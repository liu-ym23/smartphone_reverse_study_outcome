package com.obric.autoaction.vdplayer.legacy.a.a;

import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;

/* JADX INFO: compiled from: EnterCallUserUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EnterCallUserUseCase.kt */
    public static final enum EnumC0631a extends Enum<EnumC0631a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0631a f25650a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0631a f25651b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0631a f25652c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0631a[] f25653d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f25654e = null;

        private static final /* synthetic */ EnumC0631a[] a() {
            return new EnumC0631a[]{f25650a, f25651b, f25652c};
        }

        private EnumC0631a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f25650a = new EnumC0631a("SUCCESS", 0);
            f25651b = new EnumC0631a("FAIL", 1);
            f25652c = new EnumC0631a("FAIL_BEFORE_CALL_USER", 2);
            EnumC0631a[] r0 = a();
            f25653d = r0;
            f25654e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0631a valueOf(String r2) {
            return (EnumC0631a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0631a.class, r2), EnumC0631a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0631a[] values() {
            return (EnumC0631a[]) ZeusTransformUtils.preCheckCast(f25653d.clone(), EnumC0631a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: EnterCallUserUseCase.kt */
    @d.c.b.a.f(b = "EnterCallUserUseCase.kt", c = {10}, d = "invoke", e = "com.obric.autoaction.vdplayer.legacy.domain.action.EnterCallUserUseCase")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f25655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f25657c;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25656b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f25655a = r3;
            this.f25657c |= Integer.MIN_VALUE;
            return this.f25656b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public a() {
    }

    public final Object a(d.c.d<? super EnumC0631a> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");
        if ((r0.f25657c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f25657c -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f25655a;
        Object r7 = d.c.a.b.a();
        int r2 = r0.f25657c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r4);
    L24:
        if (((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g() == false) goto L30;
        return EnumC0631a.f25650a;
    L30:
        return EnumC0631a.f25651b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        IAutoActionAgentApi r8 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAgentApi.class), IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L19;
        return EnumC0631a.f25651b;
    L19:
        if (r8.beforeCallUser() == false) goto L28;
        r0.f25657c = 1;
        r4 = r8.enterCallUser(r0);
        if (r4 != r7) goto L24;
        return r7;
    L28:
        return EnumC0631a.f25652c;
    L7:
        r0 = new b(this, r6);
        goto L8
    }
}
