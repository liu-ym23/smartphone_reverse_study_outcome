package Q1;

import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: b, reason: collision with root package name */
    private static final c<?> f4903b = new c<>();

    /* renamed from: a, reason: collision with root package name */
    private final T f4904a;

    private c() {
        this.f4904a = null;
    }

    public static <T> c<T> a() {
        return (c<T>) f4903b;
    }

    public static <T> c<T> e(T t5) {
        return new c<>(t5);
    }

    public static <T> c<T> f(T t5) {
        return t5 == null ? a() : e(t5);
    }

    public T b() {
        T t5 = this.f4904a;
        if (t5 != null) {
            return t5;
        }
        throw new NoSuchElementException("No value present");
    }

    public void c(b<? super T> bVar) {
        T t5 = this.f4904a;
        if (t5 != null) {
            bVar.accept(t5);
        }
    }

    public boolean d() {
        return this.f4904a != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return Objects.equals(this.f4904a, ((c) obj).f4904a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f4904a);
    }

    public String toString() {
        T t5 = this.f4904a;
        return t5 != null ? String.format("Optional[%s]", t5) : "Optional.empty";
    }

    private c(T t5) {
        Objects.requireNonNull(t5);
        this.f4904a = t5;
    }
}
