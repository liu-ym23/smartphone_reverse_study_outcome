package com.android.server.power;

import android.app.StatusBarManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IPowerManagerSmtEx;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.provider.Settings;
import android.service.dreams.DreamManagerInternal;
import android.util.FloatProperty;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import com.android.server.display.RampAnimator;
import com.android.server.power.batterysaver.BatterySaverController;
import com.android.server.wm.WindowManagerInternalSmtEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class PowerManagerServiceSmtEx extends IPowerManagerSmtEx.Stub {
    public static final FloatProperty<PowerManagerService> BRIGHTNESS = null;
    protected static final int DIRTY_AUTO_BRIGHTNESS = 16384;
    protected static final boolean IF_REMOVE_GLARE = false;
    protected static final int MSG_DISPLAY_CHANGE_UPDATE_WAKELOCKS = 200;
    private static final String TAG = "PowerManagerService";
    private boolean DEBUG_PROCESS;
    private String LOG_TAG;
    private AutoBrightnessController.AutoBrightnessCallBack mAutoBrightnessCallBack;
    protected AutoBrightnessController mAutoBrightnessController;
    protected boolean mAutoExitLowPowerMode;
    private BatterySaverController mBatterySaverController;
    private Context mContext;
    protected volatile boolean mFeaturePhoneModeEnabled;
    private Handler mHandler;
    protected boolean mInCall;
    boolean mIsScreenDim;
    private Object mLock;
    AtomicBoolean mLockBrightnessEnabled;
    private boolean mLowPowerModeEnabled;
    protected PowerSaveModeController mPSMController;
    protected ProximitySensorHelper mProSensorHelper;
    protected float mScreenBrightnessAuto;
    protected RampAnimator<PowerManagerService> mScreenBrightnessRampAnimator;
    private PowerManagerService mService;
    boolean mSleepToDozeFlag;
    Runnable mToSleepRunnable;
    private PowerManager.WakeLock mWakeLockForPsensor;
    protected WindowManagerInternalSmtEx mWindowManagerInternalSmtEx;

    protected class ProximitySensorHelper {
        private static final int DELAY_FOR_CHECK_STATE = 300;
        private static final int PROXIMITY_NEGATIVE = 0;
        private static final int PROXIMITY_POSITIVE = 1;
        private static final int PROXIMITY_UNKNOWN = -1;
        private static final float TYPICAL_PROXIMITY_THRESHOLD = 5.0f;
        private List<Pair<Long, String>> mEventTimes;
        private int mProximity;
        private Sensor mProximitySensor;
        private boolean mProximitySensorEnabled;
        private final SensorEventListener mProximitySensorListener;
        private float mProximityThreshold;
        private SensorManager mSensorManager;
        private long mStartWorkTime;
        private final Runnable mStateCheckTask;
        final /* synthetic */ PowerManagerServiceSmtEx this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmProximity, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7541$$Nest$fgetmProximity(ProximitySensorHelper r0) {
            return r0.mProximity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProximitySensorEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7542$$Nest$fgetmProximitySensorEnabled(ProximitySensorHelper r0) {
            return r0.mProximitySensorEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProximityThreshold, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m7543$$Nest$fgetmProximityThreshold(ProximitySensorHelper r0) {
            return r0.mProximityThreshold;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStartWorkTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m7544$$Nest$fgetmStartWorkTime(ProximitySensorHelper r2) {
            return r2.mStartWorkTime;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmProximity, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7545$$Nest$fputmProximity(ProximitySensorHelper r0, int r1) {
            r0.mProximity = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mjudgeWakeUpLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7546$$Nest$mjudgeWakeUpLocked(ProximitySensorHelper r0) {
            r0.judgeWakeUpLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mwakeUpLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7547$$Nest$mwakeUpLocked(ProximitySensorHelper r0) {
            r0.wakeUpLocked();
        }

        public ProximitySensorHelper(PowerManagerServiceSmtEx this$0, SensorManager sensorManager) {
            this.this$0 = this$0;
            this.mProximitySensorEnabled = false;
            this.mProximity = -1;
            this.mStartWorkTime = 0;
            this.mEventTimes = new ArrayList();
            this.mStateCheckTask = new AnonymousClass1(this);
            this.mProximitySensorListener = new AnonymousClass2(this);
            monitor-enter(this$0);
            this.mSensorManager = sensorManager;     // Catch: Throwable -> L7
            this.mProximitySensor = this.mSensorManager.getDefaultSensor(8);     // Catch: Throwable -> L7
            if (this.mProximitySensor == null) goto L9;
            this.mProximityThreshold = Math.min(this.mProximitySensor.getMaximumRange(), TYPICAL_PROXIMITY_THRESHOLD);     // Catch: Throwable -> L7
        L9:
            monitor-exit(this$0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void setProximitySensorEnabledLocked(boolean enable) {
            Slog.i(PowerManagerServiceSmtEx.TAG, "setProximitySensorEnabledLocked");
            if (enable == false) goto L8;
            if (this.mProximitySensorEnabled == true) goto L11;
            this.mProximitySensorEnabled = true;
            this.mProximity = -1;
            Slog.i(PowerManagerServiceSmtEx.TAG, "registerListener p-sensor");
            this.mSensorManager.registerListener(this.mProximitySensorListener, this.mProximitySensor, 0, PowerManagerServiceSmtEx.m7538$$Nest$fgetmHandler(this.this$0));
            return;
        L11:
            return;
        L8:
            if (this.mProximitySensorEnabled == false) goto L13;
            this.mProximitySensorEnabled = false;
            this.mProximity = -1;
            Slog.i(PowerManagerServiceSmtEx.TAG, "unregisterListener p-sensor");
            this.mSensorManager.unregisterListener(this.mProximitySensorListener);
            return;
        }

        public void work(long evenTime, String reason) {
            Slog.i(PowerManagerServiceSmtEx.TAG, "setProximity work");
            PowerManagerServiceSmtEx r0 = this.this$0;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mStartWorkTime == 0) goto L11;
            this.mEventTimes.add(Pair.create(Long.valueOf(evenTime), reason));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            this.mStartWorkTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
            this.mEventTimes.add(Pair.create(Long.valueOf(evenTime), reason));     // Catch: Throwable -> L9
            setProximitySensorEnabledLocked(true);     // Catch: Throwable -> L9
            PowerManagerServiceSmtEx.m7538$$Nest$fgetmHandler(this.this$0).postDelayed(this.mStateCheckTask, 300);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        public void stop() {
            Slog.i(PowerManagerServiceSmtEx.TAG, "setProximity stop");
            PowerManagerServiceSmtEx r0 = this.this$0;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mStartWorkTime != 0) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.mStartWorkTime = 0;     // Catch: Throwable -> L8
            this.mEventTimes.clear();     // Catch: Throwable -> L8
            setProximitySensorEnabledLocked(false);     // Catch: Throwable -> L8
            PowerManagerServiceSmtEx.m7538$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mStateCheckTask);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private void wakeUpLocked() {
            PowerManagerServiceSmtEx r0 = this.this$0;
            monitor-enter(r0);
            Iterator<Pair<Long, String>> r1 = this.mEventTimes.iterator();     // Catch: Throwable -> L8
        L6:
            if (r1.hasNext() == false) goto L10;
            final Pair<Long, String> p = r1.next();     // Catch: Throwable -> L8
            PowerManagerServiceSmtEx.m7538$$Nest$fgetmHandler(this.this$0).post(new AnonymousClass3(this, p));     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void judgeWakeUpLocked() {
            if (this.mProximity != (-1)) goto L5;
            return;
        L5:
            if (this.mProximity != 0) goto L7;
            wakeUpLocked();
            stop();
            return;
        L7:
            Slog.i(PowerManagerServiceSmtEx.TAG, "p-sensor is positive, wait a moment ..");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetLOG_TAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7536$$Nest$fgetLOG_TAG(PowerManagerServiceSmtEx r0) {
        return r0.LOG_TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7537$$Nest$fgetmContext(PowerManagerServiceSmtEx r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7538$$Nest$fgetmHandler(PowerManagerServiceSmtEx r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7539$$Nest$fgetmLock(PowerManagerServiceSmtEx r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManagerService m7540$$Nest$fgetmService(PowerManagerServiceSmtEx r0) {
        return r0.mService;
    }

    public PowerManagerServiceSmtEx(PowerManagerService service, BatterySaverController batterySaverController, Handler handler, Object lock) {
        this.DEBUG_PROCESS = false;
        this.LOG_TAG = "SuperPowerSaveEnabler";
        this.mInCall = false;
        this.mAutoBrightnessCallBack = new AnonymousClass2(this);
        this.mScreenBrightnessAuto = -1.0f;
        this.mSleepToDozeFlag = false;
        this.mLockBrightnessEnabled = new AtomicBoolean(false);
        this.mToSleepRunnable = new AnonymousClass6(this);
        this.mService = service;
        this.mBatterySaverController = batterySaverController;
        this.mHandler = handler;
        this.mLock = lock;
    }

    static {
        IF_REMOVE_GLARE = SystemProperties.getBoolean("debug.glaremonitor.remove", false);
        final String r1 = "brightness";
        BRIGHTNESS = new AnonymousClass1(r1);
    }

    public void setWindowsBackgroundDrawableDelayed(DreamManagerInternal mDreamManager, long delay) {
        this.mHandler.postDelayed(new AnonymousClass3(this), delay);
    }

    public void setContext(Context context) {
        this.mContext = context;
        this.mPSMController = new PowerSaveModeController(this.mContext, this.mHandler);
    }

    protected void initProximitySensorHelper(SensorManager sensorManager) {
        this.mProSensorHelper = new ProximitySensorHelper(this, sensorManager);
    }

    protected void initAutoBrightnessController(Looper looper, Context context, SensorManager sensorManager) {
        this.mAutoBrightnessController = AutoBrightnessController.init(looper, context, sensorManager, this.mAutoBrightnessCallBack);
        this.mAutoBrightnessController.activate();
    }

    public boolean isAutoExitPowerSaveMode() {
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mAutoExitLowPowerMode;     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean isFeaturePhoneMode() {
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mFeaturePhoneModeEnabled;     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean setFeaturePhoneMode(boolean value) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        if (this.mPSMController.isDisablePowerSave() == false) goto L6;
        return false;
    L6:
        long ident = Binder.clearCallingIdentity();
        if (value == false) goto L13;
        boolean r2 = changeToPowerSaveModel();     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(ident);
        return r2;
    L13:
        boolean r3 = changeBackFromPowerSaveModel();     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(ident);
        return r3;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void wakeUpIfPsensorNegative(long eventTime, String reason, String opPackageName) {
        if (eventTime > SystemClock.uptimeMillis()) goto L17;
        this.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        wakeUpIfPsensorNegativeInternal(eventTime, reason, Binder.getCallingUid(), opPackageName);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        th = move-exception;
        Throwable r11 = th;
    L14:
        Binder.restoreCallingIdentity(ident);
        throw r11;
    L12:
        th = move-exception;
        r11 = th;
        goto L14
    L17:
        throw new IllegalArgumentException("event time must not be in the future");
    }

    public void setBrightness(float brightness) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        Slog.d(TAG, "setBrightness calling(" + uid + "," + pid + "), brightness=" + brightness);
        setBrightnessInternal(brightness);
    }

    private void setBrightnessInternal(float brightness) {
    }

    private boolean changeToPowerSaveModel() {
        if (this.DEBUG_PROCESS == false) goto L5;
        Log.d(this.LOG_TAG, "changeToPowerSaveModel- enter");
    L5:
        setStatusBarLocked();
        final boolean powerSaveModeChanged = false;
        this.mPSMController.changeLauncher(false);
        this.mPSMController.closeTorch();
        if (this.mBatterySaverController == null) goto L8;
        boolean beingPowerSaveMode = this.mBatterySaverController.isEnabled();
    L9:
        Settings.Global.putInt(this.mContext.getContentResolver(), "feature_phone_mode", 1);
        this.mFeaturePhoneModeEnabled = true;
        Settings.Global.putInt(this.mContext.getContentResolver(), "low_power", 1);
        this.mLowPowerModeEnabled = true;
        if (beingPowerSaveMode == this.mLowPowerModeEnabled) goto L12;
        powerSaveModeChanged = true;
    L12:
        Intent intent = new Intent("android.os.action.FEATURE_PHONE_MODE_CHANGED");
        intent.putExtra("feature_phone_mode", this.mFeaturePhoneModeEnabled);
        intent.addFlags(128);
        intent.addFlags(1073741824);
        this.mContext.sendBroadcast(intent);
        this.mService.setPowerModeInternal(1, this.mLowPowerModeEnabled);
        BackgroundThread.getHandler().post(new AnonymousClass4(this, powerSaveModeChanged));
        return true;
    L8:
        beingPowerSaveMode = false;
        goto L9
    }

    private boolean changeBackFromPowerSaveModel() {
        if (this.DEBUG_PROCESS == false) goto L5;
        Log.d(this.LOG_TAG, "changeBackFromPowerSaveModel- enter");
    L5:
        resetStatusBar();
        Settings.Global.putInt(this.mContext.getContentResolver(), "feature_phone_mode", 0);
        this.mFeaturePhoneModeEnabled = false;
        Settings.Global.putInt(this.mContext.getContentResolver(), "low_power", 0);
        this.mLowPowerModeEnabled = false;
        this.mPSMController.changeLauncher(true);
        Intent intent = new Intent("android.os.action.FEATURE_PHONE_MODE_CHANGED");
        intent.putExtra("feature_phone_mode", this.mFeaturePhoneModeEnabled);
        intent.addFlags(128);
        intent.addFlags(1073741824);
        this.mContext.sendBroadcast(intent);
        this.mService.setPowerModeInternal(1, this.mLowPowerModeEnabled);
        BackgroundThread.getHandler().post(new AnonymousClass5(this));
        return true;
    }

    private void setStatusBarLocked() {
        if (this.DEBUG_PROCESS == false) goto L5;
        Log.d(this.LOG_TAG, "setStatusBarLocked");
    L5:
        StatusBarManager mStatusBarManager = (StatusBarManager) this.mContext.getSystemService("statusbar");
        if (mStatusBarManager != null) goto L9;
        Log.d(this.LOG_TAG, "setStatusBarLocked -mStatusBarManager is null, so return");
        return;
    L9:
        int flags = 0 | 16777216;
        mStatusBarManager.disable(flags | 65536);
    }

    private void resetStatusBar() {
        if (this.DEBUG_PROCESS == false) goto L5;
        Log.d(this.LOG_TAG, "resetStatusBar");
    L5:
        StatusBarManager mStatusBarManager = (StatusBarManager) this.mContext.getSystemService("statusbar");
        if (mStatusBarManager != null) goto L9;
        Log.d(this.LOG_TAG, "setStatusBarLocked - mStatusBarManager is null, so return");
        return;
    L9:
        mStatusBarManager.disable(0);
    }

    protected void wakeUpIfPsensorNegativeInternal(long eventTime, String reason, int uid, String opPackageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PowerManager pm = (PowerManager) this.mContext.getSystemService("power");     // Catch: Throwable -> L8
        this.mWakeLockForPsensor = pm.newWakeLock(1, "wakeUpIfPsensorNegativeInternal");     // Catch: Throwable -> L8
        this.mWakeLockForPsensor.acquire(600);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mProSensorHelper.work(eventTime, reason);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public float getBrightnessSetting() {
        return this.mScreenBrightnessAuto;
    }

    private boolean isValidBrightnessValue(float brightnessState) {
        if (brightnessState >= 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (brightnessState > 1.0f) goto L7;
        return true;
    }

    public void setAutoBrightness(float brightness) {
    }

    public void initOtherManagerSmtEx(WindowManagerInternalSmtEx internalSmtEx) {
        this.mWindowManagerInternalSmtEx = internalSmtEx;
    }

    public void sleepToDoze() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mService.mWakefulnessRaw != 0) goto L11;
        Trace.traceBegin(131072, "huangxu_Powermanager:sleepToDoze Start");     // Catch: Throwable -> L9
        PowerGroup defaultPowerGroup = this.mService.mPowerGroups.get(0);     // Catch: Throwable -> L9
        defaultPowerGroup.setSandmanSummonedLocked(false);     // Catch: Throwable -> L9
        this.mSleepToDozeFlag = true;     // Catch: Throwable -> L9
        defaultPowerGroup.setWakefulnessLocked(3, SystemClock.uptimeMillis(), 1000, 0, 0, null, null);     // Catch: Throwable -> L9
        this.mService.updatePowerStateLocked();     // Catch: Throwable -> L9
        this.mSleepToDozeFlag = false;     // Catch: Throwable -> L9
        if (this.mLockBrightnessEnabled.get() == true) goto L11;
        this.mLockBrightnessEnabled.set(true);     // Catch: Throwable -> L9
    L11:
        this.mHandler.removeCallbacks(this.mToSleepRunnable);     // Catch: Throwable -> L9
        if (this.mService.mWakefulnessRaw != 3) goto L14;
        this.mHandler.postDelayed(this.mToSleepRunnable, 4000);     // Catch: Throwable -> L9
    L14:
        Trace.traceEnd(131072);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    public int getLatestLux() {
        return -1;
    }

    public long getLastSleepTime() {
        if (this.mService.isGloballyInteractiveInternal() == false) goto L7;
        return 0;
    L7:
        return this.mService.mLastGlobalSleepTime;
    }

    public float getBrightness() {
        return this.mService.mDisplayManagerInternal.getISmtEx().getScreenBrightness();
    }

    public boolean isPhoneInteractive() {
        return false;
    }

    protected void initRampAnimator(PowerManagerService service) {
    }

    public boolean isCallProxLock(PowerManagerService.WakeLock wakeLock) {
        if ((wakeLock.mFlags & 65535) == 32) goto L5;
        return false;
    L5:
        if ("com.android.server.telecom".equals(wakeLock.mPackageName) == false) goto L10;
        return true;
    L10:
        return false;
    }
}
