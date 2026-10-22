package com.bytedance.android.live.revenue.common;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class MapPropertyDelegateKt {
    public static final <K> w<K, String> a(Map<K, String> r100, K r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$property");
        return new w(r101, MapPropertyDelegateKt$property$3.INSTANCE);
    }
}
