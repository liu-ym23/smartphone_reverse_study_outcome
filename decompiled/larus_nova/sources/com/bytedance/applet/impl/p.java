package com.bytedance.applet.impl;

import com.ss.android.lark.image.entity.LoadParams;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class p {
    public static final String a(String r100) {
        if (r100 == null) goto L21;
        String r101 = LoadParams.ImageFormat.PNG;
        if (StringsKt.contains$default(r100, LoadParams.ImageFormat.PNG, false, 2, null) == true) goto L24;
        r101 = "gif";
        if (StringsKt.contains$default(r100, "gif", false, 2, null) == true) goto L24;
        r101 = "webp";
        if (StringsKt.contains$default(r100, "webp", false, 2, null) == true) goto L24;
        if (StringsKt.contains$default(r100, "heif", false, 2, null) == false) goto L16;
        return "heic";
    L16:
        if (StringsKt.contains$default(r100, "heic", false, 2, null) == true) goto L25;
        r101 = "bmp";
        if (StringsKt.contains$default(r100, "bmp", false, 2, null) == false) goto L21;
    L25:
        return "heic";
    L24:
        return r101;
    L21:
        return "jpg";
    }
}
