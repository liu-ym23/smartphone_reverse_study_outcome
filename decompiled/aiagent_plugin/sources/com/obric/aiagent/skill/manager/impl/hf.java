package com.obric.aiagent.skill.manager.impl;

import com.obric.capabilitykit.entity.ResultCode;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> f20077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> f20078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.q<com.obric.aiagent.skill.manager.api.e, hg, ao, com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> f20079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ac f20080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final p f20081e;
    private final hd f;
    private final kotlinx.coroutines.am g;
    private final Object h;
    private final LinkedHashMap<c, a> i;

    /* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlinx.coroutines.au<hi> f20082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final hh f20083b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20082a, r6.f20082a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20083b, r6.f20083b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f20082a.hashCode() * 31) + this.f20083b.hashCode();
        }

        public String toString() {
            return "InFlightSkillUpdate(deferred=" + this.f20082a + ", updateRequiredNotifier=" + this.f20083b + ')';
        }

        public a(kotlinx.coroutines.au<hi> r3, hh r4) {
            kotlinx.coroutines.au<hi> r5 = (kotlinx.coroutines.au) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.au.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "deferred");
            d.h.b.o.e(r4, "updateRequiredNotifier");
            this.f20082a = r5;
            this.f20083b = r4;
        }

        public final kotlinx.coroutines.au<hi> a() {
            return this.f20082a;
        }

        public final hh b() {
            return this.f20083b;
        }
    }

    /* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.e f20084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ar f20085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.u.a f20086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final dw f20087d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20084a, r6.f20084a) == true) goto L12;
            return false;
        L12:
            if (this.f20085b == r6.f20085b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f20086c, r6.f20086c) == true) goto L18;
            return false;
        L18:
            if (this.f20087d == r6.f20087d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f20084a.hashCode() * 31) + this.f20085b.hashCode()) * 31;
            com.obric.aiagent.skill.manager.api.u.a r1 = this.f20086c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            dw r5 = this.f20087d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "SkillUpdateAttempt(skill=" + this.f20084a + ", outcome=" + this.f20085b + ", failure=" + this.f20086c + ", errorCode=" + this.f20087d + ')';
        }

        public b(com.obric.aiagent.skill.manager.api.e r2, ar r3, com.obric.aiagent.skill.manager.api.u.a r4, dw r5) {
            d.h.b.o.e(r2, "skill");
            d.h.b.o.e(r3, "outcome");
            this.f20084a = r2;
            this.f20085b = r3;
            this.f20086c = r4;
            this.f20087d = r5;
        }

        public /* synthetic */ b(com.obric.aiagent.skill.manager.api.e r2, ar r3, com.obric.aiagent.skill.manager.api.u.a r4, dw r5, int r6, d.h.b.h r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 8) == 0) goto L8;
            r5 = null;
        L8:
            this(r2, r3, r4, r5);
        }

        public final com.obric.aiagent.skill.manager.api.e a() {
            return this.f20084a;
        }

        public final ar b() {
            return this.f20085b;
        }

        public final com.obric.aiagent.skill.manager.api.u.a c() {
            return this.f20086c;
        }

        public final dw d() {
            return this.f20087d;
        }
    }

    /* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final hg f20089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f20090c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20088a, r6.f20088a) == true) goto L12;
            return false;
        L12:
            if (this.f20089b == r6.f20089b) goto L15;
            return false;
        L15:
            if (this.f20090c == r6.f20090c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f20088a.hashCode() * 31) + this.f20089b.hashCode()) * 31) + Boolean.hashCode(this.f20090c);
        }

        public String toString() {
            return "SkillUpdateRequestKey(slug=" + this.f20088a + ", reason=" + this.f20089b + ", automaticMaintenanceEnabled=" + this.f20090c + ')';
        }

        public c(String r2, hg r3, boolean r4) {
            d.h.b.o.e(r2, "slug");
            d.h.b.o.e(r3, "reason");
            this.f20088a = r2;
            this.f20089b = r3;
            this.f20090c = r4;
        }
    }

    /* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
    @d.c.b.a.f(b = "SkillUpdateCoordinator.kt", c = {234}, d = "performRefresh", e = "com.obric.aiagent.skill.manager.impl.SkillUpdateCoordinator")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f20091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f20092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f20093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f20094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f20095e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        final /* synthetic */ hf i;
        int j;

        d(hf r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.h = r8;
            this.j |= Integer.MIN_VALUE;
            return hf.a(this.i, null, null, false, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
    @d.c.b.a.f(b = "SkillUpdateCoordinator.kt", c = {87}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillUpdateCoordinator$refresh$request$1$3$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super hi>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ hf f20097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ hg f20099d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f20100e;
        final /* synthetic */ ao f;
        final /* synthetic */ hh g;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.hf$e$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
        /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<d.x> {
            AnonymousClass1(Object r8) {
                super(0, r8, hh.class, "notifyRequired", "notifyRequired()V", 0);
            }

            public final void a() {
                ((hh) ZeusTransformUtils.preCheckCast(this.receiver, hh.class, "com.obric.aiagent.plugin")).a();
            }

            @Override // d.h.a.a
            public /* synthetic */ d.x invoke() {
                a();
                return d.x.f38692a;
            }
        }

        e(hf r3, com.obric.aiagent.skill.manager.api.e r4, hg r5, boolean r6, ao r7, hh r8, d.c.d<? super e> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20097b = r3;
            this.f20098c = r4;
            this.f20099d = r5;
            this.f20100e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r10);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super hi> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f20097b, this.f20098c, this.f20099d, this.f20100e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super hi> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20096a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            hf r2 = this.f20097b;
            com.obric.aiagent.skill.manager.api.e r11 = this.f20098c;
            hg r3 = this.f20099d;
            boolean r4 = this.f20100e;
            ao r5 = this.f;
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.g), d.h.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20096a = 1;
            r10 = hf.a(r2, r11, r3, r4, r5, r6, r7);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ d.x lambda$1kMZk7YpP5F8HQz7KOQPDWwo_lA(hf r0, c r1, a r2, Throwable r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ d.x lambda$nnfOFOZZiFWHH8CFeUTomgXaEAw() {
        return a();
    }

    public hf(d.h.a.b<? super String, com.obric.aiagent.skill.manager.api.e> r3, d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r4, d.h.a.q<? super com.obric.aiagent.skill.manager.api.e, ? super hg, ? super ao, ? extends com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r5, ac r6, p r7, hd r8, kotlinx.coroutines.am r9) {
        d.h.a.b<String, com.obric.aiagent.skill.manager.api.e> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.api.e> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.q<com.obric.aiagent.skill.manager.api.e, hg, ao, com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r12 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.q.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r13 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "findInstalledSkill");
        d.h.b.o.e(r11, "readInstalledPackage");
        d.h.b.o.e(r12, "updateStoreSkill");
        d.h.b.o.e(r6, "manifestReader");
        d.h.b.o.e(r7, "cliRepository");
        d.h.b.o.e(r8, "trackingReporter");
        d.h.b.o.e(r13, "updateScope");
        this.f20077a = r10;
        this.f20078b = r11;
        this.f20079c = r12;
        this.f20080d = r6;
        this.f20081e = r7;
        this.f = r8;
        this.g = r13;
        this.h = new Object();
        this.i = new LinkedHashMap();
    }

    public static final /* synthetic */ Object a(hf r9, com.obric.aiagent.skill.manager.api.e r10, hg r11, boolean r12, ao r13, d.h.a.a r14, d.c.d r15) {
        return r9.b(r10, r11, r12, r13, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public /* synthetic */ hf(d.h.a.b r13, d.h.a.b r14, d.h.a.q r15, ac r16, p r17, hd r18, kotlinx.coroutines.am r19, int r20, d.h.b.h r21) {
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.q r5 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.q.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r0 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r19, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        if ((r20 & 32) == 0) goto L5;
        hd r8 = new hd(null, null, null, 7, null);
    L7:
        if ((r20 & 64) == 0) goto L9;
        r0 = kotlinx.coroutines.an.a(kotlinx.coroutines.cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    L9:
        this(r3, r4, r5, r16, r17, r8, r0);
        return;
    L5:
        r8 = r18;
        goto L7
    }

    private static final d.x a() {
        return d.x.f38692a;
    }

    public static /* synthetic */ Object a(hf r7, com.obric.aiagent.skill.manager.api.e r8, hg r9, boolean r10, ao r11, d.h.a.a r12, d.c.d r13, int r14, Object r15) {
        d.h.a.a<d.x> r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d<? super hi> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r14 & 8) == 0) goto L5;
        r11 = null;
    L5:
        ao r4 = r11;
        if ((r14 & 16) == 0) goto L9;
        r16 = $$Lambda$hf$nnfOFOZZiFWHH8CFeUTomgXaEAw.INSTANCE;
    L9:
        return r7.a(r8, r9, r10, r4, r16, r6);
    }

    public final Object a(com.obric.aiagent.skill.manager.api.e r19, hg r20, boolean r21, ao r22, d.h.a.a<d.x> r23, d.c.d<? super hi> r24) {
        d.h.a.a<d.x> r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d<? super hi> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        final c r10 = new c(r19.a(), r20, r21);
        Object r11 = this.h;
        monitor-enter(r11);
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.i.get(r10), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r2 != null) goto L7;
    L12:
        hh r12 = new hh(r1);     // Catch: Throwable -> L17
        final a r13 = new a(kotlinx.coroutines.i.b(this.g, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r19, r20, r21, r22, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null), r12);     // Catch: Throwable -> L17
        ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.aiagent.plugin")).put(r10, r13);     // Catch: Throwable -> L17
        r13.a().a_(new $$Lambda$hf$1kMZk7YpP5F8HQz7KOQPDWwo_lA(this, r10, r13));     // Catch: Throwable -> L17
        r2 = r13;
    L14:
        monitor-exit(r11);
        return r2.a().a(r9);
    L7:
        if (r2.a().b() == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        r2.b().a(r1);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private static final d.x a(hf r1, c r2, a r3, Throwable r4) {
        Object r5 = r1.h;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r1.i.get(r2) != r3) goto L7;
        r1.i.remove(r2);     // Catch: Throwable -> L11
    L7:
        d.x r6 = d.x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return d.x.f38692a;
    }

    private final Object b(com.obric.aiagent.skill.manager.api.e r40, hg r41, boolean r42, ao r43, d.h.a.a<d.x> r44, d.c.d<? super hi> r45) {
        d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r44, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r45, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L7;
        d r6 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        if ((r6.j & Integer.MIN_VALUE) == 0) goto L7;
        r6.j -= Integer.MIN_VALUE;
    L8:
        Object r1 = r6.h;
        Object r7 = d.c.a.b.a();
        int r8 = r6.j;
        String r10 = "required_cli_count";
        if (r8 == 0) goto L20;
        if (r8 != 1) goto L19;
        ea r24 = (ea) ZeusTransformUtils.preCheckCast(r6.g, ea.class, "com.obric.aiagent.plugin");
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(r6.f, List.class, "com.obric.aiagent.plugin");
        ab r3 = (ab) ZeusTransformUtils.preCheckCast(r6.f20095e, ab.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.e r11 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r6.f20094d, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        b r9 = (b) ZeusTransformUtils.preCheckCast(r6.f20093c, b.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.e r12 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r6.f20092b, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        hg r13 = (hg) ZeusTransformUtils.preCheckCast(r6.f20091a, hg.class, "com.obric.aiagent.plugin");
        d.o.a(r1);     // Catch: Exception -> L14 CancellationException -> L16
        r10 = "required_cli_count";
        String r18 = "toLowerCase(...)";
        Object r17 = "reason";
    L217:
        l r4 = (l) ZeusTransformUtils.preCheckCast(r1, l.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L183 CancellationException -> L186
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r4.a(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L183 CancellationException -> L186
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L212;
    L106:
        Iterator r15 = r14.iterator();     // Catch: Exception -> L183 CancellationException -> L186
        int r16 = 0;
    L108:
        if (r15.hasNext() == false) goto L118;
        if (((q) ZeusTransformUtils.preCheckCast(r15.next(), q.class, "com.obric.aiagent.plugin")).a() != n.f20135c) goto L112;
        boolean r19 = true;
    L113:
        if (r19 == false) goto L108;
        r16 = r16 + 1;     // Catch: Exception -> L102 CancellationException -> L104
        if (r16 >= 0) goto L108;
        d.a.p.d();     // Catch: Exception -> L102 CancellationException -> L104
        goto L108
    L112:
        r19 = false;
    L118:
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r4.a(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L183 CancellationException -> L186
        if (ZeusTransformUtils.instanceOf(r110, Collection.class) == true) goto L121;
    L123:
        Iterator r111 = r110.iterator();     // Catch: Exception -> L183 CancellationException -> L186
        int r112 = 0;
    L125:
        if (r111.hasNext() == false) goto L135;
        if (((q) ZeusTransformUtils.preCheckCast(r111.next(), q.class, "com.obric.aiagent.plugin")).a() != n.f20136d) goto L129;
        boolean r113 = true;
    L130:
        if (r113 == false) goto L125;
        r112 = r112 + 1;     // Catch: Exception -> L102 CancellationException -> L104
        if (r112 >= 0) goto L125;
        d.a.p.d();     // Catch: Exception -> L102 CancellationException -> L104
        goto L125
    L129:
        r113 = false;
    L135:
        int r114 = r16 + r112;
        int r115 = r4.a().size() - r114;
        if (r16 <= 0) goto L141;
        dw r116 = dw.g;     // Catch: Exception -> L102 CancellationException -> L104
    L140:
        dw r32 = r116;
    L144:
        if (r24 == null) goto L176;
        if (r114 != 0) goto L147;
        dz r117 = dz.f19791a;     // Catch: Exception -> L102 CancellationException -> L104
    L151:
        dz r26 = r117;
        if (r114 <= 0) goto L154;
        boolean r118 = true;
    L155:
        if (r118 == false) goto L157;
        String r33 = "refresh";
    L158:
        if (r16 <= 0) goto L160;
        boolean r119 = true;
    L161:
        Boolean r34 = d.c.b.a.b.a(r119);     // Catch: Exception -> L183 CancellationException -> L186
        Boolean r35 = d.c.b.a.b.a(false);     // Catch: Exception -> L183 CancellationException -> L186
        Map<String, Object> r120 = eb.a(r4);     // Catch: Exception -> L183 CancellationException -> L186
        d.m[] r121 = new d.m[2];     // Catch: Exception -> L183 CancellationException -> L186
        String r122 = r13.a().name().toLowerCase(Locale.ROOT);     // Catch: Exception -> L183 CancellationException -> L186
        String r123 = r18;
        d.h.b.o.c(r122, r123);     // Catch: Exception -> L172 CancellationException -> L174
        Object r124 = r17;
        r121[0] = d.s.a(r124, r122);     // Catch: Exception -> L168 CancellationException -> L170
        Integer r125 = d.c.b.a.b.a(r2.size());     // Catch: Exception -> L168 CancellationException -> L170
        List<String> r39 = r2;
        r10 = r10;
        r121[1] = d.s.a(r10, r125);     // Catch: Exception -> L179 CancellationException -> L181
        ea.a(r24, r26, r11, null, null, null, null, r32, r33, r34, r35, d.a.ao.a(r120, d.a.ao.a(r121)), 60, null);     // Catch: Exception -> L179 CancellationException -> L181
    L177:
    L241:
        return new hi(r11, r12.j(), r9.b(), r3, r4, false, r9.c(), r9.d(), null, 288, null);
    L181:
        e = e;
    L182:
        r24 = r24;
        r11 = r11;
        String r20 = r123;
        r17 = r124;
        List<String> r126 = r39;
    L199:
        if (r24 == null) goto L201;
        dz r25 = dz.f19793c;
        dw r31 = dw.n;
        Boolean r36 = d.c.b.a.b.a(false);
        Boolean r37 = d.c.b.a.b.a(false);
        String r21 = r13.a().name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r21, r20);
        ea.a(r24, r25, r11, null, null, null, null, r31, "refresh", r36, r37, d.a.ao.a(new d.m[]{d.s.a(r17, r21), d.s.a(r10, d.c.b.a.b.a(r126.size()))}), 60, null);
    L201:
        throw e;
    L179:
        e = e;
    L180:
        r24 = r24;
        r11 = r11;
        String r22 = r123;
        r17 = r124;
        r126 = r39;
    L191:
        dw r127 = eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        if (r24 == null) goto L195;
        dz r27 = dz.f19792b;
        Boolean r38 = d.c.b.a.b.a(eb.a(r127));
        Boolean r310 = d.c.b.a.b.a(false);
        String r23 = r13.a().name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r23, r22);
        ea.a(r24, r27, r11, null, null, null, null, r127, "refresh", r38, r310, d.a.ao.a(new d.m[]{d.s.a(r17, r23), d.s.a(r10, d.c.b.a.b.a(r126.size()))}), 60, null);
    L195:
        ee.f19808a.a("SkillManager", "Required CLI refresh failed; using current packages", "Required CLI refresh failed: slug=" + r11.a() + ", reason=" + r13, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new hi(r11, r12.j(), r9.b(), r3, null, true, r9.c(), r9.d(), r127, 16, null);
    L170:
        e = e;
        r39 = r2;
        r10 = r10;
    L168:
        e = e;
        r39 = r2;
        r10 = r10;
        goto L180
    L174:
        e = e;
        List<String> r311 = r2;
        r10 = r10;
        r126 = r311;
        r24 = r24;
        r11 = r11;
        r20 = r123;
        r17 = r17;
    L172:
        e = e;
        List<String> r312 = r2;
        r10 = r10;
        r126 = r312;
        r24 = r24;
        r11 = r11;
        r22 = r123;
        r17 = r17;
        goto L191
    L160:
        r119 = false;
        goto L161
    L157:
        r33 = null;
        goto L158
    L154:
        r118 = false;
        goto L155
    L147:
        if (r115 != 0) goto L150;
        r117 = dz.f19792b;     // Catch: Exception -> L102 CancellationException -> L104
        goto L151
    L150:
        r117 = dz.f19794d;     // Catch: Exception -> L183 CancellationException -> L186
        goto L151
    L176:
        r39 = r2;
        r124 = r17;
        r123 = r18;
        r10 = r10;
        goto L177
    L141:
        if (r112 <= 0) goto L143;
        r116 = dw.f19776a;     // Catch: Exception -> L102 CancellationException -> L104
        goto L140
    L143:
        r32 = null;
        goto L144
    L121:
        if (((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L123;
        r112 = 0;
        goto L135
    L212:
    L104:
        e = e;
        r126 = r2;
    L188:
        r20 = r18;
    L102:
        e = e;
        r126 = r2;
    L185:
        r22 = r18;
        goto L191
    L100:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L106;
        r16 = 0;
    L186:
        e = e;
        r126 = r2;
    L183:
        e = e;
        r126 = r2;
        goto L185
    L16:
        e = e;
        r24 = r24;
        r126 = r2;
        r11 = r11;
        r10 = "required_cli_count";
        r20 = "toLowerCase(...)";
        r17 = "reason";
    L14:
        e = e;
        r24 = r24;
        r126 = r2;
        r10 = "required_cli_count";
        r22 = "toLowerCase(...)";
        r11 = r11;
        r17 = "reason";
        goto L191
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r1);
        com.obric.aiagent.skill.manager.api.e r28 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f20077a.invoke(r40.a()), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r28 != null) goto L23;
        r12 = r40;
    L24:
        if (r42 == true) goto L29;
        b r29 = new b(r12, ar.f19511b, null, null, 12, null);
    L26:
        b r30 = r29;
    L66:
        com.obric.aiagent.skill.manager.api.e r46 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f20077a.invoke(r12.a()), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        if (r46 != null) goto L69;
        r46 = r30.a();
    L69:
        com.obric.aiagent.skill.manager.api.e r128 = r46;
        r11 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f20078b.invoke(r128), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L72 CancellationException -> L204
    L74:
        ab r129 = this.f20080d.a(r11.a());
        if (ZeusTransformUtils.instanceOf(r129, ab.c.class) == false) goto L77;
        ab.c r47 = (ab.c) ZeusTransformUtils.preCheckCast(r129, ab.c.class, "com.obric.aiagent.plugin");
    L78:
        if (r47 == null) goto L82;
        aa r48 = r47.b();
        if (r48 == null) goto L82;
        List<String> r49 = r48.b();
    L83:
        if (r49 != null) goto L85;
        r49 = d.a.p.b();
    L85:
        r126 = r49;
        r17 = "reason";
        r18 = "toLowerCase(...)";
        ee.f19808a.b("SkillManager", "Skill automatic update completed", "Skill automatic update completed: slug=" + r11.a() + ", reason=" + r41 + ", outcome=" + r30.b() + ", version=" + r12.j() + "->" + r11.j() + ", isObric=" + ZeusTransformUtils.instanceOf(r129, ab.c.class) + ", requiredCliCount=" + r126.size());
        if (r126.isEmpty() == true) goto L203;
        if (r42 == false) goto L203;
        if (r41 != hg.f20102b) goto L92;
        ea r130 = new ea(dy.s, this.f, null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
    L213:
        p r50 = this.f20081e;     // Catch: Exception -> L189 CancellationException -> L197
        Collection<String> r51 = (Collection) ZeusTransformUtils.preCheckCast(r126, Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L189 CancellationException -> L197
        o r131 = r41.a();     // Catch: Exception -> L189 CancellationException -> L197
        r6.f20091a = r41;     // Catch: Exception -> L189 CancellationException -> L197
        r6.f20092b = r12;     // Catch: Exception -> L189 CancellationException -> L197
        r6.f20093c = r30;     // Catch: Exception -> L189 CancellationException -> L197
        r6.f20094d = r11;     // Catch: Exception -> L189 CancellationException -> L197
        r6.f20095e = r129;     // Catch: Exception -> L189 CancellationException -> L197
        r6.f = r126;     // Catch: Exception -> L189 CancellationException -> L197
        r6.g = r130;     // Catch: Exception -> L189 CancellationException -> L197
        r6.j = 1;     // Catch: Exception -> L189 CancellationException -> L197
        r1 = r50.a(r51, r131, r5, r6);     // Catch: Exception -> L189 CancellationException -> L197
        if (r1 != r7) goto L96;
        return r7;
    L96:
        r13 = r41;
        r9 = r30;
        r11 = r11;
        r24 = r130;
        r3 = r129;
        r2 = r126;
        goto L217
    L197:
        e = e;
        r17 = r17;
        r20 = r18;
        r10 = r10;
        r13 = r41;
        r11 = r11;
        r24 = r130;
    L189:
        e = e;
        r17 = r17;
        r22 = r18;
        r10 = r10;
        r13 = r41;
        r9 = r30;
        r24 = r130;
        r3 = r129;
        goto L191
    L92:
        r130 = null;
    L203:
        return new hi(r11, r12.j(), r30.b(), r129, null, false, r30.c(), r30.d(), null, ResultCode.ERROR_MULTI_DETAIL, null);
    L82:
        r49 = null;
        goto L83
    L77:
        r47 = null;
        goto L78
    L204:
        e = move-exception;
        throw e;
    L72:
        e = move-exception;
        ee.f19808a.a("SkillManager", "Updated Skill package read failed; using registry snapshot", "Updated Skill package read failed: slug=" + r12.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r11 = r128;
        goto L74
    L29:
        if (ZeusTransformUtils.instanceOf(r12.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == true) goto L208;
        r29 = new b(r12, ar.f19510a, null, null, 12, null);
        goto L26
    L208:
        d.n.a r52 = d.n.f38560a;     // Catch: Throwable -> L39
        hf r53 = (hf) ZeusTransformUtils.preCheckCast(this, hf.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
        if (r43 != null) goto L34;
    L36:
        boolean r54 = false;
    L37:
        Object r55 = d.n.f(d.c.b.a.b.a(r54));     // Catch: Throwable -> L39
    L41:
        Boolean r132 = d.c.b.a.b.a(false);     // Catch: Exception -> L63 CancellationException -> L206
        if (d.n.b(r55) == false) goto L45;
        r55 = r132;
    L45:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r55, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L47;
        r5.invoke();     // Catch: Exception -> L63 CancellationException -> L206
    L47:
        com.obric.aiagent.skill.manager.api.u r56 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(this.f20079c.invoke(r12, r41, r43), com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L63 CancellationException -> L206
        if (ZeusTransformUtils.instanceOf(r56, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L211;
        com.obric.aiagent.skill.manager.api.e r133 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r56, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L63 CancellationException -> L206
        if (((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r56, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).j() <= r12.j()) goto L52;
        ar r57 = ar.f19513d;     // Catch: Exception -> L63 CancellationException -> L206
    L53:
        r30 = new b(r133, r57, null, null, 12, null);     // Catch: Exception -> L63 CancellationException -> L206
        goto L66
    L52:
        r57 = ar.f19512c;     // Catch: Exception -> L63 CancellationException -> L206
        goto L53
    L211:
        if (ZeusTransformUtils.instanceOf(r56, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L60;
        r30 = new b(r12, ar.f19514e, (com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r56, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"), eb.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r56, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L61 CancellationException -> L206
        goto L66
    L60:
        throw new d.k();     // Catch: Exception -> L61 CancellationException -> L206
    L61:
        e = e;
    L65:
        ee.f19808a.a("SkillManager", "Skill automatic update failed; using local package", "Skill automatic update failed: slug=" + r12.a() + ", reason=" + r41, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r30 = new b(r12, ar.f19514e, null, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), 4, null);
        goto L66
    L34:
        if (hj.f20114a.a(r12.j(), r43.a().j()) != ec.f19805b) goto L36;
        r54 = true;
    L39:
        th = move-exception;
        d.n.a r134 = d.n.f38560a;     // Catch: Exception -> L63 CancellationException -> L206
        r55 = d.n.f(d.o.a(th));     // Catch: Exception -> L63 CancellationException -> L206
    L206:
        e = move-exception;
        throw e;
    L63:
        e = e;
        goto L65
    L23:
        r12 = r28;
    L7:
        r6 = new d(this, r0);
        goto L8
    }
}
