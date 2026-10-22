package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WsClientService extends AbsWsClientService {
    @Override // com.bytedance.common.wschannel.client.b.a
    public void replySendMsgResult(WsChannelMsg r1, boolean r2) {
    }

    public WsClientService() {
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService, com.bytedance.common.wschannel.client.b.a
    public void onReceive(WsChannelMsg r8) {
        if (r8 == null) goto L21;
        com.bytedance.common.wschannel.app.c r7 = WsConstants.getListener(r8.getChannelId());     // Catch: Throwable -> L14
        if (r7 != null) goto L6;
    L8:
        com.bytedance.common.wschannel.app.b r9 = WsConstants.getMessageAckListener();     // Catch: Throwable -> L14
        if (r9 != null) goto L11;
    L17:
        return;
    L11:
        if (r8.isAckMsg() == false) goto L17;
        com.bytedance.common.wschannel.b.d r0 = new com.bytedance.common.wschannel.b.d(r8.getUUID(), r8.getChannelId(), r8.getService(), r8.getMethod(), r8.getLogInfo());     // Catch: Throwable -> L14
        r0.a(r8.getState());     // Catch: Throwable -> L14
        r9.a(r0);     // Catch: Throwable -> L14
        goto L17
    L6:
        if (r8.isAckMsg() == true) goto L8;
        r7.a(r8);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Logger.e(th.toString());
        return;
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService, com.bytedance.common.wschannel.client.b.a
    public void onSendResult(String r1, boolean r2) {
        super.onSendResult(r1, r2);
    }

    @Override // com.bytedance.common.wschannel.client.b.a
    public void onReceiveConnectEvent(com.bytedance.common.wschannel.b.b r1, JSONObject r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        com.bytedance.common.wschannel.app.c r0 = WsConstants.getListener(r1.f6775c);
        if (r0 == null) goto L8;
        r0.a(r1, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.b.a
    public void onReceiveServiceEvent(ServiceConnectEvent r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        WsConstants.setServiceState(r1);
        com.bytedance.common.wschannel.app.d r0 = WsConstants.getServiceConnectListener();
        if (r0 == null) goto L8;
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.b.a
    public void syncState(int r1, com.bytedance.common.wschannel.b.c r2, boolean r3) {
        WsConstants.setConnectionState(r1, r2, r3);
    }
}
