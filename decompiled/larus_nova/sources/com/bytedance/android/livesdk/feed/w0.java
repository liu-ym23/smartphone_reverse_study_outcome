package com.bytedance.android.livesdk.feed;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: classes8.dex */
public final class w0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveDrawerPagerSlidingTabStrip f124579a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f124579a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LiveDrawerPagerSlidingTabStrip r100 = this.f124579a;
        r100.f123526h = r100.f123524f.getCurrentItem();
        LiveDrawerPagerSlidingTabStrip r101 = this.f124579a;
        int r102 = r101.f123526h;
        int r103 = r101.f123523e.getChildCount();
        if (r103 == 0) goto L21;
        if (r102 < 0) goto L21;
        if (r102 >= r103) goto L21;
        View r104 = r101.f123523e.getChildAt(r102);
        r104.setSelected(true);
        Object r105 = r104.getTag();
        if ((r105 instanceof LiveDrawerPagerSlidingTabStrip.d) == false) goto L21;
        LiveDrawerPagerSlidingTabStrip.d r106 = (LiveDrawerPagerSlidingTabStrip.d) r105;
        String r107 = r101.F.get(r102);
        if (TextUtils.isEmpty(r107) == true) goto L16;
        View r108 = r106.f123550c;
        if ((r108 instanceof HSImageView) == false) goto L16;
        r108.setVisibility(0);
        ImageLoader.bindImage((HSImageView) r106.f123550c, r107);
    L16:
        if (TextUtils.isEmpty(r101.G.get(r102)) == true) goto L19;
        r106.f123548a.setTextColor(s1.i(r101.G.get(r102), r101.f123532n));
    L19:
        if (r101.M != 1) goto L21;
        r106.f123548a.setTypeface(Typeface.DEFAULT_BOLD);
    L21:
        LiveDrawerPagerSlidingTabStrip r109 = this.f124579a;
        LiveDrawerPagerSlidingTabStrip.a(r109, r109.f123526h, 0);
    }

    public w0(LiveDrawerPagerSlidingTabStrip r100) {
        this.f124579a = r100;
    }
}
