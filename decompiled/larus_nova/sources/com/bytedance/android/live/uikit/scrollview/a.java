package com.bytedance.android.live.uikit.scrollview;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PagerSlidingTabStrip f102443a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f102443a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        PagerSlidingTabStrip r100 = this.f102443a;
        r100.f102420h = r100.f102418f.getCurrentItem();
        PagerSlidingTabStrip r101 = this.f102443a;
        PagerSlidingTabStrip.a(r101, r101.f102420h, 0);
    }

    public a(PagerSlidingTabStrip r100) {
        this.f102443a = r100;
    }
}
