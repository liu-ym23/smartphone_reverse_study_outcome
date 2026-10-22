package com.bytedance.android.shopping.store.moments.module.presenter;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f185681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LazyStatusView f185682b;

    public h(ViewGroup r100, LazyStatusView r101) {
        this.f185681a = r100;
        this.f185682b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LoadStatus r101 = (LoadStatus) r100;
        this.f185681a.setVisibility(0);
        if (r101 == null) goto L13;
        int r102 = b.f185675a[r101.ordinal()];
        if (r102 != 1) goto L8;
        this.f185682b.b(com.bytedance.android.ec.store.status.b.c.f48653a);
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f185681a.setVisibility(8);
        return;
    L10:
        if (r102 != 3) goto L12;
        this.f185682b.b(com.bytedance.android.ec.store.status.b.C0841b.f48652a);
        return;
    L12:
        if (r102 != 4) goto L13;
        this.f185682b.b(com.bytedance.android.ec.store.status.b.a.f48651a);
        return;
    L13:
        this.f185681a.setVisibility(8);
    }
}
