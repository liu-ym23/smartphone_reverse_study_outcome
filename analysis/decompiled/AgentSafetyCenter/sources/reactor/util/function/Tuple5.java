package reactor.util.function;

import java.util.Objects;
import java.util.function.Function;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class Tuple5<T1, T2, T3, T4, T5> extends Tuple4<T1, T2, T3, T4> {
    private static final long serialVersionUID = 3541548454198133275L;

    /* renamed from: t5, reason: collision with root package name */
    @NonNull
    final T5 f10915t5;

    public Tuple5(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52) {
        super(t12, t22, t32, t42);
        Objects.requireNonNull(t52, "t5");
        this.f10915t5 = t52;
    }

    @Override // reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Tuple5) && super.equals(obj)) {
            return this.f10915t5.equals(((Tuple5) obj).f10915t5);
        }
        return false;
    }

    @Override // reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
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
        if (i != 4) {
            return null;
        }
        return this.f10915t5;
    }

    public T5 getT5() {
        return this.f10915t5;
    }

    @Override // reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int hashCode() {
        return this.f10915t5.hashCode() + (super.hashCode() * 31);
    }

    @Override // reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple5<R, T2, T3, T4, T5> mapT1(Function<T1, R> function) {
        return new Tuple5<>(function.apply(this.f10911t1), this.f10912t2, this.f10913t3, this.f10914t4, this.f10915t5);
    }

    @Override // reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public <R> Tuple5<T1, R, T3, T4, T5> mapT2(Function<T2, R> function) {
        return new Tuple5<>(this.f10911t1, function.apply(this.f10912t2), this.f10913t3, this.f10914t4, this.f10915t5);
    }

    @Override // reactor.util.function.Tuple4, reactor.util.function.Tuple3
    public <R> Tuple5<T1, T2, R, T4, T5> mapT3(Function<T3, R> function) {
        return new Tuple5<>(this.f10911t1, this.f10912t2, function.apply(this.f10913t3), this.f10914t4, this.f10915t5);
    }

    @Override // reactor.util.function.Tuple4
    public <R> Tuple5<T1, T2, T3, R, T5> mapT4(Function<T4, R> function) {
        return new Tuple5<>(this.f10911t1, this.f10912t2, this.f10913t3, function.apply(this.f10914t4), this.f10915t5);
    }

    public <R> Tuple5<T1, T2, T3, T4, R> mapT5(Function<T5, R> function) {
        return new Tuple5<>(this.f10911t1, this.f10912t2, this.f10913t3, this.f10914t4, function.apply(this.f10915t5));
    }

    @Override // reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public int size() {
        return 5;
    }

    @Override // reactor.util.function.Tuple4, reactor.util.function.Tuple3, reactor.util.function.Tuple2
    public Object[] toArray() {
        return new Object[]{this.f10911t1, this.f10912t2, this.f10913t3, this.f10914t4, this.f10915t5};
    }
}
