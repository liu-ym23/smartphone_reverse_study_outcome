package g2;

/* loaded from: classes2.dex */
public final class c<T> implements b<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final c<Object> f32701b = new c<>(null);

    /* renamed from: a, reason: collision with root package name */
    public final T f32702a;

    public c(T t10) {
        this.f32702a = t10;
    }

    public static <T> b<T> a(T t10) {
        return new c(d.c(t10, "instance cannot be null"));
    }

    @Override // X8.a
    public T get() {
        return this.f32702a;
    }
}
