package com.bytedance.android.shopping.anchorv3;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public static final JSONObject a(AnchorV3Param r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getEntranceInfo");
        return d(r100.getEntranceInfo());
    }

    public static final boolean b(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static final boolean c(AnchorV3Param r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isQCSoftAd");
        if (r100.getRequestParam().getAggParams() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final JSONObject d(String r100) {
        if (b(r100) == false) goto L6;
        return new JSONObject(r100);
    L6:
        return null;
    L11:
        return null;
    }
}
