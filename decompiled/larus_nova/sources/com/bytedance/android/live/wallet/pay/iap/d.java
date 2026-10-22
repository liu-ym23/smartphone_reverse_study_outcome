package com.bytedance.android.live.wallet.pay.iap;

import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f102694a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f102694a.clear();
    }

    public d() {
        this.f102694a = new CompositeDisposable();
    }
}
