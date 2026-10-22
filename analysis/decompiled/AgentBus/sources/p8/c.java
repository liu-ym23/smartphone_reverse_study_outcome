package p8;

import c8.m;
import com.stepos.account.oauth.OAuthConstants;
import d7.e0;
import o8.x;
import q7.k;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final e9.f f8508a = e9.f.e(OAuthConstants.FACTOR_RESULT_MESSAGE);

    /* renamed from: b, reason: collision with root package name */
    public static final e9.f f8509b = e9.f.e("allowedTargets");

    /* renamed from: c, reason: collision with root package name */
    public static final e9.f f8510c = e9.f.e("value");

    /* renamed from: d, reason: collision with root package name */
    public static final Object f8511d = e0.U(new c7.j(m.f2049t, x.f7860c), new c7.j(m.f2052w, x.f7861d), new c7.j(m.f2053x, x.f7863f));

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.Map] */
    public static q8.g a(e9.c cVar, v8.b bVar, a3.b bVar2) {
        l8.e eVarA;
        k.e(cVar, "kotlinName");
        k.e(bVar, "annotationOwner");
        k.e(bVar2, "c");
        if (cVar.equals(m.f2042m)) {
            e9.c cVar2 = x.f7862e;
            k.d(cVar2, "DEPRECATED_ANNOTATION");
            l8.e eVarA2 = bVar.a(cVar2);
            if (eVarA2 != null) {
                return new g(eVarA2, bVar2);
            }
        }
        e9.c cVar3 = (e9.c) f8511d.get(cVar);
        if (cVar3 == null || (eVarA = bVar.a(cVar3)) == null) {
            return null;
        }
        return b(bVar2, eVarA, false);
    }

    public static q8.g b(a3.b bVar, l8.e eVar, boolean z4) {
        k.e(eVar, "annotation");
        k.e(bVar, "c");
        e9.b bVarA = l8.d.a(nb.i.t(nb.i.p(eVar.f5865a)));
        if (bVarA.equals(e9.b.j(x.f7860c))) {
            return new j(eVar, bVar);
        }
        if (bVarA.equals(e9.b.j(x.f7861d))) {
            return new i(eVar, bVar);
        }
        if (bVarA.equals(e9.b.j(x.f7863f))) {
            return new b(bVar, eVar, m.f2053x);
        }
        if (bVarA.equals(e9.b.j(x.f7862e))) {
            return null;
        }
        return new s8.f(bVar, eVar, z4);
    }
}
