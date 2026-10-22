package com.bytedance.android.livesdk.widget;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes11.dex */
public final class f1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePagerSlidingTabStrip f161699a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f161699a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LivePagerSlidingTabStrip r100 = this.f161699a;
        r100.f161055h = r100.f161053f.getCurrentItem();
        LivePagerSlidingTabStrip r101 = this.f161699a;
        LivePagerSlidingTabStrip.a(r101, r101.f161055h, true);
        LivePagerSlidingTabStrip r102 = this.f161699a;
        LivePagerSlidingTabStrip.b(r102, r102.f161055h, 0);
    }

    public f1(LivePagerSlidingTabStrip r100) {
        this.f161699a = r100;
    }
}
