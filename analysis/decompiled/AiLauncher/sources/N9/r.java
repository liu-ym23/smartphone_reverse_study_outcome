package N9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public int f5001a;

    /* renamed from: b, reason: collision with root package name */
    public String f5002b;

    /* renamed from: c, reason: collision with root package name */
    public final List<s> f5003c;

    /* renamed from: d, reason: collision with root package name */
    public q f5004d;

    /* renamed from: e, reason: collision with root package name */
    public q f5005e;

    /* renamed from: f, reason: collision with root package name */
    public final List<b> f5006f;

    /* renamed from: g, reason: collision with root package name */
    public final List<w> f5007g;

    /* renamed from: h, reason: collision with root package name */
    public final List<P9.i> f5008h;

    public r(int i10, String name) {
        kotlin.jvm.internal.p.i(name, "name");
        this.f5001a = i10;
        this.f5002b = name;
        this.f5003c = new ArrayList(0);
        this.f5006f = new ArrayList(0);
        this.f5007g = new ArrayList(0);
        List<P9.n> listC = P9.n.f5383a.c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            ((P9.n) it.next()).a();
        }
        this.f5008h = arrayList;
    }

    public final List<b> a() {
        return this.f5006f;
    }

    public final int b() {
        return this.f5001a;
    }

    public final List<s> c() {
        return this.f5003c;
    }

    public final List<w> d() {
        return this.f5007g;
    }

    public final void e(q qVar) {
        kotlin.jvm.internal.p.i(qVar, "<set-?>");
        this.f5005e = qVar;
    }

    public final void f(int i10) {
        this.f5001a = i10;
    }

    public final void g(q qVar) {
        kotlin.jvm.internal.p.i(qVar, "<set-?>");
        this.f5004d = qVar;
    }
}
