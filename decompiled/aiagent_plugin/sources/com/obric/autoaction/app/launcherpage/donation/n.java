package com.obric.autoaction.app.launcherpage.donation;

import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: UploadRecordViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends aj {
    private static final String TAG = "UploadRecordViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23816a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<List<e.a>> f23817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f23818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x<h> f23819d;

    /* JADX INFO: compiled from: UploadRecordViewModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: UploadRecordViewModel.kt */
    @d.c.b.a.f(b = "UploadRecordViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.UploadRecordViewModel$init$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f23821b;

        b(n r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23821b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23821b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f23820a != 0) goto L7;
            o.a(r2);
            n.a(this.f23821b).c();
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: UploadRecordViewModel.kt */
    @d.c.b.a.f(b = "UploadRecordViewModel.kt", c = {33}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.UploadRecordViewModel$init$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f23823b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.n$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: UploadRecordViewModel.kt */
        @d.c.b.a.f(b = "UploadRecordViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.UploadRecordViewModel$init$2$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<List<? extends e.c>, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23824a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f23825b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ n f23826c;

            AnonymousClass1(n r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23826c = r3;
                super(2, r5);
            }

            public final Object a(List<e.c> r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f23826c, r5);
                r0.f23825b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(List<? extends e.c> r3, d.c.d<? super d.x> r4) {
                return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r10) {
                d.c.a.b.a();
                if (this.f23824a != 0) goto L38;
                o.a(r10);
                List r11 = (List) ZeusTransformUtils.preCheckCast(this.f23825b, List.class, "com.obric.aiagent.plugin");
                List r0 = n.b(this.f23826c);
                if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L35;
                Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
                Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
                Iterator r3 = r2.iterator();
            L8:
                if (r3.hasNext() == false) goto L10;
                r4.add(((e.c) ZeusTransformUtils.preCheckCast(r3.next(), e.c.class, "com.obric.aiagent.plugin")).a().b());
                goto L8
            L10:
                Set r5 = p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
                Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L13;
            L15:
                Iterator r7 = r6.iterator();
            L17:
                if (r7.hasNext() == false) goto L14;
                if (r5.contains(((e.c) ZeusTransformUtils.preCheckCast(r7.next(), e.c.class, "com.obric.aiagent.plugin")).a().b()) == false) goto L17;
                boolean r8 = true;
            L21:
                if (r8 == false) goto L35;
                Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
                Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                Iterator r12 = r1.iterator();
            L24:
                if (r12.hasNext() == false) goto L34;
                Object r13 = r12.next();
                e.c r14 = (e.c) ZeusTransformUtils.preCheckCast(r13, e.c.class, "com.obric.aiagent.plugin");
                if (r14.a().e() != m.a.f.f23791a.a()) goto L28;
            L31:
                boolean r15 = true;
            L32:
                if (r15 == false) goto L24;
                r9.add(r13);
                goto L24
            L28:
                if (r14.a().e() == m.a.d.f23789a.a()) goto L31;
                r15 = false;
                goto L32
            L34:
                r0 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
                Loog.INSTANCE.w(n.TAG, "same task exist in pending-failed and server record list, so filter them out");
            L14:
                r8 = false;
                goto L21
            L13:
                if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L15;
            L35:
                this.f23826c.b().b(n.a(this.f23826c, p.c((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin"))));
                return d.x.f38692a;
            L38:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        c(n r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23823b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23823b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23822a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            kotlinx.coroutines.b.h r8 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(n.a(this.f23823b).a(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23823b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23822a = 1;
            if (kotlinx.coroutines.b.j.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((e.c) ZeusTransformUtils.preCheckCast(r2, e.c.class, "com.obric.aiagent.plugin")).a().f()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((e.c) ZeusTransformUtils.preCheckCast(r3, e.c.class, "com.obric.aiagent.plugin")).a().f()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f23816a = new a(null);
    }

    public n() {
        this.f23817b = kotlinx.coroutines.b.am.a(p.b());
        f r0 = new f(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")));
        this.f23818c = r0;
        this.f23819d = r0.b();
    }

    public static final /* synthetic */ f a(n r0) {
        return r0.f23818c;
    }

    public static final /* synthetic */ List a(n r2, List r3) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ List b(n r0) {
        return r0.g();
    }

    public final x<List<e.a>> b() {
        return this.f23817b;
    }

    public final x<h> c() {
        return this.f23819d;
    }

    public final void e() {
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final List<e.c> g() {
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(m.f23777a.c(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r3.add(new e.c((com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin")));
        goto L4
    L6:
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(m.f23777a.d(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r5.add(new e.c((com.obric.autoaction.app.launcherpage.donation.model.a) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.autoaction.app.launcherpage.donation.model.a.class, "com.obric.aiagent.plugin")));
        goto L8
    L10:
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L15;
        x<h> r7 = this.f23819d;
    L13:
        h r8 = r7.c();
        h r9 = (h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.aiagent.plugin");
        if (r7.a(r8, (h) ZeusTransformUtils.preCheckCast(h.d.f23766a, h.class, "com.obric.aiagent.plugin")) == false) goto L13;
    L15:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        HashSet r11 = new HashSet();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L17:
        if (r13.hasNext() == false) goto L22;
        Object r14 = r13.next();
        if (r11.add(((e.c) ZeusTransformUtils.preCheckCast(r14, e.c.class, "com.obric.aiagent.plugin")).a().a()) == false) goto L17;
        r12.add(r14);
        goto L17
    L22:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
    }

    private final List<e.a> a(List<e.c> r10) {
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r12 = r9.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r1 = r12.next();
        Long r2 = Long.valueOf(com.obric.autogui.util.e.a.b(((e.c) ZeusTransformUtils.preCheckCast(r1, e.c.class, "com.obric.aiagent.plugin")).a().f()));
        Object r3 = r11.get(r2);
        if (r3 != null) goto L8;
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r11.put(r2, r3);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")).add(r1);
        goto L4
    L9:
        SortedMap r13 = ao.b(r11);
        List r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r15 = ((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L11:
        if (r15.hasNext() == false) goto L30;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(r4.getKey(), Long.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r6);
        List r7 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.aiagent.plugin"));
        if (r7.size() <= 1) goto L28;
        int r8 = 0;
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r16.hasNext() == false) goto L28;
        Object r17 = r16.next();
        int r18 = r8 + 1;
        if (r8 >= 0) goto L20;
        p.c();
    L20:
        e.c r19 = (e.c) ZeusTransformUtils.preCheckCast(r17, e.c.class, "com.obric.aiagent.plugin");
        if (r8 != 0) goto L24;
        int r20 = 1;
    L27:
        r19.a(r20);
        r8 = r18;
        goto L16
    L24:
        if (r8 != (r7.size() - 1)) goto L26;
        r20 = 3;
        goto L27
    L26:
        r20 = 2;
    L28:
        r14.addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin"));
        com.obric.autogui.util.e.b r21 = com.obric.autogui.util.e.b.f31545a;
        d.h.b.o.a(r5);
        r14.add(new e.b(r21.a(r5.longValue())));
        goto L11
    L30:
        return p.l((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"));
    }

    public final void f() {
        this.f23818c.d();
    }

    @Override // androidx.lifecycle.aj
    public void a() {
        super.a();
        m.f23777a.b().clear();
    }
}
