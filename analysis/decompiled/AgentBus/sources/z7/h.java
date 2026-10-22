package z7;

import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public final class h extends s1 {

    /* renamed from: g, reason: collision with root package name */
    public final Constructor f11876g;

    public h(Constructor constructor) {
        q7.k.e(constructor, "constructor");
        this.f11876g = constructor;
    }

    @Override // z7.s1
    public final String f() {
        Class<?>[] parameterTypes = this.f11876g.getParameterTypes();
        q7.k.d(parameterTypes, "constructor.parameterTypes");
        return d7.n.o0(parameterTypes, "", "<init>(", ")V", b.f11841n, 24);
    }
}
