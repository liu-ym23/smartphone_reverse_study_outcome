package G1;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class u extends y {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f631b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f632c;

    public u(Method method, Object obj) {
        this.f631b = method;
        this.f632c = obj;
    }

    @Override // G1.y
    public final Object a(Class cls) {
        String strA = l1.g.a(cls);
        if (strA != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
        }
        return this.f631b.invoke(this.f632c, cls);
    }
}
