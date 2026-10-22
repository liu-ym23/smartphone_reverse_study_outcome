package androidx.core.util;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public interface Predicate<T> {
    boolean test(T r1);

    default Predicate<T> and(final Predicate<? super T> r2) {
        Objects.requireNonNull(r2);
        return new Predicate$$ExternalSyntheticLambda3(this, r2);
    }

    static /* synthetic */ boolean lambda$and$0(Predicate _this, Predicate r1, Object r2) {
        if (_this.test(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.test(r2) == false) goto L7;
        return true;
    }

    static /* synthetic */ boolean lambda$negate$1(Predicate _this, Object r1) {
        return !_this.test(r1);
    }

    default Predicate<T> negate() {
        return new Predicate$$ExternalSyntheticLambda4(this);
    }

    default Predicate<T> or(final Predicate<? super T> r2) {
        Objects.requireNonNull(r2);
        return new Predicate$$ExternalSyntheticLambda0(this, r2);
    }

    static /* synthetic */ boolean lambda$or$2(Predicate _this, Predicate r1, Object r2) {
        if (_this.test(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.test(r2) == true) goto L8;
        return false;
    }

    static <T> Predicate<T> isEqual(final Object r1) {
        if (r1 != null) goto L5;
        return new Predicate$$ExternalSyntheticLambda1();
    L5:
        return new Predicate$$ExternalSyntheticLambda2(r1);
    }

    static /* synthetic */ boolean lambda$isEqual$3(Object r0) {
        return Objects.isNull(r0);
    }

    static /* synthetic */ boolean lambda$isEqual$4(Object r0, Object r1) {
        return r0.equals(r1);
    }

    static <T> Predicate<T> not(Predicate<? super T> r0) {
        Objects.requireNonNull(r0);
        return r0.negate();
    }
}
