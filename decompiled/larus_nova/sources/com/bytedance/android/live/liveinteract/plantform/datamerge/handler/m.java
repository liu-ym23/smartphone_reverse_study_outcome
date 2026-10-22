package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f76466a;

    public m(n r100) {
        this.f76466a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        n r101 = this.f76466a;
        ch0.c r102 = r101.f76468c;
        r102.f23718a = ((fd2.z) r100).f476512a;
        r101.a().W0(this.f76466a.f76468c);
    }
}
