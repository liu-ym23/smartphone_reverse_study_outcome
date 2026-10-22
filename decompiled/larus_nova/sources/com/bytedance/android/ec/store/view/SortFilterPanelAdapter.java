package com.bytedance.android.ec.store.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/store/view/SortFilterPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/ec/store/view/SortFilterPanelViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SortFilterPanelAdapter extends RecyclerView.Adapter<SortFilterPanelViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function3<? super SortFilterExpandPanel, ? super View, ? super com.bytedance.android.ec.store.repository.vo.r, Unit> f48922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.ec.store.repository.vo.r> f48923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SortFilterExpandPanel f48924c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f48923b).size();
    }

    public SortFilterPanelAdapter(SortFilterExpandPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        this.f48924c = r100;
        this.f48922a = SortFilterPanelAdapter$itemClickListener$1.INSTANCE;
        this.f48923b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        SortFilterPanelViewHolder r102 = (SortFilterPanelViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        com.bytedance.android.ec.store.repository.vo.r r103 = (com.bytedance.android.ec.store.repository.vo.r) CollectionsKt.getOrNull(this.f48923b, r101);
        if (r103 != null) goto L5;
        r102.getClass();
    L9:
        r102.itemView.setOnClickListener(new w(this, r102, r101));
        return;
    L5:
        r102.f48926a.setText(r103.f48481b);
        if (r103.f() == false) goto L8;
        r102.f48926a.setTextColor((int) 4294901820L);
        goto L9
    L8:
        r102.f48926a.setTextColor((int) 4279638051L);
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        TextView r102 = new TextView(r100.getContext());
        int r103 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r102.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.d(Float.valueOf(14.0f)));
        ViewGroup.MarginLayoutParams r104 = new ViewGroup.MarginLayoutParams(-1, -2);
        r104.setMarginStart(com.bytedance.android.ec.hybrid.list.util.c.d(16));
        r104.setMarginEnd(com.bytedance.android.ec.hybrid.list.util.c.d(16));
        Unit r105 = Unit.INSTANCE;
        r102.setLayoutParams(r104);
        return new SortFilterPanelViewHolder(r102);
    }
}
