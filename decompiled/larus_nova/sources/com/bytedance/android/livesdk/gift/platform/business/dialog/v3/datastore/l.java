package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f127305a;

    public l(m r100) {
        this.f127305a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ds2.d r101 = (ds2.d) r100;
        this.f127305a.k();
    }
}
