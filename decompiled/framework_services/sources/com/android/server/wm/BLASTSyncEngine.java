package com.android.server.wm;

import android.os.Handler;
import android.os.Trace;
import android.util.ArraySet;
import android.util.Slog;
import android.view.SurfaceControl;
import android.view.WmTrace;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class BLASTSyncEngine {
    public static final int METHOD_BLAST = 1;
    public static final int METHOD_NONE = 0;
    public static final int METHOD_UNDEFINED = -1;
    private static final String TAG = "BLASTSyncEngine";
    private final ArrayList<SyncGroup> mActiveSyncs;
    private final Handler mHandler;
    private int mNextSyncId;
    private final ArrayList<Runnable> mOnIdleListeners;
    private final ArrayList<PendingSyncSet> mPendingSyncSets;
    private final ArrayList<SyncGroup> mTmpFinishQueue;
    private final ArrayList<SyncGroup> mTmpFringe;
    private final WindowManagerService mWm;

    private static class PendingSyncSet {
        private Runnable mApplySync;
        private Runnable mStartSync;

        /* JADX INFO: renamed from: -$$Nest$fgetmApplySync, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m9745$$Nest$fgetmApplySync(PendingSyncSet r0) {
            return r0.mApplySync;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStartSync, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m9746$$Nest$fgetmStartSync(PendingSyncSet r0) {
            return r0.mStartSync;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmApplySync, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9747$$Nest$fputmApplySync(PendingSyncSet r0, Runnable r1) {
            r0.mApplySync = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmStartSync, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9748$$Nest$fputmStartSync(PendingSyncSet r0, Runnable r1) {
            r0.mStartSync = r1;
        }

        /* synthetic */ PendingSyncSet(BLASTSyncEngineIA r1) {
            this();
        }

        private PendingSyncSet() {
        }
    }

    class SyncGroup {
        private static final ArrayList<SyncGroup> NO_DEPENDENCIES = null;
        ArrayList<SyncGroup> mDependencies;
        boolean mIgnoreIndirectMembers;
        final TransactionReadyListener mListener;
        final Runnable mOnTimeout;
        private SurfaceControl.Transaction mOrphanTransaction;
        boolean mReady;
        final ArraySet<WindowContainer> mRootMembers;
        final int mSyncId;
        int mSyncMethod;
        final String mSyncName;
        private String mTraceName;
        final /* synthetic */ BLASTSyncEngine this$0;

        /* JADX INFO: renamed from: com.android.server.wm.BLASTSyncEngine$SyncGroup$1CommitCallback, reason: invalid class name */
        class C1CommitCallback implements Runnable {
            final ArraySet<WindowContainer> mWcAwaitingCommit;
            boolean ran;
            final /* synthetic */ SyncGroup this$1;
            final /* synthetic */ SurfaceControl.Transaction val$merged;
            final /* synthetic */ long val$mergedTxId;

            C1CommitCallback(SyncGroup this$1, long r2, SurfaceControl.Transaction r4) {
                this.this$1 = this$1;
                this.val$mergedTxId = r2;
                this.val$merged = r4;
                this.mWcAwaitingCommit = new ArraySet();
                this.ran = false;
            }

            public void onCommitted(SurfaceControl.Transaction t) {
                this.this$1.mListener.onTransactionCommitted();
                if (SyncGroup.m9751$$Nest$fgetmTraceName(this.this$1) == null) goto L5;
                Trace.instant(32, this.this$1.mSyncName + "#" + this.this$1.mSyncId + "-committed");
            L5:
                BLASTSyncEngine.m9739$$Nest$fgetmHandler(this.this$1.this$0).removeCallbacks(this);
                WindowManagerGlobalLock r0 = BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$1.this$0).mGlobalLock;
                WindowManagerService.boostPriorityForLockedSection();
                monitor-enter(r0);
            L12:
                th = move-exception;
                WindowManagerService.resetPriorityAfterLockedSection();
                throw th;
            L8:
                if (this.ran == false) goto L15;
                monitor-exit(r0);     // Catch: Throwable -> L12
                WindowManagerService.resetPriorityAfterLockedSection();
                return;
            L15:
                this.ran = true;     // Catch: Throwable -> L12
                int i = this.mWcAwaitingCommit.size() - 1;     // Catch: Throwable -> L12
            L16:
                if (i < 0) goto L18;
                this.mWcAwaitingCommit.valueAt(i).onSyncTransactionCommitted(t);     // Catch: Throwable -> L12
                i = i - 1;     // Catch: Throwable -> L12
                goto L16
            L18:
                t.apply();     // Catch: Throwable -> L12
                this.mWcAwaitingCommit.clear();     // Catch: Throwable -> L12
                monitor-exit(r0);     // Catch: Throwable -> L12
                WindowManagerService.resetPriorityAfterLockedSection();
            }

            @Override // java.lang.Runnable
            public void run() {
                Trace.traceBegin(32, "onTransactionCommitTimeout");
                Slog.e(BLASTSyncEngine.TAG, "WM sent Transaction (#" + this.this$1.mSyncId + ", " + this.this$1.mSyncName + ", tx=" + this.val$mergedTxId + ") to organizer, but never received commit callback. Application ANR likely to follow.");
                Trace.traceEnd(32);
                WindowManagerGlobalLock r0 = BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$1.this$0).mGlobalLock;
                WindowManagerService.boostPriorityForLockedSection();
                monitor-enter(r0);
                this.this$1.mListener.onTransactionCommitTimeout();     // Catch: Throwable -> L7
                if (this.val$merged.mNativeObject == 0) goto L9;
                SurfaceControl.Transaction r1 = this.val$merged;     // Catch: Throwable -> L7
            L10:
                onCommitted(r1);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                WindowManagerService.resetPriorityAfterLockedSection();
                return;
            L9:
                r1 = BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$1.this$0).mTransactionFactory.get();     // Catch: Throwable -> L7
            L7:
                th = move-exception;
                WindowManagerService.resetPriorityAfterLockedSection();
                throw th;
            }
        }

        public static /* synthetic */ void $r8$lambda$BHN96tvxB7fo1aLu6vPwwYkPzqU(C1CommitCallback r0) {
            lambda$finishNow$1(r0);
        }

        public static /* synthetic */ void $r8$lambda$T3b4oMuoLuCo5FThSDbVYPuJEgE(SyncGroup r0) {
            r0.lambda$new$0();
        }

        public static /* synthetic */ void $r8$lambda$eVgIUAMstvoiW6T5KTFSXf3IJec(ActivityRecord r0) {
            lambda$onTimeout$4(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$gITUKhrjdOkXsZ7WQ-AZymvMjC4, reason: not valid java name */
        public static /* synthetic */ void m9749$r8$lambda$gITUKhrjdOkXsZ7WQAZymvMjC4(WindowState r0) {
            lambda$onTimeout$3(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$tlJIJYL9__mhuBj-3pgYCGCXPy4, reason: not valid java name */
        public static /* synthetic */ void m9750$r8$lambda$tlJIJYL9__mhuBj3pgYCGCXPy4(SyncGroup r0, PendingSyncSet r1) {
            r0.lambda$finishNow$2(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTraceName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9751$$Nest$fgetmTraceName(SyncGroup r0) {
            return r0.mTraceName;
        }

        /* JADX INFO: renamed from: -$$Nest$maddToSync, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9752$$Nest$maddToSync(SyncGroup r0, WindowContainer r1) {
            r0.addToSync(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mfinishNow, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9753$$Nest$mfinishNow(SyncGroup r0) {
            r0.finishNow();
        }

        /* JADX INFO: renamed from: -$$Nest$msetReady, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9754$$Nest$msetReady(SyncGroup r0, boolean r1) {
            return r0.setReady(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mtryFinish, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9755$$Nest$mtryFinish(SyncGroup r0) {
            return r0.tryFinish();
        }

        /* synthetic */ SyncGroup(BLASTSyncEngine r1, TransactionReadyListener r2, int r3, String r4, BLASTSyncEngineIA r5) {
            this(r1, r2, r3, r4);
        }

        static {
            NO_DEPENDENCIES = new ArrayList();
        }

        private SyncGroup(BLASTSyncEngine this$0, TransactionReadyListener listener, int id, String name) {
            this.this$0 = this$0;
            this.mSyncMethod = 1;
            this.mReady = false;
            this.mRootMembers = new ArraySet();
            this.mOrphanTransaction = null;
            this.mIgnoreIndirectMembers = false;
            this.mDependencies = NO_DEPENDENCIES;
            this.mSyncId = id;
            this.mSyncName = name;
            this.mListener = listener;
            this.mOnTimeout = new BLASTSyncEngine$SyncGroup$$ExternalSyntheticLambda2(this);
            if (Trace.isTagEnabled(32) == false) goto L6;
            this.mTraceName = name + "-SyncReady#" + id;
            listener.onReadyTraceStart(this.mTraceName, id);
            return;
        }

        private /* synthetic */ void lambda$new$0() {
            Slog.w(BLASTSyncEngine.TAG, "Sync group " + this.mSyncId + " timeout");
            WindowManagerGlobalLock r0 = BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            onTimeout();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        SurfaceControl.Transaction getOrphanTransaction() {
            if (this.mOrphanTransaction != null) goto L6;
            this.mOrphanTransaction = BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mTransactionFactory.get();
        L6:
            return this.mOrphanTransaction;
        }

        boolean isIgnoring(WindowContainer wc) {
            if (this.mIgnoreIndirectMembers == true) goto L6;
            return false;
        L6:
            if (wc.asWindowState() == null) goto L9;
            return false;
        L9:
            if (wc.mSyncGroup == this) goto L12;
            return true;
        L12:
            return false;
        }

        private boolean tryFinish() {
            if (this.mReady == true) goto L6;
            return false;
        L6:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L9;
            long protoLogParam0 = this.mSyncId;
            String protoLogParam1 = String.valueOf(this.mRootMembers);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, 495867940519492701L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
        L9:
            if (this.mDependencies.isEmpty() == false) goto L11;
            int i = this.mRootMembers.size() - 1;
        L15:
            if (i < 0) goto L26;
            WindowContainer wc = this.mRootMembers.valueAt(i);
            if (wc.isSyncFinished(this) == false) goto L19;
            i = i - 1;
            goto L15
        L19:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L22;
            long protoLogParam2 = this.mSyncId;
            String protoLogParam3 = String.valueOf(wc);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, 616739530932040800L, 1, new Object[]{Long.valueOf(protoLogParam2), protoLogParam3});
        L22:
            if (WmTrace.isEnable() == false) goto L24;
            StringBuilder sb = WmTrace.getLocalStringBuilder();
            sb.setLength(0);
            sb.append("SyncGroup onSurfacePlacement checking SyncId: ");
            sb.append(this.mSyncId);
            sb.append(" Unfinished container: ");
            sb.append(wc);
            WmTrace.traceInfo(1, System.currentTimeMillis(), sb.toString());
        L24:
            return false;
        L26:
            finishNow();
            return true;
        L11:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L13;
            long protoLogParam4 = this.mSyncId;
            String protoLogParam5 = String.valueOf(this.mDependencies);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, 8452501904614439940L, 1, new Object[]{Long.valueOf(protoLogParam4), protoLogParam5});
        L13:
            return false;
        }

        private void finishNow() {
            if (this.mTraceName == null) goto L6;
            this.mListener.onReadyTraceEnd(this.mTraceName, this.mSyncId);
        L6:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L8;
            long protoLogParam0 = this.mSyncId;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, 6649777898123506907L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        L8:
            SurfaceControl.Transaction merged = BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mTransactionFactory.get();
            merged.startTrace("blastsyncfinish");
            if (this.mOrphanTransaction == null) goto L11;
            merged.merge(this.mOrphanTransaction);
        L11:
            long mergedTxId = merged.getId();
            final C1CommitCallback callback = new C1CommitCallback(this, mergedTxId, merged);
            int i = this.mRootMembers.size() - 1;
        L13:
            if (i < 0) goto L15;
            WindowContainer<?> wc = this.mRootMembers.valueAt(i);
            wc.finishSync(merged, this, false);
            wc.waitForSyncTransactionCommit(callback.mWcAwaitingCommit);
            i = i - 1;
            goto L13
        L15:
            merged.addTransactionCommittedListener(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new BLASTSyncEngine$SyncGroup$$ExternalSyntheticLambda0(callback));
            BLASTSyncEngine.m9739$$Nest$fgetmHandler(this.this$0).postDelayed(callback, 5000);
            if (BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mAnimator.mPendingState != 2) goto L18;
            BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mAnimator.applyPendingTransaction();
        L18:
            merged.endTrace();
            Trace.traceBegin(32, "onTransactionReady");
            this.mListener.onTransactionReady(this.mSyncId, merged);
            Trace.traceEnd(32);
            BLASTSyncEngine.m9738$$Nest$fgetmActiveSyncs(this.this$0).remove(this);
            BLASTSyncEngine.m9739$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mOnTimeout);
            if (BLASTSyncEngine.m9738$$Nest$fgetmActiveSyncs(this.this$0).size() == 0) goto L21;
        L30:
            int i2 = BLASTSyncEngine.m9740$$Nest$fgetmOnIdleListeners(this.this$0).size() - 1;
        L31:
            if (i2 < 0) goto L40;
            if (BLASTSyncEngine.m9738$$Nest$fgetmActiveSyncs(this.this$0).size() > 0) goto L36;
            ((Runnable) BLASTSyncEngine.m9740$$Nest$fgetmOnIdleListeners(this.this$0).get(i2)).run();
            i2 = i2 - 1;
            goto L31
        L36:
            return;
        L40:
            return;
        L21:
            if (BLASTSyncEngine.m9741$$Nest$fgetmPendingSyncSets(this.this$0).isEmpty() == true) goto L30;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L25;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, 4174320302463990554L, 0, null);
        L25:
            final PendingSyncSet pt = (PendingSyncSet) BLASTSyncEngine.m9741$$Nest$fgetmPendingSyncSets(this.this$0).remove(0);
            PendingSyncSet.m9746$$Nest$fgetmStartSync(pt).run();
            if (BLASTSyncEngine.m9738$$Nest$fgetmActiveSyncs(this.this$0).size() == 0) goto L29;
            BLASTSyncEngine.m9739$$Nest$fgetmHandler(this.this$0).post(new BLASTSyncEngine$SyncGroup$$ExternalSyntheticLambda1(this, pt));
            goto L30
        L29:
            throw new IllegalStateException("Pending Sync Set didn't start a sync.");
        }

        private static /* synthetic */ void lambda$finishNow$1(C1CommitCallback callback) {
            callback.onCommitted(new SurfaceControl.Transaction());
        }

        private /* synthetic */ void lambda$finishNow$2(PendingSyncSet pt) {
            WindowManagerGlobalLock r0 = BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            PendingSyncSet.m9745$$Nest$fgetmApplySync(pt).run();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private boolean setReady(boolean ready) {
            if (this.mReady != ready) goto L7;
            return false;
        L7:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L9;
            long protoLogParam0 = this.mSyncId;
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, 6310906192788668020L, 13, new Object[]{Long.valueOf(protoLogParam0), Boolean.valueOf(ready)});
        L9:
            this.mReady = ready;
            if (ready == false) goto L12;
            BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mWindowPlacerLocked.requestTraversal();
        L12:
            return true;
        }

        private void addToSync(WindowContainer wc) {
            if (this.mRootMembers.contains(wc) == false) goto L6;
            return;
        L6:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L8;
            long protoLogParam0 = this.mSyncId;
            String protoLogParam1 = String.valueOf(wc);
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, -476337038362199951L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
        L8:
            SyncGroup dependency = wc.getSyncGroup();
            if (dependency == null) goto L29;
            if (dependency == this) goto L29;
            if (dependency.isIgnoring(wc) == true) goto L29;
            boolean isDependencyActive = BLASTSyncEngine.m9738$$Nest$fgetmActiveSyncs(this.this$0).contains(dependency);
            Slog.w(BLASTSyncEngine.TAG, "SyncGroup " + this.mSyncId + " conflicts with " + dependency.mSyncId + ": Making " + this.mSyncId + " depend on " + dependency.mSyncId + " is active :" + isDependencyActive);
            if (this.mDependencies.contains(dependency) == false) goto L17;
        L30:
            wc.prepareSync();
            if (wc.mSyncState != 0) goto L36;
            if (wc.mSyncGroup == null) goto L36;
            Slog.w(BLASTSyncEngine.TAG, "addToSync: unset SyncGroup " + wc.mSyncGroup.mSyncId + " for non-sync " + wc);
            wc.mSyncGroup = null;
        L36:
            if (BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mAnimator.mPendingState != 1) goto L41;
            if (wc.mSyncState == 0) goto L41;
            BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mAnimator.mPendingState = 2;
        L41:
            if (this.mReady == false) goto L44;
            BLASTSyncEngine.m9743$$Nest$fgetmWm(this.this$0).mWindowPlacerLocked.requestTraversal();
            return;
        L44:
            return;
        L17:
            if (dependency.dependsOn(this) == true) goto L24;
            if (isDependencyActive == false) goto L24;
            if (this.mDependencies != NO_DEPENDENCIES) goto L23;
            this.mDependencies = new ArrayList();
        L23:
            this.mDependencies.add(dependency);
        L24:
            Slog.w(BLASTSyncEngine.TAG, " Detected dependency cycle between " + this.mSyncId + " and " + dependency.mSyncId + ": Moving " + wc + " to " + this.mSyncId);
            if (wc.mSyncGroup != null) goto L27;
            wc.setSyncGroup(this);
            goto L30
        L27:
            wc.mSyncGroup.mRootMembers.remove(wc);
            this.mRootMembers.add(wc);
            wc.mSyncGroup = this;
        L29:
            this.mRootMembers.add(wc);
            wc.setSyncGroup(this);
            goto L30
        }

        private boolean dependsOn(SyncGroup group) {
            if (this.mDependencies.isEmpty() == false) goto L5;
            return false;
        L5:
            ArrayList<SyncGroup> fringe = BLASTSyncEngine.m9742$$Nest$fgetmTmpFringe(this.this$0);
            fringe.clear();
            fringe.add(this);
            int head = 0;
        L7:
            if (head >= fringe.size()) goto L21;
            SyncGroup next = fringe.get(head);
            if (next == group) goto L10;
            int i = 0;
        L14:
            if (i >= next.mDependencies.size()) goto L20;
            if (fringe.contains(next.mDependencies.get(i)) == true) goto L19;
            fringe.add(next.mDependencies.get(i));
        L19:
            i = i + 1;
            goto L14
        L20:
            head = head + 1;
            goto L7
        L10:
            fringe.clear();
            return true;
        L21:
            fringe.clear();
            return false;
        }

        void onCancelSync(WindowContainer wc) {
            this.mRootMembers.remove(wc);
        }

        private void onTimeout() {
            if (BLASTSyncEngine.m9738$$Nest$fgetmActiveSyncs(this.this$0).contains(this) == true) goto L5;
            return;
        L5:
            boolean allFinished = true;
            int i = this.mRootMembers.size();
        L6:
            i = i - 1;
            if (i < 0) goto L12;
            WindowContainer<?> wc = this.mRootMembers.valueAt(i);
            if (wc.isSyncFinished(this) == true) goto L6;
            allFinished = false;
            Slog.i(BLASTSyncEngine.TAG, "Unfinished container: " + wc);
            wc.forAllActivities(new BLASTSyncEngine$SyncGroup$$ExternalSyntheticLambda3());
            goto L6
        L12:
            int i2 = this.mDependencies.size() - 1;
        L13:
            if (i2 < 0) goto L16;
            allFinished = false;
            Slog.i(BLASTSyncEngine.TAG, "Unfinished dependency: " + this.mDependencies.get(i2).mSyncId);
            i2 = i2 + (-1);
            goto L13
        L16:
            if (allFinished == true) goto L18;
        L20:
            finishNow();
            BLASTSyncEngine.m9744$$Nest$mremoveFromDependencies(this.this$0, this);
            return;
        L18:
            if (this.mReady == true) goto L20;
            Slog.w(BLASTSyncEngine.TAG, "Sync group " + this.mSyncId + " timed-out because not ready. If you see this, please file a bug.");
            this.mListener.onReadyTimeout();
            goto L20
        }

        private static /* synthetic */ void lambda$onTimeout$4(ActivityRecord a) {
            if (a.isVisibleRequested() == false) goto L12;
            if (a.isRelaunching() == false) goto L8;
            Slog.i(BLASTSyncEngine.TAG, "  " + a + " is relaunching");
        L8:
            if (a.isAttached() == true) goto L10;
            Slog.i(BLASTSyncEngine.TAG, "  " + a + " not attached");
        L10:
            a.forAllWindows(new BLASTSyncEngine$SyncGroup$$ExternalSyntheticLambda4(), true);
            return;
        L12:
            if (a.mDisplayContent != null) goto L14;
            return;
        L14:
            if (a.mDisplayContent.mUnknownAppVisibilityController.allResolved() == true) goto L19;
            Slog.i(BLASTSyncEngine.TAG, "  UnknownAppVisibility: " + a.mDisplayContent.mUnknownAppVisibilityController.getDebugMessage());
            return;
        }

        private static /* synthetic */ void lambda$onTimeout$3(WindowState w) {
            Slog.i(BLASTSyncEngine.TAG, "  " + w + " " + w.mWinAnimator.drawStateToString());
        }
    }

    interface TransactionReadyListener {
        void onTransactionReady(int r1, SurfaceControl.Transaction r2);

        default void onTransactionCommitted() {
        }

        default void onTransactionCommitTimeout() {
        }

        default void onReadyTimeout() {
        }

        default void onReadyTraceStart(String name, int id) {
            Trace.asyncTraceBegin(32, name, id);
        }

        default void onReadyTraceEnd(String name, int id) {
            Trace.asyncTraceEnd(32, name, id);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveSyncs, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m9738$$Nest$fgetmActiveSyncs(BLASTSyncEngine r0) {
        return r0.mActiveSyncs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9739$$Nest$fgetmHandler(BLASTSyncEngine r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOnIdleListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m9740$$Nest$fgetmOnIdleListeners(BLASTSyncEngine r0) {
        return r0.mOnIdleListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingSyncSets, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m9741$$Nest$fgetmPendingSyncSets(BLASTSyncEngine r0) {
        return r0.mPendingSyncSets;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTmpFringe, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m9742$$Nest$fgetmTmpFringe(BLASTSyncEngine r0) {
        return r0.mTmpFringe;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWm, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m9743$$Nest$fgetmWm(BLASTSyncEngine r0) {
        return r0.mWm;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveFromDependencies, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9744$$Nest$mremoveFromDependencies(BLASTSyncEngine r0, SyncGroup r1) {
        r0.removeFromDependencies(r1);
    }

    BLASTSyncEngine(WindowManagerService wms) {
        this(wms, wms.mH);
    }

    BLASTSyncEngine(WindowManagerService wms, Handler mainHandler) {
        this.mNextSyncId = 0;
        this.mActiveSyncs = new ArrayList();
        this.mPendingSyncSets = new ArrayList();
        this.mOnIdleListeners = new ArrayList();
        this.mTmpFinishQueue = new ArrayList();
        this.mTmpFringe = new ArrayList();
        this.mWm = wms;
        this.mHandler = mainHandler;
    }

    SyncGroup prepareSyncSet(TransactionReadyListener listener, String name) {
        int r3 = this.mNextSyncId;
        this.mNextSyncId = r3 + 1;
        return new SyncGroup(this, listener, r3, name, null);
    }

    int startSyncSet(TransactionReadyListener listener, long timeoutMs, String name, boolean parallel) {
        SyncGroup s = prepareSyncSet(listener, name);
        startSyncSet(s, timeoutMs, parallel);
        return s.mSyncId;
    }

    void startSyncSet(SyncGroup s) {
        startSyncSet(s, 5000, false);
    }

    void startSyncSet(SyncGroup s, long timeoutMs, boolean parallel) {
        if (this.mActiveSyncs.size() <= 0) goto L5;
        boolean alreadyRunning = true;
    L6:
        if (parallel == true) goto L9;
        if (alreadyRunning == false) goto L9;
        Slog.e(TAG, "SyncGroup " + s.mSyncId + ": Started when there is other active SyncGroup");
    L9:
        this.mActiveSyncs.add(s);
        s.mIgnoreIndirectMembers = parallel;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L17;
        long protoLogParam0 = s.mSyncId;
        if (parallel == false) goto L15;
        if (alreadyRunning == false) goto L15;
        String r4 = "(in parallel) ";
    L16:
        String protoLogParam1 = String.valueOf(r4);
        String protoLogParam2 = String.valueOf(s.mListener);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, -2978812352001196863L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1, protoLogParam2});
    L15:
        r4 = "";
    L17:
        scheduleTimeout(s, timeoutMs);
        return;
    L5:
        alreadyRunning = false;
        goto L6
    }

    SyncGroup getSyncSet(int id) {
        int i = 0;
    L4:
        if (i >= this.mActiveSyncs.size()) goto L10;
        if (this.mActiveSyncs.get(i).mSyncId == id) goto L9;
        i = i + 1;
        goto L4
    L9:
        return this.mActiveSyncs.get(i);
    L10:
        return null;
    }

    boolean hasActiveSync() {
        if (this.mActiveSyncs.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void scheduleTimeout(SyncGroup s, long timeoutMs) {
        this.mHandler.postDelayed(s.mOnTimeout, timeoutMs);
    }

    void addToSyncSet(int id, WindowContainer wc) {
        SyncGroup.m9752$$Nest$maddToSync(getSyncGroup(id), wc);
    }

    void setSyncMethod(int id, int method) {
        SyncGroup syncGroup = getSyncGroup(id);
        if (syncGroup.mRootMembers.isEmpty() == false) goto L7;
        syncGroup.mSyncMethod = method;
        return;
    L7:
        throw new IllegalStateException("Not allow to change sync method after adding group member, id=" + id);
    }

    boolean setReady(int id, boolean ready) {
        return SyncGroup.m9754$$Nest$msetReady(getSyncGroup(id), ready);
    }

    void setReady(int id) {
        setReady(id, true);
    }

    boolean isReady(int id) {
        return getSyncGroup(id).mReady;
    }

    void abort(int id) {
        SyncGroup group = getSyncGroup(id);
        SyncGroup.m9753$$Nest$mfinishNow(group);
        removeFromDependencies(group);
    }

    private SyncGroup getSyncGroup(int id) {
        SyncGroup syncGroup = getSyncSet(id);
        if (syncGroup == null) goto L6;
        return syncGroup;
    L6:
        throw new IllegalStateException("SyncGroup is not started yet id=" + id);
    }

    private void removeFromDependencies(SyncGroup group) {
        boolean anyChange = false;
        int i = 0;
    L4:
        if (i >= this.mActiveSyncs.size()) goto L14;
        SyncGroup active = this.mActiveSyncs.get(i);
        if (active.mDependencies.remove(group) == false) goto L12;
        if (active.mDependencies.isEmpty() == false) goto L12;
        anyChange = true;
    L12:
        i = i + 1;
        goto L4
    L14:
        if (anyChange == true) goto L16;
        return;
    L16:
        this.mWm.mWindowPlacerLocked.requestTraversal();
    }

    void onSurfacePlacement() {
        if (this.mActiveSyncs.isEmpty() == false) goto L5;
        return;
    L5:
        this.mTmpFinishQueue.addAll(this.mActiveSyncs);
        int visitBounds = ((this.mActiveSyncs.size() + 1) * this.mActiveSyncs.size()) / 2;
    L7:
        if (this.mTmpFinishQueue.isEmpty() == true) goto L30;
        if (visitBounds > 0) goto L10;
        Slog.e(TAG, "Trying to finish more syncs than theoretically possible. This should never happen. Most likely a dependency cycle wasn't detected.");
    L10:
        visitBounds = visitBounds - 1;
        SyncGroup group = this.mTmpFinishQueue.remove(0);
        int grpIdx = this.mActiveSyncs.indexOf(group);
        if (grpIdx < 0) goto L7;
        if (SyncGroup.m9755$$Nest$mtryFinish(group) == false) goto L7;
        int insertAt = 0;
        int i = 0;
    L18:
        if (i >= this.mActiveSyncs.size()) goto L7;
        SyncGroup active = this.mActiveSyncs.get(i);
        if (active.mDependencies.remove(group) == false) goto L28;
        if (i >= grpIdx) goto L28;
        if (active.mDependencies.isEmpty() == false) goto L28;
        this.mTmpFinishQueue.add(insertAt, this.mActiveSyncs.get(i));
        insertAt = insertAt + 1;
    L28:
        i = i + 1;
        goto L18
    }

    void tryFinishForTest(int syncId) {
        SyncGroup.m9755$$Nest$mtryFinish(getSyncSet(syncId));
    }

    void queueSyncSet(Runnable startSync, Runnable applySync) {
        PendingSyncSet pt = new PendingSyncSet(null);
        PendingSyncSet.m9748$$Nest$fputmStartSync(pt, startSync);
        PendingSyncSet.m9747$$Nest$fputmApplySync(pt, applySync);
        this.mPendingSyncSets.add(pt);
    }

    boolean hasPendingSyncSets() {
        return !this.mPendingSyncSets.isEmpty();
    }

    void addOnIdleListener(Runnable onIdleListener) {
        this.mOnIdleListeners.add(onIdleListener);
    }
}
