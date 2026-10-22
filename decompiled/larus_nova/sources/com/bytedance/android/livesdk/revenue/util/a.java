package com.bytedance.android.livesdk.revenue.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a<T> {
    public a() {
    }

    public abstract T k();

    public final int hashCode() {
        return k().hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if ((!Intrinsics.areEqual(k(), ((a) r100).k())) == false) goto L11;
        return false;
    L11:
        return true;
    }
}
