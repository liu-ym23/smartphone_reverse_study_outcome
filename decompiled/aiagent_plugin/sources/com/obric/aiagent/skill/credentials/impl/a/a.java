package com.obric.aiagent.skill.credentials.impl.a;

import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAccountStatus;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.aiagent.skill.credentials.api.c;
import com.obric.aiagent.skill.credentials.api.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.o;
import d.n;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: AccountCapability.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ISkillCredentialService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.credentials.impl.c.b f19001a;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.credentials.impl.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccountCapability.kt */
    @f(b = "AccountCapability.kt", c = {67}, d = "logout-gIAlu-s", e = "com.obric.aiagent.skill.credentials.impl.account.AccountCapability")
    static final class C0415a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f19003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f19004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19005d;

        C0415a(a r3, d.c.d<? super C0415a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19004c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19003b = r3;
            this.f19005d |= Integer.MIN_VALUE;
            Object r2 = this.f19004c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    /* JADX INFO: compiled from: AccountCapability.kt */
    @f(b = "AccountCapability.kt", c = {74}, d = "status-gIAlu-s", e = "com.obric.aiagent.skill.credentials.impl.account.AccountCapability")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f19008c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f19009d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19010e;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19009d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19008c = r3;
            this.f19010e |= Integer.MIN_VALUE;
            Object r2 = this.f19009d.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    public static /* synthetic */ SidecarOperation lambda$WkCtVNAnwNJGMq8RuutdqMFQSWw(a r0, List r1, SidecarDeviceFlowCallback r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ SidecarOperation lambda$t4Xa76p3QOlKZIPgohZihWckgJs(a r0, List r1, SidecarDeviceFlowCallback r2) {
        return a(r0, r1, r2);
    }

    public a(com.obric.aiagent.skill.credentials.impl.c.b r2) {
        o.e(r2, "sidecarProvider");
        this.f19001a = r2;
    }

    public static final /* synthetic */ com.obric.aiagent.skill.credentials.impl.c.b a(a r0) {
        return r0.f19001a;
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.a
    public Object a(com.obric.aiagent.skill.credentials.api.f r4, List<String> r5, d.c.d<? super h<? extends c>> r6) {
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.h r0 = com.obric.aiagent.skill.credentials.impl.c.c.a(r4, "login");
        if (r0 == null) goto L6;
        com.obric.aiagent.skill.credentials.impl.c.c.b("login unsupported provider", "login unsupported provider=" + r4.a());
        return j.a(new c.a(r0));
    L6:
        com.obric.aiagent.skill.credentials.impl.c.c.a("login started scopeCount=" + r7.size(), "login start provider=" + r4.a() + " scopeCount=" + r7.size());
        return com.obric.aiagent.skill.credentials.impl.c.c.a("login", new $$Lambda$a$t4Xa76p3QOlKZIPgohZihWckgJs(this, r7));
    }

    private static final SidecarOperation a(a r2, List r3, SidecarDeviceFlowCallback r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        SidecarDeviceFlowCallback r6 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r4, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        o.e(r6, "callback");
        return r2.f19001a.a().login(p.q((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")), r6);
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.a
    public Object b(com.obric.aiagent.skill.credentials.api.f r4, List<String> r5, d.c.d<? super h<? extends c>> r6) {
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.h r0 = com.obric.aiagent.skill.credentials.impl.c.c.a(r4, "requestGrant");
        if (r0 == null) goto L6;
        com.obric.aiagent.skill.credentials.impl.c.c.b("requestGrant unsupported provider", "requestGrant unsupported provider=" + r4.a());
        return j.a(new c.a(r0));
    L6:
        com.obric.aiagent.skill.credentials.impl.c.c.a("requestGrant started scopeCount=" + r7.size(), "requestGrant start provider=" + r4.a() + " scopeCount=" + r7.size());
        return com.obric.aiagent.skill.credentials.impl.c.c.a("requestGrant", new $$Lambda$a$WkCtVNAnwNJGMq8RuutdqMFQSWw(this, r7));
    }

    private static final SidecarOperation b(a r2, List r3, SidecarDeviceFlowCallback r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        SidecarDeviceFlowCallback r6 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r4, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        o.e(r6, "callback");
        return r2.f19001a.a().requestGrant(p.q((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")), r6);
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.a
    public Object a(com.obric.aiagent.skill.credentials.api.f r9, d.c.d<? super n<com.obric.aiagent.skill.credentials.api.h>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C0415a.class) == false) goto L7;
        C0415a r0 = (C0415a) ZeusTransformUtils.preCheckCast(r11, C0415a.class, "com.obric.aiagent.plugin");
        if ((r0.f19005d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19005d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f19003b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19005d;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r0.f19002a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L14 CancellationException -> L16
    L27:
    L40:
        return n.f(com.obric.aiagent.skill.credentials.impl.c.c.a((SidecarResult) ZeusTransformUtils.preCheckCast(r12, SidecarResult.class, "com.obric.aiagent.plugin")));
    L14:
        th = th;
    L31:
        n.a r13 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(com.obric.aiagent.skill.credentials.impl.c.c.a(th, r8)), Throwable.class, "com.obric.aiagent.plugin")));
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r12);
        com.obric.aiagent.skill.credentials.api.h r4 = com.obric.aiagent.skill.credentials.impl.c.c.a(r9, "logout");
        if (r4 == null) goto L34;
        n.a r14 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(r4), Throwable.class, "com.obric.aiagent.plugin")));
    L34:
        n.a r5 = n.f38560a;     // Catch: CancellationException -> L16 Throwable -> L29
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Throwable -> L29
        com.obric.aiagent.skill.credentials.impl.c.c.a("logout started", "logout start provider=" + r9.a());     // Catch: CancellationException -> L16 Throwable -> L29
        SafetyGuardSidecar r15 = a(this).a();     // Catch: CancellationException -> L16 Throwable -> L29
        r0.f19002a = "logout";     // Catch: CancellationException -> L16 Throwable -> L29
        r0.f19005d = 1;     // Catch: CancellationException -> L16 Throwable -> L29
        Object r16 = r15.logout(r0);     // Catch: CancellationException -> L16 Throwable -> L29
        if (r16 != r2) goto L26;
        return r2;
    L26:
        r12 = r16;
    L29:
        th = th;
        r8 = "logout";
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new C0415a(this, r11);
        goto L8
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.a
    public Object b(com.obric.aiagent.skill.credentials.api.f r9, d.c.d<? super n<com.obric.aiagent.skill.credentials.api.a>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if ((r0.f19010e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19010e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f19008c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19010e;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r0.f19007b, String.class, "com.obric.aiagent.plugin");
        r9 = (com.obric.aiagent.skill.credentials.api.f) ZeusTransformUtils.preCheckCast(r0.f19006a, com.obric.aiagent.skill.credentials.api.f.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L14 CancellationException -> L16
    L27:
    L40:
        return n.f(com.obric.aiagent.skill.credentials.impl.c.c.a((SidecarAccountStatus) ZeusTransformUtils.preCheckCast(r12, SidecarAccountStatus.class, "com.obric.aiagent.plugin"), r9));
    L14:
        th = th;
    L31:
        n.a r13 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(com.obric.aiagent.skill.credentials.impl.c.c.a(th, r8)), Throwable.class, "com.obric.aiagent.plugin")));
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r12);
        com.obric.aiagent.skill.credentials.api.h r4 = com.obric.aiagent.skill.credentials.impl.c.c.a(r9, "status");
        if (r4 == null) goto L34;
        n.a r14 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(r4), Throwable.class, "com.obric.aiagent.plugin")));
    L34:
        n.a r5 = n.f38560a;     // Catch: CancellationException -> L16 Throwable -> L29
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Throwable -> L29
        com.obric.aiagent.skill.credentials.impl.c.c.a("status started", "status start provider=" + r9.a());     // Catch: CancellationException -> L16 Throwable -> L29
        SafetyGuardSidecar r15 = a(this).a();     // Catch: CancellationException -> L16 Throwable -> L29
        r0.f19006a = r9;     // Catch: CancellationException -> L16 Throwable -> L29
        r0.f19007b = "status";     // Catch: CancellationException -> L16 Throwable -> L29
        r0.f19010e = 1;     // Catch: CancellationException -> L16 Throwable -> L29
        Object r16 = r15.status(r0);     // Catch: CancellationException -> L16 Throwable -> L29
        if (r16 != r2) goto L26;
        return r2;
    L26:
        r12 = r16;
    L29:
        th = th;
        r8 = "status";
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new b(this, r11);
        goto L8
    }
}
