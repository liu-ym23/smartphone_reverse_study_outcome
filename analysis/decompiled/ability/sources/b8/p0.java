package b8;

import java.lang.ref.SoftReference;

/* loaded from: classes4.dex */
public final class p0 implements S7.a {
    public static final q0 c = new q0();

    /* renamed from: a, reason: collision with root package name */
    public final S7.a f2050a;
    public volatile SoftReference b;

    public p0(Object obj, S7.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'initializer' of kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal.<init> must not be null");
        }
        this.b = null;
        this.f2050a = aVar;
        if (obj != null) {
            this.b = new SoftReference(obj);
        }
    }

    @Override // S7.a
    public final Object invoke() {
        Object obj;
        Object obj2 = c;
        SoftReference softReference = this.b;
        if (softReference != null && (obj = softReference.get()) != null) {
            if (obj == obj2) {
                return null;
            }
            return obj;
        }
        Object objInvoke = this.f2050a.invoke();
        if (objInvoke != null) {
            obj2 = objInvoke;
        }
        this.b = new SoftReference(obj2);
        return objInvoke;
    }
}
