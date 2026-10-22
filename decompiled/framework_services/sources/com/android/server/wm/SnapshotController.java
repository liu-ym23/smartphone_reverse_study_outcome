package com.android.server.wm;

import android.hardware.HardwareBuffer;
import android.os.Trace;
import android.util.ArrayMap;
import android.window.TaskSnapshot;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
class SnapshotController {
    final ActivitySnapshotController mActivitySnapshotController;
    private final ArrayList<WeakReference<HardwareBuffer>> mObsoleteSnapshots;
    private final WindowManagerService mService;
    private final SnapshotPersistQueue mSnapshotPersistQueue;
    final TaskSnapshotController mTaskSnapshotController;

    private static class ActivitiesByTask {
        final ArrayMap<Task, OpenCloseActivities> mActivitiesMap;

        static class OpenCloseActivities {
            final ArrayList<ActivityRecord> mCloseActivities;
            final ArrayList<ActivityRecord> mOpenActivities;

            OpenCloseActivities() {
                this.mOpenActivities = new ArrayList();
                this.mCloseActivities = new ArrayList();
            }

            void add(ActivityRecord ar) {
                if (ar.isVisibleRequested() == false) goto L5;
                this.mOpenActivities.add(ar);
                return;
            L5:
                this.mCloseActivities.add(ar);
            }

            boolean allOpensOptInOnBackInvoked() {
                if (this.mOpenActivities.isEmpty() == false) goto L5;
                return false;
            L5:
                int i = this.mOpenActivities.size() - 1;
            L6:
                if (i < 0) goto L12;
                if (this.mOpenActivities.get(i).mOptInOnBackInvoked == false) goto L9;
                i = i - 1;
                goto L6
            L9:
                return false;
            L12:
                return true;
            }

            void recordSnapshot(ActivitySnapshotController controller) {
                if (allOpensOptInOnBackInvoked() == true) goto L5;
                return;
            L5:
                if (this.mCloseActivities.isEmpty() == true) goto L10;
                controller.recordSnapshot(this.mCloseActivities);
                return;
            }
        }

        /* synthetic */ ActivitiesByTask(SnapshotControllerIA r1) {
            this();
        }

        private ActivitiesByTask() {
            this.mActivitiesMap = new ArrayMap();
        }

        void put(ActivityRecord ar) {
            OpenCloseActivities activities = this.mActivitiesMap.get(ar.getTask());
            if (activities != null) goto L5;
            activities = new OpenCloseActivities();
            this.mActivitiesMap.put(ar.getTask(), activities);
        L5:
            activities.add(ar);
        }

        void recordSnapshot(ActivitySnapshotController controller) {
            int i = this.mActivitiesMap.size() - 1;
        L3:
            if (i < 0) goto L6;
            OpenCloseActivities pair = this.mActivitiesMap.valueAt(i);
            pair.recordSnapshot(controller);
            i = i - 1;
            goto L3
        }
    }

