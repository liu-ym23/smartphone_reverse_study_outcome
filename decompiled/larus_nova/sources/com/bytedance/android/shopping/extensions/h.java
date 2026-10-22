package com.bytedance.android.shopping.extensions;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv3.utils.u;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h {
    public static final String a(ECLogExtraData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getEComEntranceFrom");
        return b(r100);
    }

    public static final String b(ECLogExtraData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getRealCarrierType");
        String r101 = a2.d(r100.getEComEntranceForm());
        if (r101 != null) goto L6;
        int r102 = u.f165356a;
        return u.a(r100.getEnterMethod());
    L6:
        return r101;
    }

    public static final boolean c(ECLogExtraData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isFromDetailProductGuessULike");
        if (Intrinsics.areEqual(r100.getModuleLabel(), "guess_you_like_product") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getEnterFrom(), com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL) == false) goto L7;
        return true;
    }

    public static final boolean d(ECLogExtraData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isFromFeedProductGuessULike");
        if (Intrinsics.areEqual(r100.getModuleLabel(), "guess_you_like_product") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getEnterFrom(), com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE) == false) goto L7;
        return true;
    }
}
