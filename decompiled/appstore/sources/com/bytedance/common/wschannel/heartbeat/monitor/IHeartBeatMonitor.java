package com.bytedance.common.wschannel.heartbeat.monitor;

/* JADX INFO: loaded from: classes.dex */
public interface IHeartBeatMonitor {
    void onPingFail(Throwable r10);

    void onPingSuccess();

    void onPingTimeout();
}
