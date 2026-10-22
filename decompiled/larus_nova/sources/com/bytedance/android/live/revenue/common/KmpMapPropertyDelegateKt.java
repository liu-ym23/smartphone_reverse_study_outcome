package com.bytedance.android.live.revenue.common;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class KmpMapPropertyDelegateKt {
    public static final <K> s<K, String> a(Map<K, String> r100, K r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$kmpProperty");
        return new s(r101, KmpMapPropertyDelegateKt$kmpProperty$3.INSTANCE);
    }
}
