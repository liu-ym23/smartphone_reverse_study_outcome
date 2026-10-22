package com.bytedance.android.shopping.anchorv3.auction.data;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.bytedance.android.shopping.anchorv3.auction.AnchorV3AuctionOfferRecordsFragment;
import com.bytedance.android.shopping.anchorv3.auction.data.remote.AuctionOfferRecordsPagingDataSource;
import i53.b;
import j53.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/data/AuctionOfferRecordsDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lj53/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionOfferRecordsDataSourceFactory extends DataSource.Factory<Integer, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<AuctionOfferRecordsPagingDataSource> f164461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnchorV3AuctionOfferRecordsFragment.OfferRecordsParams f164462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f164463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.ec.core.async.b f164464d;

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, a> create() {
        AuctionOfferRecordsPagingDataSource r100 = new AuctionOfferRecordsPagingDataSource(this.f164462b, this.f164463c, this.f164464d);
        this.f164461a.postValue(r100);
        return r100;
    }

    public AuctionOfferRecordsDataSourceFactory(AnchorV3AuctionOfferRecordsFragment.OfferRecordsParams r100, b r101, com.bytedance.android.ec.core.async.b r102) {
        Intrinsics.checkNotNullParameter(r100, "offerRecordsParams");
        Intrinsics.checkNotNullParameter(r101, "remoteDataSource");
        Intrinsics.checkNotNullParameter(r102, "disposableScope");
        this.f164462b = r100;
        this.f164463c = r101;
        this.f164464d = r102;
        this.f164461a = new MutableLiveData();
    }
}
