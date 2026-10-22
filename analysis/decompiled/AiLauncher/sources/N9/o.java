package N9;

import Z8.C1174w;
import ea.C4018b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import w9.InterfaceC5752k;

/* loaded from: classes5.dex */
public final class o {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f4973s = {kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(o.class, "_hasSetter", "get_hasSetter()Z", 0)), kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(o.class, "_hasGetter", "get_hasGetter()Z", 0))};

    /* renamed from: a, reason: collision with root package name */
    public int f4974a;

    /* renamed from: b, reason: collision with root package name */
    public String f4975b;

    /* renamed from: c, reason: collision with root package name */
    public final O9.a f4976c;

    /* renamed from: d, reason: collision with root package name */
    public final O9.a f4977d;

    /* renamed from: e, reason: collision with root package name */
    public final p f4978e;

    /* renamed from: f, reason: collision with root package name */
    public p f4979f;

    /* renamed from: g, reason: collision with root package name */
    public final List<s> f4980g;

    /* renamed from: h, reason: collision with root package name */
    public q f4981h;

    /* renamed from: i, reason: collision with root package name */
    public final List<b> f4982i;

    /* renamed from: j, reason: collision with root package name */
    public final List<q> f4983j;

    /* renamed from: k, reason: collision with root package name */
    public final List<u> f4984k;

    /* renamed from: l, reason: collision with root package name */
    public u f4985l;

    /* renamed from: m, reason: collision with root package name */
    public q f4986m;

    /* renamed from: n, reason: collision with root package name */
    public final List<w> f4987n;

    /* renamed from: o, reason: collision with root package name */
    public final List<b> f4988o;

    /* renamed from: p, reason: collision with root package name */
    public final List<b> f4989p;

    /* renamed from: q, reason: collision with root package name */
    public final List<b> f4990q;

    /* renamed from: r, reason: collision with root package name */
    public final List<P9.h> f4991r;

    public o(int i10, String name, int i11, int i12) {
        kotlin.jvm.internal.p.i(name, "name");
        this.f4974a = i10;
        this.f4975b = name;
        C4018b.C0396b HAS_SETTER = C4018b.f32357C;
        kotlin.jvm.internal.p.h(HAS_SETTER, "HAS_SETTER");
        this.f4976c = FlagDelegatesImplKt.g(new O9.c(HAS_SETTER));
        C4018b.C0396b HAS_GETTER = C4018b.f32356B;
        kotlin.jvm.internal.p.h(HAS_GETTER, "HAS_GETTER");
        this.f4977d = FlagDelegatesImplKt.g(new O9.c(HAS_GETTER));
        p pVar = new p(i11);
        q(true);
        this.f4978e = pVar;
        this.f4979f = l() ? new p(i12) : null;
        this.f4980g = new ArrayList(0);
        this.f4982i = new ArrayList(0);
        this.f4983j = new ArrayList(0);
        this.f4984k = new ArrayList();
        this.f4987n = new ArrayList(0);
        this.f4988o = new ArrayList(0);
        this.f4989p = new ArrayList(0);
        this.f4990q = new ArrayList(0);
        List<P9.n> listC = P9.n.f5383a.c();
        ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(((P9.n) it.next()).j());
        }
        this.f4991r = arrayList;
    }

    public final List<b> a() {
        return this.f4988o;
    }

    public final List<b> b() {
        return this.f4989p;
    }

    public final List<u> c() {
        return this.f4984k;
    }

    public final List<b> d() {
        return this.f4990q;
    }

    public final List<b> e() {
        return this.f4982i;
    }

    public final List<P9.h> f() {
        return this.f4991r;
    }

    public final int g() {
        return this.f4974a;
    }

    public final p h() {
        return this.f4978e;
    }

    public final p i() {
        return this.f4979f;
    }

    public final List<s> j() {
        return this.f4980g;
    }

    public final List<w> k() {
        return this.f4987n;
    }

    public final boolean l() {
        return this.f4976c.a(this, f4973s[0]);
    }

    public final void m(int i10) {
        this.f4974a = i10;
    }

    public final void n(q qVar) {
        this.f4981h = qVar;
    }

    public final void o(q qVar) {
        kotlin.jvm.internal.p.i(qVar, "<set-?>");
        this.f4986m = qVar;
    }

    public final void p(u uVar) {
        this.f4985l = uVar;
    }

    public final void q(boolean z10) {
        this.f4977d.b(this, f4973s[1], z10);
    }
}
