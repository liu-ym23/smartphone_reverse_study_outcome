package com.bytedance.android.gamecp.common.utils;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57218a = 0;

    static {
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rgbAColor");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L10;
        LocalTestManager.a(new Class[]{uv.a.class});
        yr.c.g("ColorUtils", "rgbAColor is empty");
        return "";
    L10:
        boolean r102 = StringsKt.startsWith$default(r100, "#", false, 2, null);
        if (r102 == false) goto L15;
        if (r100.length() > 7) goto L15;
    L16:
        return r100;
    L15:
        if (r100.length() <= 6) goto L16;
        int r103 = r100.length();
        int r104 = (r102 ? 1 : 0) + 8;
        if (r103 == r104) goto L21;
        LocalTestManager.a(new Class[]{uv.a.class});
        yr.c.g("ColorUtils", "rgbAColor format error");
        return r100;
    L21:
        int r105 = (r102 ? 1 : 0) + 0;
        int r106 = (r102 ? 1 : 0) + 2;
        String r107 = r100.substring(r105, r106);
        int r108 = (r102 ? 1 : 0) + 4;
        String r109 = r100.substring(r106, r108);
        int r110 = (r102 ? 1 : 0) + 6;
        String r111 = r100.substring(r108, r110);
        return "#" + r100.substring(r110, r104) + r107 + r109 + r111;
    L5:
        r101 = false;
        goto L7
    }

    public static int a(float r100, int r101) {
        return (Math.min(255, Math.max(0, (int) (r100 * 255))) << 24) + (r101 & 16777215);
    }
}
