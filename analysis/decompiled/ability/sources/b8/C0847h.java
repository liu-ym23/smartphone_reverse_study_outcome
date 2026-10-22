package b8;

import java.lang.reflect.Constructor;

/* renamed from: b8.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0847h extends M.a {
    public final Constructor f;

    public C0847h(Constructor constructor) {
        kotlin.jvm.internal.k.f(constructor, "constructor");
        this.f = constructor;
    }

    @Override // M.a
    public final String z() {
        Class<?>[] parameterTypes = this.f.getParameterTypes();
        kotlin.jvm.internal.k.e(parameterTypes, "getParameterTypes(...)");
        return D7.q.x0(parameterTypes, "", "<init>(", ")V", C0841b.e, 24);
    }
}
