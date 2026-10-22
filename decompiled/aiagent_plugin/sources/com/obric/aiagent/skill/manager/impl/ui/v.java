package com.obric.aiagent.skill.manager.impl.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.obric.aiagent.skill.manager.impl.dw;
import com.obric.aiagent.skill.manager.impl.dy;
import com.obric.aiagent.skill.manager.impl.dz;
import com.obric.aiagent.skill.manager.impl.ea;
import com.obric.aiagent.skill.manager.impl.eb;
import com.obric.aiagent.skill.manager.impl.ee;
import com.obric.aiagent.skill.manager.impl.hd;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SkillCoverPickerCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentActivity f20825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.impl.au f20826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.am f20827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.am f20828e;
    private final d.h.a.b<String, d.x> f;
    private final d.h.a.b<Throwable, d.x> g;
    private final d.h.a.a<com.obric.aiagent.skill.manager.api.e> h;
    private final hd i;
    private final o j;
    private final w k;
    private final Object l;
    private kotlinx.coroutines.ca m;
    private ea n;
    private com.obric.aiagent.skill.manager.api.e o;
    private volatile long p;

    /* JADX INFO: compiled from: SkillCoverPickerCoordinator.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillCoverPickerCoordinator.kt */
    @d.c.b.a.f(b = "SkillCoverPickerCoordinator.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCoverPickerCoordinator$onActivityResult$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ v f20831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Uri f20832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ea f20833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20834e;
        final /* synthetic */ long f;

        /* JADX INFO: compiled from: SkillCoverPickerCoordinator.kt */
        @d.c.b.a.f(b = "SkillCoverPickerCoordinator.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCoverPickerCoordinator$onActivityResult$1$deliveryJob$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20835a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f20836b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ v f20837c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.impl.y f20838d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ ea f20839e;
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f;

            a(long r3, v r5, com.obric.aiagent.skill.manager.impl.y r6, ea r7, com.obric.aiagent.skill.manager.api.e r8, d.c.d<? super a> r9) {
                d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20836b = r3;
                this.f20837c = r5;
                this.f20838d = r6;
                this.f20839e = r7;
                this.f = r8;
                super(2, r10);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f20836b, this.f20837c, this.f20838d, this.f20839e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r19) {
                d.c.a.b.a();
                if (this.f20835a != 0) goto L32;
                d.o.a(r19);
                if (this.f20836b == v.d(this.f20837c)) goto L11;
                com.obric.aiagent.skill.manager.impl.y r1 = v.h(this.f20837c).b(this.f20838d.a());
                if (r1 == null) goto L10;
                d.c.b.a.b.a(v.b(this.f20837c).a(r1.a()));
            L10:
                return d.x.f38692a;
            L11:
                Boolean r2 = null;
                v.a(this.f20837c, null);
                n r3 = v.h(this.f20837c).a(this.f20838d.a());
                if (r3 == null) goto L14;
                ea.a(this.f20839e, dz.f19791a, this.f, null, null, null, null, null, null, d.c.b.a.b.a(false), d.c.b.a.b.a(false), d.a.ao.a(d.s.a("file_target", "cover")), 252, null);
                if (v.c(this.f20837c) != this.f20839e) goto L18;
                v.a(this.f20837c, null);
                v.a(this.f20837c, null);
            L18:
                com.obric.aiagent.skill.manager.impl.y r4 = r3.a();
                if (r4 == null) goto L21;
                r2 = d.c.b.a.b.a(v.b(this.f20837c).a(r4.a()));
            L21:
                ee r5 = ee.f19808a;
                StringBuilder r6 = new StringBuilder().append("Skill cover selected replaced=");
                boolean r7 = true;
                if (r3.a() == null) goto L24;
                boolean r8 = true;
            L25:
                String r9 = r6.append(r8).append(", previousDeleted=").append(r2).toString();
                StringBuilder r10 = new StringBuilder().append("Skill cover selected: url=").append(this.f20838d.a()).append(", replaced=");
                if (r3.a() != null) goto L29;
                r7 = false;
            L29:
                r5.b("SkillManager", r9, r10.append(r7).append(", previousDeleted=").append(r2).toString());
                v.i(this.f20837c).invoke(this.f20838d.a());
                return d.x.f38692a;
            L24:
                r8 = false;
                goto L25
            L14:
                return d.x.f38692a;
            L32:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.v$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SkillCoverPickerCoordinator.kt */
        @d.c.b.a.f(b = "SkillCoverPickerCoordinator.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillCoverPickerCoordinator$onActivityResult$1$imported$1")
        static final class C0437b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20840a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ v f20841b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Throwable f20842c;

            C0437b(v r3, Throwable r4, d.c.d<? super C0437b> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20841b = r3;
                this.f20842c = r4;
                super(2, r6);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((C0437b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0437b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0437b(this.f20841b, this.f20842c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f20840a != 0) goto L7;
                d.o.a(r2);
                v.f(this.f20841b).invoke(this.f20842c);
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(v r3, Uri r4, ea r5, com.obric.aiagent.skill.manager.api.e r6, long r7, d.c.d<? super b> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20831b = r3;
            this.f20832c = r4;
            this.f20833d = r5;
            this.f20834e = r6;
            this.f = r7;
            super(2, r10);
        }

        /* JADX INFO: renamed from: lambda$l3zSy80GKgQgRJ-NlAGJO2cxBd4, reason: not valid java name */
        public static /* synthetic */ d.x m347lambda$l3zSy80GKgQgRJNlAGJO2cxBd4(long r0, v r2, com.obric.aiagent.skill.manager.impl.y r3, Throwable r4) {
            return a(r0, r2, r3, r4);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f20831b, this.f20832c, this.f20833d, this.f20834e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r22) {
            d.c.a.b.a();
            if (this.f20830a != 0) goto L38;
            d.o.a(r22);
            boolean r2 = true;
            com.obric.aiagent.skill.manager.api.al r0 = com.obric.aiagent.skill.manager.api.al.f19195a.a();     // Catch: Throwable -> L25
            String r6 = ZeusProviderTransform.getType(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(v.a(this.f20831b), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getContentResolver(), this.f20832c, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
            InputStream r7 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(v.a(this.f20831b), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getContentResolver().openInputStream(this.f20832c);     // Catch: Throwable -> L25
            if (r7 == null) goto L24;
            final com.obric.aiagent.skill.manager.impl.y r1 = v.b(this.f20831b).a(r7, r6, r0.p());     // Catch: Throwable -> L25
            Object r3 = v.g(this.f20831b);
            long r5 = this.f;
            v r8 = this.f20831b;
            monitor-enter(r3);
        L20:
            th = move-exception;
            throw th;
        L11:
            if (r5 == v.d(r8)) goto L13;
            r2 = false;
        L14:
            monitor-exit(r3);
            if (r2 == true) goto L18;
            v.b(this.f20831b).a(r1.a());
            return d.x.f38692a;
        L18:
            kotlinx.coroutines.ca r4 = kotlinx.coroutines.i.a(v.e(this.f20831b), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f, this.f20831b, r1, this.f20833d, this.f20834e, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            final long r9 = this.f;
            final v r10 = this.f20831b;
            r4.a_(new $$Lambda$v$b$l3zSy80GKgQgRJNlAGJO2cxBd4(r9, r10, r1));
            return d.x.f38692a;
        L13:
            v.h(r8).a(r1);     // Catch: Throwable -> L20
            goto L14
        L24:
            throw new com.obric.aiagent.skill.manager.impl.bu((com.obric.aiagent.skill.manager.impl.bt) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.bt.g.f19599a, com.obric.aiagent.skill.manager.impl.bt.class, "com.obric.aiagent.plugin"), null, 2, null);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            if (ZeusTransformUtils.instanceOf(th, CancellationException.class) == true) goto L36;
            dw r14 = eb.a(th);
            ea.a(this.f20833d, dz.f19792b, this.f20834e, null, null, null, null, r14, "cover_import", d.c.b.a.b.a(eb.a(r14)), d.c.b.a.b.a(false), d.a.ao.a(new d.m[]{d.s.a("file_target", "cover"), d.s.a("failure_reason", r14.a())}), 60, null);
            if (v.c(this.f20831b) != this.f20833d) goto L32;
            v.a(this.f20831b, null);
            v.a(this.f20831b, null);
        L32:
            if (this.f != v.d(this.f20831b)) goto L35;
            kotlinx.coroutines.i.a(v.e(this.f20831b), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0437b(this.f20831b, th, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        L35:
            return d.x.f38692a;
        L36:
            throw th;
        L38:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final d.x a(long r2, v r4, com.obric.aiagent.skill.manager.impl.y r5, Throwable r6) {
            if (r6 == null) goto L4;
        L5:
            com.obric.aiagent.skill.manager.impl.y r3 = v.h(r4).b(r5.a());
            if (r3 == null) goto L9;
            v.b(r4).a(r3.a());
        L9:
            return d.x.f38692a;
        L4:
            if (r2 == v.d(r4)) goto L9;
            goto L5
        }
    }

    static {
        f20824a = new a(null);
    }

    public v(FragmentActivity r3, com.obric.aiagent.skill.manager.impl.au r4, kotlinx.coroutines.am r5, kotlinx.coroutines.am r6, d.h.a.b<? super String, d.x> r7, d.h.a.b<? super Throwable, d.x> r8, d.h.a.a<com.obric.aiagent.skill.manager.api.e> r9, hd r10) {
        FragmentActivity r11 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r12 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r13 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        d.h.a.b<String, d.x> r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<Throwable, d.x> r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<com.obric.aiagent.skill.manager.api.e> r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "activity");
        d.h.b.o.e(r4, "coverStore");
        d.h.b.o.e(r12, "ioScope");
        d.h.b.o.e(r13, "mainScope");
        d.h.b.o.e(r14, "onCoverReady");
        d.h.b.o.e(r15, "onFailure");
        d.h.b.o.e(r16, "performanceSkillProvider");
        d.h.b.o.e(r10, "trackingReporter");
        this.f20825b = r11;
        this.f20826c = r4;
        this.f20827d = r12;
        this.f20828e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r10;
        this.j = new o();
        this.k = new w();
        this.l = new Object();
    }

    public static final /* synthetic */ FragmentActivity a(v r0) {
        return r0.f20825b;
    }

    public static final /* synthetic */ void a(v r0, com.obric.aiagent.skill.manager.api.e r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void a(v r0, ea r1) {
        r0.n = r1;
    }

    public static final /* synthetic */ void a(v r2, kotlinx.coroutines.ca r3) {
        r2.m = (kotlinx.coroutines.ca) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.impl.au b(v r0) {
        return r0.f20826c;
    }

    public static final /* synthetic */ ea c(v r0) {
        return r0.n;
    }

    public static final /* synthetic */ long d(v r2) {
        return r2.p;
    }

    public static final /* synthetic */ kotlinx.coroutines.am e(v r0) {
        return r0.f20828e;
    }

    public static final /* synthetic */ d.h.a.b f(v r0) {
        return r0.g;
    }

    public static final /* synthetic */ Object g(v r0) {
        return r0.l;
    }

    public static final /* synthetic */ o h(v r0) {
        return r0.j;
    }

    public static final /* synthetic */ d.h.a.b i(v r0) {
        return r0.f;
    }

    public /* synthetic */ v(FragmentActivity r13, com.obric.aiagent.skill.manager.impl.au r14, kotlinx.coroutines.am r15, kotlinx.coroutines.am r16, d.h.a.b r17, d.h.a.b r18, d.h.a.a r19, hd r20, int r21, d.h.b.h r22) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r13, FragmentActivity.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r6 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r15, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r7 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r16, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r17, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r21 & 64) == 0) goto L5;
        r1 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f20829a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L5:
        d.h.a.a r10 = r1;
        if ((r21 & 128) == 0) goto L8;
        hd r11 = new hd(null, null, null, 7, null);
    L9:
        this(r4, r14, r6, r7, r8, r9, r10, r11);
        return;
    L8:
        r11 = r20;
        goto L9
    }

    public final void a() {
        this.k.a();
        d();
        if (a(b("com.android.gallery3d")) != null) goto L5;
        return;
    L5:
        Throwable r0 = a(a(this, null, 1, null));
        if (r0 == null) goto L9;
        this.k.c();
        this.g.invoke(r0);
        return;
    }

    public final boolean a(int r24, int r25, Intent r26) {
        if (r24 == 1201) goto L5;
        return false;
    L5:
        Long r0 = this.k.b();
        if (r0 == null) goto L25;
        r0.longValue();
        if (r25 == (-1)) goto L10;
        return true;
    L10:
        if (r26 == null) goto L23;
        Uri r2 = r26.getData();
        if (r2 == null) goto L23;
        this.p++;
        long r5 = this.p;
        ea r9 = this.n;
        if (r9 == null) goto L17;
        ea.a(r9, dz.f19793c, this.o, null, null, null, null, dw.n, "superseded", false, false, d.a.ao.a(d.s.a("file_target", "cover")), 60, null);
    L17:
        this.n = null;
        this.o = null;
        ea r3 = new ea(dy.f19787b, this.i, null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
        com.obric.aiagent.skill.manager.api.e r4 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.h.invoke(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        this.n = r3;
        this.o = r4;
        kotlinx.coroutines.ca r1 = this.m;
        if (r1 == null) goto L20;
        kotlinx.coroutines.ca.a.a(r1, null, 1, null);
    L20:
        this.m = kotlinx.coroutines.i.a(this.f20827d, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r2, r3, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return true;
    L23:
        return true;
    L25:
        return true;
    }

    public final com.obric.aiagent.skill.manager.impl.y a(String r2) {
        d.h.b.o.e(r2, "coverUrl");
        return this.j.c(r2);
    }

    public final void b() {
        this.k.c();
        d();
    }

    public final void c() {
        this.k.d();
        d();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.j.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.obric.aiagent.skill.manager.impl.y r1 = (com.obric.aiagent.skill.manager.impl.y) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aiagent.skill.manager.impl.y.class, "com.obric.aiagent.plugin");
        this.f20826c.a(r1.a());
        goto L4
    }

    private final void d() {
        Object r1 = this.l;
        monitor-enter(r1);
        this.p++;     // Catch: Throwable -> L12
        ea r4 = this.n;     // Catch: Throwable -> L12
        if (r4 == null) goto L7;
        ea.a(r4, dz.f19793c, this.o, null, null, null, null, dw.n, "user_cancel", false, false, d.a.ao.a(d.s.a("file_target", "cover")), 60, null);     // Catch: Throwable -> L12
    L7:
        this.n = null;     // Catch: Throwable -> L12
        this.o = null;     // Catch: Throwable -> L12
        kotlinx.coroutines.ca r3 = this.m;     // Catch: Throwable -> L12
        this.m = null;     // Catch: Throwable -> L12
        monitor-exit(r1);
        if (r3 == null) goto L17;
        kotlinx.coroutines.ca.a.a(r3, null, 1, null);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ Intent a(v r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.b(r1);
    }

    private final Intent b(String r3) {
        Intent r2 = new Intent("android.intent.action.GET_CONTENT");
        r2.setType("image/*");
        r2.addCategory("android.intent.category.OPENABLE");
        r2.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        if (r3 == null) goto L5;
        r2.setPackage(r3);
    L5:
        return r2;
    }

    private final Throwable a(Intent r3) {
        ZeusTransformUtils.startActivityForResult(this.f20825b, r3, 1201, "com.obric.aiagent.plugin");     // Catch: SecurityException -> L5 ActivityNotFoundException -> L7
        return null;
    L7:
        e = move-exception;
        return (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        return (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
    }
}
