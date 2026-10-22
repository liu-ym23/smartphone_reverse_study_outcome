package com.android.server.am;

import android.os.IBinder;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.ServiceThread;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes.dex */
public class OomAdjusterModernImpl extends OomAdjuster {
    static final int ADJ_SLOT_BACKUP_APP = 10;
    static final int ADJ_SLOT_CACHED_APP = 16;
    static final int ADJ_SLOT_FOREGROUND_APP = 4;
    static final int ADJ_SLOT_HEAVY_WEIGHT_APP = 11;
    static final int ADJ_SLOT_HOME_APP = 13;
    static final int ADJ_SLOT_INVALID = -1;
    static final int ADJ_SLOT_NATIVE = 0;
    static final int ADJ_SLOT_PERCEPTIBLE_APP = 7;
    static final int ADJ_SLOT_PERCEPTIBLE_LOW_APP = 9;
    static final int ADJ_SLOT_PERCEPTIBLE_MEDIUM_APP = 8;
    static final int ADJ_SLOT_PERCEPTIBLE_RECENT_FOREGROUND_APP = 5;
    static final int ADJ_SLOT_PERSISTENT_PROC = 2;
    static final int ADJ_SLOT_PERSISTENT_SERVICE = 3;
    static final int ADJ_SLOT_PREVIOUS_APP = 14;
    static final int ADJ_SLOT_SERVICE = 12;
    static final int ADJ_SLOT_SERVICE_B = 15;
    static final int ADJ_SLOT_SYSTEM = 1;
    static final int ADJ_SLOT_UNKNOWN = 17;
    static final int[] ADJ_SLOT_VALUES = null;
    static final int ADJ_SLOT_VISIBLE_APP = 6;
    static final int[] PROC_STATE_SLOTS = null;
    static final String TAG = "OomAdjusterModernImpl";
    private final ComputeConnectionIgnoringReachableClientsConsumer mComputeConnectionIgnoringReachableClientsConsumer;
    private final ComputeConnectionsConsumer mComputeConnectionsConsumer;
    private final ComputeHostConsumer mComputeHostConsumer;
    private final ProcessRecordNodes mProcessRecordAdjNodes;
    private final ProcessRecordNodes mProcessRecordProcStateNodes;
    private final ReachableCollectingConsumer mReachableCollectingConsumer;
    private final OomAdjusterArgs mTmpOomAdjusterArgs;

    @Retention(RetentionPolicy.SOURCE)
    @interface AdjSlot {
    }

    private class ComputeConnectionIgnoringReachableClientsConsumer implements BiConsumer<Connection, ProcessRecord> {
        public boolean hasReachableClient;
        private OomAdjusterArgs mArgs;
        final /* synthetic */ OomAdjusterModernImpl this$0;

        /* synthetic */ ComputeConnectionIgnoringReachableClientsConsumer(OomAdjusterModernImpl r1, OomAdjusterModernImplIA r2) {
            this(r1);
        }

        private ComputeConnectionIgnoringReachableClientsConsumer(OomAdjusterModernImpl r1) {
            this.this$0 = r1;
            this.mArgs = null;
            this.hasReachableClient = false;
        }

        @Override // java.util.function.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Connection r1, ProcessRecord r2) {
            accept2(r1, r2);
        }

