package com.android.server.am;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.util.IndentingPrintWriter;
import android.util.TimeUtils;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.Preconditions;
import com.android.server.SysOptBridge;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.PriorityDump;
import dalvik.annotation.optimization.NeverCompile;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class BroadcastProcessQueue {
    static final int REASON_BLOCKED = 4;
    static final int REASON_CACHED = 1;
    static final int REASON_CACHED_INFINITE_DEFER = 8;
    static final int REASON_CONTAINS_ALARM = 12;
    static final int REASON_CONTAINS_FOREGROUND = 10;
    static final int REASON_CONTAINS_INSTRUMENTED = 16;
    static final int REASON_CONTAINS_INTERACTIVE = 14;
    static final int REASON_CONTAINS_MANIFEST = 17;
    static final int REASON_CONTAINS_ORDERED = 11;
    static final int REASON_CONTAINS_PRIORITIZED = 13;
    static final int REASON_CONTAINS_RESULT_TO = 15;
    static final int REASON_CORE_UID = 19;
    static final int REASON_EMPTY = 0;
    static final int REASON_FORCE_DELAYED = 7;
    static final int REASON_FOREGROUND = 18;
    static final int REASON_INSTRUMENTED = 5;
    static final int REASON_MAX_PENDING = 3;
    static final int REASON_NORMAL = 2;
    static final int REASON_PERSISTENT = 6;
    static final int REASON_TOP_PROCESS = 20;
    static final boolean VERBOSE = false;
    ProcessRecord app;
    final BroadcastConstants constants;
    long lastCpuDelayTime;
    int lastProcessState;
    private BroadcastRecord mActive;
    private int mActiveAssumedDeliveryCountSinceIdle;
    private int mActiveCountConsecutiveNormal;
    private int mActiveCountConsecutiveUrgent;
    private int mActiveCountSinceIdle;
    private boolean mActiveFirstLaunch;
    private int mActiveIndex;
    private boolean mActiveReEnqueued;
    private boolean mActiveViaColdStart;
    private boolean mActiveWasStopped;
    private String mCachedToShortString;
    private String mCachedToString;
    private int mCountAlarm;
    private int mCountDeferred;
    private int mCountEnqueued;
    private int mCountForeground;
    private int mCountForegroundDeferred;
    private int mCountInstrumented;
    private int mCountInteractive;
    private int mCountManifest;
    private int mCountOrdered;
    private int mCountPrioritizeEarliestRequests;
    private int mCountPrioritized;
    private int mCountPrioritizedDeferred;
    private int mCountResultTo;
    private boolean mCurReceiversIncremented;
    private long mForcedDelayedDurationMs;
    private boolean mLastDeferredStates;
    private final ArrayList<BroadcastRecord> mOutgoingBroadcasts;
    private final ArrayDeque<SomeArgs> mPending;
    private final ArrayDeque<SomeArgs> mPendingOffload;
    private final ArrayDeque<SomeArgs> mPendingUrgent;
    private boolean mProcessFreezable;
    private boolean mProcessInstrumented;
    private boolean mProcessPersistent;
    private long mProcessStartInitiatedTimestampMillis;
    private long mRunnableAt;
    private boolean mRunnableAtInvalidated;
    private int mRunnableAtReason;
    private boolean mTimeoutScheduled;
    private boolean mUidForeground;
    final String processName;
    BroadcastProcessQueue processNameNext;
    BroadcastProcessQueue runnableAtNext;
    BroadcastProcessQueue runnableAtPrev;
    boolean runningOomAdjusted;
    String runningTraceTrackName;
    final int uid;

    @FunctionalInterface
    public interface BroadcastConsumer {
        void accept(BroadcastRecord r1, int r2);
    }

    @FunctionalInterface
    public interface BroadcastPredicate {
        boolean test(BroadcastRecord r1, int r2);
    }

    @FunctionalInterface
    public interface BroadcastRecordConsumer {
        void accept(BroadcastRecord r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Reason {
    }

    public static /* synthetic */ boolean $r8$lambda$7LuENv9AvlpyJsICrtISXBsS3_E(BroadcastRecord r0, int r1) {
        return lambda$clearDeferredStates$2(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$7jvfHufVyE3JdVe4Li1zoeZOhgw(BroadcastRecord r0, int r1) {
        return lambda$updateDeferredStates$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$uTkPoca9PFx_MiK361g77-Nbtxk, reason: not valid java name */
    public static /* synthetic */ boolean m1428$r8$lambda$uTkPoca9PFx_MiK361g77Nbtxk(BroadcastRecord r0, int r1) {
        return lambda$updateDeferredStates$1(r0, r1);
    }

    public BroadcastProcessQueue(BroadcastConstants constants, String processName, int uid) {
        this.mPending = new ArrayDeque();
        this.mPendingUrgent = new ArrayDeque(4);
        this.mPendingOffload = new ArrayDeque(4);
        this.mRunnableAt = Long.MAX_VALUE;
        this.mRunnableAtReason = 0;
        this.mOutgoingBroadcasts = new ArrayList();
        constants.getClass();
        this.constants = constants;
        processName.getClass();
        this.processName = processName;
        this.uid = uid;
    }

    private ArrayDeque<SomeArgs> getQueueForBroadcast(BroadcastRecord record) {
        if (record.isUrgent() == false) goto L7;
        return this.mPendingUrgent;
    L7:
        if (record.isOffload() == false) goto L11;
        return this.mPendingOffload;
    L11:
        return this.mPending;
    }

    public void enqueueOutgoingBroadcast(BroadcastRecord record) {
        this.mOutgoingBroadcasts.add(record);
    }

    public int getOutgoingBroadcastCount() {
        return this.mOutgoingBroadcasts.size();
    }

    public void enqueueOutgoingBroadcasts(BroadcastRecordConsumer consumer) {
        int i = 0;
    L4:
        if (i >= this.mOutgoingBroadcasts.size()) goto L6;
        consumer.accept(this.mOutgoingBroadcasts.get(i));
        i = i + 1;
        goto L4
    L6:
        this.mOutgoingBroadcasts.clear();
    }

    public void clearOutgoingBroadcasts() {
        this.mOutgoingBroadcasts.clear();
    }

    public BroadcastRecord enqueueOrReplaceBroadcast(BroadcastRecord record, int recordIndex, BroadcastConsumer deferredStatesApplyConsumer) {
        if (record.isReplacePending() == true) goto L5;
    L16:
        SomeArgs newBroadcastArgs = SomeArgs.obtain();
        newBroadcastArgs.arg1 = record;
        newBroadcastArgs.argi1 = recordIndex;
        getQueueForBroadcast(record).addLast(newBroadcastArgs);
        onBroadcastEnqueued(record, recordIndex);
        if (this.mLastDeferredStates == true) goto L19;
        return null;
    L19:
        if (shouldBeDeferred() == true) goto L21;
        return null;
    L21:
        if (record.getDeliveryState(recordIndex) != 0) goto L27;
        deferredStatesApplyConsumer.accept(record, recordIndex);
        return null;
    L27:
        return null;
    L5:
        if (record.getDeliveryGroupPolicy() != 0) goto L16;
        BroadcastRecord replacedBroadcastRecord = replaceBroadcast(record, recordIndex);
        if (replacedBroadcastRecord == null) goto L16;
        if (this.mLastDeferredStates == true) goto L11;
    L15:
        return replacedBroadcastRecord;
    L11:
        if (shouldBeDeferred() == false) goto L15;
        if (record.getDeliveryState(recordIndex) != 0) goto L15;
        deferredStatesApplyConsumer.accept(record, recordIndex);
        goto L15
    }

    public void reEnqueueActiveBroadcast() {
        BroadcastRecord record = getActive();
        int recordIndex = getActiveIndex();
        SomeArgs broadcastArgs = SomeArgs.obtain();
        broadcastArgs.arg1 = record;
        broadcastArgs.argi1 = recordIndex;
        broadcastArgs.argi2 = 1;
        getQueueForBroadcast(record).addFirst(broadcastArgs);
        onBroadcastEnqueued(record, recordIndex);
    }

    private BroadcastRecord replaceBroadcast(BroadcastRecord record, int recordIndex) {
        ArrayDeque<SomeArgs> queue = getQueueForBroadcast(record);
        return replaceBroadcastInQueue(queue, record, recordIndex);
    }

    private BroadcastRecord replaceBroadcastInQueue(ArrayDeque<SomeArgs> queue, BroadcastRecord record, int recordIndex) {
        Iterator<SomeArgs> it = queue.descendingIterator();
        Object receiver = record.receivers.get(recordIndex);
    L4:
        if (it.hasNext() == false) goto L23;
        SomeArgs args = it.next();
        BroadcastRecord testRecord = (BroadcastRecord) args.arg1;
        int testRecordIndex = args.argi1;
        Object testReceiver = testRecord.receivers.get(testRecordIndex);
        if (record == testRecord) goto L40;
        if (record.callingUid != testRecord.callingUid) goto L4;
        if (record.userId != testRecord.userId) goto L4;
        if (record.intent.filterEquals(testRecord.intent) == false) goto L4;
        if (BroadcastRecord.isReceiverEquals(receiver, testReceiver) == false) goto L4;
        if (testRecord.allReceiversPending() == false) goto L4;
        if (record.isMatchingRecord(testRecord) == false) goto L4;
        args.arg1 = record;
        args.argi1 = recordIndex;
        record.copyEnqueueTimeFrom(testRecord);
        onBroadcastDequeued(testRecord, testRecordIndex);
        onBroadcastEnqueued(record, recordIndex);
        return testRecord;
    L40:
        return null;
    L23:
        return null;
    }

    public boolean forEachMatchingBroadcast(BroadcastPredicate predicate, BroadcastConsumer consumer, boolean andRemove) {
        boolean didSomething = false | forEachMatchingBroadcastInQueue(this.mPending, predicate, consumer, andRemove);
        return (didSomething | forEachMatchingBroadcastInQueue(this.mPendingUrgent, predicate, consumer, andRemove)) | forEachMatchingBroadcastInQueue(this.mPendingOffload, predicate, consumer, andRemove);
    }

    public int getUnScheduledSize() {
        return (this.mPending.size() + this.mPendingUrgent.size()) + this.mPendingOffload.size();
    }

    public boolean sizeExceeds() {
        if (getUnScheduledSize() < this.constants.MAX_PENDING_BROADCASTS) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean forEachMatchingBroadcastInQueue(ArrayDeque<SomeArgs> queue, BroadcastPredicate predicate, BroadcastConsumer consumer, boolean andRemove) {
        boolean didSomething = false;
        Iterator<SomeArgs> it = queue.iterator();
    L4:
        if (it.hasNext() == false) goto L13;
        SomeArgs args = it.next();
        BroadcastRecord record = (BroadcastRecord) args.arg1;
        int recordIndex = args.argi1;
        if (predicate.test(record, recordIndex) == false) goto L4;
        consumer.accept(record, recordIndex);
        if (andRemove == false) goto L10;
        args.recycle();
        it.remove();
        onBroadcastDequeued(record, recordIndex);
    L11:
        didSomething = true;
        goto L4
    L10:
        invalidateRunnableAt();
        goto L11
    L13:
        return didSomething;
    }

    public boolean setProcessAndUidState(ProcessRecord app, boolean uidForeground, boolean processFreezable) {
        this.app = app;
        this.mCachedToString = null;
        this.mCachedToShortString = null;
        boolean r1 = false;
        if (app == null) goto L8;
        boolean didSomething = false | setUidForeground(uidForeground);
        boolean didSomething2 = didSomething | setProcessFreezable(processFreezable);
        if (app.getActiveInstrumentation() == null) goto L10;
        r1 = true;
    L10:
        return (didSomething2 | setProcessInstrumented(r1)) | setProcessPersistent(app.isPersistent());
    L8:
        boolean didSomething3 = false | setUidForeground(false);
        return ((didSomething3 | setProcessFreezable(false)) | setProcessInstrumented(false)) | setProcessPersistent(false);
    }

    private boolean setUidForeground(boolean uidForeground) {
        if (this.mUidForeground == uidForeground) goto L6;
        this.mUidForeground = uidForeground;
        invalidateRunnableAt();
        return true;
    L6:
        return false;
    }

    private boolean setProcessFreezable(boolean freezable) {
        if (this.mProcessFreezable == freezable) goto L6;
        this.mProcessFreezable = freezable;
        invalidateRunnableAt();
        return true;
    L6:
        return false;
    }

    private boolean setProcessInstrumented(boolean instrumented) {
        if (this.mProcessInstrumented == instrumented) goto L6;
        this.mProcessInstrumented = instrumented;
        invalidateRunnableAt();
        return true;
    L6:
        return false;
    }

    private boolean setProcessPersistent(boolean persistent) {
        if (this.mProcessPersistent == persistent) goto L6;
        this.mProcessPersistent = persistent;
        invalidateRunnableAt();
        return true;
    L6:
        return false;
    }

    public boolean isProcessWarm() {
        if (this.app == null) goto L9;
        if (this.app.getOnewayThread() == null) goto L9;
        if (this.app.isKilled() == true) goto L9;
    L10:
        return true;
    L9:
        if (SysOptBridge.getFactory().getApplicationFreezer().get(this.processName, this.uid) != null) goto L10;
        return false;
    }

    public int getPreferredSchedulingGroupLocked() {
        if (isActive() == true) goto L7;
        return Integer.MIN_VALUE;
    L7:
        if (this.mCountForeground <= this.mCountForegroundDeferred) goto L10;
        return 2;
    L10:
        if (this.mActive != null) goto L12;
        return 0;
    L12:
        if (this.mActive.isForeground() == false) goto L16;
        return 2;
    L16:
        return 0;
    }

    public int getActiveCountSinceIdle() {
        return this.mActiveCountSinceIdle;
    }

    public int getActiveAssumedDeliveryCountSinceIdle() {
        return this.mActiveAssumedDeliveryCountSinceIdle;
    }

    public void setActiveViaColdStart(boolean activeViaColdStart) {
        this.mActiveViaColdStart = activeViaColdStart;
    }

    public void setActiveWasStopped(boolean activeWasStopped) {
        this.mActiveWasStopped = activeWasStopped;
    }

    public void setActiveFirstLaunch(boolean activeFirstLaunch) {
        this.mActiveFirstLaunch = activeFirstLaunch;
    }

    public boolean getActiveViaColdStart() {
        return this.mActiveViaColdStart;
    }

    public boolean getActiveWasStopped() {
        return this.mActiveWasStopped;
    }

    public boolean getActiveFirstLaunch() {
        return this.mActiveFirstLaunch;
    }

    public void incrementCurAppReceivers() {
        this.app.mReceivers.incrementCurReceivers();
        this.mCurReceiversIncremented = true;
    }

    public void decrementCurAppReceivers() {
        if (this.mCurReceiversIncremented == false) goto L6;
        this.app.mReceivers.decrementCurReceivers();
        this.mCurReceiversIncremented = false;
        return;
    }

    public void setProcessStartInitiatedTimestampMillis(long timestampMillis) {
        this.mProcessStartInitiatedTimestampMillis = timestampMillis;
    }

    public long getProcessStartInitiatedTimestampMillis() {
        return this.mProcessStartInitiatedTimestampMillis;
    }

    public boolean hasProcessStartInitiationTimedout() {
        if (this.mProcessStartInitiatedTimestampMillis > 0) goto L6;
        return false;
    L6:
        if ((SystemClock.uptimeMillis() - this.mProcessStartInitiatedTimestampMillis) <= this.constants.PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isProcessStartInitiationTimeoutExpected() {
        if (this.mProcessStartInitiatedTimestampMillis > 0) goto L6;
        return false;
    L6:
        if ((SystemClock.uptimeMillis() - this.mProcessStartInitiatedTimestampMillis) <= (this.constants.PENDING_COLD_START_ABANDON_TIMEOUT_MILLIS / 2)) goto L9;
        return true;
    L9:
        return false;
    }

    public void clearProcessStartInitiatedTimestampMillis() {
        this.mProcessStartInitiatedTimestampMillis = 0;
    }

    public String getPackageName() {
        if (this.app != null) goto L6;
        return null;
    L6:
        return this.app.getApplicationInfo().packageName;
    }

    public void makeActiveNextPending() {
        SomeArgs r0 = removeNextBroadcast();
        this.mActive = (BroadcastRecord) r0.arg1;
        this.mActiveIndex = r0.argi1;
        if (r0.argi2 != 1) goto L5;
        boolean r1 = true;
    L6:
        this.mActiveReEnqueued = r1;
        this.mActiveCountSinceIdle++;
        this.mActiveAssumedDeliveryCountSinceIdle += this.mActive.isAssumedDelivered(this.mActiveIndex) ? 1 : 0;
        this.mActiveViaColdStart = false;
        this.mActiveWasStopped = false;
        r0.recycle();
        onBroadcastDequeued(this.mActive, this.mActiveIndex);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void makeActiveIdle() {
        this.mActive = null;
        this.mActiveIndex = 0;
        this.mActiveReEnqueued = false;
        this.mActiveCountSinceIdle = 0;
        this.mActiveAssumedDeliveryCountSinceIdle = 0;
        this.mActiveViaColdStart = false;
        invalidateRunnableAt();
    }

    public boolean wasActiveBroadcastReEnqueued() {
        return this.mActiveReEnqueued;
    }

    private void onBroadcastEnqueued(BroadcastRecord record, int recordIndex) {
        this.mCountEnqueued++;
        if (record.deferUntilActive == false) goto L6;
        this.mCountDeferred++;
    L6:
        if (record.isForeground() == false) goto L12;
        if (record.deferUntilActive == false) goto L10;
        this.mCountForegroundDeferred++;
    L10:
        this.mCountForeground++;
    L12:
        if (record.ordered == false) goto L15;
        this.mCountOrdered++;
    L15:
        if (record.alarm == false) goto L18;
        this.mCountAlarm++;
    L18:
        if (record.prioritized == false) goto L24;
        if (record.deferUntilActive == false) goto L22;
        this.mCountPrioritizedDeferred++;
    L22:
        this.mCountPrioritized++;
    L24:
        if (record.interactive == false) goto L27;
        this.mCountInteractive++;
    L27:
        if (record.resultTo == null) goto L30;
        this.mCountResultTo++;
    L30:
        if (record.callerInstrumented == false) goto L33;
        this.mCountInstrumented++;
    L33:
        if ((record.receivers.get(recordIndex) instanceof ResolveInfo) == false) goto L35;
        this.mCountManifest++;
    L35:
        invalidateRunnableAt();
    }

    private void onBroadcastDequeued(BroadcastRecord record, int recordIndex) {
        this.mCountEnqueued--;
        if (record.deferUntilActive == false) goto L6;
        this.mCountDeferred--;
    L6:
        if (record.isForeground() == false) goto L12;
        if (record.deferUntilActive == false) goto L10;
        this.mCountForegroundDeferred--;
    L10:
        this.mCountForeground--;
    L12:
        if (record.ordered == false) goto L15;
        this.mCountOrdered--;
    L15:
        if (record.alarm == false) goto L18;
        this.mCountAlarm--;
    L18:
        if (record.prioritized == false) goto L24;
        if (record.deferUntilActive == false) goto L22;
        this.mCountPrioritizedDeferred--;
    L22:
        this.mCountPrioritized--;
    L24:
        if (record.interactive == false) goto L27;
        this.mCountInteractive--;
    L27:
        if (record.resultTo == null) goto L30;
        this.mCountResultTo--;
    L30:
        if (record.callerInstrumented == false) goto L33;
        this.mCountInstrumented--;
    L33:
        if ((record.receivers.get(recordIndex) instanceof ResolveInfo) == false) goto L35;
        this.mCountManifest--;
    L35:
        invalidateRunnableAt();
    }

    public void traceProcessStartingBegin() {
        Trace.asyncTraceForTrackBegin(64, this.runningTraceTrackName, toShortString() + " starting", hashCode());
    }

    public void traceProcessRunningBegin() {
        Trace.asyncTraceForTrackBegin(64, this.runningTraceTrackName, toShortString() + " running", hashCode());
    }

    public void traceProcessEnd() {
        Trace.asyncTraceForTrackEnd(64, this.runningTraceTrackName, hashCode());
    }

    public void traceActiveBegin() {
        Trace.asyncTraceForTrackBegin(64, this.runningTraceTrackName, this.mActive.toShortString() + " scheduled", hashCode());
    }

    public void traceActiveEnd() {
        Trace.asyncTraceForTrackEnd(64, this.runningTraceTrackName, hashCode());
    }

    public BroadcastRecord getActive() {
        BroadcastRecord r0 = this.mActive;
        toString();
        r0.getClass();
        return r0;
    }

    public int getActiveIndex() {
        BroadcastRecord r0 = this.mActive;
        toString();
        r0.getClass();
        return this.mActiveIndex;
    }

    public boolean isOutgoingEmpty() {
        return this.mOutgoingBroadcasts.isEmpty();
    }

    public boolean isEmpty() {
        if (this.mPending.isEmpty() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mPendingUrgent.isEmpty() == false) goto L9;
        if (this.mPendingOffload.isEmpty() == false) goto L9;
        return true;
    }

    public boolean isActive() {
        if (this.mActive == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean forceDelayBroadcastDelivery(long delayedDurationMs) {
        if (this.mForcedDelayedDurationMs == delayedDurationMs) goto L6;
        this.mForcedDelayedDurationMs = delayedDurationMs;
        invalidateRunnableAt();
        return true;
    L6:
        return false;
    }

    private SomeArgs removeNextBroadcast() {
        ArrayDeque<SomeArgs> queue = queueForNextBroadcast();
        if (queue != this.mPendingUrgent) goto L6;
        this.mActiveCountConsecutiveUrgent++;
    L12:
        if (isQueueEmpty(queue) == false) goto L16;
        return null;
    L16:
        return queue.removeFirst();
    L6:
        if (queue != this.mPending) goto L9;
        this.mActiveCountConsecutiveUrgent = 0;
        this.mActiveCountConsecutiveNormal++;
        goto L12
    L9:
        if (queue != this.mPendingOffload) goto L12;
        this.mActiveCountConsecutiveUrgent = 0;
        this.mActiveCountConsecutiveNormal = 0;
        goto L12
    }

    ArrayDeque<SomeArgs> queueForNextBroadcast() {
        ArrayDeque<SomeArgs> nextNormal = queueForNextBroadcast(this.mPending, this.mPendingOffload, this.mActiveCountConsecutiveNormal, this.constants.MAX_CONSECUTIVE_NORMAL_DISPATCHES);
        ArrayDeque<SomeArgs> nextBroadcastQueue = queueForNextBroadcast(this.mPendingUrgent, nextNormal, this.mActiveCountConsecutiveUrgent, this.constants.MAX_CONSECUTIVE_URGENT_DISPATCHES);
        return nextBroadcastQueue;
    }

    private ArrayDeque<SomeArgs> queueForNextBroadcast(ArrayDeque<SomeArgs> highPriorityQueue, ArrayDeque<SomeArgs> lowPriorityQueue, int consecutiveHighPriorityCount, int maxHighPriorityDispatchLimit) {
        if (isQueueEmpty(highPriorityQueue) == false) goto L6;
        return lowPriorityQueue;
    L6:
        if (isQueueEmpty(lowPriorityQueue) == false) goto L8;
        return highPriorityQueue;
    L8:
        SomeArgs nextLPArgs = lowPriorityQueue.peekFirst();
        BroadcastRecord nextLPRecord = (BroadcastRecord) nextLPArgs.arg1;
        int nextLPRecordIndex = nextLPArgs.argi1;
        BroadcastRecord nextHPRecord = (BroadcastRecord) highPriorityQueue.peekFirst().arg1;
        boolean isLPQueueEligible = true;
        if (this.mCountPrioritizeEarliestRequests > 0) goto L13;
        if (consecutiveHighPriorityCount >= maxHighPriorityDispatchLimit) goto L13;
        boolean shouldConsiderLPQueue = false;
    L14:
        if (shouldConsiderLPQueue == true) goto L16;
    L20:
        isLPQueueEligible = false;
    L22:
        if (isLPQueueEligible == false) goto L25;
        return lowPriorityQueue;
    L25:
        return highPriorityQueue;
    L16:
        if (nextLPRecord.enqueueTime > nextHPRecord.enqueueTime) goto L20;
        if (nextLPRecord.isBlocked(nextLPRecordIndex) == true) goto L20;
    L13:
        shouldConsiderLPQueue = true;
        goto L14
    }

    private static boolean isQueueEmpty(ArrayDeque<SomeArgs> queue) {
        if (queue != null) goto L4;
    L7:
        return true;
    L4:
        if (queue.isEmpty() == true) goto L7;
        return false;
    }

    boolean addPrioritizeEarliestRequest() {
        if (this.mCountPrioritizeEarliestRequests != 0) goto L6;
        this.mCountPrioritizeEarliestRequests++;
        invalidateRunnableAt();
        return true;
    L6:
        this.mCountPrioritizeEarliestRequests++;
        return false;
    }

    boolean removePrioritizeEarliestRequest() {
        this.mCountPrioritizeEarliestRequests--;
        if (this.mCountPrioritizeEarliestRequests != 0) goto L7;
        invalidateRunnableAt();
        return true;
    L7:
        if (this.mCountPrioritizeEarliestRequests >= 0) goto L10;
        this.mCountPrioritizeEarliestRequests = 0;
        return false;
    L10:
        return false;
    }

    SomeArgs peekNextBroadcast() {
        ArrayDeque<SomeArgs> queue = queueForNextBroadcast();
        if (isQueueEmpty(queue) == false) goto L7;
        return null;
    L7:
        return queue.peekFirst();
    }

    BroadcastRecord peekNextBroadcastRecord() {
        ArrayDeque<SomeArgs> queue = queueForNextBroadcast();
        if (isQueueEmpty(queue) == false) goto L7;
        return null;
    L7:
        return (BroadcastRecord) queue.peekFirst().arg1;
    }

    public boolean isPendingManifest() {
        if (this.mCountManifest <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPendingOrdered() {
        if (this.mCountOrdered <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPendingResultTo() {
        if (this.mCountResultTo <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPendingUrgent() {
        BroadcastRecord next = peekNextBroadcastRecord();
        if (next != null) goto L7;
        return false;
    L7:
        return next.isUrgent();
    }

    public boolean isIdle() {
        if (isActive() == true) goto L7;
        if (isEmpty() == false) goto L7;
    L8:
        return true;
    L7:
        if (isDeferredUntilActive() == true) goto L8;
        return false;
    }

    public boolean isBeyondBarrierLocked(long barrierTime) {
        SomeArgs next = this.mPending.peekFirst();
        SomeArgs nextUrgent = this.mPendingUrgent.peekFirst();
        SomeArgs nextOffload = this.mPendingOffload.peekFirst();
        if (this.mActive != null) goto L5;
    L8:
        boolean activeBeyond = true;
    L9:
        if (next != null) goto L11;
    L14:
        boolean nextBeyond = true;
    L15:
        if (nextUrgent != null) goto L17;
    L20:
        boolean nextUrgentBeyond = true;
    L21:
        if (nextOffload != null) goto L23;
    L26:
        boolean nextOffloadBeyond = true;
    L27:
        if (activeBeyond == false) goto L32;
        if (nextBeyond == false) goto L32;
        if (nextUrgentBeyond == false) goto L32;
        if (nextOffloadBeyond == false) goto L32;
        return true;
    L32:
        if (isDeferredUntilActive() == false) goto L35;
        return true;
    L35:
        return false;
    L23:
        if (((BroadcastRecord) nextOffload.arg1).enqueueTime > barrierTime) goto L26;
        nextOffloadBeyond = false;
        goto L27
    L17:
        if (((BroadcastRecord) nextUrgent.arg1).enqueueTime > barrierTime) goto L20;
        nextUrgentBeyond = false;
        goto L21
    L11:
        if (((BroadcastRecord) next.arg1).enqueueTime > barrierTime) goto L14;
        nextBeyond = false;
        goto L15
    L5:
        if (this.mActive.enqueueTime > barrierTime) goto L8;
        activeBeyond = false;
        goto L9
    }

    public boolean isDispatched(Intent intent) {
        if (this.mActive != null) goto L5;
    L8:
        boolean activeDispatched = true;
    L9:
        boolean dispatched = isDispatchedInQueue(this.mPending, intent);
        boolean urgentDispatched = isDispatchedInQueue(this.mPendingUrgent, intent);
        boolean offloadDispatched = isDispatchedInQueue(this.mPendingOffload, intent);
        if (activeDispatched == false) goto L15;
        if (dispatched == false) goto L15;
        if (urgentDispatched == false) goto L15;
        if (offloadDispatched == false) goto L15;
        return true;
    L15:
        if (isDeferredUntilActive() == false) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (intent.filterEquals(this.mActive.intent) == false) goto L8;
        activeDispatched = false;
        goto L9
    }

    private boolean isDispatchedInQueue(ArrayDeque<SomeArgs> queue, Intent intent) {
        Iterator<SomeArgs> it = queue.iterator();
    L4:
        if (it.hasNext() == false) goto L13;
        SomeArgs args = it.next();
        if (args == null) goto L7;
        BroadcastRecord record = (BroadcastRecord) args.arg1;
        if (intent.filterEquals(record.intent) == false) goto L4;
        return false;
    L7:
        return true;
    L13:
        return true;
    }

    public boolean isRunnable() {
        if (this.mRunnableAtInvalidated == false) goto L6;
        updateRunnableAt();
    L6:
        if (this.mRunnableAt == Long.MAX_VALUE) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean isDeferredUntilActive() {
        if (this.mRunnableAtInvalidated == false) goto L6;
        updateRunnableAt();
    L6:
        if (this.mRunnableAtReason != 8) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean hasDeferredBroadcasts() {
        if (this.mCountDeferred <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getRunnableAt() {
        if (this.mRunnableAtInvalidated == false) goto L6;
        updateRunnableAt();
    L6:
        return this.mRunnableAt;
    }

    public int getRunnableAtReason() {
        if (this.mRunnableAtInvalidated == false) goto L6;
        updateRunnableAt();
    L6:
        return this.mRunnableAtReason;
    }

    public void invalidateRunnableAt() {
        this.mRunnableAtInvalidated = true;
    }

    static String reasonToString(int reason) {
        switch(reason) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L4;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L5;
            default: goto L4;
        };
    L5:
        return "TOP_PROCESS";
    L7:
        return "CORE_UID";
    L9:
        return "FOREGROUND";
    L11:
        return "CONTAINS_MANIFEST";
    L13:
        return "CONTAINS_INSTRUMENTED";
    L15:
        return "CONTAINS_RESULT_TO";
    L17:
        return "CONTAINS_INTERACTIVE";
    L19:
        return "CONTAINS_PRIORITIZED";
    L21:
        return "CONTAINS_ALARM";
    L23:
        return "CONTAINS_ORDERED";
    L25:
        return "CONTAINS_FOREGROUND";
    L27:
        return "INFINITE_DEFER";
    L29:
        return "FORCE_DELAYED";
    L31:
        return "PERSISTENT";
    L33:
        return "INSTRUMENTED";
    L35:
        return "BLOCKED";
    L37:
        return "MAX_PENDING";
    L39:
        return PriorityDump.PRIORITY_ARG_NORMAL;
    L41:
        return "CACHED";
    L43:
        return "EMPTY";
    L4:
        return Integer.toString(reason);
    }

    void updateRunnableAt() {
        if (this.mRunnableAtInvalidated == true) goto L5;
        return;
    L5:
        this.mRunnableAtInvalidated = false;
        SomeArgs next = peekNextBroadcast();
        if (next == null) goto L81;
        BroadcastRecord r = (BroadcastRecord) next.arg1;
        int index = next.argi1;
        long runnableAt = r.enqueueTime;
        if (r.isBlocked(index) == false) goto L12;
        this.mRunnableAt = Long.MAX_VALUE;
        this.mRunnableAtReason = 4;
        return;
    L12:
        if (SysOptBridge.getFactory().getBroadcastProxy().processUseProxy(this.processName, this.uid) == false) goto L15;
        this.mRunnableAt = Long.MAX_VALUE;
        this.mRunnableAtReason = 8;
    L78:
        if (((this.mPending.size() + this.mPendingUrgent.size()) + this.mPendingOffload.size()) < this.constants.MAX_PENDING_BROADCASTS) goto L84;
        this.mRunnableAt = Math.min(this.mRunnableAt, runnableAt);
        this.mRunnableAtReason = 3;
        return;
    L84:
        return;
    L15:
        if (this.mForcedDelayedDurationMs <= 0) goto L18;
        this.mRunnableAt = this.mForcedDelayedDurationMs + runnableAt;
        this.mRunnableAtReason = 7;
        goto L78
    L18:
        if (this.mCountForeground <= this.mCountForegroundDeferred) goto L21;
        this.mRunnableAt = this.constants.DELAY_URGENT_MILLIS + runnableAt;
        this.mRunnableAtReason = 10;
        goto L78
    L21:
        if (this.mCountInteractive <= 0) goto L24;
        this.mRunnableAt = this.constants.DELAY_URGENT_MILLIS + runnableAt;
        this.mRunnableAtReason = 14;
        goto L78
    L24:
        if (this.mCountInstrumented <= 0) goto L27;
        this.mRunnableAt = this.constants.DELAY_URGENT_MILLIS + runnableAt;
        this.mRunnableAtReason = 16;
        goto L78
    L27:
        if (this.mProcessInstrumented == false) goto L30;
        this.mRunnableAt = this.constants.DELAY_URGENT_MILLIS + runnableAt;
        this.mRunnableAtReason = 5;
        goto L78
    L30:
        if (this.mUidForeground == false) goto L33;
        this.mRunnableAt = this.constants.DELAY_FOREGROUND_PROC_MILLIS + runnableAt;
        this.mRunnableAtReason = 18;
        goto L78
    L33:
        if (this.app == null) goto L38;
        if (this.app.getSetProcState() != 2) goto L38;
        this.mRunnableAt = this.constants.DELAY_FOREGROUND_PROC_MILLIS + runnableAt;
        this.mRunnableAtReason = 20;
    L38:
        if (this.mProcessPersistent == false) goto L41;
        this.mRunnableAt = this.constants.DELAY_PERSISTENT_PROC_MILLIS + runnableAt;
        this.mRunnableAtReason = 6;
        goto L78
    L41:
        if (this.mCountOrdered <= 0) goto L44;
        this.mRunnableAt = runnableAt;
        this.mRunnableAtReason = 11;
        goto L78
    L44:
        if (this.mCountAlarm <= 0) goto L47;
        this.mRunnableAt = runnableAt;
        this.mRunnableAtReason = 12;
        goto L78
    L47:
        if (this.mCountPrioritized <= this.mCountPrioritizedDeferred) goto L50;
        this.mRunnableAt = runnableAt;
        this.mRunnableAtReason = 13;
        goto L78
    L50:
        if (this.mCountManifest <= 0) goto L53;
        this.mRunnableAt = runnableAt;
        this.mRunnableAtReason = 17;
        goto L78
    L53:
        if (this.mProcessFreezable == false) goto L71;
        if (r.deferUntilActive == true) goto L57;
        this.mRunnableAt = this.constants.DELAY_CACHED_MILLIS + runnableAt;
        this.mRunnableAtReason = 1;
        goto L78
    L57:
        if (this.mCountDeferred != this.mCountEnqueued) goto L60;
        this.mRunnableAt = Long.MAX_VALUE;
        this.mRunnableAtReason = 8;
        goto L78
    L60:
        if (r.isForeground() == false) goto L63;
        this.mRunnableAt = this.constants.DELAY_URGENT_MILLIS + runnableAt;
        this.mRunnableAtReason = 10;
        goto L78
    L63:
        if (r.prioritized == false) goto L66;
        this.mRunnableAt = runnableAt;
        this.mRunnableAtReason = 13;
        goto L78
    L66:
        if (r.resultTo == null) goto L68;
        this.mRunnableAt = runnableAt;
        this.mRunnableAtReason = 15;
        goto L78
    L68:
        this.mRunnableAt = this.constants.DELAY_CACHED_MILLIS + runnableAt;
        this.mRunnableAtReason = 1;
        goto L78
    L71:
        if (this.mCountResultTo <= 0) goto L74;
        this.mRunnableAt = runnableAt;
        this.mRunnableAtReason = 15;
        goto L78
    L74:
        if (UserHandle.isCore(this.uid) == false) goto L76;
        this.mRunnableAt = runnableAt;
        this.mRunnableAtReason = 19;
        goto L78
    L76:
        this.mRunnableAt = this.constants.DELAY_NORMAL_MILLIS + runnableAt;
        this.mRunnableAtReason = 2;
        goto L78
    L81:
        this.mRunnableAt = Long.MAX_VALUE;
        this.mRunnableAtReason = 0;
    }

    void updateDeferredStates(BroadcastConsumer applyConsumer, BroadcastConsumer clearConsumer) {
        boolean wantDeferredStates = shouldBeDeferred();
        if (this.mLastDeferredStates == wantDeferredStates) goto L9;
        this.mLastDeferredStates = wantDeferredStates;
        if (wantDeferredStates == false) goto L7;
        forEachMatchingBroadcast(new BroadcastProcessQueue$$ExternalSyntheticLambda1(), applyConsumer, false);
        return;
    L7:
        forEachMatchingBroadcast(new BroadcastProcessQueue$$ExternalSyntheticLambda2(), clearConsumer, false);
        return;
    }

    private static /* synthetic */ boolean lambda$updateDeferredStates$0(BroadcastRecord r, int i) {
        if (r.getDeliveryState(i) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$updateDeferredStates$1(BroadcastRecord r, int i) {
        if (r.getDeliveryState(i) != 6) goto L5;
        return true;
    L5:
        return false;
    }

    void clearDeferredStates(BroadcastConsumer clearConsumer) {
        if (this.mLastDeferredStates == false) goto L6;
        this.mLastDeferredStates = false;
        forEachMatchingBroadcast(new BroadcastProcessQueue$$ExternalSyntheticLambda0(), clearConsumer, false);
        return;
    }

    private static /* synthetic */ boolean lambda$clearDeferredStates$2(BroadcastRecord r, int i) {
        if (r.getDeliveryState(i) != 6) goto L5;
        return true;
    L5:
        return false;
    }

    boolean shouldBeDeferred() {
        if (this.mRunnableAtInvalidated == false) goto L6;
        updateRunnableAt();
    L6:
        if (this.mRunnableAtReason != 1) goto L8;
        return true;
    L8:
        if (this.mRunnableAtReason == 8) goto L13;
        return false;
    L13:
        return true;
    }

    public void assertHealthLocked() {
        if (isActive() == true) goto L5;
        Preconditions.checkState(!this.mRunnableAtInvalidated, "mRunnableAtInvalidated");
    L5:
        assertHealthLocked(this.mPending);
        assertHealthLocked(this.mPendingUrgent);
        assertHealthLocked(this.mPendingOffload);
    }

    private void assertHealthLocked(ArrayDeque<SomeArgs> queue) {
        if (queue.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<SomeArgs> it = queue.descendingIterator();
    L7:
        if (it.hasNext() == false) goto L18;
        SomeArgs args = it.next();
        BroadcastRecord record = (BroadcastRecord) args.arg1;
        int recordIndex = args.argi1;
        if (BroadcastRecord.isDeliveryStateTerminal(record.getDeliveryState(recordIndex)) == true) goto L7;
        if (record.isDeferUntilActive() == true) goto L7;
        long waitingTime = SystemClock.uptimeMillis() - record.enqueueTime;
        if (waitingTime >= 600000) goto L16;
        boolean r6 = true;
    L17:
        Preconditions.checkState(r6, "waitingTime");
        goto L7
    L16:
        r6 = false;
        goto L17
    }

    static BroadcastProcessQueue insertIntoRunnableList(BroadcastProcessQueue head, BroadcastProcessQueue item) {
        if (head != null) goto L4;
        return item;
    L4:
        long itemRunnableAt = item.getRunnableAt();
        BroadcastProcessQueue test = head;
        BroadcastProcessQueue tail = null;
    L5:
        if (test == null) goto L19;
        if (test.getRunnableAt() > itemRunnableAt) goto L8;
        tail = test;
        test = test.runnableAtNext;
        goto L5
    L8:
        item.runnableAtNext = test;
        item.runnableAtPrev = test.runnableAtPrev;
        if (item.runnableAtNext == null) goto L12;
        item.runnableAtNext.runnableAtPrev = item;
    L12:
        if (item.runnableAtPrev == null) goto L14;
        item.runnableAtPrev.runnableAtNext = item;
    L14:
        if (test != head) goto L17;
        return item;
    L17:
        return head;
    L19:
        item.runnableAtPrev = tail;
        item.runnableAtPrev.runnableAtNext = item;
        return head;
    }

    static BroadcastProcessQueue removeFromRunnableList(BroadcastProcessQueue head, BroadcastProcessQueue item) {
        if (head != item) goto L5;
        head = item.runnableAtNext;
    L5:
        if (item.runnableAtNext == null) goto L8;
        BroadcastProcessQueue r0 = item.runnableAtNext;
        r0.runnableAtPrev = item.runnableAtPrev;
    L8:
        if (item.runnableAtPrev == null) goto L10;
        BroadcastProcessQueue r1 = item.runnableAtPrev;
        r1.runnableAtNext = item.runnableAtNext;
    L10:
        item.runnableAtNext = null;
        item.runnableAtPrev = null;
        return head;
    }

    void setTimeoutScheduled(boolean timeoutScheduled) {
        this.mTimeoutScheduled = timeoutScheduled;
    }

    boolean timeoutScheduled() {
        return this.mTimeoutScheduled;
    }

    public String toString() {
        if (this.mCachedToString != null) goto L6;
        this.mCachedToString = "BroadcastProcessQueue{" + toShortString() + "}";
    L6:
        return this.mCachedToString;
    }

    public String toShortString() {
        if (this.mCachedToShortString != null) goto L10;
        StringBuilder r0 = new StringBuilder();
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append(" ");
        if (this.app == null) goto L7;
        Object r1 = Integer.valueOf(this.app.getPid());
    L8:
        r0.append(r1);
        r0.append(":");
        r0.append(this.processName);
        r0.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        r0.append(UserHandle.formatUid(this.uid));
        this.mCachedToShortString = r0.toString();
        goto L10
    L7:
        r1 = "?";
    L10:
        return this.mCachedToShortString;
    }

    public String describeStateLocked() {
        return describeStateLocked(SystemClock.uptimeMillis());
    }

    public String describeStateLocked(long now) {
        StringBuilder sb = new StringBuilder();
        if (isRunnable() == false) goto L5;
        sb.append("runnable at ");
        TimeUtils.formatDuration(getRunnableAt(), now, sb);
    L6:
        sb.append(" because ");
        sb.append(reasonToString(this.mRunnableAtReason));
        return sb.toString();
    L5:
        sb.append("not runnable");
        goto L6
    }

    @NeverCompile
    public void dumpLocked(long now, IndentingPrintWriter pw) {
        if (this.mActive == null) goto L5;
    L9:
        pw.print(toShortString());
        pw.print(" ");
        pw.print(describeStateLocked(now));
        pw.println();
        pw.increaseIndent();
        dumpProcessState(pw);
        dumpBroadcastCounts(pw);
        if (this.mOutgoingBroadcasts.isEmpty() == true) goto L16;
        int i = 0;
    L13:
        if (i >= this.mOutgoingBroadcasts.size()) goto L16;
        dumpOutgoingRecord(now, pw, this.mOutgoingBroadcasts.get(i));
        i = i + 1;
    L16:
        if (this.mActive == null) goto L18;
        dumpRecord("ACTIVE", now, pw, this.mActive, this.mActiveIndex);
    L18:
        Iterator<SomeArgs> r7 = this.mPendingUrgent.iterator();
    L20:
        if (r7.hasNext() == false) goto L22;
        SomeArgs args = r7.next();
        BroadcastRecord r = (BroadcastRecord) args.arg1;
        dumpRecord("URGENT", now, pw, r, args.argi1);
        goto L20
    L22:
        Iterator<SomeArgs> r8 = this.mPending.iterator();
    L24:
        if (r8.hasNext() == false) goto L26;
        SomeArgs args2 = r8.next();
        BroadcastRecord r2 = (BroadcastRecord) args2.arg1;
        dumpRecord(null, now, pw, r2, args2.argi1);
        goto L24
    L26:
        Iterator<SomeArgs> r9 = this.mPendingOffload.iterator();
    L28:
        if (r9.hasNext() == false) goto L30;
        SomeArgs args3 = r9.next();
        BroadcastRecord r3 = (BroadcastRecord) args3.arg1;
        dumpRecord("OFFLOAD", now, pw, r3, args3.argi1);
        goto L28
    L30:
        pw.decreaseIndent();
        pw.println();
        return;
    L5:
        if (isEmpty() == false) goto L9;
        if (isOutgoingEmpty() == false) goto L9;
    }

    @NeverCompile
    private void dumpProcessState(IndentingPrintWriter pw) {
        StringBuilder sb = new StringBuilder();
        if (this.mUidForeground == false) goto L6;
        sb.append("FG");
    L6:
        if (this.mProcessFreezable == false) goto L12;
        if (sb.length() <= 0) goto L10;
        sb.append("|");
    L10:
        sb.append("FRZ");
    L12:
        if (this.mProcessInstrumented == false) goto L18;
        if (sb.length() <= 0) goto L16;
        sb.append("|");
    L16:
        sb.append("INSTR");
    L18:
        if (this.mProcessPersistent == false) goto L24;
        if (sb.length() <= 0) goto L22;
        sb.append("|");
    L22:
        sb.append("PER");
    L24:
        if (sb.length() <= 0) goto L27;
        pw.print("state:");
        pw.println(sb);
    L27:
        if (this.runningOomAdjusted == false) goto L30;
        pw.print("runningOomAdjusted:");
        pw.println(this.runningOomAdjusted);
    L30:
        if (this.mActiveReEnqueued == false) goto L33;
        pw.print("activeReEnqueued:");
        pw.println(this.mActiveReEnqueued);
    L33:
        if (this.mProcessStartInitiatedTimestampMillis <= 0) goto L36;
        pw.print("processStartInitiatedTimestamp:");
        pw.println(TimeUtils.formatUptime(this.mProcessStartInitiatedTimestampMillis));
        return;
    }

    @NeverCompile
    private void dumpBroadcastCounts(IndentingPrintWriter pw) {
        pw.print("e:");
        pw.print(this.mCountEnqueued);
        pw.print(" d:");
        pw.print(this.mCountDeferred);
        pw.print(" f:");
        pw.print(this.mCountForeground);
        pw.print(" fd:");
        pw.print(this.mCountForegroundDeferred);
        pw.print(" o:");
        pw.print(this.mCountOrdered);
        pw.print(" a:");
        pw.print(this.mCountAlarm);
        pw.print(" p:");
        pw.print(this.mCountPrioritized);
        pw.print(" pd:");
        pw.print(this.mCountPrioritizedDeferred);
        pw.print(" int:");
        pw.print(this.mCountInteractive);
        pw.print(" rt:");
        pw.print(this.mCountResultTo);
        pw.print(" ins:");
        pw.print(this.mCountInstrumented);
        pw.print(" m:");
        pw.print(this.mCountManifest);
        pw.print(" csi:");
        pw.print(this.mActiveCountSinceIdle);
        pw.print(" adcsi:");
        pw.print(this.mActiveAssumedDeliveryCountSinceIdle);
        pw.print(" ccu:");
        pw.print(this.mActiveCountConsecutiveUrgent);
        pw.print(" ccn:");
        pw.print(this.mActiveCountConsecutiveNormal);
        pw.println();
    }

    @NeverCompile
    private void dumpOutgoingRecord(long now, IndentingPrintWriter pw, BroadcastRecord record) {
        pw.print("OUTGOING ");
        TimeUtils.formatDuration(record.enqueueTime, now, pw);
        pw.print(' ');
        pw.println(record.toShortString());
    }

    @NeverCompile
    private void dumpRecord(String flavor, long now, IndentingPrintWriter pw, BroadcastRecord record, int recordIndex) {
        TimeUtils.formatDuration(record.enqueueTime, now, pw);
        pw.print(' ');
        pw.println(record.toShortString());
        pw.print("    ");
        int deliveryState = record.delivery[recordIndex];
        pw.print(BroadcastRecord.deliveryStateToString(deliveryState));
        if (deliveryState != 4) goto L5;
        pw.print(" at ");
        TimeUtils.formatDuration(record.scheduledTime[recordIndex], now, pw);
    L5:
        if (flavor == null) goto L7;
        pw.print(' ');
        pw.print(flavor);
    L7:
        Object receiver = record.receivers.get(recordIndex);
        if ((receiver instanceof BroadcastFilter) == false) goto L10;
        BroadcastFilter filter = (BroadcastFilter) receiver;
        pw.print(" for registered ");
        pw.print(Integer.toHexString(System.identityHashCode(filter)));
    L11:
        pw.println();
        int blockedUntilBeyondCount = record.blockedUntilBeyondCount[recordIndex];
        if (blockedUntilBeyondCount == (-1)) goto L15;
        pw.print("    blocked until ");
        pw.print(blockedUntilBeyondCount);
        pw.print(", currently at ");
        pw.print(record.beyondCount);
        pw.print(" of ");
        pw.println(record.receivers.size());
        return;
    L15:
        return;
    L10:
        ResolveInfo info = (ResolveInfo) receiver;
        pw.print(" for manifest ");
        pw.print(info.activityInfo.name);
        goto L11
    }
}
