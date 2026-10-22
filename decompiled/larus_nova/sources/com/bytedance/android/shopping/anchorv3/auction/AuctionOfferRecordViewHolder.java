package com.bytedance.android.shopping.anchorv3.auction;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/AuctionOfferRecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionOfferRecordViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f164443b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuctionOfferRecordItemPresenter f164444a;

    public static final class a {
    }

    static {
    }

    public AuctionOfferRecordViewHolder(AuctionOfferRecordItemView r100) {
        AuctionOfferRecordItemPresenter r101 = new AuctionOfferRecordItemPresenter(r100);
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "presenter");
        super(r100);
        this.f164444a = r101;
    }
}
