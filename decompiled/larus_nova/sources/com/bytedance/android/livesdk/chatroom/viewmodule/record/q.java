package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f115432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f115433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f115434c;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public q() {
        Paint r100 = new Paint(1);
        r100.setColor(-16777216);
        r100.setStyle(Paint.Style.FILL);
        Unit r101 = Unit.INSTANCE;
        this.f115432a = r100;
        this.f115433b = new RectF();
        this.f115434c = -1;
    }

    public final void a(int r100) {
        this.f115434c = r100;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f115433b.set(getBounds());
        int r101 = this.f115434c;
        if (r101 < 0) goto L5;
        RectF r102 = this.f115433b;
        r102.right = r102.left + r101;
    L5:
        RectF r103 = this.f115433b;
        float r104 = 2;
        r100.drawRoundRect(r103, r103.height() / r104, this.f115433b.height() / r104, this.f115432a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f115432a.setAlpha(r100);
        invalidateSelf();
    }
}
