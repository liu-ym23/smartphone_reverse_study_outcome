package com.android.server.am;

import android.app.IApplicationThread;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.os.Bundle;
import android.os.BundleMerger;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.StabTrace;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.MathUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.SomeArgs;
import com.android.internal.os.TimeoutRecord;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserJourneyLogger;
import com.android.server.pm.UserManagerInternal;
import com.android.server.utils.AnrTimer;
import dalvik.annotation.optimization.NeverCompile;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
class BroadcastQueueImpl extends BroadcastQueue {
    private static final BroadcastProcessQueue.BroadcastPredicate BROADCAST_PREDICATE_ANY = null;
    private static final int MSG_BG_ACTIVITY_START_TIMEOUT = 3;
    private static final int MSG_CHECK_HEALTH = 4;
    private static final int MSG_CHECK_PENDING_COLD_START_VALIDITY = 5;
    private static final int MSG_DELIVERY_TIMEOUT = 2;
    private static final int MSG_DELIVERY_TIMEOUT_SOFT = 8;
    private static final int MSG_PROCESS_FREEZABLE_CHANGED = 6;
    private static final int MSG_UID_STATE_CHANGED = 7;
    private static final int MSG_UPDATE_RUNNING_LIST = 1;
    private static final Predicate<BroadcastProcessQueue> QUEUE_PREDICATE_ANY = null;
    private static final ThreadLocal<Boolean> localProxyExecutingFlag = null;
    private final BroadcastAnrTimer mAnrTimer;
    private final BroadcastConstants mBgConstants;
    final BroadcastProcessQueue.BroadcastConsumer mBroadcastConsumerDeferApply;
    final BroadcastProcessQueue.BroadcastConsumer mBroadcastConsumerDeferClear;
    private final BroadcastProcessQueue.BroadcastConsumer mBroadcastConsumerSkip;
    private final BroadcastProcessQueue.BroadcastConsumer mBroadcastConsumerSkipAndCanceled;
    final BroadcastProcessQueue.BroadcastRecordConsumer mBroadcastRecordConsumerEnqueue;
    private boolean mCheckPendingColdStartQueued;
    private final BroadcastConstants mConstants;
    private final BroadcastConstants mFgConstants;
    private long mLastTestFailureTime;
    private final Handler.Callback mLocalCallback;
    private final Handler mLocalHandler;
    private final AtomicReference<ArrayMap<BroadcastRecord, Boolean>> mMatchingRecordsCache;
    private final SparseArray<BroadcastProcessQueue> mProcessQueues;
    private final AtomicReference<ArrayMap<BroadcastRecord, Boolean>> mRecordsLookupCache;
    private final AtomicReference<ArraySet<BroadcastRecord>> mReplacedBroadcastsCache;
    private BroadcastProcessQueue mRunnableHead;
    private final BroadcastProcessQueue[] mRunning;
    private BroadcastProcessQueue mRunningColdStart;
    private final SparseBooleanArray mUidForeground;
    private final ArrayList<Pair<BooleanSupplier, CountDownLatch>> mWaitingFor;

    private class BroadcastAnrTimer extends AnrTimer<BroadcastProcessQueue> {
        @Override // com.android.server.utils.AnrTimer
        public /* bridge */ /* synthetic */ int getPid(BroadcastProcessQueue r1) {
            return getPid2(r1);
        }

        @Override // com.android.server.utils.AnrTimer
        public /* bridge */ /* synthetic */ int getUid(BroadcastProcessQueue r1) {
            return getUid2(r1);
        }

        BroadcastAnrTimer(BroadcastQueueImpl r3, Handler handler) {
            handler.getClass();
            super(handler, 2, "BROADCAST_TIMEOUT", new AnrTimer.Args().extend(true).freeze(true));
        }

        /* JADX INFO: renamed from: getPid, reason: avoid collision after fix types in other method */
        public int getPid2(BroadcastProcessQueue queue) {
            if (queue.app != null) goto L7;
            return 0;
        L7:
            return queue.app.getPid();
        }

