package com.bytedance.android.livesdk.castscreen.padandpc.adapter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadAndPcDeviceListAdapter.PadDeviceHolder f104670a;

    public a(PadAndPcDeviceListAdapter.PadDeviceHolder r100) {
        this.f104670a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PadAndPcDeviceListAdapter.PadDeviceHolder r101 = this.f104670a;
        int r102 = PadAndPcDeviceListAdapter.PadDeviceHolder.f104652g;
        r101.U3((pf1.a) r100);
    }
}
