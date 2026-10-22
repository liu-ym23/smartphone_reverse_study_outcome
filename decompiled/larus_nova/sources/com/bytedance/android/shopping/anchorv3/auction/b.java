package com.bytedance.android.shopping.anchorv3.auction;

import com.bytedance.android.ec.core.data.PagingLoadingStatus;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes12.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuctionOfferRecordsFooterViewHolder f164459a;

    public b(AuctionOfferRecordsFooterViewHolder r100) {
        this.f164459a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        AuctionOfferRecordsFooterViewHolder r101 = this.f164459a;
        int r102 = AuctionOfferRecordsFooterViewHolder.f164447e;
        r101.T3((PagingLoadingStatus) r100);
    }
}
