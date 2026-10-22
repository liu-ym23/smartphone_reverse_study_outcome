package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadGaussItemView f168996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f168997b;

    public b(HeadGaussItemView r100, Function1 r101) {
        this.f168996a = r100;
        this.f168997b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (r101 == null) goto L8;
        this.f168996a.setImageBitmap(r101);
        Function1 r102 = this.f168997b;
        if (r102 == null) goto L9;
        Unit r103 = (Unit) r102.invoke(r101);
        return;
    L9:
        return;
    }
}
