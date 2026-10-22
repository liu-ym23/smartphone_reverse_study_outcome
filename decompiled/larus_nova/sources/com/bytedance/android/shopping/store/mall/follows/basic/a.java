package com.bytedance.android.shopping.store.mall.follows.basic;

import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements gqa.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseFollowRefreshPresenter f185594a;

    public a(BaseFollowRefreshPresenter r100) {
        this.f185594a = r100;
    }

    @Override // gqa.d
    public final void d2(cqa.h r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        final BaseFollowRefreshPresenter r101 = this.f185594a;
        r101.d0(true, false);
        BaseFollowStoreViewModel.loadData$default((BaseFollowStoreViewModel) r101.f185543f.getValue(), LoadStatus.Refresh, null, false, new BaseFollowRefreshPresenter$refresh$1(r101), 6, null);
    }
}
