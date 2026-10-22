package N9;

import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;

/* loaded from: classes5.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public int f5009a;

    /* renamed from: b, reason: collision with root package name */
    public String f5010b;

    /* renamed from: c, reason: collision with root package name */
    public int f5011c;

    /* renamed from: d, reason: collision with root package name */
    public KmVariance f5012d;

    /* renamed from: e, reason: collision with root package name */
    public final List<q> f5013e;

    /* renamed from: f, reason: collision with root package name */
    public final List<P9.k> f5014f;

    public s(int i10, String name, int i11, KmVariance variance) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(variance, "variance");
        this.f5009a = i10;
        this.f5010b = name;
        this.f5011c = i11;
        this.f5012d = variance;
        this.f5013e = new ArrayList(1);
        List<P9.n> listC = P9.n.f5383a.c();
        ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(((P9.n) it.next()).q());
        }
        this.f5014f = arrayList;
    }

    public final List<P9.k> a() {
        return this.f5014f;
    }

    public final int b() {
        return this.f5009a;
    }

    public final List<q> c() {
        return this.f5013e;
    }

    public final void d(int i10) {
        this.f5009a = i10;
    }
}
