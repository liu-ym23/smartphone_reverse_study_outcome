package com.android.server.wm;

import android.app.ActivityManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArraySet;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
class RunningTasks implements Consumer<Task> {
    static final int FLAG_ALLOWED = 2;
    static final int FLAG_CROSS_USERS = 4;
    static final int FLAG_FILTER_ONLY_VISIBLE_RECENTS = 1;
    static final int FLAG_KEEP_INTENT_EXTRA = 8;
    private boolean mAllowed;
    private int mCallingUid;
    private boolean mCrossUser;
    private boolean mFilterOnlyVisibleRecents;
    private boolean mKeepIntentExtra;
    private ArraySet<Integer> mProfileIds;
    private RecentTasks mRecentTasks;
    private final ArrayList<Task> mTmpFocusedTasks;
    private final ArrayList<Task> mTmpInvisibleTasks;
    private final ArrayList<Task> mTmpSortedTasks;
    private final ArrayList<Task> mTmpVisibleTasks;
    private int mUserId;

    public static /* synthetic */ void $r8$lambda$MfBca7mzpEqQjGaOD89UUs0nLyk(RunningTasks r0, DisplayContent r1) {
        r0.lambda$getTasks$0(r1);
    }

    RunningTasks() {
        this.mTmpSortedTasks = new ArrayList();
        this.mTmpVisibleTasks = new ArrayList();
        this.mTmpInvisibleTasks = new ArrayList();
        this.mTmpFocusedTasks = new ArrayList();
    }

    @Override // java.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(Task r1) {
        accept2(r1);
    }

    void getTasks(int maxNum, List<ActivityManager.RunningTaskInfo> list, int flags, RecentTasks recentTasks, WindowContainer<?> root, int callingUid, ArraySet<Integer> profileIds) {
        if (maxNum > 0) goto L5;
        return;
    L5:
        this.mCallingUid = callingUid;
        this.mUserId = UserHandle.getUserId(callingUid);
        boolean rootContainsFocusedTask = false;
        if ((flags & 4) != 4) goto L8;
        boolean r4 = true;
    L9:
        this.mCrossUser = r4;
        this.mProfileIds = profileIds;
        if ((flags & 2) != 2) goto L12;
        boolean r5 = true;
    L13:
        this.mAllowed = r5;
        if ((flags & 1) != 1) goto L16;
        boolean r6 = true;
    L17:
        this.mFilterOnlyVisibleRecents = r6;
        this.mRecentTasks = recentTasks;
        if ((flags & 8) != 8) goto L20;
        boolean r8 = true;
    L21:
        this.mKeepIntentExtra = r8;
        if ((root instanceof RootWindowContainer) == false) goto L24;
        ((RootWindowContainer) root).forAllDisplays(new RunningTasks$$ExternalSyntheticLambda0(this));
    L40:
        int visibleTaskCount = this.mTmpVisibleTasks.size();
        int i = 0;
    L42:
        if (i >= this.mTmpFocusedTasks.size()) goto L48;
        Task focusedTask = this.mTmpFocusedTasks.get(i);
        boolean containsFocusedTask = this.mTmpVisibleTasks.remove(focusedTask);
        if (containsFocusedTask == false) goto L46;
        this.mTmpSortedTasks.add(focusedTask);
    L46:
        i = i + 1;
        goto L42
    L48:
        if (this.mTmpVisibleTasks.isEmpty() == true) goto L51;
        this.mTmpSortedTasks.addAll(this.mTmpVisibleTasks);
    L51:
        if (this.mTmpInvisibleTasks.isEmpty() == true) goto L53;
        this.mTmpSortedTasks.addAll(this.mTmpInvisibleTasks);
    L53:
        int size = Math.min(maxNum, this.mTmpSortedTasks.size());
        long now = SystemClock.elapsedRealtime();
        int i2 = 0;
    L54:
        if (i2 >= size) goto L60;
        Task task = this.mTmpSortedTasks.get(i2);
        if (i2 >= visibleTaskCount) goto L58;
        long visibleActiveTime = (((long) size) + now) - ((long) i2);
    L59:
        list.add(createRunningTaskInfo(task, visibleActiveTime));
        i2 = i2 + 1;
        goto L54
    L58:
        visibleActiveTime = -1;
        goto L59
    L60:
        this.mTmpFocusedTasks.clear();
        this.mTmpVisibleTasks.clear();
        this.mTmpInvisibleTasks.clear();
        this.mTmpSortedTasks.clear();
        return;
    L24:
        DisplayContent dc = root.getDisplayContent();
        Task focusedTask2 = null;
        if (dc != null) goto L27;
    L31:
        if (focusedTask2 != null) goto L33;
    L37:
        if (rootContainsFocusedTask == false) goto L39;
        this.mTmpFocusedTasks.add(focusedTask2);
    L39:
        processTaskInWindowContainer(root);
        goto L40
    L33:
        if (focusedTask2.isDescendantOf(root) == false) goto L37;
        rootContainsFocusedTask = true;
        goto L37
    L27:
        if (dc.mFocusedApp == null) goto L31;
        focusedTask2 = dc.mFocusedApp.getTask();
        goto L31
    L20:
        r8 = false;
        goto L21
    L16:
        r6 = false;
        goto L17
    L12:
        r5 = false;
        goto L13
    L8:
        r4 = false;
        goto L9
    }

    private /* synthetic */ void lambda$getTasks$0(DisplayContent dc) {
        if (dc.mFocusedApp == null) goto L5;
        Task focusedTask = dc.mFocusedApp.getTask();
    L6:
        if (focusedTask == null) goto L8;
        this.mTmpFocusedTasks.add(focusedTask);
    L8:
        processTaskInWindowContainer(dc);
        return;
    L5:
        focusedTask = null;
        goto L6
    }

    private void processTaskInWindowContainer(WindowContainer wc) {
        wc.forAllLeafTasks(this, true);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Task task) {
        if (task.getTopNonFinishingActivity() != null) goto L6;
        return;
    L6:
        if (task.effectiveUid == this.mCallingUid) goto L18;
        if (task.mUserId == this.mUserId) goto L15;
        if (this.mCrossUser == true) goto L15;
        if (this.mProfileIds.contains(Integer.valueOf(task.mUserId)) == true) goto L15;
        return;
    L15:
        if (this.mAllowed == true) goto L18;
        return;
    L18:
        if (this.mFilterOnlyVisibleRecents == false) goto L27;
        if (task.getActivityType() == 2) goto L27;
        if (task.getActivityType() == 3) goto L27;
        if (this.mRecentTasks.isVisibleRecentTask(task) == true) goto L27;
        return;
    L27:
        if (task.isVisibleRequested() == false) goto L29;
        this.mTmpVisibleTasks.add(task);
        return;
    L29:
        this.mTmpInvisibleTasks.add(task);
    }

    private ActivityManager.RunningTaskInfo createRunningTaskInfo(Task task, long visibleActiveTime) {
        ActivityManager.RunningTaskInfo rti = new ActivityManager.RunningTaskInfo();
        task.fillTaskInfo(rti, !this.mKeepIntentExtra);
        if (visibleActiveTime <= 0) goto L5;
        rti.lastActiveTime = visibleActiveTime;
    L5:
        rti.id = rti.taskId;
        if (this.mAllowed == true) goto L8;
        Task.trimIneffectiveInfo(task, rti);
    L8:
        return rti;
    }
}
