package com.bytedance.android.live.wallet.caijing;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static final sc4.a a(ad1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toCJModel");
        int r101 = sc4.a.f541343b;
        String r102 = r100.f2934a;
        String r103 = r100.f2935b;
        Map<String, Object> r104 = r100.f2936c;
        Intrinsics.checkNotNullParameter(r102, "merchantId");
        Intrinsics.checkNotNullParameter(r103, "cjAppId");
        Intrinsics.checkNotNullParameter(r104, "eventParams");
        if (r102.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L9;
        r103.getClass();
    L9:
        return new sc4.a(r104);
    L5:
        r105 = false;
        goto L6
    }
}
