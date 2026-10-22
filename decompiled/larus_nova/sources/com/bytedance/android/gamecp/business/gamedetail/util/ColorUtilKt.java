package com.bytedance.android.gamecp.business.gamedetail.util;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ColorUtilKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f55615a = null;

    static {
        f55615a = PatternProtector.compile("rgba\\(([\\d]+),[\\s]*([\\d]+),[\\s]*([\\d]+),[\\s]*((0?.)?[\\d]+)\\)", 0);
    }

    public static final String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$rgba2Argb");
        ColorUtilKt$rgba2Argb$1 r100 = ColorUtilKt$rgba2Argb$1.INSTANCE;
        if (r110.length() >= 3) goto L6;
        return r110;
    L6:
        if (r110.charAt(0) != '#') goto L8;
        String r101 = StringsKt.drop(r110, 1);
    L9:
        int r102 = r101.length();
        if (r102 != 3) goto L12;
        StringBuilder r111 = new StringBuilder("#FF");
        int r103 = 0;
    L65:
        if (r103 >= r101.length()) goto L71;
        char r104 = r101.charAt(r103);
        int r105 = 0;
    L67:
        if (r105 >= 2) goto L69;
        r111.append(r104);
        r105 = r105 + 1;
        goto L67
    L69:
        r103 = r103 + 1;
        goto L65
    L71:
        return r111.toString();
    L12:
        if (r102 != 4) goto L14;
        StringBuilder r112 = new StringBuilder("#");
        String r106 = StringsKt.takeLast(r101, 1);
        int r107 = 0;
    L50:
        if (r107 >= r106.length()) goto L55;
        char r108 = r106.charAt(r107);
        int r109 = 0;
    L52:
        if (r109 >= 2) goto L54;
        r112.append(r108);
        r109 = r109 + 1;
        goto L52
    L54:
        r107 = r107 + 1;
        goto L50
    L55:
        String r113 = StringsKt.dropLast(r101, 1);
        int r114 = 0;
    L57:
        if (r114 >= r113.length()) goto L85;
        char r115 = r113.charAt(r114);
        int r116 = 0;
    L59:
        if (r116 >= 2) goto L61;
        r112.append(r115);
        r116 = r116 + 1;
        goto L59
    L61:
        r114 = r114 + 1;
        goto L57
    L85:
        return r112.toString();
    L14:
        if (r102 == 6) goto L84;
        if (r102 == 8) goto L83;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L19
        Object r118 = Result.m9449constructorimpl(f55615a.matcher(r101));     // Catch: Throwable -> L19
    L21:
        Integer r119 = null;
        if (Result.m9455isFailureimpl(r118) == false) goto L24;
        r118 = null;
    L24:
        Matcher r120 = (Matcher) r118;
        if (r120 != null) goto L27;
        return r110;
    L27:
        if (r120.matches() == false) goto L81;
        String r121 = r120.group(1);
        if (r121 == null) goto L31;
        Integer r122 = Integer.valueOf(CastIntegerProtector.parseInt(r121));
    L32:
        String r123 = r120.group(2);
        if (r123 == null) goto L35;
        Integer r124 = Integer.valueOf(CastIntegerProtector.parseInt(r123));
    L36:
        String r125 = r120.group(3);
        if (r125 == null) goto L39;
        r119 = Integer.valueOf(CastIntegerProtector.parseInt(r125));
    L39:
        String r126 = r120.group(4);
        if (r126 == null) goto L44;
        Double r127 = StringsKt.toDoubleOrNull(r126);
        if (r127 == null) goto L44;
        double r128 = r127.doubleValue();
    L82:
        return "#" + r100.invoke2(Integer.valueOf((int) StrictMath.floor(r128 * ((double) 255)))) + r100.invoke2(r122) + r100.invoke2(r124) + r100.invoke2(r119);
    L44:
        r128 = 1.0d;
        goto L82
    L35:
        r124 = null;
        goto L36
    L31:
        r122 = null;
        goto L32
    L81:
        return r110;
    L19:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L83:
        return "#" + StringsKt.takeLast(r101, 2) + StringsKt.dropLast(r101, 2);
    L84:
        return "#FF".concat(r101);
    L8:
        r101 = r110;
        goto L9
    }
}
