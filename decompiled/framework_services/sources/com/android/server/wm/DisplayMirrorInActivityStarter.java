package com.android.server.wm;

import com.android.server.display.DisplayMirrorInternal;

/* JADX INFO: loaded from: classes3.dex */
final class DisplayMirrorInActivityStarter {

    interface Callback {
        void clearMirrorDisplayMark(Task r1);

        DisplayContent getMirrorDisplayContent(RootWindowContainer r1);

        boolean isSameMirrorDisplaySize(Task r1, int r2, int r3);
    }

    DisplayMirrorInActivityStarter() {
    }

    static boolean onInterceptStartActivityByMirror(ActivityRecord r, ActivityRecord sourceRecord, ActivityTaskManagerService atms, Task targetTask, TaskDisplayArea preferredTaskDisplayArea, ActivityStarter.Request request, Callback callback) {
        return onInterceptStartActivityByMirrorInner(r, sourceRecord, atms, targetTask, preferredTaskDisplayArea, request, callback);
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static boolean isSameSizeWhithDefaultDisplay(RootWindowContainer rootContainer, int w, int h) {
        DisplayContent defaultD = rootContainer.getDefaultDisplay();
        if (defaultD != null) goto L6;
        return true;
    L6:
        if (defaultD.mBaseDisplayWidth != w) goto L11;
        if (defaultD.mBaseDisplayHeight != h) goto L11;
        return true;
    L11:
        if (defaultD.mBaseDisplayWidth == h) goto L13;
        return false;
    L13:
        if (defaultD.mBaseDisplayHeight != w) goto L17;
        return true;
    L17:
        return false;
    }

    private static boolean onInterceptStartActivityByMirrorInner(ActivityRecord r, ActivityRecord sourceRecord, ActivityTaskManagerService atms, Task targetTask, TaskDisplayArea preferredTaskDisplayArea, ActivityStarter.Request request, Callback callback) {
        if (DisplayMirrorInternal.isEnable() == true) goto L5;
        return false;
    L5:
        int preferredDisplayId = -1;
        if (r.isActivityTypeHome() == false) goto L13;
        if (sourceRecord != null) goto L9;
        int sourceDisplayId = -1;
    L11:
        if (DisplayMirrorInternal.noteStartHome(sourceDisplayId) == false) goto L13;
        return true;
    L9:
        sourceDisplayId = sourceRecord.getDisplayId();
    L13:
        if (targetTask == null) goto L91;
        if (preferredTaskDisplayArea != null) goto L16;
        DisplayContent preferredDisplay = null;
    L17:
        if (preferredDisplay == null) goto L20;
        preferredDisplayId = preferredDisplay.getDisplayId();
    L20:
        if (sourceRecord != null) goto L22;
        int sourceDisplayId2 = preferredDisplayId;
    L23:
        if (sourceRecord != null) goto L26;
        boolean isSourceHomeOrRecent = false;
    L33:
        if (sourceRecord != null) goto L38;
        if (preferredDisplay != null) goto L38;
        boolean r16 = false;
    L83:
        if (sourceRecord == null) goto L85;
        boolean r6 = true;
    L87:
        if (DisplayMirrorInternal.noteStartActivity(r, r6, sourceDisplayId2, isSourceHomeOrRecent, targetTask.getDisplayId()) == false) goto L115;
        return true;
    L115:
        if (DisplayMirrorInternal.noteStartActivity(r) == false) goto L117;
        return true;
    L117:
        return r16;
    L85:
        r6 = r16;
    L38:
        if (targetTask.isTopRootTaskInDisplayArea() == true) goto L40;
    L47:
        boolean needStop = false;
        if (sourceRecord != null) goto L50;
        DisplayContent sourceDisplay = preferredDisplay;
    L51:
        DisplayContent targetDisplay = targetTask.getDisplayContent();
        if (sourceDisplayId2 == targetTask.getDisplayId()) goto L69;
        if (sourceDisplay == null) goto L69;
        if (targetDisplay == null) goto L69;
        if (targetTask.getDisplayId() == 0) goto L58;
    L62:
        r16 = false;
        if (sourceDisplayId2 == 0) goto L65;
    L70:
        if (needStop == true) goto L75;
        if (callback.isSameMirrorDisplaySize(targetTask, sourceDisplay.mBaseDisplayWidth, sourceDisplay.mBaseDisplayHeight) == true) goto L75;
        callback.clearMirrorDisplayMark(targetTask);
        needStop = true;
    L75:
        if ("com.tencent.android.qqdownloader".equals(r.packageName) == false) goto L77;
        needStop = false;
    L77:
        if (needStop == false) goto L83;
        int code = DisplayMirrorInternal.noteReusedBgTaskStart(r.mActivityComponent, r.mUserId);
        if (code == 0) goto L83;
        if (1 != code) goto L82;
        DisplayMirrorInternal.saveLastRequestToMirror(request);
    L82:
        return true;
    L65:
        if (DisplayMirrorInternal.isDisplayMirror(targetTask.getDisplayId()) == false) goto L70;
        if (isSameSizeWhithDefaultDisplay(atms.mRootWindowContainer, targetDisplay.mBaseDisplayWidth, targetDisplay.mBaseDisplayHeight) == true) goto L70;
        needStop = true;
        goto L70
    L58:
        if (DisplayMirrorInternal.isDisplayMirror(sourceDisplayId2) == false) goto L62;
        r16 = false;
        if (isSameSizeWhithDefaultDisplay(atms.mRootWindowContainer, sourceDisplay.mBaseDisplayWidth, sourceDisplay.mBaseDisplayHeight) == true) goto L70;
        needStop = true;
    L69:
        r16 = false;
        goto L70
    L50:
        sourceDisplay = sourceRecord.getDisplayContent();
        goto L51
    L40:
        if (targetTask.getWindowingMode() == 5) goto L47;
        int code2 = DisplayMirrorInternal.noteReusedFgTaskStart(r.mActivityComponent, sourceDisplayId2, targetTask.getDisplayId());
        if (code2 == 0) goto L46;
        if (1 != code2) goto L45;
        DisplayMirrorInternal.saveLastRequestToMirror(request);
    L45:
        return true;
    L46:
        r16 = false;
        goto L83
    L26:
        if (sourceRecord.isActivityTypeHome() == false) goto L28;
    L31:
        isSourceHomeOrRecent = true;
        goto L33
    L28:
        if (sourceRecord.isActivityTypeRecents() == true) goto L31;
        isSourceHomeOrRecent = false;
        goto L33
    L22:
        sourceDisplayId2 = sourceRecord.getDisplayId();
        goto L23
    L16:
        preferredDisplay = preferredTaskDisplayArea.mDisplayContent;
        goto L17
    L91:
        r16 = false;
        if (sourceRecord == null) goto L115;
        if (sourceRecord.isActivityTypeHome() == true) goto L96;
    L113:
        return false;
    L96:
        if (isThirdPartyApp(r) == false) goto L113;
        int sourceDisplayId3 = sourceRecord.getDisplayId();
        DisplayContent otherDisplay = null;
        if (sourceDisplayId3 != 0) goto L102;
        otherDisplay = callback.getMirrorDisplayContent(atms.mRootWindowContainer);
    L104:
        if (otherDisplay != null) goto L107;
        return false;
    L107:
        if (isTopOfDisplaySamePkgWith(otherDisplay, r) == false) goto L115;
        int code3 = DisplayMirrorInternal.noteReusedFgTaskStart(r.mActivityComponent, sourceDisplayId3, otherDisplay.getDisplayId());
        if (code3 == 0) goto L115;
        if (1 != code3) goto L112;
        DisplayMirrorInternal.saveLastRequestToMirror(request);
    L112:
        return true;
    L102:
        if (DisplayMirrorInternal.isDisplayMirror(sourceDisplayId3) == false) goto L104;
        otherDisplay = atms.mRootWindowContainer.getDefaultDisplay();
        goto L104
    }

    private static boolean isTopOfDisplaySamePkgWith(DisplayContent otherDisplay, ActivityRecord startActivity) {
        if (startActivity != null) goto L5;
        return false;
    L5:
        TaskDisplayArea tc = otherDisplay.getDefaultTaskDisplayArea();
        if (tc != null) goto L8;
        return false;
    L8:
        Task task = tc.getTopRootTaskInWindowingMode(1);
        if (task != null) goto L11;
    L18:
        return false;
    L11:
        if (task.isActivityTypeStandard() == false) goto L18;
        ActivityRecord top = task.getResumedActivity();
        if (top != null) goto L17;
        return false;
    L17:
        return top.packageName.equals(startActivity.packageName);
    }

    private static boolean isThirdPartyApp(ActivityRecord r) {
        if (r.info != null) goto L5;
    L20:
        return false;
    L5:
        if (r.info.packageName == null) goto L20;
        if ((r.info.flags & 129) == 0) goto L11;
        return false;
    L11:
        if (r.info.packageName.startsWith("cn.nubia.") == false) goto L13;
    L19:
        return false;
    L13:
        if (r.info.packageName.startsWith("cn.zte.") == true) goto L19;
        if (r.info.packageName.startsWith("com.zte.") == true) goto L19;
        return true;
    }
}
