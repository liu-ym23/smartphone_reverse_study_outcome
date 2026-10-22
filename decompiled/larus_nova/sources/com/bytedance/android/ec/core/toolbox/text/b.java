package com.bytedance.android.ec.core.toolbox.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f45495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f45496b;

    public b(int r100, int r101) {
        this.f45496b = r100;
        Paint r102 = new Paint();
        r102.setColor(r101);
        r102.setStyle(Paint.Style.FILL);
        Unit r103 = Unit.INSTANCE;
        this.f45495a = r102;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return this.f45496b;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r110, float r111, int r112, int r113, int r114, Paint r115) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r115, "paint");
        r100.drawRect(r111, r112, r111 + this.f45496b, r114, this.f45495a);
    }
}
