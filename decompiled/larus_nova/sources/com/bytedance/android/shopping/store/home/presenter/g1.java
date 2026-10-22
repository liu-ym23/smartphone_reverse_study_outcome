package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class g1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopLoadStatusPresenter f184178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f184179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f184180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LazyStatusView f184181d;

    public g1(ECShopLoadStatusPresenter r100, ViewGroup r101, View r102, LazyStatusView r103) {
        this.f184178a = r100;
        this.f184179b = r101;
        this.f184180c = r102;
        this.f184181d = r103;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LoadStatus r101 = (LoadStatus) r100;
        if (r101 == null) goto L18;
        int r102 = x0.f184456b[r101.ordinal()];
        if (r102 != 1) goto L8;
        this.f184178a.v0(this.f184179b, this.f184180c, r101);
        this.f184181d.b(com.bytedance.android.ec.store.status.b.c.f48653a);
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f184181d.setVisibility(8);
        this.f184178a.v0(this.f184179b, this.f184180c, r101);
        return;
    L10:
        if (r102 != 3) goto L19;
        this.f184181d.b(com.bytedance.android.ec.store.status.b.C0841b.f48652a);
        this.f184178a.v0(this.f184179b, this.f184180c, r101);
        return;
    L19:
        return;
    }
}
