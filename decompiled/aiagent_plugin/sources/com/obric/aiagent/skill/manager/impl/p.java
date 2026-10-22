package com.obric.aiagent.skill.manager.impl;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CliUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f20142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f20143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<Long> f20144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f20145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.am f20146e;
    private final Object f;
    private final LinkedHashMap<String, a> g;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.p$1, reason: invalid class name */
    /* JADX INFO: compiled from: CliUpdateRepository.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f20147a = null;

        static {
            f20147a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: CliUpdateRepository.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlinx.coroutines.au<q> f20148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final hh f20149b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20148a, r6.f20148a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20149b, r6.f20149b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f20148a.hashCode() * 31) + this.f20149b.hashCode();
        }

        public String toString() {
            return "InFlightCliUpdate(deferred=" + this.f20148a + ", updateRequiredNotifier=" + this.f20149b + ')';
        }

        public a(kotlinx.coroutines.au<q> r3, hh r4) {
            kotlinx.coroutines.au<q> r5 = (kotlinx.coroutines.au) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.au.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "deferred");
            d.h.b.o.e(r4, "updateRequiredNotifier");
            this.f20148a = r5;
            this.f20149b = r4;
        }

        public final kotlinx.coroutines.au<q> a() {
            return this.f20148a;
        }

        public final hh b() {
            return this.f20149b;
        }
    }

    /* JADX INFO: compiled from: CliUpdateRepository.kt */
    @d.c.b.a.f(b = "CliUpdateRepository.kt", c = {115}, d = "refresh", e = "com.obric.aiagent.skill.manager.impl.CliUpdateRepository")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f20150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f20151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f20152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f20153d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f20154e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ p h;
        int i;

        b(p r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CliUpdateRepository.kt */
    @d.c.b.a.f(b = "CliUpdateRepository.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.CliUpdateRepository$requestRefresh$1$request$3$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f20156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ hh f20158d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.p$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: CliUpdateRepository.kt */
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

        c(p r3, String r4, hh r5, d.c.d<? super c> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20156b = r3;
            this.f20157c = r4;
            this.f20158d = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super q> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f20156b, this.f20157c, this.f20158d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super q> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f20155a != 0) goto L7;
            d.o.a(r4);
            return p.a(this.f20156b, this.f20157c, (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20158d), d.h.a.a.class, "com.obric.aiagent.plugin"));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: lambda$QP9NilYv87oLx6b9vfkzNW6D-GI, reason: not valid java name */
    public static /* synthetic */ d.x m286lambda$QP9NilYv87oLx6b9vfkzNW6DGI(p r0, String r1, a r2, Throwable r3) {
        return a(r0, r1, r2, r3);
    }

    public p(k r3, h r4, d.h.a.a<Long> r5, m r6, kotlinx.coroutines.am r7) {
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r11 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "packageStore");
        d.h.b.o.e(r8, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r9, "nowMs");
        d.h.b.o.e(r10, "logSink");
        d.h.b.o.e(r11, "updateScope");
        this.f20142a = r3;
        this.f20143b = r8;
        this.f20144c = r9;
        this.f20145d = r10;
        this.f20146e = r11;
        this.f = new Object();
        this.g = new LinkedHashMap();
    }

    public static final /* synthetic */ q a(p r2, String r3, d.h.a.a r4) {
        return r2.a(r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public /* synthetic */ p(k r8, h r9, d.h.a.a r10, m r11, kotlinx.coroutines.am r12, int r13, d.h.b.h r14) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.aiagent.plugin");
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        m r16 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.am r17 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r12, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        if ((r13 & 4) == 0) goto L5;
        r15 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f20147a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L5:
        d.h.a.a r4 = r15;
        if ((r13 & 8) == 0) goto L8;
        m r5 = (m) ZeusTransformUtils.preCheckCast(z.f20936a, m.class, "com.obric.aiagent.plugin");
    L10:
        if ((r13 & 16) == 0) goto L12;
        kotlinx.coroutines.am r6 = kotlinx.coroutines.an.a(kotlinx.coroutines.cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    L13:
        this(r8, r3, r4, r5, r6);
        return;
    L12:
        r6 = r17;
        goto L13
    L8:
        r5 = r16;
        goto L10
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x016e -> B:34:0x01af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x019b -> B:33:0x01a2). Please report as a decompilation issue!!! */
    public final Object a(Collection<String> r12, o r13, d.h.a.a<d.x> r14, d.c.d<? super l> r15) {
        Collection r16 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r17 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r18 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r18, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r18, b.class, "com.obric.aiagent.plugin");
        if ((r1.i & Integer.MIN_VALUE) == 0) goto L7;
        r1.i -= Integer.MIN_VALUE;
    L8:
        Object r19 = r1.g;
        Object r3 = d.c.a.b.a();
        int r4 = r1.i;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r1.f, Collection.class, "com.obric.aiagent.plugin");
        Iterator r110 = (Iterator) ZeusTransformUtils.preCheckCast(r1.f20154e, Iterator.class, "com.obric.aiagent.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(r1.f20153d, Collection.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r112 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r1.f20152c, d.h.a.a.class, "com.obric.aiagent.plugin");
        o r5 = (o) ZeusTransformUtils.preCheckCast(r1.f20151b, o.class, "com.obric.aiagent.plugin");
        p r6 = (p) ZeusTransformUtils.preCheckCast(r1.f20150a, p.class, "com.obric.aiagent.plugin");
        d.o.a(r19);
    L33:
        d.h.a.a<d.x> r10 = r112;
        Iterator r113 = r110;
        p r114 = r6;
        q r7 = (q) ZeusTransformUtils.preCheckCast(r19, q.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r115 = r10;
    L34:
        r11.add(r7);
        r11 = r111;
        Iterator r116 = r113;
        o r117 = r5;
    L20:
        if (r116.hasNext() == false) goto L35;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r116.next(), String.class, "com.obric.aiagent.plugin");
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L24
        ((p) ZeusTransformUtils.preCheckCast(r114, p.class, "com.obric.aiagent.plugin")).f20142a.d(r8);     // Catch: Throwable -> L24
        Object r20 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L24
    L27:
        if (d.n.b(r20) == false) goto L29;
        m.a.a(r114.f20145d, "CLI update skipped invalid requested name", null, 2, null);
        r7 = new q(r8, n.f20136d);
        r5 = r117;
        r113 = r116;
        r111 = r11;
        goto L34
    L29:
        kotlinx.coroutines.au<q> r21 = r114.a(r8, r117, r115);
        r1.f20150a = r114;
        r1.f20151b = r117;
        r1.f20152c = r115;
        r1.f20153d = r11;
        r1.f20154e = r116;
        r1.f = r11;
        r1.i = 1;
        Object r22 = r21.a(r1);
        if (r22 != r3) goto L32;
        return r3;
    L32:
        r6 = r114;
        r110 = r116;
        r111 = r11;
        r5 = r117;
        r112 = r115;
        r19 = r22;
    L24:
        th = move-exception;
        d.n.a r23 = d.n.f38560a;
        r20 = d.n.f(d.o.a(th));
        goto L27
    L35:
        List r118 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        m r119 = r114.f20145d;
        StringBuilder r120 = new StringBuilder().append("CLI update completed: reason=").append(r117).append(", updated=");
        Iterable r121 = (Iterable) ZeusTransformUtils.preCheckCast(r118, Iterable.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (ZeusTransformUtils.instanceOf(r121, Collection.class) == true) goto L38;
    L40:
        Iterator r122 = r121.iterator();
        int r123 = 0;
    L42:
        if (r122.hasNext() == false) goto L51;
        if (((q) ZeusTransformUtils.preCheckCast(r122.next(), q.class, "com.obric.aiagent.plugin")).a() != n.f20133a) goto L46;
        boolean r2 = true;
    L47:
        if (r2 == false) goto L42;
        r123 = r123 + 1;
        if (r123 >= 0) goto L42;
        d.a.p.d();
        goto L42
    L46:
        r2 = false;
    L51:
        StringBuilder r124 = r120.append(r123).append(", upToDate=");
        Iterable r125 = (Iterable) ZeusTransformUtils.preCheckCast(r118, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r125, Collection.class) == true) goto L54;
    L56:
        Iterator r126 = r125.iterator();
        int r127 = 0;
    L58:
        if (r126.hasNext() == false) goto L67;
        if (((q) ZeusTransformUtils.preCheckCast(r126.next(), q.class, "com.obric.aiagent.plugin")).a() != n.f20134b) goto L62;
        boolean r24 = true;
    L63:
        if (r24 == false) goto L58;
        r127 = r127 + 1;
        if (r127 >= 0) goto L58;
        d.a.p.d();
        goto L58
    L62:
        r24 = false;
    L67:
        StringBuilder r128 = r124.append(r127).append(", failed=");
        Iterable r129 = (Iterable) ZeusTransformUtils.preCheckCast(r118, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r129, Collection.class) == true) goto L70;
    L72:
        Iterator r130 = r129.iterator();
        int r131 = 0;
    L74:
        if (r130.hasNext() == false) goto L83;
        if (((q) ZeusTransformUtils.preCheckCast(r130.next(), q.class, "com.obric.aiagent.plugin")).a() != n.f20135c) goto L78;
        boolean r25 = true;
    L79:
        if (r25 == false) goto L74;
        r131 = r131 + 1;
        if (r131 >= 0) goto L74;
        d.a.p.d();
        goto L74
    L78:
        r25 = false;
        goto L79
    L83:
        r0 = r131;
    L84:
        r119.a(r128.append(r0).toString());
        return new l(r118);
    L70:
        if (((Collection) ZeusTransformUtils.preCheckCast(r129, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L72;
    L54:
        if (((Collection) ZeusTransformUtils.preCheckCast(r125, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L56;
        r127 = 0;
        goto L67
    L38:
        if (((Collection) ZeusTransformUtils.preCheckCast(r121, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L40;
        r123 = 0;
        goto L51
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r19);
        Iterable r132 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
        Collection r133 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r132, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r134 = r132.iterator();
    L16:
        if (r134.hasNext() == false) goto L18;
        r133.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r134.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        goto L16
    L18:
        List r135 = d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r133, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        this.f20145d.a("CLI update started: reason=" + r13 + ", count=" + r135.size());
        Iterable r136 = (Iterable) ZeusTransformUtils.preCheckCast(r135, Iterable.class, "com.obric.aiagent.plugin");
        Collection r137 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r136, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r138 = r136.iterator();
        r114 = this;
        r11 = r137;
        r115 = r17;
        r117 = r13;
        r116 = r138;
    L7:
        r1 = new b(this, r18);
        goto L8
    }

    public final File a(String r3) {
        d.h.b.o.e(r3, "name");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        p r2 = (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r2.f20142a.d(r3);     // Catch: Throwable -> L5
        Object r4 = d.n.f(r2.f20142a.c(r3));     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r4) == false) goto L11;
        r4 = null;
    L11:
        return (File) ZeusTransformUtils.preCheckCast(r4, File.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L8
    }

    private final kotlinx.coroutines.au<q> a(final String r10, o r11, d.h.a.a<d.x> r12) {
        d.h.a.a<d.x> r13 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        Object r0 = this.f;
        monitor-enter(r0);
        final a r1 = (a) ZeusTransformUtils.preCheckCast(this.g.get(r10), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r1 != null) goto L7;
    L12:
        hh r14 = new hh(r13);     // Catch: Throwable -> L16
        r1 = new a(kotlinx.coroutines.i.b(this.f20146e, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r10, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null), r14);     // Catch: Throwable -> L16
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.aiagent.plugin")).put(r10, r1);     // Catch: Throwable -> L16
        r1.a().a_(new $$Lambda$p$QP9NilYv87oLx6b9vfkzNW6DGI(this, r10, r1));     // Catch: Throwable -> L16
    L13:
        kotlinx.coroutines.au<q> r9 = r1.a();     // Catch: Throwable -> L16
        monitor-exit(r0);
        return r9;
    L7:
        if (r1.a().b() == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        r1.b().a(r13);     // Catch: Throwable -> L16
        this.f20145d.a("CLI update joined in-flight request: name=" + r10 + ", reason=" + r11);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private static final d.x a(p r1, String r2, a r3, Throwable r4) {
        Object r5 = r1.f;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r1.g.get(r2) != r3) goto L7;
        r1.g.remove(r2);     // Catch: Throwable -> L11
    L7:
        d.x r6 = d.x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return d.x.f38692a;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final q a(String r13, d.h.a.a<d.x> r14) {
        String r0 = "-";
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        g r2 = null;
        File r3 = null;
        g r4 = this.f20143b.a(r13);     // Catch: Throwable -> L42
        this.f20142a.a(r4);     // Catch: Throwable -> L40
        j r5 = this.f20142a.b(r13);     // Catch: Throwable -> L40
        if (r5 != null) goto L7;
    L12:
        r15.invoke();     // Catch: Throwable -> L40
        r3 = this.f20142a.a(r13);     // Catch: Throwable -> L40
        boolean r6 = true;
        if (this.f20143b.a(r4.d(), r3) != r4.c()) goto L15;
        boolean r16 = true;
    L16:
        if (r16 == false) goto L39;
        if (r3.length() == r4.c()) goto L21;
        r6 = false;
    L21:
        if (r6 == false) goto L37;
        this.f20142a.a(r13, r4, r3, ((Number) ZeusTransformUtils.preCheckCast(this.f20144c.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L40
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L25
        ((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")).f20142a.a(r13, r4.a());     // Catch: Throwable -> L25
        Object r18 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L25
    L27:
        Throwable r19 = d.n.c(r18);     // Catch: Throwable -> L40
        if (r19 == null) goto L30;
        this.f20145d.a("CLI old version cleanup failed: name=" + r13 + ", version=" + r4.a(), r19);     // Catch: Throwable -> L40
    L30:
        m r110 = this.f20145d;     // Catch: Throwable -> L40
        StringBuilder r7 = new StringBuilder().append("CLI update installed: name=").append(r13).append(", version=").append(r4.a()).append(", status=");     // Catch: Throwable -> L40
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.e(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (d.o.o.d(r8) == false) goto L33;
        r8 = "-";
    L33:
        r110.a(r7.append((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin")).append(", fileSize=").append(r4.c()).toString());     // Catch: Throwable -> L40
        q r111 = new q(r13, n.f20133a);     // Catch: Throwable -> L40
        if (r3 == null) goto L56;
        this.f20142a.a(r3);
    L56:
        return r111;
    L25:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L40
        r18 = d.n.f(d.o.a(th));     // Catch: Throwable -> L40
        goto L27
    L37:
        throw new IllegalArgumentException("CLI downloaded file size mismatch.".toString());     // Catch: Throwable -> L40
    L39:
        throw new IllegalArgumentException("CLI downloaded byte count mismatch.".toString());     // Catch: Throwable -> L40
    L15:
        r16 = false;
        goto L16
    L7:
        if (a(r5, r4) == false) goto L12;
        if (this.f20142a.a(r13, r5) == null) goto L12;
        this.f20145d.a("CLI update is current: name=" + r13 + ", version=" + r4.a());     // Catch: Throwable -> L40
        return new q(r13, n.f20134b);
    L40:
        th = th;
        File r10 = r3;
        r2 = r4;
    L66:
        m r11 = this.f20145d;     // Catch: Throwable -> L57
        StringBuilder r1 = new StringBuilder().append("CLI update failed: name=").append(r13).append(", version=");     // Catch: Throwable -> L57
        String r12 = r0;
        if (r2 == null) goto L53;
        String r20 = r2.a();     // Catch: Throwable -> L57
        r12 = r0;
        if (r20 == null) goto L53;
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        if (d.o.o.d(r21) == false) goto L51;
        CharSequence r22 = r0;
    L52:
        r12 = (String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        goto L53
    L51:
        r22 = r21;
    L53:
        r11.a(r1.append(r12).toString(), th);     // Catch: Throwable -> L57
        r111 = new q(r13, n.f20135c);     // Catch: Throwable -> L57
        if (r10 == null) goto L56;
        this.f20142a.a(r10);
    L57:
        th = move-exception;
        if (r10 == null) goto L60;
        this.f20142a.a(r10);
    L60:
        throw th;
    L42:
        th = th;
        r10 = null;
        goto L66
    }

    private final boolean a(j r3, g r4) {
        if (d.h.b.o.a(r3.a(), r4.a()) == true) goto L5;
    L9:
        return false;
    L5:
        if (d.h.b.o.a(r3.b(), r4.b()) == false) goto L9;
        if (r3.c() != r4.c()) goto L9;
        return true;
    }
}
