package com.bytedance.android.btm.impl.util;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes43.dex */
public final class f<T> extends WeakReference<T> {
    public final int hashCode() {
        T r100 = get();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public f(T r100) {
        super(r100);
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (get() != ((f) r100).get()) goto L12;
        return true;
    L12:
        return false;
    }
}
