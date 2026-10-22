package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s {
    public static final String a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getUniqueId");
        String r101 = r100.f189554c;
        if (r101 != null) goto L6;
        fo.b r102 = r100.f189557f;
        fo.a<Map<String, String>> r103 = m0.f189599a;
        return (String) r102.a(m0.f189601c);
    L6:
        return r101;
    }

    public static final boolean b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isDynamicInserted");
        if ((r100 instanceof n) == false) goto L6;
        return true;
    L6:
        if (r100.f189552a != null) goto L10;
        return false;
    L10:
        return true;
    }

    public static final void c(f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setCardPosition");
        fo.b r102 = r100.f189557f;
        fo.a<Map<String, String>> r103 = m0.f189599a;
        r102.d(m0.f189603e, Integer.valueOf(r101));
        if ((r100 instanceof n) == false) goto L6;
        n r104 = (n) r100;
        c(r104.f189605k, r101);
        c(r104.f189606l, r101 + 1);
        return;
    }
}
