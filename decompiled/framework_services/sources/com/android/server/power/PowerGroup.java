package com.android.server.power;

import android.hardware.display.DisplayManagerInternal;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.PowerSaveState;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.util.Slog;
import com.android.internal.util.LatencyTracker;
import com.android.server.BaseZswSystemServiceFactory;
import com.android.server.LocalServices;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.power.feature.PowerManagerFlags;

/* JADX INFO: loaded from: classes3.dex */
public class PowerGroup {
    private static final boolean DEBUG = false;
    private static final long INVALID_TIMEOUT = -1;
    private static final String TAG = null;
    private final long mDimDuration;
    private final DisplayManagerInternal mDisplayManagerInternal;
    final DisplayManagerInternal.DisplayPowerRequest mDisplayPowerRequest;
    private IExtPowerGroup mExt;
    private final PowerManagerFlags mFeatureFlags;
    private final int mGroupId;
    private boolean mIsSandmanSummoned;
    private long mLastPowerOnTime;
    private int mLastSleepReason;
    private long mLastSleepTime;
    private int mLastUserActivityEvent;
    private long mLastUserActivityTime;
    private long mLastUserActivityTimeNoChangeLights;
    private int mLastWakeReason;
    private long mLastWakeTime;
    private final Notifier mNotifier;
    private boolean mPoweringOn;
    private boolean mReady;
    private final long mScreenOffTimeout;
    private final boolean mSupportsSandman;
    private int mUserActivitySummary;
    private int mWakeLockSummary;
    private int mWakefulness;
    private final PowerGroupListener mWakefulnessListener;
    private IZswPowerGroup mZswExt;

    protected interface PowerGroupListener {
        void onWakefulnessChangedLocked(int r1, int r2, long r3, int r5, int r6, int r7, String r8, String r9);
    }

    static {
        TAG = PowerGroup.class.getSimpleName();
    }

    PowerGroup(int groupId, PowerGroupListener wakefulnessListener, Notifier notifier, DisplayManagerInternal displayManagerInternal, int wakefulness, boolean ready, boolean supportsSandman, long eventTime, PowerManagerFlags featureFlags) {
        this.mDisplayPowerRequest = new DisplayManagerInternal.DisplayPowerRequest();
        this.mLastWakeReason = 0;
        this.mLastSleepReason = 14;
        this.mExt = (IExtPowerGroup) ExtImplFactory.getImpl(IExtPowerGroup.class, new Object[]{this});
        this.mGroupId = groupId;
        this.mWakefulnessListener = wakefulnessListener;
        this.mNotifier = notifier;
        this.mDisplayManagerInternal = displayManagerInternal;
        this.mWakefulness = wakefulness;
        this.mReady = ready;
        this.mSupportsSandman = supportsSandman;
        this.mLastWakeTime = eventTime;
        this.mLastSleepTime = eventTime;
        this.mFeatureFlags = featureFlags;
        long dimDuration = -1;
        long screenOffTimeout = -1;
        if (this.mGroupId == 0) goto L17;
        VirtualDeviceManagerInternal vdm = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
        if (vdm == null) goto L17;
        int[] displayIds = this.mDisplayManagerInternal.getDisplayIdsForGroup(this.mGroupId);
        if (displayIds == null) goto L17;
        if (displayIds.length <= 0) goto L17;
        int deviceId = vdm.getDeviceIdForDisplayId(displayIds[0]);
        if (vdm.isValidVirtualDeviceId(deviceId) == false) goto L17;
        dimDuration = vdm.getDimDurationMillisForDeviceId(deviceId);
        screenOffTimeout = vdm.getScreenOffTimeoutMillisForDeviceId(deviceId);
        if (dimDuration <= 0) goto L17;
        if (dimDuration <= screenOffTimeout) goto L17;
        dimDuration = screenOffTimeout;
    L17:
        this.mDimDuration = dimDuration;
        this.mScreenOffTimeout = screenOffTimeout;
        this.mZswExt = BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswPowerGroup(this.mGroupId);
    }

