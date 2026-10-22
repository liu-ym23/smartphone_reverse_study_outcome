package com.android.server.permission.jarjar.kotlin.ranges;

import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntRange extends IntProgression {
    public static final Companion Companion = null;
    private static final IntRange EMPTY = null;

    /* JADX INFO: compiled from: PrimitiveRanges.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public IntRange(int start, int endInclusive) {
        super(start, endInclusive, 1);
    }

    public boolean isEmpty() {
        if (getFirst() <= getLast()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object other) {
        if ((other instanceof IntRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == false) goto L9;
        if (((IntRange) other).isEmpty() == false) goto L9;
    L12:
        return true;
    L9:
        if (getFirst() != ((IntRange) other).getFirst()) goto L13;
        if (getLast() != ((IntRange) other).getLast()) goto L13;
        goto L12
    }

    public int hashCode() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return (getFirst() * 31) + getLast();
    }

    public String toString() {
        return getFirst() + ".." + getLast();
    }

    static {
        Companion = new Companion(null);
        EMPTY = new IntRange(1, 0);
    }
}
