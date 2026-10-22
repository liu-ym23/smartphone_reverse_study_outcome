package androidx.constraintlayout.utils.widget;

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
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f2086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f2088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f2089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f2093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewOutlineProvider f2094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f2095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable[] f2096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LayerDrawable f2097l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f2098m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f2099n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f2100o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2101p;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterView f2102a;

        public a(ImageFilterView r10) {
            this.f2102a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            int r12 = this.f2102a.getWidth();
            int r13 = this.f2102a.getHeight();
            r11.setRoundRect(0, 0, r12, r13, (Math.min(r12, r13) * ImageFilterView.a(this.f2102a)) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterView f2103a;

        public b(ImageFilterView r10) {
            this.f2103a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            r11.setRoundRect(0, 0, this.f2103a.getWidth(), this.f2103a.getHeight(), ImageFilterView.b(this.f2103a));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f2104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ColorMatrix f2105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorMatrix f2106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f2108e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f2109f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f2110g;

        public c() {
            this.f2104a = new float[20];
            this.f2105b = new ColorMatrix();
            this.f2106c = new ColorMatrix();
            this.f2107d = 1.0f;
            this.f2108e = 1.0f;
            this.f2109f = 1.0f;
            this.f2110g = 1.0f;
        }

        public final void a(float r10) {
            float[] r11 = this.f2104a;
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
            float[] r15 = this.f2104a;
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
            this.f2105b.reset();
            float r11 = this.f2108e;
            boolean r12 = true;
            if (r11 == 1.0f) goto L5;
            b(r11);
            this.f2105b.set(this.f2104a);
            boolean r13 = true;
        L6:
            float r14 = this.f2109f;
            if (r14 == 1.0f) goto L9;
            this.f2106c.setScale(r14, r14, r14, 1.0f);
            this.f2105b.postConcat(this.f2106c);
            r13 = true;
        L9:
            float r15 = this.f2110g;
            if (r15 == 1.0f) goto L12;
            d(r15);
            this.f2106c.set(this.f2104a);
            this.f2105b.postConcat(this.f2106c);
            r13 = true;
        L12:
            float r16 = this.f2107d;
            if (r16 == 1.0f) goto L15;
            a(r16);
            this.f2106c.set(this.f2104a);
            this.f2105b.postConcat(this.f2106c);
        L16:
            if (r12 == false) goto L18;
            r10.setColorFilter(new ColorMatrixColorFilter(this.f2105b));
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
            float r14 = ((float) Math.pow(r11, 0.07551484555006027d)) * 288.12216f;
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
            float[] r111 = this.f2104a;
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
        this.f2086a = new c();
        this.f2087b = true;
        this.f2088c = null;
        this.f2089d = null;
        this.f2090e = 0.0f;
        this.f2091f = 0.0f;
        this.f2092g = Float.NaN;
        this.f2096k = new Drawable[2];
        this.f2098m = Float.NaN;
        this.f2099n = Float.NaN;
        this.f2100o = Float.NaN;
        this.f2101p = Float.NaN;
        c(r10, null);
    }

    public static /* synthetic */ float a(ImageFilterView r10) {
        return r10.f2091f;
    }

    public static /* synthetic */ float b(ImageFilterView r10) {
        return r10.f2092g;
    }

    private void c(Context r10, AttributeSet r11) {
        if (r11 == null) goto L67;
        TypedArray r12 = getContext().obtainStyledAttributes(r11, R$styleable.ImageFilterView);
        int r13 = r12.getIndexCount();
        this.f2088c = r12.getDrawable(R$styleable.ImageFilterView_altSrc);
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L42;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.ImageFilterView_crossfade) goto L9;
        this.f2090e = r12.getFloat(r15, 0.0f);
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
        setOverlay(r12.getBoolean(r15, this.f2087b));
        goto L41
    L30:
        if (r15 != R$styleable.ImageFilterView_imagePanX) goto L33;
        setImagePanX(r12.getFloat(r15, this.f2098m));
        goto L41
    L33:
        if (r15 != R$styleable.ImageFilterView_imagePanY) goto L36;
        setImagePanY(r12.getFloat(r15, this.f2099n));
        goto L41
    L36:
        if (r15 != R$styleable.ImageFilterView_imageRotate) goto L39;
        setImageRotate(r12.getFloat(r15, this.f2101p));
        goto L41
    L39:
        if (r15 != R$styleable.ImageFilterView_imageZoom) goto L41;
        setImageZoom(r12.getFloat(r15, this.f2100o));
        goto L41
    L42:
        r12.recycle();
        Drawable r16 = getDrawable();
        this.f2089d = r16;
        if (this.f2088c == null) goto L49;
        if (r16 == null) goto L49;
        Drawable[] r17 = this.f2096k;
        Drawable r18 = getDrawable().mutate();
        this.f2089d = r18;
        r17[0] = r18;
        this.f2096k[1] = this.f2088c.mutate();
        LayerDrawable r19 = new LayerDrawable(this.f2096k);
        this.f2097l = r19;
        r19.getDrawable(1).setAlpha((int) (this.f2090e * 255.0f));
        if (this.f2087b == true) goto L48;
        this.f2097l.getDrawable(0).setAlpha((int) ((1.0f - this.f2090e) * 255.0f));
    L48:
        super.setImageDrawable(this.f2097l);
        return;
    L49:
        Drawable r20 = getDrawable();
        this.f2089d = r20;
        if (r20 == null) goto L69;
        Drawable[] r21 = this.f2096k;
        Drawable r22 = r20.mutate();
        this.f2089d = r22;
        r21[0] = r22;
        return;
    L69:
        return;
    }

    private void d() {
        if (Float.isNaN(this.f2098m) == true) goto L5;
    L11:
        float r10 = 0.0f;
        if (Float.isNaN(this.f2098m) == false) goto L14;
        float r11 = 0.0f;
    L16:
        if (Float.isNaN(this.f2099n) == false) goto L18;
        float r12 = 0.0f;
    L20:
        if (Float.isNaN(this.f2100o) == false) goto L22;
        float r13 = 1.0f;
    L24:
        if (Float.isNaN(this.f2101p) == true) goto L27;
        r10 = this.f2101p;
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
        r13 = this.f2100o;
        goto L24
    L18:
        r12 = this.f2099n;
        goto L20
    L14:
        r11 = this.f2098m;
        goto L16
    L5:
        if (Float.isNaN(this.f2099n) == false) goto L11;
        if (Float.isNaN(this.f2100o) == false) goto L11;
        if (Float.isNaN(this.f2101p) == false) goto L11;
    }

    private void e() {
        if (Float.isNaN(this.f2098m) == true) goto L5;
    L12:
        d();
        return;
    L5:
        if (Float.isNaN(this.f2099n) == false) goto L12;
        if (Float.isNaN(this.f2100o) == false) goto L12;
        if (Float.isNaN(this.f2101p) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private void setOverlay(boolean r10) {
        this.f2087b = r10;
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
    }

    public float getBrightness() {
        return this.f2086a.f2107d;
    }

    public float getContrast() {
        return this.f2086a.f2109f;
    }

    public float getCrossfade() {
        return this.f2090e;
    }

    public float getImagePanX() {
        return this.f2098m;
    }

    public float getImagePanY() {
        return this.f2099n;
    }

    public float getImageRotate() {
        return this.f2101p;
    }

    public float getImageZoom() {
        return this.f2100o;
    }

    public float getRound() {
        return this.f2092g;
    }

    public float getRoundPercent() {
        return this.f2091f;
    }

    public float getSaturation() {
        return this.f2086a.f2108e;
    }

    public float getWarmth() {
        return this.f2086a.f2110g;
    }

    @Override // android.view.View
    public void layout(int r10, int r11, int r12, int r13) {
        super.layout(r10, r11, r12, r13);
        d();
    }

    public void setAltImageResource(int r10) {
        Drawable r11 = c.a.b(getContext(), r10).mutate();
        this.f2088c = r11;
        Drawable[] r12 = this.f2096k;
        r12[0] = this.f2089d;
        r12[1] = r11;
        LayerDrawable r13 = new LayerDrawable(this.f2096k);
        this.f2097l = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f2090e);
    }

    public void setBrightness(float r10) {
        c r11 = this.f2086a;
        r11.f2107d = r10;
        r11.c(this);
    }

    public void setContrast(float r10) {
        c r11 = this.f2086a;
        r11.f2109f = r10;
        r11.c(this);
    }

    public void setCrossfade(float r10) {
        this.f2090e = r10;
        if (this.f2096k != null) goto L5;
        return;
    L5:
        if (this.f2087b == true) goto L7;
        this.f2097l.getDrawable(0).setAlpha((int) ((1.0f - this.f2090e) * 255.0f));
    L7:
        this.f2097l.getDrawable(1).setAlpha((int) (this.f2090e * 255.0f));
        super.setImageDrawable(this.f2097l);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        if (this.f2088c == null) goto L6;
        if (r10 == null) goto L6;
        Drawable r11 = r10.mutate();
        this.f2089d = r11;
        Drawable[] r12 = this.f2096k;
        r12[0] = r11;
        r12[1] = this.f2088c;
        LayerDrawable r13 = new LayerDrawable(this.f2096k);
        this.f2097l = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f2090e);
        return;
    L6:
        super.setImageDrawable(r10);
    }

    public void setImagePanX(float r10) {
        this.f2098m = r10;
        e();
    }

    public void setImagePanY(float r10) {
        this.f2099n = r10;
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r10) {
        if (this.f2088c == null) goto L5;
        Drawable r11 = c.a.b(getContext(), r10).mutate();
        this.f2089d = r11;
        Drawable[] r12 = this.f2096k;
        r12[0] = r11;
        r12[1] = this.f2088c;
        LayerDrawable r13 = new LayerDrawable(this.f2096k);
        this.f2097l = r13;
        super.setImageDrawable(r13);
        setCrossfade(this.f2090e);
        return;
    L5:
        super.setImageResource(r10);
    }

    public void setImageRotate(float r10) {
        this.f2101p = r10;
        e();
    }

    public void setImageZoom(float r10) {
        this.f2100o = r10;
        e();
    }

    @RequiresApi(21)
    public void setRound(float r10) {
        if (Float.isNaN(r10) == false) goto L7;
        this.f2092g = r10;
        float r11 = this.f2091f;
        this.f2091f = -1.0f;
        setRoundPercent(r11);
        return;
    L7:
        if (this.f2092g == r10) goto L9;
        boolean r12 = true;
    L10:
        this.f2092g = r10;
        if (r10 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r12 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f2093h != null) goto L16;
        this.f2093h = new Path();
    L16:
        if (this.f2095j != null) goto L19;
        this.f2095j = new RectF();
    L19:
        if (this.f2094i != null) goto L21;
        b r13 = new b(this);
        this.f2094i = r13;
        setOutlineProvider(r13);
    L21:
        setClipToOutline(true);
        this.f2095j.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f2093h.reset();
        Path r14 = this.f2093h;
        RectF r15 = this.f2095j;
        float r16 = this.f2092g;
        r14.addRoundRect(r15, r16, r16, Path.Direction.CW);
        goto L23
    L9:
        r12 = false;
        goto L10
    }

    @RequiresApi(21)
    public void setRoundPercent(float r10) {
        if (this.f2091f == r10) goto L5;
        boolean r11 = true;
    L6:
        this.f2091f = r10;
        if (r10 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r11 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f2093h != null) goto L12;
        this.f2093h = new Path();
    L12:
        if (this.f2095j != null) goto L15;
        this.f2095j = new RectF();
    L15:
        if (this.f2094i != null) goto L17;
        a r12 = new a(this);
        this.f2094i = r12;
        setOutlineProvider(r12);
    L17:
        setClipToOutline(true);
        int r13 = getWidth();
        int r14 = getHeight();
        float r15 = (Math.min(r13, r14) * this.f2091f) / 2.0f;
        this.f2095j.set(0.0f, 0.0f, r13, r14);
        this.f2093h.reset();
        this.f2093h.addRoundRect(this.f2095j, r15, r15, Path.Direction.CW);
        goto L19
    L5:
        r11 = false;
        goto L6
    }

    public void setSaturation(float r10) {
        c r11 = this.f2086a;
        r11.f2108e = r10;
        r11.c(this);
    }

    public void setWarmth(float r10) {
        c r11 = this.f2086a;
        r11.f2110g = r10;
        r11.c(this);
    }

    public ImageFilterView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f2086a = new c();
        this.f2087b = true;
        this.f2088c = null;
        this.f2089d = null;
        this.f2090e = 0.0f;
        this.f2091f = 0.0f;
        this.f2092g = Float.NaN;
        this.f2096k = new Drawable[2];
        this.f2098m = Float.NaN;
        this.f2099n = Float.NaN;
        this.f2100o = Float.NaN;
        this.f2101p = Float.NaN;
        c(r10, r11);
    }

    public ImageFilterView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f2086a = new c();
        this.f2087b = true;
        this.f2088c = null;
        this.f2089d = null;
        this.f2090e = 0.0f;
        this.f2091f = 0.0f;
        this.f2092g = Float.NaN;
        this.f2096k = new Drawable[2];
        this.f2098m = Float.NaN;
        this.f2099n = Float.NaN;
        this.f2100o = Float.NaN;
        this.f2101p = Float.NaN;
        c(r10, r11);
    }
}
