package R4;

import C4.F;
import C4.G;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class t<T> {

    /* renamed from: a, reason: collision with root package name */
    private final F f5163a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final T f5164b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final G f5165c;

    private t(F f5, @Nullable T t5, @Nullable G g5) {
        this.f5163a = f5;
        this.f5164b = t5;
        this.f5165c = g5;
    }

    public static <T> t<T> c(G g5, F f5) {
        Objects.requireNonNull(g5, "body == null");
        Objects.requireNonNull(f5, "rawResponse == null");
        if (f5.w()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new t<>(f5, null, g5);
    }

    public static <T> t<T> g(@Nullable T t5, F f5) {
        Objects.requireNonNull(f5, "rawResponse == null");
        if (f5.w()) {
            return new t<>(f5, t5, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    @Nullable
    public T a() {
        return this.f5164b;
    }

    public int b() {
        return this.f5163a.m();
    }

    @Nullable
    public G d() {
        return this.f5165c;
    }

    public boolean e() {
        return this.f5163a.w();
    }

    public String f() {
        return this.f5163a.x();
    }

    public String toString() {
        return this.f5163a.toString();
    }
}
