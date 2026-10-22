package com.bytedance.android.shopping.anchorv3.auction;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.data.PagingLoadingStatus;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/AuctionOfferRecordsFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionOfferRecordsFooterViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f164447e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f164448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECStatusView f164449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f164450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AuctionOfferRecordsViewModel f164451d;

    public static final class a {
    }

    static {
    }

    public final void T3(PagingLoadingStatus r100) {
        if (r100 == null) goto L13;
        int r101 = com.bytedance.android.shopping.anchorv3.auction.a.f164458a[r100.ordinal()];
        if (r101 != 1) goto L8;
        this.f164449b.c();
        this.f164448a.setVisibility(8);
        return;
    L8:
        if (r101 != 2) goto L10;
        this.f164449b.a();
        this.f164448a.setVisibility(8);
        UIUtils.displayToast(this.itemView.getContext(), R.string.shopping_fail_and_please_retry);
        return;
    L10:
        if (r101 != 3) goto L12;
        this.f164449b.a();
        this.f164448a.setVisibility(8);
        return;
    L12:
        if (r101 != 4) goto L13;
        this.f164449b.a();
        this.f164448a.setVisibility(0);
        return;
    L13:
        this.f164449b.a();
        this.f164448a.setVisibility(8);
    }

    public AuctionOfferRecordsFooterViewHolder(View r100, LifecycleOwner r101, AuctionOfferRecordsViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        super(r100);
        this.f164450c = r101;
        this.f164451d = r102;
        setIsRecyclable(false);
        this.f164448a = (ViewGroup) r100.findViewById(R.id.no_more_layout);
        this.f164449b = (ECStatusView) r100.findViewById(R.id.load_more_view);
    }
}
