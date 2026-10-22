package com.bytedance.android.livesdk.interactivity.comment.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends Drawable implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f136294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f136295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f136296c;

    @Override // com.bytedance.android.livesdk.interactivity.comment.view.c
    public final void a() {
        this.f136296c = -1;
        invalidateSelf();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.view.c
    public final Drawable getDrawable() {
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public a(int r100) {
        Paint r101 = new Paint(1);
        r101.setColor(r100);
        r101.setStyle(Paint.Style.FILL);
        Unit r102 = Unit.INSTANCE;
        this.f136294a = r101;
        this.f136295b = new RectF();
        this.f136296c = -1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.view.c
    public final void b(int r100) {
        this.f136296c = r100;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f136295b.set(getBounds());
        int r101 = this.f136296c;
        if (r101 < 0) goto L5;
        RectF r102 = this.f136295b;
        r102.right = r102.left + r101;
    L5:
        RectF r103 = this.f136295b;
        float r104 = 2;
        r100.drawRoundRect(r103, r103.height() / r104, this.f136295b.height() / r104, this.f136294a);
    }

    @Override // android.graphics.drawable.Drawable, com.bytedance.android.livesdk.interactivity.comment.view.c
    public final void setAlpha(int r100) {
        this.f136294a.setAlpha(r100);
        invalidateSelf();
    }
}
