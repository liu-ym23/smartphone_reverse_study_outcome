package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.m;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WsChannelSingleProcessImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements j {
    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r1, boolean r2, boolean r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
    }

    public k() {
    }

    private void b(Context r2, int r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L16;
        if (r3 > 0) goto L6;
        return;
    L6:
        if (r3 <= 3) goto L9;
        return;
    L9:
        if (Logger.debug() == false) goto L12;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r3);
    L12:
        if (m.a(r1).c() == true) goto L14;
        return;
    L14:
        Message r4 = new Message();
        r4.what = 2;
        r4.arg1 = r3;
        com.bytedance.common.wschannel.server.g.a(r1).handleMsg(r4);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r3) {
        b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), 1);
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r3, WsChannelMsg r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        j.a r0 = new j.a();
        r0.f6938a = "payload";
        r0.f6939b = r4;
        r0.f6940c = 5;
        a(r5, r0);
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r3, SsWsApp r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        j.a r0 = new j.a();
        r0.f6938a = WsConstants.KEY_WS_APP;
        r0.f6939b = r4;
        r0.f6940c = 0;
        a(r5, r0);
    }

    private void a(Context r3, j.a r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Message r5 = Message.obtain();
        r5.what = r4.f6940c;
        r5.getData().putParcelable(r4.f6938a, r4.f6939b);
        com.bytedance.common.wschannel.server.g.a(r2).handleMsg(r5);
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        j.a r0 = new j.a();
        r0.f6938a = WsConstants.KEY_WS_APP;
        r0.f6939b = new IntegerParcelable(r4);
        r0.f6940c = 1;
        a(r5, r0);
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void b(Context r3, SsWsApp r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (m.a(r5).c() == true) goto L5;
        return;
    L5:
        j.a r0 = new j.a();
        r0.f6938a = WsConstants.KEY_WS_APP;
        r0.f6939b = r4;
        r0.f6940c = 4;
        a(r5, r0);
    }

    @Override // com.bytedance.common.wschannel.client.j
    public void b(Context r3) {
        b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), 2);
    }
}
