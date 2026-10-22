package G1;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class v extends y {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f633b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f634c;

    public v(Method method, int i4) {
        this.f633b = method;
        this.f634c = i4;
    }

    @Override // G1.y
    public final Object a(Class cls) {
        String strA = l1.g.a(cls);
        if (strA != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
        }
        return this.f633b.invoke(null, cls, Integer.valueOf(this.f634c));
    }
}