    public static /* synthetic */ void $r8$lambda$TV29UzMtxQKVnhnWpRUevvp_os4(SnapshotController r0, HardwareBuffer r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$_ibbxI7ud-kkaypzOJwL5fxr1fg, reason: not valid java name */
    public static /* synthetic */ void m10139$r8$lambda$_ibbxI7udkkaypzOJwL5fxr1fg(SnapshotController r0, HardwareBuffer r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dn1W_cJ30WzQi63v-QztseHKt_Y, reason: not valid java name */
    public static /* synthetic */ boolean m10140$r8$lambda$dn1W_cJ30WzQi63vQztseHKt_Y(ActivityRecord r0) {
        return lambda$onTransitionFinish$2(r0);
    }

    SnapshotController(WindowManagerService wms) {
        this.mObsoleteSnapshots = new ArrayList();
        this.mService = wms;
        this.mSnapshotPersistQueue = new SnapshotPersistQueue();
        this.mTaskSnapshotController = new TaskSnapshotController(wms, this.mSnapshotPersistQueue);
        this.mActivitySnapshotController = new ActivitySnapshotController(wms, this.mSnapshotPersistQueue);
        Consumer<HardwareBuffer> releaser = new SnapshotController$$ExternalSyntheticLambda0(this);
        this.mTaskSnapshotController.setSnapshotReleaser(releaser);
        this.mActivitySnapshotController.setSnapshotReleaser(releaser);
    }

    private /* synthetic */ void lambda$new$1(final HardwareBuffer hb) {
        this.mService.mH.post(new SnapshotController$$ExternalSyntheticLambda2(this, hb));
    }

    private /* synthetic */ void lambda$new$0(HardwareBuffer hb) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (hb.isClosed() == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        if (this.mService.mAtmService.getTransitionController().inTransition() == false) goto L14;
        this.mObsoleteSnapshots.add(new WeakReference(hb));     // Catch: Throwable -> L9
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        hb.close();     // Catch: Throwable -> L9
        goto L15
    }

    void systemReady() {
        this.mSnapshotPersistQueue.systemReady();
    }

    void setPause(boolean paused) {
        this.mSnapshotPersistQueue.setPaused(paused);
    }

    void onAppRemoved(ActivityRecord activity) {
        this.mTaskSnapshotController.onAppRemoved(activity);
        this.mActivitySnapshotController.onAppRemoved(activity);
    }

    void onAppDied(ActivityRecord activity) {
        this.mTaskSnapshotController.onAppDied(activity);
        this.mActivitySnapshotController.onAppDied(activity);
    }

    void notifyAppVisibilityChanged(ActivityRecord appWindowToken, boolean visible) {
        this.mActivitySnapshotController.notifyAppVisibilityChanged(appWindowToken, visible);
    }

    void onTransactionReady(int type, ArrayList<Transition.ChangeInfo> changeInfos) {
        boolean isTransitionOpen = isTransitionOpen(type);
        boolean isTransitionClose = isTransitionClose(type);
        if (isTransitionOpen == true) goto L8;
        if (isTransitionClose == true) goto L8;
        if (type >= 1000) goto L8;
        return;
    L8:
        ActivitiesByTask activityTargets = null;
        int i = changeInfos.size() - 1;
    L9:
        if (i < 0) goto L42;
        Transition.ChangeInfo info = changeInfos.get(i);
        if (info.mWindowingMode == 2) goto L40;
        if (info.mContainer.isActivityTypeHome() == true) goto L40;
        Task task = info.mContainer.asTask();
        if (task != null) goto L19;
    L23:
        if (isTransitionClose == true) goto L40;
        if (info.mContainer.asActivityRecord() == null) goto L28;
    L29:
        TaskFragment tf = info.mContainer.asTaskFragment();
        if (tf == null) goto L32;
        ActivityRecord ar = tf.getTopMostActivity();
    L34:
        if (ar == null) goto L40;
        if (ar.getTask().isVisibleRequested() == false) goto L40;
        if (activityTargets != null) goto L39;
        activityTargets = new ActivitiesByTask(null);
    L39:
        activityTargets.put(ar);
        goto L40
    L32:
        ar = info.mContainer.asActivityRecord();
        goto L34
    L28:
        if (info.mContainer.asTaskFragment() == null) goto L40;
    L19:
        if (task.mCreatedByOrganizer == true) goto L23;
        if (task.isVisibleRequested() == true) goto L23;
        this.mTaskSnapshotController.recordSnapshot(task, info);
    L40:
        i = i - 1;
        goto L9
    L42:
        if (activityTargets == null) goto L53;
        activityTargets.recordSnapshot(this.mActivitySnapshotController);
        return;
    }

    void onTransitionFinish(int type, ArrayList<Transition.ChangeInfo> changeInfos) {
        boolean isTransitionOpen = isTransitionOpen(type);
        boolean isTransitionClose = isTransitionClose(type);
        if (isTransitionOpen == true) goto L10;
        if (isTransitionClose == true) goto L10;
        if (type >= 1000) goto L10;
    L11:
        closeObsoleteSnapshots();
        return;
    L10:
        if (changeInfos.isEmpty() == true) goto L11;
        long r6 = 32;
        Trace.traceBegin(32, "SnapshotController_analysis");
        this.mActivitySnapshotController.beginSnapshotProcess();
        ArrayList<WindowContainer> windows = new ArrayList();
        int i = changeInfos.size() - 1;
    L14:
        if (i < 0) goto L24;
        WindowContainer wc = changeInfos.get(i).mContainer;
        if (wc.asTask() == null) goto L18;
    L22:
        windows.add(wc);
    L23:
        i = i - 1;
        goto L14
    L18:
        if (wc.asTaskFragment() != null) goto L22;
        if (wc.asActivityRecord() != null) goto L22;
    L24:
        this.mActivitySnapshotController.handleTransitionFinish(windows);
        this.mActivitySnapshotController.endSnapshotProcess();
        int i2 = changeInfos.size() - 1;
    L25:
        if (i2 < 0) goto L42;
        WindowContainer wc2 = changeInfos.get(i2).mContainer;
        Task task = wc2.asTask();
        if (task == null) goto L41;
        if (wc2.isVisibleRequested() == false) goto L41;
        if (task.inPinnedWindowingMode() == true) goto L41;
        TaskSnapshot snapshot = this.mTaskSnapshotController.getSnapshot(task.mTaskId, false);
        if (snapshot == null) goto L41;
        ActivityRecord baseActivity = task.getActivity(new SnapshotController$$ExternalSyntheticLambda1(), false);
        if (baseActivity == null) goto L37;
        int baseActivityUid = baseActivity.getUid();
    L38:
        this.mTaskSnapshotController.removeAndDeleteSnapshot(task.mTaskId, task.mUserId, baseActivityUid);
        goto L41
    L37:
        baseActivityUid = task.effectiveUid;
    L41:
        i2 = i2 - 1;
        r6 = r6;
        goto L25
    L42:
        closeObsoleteSnapshots();
        Trace.traceEnd(r6);
    }

    private static /* synthetic */ boolean lambda$onTransitionFinish$2(ActivityRecord r) {
        return !r.finishing;
    }

    private void closeObsoleteSnapshots() {
        if (this.mObsoleteSnapshots.isEmpty() == false) goto L5;
        return;
    L5:
        int i = this.mObsoleteSnapshots.size() - 1;
    L6:
        if (i < 0) goto L14;
        HardwareBuffer hb = this.mObsoleteSnapshots.remove(i).get();
        if (hb == null) goto L12;
        if (hb.isClosed() == true) goto L12;
        hb.close();
    L12:
        i = i - 1;
        goto L6
    }

    private static boolean isTransitionOpen(int type) {
        if (type != 1) goto L5;
        return true;
    L5:
        if (type != 3) goto L7;
        return true;
    L7:
        if (type == 13) goto L13;
        return false;
    L13:
        return true;
    }

    private static boolean isTransitionClose(int type) {
        if (type != 2) goto L5;
    L10:
        return true;
    L5:
        if (type == 4) goto L10;
        if (type == 14) goto L10;
        return false;
    }

    void dump(PrintWriter pw, String prefix) {
        this.mTaskSnapshotController.dump(pw, prefix);
        this.mActivitySnapshotController.dump(pw, prefix);
        this.mSnapshotPersistQueue.dump(pw, prefix);
    }
}
