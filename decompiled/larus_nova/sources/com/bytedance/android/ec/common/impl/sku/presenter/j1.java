package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class j1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f43240a;

    public j1(l1 r100) {
        this.f43240a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Long r101 = (Long) r100;
        l1.d0(this.f43240a);
    }
}
