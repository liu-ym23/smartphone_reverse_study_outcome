package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter.ScrollingLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements PagerSnapScrollListener.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECFloatWindowCarouselPresenter f152150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScrollingLinearLayoutManager f152151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f152152c;

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void a(int r100, float r101) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void onPageScrollStateChanged(int r100) {
        if (r100 != 1) goto L6;
        this.f152150a.F(false);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener.a
    public final void onPageSelected(int r100) {
        ECFloatWindowCarouselPresenter r101 = this.f152150a;
        ECFloatWindowCarouselPresenter.D(r101, this.f152151b, this.f152152c, r101.E());
    }

    public b(ECFloatWindowCarouselPresenter r100, ScrollingLinearLayoutManager r101, RecyclerView r102) {
        this.f152150a = r100;
        this.f152151b = r101;
        this.f152152c = r102;
    }
}