    PowerGroup(int wakefulness, PowerGroupListener wakefulnessListener, Notifier notifier, DisplayManagerInternal displayManagerInternal, long eventTime, PowerManagerFlags featureFlags) {
        this.mDisplayPowerRequest = new DisplayManagerInternal.DisplayPowerRequest();
        this.mLastWakeReason = 0;
        this.mLastSleepReason = 14;
        this.mExt = (IExtPowerGroup) ExtImplFactory.getImpl(IExtPowerGroup.class, new Object[]{this});
        this.mGroupId = 0;
        this.mWakefulnessListener = wakefulnessListener;
        this.mNotifier = notifier;
        this.mDisplayManagerInternal = displayManagerInternal;
        this.mWakefulness = wakefulness;
        this.mReady = false;
        this.mSupportsSandman = true;
        this.mLastWakeTime = eventTime;
        this.mLastSleepTime = eventTime;
        this.mFeatureFlags = featureFlags;
        this.mDimDuration = -1;
        this.mScreenOffTimeout = -1;
        this.mZswExt = BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswPowerGroup(this.mGroupId);
    }

    void registerListener(IZswPowerGroup.Listener listener) {
        this.mZswExt.registerListener(listener);
    }

    long getScreenOffTimeoutOverrideLocked(long defaultScreenOffTimeout) {
        if (this.mScreenOffTimeout != (-1)) goto L6;
        return defaultScreenOffTimeout;
    L6:
        return this.mScreenOffTimeout;
    }

    long getScreenDimDurationOverrideLocked(long defaultScreenDimDuration) {
        if (this.mDimDuration != (-1)) goto L6;
        return defaultScreenDimDuration;
    L6:
        return this.mDimDuration;
    }

    long getLastWakeTimeLocked() {
        return this.mLastWakeTime;
    }

    long getLastSleepTimeLocked() {
        return this.mLastSleepTime;
    }

    int getWakefulnessLocked() {
        return this.mWakefulness;
    }

    int getGroupId() {
        return this.mGroupId;
    }

    boolean setWakefulnessLocked(int newWakefulness, long eventTime, int uid, int reason, int opUid, String opPackageName, String details) {
        if (this.mWakefulness != newWakefulness) goto L5;
        return false;
    L5:
        if (newWakefulness != 1) goto L10;
        setLastPowerOnTimeLocked(eventTime);
        setIsPoweringOnLocked(true);
        this.mLastWakeTime = eventTime;
        if (this.mFeatureFlags.isPolicyReasonInDisplayPowerRequestEnabled() == false) goto L16;
        this.mLastWakeReason = reason;
    L16:
        this.mWakefulness = newWakefulness;
        this.mWakefulnessListener.onWakefulnessChangedLocked(this.mGroupId, this.mWakefulness, eventTime, reason, uid, opUid, opPackageName, details);
        return true;
    L10:
        if (PowerManagerInternal.isInteractive(this.mWakefulness) == false) goto L16;
        if (PowerManagerInternal.isInteractive(newWakefulness) == true) goto L16;
        this.mLastSleepTime = eventTime;
        if (this.mFeatureFlags.isPolicyReasonInDisplayPowerRequestEnabled() == false) goto L16;
        this.mLastSleepReason = reason;
        goto L16
    }

    boolean isReadyLocked() {
        return this.mReady;
    }

    boolean setReadyLocked(boolean isReady) {
        if (this.mReady == isReady) goto L6;
        this.mReady = isReady;
        return true;
    L6:
        return false;
    }

    long getLastPowerOnTimeLocked() {
        return this.mLastPowerOnTime;
    }

    void setLastPowerOnTimeLocked(long time) {
        this.mLastPowerOnTime = time;
    }

    boolean isPoweringOnLocked() {
        return this.mPoweringOn;
    }

    void setIsPoweringOnLocked(boolean isPoweringOnNew) {
        this.mPoweringOn = isPoweringOnNew;
    }

    boolean isSandmanSummonedLocked() {
        return this.mIsSandmanSummoned;
    }

    void setSandmanSummonedLocked(boolean isSandmanSummoned) {
        this.mIsSandmanSummoned = isSandmanSummoned;
    }

