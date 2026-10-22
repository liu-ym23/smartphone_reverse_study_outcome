package com.bytedance.android.live.core.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m2 {
    public static final String b(boolean r100) {
        if (r100 == false) goto L4;
        return "1";
    L4:
        return "0";
    }

    public static final boolean a(Object r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAnyOf");
        Intrinsics.checkNotNullParameter(r101, "args");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        if (Intrinsics.areEqual(r101[r103], r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }
}
