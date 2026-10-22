package com.obric.autogui.agents.vlm.models.impl.request.b.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: StdModelRequestDefaultError.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.obric.autogui.agents.vlm.models.impl.request.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f28044a = null;

    static {
        f28044a = new c();
    }

    private c() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.b a() {
        return com.obric.autogui.agents.vlm.models.impl.request.b.b.f28053d;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public String a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        String r4 = r2.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_unhandleable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_unhandleable"));
        o.c(r4, "getString(...)");
        return r4;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a b() {
        return com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28035a;
    }
}
