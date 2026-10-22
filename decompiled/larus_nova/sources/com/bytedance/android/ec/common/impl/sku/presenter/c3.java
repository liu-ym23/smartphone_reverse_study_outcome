package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes43.dex */
public final class c3<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d3 f43189a;

    public c3(d3 r100) {
        this.f43189a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        d3.d0(this.f43189a);
    }
}
