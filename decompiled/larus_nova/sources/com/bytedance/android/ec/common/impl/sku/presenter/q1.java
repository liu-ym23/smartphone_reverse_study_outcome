package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class q1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s1 f43273a;

    public q1(s1 r100) {
        this.f43273a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        rg.a r101 = (rg.a) r100;
        s1.e0(this.f43273a);
    }
}
