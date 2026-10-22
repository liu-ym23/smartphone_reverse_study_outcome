package L;

/* loaded from: classes.dex */
final class c<T> extends n<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f3671a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3672b;

    public c(T t5, int i5) {
        super(null);
        this.f3671a = t5;
        this.f3672b = i5;
    }

    public final void a() {
        T t5 = this.f3671a;
        if (!((t5 != null ? t5.hashCode() : 0) == this.f3672b)) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }

    public final T b() {
        return this.f3671a;
    }
}
