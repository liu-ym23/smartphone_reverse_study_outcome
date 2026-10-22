package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.WindowConfiguration;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.util.Log;
import android.util.Slog;
import android.util.Utils;
import android.view.SurfaceControl;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.internal.util.function.pooled.PooledPredicate;
import com.android.server.pm.UserManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
final class TaskDisplayArea extends DisplayArea<WindowContainer> {
    private ActivityTaskManagerService mAtmService;
    private int mBackgroundColor;
    private final boolean mCanHostHomeTask;
    private int mColorLayerCounter;
    final boolean mCreatedByOrganizer;
    DisplayContent mDisplayContent;
    private final IExtTaskDisplayArea mExt;
    Task mLastFocusedRootTask;
    private int mLastLeafTaskToFrontId;
    Task mLaunchAdjacentFlagRootTask;
    private final ArrayList<LaunchRootTaskDef> mLaunchRootTasks;
    Task mPreferredTopFocusableRootTask;
    private boolean mRemoved;
    private Task mRootHomeTask;
    private Task mRootPinnedTask;
    private RootWindowContainer mRootWindowContainer;
    private boolean mShouldKeepNoTask;
    private final Configuration mTempConfiguration;
    private final ArrayList<WindowContainer> mTmpAlwaysOnTopChildren;
    private final ArrayList<WindowContainer> mTmpHomeChildren;
    private final ArrayList<WindowContainer> mTmpNormalChildren;

    private static class LaunchRootTaskDef {
        int[] activityTypes;
        Task task;
        int[] windowingModes;

        /* synthetic */ LaunchRootTaskDef(TaskDisplayAreaIA r1) {
            this();
        }

        private LaunchRootTaskDef() {
        }

