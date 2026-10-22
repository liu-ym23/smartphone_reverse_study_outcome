package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes11.dex */
public class EdgeTransparentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f160833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f160834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f160835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f160836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f160837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f160838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f160839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f160840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f160841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f160842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f160843k;

    public EdgeTransparentView(Context r100) {
        this(r100, null);
    }

    public EdgeTransparentView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(int r100, float r101) {
        this.f160834b = r100;
        this.f160835c = r101;
        invalidate();
    }

    public EdgeTransparentView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160834b = 0;
        this.f160835c = 0.0f;
        this.f160836d = 1;
        this.f160837e = 1 << 1;
        this.f160838f = 1 << 2;
        this.f160839g = 1 << 3;
        this.f160842j = new int[]{-1, 0};
        this.f160843k = new float[]{0.0f, 1.0f};
        Paint r103 = new Paint(1);
        this.f160833a = r103;
        r103.setStyle(Paint.Style.FILL);
        this.f160833a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r110, View r111, long r112) {
        int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        boolean r101 = super.drawChild(r110, r111, r112);
        if ((this.f160834b & this.f160836d) == 0) goto L6;
        r110.drawRect(0.0f, 0.0f, this.f160840h, this.f160835c, this.f160833a);
    L6:
        if ((this.f160834b & this.f160837e) == 0) goto L8;
        int r113 = r110.save();
        r110.rotate(180.0f, this.f160840h / 2.0f, this.f160841i / 2.0f);
        r110.drawRect(0.0f, 0.0f, this.f160840h, this.f160835c, this.f160833a);
        r110.restoreToCount(r113);
    L8:
        float r114 = (this.f160841i - this.f160840h) / 2.0f;
        if ((this.f160834b & this.f160838f) == 0) goto L12;
        int r115 = r110.save();
        r110.rotate(270.0f, this.f160840h / 2.0f, this.f160841i / 2.0f);
        r110.translate(0.0f, r114);
        r110.drawRect(0.0f - r114, 0.0f, this.f160840h + r114, this.f160835c, this.f160833a);
        r110.restoreToCount(r115);
    L12:
        if ((this.f160834b & this.f160839g) == 0) goto L14;
        int r116 = r110.save();
        r110.rotate(90.0f, this.f160840h / 2.0f, this.f160841i / 2.0f);
        r110.translate(0.0f, r114);
        r110.drawRect(0.0f - r114, 0.0f, this.f160840h + r114, this.f160835c, this.f160833a);
        r110.restoreToCount(r116);
    L14:
        r110.restoreToCount(r100);
        return r101;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        this.f160833a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f160835c, this.f160842j, this.f160843k, Shader.TileMode.CLAMP));
        this.f160840h = getWidth();
        this.f160841i = getHeight();
    }
}
