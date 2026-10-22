package com.bytedance.android.ec.hybrid.list;

import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntRange f47012a = null;

    static {
        f47012a = new IntRange(50000, 51000);
    }

    public static final boolean a(Integer r100) {
        IntRange r101 = f47012a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(r100.intValue()) == false) goto L7;
        return true;
    }
}
