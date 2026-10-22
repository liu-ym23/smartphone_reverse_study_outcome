package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.WindowConfiguration;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.pico.utils.Features;
import android.util.Size;
import android.window.WindowContainerToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class TaskLaunchParamsModifier implements LaunchParamsController.LaunchParamsModifier {
    private static final int BOUNDS_CONFLICT_THRESHOLD = 4;
    private static final int CASCADING_OFFSET_DP = 75;
    private static final boolean DEBUG = false;
    private static final int EPSILON = 2;
    private static final int MINIMAL_STEP = 1;
    private static final int STEP_DENOMINATOR = 16;
    private static final String TAG = "ActivityTaskManager";
    private StringBuilder mLogBuilder;
    private final ActivityTaskSupervisor mSupervisor;
    private final Rect mTmpBounds;
    private final int[] mTmpDirections;
    private TaskDisplayArea mTmpDisplayArea;
    private final Rect mTmpStableBounds;

    public static /* synthetic */ TaskDisplayArea $r8$lambda$KZI_3ccMGutdSalJhMt1ed153yY(int r0, TaskDisplayArea r1) {
        return lambda$getPreferredLaunchTaskDisplayArea$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$TjxGreTpw9xhmmPZAU-spdevuA4, reason: not valid java name */
    public static /* synthetic */ void m10301$r8$lambda$TjxGreTpw9xhmmPZAUspdevuA4(List r0, Task r1) {
        lambda$adjustBoundsToAvoidConflictInDisplayArea$2(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$cOwEsqAlVxZJC8Bgaj_hUt2vkL8(TaskLaunchParamsModifier r0, int r1, int r2, TaskDisplayArea r3) {
        return r0.lambda$calculate$0(r1, r2, r3);
    }

    TaskLaunchParamsModifier(ActivityTaskSupervisor supervisor) {
        this.mTmpBounds = new Rect();
        this.mTmpStableBounds = new Rect();
        this.mTmpDirections = new int[2];
        this.mSupervisor = supervisor;
    }

    @Override // com.android.server.wm.LaunchParamsController.LaunchParamsModifier
    public int onCalculate(Task task, ActivityInfo.WindowLayout layout, ActivityRecord activity, ActivityRecord source, ActivityOptions options, ActivityStarter.Request request, int phase, LaunchParamsController.LaunchParams currentParams, LaunchParamsController.LaunchParams outParams) {
        initLogBuilder(task, activity);
        int result = calculate(task, layout, activity, source, options, request, phase, currentParams, outParams);
        outputLog();
        return result;
    }

    private int calculate(Task task, ActivityInfo.WindowLayout layout, ActivityRecord activity, ActivityRecord source, ActivityOptions options, ActivityStarter.Request request, int phase, LaunchParamsController.LaunchParams currentParams, LaunchParamsController.LaunchParams outParams) {
        ActivityInfo.WindowLayout r7 = layout;
        if (task != null) goto L5;
        ActivityRecord root = activity;
    L11:
        if (root != null) goto L14;
        if (phase == 0) goto L14;
        return 0;
    L14:
        TaskDisplayArea suggestedDisplayArea = getPreferredLaunchTaskDisplayArea(task, options, source, currentParams, activity, request);
        final TaskLaunchParamsModifier r13 = this;
        outParams.mPreferredTaskDisplayArea = suggestedDisplayArea;
        DisplayContent r0 = suggestedDisplayArea.mDisplayContent;
        if (phase != 0) goto L17;
        return 2;
    L17:
        if (options == null) goto L19;
        int launchMode = options.getLaunchWindowingMode();
    L21:
        if (Features.FEAT_QUICK_WIN == false) goto L28;
        if (launchMode != 0) goto L28;
        IExtActivityTaskSupervisor r3 = r13.mSupervisor.getExt();
        if (request == null) goto L26;
        int r6 = request.realCallingPid;
    L27:
        int launchMode2 = r3.calculate(launchMode, source, task, activity, options, r6);
        ActivityRecord r1 = source;
        ActivityOptions r2 = options;
    L29:
        if (launchMode2 == 0) goto L31;
    L33:
        if (launchMode2 != 0) goto L40;
        if (task == null) goto L40;
        if (task.getTaskDisplayArea() != suggestedDisplayArea) goto L40;
        if (task.getRootTask().mReparentLeafTaskIfRelaunch == true) goto L40;
        launchMode2 = task.getWindowingMode();
    L40:
        boolean canCalculateBoundsForFullscreenTask = r13.canCalculateBoundsForFullscreenTask(suggestedDisplayArea, launchMode2);
        boolean canApplyFreeformWindowPolicy = r13.canApplyFreeformWindowPolicy(suggestedDisplayArea, launchMode2);
        if (r7 == null) goto L45;
        if (canApplyFreeformWindowPolicy == true) goto L44;
        if (canCalculateBoundsForFullscreenTask == false) goto L45;
    L44:
        boolean r8 = true;
    L46:
        boolean canApplyWindowLayout = r8;
        if (r13.mSupervisor.canUseActivityOptionsLaunchBounds(r2) == false) goto L53;
        if (canApplyFreeformWindowPolicy == false) goto L50;
    L52:
        boolean r9 = true;
    L54:
        boolean canApplyBoundsFromActivityOptions = r9;
        if (canApplyBoundsFromActivityOptions == true) goto L57;
        if (canApplyWindowLayout == false) goto L70;
        r13.mTmpBounds.set(currentParams.mBounds);
        r13.getLayoutBounds(suggestedDisplayArea, root, r7, r13.mTmpBounds);
        if (r13.mTmpBounds.isEmpty() == true) goto L75;
        if (canApplyFreeformWindowPolicy == false) goto L67;
        int r5 = 5;
    L68:
        launchMode2 = r5;
        outParams.mBounds.set(r13.mTmpBounds);
        boolean hasInitialBounds = true;
        boolean hasInitialBoundsForSuggestedDisplayAreaInFreeformWindow = true;
    L76:
        boolean fullyResolvedCurrentParam = false;
        if (currentParams.isEmpty() == true) goto L98;
        if (hasInitialBounds == true) goto L98;
        if (currentParams.mPreferredTaskDisplayArea == null) goto L84;
        if (currentParams.mPreferredTaskDisplayArea.getDisplayId() != r0.getDisplayId()) goto L98;
    L84:
        if (currentParams.hasWindowingMode() == false) goto L95;
        if (suggestedDisplayArea.inFreeformWindowingMode() == false) goto L95;
        launchMode2 = currentParams.mWindowingMode;
        if (launchMode2 == 5) goto L90;
        boolean r10 = true;
    L91:
        fullyResolvedCurrentParam = r10;
        goto L95
    L90:
        r10 = false;
    L95:
        if (currentParams.mBounds.isEmpty() == true) goto L97;
        outParams.mBounds.set(currentParams.mBounds);
        boolean fullyResolvedCurrentParam2 = true;
    L99:
        boolean hasInitialBoundsForSuggestedDisplayAreaInFreeformMode = false;
        if (suggestedDisplayArea.inFreeformWindowingMode() == true) goto L102;
        ActivityRecord root2 = root;
        int r12 = 1;
    L115:
        int launchMode3 = launchMode2;
    L117:
        if (launchMode3 == suggestedDisplayArea.getWindowingMode()) goto L119;
    L121:
        int r4 = launchMode3;
    L122:
        outParams.mWindowingMode = r4;
        if (phase != r12) goto L126;
        return 2;
    L126:
        if (launchMode3 == 0) goto L128;
        final int resolvedMode = launchMode3;
    L129:
        TaskDisplayArea taskDisplayArea = suggestedDisplayArea;
        if (r2 == null) goto L138;
        if (r2.getLaunchTaskDisplayArea() == null) goto L134;
    L136:
        int resolvedMode2 = resolvedMode;
        TaskLaunchParamsModifier r11 = r13;
        ActivityRecord root3 = root2;
        TaskDisplayArea taskDisplayArea2 = taskDisplayArea;
    L158:
        r11.appendLog("display-area=" + taskDisplayArea2);
        outParams.mPreferredTaskDisplayArea = taskDisplayArea2;
        if (phase != 2) goto L161;
        return 2;
    L161:
        if (fullyResolvedCurrentParam2 == true) goto L163;
        int resolvedMode3 = resolvedMode2;
        if (task != null) goto L172;
    L175:
        if (source != null) goto L177;
    L185:
        r11.getTaskBounds(root3, taskDisplayArea2, r7, resolvedMode3, hasInitialBounds, outParams.mBounds);
        return 2;
    L177:
        if (source.inFreeformWindowingMode() == false) goto L185;
        if (resolvedMode3 != 5) goto L185;
        if (outParams.mBounds.isEmpty() == false) goto L185;
        if (source.getDisplayArea() != taskDisplayArea2) goto L185;
        r11.cascadeBounds(source.getConfiguration().windowConfiguration.getBounds(), taskDisplayArea2, outParams.mBounds);
        goto L185
    L172:
        if (task.hasOverrideBounds() == false) goto L175;
        return 2;
    L163:
        if (resolvedMode2 != 5) goto L189;
        if (currentParams.mPreferredTaskDisplayArea == taskDisplayArea2) goto L167;
        r11.adjustBoundsToFitInDisplayArea(taskDisplayArea2, r7, outParams.mBounds);
    L167:
        r11.adjustBoundsToAvoidConflictInDisplayArea(taskDisplayArea2, outParams.mBounds);
        return 2;
    L189:
        return 2;
    L134:
        if (r2.getLaunchTaskDisplayAreaFeatureId() != (-1)) goto L136;
    L138:
        final int activityType = r13.mSupervisor.mRootWindowContainer.resolveActivityType(root2, r2, task);
        r0.forAllTaskDisplayAreas(new TaskLaunchParamsModifier$$ExternalSyntheticLambda1(r13, resolvedMode, activityType));
        if (r13.mTmpDisplayArea != null) goto L141;
    L153:
        resolvedMode2 = resolvedMode;
        r11 = r13;
        ActivityRecord root4 = root2;
    L155:
        if (r11.mTmpDisplayArea == null) goto L157;
        taskDisplayArea2 = r11.mTmpDisplayArea;
        r11.mTmpDisplayArea = null;
        StringBuilder r14 = new StringBuilder();
        r14.append("overridden-display-area=[");
        r14.append(WindowConfiguration.activityTypeToString(activityType));
        r14.append(", ");
        root3 = root4;
        r14.append(WindowConfiguration.windowingModeToString(resolvedMode2));
        r14.append(", ");
        r14.append(taskDisplayArea2);
        r14.append("]");
        r11.appendLog(r14.toString());
        goto L158
    L157:
        root3 = root4;
        taskDisplayArea2 = taskDisplayArea;
        goto L158
    L141:
        if (r13.mTmpDisplayArea == suggestedDisplayArea) goto L153;
        if (launchMode3 != r13.mTmpDisplayArea.getWindowingMode()) goto L145;
        int r15 = 0;
    L146:
        outParams.mWindowingMode = r15;
        if (hasInitialBoundsForSuggestedDisplayAreaInFreeformWindow == false) goto L149;
        outParams.mBounds.setEmpty();
        resolvedMode2 = resolvedMode;
        r13.getLayoutBounds(r13.mTmpDisplayArea, root2, r7, outParams.mBounds);
        hasInitialBounds = !outParams.mBounds.isEmpty();
        r11 = r13;
        root4 = root2;
        goto L155
    L149:
        resolvedMode2 = resolvedMode;
        if (hasInitialBoundsForSuggestedDisplayAreaInFreeformMode == false) goto L152;
        outParams.mBounds.setEmpty();
        TaskLaunchParamsModifier r27 = r13;
        root4 = root2;
        r11 = r27;
        r11.getTaskBounds(root4, r13.mTmpDisplayArea, r7, launchMode3, hasInitialBounds, outParams.mBounds);
        goto L155
    L152:
        r11 = r13;
        root4 = root2;
        goto L155
    L145:
        r15 = launchMode3;
        goto L146
    L128:
        resolvedMode = suggestedDisplayArea.getWindowingMode();
        goto L129
    L119:
        if (r13.shouldUpdateExistingTaskWindowingMode(task, launchMode3) == true) goto L121;
        r4 = 0;
        goto L122
    L102:
        if (launchMode2 != 2) goto L105;
        root2 = root;
        r12 = 1;
        goto L115
    L105:
        if (root.isResizeable() == false) goto L107;
        root2 = root;
        r12 = 1;
        goto L115
    L107:
        if (r13.shouldLaunchUnresizableAppInFreeform(root, suggestedDisplayArea, r2) == false) goto L112;
        launchMode3 = 5;
        if (outParams.mBounds.isEmpty() == false) goto L111;
        r7 = r7;
        ActivityRecord root5 = root;
        task = task;
        r2 = r2;
        r12 = 1;
        r13.getTaskBounds(root5, suggestedDisplayArea, r7, 5, hasInitialBounds, outParams.mBounds);
        suggestedDisplayArea = suggestedDisplayArea;
        root2 = root5;
        r13 = r13;
        hasInitialBoundsForSuggestedDisplayAreaInFreeformMode = true;
        goto L117
    L111:
        ActivityRecord r16 = root;
        r2 = r2;
        root2 = r16;
        r7 = r7;
        suggestedDisplayArea = suggestedDisplayArea;
        r13 = r13;
        r12 = 1;
        task = task;
        goto L117
    L112:
        ActivityRecord r17 = root;
        r2 = r2;
        root2 = r17;
        r7 = r7;
        suggestedDisplayArea = suggestedDisplayArea;
        r13 = r13;
        r12 = 1;
        task = task;
        outParams.mBounds.setEmpty();
        launchMode3 = 1;
        goto L117
    L97:
        fullyResolvedCurrentParam2 = fullyResolvedCurrentParam;
    L98:
        fullyResolvedCurrentParam2 = false;
        goto L99
    L67:
        r5 = launchMode2;
    L75:
        hasInitialBounds = false;
        hasInitialBoundsForSuggestedDisplayAreaInFreeformWindow = false;
        goto L76
    L70:
        if (launchMode2 != 6) goto L75;
        if (r2 == null) goto L75;
        if (r2.getLaunchBounds() == null) goto L75;
        outParams.mBounds.set(r2.getLaunchBounds());
        hasInitialBounds = true;
        hasInitialBoundsForSuggestedDisplayAreaInFreeformWindow = false;
        goto L76
    L57:
        if (launchMode2 != 0) goto L60;
        if (canApplyFreeformWindowPolicy == false) goto L60;
        int r22 = 5;
    L61:
        launchMode2 = r22;
        outParams.mBounds.set(r2.getLaunchBounds());
        hasInitialBounds = true;
        hasInitialBoundsForSuggestedDisplayAreaInFreeformWindow = false;
    L60:
        r22 = launchMode2;
        goto L61
    L50:
        if (r13.canApplyPipWindowPolicy(launchMode2) == true) goto L52;
        if (canCalculateBoundsForFullscreenTask == true) goto L52;
    L53:
        r9 = false;
    L45:
        r8 = false;
        goto L46
    L31:
        if (r13.canInheritWindowingModeFromSource(r0, suggestedDisplayArea, r1) == false) goto L33;
        launchMode2 = r1.getTask().getWindowingMode();
        goto L33
    L26:
        r6 = -1;
    L28:
        launchMode2 = launchMode;
        r1 = source;
        r2 = options;
        goto L29
    L19:
        launchMode = 0;
        goto L21
    L5:
        if (task.getRootActivity() != null) goto L7;
        ActivityRecord r18 = activity;
    L8:
        root = r18;
        goto L11
    L7:
        r18 = task.getRootActivity();
        goto L8
    }

    private /* synthetic */ boolean lambda$calculate$0(int resolvedMode, int activityType, TaskDisplayArea displayArea) {
        Task launchRoot = displayArea.getLaunchRootTask(resolvedMode, activityType, null, null, 0);
        if (launchRoot != null) goto L6;
        return false;
    L6:
        this.mTmpDisplayArea = displayArea;
        return true;
    }

    private boolean shouldUpdateExistingTaskWindowingMode(Task task, int launchMode) {
        if (Features.FEAT_QUICK_WIN == true) goto L5;
    L7:
        if (task != null) goto L9;
        return false;
    L9:
        if (task.getRequestedOverrideWindowingMode() != 0) goto L11;
        return false;
    L11:
        if (task.getRequestedOverrideWindowingMode() != 2) goto L13;
        return false;
    L13:
        if (launchMode == task.getRequestedOverrideWindowingMode()) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (this.mSupervisor.getExt().disableUpdateExistingTaskWindowingMode(task) == false) goto L7;
        return false;
    }

    private TaskDisplayArea getPreferredLaunchTaskDisplayArea(Task task, ActivityOptions options, ActivityRecord source, LaunchParamsController.LaunchParams currentParams, ActivityRecord activityRecord, ActivityStarter.Request request) {
        TaskDisplayArea taskDisplayArea = null;
        Task rootTask = null;
        if (options == null) goto L5;
        WindowContainerToken optionLaunchTaskDisplayAreaToken = options.getLaunchTaskDisplayArea();
    L6:
        if (optionLaunchTaskDisplayAreaToken == null) goto L9;
        taskDisplayArea = (TaskDisplayArea) WindowContainer.fromBinder(optionLaunchTaskDisplayAreaToken.asBinder());
    L9:
        if (taskDisplayArea != null) goto L20;
        if (options == null) goto L20;
        final int launchTaskDisplayAreaFeatureId = options.getLaunchTaskDisplayAreaFeatureId();
        if (launchTaskDisplayAreaFeatureId == (-1)) goto L20;
        if (options.getLaunchDisplayId() != (-1)) goto L16;
        int launchDisplayId = 0;
    L17:
        DisplayContent dc = this.mSupervisor.mRootWindowContainer.getDisplayContent(launchDisplayId);
        if (dc == null) goto L20;
        taskDisplayArea = (TaskDisplayArea) dc.getItemFromTaskDisplayAreas(new TaskLaunchParamsModifier$$ExternalSyntheticLambda0(launchTaskDisplayAreaFeatureId));
        goto L20
    L16:
        launchDisplayId = options.getLaunchDisplayId();
    L20:
        if (taskDisplayArea != null) goto L28;
        if (options == null) goto L23;
        int optionLaunchId = options.getLaunchDisplayId();
    L24:
        if (optionLaunchId == (-1)) goto L28;
        DisplayContent dc2 = this.mSupervisor.mRootWindowContainer.getDisplayContent(optionLaunchId);
        if (dc2 == null) goto L28;
        taskDisplayArea = dc2.getDefaultTaskDisplayArea();
        goto L28
    L23:
        optionLaunchId = -1;
    L28:
        if (taskDisplayArea != null) goto L38;
        if (source == null) goto L38;
        if (source.isNoDisplay() == false) goto L38;
        taskDisplayArea = source.mHandoverTaskDisplayArea;
        if (taskDisplayArea != null) goto L38;
        int displayId = source.mHandoverLaunchDisplayId;
        DisplayContent dc3 = this.mSupervisor.mRootWindowContainer.getDisplayContent(displayId);
        if (dc3 == null) goto L38;
        taskDisplayArea = dc3.getDefaultTaskDisplayArea();
    L38:
        if (taskDisplayArea != null) goto L41;
        if (source == null) goto L41;
        TaskDisplayArea sourceDisplayArea = source.getDisplayArea();
        taskDisplayArea = sourceDisplayArea;
    L41:
        if (taskDisplayArea != null) goto L46;
        if (task == null) goto L46;
        rootTask = task.getRootTask();
    L46:
        if (rootTask == null) goto L48;
        taskDisplayArea = rootTask.getDisplayArea();
    L48:
        if (taskDisplayArea != null) goto L53;
        if (options == null) goto L53;
        int callerDisplayId = options.getCallerDisplayId();
        DisplayContent dc4 = this.mSupervisor.mRootWindowContainer.getDisplayContent(callerDisplayId);
        if (dc4 == null) goto L53;
        taskDisplayArea = dc4.getDefaultTaskDisplayArea();
    L53:
        if (taskDisplayArea != null) goto L56;
        if (currentParams == null) goto L56;
        taskDisplayArea = currentParams.mPreferredTaskDisplayArea;
    L56:
        if (taskDisplayArea != null) goto L58;
    L62:
        if (taskDisplayArea == null) goto L69;
        if (activityRecord == null) goto L69;
        if (activityRecord.isActivityTypeHome() == false) goto L69;
        if (this.mSupervisor.mRootWindowContainer.canStartHomeOnDisplayArea(activityRecord.info, taskDisplayArea, false) == true) goto L69;
        taskDisplayArea = this.mSupervisor.mRootWindowContainer.getDefaultTaskDisplayArea();
    L69:
        if (taskDisplayArea == null) goto L72;
        return taskDisplayArea;
    L72:
        return getFallbackDisplayAreaForActivity(activityRecord, request);
    L58:
        if (this.mSupervisor.mService.mSupportsMultiDisplay == true) goto L62;
        if (taskDisplayArea.getDisplayId() == 0) goto L62;
        taskDisplayArea = this.mSupervisor.mRootWindowContainer.getDefaultTaskDisplayArea();
        goto L62
    L5:
        optionLaunchTaskDisplayAreaToken = null;
        goto L6
    }

    private static /* synthetic */ TaskDisplayArea lambda$getPreferredLaunchTaskDisplayArea$1(int launchTaskDisplayAreaFeatureId, TaskDisplayArea tda) {
        if (tda.mFeatureId == launchTaskDisplayAreaFeatureId) goto L7;
        return null;
    L7:
        return tda;
    }

    private TaskDisplayArea getFallbackDisplayAreaForActivity(ActivityRecord activityRecord, ActivityStarter.Request request) {
        if (activityRecord == null) goto L13;
        WindowProcessController controllerFromLaunchingRecord = this.mSupervisor.mService.getProcessController(activityRecord.launchedFromPid, activityRecord.launchedFromUid);
        if (controllerFromLaunchingRecord == null) goto L8;
        TaskDisplayArea taskDisplayAreaForLaunchingRecord = controllerFromLaunchingRecord.getTopActivityDisplayArea();
        if (taskDisplayAreaForLaunchingRecord == null) goto L8;
        return taskDisplayAreaForLaunchingRecord;
    L8:
        WindowProcessController controllerFromProcess = this.mSupervisor.mService.getProcessController(activityRecord.getProcessName(), activityRecord.getUid());
        if (controllerFromProcess == null) goto L13;
        TaskDisplayArea displayAreaForRecord = controllerFromProcess.getTopActivityDisplayArea();
        if (displayAreaForRecord == null) goto L13;
        return displayAreaForRecord;
    L13:
        if (request == null) goto L19;
        WindowProcessController controllerFromRequest = this.mSupervisor.mService.getProcessController(request.realCallingPid, request.realCallingUid);
        if (controllerFromRequest == null) goto L19;
        TaskDisplayArea displayAreaFromSourceProcess = controllerFromRequest.getTopActivityDisplayArea();
        if (displayAreaFromSourceProcess == null) goto L19;
        return displayAreaFromSourceProcess;
    L19:
        TaskDisplayArea defaultTaskDisplayArea = this.mSupervisor.mRootWindowContainer.getDefaultTaskDisplayArea();
        return defaultTaskDisplayArea;
    }

    private boolean canInheritWindowingModeFromSource(DisplayContent display, TaskDisplayArea suggestedDisplayArea, ActivityRecord source) {
        if (source != null) goto L6;
        return false;
    L6:
        if (suggestedDisplayArea.inFreeformWindowingMode() == false) goto L8;
        return false;
    L8:
        int sourceWindowingMode = source.getTask().getWindowingMode();
        if (sourceWindowingMode == 1) goto L14;
        if (sourceWindowingMode == 5) goto L14;
        return false;
    L14:
        if (display.getDisplayId() == source.getDisplayId()) goto L16;
        return false;
    L16:
        return true;
    }

    private boolean canCalculateBoundsForFullscreenTask(TaskDisplayArea displayArea, int launchMode) {
        if (this.mSupervisor.mService.mSupportsFreeformWindowManagement == true) goto L5;
    L9:
        return false;
    L5:
        if (displayArea.getWindowingMode() != 1) goto L7;
        if (launchMode != 0) goto L7;
        return true;
    L7:
        if (launchMode != 1) goto L9;
        return true;
    }

    private boolean canApplyFreeformWindowPolicy(TaskDisplayArea suggestedDisplayArea, int launchMode) {
        if (this.mSupervisor.mService.mSupportsFreeformWindowManagement == true) goto L5;
    L10:
        return false;
    L5:
        if (suggestedDisplayArea.inFreeformWindowingMode() == false) goto L8;
        if (launchMode != 0) goto L8;
    L9:
        return true;
    L8:
        if (launchMode != 5) goto L10;
        goto L9
    }

    private boolean canApplyPipWindowPolicy(int launchMode) {
        if (this.mSupervisor.mService.mSupportsPictureInPicture == true) goto L5;
    L7:
        return false;
    L5:
        if (launchMode != 2) goto L7;
        return true;
    }

    private void getLayoutBounds(TaskDisplayArea displayArea, ActivityRecord root, ActivityInfo.WindowLayout windowLayout, Rect inOutBounds) {
        int verticalGravity = windowLayout.gravity & 112;
        int horizontalGravity = windowLayout.gravity & 7;
        if (windowLayout.hasSpecifiedSize() == true) goto L8;
        if (verticalGravity != 0) goto L8;
        if (horizontalGravity != 0) goto L8;
        inOutBounds.setEmpty();
        return;
    L8:
        Rect stableBounds = this.mTmpStableBounds;
        displayArea.getStableRect(stableBounds);
        if (windowLayout.hasSpecifiedSize() == false) goto L12;
        LaunchParamsUtil.calculateLayoutBounds(stableBounds, windowLayout, inOutBounds, null);
        Rect inOutBounds2 = inOutBounds;
    L15:
        LaunchParamsUtil.applyLayoutGravity(verticalGravity, horizontalGravity, inOutBounds2, stableBounds);
        return;
    L12:
        if (inOutBounds.isEmpty() == false) goto L14;
        inOutBounds2 = inOutBounds;
        getTaskBounds(root, displayArea, windowLayout, 5, false, inOutBounds2);
        goto L15
    L14:
        inOutBounds2 = inOutBounds;
        goto L15
    }

    private boolean shouldLaunchUnresizableAppInFreeform(ActivityRecord activity, TaskDisplayArea displayArea, ActivityOptions options) {
        if (options == null) goto L8;
        if (options.getLaunchWindowingMode() != 1) goto L8;
        return false;
    L8:
        if (activity.supportsFreeformInDisplayArea(displayArea) == true) goto L10;
    L17:
        return false;
    L10:
        if (activity.isResizeable() == true) goto L17;
        int displayOrientation = orientationFromBounds(displayArea.getBounds());
        int activityOrientation = resolveOrientation(activity, displayArea, displayArea.getBounds());
        if (displayArea.getWindowingMode() != 5) goto L16;
        if (displayOrientation == activityOrientation) goto L16;
        return true;
    L16:
        return false;
    }

    private int resolveOrientation(ActivityRecord activity) {
        int orientation = activity.info.screenOrientation;
        switch(orientation) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L4;
            case 3: goto L4;
            case 4: goto L4;
            case 5: goto L5;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L4;
            case 11: goto L7;
            case 12: goto L6;
            case 13: goto L4;
            case 14: goto L5;
            default: goto L4;
        };
    L4:
        return -1;
    L5:
        return 14;
    L6:
        return 1;
    L7:
        return 0;
    }

    private void cascadeBounds(Rect srcBounds, TaskDisplayArea displayArea, Rect outBounds) {
        outBounds.set(srcBounds);
        float density = displayArea.getConfiguration().densityDpi / 160.0f;
        int defaultOffset = (int) ((75.0f * density) + 0.5f);
        displayArea.getBounds(this.mTmpBounds);
        int dx = Math.min(defaultOffset, Math.max(0, this.mTmpBounds.right - srcBounds.right));
        int dy = Math.min(defaultOffset, Math.max(0, this.mTmpBounds.bottom - srcBounds.bottom));
        outBounds.offset(dx, dy);
    }

    private void getTaskBounds(ActivityRecord root, TaskDisplayArea displayArea, ActivityInfo.WindowLayout layout, int resolvedMode, boolean hasInitialBounds, Rect inOutBounds) {
        if (resolvedMode == 5) goto L6;
        if (resolvedMode == 1) goto L6;
        return;
    L6:
        int orientation = resolveOrientation(root, displayArea, inOutBounds);
        if (orientation == 1) goto L12;
        if (orientation == 0) goto L12;
        throw new IllegalStateException("Orientation must be one of portrait or landscape, but it's " + ActivityInfo.screenOrientationToString(orientation));
    L12:
        displayArea.getStableRect(this.mTmpStableBounds);
        Size defaultSize = LaunchParamsUtil.getDefaultFreeformSize(root, displayArea, layout, orientation, this.mTmpStableBounds);
        this.mTmpBounds.set(0, 0, defaultSize.getWidth(), defaultSize.getHeight());
        if (hasInitialBounds == true) goto L19;
        if (sizeMatches(inOutBounds, this.mTmpBounds) == true) goto L19;
        adjustBoundsToFitInDisplayArea(displayArea, layout, this.mTmpBounds);
        inOutBounds.setEmpty();
        LaunchParamsUtil.centerBounds(displayArea, this.mTmpBounds.width(), this.mTmpBounds.height(), inOutBounds);
    L22:
        adjustBoundsToAvoidConflictInDisplayArea(displayArea, inOutBounds);
        return;
    L19:
        if (orientation == orientationFromBounds(inOutBounds)) goto L22;
        LaunchParamsUtil.centerBounds(displayArea, inOutBounds.height(), inOutBounds.width(), inOutBounds);
        goto L22
    }

    private int convertOrientationToScreenOrientation(int orientation) {
        switch(orientation) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return 0;
    L7:
        return 1;
    }

    private int resolveOrientation(ActivityRecord root, TaskDisplayArea displayArea, Rect bounds) {
        int orientation = resolveOrientation(root);
        if (orientation != 14) goto L10;
        if (bounds.isEmpty() == false) goto L7;
        int r1 = convertOrientationToScreenOrientation(displayArea.getConfiguration().orientation);
    L8:
        orientation = r1;
        goto L10
    L7:
        r1 = orientationFromBounds(bounds);
    L10:
        if (orientation == (-1)) goto L12;
        return orientation;
    L12:
        if (bounds.isEmpty() == false) goto L14;
        int orientation2 = 1;
    L16:
        return orientation2;
    L14:
        orientation2 = orientationFromBounds(bounds);
        goto L16
    }

    private void adjustBoundsToFitInDisplayArea(TaskDisplayArea displayArea, ActivityInfo.WindowLayout layout, Rect inOutBounds) {
        int layoutDirection = this.mSupervisor.mRootWindowContainer.getConfiguration().getLayoutDirection();
        LaunchParamsUtil.adjustBoundsToFitInDisplayArea(displayArea, layoutDirection, layout, inOutBounds);
    }

    private void adjustBoundsToAvoidConflictInDisplayArea(TaskDisplayArea displayArea, Rect inOutBounds) {
        final List<Rect> taskBoundsToCheck = new ArrayList();
        displayArea.forAllRootTasks(new TaskLaunchParamsModifier$$ExternalSyntheticLambda2(taskBoundsToCheck), false);
        adjustBoundsToAvoidConflict(displayArea.getBounds(), taskBoundsToCheck, inOutBounds);
    }

    private static /* synthetic */ void lambda$adjustBoundsToAvoidConflictInDisplayArea$2(List taskBoundsToCheck, Task task) {
        if (task.inFreeformWindowingMode() == true) goto L5;
        return;
    L5:
        int j = 0;
    L7:
        if (j >= task.getChildCount()) goto L10;
        taskBoundsToCheck.add(task.getChildAt(j).getBounds());
        j = j + 1;
        goto L7
    }

    void adjustBoundsToAvoidConflict(Rect displayAreaBounds, List<Rect> taskBoundsToCheck, Rect inOutBounds) {
        if (displayAreaBounds.contains(inOutBounds) == true) goto L6;
        return;
    L6:
        if (boundsConflict(taskBoundsToCheck, inOutBounds) == true) goto L8;
        return;
    L8:
        calculateCandidateShiftDirections(displayAreaBounds, inOutBounds);
        int[] r0 = this.mTmpDirections;
        int r1 = r0.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L27;
        int direction = r0[r2];
        if (direction == 0) goto L35;
        this.mTmpBounds.set(inOutBounds);
    L16:
        if (boundsConflict(taskBoundsToCheck, this.mTmpBounds) == false) goto L21;
        if (displayAreaBounds.contains(this.mTmpBounds) == false) goto L21;
        shiftBounds(direction, displayAreaBounds, this.mTmpBounds);
    L21:
        if (boundsConflict(taskBoundsToCheck, this.mTmpBounds) == true) goto L26;
        if (displayAreaBounds.contains(this.mTmpBounds) == false) goto L26;
        inOutBounds.set(this.mTmpBounds);
        return;
    L26:
        r2 = r2 + 1;
        goto L10
    L35:
        return;
    }

    private void calculateCandidateShiftDirections(Rect availableBounds, Rect initialBounds) {
        int i = 0;
    L4:
        if (i >= this.mTmpDirections.length) goto L6;
        this.mTmpDirections[i] = 0;
        i = i + 1;
        goto L4
    L6:
        int i2 = availableBounds.left;
        int oneThirdWidth = ((i2 * 2) + availableBounds.right) / 3;
        int twoThirdWidth = (availableBounds.left + (availableBounds.right * 2)) / 3;
        int centerX = initialBounds.centerX();
        if (centerX >= oneThirdWidth) goto L10;
        this.mTmpDirections[0] = 5;
        return;
    L10:
        if (centerX <= twoThirdWidth) goto L13;
        this.mTmpDirections[0] = 3;
        return;
    L13:
        int oneThirdHeight = ((availableBounds.top * 2) + availableBounds.bottom) / 3;
        int twoThirdHeight = (availableBounds.top + (availableBounds.bottom * 2)) / 3;
        int centerY = initialBounds.centerY();
        if (centerY < oneThirdHeight) goto L19;
        if (centerY > twoThirdHeight) goto L19;
        this.mTmpDirections[0] = 85;
        this.mTmpDirections[1] = 51;
        return;
    L19:
        this.mTmpDirections[0] = 5;
        this.mTmpDirections[1] = 3;
    }

    private boolean boundsConflict(List<Rect> taskBoundsToCheck, Rect candidateBounds) {
        Iterator<Rect> r0 = taskBoundsToCheck.iterator();
    L3:
        boolean bottomClose = false;
        if (r0.hasNext() == false) goto L30;
        Rect taskBounds = r0.next();
        if (Math.abs(taskBounds.left - candidateBounds.left) >= 4) goto L8;
        boolean leftClose = true;
    L10:
        if (Math.abs(taskBounds.top - candidateBounds.top) >= 4) goto L12;
        boolean topClose = true;
    L14:
        if (Math.abs(taskBounds.right - candidateBounds.right) >= 4) goto L16;
        boolean rightClose = true;
    L18:
        if (Math.abs(taskBounds.bottom - candidateBounds.bottom) >= 4) goto L20;
        bottomClose = true;
    L20:
        if (leftClose == false) goto L22;
        if (topClose == false) goto L22;
    L28:
        return true;
    L22:
        if (leftClose == false) goto L24;
        if (bottomClose == true) goto L28;
    L24:
        if (rightClose == false) goto L26;
        if (topClose == true) goto L28;
    L26:
        if (rightClose == false) goto L3;
        if (bottomClose == false) goto L3;
    L16:
        rightClose = false;
        goto L18
    L12:
        topClose = false;
        goto L14
    L8:
        leftClose = false;
        goto L10
    L30:
        return false;
    }

    private void shiftBounds(int direction, Rect availableRect, Rect inOutBounds) {
        switch((direction & 7)) {
            case 3: goto L6;
            case 4: goto L4;
            case 5: goto L5;
            default: goto L4;
        };
    L4:
        int horizontalOffset = 0;
    L8:
        switch((direction & 112)) {
            case 48: goto L11;
            case 80: goto L10;
            default: goto L9;
        };
    L9:
        int verticalOffset = 0;
    L12:
        inOutBounds.offset(horizontalOffset, verticalOffset);
        return;
    L10:
        verticalOffset = Math.max(1, availableRect.height() / 16);
        goto L12
    L11:
        verticalOffset = -Math.max(1, availableRect.height() / 16);
        goto L12
    L5:
        int horizontalOffset2 = availableRect.width();
        horizontalOffset = Math.max(1, horizontalOffset2 / 16);
        goto L8
    L6:
        horizontalOffset = -Math.max(1, availableRect.width() / 16);
        goto L8
    }

    private void initLogBuilder(Task task, ActivityRecord activity) {
    }

    private void appendLog(String log) {
    }

    private void outputLog() {
    }

    private static int orientationFromBounds(Rect bounds) {
        if (bounds.width() <= bounds.height()) goto L5;
        return 0;
    L5:
        return 1;
    }

    private static boolean sizeMatches(Rect left, Rect right) {
        if (Math.abs(right.width() - left.width()) < 2) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(right.height() - left.height()) >= 2) goto L7;
        return true;
    }
}
