package com.bytedance.android.livesdk.castscreen.padandpc.adapter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadAndPcDeviceListAdapter.PcDeviceHolder f104671a;

    public b(PadAndPcDeviceListAdapter.PcDeviceHolder r100) {
        this.f104671a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PadAndPcDeviceListAdapter.PcDeviceHolder r101 = this.f104671a;
        int r102 = PadAndPcDeviceListAdapter.PcDeviceHolder.f104661g;
        r101.U3((pf1.a) r100);
    }
}
