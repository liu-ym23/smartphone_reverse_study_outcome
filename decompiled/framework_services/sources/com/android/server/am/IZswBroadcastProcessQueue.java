package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public interface IZswBroadcastProcessQueue {
    String getLogString();

    void onBroadcastDequeued(BroadcastRecord r1);

    void onBroadcastEnqueued(BroadcastRecord r1, int r2);

    void setOldScheduleBroadcast(BroadcastRecord r1, Object r2, int r3);

    boolean setProcessFreezable(BroadcastProcessQueue r1, boolean r2);
}
