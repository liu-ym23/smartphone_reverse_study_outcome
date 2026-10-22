package com.bytedanceos.common.ui.widget.guide.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;

/* JADX INFO: loaded from: classes2.dex */
public class GuideScreenUtils {
    private GuideScreenUtils() {
        throw new AssertionError();
    }

    public static int dp2px(Context r10, int r11) {
        return (int) (r11 * r10.getResources().getDisplayMetrics().density);
    }

    public static int getNavigationBarHeight(Activity r10) {
        int r11 = 0;
        if (isNavigationBarShow(r10) == true) goto L5;
        return 0;
    L5:
        Resources r12 = r10.getResources();
        int r13 = r12.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r13 <= 0) goto L8;
        r11 = r12.getDimensionPixelSize(r13);
    L8:
        GuideLogUtil.i("NavigationBar的高度:" + r11);
        return r11;
    }

    public static int getScreenHeight(Context r10) {
        return r10.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context r10) {
        return r10.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context r10) {
        int r11 = dp2px(r10, 20);
        GuideLogUtil.i("common statusBar height:" + r11);
        int r12 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r12 <= 0) goto L5;
        r11 = r10.getResources().getDimensionPixelSize(r12);
        GuideLogUtil.i("real statusBar height:" + r11);
    L5:
        GuideLogUtil.i("finally statusBar height:" + r11);
        return r11;
    }

    public static boolean isNavigationBarShow(Activity r10) {
        Display r11 = r10.getWindowManager().getDefaultDisplay();
        Point r12 = new Point();
        Point r13 = new Point();
        r11.getSize(r12);
        r11.getRealSize(r13);
        if (r13.y == r12.y) goto L5;
        return true;
    L5:
        return false;
    }
}
