package reactor.util.function;

import java.util.Objects;
import java.util.function.Function;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public class Tuple4<T1, T2, T3, T4> extends Tuple3<T1, T2, T3> {
    private static final long serialVersionUID = -4898704078143033129L;

    /* renamed from: t4, reason: collision with root package name */
    @NonNull
    final T4 f39853t4;

    public Tuple4(T1 t12, T2 t22, T3 t32, T4 t42) {
        super(t12, t22, t32);
        Objects.requireNonNull(t42, "t4");
        this.f39853t4 = t42;
    }

    @Override // reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Tuple4) && super.equals(obj)) {
            return this.f39853t4.equals(((Tuple4) obj).f39853t4);
        }
        return false;
    }

    @Override // reactor.util.function.Tuple3, reactor.util.function.Tuple2
    @Nullable
    public Object get(int i10) {
        if (i10 == 0) {
            return this.f39850t1;
        }
        if (i10 == 1) {
            return this.f39851t2;
        }
        if (i10 == 2) {
            return this.f39852t3;
        }
        if (i10 != 3) {
            return null;
        }
        return this.f39853t4;
    }

    public T4 getT4() {
        return this.f39853t4;
    }

    @Override // reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int hashCode() {
        return (super.hashCode() * 31) + this.f39853t4.hashCode();
    }

    public <R> Tuple4<T1, T2, T3, R> mapT4(Function<T4, R> function) {
        return new Tuple4<>(this.f39850t1, this.f39851t2, this.f39852t3, function.apply(this.f39853t4));
    }

    @Override // reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int size() {
        return 4;
    }

    @Override // reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public Object[] toArray() {
        return new Object[]{this.f39850t1, this.f39851t2, this.f39852t3, this.f39853t4};
    }

    @Override // reactor.util.function.Tuple3
    public <R> Tuple4<T1, T2, R, T4> mapT3(Function<T3, R> function) {
        return new Tuple4<>(this.f39850t1, this.f39851t2, function.apply(this.f39852t3), this.f39853t4);
    }

    @Override // reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple4<R, T2, T3, T4> mapT1(Function<T1, R> function) {
        return new Tuple4<>(function.apply(this.f39850t1), this.f39851t2, this.f39852t3, this.f39853t4);
    }

    @Override // reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple4<T1, R, T3, T4> mapT2(Function<T2, R> function) {
        return new Tuple4<>(this.f39850t1, function.apply(this.f39851t2), this.f39852t3, this.f39853t4);
    }
}
