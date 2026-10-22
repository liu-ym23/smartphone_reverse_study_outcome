package com.android.server.permission.jarjar.kotlin;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.io.Serializable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof Pair) == true) goto L8;
        return false;
    L8:
        Pair r1 = (Pair) r6;
        if (Intrinsics.areEqual(this.first, r1.first) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.second, r1.second) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 0;
        if (this.first != null) goto L5;
        int r0 = 0;
    L6:
        int r2 = r0 * 31;
        if (this.second == null) goto L11;
        r1 = this.second.hashCode();
    L11:
        return r2 + r1;
    L5:
        r0 = this.first.hashCode();
        goto L6
    }

    public Pair(A r1, B r2) {
        this.first = r1;
        this.second = r2;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
