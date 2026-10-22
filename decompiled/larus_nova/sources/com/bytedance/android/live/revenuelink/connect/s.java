package com.bytedance.android.live.revenuelink.connect;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkOutManager.a f91822a;

    public s(LinkOutManager.a r100) {
        this.f91822a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LinkOutManager.a r102 = this.f91822a;
        j r103 = r102.f91753a.f91749f;
        if (r103 == null) goto L6;
        r103.M2(r102.f91754b);
        return;
    }
}
