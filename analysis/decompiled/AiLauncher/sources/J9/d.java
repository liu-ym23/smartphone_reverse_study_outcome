package J9;

import K9.A;
import La.D;
import S9.r;
import Z9.u;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: classes5.dex */
public final class d implements r {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f3792a;

    public d(ClassLoader classLoader) {
        p.i(classLoader, "classLoader");
        this.f3792a = classLoader;
    }

    @Override // S9.r
    public u a(ga.c fqName, boolean z10) {
        p.i(fqName, "fqName");
        return new A(fqName);
    }

    @Override // S9.r
    public Set<String> b(ga.c packageFqName) {
        p.i(packageFqName, "packageFqName");
        return null;
    }

    @Override // S9.r
    public Z9.g c(r.a request) {
        p.i(request, "request");
        ga.b bVarA = request.a();
        ga.c cVarF = bVarA.f();
        String strS = D.S(bVarA.g().a(), '.', '$', false, 4, null);
        if (!cVarF.c()) {
            strS = cVarF.a() + '.' + strS;
        }
        Class<?> clsA = e.a(this.f3792a, strS);
        if (clsA != null) {
            return new ReflectJavaClass(clsA);
        }
        return null;
    }
}
