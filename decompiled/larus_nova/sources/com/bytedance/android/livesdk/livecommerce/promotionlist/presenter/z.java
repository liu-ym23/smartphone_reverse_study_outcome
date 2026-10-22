package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.iron.ui.tab.CategoryExpandView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePromotionListTabPresenter f151059a;

    public z(LivePromotionListTabPresenter r100) {
        this.f151059a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    L21:
        return;
    L3:
        if (LivePromotionListTabPresenter.h0(this.f151059a).canScrollHorizontally(-1) == false) goto L5;
    L9:
        LivePromotionListTabPresenter r100 = this.f151059a;     // Catch: Throwable -> L13
        r100.f151001m = true;     // Catch: Throwable -> L13
        CategoryExpandView r101 = r100.f151000l;     // Catch: Throwable -> L13
        if (r101 == null) goto L18;
        r101.setVisibility(0);     // Catch: Throwable -> L13
    L18:
        return;
    L5:
        if (LivePromotionListTabPresenter.h0(this.f151059a).canScrollHorizontally(1) == true) goto L9;
        CategoryExpandView r102 = this.f151059a.f151000l;     // Catch: Throwable -> L13
        if (r102 == null) goto L18;
        r102.setVisibility(8);     // Catch: Throwable -> L13
        goto L18
    }
}
