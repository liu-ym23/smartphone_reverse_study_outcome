package com.android.server.vibrator;

import android.os.Build;
import android.os.CombinedVibration;
import android.os.VibrationEffect;
import android.os.vibrator.PrebakedSegment;
import android.os.vibrator.PrimitiveSegment;
import android.os.vibrator.PwleSegment;
import android.os.vibrator.RampSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
final class VibrationStepConductor {
    static final long CALLBACKS_EXTRA_TIMEOUT = 1000;
    private static final boolean DEBUG = false;
    static final List<Step> EMPTY_STEP_LIST = null;
    static final float RAMP_OFF_AMPLITUDE_MIN = 0.001f;
    private static final String TAG = "VibrationThread";
    public final boolean isInSession;
    private boolean mCancelledImmediately;
    private Vibration.EndInfo mCancelledVibrationEndInfo;
    private final DeviceAdapter mDeviceAdapter;
    private final Object mLock;
    private final PriorityQueue<Step> mNextSteps;
    private final Queue<Step> mPendingOnVibratorCompleteSteps;
    private int mPendingVibrateSteps;
    private int mRemainingStartSequentialEffectSteps;
    private final CompletableFuture<Void> mRequestVibrationParamsFuture;
    private Vibration.EndInfo mSignalCancel;
    private boolean mSignalCancelImmediate;
    private final SparseIntArray mSignalVibratorStepIds;
    private final IntArray mSignalVibratorsComplete;
    private final VibratorFrameworkStatsLogger mStatsLogger;
    private int mSuccessfulVibratorOnSteps;
    private final HalVibration mVibration;
    private final VibrationScaler mVibrationScaler;
    public final VibrationSettings vibrationSettings;
    public final VibrationThread.VibratorManagerHooks vibratorManagerHooks;

    static {
        DEBUG = VibrationThread.DEBUG;
        EMPTY_STEP_LIST = new ArrayList();
    }

    VibrationStepConductor(HalVibration vib, boolean isInSession, VibrationSettings vibrationSettings, DeviceAdapter deviceAdapter, VibrationScaler vibrationScaler, VibratorFrameworkStatsLogger statsLogger, CompletableFuture<Void> requestVibrationParamsFuture, VibrationThread.VibratorManagerHooks vibratorManagerHooks) {
        this.mNextSteps = new PriorityQueue();
        this.mPendingOnVibratorCompleteSteps = new LinkedList();
        this.mLock = new Object();
        this.mSignalCancel = null;
        this.mSignalCancelImmediate = false;
        this.mCancelledVibrationEndInfo = null;
        this.mCancelledImmediately = false;
        this.mVibration = vib;
        this.isInSession = isInSession;
        this.vibrationSettings = vibrationSettings;
        this.mDeviceAdapter = deviceAdapter;
        this.mVibrationScaler = vibrationScaler;
        this.mStatsLogger = statsLogger;
        this.mRequestVibrationParamsFuture = requestVibrationParamsFuture;
        this.vibratorManagerHooks = vibratorManagerHooks;
        this.mSignalVibratorsComplete = new IntArray(this.mDeviceAdapter.getAvailableVibratorIds().length);
        this.mSignalVibratorStepIds = new SparseIntArray(this.mDeviceAdapter.getAvailableVibratorIds().length);
    }

    AbstractVibratorStep nextVibrateStep(long startTime, VibratorController controller, VibrationEffect effect) {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        expectIsVibrationThread(true);
    L6:
        if ((effect instanceof VibrationEffect.VendorEffect) == false) goto L10;
        VibrationEffect.VendorEffect vendorEffect = (VibrationEffect.VendorEffect) effect;
        return new PerformVendorEffectVibratorStep(this, startTime, controller, vendorEffect, 0);
    L10:
        if ((effect instanceof VibrationEffect.Composed) == false) goto L13;
        VibrationEffect.Composed composed = (VibrationEffect.Composed) effect;
        return nextVibrateStep(startTime, controller, composed, 0, 0);
    L13:
        Slog.wtf(TAG, "Unable to create next step for unexpected effect: " + effect);
        return null;
    }

