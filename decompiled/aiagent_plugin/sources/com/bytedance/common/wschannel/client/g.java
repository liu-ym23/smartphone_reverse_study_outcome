package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReceiveServiceActionParse.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    public g(b.a r3) {
        super((b.a) ZeusTransformUtils.wrapperContextForParams(r3, b.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.common.wschannel.client.c
    public void a(Intent r2, com.bytedance.common.wschannel.model.a r3) {
        r2.setExtrasClassLoader(ServiceConnectEvent.class.getClassLoader());
        ServiceConnectEvent r4 = (ServiceConnectEvent) ZeusTransformUtils.preCheckCast(r2.getParcelableExtra(WsConstants.KEY_SERVICE), ServiceConnectEvent.class, "com.obric.aiagent.plugin");
        this.f6936a.onReceiveServiceEvent(r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
