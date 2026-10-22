package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public interface WindowProcessListenerSmtBase {
    void bringProcessToDefaultLocked();

    void canclePrefetch();

    String getProcessName();

    void unFreezeProcIfNeed(FrozenPendingEvent r1);
}
