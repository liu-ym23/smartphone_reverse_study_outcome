package com.bytedance.android.window.shop.search.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.opt.asyncInflate.c;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultFooterNoticeVO;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import com.bytedance.android.ec.window.base.utils.quick.d;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowBaseSearchResultViewHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowRecommendedNoticeHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowRecommendedResultHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowSearchProductFooterHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowSearchResultFooterViewHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowSearchResultViewHolder;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jp.b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vq3.e;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/search/recyclerview/WindowSearchResultAdapter;", "Lcom/bytedance/android/ec/window/base/adapter/WindowRecyclerViewWithHeaderAndFooterAdapterV1;", "Ljp/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultAdapter extends WindowRecyclerViewWithHeaderAndFooterAdapterV1<b, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final WindowSearchResultAdapter$Companion$diffCallback$1 f189768h = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f189769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f189770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f189771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f189772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WindowLayoutTypes f189773g;

    public static final class a {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.window.shop.search.recyclerview.WindowSearchResultAdapter$Companion$diffCallback$1] */
    static {
        f189768h = new WindowSearchResultAdapter$Companion$diffCallback$1();
    }

    @Override // com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1
    public final int getBasicItemViewType(int r100) {
        b r101 = getItem(r100);
        if (r101 == null) goto L7;
        return r101.f499928a.getTypeValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowBaseViewObject");
    }

    @Override // com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f189769c = r100;
    }

    @Override // com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof WindowSearchProductFooterHolder) == false) goto L6;
        ((WindowSearchProductFooterHolder) r100).f189784a.c(e.class, null);
        return;
    L6:
        if ((r100 instanceof WindowSearchResultFooterViewHolder) == false) goto L10;
        ((WindowSearchResultFooterViewHolder) r100).T3(new WindowSearchResultFooterNoticeVO());
        return;
    }

    @Override // com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        RecyclerView r100 = this.f189769c;
        if (r100 == null) goto L9;
        int r101 = WindowSearchProductFooterHolder.f189783b;
        Fragment r102 = this.f189772f;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        QUIManager r103 = new QUIManager();
        ShoppingAsyncInflater.a r104 = ShoppingAsyncInflater.f45268e;
        Context r105 = r110.getContext();
        r104.getClass();
        View r106 = ShoppingAsyncInflater.a.a(r105).aU(R.layout.ec_window_shopping_layout_store_v2_product_footer_item, r110, false);
        LoadMoreStatusView r107 = (LoadMoreStatusView) r106.findViewById(R.id.sv_product_load_more);
        r107.setPadding(0, vf4.a.b(12), 0, vf4.a.b(12));
        Lazy r108 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L7;
        r107.f(c.a(ShoppingAsyncInflater.a.a(r110.getContext()), R.layout.ec_window_shopping_store_tt_load_more, null, 6), null, null);
    L7:
        d.a(r103, new e(r106, r100), r110.getContext(), r102);
        return new WindowSearchProductFooterHolder(r103, r103.p());
    L9:
        int r109 = WindowSearchResultFooterViewHolder.f189785e;
        Context r111 = r110.getContext();
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new WindowSearchResultFooterViewHolder(new TextView(r111));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        this.f189769c = null;
    }

    @Override // com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        ViewGroup.LayoutParams r101 = null;
        if ((r100 instanceof WindowRecommendedNoticeHolder) == false) goto L5;
    L20:
        ViewGroup.LayoutParams r102 = r100.itemView.getLayoutParams();
        if ((r102 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L24;
        r101 = r102;
    L24:
        StaggeredGridLayoutManager.LayoutParams r103 = (StaggeredGridLayoutManager.LayoutParams) r101;
        if (r103 == null) goto L32;
        r103.setFullSpan(true);
        return;
    L32:
        return;
    L5:
        if ((r100 instanceof WindowSearchProductFooterHolder) == true) goto L20;
        if ((r100 instanceof WindowSearchResultViewHolder) == true) goto L12;
        if ((r100 instanceof WindowRecommendedResultHolder) == true) goto L12;
        return;
    L12:
        if (this.f189773g != WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L29;
        ViewGroup.LayoutParams r104 = r100.itemView.getLayoutParams();
        if ((r104 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L17;
        r101 = r104;
    L17:
        StaggeredGridLayoutManager.LayoutParams r105 = (StaggeredGridLayoutManager.LayoutParams) r101;
        if (r105 == null) goto L30;
        r105.setFullSpan(true);
        return;
    L30:
        return;
    }

    @Override // com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1
    public final boolean y2(int r100) {
        if (getItemViewType(r100) != WindowSearchResultItemType.RECOMMEND_NOTICE.getTypeValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public WindowSearchResultAdapter(Fragment r100, WindowLayoutTypes r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "layoutType");
        super(f189768h);
        this.f189772f = r100;
        this.f189773g = r101;
        this.f189770d = true;
        setHasStableIds(true);
    }

    @Override // com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        b r102 = getItem(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof jp.a) == true) goto L7;
        b r103 = null;
    L8:
        jp.a r104 = (jp.a) r103;
        if (r104 == null) goto L19;
        WindowV2ProductItemVO r105 = r104.f499927b;
        if (r105 == null) goto L19;
        if ((r105 instanceof com.bytedance.android.ec.window.base.repository.vo.e) == true) goto L15;
        r105.f49487y = r101;
        goto L19
    L15:
        if (this.f189771e != 0) goto L17;
        this.f189771e = r101;
    L17:
        r105.f49487y = r101 - this.f189771e;
    L19:
        ((WindowBaseSearchResultViewHolder) r100).T3(r102);
        if (this.f189770d == false) goto L42;
        this.f189770d = false;
        Map<String, String> r106 = wo.a.f560499a;
        wo.a.a("ec_perf_duration_shop_search_result", "render_end", System.currentTimeMillis());
        Intrinsics.checkNotNullParameter("ec_perf_duration_shop_search_result", "business");
        String r107 = (String) ((LinkedHashMap) wo.a.f560499a).get("ec_perf_duration_shop_search_result");
        if (r107 == null) goto L43;
        Map r108 = (Map) ((LinkedHashMap) wo.a.f560500b).get("ec_perf_duration_shop_search_result");
        if (r108 == null) goto L31;
        Iterator r109 = r108.entrySet().iterator();
    L27:
        if (r109.hasNext() == false) goto L31;
        Map.Entry r110 = (Map.Entry) r109.next();
        com.bytedance.android.ec.monitor.duration.d r111 = i.f47987a.get(r107);
        if (r111 == null) goto L27;
        r111.d((String) r110.getKey(), ((Number) r110.getValue()).longValue());
    L31:
        com.bytedance.android.ec.monitor.duration.d r112 = i.f47987a.get(r107);
        if (r112 == null) goto L34;
        r112.report();
    L34:
        wo.a.f560499a.remove("ec_perf_duration_shop_search_result");
        Map<String, Long> r113 = wo.a.f560500b.remove("ec_perf_duration_shop_search_result");
        return;
    L43:
        return;
    L42:
        return;
    L7:
        r103 = r102;
        goto L8
    }

    @Override // com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        if (r111 == WindowSearchResultItemType.RECOMMEND_NOTICE.getTypeValue()) goto L22;
        WindowSearchResultItemType r100 = WindowSearchResultItemType.SEARCH_RESULT;
        if (r111 != r100.getTypeValue()) goto L12;
        int r112 = WindowSearchResultViewHolder.f189787d;
        Fragment r113 = this.f189772f;
        WindowLayoutTypes r101 = this.f189773g;
        Intrinsics.checkNotNullParameter(r113, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r101, "layoutType");
        QUIManager r102 = new QUIManager();
        if (wq3.b.f560691a[r101.ordinal()] == 1) goto L10;
        ShoppingAsyncInflater.a r103 = ShoppingAsyncInflater.f45268e;
        Context r104 = r110.getContext();
        r103.getClass();
        View r105 = c.a(ShoppingAsyncInflater.a.a(r104), R.layout.ec_window_layout_holder_normal_product_double, r110, 4);
    L11:
        r101.getType();
        d.a(r102, new vq3.d(r105), r110.getContext(), r113);
        return new WindowSearchResultViewHolder(r102, r102.p(), r100);
    L10:
        ShoppingAsyncInflater.a r106 = ShoppingAsyncInflater.f45268e;
        Context r107 = r110.getContext();
        r106.getClass();
        r105 = c.a(ShoppingAsyncInflater.a.a(r107), R.layout.ec_window_layout_holder_product_single_saas, r110, 4);
        goto L11
    L12:
        WindowSearchResultItemType r108 = WindowSearchResultItemType.RECOMMENDED_RESULT;
        if (r111 != r108.getTypeValue()) goto L21;
        int r114 = WindowRecommendedResultHolder.f189782d;
        Fragment r115 = this.f189772f;
        WindowLayoutTypes r109 = this.f189773g;
        Intrinsics.checkNotNullParameter(r115, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r109, "layoutType");
        QUIManager r116 = new QUIManager();
        if (wq3.a.f560690a[r109.ordinal()] == 1) goto L17;
        ShoppingAsyncInflater.a r117 = ShoppingAsyncInflater.f45268e;
        Context r118 = r110.getContext();
        r117.getClass();
        View r119 = c.a(ShoppingAsyncInflater.a.a(r118), R.layout.ec_window_layout_holder_normal_product_double, r110, 4);
    L18:
        r109.getType();
        d.a(r116, new vq3.d(r119), r110.getContext(), r115);
        return new WindowRecommendedResultHolder(r116, r116.p(), r108);
    L17:
        ShoppingAsyncInflater.a r120 = ShoppingAsyncInflater.f45268e;
        Context r121 = r110.getContext();
        r120.getClass();
        r119 = c.a(ShoppingAsyncInflater.a.a(r121), R.layout.ec_window_layout_holder_product_single_saas, r110, 4);
        goto L18
    L21:
        throw new IllegalArgumentException("unexpected viewType: " + r111);
    L22:
        return new WindowRecommendedNoticeHolder(r110.getContext());
    }
}