        /* JADX INFO: renamed from: getUid, reason: avoid collision after fix types in other method */
        public int getUid2(BroadcastProcessQueue queue) {
            if (queue.app != null) goto L7;
            return 0;
        L7:
            return queue.app.uid;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-3_WqStOlS7UcrjzrWAwmVpzdkA, reason: not valid java name */
    public static /* synthetic */ boolean m1429$r8$lambda$3_WqStOlS7UcrjzrWAwmVpzdkA(BroadcastQueueImpl r0, boolean r1, int[] r2, int[] r3, BroadcastProcessQueue r4, BroadcastRecord r5, int r6) {
        return r0.lambda$setQueueStateForAppLocked$3(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ boolean $r8$lambda$16QYAuLQL3EjTEbctyb4fjGpHEU(int r0, BroadcastProcessQueue r1) {
        return lambda$cleanupDisabledPackageReceiversLocked$8(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$24PEwJCwFrtCwhjMejYjBqDalyI(String r0, Set r1, BroadcastRecord r2, int r3) {
        return lambda$cleanupDisabledPackageReceiversLocked$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$36Murt_YECpyx_eGYLLWKGof5sY(Pair r0) {
        return lambda$checkAndRemoveWaitingFor$26(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$9LyTZjPKPw65Pm7HDxcpTo37u0A(Intent r0, BroadcastProcessQueue r1) {
        return lambda$isDispatchedLocked$20(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$9o7g5bJ-8tHmwNsfR1es9uO4cgE, reason: not valid java name */
    public static /* synthetic */ void m1430$r8$lambda$9o7g5bJ8tHmwNsfR1es9uO4cgE(BroadcastQueueImpl r0, BroadcastProcessQueue r1, BroadcastRecord r2, int r3) {
        r0.lambda$setQueueStateForAppLocked$5(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$INT1l1VprHS2_5w83SbK_-Hd0q4, reason: not valid java name */
    public static /* synthetic */ boolean m1431$r8$lambda$INT1l1VprHS2_5w83SbK_Hd0q4(String r0, BroadcastProcessQueue r1) {
        return lambda$forceDelayBroadcastDelivery$27(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$RGyhdMcpap1Xu61N08H-0ANd0A0, reason: not valid java name */
    public static /* synthetic */ void m1432$r8$lambda$RGyhdMcpap1Xu61N08H0ANd0A0(BroadcastProcessQueue r0) {
        lambda$waitForBarrier$24(r0);
    }

    public static /* synthetic */ void $r8$lambda$TfBD96WDRJ0dFtOWQXnUta1JS0U(BroadcastQueueImpl r0, BroadcastRecord r1, int r2) {
        r0.lambda$new$15(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$VgcsFK2RiSzBc-KtrXoDQab557g, reason: not valid java name */
    public static /* synthetic */ void m1433$r8$lambda$VgcsFK2RiSzBcKtrXoDQab557g(long r0, BroadcastProcessQueue r2) {
        lambda$forceDelayBroadcastDelivery$28(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Y-LFIebE_0Tu90RyFG7Xi1KFU9Y, reason: not valid java name */
    public static /* synthetic */ boolean m1434$r8$lambda$YLFIebE_0Tu90RyFG7Xi1KFU9Y(BroadcastQueueImpl r0, long r1, PrintWriter r3) {
        return r0.lambda$waitForBarrier$23(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZSjfmR3N-4_Rj1ZliAjPd6tQ9eE, reason: not valid java name */
    public static /* synthetic */ boolean m1435$r8$lambda$ZSjfmR3N4_Rj1ZliAjPd6tQ9eE(String r0, BroadcastRecord r1, int r2) {
        return lambda$cleanupDisabledPackageReceiversLocked$10(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$_DBczTe7t4lAE7KcMV9C9sM5D20(int r0, BroadcastProcessQueue r1) {
        return lambda$cleanupDisabledPackageReceiversLocked$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$aYfb1X1qhGoHo8ji2mrwb5fT8yE(BroadcastQueueImpl r0, BroadcastRecord r1, int r2) {
        r0.lambda$new$17(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$b4MQRVe1iphcolptzvRL7uhixX4(BroadcastQueueImpl r0, Intent r1, PrintWriter r2) {
        return r0.lambda$waitForDispatched$25(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$cislx9KqVvTHVfn6DcQ_vjSJrsA(BroadcastProcessQueue r0) {
        lambda$waitForBarrier$22(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$cmfmC-q53VS9_U13otci6zDi6J8, reason: not valid java name */
    public static /* synthetic */ Boolean m1436$r8$lambda$cmfmCq53VS9_U13otci6zDi6J8() {
        return lambda$static$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$gih73ir_AazOAkW8TCg-Kq7U4Kw, reason: not valid java name */
    public static /* synthetic */ void m1437$r8$lambda$gih73ir_AazOAkW8TCgKq7U4Kw(BroadcastQueueImpl r0, BroadcastProcessQueue r1, BroadcastRecord r2, int r3) {
        r0.lambda$setQueueStateForAppLocked$4(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$grh5K8_uzdAIFJ3SSnzhlbF219c(BroadcastQueueImpl r0, BroadcastRecord r1, int r2) {
        r0.lambda$new$14(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$hTvD3U_B14oxuL138G715-ved_4, reason: not valid java name */
    public static /* synthetic */ boolean m1438$r8$lambda$hTvD3U_B14oxuL138G715ved_4(BroadcastProcessQueue r0) {
        return lambda$static$12(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$iY9aJvuhBHnDlx11JtYxmh2awoc(BroadcastQueueImpl r0, PrintWriter r1) {
        return r0.lambda$waitForIdle$21(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$jycfqwM1100v-MFr7Fz0Iv7Tq3M, reason: not valid java name */
    public static /* synthetic */ void m1439$r8$lambda$jycfqwM1100vMFr7Fz0Iv7Tq3M(BroadcastQueueImpl r0, BroadcastRecord r1, BundleMerger r2, BroadcastRecord r3, int r4) {
        r0.lambda$applyDeliveryGroupPolicy$6(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$kPC9-oFJolh_mHEJt9cs2FVAGN4, reason: not valid java name */
    public static /* synthetic */ boolean m1440$r8$lambda$kPC9oFJolh_mHEJt9cs2FVAGN4(BroadcastRecord r0, int r1) {
        return lambda$onApplicationCleanupLocked$2(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$lwpbuvoC3sO_snXqauY6qtxYQgw(BroadcastProcessQueue r0) {
        return lambda$isIdleLocked$18(r0);
    }

    public static /* synthetic */ void $r8$lambda$mc1rLqcRwmT6yixPJOiz7kluisg(BroadcastQueueImpl r0, BroadcastRecord r1, int r2) {
        r0.lambda$new$16(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$sqFcSHotBNb0_rR8LuPQw2ckqts(long r0, BroadcastProcessQueue r2) {
        return lambda$isBeyondBarrierLocked$19(r0, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$tgOTcR1opnm9qhcvbolboGPMf60(BroadcastQueueImpl r0, BroadcastRecord r1, ArrayMap r2, BroadcastRecord r3, int r4) {
        return r0.lambda$applyDeliveryGroupPolicy$7(r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$u3RGRsbM3cYM5RzKAYBrDpF3BAU(BroadcastQueueImpl r0, Message r1) {
        return r0.lambda$new$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$wY3BJKhJdmeaW_BKCTx4_JSzW64(BroadcastRecord r0, int r1) {
        return lambda$static$13(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocalHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m1441$$Nest$fgetmLocalHandler(BroadcastQueueImpl r0) {
        return r0.mLocalHandler;
    }

    BroadcastQueueImpl(ActivityManagerService service, Handler handler, BroadcastConstants fgConstants, BroadcastConstants bgConstants) {
        this(service, handler, fgConstants, bgConstants, new BroadcastSkipPolicy(service), new BroadcastHistory(fgConstants));
    }

    BroadcastQueueImpl(ActivityManagerService service, Handler handler, BroadcastConstants fgConstants, BroadcastConstants bgConstants, BroadcastSkipPolicy skipPolicy, BroadcastHistory history) {
        super(service, handler, skipPolicy, history);
        this.mProcessQueues = new SparseArray();
        this.mRunnableHead = null;
        this.mWaitingFor = new ArrayList();
        this.mReplacedBroadcastsCache = new AtomicReference();
        this.mRecordsLookupCache = new AtomicReference();
        this.mMatchingRecordsCache = new AtomicReference();
        this.mUidForeground = new SparseBooleanArray();
        this.mLocalCallback = new BroadcastQueueImpl$$ExternalSyntheticLambda24(this);
        this.mBroadcastConsumerSkip = new BroadcastQueueImpl$$ExternalSyntheticLambda25(this);
        this.mBroadcastConsumerSkipAndCanceled = new BroadcastQueueImpl$$ExternalSyntheticLambda26(this);
        this.mBroadcastConsumerDeferApply = new BroadcastQueueImpl$$ExternalSyntheticLambda27(this);
        this.mBroadcastConsumerDeferClear = new BroadcastQueueImpl$$ExternalSyntheticLambda28(this);
        this.mBroadcastRecordConsumerEnqueue = new BroadcastQueueImpl$$ExternalSyntheticLambda29(this);
        fgConstants.getClass();
        this.mConstants = fgConstants;
        fgConstants.getClass();
        this.mFgConstants = fgConstants;
        bgConstants.getClass();
        this.mBgConstants = bgConstants;
        this.mLocalHandler = new Handler(handler.getLooper(), this.mLocalCallback);
        this.mRunning = new BroadcastProcessQueue[this.mConstants.getMaxRunningQueues()];
        this.mAnrTimer = new BroadcastAnrTimer(this, this.mLocalHandler);
        SysOptBridge.getFactory().getBroadcastChecker().init(service.mContext);
    }

    static {
        localProxyExecutingFlag = ThreadLocal.withInitial(new BroadcastQueueImpl$$ExternalSyntheticLambda20());
        QUEUE_PREDICATE_ANY = new BroadcastQueueImpl$$ExternalSyntheticLambda21();
        BROADCAST_PREDICATE_ANY = new BroadcastQueueImpl$$ExternalSyntheticLambda22();
    }

    private static /* synthetic */ Boolean lambda$static$0() {
        return false;
    }

    private void enqueueUpdateRunningList() {
        this.mLocalHandler.removeMessages(1);
        this.mLocalHandler.sendEmptyMessage(1);
    }

    private /* synthetic */ boolean lambda$new$1(Message msg) {
        switch(msg.what) {
            case 1: goto L56;
            case 2: goto L54;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L32;
            case 6: goto L30;
            case 7: goto L15;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        deliveryTimeoutSoftLocked((BroadcastProcessQueue) msg.obj, msg.arg1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
        return true;
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L15:
        int uid = ((Integer) msg.obj).intValue();
        int procState = msg.arg1;
        ActivityManagerService r3 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        if (procState != 2) goto L22;
        this.mUidForeground.put(uid, true);     // Catch: Throwable -> L20
    L23:
        refreshProcessQueuesLocked(uid);     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        return true;
    L22:
        this.mUidForeground.delete(uid);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L30:
        handleProcessFreezableChanged((ProcessRecord) msg.obj);
        return true;
    L32:
        ActivityManagerService r1 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mCheckPendingColdStartQueued = false;     // Catch: Throwable -> L38
        checkPendingColdStartValidityLocked();     // Catch: Throwable -> L38
        monitor-exit(r1);     // Catch: Throwable -> L38
        ActivityManagerService.resetPriorityAfterLockedSection();
        return true;
    L38:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L42:
        checkHealth();
        return true;
    L44:
        ActivityManagerService r2 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        SomeArgs args = (SomeArgs) msg.obj;     // Catch: Throwable -> L50
        ProcessRecord app = (ProcessRecord) args.arg1;     // Catch: Throwable -> L50
        BroadcastRecord r = (BroadcastRecord) args.arg2;     // Catch: Throwable -> L50
        args.recycle();     // Catch: Throwable -> L50
        app.removeBackgroundStartPrivileges(r);     // Catch: Throwable -> L50
        monitor-exit(r2);     // Catch: Throwable -> L50
        ActivityManagerService.resetPriorityAfterLockedSection();
        return true;
    L50:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L54:
        deliveryTimeout((BroadcastProcessQueue) msg.obj);
        return true;
    L56:
        updateRunningList();
        return true;
    }

    private int getRunningSize() {
        int size = 0;
        int i = 0;
    L4:
        if (i >= this.mRunning.length) goto L10;
        if (this.mRunning[i] == null) goto L8;
        size = size + 1;
    L8:
        i = i + 1;
        goto L4
    L10:
        return size;
    }

    private int getRunningUrgentCount() {
        int count = 0;
        int i = 0;
    L4:
        if (i >= this.mRunning.length) goto L12;
        if (this.mRunning[i] == null) goto L10;
        if (this.mRunning[i].getActive().isUrgent() == false) goto L10;
        count = count + 1;
    L10:
        i = i + 1;
        goto L4
    L12:
        return count;
    }

    private int getRunningIndexOf(BroadcastProcessQueue test) {
        int i = 0;
    L4:
        if (i >= this.mRunning.length) goto L9;
        if (this.mRunning[i] == test) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        return -1;
    }

    private void updateRunnableList(BroadcastProcessQueue queue) {
        if (getRunningIndexOf(queue) < 0) goto L5;
        return;
    L5:
        queue.updateDeferredStates(this.mBroadcastConsumerDeferApply, this.mBroadcastConsumerDeferClear);
        queue.updateRunnableAt();
        boolean wantQueue = queue.isRunnable();
        boolean nextHigher = false;
        if (queue != this.mRunnableHead) goto L8;
    L13:
        boolean inQueue = true;
    L14:
        if (wantQueue == false) goto L32;
        if (inQueue == true) goto L17;
        this.mRunnableHead = BroadcastProcessQueue.insertIntoRunnableList(this.mRunnableHead, queue);
    L35:
        if (queue.isEmpty() == true) goto L37;
        return;
    L37:
        if (queue.isOutgoingEmpty() == true) goto L39;
        return;
    L39:
        if (queue.isActive() == false) goto L41;
        return;
    L41:
        if (queue.isProcessWarm() == true) goto L47;
        removeProcessQueue(queue.processName, queue.uid);
        return;
    L47:
        return;
    L17:
        if (queue.runnableAtPrev != null) goto L19;
    L20:
        boolean prevLower = true;
    L23:
        if (queue.runnableAtNext != null) goto L25;
    L26:
        nextHigher = true;
    L27:
        if (prevLower == false) goto L29;
        if (nextHigher == true) goto L35;
    L29:
        this.mRunnableHead = BroadcastProcessQueue.removeFromRunnableList(this.mRunnableHead, queue);
        this.mRunnableHead = BroadcastProcessQueue.insertIntoRunnableList(this.mRunnableHead, queue);
        goto L35
    L25:
        if (queue.runnableAtNext.getRunnableAt() < queue.getRunnableAt()) goto L27;
    L19:
        if (queue.runnableAtPrev.getRunnableAt() <= queue.getRunnableAt()) goto L20;
        prevLower = false;
        goto L23
    L32:
        if (inQueue == false) goto L35;
        this.mRunnableHead = BroadcastProcessQueue.removeFromRunnableList(this.mRunnableHead, queue);
        goto L35
    L8:
        if (queue.runnableAtPrev != null) goto L13;
        if (queue.runnableAtNext != null) goto L13;
        inQueue = false;
        goto L14
    }

    private void updateRunningList() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        updateRunningListLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void updateRunningListLocked() {
        int usedExtra = Math.min(getRunningUrgentCount(), this.mConstants.EXTRA_RUNNING_URGENT_PROCESS_QUEUES);
        int avail = (this.mRunning.length - getRunningSize()) - usedExtra;
        if (avail != 0) goto L5;
        return;
    L5:
        int cookie = BroadcastQueue.traceBegin("updateRunningList");
        long now = SystemClock.uptimeMillis();
        int r7 = 1;
        boolean waitingFor = !this.mWaitingFor.isEmpty();
        this.mLocalHandler.removeMessages(1);
        BroadcastProcessQueue queue = this.mRunnableHead;
        int avail2 = avail;
        boolean updateOomAdj = false;
    L6:
        if (queue == null) goto L61;
        if (avail2 <= 0) goto L61;
        queue = queue.runnableAtNext;
        long runnableAt = queue.getRunnableAt();
        if (queue.isRunnable() == false) goto L6;
        if (getRunningSize() < this.mConstants.MAX_RUNNING_PROCESS_QUEUES) goto L17;
        if (queue.isPendingUrgent() == false) goto L6;
    L17:
        if (SysOptBridge.getFactory().getBroadcastProxy().processUseProxy(queue.processName, queue.uid) == false) goto L23;
        if (queue.sizeExceeds() == false) goto L23;
    L23:
        if (runnableAt <= now) goto L26;
        if (waitingFor == true) goto L26;
        this.mLocalHandler.sendEmptyMessageAtTime(r7, runnableAt);
    L26:
        queue.clearDeferredStates(this.mBroadcastConsumerDeferClear);
        updateWarmProcess(queue);
        boolean processWarm = queue.isProcessWarm();
        if (processWarm == true) goto L29;
        updateOomAdj = updateOomAdj;
        if (this.mRunningColdStart == null) goto L37;
        if (isPendingColdStartValid() == false) goto L41;
        updateOomAdj = updateOomAdj;
        r7 = 1;
        goto L6
    L41:
        clearInvalidPendingColdStart();
        this.mRunningColdStart = queue;
        this.mRunningColdStart.clearProcessStartInitiatedTimestampMillis();
    L43:
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L45;
        BroadcastQueue.logv("Promoting " + queue + " from runnable to running; process is " + queue.app);
    L45:
        promoteToRunningLocked(queue);
        if (processWarm == false) goto L53;
        boolean updateOomAdj2 = updateOomAdj | queue.runningOomAdjusted;
        boolean completed = scheduleReceiverWarmLocked(queue);     // Catch: BroadcastRetryException -> L50
    L49:
        usedExtra = usedExtra;
        cookie = cookie;
    L57:
        if (completed == false) goto L59;
        demoteFromRunningLocked(queue);
    L59:
        avail2 = avail2 - 1;
        updateOomAdj = updateOomAdj2;
        usedExtra = usedExtra;
        cookie = cookie;
        r7 = 1;
    L51:
        finishOrReEnqueueActiveBroadcast(queue);
        completed = true;
        goto L49
    L53:
        if (SysOptBridge.getFactory().getBroadcastProxy().processUseProxy(queue.processName, queue.uid) == true) goto L56;
        SysOptBridge.getFactory().getApplicationFreezer().unfreezeAppIfNeededLocked(queue.app, queue.processName, queue.uid, IApplicationFreezer.UnfreezeReason.NEED_BROADCAST, null, null, new IApplicationFreezer.FreezeInfo().setCallerInfo(new IApplicationFreezer.CallerInfo().setExtraMsg("after-promote")));
    L56:
        completed = scheduleReceiverColdLocked(queue);
        updateOomAdj2 = updateOomAdj;
        goto L57
    L37:
        this.mRunningColdStart = queue;
        this.mRunningColdStart.clearProcessStartInitiatedTimestampMillis();
        goto L43
    L29:
        if (queue.app != null) goto L32;
        queue.app = SysOptBridge.getFactory().getApplicationFreezer().get(queue.processName, queue.uid);
    L32:
        this.mService.mOomAdjuster.unfreezeTemporarily(queue.app, 3);
        if (queue.isProcessWarm() == true) goto L43;
        enqueueUpdateRunningList();
        updateOomAdj = updateOomAdj;
        r7 = 1;
    L61:
        if (updateOomAdj == false) goto L63;
        this.mService.updateOomAdjPendingTargetsLocked(3);
    L63:
        checkPendingColdStartValidityLocked();
        checkAndRemoveWaitingFor();
        BroadcastQueue.traceEnd(cookie);
    }

    private boolean isPendingColdStartValid() {
        if (this.mRunningColdStart.hasProcessStartInitiationTimedout() == false) goto L7;
        return false;
    L7:
        if (this.mRunningColdStart.app.getPid() <= 0) goto L11;
        return !this.mRunningColdStart.app.isKilled();
    L11:
        return this.mRunningColdStart.app.isPendingStart();
    }

    private void clearInvalidPendingColdStart() {
        BroadcastQueue.logw("Clearing invalid pending cold start: " + this.mRunningColdStart);
        if (this.mRunningColdStart.wasActiveBroadcastReEnqueued() == false) goto L5;
        finishReceiverActiveLocked(this.mRunningColdStart, 5, "invalid start with re-enqueued broadcast");
    L6:
        BroadcastProcessQueue queue = this.mRunningColdStart;
        clearRunningColdStart();
        demoteFromRunningLocked(queue);
        enqueueUpdateRunningList();
        return;
    L5:
        this.mRunningColdStart.reEnqueueActiveBroadcast();
        goto L6
    }

    private void checkPendingColdStartValidityLocked() {
        if (this.mRunningColdStart != null) goto L6;
        return;
    L6:
        if (isPendingColdStartValid() == true) goto L8;
        clearInvalidPendingColdStart();
        return;
    L8:
        if (this.mCheckPendingColdStartQueued == true) goto L12;
        this.mLocalHandler.sendEmptyMessageDelayed(5, this.mConstants.PENDING_COLD_START_CHECK_INTERVAL_MILLIS);
        this.mCheckPendingColdStartQueued = true;
        return;
    }

    private void finishOrReEnqueueActiveBroadcast(BroadcastProcessQueue queue) {
        BroadcastQueue.checkState(queue.isActive(), "isActive");
        if (queue.wasActiveBroadcastReEnqueued() == false) goto L5;
        finishReceiverActiveLocked(queue, 5, "re-enqueued broadcast delivery failed");
        return;
    L5:
        BroadcastRecord record = queue.getActive();
        int index = queue.getActiveIndex();
        setDeliveryState(queue, queue.app, record, index, record.receivers.get(index), 0, "reEnqueueActiveBroadcast");
        queue.reEnqueueActiveBroadcast();
    }

    @Override // com.android.server.am.BroadcastQueue
    public boolean onApplicationAttachedLocked(ProcessRecord app) throws BroadcastRetryException {
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L5;
        BroadcastQueue.logv("Process " + app + " is attached");
    L5:
        BroadcastProcessQueue queue = getProcessQueue(app);
        if (queue == null) goto L9;
        setQueueProcess(queue, app);
        queue.clearOutgoingBroadcasts();
    L9:
        if (this.mRunningColdStart != null) goto L11;
        return false;
    L11:
        if (this.mRunningColdStart != queue) goto L25;
        this.mRunningColdStart.clearProcessStartInitiatedTimestampMillis();
        this.mRunningColdStart = null;
        notifyStartedRunning(queue);
        this.mService.updateOomAdjPendingTargetsLocked(3);
        queue.traceProcessEnd();
        queue.traceProcessRunningBegin();
    L17:
        e = move-exception;
        finishOrReEnqueueActiveBroadcast(queue);
        demoteFromRunningLocked(queue);
        throw e;
    L14:
        if (scheduleReceiverWarmLocked(queue) == false) goto L19;
        demoteFromRunningLocked(queue);     // Catch: BroadcastRetryException -> L17
    L19:
        enqueueUpdateRunningList();
        return true;
    L25:
        return false;
    }

    @Override // com.android.server.am.BroadcastQueue
    public void onApplicationTimeoutLocked(ProcessRecord app) {
        onApplicationCleanupLocked(app);
    }

    @Override // com.android.server.am.BroadcastQueue
    public void onApplicationProblemLocked(ProcessRecord app) {
        onApplicationCleanupLocked(app);
    }

    @Override // com.android.server.am.BroadcastQueue
    public void onApplicationCleanupLocked(ProcessRecord app) {
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L5;
        BroadcastQueue.logv("Process " + app + " is cleaned up");
    L5:
        SysOptBridge.getFactory().getBroadcastProxy().unProxy(app, "cleanup");
        BroadcastProcessQueue queue = getProcessQueue(app);
        if (this.mRunningColdStart != null) goto L8;
    L12:
        if (queue != null) goto L14;
        return;
    L14:
        if (queue.app != app) goto L25;
        setQueueProcess(queue, null);
        if (queue.isActive() == false) goto L18;
        finishReceiverActiveLocked(queue, 5, "onApplicationCleanupLocked");
        demoteFromRunningLocked(queue);
    L18:
        queue.clearOutgoingBroadcasts();
        boolean didSomething = queue.forEachMatchingBroadcast(new BroadcastQueueImpl$$ExternalSyntheticLambda19(), this.mBroadcastConsumerSkip, true);
        if (didSomething == false) goto L21;
    L22:
        updateRunnableList(queue);
        enqueueUpdateRunningList();
        return;
    L21:
        if (queue.isEmpty() == true) goto L22;
        return;
    L25:
        return;
    L8:
        if (this.mRunningColdStart != queue) goto L12;
        if (this.mRunningColdStart.app != app) goto L12;
        clearRunningColdStart();
        goto L12
    }

    private static /* synthetic */ boolean lambda$onApplicationCleanupLocked$2(BroadcastRecord r, int i) {
        return r.receivers.get(i) instanceof BroadcastFilter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.am.BroadcastQueue
    public void setQueueStateForAppLocked(ProcessRecord r19, final boolean r20) {
        final BroadcastProcessQueue r1 = getProcessQueue(r19);
        if (r1 != null) goto L6;
        Slog.e(IBroadcastProxy.TAG_BROADCAST_PROXY, "queue=" + r1 + " app is null!");
        return;
    L6:
        char r10 = 0;
        final int[] r4 = {0};
        final int[] r3 = {0};
        BroadcastProcessQueue.BroadcastPredicate r0 = new BroadcastQueueImpl$$ExternalSyntheticLambda2(this, r20, r3, r4, r1);
        final BroadcastQueueImpl r2 = this;
        if (r20 == false) goto L9;
        BroadcastProcessQueue.BroadcastConsumer r5 = new BroadcastQueueImpl$$ExternalSyntheticLambda3(r2, r1);
    L10:
        boolean r14 = r1.forEachMatchingBroadcast(r0, r5, false);
        if (r1.isActive() == false) goto L32;
        BroadcastRecord r6 = r1.getActive();
        int r7 = r1.getActiveIndex();
        int r8 = r2.getDeliveryState(r6, r7);
        Slog.i(IBroadcastProxy.TAG_BROADCAST_PROXY, "queue=" + r1 + " has active:" + r6 + " state:" + r8);
        if (r20 == true) goto L15;
    L17:
        if (r20 == false) goto L24;
        if (r8 != 0) goto L24;
        if (SysOptBridge.getFactory().getBroadcastProxy().isBroadcastCanBeProxy(r6) == false) goto L24;
        r10 = 0;
        r2.setDeliveryState(r1, r1.app, r6, r7, r6.receivers.get(r7), 6, "on-broadcast-proxy");
        r4[0] = r4[0] + 1;
        BroadcastQueueImpl r9 = this;
    L34:
        if (r1.app != null) goto L36;
    L43:
        r1.invalidateRunnableAt();
        r9.updateRunnableList(r1);
        r9.enqueueUpdateRunningList();
        return;
    L36:
        if (r3[r10] <= 0) goto L43;
        r9.setProxyExecutingFlag(true);
        r1.invalidateRunnableAt();
        r9.finishReceiverLocked(r1.app, 0, null, null, false, true);
        r9.setProxyExecutingFlag(r10);
        if (r20 == true) goto L40;
    L42:
        Slog.i(IBroadcastProxy.TAG_BROADCAST_PROXY, "setQueueState queue=" + r1 + " defer=" + r20 + " didSomethingInQueue=" + r14 + " modifiedNum=" + r4[0] + " delivered=" + r3[0]);
        goto L43
    L40:
        if (r9.shouldRetire(r1) == true) goto L42;
        Slog.w(IBroadcastProxy.TAG_BROADCAST_PROXY, "queue=" + r1 + " set to proxy but not retire!");
    L24:
        if (r20 == false) goto L26;
    L31:
        r9 = this;
        goto L34
    L26:
        if (r8 != 6) goto L31;
        if (SysOptBridge.getFactory().getBroadcastProxy().isBroadcastCanBeProxy(r6) == false) goto L30;
        BroadcastQueueImpl r11 = this;
        r11.setDeliveryState(r1, r1.app, r6, r7, r6.receivers.get(r7), 0, "on-broadcast-proxy");
        r4[r10] = r4[r10] + 1;
        r9 = r11;
        goto L34
    L30:
        r9 = this;
        goto L34
    L15:
        if (r8 != 4) goto L17;
        r3[0] = r3[0] + 1;
        r4[0] = r4[0] + 1;
        Slog.i(IBroadcastProxy.TAG_BROADCAST_PROXY, "queue " + r1 + " active=" + r6 + " set to finish");
        r10 = 0;
        r9 = r2;
        goto L34
    L32:
        r10 = 0;
        r9 = r2;
        goto L34
    L9:
        r5 = new BroadcastQueueImpl$$ExternalSyntheticLambda4(r2, r1);
        goto L10
    }

    private /* synthetic */ boolean lambda$setQueueStateForAppLocked$3(boolean defer, int[] changeToDelivered, int[] modifiedNum, BroadcastProcessQueue queue, BroadcastRecord r, int i) {
        Slog.i(IBroadcastProxy.TAG_BROADCAST_PROXY, "forEachMatching. r=" + r + ", i=" + i + ", state=" + getDeliveryState(r, i));
        int r0 = 1;
        if (defer == false) goto L9;
        if (getDeliveryState(r, i) != 4) goto L9;
        changeToDelivered[0] = changeToDelivered[0] + 1;
        modifiedNum[0] = modifiedNum[0] + 1;
        Slog.i(BroadcastQueue.TAG, "queue " + queue + " active=" + queue.getActiveIndex() + " i=" + i + " set to finish");
        return false;
    L9:
        if (SysOptBridge.getFactory().getBroadcastProxy().isBroadcastCanBeProxy(r) == true) goto L11;
    L15:
        boolean modify = false;
    L16:
        int r3 = modifiedNum[0];
        if (modify == true) goto L20;
        r0 = 0;
    L20:
        modifiedNum[0] = r3 + r0;
        return modify;
    L11:
        if (getDeliveryState(r, i) != 0) goto L13;
    L14:
        modify = true;
        goto L16
    L13:
        if (getDeliveryState(r, i) != 6) goto L15;
        goto L14
    }

    private /* synthetic */ void lambda$setQueueStateForAppLocked$4(BroadcastProcessQueue queue, BroadcastRecord r, int i) {
        setDeliveryState(queue, queue.app, r, i, r.receivers.get(i), 6, "on-broadcast-proxy");
    }

    private /* synthetic */ void lambda$setQueueStateForAppLocked$5(BroadcastProcessQueue queue, BroadcastRecord r, int i) {
        setDeliveryState(queue, queue.app, r, i, r.receivers.get(i), 0, "on-broadcast-proxy");
    }

    private void setProxyExecutingFlag(boolean flag) {
        localProxyExecutingFlag.set(Boolean.valueOf(flag));
    }

    private boolean getProxyExecutingFlag() {
        if (localProxyExecutingFlag.get() != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    private void clearRunningColdStart() {
        this.mRunningColdStart.traceProcessEnd();
        this.mRunningColdStart.clearProcessStartInitiatedTimestampMillis();
        this.mRunningColdStart = null;
        enqueueUpdateRunningList();
    }

    @Override // com.android.server.am.BroadcastQueue
    public void onProcessFreezableChangedLocked(ProcessRecord app) {
        this.mLocalHandler.removeMessages(6, app);
        this.mLocalHandler.obtainMessage(6, app).sendToTarget();
    }

    @Override // com.android.server.am.BroadcastQueue
    public int getPreferredSchedulingGroupLocked(ProcessRecord app) {
        BroadcastProcessQueue queue = getProcessQueue(app);
        if (queue != null) goto L5;
        return Integer.MIN_VALUE;
    L5:
        if (getRunningIndexOf(queue) >= 0) goto L7;
        return Integer.MIN_VALUE;
    L7:
        return queue.getPreferredSchedulingGroupLocked();
    }

    @Override // com.android.server.am.BroadcastQueue
    public void enqueueBroadcastLocked(BroadcastRecord r) {
        BroadcastQueueImpl this = this;
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L5;
    L6:
        BroadcastQueue.logv("Enqueuing " + r + " for " + r.receivers.size() + " receivers");
    L7:
        int cookie = BroadcastQueue.traceBegin("enqueueBroadcast");
        r.applySingletonPolicy(this.mService);
        applyDeliveryGroupPolicy(r);
        r.enqueueTime = SystemClock.uptimeMillis();
        r.enqueueRealTime = SystemClock.elapsedRealtime();
        r.enqueueClockTime = System.currentTimeMillis();
        this.mHistory.onBroadcastEnqueuedLocked(r);
        ArraySet<BroadcastRecord> replacedBroadcasts = this.mReplacedBroadcastsCache.getAndSet(null);
        if (replacedBroadcasts != null) goto L10;
        ArraySet<BroadcastRecord> replacedBroadcasts2 = new ArraySet();
    L11:
        ArrayMap<BroadcastRecord, Boolean> matchingBroadcasts = this.mMatchingRecordsCache.getAndSet(null);
        if (matchingBroadcasts != null) goto L14;
        ArrayMap<BroadcastRecord, Boolean> matchingBroadcasts2 = new ArrayMap();
    L15:
        r.setMatchingRecordsCache(matchingBroadcasts2);
        boolean enqueuedBroadcast = false;
        int i = 0;
    L17:
        if (i >= r.receivers.size()) goto L41;
        Object receiver = r.receivers.get(i);
        BroadcastProcessQueue queue = this.getOrCreateProcessQueue(BroadcastRecord.getReceiverProcessName(receiver), BroadcastRecord.getReceiverUid(receiver));
        String skipReason = this.mSkipPolicy.shouldSkipAtEnqueueMessage(r, receiver);
        if (skipReason == null) goto L22;
        this.setDeliveryState(null, null, r, i, receiver, 2, "skipped by policy at enqueue: " + skipReason);
        this = this;
    L40:
        i = i + 1;
        goto L17
    L22:
        if (SysOptBridge.getFactory().getBroadcastProxy().processUseProxy(queue.processName, queue.uid) == true) goto L24;
        this = this;
    L36:
        BroadcastRecord replacedBroadcast = queue.enqueueOrReplaceBroadcast(r, i, this.mBroadcastConsumerDeferApply);
        if (replacedBroadcast == null) goto L39;
        replacedBroadcasts2.add(replacedBroadcast);
    L39:
        this.updateRunnableList(queue);
        this.enqueueUpdateRunningList();
        enqueuedBroadcast = true;
        goto L40
    L24:
        if (SysOptBridge.getFactory().getBroadcastProxy().isBroadcastCanBeProxy(r) == false) goto L30;
        if (queue.sizeExceeds() == true) goto L30;
        Slog.i(BroadcastQueue.TAG, "setDeliveryState DELIVERY_DEFERRED for app " + queue.app + " br=" + r);
        this = this;
        this.setDeliveryState(null, null, r, i, receiver, 6, IBroadcastProxy.REASON_PROXYING);
    L30:
        Slog.i(BroadcastQueue.TAG, "unfreeze queue " + queue + " app " + queue.app + " for no-whitelist br=" + r);
        IApplicationFreezer r15 = SysOptBridge.getFactory().getApplicationFreezer();
        ProcessRecord r1 = queue.app;
        String r2 = queue.processName;
        int r6 = queue.uid;
        IApplicationFreezer.UnfreezeReason r19 = IApplicationFreezer.UnfreezeReason.NEED_BROADCAST;
        IApplicationFreezer.FreezeInfo r7 = new IApplicationFreezer.FreezeInfo();
        IApplicationFreezer.CallerInfo r3 = new IApplicationFreezer.CallerInfo().setPid(r.callingPid).setUid(r.callingUid).setPackageName(r.callerPackage);
        if (r.alarm == false) goto L33;
        String r9 = "A";
    L34:
        r15.unfreezeAppIfNeededLocked(r1, r2, r6, r19, null, null, r7.setCallerInfo(r3.setType(r9).setAction(r.intent.getAction()).setExtraMsg("enqueue")));
        goto L36
    L33:
        r9 = "B";
        goto L34
    L41:
        this.skipAndCancelReplacedBroadcasts(replacedBroadcasts2);
        replacedBroadcasts2.clear();
        this.mReplacedBroadcastsCache.compareAndSet(null, replacedBroadcasts2);
        matchingBroadcasts2.clear();
        r.clearMatchingRecordsCache();
        this.mMatchingRecordsCache.compareAndSet(null, matchingBroadcasts2);
        if (r.receivers.isEmpty() == true) goto L44;
        if (enqueuedBroadcast == false) goto L44;
    L45:
        BroadcastQueue.traceEnd(cookie);
        return;
    L44:
        scheduleResultTo(r);
        notifyFinishBroadcast(r);
        goto L45
    L14:
        matchingBroadcasts2 = matchingBroadcasts;
        goto L15
    L10:
        replacedBroadcasts2 = replacedBroadcasts;
        goto L11
    L5:
        if (r.debugLog() == false) goto L7;
        goto L6
    }

    private void skipAndCancelReplacedBroadcasts(ArraySet<BroadcastRecord> replacedBroadcasts) {
        int i = 0;
    L4:
        if (i >= replacedBroadcasts.size()) goto L14;
        BroadcastRecord r = replacedBroadcasts.valueAt(i);
        int rcvrIdx = 0;
    L7:
        if (rcvrIdx >= r.receivers.size()) goto L12;
        if (BroadcastRecord.isDeliveryStateTerminal(r.getDeliveryState(rcvrIdx)) == true) goto L11;
        this.mBroadcastConsumerSkipAndCanceled.accept(r, rcvrIdx);
    L11:
        rcvrIdx = rcvrIdx + 1;
        goto L7
    L12:
        i = i + 1;
        goto L4
    }

    private void applyDeliveryGroupPolicy(final BroadcastRecord r) {
        if (this.mService.shouldIgnoreDeliveryGroupPolicy(r.intent.getAction()) == false) goto L5;
        return;
    L5:
        int policy = r.getDeliveryGroupPolicy();
        switch(policy) {
            case 0: goto L19;
            case 1: goto L16;
            case 2: goto L10;
            default: goto L7;
        };
    L7:
        BroadcastQueue.logw("Unknown delivery group policy: " + policy);
        return;
    L16:
        BroadcastProcessQueue.BroadcastConsumer broadcastConsumer = this.mBroadcastConsumerSkipAndCanceled;
    L17:
        final ArrayMap<BroadcastRecord, Boolean> recordsLookupCache = getRecordsLookupCache();
        forEachMatchingBroadcast(QUEUE_PREDICATE_ANY, new BroadcastQueueImpl$$ExternalSyntheticLambda1(this, r, recordsLookupCache), broadcastConsumer, true);
        recordsLookupCache.clear();
        this.mRecordsLookupCache.compareAndSet(null, recordsLookupCache);
        return;
    L19:
        return;
    L10:
        if (r.receivers.size() <= 1) goto L12;
        return;
    L12:
        final BundleMerger extrasMerger = r.options.getDeliveryGroupExtrasMerger();
        if (extrasMerger != null) goto L15;
        return;
    L15:
        broadcastConsumer = new BroadcastQueueImpl$$ExternalSyntheticLambda0(this, r, extrasMerger);
        goto L17
    }

    private /* synthetic */ void lambda$applyDeliveryGroupPolicy$6(BroadcastRecord r, BundleMerger extrasMerger, BroadcastRecord record, int recordIndex) {
        r.intent.mergeExtras(record.intent, extrasMerger);
        this.mBroadcastConsumerSkipAndCanceled.accept(record, recordIndex);
    }

    private /* synthetic */ boolean lambda$applyDeliveryGroupPolicy$7(BroadcastRecord r, ArrayMap recordsLookupCache, BroadcastRecord testRecord, int testIndex) {
        if (BroadcastRecord.isDeliveryStateTerminal(testRecord.getDeliveryState(testIndex)) == false) goto L6;
        return false;
    L6:
        if (r.callingUid == testRecord.callingUid) goto L8;
    L28:
        return false;
    L8:
        if (r.userId != testRecord.userId) goto L28;
        if (r.matchesDeliveryGroup(testRecord) == false) goto L28;
        if (testRecord.ordered == false) goto L17;
        return containsAllReceivers(r, testRecord, recordsLookupCache);
    L17:
        if (testRecord.prioritized == true) goto L24;
        if (testRecord.resultTo != null) goto L24;
        return r.containsReceiver(testRecord.receivers.get(testIndex));
    L24:
        if (testRecord.getDeliveryState(testIndex) != 6) goto L27;
        return r.containsReceiver(testRecord.receivers.get(testIndex));
    L27:
        return containsAllReceivers(r, testRecord, recordsLookupCache);
    }

    private ArrayMap<BroadcastRecord, Boolean> getRecordsLookupCache() {
        ArrayMap<BroadcastRecord, Boolean> recordsLookupCache = this.mRecordsLookupCache.getAndSet(null);
        if (recordsLookupCache == null) goto L5;
        return recordsLookupCache;
    L5:
        return new ArrayMap();
    }

    private boolean containsAllReceivers(BroadcastRecord record, BroadcastRecord testRecord, ArrayMap<BroadcastRecord, Boolean> recordsLookupCache) {
        int idx = recordsLookupCache.indexOfKey(testRecord);
        if (idx > 0) goto L5;
        boolean containsAll = record.containsAllReceivers(testRecord.receivers);
        recordsLookupCache.put(testRecord, Boolean.valueOf(containsAll));
        return containsAll;
    L5:
        return recordsLookupCache.valueAt(idx).booleanValue();
    }

    private boolean scheduleReceiverColdLocked(BroadcastProcessQueue queue) {
        BroadcastQueue.checkState(queue.isActive(), "isActive");
        queue.setActiveViaColdStart(true);
        BroadcastRecord r = queue.getActive();
        int index = queue.getActiveIndex();
        Object receiver = r.receivers.get(index);
        if ((receiver instanceof BroadcastFilter) == false) goto L6;
        this.mRunningColdStart = null;
        finishReceiverActiveLocked(queue, 2, "BroadcastFilter for cold app");
        return true;
    L6:
        String skipReason = shouldSkipReceiver(queue, r, index);
        if (skipReason == null) goto L9;
    L11:
        if (skipReason == null) goto L14;
        this.mRunningColdStart = null;
        finishReceiverActiveLocked(queue, 2, skipReason);
        return true;
    L14:
        ApplicationInfo info = ((ResolveInfo) receiver).activityInfo.applicationInfo;
        ComponentName component = ((ResolveInfo) receiver).activityInfo.getComponentName();
        if (getSmtEx().isBroadcastAllowStartForModern((ResolveInfo) receiver, r) == false) goto L57;
        IApplicationFreezer r14 = SysOptBridge.getFactory().getApplicationFreezer();
        ProcessRecord r15 = r.curApp;
        String r7 = info.processName;
        int r11 = info.uid;
        IApplicationFreezer.UnfreezeReason r18 = IApplicationFreezer.UnfreezeReason.NEED_BROADCAST;
        IApplicationFreezer.FreezeInfo r12 = new IApplicationFreezer.FreezeInfo();
        IApplicationFreezer.CallerInfo r2 = new IApplicationFreezer.CallerInfo().setPid(r.callingPid).setUid(r.callingUid).setPackageName(r.callerPackage);
        if (r.alarm == false) goto L19;
        String r8 = "A";
    L20:
        r14.unfreezeAppIfNeededLocked(r15, r7, r11, r18, null, null, r12.setCallerInfo(r2.setType(r8).setAction(r.intent.getAction()).setExtraMsg("scheduleCold")));
        if (SysOptBridge.getFactory().getBroadcastProxy().processUseProxy(queue.processName, queue.uid) == true) goto L23;
    L25:
        queue.setActiveWasStopped(info.isStopped());
        queue.setActiveFirstLaunch(info.isNotLaunched());
        int intentFlags = r.intent.getFlags() | 4;
        HostingRecord hostingRecord = new HostingRecord("broadcast", component, r.intent.getAction(), r.getHostingRecordTriggerType());
        if (r.options != null) goto L28;
    L30:
        boolean isActivityCapable = false;
    L32:
        if (isActivityCapable == false) goto L34;
        int zygotePolicyFlags = 1;
    L36:
        if ((r.intent.getFlags() & 33554432) == 0) goto L38;
        boolean allowWhileBooting = true;
    L39:
        long startTimeNs = SystemClock.uptimeNanos();
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L42;
    L43:
        BroadcastQueue.logv("Scheduling " + r + " to cold " + queue);
    L45:
        if (StabTrace.isEnable() == false) goto L47;
        long beginTime3 = Process.getCpuClocks();
        long beginTime4 = beginTime3;
    L48:
        queue.app = this.mService.startProcessLocked(queue.processName, info, true, intentFlags, hostingRecord, zygotePolicyFlags, allowWhileBooting, false);
        if (StabTrace.isEnable() == false) goto L52;
        StringBuilder sb = new StringBuilder(150);
        sb.append("BQ:startProcess:");
        sb.append(queue.processName);
        sb.append("intent=");
        sb.append(r.intent.getAction());
        StabTrace.traceInfo(4, sb.toString(), beginTime4, Process.getCpuClocks());
    L52:
        if (queue.app != null) goto L55;
        this.mRunningColdStart = null;
        finishReceiverActiveLocked(queue, 5, "startProcessLocked failed");
        return true;
    L55:
        queue.setProcessStartInitiatedTimestampMillis(SystemClock.uptimeMillis());
        this.mService.mProcessList.getAppStartInfoTracker().handleProcessBroadcastStart(startTimeNs, queue.app, r.getReceiverIntent(receiver), r.alarm);
        return false;
    L47:
        beginTime4 = 0;
        goto L48
    L42:
        if (r.debugLog() == false) goto L45;
    L38:
        allowWhileBooting = false;
        goto L39
    L34:
        zygotePolicyFlags = 0;
        goto L36
    L28:
        if (r.options.getTemporaryAppAllowlistDuration() <= 0) goto L30;
        isActivityCapable = true;
        goto L32
    L23:
        if (SysOptBridge.getFactory().getBroadcastProxy().isBroadcastCanBeProxy(r) == false) goto L25;
        Slog.i(BroadcastQueue.TAG, "UpdateRunningList unfreeze app " + queue.app + " . active=" + queue.getActive() + " r=" + r);
        goto L25
    L19:
        r8 = "B";
        goto L20
    L57:
        this.mRunningColdStart = null;
        finishReceiverActiveLocked(queue, 2, skipReason);
        return true;
    L9:
        if (SysOptBridge.getFactory().getBroadcastChecker().checkBroadcastIsPackageCanStart((ResolveInfo) receiver, r) == true) goto L11;
        Slog.i(BroadcastQueue.TAG, "BroadcastChecker skip broadcast: " + r + " for cold app: " + ((ResolveInfo) receiver).activityInfo.applicationInfo.processName);
        skipReason = "special skip broadcast for launch app";
        goto L11
    }

    private boolean scheduleReceiverWarmLocked(BroadcastProcessQueue queue) throws BroadcastRetryException {
        BroadcastQueue.checkState(queue.isActive(), "isActive");
        int cookie = BroadcastQueue.traceBegin("scheduleReceiverWarmLocked");
    L4:
        if (queue.isActive() == false) goto L33;
        BroadcastRecord r = queue.getActive();
        int index = queue.getActiveIndex();
        if (r.terminalCount != 0) goto L8;
        r.dispatchTime = SystemClock.uptimeMillis();
        r.dispatchRealTime = SystemClock.elapsedRealtime();
        r.dispatchClockTime = System.currentTimeMillis();
    L8:
        String skipReason = shouldSkipReceiver(queue, r, index);
        if (skipReason == null) goto L11;
    L13:
        if (skipReason != null) goto L28;
        IApplicationFreezer r6 = SysOptBridge.getFactory().getApplicationFreezer();
        ProcessRecord r7 = queue.app;
        String r8 = queue.processName;
        int r9 = queue.uid;
        IApplicationFreezer.UnfreezeReason r10 = IApplicationFreezer.UnfreezeReason.NEED_BROADCAST;
        IApplicationFreezer.FreezeInfo r5 = new IApplicationFreezer.FreezeInfo();
        IApplicationFreezer.CallerInfo r11 = new IApplicationFreezer.CallerInfo().setPid(r.callingPid).setUid(r.callingUid).setPackageName(r.callerPackage);
        if (r.alarm == false) goto L17;
        String r12 = "A";
    L18:
        r6.unfreezeAppIfNeededLocked(r7, r8, r9, r10, null, null, r5.setCallerInfo(r11.setType(r12).setAction(r.intent.getAction()).setExtraMsg("scheduleWarm")));
        if (SysOptBridge.getFactory().getBroadcastProxy().processUseProxy(queue.processName, queue.uid) == true) goto L21;
    L23:
        boolean isBlockingDispatch = dispatchReceivers(queue, r, index);
        if (isBlockingDispatch == true) goto L25;
    L30:
        if (shouldRetire(queue) == true) goto L33;
        queue.makeActiveNextPending();
        goto L4
    L25:
        BroadcastQueue.traceEnd(cookie);
        return false;
    L21:
        if (SysOptBridge.getFactory().getBroadcastProxy().isBroadcastCanBeProxy(r) == false) goto L23;
        Slog.i(BroadcastQueue.TAG, "scheduleWarm unfreeze app " + queue.app + " active=" + queue.getActive() + " r=" + r);
        goto L23
    L17:
        r12 = "B";
        goto L18
    L28:
        finishReceiverActiveLocked(queue, 2, skipReason);
        goto L30
    L11:
        if (SysOptBridge.getFactory().getBroadcastChecker().isFilteredBroadcast(queue.app, r.intent.getAction()) == false) goto L13;
        Slog.i(BroadcastQueue.TAG, "BroadcastChecker skip broadcast " + r + " for " + queue.app.processName);
        skipReason = "skip freezed 3rd app broadcast";
    L33:
        BroadcastQueue.traceEnd(cookie);
        return true;
    }

    private String shouldSkipReceiver(BroadcastProcessQueue queue, BroadcastRecord r, int index) {
        int oldDeliveryState = getDeliveryState(r, index);
        ProcessRecord app = queue.app;
        Object receiver = r.receivers.get(index);
        if (BroadcastRecord.isDeliveryStateTerminal(oldDeliveryState) == false) goto L6;
        return "already terminal state";
    L6:
        if (app != null) goto L8;
    L11:
        String skipReason = this.mSkipPolicy.shouldSkipMessage(r, receiver);
        if (skipReason == null) goto L14;
        return skipReason;
    L14:
        Intent receiverIntent = r.getReceiverIntent(receiver);
        if (receiverIntent != null) goto L19;
        return "getReceiverIntent";
    L19:
        if ((receiver instanceof BroadcastFilter) == true) goto L21;
        return null;
    L21:
        if (((BroadcastFilter) receiver).receiverList.pid != app.getPid()) goto L23;
        return null;
    L23:
        if (((BroadcastFilter) receiver).receiverList.pid == app.mSmtEx.pid) goto L30;
        return "BroadcastFilter for mismatched PID";
    L30:
        return null;
    L8:
        if (app.isInFullBackup() == false) goto L11;
        return "isInFullBackup";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean dispatchReceivers(BroadcastProcessQueue r27, BroadcastRecord r28, int r29) throws BroadcastRetryException {
        int r5 = r29;
        ProcessRecord r3 = r27.app;
        Object r6 = r28.receivers.get(r5);
        boolean r15 = r28.isAssumedDelivered(r29);
        if (this.mService.mProcessesReady == true) goto L5;
    L12:
        r27.setTimeoutScheduled(false);
    L14:
        if (r28.mBackgroundStartPrivileges.allowsAny() == false) goto L21;
        r3.addOrUpdateBackgroundStartPrivileges(r28, r28.mBackgroundStartPrivileges);
        if (r28.isForeground() == false) goto L18;
        long r11 = this.mFgConstants.ALLOW_BG_ACTIVITY_START_TIMEOUT;
    L19:
        SomeArgs r0 = SomeArgs.obtain();
        r0.arg1 = r3;
        r0.arg2 = r28;
        this.mLocalHandler.sendMessageDelayed(Message.obtain(this.mLocalHandler, 3, r0), r11);
        goto L21
    L18:
        r11 = this.mBgConstants.ALLOW_BG_ACTIVITY_START_TIMEOUT;
    L21:
        if (r28.options != null) goto L23;
    L28:
        if (r15 == true) goto L35;
        if (r28.isForeground() == false) goto L32;
        long r7 = this.mFgConstants.TIMEOUT;
    L33:
        SysMonitorSvcBridge.getFactory().getAnrMonitor().monitorBroadcast(r28, r3.getPid(), r5, (int) r7);
        goto L35
    L32:
        r7 = this.mBgConstants.TIMEOUT;
    L35:
        if (r3.getThread() != null) goto L44;
        if (r3.getSmtEx().inFreezeStat() == false) goto L44;
        Slog.i("AMS.Freeze", "unfreezeApp for NEED_BROADCAST A, app:" + r3 + " active=" + r27.getActive() + " r=" + r28);
        IApplicationFreezer r1 = SysOptBridge.getFactory().getApplicationFreezer();
        IApplicationFreezer.UnfreezeReason r8 = IApplicationFreezer.UnfreezeReason.NEED_BROADCAST;
        IApplicationFreezer.FreezeInfo r9 = new IApplicationFreezer.FreezeInfo();
        IApplicationFreezer.CallerInfo r12 = new IApplicationFreezer.CallerInfo().setPid(r28.callingPid).setUid(r28.callingUid).setPackageName(r28.callerPackage);
        if (r28.alarm == false) goto L41;
        String r13 = "A";
    L42:
        r1.unfreezeProcessLocked(r3, true, r8, r9.setCallerInfo(r12.setType(r13).setAction(r28.intent.getAction()).setExtraMsg("dispatch")));
        goto L44
    L41:
        r13 = "B";
    L44:
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L46;
    L47:
        BroadcastQueue.logv("Scheduling " + r28 + " to warm " + r3);
    L48:
        setDeliveryState(r27, r3, r28, r5, r6, 4, "scheduleReceiverWarmLocked");
        Intent r10 = r28.getReceiverIntent(r6);
        IApplicationThread r14 = r3.getOnewayThread();
        if (r14 != null) goto L51;
        finishReceiverActiveLocked(r27, 5, "missing IApplicationThread");
        return false;
    L51:
        if (UserHandle.isApp(r3.uid) == false) goto L154;
        SysOptBridge.getFactory().getFreezeController().receiveBroadcastEvent(r3.uid, r3.mPid, false, r28.ordered, r28.intent);
    L154:
    L56:
        e = e;
        boolean r23 = 0;
        int r24 = 1;
    L137:
        BroadcastQueue.logw("Failed to schedule " + r28 + " to " + r6 + " via " + r3 + ": " + e);
        r3.killLocked("Can't deliver broadcast", 13, 26, r24);
        if ((r6 instanceof ResolveInfo) == true) goto L141;
        finishReceiverActiveLocked(r27, 5, "remote app");
        return r23;
    L141:
        cancelDeliveryTimeoutLocked(r27);
        throw new BroadcastRetryException(e);
    L54:
        if (r28.shareIdentity == false) goto L58;
        this.mService.mPackageManagerInt.grantImplicitAccess(r28.userId, r28.intent, UserHandle.getAppId(r3.uid), r28.callingUid, true);     // Catch: RemoteException -> L56
    L58:
        r27.lastProcessState = r3.mState.getCurProcState();     // Catch: RemoteException -> L56
        String r20 = "";
        if ((r6 instanceof BroadcastFilter) == true) goto L145;
        r23 = 0;
        int r18 = -1;
        notifyScheduleReceiver(r3, r28, (ResolveInfo) r6);     // Catch: RemoteException -> L95
        if (StabTrace.isEnable() == false) goto L116;
        long r21 = Process.getCpuClocks();     // Catch: RemoteException -> L95
    L117:
        ActivityInfo r16 = ((ResolveInfo) r6).activityInfo;     // Catch: RemoteException -> L95
        int r17 = r28.resultCode;     // Catch: RemoteException -> L95
        String r19 = r28.resultData;     // Catch: RemoteException -> L95
        Bundle r110 = r28.resultExtras;     // Catch: RemoteException -> L95
        boolean r111 = r28.ordered;     // Catch: RemoteException -> L95
        int r112 = r28.userId;     // Catch: RemoteException -> L95
        r24 = 1;
        int r22 = r3.mState.getReportedProcState();     // Catch: RemoteException -> L122
        if (r28.shareIdentity == false) goto L125;
        r18 = r28.callingUid;     // Catch: RemoteException -> L122
    L125:
        if (r28.shareIdentity == false) goto L127;
        String r113 = r28.callerPackage;     // Catch: RemoteException -> L122
    L128:
        r14.scheduleReceiver(r10, r16, null, r17, r19, r110, r111, r15, r112, r22, r18, r113);     // Catch: RemoteException -> L122
        if (StabTrace.isEnable() == false) goto L136;
        StringBuilder r25 = new StringBuilder(200);     // Catch: RemoteException -> L122
        r25.append("BQ:scheduleReceiver:");     // Catch: RemoteException -> L122
        r25.append(r3.processName);     // Catch: RemoteException -> L122
        r25.append(":");     // Catch: RemoteException -> L122
        if (r28.intent == null) goto L133;
        r20 = r28.intent.getAction();     // Catch: RemoteException -> L122
    L133:
        r25.append(r20);     // Catch: RemoteException -> L122
        StabTrace.traceInfo(4, r25.toString(), r21, Process.getCpuClocks());     // Catch: RemoteException -> L122
        return true;
    L136:
        return true;
    L127:
        r113 = null;
    L122:
        e = e;
        goto L137
    L116:
        r21 = 0;
        goto L117
    L145:
        notifyScheduleRegisteredReceiver(r3, r28, (BroadcastFilter) r6);     // Catch: RemoteException -> L111
        if (r28.ordered == true) goto L64;
    L67:
        long r26 = 0;
    L68:
        IIntentReceiver r2 = ((BroadcastFilter) r6).receiverList.receiver;     // Catch: RemoteException -> L111
        int r114 = r28.resultCode;     // Catch: RemoteException -> L109
        String r115 = r28.resultData;     // Catch: RemoteException -> L109
        Bundle r116 = r28.resultExtras;     // Catch: RemoteException -> L109
        int r117 = -1;
        boolean r118 = r28.ordered;     // Catch: RemoteException -> L109
        boolean r119 = r28.initialSticky;     // Catch: RemoteException -> L107
        int r30 = r28.userId;     // Catch: RemoteException -> L105
        int r31 = r3.mState.getReportedProcState();     // Catch: RemoteException -> L105
        if (r28.shareIdentity == true) goto L150;
    L79:
        if (r28.shareIdentity == false) goto L83;
        boolean r120 = true;
        String r121 = r28.callerPackage;     // Catch: RemoteException -> L77
    L84:
        boolean r4 = r120;
        r23 = 0;
        r14.scheduleRegisteredReceiver(r2, r10, r114, r115, r116, r118, r119, r15, r30, r31, r117, r121);     // Catch: RemoteException -> L103
        if (r28.ordered == false) goto L99;
        if (StabTrace.isEnable() == false) goto L99;
        StringBuilder r32 = new StringBuilder(150);     // Catch: RemoteException -> L95
        r32.append("BQ:schedule_order:");     // Catch: RemoteException -> L95
        r32.append(r3.processName);     // Catch: RemoteException -> L95
        r32.append(":");     // Catch: RemoteException -> L95
        if (r10 == null) goto L97;
        r20 = r10.getAction();     // Catch: RemoteException -> L95
    L97:
        r32.append(r20);     // Catch: RemoteException -> L95
        StabTrace.traceInfo(4, r32.toString(), r26, Process.getCpuClocks());     // Catch: RemoteException -> L95
    L99:
        if (r15 == false) goto L162;
        finishReceiverActiveLocked(r27, r4 ? 1 : 0, "assuming delivered");     // Catch: RemoteException -> L95
        return false;
    L162:
        return r4;
    L103:
        e = e;
        r24 = r4 ? 1 : 0;
    L77:
        e = e;
        r24 = 1;
        r23 = 0;
        goto L137
    L83:
        r121 = null;
        r120 = true;
        goto L84
    L150:
        r117 = r28.callingUid;     // Catch: RemoteException -> L77
    L105:
        e = e;
        r5 = 1;
        int r210 = 0;
    L96:
        r24 = r5;
        r23 = r210;
    L107:
        e = e;
        r210 = 0;
        r5 = 1;
    L109:
        e = e;
        r210 = 0;
        r5 = 1;
        goto L96
    L64:
        if (StabTrace.isEnable() == false) goto L67;
        r26 = Process.getCpuClocks();     // Catch: RemoteException -> L56
    L111:
        e = e;
        r210 = 0;
        r5 = 1;
    L95:
        e = e;
        goto L96
    L46:
        if (r28.debugLog() == false) goto L48;
    L23:
        if (r28.options.getTemporaryAppAllowlistDuration() <= 0) goto L28;
        if (r28.options.getTemporaryAppAllowlistType() != 4) goto L27;
        this.mService.mOomAdjuster.mCachedAppOptimizer.unfreezeTemporarily(r3, 3, r28.options.getTemporaryAppAllowlistDuration());
        goto L28
    L27:
        ActivityManagerService r33 = this.mService;
        int r34 = r27.uid;
        long r122 = r28.options.getTemporaryAppAllowlistDuration();
        int r211 = r28.options.getTemporaryAppAllowlistReasonCode();
        String r212 = r28.toShortString();
        int r213 = r28.options.getTemporaryAppAllowlistType();
        r210 = r28.callingUid;
        r33.tempAllowlistUidLocked(r34, r122, r211, r212, r213, r210 == true ? 1 : 0);
        goto L28
    L5:
        if (r28.timeoutExempt == true) goto L12;
        if (r15 == true) goto L12;
        r27.setTimeoutScheduled(true);
        if (r28.isForeground() == false) goto L10;
        long r35 = this.mFgConstants.TIMEOUT;
    L11:
        startDeliveryTimeoutLocked(r27, (int) r35);
        goto L14
    L10:
        r35 = this.mBgConstants.TIMEOUT;
        goto L11
    }

    private void scheduleResultTo(BroadcastRecord r) {
        if (r.resultTo != null) goto L5;
        return;
    L5:
        ProcessRecord app = r.resultToApp;
        if (app == null) goto L8;
        IApplicationThread r0 = app.getOnewayThread();
    L9:
        IApplicationThread thread = r0;
        if (thread == null) goto L47;
        this.mService.mOomAdjuster.unfreezeTemporarily(app, 2);
        if (r.shareIdentity == false) goto L49;
        if (app.uid == r.callingUid) goto L49;
        this.mService.mPackageManagerInt.grantImplicitAccess(r.userId, r.intent, UserHandle.getAppId(app.uid), r.callingUid, true);
    L49:
    L22:
        e = move-exception;
        String msg = "Failed to schedule result of " + r + " via " + app + ": " + e;
        BroadcastQueue.logw(msg);
        app.killLocked("Can't deliver broadcast", 13, 26, true);
        goto L47
    L18:
        if (r.ordered == true) goto L20;
    L24:
        long beginTime = 0;
    L25:
        IIntentReceiver r6 = r.resultTo;     // Catch: RemoteException -> L22
        Intent r7 = r.intent;     // Catch: RemoteException -> L22
        int r8 = r.resultCode;     // Catch: RemoteException -> L22
        String r9 = r.resultData;     // Catch: RemoteException -> L22
        Bundle r10 = r.resultExtras;     // Catch: RemoteException -> L22
        boolean r12 = r.initialSticky;     // Catch: RemoteException -> L22
        int r14 = r.userId;     // Catch: RemoteException -> L22
        int r15 = app.mState.getReportedProcState();     // Catch: RemoteException -> L22
        if (r.shareIdentity == false) goto L29;
        int r11 = r.callingUid;     // Catch: RemoteException -> L22
    L28:
        int r16 = r11;
        if (r.shareIdentity == false) goto L33;
        String r17 = r.callerPackage;     // Catch: RemoteException -> L22
    L34:
        thread.scheduleRegisteredReceiver(r6, r7, r8, r9, r10, false, r12, true, r14, r15, r16, r17);     // Catch: RemoteException -> L22
        if (r.ordered == false) goto L47;
        if (StabTrace.isEnable() == false) goto L47;
        StringBuilder sb = new StringBuilder(150);     // Catch: RemoteException -> L22
        sb.append("BQ:scheduleResultTo_order:");     // Catch: RemoteException -> L22
        sb.append(app.processName);     // Catch: RemoteException -> L22
        sb.append(":");     // Catch: RemoteException -> L22
        if (r.intent == null) goto L41;
        String r13 = r.intent.getAction();     // Catch: RemoteException -> L22
    L42:
        sb.append(r13);     // Catch: RemoteException -> L22
        StabTrace.traceInfo(4, sb.toString(), beginTime, Process.getCpuClocks());     // Catch: RemoteException -> L22
        goto L47
    L41:
        r13 = "";
        goto L42
    L33:
        r17 = null;
        goto L34
    L29:
        r11 = -1;
        goto L28
    L20:
        if (StabTrace.isEnable() == false) goto L24;
        long beginTime2 = Process.getCpuClocks();     // Catch: RemoteException -> L22
        beginTime = beginTime2;
    L47:
        r.resultTo = null;
        return;
    L8:
        r0 = null;
        goto L9
    }

    private void startDeliveryTimeoutLocked(BroadcastProcessQueue queue, int softTimeoutMillis) {
        if (this.mAnrTimer.serviceEnabled() == false) goto L5;
        this.mAnrTimer.start(queue, softTimeoutMillis);
        return;
    L5:
        queue.lastCpuDelayTime = queue.app.getCpuDelayTime();
        this.mLocalHandler.sendMessageDelayed(Message.obtain(this.mLocalHandler, 8, softTimeoutMillis, 0, queue), softTimeoutMillis);
    }

    private void cancelDeliveryTimeoutLocked(BroadcastProcessQueue queue) {
        this.mAnrTimer.cancel(queue);
        if (this.mAnrTimer.serviceEnabled() == true) goto L6;
        this.mLocalHandler.removeMessages(8, queue);
        return;
    }

    private void deliveryTimeoutSoftLocked(BroadcastProcessQueue queue, int softTimeoutMillis) {
        if (SysOptBridge.getFactory().getBroadcastProxy().processUseProxy(queue.processName, queue.uid) == false) goto L6;
        Slog.w(IBroadcastProxy.TAG_BROADCAST_PROXY, "deliveryTimeoutSoftLocked skipped for app " + queue.app);
    L6:
        if (queue.app == null) goto L8;
        long cpuDelayTime = queue.app.getCpuDelayTime() - queue.lastCpuDelayTime;
        long hardTimeoutMillis = MathUtils.constrain(cpuDelayTime, 0, softTimeoutMillis);
        this.mAnrTimer.start(queue, hardTimeoutMillis);
        return;
    L8:
        deliveryTimeoutLocked(queue);
    }

    private void deliveryTimeout(BroadcastProcessQueue queue) {
        int cookie = BroadcastQueue.traceBegin("deliveryTimeout");
        ActivityManagerService r1 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        deliveryTimeoutLocked(queue);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        BroadcastQueue.traceEnd(cookie);
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void deliveryTimeoutLocked(BroadcastProcessQueue queue) {
        finishReceiverActiveLocked(queue, 3, "deliveryTimeoutLocked");
        demoteFromRunningLocked(queue);
    }

    @Override // com.android.server.am.BroadcastQueue
    public boolean finishReceiverLocked(ProcessRecord app, int resultCode, String resultData, Bundle resultExtras, boolean resultAbort, boolean waitForServices) {
        BroadcastProcessQueue queue = getProcessQueue(app);
        if (queue == null) goto L62;
        if (queue.isActive() == false) goto L62;
        BroadcastRecord r = queue.getActive();
        int callPid = queue.getActiveIndex();
        if (r.ordered == false) goto L14;
        r.resultCode = resultCode;
        r.resultData = resultData;
        r.resultExtras = resultExtras;
        if (r.isNoAbort() == true) goto L14;
        r.resultAbort = resultAbort;
    L14:
        String callProcName = app.processName;
        int callPid2 = app.getSmtEx().getPid();
        if (StabTrace.isEnable() == false) goto L17;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L19:
        if (getProxyExecutingFlag() == false) goto L21;
        String r2 = IBroadcastProxy.REASON_PROXYING;
    L22:
        boolean r3 = true;
        finishReceiverActiveLocked(queue, 1, r2);
        if (r.resultAbort == false) goto L29;
        int i = callPid + 1;
    L26:
        if (i >= r.receivers.size()) goto L28;
        String callProcName2 = callProcName;
        int i2 = i;
        int index = callPid;
        setDeliveryState(null, null, r, i2, r.receivers.get(i), 2, "resultAbort");
        i = i2 + 1;
        callPid2 = callPid2;
        callProcName = callProcName2;
        callPid = index;
        r3 = r3;
        goto L26
    L28:
        boolean r25 = r3;
        String callProcName3 = callProcName;
        int index2 = callPid2;
    L31:
        if (StabTrace.isEnable() == false) goto L47;
        StringBuilder sb = new StringBuilder(120);
        sb.append("finishReceiver:callPid=");
        sb.append(index2);
        if (callProcName3.isEmpty() == true) goto L37;
        sb.append("callProc=");
        sb.append(callProcName3);
    L37:
        if (r.intent == null) goto L44;
        sb.append(" intent=");
        if (r.intent.getAction() == null) goto L42;
        sb.append(" act=");
        sb.append(r.intent.getAction());
    L42:
        if (r.intent.getComponent() == null) goto L44;
        sb.append(" cmp=");
        sb.append(r.intent.getComponent().flattenToShortString());
    L44:
        StabTrace.traceInfo(4, sb.toString(), beginTime2, Process.getCpuClocks());
    L47:
        if (shouldRetire(queue) == false) goto L50;
        demoteFromRunningLocked(queue);
        return r25;
    L50:
        queue.makeActiveNextPending();
        if (scheduleReceiverWarmLocked(queue) == false) goto L58;
        demoteFromRunningLocked(queue);     // Catch: BroadcastRetryException -> L55
        return r25;
    L58:
        return false;
    L59:
        finishOrReEnqueueActiveBroadcast(queue);
        demoteFromRunningLocked(queue);
        return r25;
    L29:
        r25 = true;
        callProcName3 = callProcName;
        index2 = callPid2;
        goto L31
    L21:
        r2 = "remote app";
        goto L22
    L17:
        beginTime2 = 0;
    L62:
        BroadcastQueue.logw("Ignoring finishReceiverLocked; no active broadcast for " + queue);
        return false;
    }

    private boolean shouldRetire(BroadcastProcessQueue queue) {
        if (UserHandle.isCore(queue.uid) == false) goto L13;
        int nonBlockingDeliveryCount = queue.getActiveAssumedDeliveryCountSinceIdle();
        int blockingDeliveryCount = queue.getActiveCountSinceIdle() - queue.getActiveAssumedDeliveryCountSinceIdle();
        if (blockingDeliveryCount < this.mConstants.MAX_CORE_RUNNING_BLOCKING_BROADCASTS) goto L7;
    L10:
        boolean shouldRetire = true;
    L18:
        if (queue.isRunnable() == true) goto L20;
        return true;
    L20:
        if (queue.isProcessWarm() == false) goto L26;
        if (shouldRetire == false) goto L24;
        return true;
    L24:
        return false;
    L26:
        return true;
    L7:
        if (nonBlockingDeliveryCount >= this.mConstants.MAX_CORE_RUNNING_NON_BLOCKING_BROADCASTS) goto L10;
        shouldRetire = false;
        goto L18
    L13:
        if (queue.getActiveCountSinceIdle() < this.mConstants.MAX_RUNNING_ACTIVE_BROADCASTS) goto L15;
        boolean r0 = true;
    L16:
        shouldRetire = r0;
        goto L18
    L15:
        r0 = false;
        goto L16
    }

    private void finishReceiverActiveLocked(BroadcastProcessQueue queue, int deliveryState, String reason) {
        if (queue.isActive() == true) goto L6;
        BroadcastQueue.logw("Ignoring finishReceiverActiveLocked; no active broadcast for " + queue);
        return;
    L6:
        int cookie = BroadcastQueue.traceBegin("finishReceiver");
        ProcessRecord app = queue.app;
        BroadcastRecord r = queue.getActive();
        int index = queue.getActiveIndex();
        Object receiver = r.receivers.get(index);
        boolean assumeDelivered = r.isAssumedDelivered(index);
        if (assumeDelivered == true) goto L9;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().cancelBroadcast(r, index);
    L9:
        setDeliveryState(queue, app, r, index, receiver, deliveryState, reason);
        if (deliveryState != 3) goto L36;
        r.anrCount++;
        if (app != null) goto L14;
    L34:
        this.mAnrTimer.discard(queue);
    L38:
        checkAndRemoveWaitingFor();
        BroadcastQueue.traceEnd(cookie);
        return;
    L14:
        if (app.isDebugging() == true) goto L34;
        if (UserHandle.isApp(app.uid) == false) goto L18;
        SysOptBridge.getFactory().getFreezeController().broadcastTimeoutEvent(app.uid, app.mPid, r.intent);
    L18:
        AutoCloseable timer = this.mAnrTimer.accept(queue);
        String packageName = BroadcastRecord.getReceiverPackageName(receiver);
        String className = BroadcastRecord.getReceiverClassName(receiver);
        TimeoutRecord tr = TimeoutRecord.forBroadcastReceiver(r.intent, packageName, className).setExpiredTimer(timer);
        StringBuilder r12 = new StringBuilder();
        r12.append(tr.mReason);
        r12.append(" queueName=");
        String r14 = "background";
        if (r.isForeground() == false) goto L21;
        String r13 = "foreground";
    L22:
        r12.append(r13);
        tr.mReason = r12.toString();
        if (StabTrace.isEnable() == false) goto L25;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L26:
        SysOptBridge.getFactory().getApplicationFreezer().checkProcessFreezeState(new FreezeErrorData(FreezeErrorData.ErrorType.BROADCAST_NOT_RESPOND, queue.app.uid, queue.app.getSmtEx().getPid(), queue.app.processName, r.intent.toString()));
        this.mService.appNotResponding(queue.app, tr);
        if (StabTrace.isEnable() == false) goto L38;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long currentTimeMillis = System.currentTimeMillis();
        String formattedDate = sdf.format(new Date(currentTimeMillis));
        StringBuilder sb = new StringBuilder(150);
        sb.append(formattedDate);
        sb.append("BQ:");
        if (r.isForeground() == false) goto L31;
        r14 = "foreground";
    L31:
        sb.append(r14);
        sb.append(":");
        sb.append(app.processName);
        sb.append(" pid=");
        sb.append(Integer.valueOf(app.getSmtEx().getPid()));
        sb.append(" occur ANR");
        StabTrace.traceInfo(4, sb.toString(), beginTime2, Process.getCpuClocks());
        goto L38
    L25:
        beginTime2 = 0;
        goto L26
    L21:
        r13 = "background";
        goto L22
    L36:
        if (queue.timeoutScheduled() == false) goto L38;
        cancelDeliveryTimeoutLocked(queue);
        goto L38
    }

    private void promoteToRunningLocked(BroadcastProcessQueue queue) {
        int queueIndex = getRunningIndexOf(null);
        this.mRunning[queueIndex] = queue;
        this.mRunnableHead = BroadcastProcessQueue.removeFromRunnableList(this.mRunnableHead, queue);
        queue.runningTraceTrackName = "BroadcastQueue.mRunning[" + queueIndex + "]";
        if (queue.isPendingManifest() == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        queue.runningOomAdjusted = r1;
        boolean processWarm = queue.isProcessWarm();
        if (processWarm == false) goto L14;
        notifyStartedRunning(queue);
    L14:
        queue.makeActiveNextPending();
        if (processWarm == false) goto L17;
        queue.traceProcessRunningBegin();
        return;
    L17:
        queue.traceProcessStartingBegin();
        return;
    L5:
        if (queue.isPendingOrdered() == true) goto L10;
        if (queue.isPendingResultTo() == true) goto L10;
        r1 = false;
        goto L11
    }

    private void demoteFromRunningLocked(BroadcastProcessQueue queue) {
        if (queue.isActive() == true) goto L6;
        BroadcastQueue.logw("Ignoring demoteFromRunning; no active broadcast for " + queue);
        return;
    L6:
        int cookie = BroadcastQueue.traceBegin("demoteFromRunning");
        if (this.mRunningColdStart != queue) goto L9;
        Slog.wtf(BroadcastQueue.TAG, "mRunningColdStart has not been cleared; mRunningColdStart.app: " + this.mRunningColdStart.app + " , queue.app: " + queue.app, new IllegalStateException());
    L9:
        queue.makeActiveIdle();
        queue.traceProcessEnd();
        int queueIndex = getRunningIndexOf(queue);
        this.mRunning[queueIndex] = null;
        updateRunnableList(queue);
        enqueueUpdateRunningList();
        notifyStoppedRunning(queue);
        BroadcastQueue.traceEnd(cookie);
    }

    private void setDeliveryState(BroadcastProcessQueue queue, ProcessRecord app, BroadcastRecord r, int index, Object receiver, int newDeliveryState, String reason) {
        int cookie = BroadcastQueue.traceBegin("setDeliveryState");
        int oldDeliveryState = getDeliveryState(r, index);
        boolean beyondCountChanged = r.setDeliveryState(index, newDeliveryState, reason);
        if (queue == null) goto L12;
        if (newDeliveryState != 4) goto L7;
        queue.traceActiveBegin();
        goto L12
    L7:
        if (oldDeliveryState != 4) goto L12;
        if (BroadcastRecord.isDeliveryStateTerminal(newDeliveryState) == false) goto L12;
        queue.traceActiveEnd();
    L12:
        if (BroadcastRecord.isDeliveryStateTerminal(oldDeliveryState) == true) goto L27;
        if (BroadcastRecord.isDeliveryStateTerminal(newDeliveryState) == false) goto L27;
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L19;
        if (newDeliveryState == 1) goto L19;
    L20:
        String msg = "Delivery state of " + r + " to " + receiver + " via " + app + " changed from " + BroadcastRecord.deliveryStateToString(oldDeliveryState) + " to " + BroadcastRecord.deliveryStateToString(newDeliveryState) + " because " + reason;
        if (newDeliveryState != 1) goto L23;
        BroadcastQueue.logv(msg);
    L24:
        notifyFinishReceiver(queue, app, r, index, receiver);
        goto L27
    L23:
        BroadcastQueue.logw(msg);
    L19:
        if (r.debugLog() == false) goto L24;
    L27:
        if (beyondCountChanged == true) goto L29;
    L46:
        BroadcastQueue.traceEnd(cookie);
        return;
    L29:
        if (r.beyondCount != r.receivers.size()) goto L32;
        scheduleResultTo(r);
    L32:
        if (r.ordered == false) goto L34;
    L35:
        int i = 0;
    L37:
        if (i >= r.receivers.size()) goto L45;
        if (BroadcastRecord.isDeliveryStateTerminal(getDeliveryState(r, i)) == false) goto L41;
        if (i == index) goto L41;
    L44:
        i = i + 1;
    L41:
        Object otherReceiver = r.receivers.get(i);
        BroadcastProcessQueue otherQueue = getProcessQueue(BroadcastRecord.getReceiverProcessName(otherReceiver), BroadcastRecord.getReceiverUid(otherReceiver));
        if (otherQueue == null) goto L44;
        otherQueue.invalidateRunnableAt();
        updateRunnableList(otherQueue);
        goto L44
    L45:
        enqueueUpdateRunningList();
        goto L46
    L34:
        if (r.prioritized == false) goto L46;
        goto L35
    }

    private int getDeliveryState(BroadcastRecord r, int index) {
        return r.getDeliveryState(index);
    }

    @Override // com.android.server.am.BroadcastQueue
    public boolean cleanupDisabledPackageReceiversLocked(final String packageName, final Set<String> filterByClasses, final int userId) {
        if (packageName == null) goto L8;
        final int uid = this.mService.mPackageManagerInt.getPackageUid(packageName, 8192, userId);
        Predicate<BroadcastProcessQueue> queuePredicate = new BroadcastQueueImpl$$ExternalSyntheticLambda7(uid);
        if (filterByClasses == null) goto L6;
        BroadcastProcessQueue.BroadcastPredicate broadcastPredicate = new BroadcastQueueImpl$$ExternalSyntheticLambda8(packageName, filterByClasses);
    L10:
        return forEachMatchingBroadcast(queuePredicate, broadcastPredicate, this.mBroadcastConsumerSkip, true);
    L6:
        broadcastPredicate = new BroadcastQueueImpl$$ExternalSyntheticLambda9(packageName);
        goto L10
    L8:
        queuePredicate = new BroadcastQueueImpl$$ExternalSyntheticLambda10(userId);
        broadcastPredicate = BROADCAST_PREDICATE_ANY;
        cleanupUserStateLocked(this.mUidForeground, userId);
        goto L10
    }

    private static /* synthetic */ boolean lambda$cleanupDisabledPackageReceiversLocked$8(int uid, BroadcastProcessQueue q) {
        if (q.uid != uid) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$cleanupDisabledPackageReceiversLocked$9(String packageName, Set filterByClasses, BroadcastRecord r, int i) {
        Object receiver = r.receivers.get(i);
        if ((receiver instanceof ResolveInfo) == false) goto L11;
        ActivityInfo info = ((ResolveInfo) receiver).activityInfo;
        if (packageName.equals(info.packageName) == true) goto L7;
        return false;
    L7:
        if (filterByClasses.contains(info.name) == false) goto L13;
        return true;
    L13:
        return false;
    L11:
        return false;
    }

    private static /* synthetic */ boolean lambda$cleanupDisabledPackageReceiversLocked$10(String packageName, BroadcastRecord r, int i) {
        Object receiver = r.receivers.get(i);
        return packageName.equals(BroadcastRecord.getReceiverPackageName(receiver));
    }

    private static /* synthetic */ boolean lambda$cleanupDisabledPackageReceiversLocked$11(int userId, BroadcastProcessQueue q) {
        if (UserHandle.getUserId(q.uid) != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private void cleanupUserStateLocked(SparseBooleanArray uidState, int userId) {
        int i = uidState.size() - 1;
    L3:
        if (i < 0) goto L9;
        int uid = uidState.keyAt(i);
        if (UserHandle.getUserId(uid) != userId) goto L7;
        uidState.removeAt(i);
    L7:
        i = i - 1;
        goto L3
    }

    private static /* synthetic */ boolean lambda$static$12(BroadcastProcessQueue q) {
        return true;
    }

    private static /* synthetic */ boolean lambda$static$13(BroadcastRecord r, int i) {
        return true;
    }

    private /* synthetic */ void lambda$new$14(BroadcastRecord r, int i) {
        setDeliveryState(null, null, r, i, r.receivers.get(i), 2, "mBroadcastConsumerSkip");
    }

    private /* synthetic */ void lambda$new$15(BroadcastRecord r, int i) {
        setDeliveryState(null, null, r, i, r.receivers.get(i), 2, "mBroadcastConsumerSkipAndCanceled");
        r.resultCode = 0;
        r.resultData = null;
        r.resultExtras = null;
    }

    private /* synthetic */ void lambda$new$16(BroadcastRecord r, int i) {
        setDeliveryState(null, null, r, i, r.receivers.get(i), 6, "mBroadcastConsumerDeferApply");
    }

    private /* synthetic */ void lambda$new$17(BroadcastRecord r, int i) {
        setDeliveryState(null, null, r, i, r.receivers.get(i), 0, "mBroadcastConsumerDeferClear");
    }

    private boolean testAllProcessQueues(Predicate<BroadcastProcessQueue> test, String label, PrintWriter pw) {
        int i = 0;
    L4:
        if (i >= this.mProcessQueues.size()) goto L16;
        BroadcastProcessQueue leaf = this.mProcessQueues.valueAt(i);
    L6:
        if (leaf == null) goto L15;
        if (test.test(leaf) == false) goto L9;
        leaf = leaf.processNameNext;
        goto L6
    L9:
        long now = SystemClock.uptimeMillis();
        if (now <= (this.mLastTestFailureTime + 1000)) goto L21;
        this.mLastTestFailureTime = now;
        pw.println("Test " + label + " failed due to " + leaf.toShortString() + " " + leaf.describeStateLocked());
        pw.flush();
        return false;
    L21:
        return false;
    L15:
        i = i + 1;
        goto L4
    L16:
        pw.println("Test " + label + " passed");
        pw.flush();
        return true;
    }

    private boolean forEachMatchingBroadcast(Predicate<BroadcastProcessQueue> queuePredicate, BroadcastProcessQueue.BroadcastPredicate broadcastPredicate, BroadcastProcessQueue.BroadcastConsumer broadcastConsumer, boolean andRemove) {
        boolean didSomething = false;
        int i = this.mProcessQueues.size() - 1;
    L3:
        if (i < 0) goto L14;
        BroadcastProcessQueue leaf = this.mProcessQueues.valueAt(i);
    L5:
        if (leaf == null) goto L12;
        if (queuePredicate.test(leaf) == false) goto L11;
        if (leaf.forEachMatchingBroadcast(broadcastPredicate, broadcastConsumer, andRemove) == false) goto L11;
        updateRunnableList(leaf);
        didSomething = true;
    L11:
        leaf = leaf.processNameNext;
        goto L5
    L12:
        i = i - 1;
        goto L3
    L14:
        if (didSomething == false) goto L16;
        enqueueUpdateRunningList();
    L16:
        return didSomething;
    }

    private boolean forEachMatchingQueue(Predicate<BroadcastProcessQueue> queuePredicate, Consumer<BroadcastProcessQueue> queueConsumer) {
        boolean didSomething = false;
        int i = this.mProcessQueues.size() - 1;
    L3:
        if (i < 0) goto L12;
        BroadcastProcessQueue leaf = this.mProcessQueues.valueAt(i);
    L5:
        if (leaf == null) goto L10;
        if (queuePredicate.test(leaf) == false) goto L9;
        queueConsumer.accept(leaf);
        updateRunnableList(leaf);
        didSomething = true;
    L9:
        leaf = leaf.processNameNext;
        goto L5
    L10:
        i = i - 1;
        goto L3
    L12:
        if (didSomething == false) goto L14;
        enqueueUpdateRunningList();
    L14:
        return didSomething;
    }

    @Override // com.android.server.am.BroadcastQueue
    public void start(ContentResolver resolver) {
        this.mFgConstants.startObserving(this.mHandler, resolver);
        this.mBgConstants.startObserving(this.mHandler, resolver);
        this.mService.registerUidObserver(new AnonymousClass1(this), 1, 2, PackageManagerService.PLATFORM_PACKAGE_NAME);
        this.mLocalHandler.sendEmptyMessage(4);
    }

    @Override // com.android.server.am.BroadcastQueue
    public boolean isIdleLocked() {
        return isIdleLocked(ActivityManagerDebugConfig.LOG_WRITER_INFO);
    }

    private static /* synthetic */ boolean lambda$isIdleLocked$18(BroadcastProcessQueue q) {
        return q.isIdle();
    }

    public boolean isIdleLocked(PrintWriter pw) {
        return testAllProcessQueues(new BroadcastQueueImpl$$ExternalSyntheticLambda23(), "idle", pw);
    }

    @Override // com.android.server.am.BroadcastQueue
    public boolean isBeyondBarrierLocked(long barrierTime) {
        return isBeyondBarrierLocked(barrierTime, ActivityManagerDebugConfig.LOG_WRITER_INFO);
    }

    private static /* synthetic */ boolean lambda$isBeyondBarrierLocked$19(long barrierTime, BroadcastProcessQueue q) {
        return q.isBeyondBarrierLocked(barrierTime);
    }

    public boolean isBeyondBarrierLocked(final long barrierTime, PrintWriter pw) {
        return testAllProcessQueues(new BroadcastQueueImpl$$ExternalSyntheticLambda6(barrierTime), "barrier", pw);
    }

    @Override // com.android.server.am.BroadcastQueue
    public boolean isDispatchedLocked(Intent intent) {
        return isDispatchedLocked(intent, ActivityManagerDebugConfig.LOG_WRITER_INFO);
    }

    private static /* synthetic */ boolean lambda$isDispatchedLocked$20(Intent intent, BroadcastProcessQueue q) {
        return q.isDispatched(intent);
    }

    public boolean isDispatchedLocked(final Intent intent, PrintWriter pw) {
        return testAllProcessQueues(new BroadcastQueueImpl$$ExternalSyntheticLambda14(intent), "dispatch of " + intent, pw);
    }

    private /* synthetic */ boolean lambda$waitForIdle$21(PrintWriter pw) {
        return isIdleLocked(pw);
    }

    @Override // com.android.server.am.BroadcastQueue
    public void waitForIdle(final PrintWriter pw) {
        waitFor(new BroadcastQueueImpl$$ExternalSyntheticLambda15(this, pw));
    }

    @Override // com.android.server.am.BroadcastQueue
    public void waitForBarrier(final PrintWriter pw) {
        final long now = SystemClock.uptimeMillis();
        ActivityManagerService r2 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        forEachMatchingQueue(QUEUE_PREDICATE_ANY, new BroadcastQueueImpl$$ExternalSyntheticLambda11());     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        ActivityManagerService.resetPriorityAfterLockedSection();
        waitFor(new BroadcastQueueImpl$$ExternalSyntheticLambda12(this, now, pw));     // Catch: Throwable -> L18
        ActivityManagerService r3 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        forEachMatchingQueue(QUEUE_PREDICATE_ANY, new BroadcastQueueImpl$$ExternalSyntheticLambda13());     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L18:
        th = move-exception;
        ActivityManagerService r4 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        forEachMatchingQueue(QUEUE_PREDICATE_ANY, new BroadcastQueueImpl$$ExternalSyntheticLambda13());     // Catch: Throwable -> L25
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L25:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L29:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$waitForBarrier$22(BroadcastProcessQueue q) {
        q.addPrioritizeEarliestRequest();
    }

    private /* synthetic */ boolean lambda$waitForBarrier$23(long now, PrintWriter pw) {
        return isBeyondBarrierLocked(now, pw);
    }

    private static /* synthetic */ void lambda$waitForBarrier$24(BroadcastProcessQueue q) {
        q.removePrioritizeEarliestRequest();
    }

    private /* synthetic */ boolean lambda$waitForDispatched$25(Intent intent, PrintWriter pw) {
        return isDispatchedLocked(intent, pw);
    }

    @Override // com.android.server.am.BroadcastQueue
    public void waitForDispatched(final Intent intent, final PrintWriter pw) {
        waitFor(new BroadcastQueueImpl$$ExternalSyntheticLambda5(this, intent, pw));
    }

    private void waitFor(BooleanSupplier condition) {
        CountDownLatch latch = new CountDownLatch(1);
        ActivityManagerService r1 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mWaitingFor.add(Pair.create(condition, latch));     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        ActivityManagerService.resetPriorityAfterLockedSection();
        enqueueUpdateRunningList();
        latch.await();     // Catch: InterruptedException -> L9
        return;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L12:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void checkAndRemoveWaitingFor() {
        if (this.mWaitingFor.isEmpty() == true) goto L6;
        this.mWaitingFor.removeIf(new BroadcastQueueImpl$$ExternalSyntheticLambda18());
        return;
    }

    private static /* synthetic */ boolean lambda$checkAndRemoveWaitingFor$26(Pair pair) {
        if (((BooleanSupplier) pair.first).getAsBoolean() == false) goto L6;
        ((CountDownLatch) pair.second).countDown();
        return true;
    L6:
        return false;
    }

    @Override // com.android.server.am.BroadcastQueue
    public void forceDelayBroadcastDelivery(final String targetPackage, final long delayedDurationMs) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        forEachMatchingQueue(new BroadcastQueueImpl$$ExternalSyntheticLambda16(targetPackage), new BroadcastQueueImpl$$ExternalSyntheticLambda17(delayedDurationMs));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ boolean lambda$forceDelayBroadcastDelivery$27(String targetPackage, BroadcastProcessQueue q) {
        return targetPackage.equals(q.getPackageName());
    }

    private static /* synthetic */ void lambda$forceDelayBroadcastDelivery$28(long delayedDurationMs, BroadcastProcessQueue q) {
        q.forceDelayBroadcastDelivery(delayedDurationMs);
    }

    @Override // com.android.server.am.BroadcastQueue
    public String describeStateLocked() {
        return getRunningSize() + " running";
    }

    private void checkHealth() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        checkHealthLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void checkHealthLocked() {
        assertHealthLocked();     // Catch: Exception -> L4
        this.mLocalHandler.sendEmptyMessageDelayed(4, 60000);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.wtf(BroadcastQueue.TAG, e);
        dumpToDropBoxLocked(e.toString());
    }

    void assertHealthLocked() {
        BroadcastProcessQueue prev = null;
        BroadcastProcessQueue next = this.mRunnableHead;
    L3:
        boolean r2 = false;
        boolean r3 = true;
        if (next == null) goto L16;
        if (next.runnableAtPrev != prev) goto L8;
        boolean r4 = true;
    L9:
        BroadcastQueue.checkState(r4, "runnableAtPrev");
        BroadcastQueue.checkState(next.isRunnable(), "isRunnable " + next);
        if (prev == null) goto L15;
        if (next.getRunnableAt() < prev.getRunnableAt()) goto L14;
        r2 = true;
    L14:
        BroadcastQueue.checkState(r2, "getRunnableAt " + next + " vs " + prev);
    L15:
        prev = next;
        next = next.runnableAtNext;
        goto L3
    L8:
        r4 = false;
        goto L9
    L16:
        BroadcastProcessQueue[] r5 = this.mRunning;
        int r6 = r5.length;
        int r7 = 0;
    L17:
        if (r7 >= r6) goto L23;
        BroadcastProcessQueue queue = r5[r7];
        if (queue == null) goto L21;
        BroadcastQueue.checkState(queue.isActive(), "isActive " + queue);
    L21:
        r7 = r7 + 1;
        goto L17
    L23:
        if (this.mRunningColdStart != null) goto L25;
    L43:
        int i = 0;
    L45:
        if (i >= this.mProcessQueues.size()) goto L51;
        BroadcastProcessQueue leaf = this.mProcessQueues.valueAt(i);
    L47:
        if (leaf == null) goto L49;
        leaf.assertHealthLocked();
        leaf = leaf.processNameNext;
        goto L47
    L49:
        i = i + 1;
        goto L45
    L51:
        return;
    L25:
        if (getRunningIndexOf(this.mRunningColdStart) < 0) goto L27;
        boolean r8 = true;
    L28:
        BroadcastQueue.checkState(r8, "isOrphaned " + this.mRunningColdStart);
        BroadcastProcessQueue queue2 = getProcessQueue(this.mRunningColdStart.processName, this.mRunningColdStart.uid);
        if (queue2 != this.mRunningColdStart) goto L31;
        boolean r9 = true;
    L32:
        BroadcastQueue.checkState(r9, "Conflicting " + this.mRunningColdStart + " with queue " + queue2 + ";\n mRunningColdStart.app: " + this.mRunningColdStart.app.toDetailedString() + ";\n queue.app: " + queue2.app.toDetailedString());
        if (this.mRunningColdStart.app != null) goto L36;
        r3 = false;
    L36:
        BroadcastQueue.checkState(r3, "Empty cold start queue " + this.mRunningColdStart);
        if (this.mRunningColdStart.isProcessStartInitiationTimeoutExpected() == false) goto L43;
        StringBuilder sb = new StringBuilder();
        sb.append("Process start timeout expected for app ");
        sb.append(this.mRunningColdStart.app);
        sb.append(" in queue ");
        sb.append(this.mRunningColdStart);
        sb.append("; startUpTime: ");
        long startupTimeMs = this.mRunningColdStart.getProcessStartInitiatedTimestampMillis();
        if (startupTimeMs != 0) goto L41;
        String r10 = "<none>";
    L42:
        sb.append(r10);
        sb.append(";\n app: ");
        sb.append(this.mRunningColdStart.app.toDetailedString());
        BroadcastQueue.checkState(false, sb.toString());
        goto L43
    L41:
        r10 = TimeUtils.formatDuration(startupTimeMs - SystemClock.uptimeMillis());
        goto L42
    L31:
        r9 = false;
        goto L32
    L27:
        r8 = false;
        goto L28
    }

    private void updateWarmProcess(BroadcastProcessQueue queue) {
        if (queue.isProcessWarm() == true) goto L6;
        ProcessRecord app = this.mService.getProcessRecordLocked(queue.processName, queue.uid);
        queue.setProcessAndUidState(app, this.mUidForeground.get(queue.uid, false), isProcessFreezable(app));
        return;
    }

    private void setQueueProcess(BroadcastProcessQueue queue, ProcessRecord app) {
        if (queue.setProcessAndUidState(app, this.mUidForeground.get(queue.uid, false), isProcessFreezable(app)) == false) goto L6;
        updateRunnableList(queue);
        return;
    }

    boolean isProcessFreezable(ProcessRecord app) {
        boolean r0 = false;
        if (app != null) goto L5;
        return false;
    L5:
        boolean hasProxy = SysOptBridge.getFactory().getBroadcastProxy().processUseProxy(app.processName, app.uid);
        if (hasProxy == false) goto L8;
        return true;
    L8:
        ActivityManagerGlobalLock r3 = this.mService.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r3);
    L15:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L11:
        if (app.mOptRecord.isPendingFreeze() == true) goto L17;
        if (app.mOptRecord.isFrozen() == true) goto L17;
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L15
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return r0;
    L17:
        r0 = true;
        goto L18
    }

    private void refreshProcessQueuesLocked(int uid) {
        BroadcastProcessQueue leaf = this.mProcessQueues.get(uid);
    L3:
        if (leaf == null) goto L5;
        setQueueProcess(leaf, leaf.app);
        leaf = leaf.processNameNext;
        goto L3
    L5:
        enqueueUpdateRunningList();
    }

    private void handleProcessFreezableChanged(ProcessRecord app) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        BroadcastProcessQueue queue = getProcessQueue(app.processName, app.uid);     // Catch: Throwable -> L14
        if (queue == null) goto L20;
        if (queue.app == null) goto L20;
        if (queue.app.getPid() != app.getPid()) goto L20;
        if (isProcessFreezable(app) == true) goto L16;
        queue.enqueueOutgoingBroadcasts(this.mBroadcastRecordConsumerEnqueue);     // Catch: Throwable -> L14
    L16:
        refreshProcessQueueLocked(queue);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L14
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void refreshProcessQueueLocked(BroadcastProcessQueue queue) {
        setQueueProcess(queue, queue.app);
        enqueueUpdateRunningList();
    }

    private void notifyStartedRunning(BroadcastProcessQueue queue) {
        if (queue.app == null) goto L11;
        queue.incrementCurAppReceivers();
        if (this.mService.mInternal.getRestrictionLevel(queue.uid) >= 40) goto L7;
        this.mService.updateLruProcessLocked(queue.app, false, null);
    L7:
        this.mService.mOomAdjuster.unfreezeTemporarily(queue.app, 3);
        if (queue.runningOomAdjusted == false) goto L12;
        queue.app.mState.forceProcessStateUpTo(11);
        this.mService.enqueueOomAdjTargetLocked(queue.app);
        return;
    L12:
        return;
    }

    private void notifyStoppedRunning(BroadcastProcessQueue queue) {
        if (queue.app == null) goto L8;
        queue.decrementCurAppReceivers();
        if (queue.runningOomAdjusted == false) goto L9;
        this.mService.enqueueOomAdjTargetLocked(queue.app);
        return;
    L9:
        return;
    }

    private void notifyScheduleRegisteredReceiver(ProcessRecord app, BroadcastRecord r, BroadcastFilter receiver) {
        reportUsageStatsBroadcastDispatched(app, r);
    }

    private void notifyScheduleReceiver(ProcessRecord app, BroadcastRecord r, ResolveInfo receiver) {
        reportUsageStatsBroadcastDispatched(app, r);
        String receiverPackageName = receiver.activityInfo.packageName;
        app.addPackage(receiverPackageName, receiver.activityInfo.applicationInfo.longVersionCode, this.mService.mProcessStats);
        if (r.intent.getComponent() == null) goto L5;
        boolean targetedBroadcast = true;
    L6:
        boolean targetedSelf = Objects.equals(r.callerPackage, receiverPackageName);
        if (targetedBroadcast == false) goto L13;
        if (targetedSelf == true) goto L13;
        if (r.userId != (-1)) goto L12;
        this.mService.mUsageStatsService.reportEventForAllUsers(receiverPackageName, 31);
        goto L13
    L12:
        this.mService.mUsageStatsService.reportEvent(receiverPackageName, r.userId, 31);
    L13:
        this.mService.notifyPackageUse(receiverPackageName, 3);
        this.mService.mPackageManagerInt.notifyComponentUsed(receiverPackageName, r.userId, r.callerPackage, r.toString());
        return;
    L5:
        targetedBroadcast = false;
        goto L6
    }

    private void reportUsageStatsBroadcastDispatched(ProcessRecord app, BroadcastRecord r) {
        if (r.options == null) goto L5;
        long r5 = r.options.getIdForResponseEvent();
    L6:
        long idForResponseEvent = r5;
        if (idForResponseEvent > 0) goto L10;
        return;
    L10:
        if (r.intent.getPackage() == null) goto L13;
        String targetPackage = r.intent.getPackage();
    L16:
        if (targetPackage != null) goto L18;
        return;
    L18:
        this.mService.mUsageStatsService.reportBroadcastDispatched(r.callingUid, targetPackage, UserHandle.of(r.userId), idForResponseEvent, SystemClock.elapsedRealtime(), this.mService.getUidStateLocked(app.uid));
        return;
    L13:
        if (r.intent.getComponent() == null) goto L15;
        targetPackage = r.intent.getComponent().getPackageName();
        goto L16
    L15:
        targetPackage = null;
        goto L16
    L5:
        r5 = 0;
        goto L6
    }

    private void notifyFinishReceiver(BroadcastProcessQueue queue, ProcessRecord app, BroadcastRecord r, int index, Object receiver) {
        if (r.wasDeliveryAttempted(index) == false) goto L7;
        logBroadcastDeliveryEventReported(queue, app, r, index, receiver);
    L7:
        if (r.isAssumedDelivered(index) == true) goto L12;
        if (r.wasDelivered(index) == false) goto L12;
        r.updateBroadcastProcessedEventRecord(receiver, r.terminalTime[index] - r.scheduledTime[index]);
    L12:
        if (r.terminalCount != r.receivers.size()) goto L14;
        boolean recordFinished = true;
    L15:
        if (recordFinished == false) goto L18;
        notifyFinishBroadcast(r);
        return;
    L18:
        return;
    L14:
        recordFinished = false;
        goto L15
    }

    private void logBroadcastDeliveryEventReported(BroadcastProcessQueue queue, ProcessRecord app, BroadcastRecord r, int index, Object receiver) {
        int uid = BroadcastRecord.getReceiverUid(receiver);
        if (r.callingUid != (-1)) goto L6;
        int r3 = 1000;
    L5:
        int senderUid = r3;
        String actionName = r.intent.getAction();
        if ((receiver instanceof BroadcastFilter) == false) goto L10;
        int receiverType = 1;
    L12:
        if (queue != null) goto L15;
        int type = 0;
        int receiverProcessState = -1;
    L18:
        long dispatchDelay = r.scheduledTime[index] - r.enqueueTime;
        long finishDelay = r.terminalTime[index] - r.scheduledTime[index];
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L25;
        StringBuilder r15 = new StringBuilder();
        r15.append("Logging broadcast for ");
        if (app == null) goto L23;
        String r8 = app.info.packageName;
    L24:
        r15.append(r8);
        r15.append(", stopped=");
        r15.append(queue.getActiveWasStopped());
        r15.append(", firstLaunch=");
        r15.append(queue.getActiveFirstLaunch());
        Slog.d(BroadcastQueue.TAG, r15.toString());
        goto L25
    L23:
        r8 = "<null>";
    L25:
        if (queue == null) goto L37;
        if (queue.getActiveWasStopped() == false) goto L29;
        int packageState = 2;
    L31:
        if (app == null) goto L34;
        String r9 = app.info.packageName;
    L33:
        String r16 = r9;
        FrameworkStatsLog.write(FrameworkStatsLog.BROADCAST_DELIVERY_EVENT_REPORTED, uid, senderUid, actionName, receiverType, type, dispatchDelay, 0, finishDelay, packageState, r16, r.callerPackage, r.calculateTypeForLogging(), r.getDeliveryGroupPolicy(), r.intent.getFlags(), BroadcastRecord.getReceiverPriority(receiver), r.callerProcState, receiverProcessState, queue.getActiveFirstLaunch(), 0);
        queue.setActiveFirstLaunch(false);
        queue.setActiveWasStopped(false);
        return;
    L34:
        r9 = null;
        goto L33
    L29:
        packageState = 1;
        goto L31
    L37:
        return;
    L15:
        if (queue.getActiveViaColdStart() == false) goto L17;
        type = 3;
        receiverProcessState = 20;
        goto L18
    L17:
        type = 1;
        receiverProcessState = queue.lastProcessState;
        goto L18
    L10:
        receiverType = 2;
        goto L12
    L6:
        r3 = r.callingUid;
        goto L5
    }

    private void notifyFinishBroadcast(BroadcastRecord r) {
        this.mService.notifyBroadcastFinishedLocked(r);
        r.finishTime = SystemClock.uptimeMillis();
        r.nextReceiver = r.receivers.size();
        this.mHistory.onBroadcastFinishedLocked(r);
        logBootCompletedBroadcastCompletionLatencyIfPossible(r);
        r.logBroadcastProcessedEventRecord();
        if (r.intent.getComponent() == null) goto L5;
        return;
    L5:
        if (r.intent.getPackage() == null) goto L7;
        return;
    L7:
        if ((r.intent.getFlags() & 1073741824) != 0) goto L25;
        int i = 0;
        int manifestCount = 0;
        int manifestSkipCount = 0;
    L10:
        if (i >= r.receivers.size()) goto L17;
        if ((r.receivers.get(i) instanceof ResolveInfo) == false) goto L16;
        manifestCount = manifestCount + 1;
        if (r.delivery[i] != 2) goto L16;
        manifestSkipCount = manifestSkipCount + 1;
    L16:
        i = i + 1;
        goto L10
    L17:
        long dispatchTime = SystemClock.uptimeMillis() - r.enqueueTime;
        this.mService.addBroadcastStatLocked(r.intent.getAction(), r.callerPackage, manifestCount, manifestSkipCount, dispatchTime);
        return;
    }

    BroadcastProcessQueue getOrCreateProcessQueue(ProcessRecord app) {
        return getOrCreateProcessQueue(app.processName, app.info.uid);
    }

    BroadcastProcessQueue getOrCreateProcessQueue(String processName, int uid) {
        BroadcastProcessQueue leaf = this.mProcessQueues.get(uid);
    L3:
        if (leaf == null) goto L11;
        if (Objects.equals(leaf.processName, processName) == true) goto L6;
        if (leaf.processNameNext == null) goto L11;
        leaf = leaf.processNameNext;
        goto L3
    L6:
        return leaf;
    L11:
        BroadcastProcessQueue created = new BroadcastProcessQueue(this.mConstants, processName, uid);
        ProcessRecord app = this.mService.getProcessRecordLocked(processName, uid);
        if (app != null) goto L14;
        app = SysOptBridge.getFactory().getApplicationFreezer().get(processName, uid);
    L14:
        setQueueProcess(created, app);
        if (leaf != null) goto L17;
        this.mProcessQueues.put(uid, created);
    L18:
        return created;
    L17:
        leaf.processNameNext = created;
        goto L18
    }

    BroadcastProcessQueue getProcessQueue(ProcessRecord app) {
        return getProcessQueue(app.processName, app.info.uid);
    }

    BroadcastProcessQueue getProcessQueue(String processName, int uid) {
        BroadcastProcessQueue leaf = this.mProcessQueues.get(uid);
    L3:
        if (leaf == null) goto L8;
        if (Objects.equals(leaf.processName, processName) == true) goto L6;
        leaf = leaf.processNameNext;
        goto L3
    L6:
        return leaf;
    L8:
        return null;
    }

    BroadcastProcessQueue removeProcessQueue(String processName, int uid) {
        BroadcastProcessQueue prev = null;
        BroadcastProcessQueue leaf = this.mProcessQueues.get(uid);
    L3:
        if (leaf == null) goto L14;
        if (Objects.equals(leaf.processName, processName) == true) goto L6;
        prev = leaf;
        leaf = leaf.processNameNext;
        goto L3
    L6:
        if (prev == null) goto L9;
        prev.processNameNext = leaf.processNameNext;
    L12:
        return leaf;
    L9:
        if (leaf.processNameNext == null) goto L11;
        this.mProcessQueues.put(uid, leaf.processNameNext);
        goto L12
    L11:
        this.mProcessQueues.remove(uid);
        goto L12
    L14:
        return null;
    }

    private void logBootCompletedBroadcastCompletionLatencyIfPossible(BroadcastRecord r) {
        if (r.receivers == null) goto L5;
        int numReceivers = r.receivers.size();
    L7:
        if (r.nextReceiver >= numReceivers) goto L9;
        return;
    L9:
        String action = r.intent.getAction();
        if ("android.intent.action.LOCKED_BOOT_COMPLETED".equals(action) == false) goto L13;
        int event = 1;
    L16:
        if (event == 0) goto L30;
        int dispatchLatency = (int) (r.dispatchTime - r.enqueueTime);
        int completeLatency = (int) (SystemClock.uptimeMillis() - r.enqueueTime);
        int dispatchRealLatency = (int) (r.dispatchRealTime - r.enqueueRealTime);
        int completeRealLatency = (int) (SystemClock.elapsedRealtime() - r.enqueueRealTime);
        UserManagerInternal umInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        String r3 = null;
        if (umInternal == null) goto L20;
        UserInfo r9 = umInternal.getUserInfo(r.userId);
    L21:
        UserInfo userInfo = r9;
        if (userInfo == null) goto L24;
        int userType = UserJourneyLogger.getUserTypeForStatsd(userInfo.userType);
        int userType2 = userType;
    L25:
        StringBuilder r2 = new StringBuilder();
        r2.append("BOOT_COMPLETED_BROADCAST_COMPLETION_LATENCY_REPORTED action:");
        r2.append(action);
        r2.append(" dispatchLatency:");
        r2.append(dispatchLatency);
        r2.append(" completeLatency:");
        r2.append(completeLatency);
        r2.append(" dispatchRealLatency:");
        r2.append(dispatchRealLatency);
        r2.append(" completeRealLatency:");
        r2.append(completeRealLatency);
        r2.append(" receiversSize:");
        r2.append(numReceivers);
        r2.append(" userId:");
        r2.append(r.userId);
        r2.append(" userType:");
        if (userInfo == null) goto L28;
        r3 = userInfo.userType;
    L28:
        r2.append(r3);
        Slog.i(BroadcastQueue.TAG, r2.toString());
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_COMPLETED_BROADCAST_COMPLETION_LATENCY_REPORTED, event, dispatchLatency, completeLatency, dispatchRealLatency, completeRealLatency, r.userId, userType2);
        return;
    L24:
        userType2 = 0;
        goto L25
    L20:
        r9 = null;
        goto L21
    L30:
        return;
    L13:
        if ("android.intent.action.BOOT_COMPLETED".equals(action) == false) goto L15;
        event = 2;
        goto L16
    L15:
        event = 0;
        goto L16
    L5:
        numReceivers = 0;
        goto L7
    }

    @Override // com.android.server.am.BroadcastQueue
    @NeverCompile
    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        this.mHistory.dumpDebug(proto);
        proto.end(token);
    }

    @Override // com.android.server.am.BroadcastQueue
    @NeverCompile
    public boolean dumpLocked(FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpConstants, boolean dumpHistory, boolean dumpAll, String dumpPackage, String dumpIntentAction, boolean needSep) {
        long now = SystemClock.uptimeMillis();
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        ipw.increaseIndent();
        ipw.println();
        if (dumpIntentAction != null) goto L7;
        dumpProcessQueues(ipw, now);
        dumpBroadcastsWithIgnoredPolicies(ipw);
        dumpForegroundUids(ipw);
        if (dumpConstants == false) goto L7;
        this.mFgConstants.dump(ipw);
        this.mBgConstants.dump(ipw);
    L7:
        if (dumpHistory == false) goto L10;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        boolean needSep2 = this.mHistory.dumpLocked(ipw, dumpPackage, dumpIntentAction, sdf, dumpAll);
        return needSep2;
    L10:
        return needSep;
    }

    private void dumpProcessQueues(IndentingPrintWriter ipw, long now) {
        ipw.println("📋 Per-process queues:");
        ipw.increaseIndent();
        int i = 0;
    L4:
        if (i >= this.mProcessQueues.size()) goto L9;
        BroadcastProcessQueue leaf = this.mProcessQueues.valueAt(i);
    L6:
        if (leaf == null) goto L8;
        leaf.dumpLocked(now, ipw);
        leaf = leaf.processNameNext;
        goto L6
    L8:
        i = i + 1;
        goto L4
    L9:
        ipw.decreaseIndent();
        ipw.println();
        ipw.println("🧍 Runnable:");
        ipw.increaseIndent();
        if (this.mRunnableHead != null) goto L12;
        ipw.println("(none)");
    L15:
        ipw.decreaseIndent();
        ipw.println();
        ipw.println("🏃 Running:");
        ipw.increaseIndent();
        BroadcastProcessQueue[] r0 = this.mRunning;
        int r2 = r0.length;
        int r3 = 0;
    L16:
        if (r3 >= r2) goto L27;
        BroadcastProcessQueue queue = r0[r3];
        if (queue != null) goto L20;
    L22:
        ipw.print("\u3000 ");
    L23:
        if (queue == null) goto L25;
        ipw.println(queue.toShortString());
    L26:
        r3 = r3 + 1;
        goto L16
    L25:
        ipw.println("(none)");
        goto L26
    L20:
        if (queue != this.mRunningColdStart) goto L22;
        ipw.print("🥶 ");
        goto L23
    L27:
        ipw.decreaseIndent();
        ipw.println();
        return;
    L12:
        BroadcastProcessQueue queue2 = this.mRunnableHead;
    L13:
        if (queue2 == null) goto L15;
        TimeUtils.formatDuration(queue2.getRunnableAt(), now, ipw);
        ipw.print(' ');
        ipw.print(BroadcastProcessQueue.reasonToString(queue2.getRunnableAtReason()));
        ipw.print(' ');
        ipw.print(queue2.toShortString());
        ipw.println();
        queue2 = queue2.runnableAtNext;
        goto L13
    }

    private void dumpBroadcastsWithIgnoredPolicies(IndentingPrintWriter ipw) {
        ipw.println("Broadcasts with ignored delivery group policies:");
        ipw.increaseIndent();
        this.mService.dumpDeliveryGroupPolicyIgnoredActions(ipw);
        ipw.decreaseIndent();
        ipw.println();
    }

    private void dumpForegroundUids(IndentingPrintWriter ipw) {
        ipw.println("Foreground UIDs:");
        ipw.increaseIndent();
        ipw.println(this.mUidForeground);
        ipw.decreaseIndent();
        ipw.println();
    }
}
