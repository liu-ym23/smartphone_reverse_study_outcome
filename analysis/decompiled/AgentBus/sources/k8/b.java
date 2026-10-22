package k8;

import ga.r;
import o4.d0;
import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f5651a;

    public /* synthetic */ b(ClassLoader classLoader) {
        this.f5651a = classLoader;
    }

    public d0 a(e9.b bVar, d9.f fVar) {
        c cVarM;
        k.e(bVar, "classId");
        k.e(fVar, "jvmMetadataVersion");
        String strD0 = r.d0(bVar.h().b(), '.', '$');
        if (!bVar.g().d()) {
            strD0 = bVar.g() + '.' + strD0;
        }
        Class clsN0 = s7.a.n0(this.f5651a, strD0);
        if (clsN0 == null || (cVarM = e0.m(clsN0)) == null) {
            return null;
        }
        return new d0(18, cVarM);
    }
}
