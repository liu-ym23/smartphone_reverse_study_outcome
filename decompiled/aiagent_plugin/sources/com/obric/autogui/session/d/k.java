package com.obric.autogui.session.d;

import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ScriptAbilityAsyncResource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends com.obric.autogui.session.d.a<List<? extends com.obric.autogui.agents.scripted.api.a>> {
    private static final String TAG = "ScriptAbilityAsyncResource";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f30921b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.session.a f30922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Set<String> f30923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.session.d.c<List<com.obric.autogui.agents.scripted.api.a>> f30924e;

    /* JADX INFO: compiled from: ScriptAbilityAsyncResource.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScriptAbilityAsyncResource.kt */
    @d.c.b.a.f(b = "ScriptAbilityAsyncResource.kt", c = {29}, d = "fetchAbilities", e = "com.obric.autogui.session.preload.ScriptAbilityAsyncResource")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f30925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f30926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f30927c;

        b(k r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30926b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30925a = r3;
            this.f30927c |= Integer.MIN_VALUE;
            return k.a(this.f30926b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScriptAbilityAsyncResource.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.b<d.c.d<? super List<? extends com.obric.autogui.agents.scripted.api.a>>, Object> {
        c(Object r8) {
            super(1, r8, k.class, "fetchAbilities", "fetchAbilities(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object a(d.c.d<? super List<com.obric.autogui.agents.scripted.api.a>> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return k.a((k) ZeusTransformUtils.preCheckCast(this.receiver, k.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super List<? extends com.obric.autogui.agents.scripted.api.a>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f30921b = new a(null);
    }

    public static /* synthetic */ boolean lambda$3Z4vCBmln9Ahxe17MWnrkj94JH8() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$4IdKX1DZnd9-JyPN9gXMHODSm2o, reason: not valid java name */
    public static /* synthetic */ x m889lambda$4IdKX1DZnd9JyPN9gXMHODSm2o(k r0, Set r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ List lambda$NjBUULbvK8CHx3ttyih0GyeHNTI() {
        return f();
    }

    public static final /* synthetic */ Object a(k r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public k(com.obric.autogui.session.a r11, Set<String> r12) {
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        o.e(r11, SensitiveType.SESSION);
        o.e(r13, "initialBlockedAbilitySnapshot");
        super(null, 1, null);
        this.f30922c = r11;
        this.f30923d = r13;
        this.f30924e = new com.obric.autogui.session.d.c(TAG, (d.h.a.b) ZeusTransformUtils.preCheckCast((d.m.e) ZeusTransformUtils.preCheckCast(new c(this), d.m.e.class, "com.obric.aiagent.plugin"), d.h.a.b.class, "com.obric.aiagent.plugin"), $$Lambda$k$NjBUULbvK8CHx3ttyih0GyeHNTI.INSTANCE, $$Lambda$k$3Z4vCBmln9Ahxe17MWnrkj94JH8.INSTANCE, null, 16, null);
    }

    @Override // com.obric.autogui.session.d.a
    public com.obric.autogui.session.d.c<List<? extends com.obric.autogui.agents.scripted.api.a>> a() {
        return this.f30924e;
    }

    private static final boolean g() {
        return com.obric.autogui.common.a.d.f28974a.q();
    }

    private static final List f() {
        return p.b();
    }

    private final Object b(d.c.d<? super List<com.obric.autogui.agents.scripted.api.a>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        if ((r0.f30927c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30927c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f30925a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30927c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r9);
    L19:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L22;
        return r6;
    L22:
        return p.b();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        IJSScriptService r10 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L22;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30922c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Set<String> r5 = this.f30923d;
        String r11 = this.f30922c.b();
        r0.f30927c = 1;
        r9 = r10.getSupportedAbilityList(r4, r5, r11, r0);
        if (r9 != r2) goto L19;
        return r2;
    L7:
        r0 = new b(this, r8);
        goto L8
    }

    public final void a(Set<String> r3) {
        final Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        o.e(r4, "blockedAbilitySnapshot");
        a(new $$Lambda$k$4IdKX1DZnd9JyPN9gXMHODSm2o(this, r4));
    }

    private static final x a(k r2, Set r3) {
        r2.f30923d = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        return x.f38692a;
    }
}
