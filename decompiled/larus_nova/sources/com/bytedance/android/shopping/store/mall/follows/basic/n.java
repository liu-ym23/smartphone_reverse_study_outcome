package com.bytedance.android.shopping.store.mall.follows.basic;

import android.view.View;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: classes14.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseFollowStoreStatusPresenter f185614a;

    public n(BaseFollowStoreStatusPresenter r100) {
        this.f185614a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BaseFollowStoreViewModel.loadData$default((BaseFollowStoreViewModel) this.f185614a.f185578g.getValue(), LoadStatus.RefreshWhenError, null, false, null, 14, null);
    }
}
