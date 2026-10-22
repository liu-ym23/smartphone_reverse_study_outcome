package N9;

import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public int f4938a;

    /* renamed from: b, reason: collision with root package name */
    public final List<u> f4939b;

    /* renamed from: c, reason: collision with root package name */
    public final List<w> f4940c;

    /* renamed from: d, reason: collision with root package name */
    public final List<b> f4941d;

    /* renamed from: e, reason: collision with root package name */
    public final List<P9.c> f4942e;

    public g(int i10) {
        this.f4938a = i10;
        this.f4939b = new ArrayList();
        this.f4940c = new ArrayList(0);
        this.f4941d = new ArrayList(0);
        List<P9.n> listC = P9.n.f5383a.c();
        ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(((P9.n) it.next()).i());
        }
        this.f4942e = arrayList;
    }

    public final List<b> a() {
        return this.f4941d;
    }

    public final List<P9.c> b() {
        return this.f4942e;
    }

    public final int c() {
        return this.f4938a;
    }

    public final List<u> d() {
        return this.f4939b;
    }

    public final List<w> e() {
        return this.f4940c;
    }

    public final void f(int i10) {
        this.f4938a = i10;
    }

    public g() {
        this(0);
    }
}
