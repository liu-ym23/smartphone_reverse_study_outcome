package com.android.server;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.service.quickaccesswallet.QuickAccessWalletClient;
import android.util.Slog;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.logging.UiEventLogger;
import com.android.internal.logging.UiEventLoggerImpl;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.wm.WindowManagerInternal;

/* JADX INFO: loaded from: classes.dex */
public class GestureLauncherService extends SystemService {
    private static final boolean DBG = false;
    private static final boolean DBG_CAMERA_LIFT = false;
    public static final int DOUBLE_POWER_TAP_COUNT_THRESHOLD = 2;
    static final int DOUBLE_TAP_POWER_DISABLED_MODE = 0;
    static final int DOUBLE_TAP_POWER_LAUNCH_CAMERA_MODE = 1;
    static final int DOUBLE_TAP_POWER_MULTI_TARGET_MODE = 2;
    private static final int EMERGENCY_GESTURE_POWER_BUTTON_COOLDOWN_PERIOD_MS_DEFAULT = 3000;
    static final int EMERGENCY_GESTURE_POWER_BUTTON_COOLDOWN_PERIOD_MS_MAX = 5000;
    private static final int EMERGENCY_GESTURE_POWER_TAP_COUNT_THRESHOLD = 5;
    private static final Bundle GRANT_BACKGROUND_START_PRIVILEGES = null;
    static final int LAUNCH_CAMERA_ON_DOUBLE_TAP_POWER = 0;
    static final int LAUNCH_WALLET_ON_DOUBLE_TAP_POWER = 1;
    static final long POWER_DOUBLE_TAP_MAX_TIME_MS = 300;
    static final long POWER_SHORT_TAP_SEQUENCE_MAX_INTERVAL_MS = 500;
    private static final String TAG = "GestureLauncherService";
    private boolean mCameraDoubleTapPowerEnabled;
    private long mCameraGestureLastEventTime;
    private long mCameraGestureOnTimeMs;
    private long mCameraGestureSensor1LastOnTimeMs;
    private long mCameraGestureSensor2LastOnTimeMs;
    private int mCameraLaunchLastEventExtra;
    private boolean mCameraLaunchRegistered;
    private Sensor mCameraLaunchSensor;
    private boolean mCameraLiftRegistered;
    private final CameraLiftTriggerEventListener mCameraLiftTriggerListener;
    private Sensor mCameraLiftTriggerSensor;
    private Context mContext;
    private boolean mEmergencyGestureEnabled;
    private int mEmergencyGesturePowerButtonCooldownPeriodMs;
    private final IExtGestureLauncherService mExt;
    private long mFirstPowerDown;
    private final GestureEventListener mGestureListener;
    private boolean mHasFeatureWatch;
    private long mLastEmergencyGestureTriggered;
    private long mLastPowerDown;
    private final MetricsLogger mMetricsLogger;
    private int mPowerButtonConsecutiveTaps;
    private int mPowerButtonSlowConsecutiveTaps;
    private PowerManager mPowerManager;
    private final QuickAccessWalletClient mQuickAccessWalletClient;
    private final ContentObserver mSettingObserver;
    private final UiEventLogger mUiEventLogger;
    private int mUserId;
    private final BroadcastReceiver mUserReceiver;
    private PowerManager.WakeLock mWakeLock;
    private boolean mWalletDoubleTapPowerEnabled;
    private WindowManagerInternal mWindowManagerInternal;

    private final class CameraLiftTriggerEventListener extends TriggerEventListener {
        final /* synthetic */ GestureLauncherService this$0;

        /* synthetic */ CameraLiftTriggerEventListener(GestureLauncherService r1, GestureLauncherServiceIA r2) {
            this(r1);
        }

