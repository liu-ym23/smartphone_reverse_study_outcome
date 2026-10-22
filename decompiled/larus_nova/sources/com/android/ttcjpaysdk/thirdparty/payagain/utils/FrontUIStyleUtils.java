package com.android.ttcjpaysdk.thirdparty.payagain.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J<\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J*\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/utils/FrontUIStyleUtils;", "", "()V", "updateFillLabel", "", "view", "Landroid/widget/TextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "updateLabel", "textColor", "", "strokeColor", "bgColor", "corner", "", "updateLabelStyle", "isEnable", "", "maxCorner", "", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FrontUIStyleUtils {
    public static final FrontUIStyleUtils INSTANCE = null;

    static {
        INSTANCE = new FrontUIStyleUtils();
    }

    private FrontUIStyleUtils() {
    }

    private final void updateFillLabel(TextView r100, Context r110) {
        if (r100 == null) goto L19;
        if (r110 == null) goto L21;
        int r101 = CJPayBasicUtils.dipToPX(r110, 2.0f);
        Drawable r102 = r100.getBackground();
        if ((r102 instanceof GradientDrawable) == false) goto L8;
        GradientDrawable r103 = (GradientDrawable) r102;
    L9:
        r100.setGravity(16);
        int r104 = CJPayBasicUtils.dipToPX(r110, 4.0f);
        r100.setPadding(r104, 0, r104, 0);
        r100.getLayoutParams().height = CJPayBasicUtils.dipToPX(r110, 16.0f);
        if (r103 == null) goto L20;
        r103.setColor(ColorProtector.parseColor("#ffffff"));
        r100.setTextColor(Color.parseColor(CJPayColorConstants.CJ_PAY_RED));     // Catch: Exception -> L14
        r103.setStroke(CJPayBasicUtils.dipToPX(r110, 0.5f), Color.parseColor(CJPayColorConstants.CJ_PAY_STROKE_RED));     // Catch: Exception -> L14
        r103.setCornerRadius(r101);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FrontUIStyleUtils#updateFillLabel", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FrontUIStyleUtils#updateFillLabel", e);
        r100.setTextColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        r103.setStroke(CJPayBasicUtils.dipToPX(r110, 0.5f), ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_STROKE_RED));
        r103.setCornerRadius(r101);
        return;
    L20:
        return;
    L8:
        r103 = null;
        goto L9
    L21:
        return;
    }

    public final void updateLabelStyle(TextView r100, Context r101, boolean r110, int r111) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L11;
        if (r110 == false) goto L7;
        updateFillLabel(r100, r101);
        return;
    L7:
        updateLabel(r100, r101, CJPayColorConstants.CJ_PAY_GRAY, "#57c8cad0", "#57c8cad0", 2.0f);
        return;
    L11:
        return;
    }

    private final void updateLabel(TextView r100, Context r101, String r102, String r103, String r104, float r105) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L15;
        Drawable r106 = r100.getBackground();
        if ((r106 instanceof GradientDrawable) == false) goto L8;
        GradientDrawable r107 = (GradientDrawable) r106;
    L9:
        r100.setTextColor(ColorProtector.parseColor(r102));
        if (r107 == null) goto L14;
        r107.setStroke(CJPayBasicUtils.dipToPX(r101, 0.5f), ColorProtector.parseColor(r103));
        r107.setColor(ColorProtector.parseColor(r104));
        r107.setCornerRadius(CJPayBasicUtils.dipToPX(r101, r105));
        return;
    L14:
        return;
    L8:
        r107 = null;
        goto L9
    L15:
        return;
    }
}