        boolean contains(int windowingMode, int activityType) {
            if (ArrayUtils.contains(this.windowingModes, windowingMode) == true) goto L5;
        L7:
            return false;
        L5:
            if (ArrayUtils.contains(this.activityTypes, activityType) == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$72qorrfHn_Lg-AJq3TtoGTVWC54, reason: not valid java name */
    public static /* synthetic */ boolean m10253$r8$lambda$72qorrfHn_LgAJq3TtoGTVWC54(Task r0, Task[] r1, Task r2) {
        return lambda$getLaunchRootTask$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$9T11aR3wjd7tX7gC_s6Y_EGgask(ActivityRecord r0, int[] r1, Task r2) {
        lambda$pauseBackTasks$6(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$CLaWFtI74ZzGqW_PSm8-Og7jDEc, reason: not valid java name */
    public static /* synthetic */ void m10254$r8$lambda$CLaWFtI74ZzGqW_PSm8Og7jDEc(int[] r0, Task r1) {
        lambda$getRootTaskCount$7(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$UO54rDaQ1J_Js1LvzH8layvsInU(int r0, int r1, Task r2) {
        return lambda$getRootTask$0(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$ZXgxsw9mli5PfIGm7IWFKgkRiK4(ActivityRecord r0, int r1) {
        return isHomeActivityForUser(r0, r1);
    }

    public static /* synthetic */ Integer $r8$lambda$a3w54gVM3Bjf6W2TQdlqDSe6OwY(TaskDisplayArea r0, int r1, TaskDisplayArea r2, Integer r3) {
        return r0.lambda$getOrientation$2(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$dqKKny9we9eL7qVJs6kyMh3ZVKs(Task r0, Task[] r1, Task r2) {
        return lambda$getLaunchRootTask$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$fHpf1BNZfV01s-YAg5gHIHSMH4U, reason: not valid java name */
    public static /* synthetic */ void m10255$r8$lambda$fHpf1BNZfV01sYAg5gHIHSMH4U(ActivityRecord r0, boolean r1, Task r2) {
        lambda$ensureActivitiesVisible$9(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gcmpsYeV0eiB9psTJi7zsZeEQmU(ArrayList r0, Task r1) {
        lambda$getVisibleTasks$1(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$m11i_DrtPHpy2oENHmantrUQ9Sc(Task r0) {
        return lambda$getBottomMostVisibleRootTask$8(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$oJRI4W8RTIWAT-_vjzmGTIzvSr8, reason: not valid java name */
    public static /* synthetic */ boolean m10256$r8$lambda$oJRI4W8RTIWAT_vjzmGTIzvSr8(Task[] r0, Task r1) {
        return lambda$getLaunchRootTask$3(r0, r1);
    }

    TaskDisplayArea(DisplayContent displayContent, WindowManagerService service, String name, int displayAreaFeature) {
        this(displayContent, service, name, displayAreaFeature, false, true);
    }

    TaskDisplayArea(DisplayContent displayContent, WindowManagerService service, String name, int displayAreaFeature, boolean createdByOrganizer) {
        this(displayContent, service, name, displayAreaFeature, createdByOrganizer, true);
    }

    TaskDisplayArea(DisplayContent displayContent, WindowManagerService service, String name, int displayAreaFeature, boolean createdByOrganizer, boolean canHostHomeTask) {
        super(service, DisplayArea.Type.ANY, name, displayAreaFeature);
        this.mBackgroundColor = 0;
        this.mColorLayerCounter = 0;
        this.mTmpAlwaysOnTopChildren = new ArrayList();
        this.mTmpNormalChildren = new ArrayList();
        this.mTmpHomeChildren = new ArrayList();
        this.mLaunchRootTasks = new ArrayList();
        this.mTempConfiguration = new Configuration();
        this.mExt = (IExtTaskDisplayArea) ExtImplFactory.getImpl(IExtTaskDisplayArea.class, new Object[]{this});
        this.mDisplayContent = displayContent;
        this.mRootWindowContainer = service.mRoot;
        this.mAtmService = service.mAtmService;
        this.mCreatedByOrganizer = createdByOrganizer;
        this.mCanHostHomeTask = canHostHomeTask;
    }

    Task getRootTask(final int windowingMode, final int activityType) {
        if (activityType == 2) goto L5;
        if (windowingMode != 2) goto L10;
        return this.mRootPinnedTask;
    L10:
        return getRootTask(new TaskDisplayArea$$ExternalSyntheticLambda1(activityType, windowingMode));
    L5:
        return this.mRootHomeTask;
    }

    private static /* synthetic */ boolean lambda$getRootTask$0(int activityType, int windowingMode, Task rootTask) {
        if (activityType != 0) goto L8;
        if (windowingMode != rootTask.getWindowingMode()) goto L8;
        return true;
    L8:
        return rootTask.isCompatible(windowingMode, activityType);
    }

    Task getTopRootTask() {
        return getRootTask(WindowContainer.alwaysTruePredicate());
    }

    Task getRootHomeTask() {
        return this.mRootHomeTask;
    }

    Task getRootPinnedTask() {
        return this.mRootPinnedTask;
    }

    ArrayList<Task> getVisibleTasks() {
        final ArrayList<Task> visibleTasks = new ArrayList();
        forAllTasks(new TaskDisplayArea$$ExternalSyntheticLambda0(visibleTasks));
        return visibleTasks;
    }

    private static /* synthetic */ void lambda$getVisibleTasks$1(ArrayList visibleTasks, Task task) {
        if (task.isLeafTask() == true) goto L5;
        return;
    L5:
        if (task.isVisible() == false) goto L9;
        visibleTasks.add(task);
        return;
    }

    void onRootTaskWindowingModeChanged(Task rootTask) {
        removeRootTaskReferenceIfNeeded(rootTask);
        addRootTaskReferenceIfNeeded(rootTask);
        if (rootTask == this.mRootPinnedTask) goto L5;
        return;
    L5:
        if (getTopRootTask() == rootTask) goto L9;
        positionChildAt(Integer.MAX_VALUE, rootTask, false);
        return;
    }

    void addRootTaskReferenceIfNeeded(Task rootTask) {
        if (rootTask.isActivityTypeHome() == false) goto L13;
        if (this.mRootHomeTask != null) goto L7;
        this.mRootHomeTask = rootTask;
        goto L13
    L7:
        if (rootTask.isDescendantOf(this.mRootHomeTask) == true) goto L13;
        throw new IllegalArgumentException("addRootTaskReferenceIfNeeded: root home task=" + this.mRootHomeTask + " already exist on display=" + this + " rootTask=" + rootTask);
    L13:
        if (rootTask.isRootTask() == true) goto L15;
        return;
    L15:
        int windowingMode = rootTask.getWindowingMode();
        if (windowingMode == 2) goto L18;
        return;
    L18:
        if (this.mRootPinnedTask != null) goto L21;
        this.mRootPinnedTask = rootTask;
        return;
    L21:
        throw new IllegalArgumentException("addRootTaskReferenceIfNeeded: root pinned task=" + this.mRootPinnedTask + " already exist on display=" + this + " rootTask=" + rootTask);
    }

    void removeRootTaskReferenceIfNeeded(Task rootTask) {
        if (rootTask != this.mRootHomeTask) goto L6;
        this.mRootHomeTask = null;
        return;
    L6:
        if (rootTask != this.mRootPinnedTask) goto L10;
        this.mRootPinnedTask = null;
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void setInitialSurfaceControlProperties(SurfaceControl.Builder b) {
        b.setEffectLayer();
        super.setInitialSurfaceControlProperties(b);
    }

    @Override // com.android.server.wm.WindowContainer
    void addChild(WindowContainer child, int position) {
        if (child.asTaskDisplayArea() == null) goto L9;
        if (WindowManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L7;
        Slog.d("WindowManager", "Set TaskDisplayArea=" + child + " on taskDisplayArea=" + this);
    L7:
        super.addChild(child, position);
        return;
    L9:
        if (child.asTask() == null) goto L13;
        addChildTask(child.asTask(), position);
        return;
    L13:
        throw new IllegalArgumentException("TaskDisplayArea can only add Task and TaskDisplayArea, but found " + child);
    }

    private void addChildTask(Task task, int position) {
        if (WindowManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L5;
        Slog.d("WindowManager", "Set task=" + task + " on taskDisplayArea=" + this);
    L5:
        addRootTaskReferenceIfNeeded(task);
        super.addChild(task, findPositionForRootTask(position, task, true));
        if (this.mPreferredTopFocusableRootTask != null) goto L8;
    L12:
        this.mAtmService.mTaskSupervisor.updateTopResumedActivityIfNeeded("addChildTask");
        this.mAtmService.updateSleepIfNeededLocked();
        return;
    L8:
        if (task.isFocusable() == false) goto L12;
        if (this.mPreferredTopFocusableRootTask.compareTo(task) >= 0) goto L12;
        this.mPreferredTopFocusableRootTask = null;
        goto L12
    }

    @Override // com.android.server.wm.WindowContainer
    protected void removeChild(WindowContainer child) {
        if (child.asTaskDisplayArea() == null) goto L6;
        super.removeChild(child);
        return;
    L6:
        if (child.asTask() == null) goto L10;
        removeChildTask(child.asTask());
        return;
    L10:
        throw new IllegalArgumentException("TaskDisplayArea can only remove Task and TaskDisplayArea, but found " + child);
    }

    private void removeChildTask(Task task) {
        if (this.mChildren.contains(task) == true) goto L6;
        Slog.w("WindowManager", "removeChildTask: taskId=" + task.mTaskId + " displayId=" + task.getDisplayId() + " name=" + task.getName() + " is NOT a child of TaskDisplayArea=" + getName() + " (likely double-remove race after last-child cascade). Skip to keep detach idempotent.");
        return;
    L6:
        super.removeChild(task);
        onRootTaskRemoved(task);
        this.mAtmService.updateSleepIfNeededLocked();
        removeRootTaskReferenceIfNeeded(task);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isOnTop() {
        return true;
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    void positionChildAt(int position, WindowContainer child, boolean includingParents) {
        if (child.asTaskDisplayArea() == null) goto L6;
        super.positionChildAt(position, child, includingParents);
        return;
    L6:
        if (child.asTask() == null) goto L10;
        positionChildTaskAt(position, child.asTask(), includingParents);
        return;
    L10:
        throw new IllegalArgumentException("TaskDisplayArea can only position Task and TaskDisplayArea, but found " + child);
    }

    private void positionChildTaskAt(int position, Task child, boolean includingParents) {
        if (Log.isLoggable("WindowManager", 3) == false) goto L5;
        Slog.d("WindowManager", "positionChildTaskAt of " + child + " at postition " + position + "the child display id is " + child.getDisplayId() + " the displayarea id is " + getDisplayId(), new RuntimeException());
    L5:
        boolean isTopFocusableTask = true;
        if (position < (getChildCount() - 1)) goto L8;
        boolean moveToTop = true;
    L9:
        if (position > 0) goto L11;
        boolean moveToBottom = true;
    L12:
        int oldPosition = this.mChildren.indexOf(child);
        if (child.isAlwaysOnTop() == false) goto L18;
        if (moveToTop == true) goto L18;
        Slog.w("WindowManager", "Ignoring move of always-on-top root task=" + this + " to bottom");
        super.positionChildAt(oldPosition, child, false);
        return;
    L18:
        if (this.mDisplayContent.isTrusted() == false) goto L22;
        if (this.mDisplayContent.mDontMoveToTop == true) goto L22;
    L24:
        int targetPosition = findPositionForRootTask(position, child, false);
        super.positionChildAt(targetPosition, child, false);
        if (includingParents == true) goto L27;
    L35:
        child.updateTaskMovement(moveToTop, moveToBottom, targetPosition);
        if (moveToTop == true) goto L38;
    L42:
        isTopFocusableTask = false;
    L43:
        Task r3 = null;
        if (isTopFocusableTask == false) goto L50;
        if (child.shouldBeVisible(null) == false) goto L48;
        r3 = child;
    L48:
        this.mPreferredTopFocusableRootTask = r3;
    L52:
        this.mAtmService.mTaskSupervisor.updateTopResumedActivityIfNeeded("positionChildTaskAt");
        return;
    L50:
        if (this.mPreferredTopFocusableRootTask != child) goto L52;
        this.mPreferredTopFocusableRootTask = null;
        goto L52
    L38:
        if (child == this.mRootPinnedTask) goto L42;
        if (child.isTopActivityFocusable() == false) goto L42;
    L27:
        if (getParent() == null) goto L35;
        if (moveToTop == true) goto L30;
        if (moveToBottom == false) goto L35;
    L30:
        WindowContainer r6 = getParent();
        if (moveToTop == false) goto L33;
        int r7 = Integer.MAX_VALUE;
    L34:
        r6.positionChildAt(r7, this, true);
        goto L35
    L33:
        r7 = Integer.MIN_VALUE;
    L22:
        if (getParent().isOnTop() == true) goto L24;
        includingParents = false;
        goto L24
    L11:
        moveToBottom = false;
        goto L12
    L8:
        moveToTop = false;
        goto L9
    }

    void onLeafTaskRemoved(int taskId) {
        if (this.mLastLeafTaskToFrontId != taskId) goto L6;
        this.mLastLeafTaskToFrontId = -1;
        return;
    }

    void onTaskMoved(Task t, boolean toTop, boolean toBottom) {
        if (toBottom == true) goto L4;
    L6:
        Task topLeafTask = t.getTopLeafTask();
        onLeafTaskMoved(topLeafTask, toTop, toBottom);
        return;
    L4:
        if (t.isLeafTask() == true) goto L6;
    }

    void onLeafTaskMoved(Task t, boolean toTop, boolean toBottom) {
        if (toBottom == false) goto L4;
        this.mAtmService.getTaskChangeNotificationController().notifyTaskMovedToBack(t.getTaskInfo());
    L4:
        if (toTop == true) goto L12;
        if (t.mTaskId != this.mLastLeafTaskToFrontId) goto L19;
        this.mLastLeafTaskToFrontId = -1;
        ActivityRecord topMost = getTopNonFinishingActivity();
        if (topMost == null) goto L20;
        this.mAtmService.getTaskChangeNotificationController().notifyTaskMovedToFront(topMost.getTask().getTaskInfo());
        return;
    L20:
        return;
    L19:
        return;
    L12:
        if (t.mTaskId != this.mLastLeafTaskToFrontId) goto L14;
        return;
    L14:
        if (t.topRunningActivityLocked() == null) goto L21;
        this.mLastLeafTaskToFrontId = t.mTaskId;
        EventLogTags.writeWmTaskToFront(t.mUserId, t.mTaskId, getDisplayId());
        this.mAtmService.getTaskChangeNotificationController().notifyTaskMovedToFront(t.getTaskInfo());
        return;
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    void onChildPositionChanged(WindowContainer child) {
        super.onChildPositionChanged(child);
        this.mRootWindowContainer.invalidateTaskLayers();
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    boolean forAllTaskDisplayAreas(Predicate<TaskDisplayArea> callback, boolean traverseTopToBottom) {
        if (traverseTopToBottom == false) goto L13;
        if (super.forAllTaskDisplayAreas(callback, traverseTopToBottom) == false) goto L7;
        return true;
    L7:
        if (callback.test(this) == false) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (callback.test(this) == false) goto L15;
        return true;
    L15:
        if (super.forAllTaskDisplayAreas(callback, traverseTopToBottom) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    void forAllTaskDisplayAreas(Consumer<TaskDisplayArea> callback, boolean traverseTopToBottom) {
        if (traverseTopToBottom == false) goto L4;
        super.forAllTaskDisplayAreas(callback, traverseTopToBottom);
        callback.accept(this);
        return;
    L4:
        callback.accept(this);
        super.forAllTaskDisplayAreas(callback, traverseTopToBottom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    <R> R reduceOnAllTaskDisplayAreas(BiFunction<TaskDisplayArea, R, R> r3, R r4, boolean r5) {
        if (r5 == false) goto L6;
        return (R) r3.apply(this, super.reduceOnAllTaskDisplayAreas(r3, r4, r5));
    L6:
        return (R) super.reduceOnAllTaskDisplayAreas(r3, r3.apply(this, r4), r5);
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    <R> R getItemFromTaskDisplayAreas(Function<TaskDisplayArea, R> r3, boolean r4) {
        if (r4 == false) goto L8;
        R r0 = (R) super.getItemFromTaskDisplayAreas(r3, r4);
        if (r0 == null) goto L7;
        return r0;
    L7:
        return r3.apply(this);
    L8:
        R r1 = r3.apply(this);
        if (r1 == null) goto L12;
        return r1;
    L12:
        return (R) super.getItemFromTaskDisplayAreas(r3, r4);
    }

    private int getPriority(WindowContainer child) {
        TaskDisplayArea tda = child.asTaskDisplayArea();
        if (tda != null) goto L5;
        Task rootTask = child.asTask();
        if (this.mWmService.mAssistantOnTopOfDream == false) goto L13;
        if (rootTask.isActivityTypeAssistant() == false) goto L13;
        return 4;
    L13:
        if (rootTask.isActivityTypeDream() == false) goto L17;
        return 3;
    L17:
        if (rootTask.inPinnedWindowingMode() == false) goto L21;
        return 2;
    L21:
        if (rootTask.isAlwaysOnTop() == false) goto L24;
        return 1;
    L24:
        return 0;
    L5:
        return tda.getPriority(tda.getTopChild());
    }

    private int findMinPositionForRootTask(Task rootTask) {
        int minPosition = Integer.MIN_VALUE;
        int i = 0;
    L4:
        if (i >= this.mChildren.size()) goto L9;
        if (getPriority((WindowContainer) this.mChildren.get(i)) >= getPriority(rootTask)) goto L9;
        minPosition = i;
        i = i + 1;
    L9:
        if (rootTask.isAlwaysOnTop() == false) goto L16;
        int currentIndex = this.mChildren.indexOf(rootTask);
        if (currentIndex > minPosition) goto L13;
        return minPosition;
    L13:
        return currentIndex;
    L16:
        return minPosition;
    }

    private int findMaxPositionForRootTask(Task rootTask) {
        int i = this.mChildren.size() - 1;
    L3:
        boolean sameRootTask = false;
        if (i < 0) goto L14;
        WindowContainer curr = (WindowContainer) this.mChildren.get(i);
        if (curr != rootTask) goto L9;
        sameRootTask = true;
    L9:
        if (getPriority(curr) > getPriority(rootTask)) goto L12;
        if (sameRootTask == true) goto L12;
        return i;
    L12:
        i = i - 1;
        goto L3
    L14:
        return 0;
    }

    private int findPositionForRootTask(int requestedPosition, Task rootTask, boolean adding) {
        int maxPosition = findMaxPositionForRootTask(rootTask);
        int minPosition = findMinPositionForRootTask(rootTask);
        if (requestedPosition != Integer.MAX_VALUE) goto L6;
        requestedPosition = this.mChildren.size();
    L8:
        int targetPosition = requestedPosition;
        int targetPosition2 = Math.max(Math.min(targetPosition, maxPosition), minPosition);
        int prevPosition = this.mChildren.indexOf(rootTask);
        if (targetPosition2 == requestedPosition) goto L14;
        if (adding == true) goto L13;
        if (targetPosition2 < prevPosition) goto L13;
        return targetPosition2;
    L13:
        return targetPosition2 + 1;
    L14:
        return targetPosition2;
    L6:
        if (requestedPosition != Integer.MIN_VALUE) goto L8;
        requestedPosition = 0;
        goto L8
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    int getOrientation(final int candidate) {
        int orientation = super.getOrientation(candidate);
        if (canSpecifyOrientation(orientation) == true) goto L7;
        this.mLastOrientationSource = null;
        return ((Integer) reduceOnAllTaskDisplayAreas(new TaskDisplayArea$$ExternalSyntheticLambda7(this, candidate), -2)).intValue();
    L7:
        if (orientation == (-2)) goto L15;
        if (orientation == 3) goto L15;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L13;
        long protoLogParam0 = orientation;
        long protoLogParam1 = this.mDisplayContent.mDisplayId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 7378236902389922467L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});
    L13:
        return orientation;
    L15:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L18;
        long protoLogParam2 = this.mDisplayContent.getLastOrientation();
        long protoLogParam3 = this.mDisplayContent.mDisplayId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 2005499548343677845L, 5, new Object[]{Long.valueOf(protoLogParam2), Long.valueOf(protoLogParam3)});
    L18:
        return this.mDisplayContent.getLastOrientation();
    }

    private /* synthetic */ Integer lambda$getOrientation$2(int candidate, TaskDisplayArea taskDisplayArea, Integer taskOrientation) {
        if (taskDisplayArea != this) goto L4;
    L8:
        return taskOrientation;
    L4:
        if (taskOrientation.intValue() != (-2)) goto L8;
        return Integer.valueOf(taskDisplayArea.getOrientation(candidate));
    }

    @Override // com.android.server.wm.WindowContainer
    void assignChildLayers(SurfaceControl.Transaction t) {
        assignRootTaskOrdering(t);
        int i = 0;
    L4:
        if (i >= this.mChildren.size()) goto L7;
        ((WindowContainer) this.mChildren.get(i)).assignChildLayers(t);
        i = i + 1;
        goto L4
    }

    void assignRootTaskOrdering(SurfaceControl.Transaction t) {
        if (getParent() != null) goto L5;
        return;
    L5:
        this.mTmpAlwaysOnTopChildren.clear();
        this.mTmpHomeChildren.clear();
        this.mTmpNormalChildren.clear();
        int i = 0;
    L7:
        if (i >= this.mChildren.size()) goto L28;
        WindowContainer child = (WindowContainer) this.mChildren.get(i);
        TaskDisplayArea childTda = child.asTaskDisplayArea();
        if (childTda == null) goto L20;
        Task childTdaTopRootTask = childTda.getTopRootTask();
        if (childTdaTopRootTask != null) goto L14;
        this.mTmpNormalChildren.add(childTda);
    L27:
        i = i + 1;
        goto L7
    L14:
        if (childTdaTopRootTask.isAlwaysOnTop() == false) goto L17;
        this.mTmpAlwaysOnTopChildren.add(childTda);
        goto L27
    L17:
        if (childTdaTopRootTask.isActivityTypeHome() == false) goto L19;
        this.mTmpHomeChildren.add(childTda);
        goto L27
    L19:
        this.mTmpNormalChildren.add(childTda);
        goto L27
    L20:
        Task childTask = child.asTask();
        if (childTask.isAlwaysOnTop() == false) goto L24;
        this.mTmpAlwaysOnTopChildren.add(childTask);
        goto L27
    L24:
        if (childTask.isActivityTypeHome() == false) goto L26;
        this.mTmpHomeChildren.add(childTask);
        goto L27
    L26:
        this.mTmpNormalChildren.add(childTask);
        goto L27
    L28:
        int layer = adjustRootTaskLayer(t, this.mTmpHomeChildren, 0);
        int layer2 = adjustRootTaskLayer(t, this.mTmpNormalChildren, layer);
        if (Features.FEAT_QUICK_WIN == false) goto L31;
        layer2 = layer2 + 10;
    L31:
        adjustRootTaskLayer(t, this.mTmpAlwaysOnTopChildren, layer2);
    }

    private int adjustRootTaskLayer(SurfaceControl.Transaction t, ArrayList<WindowContainer> children, int startLayer) {
        int childCount = children.size();
        int i = 0;
    L3:
        if (i >= childCount) goto L6;
        WindowContainer child = children.get(i);
        child.assignLayer(t, startLayer);
        i = i + 1;
        startLayer = startLayer + 1;
        goto L3
    L6:
        return startLayer;
    }

    void setBackgroundColor(int colorInt) {
        setBackgroundColor(colorInt, false);
    }

    void setBackgroundColor(int colorInt, boolean restore) {
        this.mBackgroundColor = colorInt;
        Color color = Color.valueOf(colorInt);
        if (restore == true) goto L6;
        this.mColorLayerCounter++;
    L6:
        if (this.mSurfaceControl == null) goto L9;
        getPendingTransaction().setColor(this.mSurfaceControl, new float[]{color.red(), color.green(), color.blue()});
        scheduleAnimation();
        return;
    }

    void clearBackgroundColor() {
        this.mColorLayerCounter--;
        if (this.mColorLayerCounter == 0) goto L5;
        return;
    L5:
        if (this.mSurfaceControl == null) goto L9;
        getPendingTransaction().unsetColor(this.mSurfaceControl);
        scheduleAnimation();
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void migrateToNewSurfaceControl(SurfaceControl.Transaction t) {
        super.migrateToNewSurfaceControl(t);
        if (this.mColorLayerCounter <= 0) goto L5;
        setBackgroundColor(this.mBackgroundColor, true);
    L5:
        reassignLayer(t);
        scheduleAnimation();
    }

    void onRootTaskRemoved(Task rootTask) {
        if (ActivityTaskManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L6;
        Slog.v("ActivityTaskManager", "onRootTaskRemoved: detaching " + rootTask + " from displayId=" + this.mDisplayContent.mDisplayId);
    L6:
        if (this.mPreferredTopFocusableRootTask != rootTask) goto L9;
        this.mPreferredTopFocusableRootTask = null;
    L9:
        if (this.mLaunchAdjacentFlagRootTask != rootTask) goto L11;
        this.mLaunchAdjacentFlagRootTask = null;
    L11:
        this.mDisplayContent.releaseSelfIfNeeded();
    }

    void positionTaskBehindHome(Task task) {
        Task home = getOrCreateRootHomeTask();
        Task r1 = null;
        if (home == null) goto L5;
        WindowContainer homeParent = home.getParent();
    L6:
        if (homeParent == null) goto L8;
        r1 = homeParent.asTask();
    L8:
        Task homeParentTask = r1;
        if (homeParentTask != null) goto L15;
        if (task.getParent() != this) goto L13;
        positionChildAt(Integer.MIN_VALUE, task, false);
        return;
    L13:
        task.reparent(this, false);
        return;
    L15:
        if (homeParentTask != task.getParent()) goto L17;
        homeParentTask.positionChildAtBottom(task);
        return;
    L17:
        task.reparent(homeParentTask, false, 2, false, false, "positionTaskBehindHome");
        return;
    L5:
        homeParent = null;
        goto L6
    }

    Task getOrCreateRootTask(int windowingMode, int activityType, boolean onTop) {
        return getOrCreateRootTask(windowingMode, activityType, onTop, null, null, null, 0);
    }

    Task getOrCreateRootTask(int windowingMode, int activityType, boolean onTop, Task candidateTask, Task sourceTask, ActivityOptions options, int launchFlags) {
        if (windowingMode != 0) goto L5;
        int resolvedWindowingMode = getWindowingMode();
    L7:
        if (DisplayContent.alwaysCreateRootTask(resolvedWindowingMode, activityType) == true) goto L12;
        Task rootTask = getRootTask(resolvedWindowingMode, activityType);
        if (rootTask == null) goto L52;
        return rootTask;
    L52:
        return new Task.Builder(this.mAtmService).setWindowingMode(windowingMode).setActivityType(activityType).setOnTop(onTop).setParent(this).setSourceTask(sourceTask).setActivityOptions(options).setLaunchFlags(launchFlags).build();
    L12:
        if (candidateTask == null) goto L52;
        if (onTop == false) goto L15;
        int r3 = Integer.MAX_VALUE;
    L16:
        int position = r3;
        Task launchParentTask = getLaunchRootTask(resolvedWindowingMode, activityType, options, sourceTask, launchFlags, candidateTask);
        if (launchParentTask == null) goto L25;
        if (candidateTask.getParent() != null) goto L22;
        launchParentTask.addChild(candidateTask, position);
    L42:
        if (windowingMode == 0) goto L49;
        if (candidateTask.isRootTask() == false) goto L49;
        if (candidateTask.getWindowingMode() == windowingMode) goto L49;
        candidateTask.mTransitionController.collect(candidateTask);
        candidateTask.setRootTaskWindowingMode(windowingMode);
    L49:
        return candidateTask.getRootTask();
    L22:
        if (candidateTask.getParent() == launchParentTask) goto L42;
        candidateTask.reparent(launchParentTask, position);
        goto L42
    L25:
        if (candidateTask.getDisplayArea() != this) goto L29;
        if (candidateTask.getRootTask().mReparentLeafTaskIfRelaunch == false) goto L42;
    L29:
        if (candidateTask.getParent() != null) goto L32;
        addChild(candidateTask, position);
        goto L42
    L32:
        if (candidateTask.getRootTask().mReparentLeafTaskIfRelaunch == false) goto L37;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_TASKS_enabled[0] == false) goto L37;
        long protoLogParam0 = candidateTask.mTaskId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_TASKS, 8967038468291507129L, 13, new Object[]{Long.valueOf(protoLogParam0), Boolean.valueOf(onTop)});
    L37:
        if (candidateTask.getDisplayId() != getDisplayId()) goto L39;
    L41:
        candidateTask.reparent(this, onTop);
        goto L42
    L39:
        if (this.mTransitionController.getCollectingTransition() == null) goto L41;
        this.mTransitionController.getCollectingTransition().getExt().addDisplayChangedContainer();
        goto L41
    L15:
        r3 = Integer.MIN_VALUE;
        goto L16
    L5:
        resolvedWindowingMode = windowingMode;
        goto L7
    }

    Task getOrCreateRootTask(ActivityRecord r, ActivityOptions options, Task candidateTask, Task sourceTask, LaunchParamsController.LaunchParams launchParams, int launchFlags, int activityType, boolean onTop) {
        int windowingMode = 0;
        if (launchParams == null) goto L5;
        windowingMode = launchParams.mWindowingMode;
    L8:
        return getOrCreateRootTask(validateWindowingMode(windowingMode, r, candidateTask), activityType, onTop, candidateTask, sourceTask, options, launchFlags);
    L5:
        if (options == null) goto L8;
        windowingMode = options.getLaunchWindowingMode();
        goto L8
    }

    int getNextRootTaskId() {
        return this.mAtmService.mTaskSupervisor.getNextTaskIdForUser();
    }

    Task createRootTask(int windowingMode, int activityType, boolean onTop) {
        return createRootTask(windowingMode, activityType, onTop, null);
    }

    Task createRootTask(int windowingMode, int activityType, boolean onTop, ActivityOptions opts) {
        return new Task.Builder(this.mAtmService).setWindowingMode(windowingMode).setActivityType(activityType).setParent(this).setOnTop(onTop).setActivityOptions(opts).build();
    }

    void setLaunchRootTask(Task rootTask, int[] windowingModes, int[] activityTypes) {
        if (rootTask.mCreatedByOrganizer == false) goto L15;
        LaunchRootTaskDef def = getLaunchRootTaskDef(rootTask);
        if (def == null) goto L7;
        this.mLaunchRootTasks.remove(def);
    L8:
        def.activityTypes = activityTypes;
        def.windowingModes = windowingModes;
        if (ArrayUtils.isEmpty(windowingModes) == true) goto L11;
    L12:
        this.mLaunchRootTasks.add(def);
        return;
    L11:
        if (ArrayUtils.isEmpty(activityTypes) == false) goto L12;
        return;
    L7:
        def = new LaunchRootTaskDef(null);
        def.task = rootTask;
        goto L8
    L15:
        throw new IllegalArgumentException("Can't set not mCreatedByOrganizer as launch root tr=" + rootTask);
    }

    void removeLaunchRootTask(Task rootTask) {
        LaunchRootTaskDef def = getLaunchRootTaskDef(rootTask);
        if (def == null) goto L6;
        this.mLaunchRootTasks.remove(def);
        return;
    }

    void setLaunchAdjacentFlagRootTask(Task adjacentFlagRootTask) {
        if (adjacentFlagRootTask != null) goto L4;
    L12:
        this.mLaunchAdjacentFlagRootTask = adjacentFlagRootTask;
        return;
    L4:
        if (adjacentFlagRootTask.mCreatedByOrganizer == false) goto L11;
        if (adjacentFlagRootTask.hasAdjacentTaskFragment() == true) goto L12;
        throw new UnsupportedOperationException("Can't set non-adjacent root as launch adjacent flag root tr=" + adjacentFlagRootTask);
    L11:
        throw new IllegalArgumentException("Can't set not mCreatedByOrganizer as launch adjacent flag root tr=" + adjacentFlagRootTask);
    }

    private LaunchRootTaskDef getLaunchRootTaskDef(Task rootTask) {
        int i = this.mLaunchRootTasks.size() - 1;
    L3:
        if (i < 0) goto L11;
        if (this.mLaunchRootTasks.get(i).task.mTaskId == rootTask.mTaskId) goto L7;
        i = i - 1;
        goto L3
    L7:
        LaunchRootTaskDef def = this.mLaunchRootTasks.get(i);
        return def;
    L11:
        return null;
    }

    Task getLaunchRootTask(int windowingMode, int activityType, ActivityOptions options, Task sourceTask, int launchFlags) {
        return getLaunchRootTask(windowingMode, activityType, options, sourceTask, launchFlags, null);
    }

    Task getLaunchRootTask(int windowingMode, int activityType, ActivityOptions options, final Task sourceTask, int launchFlags, final Task candidateTask) {
        if (options == null) goto L11;
        Task launchRootTask = Task.fromWindowContainerToken(options.getLaunchRootTask());
        if (launchRootTask == null) goto L11;
        if (launchRootTask.mCreatedByOrganizer == false) goto L11;
        Slog.i("WindowManager", "Using launch root task from activity options: taskId=" + launchRootTask.mTaskId);
        return launchRootTask;
    L11:
        if ((launchFlags & 4096) != 0) goto L13;
    L30:
        int i = this.mLaunchRootTasks.size() - 1;
    L31:
        if (i < 0) goto L46;
        if (this.mLaunchRootTasks.get(i).contains(windowingMode, activityType) == true) goto L34;
        i = i - 1;
        goto L31
    L34:
        Task launchRootTask2 = this.mLaunchRootTasks.get(i).task;
        if (launchRootTask2 == null) goto L43;
        if (sourceTask == null) goto L43;
        final Task[] adjacentRootTask = new Task[1];
        launchRootTask2.forOtherAdjacentTasks(new TaskDisplayArea$$ExternalSyntheticLambda4(sourceTask, adjacentRootTask));
        if (adjacentRootTask[0] == null) goto L42;
        return adjacentRootTask[0];
    L42:
        return launchRootTask2;
    L43:
        return launchRootTask2;
    L46:
        if (sourceTask == null) goto L61;
        if (candidateTask != null) goto L49;
    L50:
        Task taskWithAdjacent = sourceTask.getTaskWithAdjacent();
        if (taskWithAdjacent == null) goto L67;
        if (candidateTask == null) goto L54;
        final Task[] adjacentRootTask2 = new Task[1];
        sourceTask.forOtherAdjacentTasks(new TaskDisplayArea$$ExternalSyntheticLambda5(candidateTask, adjacentRootTask2));
        if (adjacentRootTask2[0] == null) goto L60;
        return adjacentRootTask2[0];
    L60:
        return sourceTask.getCreatedByOrganizerTask();
    L54:
        return sourceTask.getCreatedByOrganizerTask();
    L67:
        return null;
    L49:
        if (candidateTask.getWindowingMode() != 2) goto L50;
        return null;
    L61:
        return null;
    L13:
        if (this.mLaunchAdjacentFlagRootTask == null) goto L30;
        final Task[] tmpTask = new Task[1];
        this.mLaunchAdjacentFlagRootTask.forOtherAdjacentTasks(new TaskDisplayArea$$ExternalSyntheticLambda3(tmpTask));
        Task launchAdjacentRootAdjacentTask = tmpTask[0];
        if (sourceTask == null) goto L20;
        if (sourceTask != candidateTask) goto L18;
    L19:
        Slog.w("WindowManager", "Ignoring LAUNCH_ADJACENT because adjacent source is gone.");
        goto L30
    L18:
        if (sourceTask.topRunningActivity() == null) goto L19;
    L20:
        if (sourceTask == null) goto L28;
        if (launchAdjacentRootAdjacentTask == null) goto L28;
        if (sourceTask != this.mLaunchAdjacentFlagRootTask) goto L25;
    L26:
        Slog.i("WindowManager", "Using adjacent-to specified launch-adjacent task: taskId=" + launchAdjacentRootAdjacentTask.mTaskId);
        return launchAdjacentRootAdjacentTask;
    L25:
        if (sourceTask.isDescendantOf(this.mLaunchAdjacentFlagRootTask) == true) goto L26;
    L28:
        Slog.i("WindowManager", "Using specified launch-adjacent task: taskId=" + this.mLaunchAdjacentFlagRootTask.mTaskId);
        return this.mLaunchAdjacentFlagRootTask;
    }

    private static /* synthetic */ boolean lambda$getLaunchRootTask$3(Task[] tmpTask, Task task) {
        tmpTask[0] = task;
        return true;
    }

    private static /* synthetic */ boolean lambda$getLaunchRootTask$4(Task sourceTask, Task[] adjacentRootTask, Task task) {
        if (sourceTask != task) goto L5;
    L8:
        adjacentRootTask[0] = task;
        return true;
    L5:
        if (sourceTask.isDescendantOf(task) == true) goto L8;
        return false;
    }

    private static /* synthetic */ boolean lambda$getLaunchRootTask$5(Task candidateTask, Task[] adjacentRootTask, Task task) {
        if (candidateTask != task) goto L5;
    L8:
        adjacentRootTask[0] = task;
        return true;
    L5:
        if (candidateTask.isDescendantOf(task) == true) goto L8;
        return false;
    }

    Task getFocusedRootTask() {
        if ("PREFETCH_APP".equals(this.mDisplayContent.mDisplay.getName()) == false) goto L6;
        return null;
    L6:
        if (this.mPreferredTopFocusableRootTask != null) goto L8;
        int i = this.mChildren.size() - 1;
    L10:
        if (i < 0) goto L21;
        WindowContainer child = (WindowContainer) this.mChildren.get(i);
        if (child.asTaskDisplayArea() == null) goto L16;
        Task rootTask = child.asTaskDisplayArea().getFocusedRootTask();
        if (rootTask == null) goto L19;
        return rootTask;
    L19:
        i = i - 1;
        goto L10
    L16:
        Task rootTask2 = ((WindowContainer) this.mChildren.get(i)).asTask();
        if (rootTask2.isFocusableAndVisible() == false) goto L19;
        return rootTask2;
    L21:
        return null;
    L8:
        return this.mPreferredTopFocusableRootTask;
    }

    Task getNextFocusableRootTask(Task currentFocus, boolean ignoreCurrent) {
        if (currentFocus == null) goto L5;
        currentFocus.getWindowingMode();
    L5:
        int i = this.mChildren.size() - 1;
    L6:
        if (i < 0) goto L21;
        WindowContainer child = (WindowContainer) this.mChildren.get(i);
        if (child.asTaskDisplayArea() == null) goto L12;
        Task rootTask = child.asTaskDisplayArea().getNextFocusableRootTask(currentFocus, ignoreCurrent);
        if (rootTask == null) goto L18;
        return rootTask;
    L18:
        i = i - 1;
        goto L6
    L12:
        Task rootTask2 = ((WindowContainer) this.mChildren.get(i)).asTask();
        if (ignoreCurrent == false) goto L17;
        if (rootTask2 == currentFocus) goto L18;
    L17:
        if (rootTask2.isFocusableAndVisible() == false) goto L18;
        return rootTask2;
    L21:
        return null;
    }

    ActivityRecord getFocusedActivity() {
        Task focusedRootTask = getFocusedRootTask();
        if (focusedRootTask != null) goto L6;
        return null;
    L6:
        ActivityRecord resumedActivity = focusedRootTask.getTopResumedActivity();
        if (resumedActivity != null) goto L9;
    L10:
        ActivityRecord resumedActivity2 = focusedRootTask.getTopPausingActivity();
        if (resumedActivity2 == null) goto L15;
        if (resumedActivity2.app == null) goto L15;
        return resumedActivity2;
    L15:
        return focusedRootTask.topRunningActivity(true);
    L9:
        if (resumedActivity.app == null) goto L10;
        return resumedActivity;
    }

    Task getLastFocusedRootTask() {
        return this.mLastFocusedRootTask;
    }

    void updateLastFocusedRootTask(Task prevFocusedTask, String updateLastFocusedTaskReason) {
        if (updateLastFocusedTaskReason != null) goto L4;
        return;
    L4:
        Task currentFocusedTask = getFocusedRootTask();
        if (currentFocusedTask != prevFocusedTask) goto L8;
        return;
    L8:
        if (this.mDisplayContent.isSleeping() == false) goto L11;
        if (currentFocusedTask == null) goto L11;
        currentFocusedTask.clearLastPausedActivity();
    L11:
        this.mLastFocusedRootTask = prevFocusedTask;
        int r1 = this.mRootWindowContainer.mCurrentUser;
        int r2 = this.mDisplayContent.mDisplayId;
        int r3 = -1;
        if (currentFocusedTask != null) goto L14;
        int r4 = -1;
    L16:
        if (this.mLastFocusedRootTask == null) goto L19;
        r3 = this.mLastFocusedRootTask.getRootTaskId();
    L19:
        EventLogTags.writeWmFocusedRootTask(r1, r2, r4, r3, updateLastFocusedTaskReason);
        return;
    L14:
        r4 = currentFocusedTask.getRootTaskId();
        goto L16
    }

    boolean allResumedActivitiesComplete() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L15;
        WindowContainer child = (WindowContainer) this.mChildren.get(i);
        if (child.asTaskDisplayArea() != null) goto L7;
        ActivityRecord r = ((WindowContainer) this.mChildren.get(i)).asTask().getTopResumedActivity();
        if (r == null) goto L14;
        if (r.isState(ActivityRecord.State.RESUMED) == true) goto L14;
        return false;
    L14:
        i = i - 1;
        goto L3
    L7:
        if (child.asTaskDisplayArea().allResumedActivitiesComplete() == true) goto L14;
        return false;
    L15:
        Task currentFocusedRootTask = getFocusedRootTask();
        if (ActivityTaskManagerDebugConfig.DEBUG_ROOT_TASK == false) goto L18;
        Slog.d("ActivityTaskManager", "allResumedActivitiesComplete: currentFocusedRootTask changing from=" + this.mLastFocusedRootTask + " to=" + currentFocusedRootTask);
    L18:
        this.mLastFocusedRootTask = currentFocusedRootTask;
        return true;
    }

    boolean pauseBackTasks(final ActivityRecord resuming) {
        final int[] someActivityPaused = {0};
        forAllLeafTasks(new TaskDisplayArea$$ExternalSyntheticLambda9(resuming, someActivityPaused), true);
        if (someActivityPaused[0] > 0) goto L5;
        return false;
    L5:
        return true;
    }

    private static /* synthetic */ void lambda$pauseBackTasks$6(ActivityRecord resuming, int[] someActivityPaused, Task leafTask) {
        if (leafTask.pauseActivityIfNeeded(resuming, "pauseBackTasks") == false) goto L6;
        someActivityPaused[0] = someActivityPaused[0] + 1;
        return;
    }

    static boolean isWindowingModeSupported(int windowingMode, boolean supportsMultiWindow, boolean supportsFreeform, boolean supportsPip) {
        if (windowingMode == 0) goto L21;
        if (windowingMode == 1) goto L21;
        if (supportsMultiWindow == true) goto L10;
        return false;
    L10:
        if (windowingMode != 6) goto L12;
        return true;
    L12:
        if (supportsFreeform == false) goto L14;
    L16:
        if (supportsPip == false) goto L18;
    L20:
        return true;
    L18:
        if (windowingMode != 2) goto L20;
        return false;
    L14:
        if (windowingMode != 5) goto L16;
        return false;
    L21:
        return true;
    }

    int resolveWindowingMode(ActivityRecord r, ActivityOptions options, Task task) {
        if (options == null) goto L4;
        int windowingMode = options.getLaunchWindowingMode();
    L5:
        if (windowingMode != 0) goto L13;
        if (task == null) goto L8;
        windowingMode = task.getWindowingMode();
    L8:
        if (windowingMode != 0) goto L11;
        if (r == null) goto L11;
        windowingMode = r.getWindowingMode();
    L11:
        if (windowingMode != 0) goto L13;
        windowingMode = getWindowingMode();
    L13:
        int windowingMode2 = validateWindowingMode(windowingMode, r, task);
        if (windowingMode2 != 0) goto L18;
        return 1;
    L18:
        return windowingMode2;
    L4:
        windowingMode = 0;
        goto L5
    }

    boolean isValidWindowingMode(int windowingMode, ActivityRecord r, Task task) {
        boolean supportsMultiWindow = this.mAtmService.mSupportsMultiWindow;
        boolean supportsFreeform = this.mAtmService.mSupportsFreeformWindowManagement;
        boolean supportsPip = this.mAtmService.mSupportsPictureInPicture;
        if (supportsMultiWindow == false) goto L16;
        if (task == null) goto L14;
        supportsFreeform = task.supportsFreeformInDisplayArea(this);
        if (task.supportsMultiWindowInDisplayArea(this) == false) goto L8;
    L12:
        boolean r5 = true;
    L13:
        supportsMultiWindow = r5;
        goto L16
    L8:
        if (windowingMode != 2) goto L11;
        if (supportsPip == true) goto L12;
    L11:
        r5 = false;
        goto L13
    L14:
        if (r == null) goto L16;
        supportsFreeform = r.supportsFreeformInDisplayArea(this);
        supportsPip = r.supportsPictureInPicture();
        supportsMultiWindow = r.supportsMultiWindowInDisplayArea(this);
    L16:
        if (task != null) goto L18;
    L20:
        if (r != null) goto L22;
    L24:
        if (windowingMode == 0) goto L29;
        if (isWindowingModeSupported(windowingMode, supportsMultiWindow, supportsFreeform, supportsPip) == false) goto L29;
        return true;
    L29:
        return false;
    L22:
        if (Utils.isXtsPkg(r.packageName) == false) goto L24;
    L23:
        supportsFreeform = false;
        goto L24
    L18:
        if (Utils.isXtsPkg(task.getBasePackageName()) == true) goto L23;
        goto L20
    }

    int validateWindowingMode(int windowingMode, ActivityRecord r, Task task) {
        if (isValidWindowingMode(windowingMode, r, task) == true) goto L6;
        return 0;
    L6:
        return windowingMode;
    }

    boolean supportsNonResizableMultiWindow() {
        int configSupportsNonResizableMultiWindow = this.mAtmService.mSupportsNonResizableMultiWindow;
        if (this.mAtmService.mDevEnableNonResizableMultiWindow == true) goto L12;
        if (configSupportsNonResizableMultiWindow == 1) goto L12;
        if (configSupportsNonResizableMultiWindow != (-1)) goto L11;
        return false;
    L11:
        return isLargeEnoughForMultiWindow();
    L12:
        return true;
    }

    boolean supportsActivityMinWidthHeightMultiWindow(int minWidth, int minHeight, ActivityInfo activityInfo) {
        if (activityInfo != null) goto L5;
    L7:
        if (minWidth > 0) goto L10;
        if (minHeight > 0) goto L10;
        return true;
    L10:
        int configRespectsActivityMinWidthHeightMultiWindow = this.mAtmService.mRespectsActivityMinWidthHeightMultiWindow;
        if (configRespectsActivityMinWidthHeightMultiWindow != (-1)) goto L13;
        return true;
    L13:
        if (configRespectsActivityMinWidthHeightMultiWindow == 0) goto L15;
    L17:
        Configuration config = getConfiguration();
        int orientation = config.orientation;
        if (orientation != 2) goto L24;
        int maxSupportMinWidth = (int) ((this.mAtmService.mMinPercentageMultiWindowSupportWidth * config.screenWidthDp) * this.mDisplayContent.getDisplayMetrics().density);
        if (minWidth > maxSupportMinWidth) goto L23;
        return true;
    L23:
        return false;
    L24:
        int maxSupportMinHeight = (int) ((this.mAtmService.mMinPercentageMultiWindowSupportHeight * config.screenHeightDp) * this.mDisplayContent.getDisplayMetrics().density);
        if (minHeight > maxSupportMinHeight) goto L28;
        return true;
    L28:
        return false;
    L15:
        if (isLargeEnoughForMultiWindow() == false) goto L17;
        return true;
    L5:
        if (activityInfo.shouldCheckMinWidthHeightForMultiWindow() == true) goto L7;
        return true;
    }

    private boolean isLargeEnoughForMultiWindow() {
        if (getConfiguration().smallestScreenWidthDp < 600) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isTopRootTask(Task rootTask) {
        if (rootTask != getTopRootTask()) goto L5;
        return true;
    L5:
        return false;
    }

    ActivityRecord topRunningActivity() {
        return topRunningActivity(false);
    }

    ActivityRecord topRunningActivity(boolean considerKeyguardState) {
        ActivityRecord topRunning = null;
        Task focusedRootTask = getFocusedRootTask();
        if (focusedRootTask == null) goto L5;
        topRunning = focusedRootTask.topRunningActivity();
    L5:
        if (topRunning != null) goto L22;
        int i = this.mChildren.size() - 1;
    L7:
        if (i < 0) goto L22;
        WindowContainer child = (WindowContainer) this.mChildren.get(i);
        if (child.asTaskDisplayArea() == null) goto L13;
        topRunning = child.asTaskDisplayArea().topRunningActivity(considerKeyguardState);
        if (topRunning != null) goto L22;
    L21:
        i = i - 1;
        goto L7
    L13:
        Task rootTask = ((WindowContainer) this.mChildren.get(i)).asTask();
        if (rootTask == focusedRootTask) goto L21;
        if (rootTask.isTopActivityFocusable() == false) goto L21;
        topRunning = rootTask.topRunningActivity();
        if (topRunning == null) goto L21;
    L22:
        if (topRunning == null) goto L30;
        if (considerKeyguardState == false) goto L30;
        if (this.mRootWindowContainer.mTaskSupervisor.getKeyguardController().isKeyguardLocked(topRunning.getDisplayId()) == false) goto L30;
        if (topRunning.canShowWhenLocked() == true) goto L30;
        return null;
    L30:
        return topRunning;
    }

    protected int getRootTaskCount() {
        final int[] count = new int[1];
        forAllRootTasks(new TaskDisplayArea$$ExternalSyntheticLambda6(count));
        return count[0];
    }

    private static /* synthetic */ void lambda$getRootTaskCount$7(int[] count, Task task) {
        count[0] = count[0] + 1;
    }

    Task getOrCreateRootHomeTask() {
        return getOrCreateRootHomeTask(false);
    }

    Task getOrCreateRootHomeTask(boolean onTop) {
        Task homeTask = getRootHomeTask();
        if (homeTask == null) goto L5;
        return homeTask;
    L5:
        if (canHostHomeTask() == true) goto L7;
        return homeTask;
    L7:
        return createRootTask(0, 2, onTop);
    }

    Task getTopRootTaskInWindowingMode(int windowingMode) {
        if (Features.FEAT_QUICK_WIN == false) goto L9;
        if (windowingMode != 5) goto L9;
        return null;
    L9:
        return getRootTask(windowingMode, 0);
    }

    void moveHomeRootTaskToFront(String reason) {
        Task homeRootTask = getOrCreateRootHomeTask();
        if (homeRootTask == null) goto L6;
        homeRootTask.moveToFront(reason);
        return;
    }

    void moveHomeActivityToTop(String reason) {
        ActivityRecord top = getHomeActivity();
        if (top != null) goto L6;
        moveHomeRootTaskToFront(reason);
        return;
    L6:
        top.moveFocusableActivityToTop(reason);
    }

    ActivityRecord getHomeActivity() {
        return getHomeActivityForUser(this.mRootWindowContainer.mCurrentUser);
    }

    ActivityRecord getHomeActivityForUser(int userId) {
        Task rootHomeTask = getRootHomeTask();
        if (rootHomeTask != null) goto L6;
        return null;
    L6:
        PooledPredicate p = PooledLambda.obtainPredicate(new TaskDisplayArea$$ExternalSyntheticLambda2(), PooledLambda.__(ActivityRecord.class), Integer.valueOf(userId));
        ActivityRecord r = rootHomeTask.getActivity(p);
        p.recycle();
        return r;
    }

    private static boolean isHomeActivityForUser(ActivityRecord r, int userId) {
        if (r.isActivityTypeHome() == true) goto L5;
    L9:
        return false;
    L5:
        if (userId != (-1)) goto L7;
    L8:
        return true;
    L7:
        if (r.mUserId != userId) goto L9;
        goto L8
    }

    void moveRootTaskBehindBottomMostVisibleRootTask(Task rootTask) {
        if (rootTask.shouldBeVisible(null) == false) goto L5;
        return;
    L5:
        rootTask.getParent().positionChildAt(Integer.MIN_VALUE, rootTask, false);
        boolean isRootTask = rootTask.isRootTask();
        if (isRootTask == false) goto L8;
        int numRootTasks = this.mChildren.size();
    L9:
        int rootTaskNdx = 0;
    L10:
        if (rootTaskNdx >= numRootTasks) goto L38;
        if (isRootTask == false) goto L17;
        WindowContainer child = (WindowContainer) this.mChildren.get(rootTaskNdx);
        if (child.asTaskDisplayArea() == null) goto L15;
        Task s = child.asTaskDisplayArea().getBottomMostVisibleRootTask(rootTask);
    L19:
        if (s == rootTask) goto L30;
        if (s == null) goto L30;
        int winMode = s.getWindowingMode();
        boolean isValidWindowingMode = true;
        if (winMode == 1) goto L27;
        isValidWindowingMode = false;
    L27:
        if (s.shouldBeVisible(null) == false) goto L30;
        if (isValidWindowingMode == false) goto L30;
        int position = Math.max(0, rootTaskNdx - 1);
        rootTask.getParent().positionChildAt(position, rootTask, false);
        return;
    L30:
        rootTaskNdx = rootTaskNdx + 1;
        goto L10
    L15:
        s = child.asTask();
        goto L19
    L17:
        s = rootTask.getParent().getChildAt(rootTaskNdx).asTask();
        goto L19
    L38:
        return;
    L8:
        numRootTasks = rootTask.getParent().getChildCount();
        goto L9
    }

    private Task getBottomMostVisibleRootTask(Task excludeRootTask) {
        return getRootTask(new TaskDisplayArea$$ExternalSyntheticLambda10(), false);
    }

    private static /* synthetic */ boolean lambda$getBottomMostVisibleRootTask$8(Task task) {
        int winMode = task.getWindowingMode();
        if (winMode != 1) goto L5;
        boolean isValidWindowingMode = true;
    L7:
        if (task.shouldBeVisible(null) == false) goto L11;
        if (isValidWindowingMode == true) goto L10;
        return false;
    L10:
        return true;
    L11:
        return false;
    L5:
        isValidWindowingMode = false;
        goto L7
    }

    void moveRootTaskBehindRootTask(Task rootTask, Task behindRootTask) {
        if (behindRootTask == null) goto L17;
        if (behindRootTask == rootTask) goto L19;
        WindowContainer parent = rootTask.getParent();
        if (parent != null) goto L8;
        return;
    L8:
        if (parent != behindRootTask.getParent()) goto L18;
        int rootTaskIndex = parent.mChildren.indexOf(rootTask);
        int behindRootTaskIndex = parent.mChildren.indexOf(behindRootTask);
        if (rootTaskIndex > behindRootTaskIndex) goto L13;
        int insertIndex = behindRootTaskIndex - 1;
    L14:
        int position = Math.max(0, insertIndex);
        parent.positionChildAt(position, rootTask, false);
        return;
    L13:
        insertIndex = behindRootTaskIndex;
        goto L14
    L18:
        return;
    L19:
        return;
    }

    boolean hasPinnedTask() {
        if (getRootPinnedTask() == null) goto L5;
        return true;
    L5:
        return false;
    }

    static Task getRootTaskAbove(Task rootTask) {
        WindowContainer wc = rootTask.getParent();
        int index = wc.mChildren.indexOf(rootTask) + 1;
        if (index < wc.mChildren.size()) goto L7;
        return null;
    L7:
        return (Task) wc.mChildren.get(index);
    }

    boolean isRootTaskVisible(int windowingMode) {
        Task rootTask = getTopRootTaskInWindowingMode(windowingMode);
        if (rootTask != null) goto L5;
    L7:
        return false;
    L5:
        if (rootTask.isVisible() == false) goto L7;
        return true;
    }

    void removeRootTask(Task rootTask) {
        removeChild(rootTask);
    }

    int getDisplayId() {
        return this.mDisplayContent.getDisplayId();
    }

    boolean isRemoved() {
        return this.mRemoved;
    }

    boolean shouldKeepNoTask() {
        return this.mShouldKeepNoTask;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean canCreateRemoteAnimationTarget() {
        return WindowManagerService.sEnableShellTransitions;
    }

    boolean canHostHomeTask() {
        if (this.mDisplayContent.isHomeSupported() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mCanHostHomeTask == false) goto L7;
        return true;
    }

    void ensureActivitiesVisible(final ActivityRecord starting, final boolean notifyClients) {
        this.mAtmService.mTaskSupervisor.beginActivityVisibilityUpdate();
        forAllRootTasks(new TaskDisplayArea$$ExternalSyntheticLambda8(starting, notifyClients));     // Catch: Throwable -> L6
        this.mAtmService.mTaskSupervisor.endActivityVisibilityUpdate();
        return;
    L6:
        th = move-exception;
        this.mAtmService.mTaskSupervisor.endActivityVisibilityUpdate();
        throw th;
    }

    private static /* synthetic */ void lambda$ensureActivitiesVisible$9(ActivityRecord starting, boolean notifyClients, Task rootTask) {
        rootTask.ensureActivitiesVisible(starting, notifyClients);
    }

    Task prepareForRemoval() {
        this.mShouldKeepNoTask = true;
        Task lastReparentedTask = removeAllTasks();
        this.mRemoved = true;
        return lastReparentedTask;
    }

    Task setShouldKeepNoTask(boolean shouldKeepNoTask) {
        if (this.mShouldKeepNoTask != shouldKeepNoTask) goto L5;
        return null;
    L5:
        this.mShouldKeepNoTask = shouldKeepNoTask;
        if (shouldKeepNoTask == true) goto L8;
        return null;
    L8:
        return removeAllTasks();
    }

    private Task removeAllTasks() {
        TaskDisplayArea toDisplayArea = getReparentToTaskDisplayArea(getFocusedRootTask());
        this.mPreferredTopFocusableRootTask = null;
        boolean destroyContentOnRemoval = this.mDisplayContent.shouldDestroyContentOnRemove();
        int numRootTasks = this.mChildren.size();
        Task lastReparentedRootTask = null;
        int numRootTasks2 = numRootTasks;
        int i = 0;
    L3:
        if (i >= numRootTasks2) goto L39;
        WindowContainer child = (WindowContainer) this.mChildren.get(i);
        if (child.asTaskDisplayArea() == null) goto L7;
        Task lastReparentedRootTask2 = child.asTaskDisplayArea().removeAllTasks();
        lastReparentedRootTask = lastReparentedRootTask2;
    L37:
        i = i + 1;
        goto L3
    L7:
        Task task = ((WindowContainer) this.mChildren.get(i)).asTask();
        if (destroyContentOnRemoval == false) goto L10;
    L35:
        task.remove(false, "removeTaskDisplayArea");
    L36:
        i = i - (numRootTasks2 - this.mChildren.size());
        numRootTasks2 = this.mChildren.size();
        goto L37
    L10:
        if (task.isActivityTypeStandardOrUndefined() == false) goto L35;
        if (task.mCreatedByOrganizer == true) goto L35;
        WindowContainer launchRoot = toDisplayArea.getLaunchRootTask(task.getWindowingMode(), task.getActivityType(), null, null, 0);
        if (getDisplayContent().getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L20;
        if (launchRoot != null) goto L18;
        WindowContainer r3 = toDisplayArea;
    L19:
        task.reparent(r3, Integer.MIN_VALUE);
    L24:
        if (launchRoot == null) goto L26;
    L30:
        boolean keepWindowingMode = false;
    L32:
        if (keepWindowingMode == true) goto L34;
        task.setWindowingMode(0);
    L34:
        lastReparentedRootTask = task;
        goto L36
    L26:
        if (task.getRequestedOverrideWindowingMode() != 1) goto L30;
        if (toDisplayArea.getWindowingMode() == 1) goto L30;
        keepWindowingMode = true;
        goto L32
    L18:
        r3 = launchRoot;
        goto L19
    L20:
        if (launchRoot != null) goto L22;
        WindowContainer r4 = toDisplayArea;
    L23:
        task.reparent(r4, Integer.MAX_VALUE);
        goto L24
    L22:
        r4 = launchRoot;
        goto L23
    L39:
        if (lastReparentedRootTask != null) goto L41;
    L43:
        return lastReparentedRootTask;
    L41:
        if (lastReparentedRootTask.isRootTask() == true) goto L43;
        lastReparentedRootTask.getRootTask().moveToFront("display-removed");
        goto L43
    }

    private TaskDisplayArea getReparentToTaskDisplayArea(Task rootTask) {
        TaskDisplayArea defaultTaskDisplayArea = this.mRootWindowContainer.getDefaultTaskDisplayArea();
        if (rootTask != null) goto L5;
        return defaultTaskDisplayArea;
    L5:
        UserManagerInternal userManagerInternal = this.mAtmService.mWindowManager.mUmInternal;
        if (userManagerInternal.isVisibleBackgroundFullUser(rootTask.mUserId) == true) goto L8;
        return defaultTaskDisplayArea;
    L8:
        int toDisplayId = userManagerInternal.getMainDisplayAssignedToUser(rootTask.mUserId);
        if (toDisplayId != (-1)) goto L11;
        return defaultTaskDisplayArea;
    L11:
        DisplayContent dc = this.mRootWindowContainer.getDisplayContent(toDisplayId);
        if (dc == null) goto L15;
        return dc.getDefaultTaskDisplayArea();
    L15:
        return defaultTaskDisplayArea;
    }

    boolean canSpecifyOrientation(int orientation) {
        if (this.mDisplayContent.getOrientationRequestingTaskDisplayArea() == this) goto L5;
    L7:
        return false;
    L5:
        if (shouldIgnoreOrientationRequest(orientation) == true) goto L7;
        return true;
    }

    void clearPreferredTopFocusableRootTask() {
        this.mPreferredTopFocusableRootTask = null;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public void setWindowingMode(int windowingMode) {
        this.mTempConfiguration.setTo(getRequestedOverrideConfiguration());
        WindowConfiguration tempRequestWindowConfiguration = this.mTempConfiguration.windowConfiguration;
        tempRequestWindowConfiguration.setWindowingMode(windowingMode);
        onRequestedOverrideConfigurationChanged(this.mTempConfiguration);
    }

    @Override // com.android.server.wm.WindowContainer
    TaskDisplayArea getTaskDisplayArea() {
        return this;
    }

    @Override // com.android.server.wm.DisplayArea
    boolean isTaskDisplayArea() {
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    TaskDisplayArea asTaskDisplayArea() {
        return this;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.android.server.wm.WindowContainer] */
    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        pw.println(prefix + "TaskDisplayArea " + getName());
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append("  ");
        String doublePrefix = r0.toString();
        super.dump(pw, doublePrefix, dumpAll);
        if (this.mPreferredTopFocusableRootTask == null) goto L6;
        pw.println(doublePrefix + "mPreferredTopFocusableRootTask=" + this.mPreferredTopFocusableRootTask);
    L6:
        if (this.mLastFocusedRootTask == null) goto L8;
        pw.println(doublePrefix + "mLastFocusedRootTask=" + this.mLastFocusedRootTask);
    L8:
        String triplePrefix = doublePrefix + "  ";
        if (this.mLaunchRootTasks.size() <= 0) goto L13;
        pw.println(doublePrefix + "mLaunchRootTasks:");
        int i = this.mLaunchRootTasks.size() + (-1);
    L11:
        if (i < 0) goto L13;
        LaunchRootTaskDef def = this.mLaunchRootTasks.get(i);
        pw.println(triplePrefix + Arrays.toString(def.activityTypes) + " " + Arrays.toString(def.windowingModes) + "  task=" + def.task);
        i = i + (-1);
    L13:
        pw.println(doublePrefix + "Application tokens in top down Z order:");
        int index = getChildCount() + (-1);
    L14:
        if (index < 0) goto L21;
        ?? r3 = getChildAt(index);
        if (r3.asTaskDisplayArea() == null) goto L18;
        r3.dump(pw, doublePrefix, dumpAll);
    L19:
        index = index - 1;
        goto L14
    L18:
        Task rootTask = r3.asTask();
        pw.println(doublePrefix + "* " + rootTask.toFullString());
        rootTask.dump(pw, triplePrefix, dumpAll);
        goto L19
    }

    IExtTaskDisplayArea getExt() {
        return this.mExt;
    }
}