        private CameraLiftTriggerEventListener(GestureLauncherService r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.TriggerEventListener
        public void onTrigger(TriggerEvent event) {
            if (GestureLauncherService.m235$$Nest$fgetmCameraLiftRegistered(this.this$0) == true) goto L6;
            return;
        L6:
            if (event.sensor != GestureLauncherService.m237$$Nest$fgetmCameraLiftTriggerSensor(this.this$0)) goto L15;
            GestureLauncherService.m238$$Nest$fgetmContext(this.this$0).getResources();
            SensorManager sensorManager = (SensorManager) GestureLauncherService.m238$$Nest$fgetmContext(this.this$0).getSystemService("sensor");
            boolean keyguardShowingAndNotOccluded = GestureLauncherService.m244$$Nest$fgetmWindowManagerInternal(this.this$0).isKeyguardShowingAndNotOccluded();
            boolean interactive = GestureLauncherService.m240$$Nest$fgetmPowerManager(this.this$0).isInteractive();
            if (keyguardShowingAndNotOccluded == true) goto L11;
            if (interactive == false) goto L11;
        L13:
            GestureLauncherService.m249$$Nest$fputmCameraLiftRegistered(this.this$0, sensorManager.requestTriggerSensor(GestureLauncherService.m236$$Nest$fgetmCameraLiftTriggerListener(this.this$0), GestureLauncherService.m237$$Nest$fgetmCameraLiftTriggerSensor(this.this$0)));
            return;
        L11:
            if (this.this$0.handleCameraGesture(true, 2) == false) goto L13;
            MetricsLogger.action(GestureLauncherService.m238$$Nest$fgetmContext(this.this$0), 989);
            GestureLauncherService.m242$$Nest$fgetmUiEventLogger(this.this$0).log(GestureLauncherEvent.GESTURE_CAMERA_LIFT);
            goto L13
        }
    }

    private final class GestureEventListener implements SensorEventListener {
        final /* synthetic */ GestureLauncherService this$0;

        /* synthetic */ GestureEventListener(GestureLauncherService r1, GestureLauncherServiceIA r2) {
            this(r1);
        }

        private GestureEventListener(GestureLauncherService r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            if (GestureLauncherService.m233$$Nest$fgetmCameraLaunchRegistered(this.this$0) == true) goto L6;
            return;
        L6:
            if (event.sensor == GestureLauncherService.m234$$Nest$fgetmCameraLaunchSensor(this.this$0)) goto L8;
            return;
        L8:
            if (this.this$0.handleCameraGesture(true, 0) == false) goto L12;
            GestureLauncherService.m239$$Nest$fgetmMetricsLogger(this.this$0).action(256);
            GestureLauncherService.m242$$Nest$fgetmUiEventLogger(this.this$0).log(GestureLauncherEvent.GESTURE_CAMERA_WIGGLE);
            trackCameraLaunchEvent(event);
            return;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        private void trackCameraLaunchEvent(SensorEvent event) {
            long now = SystemClock.elapsedRealtime();
            long totalDuration = now - GestureLauncherService.m229$$Nest$fgetmCameraGestureOnTimeMs(this.this$0);
            float[] values = event.values;
            long sensor1OnTime = (long) (totalDuration * ((double) values[0]));
            long sensor2OnTime = (long) (totalDuration * ((double) values[1]));
            int extra = (int) values[2];
            long gestureOnTimeDiff = now - GestureLauncherService.m228$$Nest$fgetmCameraGestureLastEventTime(this.this$0);
            long sensor1OnTimeDiff = sensor1OnTime - GestureLauncherService.m230$$Nest$fgetmCameraGestureSensor1LastOnTimeMs(this.this$0);
            long sensor2OnTimeDiff = sensor2OnTime - GestureLauncherService.m231$$Nest$fgetmCameraGestureSensor2LastOnTimeMs(this.this$0);
            int extraDiff = extra - GestureLauncherService.m232$$Nest$fgetmCameraLaunchLastEventExtra(this.this$0);
            if (gestureOnTimeDiff >= 0) goto L5;
            return;
        L5:
            if (sensor1OnTimeDiff >= 0) goto L7;
            return;
        L7:
            if (sensor2OnTimeDiff < 0) goto L13;
            EventLogTags.writeCameraGestureTriggered(gestureOnTimeDiff, sensor1OnTimeDiff, sensor2OnTimeDiff, extraDiff);
            GestureLauncherService.m245$$Nest$fputmCameraGestureLastEventTime(this.this$0, now);
            GestureLauncherService.m246$$Nest$fputmCameraGestureSensor1LastOnTimeMs(this.this$0, sensor1OnTime);
            GestureLauncherService.m247$$Nest$fputmCameraGestureSensor2LastOnTimeMs(this.this$0, sensor2OnTime);
            GestureLauncherService.m248$$Nest$fputmCameraLaunchLastEventExtra(this.this$0, extra);
            return;
        }
    }

