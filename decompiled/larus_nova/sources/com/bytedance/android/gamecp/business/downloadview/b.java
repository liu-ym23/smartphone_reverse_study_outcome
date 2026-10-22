package com.bytedance.android.gamecp.business.downloadview;

import android.graphics.Color;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.lynx.react.bridge.ReadableMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    static {
    }

    public static Integer a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L19;
        return null;
    L19:
        if (r100.length() != 9) goto L15;
        int r102 = Color.parseColor("#" + r100.subSequence(7, 9) + r100.subSequence(1, 7));     // Catch: Exception -> L18
    L16:
        return Integer.valueOf(r102);
    L15:
        r102 = Color.parseColor(r100);     // Catch: Exception -> L18
    L21:
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static e c(ReadableMap r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L22
        if (r110 == null) goto L20;
        String r101 = r110.getString("icon", "");     // Catch: Throwable -> L22
        int r102 = r110.getInt("width", 18);     // Catch: Throwable -> L22
        int r103 = r110.getInt("height", 18);     // Catch: Throwable -> L22
        boolean r104 = false;
        int r105 = r110.getInt("rightMargin", 0);     // Catch: Throwable -> L22
        int r106 = r110.getInt("leftMargin", 0);     // Catch: Throwable -> L22
        int r107 = r110.getInt("topMargin", 0);     // Catch: Throwable -> L22
        int r108 = r110.getInt("bottomMargin", 0);     // Catch: Throwable -> L22
        int r111 = r110.getInt("adaptBigFont", 1);     // Catch: Throwable -> L22
        if (r101.length() <= 0) goto L7;
        r104 = true;
    L7:
        if (r104 == false) goto L20;
        if (r102 == 0) goto L20;
        if (r103 == 0) goto L20;
        if (r111 != 1) goto L13;
        int r109 = UtilityKotlinExtentionsKt.e(r102);     // Catch: Throwable -> L22
    L14:
        int r112 = r109;
        if (r111 != 1) goto L17;
        int r113 = UtilityKotlinExtentionsKt.e(r103);     // Catch: Throwable -> L22
    L18:
        int r114 = r113;
        return new e(r101, r112, r114, UtilityKotlinExtentionsKt.c(r105), UtilityKotlinExtentionsKt.c(r106), UtilityKotlinExtentionsKt.c(r107), UtilityKotlinExtentionsKt.c(r108));
    L17:
        r113 = UtilityKotlinExtentionsKt.c(r103);     // Catch: Throwable -> L22
        goto L18
    L13:
        r109 = UtilityKotlinExtentionsKt.c(r102);     // Catch: Throwable -> L22
    L20:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
        return null;
    L22:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static h d(ReadableMap r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L14
        if (r110 == null) goto L12;
        String r101 = r110.getString("text", "");     // Catch: Throwable -> L14
        int r102 = r110.getInt("textSize", 15);     // Catch: Throwable -> L14
        int r103 = r110.getInt("textSizeUnit", 2);     // Catch: Throwable -> L14
        boolean r104 = false;
        int r105 = r110.getInt("textFontWeight", 0);     // Catch: Throwable -> L14
        Integer r106 = a(r110.getString("textColor", ""));     // Catch: Throwable -> L14
        int r107 = r110.getInt("leftMargin", 0);     // Catch: Throwable -> L14
        int r108 = r110.getInt("rightMargin", 0);     // Catch: Throwable -> L14
        int r109 = r110.getInt("topMargin", 0);     // Catch: Throwable -> L14
        int r111 = r110.getInt("bottomMargin", 0);     // Catch: Throwable -> L14
        if (r101.length() <= 0) goto L8;
        r104 = true;
    L8:
        if (r104 == false) goto L12;
        if (r102 == 0) goto L12;
        return new h(r101, r102, r103, r105, r106, UtilityKotlinExtentionsKt.c(r107), UtilityKotlinExtentionsKt.c(r108), UtilityKotlinExtentionsKt.c(r109), UtilityKotlinExtentionsKt.c(r111));
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return null;
    L14:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static d b(String r110, ReadableMap r111) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "data");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L24
        ReadableMap r101 = r111.getMap(r110);     // Catch: Throwable -> L24
        yr.c.e("LynxDownload", "parseDownloadButtonInfo: " + r110 + " \n " + r101);     // Catch: Throwable -> L24
        if (r101 == null) goto L22;
        h r102 = d(r101.getMap(com.bytedance.android.livesdk.gift.model.n.KEY_MAIN_TEXT));     // Catch: Throwable -> L24
        h r103 = d(r101.getMap(com.bytedance.android.livesdk.gift.model.n.KEY_SUB_TEXT));     // Catch: Throwable -> L24
        e r104 = c(r101.getMap("mainTextPrefixIcon"));     // Catch: Throwable -> L24
        Integer r105 = a(r101.getString("backgroundColor", ""));     // Catch: Throwable -> L24
        if (r101.isNull("backgroundRadius") == false) goto L8;
        Integer r106 = null;
    L9:
        Integer r107 = a(r101.getString("progressBackgroundColor", ""));     // Catch: Throwable -> L24
        Integer r112 = a(r101.getString("progressColor", ""));     // Catch: Throwable -> L24
        if (r101.isNull("progressRadius") == false) goto L12;
        Integer r108 = null;
    L14:
        if (r106 == null) goto L16;
        Integer r113 = Integer.valueOf(UtilityKotlinExtentionsKt.c(r106.intValue()));     // Catch: Throwable -> L24
    L17:
        if (r108 == null) goto L19;
        Integer r114 = Integer.valueOf(UtilityKotlinExtentionsKt.c(r108.intValue()));     // Catch: Throwable -> L24
    L21:
        return new d(r110, r102, r103, r104, r105, r113, r107, r112, r114);
    L19:
        r114 = null;
        goto L21
    L16:
        r113 = null;
        goto L17
    L12:
        r108 = Integer.valueOf(r101.getInt("progressRadius", 4));     // Catch: Throwable -> L24
        goto L14
    L8:
        r106 = Integer.valueOf(r101.getInt("backgroundRadius", 4));     // Catch: Throwable -> L24
        goto L9
    L22:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        return null;
    L24:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }
}
