package N9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public String f4954a;

    /* renamed from: b, reason: collision with root package name */
    public final List<b> f4955b;

    /* renamed from: c, reason: collision with root package name */
    public final List<P9.d> f4956c;

    public l(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        this.f4954a = name;
        this.f4955b = new ArrayList(0);
        List<P9.n> listC = P9.n.f5383a.c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            ((P9.n) it.next()).b();
        }
        this.f4956c = arrayList;
    }

    public final List<b> a() {
        return this.f4955b;
    }

    public String toString() {
        return this.f4954a;
    }
}
