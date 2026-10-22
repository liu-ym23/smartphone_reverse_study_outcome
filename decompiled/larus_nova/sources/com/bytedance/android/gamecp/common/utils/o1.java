package com.bytedance.android.gamecp.common.utils;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class o1 {
    public static void a(View r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$throttleClick");
        Intrinsics.checkNotNullParameter(r101, "block");
        r100.setOnClickListener(new k1(500, r101));
    }
}
