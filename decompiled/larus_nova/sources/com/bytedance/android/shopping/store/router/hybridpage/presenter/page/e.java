package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f185931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LazyStatusView f185932b;

    public e(ViewGroup r100, LazyStatusView r101) {
        this.f185931a = r100;
        this.f185932b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LoadStatus r101 = (LoadStatus) r100;
        if (r101 != null) goto L6;
    L7:
        this.f185931a.setVisibility(8);
        return;
    L6:
        if (d.f185930a[r101.ordinal()] != 1) goto L7;
        this.f185931a.setVisibility(0);
        this.f185932b.b(com.bytedance.android.ec.store.status.b.C0841b.f48652a);
    }
}
