package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.SocketState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SyncConnectStateParse.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends a {
    public i(b.a r3) {
        super((b.a) ZeusTransformUtils.wrapperContextForParams(r3, b.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.common.wschannel.client.c
    public void a(Intent r3, com.bytedance.common.wschannel.model.a r4) {
        Logger.d(AbsWsClientService.TAG, "sync socket state");
        r3.setExtrasClassLoader(SocketState.class.getClassLoader());
        ArrayList r5 = r3.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);
        if (r5 == null) goto L10;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        SocketState r7 = (SocketState) ZeusTransformUtils.preCheckCast(r6.next(), SocketState.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L6;
        a(r7.getChannelId(), r7.getConnectionState(), r7.isPrivateProtocolEnabled());
        goto L6
    L16:
        return;
    }
}
