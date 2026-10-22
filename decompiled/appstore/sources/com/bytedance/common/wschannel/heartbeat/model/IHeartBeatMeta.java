package com.bytedance.common.wschannel.heartbeat.model;

import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;

/* JADX INFO: loaded from: classes.dex */
public interface IHeartBeatMeta<T extends IHeartBeatMeta> {
    T provideDefaultMeta();
}
