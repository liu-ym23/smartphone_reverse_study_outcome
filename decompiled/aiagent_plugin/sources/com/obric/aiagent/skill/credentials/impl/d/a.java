package com.obric.aiagent.skill.credentials.impl.d;

import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.aiagent.skill.credentials.api.e;
import com.obric.aiagent.skill.credentials.api.g;
import com.obric.aiagent.skill.credentials.api.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.o;
import d.n;
import d.x;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SessionCapability.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements ISkillCredentialService.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.credentials.impl.c.b f19037a;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.credentials.impl.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SessionCapability.kt */
    @f(b = "SessionCapability.kt", c = {44}, d = "end-gIAlu-s", e = "com.obric.aiagent.skill.credentials.impl.session.SessionCapability")
    static final class C0419a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f19038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f19039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19040c;

        C0419a(a r3, d.c.d<? super C0419a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19039b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19038a = r3;
            this.f19040c |= Integer.MIN_VALUE;
            Object r2 = this.f19039b.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    /* JADX INFO: compiled from: SessionCapability.kt */
    @f(b = "SessionCapability.kt", c = {28}, d = "start-BWLJW6A", e = "com.obric.aiagent.skill.credentials.impl.session.SessionCapability")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f19042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f19043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19044d;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19043c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f19042b = r7;
            this.f19044d |= Integer.MIN_VALUE;
            Object r6 = this.f19043c.a(null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r6 != d.c.a.b.a()) goto L6;
            return r6;
        L6:
            return n.g(r6);
        }
    }

    public a(com.obric.aiagent.skill.credentials.impl.c.b r2) {
        o.e(r2, "sidecarProvider");
        this.f19037a = r2;
    }

    public static final /* synthetic */ com.obric.aiagent.skill.credentials.impl.c.b a(a r0) {
        return r0.f19037a;
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.d
    public Object a(com.obric.aiagent.skill.credentials.api.f r9, String r10, long r11, d.c.d<? super n<g>> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r0.f19044d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19044d -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f19042b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19044d;
        boolean r4 = true;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r0.f19041a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Throwable -> L14 CancellationException -> L16
    L27:
        g r12 = (g) ZeusTransformUtils.preCheckCast(r15, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14 CancellationException -> L16
        StringBuilder r16 = new StringBuilder().append("startSession complete sessionIdPresent=");     // Catch: Throwable -> L14 CancellationException -> L16
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L31;
        r4 = false;
    L31:
        com.obric.aiagent.skill.credentials.impl.c.c.a("startSession completed", r16.append(r4).append(" brand=").append(r12.d()).append(" envKeys=").append(r12.b().keySet()).append(" expiresAt=").append(r12.e()).toString());     // Catch: Throwable -> L14 CancellationException -> L16
    L44:
        return n.f(r12);
    L14:
        th = th;
    L35:
        n.a r17 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(com.obric.aiagent.skill.credentials.impl.c.c.a(th, r8)), Throwable.class, "com.obric.aiagent.plugin")));
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r15);
        h r5 = com.obric.aiagent.skill.credentials.impl.c.c.a(r9, "startSession");
        if (r5 == null) goto L38;
        n.a r18 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(r5), Throwable.class, "com.obric.aiagent.plugin")));
    L38:
        n.a r6 = n.f38560a;     // Catch: CancellationException -> L16 Throwable -> L33
        d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Throwable -> L33
        com.obric.aiagent.skill.credentials.impl.c.c.a("startSession started ttlSeconds=" + r11, "startSession start provider=" + r9.a() + " cliName=" + r10 + " ttlSeconds=" + r11);     // Catch: CancellationException -> L16 Throwable -> L33
        SafetyGuardSidecar r19 = a(this).a();     // Catch: CancellationException -> L16 Throwable -> L33
        r0.f19041a = "startSession";     // Catch: CancellationException -> L16 Throwable -> L33
        r0.f19044d = 1;     // Catch: CancellationException -> L16 Throwable -> L33
        Object r20 = com.obric.aiagent.skill.credentials.impl.c.c.a(r19, r10, r11, r0);     // Catch: CancellationException -> L16 Throwable -> L33
        if (r20 != r2) goto L26;
        return r2;
    L26:
        r15 = r20;
    L33:
        th = th;
        r8 = "startSession";
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new b(this, r14);
        goto L8
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.d
    public Object a(String r8, d.c.d<? super n<x>> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, C0419a.class) == false) goto L7;
        C0419a r0 = (C0419a) ZeusTransformUtils.preCheckCast(r10, C0419a.class, "com.obric.aiagent.plugin");
        if ((r0.f19040c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19040c -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f19038a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19040c;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        d.o.a(r11);     // Catch: Throwable -> L13 CancellationException -> L15
    L28:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L30;
        n.a r7 = n.f38560a;     // Catch: Throwable -> L13 CancellationException -> L15
        return n.f(x.f38692a);
    L30:
        n.a r12 = n.f38560a;     // Catch: Throwable -> L13 CancellationException -> L15
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(com.obric.aiagent.skill.credentials.impl.c.c.a("endSession", "end_session_failed", "SafetyGuard failed to end sidecar session.", "Check SafetyGuard logs and retry cleanup.")), Throwable.class, "com.obric.aiagent.plugin")));
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        d.o.a(r11);
        StringBuilder r4 = new StringBuilder().append("endSession start sessionIdPresent=");     // Catch: Throwable -> L13 CancellationException -> L15
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L23;
        boolean r6 = true;
    L24:
        com.obric.aiagent.skill.credentials.impl.c.c.a("endSession started", r4.append(r6).toString());     // Catch: Throwable -> L13 CancellationException -> L15
        SafetyGuardSidecar r13 = this.f19037a.a();     // Catch: Throwable -> L13 CancellationException -> L15
        r0.f19040c = 1;     // Catch: Throwable -> L13 CancellationException -> L15
        r11 = r13.endSession(r8, r0);     // Catch: Throwable -> L13 CancellationException -> L15
        if (r11 != r2) goto L28;
        return r2;
    L23:
        r6 = false;
    L15:
        e = move-exception;
        throw e;
    L13:
        th = move-exception;
        n.a r14 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new e(com.obric.aiagent.skill.credentials.impl.c.c.a(th, "endSession")), Throwable.class, "com.obric.aiagent.plugin")));
    L7:
        r0 = new C0419a(this, r10);
        goto L8
    }
}
