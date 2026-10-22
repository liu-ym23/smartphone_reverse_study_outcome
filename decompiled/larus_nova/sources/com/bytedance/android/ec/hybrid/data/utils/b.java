package com.bytedance.android.ec.hybrid.data.utils;

import com.miui.easygo.constant.EasyGoConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static final int a(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "$this$versionCompare");
        Intrinsics.checkNotNullParameter(r110, "other");
        int r101 = 0;
        Object[] r102 = StringsKt.split$default(r100, new String[]{EasyGoConstant.VERSION_SEPARATIVE_SIGN}, false, 0, 6, null).toArray(new String[0]);
        if (r102 == null) goto L18;
        String[] r103 = (String[]) r102;
        Object[] r111 = StringsKt.split$default(r110, new String[]{EasyGoConstant.VERSION_SEPARATIVE_SIGN}, false, 0, 6, null).toArray(new String[0]);
        if (r111 == null) goto L16;
        String[] r112 = (String[]) r111;
        int r104 = Math.min(r103.length, r112.length);
        int r105 = 0;
    L7:
        if (r101 >= r104) goto L12;
        String r106 = r103[r101];
        String r107 = r112[r101];
        int r108 = r106.length() - r107.length();
        if (r108 != 0) goto L10;
        r105 = r106.compareTo(r107);
        r101 = r101 + 1;
        goto L7
    L10:
        r105 = r108;
    L12:
        if (r105 == 0) goto L14;
        return r105;
    L14:
        return r103.length - r112.length;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
