package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.util.SparseArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a0 {
    public static final <T> void a(SparseArray<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$forEachValue");
        Intrinsics.checkNotNullParameter(r101, "action");
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(r100.valueAt(r103));
        r103 = r103 + 1;
        goto L3
    }
}
