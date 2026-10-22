package com.bytedance.android.shopping.mall.homepage.card;

import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.shopping.mall.homepage.card.ECMallInstantCardExtensionsKt$generateClickDelegate$1] */
    public static final ECMallInstantCardExtensionsKt$generateClickDelegate$1 a(final View.OnClickListener r100, final Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertToAddressUpdateClickListener");
        Intrinsics.checkNotNullParameter(r101, "addressProvider");
        return new ECMallInstantCardExtensionsKt$generateClickDelegate$1(r101, r100);
    }
}
