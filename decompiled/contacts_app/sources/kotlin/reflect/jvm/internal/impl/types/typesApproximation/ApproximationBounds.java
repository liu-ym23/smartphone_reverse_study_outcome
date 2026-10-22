package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ApproximationBounds<T> {
    private final T lower;
    private final T upper;

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ApproximationBounds) == true) goto L8;
        return false;
    L8:
        ApproximationBounds r6 = (ApproximationBounds) r5;
        if (Intrinsics.areEqual(this.lower, r6.lower) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.upper, r6.upper) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        T r0 = this.lower;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        T r4 = this.upper;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + ')';
    }

    public ApproximationBounds(T r1, T r2) {
        this.lower = r1;
        this.upper = r2;
    }

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }
}
