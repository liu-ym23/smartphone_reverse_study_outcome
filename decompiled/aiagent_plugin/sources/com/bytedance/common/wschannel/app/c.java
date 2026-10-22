package com.bytedance.common.wschannel.app;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: compiled from: OnMessageReceiveListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface c {
    void a(com.bytedance.common.wschannel.b.b r1, JSONObject r2);

    void a(WsChannelMsg r1);
}
