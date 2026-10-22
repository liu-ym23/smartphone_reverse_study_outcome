package reactor.util.function;

import java.util.Objects;
import java.util.function.Function;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
public class Tuple7<T1, T2, T3, T4, T5, T6, T7> extends Tuple6<T1, T2, T3, T4, T5, T6> {
    private static final long serialVersionUID = -8002391247456579281L;

    /* renamed from: t7, reason: collision with root package name */
    @NonNull
    final T7 f5963t7;

    public Tuple7(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72) {
        super(t12, t22, t32, t42, t52, t62);
        Objects.requireNonNull(t72, "t7");
        this.f5963t7 = t72;
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Tuple7) && super.equals(obj)) {
            return this.f5963t7.equals(((Tuple7) obj).f5963t7);
        }
        return false;
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    @Nullable
    public Object get(int i) {
        switch (i) {
            case 0:
                return this.f5957t1;
            case 1:
                return this.f5958t2;
            case 2:
                return this.f5959t3;
            case 3:
                return this.f5960t4;
            case 4:
                return this.f5961t5;
            case 5:
                return this.f5962t6;
            case 6:
                return this.f5963t7;
            default:
                return null;
        }
    }

    public T7 getT7() {
        return this.f5963t7;
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int hashCode() {
        return this.f5963t7.hashCode() + (super.hashCode() * 31);
    }

    public <R> Tuple7<T1, T2, T3, T4, T5, T6, R> mapT7(Function<T7, R> function) {
        return new Tuple7<>(this.f5957t1, this.f5958t2, this.f5959t3, this.f5960t4, this.f5961t5, this.f5962t6, function.apply(this.f5963t7));
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int size() {
        return 7;
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public Object[] toArray() {
        return new Object[]{this.f5957t1, this.f5958t2, this.f5959t3, this.f5960t4, this.f5961t5, this.f5962t6, this.f5963t7};
    }

    @Override // reactor.util.function.Tuple6
    public <R> Tuple7<T1, T2, T3, T4, T5, R, T7> mapT6(Function<T6, R> function) {
        return new Tuple7<>(this.f5957t1, this.f5958t2, this.f5959t3, this.f5960t4, this.f5961t5, function.apply(this.f5962t6), this.f5963t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5
    public <R> Tuple7<T1, T2, T3, T4, R, T6, T7> mapT5(Function<T5, R> function) {
        return new Tuple7<>(this.f5957t1, this.f5958t2, this.f5959t3, this.f5960t4, function.apply(this.f5961t5), this.f5962t6, this.f5963t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4
    public <R> Tuple7<T1, T2, T3, R, T5, T6, T7> mapT4(Function<T4, R> function) {
        return new Tuple7<>(this.f5957t1, this.f5958t2, this.f5959t3, function.apply(this.f5960t4), this.f5961t5, this.f5962t6, this.f5963t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3
    public <R> Tuple7<T1, T2, R, T4, T5, T6, T7> mapT3(Function<T3, R> function) {
        return new Tuple7<>(this.f5957t1, this.f5958t2, function.apply(this.f5959t3), this.f5960t4, this.f5961t5, this.f5962t6, this.f5963t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple7<R, T2, T3, T4, T5, T6, T7> mapT1(Function<T1, R> function) {
        return new Tuple7<>(function.apply(this.f5957t1), this.f5958t2, this.f5959t3, this.f5960t4, this.f5961t5, this.f5962t6, this.f5963t7);
    }

    @Override // reactor.util.function.Tuple6, reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple7<T1, R, T3, T4, T5, T6, T7> mapT2(Function<T2, R> function) {
        return new Tuple7<>(this.f5957t1, function.apply(this.f5958t2), this.f5959t3, this.f5960t4, this.f5961t5, this.f5962t6, this.f5963t7);
    }
}
