package com.bytedance.android.ec.core.imagex.opt;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class s {
    public static final com.bytedance.android.shopping.api.image.q c(com.bytedance.android.ec.core.imagex.r r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$tryGetUrlParams");
        if ((r100 instanceof com.bytedance.android.ec.core.imagex.u) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.ec.core.imagex.u r101 = (com.bytedance.android.ec.core.imagex.u) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.n();
    }

    public static final com.bytedance.android.shopping.api.image.r d(com.bytedance.android.ec.core.imagex.r r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$tryGetUrlParser");
        if ((r100 instanceof com.bytedance.android.ec.core.imagex.u) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.ec.core.imagex.u r101 = (com.bytedance.android.ec.core.imagex.u) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f45062z;
    }

    public static final int a(String r110, String[] r111, boolean r112) {
        int r100 = r111.length;
        int r101 = 0;
        int r102 = -1;
    L3:
        if (r101 >= r100) goto L10;
        String r103 = r111[r101];
        int r104 = StringsKt.indexOf$default(r110, r103, 0, false, 6, null);
        if (r104 >= 0) goto L6;
        r101 = r101 + 1;
        r102 = r104;
        goto L3
    L6:
        if (r112 == false) goto L8;
        r104 = r104 + r103.length();
    L8:
        r102 = r104;
    L10:
        if (r102 < 0) goto L12;
        return r102;
    L12:
        return -1;
    }

    public static final String b(String r100, String[] r101, boolean r102, String[] r103) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r104 = 0;
        if (r101.length != 0) goto L8;
        boolean r105 = true;
    L10:
        if ((!r105) == false) goto L12;
        int r106 = a(r100, r101, true);
    L14:
        if (r103.length != 0) goto L16;
        boolean r107 = true;
    L18:
        if ((!r107) == false) goto L20;
        int r108 = a(r100, r103, false);
    L21:
        if (r106 >= 0) goto L24;
        if (r102 == false) goto L24;
    L25:
        if (r108 >= 0) goto L27;
        r108 = r100.length();
    L27:
        if (r104 < 0) goto L32;
        if (r108 < 0) goto L32;
        if (r104 >= r108) goto L32;
        return r100.substring(r104, r108);
    L32:
        return null;
    L24:
        r104 = r106;
        goto L25
    L20:
        r108 = r100.length();
        goto L21
    L16:
        r107 = false;
        goto L18
    L12:
        r106 = 0;
        goto L14
    L8:
        r105 = false;
        goto L10
    }
}
