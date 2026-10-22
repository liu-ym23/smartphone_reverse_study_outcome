package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.android.shopping.buynow.data.model.PageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171206a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        if (r100.equals(PageType.CONTINUEPAY) == false) goto L5;
        return "a1.b25587.c0.d0";
    L5:
        return "a1.b7411.c0.d0";
    }
}
