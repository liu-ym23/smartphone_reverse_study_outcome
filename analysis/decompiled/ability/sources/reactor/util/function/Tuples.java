package reactor.util.function;

import java.util.function.Function;

/* loaded from: classes4.dex */
public abstract class Tuples implements Function {
    static final Tuples empty = new Tuples() { // from class: reactor.util.function.Tuples.1
        @Override // reactor.util.function.Tuples, java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) {
            return super.apply(obj);
        }
    };

    public static <T1, T2> Function<Object[], Tuple2<T1, T2>> fn2() {
        return empty;
    }

    public static <T1, T2, T3> Function<Object[], Tuple3<T1, T2, T3>> fn3() {
        return empty;
    }

    public static <T1, T2, T3, T4> Function<Object[], Tuple4<T1, T2, T3, T4>> fn4() {
        return empty;
    }

    public static <T1, T2, T3, T4, T5> Function<Object[], Tuple5<T1, T2, T3, T4, T5>> fn5() {
        return empty;
    }

    public static <T1, T2, T3, T4, T5, T6> Function<Object[], Tuple6<T1, T2, T3, T4, T5, T6>> fn6() {
        return empty;
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Function<Object[], Tuple7<T1, T2, T3, T4, T5, T6, T7>> fn7() {
        return empty;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Function<Object[], Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> fn8() {
        return empty;
    }

    public static Function<Object[], Tuple2> fnAny() {
        return empty;
    }

    public static Tuple2 fromArray(Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            throw new IllegalArgumentException("null or too small array, need between 2 and 8 values");
        }
        switch (objArr.length) {
            case 2:
                return of(objArr[0], objArr[1]);
            case 3:
                return of(objArr[0], objArr[1], objArr[2]);
            case 4:
                return of(objArr[0], objArr[1], objArr[2], objArr[3]);
            case 5:
                return of(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            case 6:
                return of(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            case 7:
                return of(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            case 8:
                return of(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            default:
                throw new IllegalArgumentException(androidx.appfunctions.metadata.a.o(new StringBuilder("too many arguments ("), "), need between 2 and 8 values", objArr.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$fn3$1(Function function, Object[] objArr) {
        return function.apply(fn3().apply(objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$fn4$2(Function function, Object[] objArr) {
        return function.apply(fn4().apply(objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$fn5$3(Function function, Object[] objArr) {
        return function.apply(fn5().apply(objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$fn6$4(Function function, Object[] objArr) {
        return function.apply(fn6().apply(objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$fn7$5(Function function, Object[] objArr) {
        return function.apply(fn7().apply(objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$fn8$6(Function function, Object[] objArr) {
        return function.apply(fn8().apply(objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$fnAny$0(Function function, Object[] objArr) {
        return function.apply(fnAny().apply(objArr));
    }

    public static <T1, T2> Tuple2<T1, T2> of(T1 t12, T2 t22) {
        return new Tuple2<>(t12, t22);
    }

    public static StringBuilder tupleStringRepresentation(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (i != 0) {
                sb.append(',');
            }
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb;
    }

    public static <T1, T2, T3, R> Function<Object[], R> fn3(Function<Tuple3<T1, T2, T3>, R> function) {
        return new a(1, function);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> fn4(Function<Tuple4<T1, T2, T3, T4>, R> function) {
        return new a(6, function);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> fn5(Function<Tuple5<T1, T2, T3, T4, T5>, R> function) {
        return new a(3, function);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> fn6(Function<Tuple6<T1, T2, T3, T4, T5, T6>, R> function) {
        return new a(0, function);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> fn7(Function<Tuple7<T1, T2, T3, T4, T5, T6, T7>, R> function) {
        return new a(4, function);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> fn8(Function<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>, R> function) {
        return new a(5, function);
    }

    public static <R> Function<Object[], R> fnAny(Function<Tuple2, R> function) {
        return new a(2, function);
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 t12, T2 t22, T3 t32) {
        return new Tuple3<>(t12, t22, t32);
    }

    @Override // java.util.function.Function
    public Tuple2 apply(Object obj) {
        return fromArray((Object[]) obj);
    }

    public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 t12, T2 t22, T3 t32, T4 t42) {
        return new Tuple4<>(t12, t22, t32, t42);
    }

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52) {
        return new Tuple5<>(t12, t22, t32, t42, t52);
    }

    public static <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> of(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62) {
        return new Tuple6<>(t12, t22, t32, t42, t52, t62);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> of(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72) {
        return new Tuple7<>(t12, t22, t32, t42, t52, t62, t72);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> of(T1 t12, T2 t22, T3 t32, T4 t42, T5 t52, T6 t62, T7 t72, T8 t82) {
        return new Tuple8<>(t12, t22, t32, t42, t52, t62, t72, t82);
    }
}
