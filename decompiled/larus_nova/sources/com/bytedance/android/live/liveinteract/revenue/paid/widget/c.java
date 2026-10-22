package com.bytedance.android.live.liveinteract.revenue.paid.widget;

import cj0.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePaidLinkMicWidget f78592a;

    public c(BasePaidLinkMicWidget r100) {
        this.f78592a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        k r101 = (k) r100;
        if (r101 == null) goto L6;
        this.f78592a.wq(r101);
        return;
    }
}
