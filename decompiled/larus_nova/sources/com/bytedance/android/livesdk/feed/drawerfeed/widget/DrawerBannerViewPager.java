package com.bytedance.android.livesdk.feed.drawerfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.livesdk.feed.banner.BannerViewPager;
import uv1.e;
import xs2.b;

/* JADX INFO: loaded from: classes8.dex */
public class DrawerBannerViewPager extends BannerViewPager {
    public DrawerBannerViewPager(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L6;
    L8:
        b.a().post(new e(1));
    L11:
        return super.dispatchTouchEvent(r100);
    L6:
        if (r101 == 3) goto L8;
    L9:
        b.a().post(new e(1));
        goto L11
    }

    public DrawerBannerViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
