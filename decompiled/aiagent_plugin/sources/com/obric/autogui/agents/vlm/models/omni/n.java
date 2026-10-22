package com.obric.autogui.agents.vlm.models.omni;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniRequestDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements com.obric.autogui.agents.vlm.models.impl.request.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.request.b.b f28441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a f28443c;

    /* JADX INFO: compiled from: OmniRequestDelegate.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28444a = null;

        static {
            int[] r0 = new int[com.obric.autogui.agents.vlm.models.impl.request.b.b.values().length];
            r0[com.obric.autogui.agents.vlm.models.impl.request.b.b.f28054e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[com.obric.autogui.agents.vlm.models.impl.request.b.b.f28051b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[com.obric.autogui.agents.vlm.models.impl.request.b.b.f28053d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[com.obric.autogui.agents.vlm.models.impl.request.b.b.f28050a.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f28444a = r0;
        }
    }

    public n(com.obric.autogui.agents.vlm.models.impl.request.b.b r2, String r3) {
        d.h.b.o.e(r2, "errorType");
        this.f28441a = r2;
        this.f28442b = r3;
        this.f28443c = com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28036b;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.b a() {
        return this.f28441a;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a b() {
        return this.f28443c;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public String a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        com.obric.autogui.agents.vlm.models.impl.request.b.b r0 = a();
        int r1 = a.f28444a[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_network_timedout, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_network_timedout");
        Object[] r3 = new Object[1];
        String r4 = this.f28442b;
        if (r4 != null) goto L17;
        r4 = "omni";
    L17:
        r3[0] = r4;
        String r7 = r6.getString(r2, r3);
        d.h.b.o.a(r7);
        return r7;
    L5:
        if (r1 != 2) goto L7;
        String r8 = r6.getString(ZeusTransformUtils.mapRes(R.string.agent_thinking_streaming_cancelled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_thinking_streaming_cancelled"));
        d.h.b.o.a(r8);
        return r8;
    L7:
        if (r1 != 3) goto L9;
        String r9 = r6.getString(ZeusTransformUtils.mapRes(R.string.agent_thinking_streaming_network_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_thinking_streaming_network_error"));
        d.h.b.o.a(r9);
        return r9;
    L9:
        if (r1 == 4) goto L11;
        String r10 = r6.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_unhandleable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_unhandleable"));
        d.h.b.o.a(r10);
        return r10;
    L11:
        String r11 = r6.getString(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
        d.h.b.o.a(r11);
        return r11;
    }
}