    public static final enum GestureLauncherEvent extends Enum<GestureLauncherEvent> implements UiEventLogger.UiEventEnum {
        private static final /* synthetic */ GestureLauncherEvent[] $VALUES = null;
        public static final GestureLauncherEvent GESTURE_CAMERA_DOUBLE_TAP_POWER = null;
        public static final GestureLauncherEvent GESTURE_CAMERA_LIFT = null;
        public static final GestureLauncherEvent GESTURE_CAMERA_WIGGLE = null;
        public static final GestureLauncherEvent GESTURE_EMERGENCY_TAP_POWER = null;
        private final int mId;

        private static /* synthetic */ GestureLauncherEvent[] $values() {
            return new GestureLauncherEvent[]{GESTURE_CAMERA_LIFT, GESTURE_CAMERA_WIGGLE, GESTURE_CAMERA_DOUBLE_TAP_POWER, GESTURE_EMERGENCY_TAP_POWER};
        }

        public static GestureLauncherEvent valueOf(String name) {
            return (GestureLauncherEvent) Enum.valueOf(GestureLauncherEvent.class, name);
        }

        public static GestureLauncherEvent[] values() {
            return (GestureLauncherEvent[]) $VALUES.clone();
        }

        static {
            GESTURE_CAMERA_LIFT = new GestureLauncherEvent("GESTURE_CAMERA_LIFT", 0, FrameworkStatsLog.EXPRESS_UID_HISTOGRAM_SAMPLE_REPORTED);
            GESTURE_CAMERA_WIGGLE = new GestureLauncherEvent("GESTURE_CAMERA_WIGGLE", 1, FrameworkStatsLog.AUTOFILL_FIELD_CLASSIFICATION_EVENT_REPORTED);
            GESTURE_CAMERA_DOUBLE_TAP_POWER = new GestureLauncherEvent("GESTURE_CAMERA_DOUBLE_TAP_POWER", 2, 660);
            GESTURE_EMERGENCY_TAP_POWER = new GestureLauncherEvent("GESTURE_EMERGENCY_TAP_POWER", 3, 661);
            $VALUES = $values();
        }

        private GestureLauncherEvent(String r1, int r2, int id) {
            super(r1, r2);
            this.mId = id;
        }

        public int getId() {
            return this.mId;
        }
    }

