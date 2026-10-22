package com.bytedanceos.common.ui.widget.guide.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class GuideViewUtils {
    private static final String FRAGMENT_CON = "NoSaveStateFrameLayout";

    public GuideViewUtils() {
    }

    public static Rect getLocationInView(View r10, View r11) {
        if (r11 == null) goto L36;
        if (r10 == null) goto L36;
        Context r12 = r11.getContext();
        if ((r12 instanceof Activity) == false) goto L7;
        View r13 = ((Activity) r12).getWindow().getDecorView();
    L8:
        Rect r14 = new Rect();
        Rect r15 = new Rect();
        if (r11 != r10) goto L12;
        r11.getHitRect(r14);
        return r14;
    L12:
        View r16 = r11;
    L13:
        if (r16 == r13) goto L33;
        if (r16 == r10) goto L33;
        GuideLogUtil.i("tmp class:" + r16.getClass().getSimpleName());
        r16.getHitRect(r15);
        GuideLogUtil.i("tmp hit Rect:" + r15);
        if (r16.getClass().getSimpleName().equals(FRAGMENT_CON) == true) goto L18;
        r14.left += r15.left;
        r14.top += r15.top;
    L18:
        r16 = (View) r16.getParent();
        if (r16 == null) goto L32;
        if ((r16.getParent() instanceof ScrollView) == false) goto L24;
        int r17 = ((ScrollView) r16.getParent()).getScrollY();
        GuideLogUtil.i("scrollY:" + r17);
        r14.top = r14.top - r17;
    L24:
        if ((r16.getParent() instanceof HorizontalScrollView) == false) goto L27;
        int r18 = ((HorizontalScrollView) r16.getParent()).getScrollX();
        GuideLogUtil.i("scrollX:" + r18);
        r14.left = r14.left - r18;
    L27:
        if (r16.getParent() == null) goto L13;
        if ((r16.getParent() instanceof ViewPager) == false) goto L13;
        r16 = (View) r16.getParent();
        goto L13
    L32:
        throw new IllegalArgumentException("the view is not showing in the window!");
    L33:
        r14.right = r14.left + r11.getMeasuredWidth();
        r14.bottom = r14.top + r11.getMeasuredHeight();
        return r14;
    L7:
        r13 = null;
    L36:
        throw new IllegalArgumentException("parent and child can not be null .");
    }
}
