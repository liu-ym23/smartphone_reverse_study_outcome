package com.obric.autogui.net.wschannel;

import android.app.Application;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.net.wschannel.a.a;
import com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: WsChannelApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WsChannelApiImpl implements IAutoActionWsChannelApi {
    public WsChannelApiImpl() {
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "I am WsChannel!");
    }

    @Override // com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi
    public void init(Application r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "init, context: " + r5);
        a.f29245a.a(r5);
    }

    @Override // com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi
    public void connect() {
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "connect");
        a.f29245a.a();
    }

    @Override // com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi
    public void disconnect() {
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "disconnect");
        a.f29245a.b();
    }

    @Override // com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi
    public void sendMessage(String r4, q<? super Boolean, ? super String, ? super Exception, x> r5) {
        q<? super Boolean, ? super String, ? super Exception, x> r6 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        o.e(r4, "jsonMessage");
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "sendMessage, jsonMessage: " + r4 + ", listener: " + r6);
        a.f29245a.a(r4, r6);
    }

    @Override // com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi
    public void registerOnReceiveCallback(com.obric.autogui.tools.api.net.wschannel.a r4) {
        com.obric.autogui.tools.api.net.wschannel.a r5 = (com.obric.autogui.tools.api.net.wschannel.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.tools.api.net.wschannel.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "callback");
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "registerOnReceiveCallback, callback: " + r5);
        a.f29245a.a(r5);
    }

    @Override // com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi
    public void unregisterOnReceiveCallback(com.obric.autogui.tools.api.net.wschannel.a r4) {
        com.obric.autogui.tools.api.net.wschannel.a r5 = (com.obric.autogui.tools.api.net.wschannel.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.tools.api.net.wschannel.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "callback");
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "unregisterOnReceiveCallback, callback: " + r5);
        a.f29245a.b(r5);
    }

    @Override // com.obric.autogui.tools.api.net.wschannel.IAutoActionWsChannelApi
    public boolean isConnected() {
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "isConnected");
        boolean r0 = a.f29245a.c();
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "isConnected, result: " + r0);
        return r0;
    }
}
