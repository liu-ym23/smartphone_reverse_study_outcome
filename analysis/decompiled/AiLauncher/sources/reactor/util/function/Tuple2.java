package reactor.util.function;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
public class Tuple2<T1, T2> implements Iterable<Object>, Serializable {
    private static final long serialVersionUID = -3518082018884860684L;

    /* renamed from: t1, reason: collision with root package name */
    @NonNull
    final T1 f39850t1;

    /* renamed from: t2, reason: collision with root package name */
    @NonNull
    final T2 f39851t2;

    public Tuple2(T1 t12, T2 t22) {
        Objects.requireNonNull(t12, "t1");
        this.f39850t1 = t12;
        Objects.requireNonNull(t22, "t2");
        this.f39851t2 = t22;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Tuple2 tuple2 = (Tuple2) obj;
            if (this.f39850t1.equals(tuple2.f39850t1) && this.f39851t2.equals(tuple2.f39851t2)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Object get(int i10) {
        if (i10 == 0) {
            return this.f39850t1;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f39851t2;
    }

    public T1 getT1() {
        return this.f39850t1;
    }

    public T2 getT2() {
        return this.f39851t2;
    }

    public int hashCode() {
        return (((size() * 31) + this.f39850t1.hashCode()) * 31) + this.f39851t2.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return Collections.unmodifiableList(toList()).iterator();
    }

    public <R> Tuple2<R, T2> mapT1(Function<T1, R> function) {
        return new Tuple2<>(function.apply(this.f39850t1), this.f39851t2);
    }

    public <R> Tuple2<T1, R> mapT2(Function<T2, R> function) {
        return new Tuple2<>(this.f39850t1, function.apply(this.f39851t2));
    }

    public int size() {
        return 2;
    }

    public Object[] toArray() {
        return new Object[]{this.f39850t1, this.f39851t2};
    }

    public List<Object> toList() {
        return Arrays.asList(toArray());
    }

    public final String toString() {
        StringBuilder sbInsert = Tuples.tupleStringRepresentation(toArray()).insert(0, '[');
        sbInsert.append(']');
        return sbInsert.toString();
    }
}
