package g2;

/* renamed from: g2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4094a<T> implements X8.a<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f32698c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile X8.a<T> f32699a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f32700b = f32698c;

    public C4094a(X8.a<T> aVar) {
        this.f32699a = aVar;
    }

    public static <P extends X8.a<T>, T> X8.a<T> a(P p10) {
        d.b(p10);
        return p10 instanceof C4094a ? p10 : new C4094a(p10);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f32698c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // X8.a
    public T get() {
        T t10;
        T t11 = (T) this.f32700b;
        Object obj = f32698c;
        if (t11 != obj) {
            return t11;
        }
        synchronized (this) {
            try {
                t10 = (T) this.f32700b;
                if (t10 == obj) {
                    t10 = this.f32699a.get();
                    this.f32700b = b(this.f32700b, t10);
                    this.f32699a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t10;
    }
}
