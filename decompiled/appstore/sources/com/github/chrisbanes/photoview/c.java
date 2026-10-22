package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.bytedanceos.common.ui.animation.AnimationConstants;

/* JADX INFO: loaded from: classes2.dex */
public class c implements View.OnTouchListener, View.OnLayoutChangeListener {
    public static float F = 3.0f;
    public static float G = 1.75f;
    public static float H = 1.0f;
    public static int I = 200;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static int f10284J = 1;
    public int A;
    public float B;
    public boolean C;
    public ImageView.ScaleType D;
    public OnGestureListener E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Interpolator f10285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f10287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f10288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f10289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f10292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GestureDetector f10293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.github.chrisbanes.photoview.b f10294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f10295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f10296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f10297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f10298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f10299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OnMatrixChangedListener f10300p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OnPhotoTapListener f10301q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OnOutsidePhotoTapListener f10302r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public OnViewTapListener f10303s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View.OnClickListener f10304t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View.OnLongClickListener f10305u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public OnScaleChangedListener f10306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OnSingleFlingListener f10307w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OnViewDragListener f10308x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f10309y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10310z;

    public class a implements OnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f10311a;

        public a(c r10) {
            this.f10311a = r10;
        }

        @Override // com.github.chrisbanes.photoview.OnGestureListener
        public void onDrag(float r10, float r11) {
            if (c.a(this.f10311a).e() == false) goto L6;
            return;
        L6:
            if (c.b(this.f10311a) == null) goto L8;
            c.b(this.f10311a).onDrag(r10, r11);
        L8:
            c.m(this.f10311a).postTranslate(r10, r11);
            c.s(this.f10311a);
            ViewParent r12 = c.t(this.f10311a).getParent();
            if (c.u(this.f10311a) == true) goto L11;
        L34:
            if (r12 == null) goto L41;
            r12.requestDisallowInterceptTouchEvent(true);
            return;
        L41:
            return;
        L11:
            if (c.a(this.f10311a).e() == true) goto L34;
            if (c.v(this.f10311a) == true) goto L34;
            if (c.w(this.f10311a) != 2) goto L17;
        L32:
            if (r12 == null) goto L39;
            r12.requestDisallowInterceptTouchEvent(false);
            return;
        L39:
            return;
        L17:
            if (c.w(this.f10311a) != 0) goto L21;
            if (r10 >= 1.0f) goto L32;
        L21:
            if (c.w(this.f10311a) != 1) goto L25;
            if (r10 <= (-1.0f)) goto L32;
        L25:
            if (c.x(this.f10311a) != 0) goto L29;
            if (r11 >= 1.0f) goto L32;
        L29:
            if (c.x(this.f10311a) == 1) goto L31;
            return;
        L31:
            if (r11 <= (-1.0f)) goto L32;
        }

        @Override // com.github.chrisbanes.photoview.OnGestureListener
        public void onFling(float r10, float r11, float r12, float r13) {
            c r14 = this.f10311a;
            c.z(r14, new f(r14, c.t(r14).getContext()));
            f r15 = c.y(this.f10311a);
            c r16 = this.f10311a;
            int r17 = c.c(r16, c.t(r16));
            c r18 = this.f10311a;
            r15.b(r17, c.d(r18, c.t(r18)), (int) r12, (int) r13);
            c.t(this.f10311a).post(c.y(this.f10311a));
        }

        @Override // com.github.chrisbanes.photoview.OnGestureListener
        public void onScale(float r10, float r11, float r12) {
            if (this.f10311a.M() < c.e(this.f10311a)) goto L7;
            if (r10 < 1.0f) goto L7;
            return;
        L7:
            if (c.f(this.f10311a) == null) goto L9;
            c.f(this.f10311a).onScaleChange(r10, r11, r12);
        L9:
            c.m(this.f10311a).postScale(r10, r10, r11, r12);
            c.s(this.f10311a);
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f10312a;

        public b(c r10) {
            this.f10312a = r10;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent r10, MotionEvent r11, float r12, float r13) {
            if (c.h(this.f10312a) != null) goto L5;
        L14:
            return false;
        L5:
            if (this.f10312a.M() <= c.i()) goto L8;
            return false;
        L8:
            if (r10.getPointerCount() > c.j()) goto L14;
            if (r11.getPointerCount() > c.j()) goto L14;
            return c.h(this.f10312a).onFling(r10, r11, r12, r13);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r10) {
            if (c.g(this.f10312a) == null) goto L6;
            c.g(this.f10312a).onLongClick(c.t(this.f10312a));
            return;
        }
    }

