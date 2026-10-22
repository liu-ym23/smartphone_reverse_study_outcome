package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: compiled from: MainClientMsgListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements com.bytedance.common.wschannel.client.b.a {
    @Override // com.bytedance.common.wschannel.client.b.a
    public void onSendResult(String r1, boolean r2) {
    }

    public d() {
    }

    @Override // com.bytedance.common.wschannel.client.b.a
    public void onReceive(WsChannelMsg r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        j r0 = l.a(r1.getChannelId());
        if (r0 == null) goto L8;
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.b.a
    public void onReceiveConnectEvent(com.bytedance.common.wschannel.b.b r1, JSONObject r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        j r0 = l.a(r1.f6775c);
        if (r0 == null) goto L8;
        r0.a(r1, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.b.a
    public void onReceiveServiceEvent(ServiceConnectEvent r1) {
        j r0 = l.a(r1.getChannelId());
        if (r0 == null) goto L6;
        r0.b(r1);
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.b.a
    public void syncState(int r1, com.bytedance.common.wschannel.b.c r2, boolean r3) {
        j r0 = l.a(r1);
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.b.a
    public void replySendMsgResult(WsChannelMsg r1, boolean r2) {
        j r0 = l.a(r1.getChannelId());
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }
}
