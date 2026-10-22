package com.android.server.permission.jarjar.kotlin;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.io.Serializable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof Triple) == true) goto L8;
        return false;
    L8:
        Triple r1 = (Triple) r6;
        if (Intrinsics.areEqual(this.first, r1.first) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.second, r1.second) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.third, r1.third) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r1 = 0;
        if (this.first != null) goto L5;
        int r0 = 0;
    L6:
        int r2 = r0 * 31;
        if (this.second != null) goto L9;
        int r3 = 0;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.third == null) goto L15;
        r1 = this.third.hashCode();
    L15:
        return r4 + r1;
    L9:
        r3 = this.second.hashCode();
        goto L10
    L5:
        r0 = this.first.hashCode();
        goto L6
    }

    public Triple(A r1, B r2, C r3) {
        this.first = r1;
        this.second = r2;
        this.third = r3;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
