package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ButtonPresenter f43271a;

    public q(ButtonPresenter r100) {
        this.f43271a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        rg.a r101 = (rg.a) r100;
        ButtonPresenter.i0(this.f43271a);
    }
}
