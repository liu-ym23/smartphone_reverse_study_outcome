package g0;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class j extends d7.a {

    /* renamed from: f, reason: collision with root package name */
    public final c f3686f;

    public j(c cVar) {
        this.f3686f = cVar;
    }

    @Override // d7.a
    public final int a() {
        c cVar = this.f3686f;
        cVar.getClass();
        return cVar.f3674g;
    }

    @Override // d7.a, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f3686f.containsValue(obj);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        k kVar = this.f3686f.f3673f;
        l[] lVarArr = new l[8];
        for (int i2 = 0; i2 < 8; i2++) {
            lVarArr[i2] = new m(2);
        }
        return new i(kVar, lVarArr);
    }
}
