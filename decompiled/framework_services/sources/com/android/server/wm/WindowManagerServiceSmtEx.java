package com.android.server.wm;

import android.graphics.Point;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public class WindowManagerServiceSmtEx extends WindowManagerServiceSmtBase {
    protected WindowManagerServiceSmtEx(WindowManagerService wmService) {
        super(wmService);
    }

    public String getFocusWindowPackageName() {
        DisplayContent dc = this.mWmService.mRoot.getTopFocusedDisplayContent();     // Catch: Exception -> L9
        if (dc != null) goto L6;
    L11:
        return "";
    L6:
        if (dc.mCurrentFocus == null) goto L11;
        return dc.mCurrentFocus.mAttrs.packageName;
    L9:
        e = move-exception;
        Slog.e("WindowManager", "failed to getAppPackageName", e);
        return "";
    }

    public void getInitialDisplaySize(int displayId, Point size) {
        this.mWmService.getInitialDisplaySize(displayId, size);
    }
}
