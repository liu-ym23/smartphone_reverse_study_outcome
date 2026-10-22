package com.android.server.wm;

import android.util.proto.ProtoOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface WindowProcessListener {
    void appDied(String r1);

    void clearProfilerIfNeeded();

    void dumpDebug(ProtoOutputStream r1, long r2);

    long getCpuTime();

    WindowProcessListenerSmtBase getSmtEx();

    boolean isCached();

    boolean isRemoved();

    void onStartActivity(int r1, boolean r2, String r3, long r4);

    void setPendingUiClean(boolean r1);

    void setPendingUiCleanAndForceProcessStateUpTo(int r1);

    void setRunningRemoteAnimation(boolean r1);

    void updateProcessInfo(boolean r1, boolean r2, boolean r3);

    void updateServiceConnectionActivities();
}
