package com.bytedance.android.shopping.store.hybrid;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f184845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LazyStatusView f184846b;

    public e(ViewGroup r100, LazyStatusView r101) {
        this.f184845a = r100;
        this.f184846b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LoadStatus r101 = (LoadStatus) r100;
        this.f184845a.setVisibility(0);
        if (r101 == null) goto L11;
        int r102 = b.f184823a[r101.ordinal()];
        if (r102 != 1) goto L8;
        this.f184846b.b(com.bytedance.android.ec.store.status.b.c.f48653a);
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f184845a.setVisibility(8);
        return;
    L10:
        if (r102 != 3) goto L11;
        this.f184846b.b(com.bytedance.android.ec.store.status.b.C0841b.f48652a);
        return;
    L11:
        this.f184845a.setVisibility(8);
    }
}
