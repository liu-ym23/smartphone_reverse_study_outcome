package com.bytedance.android.live.core.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.live.datacontext.l f66122a;

    public c0(com.bytedance.live.datacontext.m r100) {
        this.f66122a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) {
        this.f66122a.setValue(r100);
    }
}
