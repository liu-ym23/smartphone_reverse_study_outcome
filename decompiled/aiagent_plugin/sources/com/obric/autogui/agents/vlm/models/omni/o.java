package com.obric.autogui.agents.vlm.models.omni;

import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.de;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: OmniRequestDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends com.obric.autogui.agents.vlm.models.impl.request.a.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.b.C0677b f28445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f28447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f28448e;

    /* JADX INFO: compiled from: OmniRequestDelegate.kt */
    @d.c.b.a.f(b = "OmniRequestDelegate.kt", c = {134}, d = "awaitResponse", e = "com.obric.autogui.agents.vlm.models.omni.OmniModelRequest")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f28450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o f28451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f28452d;

        a(o r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28451c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28450b = r3;
            this.f28452d |= Integer.MIN_VALUE;
            return this.f28451c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniRequestDelegate.kt */
    @d.c.b.a.f(b = "OmniRequestDelegate.kt", c = {135}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.OmniModelRequest$awaitResponse$data$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super l>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f28454b;

        b(r r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28454b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super l> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f28454b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super l> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28453a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            r r6 = this.f28454b;
            d.c.d<? super l> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28453a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public o(com.obric.autogui.agents.vlm.b.C0677b r2, String r3, int r4) {
        d.h.b.o.e(r2, SensitiveType.SESSION);
        d.h.b.o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        this.f28445b = r2;
        this.f28446c = r3;
        this.f28447d = r4;
        this.f28448e = true;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
    public boolean a() {
        return this.f28448e;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
    public Object a(d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.a.d> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r16, a.class, "com.obric.aiagent.plugin");
        if ((r0.f28452d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28452d -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f28450b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f28452d;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        o this = (o) ZeusTransformUtils.preCheckCast(r0.f28449a, o.class, "com.obric.aiagent.plugin");
        d.o.a(r17);     // Catch: Exception -> L14 CancellationException -> L16 de -> L31
    L27:
    L36:
        return (com.obric.autogui.agents.vlm.models.impl.request.a.d) ZeusTransformUtils.preCheckCast(new p(true, ((l) ZeusTransformUtils.preCheckCast(r17, l.class, "com.obric.aiagent.plugin")).a().d(), null, 4, null), com.obric.autogui.agents.vlm.models.impl.request.a.d.class, "com.obric.aiagent.plugin");
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r17);
        r r18 = t.f28523a.a(this.f28446c);
        if (r18 == null) goto L23;
        long r8 = this.f28447d;     // Catch: Exception -> L14 CancellationException -> L16 de -> L31
        d.h.a.m r19 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r18, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14 CancellationException -> L16 de -> L31
        r0.f28449a = this;     // Catch: Exception -> L14 CancellationException -> L16 de -> L31
        r0.f28452d = 1;     // Catch: Exception -> L14 CancellationException -> L16 de -> L31
        r17 = dg.a(r8, r19, r0);     // Catch: Exception -> L14 CancellationException -> L16 de -> L31
        if (r17 != r2) goto L27;
        return r2;
    L23:
        return new p(false, null, com.obric.autogui.agents.vlm.models.impl.request.b.b.f28050a);
    L31:
        Loog.INSTANCE.w("OmniModelRequest", "awaitResponse timed out, sessionId=" + this.f28446c + ", timeoutMillis=" + this.f28447d);
        return (com.obric.autogui.agents.vlm.models.impl.request.a.d) ZeusTransformUtils.preCheckCast(new p(false, null, com.obric.autogui.agents.vlm.models.impl.request.b.b.f28054e), com.obric.autogui.agents.vlm.models.impl.request.a.d.class, "com.obric.aiagent.plugin");
    L16:
        e = move-exception;
        throw e;
    L14:
        e = move-exception;
        Loog.INSTANCE.e("OmniModelRequest", "Channel closed or interrupted", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (com.obric.autogui.agents.vlm.models.impl.request.a.d) ZeusTransformUtils.preCheckCast(new p(false, null, com.obric.autogui.agents.vlm.models.impl.request.b.b.f), com.obric.autogui.agents.vlm.models.impl.request.a.d.class, "com.obric.aiagent.plugin");
    L7:
        r0 = new a(this, r16);
        goto L8
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
    public com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r3) {
        d.h.b.o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new n(com.obric.autogui.agents.vlm.models.impl.request.b.b.f, "omni_request_failed"), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
    }
}
