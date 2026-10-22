package com.bytedance.android.live.uikit.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes7.dex */
public class InScrollViewPager extends SSViewPager {
    public InScrollViewPager(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.android.live.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction() & 255;
        if (r101 != 0) goto L5;
    L13:
        ViewParent r102 = getParent();
        if (r102 == null) goto L16;
        r102.requestDisallowInterceptTouchEvent(true);
    L16:
        super.onTouchEvent(r100);
        return true;
    L5:
        if (r101 == 2) goto L13;
        if (r101 != 1) goto L9;
    L10:
        ViewParent r103 = getParent();
        if (r103 == null) goto L16;
        r103.requestDisallowInterceptTouchEvent(false);
        goto L16
    L9:
        if (r101 != 3) goto L16;
        goto L10
    }

    public InScrollViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
