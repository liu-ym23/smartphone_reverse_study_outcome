package androidx.core.util;

import android.annotation.SuppressLint;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public interface Predicate<T> {
    static /* synthetic */ boolean a(Predicate r10, Object r11) {
        return r10.lambda$negate$1(r11);
    }

    static /* synthetic */ boolean b(Predicate r10, Predicate r11, Object r12) {
        return r10.lambda$and$0(r11, r12);
    }

    static /* synthetic */ boolean c(Object r10, Object r11) {
        return lambda$isEqual$4(r10, r11);
    }

    static /* synthetic */ boolean d(Predicate r10, Predicate r11, Object r12) {
        return r10.lambda$or$2(r11, r12);
    }

    static /* synthetic */ boolean e(Object r10) {
        return lambda$isEqual$3(r10);
    }

    @SuppressLint({"MissingNullability"})
    static <T> Predicate<T> isEqual(@SuppressLint({"MissingNullability"}) final Object r10) {
        if (r10 != null) goto L5;
        return new g();
    L5:
        return new h(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ default boolean lambda$and$0(Predicate r10, Object r11) {
        if (test(r11) == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.test(r11) == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$isEqual$3(Object r10) {
        return Objects.isNull(r10);
    }

    private static /* synthetic */ boolean lambda$isEqual$4(Object r10, Object r11) {
        return r10.equals(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ default boolean lambda$negate$1(Object r10) {
        return !test(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ default boolean lambda$or$2(Predicate r10, Object r11) {
        if (test(r11) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10.test(r11) == true) goto L8;
        return false;
    }

    @SuppressLint({"MissingNullability"})
    static <T> Predicate<T> not(@SuppressLint({"MissingNullability"}) Predicate<? super T> r10) {
        Objects.requireNonNull(r10);
        return r10.negate();
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> and(@SuppressLint({"MissingNullability"}) final Predicate<? super T> r10) {
        Objects.requireNonNull(r10);
        return new i(this, r10);
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> negate() {
        return new j(this);
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> or(@SuppressLint({"MissingNullability"}) final Predicate<? super T> r10) {
        Objects.requireNonNull(r10);
        return new f(this, r10);
    }

    boolean test(T r10);
}
