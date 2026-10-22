package com.android.server.wm;

import android.os.IBinder;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImeTargetVisibilityPolicy {
    public abstract boolean removeImeScreenshot(int r1);

    public abstract boolean showImeScreenshot(IBinder r1, int r2);

    public ImeTargetVisibilityPolicy() {
    }

    public static boolean canComputeImeParent(WindowState imeLayeringTarget, InputTarget imeInputTarget) {
        if (imeLayeringTarget != null) goto L6;
        return false;
    L6:
        if (shouldComputeImeParentForEmbeddedActivity(imeLayeringTarget, imeInputTarget) == false) goto L9;
        return true;
    L9:
        if (WindowManager.LayoutParams.mayUseInputMethod(imeLayeringTarget.mAttrs.flags) == false) goto L11;
    L14:
        boolean imeLayeringTargetMayUseIme = true;
    L16:
        if (imeInputTarget != null) goto L18;
    L21:
        boolean inputAndLayeringTargetsDisagree = true;
    L23:
        if (imeLayeringTargetMayUseIme == false) goto L26;
        if (inputAndLayeringTargetsDisagree == false) goto L26;
        boolean inputTargetStale = true;
    L27:
        if (inputTargetStale == false) goto L29;
        return false;
    L29:
        return true;
    L26:
        inputTargetStale = false;
        goto L27
    L18:
        if (imeLayeringTarget.mActivityRecord != imeInputTarget.getActivityRecord()) goto L21;
        inputAndLayeringTargetsDisagree = false;
        goto L23
    L11:
        if (imeLayeringTarget.mAttrs.type == 3) goto L14;
        imeLayeringTargetMayUseIme = false;
        goto L16
    }

    private static boolean shouldComputeImeParentForEmbeddedActivity(WindowState imeLayeringTarget, InputTarget imeInputTarget) {
        if (imeInputTarget == null) goto L30;
        if (imeLayeringTarget == null) goto L30;
        WindowState inputTargetWindow = imeInputTarget.getWindowState();
        if (inputTargetWindow != null) goto L9;
    L29:
        return false;
    L9:
        if (imeLayeringTarget.isAttached() == false) goto L29;
        if (inputTargetWindow.isAttached() == false) goto L29;
        ActivityRecord inputTargetRecord = imeInputTarget.getActivityRecord();
        ActivityRecord layeringTargetRecord = imeLayeringTarget.getActivityRecord();
        if (inputTargetRecord == null) goto L28;
        if (layeringTargetRecord == null) goto L28;
        if (inputTargetRecord == layeringTargetRecord) goto L28;
        if (inputTargetRecord.getTask() != layeringTargetRecord.getTask()) goto L28;
        if (inputTargetRecord.isEmbedded() == false) goto L28;
        if (layeringTargetRecord.isEmbedded() == false) goto L28;
        if (imeLayeringTarget.compareTo(inputTargetWindow) <= 0) goto L31;
        return true;
    L31:
        return false;
    L28:
        return false;
    L30:
        return false;
    }
}
