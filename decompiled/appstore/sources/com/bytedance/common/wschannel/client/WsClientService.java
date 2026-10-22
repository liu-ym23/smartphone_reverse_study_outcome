package com.bytedance.common.wschannel.client;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public class WsClientService extends AbsWsClientService {
    public WsClientService() {
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService
    public void d(WsChannelMsg r10) {
        super.d(r10);
        if (r10 == null) goto L13;
        OnMessageReceiveListener r11 = WsConstants.getListener(r10.getChannelId());     // Catch: Throwable -> L8
        if (r11 == null) goto L14;
        r11.onReceiveMsg(r10);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.client.AbsWsClientService
    public void e(String r10, boolean r11) {
        super.e(r10, r11);
    }
}
