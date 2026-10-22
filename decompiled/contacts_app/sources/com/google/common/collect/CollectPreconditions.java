package com.google.common.collect;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
final class CollectPreconditions {
    CollectPreconditions() {
    }

    static void checkEntryNotNull(Object r2, Object r3) {
        if (r2 == null) goto L8;
        if (r3 == null) goto L6;
        return;
    L6:
        throw new NullPointerException("null value in entry: " + r2 + "=null");
    L8:
        throw new NullPointerException("null key in entry: null=" + r3);
    }

    static int checkNonnegative(int r2, String r3) {
        if (r2 < 0) goto L5;
        return r2;
    L5:
        throw new IllegalArgumentException(r3 + " cannot be negative but was: " + r2);
    }

    static void checkRemove(boolean r1) {
        Preconditions.checkState(r1, "no calls to next() since the last call to remove()");
    }
}
