package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4VideoView f168957a;

    public s(AnchorV4VideoView r100) {
        this.f168957a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = ((com.bytedance.android.shopping.anchorv4.voavhs.blur.c) r100).f168037a;
        if (r101 == null) goto L6;
        AnchorV4VideoView.g(this.f168957a, r101);
        return;
    }
}
