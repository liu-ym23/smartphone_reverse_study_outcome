package com.android.server.wm;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.KeyEvent;
import com.android.internal.inputmethod.IRemoteInputConnection;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExtWindowManagerInternal {
    public abstract IBinder getAutoFocusedWindowToken();

    public abstract Bitmap getWallPaperScreenShot(IBinder r1);

    public abstract void hideImeInAuto(int r1);

    public abstract boolean hideImeInAuto(IBinder r1, int r2);

    public abstract boolean interceptKeyEventToLauncher(KeyEvent r1);

    public abstract boolean isPkgRunWithOAuto(String r1);

    public abstract boolean shouldBlockVibrationForAuto(String r1);

    public abstract boolean showImeInAuto(IBinder r1, int r2);

    public ExtWindowManagerInternal() {
    }

    public void setFakeInputConnection(IRemoteInputConnection currentInputConnection) {
    }
}
