package com.bytedance.android.livesdk.revenue.util;

import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class DataContextUtilsKt {
    public static final <T, U> ConstantNullableTransformer<T, U> a(com.bytedance.live.datacontext.j<T> r100, c<T, U> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$transform");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        return new ConstantNullableTransformer(r100, new DataContextUtilsKt$transform$5(r101), new DataContextUtilsKt$transform$6(r101));
    }

    public static final <T, U> h<T, U> b(m<T> r100, c<T, U> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$transform");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        return new h(r100, new DataContextUtilsKt$transform$1(r101), new DataContextUtilsKt$transform$2(r101));
    }

    public static final <T, U> j<T, U> c(n<T> r100, c<T, U> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$transform");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        return new j(r100, new DataContextUtilsKt$transform$3(r101), new DataContextUtilsKt$transform$4(r101));
    }
}
