package com.android.server.display;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ParceledListSlice;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.AmbientBrightnessDayStats;
import android.hardware.display.BrightnessChangeEvent;
import android.hardware.display.ColorDisplayManager;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.display.DisplayedContentSample;
import android.hardware.display.DisplayedContentSamplingAttributes;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserManager;
import android.provider.Settings;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import android.view.Display;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.RingBuffer;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.am.ProcessList;
import com.android.server.display.utils.DebugUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessTracker {
    private static final String AMBIENT_BRIGHTNESS_STATS_FILE = "ambient_brightness_stats.xml";
    private static final String ATTR_BATTERY_LEVEL = "batteryLevel";
    private static final String ATTR_COLOR_SAMPLE_DURATION = "colorSampleDuration";
    private static final String ATTR_COLOR_TEMPERATURE = "colorTemperature";
    private static final String ATTR_COLOR_VALUE_BUCKETS = "colorValueBuckets";
    private static final String ATTR_DEFAULT_CONFIG = "defaultConfig";
    private static final String ATTR_LAST_NITS = "lastNits";
    private static final String ATTR_LUX = "lux";
    private static final String ATTR_LUX_TIMESTAMPS = "luxTimestamps";
    private static final String ATTR_NIGHT_MODE = "nightMode";
    private static final String ATTR_NITS = "nits";
    private static final String ATTR_PACKAGE_NAME = "packageName";
    private static final String ATTR_POWER_SAVE = "powerSaveFactor";
    private static final String ATTR_REDUCE_BRIGHT_COLORS = "reduceBrightColors";
    private static final String ATTR_REDUCE_BRIGHT_COLORS_OFFSET = "reduceBrightColorsOffset";
    private static final String ATTR_REDUCE_BRIGHT_COLORS_STRENGTH = "reduceBrightColorsStrength";
    private static final String ATTR_TIMESTAMP = "timestamp";
    private static final String ATTR_UNIQUE_DISPLAY_ID = "uniqueDisplayId";
    private static final String ATTR_USER = "user";
    private static final String ATTR_USER_POINT = "userPoint";
    private static final int COLOR_SAMPLE_COMPONENT_MASK = 4;
    private static final long COLOR_SAMPLE_DURATION = 0;
    static final boolean DEBUG = false;
    private static final String EVENTS_FILE = "brightness_events.xml";
    private static final SimpleDateFormat FORMAT = null;
    private static final int MAX_EVENTS = 100;
    private static final long MAX_EVENT_AGE = 0;
    private static final int MSG_BACKGROUND_START = 0;
    private static final int MSG_BRIGHTNESS_CHANGED = 1;
    private static final int MSG_SENSOR_CHANGED = 5;
    private static final int MSG_SHOULD_COLLECT_COLOR_SAMPLE_CHANGED = 4;
    private static final int MSG_START_DISPLAY_LISTENER = 6;
    private static final int MSG_START_SENSOR_LISTENER = 3;
    private static final int MSG_STOP_DISPLAY_LISTENER = 7;
    private static final int MSG_STOP_SENSOR_LISTENER = 2;
    static final String TAG = "BrightnessTracker";
    private static final String TAG_EVENT = "event";
    private static final String TAG_EVENTS = "events";
    private AmbientBrightnessStatsTracker mAmbientBrightnessStatsTracker;
    private final Handler mBgHandler;
    private BroadcastReceiver mBroadcastReceiver;
    private boolean mColorSamplingEnabled;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private int mCurrentUserId;
    private final Object mDataCollectionLock;
    private final DisplayListener mDisplayListener;
    private boolean mDisplayListenerRegistered;
    private RingBuffer<BrightnessChangeEvent> mEvents;
    private boolean mEventsDirty;
    private final Object mEventsLock;
    private float mFrameRate;
    private final Injector mInjector;
    private boolean mIsDisplayActive;
    private float mLastBatteryLevel;
    private float mLastBrightness;
    private Sensor mLightSensor;
    private int mNoFramesToSample;
    private SensorListener mSensorListener;
    private boolean mSensorRegistered;
    private SettingsObserver mSettingsObserver;
    private boolean mShouldCollectColorSample;
    private boolean mStarted;
    private final UserManager mUserManager;
    private volatile boolean mWriteBrightnessTrackerStateScheduled;

    private static class BrightnessChangeValues {
        public final float brightness;
        public final boolean isDefaultBrightnessConfig;
        public final long[] luxTimestamps;
        public final float[] luxValues;
        public final float powerBrightnessFactor;
        public final long timestamp;
        public final String uniqueDisplayId;
        public final boolean wasShortTermModelActive;

        BrightnessChangeValues(float brightness, float powerBrightnessFactor, boolean wasShortTermModelActive, boolean isDefaultBrightnessConfig, long timestamp, String uniqueDisplayId, float[] luxValues, long[] luxTimestamps) {
            this.brightness = brightness;
            this.powerBrightnessFactor = powerBrightnessFactor;
            this.wasShortTermModelActive = wasShortTermModelActive;
            this.isDefaultBrightnessConfig = isDefaultBrightnessConfig;
            this.timestamp = timestamp;
            this.uniqueDisplayId = uniqueDisplayId;
            this.luxValues = luxValues;
            this.luxTimestamps = luxTimestamps;
        }
    }

    private final class DisplayListener implements DisplayManager.DisplayListener {
        final /* synthetic */ BrightnessTracker this$0;

        /* synthetic */ DisplayListener(BrightnessTracker r1, BrightnessTrackerIA r2) {
            this(r1);
        }

        private DisplayListener(BrightnessTracker r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            if (displayId != 0) goto L10;
            BrightnessTracker.m3606$$Nest$mupdateColorSampling(this.this$0);
            boolean isDisplayActive = BrightnessTracker.m3599$$Nest$misDisplayActive(this.this$0);
            if (BrightnessTracker.m3589$$Nest$fgetmIsDisplayActive(this.this$0) == isDisplayActive) goto L11;
            BrightnessTracker.m3591$$Nest$fputmIsDisplayActive(this.this$0, isDisplayActive);
            if (isDisplayActive == false) goto L8;
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).obtainMessage(3).sendToTarget();
            return;
        L8:
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).obtainMessage(2).sendToTarget();
            return;
        L11:
            return;
        }
    }

    static class Injector {
        Injector() {
        }

        public void registerSensorListener(Context context, SensorEventListener sensorListener, Sensor lightSensor, Handler handler) {
            SensorManager sensorManager = (SensorManager) context.getSystemService(SensorManager.class);
            sensorManager.registerListener(sensorListener, lightSensor, 3, handler);
        }

        public void unregisterSensorListener(Context context, SensorEventListener sensorListener) {
            SensorManager sensorManager = (SensorManager) context.getSystemService(SensorManager.class);
            sensorManager.unregisterListener(sensorListener);
        }

        public void registerBrightnessModeObserver(ContentResolver resolver, ContentObserver settingsObserver) {
            resolver.registerContentObserver(Settings.System.getUriFor("screen_brightness_mode"), false, settingsObserver, -1);
        }

        public void unregisterBrightnessModeObserver(Context context, ContentObserver settingsObserver) {
            context.getContentResolver().unregisterContentObserver(settingsObserver);
        }

        public void registerReceiver(Context context, BroadcastReceiver receiver, IntentFilter filter) {
            context.registerReceiver(receiver, filter, 2);
        }

        public void unregisterReceiver(Context context, BroadcastReceiver receiver) {
            context.unregisterReceiver(receiver);
        }

        public Handler getBackgroundHandler() {
            return BackgroundThread.getHandler();
        }

        public boolean isBrightnessModeAutomatic(ContentResolver resolver) {
            if (Settings.System.getIntForUser(resolver, "screen_brightness_mode", 0, -2) == 1) goto L5;
            return false;
        L5:
            return true;
        }

        public int getSecureIntForUser(ContentResolver resolver, String setting, int defaultValue, int userId) {
            return Settings.Secure.getIntForUser(resolver, setting, defaultValue, userId);
        }

        public AtomicFile getFile(String filename) {
            return new AtomicFile(new File(Environment.getDataSystemDirectory(), filename));
        }

        public AtomicFile getLegacyFile(String filename) {
            return new AtomicFile(new File(Environment.getDataSystemDeDirectory(), filename));
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }

        public long elapsedRealtimeNanos() {
            return SystemClock.elapsedRealtimeNanos();
        }

        public int getUserSerialNumber(UserManager userManager, int userId) {
            return userManager.getUserSerialNumber(userId);
        }

        public int getUserId(UserManager userManager, int userSerialNumber) {
            return userManager.getUserHandle(userSerialNumber);
        }

        public int[] getProfileIds(UserManager userManager, int userId) {
            if (userManager == null) goto L6;
            return userManager.getProfileIds(userId, false);
        L6:
            return new int[]{userId};
        }

        public ActivityTaskManager.RootTaskInfo getFocusedStack() throws RemoteException {
            if (UserManager.isVisibleBackgroundUsersEnabled() == false) goto L7;
            return ActivityTaskManager.getService().getRootTaskInfoOnDisplay(1, 0, 0);
        L7:
            return ActivityTaskManager.getService().getFocusedRootTaskInfo();
        }

        public void scheduleIdleJob(Context context) {
            BrightnessIdleJob.scheduleJob(context);
        }

        public void cancelIdleJob(Context context) {
            BrightnessIdleJob.cancelJob(context);
        }

        public boolean isInteractive(Context context) {
            return ((PowerManager) context.getSystemService(PowerManager.class)).isInteractive();
        }

        public int getDisplayState(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
            Display display = displayManager.getDisplay(0);
            return display.getState();
        }

        public int getNightDisplayColorTemperature(Context context) {
            return ((ColorDisplayManager) context.getSystemService(ColorDisplayManager.class)).getNightDisplayColorTemperature();
        }

        public boolean isNightDisplayActivated(Context context) {
            return ((ColorDisplayManager) context.getSystemService(ColorDisplayManager.class)).isNightDisplayActivated();
        }

        public int getReduceBrightColorsStrength(Context context) {
            return ((ColorDisplayManager) context.getSystemService(ColorDisplayManager.class)).getReduceBrightColorsStrength();
        }

        public float getReduceBrightColorsOffsetFactor(Context context) {
            return ((ColorDisplayManager) context.getSystemService(ColorDisplayManager.class)).getReduceBrightColorsOffsetFactor();
        }

        public boolean isReduceBrightColorsActivated(Context context) {
            return ((ColorDisplayManager) context.getSystemService(ColorDisplayManager.class)).isReduceBrightColorsActivated();
        }

        public DisplayedContentSample sampleColor(int noFramesToSample) {
            DisplayManagerInternal displayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
            return displayManagerInternal.getDisplayedContentSample(0, noFramesToSample, 0);
        }

        public float getFrameRate(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
            Display display = displayManager.getDisplay(0);
            return display.getRefreshRate();
        }

        public DisplayedContentSamplingAttributes getSamplingAttributes() {
            DisplayManagerInternal displayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
            return displayManagerInternal.getDisplayedContentSamplingAttributes(0);
        }

        public boolean enableColorSampling(boolean enable, int noFrames) {
            DisplayManagerInternal displayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
            return displayManagerInternal.setDisplayedContentSamplingEnabled(0, enable, 4, noFrames);
        }

        public void registerDisplayListener(Context context, DisplayManager.DisplayListener listener, Handler handler) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
            displayManager.registerDisplayListener(listener, handler);
        }

        public void unregisterDisplayListener(Context context, DisplayManager.DisplayListener listener) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
            displayManager.unregisterDisplayListener(listener);
        }
    }

    private final class Receiver extends BroadcastReceiver {
        final /* synthetic */ BrightnessTracker this$0;

        /* synthetic */ Receiver(BrightnessTracker r1, BrightnessTrackerIA r2) {
            this(r1);
        }

        private Receiver(BrightnessTracker r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (BrightnessTracker.DEBUG == false) goto L5;
            Slog.d(BrightnessTracker.TAG, "Received " + intent.getAction());
        L5:
            String action = intent.getAction();
            if ("android.intent.action.ACTION_SHUTDOWN".equals(action) == false) goto L9;
            this.this$0.stop();
            BrightnessTracker.m3601$$Nest$mscheduleWriteBrightnessTrackerState(this.this$0);
            return;
        L9:
            if ("android.intent.action.BATTERY_CHANGED".equals(action) == false) goto L16;
            int level = intent.getIntExtra("level", -1);
            int scale = intent.getIntExtra("scale", 0);
            if (level == (-1)) goto L26;
            if (scale == 0) goto L27;
            BrightnessTracker.m3594$$Nest$mbatteryLevelChanged(this.this$0, level, scale);
            return;
        L27:
            return;
        L26:
            return;
        L16:
            if ("android.intent.action.SCREEN_OFF".equals(action) == false) goto L19;
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).sendEmptyMessage(7);
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).obtainMessage(2).sendToTarget();
            return;
        L19:
            if ("android.intent.action.SCREEN_ON".equals(action) == false) goto L24;
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).sendEmptyMessage(6);
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).obtainMessage(3).sendToTarget();
            return;
        }
    }

    private final class SensorListener implements SensorEventListener {
        final /* synthetic */ BrightnessTracker this$0;

        /* synthetic */ SensorListener(BrightnessTracker r1, BrightnessTrackerIA r2) {
            this(r1);
        }

        private SensorListener(BrightnessTracker r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            BrightnessTracker.m3600$$Nest$mrecordAmbientBrightnessStats(this.this$0, event);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ BrightnessTracker this$0;

        public SettingsObserver(BrightnessTracker r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (BrightnessTracker.DEBUG == false) goto L6;
            Slog.v(BrightnessTracker.TAG, "settings change " + uri);
        L6:
            if (BrightnessTracker.m3588$$Nest$fgetmInjector(this.this$0).isBrightnessModeAutomatic(BrightnessTracker.m3587$$Nest$fgetmContentResolver(this.this$0)) == false) goto L8;
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).sendEmptyMessage(6);
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).obtainMessage(3).sendToTarget();
            return;
        L8:
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).sendEmptyMessage(7);
            BrightnessTracker.m3585$$Nest$fgetmBgHandler(this.this$0).obtainMessage(2).sendToTarget();
        }
    }

    private final class TrackerHandler extends Handler {
        final /* synthetic */ BrightnessTracker this$0;

        public TrackerHandler(BrightnessTracker r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L25;
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L37;
            };
        L5:
            BrightnessTracker.m3604$$Nest$mstopDisplayListener(this.this$0);
            return;
        L6:
            BrightnessTracker.m3602$$Nest$mstartDisplayListener(this.this$0);
            return;
        L7:
            BrightnessTracker.m3598$$Nest$mhandleSensorChanged(this.this$0, (Sensor) msg.obj);
            return;
        L8:
            BrightnessTracker.m3592$$Nest$fputmShouldCollectColorSample(this.this$0, ((Boolean) msg.obj).booleanValue());
            if (BrightnessTracker.m3590$$Nest$fgetmShouldCollectColorSample(this.this$0) == false) goto L14;
            if (BrightnessTracker.m3586$$Nest$fgetmColorSamplingEnabled(this.this$0) == true) goto L14;
            BrightnessTracker.m3596$$Nest$menableColorSampling(this.this$0);
            return;
        L14:
            if (BrightnessTracker.m3590$$Nest$fgetmShouldCollectColorSample(this.this$0) == false) goto L16;
            return;
        L16:
            if (BrightnessTracker.m3586$$Nest$fgetmColorSamplingEnabled(this.this$0) == false) goto L32;
            BrightnessTracker.m3595$$Nest$mdisableColorSampling(this.this$0);
            return;
        L32:
            return;
        L18:
            BrightnessTracker.m3603$$Nest$mstartSensorListener(this.this$0);
            BrightnessTracker.m3596$$Nest$menableColorSampling(this.this$0);
            return;
        L19:
            BrightnessTracker.m3605$$Nest$mstopSensorListener(this.this$0);
            BrightnessTracker.m3595$$Nest$mdisableColorSampling(this.this$0);
            return;
        L20:
            BrightnessChangeValues values = (BrightnessChangeValues) msg.obj;
            boolean r2 = true;
            if (msg.arg1 == 1) goto L24;
            r2 = false;
        L24:
            boolean userInitiatedChange = r2;
            BrightnessTracker.m3597$$Nest$mhandleBrightnessChanged(this.this$0, values.brightness, userInitiatedChange, values.powerBrightnessFactor, values.wasShortTermModelActive, values.isDefaultBrightnessConfig, values.timestamp, values.uniqueDisplayId, values.luxValues, values.luxTimestamps);
            return;
        L25:
            BrightnessTracker.m3593$$Nest$mbackgroundStart(this.this$0, ((Float) msg.obj).floatValue());
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$43XkalOx5nm_XE09aY0KSxl38R8(BrightnessTracker r0, PrintWriter r1) {
        r0.lambda$dump$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$InYCBTM8pgQh_LCGYGVPfpIQCOo(BrightnessTracker r0) {
        r0.lambda$scheduleWriteBrightnessTrackerState$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBgHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3585$$Nest$fgetmBgHandler(BrightnessTracker r0) {
        return r0.mBgHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmColorSamplingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3586$$Nest$fgetmColorSamplingEnabled(BrightnessTracker r0) {
        return r0.mColorSamplingEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContentResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentResolver m3587$$Nest$fgetmContentResolver(BrightnessTracker r0) {
        return r0.mContentResolver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m3588$$Nest$fgetmInjector(BrightnessTracker r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsDisplayActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3589$$Nest$fgetmIsDisplayActive(BrightnessTracker r0) {
        return r0.mIsDisplayActive;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShouldCollectColorSample, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3590$$Nest$fgetmShouldCollectColorSample(BrightnessTracker r0) {
        return r0.mShouldCollectColorSample;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsDisplayActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3591$$Nest$fputmIsDisplayActive(BrightnessTracker r0, boolean r1) {
        r0.mIsDisplayActive = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmShouldCollectColorSample, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3592$$Nest$fputmShouldCollectColorSample(BrightnessTracker r0, boolean r1) {
        r0.mShouldCollectColorSample = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mbackgroundStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3593$$Nest$mbackgroundStart(BrightnessTracker r0, float r1) {
        r0.backgroundStart(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mbatteryLevelChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3594$$Nest$mbatteryLevelChanged(BrightnessTracker r0, int r1, int r2) {
        r0.batteryLevelChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdisableColorSampling, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3595$$Nest$mdisableColorSampling(BrightnessTracker r0) {
        r0.disableColorSampling();
    }

    /* JADX INFO: renamed from: -$$Nest$menableColorSampling, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3596$$Nest$menableColorSampling(BrightnessTracker r0) {
        r0.enableColorSampling();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBrightnessChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3597$$Nest$mhandleBrightnessChanged(BrightnessTracker r0, float r1, boolean r2, float r3, boolean r4, boolean r5, long r6, String r8, float[] r9, long[] r10) {
        r0.handleBrightnessChanged(r1, r2, r3, r4, r5, r6, r8, r9, r10);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSensorChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3598$$Nest$mhandleSensorChanged(BrightnessTracker r0, Sensor r1) {
        r0.handleSensorChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misDisplayActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3599$$Nest$misDisplayActive(BrightnessTracker r0) {
        return r0.isDisplayActive();
    }

    /* JADX INFO: renamed from: -$$Nest$mrecordAmbientBrightnessStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3600$$Nest$mrecordAmbientBrightnessStats(BrightnessTracker r0, SensorEvent r1) {
        r0.recordAmbientBrightnessStats(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleWriteBrightnessTrackerState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3601$$Nest$mscheduleWriteBrightnessTrackerState(BrightnessTracker r0) {
        r0.scheduleWriteBrightnessTrackerState();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartDisplayListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3602$$Nest$mstartDisplayListener(BrightnessTracker r0) {
        r0.startDisplayListener();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartSensorListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3603$$Nest$mstartSensorListener(BrightnessTracker r0) {
        r0.startSensorListener();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopDisplayListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3604$$Nest$mstopDisplayListener(BrightnessTracker r0) {
        r0.stopDisplayListener();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopSensorListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3605$$Nest$mstopSensorListener(BrightnessTracker r0) {
        r0.stopSensorListener();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateColorSampling, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3606$$Nest$mupdateColorSampling(BrightnessTracker r0) {
        r0.updateColorSampling();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
        MAX_EVENT_AGE = TimeUnit.DAYS.toMillis(30);
        FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        COLOR_SAMPLE_DURATION = TimeUnit.SECONDS.toSeconds(10);
    }

    public BrightnessTracker(Context context, Injector injector) {
        this.mEventsLock = new Object();
        this.mEvents = new RingBuffer(BrightnessChangeEvent.class, 100);
        this.mDisplayListener = new DisplayListener(this, null);
        this.mShouldCollectColorSample = false;
        this.mCurrentUserId = ProcessList.INVALID_ADJ;
        this.mDataCollectionLock = new Object();
        this.mLastBatteryLevel = Float.NaN;
        this.mLastBrightness = -1.0f;
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
        if (injector == null) goto L5;
        this.mInjector = injector;
    L6:
        this.mBgHandler = new TrackerHandler(this, this.mInjector.getBackgroundHandler().getLooper());
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        return;
    L5:
        this.mInjector = new Injector();
        goto L6
    }

    public void start(float initialBrightness) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Start");
    L5:
        this.mCurrentUserId = ActivityManager.getCurrentUser();
        this.mBgHandler.obtainMessage(0, Float.valueOf(initialBrightness)).sendToTarget();
    }

    public void setShouldCollectColorSample(boolean shouldCollectColorSample) {
        this.mBgHandler.obtainMessage(4, Boolean.valueOf(shouldCollectColorSample)).sendToTarget();
    }

    private void backgroundStart(float initialBrightness) {
        Object r0 = this.mDataCollectionLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "Background start");
    L14:
        readEvents();
        readAmbientBrightnessStats();
        BrightnessTrackerIA r1 = null;
        this.mSensorListener = new SensorListener(this, r1);
        this.mSettingsObserver = new SettingsObserver(this, this.mBgHandler);
        this.mInjector.registerBrightnessModeObserver(this.mContentResolver, this.mSettingsObserver);
        startDisplayListener();
        this.mIsDisplayActive = isDisplayActive();
        startSensorListener();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.mBroadcastReceiver = new Receiver(this, r1);
        this.mInjector.registerReceiver(this.mContext, this.mBroadcastReceiver, intentFilter);
        this.mInjector.scheduleIdleJob(this.mContext);
        Object r2 = this.mDataCollectionLock;
        monitor-enter(r2);
        this.mLastBrightness = initialBrightness;     // Catch: Throwable -> L20
        this.mStarted = true;     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        enableColorSampling();
        return;
    L20:
        th = move-exception;
        throw th;
    }

    void stop() {
        Object r0 = this.mDataCollectionLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "Stop");
    L14:
        this.mBgHandler.removeMessages(0);
        stopDisplayListener();
        stopSensorListener();
        this.mInjector.unregisterSensorListener(this.mContext, this.mSensorListener);
        this.mInjector.unregisterBrightnessModeObserver(this.mContext, this.mSettingsObserver);
        this.mInjector.unregisterReceiver(this.mContext, this.mBroadcastReceiver);
        this.mInjector.cancelIdleJob(this.mContext);
        Object r2 = this.mDataCollectionLock;
        monitor-enter(r2);
        this.mStarted = false;     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        disableColorSampling();
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void onSwitchUser(int newUserId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Used id updated from " + this.mCurrentUserId + " to " + newUserId);
    L5:
        this.mCurrentUserId = newUserId;
    }

    public ParceledListSlice<BrightnessChangeEvent> getEvents(int userId, boolean includePackage) {
        Object r0 = this.mEventsLock;
        monitor-enter(r0);
        BrightnessChangeEvent[] events = (BrightnessChangeEvent[]) this.mEvents.toArray();     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        int[] profiles = this.mInjector.getProfileIds(this.mUserManager, userId);
        Map<Integer, Boolean> toRedact = new HashMap();
        int i = 0;
    L7:
        boolean redact = true;
        if (i >= profiles.length) goto L15;
        int profileId = profiles[i];
        if (includePackage == false) goto L14;
        if (profileId != userId) goto L14;
        redact = false;
    L14:
        toRedact.put(Integer.valueOf(profiles[i]), Boolean.valueOf(redact));
        i = i + 1;
        goto L7
    L15:
        ArrayList<BrightnessChangeEvent> out = new ArrayList(events.length);
        int i2 = 0;
    L17:
        if (i2 >= events.length) goto L26;
        Boolean redact2 = toRedact.get(Integer.valueOf(events[i2].userId));
        if (redact2 == null) goto L24;
        if (redact2.booleanValue() == true) goto L23;
        out.add(events[i2]);
        goto L24
    L23:
        BrightnessChangeEvent event = new BrightnessChangeEvent(events[i2], true);
        out.add(event);
    L24:
        i2 = i2 + 1;
        goto L17
    L26:
        return new ParceledListSlice(out);
    L27:
        th = move-exception;
        throw th;
    }

    public void persistBrightnessTrackerState() {
        scheduleWriteBrightnessTrackerState();
    }

    public void notifyBrightnessChanged(float r12, boolean r13, float r14, boolean r15, boolean r16, String r17, float[] r18, long[] r19) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, String.format("notifyBrightnessChanged(brightness=%f, userInitiated=%b)", new Object[]{Float.valueOf(r12), Boolean.valueOf(r13)}));
    L5:
        Handler r0 = this.mBgHandler;
        BrightnessChangeValues r1 = new BrightnessChangeValues(r12, r14, r15, r16, this.mInjector.currentTimeMillis(), r17, r18, r19);
        r0.obtainMessage(1, r13 ? 1 : 0, 0, r1).sendToTarget();
    }

    public void setLightSensor(Sensor lightSensor) {
        this.mBgHandler.obtainMessage(5, 0, 0, lightSensor).sendToTarget();
    }

    private void handleBrightnessChanged(float brightness, boolean userInitiated, float powerBrightnessFactor, boolean wasShortTermModelActive, boolean isDefaultBrightnessConfig, long timestamp, String uniqueDisplayId, float[] luxValues, long[] luxTimestamps) {
        long[] r4 = luxTimestamps;
        Object r5 = this.mDataCollectionLock;
        monitor-enter(r5);
    L8:
        e = th;
    L80:
        monitor-exit(r5);     // Catch: Throwable -> L38
        throw e;
    L5:
        if (this.mStarted == true) goto L14;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L14:
        float previousBrightness = this.mLastBrightness;     // Catch: Throwable -> L8
        this.mLastBrightness = brightness;     // Catch: Throwable -> L8
        if (userInitiated == true) goto L18;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L18:
        BrightnessChangeEvent.Builder builder = new BrightnessChangeEvent.Builder();     // Catch: Throwable -> L8
        builder.setBrightness(brightness);     // Catch: Throwable -> L8
        builder.setTimeStamp(timestamp);     // Catch: Throwable -> L8
        builder.setPowerBrightnessFactor(powerBrightnessFactor);     // Catch: Throwable -> L78
        builder.setUserBrightnessPoint(wasShortTermModelActive);     // Catch: Throwable -> L76
        builder.setIsDefaultBrightnessConfig(isDefaultBrightnessConfig);     // Catch: Throwable -> L74
        builder.setUniqueDisplayId(uniqueDisplayId);     // Catch: Throwable -> L30
        if (luxValues.length != 0) goto L32;
        monitor-exit(r5);     // Catch: Throwable -> L30
        return;
    L32:
        long[] luxTimestampsMillis = new long[r4.length];     // Catch: Throwable -> L30
        long currentTimeMillis = this.mInjector.currentTimeMillis();     // Catch: Throwable -> L30
        long elapsedTimeNanos = this.mInjector.elapsedRealtimeNanos();     // Catch: Throwable -> L30
        int i = 0;
    L34:
        if (i >= r4.length) goto L40;
        Object r8 = r5;
        long elapsedTimeNanos2 = elapsedTimeNanos;
        luxTimestampsMillis[i] = currentTimeMillis - (TimeUnit.NANOSECONDS.toMillis(elapsedTimeNanos2) - luxTimestamps[i]);     // Catch: Throwable -> L38
        i = i + 1;     // Catch: Throwable -> L38
        elapsedTimeNanos = elapsedTimeNanos2;
        r5 = r8;
        r4 = luxTimestamps;
        goto L34
    L40:
        Object r9 = r5;
        builder.setLuxValues(luxValues);     // Catch: Throwable -> L38
        builder.setLuxTimestamps(luxTimestampsMillis);     // Catch: Throwable -> L38
        builder.setBatteryLevel(this.mLastBatteryLevel);     // Catch: Throwable -> L38
        builder.setLastBrightness(previousBrightness);     // Catch: Throwable -> L38
        monitor-exit(r9);     // Catch: Throwable -> L38
        ActivityTaskManager.RootTaskInfo focusedTask = this.mInjector.getFocusedStack();     // Catch: RemoteException -> L66
        if (focusedTask == null) goto L69;
        if (focusedTask.topActivity == null) goto L69;
        builder.setUserId(focusedTask.userId);     // Catch: RemoteException -> L66
        builder.setPackageName(focusedTask.topActivity.getPackageName());     // Catch: RemoteException -> L66
        builder.setNightMode(this.mInjector.isNightDisplayActivated(this.mContext));
        builder.setColorTemperature(this.mInjector.getNightDisplayColorTemperature(this.mContext));
        builder.setReduceBrightColors(this.mInjector.isReduceBrightColorsActivated(this.mContext));
        builder.setReduceBrightColorsStrength(this.mInjector.getReduceBrightColorsStrength(this.mContext));
        builder.setReduceBrightColorsOffset(this.mInjector.getReduceBrightColorsOffsetFactor(this.mContext) * brightness);
        if (this.mColorSamplingEnabled == false) goto L54;
        DisplayedContentSample sample = this.mInjector.sampleColor(this.mNoFramesToSample);
        if (sample == null) goto L54;
        if (sample.getSampleComponent(DisplayedContentSample.ColorComponent.CHANNEL2) == null) goto L54;
        float numMillis = (sample.getNumFrames() / this.mFrameRate) * 1000.0f;
        builder.setColorValues(sample.getSampleComponent(DisplayedContentSample.ColorComponent.CHANNEL2), Math.round(numMillis));
    L54:
        BrightnessChangeEvent event = builder.build();
        if (DEBUG == false) goto L57;
        Slog.d(TAG, "Event: " + event.toString());
    L57:
        Object r6 = this.mEventsLock;
        monitor-enter(r6);
        this.mEventsDirty = true;     // Catch: Throwable -> L63
        this.mEvents.append(event);     // Catch: Throwable -> L63
        monitor-exit(r6);     // Catch: Throwable -> L63
        return;
    L63:
        th = move-exception;
        throw th;
    L69:
        if (DEBUG == false) goto L95;
        Slog.d(TAG, "Ignoring event due to null focusedTask.");     // Catch: RemoteException -> L66
        return;
    L95:
        return;
    L73:
        return;
    L30:
        e = th;
    L74:
        e = th;
    L76:
        e = th;
    L78:
        e = th;
    L38:
        e = th;
        goto L80
    }

    private void handleSensorChanged(Sensor lightSensor) {
        if (this.mLightSensor == lightSensor) goto L10;
        this.mLightSensor = lightSensor;
        if (lightSensor == null) goto L7;
        this.mBgHandler.sendEmptyMessage(6);
    L8:
        stopSensorListener();
        startSensorListener();
        return;
    L7:
        this.mBgHandler.sendEmptyMessage(7);
        goto L8
    }

    private void startSensorListener() {
        if (this.mSensorRegistered == false) goto L5;
        return;
    L5:
        if (this.mLightSensor != null) goto L7;
        return;
    L7:
        if (this.mAmbientBrightnessStatsTracker != null) goto L9;
        return;
    L9:
        if (this.mInjector.isInteractive(this.mContext) == true) goto L11;
        return;
    L11:
        if (this.mIsDisplayActive == true) goto L13;
        return;
    L13:
        if (this.mInjector.isBrightnessModeAutomatic(this.mContentResolver) == false) goto L21;
        this.mAmbientBrightnessStatsTracker.start();
        this.mSensorRegistered = true;
        this.mInjector.registerSensorListener(this.mContext, this.mSensorListener, this.mLightSensor, this.mInjector.getBackgroundHandler());
        return;
    }

    private void stopSensorListener() {
        if (this.mSensorRegistered == false) goto L6;
        this.mAmbientBrightnessStatsTracker.stop();
        this.mInjector.unregisterSensorListener(this.mContext, this.mSensorListener);
        this.mSensorRegistered = false;
        return;
    }

    private void scheduleWriteBrightnessTrackerState() {
        if (this.mWriteBrightnessTrackerStateScheduled == true) goto L6;
        this.mBgHandler.post(new BrightnessTracker$$ExternalSyntheticLambda1(this));
        this.mWriteBrightnessTrackerStateScheduled = true;
        return;
    }

    private /* synthetic */ void lambda$scheduleWriteBrightnessTrackerState$0() {
        this.mWriteBrightnessTrackerStateScheduled = false;
        writeEvents();
        writeAmbientBrightnessStats();
    }

    private void writeEvents() {
        Object r0 = this.mEventsLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEventsDirty == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        AtomicFile writeTo = this.mInjector.getFile(EVENTS_FILE);     // Catch: Throwable -> L8
        if (writeTo != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        if (this.mEvents.isEmpty() == true) goto L17;
        FileOutputStream output = null;
        output = writeTo.startWrite();     // Catch: Throwable -> L8 IOException -> L24
        writeEventsLocked(output);     // Catch: Throwable -> L8 IOException -> L24
        writeTo.finishWrite(output);     // Catch: Throwable -> L8 IOException -> L24
        this.mEventsDirty = false;     // Catch: Throwable -> L8 IOException -> L24
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L24:
        e = move-exception;
        writeTo.failWrite(output);     // Catch: Throwable -> L8
        Slog.e(TAG, "Failed to write change mEvents.", e);     // Catch: Throwable -> L8
        goto L26
    L17:
        if (writeTo.exists() == false) goto L19;
        writeTo.delete();     // Catch: Throwable -> L8
    L19:
        this.mEventsDirty = false;     // Catch: Throwable -> L8
        goto L26
    }

    private void writeAmbientBrightnessStats() {
        AtomicFile writeTo = this.mInjector.getFile(AMBIENT_BRIGHTNESS_STATS_FILE);
        if (writeTo != null) goto L5;
        return;
    L5:
        FileOutputStream output = null;
        output = writeTo.startWrite();     // Catch: IOException -> L8
        this.mAmbientBrightnessStatsTracker.writeStats(output);     // Catch: IOException -> L8
        writeTo.finishWrite(output);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        writeTo.failWrite(output);
        Slog.e(TAG, "Failed to write ambient brightness stats.", e);
    }

    private AtomicFile getFileWithLegacyFallback(String filename) {
        AtomicFile file = this.mInjector.getFile(filename);
        if (file != null) goto L5;
    L12:
        return file;
    L5:
        if (file.exists() == true) goto L12;
        AtomicFile legacyFile = this.mInjector.getLegacyFile(filename);
        if (legacyFile == null) goto L12;
        if (legacyFile.exists() == false) goto L12;
        Slog.i(TAG, "Reading " + filename + " from old location");
        return legacyFile;
    }

    private void readEvents() {
        Object r0 = this.mEventsLock;
        monitor-enter(r0);
        this.mEventsDirty = true;     // Catch: Throwable -> L13
        this.mEvents.clear();     // Catch: Throwable -> L13
        AtomicFile readFrom = getFileWithLegacyFallback(EVENTS_FILE);     // Catch: Throwable -> L13
        if (readFrom != null) goto L8;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        if (readFrom.exists() == false) goto L22;
        FileInputStream input = null;
        input = readFrom.openRead();     // Catch: Throwable -> L15 IOException -> L17
        readEventsLocked(input);     // Catch: Throwable -> L15 IOException -> L17
    L11:
        IoUtils.closeQuietly(input);     // Catch: Throwable -> L13
        goto L22
    L17:
        e = move-exception;
        readFrom.delete();     // Catch: Throwable -> L15
        Slog.e(TAG, "Failed to read change mEvents.", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        IoUtils.closeQuietly(input);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void readAmbientBrightnessStats() {
        this.mAmbientBrightnessStatsTracker = new AmbientBrightnessStatsTracker(this.mUserManager, null);
        AtomicFile readFrom = getFileWithLegacyFallback(AMBIENT_BRIGHTNESS_STATS_FILE);
        if (readFrom != null) goto L5;
        return;
    L5:
        if (readFrom.exists() == false) goto L20;
        FileInputStream input = null;
        input = readFrom.openRead();     // Catch: Throwable -> L9 IOException -> L11
        this.mAmbientBrightnessStatsTracker.readStats(input);     // Catch: Throwable -> L9 IOException -> L11
    L8:
        IoUtils.closeQuietly(input);
        return;
    L11:
        e = move-exception;
        readFrom.delete();     // Catch: Throwable -> L9
        Slog.e(TAG, "Failed to read ambient brightness stats.", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        IoUtils.closeQuietly(input);
        throw th;
    }

    void writeEventsLocked(OutputStream stream) throws IOException {
        TypedXmlSerializer out = Xml.resolveSerializer(stream);
        out.startDocument(null, true);
        out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        out.startTag(null, TAG_EVENTS);
        BrightnessChangeEvent[] toWrite = (BrightnessChangeEvent[]) this.mEvents.toArray();
        this.mEvents.clear();
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Writing events " + toWrite.length);
    L5:
        long timeCutOff = this.mInjector.currentTimeMillis() - MAX_EVENT_AGE;
        int i = 0;
    L7:
        if (i >= toWrite.length) goto L35;
        int userSerialNo = this.mInjector.getUserSerialNumber(this.mUserManager, toWrite[i].userId);
        if (userSerialNo == (-1)) goto L34;
        if (toWrite[i].timeStamp <= timeCutOff) goto L34;
        this.mEvents.append(toWrite[i]);
        out.startTag(null, TAG_EVENT);
        out.attributeFloat(null, ATTR_NITS, toWrite[i].brightness);
        out.attributeLong(null, "timestamp", toWrite[i].timeStamp);
        out.attribute(null, "packageName", toWrite[i].packageName);
        out.attributeInt(null, ATTR_USER, userSerialNo);
        String uniqueDisplayId = toWrite[i].uniqueDisplayId;
        if (uniqueDisplayId != null) goto L15;
        uniqueDisplayId = "";
    L15:
        out.attribute(null, ATTR_UNIQUE_DISPLAY_ID, uniqueDisplayId);
        out.attributeFloat(null, ATTR_BATTERY_LEVEL, toWrite[i].batteryLevel);
        out.attributeBoolean(null, ATTR_NIGHT_MODE, toWrite[i].nightMode);
        out.attributeInt(null, ATTR_COLOR_TEMPERATURE, toWrite[i].colorTemperature);
        out.attributeBoolean(null, ATTR_REDUCE_BRIGHT_COLORS, toWrite[i].reduceBrightColors);
        out.attributeInt(null, ATTR_REDUCE_BRIGHT_COLORS_STRENGTH, toWrite[i].reduceBrightColorsStrength);
        out.attributeFloat(null, ATTR_REDUCE_BRIGHT_COLORS_OFFSET, toWrite[i].reduceBrightColorsOffset);
        out.attributeFloat(null, ATTR_LAST_NITS, toWrite[i].lastBrightness);
        out.attributeBoolean(null, ATTR_DEFAULT_CONFIG, toWrite[i].isDefaultBrightnessConfig);
        out.attributeFloat(null, ATTR_POWER_SAVE, toWrite[i].powerBrightnessFactor);
        out.attributeBoolean(null, ATTR_USER_POINT, toWrite[i].isUserSetBrightness);
        StringBuilder luxValues = new StringBuilder();
        StringBuilder luxTimestamps = new StringBuilder();
        int j = 0;
    L17:
        if (j >= toWrite[i].luxValues.length) goto L21;
        if (j <= 0) goto L20;
        luxValues.append(',');
        luxTimestamps.append(',');
    L20:
        luxValues.append(Float.toString(toWrite[i].luxValues[j]));
        luxTimestamps.append(Long.toString(toWrite[i].luxTimestamps[j]));
        j = j + 1;
        goto L17
    L21:
        out.attribute(null, ATTR_LUX, luxValues.toString());
        out.attribute(null, ATTR_LUX_TIMESTAMPS, luxTimestamps.toString());
        if (toWrite[i].colorValueBuckets != null) goto L24;
    L33:
        out.endTag(null, TAG_EVENT);
        goto L34
    L24:
        if (toWrite[i].colorValueBuckets.length <= 0) goto L33;
        out.attributeLong(null, ATTR_COLOR_SAMPLE_DURATION, toWrite[i].colorSampleDuration);
        StringBuilder buckets = new StringBuilder();
        int j2 = 0;
    L27:
        if (j2 >= toWrite[i].colorValueBuckets.length) goto L32;
        if (j2 <= 0) goto L31;
        buckets.append(',');
    L31:
        buckets.append(Long.toString(toWrite[i].colorValueBuckets[j2]));
        j2 = j2 + 1;
        goto L27
    L32:
        out.attribute(null, ATTR_COLOR_VALUE_BUCKETS, buckets.toString());
    L34:
        i = i + 1;
        goto L7
    L35:
        out.endTag(null, TAG_EVENTS);
        out.endDocument();
        stream.flush();
    }

    void readEventsLocked(InputStream stream) throws IOException {
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L19
    L4:
        int type = parser.next();     // Catch: Throwable -> L19
        int r6 = 1;
        if (type == 1) goto L9;
        if (type != 2) goto L4;
    L9:
        String tag = parser.getName();     // Catch: Throwable -> L19
        if (TAG_EVENTS.equals(tag) == false) goto L66;
        long timeCutOff = this.mInjector.currentTimeMillis() - MAX_EVENT_AGE;     // Catch: Throwable -> L19
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L19
    L12:
        int type2 = parser.next();     // Catch: Throwable -> L19
        if (type2 == r6) goto L64;
        if (type2 == 3) goto L17;
    L21:
        if (type2 == 3) goto L61;
        if (type2 == 4) goto L61;
        String tag2 = parser.getName();     // Catch: Throwable -> L19
        if (TAG_EVENT.equals(tag2) == false) goto L58;
        BrightnessChangeEvent.Builder builder = new BrightnessChangeEvent.Builder();     // Catch: Throwable -> L19
        builder.setBrightness(parser.getAttributeFloat(null, ATTR_NITS));     // Catch: Throwable -> L19
        builder.setTimeStamp(parser.getAttributeLong(null, "timestamp"));     // Catch: Throwable -> L19
        builder.setPackageName(parser.getAttributeValue(null, "packageName"));     // Catch: Throwable -> L19
        builder.setUserId(this.mInjector.getUserId(this.mUserManager, parser.getAttributeInt(null, ATTR_USER)));     // Catch: Throwable -> L19
        String uniqueDisplayId = parser.getAttributeValue(null, ATTR_UNIQUE_DISPLAY_ID);     // Catch: Throwable -> L19
        if (uniqueDisplayId != null) goto L30;
        uniqueDisplayId = "";
    L30:
        builder.setUniqueDisplayId(uniqueDisplayId);     // Catch: Throwable -> L19
        builder.setBatteryLevel(parser.getAttributeFloat(null, ATTR_BATTERY_LEVEL));     // Catch: Throwable -> L19
        builder.setNightMode(parser.getAttributeBoolean(null, ATTR_NIGHT_MODE));     // Catch: Throwable -> L19
        builder.setColorTemperature(parser.getAttributeInt(null, ATTR_COLOR_TEMPERATURE));     // Catch: Throwable -> L19
        builder.setReduceBrightColors(parser.getAttributeBoolean(null, ATTR_REDUCE_BRIGHT_COLORS));     // Catch: Throwable -> L19
        builder.setReduceBrightColorsStrength(parser.getAttributeInt(null, ATTR_REDUCE_BRIGHT_COLORS_STRENGTH));     // Catch: Throwable -> L19
        builder.setReduceBrightColorsOffset(parser.getAttributeFloat(null, ATTR_REDUCE_BRIGHT_COLORS_OFFSET));     // Catch: Throwable -> L19
        builder.setLastBrightness(parser.getAttributeFloat(null, ATTR_LAST_NITS));     // Catch: Throwable -> L19
        String luxValue = parser.getAttributeValue(null, ATTR_LUX);     // Catch: Throwable -> L19
        String luxTimestamp = parser.getAttributeValue(null, ATTR_LUX_TIMESTAMPS);     // Catch: Throwable -> L19
        String[] luxValuesStrings = luxValue.split(",");     // Catch: Throwable -> L19
        String[] luxTimestampsStrings = luxTimestamp.split(",");     // Catch: Throwable -> L19
        String tag3 = tag2;
        if (luxValuesStrings.length == luxTimestampsStrings.length) goto L33;
        TypedXmlPullParser parser2 = parser;
        long timeCutOff2 = timeCutOff;
    L59:
        parser = parser2;
        timeCutOff = timeCutOff2;
        r6 = 1;
        goto L12
    L33:
        float[] luxValues = new float[luxValuesStrings.length];     // Catch: Throwable -> L19
        long[] luxTimestamps = new long[luxValuesStrings.length];     // Catch: Throwable -> L19
        int type3 = 0;
    L34:
        timeCutOff2 = timeCutOff;
        if (type3 >= luxValues.length) goto L37;
        luxValues[type3] = Float.parseFloat(luxValuesStrings[type3]);     // Catch: Throwable -> L19
        luxTimestamps[type3] = Long.parseLong(luxTimestampsStrings[type3]);     // Catch: Throwable -> L19
        type3 = type3 + 1;     // Catch: Throwable -> L19
        timeCutOff = timeCutOff2;
        goto L34
    L37:
        builder.setLuxValues(luxValues);     // Catch: Throwable -> L19
        builder.setLuxTimestamps(luxTimestamps);     // Catch: Throwable -> L19
        builder.setIsDefaultBrightnessConfig(parser.getAttributeBoolean(null, ATTR_DEFAULT_CONFIG, false));     // Catch: Throwable -> L19
        builder.setPowerBrightnessFactor(parser.getAttributeFloat(null, ATTR_POWER_SAVE, 1.0f));     // Catch: Throwable -> L19
        builder.setUserBrightnessPoint(parser.getAttributeBoolean(null, ATTR_USER_POINT, false));     // Catch: Throwable -> L19
        long colorSampleDuration = parser.getAttributeLong(null, ATTR_COLOR_SAMPLE_DURATION, -1);     // Catch: Throwable -> L19
        String colorValueBucketsString = parser.getAttributeValue(null, ATTR_COLOR_VALUE_BUCKETS);     // Catch: Throwable -> L19
        if (colorSampleDuration == (-1)) goto L45;
        if (colorValueBucketsString == null) goto L45;
        String[] buckets = colorValueBucketsString.split(",");     // Catch: Throwable -> L19
        long[] bucketValues = new long[buckets.length];     // Catch: Throwable -> L19
        int i = 0;
    L41:
        parser2 = parser;
        if (i >= bucketValues.length) goto L44;
        bucketValues[i] = Long.parseLong(buckets[i]);     // Catch: Throwable -> L19
        i = i + 1;     // Catch: Throwable -> L19
        parser = parser2;
        goto L41
    L44:
        long colorSampleDuration2 = colorSampleDuration;
        builder.setColorValues(bucketValues, colorSampleDuration2);     // Catch: Throwable -> L19
    L46:
        BrightnessChangeEvent event = builder.build();     // Catch: Throwable -> L19
        if (DEBUG == false) goto L51;
        Slog.i(TAG, "Read event " + event.brightness + " " + event.packageName);     // Catch: Throwable -> L19
    L51:
        if (event.userId == (-1)) goto L59;
        if (event.timeStamp <= timeCutOff2) goto L59;
        if (event.luxValues.length <= 0) goto L59;
        this.mEvents.append(event);     // Catch: Throwable -> L19
    L45:
        parser2 = parser;
        colorSampleDuration2 = colorSampleDuration;
        goto L46
    L58:
        parser2 = parser;
        tag3 = tag2;
        timeCutOff2 = timeCutOff;
    L61:
        parser = parser;
        timeCutOff = timeCutOff;
        r6 = 1;
        goto L12
    L17:
        if (parser.getDepth() > outerDepth) goto L21;
        return;
    L64:
        return;
    L66:
        throw new XmlPullParserException("Events not found in brightness tracker file " + tag);     // Catch: Throwable -> L19
    L19:
        e = move-exception;
        this.mEvents = new RingBuffer(BrightnessChangeEvent.class, 100);
        Slog.e(TAG, "Failed to parse brightness event", e);
        throw new IOException("failed to parse file", e);
    }

    public void dump(final PrintWriter pw) {
        pw.println("BrightnessTracker state:");
        pw.println("------------------------");
        Object r0 = this.mDataCollectionLock;
        monitor-enter(r0);
        pw.println("  mStarted=" + this.mStarted);     // Catch: Throwable -> L28
        pw.println("  mLightSensor=" + this.mLightSensor);     // Catch: Throwable -> L28
        pw.println("  mLastBatteryLevel=" + this.mLastBatteryLevel);     // Catch: Throwable -> L28
        pw.println("  mLastBrightness=" + this.mLastBrightness);     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        Object r1 = this.mEventsLock;
        monitor-enter(r1);
        pw.println("  mEventsDirty=" + this.mEventsDirty);     // Catch: Throwable -> L16
        pw.println("  mEvents.size=" + this.mEvents.size());     // Catch: Throwable -> L16
        BrightnessChangeEvent[] events = (BrightnessChangeEvent[]) this.mEvents.toArray();     // Catch: Throwable -> L16
        int i = 0;
    L10:
        if (i >= events.length) goto L21;
        pw.print("    " + FORMAT.format(new Date(events[i].timeStamp)));     // Catch: Throwable -> L16
        pw.print(", userId=" + events[i].userId);     // Catch: Throwable -> L16
        pw.print(", " + events[i].lastBrightness + "->" + events[i].brightness);     // Catch: Throwable -> L16
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L16
        r3.append(", isUserSetBrightness=");     // Catch: Throwable -> L16
        r3.append(events[i].isUserSetBrightness);     // Catch: Throwable -> L16
        pw.print(r3.toString());     // Catch: Throwable -> L16
        pw.print(", powerBrightnessFactor=" + events[i].powerBrightnessFactor);     // Catch: Throwable -> L16
        pw.print(", isDefaultBrightnessConfig=" + events[i].isDefaultBrightnessConfig);     // Catch: Throwable -> L16
        pw.print(", recent lux values=");     // Catch: Throwable -> L16
        pw.print(" {");     // Catch: Throwable -> L16
        int j = 0;
    L13:
        if (j >= events[i].luxValues.length) goto L19;
        if (j == 0) goto L18;
        pw.print(", ");     // Catch: Throwable -> L16
    L18:
        pw.print("(" + events[i].luxValues[j] + "," + events[i].luxTimestamps[j] + ")");     // Catch: Throwable -> L16
        j = j + 1;     // Catch: Throwable -> L16
        goto L13
    L19:
        pw.println("}");     // Catch: Throwable -> L16
        i = i + 1;     // Catch: Throwable -> L16
        goto L10
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L16
        pw.println("  mWriteBrightnessTrackerStateScheduled=" + this.mWriteBrightnessTrackerStateScheduled);
        this.mBgHandler.runWithScissors(new BrightnessTracker$$ExternalSyntheticLambda0(this, pw), 1000);
        if (this.mAmbientBrightnessStatsTracker == null) goto L39;
        pw.println();
        this.mAmbientBrightnessStatsTracker.dump(pw);
        return;
    L39:
        return;
    L16:
        th = move-exception;
        throw th;
    L28:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$dump$1(PrintWriter pw) {
        dumpLocal(pw);
    }

    private void dumpLocal(PrintWriter pw) {
        pw.println("  mSensorRegistered=" + this.mSensorRegistered);
        pw.println("  mColorSamplingEnabled=" + this.mColorSamplingEnabled);
        pw.println("  mNoFramesToSample=" + this.mNoFramesToSample);
        pw.println("  mFrameRate=" + this.mFrameRate);
        pw.println("  mIsDisplayActive=" + this.mIsDisplayActive);
        pw.println("  mDisplayListenerRegistered=" + this.mDisplayListenerRegistered);
    }

    private void enableColorSampling() {
        if (this.mInjector.isBrightnessModeAutomatic(this.mContentResolver) == true) goto L5;
        return;
    L5:
        if (this.mInjector.isInteractive(this.mContext) == true) goto L7;
        return;
    L7:
        if (this.mIsDisplayActive == true) goto L9;
        return;
    L9:
        if (this.mColorSamplingEnabled == false) goto L11;
        return;
    L11:
        if (this.mShouldCollectColorSample == false) goto L38;
        this.mFrameRate = this.mInjector.getFrameRate(this.mContext);
        if (this.mFrameRate > 0.0f) goto L17;
        Slog.wtf(TAG, "Default display has a zero or negative framerate.");
        return;
    L17:
        this.mNoFramesToSample = (int) (this.mFrameRate * COLOR_SAMPLE_DURATION);
        DisplayedContentSamplingAttributes attributes = this.mInjector.getSamplingAttributes();
        if (DEBUG == false) goto L21;
        if (attributes == null) goto L21;
        Slog.d(TAG, "Color sampling mask=0x" + Integer.toHexString(attributes.getComponentMask()) + " dataSpace=0x" + Integer.toHexString(attributes.getDataspace()) + " pixelFormat=0x" + Integer.toHexString(attributes.getPixelFormat()));
    L21:
        if (attributes != null) goto L23;
        return;
    L23:
        if (attributes.getPixelFormat() == 55) goto L25;
        return;
    L25:
        if ((attributes.getComponentMask() & 4) == 0) goto L33;
        this.mColorSamplingEnabled = this.mInjector.enableColorSampling(true, this.mNoFramesToSample);
        if (DEBUG == false) goto L34;
        Slog.i(TAG, "turning on color sampling for " + this.mNoFramesToSample + " frames, success=" + this.mColorSamplingEnabled);
        return;
    L34:
        return;
    L33:
        return;
    }

    private void disableColorSampling() {
        if (this.mColorSamplingEnabled == true) goto L5;
        return;
    L5:
        this.mInjector.enableColorSampling(false, 0);
        this.mColorSamplingEnabled = false;
        if (DEBUG == false) goto L9;
        Slog.i(TAG, "turning off color sampling");
        return;
    }

    private void updateColorSampling() {
        if (this.mColorSamplingEnabled == true) goto L5;
        return;
    L5:
        float frameRate = this.mInjector.getFrameRate(this.mContext);
        if (frameRate == this.mFrameRate) goto L9;
        disableColorSampling();
        enableColorSampling();
        return;
    }

    public ParceledListSlice<AmbientBrightnessDayStats> getAmbientBrightnessStats(int userId) {
        if (this.mAmbientBrightnessStatsTracker == null) goto L9;
        ArrayList<AmbientBrightnessDayStats> stats = this.mAmbientBrightnessStatsTracker.getUserStats(userId);
        if (stats == null) goto L9;
        return new ParceledListSlice(stats);
    L9:
        return ParceledListSlice.emptyList();
    }

    private void recordAmbientBrightnessStats(SensorEvent event) {
        this.mAmbientBrightnessStatsTracker.add(this.mCurrentUserId, event.values[0]);
    }

    private void batteryLevelChanged(int level, int scale) {
        Object r0 = this.mDataCollectionLock;
        monitor-enter(r0);
        this.mLastBatteryLevel = level / scale;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isDisplayActive() {
        return Display.isActiveState(this.mInjector.getDisplayState(this.mContext));
    }

    private void startDisplayListener() {
        if (this.mDisplayListenerRegistered == false) goto L5;
        return;
    L5:
        if (this.mLightSensor != null) goto L7;
        return;
    L7:
        if (this.mInjector.isInteractive(this.mContext) == true) goto L9;
        return;
    L9:
        if (this.mInjector.isBrightnessModeAutomatic(this.mContentResolver) == false) goto L15;
        this.mInjector.registerDisplayListener(this.mContext, this.mDisplayListener, this.mBgHandler);
        this.mDisplayListenerRegistered = true;
        return;
    }

    private void stopDisplayListener() {
        if (this.mDisplayListenerRegistered == false) goto L6;
        this.mInjector.unregisterDisplayListener(this.mContext, this.mDisplayListener);
        this.mDisplayListenerRegistered = false;
        return;
    }
}
