package com.bytedance.android.livesdk.bottomguide;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomGuideWidget f104361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.user.f f104362b;

    public d(BottomGuideWidget r100, com.bytedance.android.livesdk.user.f r101) {
        this.f104361a = r100;
        this.f104362b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        BottomGuideWidget r102 = this.f104361a;
        int r103 = BottomGuideWidget.f104330o;
        r102.Cq();
    }
}
