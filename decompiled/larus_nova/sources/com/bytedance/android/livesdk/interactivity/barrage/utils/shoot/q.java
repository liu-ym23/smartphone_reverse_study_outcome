package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f134008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q22.a f134009b;

    public q(o r100, q22.a r101) {
        this.f134008a = r100;
        this.f134009b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f134008a.l(this.f134009b);
    }
}