    /* JADX INFO: renamed from: com.github.chrisbanes.photoview.c$c, reason: collision with other inner class name */
    public class GestureDetectorOnDoubleTapListenerC0139c implements GestureDetector.OnDoubleTapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f10313a;

        public GestureDetectorOnDoubleTapListenerC0139c(c r10) {
            this.f10313a = r10;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent r10) {
            float r11 = this.f10313a.M();     // Catch: ArrayIndexOutOfBoundsException -> L13
            float r12 = r10.getX();     // Catch: ArrayIndexOutOfBoundsException -> L13
            float r13 = r10.getY();     // Catch: ArrayIndexOutOfBoundsException -> L13
            if (r11 >= this.f10313a.K()) goto L7;
            c r14 = this.f10313a;     // Catch: ArrayIndexOutOfBoundsException -> L13
            r14.Y(r14.K(), r12, r13, true);     // Catch: ArrayIndexOutOfBoundsException -> L13
        L14:
            goto L12
        L7:
            if (r11 >= this.f10313a.K()) goto L9;
        L11:
            c r15 = this.f10313a;     // Catch: ArrayIndexOutOfBoundsException -> L13
            r15.Y(r15.L(), r12, r13, true);     // Catch: ArrayIndexOutOfBoundsException -> L13
            goto L14
        L9:
            if (r11 >= this.f10313a.J()) goto L11;
            c r16 = this.f10313a;     // Catch: ArrayIndexOutOfBoundsException -> L13
            r16.Y(r16.J(), r12, r13, true);     // Catch: ArrayIndexOutOfBoundsException -> L13
        L12:
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent r10) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent r10) {
            if (c.k(this.f10313a) == null) goto L5;
            c.k(this.f10313a).onClick(c.t(this.f10313a));
        L5:
            RectF r11 = this.f10313a.D();
            float r12 = r10.getX();
            float r13 = r10.getY();
            if (c.l(this.f10313a) == null) goto L8;
            c.l(this.f10313a).onViewTap(c.t(this.f10313a), r12, r13);
        L8:
            if (r11 != null) goto L10;
            return false;
        L10:
            if (r11.contains(r12, r13) == false) goto L17;
            float r14 = (r12 - r11.left) / r11.width();
            float r15 = (r13 - r11.top) / r11.height();
            if (c.n(this.f10313a) == null) goto L21;
            c.n(this.f10313a).onPhotoTap(c.t(this.f10313a), r14, r15);
            return true;
        L21:
            return true;
        L17:
            if (c.o(this.f10313a) == null) goto L23;
            c.o(this.f10313a).onOutsidePhotoTap(c.t(this.f10313a));
            return false;
        L23:
            return false;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10314a = null;

        static {
            int[] r10 = new int[ImageView.ScaleType.values().length];
            f10314a = r10;
            r10[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f10314a[ImageView.ScaleType.FIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f10314a[ImageView.ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f10314a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f10315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f10316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f10317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f10318d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f10319e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ c f10320f;

        public e(c r10, float r11, float r12, float r13, float r14) {
            this.f10320f = r10;
            this.f10315a = r13;
            this.f10316b = r14;
            this.f10317c = System.currentTimeMillis();
            this.f10318d = r11;
            this.f10319e = r12;
        }

        public final float a() {
            return c.r(this.f10320f).getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f10317c) * 1.0f) / c.q(this.f10320f)));
        }

        @Override // java.lang.Runnable
        public void run() {
            float r10 = a();
            float r11 = this.f10318d;
            float r12 = (r11 + ((this.f10319e - r11) * r10)) / this.f10320f.M();
            c.p(this.f10320f).onScale(r12, this.f10315a, this.f10316b);
            if (r10 >= 1.0f) goto L6;
            com.github.chrisbanes.photoview.a.a(c.t(this.f10320f), this);
            return;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OverScroller f10321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f10324d;

        public f(c r10, Context r11) {
            this.f10324d = r10;
            this.f10321a = new OverScroller(r11);
        }

        public void a() {
            this.f10321a.forceFinished(true);
        }

        public void b(int r15, int r16, int r17, int r18) {
            RectF r10 = this.f10324d.D();
            if (r10 != null) goto L5;
            return;
        L5:
            int r11 = Math.round(-r10.left);
            float r12 = r15;
            if (r12 >= r10.width()) goto L8;
            int r13 = Math.round(r10.width() - r12);
            int r14 = 0;
        L9:
            int r19 = Math.round(-r10.top);
            float r20 = r16;
            if (r20 >= r10.height()) goto L12;
            int r110 = Math.round(r10.height() - r20);
            int r111 = 0;
        L13:
            this.f10322b = r11;
            this.f10323c = r19;
            if (r11 != r13) goto L16;
            if (r19 != r110) goto L16;
            return;
        L16:
            this.f10321a.fling(r11, r19, r17, r18, r14, r13, r111, r110, 0, 0);
            return;
        L12:
            r111 = r19;
            r110 = r111;
            goto L13
        L8:
            r14 = r11;
            r13 = r14;
            goto L9
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10321a.isFinished() == false) goto L6;
            return;
        L6:
            if (this.f10321a.computeScrollOffset() == false) goto L9;
            int r10 = this.f10321a.getCurrX();
            int r11 = this.f10321a.getCurrY();
            c.m(this.f10324d).postTranslate(this.f10322b - r10, this.f10323c - r11);
            c.s(this.f10324d);
            this.f10322b = r10;
            this.f10323c = r11;
            com.github.chrisbanes.photoview.a.a(c.t(this.f10324d), this);
            return;
        }
    }

    static {
    }

    public c(ImageView r10) {
        this.f10285a = new AccelerateDecelerateInterpolator();
        this.f10286b = I;
        this.f10287c = H;
        this.f10288d = G;
        this.f10289e = F;
        this.f10290f = true;
        this.f10291g = false;
        this.f10295k = new Matrix();
        this.f10296l = new Matrix();
        this.f10297m = new Matrix();
        this.f10298n = new RectF();
        this.f10299o = new float[9];
        this.f10310z = 2;
        this.A = 2;
        this.C = true;
        this.D = ImageView.ScaleType.FIT_CENTER;
        this.E = new a(this);
        this.f10292h = r10;
        r10.setOnTouchListener(this);
        r10.addOnLayoutChangeListener(this);
        if (r10.isInEditMode() == false) goto L5;
        return;
    L5:
        this.B = 0.0f;
        this.f10294j = new com.github.chrisbanes.photoview.b(r10.getContext(), this.E);
        GestureDetector r11 = new GestureDetector(r10.getContext(), new b(this));
        this.f10293i = r11;
        r11.setOnDoubleTapListener(new GestureDetectorOnDoubleTapListenerC0139c(this));
    }

    public static /* synthetic */ com.github.chrisbanes.photoview.b a(c r10) {
        return r10.f10294j;
    }

    public static /* synthetic */ OnViewDragListener b(c r10) {
        return r10.f10308x;
    }

    public static /* synthetic */ int c(c r10, ImageView r11) {
        return r10.I(r11);
    }

    public static /* synthetic */ int d(c r10, ImageView r11) {
        return r10.H(r11);
    }

    public static /* synthetic */ float e(c r10) {
        return r10.f10289e;
    }

    public static /* synthetic */ OnScaleChangedListener f(c r10) {
        return r10.f10306v;
    }

    public static /* synthetic */ View.OnLongClickListener g(c r10) {
        return r10.f10305u;
    }

    public static /* synthetic */ OnSingleFlingListener h(c r10) {
        return r10.f10307w;
    }

    public static /* synthetic */ float i() {
        return H;
    }

    public static /* synthetic */ int j() {
        return f10284J;
    }

    public static /* synthetic */ View.OnClickListener k(c r10) {
        return r10.f10304t;
    }

    public static /* synthetic */ OnViewTapListener l(c r10) {
        return r10.f10303s;
    }

    public static /* synthetic */ Matrix m(c r10) {
        return r10.f10297m;
    }

    public static /* synthetic */ OnPhotoTapListener n(c r10) {
        return r10.f10301q;
    }

    public static /* synthetic */ OnOutsidePhotoTapListener o(c r10) {
        return r10.f10302r;
    }

    public static /* synthetic */ OnGestureListener p(c r10) {
        return r10.E;
    }

    public static /* synthetic */ int q(c r10) {
        return r10.f10286b;
    }

    public static /* synthetic */ Interpolator r(c r10) {
        return r10.f10285a;
    }

    public static /* synthetic */ void s(c r10) {
        r10.B();
    }

    public static /* synthetic */ ImageView t(c r10) {
        return r10.f10292h;
    }

    public static /* synthetic */ boolean u(c r10) {
        return r10.f10290f;
    }

    public static /* synthetic */ boolean v(c r10) {
        return r10.f10291g;
    }

    public static /* synthetic */ int w(c r10) {
        return r10.f10310z;
    }

    public static /* synthetic */ int x(c r10) {
        return r10.A;
    }

    public static /* synthetic */ f y(c r10) {
        return r10.f10309y;
    }

    public static /* synthetic */ f z(c r10, f r11) {
        r10.f10309y = r11;
        return r11;
    }

    public final void A() {
        f r10 = this.f10309y;
        if (r10 == null) goto L6;
        r10.a();
        this.f10309y = null;
        return;
    }

    public final void B() {
        if (C() == false) goto L6;
        R(F());
        return;
    }

    public final boolean C() {
        RectF r10 = E(F());
        if (r10 != null) goto L5;
        return false;
    L5:
        float r11 = r10.height();
        float r12 = r10.width();
        float r13 = H(this.f10292h);
        float r14 = 0.0f;
        if (r11 > r13) goto L15;
        int r15 = d.f10314a[this.D.ordinal()];
        if (r15 == 2) goto L13;
        if (r15 == 3) goto L12;
        float r16 = (r13 - r11) / 2.0f;
        float r17 = r10.top;
    L11:
        float r18 = r16 - r17;
    L14:
        this.A = 2;
    L22:
        float r19 = I(this.f10292h);
        if (r12 > r19) goto L32;
        int r20 = d.f10314a[this.D.ordinal()];
        if (r20 == 2) goto L30;
        if (r20 == 3) goto L29;
        float r21 = (r19 - r12) / 2.0f;
        float r22 = r10.left;
    L28:
        r14 = r21 - r22;
    L31:
        this.f10310z = 2;
    L39:
        this.f10297m.postTranslate(r14, r18);
        return true;
    L29:
        r21 = r19 - r12;
        r22 = r10.left;
        goto L28
    L30:
        r14 = -r10.left;
        goto L31
    L32:
        float r23 = r10.left;
        if (r23 <= 0.0f) goto L35;
        this.f10310z = 0;
        r14 = -r23;
        goto L39
    L35:
        float r24 = r10.right;
        if (r24 >= r19) goto L38;
        r14 = r19 - r24;
        this.f10310z = 1;
        goto L39
    L38:
        this.f10310z = -1;
        goto L39
    L12:
        r16 = r13 - r11;
        r17 = r10.top;
        goto L11
    L13:
        r18 = -r10.top;
        goto L14
    L15:
        float r25 = r10.top;
        if (r25 <= 0.0f) goto L18;
        this.A = 0;
        r18 = -r25;
        goto L22
    L18:
        float r26 = r10.bottom;
        if (r26 >= r13) goto L21;
        this.A = 1;
        r18 = r13 - r26;
        goto L22
    L21:
        this.A = -1;
        r18 = 0.0f;
        goto L22
    }

    public RectF D() {
        C();
        return E(F());
    }

    public final RectF E(Matrix r10) {
        Drawable r11 = this.f10292h.getDrawable();
        if (r11 == null) goto L6;
        this.f10298n.set(0.0f, 0.0f, r11.getIntrinsicWidth(), r11.getIntrinsicHeight());
        r10.mapRect(this.f10298n);
        return this.f10298n;
    L6:
        return null;
    }

    public final Matrix F() {
        this.f10296l.set(this.f10295k);
        this.f10296l.postConcat(this.f10297m);
        return this.f10296l;
    }

    public Matrix G() {
        return this.f10296l;
    }

    public final int H(ImageView r10) {
        return (r10.getHeight() - r10.getPaddingTop()) - r10.getPaddingBottom();
    }

    public final int I(ImageView r10) {
        return (r10.getWidth() - r10.getPaddingLeft()) - r10.getPaddingRight();
    }

    public float J() {
        return this.f10289e;
    }

    public float K() {
        return this.f10288d;
    }

    public float L() {
        return this.f10287c;
    }

    public float M() {
        return (float) Math.sqrt(((float) Math.pow(O(this.f10297m, 0), 2.0d)) + ((float) Math.pow(O(this.f10297m, 3), 2.0d)));
    }

    public ImageView.ScaleType N() {
        return this.D;
    }

    public final float O(Matrix r10, int r11) {
        r10.getValues(this.f10299o);
        return this.f10299o[r11];
    }

    public final void P() {
        this.f10297m.reset();
        V(this.B);
        R(F());
        C();
    }

    public void Q(boolean r10) {
        this.f10290f = r10;
    }

    public final void R(Matrix r10) {
        this.f10292h.setImageMatrix(r10);
        if (this.f10300p == null) goto L8;
        RectF r11 = E(r10);
        if (r11 == null) goto L9;
        this.f10300p.onMatrixChanged(r11);
        return;
    L9:
        return;
    }

    public void S(float r10) {
        com.github.chrisbanes.photoview.d.a(this.f10287c, this.f10288d, r10);
        this.f10289e = r10;
    }

    public void T(float r10) {
        com.github.chrisbanes.photoview.d.a(this.f10287c, r10, this.f10289e);
        this.f10288d = r10;
    }

    public void U(float r10) {
        com.github.chrisbanes.photoview.d.a(r10, this.f10288d, this.f10289e);
        this.f10287c = r10;
    }

    public void V(float r10) {
        this.f10297m.postRotate(r10 % 360.0f);
        B();
    }

    public void W(float r10) {
        this.f10297m.setRotate(r10 % 360.0f);
        B();
    }

    public void X(float r10) {
        Z(r10, false);
    }

    public void Y(float r10, float r11, float r12, boolean r13) {
        if (r10 < this.f10287c) goto L11;
        if (r10 > this.f10289e) goto L11;
        if (r13 == false) goto L8;
        this.f10292h.post(new e(this, M(), r10, r11, r12));
        return;
    L8:
        this.f10297m.setScale(r10, r10, r11, r12);
        B();
        return;
    L11:
        throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
    }

    public void Z(float r10, boolean r11) {
        Y(r10, this.f10292h.getRight() / 2, this.f10292h.getBottom() / 2, r11);
    }

    public void a0(ImageView.ScaleType r10) {
        if (com.github.chrisbanes.photoview.d.d(r10) == true) goto L5;
        return;
    L5:
        if (r10 == this.D) goto L9;
        this.D = r10;
        d0();
        return;
    }

    public void b0(int r10) {
        this.f10286b = r10;
    }

    public void c0(boolean r10) {
        this.C = r10;
        d0();
    }

    public void d0() {
        if (this.C == false) goto L5;
        e0(this.f10292h.getDrawable());
        return;
    L5:
        P();
    }

    public final void e0(Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        float r11 = I(this.f10292h);
        float r12 = H(this.f10292h);
        int r13 = r10.getIntrinsicWidth();
        int r14 = r10.getIntrinsicHeight();
        this.f10295k.reset();
        float r15 = r13;
        float r16 = r11 / r15;
        float r17 = r14;
        float r18 = r12 / r17;
        ImageView.ScaleType r19 = this.D;
        if (r19 != ImageView.ScaleType.CENTER) goto L8;
        this.f10295k.postTranslate((r11 - r15) / 2.0f, (r12 - r17) / 2.0f);
    L29:
        P();
        return;
    L8:
        if (r19 != ImageView.ScaleType.CENTER_CROP) goto L11;
        float r20 = Math.max(r16, r18);
        this.f10295k.postScale(r20, r20);
        this.f10295k.postTranslate((r11 - (r15 * r20)) / 2.0f, (r12 - (r17 * r20)) / 2.0f);
        goto L29
    L11:
        if (r19 != ImageView.ScaleType.CENTER_INSIDE) goto L13;
        float r21 = Math.min(1.0f, Math.min(r16, r18));
        this.f10295k.postScale(r21, r21);
        this.f10295k.postTranslate((r11 - (r15 * r21)) / 2.0f, (r12 - (r17 * r21)) / 2.0f);
        goto L29
    L13:
        RectF r22 = new RectF(0.0f, 0.0f, r15, r17);
        RectF r23 = new RectF(0.0f, 0.0f, r11, r12);
        if ((((int) this.B) % AnimationConstants.DURATION_180) == 0) goto L16;
        r22 = new RectF(0.0f, 0.0f, r17, r15);
    L16:
        int r24 = d.f10314a[this.D.ordinal()];
        if (r24 != 1) goto L19;
        this.f10295k.setRectToRect(r22, r23, Matrix.ScaleToFit.CENTER);
        goto L29
    L19:
        if (r24 != 2) goto L21;
        this.f10295k.setRectToRect(r22, r23, Matrix.ScaleToFit.START);
        goto L29
    L21:
        if (r24 != 3) goto L23;
        this.f10295k.setRectToRect(r22, r23, Matrix.ScaleToFit.END);
        goto L29
    L23:
        if (r24 != 4) goto L29;
        this.f10295k.setRectToRect(r22, r23, Matrix.ScaleToFit.FILL);
        goto L29
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        if (r11 != r15) goto L6;
        if (r12 != r16) goto L6;
        if (r13 != r17) goto L6;
        if (r14 != r18) goto L6;
        return;
    L6:
        e0(this.f10292h.getDrawable());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r11, MotionEvent r12) {
        boolean r10 = false;
        if (this.C == true) goto L5;
        return false;
    L5:
        if (com.github.chrisbanes.photoview.d.c((ImageView) r11) == false) goto L53;
        int r13 = r12.getAction();
        if (r13 == 0) goto L23;
        if (r13 == 1) goto L13;
        if (r13 == 3) goto L13;
    L27:
        boolean r14 = false;
    L28:
        com.github.chrisbanes.photoview.b r15 = this.f10294j;
        if (r15 == null) goto L45;
        boolean r16 = r15.e();
        boolean r17 = this.f10294j.d();
        boolean r18 = this.f10294j.f(r12);
        if (r16 == false) goto L33;
    L35:
        boolean r19 = false;
    L36:
        if (r17 == false) goto L38;
    L40:
        boolean r20 = false;
    L41:
        if (r19 == false) goto L44;
        if (r20 == false) goto L44;
        r10 = true;
    L44:
        this.f10291g = r10;
        boolean r21 = r18;
    L46:
        GestureDetector r110 = this.f10293i;
        if (r110 != null) goto L49;
        return r21;
    L49:
        if (r110.onTouchEvent(r12) == true) goto L51;
        return r21;
    L51:
        return true;
    L38:
        if (this.f10294j.d() == true) goto L40;
        r20 = true;
        goto L41
    L33:
        if (this.f10294j.e() == true) goto L35;
        r19 = true;
        goto L36
    L45:
        r21 = r14;
    L13:
        if (M() >= this.f10287c) goto L18;
        RectF r22 = D();
        if (r22 == null) goto L27;
        r11.post(new e(this, M(), this.f10287c, r22.centerX(), r22.centerY()));
    L22:
        r14 = true;
        goto L28
    L18:
        if (M() <= this.f10289e) goto L27;
        RectF r23 = D();
        if (r23 == null) goto L27;
        r11.post(new e(this, M(), this.f10289e, r23.centerX(), r23.centerY()));
        goto L22
    L23:
        ViewParent r111 = r11.getParent();
        if (r111 == null) goto L26;
        r111.requestDisallowInterceptTouchEvent(true);
    L26:
        A();
        goto L27
    L53:
        return false;
    }

    public void setOnClickListener(View.OnClickListener r10) {
        this.f10304t = r10;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r10) {
        this.f10293i.setOnDoubleTapListener(r10);
    }

    public void setOnLongClickListener(View.OnLongClickListener r10) {
        this.f10305u = r10;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener r10) {
        this.f10300p = r10;
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener r10) {
        this.f10302r = r10;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener r10) {
        this.f10301q = r10;
    }

    public void setOnScaleChangeListener(OnScaleChangedListener r10) {
        this.f10306v = r10;
    }

    public void setOnSingleFlingListener(OnSingleFlingListener r10) {
        this.f10307w = r10;
    }

    public void setOnViewDragListener(OnViewDragListener r10) {
        this.f10308x = r10;
    }

    public void setOnViewTapListener(OnViewTapListener r10) {
        this.f10303s = r10;
    }
}
