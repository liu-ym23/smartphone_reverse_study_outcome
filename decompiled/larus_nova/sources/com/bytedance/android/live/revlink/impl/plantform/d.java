package com.bytedance.android.live.revlink.impl.plantform;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f97406a = null;

    static {
        f97406a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 == null) goto L6;
        r101.printStackTrace();
        return;
    }
}
