package a2;

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

/* renamed from: a2.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnTouchListenerC1224l implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: B, reason: collision with root package name */
    public static float f7879B = 3.0f;

    /* renamed from: C, reason: collision with root package name */
    public static float f7880C = 1.75f;

    /* renamed from: D, reason: collision with root package name */
    public static float f7881D = 1.0f;

    /* renamed from: E, reason: collision with root package name */
    public static int f7882E = 200;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f7891h;

    /* renamed from: i, reason: collision with root package name */
    public GestureDetector f7892i;

    /* renamed from: j, reason: collision with root package name */
    public C1214b f7893j;

    /* renamed from: p, reason: collision with root package name */
    public InterfaceC1218f f7899p;

    /* renamed from: q, reason: collision with root package name */
    public InterfaceC1217e f7900q;

    /* renamed from: r, reason: collision with root package name */
    public View.OnClickListener f7901r;

    /* renamed from: s, reason: collision with root package name */
    public View.OnLongClickListener f7902s;

    /* renamed from: t, reason: collision with root package name */
    public InterfaceC1219g f7903t;

    /* renamed from: u, reason: collision with root package name */
    public f f7904u;

    /* renamed from: x, reason: collision with root package name */
    public float f7907x;

    /* renamed from: a, reason: collision with root package name */
    public Interpolator f7884a = new AccelerateDecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public int f7885b = f7882E;

    /* renamed from: c, reason: collision with root package name */
    public float f7886c = f7881D;

    /* renamed from: d, reason: collision with root package name */
    public float f7887d = f7880C;

    /* renamed from: e, reason: collision with root package name */
    public float f7888e = f7879B;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7889f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7890g = false;

    /* renamed from: k, reason: collision with root package name */
    public final Matrix f7894k = new Matrix();

    /* renamed from: l, reason: collision with root package name */
    public final Matrix f7895l = new Matrix();

    /* renamed from: m, reason: collision with root package name */
    public final Matrix f7896m = new Matrix();

    /* renamed from: n, reason: collision with root package name */
    public final RectF f7897n = new RectF();

    /* renamed from: o, reason: collision with root package name */
    public final float[] f7898o = new float[9];

    /* renamed from: v, reason: collision with root package name */
    public int f7905v = 2;

    /* renamed from: w, reason: collision with root package name */
    public int f7906w = 2;

    /* renamed from: y, reason: collision with root package name */
    public boolean f7908y = true;

    /* renamed from: z, reason: collision with root package name */
    public ImageView.ScaleType f7909z = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: A, reason: collision with root package name */
    public InterfaceC1215c f7883A = new a();

    /* renamed from: a2.l$a */
    public class a implements InterfaceC1215c {
        public a() {
        }

        @Override // a2.InterfaceC1215c
        public void onDrag(float f10, float f11) {
            if (ViewOnTouchListenerC1224l.this.f7893j.e()) {
                return;
            }
            ViewOnTouchListenerC1224l.b(ViewOnTouchListenerC1224l.this);
            ViewOnTouchListenerC1224l.this.f7896m.postTranslate(f10, f11);
            ViewOnTouchListenerC1224l.this.z();
            ViewParent parent = ViewOnTouchListenerC1224l.this.f7891h.getParent();
            if (!ViewOnTouchListenerC1224l.this.f7889f || ViewOnTouchListenerC1224l.this.f7893j.e() || ViewOnTouchListenerC1224l.this.f7890g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((ViewOnTouchListenerC1224l.this.f7905v == 2 || ((ViewOnTouchListenerC1224l.this.f7905v == 0 && f10 >= 1.0f) || ((ViewOnTouchListenerC1224l.this.f7905v == 1 && f10 <= -1.0f) || ((ViewOnTouchListenerC1224l.this.f7906w == 0 && f11 >= 1.0f) || (ViewOnTouchListenerC1224l.this.f7906w == 1 && f11 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // a2.InterfaceC1215c
        public void onFling(float f10, float f11, float f12, float f13) {
            ViewOnTouchListenerC1224l viewOnTouchListenerC1224l = ViewOnTouchListenerC1224l.this;
            viewOnTouchListenerC1224l.f7904u = viewOnTouchListenerC1224l.new f(viewOnTouchListenerC1224l.f7891h.getContext());
            f fVar = ViewOnTouchListenerC1224l.this.f7904u;
            ViewOnTouchListenerC1224l viewOnTouchListenerC1224l2 = ViewOnTouchListenerC1224l.this;
            int iG = viewOnTouchListenerC1224l2.G(viewOnTouchListenerC1224l2.f7891h);
            ViewOnTouchListenerC1224l viewOnTouchListenerC1224l3 = ViewOnTouchListenerC1224l.this;
            fVar.b(iG, viewOnTouchListenerC1224l3.F(viewOnTouchListenerC1224l3.f7891h), (int) f12, (int) f13);
            ViewOnTouchListenerC1224l.this.f7891h.post(ViewOnTouchListenerC1224l.this.f7904u);
        }

        @Override // a2.InterfaceC1215c
        public void onScale(float f10, float f11, float f12) {
            if (ViewOnTouchListenerC1224l.this.K() < ViewOnTouchListenerC1224l.this.f7888e || f10 < 1.0f) {
                if (ViewOnTouchListenerC1224l.this.f7903t != null) {
                    ViewOnTouchListenerC1224l.this.f7903t.onScaleChange(f10, f11, f12);
                }
                ViewOnTouchListenerC1224l.this.f7896m.postScale(f10, f10, f11, f12);
                ViewOnTouchListenerC1224l.this.z();
            }
        }
    }

    /* renamed from: a2.l$b */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            ViewOnTouchListenerC1224l.h(ViewOnTouchListenerC1224l.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ViewOnTouchListenerC1224l.this.f7902s != null) {
                ViewOnTouchListenerC1224l.this.f7902s.onLongClick(ViewOnTouchListenerC1224l.this.f7891h);
            }
        }
    }

    /* renamed from: a2.l$c */
    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fK = ViewOnTouchListenerC1224l.this.K();
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                if (fK < ViewOnTouchListenerC1224l.this.I()) {
                    ViewOnTouchListenerC1224l viewOnTouchListenerC1224l = ViewOnTouchListenerC1224l.this;
                    viewOnTouchListenerC1224l.g0(viewOnTouchListenerC1224l.I(), x10, y10, true);
                } else if (fK < ViewOnTouchListenerC1224l.this.I() || fK >= ViewOnTouchListenerC1224l.this.H()) {
                    ViewOnTouchListenerC1224l viewOnTouchListenerC1224l2 = ViewOnTouchListenerC1224l.this;
                    viewOnTouchListenerC1224l2.g0(viewOnTouchListenerC1224l2.J(), x10, y10, true);
                } else {
                    ViewOnTouchListenerC1224l viewOnTouchListenerC1224l3 = ViewOnTouchListenerC1224l.this;
                    viewOnTouchListenerC1224l3.g0(viewOnTouchListenerC1224l3.H(), x10, y10, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ViewOnTouchListenerC1224l.this.f7901r != null) {
                ViewOnTouchListenerC1224l.this.f7901r.onClick(ViewOnTouchListenerC1224l.this.f7891h);
            }
            RectF rectFB = ViewOnTouchListenerC1224l.this.B();
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            ViewOnTouchListenerC1224l.j(ViewOnTouchListenerC1224l.this);
            if (rectFB == null) {
                return false;
            }
            if (!rectFB.contains(x10, y10)) {
                if (ViewOnTouchListenerC1224l.this.f7900q == null) {
                    return false;
                }
                ViewOnTouchListenerC1224l.this.f7900q.onOutsidePhotoTap(ViewOnTouchListenerC1224l.this.f7891h);
                return false;
            }
            float fWidth = (x10 - rectFB.left) / rectFB.width();
            float fHeight = (y10 - rectFB.top) / rectFB.height();
            if (ViewOnTouchListenerC1224l.this.f7899p == null) {
                return true;
            }
            ViewOnTouchListenerC1224l.this.f7899p.onPhotoTap(ViewOnTouchListenerC1224l.this.f7891h, fWidth, fHeight);
            return true;
        }
    }

    /* renamed from: a2.l$d */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7913a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f7913a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7913a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7913a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7913a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a2.l$e */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final float f7914a;

        /* renamed from: b, reason: collision with root package name */
        public final float f7915b;

        /* renamed from: c, reason: collision with root package name */
        public final long f7916c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        public final float f7917d;

        /* renamed from: e, reason: collision with root package name */
        public final float f7918e;

        public e(float f10, float f11, float f12, float f13) {
            this.f7914a = f12;
            this.f7915b = f13;
            this.f7917d = f10;
            this.f7918e = f11;
        }

        public final float a() {
            return ViewOnTouchListenerC1224l.this.f7884a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f7916c) * 1.0f) / ViewOnTouchListenerC1224l.this.f7885b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f10 = this.f7917d;
            ViewOnTouchListenerC1224l.this.f7883A.onScale((f10 + ((this.f7918e - f10) * fA)) / ViewOnTouchListenerC1224l.this.K(), this.f7914a, this.f7915b);
            if (fA < 1.0f) {
                C1213a.a(ViewOnTouchListenerC1224l.this.f7891h, this);
            }
        }
    }

    /* renamed from: a2.l$f */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final OverScroller f7920a;

        /* renamed from: b, reason: collision with root package name */
        public int f7921b;

        /* renamed from: c, reason: collision with root package name */
        public int f7922c;

        public f(Context context) {
            this.f7920a = new OverScroller(context);
        }

        public void a() {
            this.f7920a.forceFinished(true);
        }

        public void b(int i10, int i11, int i12, int i13) {
            int i14;
            int iRound;
            int i15;
            int iRound2;
            RectF rectFB = ViewOnTouchListenerC1224l.this.B();
            if (rectFB == null) {
                return;
            }
            int iRound3 = Math.round(-rectFB.left);
            float f10 = i10;
            if (f10 < rectFB.width()) {
                iRound = Math.round(rectFB.width() - f10);
                i14 = 0;
            } else {
                i14 = iRound3;
                iRound = i14;
            }
            int iRound4 = Math.round(-rectFB.top);
            float f11 = i11;
            if (f11 < rectFB.height()) {
                iRound2 = Math.round(rectFB.height() - f11);
                i15 = 0;
            } else {
                i15 = iRound4;
                iRound2 = i15;
            }
            this.f7921b = iRound3;
            this.f7922c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f7920a.fling(iRound3, iRound4, i12, i13, i14, iRound, i15, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f7920a.isFinished() && this.f7920a.computeScrollOffset()) {
                int currX = this.f7920a.getCurrX();
                int currY = this.f7920a.getCurrY();
                ViewOnTouchListenerC1224l.this.f7896m.postTranslate(this.f7921b - currX, this.f7922c - currY);
                ViewOnTouchListenerC1224l.this.z();
                this.f7921b = currX;
                this.f7922c = currY;
                C1213a.a(ViewOnTouchListenerC1224l.this.f7891h, this);
            }
        }
    }

    public ViewOnTouchListenerC1224l(ImageView imageView) {
        this.f7891h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f7907x = 0.0f;
        this.f7893j = new C1214b(imageView.getContext(), this.f7883A);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f7892i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    public static /* synthetic */ InterfaceC1221i b(ViewOnTouchListenerC1224l viewOnTouchListenerC1224l) {
        viewOnTouchListenerC1224l.getClass();
        return null;
    }

    public static /* synthetic */ InterfaceC1220h h(ViewOnTouchListenerC1224l viewOnTouchListenerC1224l) {
        viewOnTouchListenerC1224l.getClass();
        return null;
    }

    public static /* synthetic */ InterfaceC1222j j(ViewOnTouchListenerC1224l viewOnTouchListenerC1224l) {
        viewOnTouchListenerC1224l.getClass();
        return null;
    }

    public final boolean A() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        RectF rectFC = C(D());
        if (rectFC == null) {
            return false;
        }
        float fHeight = rectFC.height();
        float fWidth = rectFC.width();
        float F10 = F(this.f7891h);
        float f15 = 0.0f;
        if (fHeight <= F10) {
            int i10 = d.f7913a[this.f7909z.ordinal()];
            if (i10 != 2) {
                if (i10 != 3) {
                    f13 = (F10 - fHeight) / 2.0f;
                    f14 = rectFC.top;
                } else {
                    f13 = F10 - fHeight;
                    f14 = rectFC.top;
                }
                f10 = f13 - f14;
            } else {
                f10 = -rectFC.top;
            }
            this.f7906w = 2;
        } else {
            float f16 = rectFC.top;
            if (f16 > 0.0f) {
                this.f7906w = 0;
                f10 = -f16;
            } else {
                float f17 = rectFC.bottom;
                if (f17 < F10) {
                    this.f7906w = 1;
                    f10 = F10 - f17;
                } else {
                    this.f7906w = -1;
                    f10 = 0.0f;
                }
            }
        }
        float fG = G(this.f7891h);
        if (fWidth <= fG) {
            int i11 = d.f7913a[this.f7909z.ordinal()];
            if (i11 != 2) {
                if (i11 != 3) {
                    f11 = (fG - fWidth) / 2.0f;
                    f12 = rectFC.left;
                } else {
                    f11 = fG - fWidth;
                    f12 = rectFC.left;
                }
                f15 = f11 - f12;
            } else {
                f15 = -rectFC.left;
            }
            this.f7905v = 2;
        } else {
            float f18 = rectFC.left;
            if (f18 > 0.0f) {
                this.f7905v = 0;
                f15 = -f18;
            } else {
                float f19 = rectFC.right;
                if (f19 < fG) {
                    f15 = fG - f19;
                    this.f7905v = 1;
                } else {
                    this.f7905v = -1;
                }
            }
        }
        this.f7896m.postTranslate(f15, f10);
        return true;
    }

    public RectF B() {
        A();
        return C(D());
    }

    public final RectF C(Matrix matrix) {
        if (this.f7891h.getDrawable() == null) {
            return null;
        }
        this.f7897n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.f7897n);
        return this.f7897n;
    }

    public final Matrix D() {
        this.f7895l.set(this.f7894k);
        this.f7895l.postConcat(this.f7896m);
        return this.f7895l;
    }

    public Matrix E() {
        return this.f7895l;
    }

    public final int F(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final int G(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public float H() {
        return this.f7888e;
    }

    public float I() {
        return this.f7887d;
    }

    public float J() {
        return this.f7886c;
    }

    public float K() {
        return (float) Math.sqrt(((float) Math.pow(M(this.f7896m, 0), 2.0d)) + ((float) Math.pow(M(this.f7896m, 3), 2.0d)));
    }

    public ImageView.ScaleType L() {
        return this.f7909z;
    }

    public final float M(Matrix matrix, int i10) {
        matrix.getValues(this.f7898o);
        return this.f7898o[i10];
    }

    public final void N() {
        this.f7896m.reset();
        d0(this.f7907x);
        P(D());
        A();
    }

    public void O(boolean z10) {
        this.f7889f = z10;
    }

    public final void P(Matrix matrix) {
        this.f7891h.setImageMatrix(matrix);
    }

    public void Q(float f10) {
        C1225m.a(this.f7886c, this.f7887d, f10);
        this.f7888e = f10;
    }

    public void R(float f10) {
        C1225m.a(this.f7886c, f10, this.f7888e);
        this.f7887d = f10;
    }

    public void S(float f10) {
        C1225m.a(f10, this.f7887d, this.f7888e);
        this.f7886c = f10;
    }

    public void T(View.OnClickListener onClickListener) {
        this.f7901r = onClickListener;
    }

    public void U(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f7892i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void V(View.OnLongClickListener onLongClickListener) {
        this.f7902s = onLongClickListener;
    }

    public void W(InterfaceC1216d interfaceC1216d) {
    }

    public void X(InterfaceC1217e interfaceC1217e) {
        this.f7900q = interfaceC1217e;
    }

    public void Y(InterfaceC1218f interfaceC1218f) {
        this.f7899p = interfaceC1218f;
    }

    public void Z(InterfaceC1219g interfaceC1219g) {
        this.f7903t = interfaceC1219g;
    }

    public void a0(InterfaceC1220h interfaceC1220h) {
    }

    public void b0(InterfaceC1221i interfaceC1221i) {
    }

    public void c0(InterfaceC1222j interfaceC1222j) {
    }

    public void d0(float f10) {
        this.f7896m.postRotate(f10 % 360.0f);
        z();
    }

    public void e0(float f10) {
        this.f7896m.setRotate(f10 % 360.0f);
        z();
    }

    public void f0(float f10) {
        h0(f10, false);
    }

    public void g0(float f10, float f11, float f12, boolean z10) {
        if (f10 < this.f7886c || f10 > this.f7888e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z10) {
            this.f7891h.post(new e(K(), f10, f11, f12));
        } else {
            this.f7896m.setScale(f10, f10, f11, f12);
            z();
        }
    }

    public void h0(float f10, boolean z10) {
        g0(f10, this.f7891h.getRight() / 2, this.f7891h.getBottom() / 2, z10);
    }

    public void i0(ImageView.ScaleType scaleType) {
        if (!C1225m.d(scaleType) || scaleType == this.f7909z) {
            return;
        }
        this.f7909z = scaleType;
        l0();
    }

    public void j0(int i10) {
        this.f7885b = i10;
    }

    public void k0(boolean z10) {
        this.f7908y = z10;
        l0();
    }

    public void l0() {
        if (this.f7908y) {
            m0(this.f7891h.getDrawable());
        } else {
            N();
        }
    }

    public final void m0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fG = G(this.f7891h);
        float F10 = F(this.f7891h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f7894k.reset();
        float f10 = intrinsicWidth;
        float f11 = fG / f10;
        float f12 = intrinsicHeight;
        float f13 = F10 / f12;
        ImageView.ScaleType scaleType = this.f7909z;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f7894k.postTranslate((fG - f10) / 2.0f, (F10 - f12) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f11, f13);
            this.f7894k.postScale(fMax, fMax);
            this.f7894k.postTranslate((fG - (f10 * fMax)) / 2.0f, (F10 - (f12 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f11, f13));
            this.f7894k.postScale(fMin, fMin);
            this.f7894k.postTranslate((fG - (f10 * fMin)) / 2.0f, (F10 - (f12 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f10, f12);
            RectF rectF2 = new RectF(0.0f, 0.0f, fG, F10);
            if (((int) this.f7907x) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f12, f10);
            }
            int i10 = d.f7913a[this.f7909z.ordinal()];
            if (i10 == 1) {
                this.f7894k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i10 == 2) {
                this.f7894k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i10 == 3) {
                this.f7894k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i10 == 4) {
                this.f7894k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        N();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 == i14 && i11 == i15 && i12 == i16 && i13 == i17) {
            return;
        }
        m0(this.f7891h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
            r8 = this;
            boolean r0 = r8.f7908y
            r6 = 0
            if (r0 == 0) goto Lc4
            r0 = r9
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = a2.C1225m.c(r0)
            if (r0 == 0) goto Lc4
            int r0 = r10.getAction()
            r7 = 1
            if (r0 == 0) goto L75
            if (r0 == r7) goto L1c
            r2 = 3
            if (r0 == r2) goto L1c
            goto L81
        L1c:
            float r0 = r8.K()
            float r2 = r8.f7886c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L48
            android.graphics.RectF r0 = r8.B()
            if (r0 == 0) goto L81
            r2 = r0
            a2.l$e r0 = new a2.l$e
            r3 = r2
            float r2 = r8.K()
            r4 = r3
            float r3 = r8.f7886c
            r5 = r4
            float r4 = r5.centerX()
            float r5 = r5.centerY()
            r1 = r8
            r0.<init>(r2, r3, r4, r5)
            r9.post(r0)
            goto L73
        L48:
            float r0 = r8.K()
            float r2 = r8.f7888e
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L81
            android.graphics.RectF r0 = r8.B()
            if (r0 == 0) goto L81
            r2 = r0
            a2.l$e r0 = new a2.l$e
            r3 = r2
            float r2 = r8.K()
            r4 = r3
            float r3 = r8.f7888e
            r5 = r4
            float r4 = r5.centerX()
            float r5 = r5.centerY()
            r1 = r8
            r0.<init>(r2, r3, r4, r5)
            r9.post(r0)
        L73:
            r0 = r7
            goto L82
        L75:
            android.view.ViewParent r0 = r9.getParent()
            if (r0 == 0) goto L7e
            r0.requestDisallowInterceptTouchEvent(r7)
        L7e:
            r8.y()
        L81:
            r0 = r6
        L82:
            a2.b r2 = r8.f7893j
            if (r2 == 0) goto Lb8
            boolean r0 = r2.e()
            a2.b r2 = r8.f7893j
            boolean r2 = r2.d()
            a2.b r3 = r8.f7893j
            boolean r3 = r3.f(r10)
            if (r0 != 0) goto La2
            a2.b r0 = r8.f7893j
            boolean r0 = r0.e()
            if (r0 != 0) goto La2
            r0 = r7
            goto La3
        La2:
            r0 = r6
        La3:
            if (r2 != 0) goto Laf
            a2.b r2 = r8.f7893j
            boolean r2 = r2.d()
            if (r2 != 0) goto Laf
            r2 = r7
            goto Lb0
        Laf:
            r2 = r6
        Lb0:
            if (r0 == 0) goto Lb5
            if (r2 == 0) goto Lb5
            r6 = r7
        Lb5:
            r8.f7890g = r6
            r0 = r3
        Lb8:
            android.view.GestureDetector r1 = r8.f7892i
            if (r1 == 0) goto Lc3
            boolean r1 = r1.onTouchEvent(r10)
            if (r1 == 0) goto Lc3
            return r7
        Lc3:
            return r0
        Lc4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.ViewOnTouchListenerC1224l.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void y() {
        f fVar = this.f7904u;
        if (fVar != null) {
            fVar.a();
            this.f7904u = null;
        }
    }

    public final void z() {
        if (A()) {
            P(D());
        }
    }
}
