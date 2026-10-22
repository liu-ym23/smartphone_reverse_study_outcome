package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadGaussItemView f168995a;

    public a(HeadGaussItemView r100) {
        this.f168995a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return HeadGaussItemView.a(this.f168995a, r101);
    }
}
