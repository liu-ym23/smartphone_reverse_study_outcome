package com.bytedance.android.annie.bridge.method;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f38578a;

    public c0(d0 r100) {
        this.f38578a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        GetDeviceStatsResultModel r101 = (GetDeviceStatsResultModel) r100;
        r101.b(GetDeviceStatsResultModel.Code.Success);
        this.f38578a.finishWithResult(r101);
    }
}
