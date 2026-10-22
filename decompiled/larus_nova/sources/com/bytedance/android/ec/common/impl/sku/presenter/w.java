package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class w<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CarModelOptimizePresenter f43305a;

    public w(CarModelOptimizePresenter r100) {
        this.f43305a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        CarModelOptimizePresenter r101 = this.f43305a;
        r101.d0((CarAdaptComponent) r100);
    }
}
