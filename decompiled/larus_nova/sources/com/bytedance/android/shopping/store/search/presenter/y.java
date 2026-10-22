package com.bytedance.android.shopping.store.search.presenter;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.ec.store.status.StoreSearchProductLoadingStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class y<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f186113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f186114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LazyStatusView f186115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f186116d;

    public y(z r100, ViewGroup r101, LazyStatusView r102, Context r103) {
        this.f186113a = r100;
        this.f186114b = r101;
        this.f186115c = r102;
        this.f186116d = r103;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LoadStatus r101 = (LoadStatus) r100;
        this.f186114b.setVisibility(0);
        if (this.f186113a.f186118g == false) goto L6;
        this.f186115c.a(new StoreSearchProductLoadingStatusView(this.f186116d).a());
    L6:
        if (r101 == null) goto L16;
        int r102 = w.f186111a[r101.ordinal()];
        if (r102 != 1) goto L11;
        this.f186115c.b(com.bytedance.android.ec.store.status.b.c.f48653a);
    L21:
        this.f186113a.f186118g = true;
        return;
    L11:
        if (r102 != 2) goto L13;
        this.f186114b.setVisibility(8);
        goto L21
    L13:
        if (r102 != 3) goto L15;
        this.f186115c.b(com.bytedance.android.ec.store.status.b.C0841b.f48652a);
        goto L21
    L15:
        if (r102 != 4) goto L16;
        this.f186115c.b(com.bytedance.android.ec.store.status.b.a.f48651a);
    L16:
        this.f186114b.setVisibility(8);
        goto L21
    }
}
