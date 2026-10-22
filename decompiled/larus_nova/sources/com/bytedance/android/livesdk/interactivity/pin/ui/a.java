package com.bytedance.android.livesdk.interactivity.pin.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f138881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f138882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f138883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f138884d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public a(int r100) {
        this.f138884d = UtilityKotlinExtentionsKt.h(8);
        Paint r101 = new Paint(1);
        r101.setColor(r100);
        r101.setStyle(Paint.Style.FILL);
        Unit r102 = Unit.INSTANCE;
        this.f138881a = r101;
        this.f138882b = new RectF();
        this.f138883c = UtilityKotlinExtentionsKt.h(72);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f138882b.set(getBounds());
        float r101 = this.f138883c;
        if (r101 <= 0.0f) goto L5;
        RectF r102 = this.f138882b;
        r102.bottom = r102.top + r101;
    L5:
        RectF r103 = this.f138882b;
        float r104 = this.f138884d;
        r100.drawRoundRect(r103, r104, r104, this.f138881a);
    }
}
