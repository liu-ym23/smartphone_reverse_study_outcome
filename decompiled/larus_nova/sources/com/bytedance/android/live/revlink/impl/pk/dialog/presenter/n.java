package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f96051a;

    public n(k r100) {
        this.f96051a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        k r101 = this.f96051a;
        r101.d((Throwable) r100);
    }
}
