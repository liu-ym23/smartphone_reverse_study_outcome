package com.android.ttcjpaysdk.base.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import ue4.b;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayThemeUtils {
    public CJPayThemeUtils() {
    }

    public static int getLinkLightColor() {
        int r100 = ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED);
        return Color.parseColor(CJPayThemeManager.getInstance().getThemeInfo().linkTextInfo.textColor);
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayThemeUtils#getLinkLightColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayThemeUtils#getLinkLightColor", e);
        return r100;
    }

    public static int getColor(Context r100, int r101) {
        TypedArray r102 = r100.obtainStyledAttributes(new int[]{r101});
        int r103 = r102.getColor(0, -1);
        r102.recycle();
        return r103;
    }

    public static Drawable getDrawable(Context r100, int r101) {
        TypedArray r102 = r100.obtainStyledAttributes(new int[]{r101});
        Drawable r103 = r102.getDrawable(0);
        r102.recycle();
        return r103;
    }

    public static int getDrawableResId(Context r100, int r101) {
        TypedArray r102 = r100.obtainStyledAttributes(new int[]{r101});
        int r103 = r102.getResourceId(0, 0);
        r102.recycle();
        return r103;
    }

    public static int getColor(Context r100, int r101, int r102) {
        TypedArray r103 = r100.obtainStyledAttributes(new int[]{r101});
        Integer r104 = b.a(r100, r102);
        int r105 = r103.getColor(0, -1);
        if (r104 == null) goto L5;
        r105 = r104.intValue();
    L5:
        int r106 = r103.getColor(0, r105);
        r103.recycle();
        return r106;
    }

    public static int getColorWithDefaultColor(Context r100, int r101, int r102) {
        TypedArray r103 = r100.obtainStyledAttributes(new int[]{r101});
        int r104 = r103.getColor(0, ContextCompat.getColor(r100, r102));
        r103.recycle();
        return r104;
    }
}
