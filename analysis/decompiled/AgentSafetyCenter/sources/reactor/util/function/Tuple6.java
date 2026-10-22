package reactor.util.function;

import java.util.Objects;
import java.util.function.Function;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class Tuple6<T1, T2, T3, T4, T5, T6> extends Tuple5<T1, T2, T3, T4, T5> {
    private static final long serialVersionUID = 770306356087176830L;

    /* renamed from: t6, reason: collision with root package name */
    @NonNull
    final T6 f10916t6;

    public Tuple6(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62) {
        super(t12, t22, t32, t42, t52);
        Objects.requireNonNull(t62, "t6");
        this.f10916t6 = t62;
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Tuple6) && super.equals(obj)) {
            return this.f10916t6.equals(((Tuple6) obj).f10916t6);
        }
        return false;
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    @Nullable
    public Object get(int i) {
        if (i == 0) {
            return this.f10911t1;
        }
        if (i == 1) {
            return this.f10912t2;
        }
        if (i == 2) {
            return this.f10913t3;
        }
        if (i == 3) {
            return this.f10914t4;
        }
        if (i == 4) {
            return this.f10915t5;
        }
        if (i != 5) {
            return null;
        }
        return this.f10916t6;
    }

    public T6 getT6() {
        return this.f10916t6;
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int hashCode() {
        return this.f10916t6.hashCode() + (super.hashCode() * 31);
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple6<R, T2, T3, T4, T5, T6> mapT1(Function<T1, R> function) {
        return new Tuple6<>(function.apply(this.f10911t1), this.f10912t2, this.f10913t3, this.f10914t4, this.f10915t5, this.f10916t6);
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple6<T1, R, T3, T4, T5, T6> mapT2(Function<T2, R> function) {
        return new Tuple6<>(this.f10911t1, function.apply(this.f10912t2), this.f10913t3, this.f10914t4, this.f10915t5, this.f10916t6);
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3
    public <R> Tuple6<T1, T2, R, T4, T5, T6> mapT3(Function<T3, R> function) {
        return new Tuple6<>(this.f10911t1, this.f10912t2, function.apply(this.f10913t3), this.f10914t4, this.f10915t5, this.f10916t6);
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4
    public <R> Tuple6<T1, T2, T3, R, T5, T6> mapT4(Function<T4, R> function) {
        return new Tuple6<>(this.f10911t1, this.f10912t2, this.f10913t3, function.apply(this.f10914t4), this.f10915t5, this.f10916t6);
    }

    @Override // reactor.util.function.Tuple5
    public <R> Tuple6<T1, T2, T3, T4, R, T6> mapT5(Function<T5, R> function) {
        return new Tuple6<>(this.f10911t1, this.f10912t2, this.f10913t3, this.f10914t4, function.apply(this.f10915t5), this.f10916t6);
    }

    public <R> Tuple6<T1, T2, T3, T4, T5, R> mapT6(Function<T6, R> function) {
        return new Tuple6<>(this.f10911t1, this.f10912t2, this.f10913t3, this.f10914t4, this.f10915t5, function.apply(this.f10916t6));
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int size() {
        return 6;
    }

    @Override // reactor.util.function.Tuple5, reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public Object[] toArray() {
        return new Object[]{this.f10911t1, this.f10912t2, this.f10913t3, this.f10914t4, this.f10915t5, this.f10916t6};
    }
}
