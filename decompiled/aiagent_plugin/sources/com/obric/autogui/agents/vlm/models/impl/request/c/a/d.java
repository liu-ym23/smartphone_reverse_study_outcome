package com.obric.autogui.agents.vlm.models.impl.request.c.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: StreamingResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.obric.autogui.agents.vlm.models.impl.request.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsonObject f28102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f28103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.request.b.a f28104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f28105d;

    /* JADX INFO: compiled from: StreamingResponse.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f28106a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f28107b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f28108c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f28109d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f28110e = null;
        public static final a f = null;
        private static final /* synthetic */ a[] g = null;
        private static final /* synthetic */ d.d.a h = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f28106a, f28107b, f28108c, f28109d, f28110e, f};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f28106a = new a("None", 0);
            f28107b = new a("UserTerminated", 1);
            f28108c = new a("StreamTermBeforeActionReceived", 2);
            f28109d = new a("UnexpectedFrameFormat", 3);
            f28110e = new a("NetError", 4);
            f = new a("ServiceRespondedError", 5);
            a[] r0 = a();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: StreamingResponse.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28111a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f28106a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[a.f28107b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[a.f28108c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[a.f28109d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[a.f28110e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[a.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f28111a = r0;
        }
    }

    public d(JsonObject r3, a r4, com.obric.autogui.agents.vlm.models.impl.request.b.a r5) {
        com.obric.autogui.agents.vlm.models.impl.request.b.a r6 = (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "streamTermType");
        this.f28102a = r3;
        this.f28103b = r4;
        this.f28104c = r6;
        if (r3 == null) goto L5;
        boolean r7 = true;
    L6:
        this.f28105d = r7;
        return;
    L5:
        r7 = false;
        goto L6
    }

    public /* synthetic */ d(JsonObject r2, a r3, com.obric.autogui.agents.vlm.models.impl.request.b.a r4, int r5, h r6) {
        com.obric.autogui.agents.vlm.models.impl.request.b.a r7 = (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = a.f28106a;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r7 = null;
    L8:
        this(r2, r3, r7);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
    public boolean a() {
        return this.f28105d;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
    public JsonObject b() {
        JsonObject r0 = this.f28102a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new JsonObject();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
    public com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        com.obric.autogui.agents.vlm.models.impl.request.b.a r0 = this.f28104c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return b(r4);
    }

    private final com.obric.autogui.agents.vlm.models.impl.request.b.a b(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.request.b.b r0 = com.obric.autogui.agents.vlm.models.impl.request.b.b.h;
        a r4 = this.f28103b;
        switch(b.f28111a[r4.ordinal()]) {
            case 1: goto L16;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L10:
        String r7 = r6.getString(ZeusTransformUtils.mapRes(R.string.agent_task_early_term_model_api_streaming_format_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_model_api_streaming_format_error"));
        o.c(r7, "getString(...)");
        com.obric.autogui.agents.vlm.models.impl.request.b.b r8 = com.obric.autogui.agents.vlm.models.impl.request.b.b.h;
    L14:
        return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.b.a.a(r8, com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28035a, r7), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
    L11:
        r7 = r6.getString(ZeusTransformUtils.mapRes(R.string.agent_task_early_term_model_api_streaming_early_terminated, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_model_api_streaming_early_terminated"));
        o.c(r7, "getString(...)");
        r8 = com.obric.autogui.agents.vlm.models.impl.request.b.b.f;
        goto L14
    L12:
        r7 = r6.getString(ZeusTransformUtils.mapRes(R.string.agent_task_early_terminated_by_user, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_terminated_by_user"));
        o.c(r7, "getString(...)");
        r8 = com.obric.autogui.agents.vlm.models.impl.request.b.b.f28051b;
        goto L14
    L5:
        throw new k();
    L7:
        return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.vlm.models.impl.request.b.a.c.f28044a, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
    L9:
        return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.vlm.models.impl.request.b.a.c.f28044a, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
    L16:
        return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.vlm.models.impl.request.b.a.c.f28044a, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
    }
}
