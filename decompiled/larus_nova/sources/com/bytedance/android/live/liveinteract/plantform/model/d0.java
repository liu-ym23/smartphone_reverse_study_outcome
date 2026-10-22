package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d0 {
    public static final Spannable a(c0 r100, Spannable r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$wrapperText");
        Intrinsics.checkNotNullParameter(r101, "eventInfo");
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_PLACEHOLDER);
        Intrinsics.checkNotNullParameter(r100, "$this$needPlaceHolder");
        boolean r103 = true;
        if (r100.getEventInfoType() != 2) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
    L40:
        return r101;
    L10:
        if (r102.length() != 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L40;
        if (r101.length() != 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L21;
        SpannableStringBuilder r107 = new SpannableStringBuilder();
        Intrinsics.checkNotNullParameter(r100, "$this$isEcom");
        if (r100.getEventInfoType() != 5) goto L25;
    L28:
        boolean r108 = true;
    L30:
        if (r108 == true) goto L38;
        Intrinsics.checkNotNullParameter(r100, "$this$isRecommend");
        if (r100.getEventInfoType() == 8) goto L35;
        r103 = false;
    L35:
        if (r103 == true) goto L38;
        r107.append(r102 + " | ");
        r107.append(r101);
    L39:
        return r107;
    L38:
        r107.append(r101);
        r107.append(" | " + r102);
        goto L39
    L25:
        if (r100.getEventInfoType() == 6) goto L28;
        r108 = false;
        goto L30
    L21:
        return new SpannableString(r102);
    L18:
        r106 = false;
        goto L19
    L12:
        r105 = false;
        goto L13
    L5:
        if (r100.getEventInfoType() == 4) goto L7;
        r104 = true;
        goto L8
    }
}
