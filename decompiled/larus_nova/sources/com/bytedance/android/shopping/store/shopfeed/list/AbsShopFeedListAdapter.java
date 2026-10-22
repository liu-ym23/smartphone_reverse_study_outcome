package com.bytedance.android.shopping.store.shopfeed.list;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.hybridproduct.holder.e;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/AbsShopFeedListAdapter;", "Lcom/bytedance/android/ec/store/adapter/ShopRecyclerViewWithHeaderAndFooterAdapter;", "Lcom/bytedance/android/shopping/store/shopfeed/list/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsShopFeedListAdapter extends ShopRecyclerViewWithHeaderAndFooterAdapter<com.bytedance.android.shopping.store.shopfeed.list.a, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AbsShopFeedListAdapter$Companion$diffCallback$1 f186174h = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f186175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final QLiveData<LoadStatus> f186176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleOwner f186177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f186178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECShopFeedViewModel f186179g;

    public static final class a {
    }

    public abstract RecyclerView.ViewHolder A2(ViewGroup r100);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    public abstract void z2();

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedListAdapter$Companion$diffCallback$1] */
    static {
        f186174h = new AbsShopFeedListAdapter$Companion$diffCallback$1();
    }

    @Override // com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter
    public final int getBasicItemViewType(int r100) {
        com.bytedance.android.shopping.store.shopfeed.list.a r101 = getItem(r100);
        if (r101 == null) goto L7;
        ShopFeedItemType r102 = r101.f186230a;
        if (r102 == null) goto L7;
        return r102.getTypeValue();
    L7:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewRecycled(r100);
        if ((r100 instanceof ShopFeedBaseViewHolder) == true) goto L5;
        r100 = null;
    L5:
        ShopFeedBaseViewHolder r101 = (ShopFeedBaseViewHolder) r100;
        if (r101 == null) goto L9;
        r101.o();
        return;
    }

    @Override // com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        com.bytedance.android.shopping.store.shopfeed.list.a r102 = getItem(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof b) == true) goto L7;
        com.bytedance.android.shopping.store.shopfeed.list.a r103 = null;
    L8:
        b r104 = (b) r103;
        if (r104 == null) goto L18;
        if ((r100 instanceof ShopFeedBaseViewHolder) == true) goto L13;
        RecyclerView.ViewHolder r105 = null;
    L14:
        ShopFeedBaseViewHolder r106 = (ShopFeedBaseViewHolder) r105;
        if (r106 == null) goto L18;
        r106.T3(r104, r101, this.f186175c);
        goto L18
    L13:
        r105 = r100;
    L18:
        if ((r102 instanceof c) == true) goto L20;
        r102 = null;
    L20:
        c r107 = (c) r102;
        if (r107 != null) goto L23;
        return;
    L23:
        if ((r100 instanceof ShopFlowSliceCardViewHolder) == true) goto L25;
        r100 = null;
    L25:
        ShopFlowSliceCardViewHolder r108 = (ShopFlowSliceCardViewHolder) r100;
        if (r108 == null) goto L31;
        r108.T3(r107, r101, this.f186175c);
        return;
    L31:
        return;
    L7:
        r103 = r102;
        goto L8
    }

    @Override // com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != ShopFeedItemType.LYNX_CARD.getTypeValue()) goto L7;
        return A2(r100);
    L7:
        if (r101 != ShopFeedItemType.SLICE_CARD.getTypeValue()) goto L11;
        int r102 = ShopFlowSliceCardViewHolder.f186223e;
        QLiveData<LoadStatus> r103 = this.f186176d;
        ECShopFeedViewModel r104 = this.f186179g;
        Fragment r105 = this.f186178f;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r103, "loadStatus");
        Intrinsics.checkNotNullParameter(r104, "feedViewModel");
        Intrinsics.checkNotNullParameter(r105, WidgetService.PARAM_FRAGMENT);
        QUIManager r106 = new QUIManager();
        FrameLayout r107 = new FrameLayout(r100.getContext());
        e r108 = new e();
        pn.b.a(r106, new ek3.b(r105, r107, r108), r100.getContext(), r105);
        return new ShopFlowSliceCardViewHolder(r106, r107, r104, r108);
    L11:
        throw new IllegalArgumentException("unexpected viewType: " + r101);
    }

    public AbsShopFeedListAdapter(QLiveData<LoadStatus> r100, LifecycleOwner r101, Fragment r102, ECShopFeedViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "loadStatus");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "shopFeedViewModel");
        super(f186174h);
        this.f186176d = r100;
        this.f186177e = r101;
        this.f186178f = r102;
        this.f186179g = r103;
        setHasStableIds(true);
        z2();
        if (true == this.f48195a) goto L6;
        this.f48195a = true;
        return;
    }
}
