package com.android.server.wm;

import android.graphics.Rect;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WindowManagerInternalSmtEx extends WindowManagerInternalSmtBase {
    public abstract void dispatchFodKey(int r1);

    public abstract boolean getIgnoreKeyEventFlag();

    public abstract void getStableInsets(int r1, Rect r2);

    public abstract void ignoreKeyEvent(boolean r1);

    public abstract void setStatusBarWindowTranslateY(float r1);

    public abstract void unRegisterAppTransitionListener(WindowManagerInternal.AppTransitionListener r1);

    public abstract WindowState windowForClientLocked(Session r1, IBinder r2, boolean r3);

    public abstract WindowState windowForInputToken(IBinder r1);

    public WindowManagerInternalSmtEx() {
    }
}