    public static /* synthetic */ void $r8$lambda$J_u470zAEaWwT8K6VSDfXYnX5ns(GestureLauncherService r0, PendingIntent r1) {
        r0.lambda$sendGestureTargetActivityPendingIntent$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$owMLYHZSmOWIOp9hw317vIOOPMo(GestureLauncherService r0, PendingIntent r1) {
        r0.lambda$sendFallbackPendingIntent$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraGestureLastEventTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m228$$Nest$fgetmCameraGestureLastEventTime(GestureLauncherService r2) {
        return r2.mCameraGestureLastEventTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraGestureOnTimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m229$$Nest$fgetmCameraGestureOnTimeMs(GestureLauncherService r2) {
        return r2.mCameraGestureOnTimeMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraGestureSensor1LastOnTimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m230$$Nest$fgetmCameraGestureSensor1LastOnTimeMs(GestureLauncherService r2) {
        return r2.mCameraGestureSensor1LastOnTimeMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraGestureSensor2LastOnTimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m231$$Nest$fgetmCameraGestureSensor2LastOnTimeMs(GestureLauncherService r2) {
        return r2.mCameraGestureSensor2LastOnTimeMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraLaunchLastEventExtra, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m232$$Nest$fgetmCameraLaunchLastEventExtra(GestureLauncherService r0) {
        return r0.mCameraLaunchLastEventExtra;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraLaunchRegistered, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m233$$Nest$fgetmCameraLaunchRegistered(GestureLauncherService r0) {
        return r0.mCameraLaunchRegistered;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraLaunchSensor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Sensor m234$$Nest$fgetmCameraLaunchSensor(GestureLauncherService r0) {
        return r0.mCameraLaunchSensor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraLiftRegistered, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m235$$Nest$fgetmCameraLiftRegistered(GestureLauncherService r0) {
        return r0.mCameraLiftRegistered;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraLiftTriggerListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ CameraLiftTriggerEventListener m236$$Nest$fgetmCameraLiftTriggerListener(GestureLauncherService r0) {
        return r0.mCameraLiftTriggerListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraLiftTriggerSensor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Sensor m237$$Nest$fgetmCameraLiftTriggerSensor(GestureLauncherService r0) {
        return r0.mCameraLiftTriggerSensor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m238$$Nest$fgetmContext(GestureLauncherService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMetricsLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ MetricsLogger m239$$Nest$fgetmMetricsLogger(GestureLauncherService r0) {
        return r0.mMetricsLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager m240$$Nest$fgetmPowerManager(GestureLauncherService r0) {
        return r0.mPowerManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettingObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentObserver m241$$Nest$fgetmSettingObserver(GestureLauncherService r0) {
        return r0.mSettingObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUiEventLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ UiEventLogger m242$$Nest$fgetmUiEventLogger(GestureLauncherService r0) {
        return r0.mUiEventLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m243$$Nest$fgetmUserId(GestureLauncherService r0) {
        return r0.mUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerInternal m244$$Nest$fgetmWindowManagerInternal(GestureLauncherService r0) {
        return r0.mWindowManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCameraGestureLastEventTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m245$$Nest$fputmCameraGestureLastEventTime(GestureLauncherService r0, long r1) {
        r0.mCameraGestureLastEventTime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCameraGestureSensor1LastOnTimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m246$$Nest$fputmCameraGestureSensor1LastOnTimeMs(GestureLauncherService r0, long r1) {
        r0.mCameraGestureSensor1LastOnTimeMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCameraGestureSensor2LastOnTimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m247$$Nest$fputmCameraGestureSensor2LastOnTimeMs(GestureLauncherService r0, long r1) {
        r0.mCameraGestureSensor2LastOnTimeMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCameraLaunchLastEventExtra, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m248$$Nest$fputmCameraLaunchLastEventExtra(GestureLauncherService r0, int r1) {
        r0.mCameraLaunchLastEventExtra = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCameraLiftRegistered, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m249$$Nest$fputmCameraLiftRegistered(GestureLauncherService r0, boolean r1) {
        r0.mCameraLiftRegistered = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m250$$Nest$fputmUserId(GestureLauncherService r0, int r1) {
        r0.mUserId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterContentObservers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m251$$Nest$mregisterContentObservers(GestureLauncherService r0) {
        r0.registerContentObservers();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateCameraRegistered, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m252$$Nest$mupdateCameraRegistered(GestureLauncherService r0) {
        r0.updateCameraRegistered();
    }

    static {
        GRANT_BACKGROUND_START_PRIVILEGES = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(3).toBundle();
    }

    public GestureLauncherService(Context context) {
        this(context, new MetricsLogger(), QuickAccessWalletClient.create(context), new UiEventLoggerImpl());
    }

    public GestureLauncherService(Context context, MetricsLogger metricsLogger, QuickAccessWalletClient quickAccessWalletClient, UiEventLogger uiEventLogger) {
        super(context);
        GestureLauncherServiceIA r1 = null;
        this.mGestureListener = new GestureEventListener(this, r1);
        this.mCameraLiftTriggerListener = new CameraLiftTriggerEventListener(this, r1);
        this.mCameraGestureOnTimeMs = 0;
        this.mCameraGestureLastEventTime = 0;
        this.mCameraGestureSensor1LastOnTimeMs = 0;
        this.mCameraGestureSensor2LastOnTimeMs = 0;
        this.mCameraLaunchLastEventExtra = 0;
        this.mUserReceiver = new AnonymousClass1(this);
        final Handler r2 = new Handler();
        this.mSettingObserver = new AnonymousClass2(this, r2);
        this.mExt = (IExtGestureLauncherService) ExtImplFactory.getImpl(IExtGestureLauncherService.class, new Object[]{this});
        this.mContext = context;
        this.mMetricsLogger = metricsLogger;
        this.mQuickAccessWalletClient = quickAccessWalletClient;
        this.mUiEventLogger = uiEventLogger;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        LocalServices.addService(GestureLauncherService.class, this);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 600) goto L9;
        Resources resources = this.mContext.getResources();
        if (isGestureLauncherEnabled(resources) == true) goto L7;
        return;
    L7:
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mWakeLock = this.mPowerManager.newWakeLock(1, TAG);
        updateCameraRegistered();
        updateCameraDoubleTapPowerEnabled();
        updateWalletDoubleTapPowerEnabled();
        updateEmergencyGestureEnabled();
        updateEmergencyGesturePowerButtonCooldownPeriodMs();
        this.mUserId = ActivityManager.getCurrentUser();
        this.mContext.registerReceiver(this.mUserReceiver, new IntentFilter("android.intent.action.USER_SWITCHED"));
        registerContentObservers();
        this.mHasFeatureWatch = this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        return;
    }

    private void registerContentObservers() {
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("double_tap_power_button_gesture_enabled"), false, this.mSettingObserver, this.mUserId);
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("double_tap_power_button_gesture"), false, this.mSettingObserver, this.mUserId);
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("camera_gesture_disabled"), false, this.mSettingObserver, this.mUserId);
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("camera_double_tap_power_gesture_disabled"), false, this.mSettingObserver, this.mUserId);
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("camera_lift_trigger_enabled"), false, this.mSettingObserver, this.mUserId);
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("emergency_gesture_enabled"), false, this.mSettingObserver, this.mUserId);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("emergency_gesture_power_button_cooldown_period_ms"), false, this.mSettingObserver, this.mUserId);
    }

    private void updateCameraRegistered() {
        Resources resources = this.mContext.getResources();
        if (isCameraLaunchSettingEnabled(this.mContext, this.mUserId) == false) goto L5;
        registerCameraLaunchGesture(resources);
    L7:
        if (isCameraLiftTriggerSettingEnabled(this.mContext, this.mUserId) == false) goto L9;
        registerCameraLiftTrigger(resources);
        return;
    L9:
        unregisterCameraLiftTrigger();
        return;
    L5:
        unregisterCameraLaunchGesture();
        goto L7
    }

    void updateCameraDoubleTapPowerEnabled() {
        boolean enabled = isCameraDoubleTapPowerSettingEnabled(this.mContext, this.mUserId);
        monitor-enter(this);
        this.mCameraDoubleTapPowerEnabled = enabled;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void updateWalletDoubleTapPowerEnabled() {
        boolean enabled = isWalletDoubleTapPowerSettingEnabled(this.mContext, this.mUserId);
        monitor-enter(this);
        this.mWalletDoubleTapPowerEnabled = enabled;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void updateEmergencyGestureEnabled() {
        boolean enabled = isEmergencyGestureSettingEnabled(this.mContext, this.mUserId);
        monitor-enter(this);
        this.mEmergencyGestureEnabled = enabled;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void updateEmergencyGesturePowerButtonCooldownPeriodMs() {
        int cooldownPeriodMs = getEmergencyGesturePowerButtonCooldownPeriodMs(this.mContext, this.mUserId);
        monitor-enter(this);
        this.mEmergencyGesturePowerButtonCooldownPeriodMs = cooldownPeriodMs;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void unregisterCameraLaunchGesture() {
        if (this.mCameraLaunchRegistered == false) goto L6;
        this.mCameraLaunchRegistered = false;
        this.mCameraGestureOnTimeMs = 0;
        this.mCameraGestureLastEventTime = 0;
        this.mCameraGestureSensor1LastOnTimeMs = 0;
        this.mCameraGestureSensor2LastOnTimeMs = 0;
        this.mCameraLaunchLastEventExtra = 0;
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        sensorManager.unregisterListener(this.mGestureListener);
        return;
    }

    private void registerCameraLaunchGesture(Resources resources) {
        if (this.mCameraLaunchRegistered == false) goto L5;
        return;
    L5:
        this.mCameraGestureOnTimeMs = SystemClock.elapsedRealtime();
        this.mCameraGestureLastEventTime = this.mCameraGestureOnTimeMs;
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        int cameraLaunchGestureId = resources.getInteger(R.integer.config_datagram_wait_for_connected_state_timeout_millis);
        if (cameraLaunchGestureId == (-1)) goto L14;
        this.mCameraLaunchRegistered = false;
        String sensorName = resources.getString(R.string.config_defaultNearbyFastPairSettingsDevicesComponent);
        this.mCameraLaunchSensor = sensorManager.getDefaultSensor(cameraLaunchGestureId, true);
        if (this.mCameraLaunchSensor != null) goto L10;
        return;
    L10:
        if (sensorName.equals(this.mCameraLaunchSensor.getStringType()) == false) goto L12;
        this.mCameraLaunchRegistered = sensorManager.registerListener(this.mGestureListener, this.mCameraLaunchSensor, 0);
        return;
    L12:
        String message = String.format("Wrong configuration. Sensor type and sensor string type don't match: %s in resources, %s in the sensor.", new Object[]{sensorName, this.mCameraLaunchSensor.getStringType()});
        throw new RuntimeException(message);
    }

    private void unregisterCameraLiftTrigger() {
        if (this.mCameraLiftRegistered == false) goto L6;
        this.mCameraLiftRegistered = false;
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        sensorManager.cancelTriggerSensor(this.mCameraLiftTriggerListener, this.mCameraLiftTriggerSensor);
        return;
    }

    private void registerCameraLiftTrigger(Resources resources) {
        if (this.mCameraLiftRegistered == false) goto L5;
        return;
    L5:
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        int cameraLiftTriggerId = resources.getInteger(R.integer.config_datause_notification_type);
        if (cameraLiftTriggerId == (-1)) goto L14;
        this.mCameraLiftRegistered = false;
        String sensorName = resources.getString(R.string.config_defaultNearbySharingComponent);
        this.mCameraLiftTriggerSensor = sensorManager.getDefaultSensor(cameraLiftTriggerId, true);
        if (this.mCameraLiftTriggerSensor != null) goto L10;
        return;
    L10:
        if (sensorName.equals(this.mCameraLiftTriggerSensor.getStringType()) == false) goto L12;
        this.mCameraLiftRegistered = sensorManager.requestTriggerSensor(this.mCameraLiftTriggerListener, this.mCameraLiftTriggerSensor);
        return;
    L12:
        String message = String.format("Wrong configuration. Sensor type and sensor string type don't match: %s in resources, %s in the sensor.", new Object[]{sensorName, this.mCameraLiftTriggerSensor.getStringType()});
        throw new RuntimeException(message);
    }

    public static boolean isCameraLaunchSettingEnabled(Context context, int userId) {
        if (isCameraLaunchEnabled(context.getResources()) == true) goto L5;
        return false;
    L5:
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "camera_gesture_disabled", 0, userId) != 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isCameraDoubleTapPowerSettingEnabled(Context context, int userId) {
        int doubleTapPowerGestureSettingMode = getDoubleTapPowerGestureMode(context.getResources());
        switch(doubleTapPowerGestureSettingMode) {
            case 1: goto L12;
            case 2: goto L6;
            default: goto L16;
        };
    L16:
        return false;
    L6:
        if (isMultiTargetDoubleTapPowerGestureSettingEnabled(context, userId) == false) goto L17;
        if (getDoubleTapPowerGestureAction(context, userId) != 0) goto L17;
        return true;
    L17:
        return false;
    L12:
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "camera_double_tap_power_gesture_disabled", 0, userId) != 0) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isWalletDoubleTapPowerSettingEnabled(Context context, int userId) {
        if (getDoubleTapPowerGestureMode(context.getResources()) == 2) goto L5;
    L9:
        return false;
    L5:
        if (isMultiTargetDoubleTapPowerGestureSettingEnabled(context, userId) == false) goto L9;
        if (getDoubleTapPowerGestureAction(context, userId) != 1) goto L9;
        return true;
    }

    public static boolean isCameraLiftTriggerSettingEnabled(Context context, int userId) {
        if (isCameraLiftTriggerEnabled(context.getResources()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "camera_lift_trigger_enabled", 1, userId) == 0) goto L7;
        return true;
    }

    public static boolean isEmergencyGestureSettingEnabled(Context r3, int r4) {
        if (isEmergencyGestureEnabled(r3.getResources()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Settings.Secure.getIntForUser(r3.getContentResolver(), "emergency_gesture_enabled", isDefaultEmergencyGestureEnabled(r3.getResources()) ? 1 : 0, r4) == 0) goto L7;
        return true;
    }

    private static int getDoubleTapPowerGestureMode(Resources resources) {
        return resources.getInteger(R.integer.config_dreamsBatteryLevelMinimumWhenNotPowered);
    }

    private static boolean isMultiTargetDoubleTapPowerGestureSettingEnabled(Context context, int userId) {
        ContentResolver r0 = context.getContentResolver();
        if (getDoubleTapPowerGestureMode(context.getResources()) != 2) goto L5;
        int r1 = 1;
    L7:
        if (Settings.Secure.getIntForUser(r0, "double_tap_power_button_gesture_enabled", r1, userId) == 1) goto L9;
        return false;
    L9:
        return true;
    L5:
        r1 = 0;
        goto L7
    }

    private static int getDoubleTapPowerGestureAction(Context context, int userId) {
        return Settings.Secure.getIntForUser(context.getContentResolver(), "double_tap_power_button_gesture", context.getResources().getInteger(R.integer.config_dreamsBatteryLevelMinimumWhenPowered), userId);
    }

    static int getEmergencyGesturePowerButtonCooldownPeriodMs(Context context, int userId) {
        int cooldown = Settings.Global.getInt(context.getContentResolver(), "emergency_gesture_power_button_cooldown_period_ms", 3000);
        return Math.min(cooldown, 5000);
    }

    private static boolean isCameraLaunchEnabled(Resources resources) {
        if (resources.getInteger(R.integer.config_datagram_wait_for_connected_state_timeout_millis) == (-1)) goto L5;
        boolean configSet = true;
    L7:
        if (configSet == false) goto L12;
        if (SystemProperties.getBoolean("gesture.disable_camera_launch", false) == true) goto L12;
        return true;
    L12:
        return false;
    L5:
        configSet = false;
        goto L7
    }

    static boolean isCameraDoubleTapPowerEnabled(Resources resources) {
        return resources.getBoolean(R.bool.config_canInternalDisplayHostDesktops);
    }

    private static boolean isCameraLiftTriggerEnabled(Resources resources) {
        if (resources.getInteger(R.integer.config_datause_notification_type) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isEmergencyGestureEnabled(Resources resources) {
        return resources.getBoolean(R.bool.config_enableAutoPowerModes);
    }

    private static boolean isDefaultEmergencyGestureEnabled(Resources resources) {
        return resources.getBoolean(R.bool.config_defaultPreventScreenTimeoutEnabled);
    }

    public static boolean isGestureLauncherEnabled(Resources resources) {
        boolean r1 = true;
        if (isCameraLaunchEnabled(resources) == false) goto L5;
    L10:
        boolean res = true;
    L12:
        if (getDoubleTapPowerGestureMode(resources) != 0) goto L16;
        r1 = false;
    L16:
        return res | r1;
    L5:
        if (isCameraLiftTriggerEnabled(resources) == true) goto L10;
        if (isEmergencyGestureEnabled(resources) == true) goto L10;
        res = false;
        goto L12
    }

    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v0 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchDebugInfoByOffset(DebugInfoApplyVisitor.java:107)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:83)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v0 'this'  ??, new type: com.android.server.GestureLauncherService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v5 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v7 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v8 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r19v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v0 'this'  ??, new type: com.android.server.GestureLauncherService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v0 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public boolean interceptPowerKeyDown(android.view.KeyEvent r20, boolean r21, android.util.MutableBoolean r22) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONST (r3v0 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (0 ??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) A[DECLARE_VAR] in method: com.android.server.GestureLauncherService.interceptPowerKeyDown(android.view.KeyEvent, boolean, android.util.MutableBoolean):boolean, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.GestureLauncherService.interceptPowerKeyDown(android.view.KeyEvent, boolean, android.util.MutableBoolean):boolean");
    }

    private boolean sendGestureTargetActivityPendingIntent() {
        boolean userSetupComplete = isUserSetupComplete();
        if (this.mQuickAccessWalletClient != null) goto L5;
    L11:
        Slog.w(TAG, "QuickAccessWalletService is not available, ignoring wallet gesture.");
        return false;
    L5:
        if (this.mQuickAccessWalletClient.isWalletServiceAvailable() == false) goto L11;
        if (userSetupComplete == true) goto L9;
        return false;
    L9:
        this.mQuickAccessWalletClient.getGestureTargetActivityPendingIntent(getContext().getMainExecutor(), new GestureLauncherService$$ExternalSyntheticLambda0(this));
        return true;
    }

    private /* synthetic */ void lambda$sendGestureTargetActivityPendingIntent$0(PendingIntent gesturePendingIntent) {
        if (gesturePendingIntent != null) goto L5;
        Slog.d(TAG, "getGestureTargetActivityPendingIntent is null.");
        sendFallbackPendingIntent();
        return;
    L5:
        sendPendingIntentWithBackgroundStartPrivileges(gesturePendingIntent);
    }

    private void sendFallbackPendingIntent() {
        this.mQuickAccessWalletClient.getWalletPendingIntent(getContext().getMainExecutor(), new GestureLauncherService$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$sendFallbackPendingIntent$1(PendingIntent walletPendingIntent) {
        if (walletPendingIntent != null) goto L5;
        Slog.w(TAG, "getWalletPendingIntent returns null. Not launching anything for wallet.");
        return;
    L5:
        sendPendingIntentWithBackgroundStartPrivileges(walletPendingIntent);
    }

    private void sendPendingIntentWithBackgroundStartPrivileges(PendingIntent pendingIntent) {
        pendingIntent.send(GRANT_BACKGROUND_START_PRIVILEGES);     // Catch: PendingIntent.CanceledException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "PendingIntent was canceled", e);
    }

    boolean handleCameraGesture(boolean useWakelock, int source) {
        Trace.traceBegin(64, "GestureLauncher:handleCameraGesture");
        boolean userSetupComplete = isUserSetupComplete();     // Catch: Throwable -> L9
        if (userSetupComplete == true) goto L7;
        Trace.traceEnd(64);
        return false;
    L7:
        if (useWakelock == false) goto L11;
        this.mWakeLock.acquire(500);     // Catch: Throwable -> L9
    L11:
        StatusBarManagerInternal service = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);     // Catch: Throwable -> L9
        service.onCameraLaunchGestureDetected(source);     // Catch: Throwable -> L9
        Trace.traceEnd(64);
        return true;
    L9:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    boolean handleWalletGesture() {
        Trace.traceBegin(64, "GestureLauncher:handleWalletGesture");
        boolean userSetupComplete = isUserSetupComplete();     // Catch: Throwable -> L10
        if (userSetupComplete == true) goto L7;
        Trace.traceEnd(64);
        return false;
    L7:
        StatusBarManagerInternal service = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);     // Catch: Throwable -> L10
        service.onWalletLaunchGestureDetected();     // Catch: Throwable -> L10
        Trace.traceEnd(64);
        return true;
    L10:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    boolean handleEmergencyGesture() {
        Trace.traceBegin(64, "GestureLauncher:handleEmergencyGesture");
        boolean userSetupComplete = isUserSetupComplete();     // Catch: Throwable -> L10
        if (userSetupComplete == true) goto L7;
        Trace.traceEnd(64);
        return false;
    L7:
        StatusBarManagerInternal service = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);     // Catch: Throwable -> L10
        service.onEmergencyActionLaunchGestureDetected();     // Catch: Throwable -> L10
        Trace.traceEnd(64);
        return true;
    L10:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    private boolean isUserSetupComplete() {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "user_setup_complete", 0, -2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public IExtGestureLauncherService getExt() {
        return this.mExt;
    }
}
