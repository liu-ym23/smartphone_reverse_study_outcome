package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeQuickShotLayerWidget f119074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f119075b;

    public g(LandscapeQuickShotLayerWidget r100, Bitmap r101) {
        this.f119074a = r100;
        this.f119075b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LandscapeQuickShotLayerWidget.wq(this.f119074a, this.f119075b);
    }
}
