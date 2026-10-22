package com.android.server.display;

import android.hardware.display.DisplayManagerInternal;
import android.util.Slog;
import com.android.server.display.utils.DebugUtils;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class WakelockController {
    private static final boolean DEBUG = false;
    private static final String TAG = "WakelockController";
    static final int WAKE_LOCK_MAX = 6;
    public static final int WAKE_LOCK_OVERRIDE_DOZE_SCREEN_STATE = 5;
    public static final int WAKE_LOCK_PROXIMITY_DEBOUNCE = 3;
    public static final int WAKE_LOCK_PROXIMITY_NEGATIVE = 2;
    public static final int WAKE_LOCK_PROXIMITY_POSITIVE = 1;
    public static final int WAKE_LOCK_STATE_CHANGED = 4;
    public static final int WAKE_LOCK_UNFINISHED_BUSINESS = 6;
    private final int mDisplayId;
    private final DisplayManagerInternal.DisplayPowerCallbacks mDisplayPowerCallbacks;
    private boolean mHasProximityDebounced;
    private boolean mIsOverrideDozeScreenStateAcquired;
    private boolean mIsProximityNegativeAcquired;
    private boolean mIsProximityPositiveAcquired;
    private final Object mLock;
    private boolean mOnStateChangedPending;
    private final String mSuspendBlockerIdOnStateChanged;
    private final String mSuspendBlockerIdProxDebounce;
    private final String mSuspendBlockerIdProxNegative;
    private final String mSuspendBlockerIdProxPositive;
    private final String mSuspendBlockerIdUnfinishedBusiness;
    private final String mSuspendBlockerOverrideDozeScreenState;
    private final String mTag;
    private boolean mUnfinishedBusiness;

    @Retention(RetentionPolicy.SOURCE)
    public @interface WAKE_LOCK_TYPE {
    }

    /* JADX INFO: renamed from: $r8$lambda$DC3Jjdcy5pC5tkL4-1bzHZx_j9Q, reason: not valid java name */
    public static /* synthetic */ void m3901$r8$lambda$DC3Jjdcy5pC5tkL41bzHZx_j9Q(WakelockController r0) {
        r0.lambda$getOnStateChangedRunnable$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$IvKh1ddXhKb-OhNkChFV9eFYY68, reason: not valid java name */
    public static /* synthetic */ void m3902$r8$lambda$IvKh1ddXhKbOhNkChFV9eFYY68(WakelockController r0) {
        r0.lambda$getOnProximityPositiveRunnable$0();
    }

    public static /* synthetic */ void $r8$lambda$Mv9NP1W90VpZtg1gBnYyNVVck1s(WakelockController r0) {
        r0.lambda$getOnProximityNegativeRunnable$2();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    public WakelockController(int displayId, DisplayManagerInternal.DisplayPowerCallbacks callbacks) {
        this.mLock = new Object();
        this.mDisplayId = displayId;
        this.mTag = "WakelockController[" + this.mDisplayId + "]";
        this.mDisplayPowerCallbacks = callbacks;
        this.mSuspendBlockerIdUnfinishedBusiness = "[" + displayId + "]unfinished business";
        this.mSuspendBlockerOverrideDozeScreenState = "[" + displayId + "]override doze screen state";
        this.mSuspendBlockerIdOnStateChanged = "[" + displayId + "]on state changed";
        this.mSuspendBlockerIdProxPositive = "[" + displayId + "]prox positive";
        this.mSuspendBlockerIdProxNegative = "[" + displayId + "]prox negative";
        this.mSuspendBlockerIdProxDebounce = "[" + displayId + "]prox debounce";
    }

    public boolean acquireWakelock(int wakelock) {
        return acquireWakelockInternal(wakelock);
    }

    public boolean releaseWakelock(int wakelock) {
        return releaseWakelockInternal(wakelock);
    }

    public void releaseAll() {
        int i = 1;
    L4:
        if (i > 6) goto L7;
        releaseWakelockInternal(i);
        i = i + 1;
        goto L4
    }

    private boolean acquireWakelockInternal(int wakelock) {
        switch(wakelock) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L4;
        };
    L7:
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = acquireOverrideDozeScreenStateSuspendBlockerLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Invalid wakelock attempted to be acquired");
    L6:
        return acquireUnfinishedBusinessSuspendBlocker();
    L16:
        return acquireStateChangedSuspendBlocker();
    L18:
        return acquireProxDebounceSuspendBlocker();
    L20:
        return acquireProxNegativeSuspendBlocker();
    L22:
        return acquireProxPositiveSuspendBlocker();
    }

    private boolean releaseWakelockInternal(int wakelock) {
        switch(wakelock) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L4;
        };
    L7:
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = releaseOverrideDozeScreenStateSuspendBlockerLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("Invalid wakelock attempted to be released");
    L6:
        return releaseUnfinishedBusinessSuspendBlocker();
    L16:
        return releaseStateChangedSuspendBlocker();
    L18:
        return releaseProxDebounceSuspendBlocker();
    L20:
        return releaseProxNegativeSuspendBlocker();
    L22:
        return releaseProxPositiveSuspendBlocker();
    }

    private boolean acquireProxPositiveSuspendBlocker() {
        if (this.mIsProximityPositiveAcquired == true) goto L6;
        this.mDisplayPowerCallbacks.acquireSuspendBlocker(this.mSuspendBlockerIdProxPositive);
        this.mIsProximityPositiveAcquired = true;
        return true;
    L6:
        return false;
    }

    private boolean acquireStateChangedSuspendBlocker() {
        if (this.mOnStateChangedPending == false) goto L5;
        return false;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(this.mTag, "State Changed...");
    L7:
        this.mDisplayPowerCallbacks.acquireSuspendBlocker(this.mSuspendBlockerIdOnStateChanged);
        this.mOnStateChangedPending = true;
        return true;
    }

    private boolean releaseStateChangedSuspendBlocker() {
        if (this.mOnStateChangedPending == false) goto L6;
        this.mDisplayPowerCallbacks.releaseSuspendBlocker(this.mSuspendBlockerIdOnStateChanged);
        this.mOnStateChangedPending = false;
        return true;
    L6:
        return false;
    }

    private boolean acquireOverrideDozeScreenStateSuspendBlockerLocked() {
        if (this.mIsOverrideDozeScreenStateAcquired == false) goto L5;
        return false;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(this.mTag, "Acquiring suspend blocker to override the doze screen state...");
    L7:
        this.mDisplayPowerCallbacks.acquireSuspendBlocker(this.mSuspendBlockerOverrideDozeScreenState);
        this.mIsOverrideDozeScreenStateAcquired = true;
        return true;
    }

    private boolean releaseOverrideDozeScreenStateSuspendBlockerLocked() {
        if (this.mIsOverrideDozeScreenStateAcquired == true) goto L5;
        return false;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(this.mTag, "Finished overriding doze screen state...");
    L7:
        this.mDisplayPowerCallbacks.releaseSuspendBlocker(this.mSuspendBlockerOverrideDozeScreenState);
        this.mIsOverrideDozeScreenStateAcquired = false;
        return true;
    }

    private boolean acquireUnfinishedBusinessSuspendBlocker() {
        if (this.mUnfinishedBusiness == false) goto L5;
        return false;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(this.mTag, "Unfinished business...");
    L7:
        this.mDisplayPowerCallbacks.acquireSuspendBlocker(this.mSuspendBlockerIdUnfinishedBusiness);
        this.mUnfinishedBusiness = true;
        return true;
    }

    private boolean releaseUnfinishedBusinessSuspendBlocker() {
        if (this.mUnfinishedBusiness == true) goto L5;
        return false;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(this.mTag, "Finished business...");
    L7:
        this.mDisplayPowerCallbacks.releaseSuspendBlocker(this.mSuspendBlockerIdUnfinishedBusiness);
        this.mUnfinishedBusiness = false;
        return true;
    }

    private boolean releaseProxPositiveSuspendBlocker() {
        if (this.mIsProximityPositiveAcquired == false) goto L6;
        this.mDisplayPowerCallbacks.releaseSuspendBlocker(this.mSuspendBlockerIdProxPositive);
        this.mIsProximityPositiveAcquired = false;
        return true;
    L6:
        return false;
    }

    private boolean acquireProxNegativeSuspendBlocker() {
        if (this.mIsProximityNegativeAcquired == true) goto L6;
        this.mDisplayPowerCallbacks.acquireSuspendBlocker(this.mSuspendBlockerIdProxNegative);
        this.mIsProximityNegativeAcquired = true;
        return true;
    L6:
        return false;
    }

    private boolean releaseProxNegativeSuspendBlocker() {
        if (this.mIsProximityNegativeAcquired == false) goto L6;
        this.mDisplayPowerCallbacks.releaseSuspendBlocker(this.mSuspendBlockerIdProxNegative);
        this.mIsProximityNegativeAcquired = false;
        return true;
    L6:
        return false;
    }

    private boolean acquireProxDebounceSuspendBlocker() {
        if (this.mHasProximityDebounced == true) goto L6;
        this.mDisplayPowerCallbacks.acquireSuspendBlocker(this.mSuspendBlockerIdProxDebounce);
        this.mHasProximityDebounced = true;
        return true;
    L6:
        return false;
    }

    private boolean releaseProxDebounceSuspendBlocker() {
        if (this.mHasProximityDebounced == false) goto L6;
        this.mDisplayPowerCallbacks.releaseSuspendBlocker(this.mSuspendBlockerIdProxDebounce);
        this.mHasProximityDebounced = false;
        return true;
    L6:
        return false;
    }

    public Runnable getOnProximityPositiveRunnable() {
        return new WakelockController$$ExternalSyntheticLambda2(this);
    }

    private /* synthetic */ void lambda$getOnProximityPositiveRunnable$0() {
        if (this.mIsProximityPositiveAcquired == false) goto L6;
        this.mIsProximityPositiveAcquired = false;
        this.mDisplayPowerCallbacks.onProximityPositive();
        this.mDisplayPowerCallbacks.releaseSuspendBlocker(this.mSuspendBlockerIdProxPositive);
        return;
    }

    public Runnable getOnStateChangedRunnable() {
        return new WakelockController$$ExternalSyntheticLambda0(this);
    }

    private /* synthetic */ void lambda$getOnStateChangedRunnable$1() {
        if (this.mOnStateChangedPending == false) goto L6;
        this.mOnStateChangedPending = false;
        this.mDisplayPowerCallbacks.onStateChanged();
        this.mDisplayPowerCallbacks.releaseSuspendBlocker(this.mSuspendBlockerIdOnStateChanged);
        return;
    }

    public Runnable getOnProximityNegativeRunnable() {
        return new WakelockController$$ExternalSyntheticLambda1(this);
    }

    private /* synthetic */ void lambda$getOnProximityNegativeRunnable$2() {
        if (this.mIsProximityNegativeAcquired == false) goto L6;
        this.mIsProximityNegativeAcquired = false;
        this.mDisplayPowerCallbacks.onProximityNegative();
        this.mDisplayPowerCallbacks.releaseSuspendBlocker(this.mSuspendBlockerIdProxNegative);
        return;
    }

    public void dumpLocal(PrintWriter pw) {
        pw.println("WakelockController State:");
        pw.println("-------------------------");
        pw.println("  mDisplayId=" + this.mDisplayId);
        pw.println("  mUnfinishedBusiness=" + hasUnfinishedBusiness());
        pw.println("  mOnStateChangePending=" + isOnStateChangedPending());
        pw.println("  mOnProximityPositiveMessages=" + isProximityPositiveAcquired());
        pw.println("  mOnProximityNegativeMessages=" + isProximityNegativeAcquired());
        pw.println("  mIsOverrideDozeScreenStateAcquired=" + isOverrideDozeScreenStateAcquired());
    }

    String getSuspendBlockerUnfinishedBusinessId() {
        return this.mSuspendBlockerIdUnfinishedBusiness;
    }

    String getSuspendBlockerOnStateChangedId() {
        return this.mSuspendBlockerIdOnStateChanged;
    }

    String getSuspendBlockerProxPositiveId() {
        return this.mSuspendBlockerIdProxPositive;
    }

    String getSuspendBlockerProxNegativeId() {
        return this.mSuspendBlockerIdProxNegative;
    }

    String getSuspendBlockerProxDebounceId() {
        return this.mSuspendBlockerIdProxDebounce;
    }

    String getSuspendBlockerOverrideDozeScreenState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mSuspendBlockerOverrideDozeScreenState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean hasUnfinishedBusiness() {
        return this.mUnfinishedBusiness;
    }

    boolean isOnStateChangedPending() {
        return this.mOnStateChangedPending;
    }

    boolean isProximityPositiveAcquired() {
        return this.mIsProximityPositiveAcquired;
    }

    boolean isProximityNegativeAcquired() {
        return this.mIsProximityNegativeAcquired;
    }

    boolean hasProximitySensorDebounced() {
        return this.mHasProximityDebounced;
    }

    boolean isOverrideDozeScreenStateAcquired() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsOverrideDozeScreenStateAcquired;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
