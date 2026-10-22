package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadGaussItemView f169003a;

    public f(HeadGaussItemView r100) {
        this.f169003a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = ((com.bytedance.android.shopping.anchorv4.voavhs.blur.c) r100).f168037a;
        if (r101 == null) goto L6;
        this.f169003a.setImageBitmap(r101);
        return;
    }
}
