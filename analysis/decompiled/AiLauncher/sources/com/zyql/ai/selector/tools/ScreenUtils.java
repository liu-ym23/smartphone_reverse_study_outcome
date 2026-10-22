package com.zyql.ai.selector.tools;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;

/* loaded from: classes4.dex */
public class ScreenUtils {
    public static int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - getStatusBarHeight(context);
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a);
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize == 0 ? dip2px(context, 25.0f) : dimensionPixelSize;
    }
}
