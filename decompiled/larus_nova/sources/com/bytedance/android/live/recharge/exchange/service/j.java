package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f89954a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(hw0.c.f487400a), this.f89954a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f89954a.clear();
    }

    public j() {
        this.f89954a = new CompositeDisposable();
    }
}
