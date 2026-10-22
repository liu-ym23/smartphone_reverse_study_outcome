package com.android.ttcjpaysdk.thirdparty.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayStyleUtils {
    public CJPayStyleUtils() {
    }

    public static Activity getActivityFromView(View r100) {
        if (r100 == null) goto L11;
        Context r101 = r100.getContext();
    L5:
        if ((r101 instanceof ContextWrapper) == false) goto L15;
        if ((r101 instanceof Activity) == true) goto L9;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L5
    L9:
        return (Activity) r101;
    L15:
        return null;
    L11:
        return null;
    }

    public static int getAgreementColorFromSettings(Context r100) {
        String r101 = CJPayThemeManager.getInstance().getThemeInfo().themeType;     // Catch: Exception -> L11
        String r102 = CJPayThemeManager.getInstance().getThemeInfo().agreementTextInfo.textColor;     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r101) == true) goto L10;
        if (TextUtils.isEmpty(r102) == true) goto L10;
        return Color.parseColor(r102);
    L10:
        return ContextCompat.getColor(r100, R.color.cj_pay_color_blue_agreement);
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayStyleUtils#getAgreementColorFromSettings", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayStyleUtils#getAgreementColorFromSettings", e);
        return ContextCompat.getColor(r100, R.color.cj_pay_color_blue_agreement);
    }

    public static void updateViewByButtonColor(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setBackgroundColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
    }

    public static void setViewEnable(TextView r100, boolean r101, boolean r102, int r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == false) goto L7;
        r100.setVisibility(0);
    L8:
        r100.setEnabled(r101);
        r100.setTextColor(ColorProtector.parseColor("#ffffff"));
        GradientDrawable r104 = (GradientDrawable) r100.getBackground();
        if (r101 == false) goto L11;
        r104.setColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        r104.setStroke(CJPayBasicUtils.dipToPX(r100.getContext(), 0.5f), ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
    L12:
        float r105 = 0;
        r104.setCornerRadii(new float[]{r105, r105, r105, r105, r105, r105, r105, r105});
        return;
    L11:
        String r106 = "#4D" + CJPayColorConstants.CJ_PAY_RED.split("#")[1];
        r104.setColor(ColorProtector.parseColor(r106));
        r104.setStroke(CJPayBasicUtils.dipToPX(r100.getContext(), 0.5f), ColorProtector.parseColor(r106));
        goto L12
    L7:
        r100.setVisibility(8);
        goto L8
    }
}
