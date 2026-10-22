package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class a1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealTimeChorusOperateView f146476a;

    public a1(RealTimeChorusOperateView r100) {
        this.f146476a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ye2.a r101 = (ye2.a) r100;
        RealTimeChorusOperateView r102 = this.f146476a;
        int r103 = RealTimeChorusOperateView.f146392r;
        r102.V5("paid auto join");
    }
}