    void wakeUpLocked(long eventTime, int reason, String details, int uid, String opPackageName, int opUid, LatencyTracker latencyTracker) {
        if (eventTime < this.mLastSleepTime) goto L27;
        if (this.mWakefulness == 1) goto L27;
        Trace.traceBegin(131072, "wakePowerGroup" + this.mGroupId);
        Slog.i(TAG, "Waking up power group from " + PowerManagerInternal.wakefulnessToString(this.mWakefulness) + " (groupId=" + this.mGroupId + ", uid=" + uid + ", reason=" + PowerManager.wakeReasonToString(reason) + ", details=" + details + ")...");     // Catch: Throwable -> L22
        Trace.asyncTraceBegin(131072, "Screen turning on", this.mGroupId);     // Catch: Throwable -> L22
        latencyTracker.onActionStart(5, String.valueOf(this.mGroupId));     // Catch: Throwable -> L20
        setWakefulnessLocked(1, eventTime, uid, reason, opUid, opPackageName, details);     // Catch: Throwable -> L18
        this.mZswExt.wakeUpLocked(reason, uid, details);     // Catch: Throwable -> L18
        Trace.traceEnd(131072);
        return;
    L18:
        th = th;
    L24:
        Trace.traceEnd(131072);
        throw th;
    L20:
        th = th;
    L22:
        th = th;
    L27:
        this.mZswExt.exitFakeSleep();
    }

    boolean dreamLocked(long eventTime, int uid, boolean allowWake) {
        if (eventTime >= this.mLastWakeTime) goto L5;
        return false;
    L5:
        if (allowWake == false) goto L7;
    L9:
        Trace.traceBegin(131072, "dreamPowerGroup" + getGroupId());
        Slog.i(TAG, "Napping power group (groupId=" + getGroupId() + ", uid=" + uid + ")...");     // Catch: Throwable -> L13
        setSandmanSummonedLocked(true);     // Catch: Throwable -> L13
        setWakefulnessLocked(2, eventTime, uid, 0, 0, null, null);     // Catch: Throwable -> L13
        Trace.traceEnd(131072);
        return true;
    L13:
        th = move-exception;
        Trace.traceEnd(131072);
        throw th;
    L7:
        if (this.mWakefulness == 1) goto L9;
        return false;
    }

    boolean dozeLocked(long eventTime, int uid, int reason) {
        if (eventTime >= getLastWakeTimeLocked()) goto L5;
    L22:
        return false;
    L5:
        if (PowerManagerInternal.isInteractive(this.mWakefulness) == false) goto L22;
        if (this.mZswExt.enterFakeSleep(reason) == false) goto L10;
        return false;
    L10:
        this.mExt.boostPower();
        Trace.traceBegin(131072, "powerOffDisplay");
        int reason2 = Math.min(20, Math.max(reason, 0));     // Catch: Throwable -> L18
        long millisSinceLastUserActivity = eventTime - Math.max(this.mLastUserActivityTimeNoChangeLights, this.mLastUserActivityTime);     // Catch: Throwable -> L16
        Slog.i(TAG, "Powering off display group due to " + PowerManager.sleepReasonToString(reason2) + " (groupId= " + getGroupId() + ", uid= " + uid + ", millisSinceLastUserActivity=" + millisSinceLastUserActivity + ", lastUserActivityEvent=" + PowerManager.userActivityEventToString(this.mLastUserActivityEvent) + ")...");     // Catch: Throwable -> L16
        setSandmanSummonedLocked(true);     // Catch: Throwable -> L16
        setWakefulnessLocked(3, eventTime, uid, reason2, 0, null, null);     // Catch: Throwable -> L16
        this.mZswExt.dozeLocked(reason2);     // Catch: Throwable -> L16
        Trace.traceEnd(131072);
        return true;
    L16:
        th = th;
    L20:
        Trace.traceEnd(131072);
        throw th;
    L18:
        th = th;
        goto L20
    }

    boolean sleepLocked(long eventTime, int uid, int reason) {
        if (eventTime >= this.mLastWakeTime) goto L5;
        return false;
    L5:
        if (getWakefulnessLocked() == 0) goto L18;
        Trace.traceBegin(131072, "sleepPowerGroup");
        Slog.i(TAG, "Sleeping power group (groupId=" + getGroupId() + ", uid=" + uid + ", reason=" + PowerManager.sleepReasonToString(reason) + ")...");     // Catch: Throwable -> L11
        setSandmanSummonedLocked(true);     // Catch: Throwable -> L11
        setWakefulnessLocked(0, eventTime, uid, reason, 0, null, null);     // Catch: Throwable -> L11
        Trace.traceEnd(131072);
        return true;
    L11:
        th = move-exception;
        Trace.traceEnd(131072);
        throw th;
    L18:
        return false;
    }

