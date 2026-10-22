package androidx.constraintlayout.utils.widget;

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
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageFilterView.c f2068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f2072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewOutlineProvider f2073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f2074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable[] f2075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LayerDrawable f2076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f2078k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f2079l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f2080m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f2081n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f2082o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2083p;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterButton f2084a;

        public a(ImageFilterButton r10) {
            this.f2084a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            int r12 = this.f2084a.getWidth();
            int r13 = this.f2084a.getHeight();
            r11.setRoundRect(0, 0, r12, r13, (Math.min(r12, r13) * ImageFilterButton.a(this.f2084a)) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterButton f2085a;

        public b(ImageFilterButton r10) {
            this.f2085a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            r11.setRoundRect(0, 0, this.f2085a.getWidth(), this.f2085a.getHeight(), ImageFilterButton.b(this.f2085a));
        }
    }

    public ImageFilterButton(Context r10) {
        super(r10);
        this.f2068a = new ImageFilterView.c();
        this.f2069b = 0.0f;
        this.f2070c = 0.0f;
        this.f2071d = Float.NaN;
        this.f2075h = new Drawable[2];
        this.f2077j = true;
        this.f2078k = null;
        this.f2079l = null;
        this.f2080m = Float.NaN;
        this.f2081n = Float.NaN;
        this.f2082o = Float.NaN;
        this.f2083p = Float.NaN;
        c(r10, null);
    }

    public static /* synthetic */ float a(ImageFilterButton r10) {
        return r10.f2070c;
    }

    public static /* synthetic */ float b(ImageFilterButton r10) {
        return r10.f2071d;
    }

    private void c(Context r10, AttributeSet r11) {
        setPadding(0, 0, 0, 0);
        if (r11 == null) goto L64;
        TypedArray r12 = getContext().obtainStyledAttributes(r11, R$styleable.ImageFilterView);
        int r13 = r12.getIndexCount();
        this.f2078k = r12.getDrawable(R$styleable.ImageFilterView_altSrc);
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L40;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.ImageFilterView_crossfade) goto L10;
        this.f2069b = r12.getFloat(r15, 0.0f);
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
        setOverlay(r12.getBoolean(r15, this.f2077j));
        goto L39
    L28:
        if (r15 != R$styleable.ImageFilterView_imagePanX) goto L31;
        setImagePanX(r12.getFloat(r15, this.f2080m));
        goto L39
    L31:
        if (r15 != R$styleable.ImageFilterView_imagePanY) goto L34;
        setImagePanY(r12.getFloat(r15, this.f2081n));
        goto L39
    L34:
        if (r15 != R$styleable.ImageFilterView_imageRotate) goto L37;
        setImageRotate(r12.getFloat(r15, this.f2083p));
        goto L39
    L37:
        if (r15 != R$styleable.ImageFilterView_imageZoom) goto L39;
        setImageZoom(r12.getFloat(r15, this.f2082o));
        goto L39
    L40:
        r12.recycle();
        Drawable r16 = getDrawable();
        this.f2079l = r16;
        if (this.f2078k == null) goto L47;
        if (r16 == null) goto L47;
        Drawable[] r17 = this.f2075h;
        Drawable r18 = getDrawable().mutate();
        this.f2079l = r18;
        r17[0] = r18;
        this.f2075h[1] = this.f2078k.mutate();
        LayerDrawable r19 = new LayerDrawable(this.f2075h);
        this.f2076i = r19;
        r19.getDrawable(1).setAlpha((int) (this.f2069b * 255.0f));
        if (this.f2077j == true) goto L46;
        this.f2076i.getDrawable(0).setAlpha((int) ((1.0f - this.f2069b) * 255.0f));
    L46:
        super.setImageDrawable(this.f2076i);
        return;
    L47:
        Drawable r20 = getDrawable();
        this.f2079l = r20;
        if (r20 == null) goto L66;
        Drawable[] r21 = this.f2075h;
        Drawable r22 = r20.mutate();
        this.f2079l = r22;
        r21[0] = r22;
        return;
    L66:
        return;
    }

    private void setOverlay(boolean r10) {
        this.f2077j = r10;
    }

    public final void d() {
        if (Float.isNaN(this.f2080m) == true) goto L5;
    L11:
        float r10 = 0.0f;
        if (Float.isNaN(this.f2080m) == false) goto L14;
        float r11 = 0.0f;
    L16:
        if (Float.isNaN(this.f2081n) == false) goto L18;
        float r12 = 0.0f;
    L20:
        if (Float.isNaN(this.f2082o) == false) goto L22;
        float r13 = 1.0f;
    L24:
        if (Float.isNaN(this.f2083p) == true) goto L27;
        r10 = this.f2083p;
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
        r13 = this.f2082o;
        goto L24
    L18:
        r12 = this.f2081n;
        goto L20
    L14:
        r11 = this.f2080m;
        goto L16
    L5:
        if (Float.isNaN(this.f2081n) == false) goto L11;
        if (Float.isNaN(this.f2082o) == false) goto L11;
        if (Float.isNaN(this.f2083p) == false) goto L11;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
    }

    public final void e() {
        if (Float.isNaN(this.f2080m) == true) goto L5;
    L12:
        d();
        return;
    L5:
        if (Float.isNaN(this.f2081n) == false) goto L12;
        if (Float.isNaN(this.f2082o) == false) goto L12;
        if (Float.isNaN(this.f2083p) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public float getContrast() {
        return this.f2068a.f2109f;
    }

    public float getCrossfade() {
        return this.f2069b;
    }

    public float getImagePanX() {
        return this.f2080m;
    }

    public float getImagePanY() {
        return this.f2081n;
    }

    public float getImageRotate() {
        return this.f2083p;
    }

    public float getImageZoom() {
        return this.f2082o;
    }

    public float getRound() {
        return this.f2071d;
    }

    public float getRoundPercent() {
        return this.f2070c;
    }

    public float getSaturation() {
        return this.f2068a.f2108e;
    }

    public float getWarmth() {
        return this.f2068a.f2110g;
    }

    @Override // android.view.View
    public void layout(int r10, int r11, int r12, int r13) {
        super.layout(r10, r11, r12, r13);
        d();
    }

    public void setAltImageResource(int r10) {
        Drawable r11 = c.a.b(getContext(), r10).mutate();
        this.f2078k = r11;
        Drawable[] r12 = this.f2075h;
        r12[0] = this.f2079l;
        r12[1] = r11;
        LayerDrawable r13 = new LayerDrawable(this.f2075h);
        this.f2076i = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f2069b);
    }

    public void setBrightness(float r10) {
        ImageFilterView.c r11 = this.f2068a;
        r11.f2107d = r10;
        r11.c(this);
    }

    public void setContrast(float r10) {
        ImageFilterView.c r11 = this.f2068a;
        r11.f2109f = r10;
        r11.c(this);
    }

    public void setCrossfade(float r10) {
        this.f2069b = r10;
        if (this.f2075h != null) goto L5;
        return;
    L5:
        if (this.f2077j == true) goto L7;
        this.f2076i.getDrawable(0).setAlpha((int) ((1.0f - this.f2069b) * 255.0f));
    L7:
        this.f2076i.getDrawable(1).setAlpha((int) (this.f2069b * 255.0f));
        super.setImageDrawable(this.f2076i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        if (this.f2078k == null) goto L6;
        if (r10 == null) goto L6;
        Drawable r11 = r10.mutate();
        this.f2079l = r11;
        Drawable[] r12 = this.f2075h;
        r12[0] = r11;
        r12[1] = this.f2078k;
        LayerDrawable r13 = new LayerDrawable(this.f2075h);
        this.f2076i = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f2069b);
        return;
    L6:
        super.setImageDrawable(r10);
    }

    public void setImagePanX(float r10) {
        this.f2080m = r10;
        e();
    }

    public void setImagePanY(float r10) {
        this.f2081n = r10;
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int r10) {
        if (this.f2078k == null) goto L5;
        Drawable r11 = c.a.b(getContext(), r10).mutate();
        this.f2079l = r11;
        Drawable[] r12 = this.f2075h;
        r12[0] = r11;
        r12[1] = this.f2078k;
        LayerDrawable r13 = new LayerDrawable(this.f2075h);
        this.f2076i = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f2069b);
        return;
    L5:
        super.setImageResource(r10);
    }

    public void setImageRotate(float r10) {
        this.f2083p = r10;
        e();
    }

    public void setImageZoom(float r10) {
        this.f2082o = r10;
        e();
    }

    @RequiresApi(21)
    public void setRound(float r10) {
        if (Float.isNaN(r10) == false) goto L7;
        this.f2071d = r10;
        float r11 = this.f2070c;
        this.f2070c = -1.0f;
        setRoundPercent(r11);
        return;
    L7:
        if (this.f2071d == r10) goto L9;
        boolean r12 = true;
    L10:
        this.f2071d = r10;
        if (r10 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r12 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f2072e != null) goto L16;
        this.f2072e = new Path();
    L16:
        if (this.f2074g != null) goto L19;
        this.f2074g = new RectF();
    L19:
        if (this.f2073f != null) goto L21;
        b r13 = new b(this);
        this.f2073f = r13;
        setOutlineProvider(r13);
    L21:
        setClipToOutline(true);
        this.f2074g.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f2072e.reset();
        Path r14 = this.f2072e;
        RectF r15 = this.f2074g;
        float r16 = this.f2071d;
        r14.addRoundRect(r15, r16, r16, Path.Direction.CW);
        goto L23
    L9:
        r12 = false;
        goto L10
    }

    @RequiresApi(21)
    public void setRoundPercent(float r10) {
        if (this.f2070c == r10) goto L5;
        boolean r11 = true;
    L6:
        this.f2070c = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r11 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f2072e != null) goto L12;
        this.f2072e = new Path();
    L12:
        if (this.f2074g != null) goto L15;
        this.f2074g = new RectF();
    L15:
        if (this.f2073f != null) goto L17;
        a r12 = new a(this);
        this.f2073f = r12;
        setOutlineProvider(r12);
    L17:
        setClipToOutline(true);
        int r13 = getWidth();
        int r14 = getHeight();
        float r15 = (Math.min(r13, r14) * this.f2070c) / 2.0f;
        this.f2074g.set(0.0f, 0.0f, r13, r14);
        this.f2072e.reset();
        this.f2072e.addRoundRect(this.f2074g, r15, r15, Path.Direction.CW);
        goto L19
    L5:
        r11 = false;
        goto L6
    }

    public void setSaturation(float r10) {
        ImageFilterView.c r11 = this.f2068a;
        r11.f2108e = r10;
        r11.c(this);
    }

    public void setWarmth(float r10) {
        ImageFilterView.c r11 = this.f2068a;
        r11.f2110g = r10;
        r11.c(this);
    }

    public ImageFilterButton(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f2068a = new ImageFilterView.c();
        this.f2069b = 0.0f;
        this.f2070c = 0.0f;
        this.f2071d = Float.NaN;
        this.f2075h = new Drawable[2];
        this.f2077j = true;
        this.f2078k = null;
        this.f2079l = null;
        this.f2080m = Float.NaN;
        this.f2081n = Float.NaN;
        this.f2082o = Float.NaN;
        this.f2083p = Float.NaN;
        c(r10, r11);
    }

    public ImageFilterButton(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f2068a = new ImageFilterView.c();
        this.f2069b = 0.0f;
        this.f2070c = 0.0f;
        this.f2071d = Float.NaN;
        this.f2075h = new Drawable[2];
        this.f2077j = true;
        this.f2078k = null;
        this.f2079l = null;
        this.f2080m = Float.NaN;
        this.f2081n = Float.NaN;
        this.f2082o = Float.NaN;
        this.f2083p = Float.NaN;
        c(r10, r11);
    }
}
