package com.bytedance.android.live.uikit.imageview.imagezoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public class ImageViewTouchBase extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wb1.a f102221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f102222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Matrix f102223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f102224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f102225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f102226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f102227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f102228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f102229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f102230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f102231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f102232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f102233m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f102234n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f102235o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f102236p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f102237q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f102238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f102239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Matrix f102240c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f102241d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ImageViewTouchBase f102242e;

        @Override // java.lang.Runnable
        public final void run() {
            this.f102242e.n(this.f102238a, this.f102239b, this.f102240c, this.f102241d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ImageViewTouchBase r100, Drawable r101, boolean r102, Matrix r103, float r104) {
            this.f102242e = r100;
            this.f102238a = r101;
            this.f102239b = r102;
            this.f102240c = r103;
            this.f102241d = r104;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f102243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f102244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f102245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f102246d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f102247e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f102248f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ImageViewTouchBase f102249g;

        public final void a() {
            float r100 = Math.min(this.f102243a, System.currentTimeMillis() - this.f102244b);
            wb1.a r101 = this.f102249g.f102221a;
            double r102 = this.f102245c;
            double r103 = this.f102243a;
            r101.getClass();
            double r104 = ((double) r100) / (r103 / 2.0d);
            double r105 = r102 / 2.0d;
            if (r104 >= 1.0d) goto L5;
            double r106 = ((r105 * r104) * r104) * r104;
        L6:
            this.f102249g.p(this.f102246d + ((float) (r106 + AudioStats.AUDIO_AMPLITUDE_NONE)), this.f102247e, this.f102248f);
            if (r100 >= this.f102243a) goto L9;
            this.f102249g.f102224d.post(this);
            return;
        L9:
            ImageViewTouchBase r107 = this.f102249g;
            if (r107.f102237q == false) goto L13;
            r107.f102237q = false;
            return;
        L13:
            r107.f102237q = true;
            r107.l(r107.getScale());
            this.f102249g.b();
            return;
        L5:
            double r108 = r104 - 2.0d;
            r106 = r105 * (((r108 * r108) * r108) + 2.0d);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ImageViewTouchBase r100, float r101, long r102, float r103, float r104, float r105, float r106) {
            this.f102249g = r100;
            this.f102243a = r101;
            this.f102244b = r102;
            this.f102245c = r103;
            this.f102246d = r104;
            this.f102247e = r105;
            this.f102248f = r106;
        }
    }

    public interface c {
    }

    @Override // android.view.View
    public float getRotation() {
        return 0.0f;
    }

    public void j() {
    }

    public void k(float r100) {
    }

    public void l(float r100) {
    }

    public void setOnBitmapChangedListener(c r100) {
    }

    public RectF getBitmapRect() {
        return c(this.f102223c);
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.f102223c);
    }

    public Matrix getImageViewMatrix() {
        Matrix r100 = this.f102223c;
        this.f102228h.set(this.f102222b);
        this.f102228h.postConcat(r100);
        return this.f102228h;
    }

    public float getMaxZoom() {
        if (this.f102226f >= 1.0f) goto L6;
        this.f102226f = i();
    L6:
        return this.f102226f;
    }

    public float getMinZoom() {
        if (this.f102227g >= 0.0f) goto L6;
        this.f102227g = 1.0f;
    L6:
        return this.f102227g;
    }

    public float getScale() {
        this.f102223c.getValues(this.f102229i);
        return this.f102229i[0];
    }

    public void h() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void b() {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        RectF r100 = d(this.f102223c);
        float r101 = r100.left;
        if (r101 == 0.0f) goto L8;
    L9:
        float r102 = r100.top;
        this.f102223c.postTranslate(r101, r102);
        setImageMatrix(getImageViewMatrix());
        return;
    L8:
        if (r100.top != 0.0f) goto L9;
    }

    public final float i() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        return Math.max(r100.getIntrinsicWidth() / this.f102230j, r100.getIntrinsicHeight() / this.f102231k) * 4.0f;
    }

    public ImageViewTouchBase(Context r100) {
        super(r100);
        this.f102221a = new wb1.a();
        this.f102222b = new Matrix();
        this.f102223c = new Matrix();
        this.f102224d = new Handler();
        this.f102225e = null;
        this.f102227g = -1.0f;
        this.f102228h = new Matrix();
        this.f102229i = new float[9];
        this.f102230j = -1;
        this.f102231k = -1;
        this.f102232l = false;
        this.f102233m = false;
        this.f102234n = new RectF();
        this.f102235o = new RectF();
        this.f102236p = new RectF();
        h();
    }

    public final RectF c(Matrix r100) {
        Drawable r101 = getDrawable();
        this.f102228h.set(this.f102222b);
        this.f102228h.postConcat(r100);
        Matrix r102 = this.f102228h;
        if (r101 == null) goto L5;
        this.f102234n.set(0.0f, 0.0f, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
    L6:
        r102.mapRect(this.f102234n);
        return this.f102234n;
    L5:
        this.f102234n.set(0.0f, 0.0f, 0.0f, 0.0f);
        goto L6
    }

    public final RectF d(Matrix r100) {
        if (getDrawable() == null) goto L5;
        this.f102235o.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF r101 = c(r100);
        float r102 = r101.height();
        float r103 = r101.width();
        float r104 = getHeight();
        if (r102 >= r104) goto L9;
        float r105 = (r104 - r102) / 2.0f;
        float r106 = r101.top;
    L15:
        float r107 = r105 - r106;
    L17:
        float r108 = getWidth();
        if (r103 >= r108) goto L20;
        r108 = (r108 - r103) / 2.0f;
        float r109 = r101.left;
    L25:
        float r110 = r108 - r109;
    L27:
        this.f102235o.set(r110, r107, 0.0f, 0.0f);
        return this.f102235o;
    L20:
        float r111 = r101.left;
        if (r111 <= 0.0f) goto L23;
        r110 = -r111;
        goto L27
    L23:
        r109 = r101.right;
        if (r109 < r108) goto L25;
        r110 = 0.0f;
        goto L27
    L9:
        float r112 = r101.top;
        if (r112 <= 0.0f) goto L13;
        r107 = -r112;
        goto L17
    L13:
        if (r101.bottom >= r104) goto L16;
        r105 = getHeight();
        r106 = r101.bottom;
        goto L15
    L16:
        r107 = 0.0f;
        goto L17
    L5:
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setFitToScreen(boolean r100) {
        if (r100 == this.f102233m) goto L6;
        this.f102233m = r100;
        requestLayout();
        return;
    }

    public void setFitToWidth(boolean r100) {
        if (r100 == this.f102232l) goto L6;
        this.f102232l = r100;
        requestLayout();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        if (r100 == null) goto L5;
        n(new xb1.a(r100), true, null, -1.0f);
        return;
    L5:
        n(null, true, null, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        n(r100, true, null, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        setImageDrawable(getContext().getResources().getDrawable(r100));
    }

    public void setMinZoom(float r100) {
        this.f102227g = r100;
    }

    public ImageViewTouchBase(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f102221a = new wb1.a();
        this.f102222b = new Matrix();
        this.f102223c = new Matrix();
        this.f102224d = new Handler();
        this.f102225e = null;
        this.f102227g = -1.0f;
        this.f102228h = new Matrix();
        this.f102229i = new float[9];
        this.f102230j = -1;
        this.f102231k = -1;
        this.f102232l = false;
        this.f102233m = false;
        this.f102234n = new RectF();
        this.f102235o = new RectF();
        this.f102236p = new RectF();
        h();
    }

    public final void e(Drawable r100, Matrix r101) {
        float r102 = getWidth();
        float r103 = getHeight();
        float r104 = r100.getIntrinsicWidth();
        float r105 = r100.getIntrinsicHeight();
        r101.reset();
        if (r104 <= r102) goto L5;
    L8:
        float r106 = Math.min(Math.min(r102 / r104, 2.0f), Math.min(r103 / r105, 2.0f));
        r101.postScale(r106, r106);
        r101.postTranslate((r102 - (r104 * r106)) / 2.0f, (r103 - (r105 * r106)) / 2.0f);
        return;
    L5:
        if (r105 > r103) goto L8;
        r101.postTranslate((r102 - r104) / 2.0f, (r103 - r105) / 2.0f);
    }

    public final void f(Drawable r100, Matrix r101) {
        float r102 = getWidth();
        float r103 = getHeight();
        float r104 = r100.getIntrinsicWidth();
        float r105 = r100.getIntrinsicHeight();
        r101.reset();
        float r106 = Math.min(Math.min(r102 / r104, 2.5f), Math.min(r103 / r105, 2.5f));
        r101.postScale(r106, r106);
        r101.postTranslate((r102 - (r104 * r106)) / 2.0f, (r103 - (r105 * r106)) / 2.0f);
    }

    public final void m(double r100, double r101) {
        RectF r102 = getBitmapRect();
        this.f102236p.set((float) r100, (float) r101, 0.0f, 0.0f);
        o(r102, this.f102236p);
        RectF r103 = this.f102236p;
        float r104 = r103.left;
        float r105 = r103.top;
        this.f102223c.postTranslate(r104, r105);
        setImageMatrix(getImageViewMatrix());
        b();
    }

    public final void o(RectF r100, RectF r101) {
        float r102 = getWidth();
        float r103 = getHeight();
        if (r100.top < 0.0f) goto L8;
        if (r100.bottom > r103) goto L8;
        r101.top = 0.0f;
    L8:
        if (r100.left >= 0.0f) goto L10;
    L12:
        float r104 = r100.top;
        if ((r101.top + r104) >= 0.0f) goto L15;
    L17:
        float r105 = r100.bottom;
        float r106 = r103 - 0.0f;
        if ((r101.top + r105) <= r106) goto L20;
    L22:
        float r107 = r100.left;
        if ((r101.left + r107) < 0.0f) goto L25;
        r101.left = (int) (0.0f - r107);
    L25:
        float r108 = r100.right;
        float r109 = r102 - 0.0f;
        if ((r101.left + r108) > r109) goto L29;
        r101.left = (int) (r109 - r108);
        return;
    L29:
        return;
    L20:
        if (r100.top >= 0.0f) goto L22;
        r101.top = (int) (r106 - r105);
        goto L22
    L15:
        if (r100.bottom <= r103) goto L17;
        r101.top = (int) (0.0f - r104);
        goto L17
    L10:
        if (r100.right > r102) goto L12;
        r101.left = 0.0f;
        goto L12
    }

    public final void g(Drawable r100, Matrix r101, float[] r102) {
        float r103 = getWidth();
        float r104 = r100.getIntrinsicWidth();
        r101.reset();
        float r105 = Math.min(r103 / r104, 2.5f);
        r101.postScale(r105, r105);
        r101.postTranslate((r103 - (r104 * r105)) / 2.0f, 0.0f);
        if (r105 <= 1.0f) goto L5;
        r102[0] = 1.0f / r105;
        return;
    L5:
        r102[0] = 1.0f;
    }

    public final void p(float r100, float r101, float r102) {
        float r103 = this.f102226f;
        if (r100 <= r103) goto L5;
        r100 = r103;
    L5:
        float r104 = r100 / getScale();
        this.f102223c.postScale(r104, r104, r101, r102);
        setImageMatrix(getImageViewMatrix());
        k(getScale());
        b();
    }

    public void a(Drawable r100, boolean r101, Matrix r102, float r103) {
        if (r100 != null) goto L4;
        this.f102222b.reset();
        super.setImageDrawable(null);
    L12:
        if (r101 == false) goto L16;
        this.f102223c.reset();
        if (r102 == null) goto L16;
        this.f102223c = new Matrix(r102);
    L16:
        setImageMatrix(getImageViewMatrix());
        if (r103 >= 1.0f) goto L19;
        this.f102226f = i();
    L20:
        j();
        return;
    L19:
        this.f102226f = r103;
        goto L20
    L4:
        if (this.f102232l == false) goto L7;
        float[] r104 = new float[1];
        g(r100, this.f102222b, r104);
        setMinZoom(r104[0]);
    L10:
        super.setImageDrawable(r100);
        goto L12
    L7:
        if (this.f102233m == false) goto L9;
        f(r100, this.f102222b);
        this.f102222b.getValues(this.f102229i);
        setMinZoom(this.f102229i[0]);
        goto L10
    L9:
        e(r100, this.f102222b);
        setMinZoom(getMinZoom());
        goto L10
    }

    public final void n(Drawable r100, boolean r101, Matrix r110, float r111) {
        if (getWidth() > 0) goto L6;
        this.f102225e = new a(this, r100, r101, r110, r111);
        return;
    L6:
        a(r100, r101, r110, r111);
    }

    public final void q(float r110, float r111, float r112, float r113) {
        if (r110 <= getMaxZoom()) goto L5;
        r110 = getMaxZoom();
    L5:
        long r100 = System.currentTimeMillis();
        float r101 = getScale();
        float r102 = r110 - r101;
        Matrix r103 = new Matrix(this.f102223c);
        r103.postScale(r110, r110, r111, r112);
        RectF r104 = d(r103);
        float r105 = r111 + (r104.left * r110);
        float r106 = r112 + (r104.top * r110);
        this.f102224d.post(new b(this, r113, r100, r102, r101, r105, r106));
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.f102230j = r103 - r101;
        this.f102231k = r104 - r102;
        a r105 = this.f102225e;
        if (r105 == null) goto L6;
        this.f102225e = null;
        r105.run();
    L6:
        if (getDrawable() == null) goto L16;
        float r106 = 1.0f;
        if (this.f102232l == false) goto L11;
        float[] r107 = new float[1];
        g(getDrawable(), this.f102222b, r107);
        setMinZoom(r107[0]);
    L14:
        setImageMatrix(getImageViewMatrix());
        p(r106, getWidth() / 2.0f, getHeight() / 2.0f);
        return;
    L11:
        if (this.f102233m == false) goto L13;
        f(getDrawable(), this.f102222b);
        setMinZoom(1.0f);
        r106 = getMinZoom();
        goto L14
    L13:
        e(getDrawable(), this.f102222b);
        setMinZoom(getMinZoom());
        r106 = getMinZoom();
        goto L14
    }
}
