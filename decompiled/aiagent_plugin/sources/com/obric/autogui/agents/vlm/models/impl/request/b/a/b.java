package com.obric.autogui.agents.vlm.models.impl.request.b.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: StdModelHttpInferencingError.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.autogui.agents.vlm.models.impl.request.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.tools.api.net.b f28042a;

    /* JADX INFO: compiled from: StdModelHttpInferencingError.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28043a = null;

        static {
            int[] r0 = new int[com.obric.autogui.tools.api.net.c.values().length];
            r0[com.obric.autogui.tools.api.net.c.f31482a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[com.obric.autogui.tools.api.net.c.f31483b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[com.obric.autogui.tools.api.net.c.i.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[com.obric.autogui.tools.api.net.c.g.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[com.obric.autogui.tools.api.net.c.f31484c.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[com.obric.autogui.tools.api.net.c.f31485d.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[com.obric.autogui.tools.api.net.c.f31486e.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[com.obric.autogui.tools.api.net.c.f.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[com.obric.autogui.tools.api.net.c.h.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[com.obric.autogui.tools.api.net.c.j.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f28043a = r0;
        }
    }

    public b(com.obric.autogui.tools.api.net.b r3) {
        com.obric.autogui.tools.api.net.b r4 = (com.obric.autogui.tools.api.net.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "httpException");
        this.f28042a = r4;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.b a() {
        com.obric.autogui.tools.api.net.c r1 = this.f28042a.getType();
        switch(a.f28043a[r1.ordinal()]) {
            case 1: goto L11;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L5;
        };
    L5:
        throw new k();
    L12:
        return com.obric.autogui.agents.vlm.models.impl.request.b.b.f28052c;
    L13:
        return com.obric.autogui.agents.vlm.models.impl.request.b.b.f28053d;
    L14:
        return com.obric.autogui.agents.vlm.models.impl.request.b.b.f28054e;
    L15:
        return com.obric.autogui.agents.vlm.models.impl.request.b.b.i;
    L11:
        return com.obric.autogui.agents.vlm.models.impl.request.b.b.f28051b;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public String a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        switch(a.f28043a[this.f28042a.getType().ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        String r5 = r7.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_network_responded_failure, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_network_responded_failure"), new Object[]{this.f28042a.a()});
        o.a(r5);
        return r5;
    L7:
        String r8 = r7.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_network_transfer_failure, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_network_transfer_failure"), new Object[]{this.f28042a.a()});
        o.a(r8);
        return r8;
    L8:
        String r9 = r7.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_network_not_reachable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_network_not_reachable"), new Object[]{this.f28042a.a()});
        o.a(r9);
        return r9;
    L9:
        String r10 = r7.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_network_weak, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_network_weak"), new Object[]{this.f28042a.a()});
        o.a(r10);
        return r10;
    L10:
        String r11 = r7.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_network_unstable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_network_unstable"), new Object[]{this.f28042a.a()});
        o.a(r11);
        return r11;
    L11:
        String r12 = r7.getString(ZeusTransformUtils.mapRes(R.string.agent_thinking_streaming_network_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_thinking_streaming_network_error"));
        o.a(r12);
        return r12;
    L12:
        String r13 = r7.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_network_timedout, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_network_timedout"), new Object[]{this.f28042a.a()});
        o.a(r13);
        return r13;
    L13:
        String r14 = r7.getString(ZeusTransformUtils.mapRes(R.string.std_model_err_thinking_streaming_network_bad_request, WsChannelMultiProcessSharedProvider.STRING_TYPE, "std_model_err_thinking_streaming_network_bad_request"), new Object[]{this.f28042a.a()});
        o.a(r14);
        return r14;
    L14:
        String r15 = r7.getString(ZeusTransformUtils.mapRes(R.string.agent_thinking_streaming_cancelled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_thinking_streaming_cancelled"));
        o.a(r15);
        return r15;
    L15:
        String r16 = r7.getString(ZeusTransformUtils.mapRes(R.string.agent_thinking_streaming_cancelled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_thinking_streaming_cancelled"));
        o.a(r16);
        return r16;
    L5:
        throw new k();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
    public com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a b() {
        com.obric.autogui.tools.api.net.c r1 = this.f28042a.getType();
        switch(a.f28043a[r1.ordinal()]) {
            case 1: goto L9;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L10;
            case 9: goto L10;
            case 10: goto L11;
            default: goto L5;
        };
    L5:
        throw new k();
    L10:
        return com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28035a;
    L11:
        return com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28036b;
    L9:
        return com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28035a;
    }
}
