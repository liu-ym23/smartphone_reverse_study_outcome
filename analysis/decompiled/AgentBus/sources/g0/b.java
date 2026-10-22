package g0;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: i, reason: collision with root package name */
    public final ea.g f3670i;

    /* renamed from: j, reason: collision with root package name */
    public Object f3671j;

    public b(ea.g gVar, Object obj, Object obj2) {
        super(0, obj, obj2);
        this.f3670i = gVar;
        this.f3671j = obj2;
    }

    @Override // g0.a, java.util.Map.Entry
    public final Object getValue() {
        return this.f3671j;
    }

    @Override // g0.a, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f3671j;
        this.f3671j = obj;
        e eVar = (e) this.f3670i.f3236g;
        j0.g gVar = eVar.f3678i;
        Object obj3 = this.f3668g;
        if (!gVar.containsKey(obj3)) {
            return obj2;
        }
        boolean z4 = eVar.f3677h;
        if (!z4) {
            gVar.put(obj3, obj);
        } else {
            if (!z4) {
                throw new NoSuchElementException();
            }
            l lVar = eVar.f3675f[eVar.f3676g];
            Object obj4 = lVar.f3692f[lVar.f3694h];
            gVar.put(obj3, obj);
            eVar.d(obj4 != null ? obj4.hashCode() : 0, gVar.f5078g, obj4, 0);
        }
        eVar.f3681l = gVar.f5080i;
        return obj2;
    }
}
