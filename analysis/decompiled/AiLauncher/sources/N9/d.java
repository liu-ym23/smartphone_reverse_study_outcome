package N9;

import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class d implements i {

    /* renamed from: a, reason: collision with root package name */
    public int f4915a;

    /* renamed from: b, reason: collision with root package name */
    public String f4916b;

    /* renamed from: i, reason: collision with root package name */
    public String f4923i;

    /* renamed from: n, reason: collision with root package name */
    public String f4928n;

    /* renamed from: o, reason: collision with root package name */
    public q f4929o;

    /* renamed from: s, reason: collision with root package name */
    public final List<P9.b> f4933s;

    /* renamed from: c, reason: collision with root package name */
    public final List<s> f4917c = new ArrayList(0);

    /* renamed from: d, reason: collision with root package name */
    public final List<q> f4918d = new ArrayList(1);

    /* renamed from: e, reason: collision with root package name */
    public final List<n> f4919e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final List<o> f4920f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final List<r> f4921g = new ArrayList(0);

    /* renamed from: h, reason: collision with root package name */
    public final List<g> f4922h = new ArrayList(1);

    /* renamed from: j, reason: collision with root package name */
    public final List<String> f4924j = new ArrayList(0);

    /* renamed from: k, reason: collision with root package name */
    public final List<String> f4925k = new ArrayList(0);

    /* renamed from: l, reason: collision with root package name */
    public final List<l> f4926l = new ArrayList(0);

    /* renamed from: m, reason: collision with root package name */
    public final List<String> f4927m = new ArrayList(0);

    /* renamed from: p, reason: collision with root package name */
    public final List<b> f4930p = new ArrayList(0);

    /* renamed from: q, reason: collision with root package name */
    public final List<q> f4931q = new ArrayList(0);

    /* renamed from: r, reason: collision with root package name */
    public final List<w> f4932r = new ArrayList(0);

    public d() {
        List<P9.n> listC = P9.n.f5383a.c();
        ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(((P9.n) it.next()).g());
        }
        this.f4933s = arrayList;
    }

    @Override // N9.i
    public List<o> a() {
        return this.f4920f;
    }

    @Override // N9.i
    public List<r> b() {
        return this.f4921g;
    }

    @Override // N9.i
    public List<n> c() {
        return this.f4919e;
    }

    public final List<b> d() {
        return this.f4930p;
    }

    public final List<g> e() {
        return this.f4922h;
    }

    public final List<q> f() {
        return this.f4931q;
    }

    public final List<String> g() {
        return this.f4925k;
    }

    public final List<P9.b> h() {
        return this.f4933s;
    }

    public final int i() {
        return this.f4915a;
    }

    public final q j() {
        return this.f4929o;
    }

    public final List<l> k() {
        return this.f4926l;
    }

    public final String l() {
        String str = this.f4916b;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.p.A("name");
        return null;
    }

    public final List<String> m() {
        return this.f4924j;
    }

    public final List<String> n() {
        return this.f4927m;
    }

    public final List<q> o() {
        return this.f4918d;
    }

    public final List<s> p() {
        return this.f4917c;
    }

    public final List<w> q() {
        return this.f4932r;
    }

    public final void r(String str) {
        this.f4923i = str;
    }

    public final void s(int i10) {
        this.f4915a = i10;
    }

    public final void t(String str) {
        this.f4928n = str;
    }

    public final void u(q qVar) {
        this.f4929o = qVar;
    }

    public final void v(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.f4916b = str;
    }
}
