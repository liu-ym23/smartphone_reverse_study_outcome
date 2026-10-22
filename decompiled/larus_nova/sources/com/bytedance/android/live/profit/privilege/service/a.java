package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f88449a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(wu0.b.f561429a), this.f88449a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f88449a.clear();
    }

    public a() {
        this.f88449a = new CompositeDisposable();
    }
}
