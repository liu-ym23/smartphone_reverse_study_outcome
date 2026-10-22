package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class y1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f43322a;

    public y1(b2 r100) {
        this.f43322a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        this.f43322a.m0();
        this.f43322a.n0();
        this.f43322a.l0();
    }
}
