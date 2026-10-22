package com.obric.aiagent.skill.manager.impl.ui;

import com.obric.aiagent.skill.manager.impl.db;
import com.obric.aiagent.skill.manager.impl.hi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SkillDetailLoadCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<String, com.obric.aiagent.skill.manager.impl.ao> f20915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.r<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.impl.ao, d.h.a.a<d.x>, d.c.d<? super hi>, Object> f20916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.m<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.u.a, d.x> f20917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<aa, d.x> f20918d;

    /* JADX INFO: compiled from: SkillDetailLoadCoordinator.kt */
    @d.c.b.a.f(b = "SkillDetailLoadCoordinator.kt", c = {108}, d = "load", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailLoadCoordinator")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f20919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f20920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f20921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f20922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f20923e;
        final /* synthetic */ z f;
        int g;

        a(z r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f20923e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$tGNNHHbJsMj8J-wZeanZlTy_4aA, reason: not valid java name */
    public static /* synthetic */ d.x m357lambda$tGNNHHbJsMj8JwZeanZlTy_4aA(z r0) {
        return a(r0);
    }

    public z(d.h.a.b<? super String, com.obric.aiagent.skill.manager.impl.ao> r3, d.h.a.r<? super com.obric.aiagent.skill.manager.api.e, ? super com.obric.aiagent.skill.manager.impl.ao, ? super d.h.a.a<d.x>, ? super d.c.d<? super hi>, ? extends Object> r4, d.h.a.m<? super com.obric.aiagent.skill.manager.api.e, ? super com.obric.aiagent.skill.manager.api.u.a, d.x> r5, d.h.a.b<? super aa, d.x> r6) {
        d.h.a.b<String, com.obric.aiagent.skill.manager.impl.ao> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.r<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.impl.ao, d.h.a.a<d.x>, d.c.d<? super hi>, Object> r8 = (d.h.a.r) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.r.class, "com.obric.aiagent.plugin");
        d.h.a.m<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.u.a, d.x> r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.b<aa, d.x> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "loadRemoteDetail");
        d.h.b.o.e(r8, "refreshInstalledStoreSkill");
        d.h.b.o.e(r9, "onInstalledStoreRefreshFailure");
        d.h.b.o.e(r10, "onStageChanged");
        this.f20915a = r7;
        this.f20916b = r8;
        this.f20917c = r9;
        this.f20918d = r10;
    }

    public final Object a(String r21, com.obric.aiagent.skill.manager.api.e r22, d.c.d<? super ae> r23) {
        final z r0 = this;
        String r1 = r21;
        com.obric.aiagent.skill.manager.api.e r2 = r22;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L7;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
        if ((r5.g & Integer.MIN_VALUE) == 0) goto L7;
        r5.g -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f20923e;
        Object r6 = d.c.a.b.a();
        int r7 = r5.g;
        if (r7 == 0) goto L19;
        if (r7 != 1) goto L18;
        com.obric.aiagent.skill.manager.impl.ao r8 = (com.obric.aiagent.skill.manager.impl.ao) ZeusTransformUtils.preCheckCast(r5.f20922d, com.obric.aiagent.skill.manager.impl.ao.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.e r9 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r5.f20921c, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5.f20920b, String.class, "com.obric.aiagent.plugin");
        z r11 = (z) ZeusTransformUtils.preCheckCast(r5.f20919a, z.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Exception -> L14 CancellationException -> L15
        com.obric.aiagent.skill.manager.impl.ao r12 = r8;
        r0 = r11;
        Object r13 = r4;
        r2 = r9;
        r1 = r10;
    L51:
        hi r14 = (hi) ZeusTransformUtils.preCheckCast(r13, hi.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L15 Exception -> L69
    L54:
        if (r14 == null) goto L58;
        com.obric.aiagent.skill.manager.api.u.a r15 = r14.g();
        if (r15 == null) goto L58;
        r0.f20917c.invoke(r2, r15);
    L58:
        if (r14 == null) goto L65;
        if (d.h.b.o.a(r14.a().a(), r1) == false) goto L63;
        r2 = r14.a();
        goto L65
    L63:
        r0.f20917c.invoke(r2, new com.obric.aiagent.skill.manager.api.u.a(com.obric.aiagent.skill.manager.api.r.q, false, "refreshed_slug_mismatch", null, 10, null));
    L65:
        return new ae(r2, r12.b(), r12.c(), true);
    L53:
        r0.f20917c.invoke(r2, new com.obric.aiagent.skill.manager.api.u.a(com.obric.aiagent.skill.manager.api.r.q, false, "installed_refresh_exception", null, 10, null));
        r14 = null;
    L14:
        r12 = r8;
        r0 = r11;
        r2 = r9;
        r1 = r10;
        goto L53
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        d.o.a(r4);
        r0.f20918d.invoke(aa.f20483a);
        if (r2 != null) goto L26;
        com.obric.aiagent.skill.manager.impl.ao r16 = (com.obric.aiagent.skill.manager.impl.ao) ZeusTransformUtils.preCheckCast(r0.f20915a.invoke(r1), com.obric.aiagent.skill.manager.impl.ao.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L24;
        return null;
    L24:
        return new ae(r16.a(), r16.b(), r16.c(), false);
    L26:
        if (ZeusTransformUtils.instanceOf(r22.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L28;
        com.obric.aiagent.skill.manager.impl.ao r17 = r0.f20915a.invoke(r1);     // Catch: Exception -> L40 CancellationException -> L67
        if (((com.obric.aiagent.skill.manager.impl.ao) ZeusTransformUtils.preCheckCast(r17, com.obric.aiagent.skill.manager.impl.ao.class, "com.obric.aiagent.plugin")) != null) goto L38;
        r0.f20917c.invoke(r2, new com.obric.aiagent.skill.manager.api.u.a(com.obric.aiagent.skill.manager.api.r.f19301b, false, "detail_not_found", null, 10, null));     // Catch: Exception -> L40 CancellationException -> L67
    L38:
        r12 = (com.obric.aiagent.skill.manager.impl.ao) ZeusTransformUtils.preCheckCast(r17, com.obric.aiagent.skill.manager.impl.ao.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L40 CancellationException -> L67
    L41:
        if (r12 != null) goto L45;
        return new ae(r22, "", null, true, 4, null);
    L45:
        if (d.h.b.o.a(r12.a().a(), r1) == true) goto L72;
        r0.f20917c.invoke(r2, new com.obric.aiagent.skill.manager.api.u.a(com.obric.aiagent.skill.manager.api.r.q, false, "remote_detail_slug_mismatch", null, 10, null));
        return new ae(r22, "", null, true, 4, null);
    L72:
        d.h.a.r<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.impl.ao, d.h.a.a<d.x>, d.c.d<? super hi>, Object> r18 = r0.f20916b;     // Catch: CancellationException -> L15 Exception -> L69
        d.h.a.a<d.x> r19 = new $$Lambda$z$tGNNHHbJsMj8JwZeanZlTy_4aA(r0);     // Catch: CancellationException -> L15 Exception -> L69
        r5.f20919a = r0;     // Catch: CancellationException -> L15 Exception -> L69
        r5.f20920b = r1;     // Catch: CancellationException -> L15 Exception -> L69
        r5.f20921c = r2;     // Catch: CancellationException -> L15 Exception -> L69
        r5.f20922d = r12;     // Catch: CancellationException -> L15 Exception -> L69
        r5.g = 1;     // Catch: CancellationException -> L15 Exception -> L69
        r13 = r18.a(r2, r12, r19, r5);     // Catch: CancellationException -> L15 Exception -> L69
        if (r13 != r6) goto L51;
        return r6;
    L67:
        e = move-exception;
        throw e;
    L40:
        r0.f20917c.invoke(r2, new com.obric.aiagent.skill.manager.api.u.a(com.obric.aiagent.skill.manager.api.r.n, false, "detail_request_exception", null, 10, null));
        r12 = null;
        goto L41
    L28:
        if (d.h.b.o.a(r22.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L74;
        List<String> r20 = d.a.p.b();
    L34:
        return new ae(r2, r22.c(), r20, true);
    L74:
        r20 = db.a(db.f19721a, r22.k(), 0, 2, null).d();     // Catch: Exception -> L31
    L31:
        r20 = d.a.p.b();
    L15:
        e = move-exception;
        throw e;
    L7:
        r5 = new a(r0, r3);
        goto L8
    }

    private static final d.x a(z r1) {
        r1.f20918d.invoke(aa.f20484b);
        return d.x.f38692a;
    }
}
