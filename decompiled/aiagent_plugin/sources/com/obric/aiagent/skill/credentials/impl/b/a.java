package com.obric.aiagent.skill.credentials.impl.b;

import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarAppInfo;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarDeviceFlowCallback;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarResult;
import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.aiagent.skill.credentials.api.e;
import com.obric.aiagent.skill.credentials.api.h;
import com.obric.aiagent.skill.credentials.impl.c.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.o;
import d.n;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: AppCapability.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ISkillCredentialService.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.credentials.impl.c.b f19011a;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.credentials.impl.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppCapability.kt */
    @f(b = "AppCapability.kt", c = {70}, d = "delete-gIAlu-s", e = "com.obric.aiagent.skill.credentials.impl.app.AppCapability")
    static final class C0416a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f19013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f19014c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19015d;

        C0416a(a r3, d.c.d<? super C0416a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19014c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19013b = r3;
            this.f19015d |= Integer.MIN_VALUE;
            Object r2 = this.f19014c.c(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    /* JADX INFO: compiled from: AppCapability.kt */
    @f(b = "AppCapability.kt", c = {29}, d = "getConfigured-gIAlu-s", e = "com.obric.aiagent.skill.credentials.impl.app.AppCapability")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f19018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f19019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19020e;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19019d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19018c = r3;
            this.f19020e |= Integer.MIN_VALUE;
            Object r2 = this.f19019d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    public static /* synthetic */ SidecarOperation lambda$a4ozWZKJBtQutQP_QmlrADPR78k(a r0, SidecarDeviceFlowCallback r1) {
        return a(r0, r1);
    }

    public a(com.obric.aiagent.skill.credentials.impl.c.b r2) {
        o.e(r2, "sidecarProvider");
        this.f19011a = r2;
    }

    public static final /* synthetic */ com.obric.aiagent.skill.credentials.impl.c.b a(a r0) {
        return r0.f19011a;
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.b
    public Object a(com.obric.aiagent.skill.credentials.api.f r9, d.c.d<? super n<com.obric.aiagent.skill.credentials.api.b>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if ((r0.f19020e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19020e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f19018c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19020e;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r0.f19017b, String.class, "com.obric.aiagent.plugin");
        r9 = (com.obric.aiagent.skill.credentials.api.f) ZeusTransformUtils.preCheckCast(r0.f19016a, com.obric.aiagent.skill.credentials.api.f.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L14 CancellationException -> L16
    L27:
        SidecarAppInfo r13 = (SidecarAppInfo) ZeusTransformUtils.preCheckCast(r12, SidecarAppInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14 CancellationException -> L16
        if (r13 == null) goto L30;
        com.obric.aiagent.skill.credentials.api.b r14 = c.a(r13, r9);     // Catch: Throwable -> L14 CancellationException -> L16
    L31:
    L44:
        return n.f(r14);
    L30:
        r14 = null;
    L14:
        th = th;
    L35:
        n.a r15 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(c.a(th, r8)), Throwable.class, "com.obric.aiagent.plugin")));
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r12);
        h r4 = c.a(r9, "getConfiguredApp");
        if (r4 == null) goto L40;
        n.a r16 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(r4), Throwable.class, "com.obric.aiagent.plugin")));
    L40:
        n.a r5 = n.f38560a;     // Catch: CancellationException -> L16 Throwable -> L33
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Throwable -> L33
        c.a("getConfiguredApp started", "getConfiguredApp provider=" + r9.a());     // Catch: CancellationException -> L16 Throwable -> L33
        SafetyGuardSidecar r17 = a(this).a();     // Catch: CancellationException -> L16 Throwable -> L33
        r0.f19016a = r9;     // Catch: CancellationException -> L16 Throwable -> L33
        r0.f19017b = "getConfiguredApp";     // Catch: CancellationException -> L16 Throwable -> L33
        r0.f19020e = 1;     // Catch: CancellationException -> L16 Throwable -> L33
        Object r18 = r17.configuredApp(r0);     // Catch: CancellationException -> L16 Throwable -> L33
        if (r18 != r2) goto L26;
        return r2;
    L26:
        r12 = r18;
    L33:
        th = th;
        r8 = "getConfiguredApp";
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new b(this, r11);
        goto L8
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.b
    public Object b(com.obric.aiagent.skill.credentials.api.f r3, d.c.d<? super kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        h r0 = c.a(r3, "configCreateApp");
        if (r0 == null) goto L6;
        c.b("configCreateApp unsupported provider", "configCreateApp unsupported provider=" + r3.a());
        return j.a(new com.obric.aiagent.skill.credentials.api.c.a(r0));
    L6:
        c.a("configCreateApp started", "configCreateApp start provider=" + r3.a());
        return c.a("configCreateApp", new $$Lambda$a$a4ozWZKJBtQutQP_QmlrADPR78k(this));
    }

    private static final SidecarOperation a(a r2, SidecarDeviceFlowCallback r3) {
        SidecarDeviceFlowCallback r4 = (SidecarDeviceFlowCallback) ZeusTransformUtils.wrapperContextForParams(r3, SidecarDeviceFlowCallback.class, "com.obric.aiagent.plugin");
        o.e(r4, "callback");
        return r2.f19011a.a().configCreateApp("feishu", r4);
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.b
    public Object c(com.obric.aiagent.skill.credentials.api.f r9, d.c.d<? super n<h>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C0416a.class) == false) goto L7;
        C0416a r0 = (C0416a) ZeusTransformUtils.preCheckCast(r11, C0416a.class, "com.obric.aiagent.plugin");
        if ((r0.f19015d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19015d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f19013b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19015d;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r0.f19012a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L14 CancellationException -> L16
    L27:
    L40:
        return n.f(c.a((SidecarResult) ZeusTransformUtils.preCheckCast(r12, SidecarResult.class, "com.obric.aiagent.plugin")));
    L14:
        th = th;
    L31:
        n.a r13 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(c.a(th, r8)), Throwable.class, "com.obric.aiagent.plugin")));
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r12);
        h r4 = c.a(r9, "deleteConfiguredApp");
        if (r4 == null) goto L34;
        n.a r14 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(r4), Throwable.class, "com.obric.aiagent.plugin")));
    L34:
        n.a r5 = n.f38560a;     // Catch: CancellationException -> L16 Throwable -> L29
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Throwable -> L29
        c.a("deleteConfiguredApp started", "deleteConfiguredApp start provider=" + r9.a());     // Catch: CancellationException -> L16 Throwable -> L29
        SafetyGuardSidecar r15 = a(this).a();     // Catch: CancellationException -> L16 Throwable -> L29
        r0.f19012a = "deleteConfiguredApp";     // Catch: CancellationException -> L16 Throwable -> L29
        r0.f19015d = 1;     // Catch: CancellationException -> L16 Throwable -> L29
        Object r16 = r15.configDeleteApp(r0);     // Catch: CancellationException -> L16 Throwable -> L29
        if (r16 != r2) goto L26;
        return r2;
    L26:
        r12 = r16;
    L29:
        th = th;
        r8 = "deleteConfiguredApp";
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new C0416a(this, r11);
        goto L8
    }
}
