package com.bytedance.android.ec.store.view;

import android.view.View;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SortFilterPanelAdapter f48969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SortFilterPanelViewHolder f48970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f48971c;

    public w(SortFilterPanelAdapter r100, SortFilterPanelViewHolder r101, int r102) {
        this.f48969a = r100;
        this.f48970b = r101;
        this.f48971c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f48969a.notifyDataSetChanged();
        SortFilterPanelAdapter r101 = this.f48969a;
        r101.f48922a.invoke(r101.f48924c, this.f48970b.itemView, CollectionsKt.getOrNull(r101.f48923b, this.f48971c));
    }
}
