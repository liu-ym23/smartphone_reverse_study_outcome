package com.bytedance.common.wschannel.heartbeat.monitor;

/* JADX INFO: loaded from: classes2.dex */
public interface IHeartBeatMonitor {
    void onPingFail(Throwable r1);

    void onPingSuccess();

    void onPingTimeout();
}
