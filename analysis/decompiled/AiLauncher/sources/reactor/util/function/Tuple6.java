package reactor.util.function;

import java.util.Objects;
import java.util.function.Function;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public class Tuple6<T1, T2, T3, T4, T5, T6> extends Tuple5<T1, T2, T3, T4, T5> {
    private static final long serialVersionUID = 770306356087176830L;

    /* renamed from: t6, reason: collision with root package name */
    @NonNull
    final T6 f39855t6;

    public Tuple6(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62) {
        super(t12, t22, t32, t42, t52);
        Objects.requireNonNull(t62, "t6");
        this.f39855t6 = t62;
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Tuple6) && super.equals(obj)) {
            return this.f39855t6.equals(((Tuple6) obj).f39855t6);
        }
        return false;
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
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
        if (i10 == 3) {
            return this.f39853t4;
        }
        if (i10 == 4) {
            return this.f39854t5;
        }
        if (i10 != 5) {
            return null;
        }
        return this.f39855t6;
    }

    public T6 getT6() {
        return this.f39855t6;
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int hashCode() {
        return (super.hashCode() * 31) + this.f39855t6.hashCode();
    }

    public <R> Tuple6<T1, T2, T3, T4, T5, R> mapT6(Function<T6, R> function) {
        return new Tuple6<>(this.f39850t1, this.f39851t2, this.f39852t3, this.f39853t4, this.f39854t5, function.apply(this.f39855t6));
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int size() {
        return 6;
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public Object[] toArray() {
        return new Object[]{this.f39850t1, this.f39851t2, this.f39852t3, this.f39853t4, this.f39854t5, this.f39855t6};
    }

    @Override // reactor.util.function.Tuple5
    public <R> Tuple6<T1, T2, T3, T4, R, T6> mapT5(Function<T5, R> function) {
        return new Tuple6<>(this.f39850t1, this.f39851t2, this.f39852t3, this.f39853t4, function.apply(this.f39854t5), this.f39855t6);
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4
    public <R> Tuple6<T1, T2, T3, R, T5, T6> mapT4(Function<T4, R> function) {
        return new Tuple6<>(this.f39850t1, this.f39851t2, this.f39852t3, function.apply(this.f39853t4), this.f39854t5, this.f39855t6);
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3
    public <R> Tuple6<T1, T2, R, T4, T5, T6> mapT3(Function<T3, R> function) {
        return new Tuple6<>(this.f39850t1, this.f39851t2, function.apply(this.f39852t3), this.f39853t4, this.f39854t5, this.f39855t6);
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple6<R, T2, T3, T4, T5, T6> mapT1(Function<T1, R> function) {
        return new Tuple6<>(function.apply(this.f39850t1), this.f39851t2, this.f39852t3, this.f39853t4, this.f39854t5, this.f39855t6);
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple6<T1, R, T3, T4, T5, T6> mapT2(Function<T2, R> function) {
        return new Tuple6<>(this.f39850t1, function.apply(this.f39851t2), this.f39852t3, this.f39853t4, this.f39854t5, this.f39855t6);
    }
}
