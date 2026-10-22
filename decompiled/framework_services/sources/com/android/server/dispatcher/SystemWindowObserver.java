package com.android.server.dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public interface SystemWindowObserver extends AbsDispatcher.IObserver {
    void onFocuesWindowChanged(SystemWindowManagerEventDispatcher.FocuesWindow r1);

    void onSystemWindowChanged(boolean r1, SystemWindowManagerEventDispatcher.SystemWindow r2);
}
