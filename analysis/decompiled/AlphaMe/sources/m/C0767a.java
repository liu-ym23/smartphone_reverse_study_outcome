package m;

import java.util.HashMap;

/* renamed from: m.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0767a extends g {

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f13507e = new HashMap();

    @Override // m.g
    public final c a(Object obj) {
        return (c) this.f13507e.get(obj);
    }

    @Override // m.g
    public final Object c(Object obj) {
        Object objC = super.c(obj);
        this.f13507e.remove(obj);
        return objC;
    }

    public final Object d(Object obj, Object obj2) {
        c cVarA = a(obj);
        if (cVarA != null) {
            return cVarA.f13510b;
        }
        HashMap map = this.f13507e;
        c cVar = new c(obj, obj2);
        this.f13521d++;
        c cVar2 = this.f13519b;
        if (cVar2 == null) {
            this.f13518a = cVar;
            this.f13519b = cVar;
        } else {
            cVar2.f13511c = cVar;
            cVar.f13512d = cVar2;
            this.f13519b = cVar;
        }
        map.put(obj, cVar);
        return null;
    }
}
