package G1;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class w extends y {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f635b;

    public w(Method method) {
        this.f635b = method;
    }

    @Override // G1.y
    public final Object a(Class cls) {
        String strA = l1.g.a(cls);
        if (strA != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
        }
        return this.f635b.invoke(null, cls, Object.class);
    }
}
