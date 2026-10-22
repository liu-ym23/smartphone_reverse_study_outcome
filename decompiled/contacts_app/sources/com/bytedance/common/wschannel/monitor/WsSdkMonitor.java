package com.bytedance.common.wschannel.monitor;

import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class WsSdkMonitor {
    public WsSdkMonitor(IWsSdkMonitor r1) {
        HeartBeatMonitor.getInstance().setHeartBeatMonitor(r1);
    }
}