    AbstractVibratorStep nextVibrateStep(long startTime, VibratorController controller, VibrationEffect.Composed effect, int segmentIndex, long pendingVibratorOffDeadline) {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        expectIsVibrationThread(true);
    L6:
        if (segmentIndex < effect.getSegments().size()) goto L8;
        int segmentIndex2 = effect.getRepeatIndex();
    L9:
        if (segmentIndex2 < 0) goto L11;
        VibrationEffectSegment segment = (VibrationEffectSegment) effect.getSegments().get(segmentIndex2);
        if ((segment instanceof PrebakedSegment) == false) goto L17;
        return new PerformPrebakedVibratorStep(this, startTime, controller, effect, segmentIndex2, pendingVibratorOffDeadline);
    L17:
        if ((segment instanceof PrimitiveSegment) == false) goto L21;
        return new ComposePrimitivesVibratorStep(this, startTime, controller, effect, segmentIndex2, pendingVibratorOffDeadline);
    L21:
        if ((segment instanceof RampSegment) == false) goto L25;
        return new ComposePwleVibratorStep(this, startTime, controller, effect, segmentIndex2, pendingVibratorOffDeadline);
    L25:
        if ((segment instanceof PwleSegment) == false) goto L29;
        return new ComposePwleV2VibratorStep(this, startTime, controller, effect, segmentIndex2, pendingVibratorOffDeadline);
    L29:
        return new SetAmplitudeVibratorStep(this, startTime, controller, effect, segmentIndex2, pendingVibratorOffDeadline);
    L11:
        return new CompleteEffectVibratorStep(this, startTime, false, controller, pendingVibratorOffDeadline);
    L8:
        segmentIndex2 = segmentIndex;
        goto L9
    }

    public boolean prepareToStart() {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        expectIsVibrationThread(true);
    L5:
        waitForVibrationParamsIfRequired();
        this.mVibration.scaleEffects(this.mVibrationScaler);
        if (this.mVibration.adaptToDevice(this.mDeviceAdapter) == true) goto L9;
        return false;
    L9:
        CombinedVibration.Sequential sequentialEffect = toSequential(this.mVibration.getEffectToPlay());
        this.mPendingVibrateSteps++;
        this.mRemainingStartSequentialEffectSteps = sequentialEffect.getEffects().size();
        this.mNextSteps.offer(new StartSequentialEffectStep(this, sequentialEffect));
        this.mVibration.stats.reportStarted();
        return true;
    }

    public HalVibration getVibration() {
        return this.mVibration;
    }

    SparseArray<VibratorController> getVibrators() {
        return this.mDeviceAdapter.getAvailableVibrators();
    }

    public boolean isFinished() {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        expectIsVibrationThread(true);
    L6:
        if (this.mCancelledImmediately == false) goto L9;
        return true;
    L9:
        if (this.mPendingOnVibratorCompleteSteps.isEmpty() == true) goto L11;
    L13:
        return false;
    L11:
        if (this.mNextSteps.isEmpty() == false) goto L13;
        return true;
    }

    public Vibration.EndInfo calculateVibrationEndInfo() {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        expectIsVibrationThread(true);
    L6:
        if (this.mCancelledVibrationEndInfo == null) goto L10;
        return this.mCancelledVibrationEndInfo;
    L10:
        if (this.mPendingVibrateSteps <= 0) goto L12;
        return null;
    L12:
        if (this.mRemainingStartSequentialEffectSteps <= 0) goto L15;
        return null;
    L15:
        if (this.mSuccessfulVibratorOnSteps <= 0) goto L19;
        return new Vibration.EndInfo(VibrationSession.Status.FINISHED);
    L19:
        return new Vibration.EndInfo(VibrationSession.Status.IGNORED_UNSUPPORTED);
    }

