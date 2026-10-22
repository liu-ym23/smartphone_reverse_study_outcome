package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class ImageFilterView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f13960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f13962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f13963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f13964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f13965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f13966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f13967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewOutlineProvider f13968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f13969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable[] f13970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LayerDrawable f13971l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13972m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13973n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13974o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13975p;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterView f13976a;

        public a(ImageFilterView r10) {
            this.f13976a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            int r12 = this.f13976a.getWidth();
            int r13 = this.f13976a.getHeight();
            r11.setRoundRect(0, 0, r12, r13, (Math.min(r12, r13) * ImageFilterView.a(this.f13976a)) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterView f13977a;

        public b(ImageFilterView r10) {
            this.f13977a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            r11.setRoundRect(0, 0, this.f13977a.getWidth(), this.f13977a.getHeight(), ImageFilterView.b(this.f13977a));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f13978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ColorMatrix f13979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorMatrix f13980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f13981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f13982e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f13983f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f13984g;

        public c() {
            this.f13978a = new float[20];
            this.f13979b = new ColorMatrix();
            this.f13980c = new ColorMatrix();
            this.f13981d = 1.0f;
            this.f13982e = 1.0f;
            this.f13983f = 1.0f;
            this.f13984g = 1.0f;
        }

        public final void a(float r10) {
            float[] r11 = this.f13978a;
            r11[0] = r10;
            r11[1] = 0.0f;
            r11[2] = 0.0f;
            r11[3] = 0.0f;
            r11[4] = 0.0f;
            r11[5] = 0.0f;
            r11[6] = r10;
            r11[7] = 0.0f;
            r11[8] = 0.0f;
            r11[9] = 0.0f;
            r11[10] = 0.0f;
            r11[11] = 0.0f;
            r11[12] = r10;
            r11[13] = 0.0f;
            r11[14] = 0.0f;
            r11[15] = 0.0f;
            r11[16] = 0.0f;
            r11[17] = 0.0f;
            r11[18] = 1.0f;
            r11[19] = 0.0f;
        }

        public final void b(float r10) {
            float r11 = 1.0f - r10;
            float r12 = 0.2999f * r11;
            float r13 = 0.587f * r11;
            float r14 = r11 * 0.114f;
            float[] r15 = this.f13978a;
            r15[0] = r12 + r10;
            r15[1] = r13;
            r15[2] = r14;
            r15[3] = 0.0f;
            r15[4] = 0.0f;
            r15[5] = r12;
            r15[6] = r13 + r10;
            r15[7] = r14;
            r15[8] = 0.0f;
            r15[9] = 0.0f;
            r15[10] = r12;
            r15[11] = r13;
            r15[12] = r14 + r10;
            r15[13] = 0.0f;
            r15[14] = 0.0f;
            r15[15] = 0.0f;
            r15[16] = 0.0f;
            r15[17] = 0.0f;
            r15[18] = 1.0f;
            r15[19] = 0.0f;
        }

        public void c(ImageView r10) {
            this.f13979b.reset();
            float r11 = this.f13982e;
            boolean r12 = true;
            if (r11 == 1.0f) goto L5;
            b(r11);
            this.f13979b.set(this.f13978a);
            boolean r13 = true;
        L6:
            float r14 = this.f13983f;
            if (r14 == 1.0f) goto L9;
            this.f13980c.setScale(r14, r14, r14, 1.0f);
            this.f13979b.postConcat(this.f13980c);
            r13 = true;
        L9:
            float r15 = this.f13984g;
            if (r15 == 1.0f) goto L12;
            d(r15);
            this.f13980c.set(this.f13978a);
            this.f13979b.postConcat(this.f13980c);
            r13 = true;
        L12:
            float r16 = this.f13981d;
            if (r16 == 1.0f) goto L15;
            a(r16);
            this.f13980c.set(this.f13978a);
            this.f13979b.postConcat(this.f13980c);
        L16:
            if (r12 == false) goto L18;
            r10.setColorFilter(new ColorMatrixColorFilter(this.f13979b));
            return;
        L18:
            r10.clearColorFilter();
            return;
        L15:
            r12 = r13;
            goto L16
        L5:
            r13 = false;
            goto L6
        }

        public final void d(float r12) {
            if (r12 > 0.0f) goto L5;
            r12 = 0.01f;
        L5:
            float r10 = (5000.0f / r12) / 100.0f;
            if (r10 <= 66.0f) goto L8;
            double r11 = r10 - 60.0f;
            float r13 = ((float) Math.pow(r11, -0.13320475816726685d)) * 329.69873f;
            float r14 = ((float) Math.pow(r11, 0.07551485300064087d)) * 288.12216f;
        L10:
            if (r10 < 66.0f) goto L12;
            float r15 = 255.0f;
        L16:
            float r16 = Math.min(255.0f, Math.max(r13, 0.0f));
            float r17 = Math.min(255.0f, Math.max(r14, 0.0f));
            float r18 = Math.min(255.0f, Math.max(r15, 0.0f));
            float r19 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float r20 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float r21 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float r22 = Math.min(255.0f, Math.max(r19, 0.0f));
            float r110 = r18 / Math.min(255.0f, Math.max(r20, 0.0f));
            float[] r111 = this.f13978a;
            r111[0] = r16 / r21;
            r111[1] = 0.0f;
            r111[2] = 0.0f;
            r111[3] = 0.0f;
            r111[4] = 0.0f;
            r111[5] = 0.0f;
            r111[6] = r17 / r22;
            r111[7] = 0.0f;
            r111[8] = 0.0f;
            r111[9] = 0.0f;
            r111[10] = 0.0f;
            r111[11] = 0.0f;
            r111[12] = r110;
            r111[13] = 0.0f;
            r111[14] = 0.0f;
            r111[15] = 0.0f;
            r111[16] = 0.0f;
            r111[17] = 0.0f;
            r111[18] = 1.0f;
            r111[19] = 0.0f;
            return;
        L12:
            if (r10 <= 19.0f) goto L14;
            r15 = (((float) Math.log(r10 - 10.0f)) * 138.51773f) - 305.0448f;
            goto L16
        L14:
            r15 = 0.0f;
            goto L16
        L8:
            r14 = (((float) Math.log(r10)) * 99.4708f) - 161.11957f;
            r13 = 255.0f;
            goto L10
        }
    }

    public ImageFilterView(Context r10) {
        super(r10);
        this.f13960a = new c();
        this.f13961b = true;
        this.f13962c = null;
        this.f13963d = null;
        this.f13964e = 0.0f;
        this.f13965f = 0.0f;
        this.f13966g = Float.NaN;
        this.f13970k = new Drawable[2];
        this.f13972m = Float.NaN;
        this.f13973n = Float.NaN;
        this.f13974o = Float.NaN;
        this.f13975p = Float.NaN;
        c(r10, null);
    }

    public static /* synthetic */ float a(ImageFilterView r10) {
        return r10.f13965f;
    }

    public static /* synthetic */ float b(ImageFilterView r10) {
        return r10.f13966g;
    }

    private void c(Context r10, AttributeSet r11) {
        if (r11 == null) goto L67;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.ImageFilterView);
        int r13 = r12.getIndexCount();
        this.f13962c = r12.getDrawable(R$styleable.ImageFilterView_altSrc);
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L42;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.ImageFilterView_crossfade) goto L9;
        this.f13964e = r12.getFloat(r15, 0.0f);
    L41:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R$styleable.ImageFilterView_warmth) goto L12;
        setWarmth(r12.getFloat(r15, 0.0f));
        goto L41
    L12:
        if (r15 != R$styleable.ImageFilterView_saturation) goto L15;
        setSaturation(r12.getFloat(r15, 0.0f));
        goto L41
    L15:
        if (r15 != R$styleable.ImageFilterView_contrast) goto L18;
        setContrast(r12.getFloat(r15, 0.0f));
        goto L41
    L18:
        if (r15 != R$styleable.ImageFilterView_brightness) goto L21;
        setBrightness(r12.getFloat(r15, 0.0f));
        goto L41
    L21:
        if (r15 != R$styleable.ImageFilterView_round) goto L24;
        setRound(r12.getDimension(r15, 0.0f));
        goto L41
    L24:
        if (r15 != R$styleable.ImageFilterView_roundPercent) goto L27;
        setRoundPercent(r12.getFloat(r15, 0.0f));
        goto L41
    L27:
        if (r15 != R$styleable.ImageFilterView_overlay) goto L30;
        setOverlay(r12.getBoolean(r15, this.f13961b));
        goto L41
    L30:
        if (r15 != R$styleable.ImageFilterView_imagePanX) goto L33;
        setImagePanX(r12.getFloat(r15, this.f13972m));
        goto L41
    L33:
        if (r15 != R$styleable.ImageFilterView_imagePanY) goto L36;
        setImagePanY(r12.getFloat(r15, this.f13973n));
        goto L41
    L36:
        if (r15 != R$styleable.ImageFilterView_imageRotate) goto L39;
        setImageRotate(r12.getFloat(r15, this.f13975p));
        goto L41
    L39:
        if (r15 != R$styleable.ImageFilterView_imageZoom) goto L41;
        setImageZoom(r12.getFloat(r15, this.f13974o));
        goto L41
    L42:
        r12.recycle();
        Drawable r16 = getDrawable();
        this.f13963d = r16;
        if (this.f13962c == null) goto L49;
        if (r16 == null) goto L49;
        Drawable[] r17 = this.f13970k;
        Drawable r18 = getDrawable().mutate();
        this.f13963d = r18;
        r17[0] = r18;
        this.f13970k[1] = this.f13962c.mutate();
        LayerDrawable r19 = new LayerDrawable(this.f13970k);
        this.f13971l = r19;
        r19.getDrawable(1).setAlpha((int) (this.f13964e * 255.0f));
        if (this.f13961b == true) goto L48;
        this.f13971l.getDrawable(0).setAlpha((int) ((1.0f - this.f13964e) * 255.0f));
    L48:
        super.setImageDrawable(this.f13971l);
        return;
    L49:
        Drawable r20 = getDrawable();
        this.f13963d = r20;
        if (r20 == null) goto L69;
        Drawable[] r21 = this.f13970k;
        Drawable r22 = r20.mutate();
        this.f13963d = r22;
        r21[0] = r22;
        return;
    L69:
        return;
    }

    private void d() {
        if (Float.isNaN(this.f13972m) == true) goto L5;
    L11:
        float r10 = 0.0f;
        if (Float.isNaN(this.f13972m) == false) goto L14;
        float r11 = 0.0f;
    L16:
        if (Float.isNaN(this.f13973n) == false) goto L18;
        float r12 = 0.0f;
    L20:
        if (Float.isNaN(this.f13974o) == false) goto L22;
        float r13 = 1.0f;
    L24:
        if (Float.isNaN(this.f13975p) == true) goto L27;
        r10 = this.f13975p;
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
        r13 = this.f13974o;
        goto L24
    L18:
        r12 = this.f13973n;
        goto L20
    L14:
        r11 = this.f13972m;
        goto L16
    L5:
        if (Float.isNaN(this.f13973n) == false) goto L11;
        if (Float.isNaN(this.f13974o) == false) goto L11;
        if (Float.isNaN(this.f13975p) == false) goto L11;
    }

    private void e() {
        if (Float.isNaN(this.f13972m) == true) goto L5;
    L12:
        d();
        return;
    L5:
        if (Float.isNaN(this.f13973n) == false) goto L12;
        if (Float.isNaN(this.f13974o) == false) goto L12;
        if (Float.isNaN(this.f13975p) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private void setOverlay(boolean r10) {
        this.f13961b = r10;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
    }

    public float getBrightness() {
        return this.f13960a.f13981d;
    }

    public float getContrast() {
        return this.f13960a.f13983f;
    }

    public float getCrossfade() {
        return this.f13964e;
    }

    public float getImagePanX() {
        return this.f13972m;
    }

    public float getImagePanY() {
        return this.f13973n;
    }

    public float getImageRotate() {
        return this.f13975p;
    }

    public float getImageZoom() {
        return this.f13974o;
    }

    public float getRound() {
        return this.f13966g;
    }

    public float getRoundPercent() {
        return this.f13965f;
    }

    public float getSaturation() {
        return this.f13960a.f13982e;
    }

    public float getWarmth() {
        return this.f13960a.f13984g;
    }

    @Override // android.view.View
    public void layout(int r10, int r11, int r12, int r13) {
        super.layout(r10, r11, r12, r13);
        d();
    }

    public void setAltImageDrawable(Drawable r10) {
        Drawable r11 = r10.mutate();
        this.f13962c = r11;
        Drawable[] r12 = this.f13970k;
        r12[0] = this.f13963d;
        r12[1] = r11;
        LayerDrawable r13 = new LayerDrawable(this.f13970k);
        this.f13971l = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f13964e);
    }

    public void setAltImageResource(int r10) {
        Drawable r11 = c.a.b(getContext(), r10);
        this.f13962c = r11;
        setAltImageDrawable(r11);
    }

    public void setBrightness(float r10) {
        c r11 = this.f13960a;
        r11.f13981d = r10;
        r11.c(this);
    }

    public void setContrast(float r10) {
        c r11 = this.f13960a;
        r11.f13983f = r10;
        r11.c(this);
    }

    public void setCrossfade(float r10) {
        this.f13964e = r10;
        if (this.f13970k != null) goto L5;
        return;
    L5:
        if (this.f13961b == true) goto L7;
        this.f13971l.getDrawable(0).setAlpha((int) ((1.0f - this.f13964e) * 255.0f));
    L7:
        this.f13971l.getDrawable(1).setAlpha((int) (this.f13964e * 255.0f));
        super.setImageDrawable(this.f13971l);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        if (this.f13962c == null) goto L6;
        if (r10 == null) goto L6;
        Drawable r11 = r10.mutate();
        this.f13963d = r11;
        Drawable[] r12 = this.f13970k;
        r12[0] = r11;
        r12[1] = this.f13962c;
        LayerDrawable r13 = new LayerDrawable(this.f13970k);
        this.f13971l = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f13964e);
        return;
    L6:
        super.setImageDrawable(r10);
    }

    public void setImagePanX(float r10) {
        this.f13972m = r10;
        e();
    }

    public void setImagePanY(float r10) {
        this.f13973n = r10;
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r10) {
        if (this.f13962c == null) goto L5;
        Drawable r11 = c.a.b(getContext(), r10).mutate();
        this.f13963d = r11;
        Drawable[] r12 = this.f13970k;
        r12[0] = r11;
        r12[1] = this.f13962c;
        LayerDrawable r13 = new LayerDrawable(this.f13970k);
        this.f13971l = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f13964e);
        return;
    L5:
        super.setImageResource(r10);
    }

    public void setImageRotate(float r10) {
        this.f13975p = r10;
        e();
    }

    public void setImageZoom(float r10) {
        this.f13974o = r10;
        e();
    }

    public void setRound(float r10) {
        if (Float.isNaN(r10) == false) goto L7;
        this.f13966g = r10;
        float r11 = this.f13965f;
        this.f13965f = -1.0f;
        setRoundPercent(r11);
        return;
    L7:
        if (this.f13966g == r10) goto L9;
        boolean r12 = true;
    L10:
        this.f13966g = r10;
        if (r10 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r12 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f13967h != null) goto L16;
        this.f13967h = new Path();
    L16:
        if (this.f13969j != null) goto L19;
        this.f13969j = new RectF();
    L19:
        if (this.f13968i != null) goto L21;
        b r13 = new b(this);
        this.f13968i = r13;
        setOutlineProvider(r13);
    L21:
        setClipToOutline(true);
        this.f13969j.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f13967h.reset();
        Path r14 = this.f13967h;
        RectF r15 = this.f13969j;
        float r16 = this.f13966g;
        r14.addRoundRect(r15, r16, r16, Path.Direction.CW);
        goto L23
    L9:
        r12 = false;
        goto L10
    }

    public void setRoundPercent(float r10) {
        if (this.f13965f == r10) goto L5;
        boolean r11 = true;
    L6:
        this.f13965f = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r11 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f13967h != null) goto L12;
        this.f13967h = new Path();
    L12:
        if (this.f13969j != null) goto L15;
        this.f13969j = new RectF();
    L15:
        if (this.f13968i != null) goto L17;
        a r12 = new a(this);
        this.f13968i = r12;
        setOutlineProvider(r12);
    L17:
        setClipToOutline(true);
        int r13 = getWidth();
        int r14 = getHeight();
        float r15 = (Math.min(r13, r14) * this.f13965f) / 2.0f;
        this.f13969j.set(0.0f, 0.0f, r13, r14);
        this.f13967h.reset();
        this.f13967h.addRoundRect(this.f13969j, r15, r15, Path.Direction.CW);
        goto L19
    L5:
        r11 = false;
        goto L6
    }

    public void setSaturation(float r10) {
        c r11 = this.f13960a;
        r11.f13982e = r10;
        r11.c(this);
    }

    public void setWarmth(float r10) {
        c r11 = this.f13960a;
        r11.f13984g = r10;
        r11.c(this);
    }

    public ImageFilterView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f13960a = new c();
        this.f13961b = true;
        this.f13962c = null;
        this.f13963d = null;
        this.f13964e = 0.0f;
        this.f13965f = 0.0f;
        this.f13966g = Float.NaN;
        this.f13970k = new Drawable[2];
        this.f13972m = Float.NaN;
        this.f13973n = Float.NaN;
        this.f13974o = Float.NaN;
        this.f13975p = Float.NaN;
        c(r10, r11);
    }

    public ImageFilterView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f13960a = new c();
        this.f13961b = true;
        this.f13962c = null;
        this.f13963d = null;
        this.f13964e = 0.0f;
        this.f13965f = 0.0f;
        this.f13966g = Float.NaN;
        this.f13970k = new Drawable[2];
        this.f13972m = Float.NaN;
        this.f13973n = Float.NaN;
        this.f13974o = Float.NaN;
        this.f13975p = Float.NaN;
        c(r10, r11);
    }
}
