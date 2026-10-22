package N9;

import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public int f4994a;

    /* renamed from: b, reason: collision with root package name */
    public e f4995b;

    /* renamed from: c, reason: collision with root package name */
    public final List<t> f4996c;

    /* renamed from: d, reason: collision with root package name */
    public q f4997d;

    /* renamed from: e, reason: collision with root package name */
    public q f4998e;

    /* renamed from: f, reason: collision with root package name */
    public m f4999f;

    /* renamed from: g, reason: collision with root package name */
    public final List<P9.j> f5000g;

    public q(int i10) {
        this.f4994a = i10;
        this.f4996c = new ArrayList(0);
        List<P9.n> listC = P9.n.f5383a.c();
        ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(((P9.n) it.next()).l());
        }
        this.f5000g = arrayList;
    }

    public final List<t> a() {
        return this.f4996c;
    }

    public final e b() {
        e eVar = this.f4995b;
        if (eVar != null) {
            return eVar;
        }
        kotlin.jvm.internal.p.A("classifier");
        return null;
    }

    public final List<P9.j> c() {
        return this.f5000g;
    }

    public final int d() {
        return this.f4994a;
    }

    public final void e(q qVar) {
        this.f4997d = qVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.p.d(q.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type kotlin.metadata.KmType");
        q qVar = (q) obj;
        return this.f4994a == qVar.f4994a && kotlin.jvm.internal.p.d(b(), qVar.b()) && kotlin.jvm.internal.p.d(this.f4996c, qVar.f4996c) && kotlin.jvm.internal.p.d(this.f4998e, qVar.f4998e) && kotlin.jvm.internal.p.d(this.f4997d, qVar.f4997d) && kotlin.jvm.internal.p.d(this.f4999f, qVar.f4999f) && kotlin.jvm.internal.p.d(this.f5000g, qVar.f5000g);
    }

    public final void f(e eVar) {
        kotlin.jvm.internal.p.i(eVar, "<set-?>");
        this.f4995b = eVar;
    }

    public final void g(int i10) {
        this.f4994a = i10;
    }

    public final void h(m mVar) {
        this.f4999f = mVar;
    }

    public int hashCode() {
        return (((this.f4994a * 31) + b().hashCode()) * 31) + this.f4996c.hashCode();
    }

    public final void i(q qVar) {
        this.f4998e = qVar;
    }

    public q() {
        this(0);
    }
}
