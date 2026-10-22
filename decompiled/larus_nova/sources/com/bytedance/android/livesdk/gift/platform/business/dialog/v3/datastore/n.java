package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f127316a;

    public n(u r100) {
        this.f127316a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        u r102 = this.f127316a;
        r102.f127332m.fetchAutoExchangeStatus(r102.f127325f);
    }
}
