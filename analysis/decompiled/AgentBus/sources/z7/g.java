package z7;

import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends s1 {

    /* renamed from: g, reason: collision with root package name */
    public final List f11865g;

    public g(Class cls) throws SecurityException {
        q7.k.e(cls, "jClass");
        Method[] declaredMethods = cls.getDeclaredMethods();
        q7.k.d(declaredMethods, "jClass.declaredMethods");
        this.f11865g = d7.n.u0(declaredMethods, new m4.i0(4));
    }

    @Override // z7.s1
    public final String f() {
        return d7.r.U0(this.f11865g, "", "<init>(", ")V", b.f11840m, 24);
    }
}
