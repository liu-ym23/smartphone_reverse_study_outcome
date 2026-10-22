package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageFilterView.c f13942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f13944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f13946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewOutlineProvider f13947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f13948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable[] f13949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LayerDrawable f13950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f13952k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f13953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13955n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13956o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13957p;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterButton f13958a;

        public a(ImageFilterButton r10) {
            this.f13958a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            int r12 = this.f13958a.getWidth();
            int r13 = this.f13958a.getHeight();
            r11.setRoundRect(0, 0, r12, r13, (Math.min(r12, r13) * ImageFilterButton.a(this.f13958a)) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterButton f13959a;

        public b(ImageFilterButton r10) {
            this.f13959a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            r11.setRoundRect(0, 0, this.f13959a.getWidth(), this.f13959a.getHeight(), ImageFilterButton.b(this.f13959a));
        }
    }

    public ImageFilterButton(Context r10) {
        super(r10);
        this.f13942a = new ImageFilterView.c();
        this.f13943b = 0.0f;
        this.f13944c = 0.0f;
        this.f13945d = Float.NaN;
        this.f13949h = new Drawable[2];
        this.f13951j = true;
        this.f13952k = null;
        this.f13953l = null;
        this.f13954m = Float.NaN;
        this.f13955n = Float.NaN;
        this.f13956o = Float.NaN;
        this.f13957p = Float.NaN;
        c(r10, null);
    }

    public static /* synthetic */ float a(ImageFilterButton r10) {
        return r10.f13944c;
    }

    public static /* synthetic */ float b(ImageFilterButton r10) {
        return r10.f13945d;
    }

    private void c(Context r10, AttributeSet r11) {
        setPadding(0, 0, 0, 0);
        if (r11 == null) goto L64;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.ImageFilterView);
        int r13 = r12.getIndexCount();
        this.f13952k = r12.getDrawable(R$styleable.ImageFilterView_altSrc);
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L40;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.ImageFilterView_crossfade) goto L10;
        this.f13943b = r12.getFloat(r15, 0.0f);
    L39:
        r14 = r14 + 1;
        goto L5
    L10:
        if (r15 != R$styleable.ImageFilterView_warmth) goto L13;
        setWarmth(r12.getFloat(r15, 0.0f));
        goto L39
    L13:
        if (r15 != R$styleable.ImageFilterView_saturation) goto L16;
        setSaturation(r12.getFloat(r15, 0.0f));
        goto L39
    L16:
        if (r15 != R$styleable.ImageFilterView_contrast) goto L19;
        setContrast(r12.getFloat(r15, 0.0f));
        goto L39
    L19:
        if (r15 != R$styleable.ImageFilterView_round) goto L22;
        setRound(r12.getDimension(r15, 0.0f));
        goto L39
    L22:
        if (r15 != R$styleable.ImageFilterView_roundPercent) goto L25;
        setRoundPercent(r12.getFloat(r15, 0.0f));
        goto L39
    L25:
        if (r15 != R$styleable.ImageFilterView_overlay) goto L28;
        setOverlay(r12.getBoolean(r15, this.f13951j));
        goto L39
    L28:
        if (r15 != R$styleable.ImageFilterView_imagePanX) goto L31;
        setImagePanX(r12.getFloat(r15, this.f13954m));
        goto L39
    L31:
        if (r15 != R$styleable.ImageFilterView_imagePanY) goto L34;
        setImagePanY(r12.getFloat(r15, this.f13955n));
        goto L39
    L34:
        if (r15 != R$styleable.ImageFilterView_imageRotate) goto L37;
        setImageRotate(r12.getFloat(r15, this.f13957p));
        goto L39
    L37:
        if (r15 != R$styleable.ImageFilterView_imageZoom) goto L39;
        setImageZoom(r12.getFloat(r15, this.f13956o));
        goto L39
    L40:
        r12.recycle();
        Drawable r16 = getDrawable();
        this.f13953l = r16;
        if (this.f13952k == null) goto L47;
        if (r16 == null) goto L47;
        Drawable[] r17 = this.f13949h;
        Drawable r18 = getDrawable().mutate();
        this.f13953l = r18;
        r17[0] = r18;
        this.f13949h[1] = this.f13952k.mutate();
        LayerDrawable r19 = new LayerDrawable(this.f13949h);
        this.f13950i = r19;
        r19.getDrawable(1).setAlpha((int) (this.f13943b * 255.0f));
        if (this.f13951j == true) goto L46;
        this.f13950i.getDrawable(0).setAlpha((int) ((1.0f - this.f13943b) * 255.0f));
    L46:
        super.setImageDrawable(this.f13950i);
        return;
    L47:
        Drawable r20 = getDrawable();
        this.f13953l = r20;
        if (r20 == null) goto L66;
        Drawable[] r21 = this.f13949h;
        Drawable r22 = r20.mutate();
        this.f13953l = r22;
        r21[0] = r22;
        return;
    L66:
        return;
    }

    private void d() {
        if (Float.isNaN(this.f13954m) == true) goto L5;
    L11:
        float r10 = 0.0f;
        if (Float.isNaN(this.f13954m) == false) goto L14;
        float r11 = 0.0f;
    L16:
        if (Float.isNaN(this.f13955n) == false) goto L18;
        float r12 = 0.0f;
    L20:
        if (Float.isNaN(this.f13956o) == false) goto L22;
        float r13 = 1.0f;
    L24:
        if (Float.isNaN(this.f13957p) == true) goto L27;
        r10 = this.f13957p;
    L27:
        Matrix r14 = new Matrix();
        r14.reset();
        float r15 = getDrawable().getIntrinsicWidth();
        float r16 = getDrawable().getIntrinsicHeight();
        float r17 = getWidth();
        float r18 = getHeight();
        if ((r15 * r18) >= (r16 * r17)) goto L30;
        float r19 = r17 / r15;
    L31:
        float r20 = r13 * r19;
        r14.postScale(r20, r20);
        float r21 = r15 * r20;
        float r22 = r20 * r16;
        r14.postTranslate((((r11 * (r17 - r21)) + r17) - r21) * 0.5f, (((r12 * (r18 - r22)) + r18) - r22) * 0.5f);
        r14.postRotate(r10, r17 / 2.0f, r18 / 2.0f);
        setImageMatrix(r14);
        setScaleType(ImageView.ScaleType.MATRIX);
        return;
    L30:
        r19 = r18 / r16;
        goto L31
    L22:
        r13 = this.f13956o;
        goto L24
    L18:
        r12 = this.f13955n;
        goto L20
    L14:
        r11 = this.f13954m;
        goto L16
    L5:
        if (Float.isNaN(this.f13955n) == false) goto L11;
        if (Float.isNaN(this.f13956o) == false) goto L11;
        if (Float.isNaN(this.f13957p) == false) goto L11;
    }

    private void e() {
        if (Float.isNaN(this.f13954m) == true) goto L5;
    L12:
        d();
        return;
    L5:
        if (Float.isNaN(this.f13955n) == false) goto L12;
        if (Float.isNaN(this.f13956o) == false) goto L12;
        if (Float.isNaN(this.f13957p) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private void setOverlay(boolean r10) {
        this.f13951j = r10;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
    }

    public float getContrast() {
        return this.f13942a.f13983f;
    }

    public float getCrossfade() {
        return this.f13943b;
    }

    public float getImagePanX() {
        return this.f13954m;
    }

    public float getImagePanY() {
        return this.f13955n;
    }

    public float getImageRotate() {
        return this.f13957p;
    }

    public float getImageZoom() {
        return this.f13956o;
    }

    public float getRound() {
        return this.f13945d;
    }

    public float getRoundPercent() {
        return this.f13944c;
    }

    public float getSaturation() {
        return this.f13942a.f13982e;
    }

    public float getWarmth() {
        return this.f13942a.f13984g;
    }

    @Override // android.view.View
    public void layout(int r10, int r11, int r12, int r13) {
        super.layout(r10, r11, r12, r13);
        d();
    }

    public void setAltImageResource(int r10) {
        Drawable r11 = c.a.b(getContext(), r10).mutate();
        this.f13952k = r11;
        Drawable[] r12 = this.f13949h;
        r12[0] = this.f13953l;
        r12[1] = r11;
        LayerDrawable r13 = new LayerDrawable(this.f13949h);
        this.f13950i = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f13943b);
    }

    public void setBrightness(float r10) {
        ImageFilterView.c r11 = this.f13942a;
        r11.f13981d = r10;
        r11.c(this);
    }

    public void setContrast(float r10) {
        ImageFilterView.c r11 = this.f13942a;
        r11.f13983f = r10;
        r11.c(this);
    }

    public void setCrossfade(float r10) {
        this.f13943b = r10;
        if (this.f13949h != null) goto L5;
        return;
    L5:
        if (this.f13951j == true) goto L7;
        this.f13950i.getDrawable(0).setAlpha((int) ((1.0f - this.f13943b) * 255.0f));
    L7:
        this.f13950i.getDrawable(1).setAlpha((int) (this.f13943b * 255.0f));
        super.setImageDrawable(this.f13950i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        if (this.f13952k == null) goto L6;
        if (r10 == null) goto L6;
        Drawable r11 = r10.mutate();
        this.f13953l = r11;
        Drawable[] r12 = this.f13949h;
        r12[0] = r11;
        r12[1] = this.f13952k;
        LayerDrawable r13 = new LayerDrawable(this.f13949h);
        this.f13950i = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f13943b);
        return;
    L6:
        super.setImageDrawable(r10);
    }

    public void setImagePanX(float r10) {
        this.f13954m = r10;
        e();
    }

    public void setImagePanY(float r10) {
        this.f13955n = r10;
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int r10) {
        if (this.f13952k == null) goto L5;
        Drawable r11 = c.a.b(getContext(), r10).mutate();
        this.f13953l = r11;
        Drawable[] r12 = this.f13949h;
        r12[0] = r11;
        r12[1] = this.f13952k;
        LayerDrawable r13 = new LayerDrawable(this.f13949h);
        this.f13950i = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f13943b);
        return;
    L5:
        super.setImageResource(r10);
    }

    public void setImageRotate(float r10) {
        this.f13957p = r10;
        e();
    }

    public void setImageZoom(float r10) {
        this.f13956o = r10;
        e();
    }

    public void setRound(float r10) {
        if (Float.isNaN(r10) == false) goto L7;
        this.f13945d = r10;
        float r11 = this.f13944c;
        this.f13944c = -1.0f;
        setRoundPercent(r11);
        return;
    L7:
        if (this.f13945d == r10) goto L9;
        boolean r12 = true;
    L10:
        this.f13945d = r10;
        if (r10 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r12 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f13946e != null) goto L16;
        this.f13946e = new Path();
    L16:
        if (this.f13948g != null) goto L19;
        this.f13948g = new RectF();
    L19:
        if (this.f13947f != null) goto L21;
        b r13 = new b(this);
        this.f13947f = r13;
        setOutlineProvider(r13);
    L21:
        setClipToOutline(true);
        this.f13948g.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f13946e.reset();
        Path r14 = this.f13946e;
        RectF r15 = this.f13948g;
        float r16 = this.f13945d;
        r14.addRoundRect(r15, r16, r16, Path.Direction.CW);
        goto L23
    L9:
        r12 = false;
        goto L10
    }

    public void setRoundPercent(float r10) {
        if (this.f13944c == r10) goto L5;
        boolean r11 = true;
    L6:
        this.f13944c = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r11 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f13946e != null) goto L12;
        this.f13946e = new Path();
    L12:
        if (this.f13948g != null) goto L15;
        this.f13948g = new RectF();
    L15:
        if (this.f13947f != null) goto L17;
        a r12 = new a(this);
        this.f13947f = r12;
        setOutlineProvider(r12);
    L17:
        setClipToOutline(true);
        int r13 = getWidth();
        int r14 = getHeight();
        float r15 = (Math.min(r13, r14) * this.f13944c) / 2.0f;
        this.f13948g.set(0.0f, 0.0f, r13, r14);
        this.f13946e.reset();
        this.f13946e.addRoundRect(this.f13948g, r15, r15, Path.Direction.CW);
        goto L19
    L5:
        r11 = false;
        goto L6
    }

    public void setSaturation(float r10) {
        ImageFilterView.c r11 = this.f13942a;
        r11.f13982e = r10;
        r11.c(this);
    }

    public void setWarmth(float r10) {
        ImageFilterView.c r11 = this.f13942a;
        r11.f13984g = r10;
        r11.c(this);
    }

    public ImageFilterButton(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f13942a = new ImageFilterView.c();
        this.f13943b = 0.0f;
        this.f13944c = 0.0f;
        this.f13945d = Float.NaN;
        this.f13949h = new Drawable[2];
        this.f13951j = true;
        this.f13952k = null;
        this.f13953l = null;
        this.f13954m = Float.NaN;
        this.f13955n = Float.NaN;
        this.f13956o = Float.NaN;
        this.f13957p = Float.NaN;
        c(r10, r11);
    }

    public ImageFilterButton(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f13942a = new ImageFilterView.c();
        this.f13943b = 0.0f;
        this.f13944c = 0.0f;
        this.f13945d = Float.NaN;
        this.f13949h = new Drawable[2];
        this.f13951j = true;
        this.f13952k = null;
        this.f13953l = null;
        this.f13954m = Float.NaN;
        this.f13955n = Float.NaN;
        this.f13956o = Float.NaN;
        this.f13957p = Float.NaN;
        c(r10, r11);
    }
}
