package r8;

import ca.AbstractC0897f;
import e8.n;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import n8.AbstractC1744c;
import q8.u;
import x8.InterfaceC2119b;

/* renamed from: r8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1881c {

    /* renamed from: a, reason: collision with root package name */
    public static final G8.f f5681a = G8.f.e("message");
    public static final G8.f b = G8.f.e("allowedTargets");
    public static final G8.f c = G8.f.e("value");
    public static final Object d = kotlin.collections.a.R(new Pair(n.f4421t, u.c), new Pair(n.f4423w, u.d), new Pair(n.f4424x, u.f));

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.Map] */
    public static s8.f a(G8.c kotlinName, InterfaceC2119b annotationOwner, K1.a c2) {
        n8.d dVarA;
        k.f(kotlinName, "kotlinName");
        k.f(annotationOwner, "annotationOwner");
        k.f(c2, "c");
        if (kotlinName.equals(n.m)) {
            G8.c DEPRECATED_ANNOTATION = u.e;
            k.e(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            n8.d dVarA2 = annotationOwner.a(DEPRECATED_ANNOTATION);
            if (dVarA2 != null) {
                return new g(dVarA2, c2);
            }
        }
        G8.c cVar = (G8.c) d.get(kotlinName);
        if (cVar == null || (dVarA = annotationOwner.a(cVar)) == null) {
            return null;
        }
        return b(c2, dVarA, false);
    }

    public static s8.f b(K1.a c2, n8.d annotation, boolean z10) {
        k.f(annotation, "annotation");
        k.f(c2, "c");
        G8.b bVarA = AbstractC1744c.a(M.a.Z(M.a.V(annotation.f5356a)));
        G8.c TARGET_ANNOTATION = u.c;
        k.e(TARGET_ANNOTATION, "TARGET_ANNOTATION");
        if (bVarA.equals(AbstractC0897f.N(TARGET_ANNOTATION))) {
            return new j(annotation, c2);
        }
        G8.c RETENTION_ANNOTATION = u.d;
        k.e(RETENTION_ANNOTATION, "RETENTION_ANNOTATION");
        if (bVarA.equals(AbstractC0897f.N(RETENTION_ANNOTATION))) {
            return new i(annotation, c2);
        }
        G8.c DOCUMENTED_ANNOTATION = u.f;
        k.e(DOCUMENTED_ANNOTATION, "DOCUMENTED_ANNOTATION");
        if (bVarA.equals(AbstractC0897f.N(DOCUMENTED_ANNOTATION))) {
            return new C1880b(c2, annotation, n.f4424x);
        }
        G8.c DEPRECATED_ANNOTATION = u.e;
        k.e(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
        if (bVarA.equals(AbstractC0897f.N(DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new u8.g(c2, annotation, z10);
    }
}
