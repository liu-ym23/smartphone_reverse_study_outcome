package com.obric.autoaction.vdplayer.b.a;

import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;

/* JADX INFO: compiled from: EnterCallUserUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EnterCallUserUseCase.kt */
    public static final enum EnumC0606a extends Enum<EnumC0606a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0606a f25181a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0606a f25182b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0606a f25183c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0606a[] f25184d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f25185e = null;

        private static final /* synthetic */ EnumC0606a[] a() {
            return new EnumC0606a[]{f25181a, f25182b, f25183c};
        }

        private EnumC0606a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f25181a = new EnumC0606a("SUCCESS", 0);
            f25182b = new EnumC0606a("FAIL", 1);
            f25183c = new EnumC0606a("FAIL_BEFORE_CALL_USER", 2);
            EnumC0606a[] r0 = a();
            f25184d = r0;
            f25185e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0606a valueOf(String r2) {
            return (EnumC0606a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0606a.class, r2), EnumC0606a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0606a[] values() {
            return (EnumC0606a[]) ZeusTransformUtils.preCheckCast(f25184d.clone(), EnumC0606a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: EnterCallUserUseCase.kt */
    @d.c.b.a.f(b = "EnterCallUserUseCase.kt", c = {10}, d = "invoke", e = "com.obric.autoaction.vdplayer.domain.action.EnterCallUserUseCase")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f25186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f25188c;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25187b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25186a = r3;
            this.f25188c |= Integer.MIN_VALUE;
            return this.f25187b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public a() {
    }

    public final Object a(d.c.d<? super EnumC0606a> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");
        if ((r0.f25188c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f25188c -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f25186a;
        Object r7 = d.c.a.b.a();
        int r2 = r0.f25188c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r4);
    L24:
        if (((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g() == false) goto L30;
        return EnumC0606a.f25181a;
    L30:
        return EnumC0606a.f25182b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        IAutoActionAgentApi r8 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAgentApi.class), IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L19;
        return EnumC0606a.f25182b;
    L19:
        if (r8.beforeCallUser() == false) goto L28;
        r0.f25188c = 1;
        r4 = r8.enterCallUser(r0);
        if (r4 != r7) goto L24;
        return r7;
    L28:
        return EnumC0606a.f25183c;
    L7:
        r0 = new b(this, r6);
        goto L8
    }
}
