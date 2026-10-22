package J9;

import C9.o;
import ba.p;
import ea.C4019c;
import java.io.InputStream;
import va.C5686a;
import va.C5687b;

/* loaded from: classes5.dex */
public final class g implements p {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f3796a;

    /* renamed from: b, reason: collision with root package name */
    public final C5687b f3797b;

    public g(ClassLoader classLoader) {
        kotlin.jvm.internal.p.i(classLoader, "classLoader");
        this.f3796a = classLoader;
        this.f3797b = new C5687b();
    }

    @Override // ba.p
    public p.a a(ga.b classId, C4019c metadataVersion) {
        kotlin.jvm.internal.p.i(classId, "classId");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        return d(h.b(classId));
    }

    @Override // ua.InterfaceC5640z
    public InputStream b(ga.c packageFqName) {
        kotlin.jvm.internal.p.i(packageFqName, "packageFqName");
        if (packageFqName.h(o.f1809A)) {
            return this.f3797b.a(C5686a.f42871r.r(packageFqName));
        }
        return null;
    }

    @Override // ba.p
    public p.a c(Z9.g javaClass, C4019c metadataVersion) {
        String strA;
        kotlin.jvm.internal.p.i(javaClass, "javaClass");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        ga.c cVarF = javaClass.f();
        if (cVarF == null || (strA = cVarF.a()) == null) {
            return null;
        }
        return d(strA);
    }

    public final p.a d(String str) {
        f fVarA;
        Class<?> clsA = e.a(this.f3796a, str);
        if (clsA == null || (fVarA = f.f3793c.a(clsA)) == null) {
            return null;
        }
        return new p.a.b(fVarA, null, 2, null);
    }
}
