package com.bytedance.android.livesdk.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i6 {
    static {
    }

    public static String a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        String r102 = "...";
        Intrinsics.checkNotNullParameter("...", "ellipsis");
        if (r100.length() <= r101) goto L23;
        int r103 = r100.codePointCount(0, r100.length());
        if (r103 <= 0) goto L18;
        int r104 = r103 + 1;
        int r105 = 1;
    L7:
        if (r105 >= r104) goto L18;
        int r106 = r100.offsetByCodePoints(0, r105 - 1);
        int r107 = r100.offsetByCodePoints(0, r105);
        if (r106 >= r101) goto L16;
        if (r107 <= r101) goto L16;
        StringBuilder r108 = new StringBuilder();
        r108.append(r100.substring(0, r107));
        if (r105 < r103) goto L15;
        r102 = "";
    L15:
        r108.append(r102);
        return r108.toString();
    L16:
        r105 = r105 + 1;
    L18:
        return r100.substring(0, r101) + "...";
    L23:
        return r100;
    }
}
