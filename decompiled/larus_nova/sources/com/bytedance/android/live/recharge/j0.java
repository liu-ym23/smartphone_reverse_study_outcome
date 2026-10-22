package com.bytedance.android.live.recharge;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class j0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f89985a;

    public j0(a0 r100) {
        this.f89985a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (((Boolean) this.f89985a.f89617u.f64752a).booleanValue() == true) goto L6;
        a0 r102 = this.f89985a;
        r102.T = true;
        r102.R.onNext(8);
        return;
    }
}
