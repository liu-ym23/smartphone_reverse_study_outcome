package reactor.util.function;

import java.util.Objects;
import java.util.function.Function;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public class Tuple7<T1, T2, T3, T4, T5, T6, T7> extends Tuple6<T1, T2, T3, T4, T5, T6> {
    private static final long serialVersionUID = -8002391247456579281L;

    /* renamed from: t7, reason: collision with root package name */
    @NonNull
    final T7 f39856t7;

    public Tuple7(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72) {
        super(t12, t22, t32, t42, t52, t62);
        Objects.requireNonNull(t72, "t7");
        this.f39856t7 = t72;
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Tuple7) && super.equals(obj)) {
            return this.f39856t7.equals(((Tuple7) obj).f39856t7);
        }
        return false;
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    @Nullable
    public Object get(int i10) {
        switch (i10) {
            case 0:
                return this.f39850t1;
            case 1:
                return this.f39851t2;
            case 2:
                return this.f39852t3;
            case 3:
                return this.f39853t4;
            case 4:
                return this.f39854t5;
            case 5:
                return this.f39855t6;
            case 6:
                return this.f39856t7;
            default:
                return null;
        }
    }

    public T7 getT7() {
        return this.f39856t7;
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int hashCode() {
        return (super.hashCode() * 31) + this.f39856t7.hashCode();
    }

    public <R> Tuple7<T1, T2, T3, T4, T5, T6, R> mapT7(Function<T7, R> function) {
        return new Tuple7<>(this.f39850t1, this.f39851t2, this.f39852t3, this.f39853t4, this.f39854t5, this.f39855t6, function.apply(this.f39856t7));
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int size() {
        return 7;
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public Object[] toArray() {
        return new Object[]{this.f39850t1, this.f39851t2, this.f39852t3, this.f39853t4, this.f39854t5, this.f39855t6, this.f39856t7};
    }

    @Override // reactor.util.function.Tuple6
    public <R> Tuple7<T1, T2, T3, T4, T5, R, T7> mapT6(Function<T6, R> function) {
        return new Tuple7<>(this.f39850t1, this.f39851t2, this.f39852t3, this.f39853t4, this.f39854t5, function.apply(this.f39855t6), this.f39856t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5
    public <R> Tuple7<T1, T2, T3, T4, R, T6, T7> mapT5(Function<T5, R> function) {
        return new Tuple7<>(this.f39850t1, this.f39851t2, this.f39852t3, this.f39853t4, function.apply(this.f39854t5), this.f39855t6, this.f39856t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4
    public <R> Tuple7<T1, T2, T3, R, T5, T6, T7> mapT4(Function<T4, R> function) {
        return new Tuple7<>(this.f39850t1, this.f39851t2, this.f39852t3, function.apply(this.f39853t4), this.f39854t5, this.f39855t6, this.f39856t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3
    public <R> Tuple7<T1, T2, R, T4, T5, T6, T7> mapT3(Function<T3, R> function) {
        return new Tuple7<>(this.f39850t1, this.f39851t2, function.apply(this.f39852t3), this.f39853t4, this.f39854t5, this.f39855t6, this.f39856t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple7<R, T2, T3, T4, T5, T6, T7> mapT1(Function<T1, R> function) {
        return new Tuple7<>(function.apply(this.f39850t1), this.f39851t2, this.f39852t3, this.f39853t4, this.f39854t5, this.f39855t6, this.f39856t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple7<T1, R, T3, T4, T5, T6, T7> mapT2(Function<T2, R> function) {
        return new Tuple7<>(this.f39850t1, function.apply(this.f39851t2), this.f39852t3, this.f39853t4, this.f39854t5, this.f39855t6, this.f39856t7);
    }
}
