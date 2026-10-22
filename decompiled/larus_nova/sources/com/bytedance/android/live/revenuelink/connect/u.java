package com.bytedance.android.live.revenuelink.connect;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkOutManager.e f91824a;

    public u(LinkOutManager.e r100) {
        this.f91824a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LinkOutManager.e r102 = this.f91824a;
        j r103 = r102.f91765a.f91749f;
        if (r103 == null) goto L6;
        r103.Q4(r102.f91768d);
        return;
    }
}
