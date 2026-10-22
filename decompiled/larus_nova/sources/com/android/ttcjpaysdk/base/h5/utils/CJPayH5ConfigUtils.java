package com.android.ttcjpaysdk.base.h5.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayH5ConfigUtils {
    public static String TITLE_LEFT_ICON_CLOSE = "close";

    public CJPayH5ConfigUtils() {
    }

    private static Bitmap drawColourfulArrowBg(Context r100, String r101, int r102, int r103) {
        return drawColourBg(r100, r101, r102, r103, R.drawable.cj_pay_icon_titlebar_left_arrow);
    }

    private static Bitmap drawColourfulCloseBg(Context r100, String r101, int r102, int r103) {
        return drawColourBg(r100, r101, r102, r103, R.drawable.cj_pay_icon_titlebar_left_close);
    }

    public static Bitmap drawColourBg(Context r100, String r101, int r102, int r103, int r104) {
        Bitmap r105 = Bitmap.createBitmap(r102, r103, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L4
        Canvas r106 = new Canvas(r105);     // Catch: Exception -> L4
        Paint r107 = new Paint(1);     // Catch: Exception -> L4
        r107.setColor(Color.parseColor(r101));     // Catch: Exception -> L4
        r106.drawRoundRect(new RectF(0.0f, 0.0f, r102, r103), 0.0f, 0.0f, r107);     // Catch: Exception -> L4
        r107.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));     // Catch: Exception -> L4
        r106.drawBitmap(BitmapFactory.decodeResource(r100.getResources(), r104), 0.0f, 0.0f, r107);     // Catch: Exception -> L4
        return r105;
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayH5ConfigUtils#drawColourBg", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayH5ConfigUtils#drawColourBg", e);
        return null;
    }

    public static Bitmap drawTitleBarLeftIcon(Context r100, String r101, String r102, int r103, int r104) {
        if (TITLE_LEFT_ICON_CLOSE.equals(r101) == false) goto L6;
        return drawColourfulCloseBg(r100, r102, r103, r104);
    L6:
        return drawColourfulArrowBg(r100, r102, r103, r104);
    }
}
