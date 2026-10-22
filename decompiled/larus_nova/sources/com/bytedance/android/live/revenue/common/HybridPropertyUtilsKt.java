package com.bytedance.android.live.revenue.common;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.s1;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class HybridPropertyUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SharedPreferences f90802a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w0<Map<String, String>> f90803b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w0<Boolean> f90804c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w0<String> f90805d = null;

    static {
        f90802a = s1.getContext().getSharedPreferences("js_kv_methods_20191113", 0);
        f90803b = new w0(HybridPropertyUtilsKt$STRING_MAP_ADAPTER$1.INSTANCE, HybridPropertyUtilsKt$STRING_MAP_ADAPTER$2.INSTANCE);
        f90804c = new w0(HybridPropertyUtilsKt$BOOLEAN_ADAPTER$1.INSTANCE, HybridPropertyUtilsKt$BOOLEAN_ADAPTER$2.INSTANCE);
        HybridPropertyUtilsKt$INT_ADAPTER$1 r100 = HybridPropertyUtilsKt$INT_ADAPTER$1.INSTANCE;
        HybridPropertyUtilsKt$INT_ADAPTER$2 r101 = HybridPropertyUtilsKt$INT_ADAPTER$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "read");
        Intrinsics.checkNotNullParameter(r101, "write");
        HybridPropertyUtilsKt$LONG_ADAPTER$1 r102 = HybridPropertyUtilsKt$LONG_ADAPTER$1.INSTANCE;
        HybridPropertyUtilsKt$LONG_ADAPTER$2 r103 = HybridPropertyUtilsKt$LONG_ADAPTER$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "read");
        Intrinsics.checkNotNullParameter(r103, "write");
        HybridPropertyUtilsKt$FLOAT_ADAPTER$1 r104 = HybridPropertyUtilsKt$FLOAT_ADAPTER$1.INSTANCE;
        HybridPropertyUtilsKt$FLOAT_ADAPTER$2 r105 = HybridPropertyUtilsKt$FLOAT_ADAPTER$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r104, "read");
        Intrinsics.checkNotNullParameter(r105, "write");
        f90805d = new w0(HybridPropertyUtilsKt$STRING_ADAPTER$1.INSTANCE, HybridPropertyUtilsKt$STRING_ADAPTER$2.INSTANCE);
    }

    public static final void a(String r100, Object r101) {
        f90802a.edit().putString(r100, r101.toString()).apply();
    }

    public static final m b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        return new m(r100, r101, f90805d);
    }

    public static final m c(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        return new m(r100, r101, f90803b);
    }
}
