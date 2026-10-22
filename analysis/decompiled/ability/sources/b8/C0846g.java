package b8;

import java.lang.reflect.Method;
import java.util.List;

/* renamed from: b8.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0846g extends M.a {
    public final List f;

    public C0846g(Class jClass) throws SecurityException {
        kotlin.jvm.internal.k.f(jClass, "jClass");
        Method[] declaredMethods = jClass.getDeclaredMethods();
        kotlin.jvm.internal.k.e(declaredMethods, "getDeclaredMethods(...)");
        this.f = D7.q.D0(declaredMethods, new C0845f(0));
    }

    @Override // M.a
    public final String z() {
        return D7.v.I0(this.f, "", "<init>(", ")V", C0841b.d, 24);
    }
}
