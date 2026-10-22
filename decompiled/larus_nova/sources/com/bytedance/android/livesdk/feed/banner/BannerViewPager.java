package com.bytedance.android.livesdk.feed.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.uikit.rtl.RtlViewPager;
import com.bytedance.android.livesdkapi.view.ISupportNestedScrollViewPager;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes8.dex */
public class BannerViewPager extends RtlViewPager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f123642d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f123643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f123644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MotionEvent f123645c;

    private ISupportNestedScrollViewPager getParentViewPager() {
        ViewParent r100 = this;
    L3:
        if (r100 == null) goto L8;
        if ((r100 instanceof ISupportNestedScrollViewPager) == true) goto L8;
        r100 = r100.getParent();
    L8:
        return (ISupportNestedScrollViewPager) r100;
    }

    public final void i() {
        if (this.f123643a == false) goto L5;
        return;
    L5:
        Logger.d("BannerViewPager", "enableParent");
        this.f123643a = true;
        ISupportNestedScrollViewPager r100 = getParentViewPager();
        if (r100 == null) goto L11;
        Boolean r101 = this.f123644b;
        if (r101 == null) goto L12;
        r100.supportNestViewPagerNoScroll(r101.booleanValue());
        this.f123644b = null;
        return;
    L12:
        return;
    }

    public final void h() {
        if (getChildCount() > 1) goto L6;
        return;
    L6:
        if (this.f123643a == true) goto L8;
        return;
    L8:
        Logger.d("BannerViewPager", "disableParent");
        this.f123643a = false;
        ISupportNestedScrollViewPager r100 = getParentViewPager();
        if (r100 != null) goto L11;
        return;
    L11:
        if (this.f123644b != null) goto L13;
        this.f123644b = Boolean.valueOf(r100.isSupportNestViewPagerNoScroll());
    L13:
        r100.supportNestViewPagerNoScroll(false);
    }

    public BannerViewPager(Context r100) {
        super(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        boolean r101 = super.onInterceptTouchEvent(r100);
        if (r100.getAction() != 0) goto L6;
        h();
    L10:
        this.f123645c = r100;
        return r101;
    L6:
        if (r100.getAction() != 2) goto L9;
        if (r101 == false) goto L10;
        h();
        goto L10
    L9:
        i();
        goto L10
    }

    @Override // com.bytedance.android.live.uikit.rtl.RtlViewPager, androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        super.setOnPageChangeListener(r100);
    }

    public BannerViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
