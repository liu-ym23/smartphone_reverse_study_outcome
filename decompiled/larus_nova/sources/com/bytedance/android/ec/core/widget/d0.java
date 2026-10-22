package com.bytedance.android.ec.core.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d0 {
    public static final boolean a(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public static final String b(PriceView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$asDescription");
        StringBuilder r101 = new StringBuilder();
        if (a(r100.getPrefixText()) == false) goto L5;
        r101.append(r100.getPrefixText());
    L5:
        String r102 = c(r100.getPriceIntegerText(), r100.getPriceDecimalText());
        CharSequence r103 = null;
        if (a(r102) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        r101.append(r102);
    L11:
        String r104 = c(r100.getMaxPriceIntegerText(), r100.getMaxPriceDecimalText());
        if (a(r104) == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L18;
        r101.append(r104);
    L18:
        if (a(r100.getExtraText()) == false) goto L20;
        r103 = r101;
    L20:
        if (r103 == null) goto L23;
        r101.append(r103);
    L23:
        return r101.toString();
    }

    public static final String c(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        if (a(r100) == false) goto L5;
        r102.append(r100);
    L5:
        boolean r103 = true;
        if (a(r101) == false) goto L15;
        if (r102.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        r102.append("0");
    L13:
        r102.append(r101);
        goto L15
    L10:
        r104 = false;
    L15:
        if (r102.length() > 0) goto L18;
        r103 = false;
    L18:
        if (r103 == false) goto L21;
        r102.append("元");
    L21:
        return r102.toString();
    }
}
