package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class f0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f43210a;

    public f0(i0 r100) {
        this.f43210a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        SkuLimit r101 = (SkuLimit) r100;
        i0.d0(this.f43210a);
    }
}
