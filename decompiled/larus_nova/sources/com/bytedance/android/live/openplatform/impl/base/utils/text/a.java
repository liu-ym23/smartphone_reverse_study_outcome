package com.bytedance.android.live.openplatform.impl.base.utils.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f84076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f84077b;

    public a(int r100, int r101) {
        this.f84077b = r100;
        Paint r102 = new Paint();
        r102.setColor(r101);
        r102.setStyle(Paint.Style.FILL);
        Unit r103 = Unit.INSTANCE;
        this.f84076a = r102;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return this.f84077b;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r110, float r111, int r112, int r113, int r114, Paint r115) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r115, "paint");
        r100.drawRect(r111, r112, r111 + this.f84077b, r114, this.f84076a);
    }
}
