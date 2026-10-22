package com.bytedance.android.live.recharge.order;

import io.reactivex.functions.Consumer;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f90103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.b f90104b;

    public h(f r100, f.b r101) {
        this.f90103a = r100;
        this.f90104b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Order.State r101 = (Order.State) r100;
        Set<f.b> r102 = this.f90103a.f90090b;
        HashSet r103 = (HashSet) r102;
        r103.remove(this.f90104b);
    }
}