    public boolean waitUntilNextStepIsDue() {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        expectIsVibrationThread(true);
    L5:
        processAllNotifySignals();
        if (this.mCancelledImmediately == false) goto L9;
        return false;
    L9:
        if (this.mPendingOnVibratorCompleteSteps.isEmpty() == true) goto L11;
        return true;
    L11:
        Step nextStep = this.mNextSteps.peek();
        if (nextStep != null) goto L15;
        return true;
    L15:
        if (this.isInSession == false) goto L17;
        return true;
    L17:
        long waitMillis = nextStep.calculateWaitTime();
        if (waitMillis > 0) goto L20;
        return true;
    L20:
        Object r1 = this.mLock;
        monitor-enter(r1);
    L26:
        th = move-exception;
        throw th;
    L23:
        if (hasPendingNotifySignalLocked() == false) goto L36;
        monitor-exit(r1);     // Catch: Throwable -> L26
        return false;
    L36:
        this.mLock.wait(waitMillis);     // Catch: Throwable -> L26 InterruptedException -> L30
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L26
        return false;
    }

    private Step pollNext() {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        expectIsVibrationThread(true);
    L6:
        if (this.mPendingOnVibratorCompleteSteps.isEmpty() == true) goto L10;
        return this.mPendingOnVibratorCompleteSteps.poll();
    L10:
        return this.mNextSteps.poll();
    }

    public void runNextStep() {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        expectIsVibrationThread(true);
    L5:
        Step r0 = pollNext();
        if (r0 != null) goto L8;
        return;
    L8:
        if (DEBUG == false) goto L17;
        StringBuilder r2 = new StringBuilder();
        r2.append("Playing vibration id ");
        r2.append(getVibration().id);
        String r4 = "";
        if ((r0 instanceof AbstractVibratorStep) == false) goto L12;
        String r3 = " on vibrator " + ((AbstractVibratorStep) r0).getVibratorId();
    L13:
        r2.append(r3);
        r2.append(" ");
        r2.append(r0.getClass().getSimpleName());
        if (r0.isCleanUp() == false) goto L16;
        r4 = " (cleanup)";
    L16:
        r2.append(r4);
        Slog.d(TAG, r2.toString());
        goto L17
    L12:
        r3 = "";
    L17:
        List<Step> r5 = r0.play();
        if (r0.getVibratorOnDuration() <= 0) goto L21;
        this.mSuccessfulVibratorOnSteps++;
    L21:
        if ((r0 instanceof StartSequentialEffectStep) == false) goto L24;
        this.mRemainingStartSequentialEffectSteps--;
    L24:
        if (r0.isCleanUp() == true) goto L26;
        this.mPendingVibrateSteps--;
    L26:
        int r6 = 0;
    L28:
        if (r6 >= r5.size()) goto L30;
        this.mPendingVibrateSteps += !r5.get(r6).isCleanUp() ? 1 : 0;
        r6 = r6 + 1;
        goto L28
    L30:
        this.mNextSteps.addAll(r5);
    }

