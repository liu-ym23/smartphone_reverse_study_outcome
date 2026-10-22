package f5;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j extends m {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f8756b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8757c;

    public j(int i10, Method method) {
        this.f8756b = method;
        this.f8757c = i10;
    }

    @Override // f5.m
    public final <T> T a(Class<T> cls) {
        String strA = a.a(cls);
        if (strA != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
        }
        return (T) this.f8756b.invoke(null, cls, Integer.valueOf(this.f8757c));
    }
}
