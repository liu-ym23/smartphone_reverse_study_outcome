package N9;

import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public int f4960a;

    /* renamed from: b, reason: collision with root package name */
    public String f4961b;

    /* renamed from: c, reason: collision with root package name */
    public final List<s> f4962c;

    /* renamed from: d, reason: collision with root package name */
    public q f4963d;

    /* renamed from: e, reason: collision with root package name */
    public final List<b> f4964e;

    /* renamed from: f, reason: collision with root package name */
    public final List<q> f4965f;

    /* renamed from: g, reason: collision with root package name */
    public final List<u> f4966g;

    /* renamed from: h, reason: collision with root package name */
    public final List<u> f4967h;

    /* renamed from: i, reason: collision with root package name */
    public q f4968i;

    /* renamed from: j, reason: collision with root package name */
    public final List<w> f4969j;

    /* renamed from: k, reason: collision with root package name */
    public h f4970k;

    /* renamed from: l, reason: collision with root package name */
    public final List<b> f4971l;

    /* renamed from: m, reason: collision with root package name */
    public final List<P9.g> f4972m;

    public n(int i10, String name) {
        kotlin.jvm.internal.p.i(name, "name");
        this.f4960a = i10;
        this.f4961b = name;
        this.f4962c = new ArrayList(0);
        this.f4964e = new ArrayList(0);
        this.f4965f = new ArrayList(0);
        this.f4966g = new ArrayList();
        this.f4967h = new ArrayList();
        this.f4969j = new ArrayList(0);
        this.f4971l = new ArrayList(0);
        List<P9.n> listC = P9.n.f5383a.c();
        ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(((P9.n) it.next()).p());
        }
        this.f4972m = arrayList;
    }

    public final List<b> a() {
        return this.f4971l;
    }

    public final List<u> b() {
        return this.f4967h;
    }

    public final List<b> c() {
        return this.f4964e;
    }

    public final List<P9.g> d() {
        return this.f4972m;
    }

    public final int e() {
        return this.f4960a;
    }

    public final List<s> f() {
        return this.f4962c;
    }

    public final List<u> g() {
        return this.f4966g;
    }

    public final List<w> h() {
        return this.f4969j;
    }

    public final void i(h hVar) {
        this.f4970k = hVar;
    }

    public final void j(int i10) {
        this.f4960a = i10;
    }

    public final void k(q qVar) {
        this.f4963d = qVar;
    }

    public final void l(q qVar) {
        kotlin.jvm.internal.p.i(qVar, "<set-?>");
        this.f4968i = qVar;
    }
}
