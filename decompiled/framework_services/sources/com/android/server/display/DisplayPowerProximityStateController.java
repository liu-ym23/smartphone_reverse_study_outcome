package com.android.server.display;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.pico.utils.ExtImplFactory;
import android.util.Slog;
import android.util.TimeUtils;
import com.android.server.display.utils.SensorUtils;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayPowerProximityStateController {
    private static final boolean DEBUG_PRETEND_PROXIMITY_SENSOR_ABSENT = false;
    private static final int MSG_IGNORE_PROXIMITY = 2;
    static final int MSG_PROXIMITY_SENSOR_DEBOUNCED = 1;
    private static final int PROXIMITY_NEGATIVE = 0;
    static final int PROXIMITY_POSITIVE = 1;
    private static final int PROXIMITY_SENSOR_NEGATIVE_DEBOUNCE_DELAY = 0;
    static final int PROXIMITY_SENSOR_POSITIVE_DEBOUNCE_DELAY = 0;
    static final int PROXIMITY_UNKNOWN = -1;
    private static final float TYPICAL_PROXIMITY_THRESHOLD = 5.0f;
    private final Clock mClock;
    private DisplayDeviceConfig mDisplayDeviceConfig;
    private final int mDisplayId;
    private IExtDisplayPowerProximityStateController mExt;
    private final DisplayPowerProximityStateHandler mHandler;
    private boolean mIgnoreProximityUntilChanged;
    private final Object mLock;
    private final Runnable mNudgeUpdatePowerState;
    private int mPendingProximity;
    private long mPendingProximityDebounceTime;
    private boolean mPendingWaitForNegativeProximityLocked;
    private int mProximity;
    private Sensor mProximitySensor;
    private boolean mProximitySensorEnabled;
    private final SensorEventListener mProximitySensorListener;
    private float mProximityThreshold;
    private boolean mScreenOffBecauseOfProximity;
    private final SensorManager mSensorManager;
    private boolean mSkipRampBecauseOfProximityChangeToNegative;
    private final String mTag;
    private boolean mWaitingForNegativeProximity;
    private final WakelockController mWakelockController;

    interface Clock {
        long uptimeMillis();
    }

    private class DisplayPowerProximityStateHandler extends Handler {
        final /* synthetic */ DisplayPowerProximityStateController this$0;

        DisplayPowerProximityStateHandler(DisplayPowerProximityStateController r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L6;
                case 2: goto L5;
                default: goto L9;
            };
        L5:
            this.this$0.ignoreProximitySensorUntilChangedInternal();
            return;
        L6:
            DisplayPowerProximityStateController.m3776$$Nest$mdebounceProximitySensor(this.this$0);
            return;
        }
    }

    static class Injector {
        Injector() {
        }

        Clock createClock() {
            return new DisplayPowerProximityStateController$Injector$$ExternalSyntheticLambda0();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ProximityState {
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Clock m3771$$Nest$fgetmClock(DisplayPowerProximityStateController r0) {
        return r0.mClock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtDisplayPowerProximityStateController m3772$$Nest$fgetmExt(DisplayPowerProximityStateController r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProximitySensorEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3773$$Nest$fgetmProximitySensorEnabled(DisplayPowerProximityStateController r0) {
        return r0.mProximitySensorEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProximityThreshold, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m3774$$Nest$fgetmProximityThreshold(DisplayPowerProximityStateController r0) {
        return r0.mProximityThreshold;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3775$$Nest$fgetmTag(DisplayPowerProximityStateController r0) {
        return r0.mTag;
    }

    /* JADX INFO: renamed from: -$$Nest$mdebounceProximitySensor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3776$$Nest$mdebounceProximitySensor(DisplayPowerProximityStateController r0) {
        r0.debounceProximitySensor();
    }

    public DisplayPowerProximityStateController(WakelockController wakeLockController, DisplayDeviceConfig displayDeviceConfig, Looper looper, Runnable nudgeUpdatePowerState, int displayId, SensorManager sensorManager) {
        this(wakeLockController, displayDeviceConfig, looper, nudgeUpdatePowerState, displayId, sensorManager, new Injector());
    }

    DisplayPowerProximityStateController(WakelockController wakeLockController, DisplayDeviceConfig displayDeviceConfig, Looper looper, Runnable nudgeUpdatePowerState, int displayId, SensorManager sensorManager, Injector injector) {
        this.mExt = (IExtDisplayPowerProximityStateController) ExtImplFactory.getImpl(IExtDisplayPowerProximityStateController.class, new Object[]{this});
        this.mLock = new Object();
        this.mProximitySensorListener = new AnonymousClass1(this);
        this.mPendingProximityDebounceTime = -1;
        this.mPendingProximity = -1;
        this.mProximity = -1;
        this.mSkipRampBecauseOfProximityChangeToNegative = false;
        if (injector != null) goto L5;
        injector = new Injector();
    L5:
        this.mClock = injector.createClock();
        this.mWakelockController = wakeLockController;
        this.mHandler = new DisplayPowerProximityStateHandler(this, looper);
        this.mNudgeUpdatePowerState = nudgeUpdatePowerState;
        this.mDisplayDeviceConfig = displayDeviceConfig;
        this.mDisplayId = displayId;
        this.mTag = "DisplayPowerProximityStateController[" + this.mDisplayId + "]";
        this.mSensorManager = sensorManager;
        loadProximitySensor();
        if (this.mExt == null) goto L9;
        this.mExt.init(sensorManager, this.mHandler);
        return;
    }

    public void updatePendingProximityRequestsLocked() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mWaitingForNegativeProximity |= this.mPendingWaitForNegativeProximityLocked;     // Catch: Throwable -> L7
        this.mPendingWaitForNegativeProximityLocked = false;     // Catch: Throwable -> L7
        if (this.mIgnoreProximityUntilChanged == false) goto L9;
        this.mWaitingForNegativeProximity = false;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanup() {
        setProximitySensorEnabled(false);
    }

    public boolean isProximitySensorAvailable() {
        if (this.mProximitySensor == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean setPendingWaitForNegativeProximityLocked(boolean requestWaitForNegativeProximity) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (requestWaitForNegativeProximity == true) goto L17;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L17:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mPendingWaitForNegativeProximityLocked == true) goto L12;
        this.mPendingWaitForNegativeProximityLocked = true;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    }

    public void updateProximityState(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest, int displayState) {
        this.mSkipRampBecauseOfProximityChangeToNegative = false;
        if (this.mProximitySensor != null) goto L5;
        setProximitySensorEnabled(false);
        this.mWaitingForNegativeProximity = false;
        this.mIgnoreProximityUntilChanged = false;
        if (this.mScreenOffBecauseOfProximity == false) goto L36;
        this.mScreenOffBecauseOfProximity = false;
        this.mSkipRampBecauseOfProximityChangeToNegative = true;
        sendOnProximityNegativeWithWakelock();
    L36:
        if (this.mExt == null) goto L39;
        this.mExt.updatePickUpState(this.mProximitySensorEnabled, displayPowerRequest.inCall);
        return;
    L39:
        return;
    L5:
        if (displayPowerRequest.useProximitySensor == false) goto L15;
        if (displayState == 1) goto L15;
        setProximitySensorEnabled(true);
        if (this.mScreenOffBecauseOfProximity == true) goto L26;
        if (this.mProximity != 1) goto L26;
        if (this.mIgnoreProximityUntilChanged == true) goto L26;
        this.mScreenOffBecauseOfProximity = true;
        sendOnProximityPositiveWithWakelock();
    L26:
        if (this.mScreenOffBecauseOfProximity == false) goto L36;
        if (this.mProximity == 1) goto L30;
    L31:
        this.mScreenOffBecauseOfProximity = false;
        this.mSkipRampBecauseOfProximityChangeToNegative = true;
        sendOnProximityNegativeWithWakelock();
        goto L36
    L30:
        if (this.mIgnoreProximityUntilChanged == false) goto L36;
    L15:
        if (this.mWaitingForNegativeProximity == false) goto L23;
        if (this.mScreenOffBecauseOfProximity == false) goto L23;
        if (this.mProximity != 1) goto L23;
        if (displayState == 1) goto L23;
        setProximitySensorEnabled(true);
    L23:
        if (displayPowerRequest.useProximitySensor == true) goto L26;
        setProximitySensorEnabled(false);
        this.mWaitingForNegativeProximity = false;
        goto L26
    }

    public boolean shouldSkipRampBecauseOfProximityChangeToNegative() {
        return this.mSkipRampBecauseOfProximityChangeToNegative;
    }

    public boolean isScreenOffBecauseOfProximity() {
        return this.mScreenOffBecauseOfProximity;
    }

    public void ignoreProximitySensorUntilChanged() {
        this.mHandler.sendEmptyMessage(2);
    }

    public void notifyDisplayDeviceChanged(DisplayDeviceConfig displayDeviceConfig) {
        this.mDisplayDeviceConfig = displayDeviceConfig;
        loadProximitySensor();
    }

    public void dumpLocal(PrintWriter pw) {
        pw.println();
        pw.println("DisplayPowerProximityStateController:");
        pw.println("-------------------------------------");
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("  mPendingWaitForNegativeProximityLocked=" + this.mPendingWaitForNegativeProximityLocked);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        pw.println("  mDisplayId=" + this.mDisplayId);
        pw.println("  mWaitingForNegativeProximity=" + this.mWaitingForNegativeProximity);
        pw.println("  mIgnoreProximityUntilChanged=" + this.mIgnoreProximityUntilChanged);
        pw.println("  mProximitySensor=" + this.mProximitySensor);
        pw.println("  mProximitySensorEnabled=" + this.mProximitySensorEnabled);
        pw.println("  mProximityThreshold=" + this.mProximityThreshold);
        pw.println("  mProximity=" + proximityToString(this.mProximity));
        pw.println("  mPendingProximity=" + proximityToString(this.mPendingProximity));
        pw.println("  mPendingProximityDebounceTime=" + TimeUtils.formatUptime(this.mPendingProximityDebounceTime));
        pw.println("  mScreenOffBecauseOfProximity=" + this.mScreenOffBecauseOfProximity);
        pw.println("  mSkipRampBecauseOfProximityChangeToNegative=" + this.mSkipRampBecauseOfProximityChangeToNegative);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void ignoreProximitySensorUntilChangedInternal() {
        if (this.mIgnoreProximityUntilChanged == false) goto L5;
        return;
    L5:
        if (this.mProximity != 1) goto L9;
        this.mIgnoreProximityUntilChanged = true;
        Slog.i(this.mTag, "Ignoring proximity");
        this.mNudgeUpdatePowerState.run();
        return;
    }

    private void sendOnProximityPositiveWithWakelock() {
        this.mWakelockController.acquireWakelock(1);
        this.mHandler.post(this.mWakelockController.getOnProximityPositiveRunnable());
    }

    private void sendOnProximityNegativeWithWakelock() {
        this.mWakelockController.acquireWakelock(2);
        this.mHandler.post(this.mWakelockController.getOnProximityNegativeRunnable());
    }

    private void loadProximitySensor() {
        if (this.mDisplayId == 0) goto L5;
        return;
    L5:
        this.mProximitySensor = SensorUtils.findSensor(this.mSensorManager, this.mDisplayDeviceConfig.getProximitySensor(), 8);
        if (this.mProximitySensor == null) goto L9;
        this.mProximityThreshold = Math.min(this.mProximitySensor.getMaximumRange(), TYPICAL_PROXIMITY_THRESHOLD);
        return;
    }

    private void setProximitySensorEnabled(boolean enable) {
        Slog.d(this.mTag, "setProximitySensorEnabled : " + this.mProximitySensorEnabled + "->" + enable);
        if (enable == false) goto L8;
        if (this.mProximitySensorEnabled == true) goto L13;
        this.mProximitySensorEnabled = true;
        this.mIgnoreProximityUntilChanged = false;
        this.mSensorManager.registerListener(this.mProximitySensorListener, this.mProximitySensor, 3, this.mHandler);
        return;
    L13:
        return;
    L8:
        if (this.mProximitySensorEnabled == false) goto L15;
        this.mProximitySensorEnabled = false;
        this.mProximity = -1;
        this.mIgnoreProximityUntilChanged = false;
        this.mPendingProximity = -1;
        this.mHandler.removeMessages(1);
        this.mSensorManager.unregisterListener(this.mProximitySensorListener);
        boolean proxDebounceSuspendBlockerReleased = this.mWakelockController.releaseWakelock(3);
        if (proxDebounceSuspendBlockerReleased == false) goto L16;
        this.mPendingProximityDebounceTime = -1;
        return;
    L16:
        return;
    }

    protected void handleProximitySensorEvent(long time, boolean positive) {
        if (this.mProximitySensorEnabled == true) goto L5;
        return;
    L5:
        if (this.mPendingProximity != 0) goto L9;
        if (positive == true) goto L9;
        return;
    L9:
        if (this.mPendingProximity != 1) goto L12;
        if (positive == false) goto L12;
        return;
    L12:
        this.mHandler.removeMessages(1);
        if (positive == false) goto L15;
        this.mPendingProximity = 1;
        this.mPendingProximityDebounceTime = 0 + time;
        this.mWakelockController.acquireWakelock(3);
    L16:
        debounceProximitySensor();
        return;
    L15:
        this.mPendingProximity = 0;
        this.mPendingProximityDebounceTime = 0 + time;
        this.mWakelockController.acquireWakelock(3);
        goto L16
    }

    private void debounceProximitySensor() {
        if (this.mProximitySensorEnabled == true) goto L5;
        return;
    L5:
        if (this.mPendingProximity != (-1)) goto L7;
        return;
    L7:
        if (this.mPendingProximityDebounceTime < 0) goto L21;
        long now = this.mClock.uptimeMillis();
        if (this.mPendingProximityDebounceTime <= now) goto L11;
        Message msg = this.mHandler.obtainMessage(1);
        this.mHandler.sendMessageAtTime(msg, this.mPendingProximityDebounceTime);
        return;
    L11:
        if (this.mProximity == this.mPendingProximity) goto L13;
        this.mIgnoreProximityUntilChanged = false;
        Slog.i(this.mTag, "Applying proximity: " + proximityToString(this.mPendingProximity));
    L13:
        this.mProximity = this.mPendingProximity;
        this.mNudgeUpdatePowerState.run();
        boolean proxDebounceSuspendBlockerReleased = this.mWakelockController.releaseWakelock(3);
        if (proxDebounceSuspendBlockerReleased == false) goto L23;
        this.mPendingProximityDebounceTime = -1;
        return;
    L23:
        return;
    }

    private String proximityToString(int state) {
        switch(state) {
            case -1: goto L9;
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "Positive";
    L7:
        return "Negative";
    L9:
        return "Unknown";
    L4:
        return Integer.toString(state);
    }

    boolean getPendingWaitForNegativeProximityLocked() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mPendingWaitForNegativeProximityLocked;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean getWaitingForNegativeProximity() {
        return this.mWaitingForNegativeProximity;
    }

    boolean shouldIgnoreProximityUntilChanged() {
        return this.mIgnoreProximityUntilChanged;
    }

    boolean isProximitySensorEnabled() {
        return this.mProximitySensorEnabled;
    }

    Handler getHandler() {
        return this.mHandler;
    }

    int getPendingProximity() {
        return this.mPendingProximity;
    }

    int getProximity() {
        return this.mProximity;
    }

    long getPendingProximityDebounceTime() {
        return this.mPendingProximityDebounceTime;
    }

    SensorEventListener getProximitySensorListener() {
        return this.mProximitySensorListener;
    }
}
