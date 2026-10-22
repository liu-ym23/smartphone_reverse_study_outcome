package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f150720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f150721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f150722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f150723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f150724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f150725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f150726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f150727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f150728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f150729j;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void a() {
        if (this.f150721b.isEmpty() == false) goto L5;
        return;
    L5:
        float r100 = this.f150721b.width();
        float r101 = this.f150721b.height();
        float r102 = this.f150721b.centerX();
        float r103 = this.f150721b.centerY();
        double r104 = ((double) (90 - this.f150728i)) * 0.017453292519943295d;
        double r105 = Math.abs(((double) r100) * Math.cos(r104)) + Math.abs(((double) r101) * Math.sin(r104));
        double r106 = r102;
        double r107 = r105 / 2.0d;
        this.f150722c = (float) (r106 - (Math.cos(r104) * r107));
        double r108 = r103;
        this.f150723d = ((float) ((Math.sin(r104) * r107) + r108)) + this.f150729j;
        this.f150724e = (float) (r106 + (Math.cos(r104) * r107));
        this.f150725f = ((float) (r108 - (r107 * Math.sin(r104)))) + this.f150729j;
        this.f150720a.setShader(new LinearGradient(this.f150722c, this.f150723d, this.f150724e, this.f150725f, this.f150726g, this.f150727h, Shader.TileMode.CLAMP));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawRect(this.f150721b, this.f150720a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        this.f150721b.set(r100);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f150720a.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f150720a.setColorFilter(r100);
        invalidateSelf();
    }

    public a(int[] r100, float[] r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        Intrinsics.checkNotNullParameter(r101, "positions");
        this.f150726g = r100;
        this.f150727h = r101;
        this.f150728i = r102;
        this.f150729j = r103;
        this.f150720a = new Paint(1);
        this.f150721b = new RectF();
        a();
    }
}
