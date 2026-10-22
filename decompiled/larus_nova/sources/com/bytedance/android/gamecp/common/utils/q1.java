package com.bytedance.android.gamecp.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class q1<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f57270a;

    public q1(com.lynx.tasm.behavior.ui.view.a r100) {
        this.f57270a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Integer) r100, "it");
        Bitmap r101 = Bitmap.createBitmap(this.f57270a.getWidth(), this.f57270a.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r102 = new Canvas(r101);
        r102.setDensity(480);
        this.f57270a.draw(r102);
        return r101;
    }
}
