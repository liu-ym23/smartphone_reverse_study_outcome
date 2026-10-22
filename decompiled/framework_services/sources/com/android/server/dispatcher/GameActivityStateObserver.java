package com.android.server.dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public interface GameActivityStateObserver extends AbsDispatcher.IObserver {
    void onActivityResumed(GameActivityStateEventDispatcher.RecordActivity r1);

    void onFullActivityFirstCreate(GameActivityStateEventDispatcher.RecordActivity r1);
}
