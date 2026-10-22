package com.bytedance.android.annie.xbridge.mix;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.annie.xbridge.mix.JSB2ConvertUtilsKt$getStatefulMethodV2$1] */
    public static final JSB2ConvertUtilsKt$getStatefulMethodV2$1 a(final com.bytedance.ies.web.jsbridge2.f r100, final String r101, final m16.b r102) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        Intrinsics.checkNotNullParameter(r102, "contextProviderFactory");
        return new JSB2ConvertUtilsKt$getStatefulMethodV2$1(r101, r102, r100);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.annie.xbridge.mix.JSB2ConvertUtilsKt$getStatelessMethodV2$1] */
    public static final JSB2ConvertUtilsKt$getStatelessMethodV2$1 b(final com.bytedance.ies.web.jsbridge2.g r100, final String r101, final m16.b r102) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        Intrinsics.checkNotNullParameter(r102, "contextProviderFactory");
        return new JSB2ConvertUtilsKt$getStatelessMethodV2$1(r101, r102, r100);
    }
}
