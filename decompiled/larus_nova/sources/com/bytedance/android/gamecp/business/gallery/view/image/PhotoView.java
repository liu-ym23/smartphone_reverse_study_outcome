package com.bytedance.android.gamecp.business.gallery.view.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.gamecp.common.utils.p0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes44.dex */
public class PhotoView extends AppCompatImageView {
    public int A;
    public int B;
    public float C;
    public float D;
    public final RectF E;
    public final RectF F;
    public final RectF G;
    public final RectF H;
    public final RectF I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final PointF f53293J;
    public final PointF K;
    public final PointF L;
    public final j M;
    public RectF N;
    public zs.a O;
    public long P;
    public Runnable Q;
    public View.OnLongClickListener R;
    public final a S;
    public final b T;
    public final c U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f53295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f53298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f53299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f53300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f53301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f53302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GestureDetector f53303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ScaleGestureDetector f53304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View.OnClickListener f53305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView.ScaleType f53306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f53307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f53308o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f53309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f53310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f53311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f53312s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f53313t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f53314u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f53315v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f53316w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f53317x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f53318y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f53319z;

    public class a implements ScaleGestureDetector.OnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f53320a;

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r100) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector r100) {
        }

        public a(PhotoView r100) {
            this.f53320a = r100;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            float r101 = r100.getScaleFactor();
            if (Float.isNaN(r101) == false) goto L5;
        L13:
            return false;
        L5:
            if (Float.isInfinite(r101) == true) goto L13;
            PhotoView r102 = this.f53320a;
            float r103 = r102.f53319z * r101;
            r102.f53319z = r103;
            if (r103 <= 1.0f) goto L10;
            r102.f53314u = true;
        L11:
            r102.f53300g.postScale(r101, r101, r100.getFocusX(), r100.getFocusY());
            this.f53320a.o();
            return true;
        L10:
            r102.f53314u = false;
            goto L11
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f53321a;

        @Override // java.lang.Runnable
        public final void run() {
            PhotoView r100 = this.f53321a;     // Catch: Throwable -> L6
            View.OnClickListener r101 = r100.f53305l;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.onClick(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(PhotoView r100) {
            this.f53321a = r100;
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f53322a;

        public c(PhotoView r100) {
            this.f53322a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            this.f53322a.M.c();
            RectF r101 = this.f53322a.G;
            float r102 = r101.left + (r101.width() / 2.0f);
            RectF r103 = this.f53322a.G;
            float r104 = r103.top + (r103.height() / 2.0f);
            this.f53322a.K.set(r102, r104);
            this.f53322a.L.set(r102, r104);
            PhotoView r105 = this.f53322a;
            r105.A = 0;
            r105.B = 0;
            if (r105.f53314u == false) goto L5;
            float r106 = r105.f53319z;
            float r107 = 1.0f;
        L6:
            this.f53322a.f53302i.reset();
            PhotoView r108 = this.f53322a;
            Matrix r109 = r108.f53302i;
            RectF r110 = r108.F;
            r109.postTranslate(-r110.left, -r110.top);
            PhotoView r111 = this.f53322a;
            Matrix r112 = r111.f53302i;
            PointF r113 = r111.L;
            r112.postTranslate(r113.x, r113.y);
            PhotoView r114 = this.f53322a;
            r114.f53302i.postTranslate(-r114.C, -r114.D);
            PhotoView r115 = this.f53322a;
            Matrix r116 = r115.f53302i;
            float r117 = r115.f53318y;
            PointF r118 = r115.L;
            r116.postRotate(r117, r118.x, r118.y);
            PhotoView r119 = this.f53322a;
            Matrix r120 = r119.f53302i;
            PointF r121 = r119.K;
            r120.postScale(r107, r107, r121.x, r121.y);
            PhotoView r122 = this.f53322a;
            r122.f53302i.postTranslate(r122.A, r122.B);
            PhotoView r123 = this.f53322a;
            r123.f53302i.mapRect(r123.H, r123.F);
            PhotoView r124 = this.f53322a;
            r124.n(r124.H);
            PhotoView r125 = this.f53322a;
            r125.f53314u = !r125.f53314u;
            r125.M.d(r106, r107);
            j r126 = this.f53322a.M;
            r126.f53328a = true;
            r126.f53341n.post(r126);
            return false;
        L5:
            float r127 = r105.f53319z;
            float r128 = r105.f53295b;
            r105.K.set(r100.getX(), r100.getY());
            r106 = r127;
            r107 = r128;
            goto L6
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            PhotoView r101 = this.f53322a;
            r101.f53310q = false;
            r101.f53307n = false;
            r101.f53315v = false;
            r101.removeCallbacks(r101.T);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            PhotoView r101 = this.f53322a;
            View.OnLongClickListener r102 = r101.R;
            if (r102 == null) goto L6;
            r102.onLongClick(r101);
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            PhotoView r101 = this.f53322a;
            r101.postDelayed(r101.T, 250);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r210, MotionEvent r211, float r212, float r310) {
            PhotoView r100 = this.f53322a;
            if (r100.f53307n == false) goto L6;
            return false;
        L6:
            if (r100.f53316w == true) goto L11;
            if (r100.f53317x == true) goto L11;
            return false;
        L11:
            if (r100.M.f53328a == false) goto L13;
            return false;
        L13:
            float r101 = Math.round(r100.G.left);
            PhotoView r102 = this.f53322a;
            if (r101 < r102.E.left) goto L16;
        L19:
            float r103 = 0.0f;
        L20:
            float r104 = Math.round(this.f53322a.G.top);
            PhotoView r105 = this.f53322a;
            if (r104 < r105.E.top) goto L23;
        L26:
            float r106 = 0.0f;
        L27:
            PhotoView r107 = this.f53322a;
            if (r107.f53315v == false) goto L30;
        L31:
            float r108 = r107.f53318y;
            float r109 = ((int) (r108 / 90.0f)) * 90;
            float r110 = r108 % 90.0f;
            if (r110 <= 45.0f) goto L35;
            r109 = r109 + 90.0f;
        L37:
            j r111 = r107.M;
            int r112 = (int) r108;
            r111.f53333f.startScroll(r112, 0, ((int) r109) - r112, 0, r111.f53341n.f53294a);
            this.f53322a.f53318y = r109;
        L38:
            PhotoView r113 = this.f53322a;
            r113.n(r113.G);
            j r114 = this.f53322a.M;
            r114.getClass();
            if (r103 >= 0.0f) goto L41;
            int r115 = Integer.MAX_VALUE;
        L42:
            r114.f53335h = r115;
            PhotoView r116 = r114.f53341n;
            if (r103 <= 0.0f) goto L45;
            float r117 = Math.abs(r116.G.left);
        L46:
            int r118 = (int) r117;
            if (r103 >= 0.0f) goto L49;
            r118 = Integer.MAX_VALUE - r118;
        L49:
            if (r103 >= 0.0f) goto L51;
            int r119 = r118;
        L52:
            if (r103 >= 0.0f) goto L54;
            int r120 = Integer.MAX_VALUE;
        L55:
            if (r103 >= 0.0f) goto L58;
            r118 = Integer.MAX_VALUE - r119;
        L58:
            if (r106 >= 0.0f) goto L60;
            int r121 = Integer.MAX_VALUE;
        L61:
            r114.f53336i = r121;
            PhotoView r122 = r114.f53341n;
            if (r106 <= 0.0f) goto L64;
            float r123 = Math.abs(r122.G.top);
        L65:
            int r124 = (int) r123;
            if (r106 >= 0.0f) goto L68;
            r124 = Integer.MAX_VALUE - r124;
        L68:
            if (r106 >= 0.0f) goto L70;
            int r125 = r124;
        L71:
            if (r106 >= 0.0f) goto L73;
            int r126 = Integer.MAX_VALUE;
        L74:
            if (r106 >= 0.0f) goto L76;
            r124 = Integer.MAX_VALUE - r125;
        L76:
            if (r103 != 0.0f) goto L78;
            int r213 = 0;
            int r214 = 0;
        L79:
            if (r106 != 0.0f) goto L81;
            int r215 = 0;
            int r216 = 0;
        L82:
            OverScroller r127 = r114.f53330c;
            int r128 = r114.f53335h;
            int r129 = r114.f53336i;
            int r130 = (int) r103;
            int r131 = (int) r106;
            int r132 = Math.abs(r118);
            int r133 = r114.f53341n.f53296c;
            if (r132 >= (r133 * 2)) goto L85;
            int r217 = 0;
        L86:
            int r134 = Math.abs(r124);
            int r135 = r114.f53341n.f53296c;
            if (r134 >= (r135 * 2)) goto L89;
            int r218 = 0;
        L90:
            r127.fling(r128, r129, r130, r131, r213, r214, r215, r216, r217, r218);
            j r136 = this.f53322a.M;
            r136.f53328a = true;
            r136.f53341n.post(r136);
            return super.onFling(r210, r211, r212, r310);
        L89:
            r218 = r135;
            goto L90
        L85:
            r217 = r133;
            goto L86
        L81:
            r215 = r125;
            r216 = r126;
            goto L82
        L78:
            r213 = r119;
            r214 = r120;
            goto L79
        L73:
            r126 = r124;
            goto L74
        L70:
            r125 = 0;
            goto L71
        L64:
            r123 = r122.G.bottom - r122.E.bottom;
            goto L65
        L60:
            r121 = 0;
            goto L61
        L54:
            r120 = r118;
            goto L55
        L51:
            r119 = 0;
            goto L52
        L45:
            r117 = r116.G.right - r116.E.right;
            goto L46
        L41:
            r115 = 0;
            goto L42
        L35:
            if (r110 >= (-45.0f)) goto L37;
            r109 = r109 - 90.0f;
            goto L37
        L30:
            if ((r107.f53318y % 90.0f) == 0.0f) goto L38;
        L23:
            if (Math.round(r105.G.bottom) <= this.f53322a.E.bottom) goto L26;
            r106 = r310;
            goto L27
        L16:
            if (Math.round(r102.G.right) <= this.f53322a.E.right) goto L19;
            r103 = r212;
            goto L20
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            j r104 = this.f53322a.M;
            if (r104.f53328a == false) goto L6;
            r104.c();
        L6:
            if (this.f53322a.l(r102) == true) goto L8;
            PhotoView r105 = this.f53322a;
            if (r105.f53316w == false) goto L21;
        L24:
            PhotoView.j(r105);
            PhotoView r106 = this.f53322a;
            if (r106.f53307n == false) goto L27;
        L36:
            PhotoView r107 = this.f53322a;
            r107.A = (int) (r107.A - r102);
            r107.f53300g.postTranslate(-r102, 0.0f);
            this.f53322a.f53310q = true;
        L38:
            if (this.f53322a.m(r103) == true) goto L40;
            PhotoView r108 = this.f53322a;
            if (r108.f53317x == false) goto L53;
        L56:
            PhotoView.j(r108);
            PhotoView r109 = this.f53322a;
            if (r109.f53307n == false) goto L59;
        L68:
            this.f53322a.f53300g.postTranslate(0.0f, -r103);
            PhotoView r110 = this.f53322a;
            r110.B = (int) (r110.B - r103);
            r110.f53310q = true;
        L69:
            this.f53322a.o();
            return true;
        L59:
            if (r103 >= 0.0f) goto L64;
            float r111 = r109.G.top;
            float r112 = r111 - r103;
            float r113 = r109.I.top;
            if (r112 <= r113) goto L64;
            r103 = r103 * (Math.abs(Math.abs(r111 - r113) - r109.f53297d) / r109.f53297d);
        L64:
            if (r103 <= 0.0f) goto L68;
            PhotoView r114 = this.f53322a;
            float r115 = r114.G.bottom;
            float r116 = r115 - r103;
            float r117 = r114.I.bottom;
            if (r116 >= r117) goto L68;
            r103 = r103 * (Math.abs(Math.abs(r115 - r117) - r114.f53297d) / r114.f53297d);
            goto L68
        L53:
            if (r108.f53310q == true) goto L56;
            if (r108.f53307n == false) goto L69;
        L40:
            if (r103 >= 0.0f) goto L45;
            PhotoView r118 = this.f53322a;
            float r119 = r118.G.top;
            if ((r119 - r103) <= r118.E.top) goto L45;
            r103 = r119;
        L45:
            if (r103 <= 0.0f) goto L49;
            PhotoView r120 = this.f53322a;
            float r121 = r120.G.bottom;
            float r122 = r121 - r103;
            float r123 = r120.E.bottom;
            if (r122 >= r123) goto L49;
            r103 = r121 - r123;
        L49:
            this.f53322a.f53300g.postTranslate(0.0f, -r103);
            PhotoView r124 = this.f53322a;
            r124.B = (int) (r124.B - r103);
            goto L69
        L27:
            if (r102 >= 0.0f) goto L32;
            float r125 = r106.G.left;
            float r126 = r125 - r102;
            float r127 = r106.I.left;
            if (r126 <= r127) goto L32;
            r102 = r102 * (Math.abs(Math.abs(r125 - r127) - r106.f53297d) / r106.f53297d);
        L32:
            if (r102 <= 0.0f) goto L36;
            PhotoView r128 = this.f53322a;
            float r129 = r128.G.right;
            float r130 = r129 - r102;
            float r131 = r128.I.right;
            if (r130 >= r131) goto L36;
            r102 = r102 * (Math.abs(Math.abs(r129 - r131) - r128.f53297d) / r128.f53297d);
            goto L36
        L21:
            if (r105.f53307n == true) goto L24;
            if (r105.f53310q == false) goto L38;
        L8:
            if (r102 >= 0.0f) goto L13;
            PhotoView r132 = this.f53322a;
            float r133 = r132.G.left;
            if ((r133 - r102) <= r132.E.left) goto L13;
            r102 = r133;
        L13:
            if (r102 <= 0.0f) goto L17;
            PhotoView r134 = this.f53322a;
            float r135 = r134.G.right;
            float r136 = r135 - r102;
            float r137 = r134.E.right;
            if (r136 >= r137) goto L17;
            r102 = r135 - r137;
        L17:
            this.f53322a.f53300g.postTranslate(-r102, 0.0f);
            PhotoView r138 = this.f53322a;
            r138.A = (int) (r138.A - r102);
            goto L38
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f53323a = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            f53323a = r100;
            r100[ImageView.ScaleType.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f53323a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f53323a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f53323a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f53323a[ImageView.ScaleType.FIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f53323a[ImageView.ScaleType.FIT_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f53323a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public interface e {
        float a();
    }

    public class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f53324a;

        @Override // com.bytedance.android.gamecp.business.gallery.view.image.PhotoView.e
        public final float a() {
            return this.f53324a.G.bottom;
        }

        public f(PhotoView r100) {
            this.f53324a = r100;
        }
    }

    public class g implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Interpolator f53325a;

        public g() {
            this.f53325a = new DecelerateInterpolator();
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            Interpolator r101 = this.f53325a;
            if (r101 != null) goto L5;
            return r100;
        L5:
            return r101.getInterpolation(r100);
        }
    }

    public class h implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f53326a;

        @Override // com.bytedance.android.gamecp.business.gallery.view.image.PhotoView.e
        public final float a() {
            RectF r100 = this.f53326a.G;
            return (r100.top + r100.bottom) / 2.0f;
        }

        public h(PhotoView r100) {
            this.f53326a = r100;
        }
    }

    public class i implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoView f53327a;

        @Override // com.bytedance.android.gamecp.business.gallery.view.image.PhotoView.e
        public final float a() {
            return this.f53327a.G.top;
        }

        public i(PhotoView r100) {
            this.f53327a = r100;
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f53328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OverScroller f53329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OverScroller f53330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Scroller f53331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Scroller f53332e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Scroller f53333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public e f53334g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f53335h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f53336i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f53337j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f53338k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final RectF f53339l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final g f53340m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ PhotoView f53341n;

        public final void a() {
            this.f53341n.f53300g.reset();
            PhotoView r100 = this.f53341n;
            Matrix r101 = r100.f53300g;
            RectF r102 = r100.F;
            r101.postTranslate(-r102.left, -r102.top);
            PhotoView r103 = this.f53341n;
            Matrix r104 = r103.f53300g;
            PointF r105 = r103.L;
            r104.postTranslate(r105.x, r105.y);
            PhotoView r106 = this.f53341n;
            r106.f53300g.postTranslate(-r106.C, -r106.D);
            PhotoView r107 = this.f53341n;
            Matrix r108 = r107.f53300g;
            float r109 = r107.f53318y;
            PointF r110 = r107.L;
            r108.postRotate(r109, r110.x, r110.y);
            PhotoView r111 = this.f53341n;
            Matrix r112 = r111.f53300g;
            float r113 = r111.f53319z;
            PointF r114 = r111.K;
            r112.postScale(r113, r113, r114.x, r114.y);
            PhotoView r115 = this.f53341n;
            r115.f53300g.postTranslate(r115.A, r115.B);
            this.f53341n.o();
        }

        public final void b() {
            boolean r100 = false;
            boolean r101 = true;
            if (this.f53331d.computeScrollOffset() == false) goto L5;
            this.f53341n.f53319z = this.f53331d.getCurrX() / 10000.0f;
            boolean r102 = false;
        L7:
            if (this.f53329b.computeScrollOffset() == false) goto L10;
            int r103 = this.f53329b.getCurrX() - this.f53337j;
            int r104 = this.f53329b.getCurrY() - this.f53338k;
            PhotoView r105 = this.f53341n;
            r105.A += r103;
            r105.B += r104;
            this.f53337j = this.f53329b.getCurrX();
            this.f53338k = this.f53329b.getCurrY();
            r102 = false;
        L10:
            if (this.f53330c.computeScrollOffset() == false) goto L13;
            int r106 = this.f53330c.getCurrX() - this.f53335h;
            int r107 = this.f53330c.getCurrY() - this.f53336i;
            this.f53335h = this.f53330c.getCurrX();
            this.f53336i = this.f53330c.getCurrY();
            PhotoView r108 = this.f53341n;
            r108.A += r106;
            r108.B += r107;
            r102 = false;
        L13:
            if (this.f53333f.computeScrollOffset() == false) goto L16;
            this.f53341n.f53318y = this.f53333f.getCurrX();
            r102 = false;
        L16:
            if (this.f53332e.computeScrollOffset() == false) goto L18;
        L19:
            float r109 = this.f53332e.getCurrX() / 10000.0f;
            float r110 = this.f53332e.getCurrY() / 10000.0f;
            PhotoView r111 = this.f53341n;
            Matrix r112 = r111.f53302i;
            RectF r113 = r111.G;
            r112.setScale(r109, r110, (r113.left + r113.right) / 2.0f, this.f53334g.a());
            PhotoView r114 = this.f53341n;
            r114.f53302i.mapRect(this.f53339l, r114.G);
            if (r109 != 1.0f) goto L23;
            RectF r115 = this.f53339l;
            RectF r116 = this.f53341n.E;
            r115.left = r116.left;
            r115.right = r116.right;
        L23:
            if (r110 != 1.0f) goto L25;
            RectF r117 = this.f53339l;
            RectF r118 = this.f53341n.E;
            r117.top = r118.top;
            r117.bottom = r118.bottom;
        L25:
            this.f53341n.N = this.f53339l;
        L26:
            if (r102 == true) goto L30;
            a();
            if (this.f53328a == false) goto L54;
            this.f53341n.post(this);
            return;
        L54:
            return;
        L30:
            this.f53328a = false;
            PhotoView r119 = this.f53341n;
            if (r119.f53316w == false) goto L39;
            RectF r120 = r119.G;
            float r121 = r120.left;
            if (r121 <= 0.0f) goto L36;
            r119.A = (int) (r119.A - r121);
        L38:
            r100 = true;
            goto L39
        L36:
            if (r120.right >= r119.E.width()) goto L38;
            PhotoView r122 = this.f53341n;
            r122.A -= (int) (r122.E.width() - this.f53341n.G.right);
        L39:
            PhotoView r123 = this.f53341n;
            if (r123.f53317x == false) goto L47;
            RectF r124 = r123.G;
            float r125 = r124.top;
            if (r125 <= 0.0f) goto L45;
            r123.B = (int) (r123.B - r125);
        L48:
            if (r101 == false) goto L50;
            a();
        L50:
            this.f53341n.invalidate();
            Runnable r126 = this.f53341n.Q;
            if (r126 == null) goto L56;
            r126.run();
            this.f53341n.Q = null;
            return;
        L56:
            return;
        L45:
            if (r124.bottom >= r123.E.height()) goto L48;
            PhotoView r127 = this.f53341n;
            r127.B -= (int) (r127.E.height() - this.f53341n.G.bottom);
            goto L48
        L47:
            r101 = r100;
            goto L48
        L18:
            if (this.f53341n.N == null) goto L26;
        L5:
            r102 = true;
            goto L7
        }

        public final void c() {
            this.f53341n.removeCallbacks(this);
            this.f53329b.abortAnimation();
            this.f53331d.abortAnimation();
            this.f53330c.abortAnimation();
            this.f53333f.abortAnimation();
            this.f53328a = false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(PhotoView r100) {
            this.f53341n = r100;
            this.f53339l = new RectF();
            g r101 = new g();
            this.f53340m = r101;
            Context r102 = r100.getContext();
            this.f53329b = new OverScroller(r102, r101);
            this.f53331d = new Scroller(r102, r101);
            this.f53330c = new OverScroller(r102, r101);
            this.f53332e = new Scroller(r102, r101);
            this.f53333f = new Scroller(r102, r101);
        }

        public final void d(float r100, float r101) {
            this.f53331d.startScroll((int) (r100 * 10000.0f), 0, (int) ((r101 - r100) * 10000.0f), 0, this.f53341n.f53294a);
        }
    }

    public int getDefaultAnimaDuring() {
        return 340;
    }

    public zs.a getInfo() {
        RectF r100 = new RectF();
        int[] r101 = new int[2];
        r101[0] = r101[0] + getLeft();
        r101[1] = r101[1] + getTop();
        Object r102 = getParent();
    L4:
        if ((r102 instanceof View) == false) goto L9;
        View r103 = (View) r102;
        if (r103.getId() == 16908290) goto L10;
        r101[0] = r101[0] - r103.getScrollX();
        r101[1] = r101[1] - r103.getScrollY();
        r101[0] = r101[0] + r103.getLeft();
        r101[1] = r101[1] + r103.getTop();
        r102 = r103.getParent();
    L10:
        float r104 = r101[0];
        RectF r105 = this.G;
        float r106 = r105.left + r104;
        float r107 = r101[1];
        r100.set(r106, r105.top + r107, r104 + r105.right, r107 + r105.bottom);
        return new zs.a(r100, this.G, this.E, this.F, this.f53293J, this.f53318y, this.f53306m);
    L9:
        r101[0] = (int) (r101[0] + 0.5f);
        r101[1] = (int) (r101[1] + 0.5f);
        goto L10
    }

    public final void o() {
        this.f53301h.set(this.f53299f);
        this.f53301h.postConcat(this.f53300g);
        setImageMatrix(this.f53301h);
        this.f53300g.mapRect(this.G, this.F);
        boolean r100 = true;
        if (this.G.width() <= this.E.width()) goto L5;
        boolean r101 = true;
    L6:
        this.f53316w = r101;
        if (this.G.height() > this.E.height()) goto L10;
        r100 = false;
    L10:
        this.f53317x = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void r() {
        if (this.f53308o == true) goto L6;
        return;
    L6:
        if (this.f53309p == true) goto L8;
        return;
    L8:
        this.f53299f.reset();
        this.f53300g.reset();
        this.f53314u = false;
        Drawable r100 = getDrawable();
        int r101 = getWidth();
        int r102 = getHeight();
        int r103 = q(r100);
        int r104 = p(r100);
        float r105 = r103;
        float r106 = r104;
        this.F.set(0.0f, 0.0f, r105, r106);
        int r107 = (r101 - r103) / 2;
        int r110 = (r102 - r104) / 2;
        if (r103 <= r101) goto L11;
        float r108 = r101 / r105;
    L12:
        if (r104 <= r102) goto L14;
        float r109 = r102 / r106;
    L16:
        if (r108 < r109) goto L19;
        r108 = r109;
    L19:
        this.f53299f.reset();
        this.f53299f.postTranslate(r107, r110);
        Matrix r111 = this.f53299f;
        PointF r112 = this.f53293J;
        r111.postScale(r108, r108, r112.x, r112.y);
        this.f53299f.mapRect(this.F);
        this.C = this.F.width() / 2.0f;
        this.D = this.F.height() / 2.0f;
        this.K.set(this.f53293J);
        this.L.set(this.K);
        o();
        switch(d.f53323a[this.f53306m.ordinal()]) {
            case 1: goto L45;
            case 2: goto L36;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            default: goto L59;
        };
    L22:
        float r113 = this.E.width() / this.G.width();
        float r114 = this.E.height() / this.G.height();
        Matrix r115 = this.f53300g;
        PointF r116 = this.f53293J;
        r115.postScale(r113, r114, r116.x, r116.y);
        o();
        u();
        goto L59
    L23:
        s();
        float r117 = this.E.bottom - this.G.bottom;
        this.B = (int) (this.B + r117);
        this.f53300g.postTranslate(0.0f, r117);
        o();
        u();
        goto L59
    L24:
        s();
        float r118 = -this.G.top;
        this.B = (int) (this.B + r118);
        this.f53300g.postTranslate(0.0f, r118);
        o();
        u();
        goto L59
    L25:
        s();
    L59:
        this.f53312s = true;
        if (this.O != null) goto L62;
    L89:
        this.O = null;
        if (r104 <= (r103 * 3)) goto L93;
        this.f53300g.postTranslate(0.0f, -this.G.top);
        this.B = (int) (this.B - this.G.top);
        o();
        return;
    L93:
        return;
    L62:
        if ((System.currentTimeMillis() - this.P) >= this.f53298e) goto L89;
        zs.a r119 = this.O;
        if (this.f53312s == false) goto L88;
        this.f53300g.reset();
        o();
        this.f53319z = 1.0f;
        this.A = 0;
        this.B = 0;
        zs.a r120 = getInfo();
        float r121 = r119.f573453b.width() / r120.f573453b.width();
        float r122 = r119.f573453b.height() / r120.f573453b.height();
        if (r121 < r122) goto L69;
        r121 = r122;
    L69:
        RectF r123 = r119.f573452a;
        float r124 = r123.left + (r123.width() / 2.0f);
        RectF r125 = r119.f573452a;
        float r126 = r125.top + (r125.height() / 2.0f);
        this.f53300g.reset();
        Matrix r127 = this.f53300g;
        RectF r128 = this.F;
        r127.postTranslate(-r128.left, -r128.top);
        this.f53300g.postTranslate(r124 - (this.F.width() / 2.0f), r126 - (this.F.height() / 2.0f));
        this.f53300g.postScale(r121, r121, r124, r126);
        this.f53300g.postRotate(r119.f573455d, r124, r126);
        o();
        this.K.set(r124, r126);
        this.L.set(r124, r126);
        j r129 = this.M;
        PointF r130 = this.f53293J;
        int r131 = (int) (r130.x - r124);
        int r132 = (int) (r130.y - r126);
        r129.f53337j = 0;
        r129.f53338k = 0;
        r129.f53329b.startScroll(0, 0, r131, r132, r129.f53341n.f53294a);
        this.M.d(r121, 1.0f);
        j r133 = this.M;
        int r134 = (int) r119.f573455d;
        r133.f53333f.startScroll(r134, 0, 0 - r134, 0, r133.f53341n.f53294a);
        if (r119.f573454c.width() >= r119.f573453b.width()) goto L72;
    L73:
        float r135 = r119.f573454c.width() / r119.f573453b.width();
        float r136 = r119.f573454c.height() / r119.f573453b.height();
        if (r135 <= 1.0f) goto L77;
        r135 = 1.0f;
    L77:
        if (r136 <= 1.0f) goto L79;
        r136 = 1.0f;
    L79:
        ImageView.ScaleType r137 = r119.f573456e;
        if (r137 != ImageView.ScaleType.FIT_START) goto L83;
        e r138 = new i(this);
    L86:
        j r139 = this.M;
        r139.f53332e.startScroll((int) (r135 * 10000.0f), (int) (r136 * 10000.0f), (int) ((1.0f - r135) * 10000.0f), (int) ((1.0f - r136) * 10000.0f), this.f53294a / 3);
        r139.f53334g = r138;
        Matrix r140 = this.f53302i;
        RectF r141 = this.G;
        r140.setScale(r135, r136, (r141.left + r141.right) / 2.0f, r138.a());
        this.f53302i.mapRect(this.M.f53339l, this.G);
        this.N = this.M.f53339l;
    L87:
        j r142 = this.M;
        r142.f53328a = true;
        r142.f53341n.post(r142);
        goto L89
    L83:
        if (r137 != ImageView.ScaleType.FIT_END) goto L85;
        r138 = new f(this);
        goto L86
    L85:
        r138 = new h(this);
        goto L86
    L72:
        if (r119.f573454c.height() >= r119.f573453b.height()) goto L87;
    L88:
        this.O = r119;
        this.P = System.currentTimeMillis();
        goto L89
    L27:
        if (this.G.width() <= this.E.width()) goto L29;
    L30:
        float r143 = this.E.width() / this.G.width();
        float r144 = this.E.height() / this.G.height();
        if (r143 < r144) goto L34;
        r143 = r144;
    L34:
        this.f53319z = r143;
        Matrix r145 = this.f53300g;
        PointF r146 = this.f53293J;
        r145.postScale(r143, r143, r146.x, r146.y);
        o();
        u();
        goto L59
    L29:
        if (this.G.height() <= this.E.height()) goto L59;
    L36:
        if (this.G.width() >= this.E.width()) goto L38;
    L39:
        float r147 = this.E.width() / this.G.width();
        float r148 = this.E.height() / this.G.height();
        if (r147 > r148) goto L43;
        r147 = r148;
    L43:
        this.f53319z = r147;
        Matrix r149 = this.f53300g;
        PointF r150 = this.f53293J;
        r149.postScale(r147, r147, r150.x, r150.y);
        o();
        u();
        goto L59
    L38:
        if (this.G.height() >= this.E.height()) goto L59;
    L45:
        if (this.f53308o == false) goto L59;
        if (this.f53309p == false) goto L59;
        Drawable r151 = getDrawable();
        int r152 = q(r151);
        int r153 = p(r151);
        float r154 = r152;
        if (r154 <= this.E.width()) goto L53;
    L54:
        float r155 = r154 / this.G.width();
        float r156 = r153 / this.G.height();
        if (r155 > r156) goto L58;
        r155 = r156;
    L58:
        this.f53319z = r155;
        Matrix r157 = this.f53300g;
        PointF r158 = this.f53293J;
        r157.postScale(r155, r155, r158.x, r158.y);
        o();
        u();
        goto L59
    L53:
        if (r153 <= this.E.height()) goto L59;
    L14:
        r109 = 1.0f;
        goto L16
    L11:
        r108 = 1.0f;
        goto L12
    }

    public final void t() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
        if (this.f53306m != null) goto L5;
        this.f53306m = ImageView.ScaleType.CENTER_INSIDE;
    L5:
        this.f53303j = new GestureDetector(getContext(), this.U);
        this.f53304k = new ScaleGestureDetector(getContext(), this.S);
        Resources r100 = getResources();
        float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        this.f53296c = (int) (30.0f * r101);
        this.f53297d = (int) (r101 * 140.0f);
        this.f53294a = 340;
        this.f53295b = 2.5f;
    }

    public final void s() {
        if ((!p0.a()) == false) goto L8;
        if (this.G.width() >= this.E.width()) goto L11;
        float r100 = this.E.width() / this.G.width();
        this.f53319z = r100;
        Matrix r101 = this.f53300g;
        PointF r102 = this.f53293J;
        r101.postScale(r100, r100, r102.x, r102.y);
        o();
        u();
        return;
    L11:
        return;
    L8:
        if (this.G.height() >= this.E.height()) goto L13;
        float r103 = this.E.height() / this.G.height();
        this.f53319z = r103;
        Matrix r104 = this.f53300g;
        PointF r105 = this.f53293J;
        r104.postScale(r103, r103, r105.x, r105.y);
        o();
        u();
        return;
    }

    public final void u() {
        Drawable r100 = getDrawable();
        this.F.set(0.0f, 0.0f, q(r100), p(r100));
        this.f53299f.set(this.f53301h);
        this.f53299f.mapRect(this.F);
        this.C = this.F.width() / 2.0f;
        this.D = this.F.height() / 2.0f;
        this.f53319z = 1.0f;
        this.A = 0;
        this.B = 0;
        this.f53300g.reset();
    }

    public int getAnimaDuring() {
        return this.f53294a;
    }

    public float getMaxScale() {
        return this.f53295b;
    }

    public PhotoView(Context r100) {
        super(r100);
        this.f53296c = 0;
        this.f53297d = 0;
        this.f53298e = 500;
        this.f53299f = new Matrix();
        this.f53300g = new Matrix();
        this.f53301h = new Matrix();
        this.f53302i = new Matrix();
        this.f53311r = false;
        this.f53319z = 1.0f;
        this.E = new RectF();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new RectF();
        this.I = new RectF();
        this.f53293J = new PointF();
        this.K = new PointF();
        this.L = new PointF();
        this.M = new j(this);
        this.S = new a(this);
        this.T = new b(this);
        this.U = new c(this);
        t();
    }

    public static void j(PhotoView r100) {
        if (r100.f53310q == true) goto L28;
        RectF r101 = r100.E;
        RectF r102 = r100.G;
        RectF r103 = r100.I;
        float r104 = r101.left;
        float r105 = r102.left;
        if (r104 > r105) goto L8;
        r104 = r105;
    L8:
        float r106 = r101.right;
        float r107 = r102.right;
        if (r106 < r107) goto L13;
        r106 = r107;
    L13:
        if (r104 <= r106) goto L15;
        r103.set(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    L15:
        float r108 = r101.top;
        float r109 = r102.top;
        if (r108 > r109) goto L19;
        r108 = r109;
    L19:
        float r110 = r101.bottom;
        float r111 = r102.bottom;
        if (r110 < r111) goto L24;
        r110 = r111;
    L24:
        if (r108 <= r110) goto L26;
        r103.set(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    L26:
        r103.set(r104, r108, r106, r110);
        return;
    }

    public static int p(Drawable r100) {
        int r101 = r100.getIntrinsicHeight();
        if (r101 > 0) goto L5;
        r101 = r100.getMinimumHeight();
    L5:
        if (r101 <= 0) goto L7;
        return r101;
    L7:
        return r100.getBounds().height();
    }

    public static int q(Drawable r100) {
        int r101 = r100.getIntrinsicWidth();
        if (r101 > 0) goto L5;
        r101 = r100.getMinimumWidth();
    L5:
        if (r101 <= 0) goto L7;
        return r101;
    L7:
        return r100.getBounds().width();
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f53307n == false) goto L7;
        return true;
    L7:
        return l(r100);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f53307n == false) goto L7;
        return true;
    L7:
        return m(r100);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        if (this.f53311r == false) goto L39;
        int r100 = r110.getActionMasked();
        if (r110.getPointerCount() < 2) goto L7;
        this.f53307n = true;
    L7:
        GestureDetector r101 = this.f53303j;
        if (r101 == null) goto L10;
        r101.onTouchEvent(r110);
    L10:
        ScaleGestureDetector r102 = this.f53304k;
        if (r102 == null) goto L13;
        r102.onTouchEvent(r110);
    L13:
        if (r100 != 1) goto L15;
    L16:
        j r111 = this.M;
        if (r111.f53328a == false) goto L20;
    L37:
        return true;
    L20:
        if (this.f53315v == false) goto L22;
    L23:
        float r103 = this.f53318y;
        float r104 = ((int) (r103 / 90.0f)) * 90;
        float r105 = r103 % 90.0f;
        if (r105 <= 45.0f) goto L27;
        r104 = r104 + 90.0f;
    L29:
        int r106 = (int) r103;
        r111.f53333f.startScroll(r106, 0, ((int) r104) - r106, 0, r111.f53341n.f53294a);
        this.f53318y = r104;
    L30:
        float r112 = this.f53319z;
        if (r112 >= 1.0f) goto L33;
        this.M.d(r112, 1.0f);
        r112 = 1.0f;
    L36:
        RectF r107 = this.G;
        float r108 = r107.left + (r107.width() / 2.0f);
        RectF r109 = this.G;
        float r113 = r109.top + (r109.height() / 2.0f);
        this.K.set(r108, r113);
        this.L.set(r108, r113);
        this.A = 0;
        this.B = 0;
        this.f53302i.reset();
        Matrix r114 = this.f53302i;
        RectF r115 = this.F;
        r114.postTranslate(-r115.left, -r115.top);
        this.f53302i.postTranslate(r108 - this.C, r113 - this.D);
        this.f53302i.postScale(r112, r112, r108, r113);
        this.f53302i.postRotate(this.f53318y, r108, r113);
        this.f53302i.mapRect(this.H, this.F);
        n(this.H);
        j r116 = this.M;
        r116.f53328a = true;
        r116.f53341n.post(r116);
        goto L37
    L33:
        float r117 = this.f53295b;
        if (r112 <= r117) goto L36;
        this.M.d(r112, r117);
        r112 = r117;
        goto L36
    L27:
        if (r105 >= (-45.0f)) goto L29;
        r104 = r104 - 90.0f;
        goto L29
    L22:
        if ((this.f53318y % 90.0f) == 0.0f) goto L30;
    L15:
        if (r100 != 3) goto L37;
    L39:
        return super.dispatchTouchEvent(r110);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        RectF r101 = this.N;
        if (r101 == null) goto L5;
        r100.clipRect(r101);
        this.N = null;
    L5:
        super.draw(r100);
    }

    public final boolean l(float r100) {
        if (this.G.width() > this.E.width()) goto L6;
        return false;
    L6:
        if (r100 >= 0.0f) goto L11;
        if ((Math.round(this.G.left) - r100) < this.E.left) goto L11;
        return false;
    L11:
        if (r100 > 0.0f) goto L13;
        return true;
    L13:
        if ((Math.round(this.G.right) - r100) > this.E.right) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean m(float r100) {
        if (this.G.height() > this.E.height()) goto L6;
        return false;
    L6:
        if (r100 >= 0.0f) goto L11;
        if ((Math.round(this.G.top) - r100) < this.E.top) goto L11;
        return false;
    L11:
        if (r100 > 0.0f) goto L13;
        return true;
    L13:
        if ((Math.round(this.G.bottom) - r100) > this.E.bottom) goto L17;
        return false;
    L17:
        return true;
    }

    public final void n(RectF r110) {
        boolean r100 = true;
        if (r110.width() <= this.E.width()) goto L5;
        float r101 = r110.left;
        RectF r102 = this.E;
        float r103 = r102.left;
        if (r101 <= r103) goto L13;
        float r104 = r101 - r103;
    L16:
        int r105 = (int) r104;
    L19:
        if (r110.height() <= this.E.height()) goto L21;
        float r106 = r110.top;
        RectF r107 = this.E;
        float r108 = r107.top;
        if (r106 <= r108) goto L29;
        int r111 = (int) (r106 - r108);
    L33:
        if (r105 != 0) goto L36;
        if (r111 != 0) goto L36;
        return;
    L36:
        if (this.M.f53330c.isFinished() == true) goto L38;
        this.M.f53330c.abortAnimation();
    L38:
        j r109 = this.M;
        r109.f53337j = 0;
        r109.f53338k = 0;
        r109.f53329b.startScroll(0, 0, -r105, -r111, r109.f53341n.f53294a);
        return;
    L29:
        float r112 = r110.bottom;
        float r113 = r107.bottom;
        if (r112 >= r113) goto L32;
        r111 = (int) (r112 - r113);
    L32:
        r111 = 0;
        goto L33
    L21:
        if (Math.abs(Math.round(r110.top) - ((this.E.height() - r110.height()) / 2.0f)) < 1.0f) goto L24;
        r100 = false;
    L24:
        if (r100 == true) goto L32;
        r111 = -((int) (((this.E.height() - r110.height()) / 2.0f) - r110.top));
        goto L33
    L13:
        float r114 = r110.right;
        float r115 = r102.right;
        if (r114 >= r115) goto L17;
        r104 = r114 - r115;
    L17:
        r105 = 0;
        goto L19
    L5:
        if (Math.abs(Math.round(r110.left) - ((this.E.width() - r110.width()) / 2.0f)) >= 1.0f) goto L7;
        boolean r116 = true;
    L8:
        if (r116 == true) goto L17;
        r105 = -((int) (((this.E.width() - r110.width()) / 2.0f) - r110.left));
        goto L19
    L7:
        r116 = false;
        goto L8
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r100) {
        super.setAdjustViewBounds(r100);
        this.f53313t = r100;
    }

    public void setAnimaDuring(int r100) {
        this.f53294a = r100;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        boolean r101 = false;
        if (r100 != null) goto L7;
        this.f53308o = false;
        return;
    L7:
        if (r100.getIntrinsicHeight() <= 0) goto L11;
        if (r100.getIntrinsicWidth() <= 0) goto L11;
    L19:
        r101 = true;
    L20:
        if (r101 == true) goto L23;
        return;
    L23:
        if (this.f53308o == true) goto L25;
        this.f53308o = true;
    L25:
        r();
        return;
    L11:
        if (r100.getMinimumWidth() <= 0) goto L15;
        if (r100.getMinimumHeight() > 0) goto L19;
    L15:
        if (r100.getBounds().width() <= 0) goto L20;
        if (r100.getBounds().height() > 0) goto L19;
        goto L19
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r100) {
        Drawable r101 = getResources().getDrawable(r100);     // Catch: Exception -> L4
    L5:
        setImageDrawable(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setInterpolator(Interpolator r100) {
        this.M.f53340m.f53325a = r100;
    }

    public void setMaxAnimFromWaiteTime(int r100) {
        this.f53298e = r100;
    }

    public void setMaxScale(float r100) {
        this.f53295b = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
        this.f53305l = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.R = r100;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r100) {
        ImageView.ScaleType r101 = this.f53306m;
        this.f53306m = r100;
        if (r101 == r100) goto L6;
        r();
        return;
    }

    public PhotoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f53296c = 0;
        this.f53297d = 0;
        this.f53298e = 500;
        this.f53299f = new Matrix();
        this.f53300g = new Matrix();
        this.f53301h = new Matrix();
        this.f53302i = new Matrix();
        this.f53311r = false;
        this.f53319z = 1.0f;
        this.E = new RectF();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new RectF();
        this.I = new RectF();
        this.f53293J = new PointF();
        this.K = new PointF();
        this.L = new PointF();
        this.M = new j(this);
        this.S = new a(this);
        this.T = new b(this);
        this.U = new c(this);
        t();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (this.f53308o == true) goto L6;
        super.onMeasure(r110, r111);
        return;
    L6:
        Drawable r100 = getDrawable();
        int r101 = q(r100);
        int r102 = p(r100);
        int r103 = View.MeasureSpec.getSize(r110);
        int r104 = View.MeasureSpec.getSize(r111);
        int r112 = View.MeasureSpec.getMode(r110);
        int r113 = View.MeasureSpec.getMode(r111);
        ViewGroup.LayoutParams r105 = getLayoutParams();
        if (r105 != null) goto L9;
        r105 = new ViewGroup.LayoutParams(-2, -2);
    L9:
        int r106 = r105.width;
        if (r106 != (-1)) goto L13;
        if (r112 == 0) goto L18;
    L19:
        int r114 = r105.height;
        if (r114 != (-1)) goto L23;
        if (r113 != 0) goto L30;
    L28:
        r104 = r102;
    L30:
        if (this.f53313t == false) goto L43;
        float r115 = r101;
        float r107 = r102;
        float r108 = r103;
        float r109 = r104;
        if ((r115 / r107) == (r108 / r109)) goto L43;
        float r116 = r109 / r107;
        float r117 = r108 / r115;
        if (r116 < r117) goto L37;
        r116 = r117;
    L37:
        if (r106 == (-1)) goto L40;
        r103 = (int) (r115 * r116);
    L40:
        if (r114 == (-1)) goto L43;
        r104 = (int) (r107 * r116);
    L43:
        setMeasuredDimension(r103, r104);
        return;
    L23:
        if (r113 == 1073741824) goto L30;
        if (r113 != Integer.MIN_VALUE) goto L28;
        if (r102 <= r104) goto L28;
    L18:
        r103 = r101;
        goto L19
    L13:
        if (r112 == 1073741824) goto L19;
        if (r112 != Integer.MIN_VALUE) goto L18;
        if (r101 <= r103) goto L18;
        goto L18
    }

    public PhotoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f53296c = 0;
        this.f53297d = 0;
        this.f53298e = 500;
        this.f53299f = new Matrix();
        this.f53300g = new Matrix();
        this.f53301h = new Matrix();
        this.f53302i = new Matrix();
        this.f53311r = false;
        this.f53319z = 1.0f;
        this.E = new RectF();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new RectF();
        this.I = new RectF();
        this.f53293J = new PointF();
        this.K = new PointF();
        this.L = new PointF();
        this.M = new j(this);
        this.S = new a(this);
        this.T = new b(this);
        this.U = new c(this);
        t();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.E.set(0.0f, 0.0f, r100, r101);
        this.f53293J.set(r100 / 2, r101 / 2);
        if (this.f53309p == true) goto L6;
        this.f53309p = true;
        r();
        return;
    }
}
