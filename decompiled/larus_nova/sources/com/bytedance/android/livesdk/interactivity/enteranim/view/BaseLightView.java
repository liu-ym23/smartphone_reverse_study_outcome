package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public class BaseLightView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f136813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Matrix f136814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f136815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Shader f136816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Shader f136817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComposeShader f136818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Matrix f136819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f136820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f136821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Canvas f136822j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RectF f136823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f136824l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f136825m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f136826n;

    public BaseLightView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f136813a == false) goto L11;
        this.f136822j.drawPaint(this.f136821i);
        float r101 = this.f136815c - 30.0f;
        this.f136815c = r101;
        this.f136814b.setTranslate(r101, 0.0f);
        this.f136817e.setLocalMatrix(this.f136814b);
        ComposeShader r102 = new ComposeShader(this.f136816d, this.f136817e, PorterDuff.Mode.DST_ATOP);
        this.f136818f = r102;
        r102.setLocalMatrix(this.f136819g);
        this.f136820h.setShader(this.f136818f);
        this.f136822j.drawRoundRect(this.f136823k, 10.0f, 10.0f, this.f136820h);
        this.f136820h.setAlpha(128);
        r100.drawBitmap(this.f136824l, 0.0f, 0.0f, this.f136820h);
        float r103 = this.f136815c;
        float r104 = (-this.f136825m) / 2.0f;
        if (r103 > r104) goto L8;
        this.f136813a = false;
    L8:
        if (r103 <= r104) goto L12;
        postInvalidateDelayed(20);
        return;
    L12:
        return;
    }

    public BaseLightView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f136825m = View.MeasureSpec.getSize(r100);
        this.f136826n = View.MeasureSpec.getSize(r101);
    }

    public BaseLightView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f136820h = r103;
        r103.setAntiAlias(true);
        Paint r104 = new Paint();
        this.f136821i = r104;
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f136814b = new Matrix();
        Matrix r105 = new Matrix();
        this.f136819g = r105;
        r105.setTranslate(1.0f, 0.0f);
        this.f136825m = getWidth();
        this.f136826n = getHeight();
        this.f136823k = new RectF(0.0f, 0.0f, this.f136825m, this.f136826n);
    }
}
