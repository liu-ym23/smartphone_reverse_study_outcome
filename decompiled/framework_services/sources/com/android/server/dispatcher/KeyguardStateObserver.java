package com.android.server.dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public interface KeyguardStateObserver extends AbsDispatcher.IObserver {
    void onKeyguardStateChanged(int r1, KeyguardStateDispatcher.KeyguardState r2);
}