    public void notifyCancelled(Vibration.EndInfo cancelInfo, boolean immediate) {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        expectIsVibrationThread(false);
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "Vibration cancel requested with signal=" + cancelInfo + ", immediate=" + immediate);
    L8:
        if (cancelInfo != null) goto L10;
    L11:
        Slog.w(TAG, "Vibration cancel requested with bad signal=" + cancelInfo + ", using CANCELLED_UNKNOWN_REASON to ensure cancellation.");
        cancelInfo = new Vibration.EndInfo(VibrationSession.Status.CANCELLED_BY_UNKNOWN_REASON);
    L12:
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (immediate == false) goto L21;
    L18:
        th = move-exception;
        throw th;
    L16:
        if (this.mSignalCancelImmediate == false) goto L21;
    L23:
        if (DEBUG == false) goto L25;
        Slog.d(TAG, "Vibration cancel request ignored as the vibration " + this.mVibration.id + "is already being cancelled with signal=" + this.mSignalCancel + ", immediate=" + this.mSignalCancelImmediate);     // Catch: Throwable -> L18
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L21:
        if (this.mSignalCancel != null) goto L23;
        this.mSignalCancelImmediate |= immediate;     // Catch: Throwable -> L18
        if (this.mSignalCancel != null) goto L31;
        this.mSignalCancel = cancelInfo;     // Catch: Throwable -> L18
    L34:
        if (this.mRequestVibrationParamsFuture == null) goto L36;
        this.mRequestVibrationParamsFuture.cancel(true);     // Catch: Throwable -> L18
    L36:
        this.mLock.notify();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L31:
        if (DEBUG == false) goto L34;
        Slog.d(TAG, "Vibration cancel request new signal=" + cancelInfo + " ignored as the vibration was already cancelled with signal=" + this.mSignalCancel + ", but immediate flag was updated to " + this.mSignalCancelImmediate);     // Catch: Throwable -> L18
        goto L34
    L10:
        if (cancelInfo.status.name().startsWith("CANCEL") == true) goto L12;
        goto L11
    }

    public void notifyVibratorComplete(int vibratorId, long stepId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Vibration complete reported by vibrator " + vibratorId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSignalVibratorsComplete.add(vibratorId);     // Catch: Throwable -> L10
        this.mLock.notify();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void notifySyncedVibrationComplete() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Synced vibration complete reported by vibrator manager");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int[] r1 = this.mDeviceAdapter.getAvailableVibratorIds();     // Catch: Throwable -> L10
        int r2 = r1.length;     // Catch: Throwable -> L10
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L12;
        int vibratorId = r1[r3];     // Catch: Throwable -> L10
        this.mSignalVibratorsComplete.add(vibratorId);     // Catch: Throwable -> L10
        r3 = r3 + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mLock.notify();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void notifyVibrationComplete(Vibration.EndInfo endInfo) {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        expectIsVibrationThread(true);
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "Vibration " + this.mVibration.id + " finished with " + endInfo);
    L8:
        this.mVibration.end(endInfo);
    }

    public boolean wasNotifiedToCancel() {
        boolean r1 = false;
        if (Build.IS_DEBUGGABLE == false) goto L5;
        expectIsVibrationThread(false);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mSignalCancel == null) goto L10;
        r1 = true;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    }

    private void waitForVibrationParamsIfRequired() {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        expectIsVibrationThread(true);
    L6:
        if (this.mRequestVibrationParamsFuture != null) goto L25;
        return;
    L25:
        this.mRequestVibrationParamsFuture.get(this.vibrationSettings.getRequestVibrationParamsTimeoutMs(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10 CancellationException -> L12 TimeoutException -> L14
    L27:
        return;
    L12:
        e = move-exception;
        if (DEBUG == false) goto L28;
        Slog.d(TAG, "Request for vibration params cancelled, maybe superseded or vibrator controller unregistered. Skipping params...", e);
        return;
    L28:
        return;
    L14:
        e = move-exception;
        if (DEBUG == false) goto L23;
        Slog.d(TAG, "Request for vibration params timed out", e);
    L23:
        this.mStatsLogger.logVibrationParamRequestTimeout(this.mVibration.callerInfo.uid);
        return;
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed to retrieve vibration params.", e);
    }

    private boolean hasPendingNotifySignalLocked() {
        if (Build.IS_DEBUGGABLE == false) goto L6;
        expectIsVibrationThread(true);
    L6:
        if (this.mSignalCancel == null) goto L10;
        if (this.mCancelledVibrationEndInfo != null) goto L10;
        return true;
    L10:
        if (this.mSignalCancelImmediate == false) goto L14;
        if (this.mCancelledImmediately == true) goto L14;
        return true;
    L14:
        if (this.mSignalVibratorsComplete.size() > 0) goto L20;
        return false;
    L20:
        return true;
    }

    private void processAllNotifySignals() {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        expectIsVibrationThread(true);
    L5:
        int[] vibratorsToProcess = null;
        Vibration.EndInfo doCancelInfo = null;
        boolean doCancelImmediate = false;
        Object r3 = this.mLock;
        monitor-enter(r3);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mSignalCancelImmediate == false) goto L16;
        if (this.mCancelledImmediately == false) goto L14;
        Slog.wtf(TAG, "Immediate cancellation signal processed twice");     // Catch: Throwable -> L12
    L14:
        doCancelImmediate = true;
        doCancelInfo = this.mSignalCancel;     // Catch: Throwable -> L12
    L16:
        if (this.mSignalCancel != null) goto L18;
    L20:
        if (doCancelImmediate == false) goto L22;
    L24:
        monitor-exit(r3);     // Catch: Throwable -> L12
        if (doCancelImmediate == false) goto L28;
        processCancelImmediately(doCancelInfo);
        return;
    L28:
        if (doCancelInfo == null) goto L30;
        processCancel(doCancelInfo);
    L30:
        if (vibratorsToProcess == null) goto L37;
        processVibratorsComplete(vibratorsToProcess);
        return;
    L37:
        return;
    L22:
        if (this.mSignalVibratorsComplete.size() <= 0) goto L24;
        vibratorsToProcess = this.mSignalVibratorsComplete.toArray();     // Catch: Throwable -> L12
        this.mSignalVibratorsComplete.clear();     // Catch: Throwable -> L12
        goto L24
    L18:
        if (this.mCancelledVibrationEndInfo != null) goto L20;
        doCancelInfo = this.mSignalCancel;     // Catch: Throwable -> L12
        goto L20
    }

    public void processCancel(Vibration.EndInfo cancelInfo) {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        expectIsVibrationThread(true);
    L5:
        this.mCancelledVibrationEndInfo = cancelInfo;
        List<Step> cleanUpSteps = new ArrayList();
    L6:
        Step step = pollNext();
        if (step == null) goto L9;
        cleanUpSteps.addAll(step.cancel());
        goto L6
    L9:
        this.mPendingVibrateSteps = 0;
        this.mNextSteps.addAll(cleanUpSteps);
    }

    public void processCancelImmediately(Vibration.EndInfo cancelInfo) {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        expectIsVibrationThread(true);
    L5:
        this.mCancelledImmediately = true;
        this.mCancelledVibrationEndInfo = cancelInfo;
    L6:
        Step step = pollNext();
        if (step == null) goto L9;
        step.cancelImmediately();
        goto L6
    L9:
        this.mPendingVibrateSteps = 0;
    }

    private void processVibratorsComplete(int[] vibratorsToProcess) {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        expectIsVibrationThread(true);
    L5:
        int r0 = vibratorsToProcess.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L15;
        int vibratorId = vibratorsToProcess[r1];
        Iterator<Step> it = this.mNextSteps.iterator();
    L9:
        if (it.hasNext() == false) goto L14;
        Step step = it.next();
        if (step.acceptVibratorCompleteCallback(vibratorId) == false) goto L9;
        it.remove();
        this.mPendingOnVibratorCompleteSteps.offer(step);
    L14:
        r1 = r1 + 1;
        goto L6
    }

    public int nextVibratorCallbackStepId(int vibratorId) {
        return 0;
    }

    private static CombinedVibration.Sequential toSequential(CombinedVibration effect) {
        if ((effect instanceof CombinedVibration.Sequential) == false) goto L7;
        return (CombinedVibration.Sequential) effect;
    L7:
        return CombinedVibration.startSequential().addNext(effect).combine();
    }

    private static void expectIsVibrationThread(boolean isVibrationThread) {
        if ((Thread.currentThread() instanceof VibrationThread) == isVibrationThread) goto L6;
        Slog.wtfStack("VibrationStepConductor", "Thread caller assertion failed, expected isVibrationThread=" + isVibrationThread);
        return;
    }
}
