package f5;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends m {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f8754b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8755c;

    public i(Method method, Object obj) {
        this.f8754b = method;
        this.f8755c = obj;
    }

    @Override // f5.m
    public final <T> T a(Class<T> cls) {
        String strA = a.a(cls);
        if (strA != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
        }
        return (T) this.f8754b.invoke(this.f8755c, cls);
    }
}
