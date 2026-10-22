package com.bytedance.android.livesdk.coupon.customview;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"indexOfRange", "Lkotlin/Pair;", "", "", "that", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class UgCouponGoodsNewDialog$createPricingSpannableString$1 extends Lambda implements Function2<String, String, Pair<? extends Integer, ? extends Integer>> {
    public static final UgCouponGoodsNewDialog$createPricingSpannableString$1 INSTANCE = null;

    static {
        INSTANCE = new UgCouponGoodsNewDialog$createPricingSpannableString$1();
    }

    public UgCouponGoodsNewDialog$createPricingSpannableString$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<Integer, Integer> invoke2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$indexOfRange");
        Intrinsics.checkNotNullParameter(r101, "that");
        int r102 = StringsKt.indexOf$default(r100, r101, 0, false, 6, null);
        int r103 = r100.length();
        if (r102 < 0) goto L15;
        if (r103 <= r102) goto L12;
        int r104 = r100.length();
        int r105 = (r101.length() + r102) - 1;
        if (r105 < 0) goto L14;
        if (r104 > r105) goto L11;
        return null;
    L11:
        return TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r102 + r101.length()));
    L14:
        return null;
    L12:
        return null;
    L15:
        return null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(String r100, String r101) {
        return invoke2(r100, r101);
    }
}
