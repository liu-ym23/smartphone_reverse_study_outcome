package e8;

import w7.t;

/* loaded from: classes.dex */
public final class e implements ea.a {

    /* renamed from: f, reason: collision with root package name */
    public static final e f3137f = new e();

    public static f8.e a(f8.e eVar) {
        e9.e eVarG = h9.f.g(eVar);
        String str = d.f3123a;
        e9.c cVar = (e9.c) d.f3133k.get(eVarG);
        if (cVar != null) {
            return l9.d.e(eVar).i(cVar);
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a read-only collection");
    }

    public static f8.e c(e9.c cVar, c8.h hVar) {
        q7.k.e(hVar, "builtIns");
        String str = d.f3123a;
        e9.b bVar = (e9.b) d.f3130h.get(cVar.i());
        if (bVar != null) {
            return hVar.i(bVar.b());
        }
        return null;
    }

    @Override // ea.a
    public Iterable b(Object obj) {
        t[] tVarArr = o.f3165g;
        return ((f8.c) obj).a().r();
    }
}
