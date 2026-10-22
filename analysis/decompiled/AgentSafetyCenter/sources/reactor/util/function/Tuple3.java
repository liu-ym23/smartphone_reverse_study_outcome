package reactor.util.function;

import java.util.Objects;
import java.util.function.Function;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class Tuple3<T1, T2, T3> extends Tuple2<T1, T2> {
    private static final long serialVersionUID = -4430274211524723033L;

    /* renamed from: t3, reason: collision with root package name */
    @NonNull
    final T3 f10913t3;

    public Tuple3(T1 t12, T2 t22, T3 t32) {
        super(t12, t22);
        Objects.requireNonNull(t32, "t3");
        this.f10913t3 = t32;
    }

    @Override // reactor.util.function.Tuple2
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Tuple3) && super.equals(obj)) {
            return this.f10913t3.equals(((Tuple3) obj).f10913t3);
        }
        return false;
    }

    @Override // reactor.util.function.Tuple2
    @Nullable
    public Object get(int i) {
        if (i == 0) {
            return this.f10911t1;
        }
        if (i == 1) {
            return this.f10912t2;
        }
        if (i != 2) {
            return null;
        }
        return this.f10913t3;
    }

    public T3 getT3() {
        return this.f10913t3;
    }

    @Override // reactor.util.function.Tuple2
    public int hashCode() {
        return this.f10913t3.hashCode() + (super.hashCode() * 31);
    }

    @Override // reactor.util.function.Tuple2
    public <R> Tuple3<R, T2, T3> mapT1(Function<T1, R> function) {
        return new Tuple3<>(function.apply(this.f10911t1), this.f10912t2, this.f10913t3);
    }

    @Override // reactor.util.function.Tuple2
    public <R> Tuple3<T1, R, T3> mapT2(Function<T2, R> function) {
        return new Tuple3<>(this.f10911t1, function.apply(this.f10912t2), this.f10913t3);
    }

    public <R> Tuple3<T1, T2, R> mapT3(Function<T3, R> function) {
        return new Tuple3<>(this.f10911t1, this.f10912t2, function.apply(this.f10913t3));
    }

    @Override // reactor.util.function.Tuple2
    public int size() {
        return 3;
    }

    @Override // reactor.util.function.Tuple2
    public Object[] toArray() {
        return new Object[]{this.f10911t1, this.f10912t2, this.f10913t3};
    }
}
