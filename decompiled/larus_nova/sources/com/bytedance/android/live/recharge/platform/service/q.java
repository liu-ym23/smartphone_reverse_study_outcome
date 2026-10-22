package com.bytedance.android.live.recharge.platform.service;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;

/* JADX INFO: loaded from: classes47.dex */
public final class q implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f90322a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f90322a = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(fx0.n.f479084a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f90322a.dispose();
    }

    public q() {
        this.f90322a = Disposables.disposed();
    }
}
