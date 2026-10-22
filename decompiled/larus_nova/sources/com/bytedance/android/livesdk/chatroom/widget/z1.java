package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class z1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PortraitQuickShotLayerWidget f119288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f119289b;

    public z1(PortraitQuickShotLayerWidget r100, Bitmap r101) {
        this.f119288a = r100;
        this.f119289b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Bitmap r102 = this.f119289b;
        if (r102 == null) goto L6;
        PortraitQuickShotLayerWidget.xq(this.f119288a, r102);
        return;
    }
}
