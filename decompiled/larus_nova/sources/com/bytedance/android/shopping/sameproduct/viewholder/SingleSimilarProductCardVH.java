package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductView;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardBuyButton;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/SingleSimilarProductCardVH;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/BaseSimilarProductCardVH;", "Lrd3/a;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleSimilarProductCardVH extends BaseSimilarProductCardVH<rd3.a> implements a {
    @Override // com.bytedance.jedi.ext.adapter.JediViewHolder
    public final void onDestroy() {
        View r100 = this.itemView;
        if ((r100 instanceof FlowTinyProductView) == true) goto L5;
        r100 = null;
    L5:
        FlowTinyProductView r101 = (FlowTinyProductView) r100;
        if (r101 == null) goto L11;
        Disposable r102 = r101.f175847c.f182399c;
        if (r102 == null) goto L12;
        r102.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.jedi.ext.adapter.JediViewHolder, com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder
    public final void T3() {
        super.T3();
        int r100 = dh3.d.f468589a;
        dh3.d.b(this.itemView.getContext(), d4(), getItem());
    }

    @Override // com.bytedance.jedi.ext.adapter.JediSimpleViewHolder
    public final void a4(Object r100) {
        rd3.a r101 = (rd3.a) r100;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        this.f182426l = r101;
        r101.f537239f = getAdapterPosition() - 1;
        View r102 = this.itemView;
        View r103 = null;
        if ((r102 instanceof FlowTinyProductView) == true) goto L5;
        r102 = null;
    L5:
        FlowTinyProductView r104 = (FlowTinyProductView) r102;
        if (r104 == null) goto L8;
        r104.b(r101);
    L8:
        View r105 = this.itemView;
        if ((r105 instanceof FlowTinyProductView) == true) goto L11;
        r105 = null;
    L11:
        FlowTinyProductView r106 = (FlowTinyProductView) r105;
        if (r106 == null) goto L16;
        ProductFlowCardBuyButton r107 = r106.getBuyButton();
        if (r107 == null) goto L16;
        r107.setOnClickListener(new d(this, r101));
    L16:
        View r108 = this.itemView;
        if ((r108 instanceof FlowTinyProductView) == false) goto L20;
        r103 = r108;
    L20:
        FlowTinyProductView r109 = (FlowTinyProductView) r103;
        if (r109 == null) goto L24;
        r109.setOnClickListener(new e(this));
        return;
    }

    @Override // com.bytedance.android.shopping.sameproduct.viewholder.BaseSimilarProductCardVH
    public final void c4(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        e4(getItem());
    }

    @Override // com.bytedance.android.shopping.sameproduct.viewholder.BaseSimilarProductCardVH
    public final void f4(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = dh3.d.f468589a;
        dh3.d.a(this.itemView.getContext(), this.f182426l);
    }

    public SingleSimilarProductCardVH(Fragment r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        View r102 = null;
        super(r100, new FlowTinyProductView(r101.getContext(), null, 6, 0));
        View r103 = this.itemView;
        if ((r103 instanceof FlowTinyProductView) == false) goto L6;
        r102 = r103;
    L6:
        FlowTinyProductView r104 = (FlowTinyProductView) r102;
        if (r104 == null) goto L9;
        r104.setStyle(3);
    L9:
        StaggeredGridDoubleColumnDecoration.a r105 = StaggeredGridDoubleColumnDecoration.f164806g;
        View r106 = this.itemView;
        r105.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r106, true);
        this.f182431q.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }
}
