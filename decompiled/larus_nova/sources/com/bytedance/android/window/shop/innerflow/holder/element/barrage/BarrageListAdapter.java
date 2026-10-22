package com.bytedance.android.window.shop.innerflow.holder.element.barrage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wp3.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/element/barrage/BarrageListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/window/shop/innerflow/holder/element/barrage/BarrageListItemHolder;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageListAdapter extends RecyclerView.Adapter<BarrageListItemHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a.C8143a> f189057a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public BarrageListAdapter() {
        this.f189057a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BarrageListItemHolder r102 = (BarrageListItemHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        if (((ArrayList) this.f189057a).size() == 0) goto L10;
        List<a.C8143a> r103 = this.f189057a;
        a.C8143a r104 = (a.C8143a) ListProtector.get(r103, r101 % ((ArrayList) r103).size());
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "vo");
        String r105 = r104.f560567a;
        if (r105 == null) goto L11;
        r102.f189058a.setText(r105);
        r102.f189059b.setText(Intrinsics.stringPlus(r104.f560568b, " "));
        return;
    L11:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new BarrageListItemHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ec_shop_layout_inner_flow_element_item_barrage, null));
    }
}
