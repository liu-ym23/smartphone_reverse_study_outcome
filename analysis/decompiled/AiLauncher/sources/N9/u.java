package N9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public int f5019a;

    /* renamed from: b, reason: collision with root package name */
    public String f5020b;

    /* renamed from: c, reason: collision with root package name */
    public q f5021c;

    /* renamed from: d, reason: collision with root package name */
    public q f5022d;

    /* renamed from: e, reason: collision with root package name */
    public c f5023e;

    /* renamed from: f, reason: collision with root package name */
    public final List<b> f5024f;

    /* renamed from: g, reason: collision with root package name */
    public final List<P9.l> f5025g;

    public u(int i10, String name) {
        kotlin.jvm.internal.p.i(name, "name");
        this.f5019a = i10;
        this.f5020b = name;
        this.f5024f = new ArrayList(0);
        List<P9.n> listC = P9.n.f5383a.c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            ((P9.n) it.next()).r();
        }
        this.f5025g = arrayList;
    }

    public final List<b> a() {
        return this.f5024f;
    }

    public final int b() {
        return this.f5019a;
    }

    public final void c(c cVar) {
        this.f5023e = cVar;
    }

    public final void d(int i10) {
        this.f5019a = i10;
    }

    public final void e(q qVar) {
        kotlin.jvm.internal.p.i(qVar, "<set-?>");
        this.f5021c = qVar;
    }

    public final void f(q qVar) {
        this.f5022d = qVar;
    }
}
