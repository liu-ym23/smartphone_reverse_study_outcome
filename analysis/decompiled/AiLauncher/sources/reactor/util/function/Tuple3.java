package reactor.util.function;

import java.util.Objects;
import java.util.function.Function;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public class Tuple3<T1, T2, T3> extends Tuple2<T1, T2> {
    private static final long serialVersionUID = -4430274211524723033L;

    /* renamed from: t3, reason: collision with root package name */
    @NonNull
    final T3 f39852t3;

    public Tuple3(T1 t12, T2 t22, T3 t32) {
        super(t12, t22);
        Objects.requireNonNull(t32, "t3");
        this.f39852t3 = t32;
    }

    @Override // reactor.util.function.Tuple2
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Tuple3) && super.equals(obj)) {
            return this.f39852t3.equals(((Tuple3) obj).f39852t3);
        }
        return false;
    }

    @Override // reactor.util.function.Tuple2
    @Nullable
    public Object get(int i10) {
        if (i10 == 0) {
            return this.f39850t1;
        }
        if (i10 == 1) {
            return this.f39851t2;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f39852t3;
    }

    public T3 getT3() {
        return this.f39852t3;
    }

    @Override // reactor.util.function.Tuple2
    public int hashCode() {
        return (super.hashCode() * 31) + this.f39852t3.hashCode();
    }

    public <R> Tuple3<T1, T2, R> mapT3(Function<T3, R> function) {
        return new Tuple3<>(this.f39850t1, this.f39851t2, function.apply(this.f39852t3));
    }

    @Override // reactor.util.function.Tuple2
    public int size() {
        return 3;
    }

    @Override // reactor.util.function.Tuple2
    public Object[] toArray() {
        return new Object[]{this.f39850t1, this.f39851t2, this.f39852t3};
    }

    @Override // reactor.util.function.Tuple2
    public <R> Tuple3<R, T2, T3> mapT1(Function<T1, R> function) {
        return new Tuple3<>(function.apply(this.f39850t1), this.f39851t2, this.f39852t3);
    }

    @Override // reactor.util.function.Tuple2
    public <R> Tuple3<T1, R, T3> mapT2(Function<T2, R> function) {
        return new Tuple3<>(this.f39850t1, function.apply(this.f39851t2), this.f39852t3);
    }
}
