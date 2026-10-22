package com.bytedance.android.livesdk.livecommerce.utils;

import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class e0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f153078a;

    public e0(f0 r100) {
        this.f153078a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f153078a.f153080b.invoke(MSkiaImageRegionDecoder.FILE_PREFIX + ((String) r100), null);
    }
}
