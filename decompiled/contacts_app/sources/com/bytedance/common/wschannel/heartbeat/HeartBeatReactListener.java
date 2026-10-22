package com.bytedance.common.wschannel.heartbeat;

/* JADX INFO: loaded from: classes2.dex */
public interface HeartBeatReactListener {
    void onHeartBeatTimeout();

    void onSendPing();
}