    long getLastUserActivityTimeLocked() {
        return this.mLastUserActivityTime;
    }

    void setLastUserActivityTimeLocked(long lastUserActivityTime, int event) {
        this.mLastUserActivityTime = lastUserActivityTime;
        this.mLastUserActivityEvent = event;
    }

    public long getLastUserActivityTimeNoChangeLightsLocked() {
        return this.mLastUserActivityTimeNoChangeLights;
    }

    public void setLastUserActivityTimeNoChangeLightsLocked(long time, int event) {
        this.mLastUserActivityTimeNoChangeLights = time;
        this.mLastUserActivityEvent = event;
    }

    public int getUserActivitySummaryLocked() {
        return this.mUserActivitySummary;
    }

    public boolean isPolicyBrightLocked() {
        if (this.mDisplayPowerRequest.policy != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPolicyDimLocked() {
        if (this.mDisplayPowerRequest.policy != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBrightOrDimLocked() {
        return this.mDisplayPowerRequest.isBrightOrDim();
    }

    public void setUserActivitySummaryLocked(int summary) {
        this.mUserActivitySummary = summary;
    }

    public int getWakeLockSummaryLocked() {
        return this.mWakeLockSummary;
    }

    public boolean hasWakeLockKeepingScreenOnLocked() {
        if ((this.mWakeLockSummary & 38) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getScreenTimeoutPolicy() {
        if (hasWakeLockKeepingScreenOnLocked() == false) goto L5;
        return 1;
    L5:
        return 0;
    }

    public void setWakeLockSummaryLocked(int summary) {
        this.mWakeLockSummary = summary;
    }

    public boolean supportsSandmanLocked() {
        return this.mSupportsSandman;
    }

    boolean needSuspendBlockerLocked(boolean proximityPositive, boolean suspendWhenScreenOffDueToProximityConfig) {
        if (isBrightOrDimLocked() == false) goto L10;
        if (this.mDisplayPowerRequest.useProximitySensor == false) goto L8;
        if (proximityPositive == false) goto L8;
        if (suspendWhenScreenOffDueToProximityConfig == true) goto L10;
    L8:
        return true;
    L10:
        if (this.mDisplayPowerRequest.policy == 1) goto L12;
        return false;
    L12:
        if (this.mDisplayPowerRequest.dozeScreenState != 2) goto L16;
        return true;
    L16:
        return false;
    }

    private void updateScreenPolicyLocked(boolean quiescent, boolean dozeAfterScreenOff, boolean bootCompleted, boolean screenBrightnessBoostInProgress, boolean brightWhenDozing) {
        int wakefulness = getWakefulnessLocked();
        int wakeLockSummary = getWakeLockSummaryLocked();
        int policyReason = 1;
        int policy = Integer.MAX_VALUE;
        if (quiescent == false) goto L5;
        policy = 0;
    L17:
        if (policy != Integer.MAX_VALUE) goto L31;
        if (PowerManagerInternal.isInteractive(wakefulness) == false) goto L22;
        policyReason = wakeReasonToDisplayStateReason(this.mLastWakeReason);
    L22:
        if ((wakeLockSummary & 2) != 0) goto L29;
        if (bootCompleted == false) goto L29;
        if ((getUserActivitySummaryLocked() & 1) != 0) goto L29;
        if (screenBrightnessBoostInProgress == true) goto L29;
        policy = 2;
    L29:
        policy = 3;
    L31:
        if (this.mFeatureFlags.isPolicyReasonInDisplayPowerRequestEnabled() == false) goto L33;
        this.mDisplayPowerRequest.policyReason = policyReason;
    L33:
        this.mDisplayPowerRequest.policy = policy;
        this.mExt.updateScreenPolicyLocked();
        return;
    L5:
        if (wakefulness != 0) goto L8;
        policy = 0;
        policyReason = sleepReasonToDisplayStateReason(this.mLastSleepReason);
        goto L17
    L8:
        if (wakefulness != 3) goto L17;
        if ((wakeLockSummary & 64) == 0) goto L12;
        policy = 1;
        goto L17
    L12:
        if (dozeAfterScreenOff == false) goto L14;
        policy = 0;
        goto L17
    L14:
        if (brightWhenDozing == false) goto L17;
        policy = 3;
        goto L17
    }

    int getPolicyLocked() {
        return this.mDisplayPowerRequest.policy;
    }

    boolean updateLocked(float screenBrightnessOverride, CharSequence overrideTag, boolean useProximitySensor, boolean boostScreenBrightness, int dozeScreenState, int dozeScreenStateReason, float dozeScreenBrightness, boolean useNormalBrightnessForDoze, boolean overrideDrawWakeLock, PowerSaveState powerSaverState, boolean quiescent, boolean dozeAfterScreenOff, boolean bootCompleted, boolean screenBrightnessBoostInProgress, boolean waitForNegativeProximity, boolean brightWhenDozing) {
        updateScreenPolicyLocked(quiescent, dozeAfterScreenOff, bootCompleted, screenBrightnessBoostInProgress, brightWhenDozing);
        this.mDisplayPowerRequest.screenBrightnessOverride = screenBrightnessOverride;
        this.mDisplayPowerRequest.screenBrightnessOverrideTag = overrideTag;
        this.mDisplayPowerRequest.useProximitySensor = useProximitySensor;
        this.mDisplayPowerRequest.boostScreenBrightness = boostScreenBrightness;
        if (this.mDisplayPowerRequest.policy != 1) goto L14;
        this.mDisplayPowerRequest.dozeScreenState = dozeScreenState;
        this.mDisplayPowerRequest.dozeScreenStateReason = dozeScreenStateReason;
        if ((getWakeLockSummaryLocked() & 128) == 0) goto L13;
        if (overrideDrawWakeLock == true) goto L13;
        if (this.mDisplayPowerRequest.dozeScreenState != 4) goto L11;
        this.mDisplayPowerRequest.dozeScreenState = 3;
        this.mDisplayPowerRequest.dozeScreenStateReason = 2;
    L11:
        if (this.mDisplayPowerRequest.dozeScreenState != 6) goto L13;
        this.mDisplayPowerRequest.dozeScreenState = 2;
        this.mDisplayPowerRequest.dozeScreenStateReason = 2;
    L13:
        this.mDisplayPowerRequest.dozeScreenBrightness = dozeScreenBrightness;
        this.mDisplayPowerRequest.useNormalBrightnessForDoze = useNormalBrightnessForDoze;
        this.mExt.updateDozeScreenBrightness(this.mDisplayPowerRequest);
    L15:
        DisplayManagerInternal.DisplayPowerRequest r2 = this.mDisplayPowerRequest;
        r2.lowPowerMode = powerSaverState.batterySaverEnabled;
        DisplayManagerInternal.DisplayPowerRequest r3 = this.mDisplayPowerRequest;
        r3.screenLowPowerBrightnessFactor = powerSaverState.brightnessFactor;
        boolean ready = this.mDisplayManagerInternal.requestPowerState(this.mGroupId, this.mDisplayPowerRequest, waitForNegativeProximity);
        this.mNotifier.onScreenPolicyUpdate(this.mGroupId, this.mDisplayPowerRequest.policy);
        return ready;
    L14:
        DisplayManagerInternal.DisplayPowerRequest r4 = this.mDisplayPowerRequest;
        r4.lastDozeScreenBrightness = this.mDisplayPowerRequest.dozeScreenBrightness;
        this.mDisplayPowerRequest.dozeScreenState = 0;
        this.mDisplayPowerRequest.dozeScreenBrightness = Float.NaN;
        this.mDisplayPowerRequest.dozeScreenStateReason = 1;
        this.mDisplayPowerRequest.useNormalBrightnessForDoze = false;
        goto L15
    }

    private static int wakeReasonToDisplayStateReason(int wakeReason) {
        switch(wakeReason) {
            case 1: goto L9;
            case 6: goto L9;
            case 7: goto L7;
            case 14: goto L5;
            default: goto L3;
        };
    L3:
        return 1;
    L5:
        return 4;
    L7:
        return 7;
    L9:
        return 6;
    }

    private static int sleepReasonToDisplayStateReason(int sleepReason) {
        switch(sleepReason) {
            case 4: goto L5;
            case 5: goto L3;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return 1;
    L5:
        return 6;
    }

    public IExtPowerGroup getExt() {
        return this.mExt;
    }
}