        public void init(OomAdjusterArgs args) {
            this.mArgs = args;
            this.hasReachableClient = false;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Connection conn, ProcessRecord client) {
            ProcessRecord host = this.mArgs.mApp;
            ProcessRecord topApp = this.mArgs.mTopApp;
            long now = this.mArgs.mNow;
            int oomAdjReason = this.mArgs.mOomAdjReason;
            if (client.mState.isReachable() == false) goto L7;
            this.hasReachableClient = true;
            return;
        L7:
            if (OomAdjusterModernImpl.m1527$$Nest$smunimportantConnectionLSP(conn, host, client) == false) goto L9;
            return;
        L9:
            conn.computeHostOomAdjLSP(this.this$0, host, client, now, topApp, false, oomAdjReason, 1001);
        }
    }

    private class ComputeConnectionsConsumer implements Consumer<OomAdjusterArgs> {
        final /* synthetic */ OomAdjusterModernImpl this$0;

        /* synthetic */ ComputeConnectionsConsumer(OomAdjusterModernImpl r1, OomAdjusterModernImplIA r2) {
            this(r1);
        }

        private ComputeConnectionsConsumer(OomAdjusterModernImpl r1) {
            this.this$0 = r1;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(OomAdjusterArgs r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(OomAdjusterArgs args) {
            ProcessRecord app = args.mApp;
            ActiveUids uids = args.mUids;
            app.mState.setCompletedAdjSeq(this.this$0.mAdjSeq);
            if (uids == null) goto L7;
            UidRecord uidRec = app.getUidRecord();
            if (uidRec == null) goto L7;
            uids.put(uidRec.getUid(), uidRec);
        L7:
            OomAdjusterModernImpl.m1522$$Nest$fgetmComputeHostConsumer(this.this$0).args = args;
            OomAdjusterModernImpl.m1526$$Nest$smforEachConnectionLSP(app, OomAdjusterModernImpl.m1522$$Nest$fgetmComputeHostConsumer(this.this$0));
        }
    }

    private class ComputeHostConsumer implements BiConsumer<Connection, ProcessRecord> {
        public OomAdjusterArgs args;
        final /* synthetic */ OomAdjusterModernImpl this$0;

        /* synthetic */ ComputeHostConsumer(OomAdjusterModernImpl r1, OomAdjusterModernImplIA r2) {
            this(r1);
        }

        private ComputeHostConsumer(OomAdjusterModernImpl r1) {
            this.this$0 = r1;
            this.args = null;
        }

        @Override // java.util.function.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Connection r1, ProcessRecord r2) {
            accept2(r1, r2);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Connection conn, ProcessRecord host) {
            ProcessRecord client = this.args.mApp;
            int cachedAdj = this.args.mCachedAdj;
            ProcessRecord topApp = this.args.mTopApp;
            long now = this.args.mNow;
            int oomAdjReason = this.args.mOomAdjReason;
            boolean fullUpdate = this.args.mFullUpdate;
            int prevProcState = host.mState.getCurProcState();
            int prevAdj = host.mState.getCurRawAdj();
            if (OomAdjusterModernImpl.m1527$$Nest$smunimportantConnectionLSP(conn, host, client) == false) goto L5;
            return;
        L5:
            conn.computeHostOomAdjLSP(this.this$0, host, client, now, topApp, fullUpdate, oomAdjReason, cachedAdj);
            OomAdjusterModernImpl.m1525$$Nest$mupdateProcStateSlotIfNecessary(this.this$0, host, prevProcState);
            OomAdjusterModernImpl.m1524$$Nest$mupdateAdjSlotIfNecessary(this.this$0, host, prevAdj);
        }
    }

    public interface Connection {
        boolean canAffectCapabilities();

        void computeHostOomAdjLSP(OomAdjuster r1, ProcessRecord r2, ProcessRecord r3, long r4, ProcessRecord r6, boolean r7, int r8, int r9);

        default boolean transmitsCpuTime() {
            return true;
        }
    }

    private class OomAdjusterArgs {
        ProcessRecord mApp;
        int mCachedAdj;
        boolean mFullUpdate;
        long mNow;
        int mOomAdjReason;
        ProcessRecord mTopApp;
        ActiveUids mUids;

        /* synthetic */ OomAdjusterArgs(OomAdjusterModernImpl r1, OomAdjusterModernImplIA r2) {
            this(r1);
        }

        private OomAdjusterArgs(OomAdjusterModernImpl r1) {
        }

        void update(ProcessRecord topApp, long now, int cachedAdj, int oomAdjReason, ActiveUids uids, boolean fullUpdate) {
            this.mTopApp = topApp;
            this.mNow = now;
            this.mCachedAdj = cachedAdj;
            this.mOomAdjReason = oomAdjReason;
            this.mUids = uids;
            this.mFullUpdate = fullUpdate;
        }
    }

    static class ProcessRecordNode {
        static final int NODE_TYPE_ADJ = 1;
        static final int NODE_TYPE_PROC_STATE = 0;
        static final int NUM_NODE_TYPE = 2;
        final ProcessRecord mApp;
        ProcessRecordNode mNext;
        ProcessRecordNode mPrev;

        @Retention(RetentionPolicy.SOURCE)
        @interface NodeType {
        }

        ProcessRecordNode(ProcessRecord app) {
            this.mApp = app;
        }

        void unlink() {
            if (this.mPrev == null) goto L6;
            ProcessRecordNode r0 = this.mPrev;
            r0.mNext = this.mNext;
        L6:
            if (this.mNext == null) goto L8;
            ProcessRecordNode r1 = this.mNext;
            r1.mPrev = this.mPrev;
        L8:
            this.mNext = null;
            this.mPrev = null;
        }

        boolean isLinked() {
            if (this.mPrev != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mNext == null) goto L7;
            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ProcessRecordNode{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(' ');
            sb.append(this.mApp);
            sb.append(' ');
            if (this.mApp == null) goto L5;
            int r2 = this.mApp.mState.getCurProcState();
        L6:
            sb.append(r2);
            sb.append(' ');
            if (this.mApp == null) goto L9;
            int r3 = this.mApp.mState.getCurAdj();
        L10:
            sb.append(r3);
            sb.append(' ');
            sb.append(Integer.toHexString(System.identityHashCode(this.mPrev)));
            sb.append(' ');
            sb.append(Integer.toHexString(System.identityHashCode(this.mNext)));
            sb.append('}');
            return sb.toString();
        L9:
            r3 = 1001;
            goto L10
        L5:
            r2 = -1;
            goto L6
        }
    }

    private class ProcessRecordNodes {
        private int mFirstPopulatedSlot;
        private final ProcessRecordNode[] mLastNode;
        private final LinkedProcessRecordList[] mProcessRecordNodes;
        private final ToIntFunction<ProcessRecord> mSlotFunction;
        private final int mType;
        final /* synthetic */ OomAdjusterModernImpl this$0;

        private static class LinkedProcessRecordList {
            final ProcessRecordNode HEAD;
            final ProcessRecordNode TAIL;
            final ToIntFunction<ProcessRecord> mValueFunction;

            LinkedProcessRecordList(ToIntFunction<ProcessRecord> valueFunction) {
                this.HEAD = new ProcessRecordNode(null);
                this.TAIL = new ProcessRecordNode(null);
                ProcessRecordNode r0 = this.HEAD;
                r0.mNext = this.TAIL;
                ProcessRecordNode r1 = this.TAIL;
                r1.mPrev = this.HEAD;
                this.mValueFunction = valueFunction;
            }

            ProcessRecordNode poll() {
                ProcessRecordNode next = this.HEAD.mNext;
                if (next != this.TAIL) goto L6;
                return null;
            L6:
                next.unlink();
                return next;
            }

            void offer(ProcessRecordNode node) {
                int newValue = this.mValueFunction.applyAsInt(node.mApp);
                ProcessRecordNode curNode = this.TAIL.mPrev;
            L4:
                if (curNode == this.HEAD) goto L8;
                if (this.mValueFunction.applyAsInt(curNode.mApp) <= newValue) goto L8;
                curNode = curNode.mPrev;
            L8:
                node.mPrev = curNode;
                node.mNext = curNode.mNext;
                curNode.mNext.mPrev = node;
                curNode.mNext = node;
            }

            void append(ProcessRecordNode node) {
                node.mNext = this.TAIL;
                node.mPrev = this.TAIL.mPrev;
                this.TAIL.mPrev.mNext = node;
                this.TAIL.mPrev = node;
            }

            void moveTo(LinkedProcessRecordList toList) {
                if (this.HEAD.mNext == this.TAIL) goto L6;
                ProcessRecordNode r0 = toList.TAIL.mPrev;
                r0.mNext = this.HEAD.mNext;
                ProcessRecordNode r1 = this.HEAD.mNext;
                r1.mPrev = toList.TAIL.mPrev;
                ProcessRecordNode r2 = toList.TAIL;
                r2.mPrev = this.TAIL.mPrev;
                ProcessRecordNode r3 = this.TAIL.mPrev;
                r3.mNext = toList.TAIL;
                ProcessRecordNode r4 = this.HEAD;
                r4.mNext = this.TAIL;
                ProcessRecordNode r5 = this.TAIL;
                r5.mPrev = this.HEAD;
                return;
            }

            void moveNodeToTail(ProcessRecordNode node) {
                node.unlink();
                append(node);
            }

            ProcessRecordNode getLastNodeBeforeTail() {
                return this.TAIL.mPrev;
            }

            void reset() {
                if (this.HEAD.mNext == this.TAIL) goto L5;
                ProcessRecordNode r0 = this.HEAD.mNext;
                this.TAIL.mPrev.mNext = null;
                r0.mPrev = null;
            L5:
                ProcessRecordNode r1 = this.HEAD;
                r1.mNext = this.TAIL;
                ProcessRecordNode r2 = this.TAIL;
                r2.mPrev = this.HEAD;
            }

            String toString(int logUid) {
                StringBuilder sb = new StringBuilder();
                sb.append("LinkedProcessRecordList{");
                sb.append(this.HEAD);
                sb.append(' ');
                sb.append(this.TAIL);
                sb.append('[');
                ProcessRecordNode node = this.HEAD.mNext;
            L4:
                if (node == this.TAIL) goto L11;
                if (node.mApp == null) goto L10;
                if (node.mApp.uid != logUid) goto L10;
                sb.append(node);
                sb.append(',');
            L10:
                node = node.mNext;
                goto L4
            L11:
                sb.append(']');
                sb.append('}');
                return sb.toString();
            }
        }

        public static /* synthetic */ int $r8$lambda$1fW7yf2z7Pgv749DQUgfBRaf7aQ(ProcessRecord r0) {
            return lambda$new$3(r0);
        }

        public static /* synthetic */ int $r8$lambda$TZt9shA5uGR6y6KMomqwUImYth0(ProcessRecord r0) {
            return lambda$new$5(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$bQ88-2swpGH2IsZbscjy6IA3z44, reason: not valid java name */
        public static /* synthetic */ int m1528$r8$lambda$bQ882swpGH2IsZbscjy6IA3z44(ProcessRecord r0) {
            return lambda$new$4(r0);
        }

        public static /* synthetic */ int $r8$lambda$dVky852B00emlsqiXMSJCZhOi8g(ProcessRecord r0) {
            return lambda$new$1(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$f3jBBX76pazR-KkVwKD4h19bcRw, reason: not valid java name */
        public static /* synthetic */ int m1529$r8$lambda$f3jBBX76pazRKkVwKD4h19bcRw(ProcessRecord r0) {
            return lambda$new$0(r0);
        }

        public static /* synthetic */ int $r8$lambda$xRsLLgodHEUbn_iuIPZpAnHO0RE(ProcessRecord r0) {
            return lambda$new$2(r0);
        }

        ProcessRecordNodes(OomAdjusterModernImpl r4, int type, int size) {
            this.this$0 = r4;
            this.mFirstPopulatedSlot = 0;
            this.mType = type;
            switch(this.mType) {
                case 0: goto L6;
                case 1: goto L5;
                default: goto L4;
            };
        L4:
            ToIntFunction<ProcessRecord> valueFunction = new OomAdjusterModernImpl$ProcessRecordNodes$$ExternalSyntheticLambda4();
            this.mSlotFunction = new OomAdjusterModernImpl$ProcessRecordNodes$$ExternalSyntheticLambda5();
        L7:
            this.mProcessRecordNodes = new LinkedProcessRecordList[size];
            int i = 0;
        L8:
            if (i >= size) goto L10;
            this.mProcessRecordNodes[i] = new LinkedProcessRecordList(valueFunction);
            i = i + 1;
            goto L8
        L10:
            this.mLastNode = new ProcessRecordNode[size];
            resetLastNodes();
            return;
        L5:
            valueFunction = new OomAdjusterModernImpl$ProcessRecordNodes$$ExternalSyntheticLambda2();
            this.mSlotFunction = new OomAdjusterModernImpl$ProcessRecordNodes$$ExternalSyntheticLambda3();
            goto L7
        L6:
            valueFunction = new OomAdjusterModernImpl$ProcessRecordNodes$$ExternalSyntheticLambda0();
            this.mSlotFunction = new OomAdjusterModernImpl$ProcessRecordNodes$$ExternalSyntheticLambda1();
            goto L7
        }

        private static /* synthetic */ int lambda$new$0(ProcessRecord proc) {
            return proc.mState.getCurProcState();
        }

        private static /* synthetic */ int lambda$new$1(ProcessRecord proc) {
            return OomAdjusterModernImpl.processStateToSlot(proc.mState.getCurProcState());
        }

        private static /* synthetic */ int lambda$new$2(ProcessRecord proc) {
            return proc.mState.getCurRawAdj();
        }

        private static /* synthetic */ int lambda$new$3(ProcessRecord proc) {
            return OomAdjusterModernImpl.adjToSlot(proc.mState.getCurRawAdj());
        }

        private static /* synthetic */ int lambda$new$4(ProcessRecord proc) {
            return 0;
        }

        private static /* synthetic */ int lambda$new$5(ProcessRecord proc) {
            return 0;
        }

        int size() {
            return this.mProcessRecordNodes.length;
        }

        void reset() {
            int i = 0;
        L4:
            if (i >= this.mProcessRecordNodes.length) goto L7;
            this.mProcessRecordNodes[i].reset();
            setLastNodeToHead(i);
            i = i + 1;
            goto L4
        }

        void resetLastNodes() {
            reset();
        }

        void setLastNodeToHead(int slot) {
            this.mLastNode[slot] = this.mProcessRecordNodes[slot].HEAD;
        }

        void forEachNewNode(int slot, Consumer<OomAdjusterArgs> callback) {
            ProcessRecordNode node = this.mLastNode[slot].mNext;
            ProcessRecordNode tail = this.mProcessRecordNodes[slot].TAIL;
        L3:
            if (node == null) goto L28;
            if (node == tail) goto L33;
            OomAdjusterArgs r2 = OomAdjusterModernImpl.m1523$$Nest$fgetmTmpOomAdjusterArgs(this.this$0);
            r2.mApp = node.mApp;
            if (node.mApp != null) goto L17;
            StringBuilder sb = new StringBuilder();
            sb.append("Iterating null process during OomAdjuster traversal!!!\n");
            sb.append("Type:");
            switch(this.mType) {
                case 0: goto L11;
                case 1: goto L10;
                default: goto L9;
            };
        L9:
            sb.append("UNKNOWN");
        L12:
            sb.append(", Slot:");
            sb.append(slot);
            sb.append("\nLAST:");
            ProcessRecordNode last = this.mLastNode[slot];
            if (last.mApp != null) goto L15;
            sb.append("null");
        L16:
            Slog.wtfStack(OomAdjusterModernImpl.TAG, sb.toString());
            goto L17
        L15:
            sb.append(last);
            sb.append("\nSetProcState:");
            sb.append(last.mApp.getSetProcState());
            sb.append(", CurProcState:");
            sb.append(last.mApp.mState.getCurProcState());
            sb.append(", SetAdj:");
            sb.append(last.mApp.getSetAdj());
            sb.append(", CurRawAdj:");
            sb.append(last.mApp.mState.getCurRawAdj());
            goto L16
        L10:
            sb.append("NODE_TYPE_ADJ");
            goto L12
        L11:
            sb.append("NODE_TYPE_PROC_STATE");
        L17:
            ProcessRecordNode next = node.mNext;
            if (OomAdjusterModernImpl.m1523$$Nest$fgetmTmpOomAdjusterArgs(this.this$0).mApp == null) goto L20;
            callback.accept(OomAdjusterModernImpl.m1523$$Nest$fgetmTmpOomAdjusterArgs(this.this$0));
        L20:
            if (next == tail) goto L22;
        L26:
            ProcessRecordNode r3 = next;
        L27:
            node = r3;
            goto L3
        L22:
            if (node.mNext == null) goto L26;
            if (node.mNext.mNext == null) goto L26;
            r3 = node.mNext;
            goto L27
        L33:
            return;
        }

        ProcessRecord poll() {
            ProcessRecordNode node = null;
            int size = this.mProcessRecordNodes.length;
        L3:
            if (node != null) goto L9;
            if (this.mFirstPopulatedSlot >= size) goto L9;
            node = this.mProcessRecordNodes[this.mFirstPopulatedSlot].poll();
            if (node != null) goto L3;
            this.mFirstPopulatedSlot++;
        L9:
            if (node != null) goto L13;
            return null;
        L13:
            return node.mApp;
        }

        void offer(ProcessRecord proc) {
            ProcessRecordNode node = proc.mLinkedNodes[this.mType];
            int newSlot = this.mSlotFunction.applyAsInt(proc);
            if (newSlot >= this.mFirstPopulatedSlot) goto L5;
            this.mFirstPopulatedSlot = newSlot;
        L5:
            node.unlink();
            this.mProcessRecordNodes[newSlot].offer(node);
        }

        int getNumberOfSlots() {
            return this.mProcessRecordNodes.length;
        }

        void moveAppTo(ProcessRecord app, int prevSlot, int newSlot) {
            ProcessRecordNode node = app.mLinkedNodes[this.mType];
            if (prevSlot != (-1)) goto L5;
        L7:
            append(node, newSlot);
            return;
        L5:
            if (this.mLastNode[prevSlot] != node) goto L7;
            this.mLastNode[prevSlot] = node.mPrev;
            goto L7
        }

        void moveAllNodesTo(int fromSlot, int toSlot) {
            LinkedProcessRecordList fromList = this.mProcessRecordNodes[fromSlot];
            LinkedProcessRecordList toList = this.mProcessRecordNodes[toSlot];
            if (fromSlot != toSlot) goto L5;
            return;
        L5:
            if (fromList.HEAD.mNext == fromList.TAIL) goto L9;
            fromList.moveTo(toList);
            this.mLastNode[fromSlot] = fromList.getLastNodeBeforeTail();
            return;
        }

        void moveAppToTail(ProcessRecord app) {
            ProcessRecordNode node = app.mLinkedNodes[this.mType];
            switch(this.mType) {
                case 0: goto L9;
                case 1: goto L5;
                default: goto L4;
            };
        L4:
            return;
        L5:
            int slot = OomAdjusterModernImpl.adjToSlot(app.mState.getCurRawAdj());
            if (this.mLastNode[slot] != node) goto L8;
            this.mLastNode[slot] = node.mPrev;
        L8:
            this.mProcessRecordNodes[slot].moveNodeToTail(node);
            return;
        L9:
            int slot2 = OomAdjusterModernImpl.processStateToSlot(app.mState.getCurProcState());
            if (this.mLastNode[slot2] != node) goto L12;
            this.mLastNode[slot2] = node.mPrev;
        L12:
            this.mProcessRecordNodes[slot2].moveNodeToTail(node);
        }

        void reset(int slot) {
            this.mProcessRecordNodes[slot].reset();
        }

        void unlink(ProcessRecord app) {
            ProcessRecordNode node = app.mLinkedNodes[this.mType];
            int slot = getCurrentSlot(app);
            if (slot != (-1)) goto L5;
        L7:
            node.unlink();
            return;
        L5:
            if (this.mLastNode[slot] != node) goto L7;
            this.mLastNode[slot] = node.mPrev;
            goto L7
        }

        void append(ProcessRecord app) {
            append(app, getCurrentSlot(app));
        }

        void append(ProcessRecord app, int targetSlot) {
            append(app.mLinkedNodes[this.mType], targetSlot);
        }

        void append(ProcessRecordNode node, int targetSlot) {
            node.unlink();
            this.mProcessRecordNodes[targetSlot].append(node);
        }

        private int getCurrentSlot(ProcessRecord app) {
            switch(this.mType) {
                case 0: goto L9;
                case 1: goto L7;
                default: goto L4;
            };
        L4:
            return -1;
        L7:
            return OomAdjusterModernImpl.adjToSlot(app.mState.getCurRawAdj());
        L9:
            return OomAdjusterModernImpl.processStateToSlot(app.mState.getCurProcState());
        }

        String toString(int slot, int logUid) {
            return "lastNode=" + this.mLastNode[slot] + " " + this.mProcessRecordNodes[slot].toString(logUid);
        }
    }

    private static class ReachableCollectingConsumer implements BiConsumer<Connection, ProcessRecord> {
        ArrayList<ProcessRecord> mReachables;

        /* synthetic */ ReachableCollectingConsumer(OomAdjusterModernImplIA r1) {
            this();
        }

        private ReachableCollectingConsumer() {
            this.mReachables = null;
        }

        @Override // java.util.function.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Connection r1, ProcessRecord r2) {
            accept2(r1, r2);
        }

        public void init(ArrayList<ProcessRecord> reachables) {
            this.mReachables = reachables;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Connection unused, ProcessRecord host) {
            if (host.mState.isReachable() == false) goto L5;
            return;
        L5:
            host.mState.setReachable(true);
            this.mReachables.add(host);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmComputeHostConsumer, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComputeHostConsumer m1522$$Nest$fgetmComputeHostConsumer(OomAdjusterModernImpl r0) {
        return r0.mComputeHostConsumer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTmpOomAdjusterArgs, reason: not valid java name */
    static /* bridge */ /* synthetic */ OomAdjusterArgs m1523$$Nest$fgetmTmpOomAdjusterArgs(OomAdjusterModernImpl r0) {
        return r0.mTmpOomAdjusterArgs;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAdjSlotIfNecessary, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1524$$Nest$mupdateAdjSlotIfNecessary(OomAdjusterModernImpl r0, ProcessRecord r1, int r2) {
        r0.updateAdjSlotIfNecessary(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateProcStateSlotIfNecessary, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1525$$Nest$mupdateProcStateSlotIfNecessary(OomAdjusterModernImpl r0, ProcessRecord r1, int r2) {
        r0.updateProcStateSlotIfNecessary(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smforEachConnectionLSP, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1526$$Nest$smforEachConnectionLSP(ProcessRecord r0, BiConsumer r1) {
        forEachConnectionLSP(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smunimportantConnectionLSP, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1527$$Nest$smunimportantConnectionLSP(Connection r0, ProcessRecord r1, ProcessRecord r2) {
        return unimportantConnectionLSP(r0, r1, r2);
    }

    static {
        ADJ_SLOT_VALUES = new int[]{-1000, ProcessList.SYSTEM_ADJ, ProcessList.PERSISTENT_PROC_ADJ, ProcessList.PERSISTENT_SERVICE_ADJ, 0, 50, 100, 200, ProcessList.PERCEPTIBLE_MEDIUM_APP_ADJ, 250, 300, 400, 500, 600, 700, 800, 900, 1001};
        PROC_STATE_SLOTS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, -1};
    }

    static int adjToSlot(int adj) {
        if (adj < ADJ_SLOT_VALUES[0]) goto L12;
        if (adj > ADJ_SLOT_VALUES[ADJ_SLOT_VALUES.length - 1]) goto L12;
        int index = Arrays.binarySearch(ADJ_SLOT_VALUES, adj);
        if (index < 0) goto L10;
        return index;
    L10:
        return (-(index + 1)) - 1;
    L12:
        return ADJ_SLOT_VALUES.length - 1;
    }

    static int processStateToSlot(int state) {
        if (state < 0) goto L7;
        if (state > 19) goto L7;
        return state;
    L7:
        return PROC_STATE_SLOTS.length - 1;
    }

    OomAdjusterModernImpl(ActivityManagerService service, ProcessList processList, ActiveUids activeUids, ServiceThread adjusterThread, OomAdjuster.GlobalState globalState, CachedAppOptimizer cachedAppOptimizer, OomAdjuster.Injector injector) {
        super(service, processList, activeUids, adjusterThread, globalState, cachedAppOptimizer, injector);
        OomAdjusterModernImplIA r2 = null;
        this.mReachableCollectingConsumer = new ReachableCollectingConsumer(r2);
        this.mComputeConnectionIgnoringReachableClientsConsumer = new ComputeConnectionIgnoringReachableClientsConsumer(this, r2);
        this.mComputeHostConsumer = new ComputeHostConsumer(this, r2);
        this.mComputeConnectionsConsumer = new ComputeConnectionsConsumer(this, r2);
        this.mProcessRecordProcStateNodes = new ProcessRecordNodes(this, 0, PROC_STATE_SLOTS.length);
        this.mProcessRecordAdjNodes = new ProcessRecordNodes(this, 1, ADJ_SLOT_VALUES.length);
        this.mTmpOomAdjusterArgs = new OomAdjusterArgs(this, r2);
    }

    void linkProcessRecordToList(ProcessRecord app) {
        this.mProcessRecordProcStateNodes.append(app);
        this.mProcessRecordAdjNodes.append(app);
    }

    void unlinkProcessRecordFromList(ProcessRecord app) {
        this.mProcessRecordProcStateNodes.unlink(app);
        this.mProcessRecordAdjNodes.unlink(app);
    }

    @Override // com.android.server.am.OomAdjuster
    void resetInternal() {
        this.mProcessRecordProcStateNodes.reset();
        this.mProcessRecordAdjNodes.reset();
    }

    @Override // com.android.server.am.OomAdjuster
    void onProcessEndLocked(ProcessRecord app) {
        if (app.mLinkedNodes[0] != null) goto L5;
        return;
    L5:
        if (app.mLinkedNodes[0].isLinked() == false) goto L9;
        unlinkProcessRecordFromList(app);
        return;
    }

    @Override // com.android.server.am.OomAdjuster
    void onProcessStateChanged(ProcessRecord app, int prevProcState) {
        updateProcStateSlotIfNecessary(app, prevProcState);
    }

    @Override // com.android.server.am.OomAdjuster
    void onProcessOomAdjChanged(ProcessRecord app, int prevAdj) {
        updateAdjSlotIfNecessary(app, prevAdj);
    }

    @Override // com.android.server.am.OomAdjuster
    protected int getInitialAdj(ProcessRecord app) {
        return 1001;
    }

    @Override // com.android.server.am.OomAdjuster
    protected int getInitialProcState(ProcessRecord app) {
        return -1;
    }

    @Override // com.android.server.am.OomAdjuster
    protected int getInitialCapability(ProcessRecord app) {
        return 0;
    }

    @Override // com.android.server.am.OomAdjuster
    protected boolean getInitialIsCurBoundByNonBgRestrictedApp(ProcessRecord app) {
        return false;
    }

    private void updateAdjSlotIfNecessary(ProcessRecord app, int prevRawAdj) {
        if (app.mState.getCurRawAdj() == prevRawAdj) goto L6;
        this.mProcessRecordAdjNodes.offer(app);
        return;
    }

    private void updateAdjSlot(ProcessRecord app, int prevRawAdj) {
        this.mProcessRecordAdjNodes.offer(app);
    }

    private void updateProcStateSlotIfNecessary(ProcessRecord app, int prevProcState) {
        if (app.mState.getCurProcState() == prevProcState) goto L6;
        this.mProcessRecordProcStateNodes.offer(app);
        return;
    }

    private void updateProcStateSlot(ProcessRecord app, int prevProcState) {
        this.mProcessRecordProcStateNodes.offer(app);
    }

    @Override // com.android.server.am.OomAdjuster
    protected void performUpdateOomAdjLSP(int oomAdjReason) {
        this.mService.getTopApp();
        this.mProcessStateCurTop = this.mService.mAtmInternal.getTopProcessState();
        this.mPendingProcessSet.clear();
        AppProfiler r1 = this.mService.mAppProfiler;
        this.mService.mAppProfiler.mHasHomeProcess = false;
        r1.mHasPreviousProcess = false;
        this.mLastReason = oomAdjReason;
        Trace.traceBegin(64, OomAdjuster.oomAdjReasonToString(oomAdjReason));
        fullUpdateLSP(oomAdjReason);
        Trace.traceEnd(64);
    }

    @Override // com.android.server.am.OomAdjuster
    protected boolean performUpdateOomAdjLSP(ProcessRecord app, int oomAdjReason) {
        this.mPendingProcessSet.add(app);
        performUpdateOomAdjPendingTargetsLocked(oomAdjReason);
        return true;
    }

    @Override // com.android.server.am.OomAdjuster
    protected void performUpdateOomAdjPendingTargetsLocked(int oomAdjReason) {
        this.mLastReason = oomAdjReason;
        this.mProcessStateCurTop = enqueuePendingTopAppIfNecessaryLSP();
        Trace.traceBegin(64, OomAdjuster.oomAdjReasonToString(oomAdjReason));
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        partialUpdateLSP(oomAdjReason, this.mPendingProcessSet);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        this.mPendingProcessSet.clear();
        Trace.traceEnd(64);
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private void fullUpdateLSP(int oomAdjReason) {
        ProcessRecord topApp = this.mService.getTopApp();
        long now = this.mInjector.getUptimeMillis();
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        long oldTime = now - this.mConstants.mMaxEmptyTimeMillis;
        this.mAdjSeq++;
        this.mNewNumServiceProcs = 0;
        this.mNewNumAServiceProcs = 0;
        this.mProcessRecordProcStateNodes.reset();
        this.mProcessRecordAdjNodes.reset();
        ArrayList<ProcessRecord> lru = this.mProcessList.getLruProcessesLOSP();
        int i = lru.size() - 1;
    L3:
        if (i < 0) goto L11;
        ProcessRecord app = lru.get(i);
        app.mState.getCurProcState();
        app.mState.getCurRawAdj();
        app.mState.resetCachedInfo();
        UidRecord uidRec = app.getUidRecord();
        if (uidRec == null) goto L10;
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L9;
        Slog.i("ActivityManager", "Starting update of " + uidRec);
    L9:
        uidRec.reset();
    L10:
        long now2 = now;
        computeOomAdjLSP(app, 1001, topApp, true, now2, false, false, oomAdjReason, false);
        this.mProcessRecordProcStateNodes.offer(app);
        i = i - 1;
        now = now2;
        goto L3
    L11:
        long now3 = now;
        this.mProcessRecordAdjNodes.resetLastNodes();
        this.mTmpOomAdjusterArgs.update(topApp, now3, 1001, oomAdjReason, null, true);
        computeConnectionsLSP();
        applyLruAdjust(this.mProcessList.getLruProcessesLOSP());
        postUpdateOomAdjInnerLSP(oomAdjReason, this.mActiveUids, now3, nowElapsed, oldTime, true);
    }

    private void computeConnectionsLSP() {
        ProcessRecord proc = this.mProcessRecordProcStateNodes.poll();
    L3:
        if (proc == null) goto L5;
        this.mTmpOomAdjusterArgs.mApp = proc;
        this.mComputeConnectionsConsumer.accept2(this.mTmpOomAdjusterArgs);
        proc = this.mProcessRecordProcStateNodes.poll();
        goto L3
    L5:
        ProcessRecord proc2 = this.mProcessRecordAdjNodes.poll();
    L6:
        if (proc2 == null) goto L9;
        this.mTmpOomAdjusterArgs.mApp = proc2;
        this.mComputeConnectionsConsumer.accept2(this.mTmpOomAdjusterArgs);
        proc2 = this.mProcessRecordAdjNodes.poll();
        goto L6
    }

    private void partialUpdateLSP(int oomAdjReason, ArraySet<ProcessRecord> targets) {
        ProcessRecord topApp = this.mService.getTopApp();
        long now = this.mInjector.getUptimeMillis();
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        long oldTime = now - this.mConstants.mMaxEmptyTimeMillis;
        ActiveUids activeUids = this.mTmpUidRecords;
        activeUids.clear();
        this.mTmpOomAdjusterArgs.update(topApp, now, 1001, oomAdjReason, activeUids, false);
        boolean r2 = true;
        this.mAdjSeq++;
        ArrayList<ProcessRecord> reachables = this.mTmpProcessList;
        reachables.clear();
        int i = 0;
        int size = targets.size();
    L3:
        if (i >= size) goto L5;
        ProcessRecord target = (ProcessRecord) targets.valueAtUnchecked(i);
        target.mState.resetCachedInfo();
        target.mState.setReachable(true);
        reachables.add(target);
        i = i + 1;
        goto L3
    L5:
        collectAndMarkReachableProcessesLSP(reachables);
        this.mProcessRecordProcStateNodes.resetLastNodes();
        initReachableStatesLSP(reachables, targets.size(), this.mTmpOomAdjusterArgs);
        this.mProcessRecordAdjNodes.resetLastNodes();
        computeConnectionsLSP();
        int i2 = 0;
        int size2 = reachables.size();
        boolean needLruAdjust = false;
    L6:
        if (i2 >= size2) goto L19;
        ProcessStateRecord state = reachables.get(i2).mState;
        state.setReachable(false);
        boolean r17 = r2;
        state.setCompletedAdjSeq(this.mAdjSeq);
        int curAdj = state.getCurAdj();
        if (700 > curAdj) goto L14;
        if (curAdj <= ProcessList.PREVIOUS_APP_MAX_ADJ) goto L14;
    L14:
        if (curAdj < 1001) goto L17;
        needLruAdjust = true;
    L17:
        i2 = i2 + 1;
        r2 = r17;
        goto L6
    L19:
        if (needLruAdjust == false) goto L21;
        applyLruAdjust(this.mProcessList.getLruProcessesLOSP());
    L21:
        int i3 = 0;
        int size3 = activeUids.size();
    L22:
        if (i3 >= size3) goto L27;
        UidRecord ur = activeUids.valueAt(i3);
        ur.reset();
        int j = ur.getNumOfProcs() - 1;
    L24:
        if (j < 0) goto L26;
        ProcessRecord proc = ur.getProcessRecordByIndex(j);
        updateAppUidRecIfNecessaryLSP(proc);
        j = j - 1;
        goto L24
    L26:
        i3 = i3 + 1;
        goto L22
    L27:
        postUpdateOomAdjInnerLSP(oomAdjReason, activeUids, now, nowElapsed, oldTime, false);
    }

    private void collectAndMarkReachableProcessesLSP(ArrayList<ProcessRecord> reachables) {
        this.mReachableCollectingConsumer.init(reachables);
        int i = 0;
    L4:
        if (i >= reachables.size()) goto L7;
        ProcessRecord pr = reachables.get(i);
        forEachConnectionLSP(pr, this.mReachableCollectingConsumer);
        i = i + 1;
        goto L4
    }

    private void initReachableStatesLSP(ArrayList<ProcessRecord> reachables, int targetCount, OomAdjusterArgs args) {
        int i = 0;
        boolean initReachables = true;
    L3:
        if (i >= targetCount) goto L6;
        if (initReachables == true) goto L6;
        ProcessRecord target = reachables.get(i);
        int prevProcState = target.mState.getCurProcState();
        int prevAdj = target.mState.getCurRawAdj();
        int prevCapability = target.mState.getCurCapability();
        boolean prevShouldNotFreeze = target.mOptRecord.shouldNotFreeze();
        args.mApp = target;
        initReachables = (initReachables | computeOomAdjIgnoringReachablesLSP(args)) | selfImportanceLoweredLSP(target, prevProcState, prevAdj, prevCapability, prevShouldNotFreeze);
        updateProcStateSlot(target, prevProcState);
        updateAdjSlot(target, prevAdj);
        i = i + 1;
    L6:
        if (initReachables == true) goto L8;
        return;
    L8:
        int size = reachables.size();
    L9:
        if (i >= size) goto L12;
        ProcessRecord reachable = reachables.get(i);
        reachable.mState.getCurProcState();
        reachable.mState.getCurRawAdj();
        args.mApp = reachable;
        computeOomAdjIgnoringReachablesLSP(args);
        this.mProcessRecordProcStateNodes.offer(reachable);
        i = i + 1;
        goto L9
    }

    private boolean computeOomAdjIgnoringReachablesLSP(OomAdjusterArgs args) {
        ProcessRecord app = args.mApp;
        ProcessRecord topApp = args.mTopApp;
        long now = args.mNow;
        int oomAdjReason = args.mOomAdjReason;
        computeOomAdjLSP(app, 1001, topApp, false, now, false, false, oomAdjReason, false);
        this.mComputeConnectionIgnoringReachableClientsConsumer.init(args);
        forEachClientConnectionLSP(app, this.mComputeConnectionIgnoringReachableClientsConsumer);
        return this.mComputeConnectionIgnoringReachableClientsConsumer.hasReachableClient;
    }

    private static void forEachConnectionLSP(ProcessRecord app, BiConsumer<Connection, ProcessRecord> connectionConsumer) {
        ProcessServiceRecord psr = app.mServices;
        int i = psr.numberOfConnections();
    L3:
        i = i - 1;
        if (i < 0) goto L28;
        ConnectionRecord cr = psr.getConnectionAt(i);
        if (cr.hasFlag(2) == false) goto L8;
        ProcessRecord service = cr.binding.service.isolationHostProc;
    L9:
        if (service == null) goto L3;
        if (service == app) goto L3;
        if (service.mState.getMaxAdj() < (-900)) goto L16;
        if (service.mState.getMaxAdj() < 0) goto L3;
    L16:
        if (service.mState.getCurAdj() > 0) goto L22;
        if (service.mState.getCurrentSchedulingGroup() <= 0) goto L22;
        if (service.mState.getCurProcState() <= 2) goto L3;
    L22:
        if (service.isSdkSandbox == true) goto L24;
    L26:
        connectionConsumer.accept(cr, service);
        goto L3
    L24:
        if (cr.binding.attributedClient == null) goto L26;
    L8:
        service = cr.binding.service.app;
        goto L9
    L28:
        int i2 = psr.numberOfSdkSandboxConnections();
        int i3 = i2 - 1;
    L29:
        if (i3 < 0) goto L46;
        ConnectionRecord cr2 = psr.getSdkSandboxConnectionAt(i3);
        ProcessRecord service2 = cr2.binding.service.app;
        if (service2 == null) goto L45;
        if (service2 == app) goto L45;
        if (service2.mState.getMaxAdj() < (-900)) goto L38;
        if (service2.mState.getMaxAdj() < 0) goto L45;
    L38:
        if (service2.mState.getCurAdj() <= 0) goto L40;
    L44:
        connectionConsumer.accept(cr2, service2);
        goto L45
    L40:
        if (service2.mState.getCurrentSchedulingGroup() <= 0) goto L44;
        if (service2.mState.getCurProcState() > 2) goto L44;
    L45:
        i3 = i3 - 1;
        goto L29
    L46:
        ProcessProviderRecord ppr = app.mProviders;
        int i4 = ppr.numberOfProviderConnections() - 1;
    L47:
        if (i4 < 0) goto L65;
        ContentProviderConnection cpc = ppr.getProviderConnectionAt(i4);
        ProcessRecord provider = cpc.provider.proc;
        if (provider == null) goto L63;
        if (provider == app) goto L63;
        if (provider.mState.getMaxAdj() < (-900)) goto L56;
        if (provider.mState.getMaxAdj() < 0) goto L63;
    L56:
        if (provider.mState.getCurAdj() <= 0) goto L58;
    L62:
        connectionConsumer.accept(cpc, provider);
        goto L63
    L58:
        if (provider.mState.getCurrentSchedulingGroup() <= 0) goto L62;
        if (provider.mState.getCurProcState() > 2) goto L62;
    L63:
        i4 = i4 - 1;
        goto L47
    }

    private static void forEachClientConnectionLSP(ProcessRecord app, BiConsumer<Connection, ProcessRecord> connectionConsumer) {
        ProcessServiceRecord psr = app.mServices;
        int i = psr.numberOfRunningServices() - 1;
    L3:
        if (i < 0) goto L21;
        ServiceRecord s = psr.getRunningServiceAt(i);
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> serviceConnections = s.getConnections();
        int j = serviceConnections.size() - 1;
    L5:
        if (j < 0) goto L20;
        ArrayList<ConnectionRecord> clist = serviceConnections.valueAt(j);
        int k = clist.size() - 1;
    L7:
        if (k < 0) goto L19;
        ConnectionRecord cr = clist.get(k);
        if (app.isSdkSandbox == true) goto L11;
    L13:
        ProcessRecord client = cr.binding.client;
    L14:
        if (client == null) goto L18;
        if (client == app) goto L18;
        connectionConsumer.accept(cr, client);
    L18:
        k = k - 1;
        goto L7
    L11:
        if (cr.binding.attributedClient == null) goto L13;
        client = cr.binding.attributedClient;
        goto L14
    L19:
        j = j - 1;
        goto L5
    L20:
        i = i - 1;
        goto L3
    L21:
        ProcessProviderRecord ppr = app.mProviders;
        int i2 = ppr.numberOfProviders() - 1;
    L22:
        if (i2 < 0) goto L28;
        ContentProviderRecord cpr = ppr.getProviderAt(i2);
        int j2 = cpr.connections.size() - 1;
    L24:
        if (j2 < 0) goto L26;
        ContentProviderConnection conn = cpr.connections.get(j2);
        connectionConsumer.accept(conn, conn.client);
        j2 = j2 - 1;
        goto L24
    L26:
        i2 = i2 - 1;
        goto L22
    }

    private static boolean selfImportanceLoweredLSP(ProcessRecord app, int prevProcState, int prevAdj, int prevCapability, boolean prevShouldNotFreeze) {
        if (app.mState.getCurProcState() <= prevProcState) goto L6;
        return true;
    L6:
        if (app.mState.getCurRawAdj() <= prevAdj) goto L9;
        return true;
    L9:
        if ((app.mState.getCurCapability() & prevCapability) == prevCapability) goto L12;
        return true;
    L12:
        if (app.mOptRecord.shouldNotFreeze() == true) goto L15;
        if (prevShouldNotFreeze == false) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    }

    private static boolean unimportantConnectionLSP(Connection conn, ProcessRecord host, ProcessRecord client) {
        return false;
    }
}
