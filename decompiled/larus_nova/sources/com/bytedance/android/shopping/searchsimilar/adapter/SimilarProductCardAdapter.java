package com.bytedance.android.shopping.searchsimilar.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter;
import com.bytedance.android.shopping.monitor.d;
import com.bytedance.android.shopping.searchsimilar.view.SimilarProductCardView;
import com.bytedance.android.shopping.searchsimilar.view.SimilarProductFeedbackView;
import com.bytedance.android.shopping.searchsimilar.viewholder.SimilarProductCardVH;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/adapter/SimilarProductCardAdapter;", "Lcom/bytedance/android/shopping/jedi/LoadMoreRecyclerViewAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductCardAdapter extends LoadMoreRecyclerViewAdapter {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f182473u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<rd3.a> f182474v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Set<String> f182475w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SimilarProductVM f182476x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RecyclerView f182477y;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter
    public final int getBasicItemCount() {
        return ((ArrayList) this.f182474v).size();
    }

    public SimilarProductCardAdapter(SimilarProductVM r100, RecyclerView r101) {
        Intrinsics.checkNotNullParameter(r100, "vm");
        this.f182476x = r100;
        this.f182477y = r101;
        this.f182473u = "";
        this.f182474v = new ArrayList();
        this.f182475w = new LinkedHashSet();
    }

    @Override // com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        View r100 = null;
        if ((r110 instanceof SimilarProductCardVH) == true) goto L5;
        r110 = null;
    L5:
        SimilarProductCardVH r112 = (SimilarProductCardVH) r110;
        if (r112 == null) goto L15;
        rd3.a r101 = (rd3.a) CollectionsKt.getOrNull(this.f182474v, r111);
        SimilarProductVM r102 = this.f182476x;
        Integer r103 = Integer.valueOf(r111);
        Intrinsics.checkNotNullParameter(r102, "vm");
        View r113 = r112.itemView;
        if ((r113 instanceof SimilarProductCardView) == false) goto L11;
        r100 = r113;
    L11:
        SimilarProductCardView r104 = (SimilarProductCardView) r100;
        if (r104 == null) goto L15;
        r104.a(r101, r102, r103, r112.f182567b, r112.f182568c, r112.f182566a);
    L15:
        if (this.f182476x.getIsFirstBind() == false) goto L18;
        d.f(this.f182473u).h();
        this.f182476x.setIsFirstBind(false);
        return;
    }

    @Override // com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new SimilarProductCardVH(new SimilarProductCardView(r100.getContext(), null, 6, 0), this.f182477y, this, this.f182475w);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.contains(1) == false) goto L18;
        View r103 = null;
        if ((r100 instanceof SimilarProductCardVH) == true) goto L7;
        r100 = null;
    L7:
        SimilarProductCardVH r104 = (SimilarProductCardVH) r100;
        if (r104 == null) goto L20;
        View r105 = r104.itemView;
        if ((r105 instanceof SimilarProductCardView) == false) goto L13;
        r103 = r105;
    L13:
        SimilarProductCardView r106 = (SimilarProductCardView) r103;
        if (r106 == null) goto L21;
        SimilarProductFeedbackView r107 = r106.f182526h;
        if (r107 == null) goto L22;
        r107.b(false, r106);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L18:
        onBindViewHolder(r100, r101);
    }
}
