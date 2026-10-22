package com.obric.autogui.net.push;

import android.content.Context;
import com.obric.autogui.net.push.internal.a;
import com.obric.autogui.tools.api.net.push.IAutoActionPushApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PushApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PushApiImpl implements IAutoActionPushApi {
    public PushApiImpl() {
    }

    @Override // com.obric.autogui.tools.api.net.push.IAutoActionPushApi
    public void init(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        a.f29134a.a(r1);
    }

    @Override // com.obric.autogui.tools.api.net.push.IAutoActionPushApi
    public void registerPushMessageCallback(com.obric.autogui.tools.api.net.push.a r2) {
        com.obric.autogui.tools.api.net.push.a r1 = (com.obric.autogui.tools.api.net.push.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.tools.api.net.push.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        a.f29134a.a(r1);
    }

    @Override // com.obric.autogui.tools.api.net.push.IAutoActionPushApi
    public void unregisterPushMessageCallback(com.obric.autogui.tools.api.net.push.a r2) {
        com.obric.autogui.tools.api.net.push.a r1 = (com.obric.autogui.tools.api.net.push.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.tools.api.net.push.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        a.f29134a.b(r1);
    }
}
