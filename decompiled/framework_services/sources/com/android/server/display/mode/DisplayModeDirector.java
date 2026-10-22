package com.android.server.display.mode;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.BrightnessInfo;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.fingerprint.IUdfpsRefreshRateRequestCallback;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.IThermalEventListener;
import android.os.IThermalService;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.provider.Settings;
import android.sysprop.SurfaceFlingerProperties;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.SurfaceControl;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.internal.os.BackgroundThread;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.display.DisplayDeviceConfig;
import com.android.server.display.config.IdleScreenRefreshRateTimeoutLuxThresholdPoint;
import com.android.server.display.config.RefreshRateData;
import com.android.server.display.config.SupportedModeData;
import com.android.server.display.feature.DeviceConfigParameterProvider;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.utils.AmbientFilter;
import com.android.server.display.utils.AmbientFilterFactory;
import com.android.server.display.utils.SensorUtils;
import com.android.server.sensors.SensorManagerInternal;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.IntSupplier;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayModeDirector {
    private static final int MSG_DEFAULT_PEAK_REFRESH_RATE_CHANGED = 3;
    private static final int MSG_HIGH_BRIGHTNESS_THRESHOLDS_CHANGED = 6;
    private static final int MSG_LOW_BRIGHTNESS_THRESHOLDS_CHANGED = 2;
    private static final int MSG_REFRESH_RATE_IN_HBM_HDR_CHANGED = 8;
    private static final int MSG_REFRESH_RATE_IN_HBM_SUNLIGHT_CHANGED = 7;
    private static final int MSG_REFRESH_RATE_IN_HIGH_ZONE_CHANGED = 5;
    private static final int MSG_REFRESH_RATE_IN_LOW_ZONE_CHANGED = 4;
    private static final int MSG_REFRESH_RATE_RANGE_CHANGED = 1;
    private static final int MSG_SWITCH_USER = 9;
    public static final float SYNCHRONIZED_REFRESH_RATE_TARGET = 60.0f;
    public static final float SYNCHRONIZED_REFRESH_RATE_TOLERANCE = 1.0f;
    private static final String TAG = "DisplayModeDirector";
    private boolean mAlwaysRespectAppRequest;
    private final AppRequestObserver mAppRequestObserver;
    private SparseArray<Display.Mode[]> mAppSupportedModesByDisplay;
    private BrightnessObserver mBrightnessObserver;
    private final DeviceConfigParameterProvider mConfigParameterProvider;
    private final Context mContext;
    private DisplayDeviceConfig mDefaultDisplayDeviceConfig;
    private SparseArray<Display.Mode> mDefaultModeByDisplay;
    private DesiredDisplayModeSpecsListener mDesiredDisplayModeSpecsListener;
    private final DeviceConfigDisplaySettings mDeviceConfigDisplaySettings;
    private SparseArray<DisplayDeviceConfig> mDisplayDeviceConfigByDisplay;
    private final DisplayDeviceConfigProvider mDisplayDeviceConfigProvider;
    private final DisplayManagerFlags mDisplayManagerFlags;
    private final DisplayObserver mDisplayObserver;
    private final Set<Integer> mExternalDisplaysConnected;
    private final DisplayModeDirectorHandler mHandler;
    private SparseBooleanArray mHasArrSupport;
    private final boolean mHasArrSupportFlagEnabled;
    private final HbmObserver mHbmObserver;
    private final Injector mInjector;
    private final boolean mIsBackUpSmoothDisplayAndForcePeakRefreshRateEnabled;
    private final boolean mIsDisplayResolutionRangeVotingEnabled;
    private final boolean mIsDisplaysRefreshRatesSynchronizationEnabled;
    private final boolean mIsExternalDisplayLimitModeEnabled;
    private final boolean mIsUserPreferredModeVoteEnabled;
    public final Object mLock;
    private boolean mLoggingEnabled;
    private final ModeChangeObserver mModeChangeObserver;
    private int mModeSwitchingType;
    private final ProximitySensorObserver mSensorObserver;
    private final SettingsObserver mSettingsObserver;
    private final SkinThermalStatusObserver mSkinThermalStatusObserver;
    private SparseArray<Display.Mode[]> mSupportedModesByDisplay;
    private final boolean mSupportsFrameRateOverride;
    private final SystemRequestObserver mSystemRequestObserver;
    private final UdfpsObserver mUdfpsObserver;
    private final VotesStatsReporter mVotesStatsReporter;
    private final VotesStorage mVotesStorage;

    public final class AppRequestObserver {
        private final boolean mIgnorePreferredRefreshRate;
        final /* synthetic */ DisplayModeDirector this$0;

        /* JADX INFO: renamed from: -$$Nest$mdumpLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4094$$Nest$mdumpLocked(AppRequestObserver r0, PrintWriter r1) {
            r0.dumpLocked(r1);
        }

        AppRequestObserver(DisplayModeDirector this$0, DisplayManagerFlags flags) {
            this.this$0 = this$0;
            this.mIgnorePreferredRefreshRate = flags.ignoreAppPreferredRefreshRateRequest();
        }

        public void setAppRequest(int displayId, int modeId, float requestedRefreshRate, float requestedMinRefreshRateRange, float requestedMaxRefreshRateRange) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            Display.Mode requestedMode = findModeLocked(displayId, modeId, requestedRefreshRate);     // Catch: Throwable -> L11
            boolean isExternalDisplay = this.this$0.isExternalDisplayLocked(displayId);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            Vote frameRateVote = getFrameRateVote(requestedMinRefreshRateRange, requestedMaxRefreshRateRange);
            Vote baseModeRefreshRateVote = getBaseModeVote(requestedMode, requestedRefreshRate);
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 5, frameRateVote);
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 6, baseModeRefreshRateVote);
            if (isExternalDisplay == true) goto L9;
            Vote sizeVote = getSizeVote(requestedMode);
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 7, sizeVote);
        L9:
            SysOptBridge.getFactory().getDynamicRefreshRateService().onAppPreferredRefreshRateRangeChanged(requestedRefreshRate);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private Display.Mode findModeLocked(int displayId, int modeId, float requestedRefreshRate) {
            if (modeId == 0) goto L6;
            return findAppModeByIdLocked(displayId, modeId);
        L6:
            if (requestedRefreshRate != 0.0f) goto L8;
            return null;
        L8:
            if (this.mIgnorePreferredRefreshRate == true) goto L15;
            Display.Mode mode = findDefaultModeByRefreshRateLocked(displayId, requestedRefreshRate);
            if (mode != null) goto L16;
            Slog.e(DisplayModeDirector.TAG, "Couldn't find a mode for the requestedRefreshRate: " + requestedRefreshRate + " on Display: " + displayId);
            return mode;
        L16:
            return mode;
        L15:
            return null;
        }

        private Vote getFrameRateVote(float minRefreshRate, float maxRefreshRate) {
            SurfaceControl.RefreshRateRange refreshRateRange = null;
            if (minRefreshRate > 0.0f) goto L7;
            if (maxRefreshRate > 0.0f) goto L7;
        L15:
            if (refreshRateRange != null) goto L19;
            return null;
        L19:
            return Vote.forRenderFrameRates(refreshRateRange.min, refreshRateRange.max);
        L7:
            if (maxRefreshRate <= 0.0f) goto L9;
            float max = maxRefreshRate;
        L10:
            refreshRateRange = new SurfaceControl.RefreshRateRange(minRefreshRate, max);
            if (refreshRateRange.min != 0.0f) goto L15;
            if (refreshRateRange.max != 0.0f) goto L15;
            refreshRateRange = null;
            goto L15
        L9:
            max = Float.POSITIVE_INFINITY;
            goto L10
        }

        private Vote getSizeVote(Display.Mode mode) {
            if (mode != null) goto L6;
            return null;
        L6:
            return Vote.forSize(mode.getPhysicalWidth(), mode.getPhysicalHeight());
        }

        private Vote getBaseModeVote(Display.Mode mode, float requestedRefreshRate) {
            if (mode == null) goto L9;
            if (mode.isSynthetic() == false) goto L7;
            Vote vote = Vote.forRequestedRefreshRate(mode.getRefreshRate());
            return vote;
        L7:
            Vote vote2 = Vote.forBaseModeRefreshRate(mode.getRefreshRate());
            return vote2;
        L9:
            if (requestedRefreshRate != 0.0f) goto L11;
            return null;
        L11:
            if (this.mIgnorePreferredRefreshRate == false) goto L17;
            Vote vote3 = Vote.forRequestedRefreshRate(requestedRefreshRate);
            return vote3;
        L17:
            return null;
        }

        private Display.Mode findDefaultModeByRefreshRateLocked(int displayId, float refreshRate) {
            Display.Mode[] modes = (Display.Mode[]) DisplayModeDirector.m4067$$Nest$fgetmAppSupportedModesByDisplay(this.this$0).get(displayId);
            Display.Mode defaultMode = (Display.Mode) DisplayModeDirector.m4072$$Nest$fgetmDefaultModeByDisplay(this.this$0).get(displayId);
            int i = 0;
        L4:
            if (i >= modes.length) goto L10;
            if (modes[i].matches(defaultMode.getPhysicalWidth(), defaultMode.getPhysicalHeight(), refreshRate) == true) goto L8;
            i = i + 1;
            goto L4
        L8:
            return modes[i];
        L10:
            return null;
        }

        private Display.Mode findAppModeByIdLocked(int displayId, int modeId) {
            Display.Mode[] modes = (Display.Mode[]) DisplayModeDirector.m4067$$Nest$fgetmAppSupportedModesByDisplay(this.this$0).get(displayId);
            if (modes != null) goto L5;
            return null;
        L5:
            int r2 = modes.length;
            int r3 = 0;
        L6:
            if (r3 >= r2) goto L11;
            Display.Mode mode = modes[r3];
            if (mode.getModeId() == modeId) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return mode;
        L11:
            return null;
        }

        private void dumpLocked(PrintWriter pw) {
            pw.println("  AppRequestObserver");
            pw.println("    mIgnorePreferredRefreshRate: " + this.mIgnorePreferredRefreshRate);
        }
    }

    public class BrightnessObserver implements DisplayManager.DisplayListener {
        private static final int LIGHT_SENSOR_RATE_MS = 250;
        private AmbientFilter mAmbientFilter;
        private float mAmbientLux;
        private float mBrightness;
        private final Context mContext;
        private int mDefaultDisplayState;
        private final Handler mHandler;
        private float[] mHighAmbientBrightnessThresholds;
        private float[] mHighDisplayBrightnessThresholds;
        private SparseArray<SurfaceControl.RefreshRateRange> mHighZoneRefreshRateForThermals;
        private SurfaceControl.IdleScreenRefreshRateConfig mIdleScreenRefreshRateConfig;
        private List<IdleScreenRefreshRateTimeoutLuxThresholdPoint> mIdleScreenRefreshRateTimeoutLuxThresholdPoints;
        private final Injector mInjector;
        private Sensor mLightSensor;
        private final LightSensorEventListener mLightSensorListener;
        private String mLightSensorName;
        private String mLightSensorType;
        private boolean mLoggingEnabled;
        private float[] mLowAmbientBrightnessThresholds;
        private float[] mLowDisplayBrightnessThresholds;
        private boolean mLowPowerModeEnabled;
        private SparseArray<SurfaceControl.RefreshRateRange> mLowZoneRefreshRateForThermals;
        private boolean mRefreshRateChangeable;
        private int mRefreshRateInHighZone;
        private int mRefreshRateInLowZone;
        private Sensor mRegisteredLightSensor;
        private SensorManager mSensorManager;
        private boolean mShouldObserveAmbientHighChange;
        private boolean mShouldObserveAmbientLowChange;
        private boolean mShouldObserveDisplayHighChange;
        private boolean mShouldObserveDisplayLowChange;
        private final IThermalEventListener.Stub mThermalListener;
        private boolean mThermalRegistered;
        private int mThermalStatus;
        private final boolean mVsyncLowLightBlockingVoteEnabled;
        final /* synthetic */ DisplayModeDirector this$0;

        private final class LightSensorEventListener implements SensorEventListener {
            private static final int INJECT_EVENTS_INTERVAL_MS = 250;
            private final Runnable mInjectSensorEventRunnable;
            private float mLastSensorData;
            private boolean mLoggingEnabled;
            private long mTimestamp;
            final /* synthetic */ BrightnessObserver this$1;

            /* JADX INFO: renamed from: -$$Nest$fgetmInjectSensorEventRunnable, reason: not valid java name */
            static /* bridge */ /* synthetic */ Runnable m4118$$Nest$fgetmInjectSensorEventRunnable(LightSensorEventListener r0) {
                return r0.mInjectSensorEventRunnable;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmLastSensorData, reason: not valid java name */
            static /* bridge */ /* synthetic */ float m4119$$Nest$fgetmLastSensorData(LightSensorEventListener r0) {
                return r0.mLastSensorData;
            }

            /* JADX INFO: renamed from: -$$Nest$misDifferentZone, reason: not valid java name */
            static /* bridge */ /* synthetic */ boolean m4120$$Nest$misDifferentZone(LightSensorEventListener r0, float r1, float r2, float[] r3) {
                return r0.isDifferentZone(r1, r2, r3);
            }

            /* JADX INFO: renamed from: -$$Nest$mprocessSensorData, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m4121$$Nest$mprocessSensorData(LightSensorEventListener r0, long r1) {
                r0.processSensorData(r1);
            }

            /* synthetic */ LightSensorEventListener(BrightnessObserver r1, DisplayModeDirectorIA r2) {
                this(r1);
            }

            private LightSensorEventListener(BrightnessObserver r1) {
                this.this$1 = r1;
                this.mInjectSensorEventRunnable = new AnonymousClass1(this);
            }

            public void dumpLocked(PrintWriter pw) {
                pw.println("    mLastSensorData: " + this.mLastSensorData);
                pw.println("    mTimestamp: " + formatTimestamp(this.mTimestamp));
            }

            public void setLoggingEnabled(boolean loggingEnabled) {
                if (this.mLoggingEnabled != loggingEnabled) goto L5;
                return;
            L5:
                this.mLoggingEnabled = loggingEnabled;
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent event) {
                this.mLastSensorData = event.values[0];
                if (this.mLoggingEnabled == false) goto L5;
                Slog.d(DisplayModeDirector.TAG, "On sensor changed: " + this.mLastSensorData);
            L5:
                boolean lowZoneChanged = isDifferentZone(this.mLastSensorData, BrightnessObserver.m4103$$Nest$fgetmAmbientLux(this.this$1), BrightnessObserver.m4106$$Nest$fgetmLowAmbientBrightnessThresholds(this.this$1));
                boolean highZoneChanged = isDifferentZone(this.mLastSensorData, BrightnessObserver.m4103$$Nest$fgetmAmbientLux(this.this$1), BrightnessObserver.m4105$$Nest$fgetmHighAmbientBrightnessThresholds(this.this$1));
                if (lowZoneChanged == true) goto L8;
            L9:
                if (highZoneChanged == true) goto L11;
            L15:
                long now = SystemClock.uptimeMillis();
                this.mTimestamp = System.currentTimeMillis();
                if (BrightnessObserver.m4102$$Nest$fgetmAmbientFilter(this.this$1) == null) goto L18;
                BrightnessObserver.m4102$$Nest$fgetmAmbientFilter(this.this$1).addValue(now, this.mLastSensorData);
            L18:
                BrightnessObserver.m4104$$Nest$fgetmHandler(this.this$1).removeCallbacks(this.mInjectSensorEventRunnable);
                processSensorData(now);
                if (lowZoneChanged == true) goto L21;
            L22:
                if (highZoneChanged == true) goto L24;
            L27:
                if (DisplayModeDirector.m4076$$Nest$fgetmDisplayManagerFlags(this.this$1.this$0).isIdleScreenRefreshRateTimeoutEnabled() == false) goto L30;
                BrightnessObserver.m4117$$Nest$mupdateIdleScreenRefreshRate(this.this$1, BrightnessObserver.m4103$$Nest$fgetmAmbientLux(this.this$1));
                return;
            L30:
                return;
            L24:
                if (this.mLastSensorData >= BrightnessObserver.m4103$$Nest$fgetmAmbientLux(this.this$1)) goto L27;
            L25:
                BrightnessObserver.m4104$$Nest$fgetmHandler(this.this$1).postDelayed(this.mInjectSensorEventRunnable, 250);
                goto L27
            L21:
                if (this.mLastSensorData > BrightnessObserver.m4103$$Nest$fgetmAmbientLux(this.this$1)) goto L25;
            L11:
                if (this.mLastSensorData <= BrightnessObserver.m4103$$Nest$fgetmAmbientLux(this.this$1)) goto L15;
            L13:
                if (BrightnessObserver.m4102$$Nest$fgetmAmbientFilter(this.this$1) == null) goto L15;
                BrightnessObserver.m4102$$Nest$fgetmAmbientFilter(this.this$1).clear();
                goto L15
            L8:
                if (this.mLastSensorData < BrightnessObserver.m4103$$Nest$fgetmAmbientLux(this.this$1)) goto L13;
                goto L9
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }

            public void removeCallbacks() {
                BrightnessObserver.m4104$$Nest$fgetmHandler(this.this$1).removeCallbacks(this.mInjectSensorEventRunnable);
            }

            private String formatTimestamp(long time) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
                return dateFormat.format(new Date(time));
            }

            private void processSensorData(long now) {
                if (BrightnessObserver.m4102$$Nest$fgetmAmbientFilter(this.this$1) == null) goto L5;
                BrightnessObserver.m4108$$Nest$fputmAmbientLux(this.this$1, BrightnessObserver.m4102$$Nest$fgetmAmbientFilter(this.this$1).getEstimate(now));
            L6:
                Object r0 = this.this$1.this$0.mLock;
                monitor-enter(r0);
                BrightnessObserver.m4112$$Nest$monBrightnessChangedLocked(this.this$1);     // Catch: Throwable -> L11
                monitor-exit(r0);     // Catch: Throwable -> L11
                return;
            L11:
                th = move-exception;
                throw th;
            L5:
                BrightnessObserver.m4108$$Nest$fputmAmbientLux(this.this$1, this.mLastSensorData);
                goto L6
            }

            private boolean isDifferentZone(float lux1, float lux2, float[] luxThresholds) {
                int r0 = luxThresholds.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L15;
                float boundary = luxThresholds[r2];
                if (lux1 > boundary) goto L9;
                if (lux2 <= boundary) goto L9;
                return true;
            L9:
                if (lux1 <= boundary) goto L14;
                if (lux2 > boundary) goto L14;
                return true;
            L14:
                r2 = r2 + 1;
                goto L3
            L15:
                return false;
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$8DAn56bU6WgFgsFx-a9p7-LZAcI, reason: not valid java name */
        public static /* synthetic */ float[] m4095$r8$lambda$8DAn56bU6WgFgsFxa9p7LZAcI(DisplayDeviceConfig r0) {
            return lambda$loadLowBrightnessThresholds$1(r0);
        }

        public static /* synthetic */ float[] $r8$lambda$Ay2prysMHDYMO6gnyiTQlctgcyI(BrightnessObserver r0) {
            return r0.lambda$loadLowBrightnessThresholds$2();
        }

        public static /* synthetic */ float[] $r8$lambda$ErR8h1ciNprVwDnWLJTnyyvJFow(DisplayDeviceConfig r0) {
            return lambda$onDeviceConfigHighBrightnessThresholdsChanged$13(r0);
        }

        public static /* synthetic */ float[] $r8$lambda$IKnEMBFyGRQBJ1PKPV09LlnUYcQ(BrightnessObserver r0) {
            return r0.lambda$loadLowBrightnessThresholds$0();
        }

        public static /* synthetic */ float[] $r8$lambda$NoY5RPLd_tMQ9arcQdNvKQupLRA(DisplayDeviceConfig r0) {
            return lambda$onDeviceConfigHighBrightnessThresholdsChanged$15(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$QQJ_8KNK1PlQxWszYy-c-kL2A3U, reason: not valid java name */
        public static /* synthetic */ float[] m4096$r8$lambda$QQJ_8KNK1PlQxWszYyckL2A3U(DisplayDeviceConfig r0) {
            return lambda$loadLowBrightnessThresholds$3(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$Qap_vgSsSIpOoM7GLXh-0nck6zU, reason: not valid java name */
        public static /* synthetic */ float[] m4097$r8$lambda$Qap_vgSsSIpOoM7GLXh0nck6zU(DisplayDeviceConfig r0) {
            return lambda$onDeviceConfigLowBrightnessThresholdsChanged$11(r0);
        }

        public static /* synthetic */ float[] $r8$lambda$R05hOuFMoShOgMWSJv7wolTW2T0(DisplayDeviceConfig r0) {
            return lambda$onDeviceConfigLowBrightnessThresholdsChanged$9(r0);
        }

        public static /* synthetic */ float[] $r8$lambda$TN6bCtO3Mq3QS43W5huCcmcyJ1w(BrightnessObserver r0) {
            return r0.lambda$onDeviceConfigHighBrightnessThresholdsChanged$14();
        }

        /* JADX INFO: renamed from: $r8$lambda$TOfl-cGYXuStF3el4JR8AneQz-w, reason: not valid java name */
        public static /* synthetic */ float[] m4098$r8$lambda$TOflcGYXuStF3el4JR8AneQzw(DisplayDeviceConfig r0) {
            return lambda$loadHighBrightnessThresholds$7(r0);
        }

        public static /* synthetic */ float[] $r8$lambda$aoh3sBmq2C7SevGL6MwSMwgHrls(BrightnessObserver r0) {
            return r0.lambda$onDeviceConfigLowBrightnessThresholdsChanged$10();
        }

        /* JADX INFO: renamed from: $r8$lambda$eSIxrilA5_Gi_Xv6-SCnYK1kGRg, reason: not valid java name */
        public static /* synthetic */ float[] m4099$r8$lambda$eSIxrilA5_Gi_Xv6SCnYK1kGRg(BrightnessObserver r0) {
            return r0.lambda$onDeviceConfigHighBrightnessThresholdsChanged$12();
        }

        public static /* synthetic */ float[] $r8$lambda$horxynV7MmybweJstKDz3KJXC50(DisplayDeviceConfig r0) {
            return lambda$loadHighBrightnessThresholds$5(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$q9lF_A0quq49fCqX-dNNPJaLYQ8, reason: not valid java name */
        public static /* synthetic */ float[] m4100$r8$lambda$q9lF_A0quq49fCqXdNNPJaLYQ8(BrightnessObserver r0) {
            return r0.lambda$loadHighBrightnessThresholds$4();
        }

        /* JADX INFO: renamed from: $r8$lambda$uJDIpoE3-0BsPhq2MxsFE6C-7l4, reason: not valid java name */
        public static /* synthetic */ float[] m4101$r8$lambda$uJDIpoE30BsPhq2MxsFE6C7l4(BrightnessObserver r0) {
            return r0.lambda$onDeviceConfigLowBrightnessThresholdsChanged$8();
        }

        public static /* synthetic */ float[] $r8$lambda$ukYjuV9AUGT_8BbrisQUwkGAqfM(BrightnessObserver r0) {
            return r0.lambda$loadHighBrightnessThresholds$6();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAmbientFilter, reason: not valid java name */
        static /* bridge */ /* synthetic */ AmbientFilter m4102$$Nest$fgetmAmbientFilter(BrightnessObserver r0) {
            return r0.mAmbientFilter;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAmbientLux, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m4103$$Nest$fgetmAmbientLux(BrightnessObserver r0) {
            return r0.mAmbientLux;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ Handler m4104$$Nest$fgetmHandler(BrightnessObserver r0) {
            return r0.mHandler;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHighAmbientBrightnessThresholds, reason: not valid java name */
        static /* bridge */ /* synthetic */ float[] m4105$$Nest$fgetmHighAmbientBrightnessThresholds(BrightnessObserver r0) {
            return r0.mHighAmbientBrightnessThresholds;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLowAmbientBrightnessThresholds, reason: not valid java name */
        static /* bridge */ /* synthetic */ float[] m4106$$Nest$fgetmLowAmbientBrightnessThresholds(BrightnessObserver r0) {
            return r0.mLowAmbientBrightnessThresholds;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmThermalStatus, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4107$$Nest$fgetmThermalStatus(BrightnessObserver r0) {
            return r0.mThermalStatus;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAmbientLux, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4108$$Nest$fputmAmbientLux(BrightnessObserver r0, float r1) {
            r0.mAmbientLux = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmThermalStatus, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4109$$Nest$fputmThermalStatus(BrightnessObserver r0, int r1) {
            r0.mThermalStatus = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mloadIdleScreenRefreshRateConfigs, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4110$$Nest$mloadIdleScreenRefreshRateConfigs(BrightnessObserver r0, DisplayDeviceConfig r1) {
            r0.loadIdleScreenRefreshRateConfigs(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mobserve, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4111$$Nest$mobserve(BrightnessObserver r0, SensorManager r1) {
            r0.observe(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$monBrightnessChangedLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4112$$Nest$monBrightnessChangedLocked(BrightnessObserver r0) {
            r0.onBrightnessChangedLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$monDeviceConfigHighBrightnessThresholdsChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4113$$Nest$monDeviceConfigHighBrightnessThresholdsChanged(BrightnessObserver r0, float[] r1, float[] r2) {
            r0.onDeviceConfigHighBrightnessThresholdsChanged(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$monDeviceConfigLowBrightnessThresholdsChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4114$$Nest$monDeviceConfigLowBrightnessThresholdsChanged(BrightnessObserver r0, float[] r1, float[] r2) {
            r0.onDeviceConfigLowBrightnessThresholdsChanged(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mreloadLightSensor, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4115$$Nest$mreloadLightSensor(BrightnessObserver r0, DisplayDeviceConfig r1) {
            r0.reloadLightSensor(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetLoggingEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4116$$Nest$msetLoggingEnabled(BrightnessObserver r0, boolean r1) {
            r0.setLoggingEnabled(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateIdleScreenRefreshRate, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4117$$Nest$mupdateIdleScreenRefreshRate(BrightnessObserver r0, float r1) {
            r0.updateIdleScreenRefreshRate(r1);
        }

        BrightnessObserver(DisplayModeDirector this$0, Context context, Handler handler, Injector injector, DisplayManagerFlags flags) {
            this.this$0 = this$0;
            this.mLightSensorListener = new LightSensorEventListener(this, null);
            this.mAmbientLux = -1.0f;
            this.mBrightness = Float.NaN;
            this.mThermalListener = new AnonymousClass1(this);
            this.mDefaultDisplayState = 0;
            this.mRefreshRateChangeable = false;
            this.mLowPowerModeEnabled = false;
            this.mThermalStatus = 0;
            this.mContext = context;
            this.mHandler = handler;
            this.mInjector = injector;
            updateBlockingZoneThresholds(null, false);
            this.mRefreshRateInHighZone = context.getResources().getInteger(R.integer.config_jobSchedulerUserGracePeriod);
            this.mVsyncLowLightBlockingVoteEnabled = flags.isVsyncLowLightVoteEnabled();
            loadIdleScreenRefreshRateConfigs(null);
        }

        private void loadIdleScreenRefreshRateConfigs(DisplayDeviceConfig displayDeviceConfig) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (DisplayModeDirector.m4076$$Nest$fgetmDisplayManagerFlags(this.this$0).isIdleScreenConfigInSubscribingLightSensorEnabled() == false) goto L15;
            if (displayDeviceConfig == null) goto L15;
            if (displayDeviceConfig.getIdleScreenRefreshRateTimeoutLuxThresholdPoint().isEmpty() == true) goto L15;
            this.mIdleScreenRefreshRateTimeoutLuxThresholdPoints = displayDeviceConfig.getIdleScreenRefreshRateTimeoutLuxThresholdPoint();     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L15:
            this.mIdleScreenRefreshRateConfig = null;     // Catch: Throwable -> L13
            this.mIdleScreenRefreshRateTimeoutLuxThresholdPoints = null;     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
        }

        public void updateBlockingZoneThresholds(DisplayDeviceConfig displayDeviceConfig, boolean attemptReadFromFeatureParams) {
            loadLowBrightnessThresholds(displayDeviceConfig, attemptReadFromFeatureParams);
            loadHighBrightnessThresholds(displayDeviceConfig, attemptReadFromFeatureParams);
        }

        float[] getLowDisplayBrightnessThresholds() {
            return this.mLowDisplayBrightnessThresholds;
        }

        float[] getLowAmbientBrightnessThresholds() {
            return this.mLowAmbientBrightnessThresholds;
        }

        float[] getHighDisplayBrightnessThresholds() {
            return this.mHighDisplayBrightnessThresholds;
        }

        float[] getHighAmbientBrightnessThresholds() {
            return this.mHighAmbientBrightnessThresholds;
        }

        int getRefreshRateInHighZone() {
            return this.mRefreshRateInHighZone;
        }

        int getRefreshRateInLowZone() {
            return this.mRefreshRateInLowZone;
        }

        SurfaceControl.IdleScreenRefreshRateConfig getIdleScreenRefreshRateConfig() {
            return this.mIdleScreenRefreshRateConfig;
        }

        List<IdleScreenRefreshRateTimeoutLuxThresholdPoint> getIdleScreenRefreshRateTimeoutLuxThresholdPoints() {
            return this.mIdleScreenRefreshRateTimeoutLuxThresholdPoints;
        }

        private void loadLowBrightnessThresholds(final DisplayDeviceConfig displayDeviceConfig, boolean attemptReadFromFeatureParams) {
            loadRefreshRateInHighZone(displayDeviceConfig, attemptReadFromFeatureParams);
            loadRefreshRateInLowZone(displayDeviceConfig, attemptReadFromFeatureParams);
            this.mLowDisplayBrightnessThresholds = loadBrightnessThresholds(new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda6(this), new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda7(displayDeviceConfig), R.array.config_defaultAllowlistLaunchOnPrivateDisplayPackages, displayDeviceConfig, attemptReadFromFeatureParams, new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda2());
            this.mLowAmbientBrightnessThresholds = loadBrightnessThresholds(new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda8(this), new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda9(displayDeviceConfig), R.array.config_backupHealthConnectDataAndSettingsKnownSigners, displayDeviceConfig, attemptReadFromFeatureParams, new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda5());
            if (this.mLowDisplayBrightnessThresholds.length != this.mLowAmbientBrightnessThresholds.length) goto L6;
            return;
        L6:
            throw new RuntimeException("display low brightness threshold array and ambient brightness threshold array have different length: displayBrightnessThresholds=" + Arrays.toString(this.mLowDisplayBrightnessThresholds) + ", ambientBrightnessThresholds=" + Arrays.toString(this.mLowAmbientBrightnessThresholds));
        }

        private /* synthetic */ float[] lambda$loadLowBrightnessThresholds$0() throws Exception {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getLowDisplayBrightnessThresholds();
        }

        private static /* synthetic */ float[] lambda$loadLowBrightnessThresholds$1(DisplayDeviceConfig displayDeviceConfig) throws Exception {
            return displayDeviceConfig.getLowDisplayBrightnessThresholds();
        }

        private /* synthetic */ float[] lambda$loadLowBrightnessThresholds$2() throws Exception {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getLowAmbientBrightnessThresholds();
        }

        private static /* synthetic */ float[] lambda$loadLowBrightnessThresholds$3(DisplayDeviceConfig displayDeviceConfig) throws Exception {
            return displayDeviceConfig.getLowAmbientBrightnessThresholds();
        }

        private void loadRefreshRateInLowZone(DisplayDeviceConfig displayDeviceConfig, boolean attemptReadFromFeatureParams) {
            int refreshRateInLowZone = -1;
            if (attemptReadFromFeatureParams == false) goto L8;
            refreshRateInLowZone = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getRefreshRateInLowZone();     // Catch: Exception -> L6
        L8:
            if (refreshRateInLowZone != (-1)) goto L13;
            if (displayDeviceConfig != null) goto L11;
            int r1 = this.mContext.getResources().getInteger(R.integer.config_deviceStateConcurrentRearDisplay);
        L12:
            refreshRateInLowZone = r1;
            goto L13
        L11:
            r1 = displayDeviceConfig.getDefaultLowBlockingZoneRefreshRate();
        L13:
            if (displayDeviceConfig != null) goto L15;
            SparseArray<SurfaceControl.RefreshRateRange> r2 = null;
        L16:
            this.mLowZoneRefreshRateForThermals = r2;
            this.mRefreshRateInLowZone = refreshRateInLowZone;
            return;
        L15:
            r2 = displayDeviceConfig.getLowBlockingZoneThermalMap();
            goto L16
        }

        private void loadRefreshRateInHighZone(DisplayDeviceConfig displayDeviceConfig, boolean attemptReadFromFeatureParams) {
            int refreshRateInHighZone = -1;
            if (attemptReadFromFeatureParams == false) goto L8;
            refreshRateInHighZone = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getRefreshRateInHighZone();     // Catch: Exception -> L6
        L8:
            if (refreshRateInHighZone != (-1)) goto L13;
            if (displayDeviceConfig != null) goto L11;
            int r1 = this.mContext.getResources().getInteger(R.integer.config_jobSchedulerUserGracePeriod);
        L12:
            refreshRateInHighZone = r1;
            goto L13
        L11:
            r1 = displayDeviceConfig.getDefaultHighBlockingZoneRefreshRate();
        L13:
            if (displayDeviceConfig != null) goto L15;
            SparseArray<SurfaceControl.RefreshRateRange> r2 = null;
        L16:
            this.mHighZoneRefreshRateForThermals = r2;
            this.mRefreshRateInHighZone = refreshRateInHighZone;
            return;
        L15:
            r2 = displayDeviceConfig.getHighBlockingZoneThermalMap();
            goto L16
        }

        private void loadHighBrightnessThresholds(final DisplayDeviceConfig displayDeviceConfig, boolean attemptReadFromFeatureParams) {
            this.mHighDisplayBrightnessThresholds = loadBrightnessThresholds(new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda10(this), new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda11(displayDeviceConfig), R.array.config_networkNotifySwitches, displayDeviceConfig, attemptReadFromFeatureParams, new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda2());
            this.mHighAmbientBrightnessThresholds = loadBrightnessThresholds(new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda12(this), new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda13(displayDeviceConfig), R.array.config_mobile_tcp_buffers, displayDeviceConfig, attemptReadFromFeatureParams, new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda5());
            if (this.mHighDisplayBrightnessThresholds.length != this.mHighAmbientBrightnessThresholds.length) goto L6;
            return;
        L6:
            throw new RuntimeException("display high brightness threshold array and ambient brightness threshold array have different length: displayBrightnessThresholds=" + Arrays.toString(this.mHighDisplayBrightnessThresholds) + ", ambientBrightnessThresholds=" + Arrays.toString(this.mHighAmbientBrightnessThresholds));
        }

        private /* synthetic */ float[] lambda$loadHighBrightnessThresholds$4() throws Exception {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getHighDisplayBrightnessThresholds();
        }

        private static /* synthetic */ float[] lambda$loadHighBrightnessThresholds$5(DisplayDeviceConfig displayDeviceConfig) throws Exception {
            return displayDeviceConfig.getHighDisplayBrightnessThresholds();
        }

        private /* synthetic */ float[] lambda$loadHighBrightnessThresholds$6() throws Exception {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getHighAmbientBrightnessThresholds();
        }

        private static /* synthetic */ float[] lambda$loadHighBrightnessThresholds$7(DisplayDeviceConfig displayDeviceConfig) throws Exception {
            return displayDeviceConfig.getHighAmbientBrightnessThresholds();
        }

        private float[] loadBrightnessThresholds(Callable<float[]> loadFromDeviceConfigDisplaySettingsCallable, Callable<float[]> loadFromDisplayDeviceConfigCallable, int brightnessThresholdOfFixedRefreshRateKey, DisplayDeviceConfig displayDeviceConfig, boolean attemptReadFromFeatureParams, Function<int[], float[]> conversion) {
            float[] brightnessThresholds = null;
            if (attemptReadFromFeatureParams == true) goto L16;
        L7:
            if (brightnessThresholds != null) goto L20;
            if (displayDeviceConfig != null) goto L12;
            float[] r1 = conversion.apply(this.mContext.getResources().getIntArray(brightnessThresholdOfFixedRefreshRateKey));     // Catch: Exception -> L10
        L13:
            brightnessThresholds = r1;
            return brightnessThresholds;
        L12:
            r1 = loadFromDisplayDeviceConfigCallable.call();     // Catch: Exception -> L10
        L10:
            e = move-exception;
            Slog.e(DisplayModeDirector.TAG, "Unexpectedly failed to load display brightness threshold");
            e.printStackTrace();
            return brightnessThresholds;
        L20:
            return brightnessThresholds;
        L16:
            brightnessThresholds = loadFromDeviceConfigDisplaySettingsCallable.call();     // Catch: Exception -> L6
            goto L7
        }

        private void observe(SensorManager sensorManager) {
            this.mSensorManager = sensorManager;
            this.mBrightness = getBrightness(0);
            float[] lowDisplayBrightnessThresholds = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getLowDisplayBrightnessThresholds();
            float[] lowAmbientBrightnessThresholds = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getLowAmbientBrightnessThresholds();
            if (lowDisplayBrightnessThresholds == null) goto L8;
            if (lowAmbientBrightnessThresholds == null) goto L8;
            if (lowDisplayBrightnessThresholds.length != lowAmbientBrightnessThresholds.length) goto L8;
            this.mLowDisplayBrightnessThresholds = lowDisplayBrightnessThresholds;
            this.mLowAmbientBrightnessThresholds = lowAmbientBrightnessThresholds;
        L8:
            float[] highDisplayBrightnessThresholds = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getHighDisplayBrightnessThresholds();
            float[] highAmbientBrightnessThresholds = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getHighAmbientBrightnessThresholds();
            if (highDisplayBrightnessThresholds == null) goto L14;
            if (highAmbientBrightnessThresholds == null) goto L14;
            if (highDisplayBrightnessThresholds.length != highAmbientBrightnessThresholds.length) goto L14;
            this.mHighDisplayBrightnessThresholds = highDisplayBrightnessThresholds;
            this.mHighAmbientBrightnessThresholds = highAmbientBrightnessThresholds;
        L14:
            int refreshRateInLowZone = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getRefreshRateInLowZone();
            if (refreshRateInLowZone == (-1)) goto L17;
            this.mRefreshRateInLowZone = refreshRateInLowZone;
        L17:
            int refreshRateInHighZone = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getRefreshRateInHighZone();
            if (refreshRateInHighZone == (-1)) goto L20;
            this.mRefreshRateInHighZone = refreshRateInHighZone;
        L20:
            restartObserver();
            DisplayModeDirector.m4073$$Nest$fgetmDeviceConfigDisplaySettings(this.this$0).startListening();
            registerDisplayListener();
        }

        private void registerDisplayListener() {
            this.mInjector.registerDisplayListener(this, this.mHandler, 4, 1);
        }

        private void setLoggingEnabled(boolean loggingEnabled) {
            if (this.mLoggingEnabled != loggingEnabled) goto L5;
            return;
        L5:
            this.mLoggingEnabled = loggingEnabled;
            this.mLightSensorListener.setLoggingEnabled(loggingEnabled);
        }

        public void onRefreshRateSettingChangedLocked(float min, float max) {
            if ((max - min) > 1.0f) goto L5;
        L7:
            boolean changeable = false;
        L9:
            if (this.mRefreshRateChangeable == changeable) goto L14;
            this.mRefreshRateChangeable = changeable;
            updateSensorStatus();
            if (changeable == true) goto L15;
            removeFlickerRefreshRateVotes();
            return;
        L15:
            return;
        L14:
            return;
        L5:
            if (max <= 60.0f) goto L7;
            changeable = true;
            goto L9
        }

        void onLowPowerModeEnabledLocked(boolean enabled) {
            if (this.mLowPowerModeEnabled == enabled) goto L8;
            this.mLowPowerModeEnabled = enabled;
            updateSensorStatus();
            if (enabled == false) goto L9;
            removeFlickerRefreshRateVotes();
            return;
        L9:
            return;
        }

        private void removeFlickerRefreshRateVotes() {
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateGlobalVote(1, null);
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateGlobalVote(20, null);
        }

        private void onDeviceConfigLowBrightnessThresholdsChanged(float[] displayThresholds, float[] ambientThresholds) {
            if (displayThresholds == null) goto L7;
            if (ambientThresholds == null) goto L7;
            if (displayThresholds.length != ambientThresholds.length) goto L7;
            this.mLowDisplayBrightnessThresholds = displayThresholds;
            this.mLowAmbientBrightnessThresholds = ambientThresholds;
        L12:
            restartObserver();
            return;
        L7:
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            final DisplayDeviceConfig displayDeviceConfig = DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0);     // Catch: Throwable -> L14
            monitor-exit(r1);     // Catch: Throwable -> L14
            this.mLowDisplayBrightnessThresholds = loadBrightnessThresholds(new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda14(this), new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda15(displayDeviceConfig), R.array.config_defaultAllowlistLaunchOnPrivateDisplayPackages, displayDeviceConfig, false, new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda2());
            this.mLowAmbientBrightnessThresholds = loadBrightnessThresholds(new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda16(this), new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda17(displayDeviceConfig), R.array.config_backupHealthConnectDataAndSettingsKnownSigners, displayDeviceConfig, false, new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda5());
        L14:
            th = th;
        L22:
            throw th;
        L18:
            th = th;
            goto L22
        }

        private /* synthetic */ float[] lambda$onDeviceConfigLowBrightnessThresholdsChanged$8() throws Exception {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getLowDisplayBrightnessThresholds();
        }

        private static /* synthetic */ float[] lambda$onDeviceConfigLowBrightnessThresholdsChanged$9(DisplayDeviceConfig displayDeviceConfig) throws Exception {
            return displayDeviceConfig.getLowDisplayBrightnessThresholds();
        }

        private /* synthetic */ float[] lambda$onDeviceConfigLowBrightnessThresholdsChanged$10() throws Exception {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getLowAmbientBrightnessThresholds();
        }

        private static /* synthetic */ float[] lambda$onDeviceConfigLowBrightnessThresholdsChanged$11(DisplayDeviceConfig displayDeviceConfig) throws Exception {
            return displayDeviceConfig.getLowAmbientBrightnessThresholds();
        }

        public void onDeviceConfigRefreshRateInLowZoneChanged(int refreshRate) {
            if (refreshRate != (-1)) goto L13;
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            loadRefreshRateInLowZone(DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0), false);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            restartObserver();
            return;
        L9:
            th = move-exception;
            throw th;
        L13:
            if (refreshRate == this.mRefreshRateInLowZone) goto L19;
            this.mRefreshRateInLowZone = refreshRate;
            restartObserver();
            return;
        }

        private void onDeviceConfigHighBrightnessThresholdsChanged(float[] displayThresholds, float[] ambientThresholds) {
            if (displayThresholds == null) goto L7;
            if (ambientThresholds == null) goto L7;
            if (displayThresholds.length != ambientThresholds.length) goto L7;
            this.mHighDisplayBrightnessThresholds = displayThresholds;
            this.mHighAmbientBrightnessThresholds = ambientThresholds;
        L12:
            restartObserver();
            return;
        L7:
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            final DisplayDeviceConfig displayDeviceConfig = DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0);     // Catch: Throwable -> L14
            monitor-exit(r1);     // Catch: Throwable -> L14
            this.mHighDisplayBrightnessThresholds = loadBrightnessThresholds(new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda0(this), new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda1(displayDeviceConfig), R.array.config_networkNotifySwitches, displayDeviceConfig, false, new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda2());
            this.mHighAmbientBrightnessThresholds = loadBrightnessThresholds(new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda3(this), new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda4(displayDeviceConfig), R.array.config_mobile_tcp_buffers, displayDeviceConfig, false, new DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda5());
        L14:
            th = th;
        L22:
            throw th;
        L18:
            th = th;
            goto L22
        }

        private /* synthetic */ float[] lambda$onDeviceConfigHighBrightnessThresholdsChanged$12() throws Exception {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getLowDisplayBrightnessThresholds();
        }

        private static /* synthetic */ float[] lambda$onDeviceConfigHighBrightnessThresholdsChanged$13(DisplayDeviceConfig displayDeviceConfig) throws Exception {
            return displayDeviceConfig.getHighDisplayBrightnessThresholds();
        }

        private /* synthetic */ float[] lambda$onDeviceConfigHighBrightnessThresholdsChanged$14() throws Exception {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getHighAmbientBrightnessThresholds();
        }

        private static /* synthetic */ float[] lambda$onDeviceConfigHighBrightnessThresholdsChanged$15(DisplayDeviceConfig displayDeviceConfig) throws Exception {
            return displayDeviceConfig.getHighAmbientBrightnessThresholds();
        }

        public void onDeviceConfigRefreshRateInHighZoneChanged(int refreshRate) {
            if (refreshRate != (-1)) goto L13;
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            loadRefreshRateInHighZone(DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0), false);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            restartObserver();
            return;
        L9:
            th = move-exception;
            throw th;
        L13:
            if (refreshRate == this.mRefreshRateInHighZone) goto L19;
            this.mRefreshRateInHighZone = refreshRate;
            restartObserver();
            return;
        }

        void dumpLocked(PrintWriter pw) {
            pw.println("  BrightnessObserver");
            pw.println("    mAmbientLux: " + this.mAmbientLux);
            pw.println("    mBrightness: " + this.mBrightness);
            pw.println("    mDefaultDisplayState: " + this.mDefaultDisplayState);
            pw.println("    mLowPowerModeEnabled: " + this.mLowPowerModeEnabled);
            pw.println("    mRefreshRateChangeable: " + this.mRefreshRateChangeable);
            pw.println("    mShouldObserveDisplayLowChange: " + this.mShouldObserveDisplayLowChange);
            pw.println("    mShouldObserveAmbientLowChange: " + this.mShouldObserveAmbientLowChange);
            pw.println("    mRefreshRateInLowZone: " + this.mRefreshRateInLowZone);
            float[] r0 = this.mLowDisplayBrightnessThresholds;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            float d = r0[r3];
            pw.println("    mDisplayLowBrightnessThreshold: " + d);
            r3 = r3 + 1;
            goto L3
        L5:
            float[] r4 = this.mLowAmbientBrightnessThresholds;
            int r5 = r4.length;
            int r6 = 0;
        L6:
            if (r6 >= r5) goto L8;
            float d2 = r4[r6];
            pw.println("    mAmbientLowBrightnessThreshold: " + d2);
            r6 = r6 + 1;
            goto L6
        L8:
            pw.println("    mShouldObserveDisplayHighChange: " + this.mShouldObserveDisplayHighChange);
            pw.println("    mShouldObserveAmbientHighChange: " + this.mShouldObserveAmbientHighChange);
            pw.println("    mRefreshRateInHighZone: " + this.mRefreshRateInHighZone);
            float[] r7 = this.mHighDisplayBrightnessThresholds;
            int r8 = r7.length;
            int r9 = 0;
        L9:
            if (r9 >= r8) goto L11;
            float d3 = r7[r9];
            pw.println("    mDisplayHighBrightnessThresholds: " + d3);
            r9 = r9 + 1;
            goto L9
        L11:
            float[] r10 = this.mHighAmbientBrightnessThresholds;
            int r11 = r10.length;
        L12:
            if (r2 >= r11) goto L14;
            float d4 = r10[r2];
            pw.println("    mAmbientHighBrightnessThresholds: " + d4);
            r2 = r2 + 1;
            goto L12
        L14:
            pw.println("    mRegisteredLightSensor: " + this.mRegisteredLightSensor);
            pw.println("    mLightSensor: " + this.mLightSensor);
            pw.println("    mLightSensorName: " + this.mLightSensorName);
            pw.println("    mLightSensorType: " + this.mLightSensorType);
            this.mLightSensorListener.dumpLocked(pw);
            if (this.mAmbientFilter == null) goto L22;
            this.mAmbientFilter.dump(new IndentingPrintWriter(pw, "    "));
            return;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            if (displayId != 0) goto L14;
            updateDefaultDisplayState();
            float brightness = getBrightness(displayId);
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L6:
            if (BrightnessSynchronizer.floatEquals(brightness, this.mBrightness) == true) goto L10;
            this.mBrightness = brightness;     // Catch: Throwable -> L8
            onBrightnessChangedLocked();     // Catch: Throwable -> L8
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        }

        private boolean hasLowLightVrrConfig() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            DisplayDeviceConfig config = DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0);     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            if (this.mVsyncLowLightBlockingVoteEnabled == false) goto L14;
            if (config == null) goto L14;
            if (config.isVrrSupportEnabled() == false) goto L14;
            if (config.getRefreshRateData().lowLightBlockingZoneSupportedModes.isEmpty() == true) goto L14;
            return true;
        L14:
            return false;
        L16:
            th = move-exception;
            throw th;
        }

        private void restartObserver() {
            if (this.mRefreshRateInLowZone <= 0) goto L5;
        L8:
            this.mShouldObserveDisplayLowChange = hasValidThreshold(this.mLowDisplayBrightnessThresholds);
            this.mShouldObserveAmbientLowChange = hasValidThreshold(this.mLowAmbientBrightnessThresholds);
        L10:
            if (this.mRefreshRateInHighZone <= 0) goto L12;
            this.mShouldObserveDisplayHighChange = hasValidThreshold(this.mHighDisplayBrightnessThresholds);
            this.mShouldObserveAmbientHighChange = hasValidThreshold(this.mHighAmbientBrightnessThresholds);
        L14:
            if (shouldRegisterLightSensor() == false) goto L21;
            Sensor lightSensor = getLightSensor();
            if (lightSensor != null) goto L18;
        L22:
            updateSensorStatus();
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            onBrightnessChangedLocked();     // Catch: Throwable -> L27
            monitor-exit(r0);     // Catch: Throwable -> L27
            return;
        L27:
            th = move-exception;
            throw th;
        L18:
            if (lightSensor == this.mLightSensor) goto L22;
            Resources res = this.mContext.getResources();
            this.mAmbientFilter = AmbientFilterFactory.createBrightnessFilter(DisplayModeDirector.TAG, res);
            this.mLightSensor = lightSensor;
            goto L22
        L21:
            this.mAmbientFilter = null;
            this.mLightSensor = null;
            goto L22
        L12:
            this.mShouldObserveDisplayHighChange = false;
            this.mShouldObserveAmbientHighChange = false;
            goto L14
        L5:
            if (hasLowLightVrrConfig() == true) goto L8;
            this.mShouldObserveDisplayLowChange = false;
            this.mShouldObserveAmbientLowChange = false;
            goto L10
        }

        private void reloadLightSensor(DisplayDeviceConfig displayDeviceConfig) {
            reloadLightSensorData(displayDeviceConfig);
            restartObserver();
        }

        private void reloadLightSensorData(DisplayDeviceConfig displayDeviceConfig) {
            if (displayDeviceConfig == null) goto L7;
            if (displayDeviceConfig.getAmbientLightSensor() == null) goto L7;
            this.mLightSensorType = displayDeviceConfig.getAmbientLightSensor().type;
            this.mLightSensorName = displayDeviceConfig.getAmbientLightSensor().name;
            return;
        L7:
            if (this.mLightSensorName == null) goto L9;
            return;
        L9:
            if (this.mLightSensorType != null) goto L14;
            Resources resources = this.mContext.getResources();
            this.mLightSensorType = resources.getString(R.string.config_mms_user_agent_profile_url);
            this.mLightSensorName = "";
            return;
        }

        private Sensor getLightSensor() {
            return SensorUtils.findSensor(this.mSensorManager, this.mLightSensorType, this.mLightSensorName, 5);
        }

        private boolean hasValidThreshold(float[] a) {
            int r0 = a.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            float d = a[r2];
            if (d >= 0.0f) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        private boolean isInsideLowZone(float brightness, float lux) {
            int i = 0;
        L4:
            if (i >= this.mLowDisplayBrightnessThresholds.length) goto L25;
            float disp = this.mLowDisplayBrightnessThresholds[i];
            float ambi = this.mLowAmbientBrightnessThresholds[i];
            if (disp < 0.0f) goto L15;
            if (ambi < 0.0f) goto L15;
            if (brightness > disp) goto L24;
            if (lux > ambi) goto L24;
            return true;
        L24:
            i = i + 1;
        L15:
            if (disp < 0.0f) goto L20;
            if (brightness > disp) goto L24;
            return true;
        L20:
            if (ambi < 0.0f) goto L24;
            if (lux > ambi) goto L24;
            return true;
        L25:
            return false;
        }

        private boolean isInsideHighZone(float brightness, float lux) {
            int i = 0;
        L4:
            if (i >= this.mHighDisplayBrightnessThresholds.length) goto L25;
            float disp = this.mHighDisplayBrightnessThresholds[i];
            float ambi = this.mHighAmbientBrightnessThresholds[i];
            if (disp < 0.0f) goto L15;
            if (ambi < 0.0f) goto L15;
            if (brightness < disp) goto L24;
            if (lux < ambi) goto L24;
            return true;
        L24:
            i = i + 1;
        L15:
            if (disp < 0.0f) goto L20;
            if (brightness < disp) goto L24;
            return true;
        L20:
            if (ambi < 0.0f) goto L24;
            if (lux < ambi) goto L24;
            return true;
        L25:
            return false;
        }

        private void onBrightnessChangedLocked() {
            if (this.mRefreshRateChangeable == true) goto L5;
            return;
        L5:
            if (this.mLowPowerModeEnabled == true) goto L46;
            Vote refreshRateVote = null;
            Vote refreshRateSwitchingVote = null;
            if (Float.isNaN(this.mBrightness) == false) goto L10;
            return;
        L10:
            boolean insideHighZone = false;
            if (hasValidLowZone() == true) goto L13;
        L15:
            boolean insideLowZone = false;
        L16:
            if (insideLowZone == false) goto L27;
            if (hasLowLightVrrConfig() == false) goto L20;
            refreshRateVote = Vote.forSupportedRefreshRates(DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0).getRefreshRateData().lowLightBlockingZoneSupportedModes);
        L22:
            if (this.mLowZoneRefreshRateForThermals == null) goto L27;
            SurfaceControl.RefreshRateRange range = SkinThermalStatusObserver.findBestMatchingRefreshRateRange(this.mThermalStatus, this.mLowZoneRefreshRateForThermals);
            if (range == null) goto L27;
            refreshRateVote = Vote.forPhysicalRefreshRates(range.min, range.max);
            goto L27
        L20:
            refreshRateVote = Vote.forPhysicalRefreshRates(this.mRefreshRateInLowZone, this.mRefreshRateInLowZone);
            refreshRateSwitchingVote = Vote.forDisableRefreshRateSwitching();
        L27:
            if (hasValidHighZone() == true) goto L29;
        L33:
            if (insideHighZone == false) goto L41;
            refreshRateVote = Vote.forPhysicalRefreshRates(this.mRefreshRateInHighZone, this.mRefreshRateInHighZone);
            if (this.mHighZoneRefreshRateForThermals == null) goto L39;
            SurfaceControl.RefreshRateRange range2 = SkinThermalStatusObserver.findBestMatchingRefreshRateRange(this.mThermalStatus, this.mHighZoneRefreshRateForThermals);
            if (range2 == null) goto L39;
            refreshRateVote = Vote.forPhysicalRefreshRates(range2.min, range2.max);
        L39:
            refreshRateSwitchingVote = Vote.forDisableRefreshRateSwitching();
        L41:
            if (this.mLoggingEnabled == false) goto L43;
            Slog.d(DisplayModeDirector.TAG, "Display brightness " + this.mBrightness + ", ambient lux " + this.mAmbientLux + ", Vote " + refreshRateVote);
        L43:
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateGlobalVote(1, refreshRateVote);
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateGlobalVote(20, refreshRateSwitchingVote);
            return;
        L29:
            if (isInsideHighZone(this.mBrightness, this.mAmbientLux) == false) goto L33;
            insideHighZone = true;
            goto L33
        L13:
            if (isInsideLowZone(this.mBrightness, this.mAmbientLux) == false) goto L15;
            insideLowZone = true;
            goto L16
        }

        private boolean hasValidLowZone() {
            if (this.mRefreshRateInLowZone > 0) goto L7;
            if (hasLowLightVrrConfig() == true) goto L7;
        L11:
            return false;
        L7:
            if (this.mShouldObserveDisplayLowChange == false) goto L9;
        L12:
            return true;
        L9:
            if (this.mShouldObserveAmbientLowChange == false) goto L11;
            goto L11
        }

        private boolean hasValidHighZone() {
            if (this.mRefreshRateInHighZone > 0) goto L5;
        L9:
            return false;
        L5:
            if (this.mShouldObserveDisplayHighChange == false) goto L7;
        L8:
            return true;
        L7:
            if (this.mShouldObserveAmbientHighChange == false) goto L9;
            goto L8
        }

        private void updateDefaultDisplayState() {
            Display display = this.mInjector.getDisplay(0);
            if (display != null) goto L5;
            return;
        L5:
            setDefaultDisplayState(display.getState());
        }

        void setDefaultDisplayState(int state) {
            if (this.mLoggingEnabled == false) goto L6;
            Slog.d(DisplayModeDirector.TAG, "setDefaultDisplayState: mDefaultDisplayState = " + this.mDefaultDisplayState + ", state = " + state);
        L6:
            if (this.mDefaultDisplayState == state) goto L9;
            this.mDefaultDisplayState = state;
            updateSensorStatus();
            return;
        }

        private void updateSensorStatus() {
            if (this.mSensorManager != null) goto L5;
            return;
        L5:
            if (this.mLightSensorListener != null) goto L8;
            return;
        L8:
            if (this.mLoggingEnabled == false) goto L10;
            Slog.d(DisplayModeDirector.TAG, "updateSensorStatus: mShouldObserveAmbientLowChange = " + this.mShouldObserveAmbientLowChange + ", mShouldObserveAmbientHighChange = " + this.mShouldObserveAmbientHighChange);
            Slog.d(DisplayModeDirector.TAG, "updateSensorStatus: mLowPowerModeEnabled = " + this.mLowPowerModeEnabled + ", mRefreshRateChangeable = " + this.mRefreshRateChangeable);
        L10:
            boolean registerForThermals = false;
            if (shouldRegisterLightSensor() == true) goto L13;
        L26:
            unregisterSensorListener();
        L27:
            if (registerForThermals == true) goto L29;
        L31:
            if (registerForThermals == false) goto L33;
            return;
        L33:
            if (this.mThermalRegistered == false) goto L47;
            this.mInjector.unregisterThermalServiceListener(this.mThermalListener);
            this.mThermalRegistered = false;
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            this.mThermalStatus = 0;     // Catch: Throwable -> L39
            monitor-exit(r1);     // Catch: Throwable -> L39
            return;
        L39:
            th = move-exception;
            throw th;
        L47:
            return;
        L29:
            if (this.mThermalRegistered == true) goto L31;
            this.mThermalRegistered = this.mInjector.registerThermalServiceListener(this.mThermalListener);
            return;
        L13:
            if (isDeviceActive() == false) goto L26;
            if (this.mLowPowerModeEnabled == true) goto L26;
            if (this.mRefreshRateChangeable == false) goto L26;
            registerLightSensor();
            if (this.mLowZoneRefreshRateForThermals == null) goto L21;
        L24:
            boolean r2 = true;
        L25:
            registerForThermals = r2;
            goto L27
        L21:
            if (this.mHighZoneRefreshRateForThermals != null) goto L24;
            r2 = false;
            goto L25
        }

        private boolean shouldRegisterLightSensor() {
            if (this.mShouldObserveAmbientLowChange == false) goto L5;
        L10:
            return true;
        L5:
            if (this.mShouldObserveAmbientHighChange == true) goto L10;
            if (isIdleScreenRefreshRateConfigDefined() == true) goto L10;
            return false;
        }

        private boolean isIdleScreenRefreshRateConfigDefined() {
            if (DisplayModeDirector.m4076$$Nest$fgetmDisplayManagerFlags(this.this$0).isIdleScreenConfigInSubscribingLightSensorEnabled() == true) goto L5;
        L9:
            return false;
        L5:
            if (this.mIdleScreenRefreshRateTimeoutLuxThresholdPoints == null) goto L9;
            if (this.mIdleScreenRefreshRateTimeoutLuxThresholdPoints.isEmpty() == true) goto L9;
            return true;
        }

        private void registerLightSensor() {
            if (this.mRegisteredLightSensor != this.mLightSensor) goto L6;
            return;
        L6:
            if (this.mRegisteredLightSensor == null) goto L8;
            unregisterSensorListener();
        L8:
            this.mSensorManager.registerListener(this.mLightSensorListener, this.mLightSensor, 250000, this.mHandler);
            this.mRegisteredLightSensor = this.mLightSensor;
            if (this.mLoggingEnabled == false) goto L12;
            Slog.d(DisplayModeDirector.TAG, "updateSensorStatus: registerListener");
            return;
        }

        private void unregisterSensorListener() {
            this.mLightSensorListener.removeCallbacks();
            this.mSensorManager.unregisterListener(this.mLightSensorListener);
            this.mRegisteredLightSensor = null;
            if (this.mLoggingEnabled == false) goto L6;
            Slog.d(DisplayModeDirector.TAG, "updateSensorStatus: unregisterListener");
            return;
        }

        private boolean isDeviceActive() {
            if (this.mDefaultDisplayState != 2) goto L5;
            return true;
        L5:
            return false;
        }

        private float getBrightness(int displayId) {
            BrightnessInfo info = this.mInjector.getBrightnessInfo(displayId);
            if (info != null) goto L5;
            return Float.NaN;
        L5:
            return info.adjustedBrightness;
        }

        private void updateIdleScreenRefreshRate(float ambientLux) {
            if (this.mIdleScreenRefreshRateTimeoutLuxThresholdPoints != null) goto L5;
        L26:
            this.mIdleScreenRefreshRateConfig = null;
            return;
        L5:
            if (this.mIdleScreenRefreshRateTimeoutLuxThresholdPoints.isEmpty() == true) goto L26;
            int newTimeout = -1;
            Iterator<IdleScreenRefreshRateTimeoutLuxThresholdPoint> r1 = this.mIdleScreenRefreshRateTimeoutLuxThresholdPoints.iterator();
        L9:
            if (r1.hasNext() == false) goto L15;
            IdleScreenRefreshRateTimeoutLuxThresholdPoint point = r1.next();
            int newLux = point.getLux().intValue();
            if (newLux > ambientLux) goto L9;
            newTimeout = point.getTimeout().intValue();
            goto L9
        L15:
            if (this.mIdleScreenRefreshRateConfig != null) goto L17;
        L18:
            this.mIdleScreenRefreshRateConfig = new SurfaceControl.IdleScreenRefreshRateConfig(newTimeout);
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            DisplayModeDirector.m4093$$Nest$mnotifyDesiredDisplayModeSpecsChangedLocked(this.this$0);     // Catch: Throwable -> L23
            monitor-exit(r2);     // Catch: Throwable -> L23
            return;
        L23:
            th = move-exception;
            throw th;
        L17:
            if (newTimeout != this.mIdleScreenRefreshRateConfig.timeoutMillis) goto L18;
        }
    }

    public static final class DesiredDisplayModeSpecs {
        public boolean allowGroupSwitching;
        public final SurfaceControl.RefreshRateRanges appRequest;
        public int baseModeId;
        public SurfaceControl.IdleScreenRefreshRateConfig mIdleScreenRefreshRateConfig;
        public final SurfaceControl.RefreshRateRanges primary;

        public DesiredDisplayModeSpecs() {
            this.primary = new SurfaceControl.RefreshRateRanges();
            this.appRequest = new SurfaceControl.RefreshRateRanges();
        }

        public DesiredDisplayModeSpecs(int baseModeId, boolean allowGroupSwitching, SurfaceControl.RefreshRateRanges primary, SurfaceControl.RefreshRateRanges appRequest, SurfaceControl.IdleScreenRefreshRateConfig idleScreenRefreshRateConfig) {
            this.baseModeId = baseModeId;
            this.allowGroupSwitching = allowGroupSwitching;
            this.primary = primary;
            this.appRequest = appRequest;
            this.mIdleScreenRefreshRateConfig = idleScreenRefreshRateConfig;
        }

        public String toString() {
            return String.format("baseModeId=%d allowGroupSwitching=%b primary=%s appRequest=%s idleScreenRefreshRateConfig=%s", new Object[]{Integer.valueOf(this.baseModeId), Boolean.valueOf(this.allowGroupSwitching), this.primary.toString(), this.appRequest.toString(), String.valueOf(this.mIdleScreenRefreshRateConfig)});
        }

        public boolean equals(Object other) {
            if (other != this) goto L6;
            return true;
        L6:
            if ((other instanceof DesiredDisplayModeSpecs) == true) goto L8;
            return false;
        L8:
            DesiredDisplayModeSpecs desiredDisplayModeSpecs = (DesiredDisplayModeSpecs) other;
            if (this.baseModeId == desiredDisplayModeSpecs.baseModeId) goto L12;
            return false;
        L12:
            if (this.allowGroupSwitching == desiredDisplayModeSpecs.allowGroupSwitching) goto L15;
            return false;
        L15:
            if (this.primary.equals(desiredDisplayModeSpecs.primary) == true) goto L18;
            return false;
        L18:
            if (this.appRequest.equals(desiredDisplayModeSpecs.appRequest) == true) goto L21;
            return false;
        L21:
            if (Objects.equals(this.mIdleScreenRefreshRateConfig, desiredDisplayModeSpecs.mIdleScreenRefreshRateConfig) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.baseModeId), Boolean.valueOf(this.allowGroupSwitching), this.primary, this.appRequest, this.mIdleScreenRefreshRateConfig});
        }

        public void copyFrom(DesiredDisplayModeSpecs other) {
            this.baseModeId = other.baseModeId;
            this.allowGroupSwitching = other.allowGroupSwitching;
            SurfaceControl.RefreshRateRange r0 = this.primary.physical;
            r0.min = other.primary.physical.min;
            SurfaceControl.RefreshRateRange r1 = this.primary.physical;
            r1.max = other.primary.physical.max;
            SurfaceControl.RefreshRateRange r2 = this.primary.render;
            r2.min = other.primary.render.min;
            SurfaceControl.RefreshRateRange r3 = this.primary.render;
            r3.max = other.primary.render.max;
            SurfaceControl.RefreshRateRange r4 = this.appRequest.physical;
            r4.min = other.appRequest.physical.min;
            SurfaceControl.RefreshRateRange r5 = this.appRequest.physical;
            r5.max = other.appRequest.physical.max;
            SurfaceControl.RefreshRateRange r6 = this.appRequest.render;
            r6.min = other.appRequest.render.min;
            SurfaceControl.RefreshRateRange r7 = this.appRequest.render;
            r7.max = other.appRequest.render.max;
            if (other.mIdleScreenRefreshRateConfig != null) goto L5;
            this.mIdleScreenRefreshRateConfig = null;
            return;
        L5:
            this.mIdleScreenRefreshRateConfig = new SurfaceControl.IdleScreenRefreshRateConfig(other.mIdleScreenRefreshRateConfig.timeoutMillis);
        }
    }

    public interface DesiredDisplayModeSpecsListener {
        void onDesiredDisplayModeSpecsChanged();
    }

    private class DeviceConfigDisplaySettings implements DeviceConfig.OnPropertiesChangedListener {
        final /* synthetic */ DisplayModeDirector this$0;

        public static /* synthetic */ int $r8$lambda$4IM44pR3egbsLgKCJgtproSJ4HU(DeviceConfigDisplaySettings r0) {
            return r0.lambda$getRefreshRateInHbmHdr$0();
        }

        /* JADX INFO: renamed from: $r8$lambda$UjQJH7qg8DdCnUYR-DTJghZFPuQ, reason: not valid java name */
        public static /* synthetic */ int m4122$r8$lambda$UjQJH7qg8DdCnUYRDTJghZFPuQ(DisplayDeviceConfig r0) {
            return lambda$getRefreshRateInHbmHdr$1(r0);
        }

        public static /* synthetic */ int $r8$lambda$Zlf8FUrJAId9oJETwAtYDKb3u9M(DisplayDeviceConfig r0) {
            return lambda$getRefreshRateInHbmSunlight$3(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$p85UmY-pmP6AkHPGqUwdtsPukFw, reason: not valid java name */
        public static /* synthetic */ int m4123$r8$lambda$p85UmYpmP6AkHPGqUwdtsPukFw(DeviceConfigDisplaySettings r0) {
            return r0.lambda$getRefreshRateInHbmSunlight$2();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetRefreshRateInHbmHdr, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4124$$Nest$mgetRefreshRateInHbmHdr(DeviceConfigDisplaySettings r0, DisplayDeviceConfig r1) {
            return r0.getRefreshRateInHbmHdr(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetRefreshRateInHbmSunlight, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4125$$Nest$mgetRefreshRateInHbmSunlight(DeviceConfigDisplaySettings r0, DisplayDeviceConfig r1) {
            return r0.getRefreshRateInHbmSunlight(r1);
        }

        /* synthetic */ DeviceConfigDisplaySettings(DisplayModeDirector r1, DisplayModeDirectorIA r2) {
            this(r1);
        }

        private DeviceConfigDisplaySettings(DisplayModeDirector r1) {
            this.this$0 = r1;
        }

        public void startListening() {
            DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).addOnPropertiesChangedListener(BackgroundThread.getExecutor(), this);
        }

        private int getRefreshRateInHbmHdr(final DisplayDeviceConfig displayDeviceConfig) {
            return getRefreshRate(new DisplayModeDirector$DeviceConfigDisplaySettings$$ExternalSyntheticLambda0(this), new DisplayModeDirector$DeviceConfigDisplaySettings$$ExternalSyntheticLambda1(displayDeviceConfig), R.integer.config_deskDockKeepsScreenOn, displayDeviceConfig);
        }

        private /* synthetic */ int lambda$getRefreshRateInHbmHdr$0() {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getRefreshRateInHbmHdr();
        }

        private static /* synthetic */ int lambda$getRefreshRateInHbmHdr$1(DisplayDeviceConfig displayDeviceConfig) {
            return displayDeviceConfig.getRefreshRateData().defaultRefreshRateInHbmHdr;
        }

        private int getRefreshRateInHbmSunlight(final DisplayDeviceConfig displayDeviceConfig) {
            return getRefreshRate(new DisplayModeDirector$DeviceConfigDisplaySettings$$ExternalSyntheticLambda2(this), new DisplayModeDirector$DeviceConfigDisplaySettings$$ExternalSyntheticLambda3(displayDeviceConfig), R.integer.config_deskDockRotation, displayDeviceConfig);
        }

        private /* synthetic */ int lambda$getRefreshRateInHbmSunlight$2() {
            return DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getRefreshRateInHbmSunlight();
        }

        private static /* synthetic */ int lambda$getRefreshRateInHbmSunlight$3(DisplayDeviceConfig displayDeviceConfig) {
            return displayDeviceConfig.getRefreshRateData().defaultRefreshRateInHbmSunlight;
        }

        private int getRefreshRate(IntSupplier fromConfigPram, IntSupplier fromDisplayDeviceConfig, int configKey, DisplayDeviceConfig displayDeviceConfig) {
            int refreshRate = -1;
            refreshRate = fromConfigPram.getAsInt();     // Catch: NullPointerException -> L5
        L7:
            if (refreshRate != (-1)) goto L15;
            if (displayDeviceConfig != null) goto L10;
            int r1 = DisplayModeDirector.m4070$$Nest$fgetmContext(this.this$0).getResources().getInteger(configKey);
        L11:
            int refreshRate2 = r1;
            return refreshRate2;
        L10:
            r1 = fromDisplayDeviceConfig.getAsInt();
            goto L11
        L15:
            return refreshRate;
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            float defaultPeakRefreshRate = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getPeakRefreshRateDefault();
            DisplayModeDirectorHandler r1 = DisplayModeDirector.m4078$$Nest$fgetmHandler(this.this$0);
            if (defaultPeakRefreshRate != (-1.0f)) goto L5;
            Float r2 = null;
        L6:
            r1.obtainMessage(3, r2).sendToTarget();
            float[] lowDisplayBrightnessThresholds = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getLowDisplayBrightnessThresholds();
            float[] lowAmbientBrightnessThresholds = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getLowAmbientBrightnessThresholds();
            int refreshRateInLowZone = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getRefreshRateInLowZone();
            DisplayModeDirector.m4078$$Nest$fgetmHandler(this.this$0).obtainMessage(2, new Pair(lowDisplayBrightnessThresholds, lowAmbientBrightnessThresholds)).sendToTarget();
            DisplayModeDirector.m4078$$Nest$fgetmHandler(this.this$0).obtainMessage(4, refreshRateInLowZone, 0).sendToTarget();
            float[] highDisplayBrightnessThresholds = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getHighDisplayBrightnessThresholds();
            float[] highAmbientBrightnessThresholds = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getHighAmbientBrightnessThresholds();
            int refreshRateInHighZone = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getRefreshRateInHighZone();
            DisplayModeDirector.m4078$$Nest$fgetmHandler(this.this$0).obtainMessage(6, new Pair(highDisplayBrightnessThresholds, highAmbientBrightnessThresholds)).sendToTarget();
            DisplayModeDirector.m4078$$Nest$fgetmHandler(this.this$0).obtainMessage(5, refreshRateInHighZone, 0).sendToTarget();
            Object r8 = this.this$0.mLock;
            monitor-enter(r8);
            int refreshRateInHbmSunlight = getRefreshRateInHbmSunlight(DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0));     // Catch: Throwable -> L11
            DisplayModeDirector.m4078$$Nest$fgetmHandler(this.this$0).obtainMessage(7, refreshRateInHbmSunlight, 0).sendToTarget();     // Catch: Throwable -> L11
            int refreshRateInHbmHdr = getRefreshRateInHbmHdr(DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0));     // Catch: Throwable -> L11
            DisplayModeDirector.m4078$$Nest$fgetmHandler(this.this$0).obtainMessage(8, refreshRateInHbmHdr, 0).sendToTarget();     // Catch: Throwable -> L11
            monitor-exit(r8);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        L5:
            r2 = Float.valueOf(defaultPeakRefreshRate);
            goto L6
        }
    }

    public interface DisplayDeviceConfigProvider {
        DisplayDeviceConfig getDisplayDeviceConfig(int r1);
    }

    private final class DisplayModeDirectorHandler extends Handler {
        final /* synthetic */ DisplayModeDirector this$0;

        DisplayModeDirectorHandler(DisplayModeDirector r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L5;
                default: goto L32;
            };
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            SettingsObserver.m4129$$Nest$mupdateRefreshRateSettingLocked(DisplayModeDirector.m4088$$Nest$fgetmSettingsObserver(this.this$0));     // Catch: Throwable -> L10
            SettingsObserver.m4128$$Nest$mupdateModeSwitchingTypeSettingLocked(DisplayModeDirector.m4088$$Nest$fgetmSettingsObserver(this.this$0));     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            int refreshRateInHbmHdr = msg.arg1;
            DisplayModeDirector.m4080$$Nest$fgetmHbmObserver(this.this$0).onDeviceConfigRefreshRateInHbmHdrChanged(refreshRateInHbmHdr);
            return;
        L14:
            int refreshRateInHbmHdr2 = msg.arg1;
            DisplayModeDirector.m4080$$Nest$fgetmHbmObserver(this.this$0).onDeviceConfigRefreshRateInHbmSunlightChanged(refreshRateInHbmHdr2);
            return;
        L15:
            Pair<float[], float[]> thresholds = (Pair) msg.obj;
            BrightnessObserver.m4113$$Nest$monDeviceConfigHighBrightnessThresholdsChanged(DisplayModeDirector.m4068$$Nest$fgetmBrightnessObserver(this.this$0), (float[]) thresholds.first, (float[]) thresholds.second);
            return;
        L16:
            int refreshRateInZone = msg.arg1;
            DisplayModeDirector.m4068$$Nest$fgetmBrightnessObserver(this.this$0).onDeviceConfigRefreshRateInHighZoneChanged(refreshRateInZone);
            return;
        L17:
            int refreshRateInZone2 = msg.arg1;
            DisplayModeDirector.m4068$$Nest$fgetmBrightnessObserver(this.this$0).onDeviceConfigRefreshRateInLowZoneChanged(refreshRateInZone2);
            return;
        L18:
            Float defaultPeakRefreshRate = (Float) msg.obj;
            DisplayModeDirector.m4088$$Nest$fgetmSettingsObserver(this.this$0).onDeviceConfigDefaultPeakRefreshRateChanged(defaultPeakRefreshRate);
            return;
        L19:
            Pair<float[], float[]> thresholds2 = (Pair) msg.obj;
            BrightnessObserver.m4114$$Nest$monDeviceConfigLowBrightnessThresholdsChanged(DisplayModeDirector.m4068$$Nest$fgetmBrightnessObserver(this.this$0), (float[]) thresholds2.first, (float[]) thresholds2.second);
            return;
        L20:
            DesiredDisplayModeSpecsListener desiredDisplayModeSpecsListener = (DesiredDisplayModeSpecsListener) msg.obj;
            desiredDisplayModeSpecsListener.onDesiredDisplayModeSpecsChanged();
            return;
        }
    }

    public final class DisplayObserver implements DisplayManager.DisplayListener {
        private final Context mContext;
        private int mExternalDisplayPeakHeight;
        private int mExternalDisplayPeakRefreshRate;
        private int mExternalDisplayPeakWidth;
        private final Handler mHandler;
        private final boolean mRefreshRateSynchronizationEnabled;
        private final VotesStorage mVotesStorage;
        final /* synthetic */ DisplayModeDirector this$0;

        DisplayObserver(DisplayModeDirector this$0, Context context, Handler handler, VotesStorage votesStorage, Injector injector) {
            this.this$0 = this$0;
            this.mContext = context;
            this.mHandler = handler;
            this.mVotesStorage = votesStorage;
            this.mExternalDisplayPeakRefreshRate = this.mContext.getResources().getInteger(R.integer.config_hsumBootStrategy);
            this.mExternalDisplayPeakWidth = this.mContext.getResources().getInteger(R.integer.config_immersive_mode_confirmation_panic);
            this.mExternalDisplayPeakHeight = this.mContext.getResources().getInteger(R.integer.config_hoverTapTimeoutMillis);
            this.mRefreshRateSynchronizationEnabled = this.mContext.getResources().getBoolean(R.bool.config_safe_media_volume_enabled);
        }

        private boolean isExternalDisplayLimitModeEnabled() {
            if (this.mExternalDisplayPeakWidth > 0) goto L5;
        L15:
            return false;
        L5:
            if (this.mExternalDisplayPeakHeight <= 0) goto L15;
            if (this.mExternalDisplayPeakRefreshRate <= 0) goto L15;
            if (DisplayModeDirector.m4084$$Nest$fgetmIsExternalDisplayLimitModeEnabled(this.this$0) == false) goto L15;
            if (DisplayModeDirector.m4082$$Nest$fgetmIsDisplayResolutionRangeVotingEnabled(this.this$0) == false) goto L15;
            if (DisplayModeDirector.m4085$$Nest$fgetmIsUserPreferredModeVoteEnabled(this.this$0) == false) goto L15;
            return true;
        }

        private boolean isRefreshRateSynchronizationEnabled() {
            if (this.mRefreshRateSynchronizationEnabled == true) goto L5;
        L7:
            return false;
        L5:
            if (DisplayModeDirector.m4083$$Nest$fgetmIsDisplaysRefreshRatesSynchronizationEnabled(this.this$0) == false) goto L7;
            return true;
        }

        public void observe() {
            DisplayModeDirector.m4081$$Nest$fgetmInjector(this.this$0).registerDisplayListener(this, this.mHandler);
            SparseArray<Display.Mode[]> modes = new SparseArray();
            SparseArray<Display.Mode[]> appModes = new SparseArray();
            SparseArray<Display.Mode> defaultModes = new SparseArray();
            Display[] displays = DisplayModeDirector.m4081$$Nest$fgetmInjector(this.this$0).getDisplays();
            int r4 = displays.length;
            int r6 = 0;
        L3:
            if (r6 >= r4) goto L5;
            Display d = displays[r6];
            int displayId = d.getDisplayId();
            DisplayInfo info = getDisplayInfo(displayId);
            modes.put(displayId, info.supportedModes);
            appModes.put(displayId, info.appsSupportedModes);
            defaultModes.put(displayId, info.getDefaultMode());
            r6 = r6 + 1;
            goto L3
        L5:
            DisplayDeviceConfig defaultDisplayConfig = DisplayModeDirector.m4075$$Nest$fgetmDisplayDeviceConfigProvider(this.this$0).getDisplayDeviceConfig(0);
            Object r7 = this.this$0.mLock;
            monitor-enter(r7);
            int size = modes.size();     // Catch: Throwable -> L10
            int i = 0;
        L8:
            if (i >= size) goto L12;
            DisplayModeDirector.m4089$$Nest$fgetmSupportedModesByDisplay(this.this$0).put(modes.keyAt(i), modes.valueAt(i));     // Catch: Throwable -> L10
            DisplayModeDirector.m4067$$Nest$fgetmAppSupportedModesByDisplay(this.this$0).put(appModes.keyAt(i), appModes.valueAt(i));     // Catch: Throwable -> L10
            DisplayModeDirector.m4072$$Nest$fgetmDefaultModeByDisplay(this.this$0).put(defaultModes.keyAt(i), defaultModes.valueAt(i));     // Catch: Throwable -> L10
            i = i + 1;     // Catch: Throwable -> L10
            goto L8
        L12:
            DisplayModeDirector.m4074$$Nest$fgetmDisplayDeviceConfigByDisplay(this.this$0).put(0, defaultDisplayConfig);     // Catch: Throwable -> L10
            monitor-exit(r7);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
            updateDisplayDeviceConfig(displayId);
            DisplayInfo displayInfo = getDisplayInfo(displayId);
            registerExternalDisplay(displayInfo);
            updateDisplayModes(displayId, displayInfo);
            updateHasArrSupport(displayId, displayInfo);
            updateLayoutLimitedFrameRate(displayId, displayInfo);
            updateUserSettingDisplayPreferredSize(displayInfo);
            updateDisplaysPeakRefreshRateAndResolution(displayInfo);
            if (displayInfo != null) goto L5;
            return;
        L5:
            if (displayInfo.type != 2) goto L9;
            SysOptBridge.getFactory().getDynamicRefreshRateService().onPhysicalDisplayStateChanged(displayId, true);
            return;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
            SysOptBridge.getFactory().getDynamicRefreshRateService().onPhysicalDisplayStateChanged(displayId, false);
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            DisplayModeDirector.m4089$$Nest$fgetmSupportedModesByDisplay(this.this$0).remove(displayId);     // Catch: Throwable -> L8
            DisplayModeDirector.m4067$$Nest$fgetmAppSupportedModesByDisplay(this.this$0).remove(displayId);     // Catch: Throwable -> L8
            DisplayModeDirector.m4072$$Nest$fgetmDefaultModeByDisplay(this.this$0).remove(displayId);     // Catch: Throwable -> L8
            DisplayModeDirector.m4074$$Nest$fgetmDisplayDeviceConfigByDisplay(this.this$0).remove(displayId);     // Catch: Throwable -> L8
            SettingsObserver.m4126$$Nest$mremoveRefreshRateSetting(DisplayModeDirector.m4088$$Nest$fgetmSettingsObserver(this.this$0), displayId);     // Catch: Throwable -> L8
            DisplayModeDirector.m4079$$Nest$fgetmHasArrSupport(this.this$0).delete(displayId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            updateLayoutLimitedFrameRate(displayId, null);
            removeUserSettingDisplayPreferredSize(displayId);
            removeDisplaysPeakRefreshRateAndResolution(displayId);
            unregisterExternalDisplay(displayId);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            updateDisplayDeviceConfig(displayId);
            DisplayInfo displayInfo = getDisplayInfo(displayId);
            updateHasArrSupport(displayId, displayInfo);
            updateDisplayModes(displayId, displayInfo);
            updateLayoutLimitedFrameRate(displayId, displayInfo);
            updateUserSettingDisplayPreferredSize(displayInfo);
        }

        private void registerExternalDisplay(DisplayInfo displayInfo) {
            if (displayInfo != null) goto L4;
            return;
        L4:
            if (displayInfo.type != 2) goto L20;
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            DisplayModeDirector.m4077$$Nest$fgetmExternalDisplaysConnected(this.this$0).add(Integer.valueOf(displayInfo.displayId));     // Catch: Throwable -> L11
            if (DisplayModeDirector.m4077$$Nest$fgetmExternalDisplaysConnected(this.this$0).size() != 1) goto L13;
            addDisplaysSynchronizedPeakRefreshRate();     // Catch: Throwable -> L11
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private void unregisterExternalDisplay(int displayId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.isExternalDisplayLocked(displayId) == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            DisplayModeDirector.m4077$$Nest$fgetmExternalDisplaysConnected(this.this$0).remove(Integer.valueOf(displayId));     // Catch: Throwable -> L8
            if (DisplayModeDirector.m4077$$Nest$fgetmExternalDisplaysConnected(this.this$0).isEmpty() == false) goto L13;
            removeDisplaysSynchronizedPeakRefreshRate();     // Catch: Throwable -> L8
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private DisplayInfo getDisplayInfo(int displayId) {
            DisplayInfo info = new DisplayInfo();
            if (DisplayModeDirector.m4081$$Nest$fgetmInjector(this.this$0).getDisplayInfo(displayId, info) == true) goto L7;
            return null;
        L7:
            return info;
        }

        private void updateLayoutLimitedFrameRate(int displayId, DisplayInfo info) {
            Vote refreshRateVote = null;
            Vote frameRateVote = null;
            if (info != null) goto L5;
        L7:
            this.mVotesStorage.updateVote(displayId, 15, refreshRateVote);
            this.mVotesStorage.updateVote(displayId, 16, frameRateVote);
            return;
        L5:
            if (info.layoutLimitedRefreshRate == null) goto L7;
            refreshRateVote = Vote.forPhysicalRefreshRates(info.layoutLimitedRefreshRate.min, info.layoutLimitedRefreshRate.max);
            frameRateVote = Vote.forRenderFrameRates(info.layoutLimitedRefreshRate.min, info.layoutLimitedRefreshRate.max);
            goto L7
        }

        private void removeUserSettingDisplayPreferredSize(int displayId) {
            if (DisplayModeDirector.m4085$$Nest$fgetmIsUserPreferredModeVoteEnabled(this.this$0) == true) goto L5;
            return;
        L5:
            this.mVotesStorage.updateVote(displayId, 4, null);
        }

        private void updateUserSettingDisplayPreferredSize(DisplayInfo info) {
            if (info != null) goto L4;
            return;
        L4:
            if (DisplayModeDirector.m4085$$Nest$fgetmIsUserPreferredModeVoteEnabled(this.this$0) == false) goto L21;
            Display.Mode preferredMode = findDisplayPreferredMode(info);
            if (preferredMode != null) goto L11;
            removeUserSettingDisplayPreferredSize(info.displayId);
            return;
        L11:
            if (info.type == 2) goto L13;
        L17:
            this.mVotesStorage.updateVote(info.displayId, 4, Vote.forSize(preferredMode.getPhysicalWidth(), preferredMode.getPhysicalHeight()));
            return;
        L13:
            if (DisplayModeDirector.m4076$$Nest$fgetmDisplayManagerFlags(this.this$0).isUserRefreshRateForExternalDisplayEnabled() == false) goto L17;
            if (isRefreshRateSynchronizationEnabled() == true) goto L17;
            this.mVotesStorage.updateVote(info.displayId, 4, Vote.forSizeAndPhysicalRefreshRatesRange(preferredMode.getPhysicalWidth(), preferredMode.getPhysicalHeight(), preferredMode.getPhysicalWidth(), preferredMode.getPhysicalHeight(), preferredMode.getRefreshRate(), preferredMode.getRefreshRate()));
            return;
        }

        private Display.Mode findDisplayPreferredMode(DisplayInfo info) {
            if (info.userPreferredModeId != (-1)) goto L5;
            return null;
        L5:
            Display.Mode[] r0 = info.supportedModes;
            int r1 = r0.length;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            Display.Mode mode = r0[r3];
            if (mode.getModeId() == info.userPreferredModeId) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return mode;
        L11:
            return null;
        }

        private void removeDisplaysPeakRefreshRateAndResolution(int displayId) {
            if (isExternalDisplayLimitModeEnabled() == true) goto L5;
            return;
        L5:
            this.mVotesStorage.updateVote(displayId, 13, null);
        }

        private void updateDisplaysPeakRefreshRateAndResolution(DisplayInfo info) {
            if (info != null) goto L4;
            return;
        L4:
            if (info.type == 2) goto L6;
            return;
        L6:
            if (isExternalDisplayLimitModeEnabled() == false) goto L12;
            this.mVotesStorage.updateVote(info.displayId, 13, Vote.forSizeAndPhysicalRefreshRatesRange(0, 0, this.mExternalDisplayPeakWidth, this.mExternalDisplayPeakHeight, 0.0f, this.mExternalDisplayPeakRefreshRate));
            return;
        }

        private void addDisplaysSynchronizedPeakRefreshRate() {
            if (isRefreshRateSynchronizationEnabled() == true) goto L5;
            return;
        L5:
            this.mVotesStorage.updateGlobalVote(11, Vote.forPhysicalRefreshRates(59.0f, 61.0f));
            this.mVotesStorage.updateGlobalVote(12, Vote.forRenderFrameRates(59.0f, 61.0f));
        }

        private void removeDisplaysSynchronizedPeakRefreshRate() {
            if (isRefreshRateSynchronizationEnabled() == true) goto L5;
            return;
        L5:
            this.mVotesStorage.updateGlobalVote(11, null);
            this.mVotesStorage.updateGlobalVote(12, null);
        }

        private void updateDisplayDeviceConfig(int displayId) {
            DisplayDeviceConfig config = DisplayModeDirector.m4075$$Nest$fgetmDisplayDeviceConfigProvider(this.this$0).getDisplayDeviceConfig(displayId);
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            DisplayModeDirector.m4074$$Nest$fgetmDisplayDeviceConfigByDisplay(this.this$0).put(displayId, config);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void updateDisplayModes(int displayId, DisplayInfo info) {
            if (info != null) goto L4;
            return;
        L4:
            boolean changed = false;
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (Arrays.equals((Object[]) DisplayModeDirector.m4089$$Nest$fgetmSupportedModesByDisplay(this.this$0).get(displayId), info.supportedModes) == true) goto L12;
            DisplayModeDirector.m4089$$Nest$fgetmSupportedModesByDisplay(this.this$0).put(displayId, info.supportedModes);     // Catch: Throwable -> L9
            changed = true;
        L12:
            if (Arrays.equals((Object[]) DisplayModeDirector.m4067$$Nest$fgetmAppSupportedModesByDisplay(this.this$0).get(displayId), info.appsSupportedModes) == true) goto L15;
            DisplayModeDirector.m4067$$Nest$fgetmAppSupportedModesByDisplay(this.this$0).put(displayId, info.appsSupportedModes);     // Catch: Throwable -> L9
            changed = true;
        L15:
            if (Objects.equals(DisplayModeDirector.m4072$$Nest$fgetmDefaultModeByDisplay(this.this$0).get(displayId), info.getDefaultMode()) == true) goto L17;
            changed = true;
            DisplayModeDirector.m4072$$Nest$fgetmDefaultModeByDisplay(this.this$0).put(displayId, info.getDefaultMode());     // Catch: Throwable -> L9
        L17:
            if (changed == false) goto L19;
            DisplayModeDirector.m4093$$Nest$mnotifyDesiredDisplayModeSpecsChangedLocked(this.this$0);     // Catch: Throwable -> L9
            SettingsObserver.m4131$$Nest$mupdateRefreshRateSettingLocked(DisplayModeDirector.m4088$$Nest$fgetmSettingsObserver(this.this$0), displayId);     // Catch: Throwable -> L9
        L19:
            monitor-exit(r1);     // Catch: Throwable -> L9
        }

        private void updateHasArrSupport(int displayId, DisplayInfo info) {
            if (info != null) goto L4;
            return;
        L4:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            DisplayModeDirector.m4079$$Nest$fgetmHasArrSupport(this.this$0).put(displayId, info.hasArrSupport);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public class HbmObserver implements DisplayManager.DisplayListener {
        private final DeviceConfigDisplaySettings mDeviceConfigDisplaySettings;
        private DisplayManagerInternal mDisplayManagerInternal;
        private final Handler mHandler;
        private final SparseBooleanArray mHbmActive;
        private final SparseIntArray mHbmMode;
        private final Injector mInjector;
        private int mRefreshRateInHbmHdr;
        private int mRefreshRateInHbmSunlight;
        private final VotesStorage mVotesStorage;
        final /* synthetic */ DisplayModeDirector this$0;

        HbmObserver(DisplayModeDirector this$0, Injector injector, VotesStorage votesStorage, Handler handler, DeviceConfigDisplaySettings displaySettings) {
            this.this$0 = this$0;
            this.mHbmMode = new SparseIntArray();
            this.mHbmActive = new SparseBooleanArray();
            this.mInjector = injector;
            this.mVotesStorage = votesStorage;
            this.mHandler = handler;
            this.mDeviceConfigDisplaySettings = displaySettings;
        }

        public void setupHdrRefreshRates(DisplayDeviceConfig displayDeviceConfig) {
            this.mRefreshRateInHbmHdr = DeviceConfigDisplaySettings.m4124$$Nest$mgetRefreshRateInHbmHdr(this.mDeviceConfigDisplaySettings, displayDeviceConfig);
            this.mRefreshRateInHbmSunlight = DeviceConfigDisplaySettings.m4125$$Nest$mgetRefreshRateInHbmSunlight(this.mDeviceConfigDisplaySettings, displayDeviceConfig);
        }

        public void observe() {
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            setupHdrRefreshRates(DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0));     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            this.mDisplayManagerInternal = this.mInjector.getDisplayManagerInternal();
            this.mInjector.registerDisplayListener(this, this.mHandler, 2, 1);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        int getRefreshRateInHbmSunlight() {
            return this.mRefreshRateInHbmSunlight;
        }

        int getRefreshRateInHbmHdr() {
            return this.mRefreshRateInHbmHdr;
        }

        public void onDeviceConfigRefreshRateInHbmSunlightChanged(int refreshRate) {
            if (refreshRate == this.mRefreshRateInHbmSunlight) goto L6;
            this.mRefreshRateInHbmSunlight = refreshRate;
            onDeviceConfigRefreshRateInHbmChanged();
            return;
        }

        public void onDeviceConfigRefreshRateInHbmHdrChanged(int refreshRate) {
            if (refreshRate == this.mRefreshRateInHbmHdr) goto L6;
            this.mRefreshRateInHbmHdr = refreshRate;
            onDeviceConfigRefreshRateInHbmChanged();
            return;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
            this.mVotesStorage.updateVote(displayId, 2, null);
            this.mHbmMode.delete(displayId);
            this.mHbmActive.delete(displayId);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            BrightnessInfo info = this.mInjector.getBrightnessInfo(displayId);
            if (info != null) goto L5;
            return;
        L5:
            int hbmMode = info.highBrightnessMode;
            if (hbmMode != 0) goto L8;
        L10:
            boolean isHbmActive = false;
        L12:
            if (hbmMode == this.mHbmMode.get(displayId)) goto L14;
        L16:
            this.mHbmMode.put(displayId, hbmMode);
            this.mHbmActive.put(displayId, isHbmActive);
            recalculateVotesForDisplay(displayId);
            return;
        L14:
            if (isHbmActive != this.mHbmActive.get(displayId)) goto L16;
            return;
        L8:
            if (info.adjustedBrightness <= info.highBrightnessTransitionPoint) goto L10;
            isHbmActive = true;
            goto L12
        }

        private void onDeviceConfigRefreshRateInHbmChanged() {
            int[] displayIds = this.mHbmMode.copyKeys();
            if (displayIds == null) goto L8;
            int r1 = displayIds.length;
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L10;
            int id = displayIds[r2];
            recalculateVotesForDisplay(id);
            r2 = r2 + 1;
            goto L6
        L10:
            return;
        }

        private void recalculateVotesForDisplay(int displayId) {
            Vote vote = null;
            if (this.mHbmActive.get(displayId, false) == false) goto L23;
            int hbmMode = this.mHbmMode.get(displayId, 0);
            if (hbmMode == 1) goto L7;
            if (hbmMode == 2) goto L20;
        L22:
            Slog.w(DisplayModeDirector.TAG, "Unexpected HBM mode " + hbmMode + " for display ID " + displayId);
            goto L23
        L20:
            if (this.mRefreshRateInHbmHdr <= 0) goto L22;
            vote = Vote.forPhysicalRefreshRates(this.mRefreshRateInHbmHdr, this.mRefreshRateInHbmHdr);
            goto L23
        L7:
            if (this.mRefreshRateInHbmSunlight <= 0) goto L9;
            vote = Vote.forPhysicalRefreshRates(this.mRefreshRateInHbmSunlight, this.mRefreshRateInHbmSunlight);
            goto L23
        L9:
            List<DisplayManagerInternal.RefreshRateLimitation> limits = this.mDisplayManagerInternal.getRefreshRateLimitations(displayId);
            int i = 0;
        L10:
            if (limits == null) goto L23;
            if (i >= limits.size()) goto L23;
            DisplayManagerInternal.RefreshRateLimitation limitation = limits.get(i);
            if (limitation.type == 1) goto L15;
            i = i + 1;
            goto L10
        L15:
            vote = Vote.forPhysicalRefreshRates(limitation.range.min, limitation.range.max);
        L23:
            this.mVotesStorage.updateVote(displayId, 2, vote);
        }

        void dumpLocked(PrintWriter pw) {
            pw.println("   HbmObserver");
            pw.println("     mHbmMode: " + this.mHbmMode);
            pw.println("     mHbmActive: " + this.mHbmActive);
            pw.println("     mRefreshRateInHbmSunlight: " + this.mRefreshRateInHbmSunlight);
            pw.println("     mRefreshRateInHbmHdr: " + this.mRefreshRateInHbmHdr);
        }
    }

    interface Injector {
        public static final Uri MIN_REFRESH_RATE_URI = null;
        public static final Uri PEAK_REFRESH_RATE_URI = null;

        BrightnessInfo getBrightnessInfo(int r1);

        DeviceConfigInterface getDeviceConfig();

        Display getDisplay(int r1);

        boolean getDisplayInfo(int r1, DisplayInfo r2);

        DisplayManagerInternal getDisplayManagerInternal();

        Display[] getDisplays();

        SensorManagerInternal getSensorManagerInternal();

        StatusBarManagerInternal getStatusBarManagerInternal();

        VotesStatsReporter getVotesStatsReporter();

        boolean isDozeState(Display r1);

        void registerDisplayListener(DisplayManager.DisplayListener r1, Handler r2);

        void registerDisplayListener(DisplayManager.DisplayListener r1, Handler r2, long r3);

        void registerDisplayListener(DisplayManager.DisplayListener r1, Handler r2, long r3, long r5);

        void registerMinRefreshRateObserver(ContentResolver r1, ContentObserver r2);

        void registerPeakRefreshRateObserver(ContentResolver r1, ContentObserver r2);

        boolean registerThermalServiceListener(IThermalEventListener r1);

        boolean supportsFrameRateOverride();

        void unregisterThermalServiceListener(IThermalEventListener r1);

        static {
            PEAK_REFRESH_RATE_URI = Settings.System.getUriFor("peak_refresh_rate");
            MIN_REFRESH_RATE_URI = Settings.System.getUriFor("min_refresh_rate");
        }
    }

    static class RealInjector implements Injector {
        private final Context mContext;
        private DisplayManager mDisplayManager;

        RealInjector(Context context) {
            this.mContext = context;
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public DeviceConfigInterface getDeviceConfig() {
            return DeviceConfigInterface.REAL;
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public void registerPeakRefreshRateObserver(ContentResolver cr, ContentObserver observer) {
            cr.registerContentObserver(Injector.PEAK_REFRESH_RATE_URI, false, observer, -1);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public void registerMinRefreshRateObserver(ContentResolver cr, ContentObserver observer) {
            cr.registerContentObserver(Injector.MIN_REFRESH_RATE_URI, false, observer, -1);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public void registerDisplayListener(DisplayManager.DisplayListener listener, Handler handler) {
            getDisplayManager().registerDisplayListener(listener, handler);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public void registerDisplayListener(DisplayManager.DisplayListener listener, Handler handler, long flags) {
            getDisplayManager().registerDisplayListener(listener, handler, flags);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public void registerDisplayListener(DisplayManager.DisplayListener listener, Handler handler, long flags, long privateFlags) {
            getDisplayManager().registerDisplayListener(listener, handler, flags, privateFlags);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public Display getDisplay(int displayId) {
            return getDisplayManager().getDisplay(displayId);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public Display[] getDisplays() {
            return getDisplayManager().getDisplays("android.hardware.display.category.ALL_INCLUDING_DISABLED");
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public boolean getDisplayInfo(int displayId, DisplayInfo displayInfo) {
            Display display = getDisplayManager().getDisplay(displayId);
            if (display != null) goto L7;
            return false;
        L7:
            return display.getDisplayInfo(displayInfo);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public BrightnessInfo getBrightnessInfo(int displayId) {
            Display display = getDisplayManager().getDisplay(displayId);
            if (display != null) goto L5;
            return null;
        L5:
            return display.getBrightnessInfo();
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public boolean isDozeState(Display d) {
            if (d != null) goto L6;
            return false;
        L6:
            return Display.isDozeState(d.getState());
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public boolean registerThermalServiceListener(IThermalEventListener listener) {
            IThermalService thermalService = getThermalService();
            if (thermalService != null) goto L13;
            Slog.w(DisplayModeDirector.TAG, "Could not observe thermal status. Service not available");
            return false;
        L13:
            thermalService.registerThermalEventListenerWithType(listener, 3);     // Catch: RemoteException -> L10
            return true;
        L10:
            e = move-exception;
            Slog.e(DisplayModeDirector.TAG, "Failed to register thermal status listener", e);
            return false;
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public void unregisterThermalServiceListener(IThermalEventListener listener) {
            IThermalService thermalService = getThermalService();
            if (thermalService != null) goto L10;
            Slog.w(DisplayModeDirector.TAG, "Could not unregister thermal status. Service not available");
        L10:
            thermalService.unregisterThermalEventListener(listener);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Slog.e(DisplayModeDirector.TAG, "Failed to unregister thermal status listener", e);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public boolean supportsFrameRateOverride() {
            return SurfaceFlingerProperties.enable_frame_rate_override().orElse(true).booleanValue();
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public DisplayManagerInternal getDisplayManagerInternal() {
            return (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public StatusBarManagerInternal getStatusBarManagerInternal() {
            return (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public SensorManagerInternal getSensorManagerInternal() {
            return (SensorManagerInternal) LocalServices.getService(SensorManagerInternal.class);
        }

        @Override // com.android.server.display.mode.DisplayModeDirector.Injector
        public VotesStatsReporter getVotesStatsReporter() {
            return new VotesStatsReporter(supportsFrameRateOverride());
        }

        private DisplayManager getDisplayManager() {
            if (this.mDisplayManager != null) goto L6;
            this.mDisplayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        L6:
            return this.mDisplayManager;
        }

        private IThermalService getThermalService() {
            return IThermalService.Stub.asInterface(ServiceManager.getService("thermalservice"));
        }
    }

    final class SettingsObserver extends ContentObserver {
        private final Context mContext;
        private float mDefaultPeakRefreshRate;
        private float mDefaultRefreshRate;
        private final DisplayManager.DisplayListener mDisplayListener;
        private final Handler mHandler;
        private boolean mIsLowPower;
        private final Uri mLowPowerModeSetting;
        private final Uri mMatchContentFrameRateSetting;
        private final Uri mMinRefreshRateSetting;
        private final boolean mPeakRefreshRatePhysicalLimitEnabled;
        private final Uri mPeakRefreshRateSetting;
        private final boolean mVsyncLowPowerVoteEnabled;
        final /* synthetic */ DisplayModeDirector this$0;

        /* JADX INFO: renamed from: -$$Nest$mremoveRefreshRateSetting, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4126$$Nest$mremoveRefreshRateSetting(SettingsObserver r0, int r1) {
            r0.removeRefreshRateSetting(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateLowPowerModeAllowedModesLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4127$$Nest$mupdateLowPowerModeAllowedModesLocked(SettingsObserver r0) {
            r0.updateLowPowerModeAllowedModesLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateModeSwitchingTypeSettingLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4128$$Nest$mupdateModeSwitchingTypeSettingLocked(SettingsObserver r0) {
            r0.updateModeSwitchingTypeSettingLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateRefreshRateSettingLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4129$$Nest$mupdateRefreshRateSettingLocked(SettingsObserver r0) {
            r0.updateRefreshRateSettingLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateRefreshRateSettingLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4130$$Nest$mupdateRefreshRateSettingLocked(SettingsObserver r0, float r1, float r2, float r3, int r4) {
            r0.updateRefreshRateSettingLocked(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateRefreshRateSettingLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4131$$Nest$mupdateRefreshRateSettingLocked(SettingsObserver r0, int r1) {
            r0.updateRefreshRateSettingLocked(r1);
        }

        SettingsObserver(DisplayModeDirector this$0, Context context, Handler handler, DisplayManagerFlags flags) {
            this.this$0 = this$0;
            super(handler);
            this.mPeakRefreshRateSetting = Settings.System.getUriFor("peak_refresh_rate");
            this.mMinRefreshRateSetting = Settings.System.getUriFor("min_refresh_rate");
            this.mLowPowerModeSetting = Settings.Global.getUriFor("low_power");
            this.mMatchContentFrameRateSetting = Settings.Secure.getUriFor("match_content_frame_rate");
            this.mIsLowPower = false;
            this.mDisplayListener = new AnonymousClass1(this);
            this.mContext = context;
            this.mHandler = handler;
            this.mVsyncLowPowerVoteEnabled = flags.isVsyncLowPowerVoteEnabled();
            this.mPeakRefreshRatePhysicalLimitEnabled = flags.isPeakRefreshRatePhysicalLimitEnabled();
            setRefreshRates(null, false);
        }

        void setRefreshRates(DisplayDeviceConfig displayDeviceConfig, boolean attemptReadFromFeatureParams) {
            if (displayDeviceConfig != null) goto L4;
            RefreshRateData refreshRateData = null;
        L5:
            setDefaultPeakRefreshRate(displayDeviceConfig, attemptReadFromFeatureParams);
            if (refreshRateData != null) goto L8;
            float r1 = this.mContext.getResources().getInteger(R.integer.config_demo_pointing_not_aligned_duration_millis);
        L9:
            this.mDefaultRefreshRate = r1;
            return;
        L8:
            r1 = refreshRateData.defaultRefreshRate;
            goto L9
        L4:
            refreshRateData = displayDeviceConfig.getRefreshRateData();
            goto L5
        }

        public void observe() {
            ContentResolver cr = this.mContext.getContentResolver();
            DisplayModeDirector.m4081$$Nest$fgetmInjector(this.this$0).registerPeakRefreshRateObserver(cr, this);
            DisplayModeDirector.m4081$$Nest$fgetmInjector(this.this$0).registerMinRefreshRateObserver(cr, this);
            cr.registerContentObserver(this.mLowPowerModeSetting, false, this, -1);
            cr.registerContentObserver(this.mMatchContentFrameRateSetting, false, this, -1);
            DisplayModeDirector.m4081$$Nest$fgetmInjector(this.this$0).registerDisplayListener(this.mDisplayListener, this.mHandler);
            float deviceConfigDefaultPeakRefresh = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getPeakRefreshRateDefault();
            if (deviceConfigDefaultPeakRefresh == (-1.0f)) goto L5;
            this.mDefaultPeakRefreshRate = deviceConfigDefaultPeakRefresh;
        L5:
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            updateRefreshRateSettingLocked();     // Catch: Throwable -> L10
            updateLowPowerModeSettingLocked();     // Catch: Throwable -> L10
            updateModeSwitchingTypeSettingLocked();     // Catch: Throwable -> L10
            monitor-exit(r2);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void setDefaultRefreshRate(float refreshRate) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.mDefaultRefreshRate = refreshRate;     // Catch: Throwable -> L7
            updateRefreshRateSettingLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onDeviceConfigDefaultPeakRefreshRateChanged(Float defaultPeakRefreshRate) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            if (defaultPeakRefreshRate != null) goto L9;
            setDefaultPeakRefreshRate(DisplayModeDirector.m4071$$Nest$fgetmDefaultDisplayDeviceConfig(this.this$0), false);     // Catch: Throwable -> L6
        L11:
            updateRefreshRateSettingLocked();     // Catch: Throwable -> L6
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L9:
            if (this.mDefaultPeakRefreshRate == defaultPeakRefreshRate.floatValue()) goto L11;
            this.mDefaultPeakRefreshRate = defaultPeakRefreshRate.floatValue();     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mPeakRefreshRateSetting.equals(uri) == true) goto L17;
            if (this.mMinRefreshRateSetting.equals(uri) == true) goto L17;
            if (this.mLowPowerModeSetting.equals(uri) == false) goto L15;
            updateLowPowerModeSettingLocked();     // Catch: Throwable -> L12
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L15:
            if (this.mMatchContentFrameRateSetting.equals(uri) == false) goto L18;
            updateModeSwitchingTypeSettingLocked();     // Catch: Throwable -> L12
        L17:
            updateRefreshRateSettingLocked();     // Catch: Throwable -> L12
            goto L18
        }

        float getDefaultRefreshRate() {
            return this.mDefaultRefreshRate;
        }

        float getDefaultPeakRefreshRate() {
            return this.mDefaultPeakRefreshRate;
        }

        private void setDefaultPeakRefreshRate(DisplayDeviceConfig displayDeviceConfig, boolean attemptReadFromFeatureParams) {
            float defaultPeakRefreshRate = -1.0f;
            if (attemptReadFromFeatureParams == false) goto L8;
            defaultPeakRefreshRate = DisplayModeDirector.m4069$$Nest$fgetmConfigParameterProvider(this.this$0).getPeakRefreshRateDefault();     // Catch: Exception -> L6
        L8:
            if (defaultPeakRefreshRate != (-1.0f)) goto L13;
            if (displayDeviceConfig != null) goto L11;
            float r1 = this.mContext.getResources().getInteger(R.integer.config_default_cellular_usage_setting);
        L12:
            defaultPeakRefreshRate = r1;
            goto L13
        L11:
            r1 = displayDeviceConfig.getRefreshRateData().defaultPeakRefreshRate;
        L13:
            this.mDefaultPeakRefreshRate = defaultPeakRefreshRate;
        }

        private void updateLowPowerModeSettingLocked() {
            boolean r2 = false;
            if (Settings.Global.getInt(this.mContext.getContentResolver(), "low_power", 0) == 0) goto L5;
            r2 = true;
        L5:
            this.mIsLowPower = r2;
            if (this.mIsLowPower == false) goto L8;
            Vote vote = Vote.forRenderFrameRates(0.0f, 60.0f);
        L9:
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateGlobalVote(19, vote);
            DisplayModeDirector.m4068$$Nest$fgetmBrightnessObserver(this.this$0).onLowPowerModeEnabledLocked(this.mIsLowPower);
            updateLowPowerModeAllowedModesLocked();
            return;
        L8:
            vote = null;
            goto L9
        }

        private void updateLowPowerModeAllowedModesLocked() {
            if (this.mVsyncLowPowerVoteEnabled == true) goto L6;
            return;
        L6:
            if (this.mIsLowPower == false) goto L16;
            int i = 0;
        L9:
            if (i >= DisplayModeDirector.m4074$$Nest$fgetmDisplayDeviceConfigByDisplay(this.this$0).size()) goto L21;
            DisplayDeviceConfig config = (DisplayDeviceConfig) DisplayModeDirector.m4074$$Nest$fgetmDisplayDeviceConfigByDisplay(this.this$0).valueAt(i);
            if (config == null) goto L14;
            List<SupportedModeData> supportedModes = config.getRefreshRateData().lowPowerSupportedModes;
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(DisplayModeDirector.m4074$$Nest$fgetmDisplayDeviceConfigByDisplay(this.this$0).keyAt(i), 18, Vote.forSupportedRefreshRates(supportedModes));
        L14:
            i = i + 1;
            goto L9
        L21:
            return;
        L16:
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).removeAllVotesForPriority(18);
        }

        private void updateRefreshRateSettingLocked() {
            int i = 0;
        L4:
            if (i >= DisplayModeDirector.m4089$$Nest$fgetmSupportedModesByDisplay(this.this$0).size()) goto L7;
            updateRefreshRateSettingLocked(DisplayModeDirector.m4089$$Nest$fgetmSupportedModesByDisplay(this.this$0).keyAt(i));
            i = i + 1;
            goto L4
        }

        private void updateRefreshRateSettingLocked(int displayId) {
            ContentResolver cr = this.mContext.getContentResolver();
            if (DisplayModeDirector.m4089$$Nest$fgetmSupportedModesByDisplay(this.this$0).contains(displayId) == true) goto L6;
            Slog.e(DisplayModeDirector.TAG, "Cannot update refresh rate setting: no supported modes for display " + displayId);
            return;
        L6:
            float highestRefreshRate = DisplayModeDirector.m4092$$Nest$mgetMaxRefreshRateLocked(this.this$0, displayId);
            float minRefreshRate = Settings.System.getFloatForUser(cr, "min_refresh_rate", 0.0f, -2);
            if (Float.isInfinite(minRefreshRate) == false) goto L9;
            minRefreshRate = highestRefreshRate;
        L9:
            float peakRefreshRate = Settings.System.getFloatForUser(cr, "peak_refresh_rate", this.mDefaultPeakRefreshRate, -2);
            if (Float.isInfinite(peakRefreshRate) == false) goto L12;
            peakRefreshRate = highestRefreshRate;
        L12:
            updateRefreshRateSettingLocked(minRefreshRate, peakRefreshRate, this.mDefaultRefreshRate, displayId);
        }

        private void updateRefreshRateSettingLocked(float minRefreshRate, float peakRefreshRate, float defaultRefreshRate, int displayId) {
            if (this.this$0.isExternalDisplayLocked(displayId) == true) goto L5;
            Vote defaultVote = null;
            if (this.mPeakRefreshRatePhysicalLimitEnabled == false) goto L16;
            if (peakRefreshRate != 0.0f) goto L13;
            Vote peakVote = null;
        L14:
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 9, peakVote);
            goto L16
        L13:
            peakVote = Vote.forPhysicalRefreshRates(0.0f, Math.max(minRefreshRate, peakRefreshRate));
        L16:
            if (peakRefreshRate != 0.0f) goto L18;
            Vote peakRenderVote = null;
        L19:
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 10, peakRenderVote);
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 3, Vote.forRenderFrameRates(minRefreshRate, Float.POSITIVE_INFINITY));
            if (defaultRefreshRate == 0.0f) goto L23;
            defaultVote = Vote.forRenderFrameRates(0.0f, defaultRefreshRate);
        L23:
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateGlobalVote(0, defaultVote);
            if (peakRefreshRate != 0.0f) goto L29;
            if (defaultRefreshRate != 0.0f) goto L29;
            Slog.e(DisplayModeDirector.TAG, "Default and peak refresh rates are both 0. One of them should be set to a valid value.");
            float maxRefreshRate = minRefreshRate;
        L35:
            if (displayId != 0) goto L39;
            DisplayModeDirector.m4068$$Nest$fgetmBrightnessObserver(this.this$0).onRefreshRateSettingChangedLocked(minRefreshRate, maxRefreshRate);
            return;
        L39:
            return;
        L29:
            if (peakRefreshRate != 0.0f) goto L32;
            maxRefreshRate = defaultRefreshRate;
            goto L35
        L32:
            if (defaultRefreshRate != 0.0f) goto L34;
            maxRefreshRate = peakRefreshRate;
            goto L35
        L34:
            maxRefreshRate = Math.min(defaultRefreshRate, peakRefreshRate);
            goto L35
        L18:
            peakRenderVote = Vote.forRenderFrameRates(0.0f, Math.max(minRefreshRate, peakRefreshRate));
            goto L19
        L5:
            if (DisplayModeDirector.m4086$$Nest$fgetmLoggingEnabled(this.this$0) == false) goto L38;
            Slog.d(DisplayModeDirector.TAG, "skip updateRefreshRateSettingLocked for external display " + displayId);
            return;
        }

        private void removeRefreshRateSetting(int displayId) {
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 9, null);
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 10, null);
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 3, null);
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, 0, null);
        }

        private void updateModeSwitchingTypeSettingLocked() {
            ContentResolver cr = this.mContext.getContentResolver();
            int switchingType = Settings.Secure.getIntForUser(cr, "match_content_frame_rate", DisplayModeDirector.m4087$$Nest$fgetmModeSwitchingType(this.this$0), -2);
            if (switchingType == DisplayModeDirector.m4087$$Nest$fgetmModeSwitchingType(this.this$0)) goto L6;
            DisplayModeDirector.m4091$$Nest$fputmModeSwitchingType(this.this$0, switchingType);
            DisplayModeDirector.m4093$$Nest$mnotifyDesiredDisplayModeSpecsChangedLocked(this.this$0);
            return;
        }

        public void dumpLocked(PrintWriter pw) {
            pw.println("  SettingsObserver");
            pw.println("    mDefaultRefreshRate: " + this.mDefaultRefreshRate);
            pw.println("    mDefaultPeakRefreshRate: " + this.mDefaultPeakRefreshRate);
        }
    }

    private class UdfpsObserver extends IUdfpsRefreshRateRequestCallback.Stub {
        private final SparseBooleanArray mAuthenticationPossible;
        private final SparseBooleanArray mUdfpsRefreshRateEnabled;
        final /* synthetic */ DisplayModeDirector this$0;

        /* synthetic */ UdfpsObserver(DisplayModeDirector r1, DisplayModeDirectorIA r2) {
            this(r1);
        }

        private UdfpsObserver(DisplayModeDirector r1) {
            this.this$0 = r1;
            this.mUdfpsRefreshRateEnabled = new SparseBooleanArray();
            this.mAuthenticationPossible = new SparseBooleanArray();
        }

        public void observe() {
            StatusBarManagerInternal statusBar = DisplayModeDirector.m4081$$Nest$fgetmInjector(this.this$0).getStatusBarManagerInternal();
            if (statusBar != null) goto L5;
            return;
        L5:
            boolean ignoreUdfpsVote = DisplayModeDirector.m4070$$Nest$fgetmContext(this.this$0).getResources().getBoolean(R.bool.config_isDisplayHingeAlwaysSeparating);
            if (ignoreUdfpsVote == true) goto L9;
            statusBar.setUdfpsRefreshRateCallback(this);
            return;
        }

        public void onRequestEnabled(int displayId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.mUdfpsRefreshRateEnabled.put(displayId, true);     // Catch: Throwable -> L7
            updateVoteLocked(displayId, true, 23);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onRequestDisabled(int displayId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.mUdfpsRefreshRateEnabled.put(displayId, false);     // Catch: Throwable -> L7
            updateVoteLocked(displayId, false, 23);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onAuthenticationPossible(int displayId, boolean isPossible) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.mAuthenticationPossible.put(displayId, isPossible);     // Catch: Throwable -> L7
            updateVoteLocked(displayId, isPossible, 14);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void updateVoteLocked(int displayId, boolean enabled, int votePriority) {
            if (enabled == false) goto L4;
            float maxRefreshRate = DisplayModeDirector.m4092$$Nest$mgetMaxRefreshRateLocked(this.this$0, displayId);
            Vote vote = Vote.forPhysicalRefreshRates(maxRefreshRate, maxRefreshRate);
        L5:
            DisplayModeDirector.m4090$$Nest$fgetmVotesStorage(this.this$0).updateVote(displayId, votePriority, vote);
            return;
        L4:
            vote = null;
            goto L5
        }

        void dumpLocked(PrintWriter pw) {
            pw.println("  UdfpsObserver");
            pw.println("    mUdfpsRefreshRateEnabled: ");
            int i = 0;
        L4:
            if (i >= this.mUdfpsRefreshRateEnabled.size()) goto L10;
            int displayId = this.mUdfpsRefreshRateEnabled.keyAt(i);
            if (this.mUdfpsRefreshRateEnabled.valueAt(i) == false) goto L8;
            String enabled = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
        L9:
            pw.println("      Display " + displayId + ": " + enabled);
            i = i + 1;
            goto L4
        L8:
            enabled = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
            goto L9
        L10:
            pw.println("    mAuthenticationPossible: ");
            int i2 = 0;
        L12:
            if (i2 >= this.mAuthenticationPossible.size()) goto L19;
            int displayId2 = this.mAuthenticationPossible.keyAt(i2);
            if (this.mAuthenticationPossible.valueAt(i2) == false) goto L16;
            String isPossible = "possible";
        L17:
            pw.println("      Display " + displayId2 + ": " + isPossible);
            i2 = i2 + 1;
            goto L12
        L16:
            isPossible = "impossible";
            goto L17
        }
    }

    public static /* synthetic */ void $r8$lambda$CBSdi5wPAhAASfeb2bCpd2owPvs(DisplayModeDirector r0) {
        r0.notifyDesiredDisplayModeSpecsChangedLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppSupportedModesByDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4067$$Nest$fgetmAppSupportedModesByDisplay(DisplayModeDirector r0) {
        return r0.mAppSupportedModesByDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBrightnessObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ BrightnessObserver m4068$$Nest$fgetmBrightnessObserver(DisplayModeDirector r0) {
        return r0.mBrightnessObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfigParameterProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceConfigParameterProvider m4069$$Nest$fgetmConfigParameterProvider(DisplayModeDirector r0) {
        return r0.mConfigParameterProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m4070$$Nest$fgetmContext(DisplayModeDirector r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultDisplayDeviceConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayDeviceConfig m4071$$Nest$fgetmDefaultDisplayDeviceConfig(DisplayModeDirector r0) {
        return r0.mDefaultDisplayDeviceConfig;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultModeByDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4072$$Nest$fgetmDefaultModeByDisplay(DisplayModeDirector r0) {
        return r0.mDefaultModeByDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceConfigDisplaySettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceConfigDisplaySettings m4073$$Nest$fgetmDeviceConfigDisplaySettings(DisplayModeDirector r0) {
        return r0.mDeviceConfigDisplaySettings;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayDeviceConfigByDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4074$$Nest$fgetmDisplayDeviceConfigByDisplay(DisplayModeDirector r0) {
        return r0.mDisplayDeviceConfigByDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayDeviceConfigProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayDeviceConfigProvider m4075$$Nest$fgetmDisplayDeviceConfigProvider(DisplayModeDirector r0) {
        return r0.mDisplayDeviceConfigProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayManagerFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManagerFlags m4076$$Nest$fgetmDisplayManagerFlags(DisplayModeDirector r0) {
        return r0.mDisplayManagerFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExternalDisplaysConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m4077$$Nest$fgetmExternalDisplaysConnected(DisplayModeDirector r0) {
        return r0.mExternalDisplaysConnected;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayModeDirectorHandler m4078$$Nest$fgetmHandler(DisplayModeDirector r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHasArrSupport, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m4079$$Nest$fgetmHasArrSupport(DisplayModeDirector r0) {
        return r0.mHasArrSupport;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHbmObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ HbmObserver m4080$$Nest$fgetmHbmObserver(DisplayModeDirector r0) {
        return r0.mHbmObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m4081$$Nest$fgetmInjector(DisplayModeDirector r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsDisplayResolutionRangeVotingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4082$$Nest$fgetmIsDisplayResolutionRangeVotingEnabled(DisplayModeDirector r0) {
        return r0.mIsDisplayResolutionRangeVotingEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsDisplaysRefreshRatesSynchronizationEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4083$$Nest$fgetmIsDisplaysRefreshRatesSynchronizationEnabled(DisplayModeDirector r0) {
        return r0.mIsDisplaysRefreshRatesSynchronizationEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsExternalDisplayLimitModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4084$$Nest$fgetmIsExternalDisplayLimitModeEnabled(DisplayModeDirector r0) {
        return r0.mIsExternalDisplayLimitModeEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsUserPreferredModeVoteEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4085$$Nest$fgetmIsUserPreferredModeVoteEnabled(DisplayModeDirector r0) {
        return r0.mIsUserPreferredModeVoteEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLoggingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4086$$Nest$fgetmLoggingEnabled(DisplayModeDirector r0) {
        return r0.mLoggingEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModeSwitchingType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4087$$Nest$fgetmModeSwitchingType(DisplayModeDirector r0) {
        return r0.mModeSwitchingType;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettingsObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ SettingsObserver m4088$$Nest$fgetmSettingsObserver(DisplayModeDirector r0) {
        return r0.mSettingsObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportedModesByDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4089$$Nest$fgetmSupportedModesByDisplay(DisplayModeDirector r0) {
        return r0.mSupportedModesByDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVotesStorage, reason: not valid java name */
    static /* bridge */ /* synthetic */ VotesStorage m4090$$Nest$fgetmVotesStorage(DisplayModeDirector r0) {
        return r0.mVotesStorage;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmModeSwitchingType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4091$$Nest$fputmModeSwitchingType(DisplayModeDirector r0, int r1) {
        r0.mModeSwitchingType = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMaxRefreshRateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m4092$$Nest$mgetMaxRefreshRateLocked(DisplayModeDirector r0, int r1) {
        return r0.getMaxRefreshRateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyDesiredDisplayModeSpecsChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4093$$Nest$mnotifyDesiredDisplayModeSpecsChangedLocked(DisplayModeDirector r0) {
        r0.notifyDesiredDisplayModeSpecsChangedLocked();
    }

    public DisplayModeDirector(Context context, Handler handler, DisplayManagerFlags displayManagerFlags, DisplayDeviceConfigProvider displayDeviceConfigProvider) {
        this(context, handler, new RealInjector(context), displayManagerFlags, displayDeviceConfigProvider);
    }

    public DisplayModeDirector(Context context, Handler handler, Injector injector, DisplayManagerFlags displayManagerFlags, DisplayDeviceConfigProvider displayDeviceConfigProvider) {
        this.mLock = new Object();
        this.mDisplayDeviceConfigByDisplay = new SparseArray();
        this.mExternalDisplaysConnected = new HashSet();
        this.mModeSwitchingType = 1;
        this.mIsDisplayResolutionRangeVotingEnabled = displayManagerFlags.isDisplayResolutionRangeVotingEnabled();
        this.mIsUserPreferredModeVoteEnabled = displayManagerFlags.isUserPreferredModeVoteEnabled();
        this.mIsExternalDisplayLimitModeEnabled = displayManagerFlags.isExternalDisplayLimitModeEnabled();
        this.mIsDisplaysRefreshRatesSynchronizationEnabled = displayManagerFlags.isDisplaysRefreshRatesSynchronizationEnabled();
        this.mIsBackUpSmoothDisplayAndForcePeakRefreshRateEnabled = displayManagerFlags.isBackUpSmoothDisplayAndForcePeakRefreshRateEnabled();
        this.mHasArrSupportFlagEnabled = displayManagerFlags.hasArrSupportFlag();
        this.mDisplayManagerFlags = displayManagerFlags;
        this.mDisplayDeviceConfigProvider = displayDeviceConfigProvider;
        this.mContext = context;
        this.mHandler = new DisplayModeDirectorHandler(this, handler.getLooper());
        this.mInjector = injector;
        this.mVotesStatsReporter = injector.getVotesStatsReporter();
        this.mSupportedModesByDisplay = new SparseArray();
        this.mAppSupportedModesByDisplay = new SparseArray();
        this.mDefaultModeByDisplay = new SparseArray();
        this.mHasArrSupport = new SparseBooleanArray();
        this.mAppRequestObserver = new AppRequestObserver(this, displayManagerFlags);
        this.mConfigParameterProvider = new DeviceConfigParameterProvider(injector.getDeviceConfig());
        DisplayModeDirectorIA r1 = null;
        this.mDeviceConfigDisplaySettings = new DeviceConfigDisplaySettings(this, r1);
        this.mSettingsObserver = new SettingsObserver(this, context, handler, displayManagerFlags);
        this.mBrightnessObserver = new BrightnessObserver(this, context, handler, injector, displayManagerFlags);
        this.mDefaultDisplayDeviceConfig = null;
        this.mUdfpsObserver = new UdfpsObserver(this, r1);
        this.mVotesStorage = new VotesStorage(new DisplayModeDirector$$ExternalSyntheticLambda0(this), this.mVotesStatsReporter);
        this.mDisplayObserver = new DisplayObserver(this, context, handler, this.mVotesStorage, injector);
        this.mSensorObserver = new ProximitySensorObserver(this.mVotesStorage, injector);
        this.mSkinThermalStatusObserver = new SkinThermalStatusObserver(injector, this.mVotesStorage);
        this.mModeChangeObserver = new ModeChangeObserver(this.mVotesStorage, injector, handler.getLooper());
        this.mHbmObserver = new HbmObserver(this, injector, this.mVotesStorage, BackgroundThread.getHandler(), this.mDeviceConfigDisplaySettings);
        if (displayManagerFlags.isRestrictDisplayModesEnabled() == false) goto L5;
        this.mSystemRequestObserver = new SystemRequestObserver(this.mVotesStorage);
    L6:
        this.mAlwaysRespectAppRequest = false;
        this.mSupportsFrameRateOverride = injector.supportsFrameRateOverride();
        return;
    L5:
        this.mSystemRequestObserver = null;
        goto L6
    }

    public void start(SensorManager sensorManager) {
        this.mDisplayObserver.observe();
        this.mSettingsObserver.observe();
        BrightnessObserver.m4111$$Nest$mobserve(this.mBrightnessObserver, sensorManager);
        this.mSensorObserver.observe();
        this.mHbmObserver.observe();
        this.mSkinThermalStatusObserver.observe();
        if (this.mDisplayManagerFlags.isDisplayConfigErrorHalEnabled() == false) goto L5;
        this.mModeChangeObserver.observe();
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        notifyDesiredDisplayModeSpecsChangedLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void onBootCompleted() {
        this.mUdfpsObserver.observe();
    }

    public void setLoggingEnabled(boolean loggingEnabled) {
        if (this.mLoggingEnabled != loggingEnabled) goto L5;
        return;
    L5:
        this.mLoggingEnabled = loggingEnabled;
        BrightnessObserver.m4116$$Nest$msetLoggingEnabled(this.mBrightnessObserver, loggingEnabled);
        this.mSkinThermalStatusObserver.setLoggingEnabled(loggingEnabled);
        this.mVotesStorage.setLoggingEnabled(loggingEnabled);
    }

    public DesiredDisplayModeSpecs getDesiredDisplayModeSpecs(int displayId) {
        Object r3 = this.mLock;
        monitor-enter(r3);
        SparseArray<Vote> votes = this.mVotesStorage.getVotes(displayId);     // Catch: Throwable -> L17
        Display.Mode[] modes = this.mSupportedModesByDisplay.get(displayId);     // Catch: Throwable -> L17
        Display.Mode defaultMode = this.mDefaultModeByDisplay.get(displayId);     // Catch: Throwable -> L17
        if (modes == null) goto L57;
        if (defaultMode == null) goto L57;
        List<Display.Mode> availableModes = new ArrayList();     // Catch: Throwable -> L17
        availableModes.add(defaultMode);     // Catch: Throwable -> L17
        VoteSummary primarySummary = new VoteSummary(this.mIsDisplayResolutionRangeVotingEnabled, isVrrSupportedLocked(displayId), this.mLoggingEnabled, this.mSupportsFrameRateOverride);     // Catch: Throwable -> L17
        int lowestConsideredPriority = 0;
        int highestConsideredPriority = 23;
        if (this.mAlwaysRespectAppRequest == false) goto L11;
        lowestConsideredPriority = 5;
        highestConsideredPriority = 7;
    L11:
        if (lowestConsideredPriority > highestConsideredPriority) goto L23;
        primarySummary.applyVotes(votes, lowestConsideredPriority, highestConsideredPriority);     // Catch: Throwable -> L17
        primarySummary.adjustSize(defaultMode, modes);     // Catch: Throwable -> L17
        availableModes = primarySummary.filterModes(modes);     // Catch: Throwable -> L17
        if (availableModes.isEmpty() == false) goto L15;
        if (this.mLoggingEnabled == false) goto L22;
        Slog.w(TAG, "Couldn't find available modes with lowest priority set to " + Vote.priorityToString(lowestConsideredPriority) + " and with the following summary: " + primarySummary);     // Catch: Throwable -> L17
    L22:
        lowestConsideredPriority = lowestConsideredPriority + 1;     // Catch: Throwable -> L17
        goto L11
    L15:
        if (this.mLoggingEnabled == false) goto L23;
        Slog.w(TAG, "Found available modes=" + availableModes + " with lowest priority considered " + Vote.priorityToString(lowestConsideredPriority) + " and summary: " + primarySummary);     // Catch: Throwable -> L17
    L23:
        VoteSummary appRequestSummary = new VoteSummary(this.mIsDisplayResolutionRangeVotingEnabled, isVrrSupportedLocked(displayId), this.mLoggingEnabled, this.mSupportsFrameRateOverride);     // Catch: Throwable -> L17
        appRequestSummary.applyVotes(votes, 5, 23);     // Catch: Throwable -> L17
        appRequestSummary.limitRefreshRanges(primarySummary);     // Catch: Throwable -> L17
        Display.Mode baseMode = primarySummary.selectBaseMode(availableModes, defaultMode);     // Catch: Throwable -> L17
        if (this.mVotesStatsReporter == null) goto L26;
        this.mVotesStatsReporter.reportVotesActivated(displayId, lowestConsideredPriority, baseMode, votes);     // Catch: Throwable -> L17
    L26:
        if (baseMode != null) goto L31;
        Slog.w(TAG, "Can't find a set of allowed modes which satisfies the votes. Falling back to the default mode. Display = " + displayId + ", votes = " + votes + ", supported modes = " + Arrays.toString(modes));     // Catch: Throwable -> L17
        float fps = defaultMode.getRefreshRate();     // Catch: Throwable -> L17
        SurfaceControl.RefreshRateRange range = new SurfaceControl.RefreshRateRange(fps, fps);     // Catch: Throwable -> L17
        SurfaceControl.RefreshRateRanges ranges = new SurfaceControl.RefreshRateRanges(range, range);     // Catch: Throwable -> L17
        DesiredDisplayModeSpecs r15 = new DesiredDisplayModeSpecs(defaultMode.getModeId(), false, ranges, ranges, this.mBrightnessObserver.getIdleScreenRefreshRateConfig());     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        return r15;
    L31:
        if (this.mModeSwitchingType == 0) goto L36;
        if (this.mModeSwitchingType == 3) goto L36;
        boolean modeSwitchingDisabled = false;
    L38:
        if (modeSwitchingDisabled == false) goto L40;
    L41:
        float fps2 = baseMode.getRefreshRate();     // Catch: Throwable -> L17
        primarySummary.disableModeSwitching(fps2);     // Catch: Throwable -> L17
        if (modeSwitchingDisabled == false) goto L47;
        appRequestSummary.disableModeSwitching(fps2);     // Catch: Throwable -> L17
        primarySummary.disableRenderRateSwitching(fps2);     // Catch: Throwable -> L17
        if (this.mModeSwitchingType != 0) goto L47;
        appRequestSummary.disableRenderRateSwitching(fps2);     // Catch: Throwable -> L17
    L47:
        if (this.mModeSwitchingType != 2) goto L49;
        boolean r13 = true;
    L50:
        boolean allowGroupSwitching = r13;
        if (isExternalDisplayLocked(displayId) == false) goto L53;
        primarySummary.maxRenderFrameRate = Math.max(baseMode.getRefreshRate(), primarySummary.maxRenderFrameRate);     // Catch: Throwable -> L17
        appRequestSummary.maxRenderFrameRate = Math.max(baseMode.getRefreshRate(), appRequestSummary.maxRenderFrameRate);     // Catch: Throwable -> L17
    L53:
        DesiredDisplayModeSpecs r14 = new DesiredDisplayModeSpecs(baseMode.getModeId(), allowGroupSwitching, new SurfaceControl.RefreshRateRanges(new SurfaceControl.RefreshRateRange(primarySummary.minPhysicalRefreshRate, primarySummary.maxPhysicalRefreshRate), new SurfaceControl.RefreshRateRange(primarySummary.minRenderFrameRate, primarySummary.maxRenderFrameRate)), new SurfaceControl.RefreshRateRanges(new SurfaceControl.RefreshRateRange(appRequestSummary.minPhysicalRefreshRate, appRequestSummary.maxPhysicalRefreshRate), new SurfaceControl.RefreshRateRange(appRequestSummary.minRenderFrameRate, appRequestSummary.maxRenderFrameRate)), this.mBrightnessObserver.getIdleScreenRefreshRateConfig());     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        return r14;
    L49:
        r13 = false;
        goto L50
    L40:
        if (primarySummary.disableRefreshRateSwitching == false) goto L47;
    L36:
        modeSwitchingDisabled = true;
    L57:
        Slog.e(TAG, "Asked about unknown display, returning empty display mode specs!(id=" + displayId + ")");     // Catch: Throwable -> L17
        DesiredDisplayModeSpecs r0 = new DesiredDisplayModeSpecs();     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        return r0;
    L17:
        th = move-exception;
        throw th;
    }

    public AppRequestObserver getAppRequestObserver() {
        return this.mAppRequestObserver;
    }

    private boolean isVrrSupportedLocked(int displayId) {
        if (this.mHasArrSupportFlagEnabled == false) goto L8;
        Boolean hasArrSupport = Boolean.valueOf(this.mHasArrSupport.get(displayId));
        if (hasArrSupport.booleanValue() == true) goto L7;
        return false;
    L7:
        return true;
    L8:
        DisplayDeviceConfig config = this.mDisplayDeviceConfigByDisplay.get(displayId);
        if (config != null) goto L11;
        return false;
    L11:
        if (config.isVrrSupportEnabled() == true) goto L13;
        return false;
    L13:
        return true;
    }

    public void setDesiredDisplayModeSpecsListener(DesiredDisplayModeSpecsListener desiredDisplayModeSpecsListener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDesiredDisplayModeSpecsListener = desiredDisplayModeSpecsListener;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void defaultDisplayDeviceUpdated(DisplayDeviceConfig displayDeviceConfig) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDefaultDisplayDeviceConfig = displayDeviceConfig;     // Catch: Throwable -> L7
        this.mSettingsObserver.setRefreshRates(displayDeviceConfig, true);     // Catch: Throwable -> L7
        this.mBrightnessObserver.updateBlockingZoneThresholds(displayDeviceConfig, true);     // Catch: Throwable -> L7
        BrightnessObserver.m4110$$Nest$mloadIdleScreenRefreshRateConfigs(this.mBrightnessObserver, displayDeviceConfig);     // Catch: Throwable -> L7
        BrightnessObserver.m4115$$Nest$mreloadLightSensor(this.mBrightnessObserver, displayDeviceConfig);     // Catch: Throwable -> L7
        this.mHbmObserver.setupHdrRefreshRates(displayDeviceConfig);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setShouldAlwaysRespectAppRequestedMode(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAlwaysRespectAppRequest == enabled) goto L9;
        this.mAlwaysRespectAppRequest = enabled;     // Catch: Throwable -> L7
        notifyDesiredDisplayModeSpecsChangedLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public boolean shouldAlwaysRespectAppRequestedMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mAlwaysRespectAppRequest;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setModeSwitchingType(int newType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (newType == this.mModeSwitchingType) goto L9;
        this.mModeSwitchingType = newType;     // Catch: Throwable -> L7
        notifyDesiredDisplayModeSpecsChangedLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public int getModeSwitchingType() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mModeSwitchingType;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    Vote getVote(int displayId, int priority) {
        SparseArray<Vote> votes = this.mVotesStorage.getVotes(displayId);
        return votes.get(priority);
    }

    public void requestDisplayModes(IBinder token, int displayId, int[] modeIds) {
        if (this.mSystemRequestObserver == null) goto L13;
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean vrrSupported = isVrrSupportedLocked(displayId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (vrrSupported == false) goto L16;
        this.mSystemRequestObserver.requestDisplayModes(token, displayId, modeIds);
        return;
    L16:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void onSwitchUser() {
        this.mHandler.obtainMessage(9).sendToTarget();
    }

    public void dump(PrintWriter pw) {
        pw.println("DisplayModeDirector:");
        pw.println("--------------------");
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("  mSupportedModesByDisplay:");     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mSupportedModesByDisplay.size()) goto L10;
        int id = this.mSupportedModesByDisplay.keyAt(i);     // Catch: Throwable -> L8
        Display.Mode[] modes = this.mSupportedModesByDisplay.valueAt(i);     // Catch: Throwable -> L8
        pw.println("    " + id + " -> " + Arrays.toString(modes));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        pw.println("  mAppSupportedModesByDisplay:");     // Catch: Throwable -> L8
        int i2 = 0;
    L12:
        if (i2 >= this.mAppSupportedModesByDisplay.size()) goto L14;
        int id2 = this.mAppSupportedModesByDisplay.keyAt(i2);     // Catch: Throwable -> L8
        Display.Mode[] modes2 = this.mAppSupportedModesByDisplay.valueAt(i2);     // Catch: Throwable -> L8
        pw.println("    " + id2 + " -> " + Arrays.toString(modes2));     // Catch: Throwable -> L8
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L12
    L14:
        pw.println("  mDefaultModeByDisplay:");     // Catch: Throwable -> L8
        int i3 = 0;
    L16:
        if (i3 >= this.mDefaultModeByDisplay.size()) goto L18;
        int id3 = this.mDefaultModeByDisplay.keyAt(i3);     // Catch: Throwable -> L8
        Display.Mode mode = this.mDefaultModeByDisplay.valueAt(i3);     // Catch: Throwable -> L8
        pw.println("    " + id3 + " -> " + mode);     // Catch: Throwable -> L8
        i3 = i3 + 1;     // Catch: Throwable -> L8
        goto L16
    L18:
        pw.println("  mModeSwitchingType: " + switchingTypeToString(this.mModeSwitchingType));     // Catch: Throwable -> L8
        pw.println("  mAlwaysRespectAppRequest: " + this.mAlwaysRespectAppRequest);     // Catch: Throwable -> L8
        this.mSettingsObserver.dumpLocked(pw);     // Catch: Throwable -> L8
        AppRequestObserver.m4094$$Nest$mdumpLocked(this.mAppRequestObserver, pw);     // Catch: Throwable -> L8
        this.mBrightnessObserver.dumpLocked(pw);     // Catch: Throwable -> L8
        this.mUdfpsObserver.dumpLocked(pw);     // Catch: Throwable -> L8
        this.mHbmObserver.dumpLocked(pw);     // Catch: Throwable -> L8
        this.mSkinThermalStatusObserver.dumpLocked(pw);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mVotesStorage.dump(pw);
        this.mSensorObserver.dump(pw);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private float getMaxRefreshRateLocked(int displayId) {
        Display.Mode[] modes = this.mSupportedModesByDisplay.get(displayId);
        float maxRefreshRate = 0.0f;
        int r2 = modes.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        Display.Mode mode = modes[r3];
        if (mode.getRefreshRate() <= maxRefreshRate) goto L7;
        maxRefreshRate = mode.getRefreshRate();
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return maxRefreshRate;
    }

    public void notifyDesiredDisplayModeSpecsChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        notifyDesiredDisplayModeSpecsChangedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyDesiredDisplayModeSpecsChangedLocked() {
        if (this.mDesiredDisplayModeSpecsListener != null) goto L5;
        return;
    L5:
        if (this.mHandler.hasMessages(1) == true) goto L9;
        Message msg = this.mHandler.obtainMessage(1, this.mDesiredDisplayModeSpecsListener);
        msg.sendToTarget();
        return;
    }

    boolean isExternalDisplayLocked(int displayId) {
        return this.mExternalDisplaysConnected.contains(Integer.valueOf(displayId));
    }

    private static String switchingTypeToString(int type) {
        switch(type) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "SWITCHING_TYPE_RENDER_FRAME_RATE_ONLY";
    L7:
        return "SWITCHING_TYPE_ACROSS_AND_WITHIN_GROUPS";
    L9:
        return "SWITCHING_TYPE_WITHIN_GROUPS";
    L11:
        return "SWITCHING_TYPE_NONE";
    L4:
        return "Unknown SwitchingType " + type;
    }

    void injectSupportedModesByDisplay(SparseArray<Display.Mode[]> supportedModesByDisplay) {
        this.mSupportedModesByDisplay = supportedModesByDisplay;
    }

    void injectAppSupportedModesByDisplay(SparseArray<Display.Mode[]> appSupportedModesByDisplay) {
        this.mAppSupportedModesByDisplay = appSupportedModesByDisplay;
    }

    void injectDefaultModeByDisplay(SparseArray<Display.Mode> defaultModeByDisplay) {
        this.mDefaultModeByDisplay = defaultModeByDisplay;
    }

    void injectDisplayDeviceConfigByDisplay(SparseArray<DisplayDeviceConfig> ddcByDisplay) {
        this.mDisplayDeviceConfigByDisplay = ddcByDisplay;
    }

    void injectVotesByDisplay(SparseArray<SparseArray<Vote>> votesByDisplay) {
        this.mVotesStorage.injectVotesByDisplay(votesByDisplay);
    }

    void addExternalDisplayId(int externalDisplayId) {
        this.mExternalDisplaysConnected.add(Integer.valueOf(externalDisplayId));
    }

    void injectBrightnessObserver(BrightnessObserver brightnessObserver) {
        this.mBrightnessObserver = brightnessObserver;
    }

    BrightnessObserver getBrightnessObserver() {
        return this.mBrightnessObserver;
    }

    SettingsObserver getSettingsObserver() {
        return this.mSettingsObserver;
    }

    UdfpsObserver getUdpfsObserver() {
        return this.mUdfpsObserver;
    }

    HbmObserver getHbmObserver() {
        return this.mHbmObserver;
    }

    DisplayObserver getDisplayObserver() {
        return this.mDisplayObserver;
    }

    DesiredDisplayModeSpecs getDesiredDisplayModeSpecsWithInjectedFpsSettings(float minRefreshRate, float peakRefreshRate, float defaultRefreshRate) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SettingsObserver.m4130$$Nest$mupdateRefreshRateSettingLocked(this.mSettingsObserver, minRefreshRate, peakRefreshRate, defaultRefreshRate, 0);     // Catch: Throwable -> L7
        DesiredDisplayModeSpecs r1 = getDesiredDisplayModeSpecs(0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
