package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadGaussItemView f169001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f169002b;

    public e(HeadGaussItemView r100, Function1 r101) {
        this.f169001a = r100;
        this.f169002b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.shopping.anchorv4.voavhs.blur.c r101 = (com.bytedance.android.shopping.anchorv4.voavhs.blur.c) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        Bitmap r102 = r101.f168037a;
        if (r102 == null) goto L9;
        Bitmap r103 = HeadGaussItemView.a(this.f169001a, r102);
        if (r103 == null) goto L11;
        Function1 r104 = this.f169002b;
        if (r104 == null) goto L11;
        Unit r105 = (Unit) r104.invoke(r103);
    L11:
        return new com.bytedance.android.shopping.anchorv4.voavhs.blur.c(r103);
    L9:
        r103 = null;
        goto L11
    }
}
