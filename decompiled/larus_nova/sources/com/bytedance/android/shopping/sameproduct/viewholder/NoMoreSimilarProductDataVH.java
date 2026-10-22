package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.sameproduct.widget.NoMoreSameProductView;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/NoMoreSimilarProductDataVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Leh3/a;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoMoreSimilarProductDataVH extends JediSimpleViewHolder<eh3.a> implements a {
    public NoMoreSimilarProductDataVH(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        super(new NoMoreSameProductView(r100.getContext(), null));
        StaggeredGridDoubleColumnDecoration.a r101 = StaggeredGridDoubleColumnDecoration.f164806g;
        View r102 = this.itemView;
        r101.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r102, false);
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // com.bytedance.jedi.ext.adapter.JediSimpleViewHolder
    public final void a4(eh3.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }
}
