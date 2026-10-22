package com.bytedance.android.window.shop.innerflow.widget;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowEmptyHolder;
import com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder;
import com.bytedance.android.window.shop.innerflow.holder.ECWindowInnerFlowFooterHolder;
import com.bytedance.android.window.shop.innerflow.holder.factory.ECShopInnerFlowHolderFactory;
import com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import eq3.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vp3.b;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECWindowInnerFlowAdapter;", "Lcom/bytedance/android/window/shop/widget/WindowRecyclerViewWithHeaderAndFooterAdapterV2;", "Lcom/bytedance/android/window/shop/innerflow/holder/ECShopInnerFlowItemHolder;", "Lvp3/b;", "Lcom/bytedance/android/window/shop/innerflow/holder/ECShopInnerFlowHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowAdapter extends WindowRecyclerViewWithHeaderAndFooterAdapterV2<ECShopInnerFlowItemHolder<? extends b>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f189219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECWindowInnerFlowFooterHolder f189220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f189221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Activity f189222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f189223g;

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final int getBasicItemCount() {
        return ((ArrayList) this.f189219c).size();
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final int getBasicItemViewType(int r100) {
        return ((b) ListProtector.get(this.f189219c, r100)).getType();
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ECWindowInnerFlowFooterHolder r101 = new ECWindowInnerFlowFooterHolder(r100.getContext());
        this.f189220d = r101;
        return r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        ECShopInnerFlowItemHolder r101 = (ECShopInnerFlowItemHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        r101.U3();
    }

    public final void z2(FooterStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "footerStatus");
        ECWindowInnerFlowFooterHolder r101 = this.f189220d;
        if (r101 == null) goto L6;
        r101.V3(r100);
        return;
    }

    public ECWindowInnerFlowAdapter(FragmentActivity r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "firstBindCallback");
        this.f189222f = r100;
        this.f189223g = r101;
        this.f189219c = new ArrayList();
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ECShopInnerFlowItemHolder r102 = (ECShopInnerFlowItemHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        b r103 = (b) ListProtector.get(this.f189219c, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "vo");
        r103.f556618a.b(b.f556616c, Integer.valueOf(r102.getLayoutPosition()));
        r102.T3(r103);
        View r104 = r102.itemView;
        if (this.f189221e == true) goto L7;
        this.f189221e = true;
        r104.post(new a(this));
        return;
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Map<Integer, Function1<Activity, ECShopInnerFlowItemHolder<? extends b>>> r102 = ECShopInnerFlowHolderFactory.f189159a;
        Activity r103 = this.f189222f;
        Intrinsics.checkNotNullParameter(r103, "activity");
        Function1<Activity, ECShopInnerFlowItemHolder<? extends b>> r104 = ECShopInnerFlowHolderFactory.f189159a.get(Integer.valueOf(r101));
        if (r104 == null) goto L7;
        ECShopInnerFlowItemHolder<? extends b> r105 = r104.invoke(r103);
        if (r105 == null) goto L7;
        return r105;
    L7:
        return new ECShopInnerFlowEmptyHolder(new View(r103));
    }
}
