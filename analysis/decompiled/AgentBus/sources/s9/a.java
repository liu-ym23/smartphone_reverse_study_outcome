package s9;

import f9.h;
import f9.n;
import ga.r;
import q7.k;

/* loaded from: classes.dex */
public final class a extends q9.a {

    /* renamed from: m, reason: collision with root package name */
    public static final a f9622m;

    static {
        h hVar = new h();
        a9.b.a(hVar);
        n nVar = a9.b.f468a;
        k.d(nVar, "packageFqName");
        n nVar2 = a9.b.f470c;
        k.d(nVar2, "constructorAnnotation");
        n nVar3 = a9.b.f469b;
        k.d(nVar3, "classAnnotation");
        n nVar4 = a9.b.f471d;
        k.d(nVar4, "functionAnnotation");
        n nVar5 = a9.b.f472e;
        k.d(nVar5, "propertyAnnotation");
        n nVar6 = a9.b.f473f;
        k.d(nVar6, "propertyGetterAnnotation");
        n nVar7 = a9.b.f474g;
        k.d(nVar7, "propertySetterAnnotation");
        n nVar8 = a9.b.f476i;
        k.d(nVar8, "enumEntryAnnotation");
        n nVar9 = a9.b.f475h;
        k.d(nVar9, "compileTimeValue");
        n nVar10 = a9.b.f477j;
        k.d(nVar10, "parameterAnnotation");
        n nVar11 = a9.b.f478k;
        k.d(nVar11, "typeAnnotation");
        n nVar12 = a9.b.f479l;
        k.d(nVar12, "typeParameterAnnotation");
        f9622m = new a(hVar, nVar, nVar2, nVar3, nVar4, nVar5, nVar6, nVar7, nVar8, nVar9, nVar10, nVar11, nVar12);
    }

    public static String a(e9.c cVar) {
        String strB;
        k.e(cVar, "fqName");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(r.d0(cVar.b(), '.', '/'));
        sb2.append('/');
        if (cVar.d()) {
            strB = "default-package";
        } else {
            strB = cVar.f().b();
            k.d(strB, "fqName.shortName().asString()");
        }
        sb2.append(strB.concat(".kotlin_builtins"));
        return sb2.toString();
    }
}
