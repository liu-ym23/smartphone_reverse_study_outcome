package i8;

/* loaded from: classes4.dex */
public final class b<T> implements d<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f33070c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile d<T> f33071a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f33072b = f33070c;

    public b(d<T> dVar) {
        this.f33071a = dVar;
    }

    public static <T> d<T> b(d<T> dVar) {
        c.b(dVar);
        return dVar instanceof b ? dVar : new b(dVar);
    }

    private static Object c(Object obj, Object obj2) {
        if (obj == f33070c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public final synchronized Object a() {
        Object obj;
        obj = this.f33072b;
        if (obj == f33070c) {
            obj = this.f33071a.get();
            this.f33072b = c(this.f33072b, obj);
            this.f33071a = null;
        }
        return obj;
    }

    @Override // X8.a
    public T get() {
        T t10 = (T) this.f33072b;
        return t10 == f33070c ? (T) a() : t10;
    }
}
