package com.obric.autogui.agents.vlm.models.omni.c;

import android.content.Context;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: PrewarmAdmissionController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: compiled from: PrewarmAdmissionController.kt */
    @d.c.b.a.f(b = "PrewarmAdmissionController.kt", c = {46, 58, 74}, d = "checkAdmission", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.PrewarmAdmissionController")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f28307d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f28308e;
        final /* synthetic */ m f;
        int g;

        a(m r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28308e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public m() {
    }

    public final boolean a(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r3, "packageName");
        com.obric.autogui.operator.a.b.a.b r0 = null;
        com.obric.autogui.operator.a.b.a.c r4 = new com.obric.autogui.operator.a.b.a.b.b.d(r3, null).a(r1);
        if (r4 == null) goto L6;
        r0 = r4.a();
    L6:
        if (r0 != com.obric.autogui.operator.a.b.a.b.f29448d) goto L8;
        return true;
    L8:
        return false;
    }

    public final Object a(Context r13, String r14, d.c.d<? super p> r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        d.c.d r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r17, a.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f28308e;
        Object r18 = d.c.a.b.a();
        int r2 = r0.g;
        com.obric.autogui.agents.vlm.models.impl.applist.black.j.e r10 = null;
        if (r2 == 0) goto L29;
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L20;
        if (r2 != 3) goto L19;
        boolean r19 = r0.f28307d;
        AppBlackListState r110 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r0.f28304a, AppBlackListState.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: CancellationException -> L16 Exception -> L58
    L45:
        com.obric.autogui.agents.vlm.models.impl.applist.black.j.d r111 = (com.obric.autogui.agents.vlm.models.impl.applist.black.j.d) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.vlm.models.impl.applist.black.j.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Exception -> L58
    L46:
        n r112 = n.f28309a;
        if (r111 == null) goto L49;
        boolean r1 = r111.a();
    L50:
        if (r111 == null) goto L52;
        r10 = r111.b();
    L52:
        o r113 = r112.a(r110, r19, r1, r10);
        if (r113 == null) goto L57;
        return new p.b(r113);
    L57:
        return p.a.f28316a;
    L49:
        r1 = false;
        goto L50
        goto L59
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        AppBlackListState r114 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r0.f28306c, AppBlackListState.class, "com.obric.aiagent.plugin");
        String r115 = (String) ZeusTransformUtils.preCheckCast(r0.f28305b, String.class, "com.obric.aiagent.plugin");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r0.f28304a, Context.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: CancellationException -> L24 Exception -> L61
        String r11 = r115;
        r110 = r114;
    L23:
        String r116 = r11;
        boolean r117 = ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: CancellationException -> L24 Exception -> L61
        if (r117 == false) goto L41;
        r19 = r117;
        r111 = null;
        goto L46
    L41:
        com.obric.autogui.agents.vlm.models.impl.applist.black.j r4 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.a(r3);     // Catch: CancellationException -> L16 Exception -> L58
        r0.f28304a = r110;     // Catch: CancellationException -> L16 Exception -> L58
        r0.f28305b = null;     // Catch: CancellationException -> L16 Exception -> L58
        r0.f28306c = null;     // Catch: CancellationException -> L16 Exception -> L58
        r0.f28307d = r117;     // Catch: CancellationException -> L16 Exception -> L58
        r0.g = 3;     // Catch: CancellationException -> L16 Exception -> L58
        Object r118 = r4.a(r116, r0);     // Catch: CancellationException -> L16 Exception -> L58
        if (r118 != r18) goto L44;
        return r18;
    L44:
        r19 = r117;
        r12 = r118;
        goto L45
        goto L62
    L26:
        r14 = (String) ZeusTransformUtils.preCheckCast(r0.f28305b, String.class, "com.obric.aiagent.plugin");
        r16 = (Context) ZeusTransformUtils.preCheckCast(r0.f28304a, Context.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Exception -> L64 CancellationException -> L66
    L33:
        AppBlackListState r119 = (AppBlackListState) ZeusTransformUtils.preCheckCast(r12, AppBlackListState.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L64 CancellationException -> L66
        IAutoActionPlatformStrategyApi r5 = AOPlatformTools.INSTANCE.platformStrategy();     // Catch: CancellationException -> L24 Exception -> L61
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L24 Exception -> L61
        d.h.b.o.c(r6, "getApplicationContext(...)");     // Catch: CancellationException -> L24 Exception -> L61
        r0.f28304a = r16;     // Catch: CancellationException -> L24 Exception -> L61
        r0.f28305b = r14;     // Catch: CancellationException -> L24 Exception -> L61
        r0.f28306c = r119;     // Catch: CancellationException -> L24 Exception -> L61
        r0.g = 2;     // Catch: CancellationException -> L24 Exception -> L61
        Object r7 = IAutoActionPlatformStrategyApi.DefaultImpls.isGloballyWhitelistedPackage$default(r5, r6, r14, null, r0, 4, null);     // Catch: CancellationException -> L24 Exception -> L61
        if (r7 != r18) goto L37;
        return r18;
    L37:
        r11 = r14;
        r110 = r119;
        r12 = r7;
        r3 = r16;
        goto L23
        goto L65
    L29:
        d.o.a(r12);
        com.obric.autogui.agents.vlm.models.impl.applist.black.g r120 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;     // Catch: Exception -> L64 CancellationException -> L66
        r0.f28304a = r16;     // Catch: Exception -> L64 CancellationException -> L66
        r0.f28305b = r14;     // Catch: Exception -> L64 CancellationException -> L66
        r0.g = 1;     // Catch: Exception -> L64 CancellationException -> L66
        r12 = r120.a(r16, r14, r0);     // Catch: Exception -> L64 CancellationException -> L66
        if (r12 != r18) goto L33;
        return r18;
    L24:
        e = move-exception;
        throw e;
    L66:
        e = move-exception;
        throw e;
    L16:
        e = move-exception;
        throw e;
    L62:
        return new p.b(o.h);
    L65:
        return new p.b(o.f);
    L59:
        return new p.b(o.h);
    L7:
        r0 = new a(this, r17);
        goto L8
    }
}
