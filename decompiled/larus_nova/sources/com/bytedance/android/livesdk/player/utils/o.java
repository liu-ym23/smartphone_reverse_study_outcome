package com.bytedance.android.livesdk.player.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f156224a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        if ((!StringsKt.isBlank(r100)) == false) goto L50;
        int r102 = r100.length() - 1;
        int r103 = 0;
        boolean r104 = false;
    L14:
        if (r103 > r102) goto L29;
        if (r104 == true) goto L17;
        int r105 = r103;
    L19:
        if (Intrinsics.compare(r100.charAt(r105), 32) > 0) goto L21;
        boolean r106 = true;
    L22:
        if (r104 == false) goto L23;
        if (r106 == false) goto L29;
        r102 = r102 - 1;
        goto L14
    L23:
        if (r106 == false) goto L24;
        r103 = r103 + 1;
        goto L14
    L24:
        r104 = true;
        goto L14
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = r102;
    L29:
        String r107 = r100.subSequence(r103, r102 + 1).toString();
        if (StringsKt.startsWith$default(r107, "{", false, 2, null) == false) goto L35;
        if (StringsKt.endsWith$default(r107, com.alipay.sdk.m.u.i.f25855d, false, 2, null) == false) goto L35;
    L38:
        return true;
    L35:
        if (StringsKt.startsWith$default(r107, "[", false, 2, null) == true) goto L37;
        return false;
    L37:
        if (StringsKt.endsWith$default(r107, "]", false, 2, null) == true) goto L38;
        return false;
    L50:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
