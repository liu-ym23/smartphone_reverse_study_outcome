package com.android.ttcjpaysdk.base.ui.Utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayFontUtils {
    private static final String DOU_YIN_MEDIUM_FONT = "font/cj_pay_number_condensed_medium.otf";
    private static Typeface douYinMediumTypeface;

    public CJPayFontUtils() {
    }

    public static Typeface getTypefaceDouYinMedium(Context r100) {
    L6:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFontUtils#getTypefaceDouYinMedium", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFontUtils#getTypefaceDouYinMedium", th);
    L9:
        return douYinMediumTypeface;
    L3:
        if (douYinMediumTypeface != null) goto L9;
        douYinMediumTypeface = Typeface.createFromAsset(r100.getAssets(), DOU_YIN_MEDIUM_FONT);     // Catch: Throwable -> L6
        goto L9
    }

    public static void setDouYinMediumTypeface(Context r100, Paint r101) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L16;
    L9:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFontUtils#setDouYinMediumTypeface", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFontUtils#setDouYinMediumTypeface", th);
    L11:
        r101.setTypeface(douYinMediumTypeface);
        return;
    L6:
        if (douYinMediumTypeface != null) goto L11;
        douYinMediumTypeface = Typeface.createFromAsset(r100.getAssets(), DOU_YIN_MEDIUM_FONT);     // Catch: Throwable -> L9
        goto L11
    L16:
        return;
    }

    public static void setDouYinMediumTypeface(Context r100, TextView r101) {
    L6:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFontUtils#setDouYinMediumTypeface", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFontUtils#setDouYinMediumTypeface", th);
    L8:
        r101.setTypeface(douYinMediumTypeface);
        return;
    L3:
        if (douYinMediumTypeface != null) goto L8;
        douYinMediumTypeface = Typeface.createFromAsset(r100.getAssets(), DOU_YIN_MEDIUM_FONT);     // Catch: Throwable -> L6
        goto L8
    }
}
