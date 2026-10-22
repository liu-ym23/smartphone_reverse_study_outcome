package androidx.core.util;

import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
public interface Predicate<T> {

    /* JADX INFO: renamed from: androidx.core.util.Predicate$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static /* synthetic */ boolean lambda$isEqual$3(Object r100) {
            if (r100 != null) goto L4;
            return true;
        L4:
            return false;
        }

        public static Predicate $default$negate(final Predicate r100) {
            return new e(r100);
        }

        public static <T> Predicate<T> isEqual(final Object r100) {
            if (r100 != null) goto L5;
            return new b();
        L5:
            return new c(r100);
        }

        public static <T> Predicate<T> not(Predicate<? super T> r100) {
            Objects.requireNonNull(r100);
            return r100.negate();
        }

        public static Predicate $default$and(final Predicate r100, final Predicate r101) {
            Objects.requireNonNull(r101);
            return new d(r100, r101);
        }

        public static Predicate $default$or(final Predicate r100, final Predicate r101) {
            Objects.requireNonNull(r101);
            return new a(r100, r101);
        }

        public static /* synthetic */ boolean $private$lambda$negate$1(Predicate r100, Object r101) {
            return !r100.test(r101);
        }

        public static /* synthetic */ boolean lambda$isEqual$4(Object r100, Object r101) {
            return r100.equals(r101);
        }

        public static /* synthetic */ boolean $private$lambda$and$0(Predicate r100, Predicate r101, Object r102) {
            if (r100.test(r102) == true) goto L5;
        L7:
            return false;
        L5:
            if (r101.test(r102) == false) goto L7;
            return true;
        }

        public static /* synthetic */ boolean $private$lambda$or$2(Predicate r100, Predicate r101, Object r102) {
            if (r100.test(r102) == false) goto L5;
        L8:
            return true;
        L5:
            if (r101.test(r102) == true) goto L8;
            return false;
        }
    }

    Predicate<T> and(Predicate<? super T> r100);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> r100);

    boolean test(T r100);
}
