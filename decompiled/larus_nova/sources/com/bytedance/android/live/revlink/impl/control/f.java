package com.bytedance.android.live.revlink.impl.control;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f92413a;

    public f(e r100) {
        this.f92413a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        e.b r102 = (e.b) this.f92413a.f119707a;
        if (r102 == null) goto L6;
        r102.Ab();
        return;
    }
}
