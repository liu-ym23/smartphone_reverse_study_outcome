package com.bytedance.android.shopping.store.home.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f184689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f184690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SweepGradient f184691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f184692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f184693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f184694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f184695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f184696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f184697i;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void a() {
        SweepGradient r100 = new SweepGradient((getBounds().width() * this.f184692d) + getBounds().left, (getBounds().height() * this.f184693e) + getBounds().top, this.f184695g, null);
        this.f184691c = r100;
        r100.setLocalMatrix(null);
        this.f184689a.setShader(this.f184691c);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Rect r101 = getBounds();
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        Integer r102 = this.f184697i;
        if (r102 == null) goto L11;
        this.f184690b.setColor(r102.intValue());
        float r103 = this.f184696h;
        if (r103 <= 0) goto L10;
        RectF r104 = this.f184694f;
        r104.left = r101.left;
        r104.top = r101.top;
        r104.right = r101.right;
        r104.bottom = r101.bottom;
        r100.drawRoundRect(r104, r103, r103, this.f184690b);
        goto L11
    L10:
        r100.drawRect(r101, this.f184690b);
    L11:
        float r105 = this.f184696h;
        if (r105 <= 0) goto L14;
        RectF r106 = this.f184694f;
        r106.left = r101.left;
        r106.top = r101.top;
        r106.right = r101.right;
        r106.bottom = r101.bottom;
        r100.drawRoundRect(r106, r105, r105, this.f184689a);
        return;
    L14:
        r100.drawRect(r101, this.f184689a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f184689a.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f184689a.setColorFilter(r100);
        invalidateSelf();
    }

    public a(int[] r100, float r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.f184695g = r100;
        this.f184696h = 0.0f;
        this.f184697i = r102;
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(r101);
        Unit r104 = Unit.INSTANCE;
        this.f184689a = r103;
        Paint r105 = new Paint(1);
        r105.setStyle(Paint.Style.FILL);
        this.f184690b = r105;
        this.f184692d = 0.5f;
        this.f184693e = 0.5f;
        this.f184694f = new RectF();
    }
}
