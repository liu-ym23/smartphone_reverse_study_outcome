package com.bytedance.android.shopping.store.home.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f184746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f184747b;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public t(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "colorArray");
        this.f184747b = r100;
        this.f184746a = new Paint();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawRect(getBounds(), this.f184746a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r110) {
        Intrinsics.checkNotNullParameter(r110, "bounds");
        super.onBoundsChange(r110);
        this.f184746a.setShader(new LinearGradient(0.0f, 0.0f, r110.right - r110.left, 0.0f, this.f184747b, null, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f184746a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f184746a.setColorFilter(r100);
    }
}
