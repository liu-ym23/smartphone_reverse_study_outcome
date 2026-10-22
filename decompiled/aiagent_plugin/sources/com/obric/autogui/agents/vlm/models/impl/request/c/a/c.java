package com.obric.autogui.agents.vlm.models.impl.request.c.a;

import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StreamingRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autogui.agents.vlm.models.impl.request.a.c {
    private static final String TAG = "M-Std-SSE/SSE-Req";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f28095b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.a.d<f> f28096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.tools.api.net.a.b f28097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f28098e;
    private final com.obric.autogui.agents.vlm.models.impl.request.c.a.b f;

    /* JADX INFO: compiled from: StreamingRequest.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StreamingRequest.kt */
    @d.c.b.a.f(b = "StreamingRequest.kt", c = {50}, d = "awaitResponse", e = "com.obric.autogui.agents.vlm.models.impl.request.sse.streaming.StreamingRequest")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f28099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f28100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f28101c;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28100b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28099a = r3;
            this.f28101c |= Integer.MIN_VALUE;
            return this.f28100b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f28095b = new a(null);
    }

    public final kotlinx.coroutines.a.d<f> c() {
        return this.f28096c;
    }

    public c(com.obric.autogui.agents.vlm.b.C0677b r3, String r4, String r5, kotlinx.coroutines.a.d<f> r6, com.obric.autogui.tools.api.net.a.b r7) {
        kotlinx.coroutines.a.d<f> r8 = (kotlinx.coroutines.a.d) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.tools.api.net.a.b r9 = (com.obric.autogui.tools.api.net.a.b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.tools.api.net.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, SensitiveType.SESSION);
        o.e(r4, "stepId");
        o.e(r5, "requestId");
        o.e(r8, "replyChannel");
        this.f28096c = r8;
        this.f28097d = r9;
        this.f28098e = true;
        a(1 | b());
        this.f = new com.obric.autogui.agents.vlm.models.impl.request.c.a.b(r3, r4, r5, this);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
    public boolean a() {
        return this.f28098e;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
    public Object a(d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.a.d> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin");
        if ((r0.f28101c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28101c -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f28099a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f28101c;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        d.o.a(r11);     // Catch: com.obric.autogui.agents.vlm.models.impl.request.c.a.b.C0708b -> L13
    L21:
        return (com.obric.autogui.agents.vlm.models.impl.request.a.d) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.agents.vlm.models.impl.request.a.d.class, "com.obric.aiagent.plugin");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r11);
        com.obric.autogui.agents.vlm.models.impl.request.c.a.b r8 = this.f;     // Catch: com.obric.autogui.agents.vlm.models.impl.request.c.a.b.C0708b -> L13
        r0.f28101c = 1;     // Catch: com.obric.autogui.agents.vlm.models.impl.request.c.a.b.C0708b -> L13
        r11 = r8.a(r0);     // Catch: com.obric.autogui.agents.vlm.models.impl.request.c.a.b.C0708b -> L13
        if (r11 != r2) goto L21;
        return r2;
    L13:
        e = move-exception;
        return (com.obric.autogui.agents.vlm.models.impl.request.a.d) ZeusTransformUtils.preCheckCast(new d(null, e.a(), null, 4, null), com.obric.autogui.agents.vlm.models.impl.request.a.d.class, "com.obric.aiagent.plugin");
    L7:
        r0 = new b(this, r10);
        goto L8
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
    public com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r2) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        throw new UnsupportedOperationException("analyseError() called on a succeeded streaming request.");
    }

    public final void d() {
        com.obric.autogui.tools.api.net.a.b r3 = this.f28097d;     // Catch: Throwable -> L6
        if (r3 == null) goto L11;
        r3.a();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Thrown " + th + " in cancelReceiving.", th);
    }
}
