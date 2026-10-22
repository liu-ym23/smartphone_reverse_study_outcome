package z7;

import java.lang.ref.SoftReference;

/* loaded from: classes.dex */
public final class q1 extends s1 implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final p7.a f11941g;

    /* renamed from: h, reason: collision with root package name */
    public volatile SoftReference f11942h;

    public q1(Object obj, p7.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'initializer' of kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal.<init> must not be null");
        }
        this.f11942h = null;
        this.f11941g = aVar;
        if (obj != null) {
            this.f11942h = new SoftReference(obj);
        }
    }

    @Override // p7.a
    public final Object c() {
        Object obj;
        Object obj2 = s1.f11954f;
        SoftReference softReference = this.f11942h;
        if (softReference != null && (obj = softReference.get()) != null) {
            if (obj == obj2) {
                return null;
            }
            return obj;
        }
        Object objC = this.f11941g.c();
        if (objC != null) {
            obj2 = objC;
        }
        this.f11942h = new SoftReference(obj2);
        return objC;
    }
}
