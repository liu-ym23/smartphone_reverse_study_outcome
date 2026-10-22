package com.bytedance.android.shopping.anchorv3.detail.utils;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class BannerRenderHelper {
    static {
    }

    @JvmStatic
    public static final void a(TextView r100, final PromotionProductBannerStruct r101, final boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "banner");
        final Context r102 = th.a.e(r100.getContext(), true);
        if (r101.getIcon() != null) goto L5;
        int r103 = 0;
    L6:
        r100.setPadding(r103, 0, b.b(4), 0);
        r100.setTextSize(2, 12.0f);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r101.getTextColor())));     // Catch: Throwable -> L9
    L11:
        Object r106 = null;
        if (Result.m9455isFailureimpl(r105) == false) goto L14;
        r105 = null;
    L14:
        Integer r107 = (Integer) r105;
        if (r107 == null) goto L17;
        int r108 = r107.intValue();
    L18:
        r100.setTextColor(r108);
        Object r109 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r101.getDrawableLeftColor())));     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r109) == false) goto L26;
        r109 = null;
    L26:
        Integer r111 = (Integer) r109;
        if (r111 == null) goto L30;
        int r112 = r111.intValue();
    L29:
        final int r113 = r112;
        Object r114 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r101.getDrawableRightColor())));     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r114) == true) goto L41;
        r106 = r114;
    L41:
        Integer r115 = (Integer) r106;
        if (r115 == null) goto L45;
        int r116 = r115.intValue();
    L44:
        final int r117 = r116;
        r100.setBackground(com.bytedance.commerce.base.drawable.a.a(new BannerRenderHelper$setTextStyle$2(r101, r110, r102, r113, r117)));
        return;
    L45:
        if (r110 == false) goto L47;
        r116 = ContextCompat.getColor(r102, R.color.transparent);
        goto L44
    L47:
        r116 = ContextCompat.getColor(r102, R.color.transparent);
    L35:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L30:
        if (r110 == false) goto L32;
        r112 = ContextCompat.getColor(r102, R.color.transparent);
        goto L29
    L32:
        r112 = ContextCompat.getColor(r102, R.color.transparent);
    L21:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L17:
        r108 = ContextCompat.getColor(r102, R.color.black);
    L9:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L5:
        r103 = b.b(4);
        goto L6
    }
}
