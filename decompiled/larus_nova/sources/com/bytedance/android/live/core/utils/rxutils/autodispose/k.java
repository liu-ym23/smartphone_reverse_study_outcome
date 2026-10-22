package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;

/* JADX INFO: loaded from: classes45.dex */
public final class k extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Completable f66311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompletableSource f66312b;

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f66311a.subscribe(new r(this.f66312b, r100));
    }

    public k(Completable r100, CompletableSource r101) {
        this.f66311a = r100;
        this.f66312b = r101;
    }
}
