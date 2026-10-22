package i8;

/* loaded from: classes4.dex */
public final class f<T> implements d<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f33074c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile d<T> f33075a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f33076b = f33074c;

    public f(d<T> dVar) {
        this.f33075a = dVar;
    }

    public static <T> d<T> a(d<T> dVar) {
        return ((dVar instanceof f) || (dVar instanceof b)) ? dVar : new f((d) c.b(dVar));
    }

    @Override // X8.a
    public T get() {
        T t10 = (T) this.f33076b;
        if (t10 != f33074c) {
            return t10;
        }
        d<T> dVar = this.f33075a;
        if (dVar == null) {
            return (T) this.f33076b;
        }
        T t11 = dVar.get();
        this.f33076b = t11;
        this.f33075a = null;
        return t11;
    }
}
