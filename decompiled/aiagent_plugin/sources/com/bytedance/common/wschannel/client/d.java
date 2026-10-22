package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.SocketState;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReceiveConnectionActionParse.java */
/* JADX INFO: loaded from: classes.dex */
class d extends a {
    public d(b.a r3) {
        super((b.a) ZeusTransformUtils.wrapperContextForParams(r3, b.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.common.wschannel.client.c
    public void a(Intent r4, com.bytedance.common.wschannel.model.a r5) {
        r4.setExtrasClassLoader(SocketState.class.getClassLoader());
        SocketState r6 = (SocketState) ZeusTransformUtils.preCheckCast(r4.getParcelableExtra(WsConstants.KEY_CONNECTION), SocketState.class, "com.obric.aiagent.plugin");
        com.bytedance.common.wschannel.b.c r7 = a(r6.getChannelId(), r6.getConnectionState(), r6.isPrivateProtocolEnabled());     // Catch: Throwable -> L5
        this.f6936a.onReceiveConnectEvent(new com.bytedance.common.wschannel.b.b(r7, r6.getChannelType(), r6.getChannelId()), r6.toJson());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
