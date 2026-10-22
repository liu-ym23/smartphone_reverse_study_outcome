package com.bytedance.android.shopping.store.tabkit;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f186756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<Long> f186757b = null;

    static {
        f186757b = new SparseArray();
    }

    public static Long a(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
        return f186757b.get(r101);
    L4:
        return null;
    }
}
