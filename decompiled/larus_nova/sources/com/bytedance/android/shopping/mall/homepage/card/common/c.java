package com.bytedance.android.shopping.mall.homepage.card.common;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes13.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECLynxCardMonitorHolder f177509a;

    public c(ECLynxCardMonitorHolder r100) {
        this.f177509a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ECLynxCardMonitorHolder r101 = this.f177509a;
        r101.H0 = ((Float) r100).floatValue();
        this.f177509a.N4(null);
    }
}
