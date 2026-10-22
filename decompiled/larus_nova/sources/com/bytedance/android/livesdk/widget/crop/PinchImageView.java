package com.bytedance.android.livesdk.widget.crop;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes11.dex */
public class PinchImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f161616p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f161617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f161618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f161619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f161620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f161621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f161622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f161623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f161624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f161625i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PointF f161626j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PointF f161627k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f161628l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f161629m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f161630n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final GestureDetector f161631o;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinchImageView f161632a;

        public a(PinchImageView r100) {
            this.f161632a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r210) {
            PinchImageView r100 = this.f161632a;
            if (r100.f161624h != 1) goto L68;
            h r101 = r100.f161629m;
            if (r101 != null) goto L7;
        L8:
            PinchImageView r102 = this.f161632a;
            float r103 = r210.getX();
            float r104 = r210.getY();
            if (r102.o() == false) goto L70;
            Matrix r105 = c.c();
            r102.n(r105);
            float r106 = c.a(r105)[0];
            float r107 = c.a(r102.f161623g)[0] * r106;
            boolean r108 = r102.f161617a;
            if (r108 == false) goto L14;
            float r110 = r102.f161618b.left;
        L15:
            if (r108 == false) goto L17;
            int r109 = r102.f161618b.right;
        L18:
            float r111 = r109;
            boolean r112 = r102.f161617a;
            if (r112 == false) goto L21;
            float r113 = r102.f161618b.top;
        L22:
            if (r112 == false) goto L24;
            int r114 = r102.f161618b.bottom;
        L25:
            float r115 = r114;
            if (r102.f161617a == false) goto L28;
            int r116 = r102.f161618b.width();
        L29:
            float r117 = r116;
            if (r102.f161617a == false) goto L32;
            int r118 = r102.f161618b.height();
        L33:
            float r119 = r118;
            float r120 = r102.getMaxScale();
            if (r107 >= r102.getMaxScale()) goto L36;
            float r121 = r102.getMaxScale();
        L38:
            if (r121 > r120) goto L42;
            r120 = r121;
        L42:
            if (r120 < r106) goto L45;
            r106 = r120;
        L45:
            Matrix r122 = c.d(r102.f161623g);
            float r123 = r106 / r107;
            r122.postScale(r123, r123, r103, r104);
            float r124 = r117 / 2.0f;
            float r125 = r119 / 2.0f;
            r122.postTranslate(r124 - r103, r125 - r104);
            Matrix r126 = c.d(r105);
            r126.postConcat(r122);
            RectF r127 = c.f(r102.getDrawable().getIntrinsicWidth(), r102.getDrawable().getIntrinsicHeight());
            r126.mapRect(r127);
            float r128 = r127.right;
            float r129 = r127.left;
            if ((r128 - r129) >= r117) goto L49;
            float r130 = r124 - ((r128 + r129) / 2.0f);
        L55:
            float r131 = r127.bottom;
            float r132 = r127.top;
            if ((r131 - r132) >= r119) goto L59;
            float r133 = r125 - ((r131 + r132) / 2.0f);
        L65:
            r122.postTranslate(r130, r133);
            r102.j();
            h r134 = new h(r102, r102.f161623g, r122);
            r102.f161629m = r134;
            r134.start();
            c.e(r127);
            c.b(r126);
            c.b(r122);
            c.b(r105);
            return true;
        L59:
            if (r132 <= r113) goto L62;
            r133 = r113 - r132;
            goto L65
        L62:
            if (r131 >= r115) goto L64;
            r133 = r115 - r131;
            goto L65
        L64:
            r133 = 0.0f;
            goto L65
        L49:
            if (r129 <= r110) goto L52;
            r130 = r110 - r129;
            goto L55
        L52:
            if (r128 >= r111) goto L54;
            r130 = r111 - r128;
            goto L55
        L54:
            r130 = 0.0f;
            goto L55
        L36:
            r121 = r106;
            goto L38
        L32:
            r118 = r102.getHeight();
            goto L33
        L28:
            r116 = r102.getWidth();
            goto L29
        L24:
            r114 = r102.getHeight();
            goto L25
        L21:
            r113 = 0.0f;
            goto L22
        L17:
            r109 = r102.getWidth();
            goto L18
        L14:
            r110 = 0.0f;
            goto L15
        L70:
            return true;
        L7:
            if (r101.isRunning() == false) goto L8;
            return true;
        L68:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            PinchImageView r101 = this.f161632a;
            View.OnLongClickListener r102 = r101.f161622f;
            if (r102 == null) goto L6;
            r102.onLongClick(r101);
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            PinchImageView r101 = this.f161632a;
            View.OnClickListener r102 = r101.f161621e;
            if (r102 == null) goto L7;
            r102.onClick(r101);
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            PinchImageView r104 = this.f161632a;
            if (r104.f161624h != 0) goto L14;
            h r105 = r104.f161629m;
            if (r105 != null) goto L7;
        L8:
            PinchImageView r106 = this.f161632a;
            if (r106.o() == false) goto L16;
            r106.j();
            b r107 = new b(r106, r102 / 60.0f, r103 / 60.0f);
            r106.f161630n = r107;
            r107.start();
            return true;
        L16:
            return true;
        L7:
            if (r105.isRunning() == false) goto L8;
            return true;
        L14:
            return true;
        }
    }

    public class b extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f161633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PinchImageView f161634b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            PinchImageView r101 = this.f161634b;
            float[] r102 = this.f161633a;
            float r103 = r102[0];
            float r104 = r102[1];
            int r105 = PinchImageView.f161616p;
            boolean r106 = r101.s(r103, r104);
            float[] r107 = this.f161633a;
            float r108 = r107[0] * 0.9f;
            r107[0] = r108;
            float r109 = r107[1] * 0.9f;
            r107[1] = r109;
            if (r106 == false) goto L6;
            d r110 = c.f161635a;
            float r111 = 0.0f - r108;
            float r112 = 0.0f - r109;
            if (((float) Math.sqrt((r111 * r111) + (r112 * r112))) < 1.0f) goto L6;
            return;
        L6:
            r100.cancel();
        }

        public b(PinchImageView r100, float r101, float r102) {
            this.f161634b = r100;
            setFloatValues(new float[]{0.0f, 1.0f});
            setDuration(1000000);
            addUpdateListener(this);
            this.f161633a = new float[]{r101, r102};
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f161635a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f161636b = null;

        static {
            f161635a = new d();
            f161636b = new g();
        }

        public static Matrix c() {
            return f161635a.c();
        }

        public static float[] a(Matrix r100) {
            if (r100 == null) goto L7;
            float[] r101 = new float[9];
            r100.getValues(r101);
            return new float[]{r101[0], r101[4]};
        L7:
            return new float[2];
        }

        public static void b(Matrix r100) {
            d r101 = f161635a;
            if (r100 != null) goto L5;
            r101.getClass();
            return;
        L5:
            if (((LinkedList) r101.f161638b).size() >= r101.f161637a) goto L9;
            ((LinkedList) r101.f161638b).offer(r100);
            return;
        }

        public static Matrix d(Matrix r100) {
            Matrix r101 = f161635a.c();
            if (r100 == null) goto L5;
            r101.set(r100);
        L5:
            return r101;
        }

        public static void e(RectF r100) {
            g r101 = f161636b;
            if (((LinkedList) r101.f161638b).size() >= r101.f161637a) goto L6;
            ((LinkedList) r101.f161638b).offer(r100);
            return;
        }

        public static RectF f(float r100, float r101) {
            RectF r102 = f161636b.c();
            r102.set(0.0f, 0.0f, r100, r101);
            return r102;
        }
    }

    public static class d extends e<Matrix> {
        @Override // com.bytedance.android.livesdk.widget.crop.PinchImageView.e
        public final Matrix a() {
            return new Matrix();
        }

        public d() {
        }

        @Override // com.bytedance.android.livesdk.widget.crop.PinchImageView.e
        public final Matrix b(Matrix r100) {
            Matrix r101 = r100;
            if (r101 == null) goto L7;
            r101.reset();
            return r101;
        L7:
            return new Matrix();
        }
    }

    public static abstract class e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f161637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Queue<T> f161638b;

        public abstract T a();

        public abstract T b(T r100);

        /* JADX WARN: Multi-variable type inference failed */
        public final T c() {
            if (((LinkedList) this.f161638b).size() == 0) goto L5;
            return (T) b(((LinkedList) this.f161638b).poll());
        L9:
            return (T) a();
        L5:
            return (T) a();
        }

        public e() {
            this.f161637a = 16;
            this.f161638b = new LinkedList();
        }
    }

    public interface f {
        void a();
    }

    public static class g extends e<RectF> {
        @Override // com.bytedance.android.livesdk.widget.crop.PinchImageView.e
        public final RectF a() {
            return new RectF();
        }

        public g() {
        }

        @Override // com.bytedance.android.livesdk.widget.crop.PinchImageView.e
        public final RectF b(RectF r100) {
            RectF r101 = r100;
            if (r101 == null) goto L7;
            r101.setEmpty();
            return r101;
        L7:
            return new RectF();
        }
    }

    public class h extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f161639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f161640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f161641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PinchImageView f161642d;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = ((Float) r100.getAnimatedValue()).floatValue();
            int r102 = 0;
        L4:
            if (r102 >= 9) goto L6;
            float[] r103 = this.f161641c;
            float r104 = this.f161639a[r102];
            r103[r102] = r104 + ((this.f161640b[r102] - r104) * r101);
            r102 = r102 + 1;
            goto L4
        L6:
            this.f161642d.f161623g.setValues(this.f161641c);
            this.f161642d.l();
            this.f161642d.invalidate();
        }

        public h(PinchImageView r100, Matrix r101, Matrix r102) {
            this.f161642d = r100;
            float[] r103 = new float[9];
            this.f161639a = r103;
            float[] r104 = new float[9];
            this.f161640b = r104;
            this.f161641c = new float[9];
            setFloatValues(new float[]{0.0f, 1.0f});
            setDuration(200);
            addUpdateListener(this);
            r101.getValues(r103);
            r102.getValues(r104);
        }
    }

    public RectF getMask() {
        return null;
    }

    public final void l() {
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r100) {
    }

    public final void j() {
        h r100 = this.f161629m;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f161629m = null;
    L5:
        b r101 = this.f161630n;
        if (r101 == null) goto L9;
        r101.cancel();
        this.f161630n = null;
        return;
    }

    public final void p() {
        if (this.f161619c == false) goto L5;
        r();
    L6:
        this.f161624h = 0;
        this.f161626j.set(0.0f, 0.0f);
        this.f161627k.set(0.0f, 0.0f);
        this.f161628l = 0.0f;
        j();
        invalidate();
        return;
    L5:
        this.f161623g.reset();
        l();
        goto L6
    }

    private float getMinScale() {
        if (o() == true) goto L5;
        return 1.0f;
    L5:
        if (this.f161618b == null) goto L18;
        float r100 = getDrawable().getIntrinsicWidth() / getDrawable().getIntrinsicHeight();
        float r101 = getWidth() / getHeight();
        if (r100 < (this.f161618b.width() / this.f161618b.height())) goto L15;
        if (r100 < r101) goto L15;
        return this.f161618b.height() / (getWidth() / r100);
    L15:
        return (this.f161618b.width() / getWidth()) * (getWidth() / (c.a(n(null))[0] * getDrawable().getIntrinsicWidth()));
    L18:
        return 1.0f;
    }

    public float getMaxScale() {
        if (o() == true) goto L5;
        float r100 = 4.0f;
    L11:
        return Math.max(r100, 4.0f);
    L5:
        if ((getDrawable().getIntrinsicWidth() / getDrawable().getIntrinsicHeight()) >= (getWidth() / getHeight())) goto L7;
        float r101 = getWidth();
        int r102 = getDrawable().getIntrinsicWidth();
    L8:
        r100 = r101 / r102;
        goto L11
    L7:
        r101 = getHeight();
        r102 = getDrawable().getIntrinsicHeight();
        goto L8
    }

    public final boolean o() {
        if (getDrawable() != null) goto L5;
    L13:
        return false;
    L5:
        if (getDrawable().getIntrinsicWidth() <= 0) goto L13;
        if (getDrawable().getIntrinsicHeight() <= 0) goto L13;
        if (getWidth() <= 0) goto L13;
        if (getHeight() <= 0) goto L13;
        return true;
    }

    public final void r() {
        if (o() == true) goto L5;
        return;
    L5:
        Matrix r100 = c.c();
        n(r100).postConcat(this.f161623g);
        boolean r101 = false;
        float r102 = c.a(this.f161623g)[0];
        boolean r103 = this.f161617a;
        if (r103 == false) goto L8;
        float r104 = this.f161618b.left;
    L9:
        if (r103 == false) goto L11;
        int r105 = this.f161618b.right;
    L12:
        float r106 = r105;
        boolean r107 = this.f161617a;
        if (r107 == false) goto L15;
        float r108 = this.f161618b.top;
    L16:
        if (r107 == false) goto L18;
        int r109 = this.f161618b.bottom;
    L19:
        float r110 = r109;
        float r111 = getMinScale() / r102;
        boolean r112 = true;
        if (r111 == 1.0f) goto L22;
        r101 = true;
    L22:
        Matrix r113 = c.d(r100);
        PointF r114 = this.f161626j;
        r113.postScale(r111, r111, r114.x, r114.y);
        RectF r115 = c.f(getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        r113.mapRect(r115);
        float r116 = ((r104 + r106) / 2.0f) - ((r115.left + r115.right) / 2.0f);
        float r117 = ((r108 + r110) / 2.0f) - ((r115.top + r115.bottom) / 2.0f);
        if (r116 == 0.0f) goto L25;
    L28:
        if (r112 == false) goto L30;
        Matrix r118 = c.d(this.f161623g);
        PointF r119 = this.f161626j;
        r118.postScale(r111, r111, r119.x, r119.y);
        r118.postTranslate(r116, r117);
        this.f161623g.set(r118);
        c.b(r118);
    L30:
        c.e(r115);
        c.b(r113);
        c.b(r100);
        return;
    L25:
        if (r117 != 0.0f) goto L28;
        r112 = r101;
        goto L28
    L18:
        r109 = getHeight();
        goto L19
    L15:
        r108 = 0.0f;
        goto L16
    L11:
        r105 = getWidth();
        goto L12
    L8:
        r104 = 0.0f;
        goto L9
    }

    public int getPinchMode() {
        return this.f161624h;
    }

    public PinchImageView(Context r100) {
        super(r100);
        this.f161617a = false;
        this.f161618b = null;
        this.f161619c = false;
        this.f161620d = false;
        this.f161623g = new Matrix();
        this.f161624h = 0;
        this.f161626j = new PointF();
        this.f161627k = new PointF();
        this.f161628l = 0.0f;
        this.f161631o = new GestureDetector(getContext(), new a(this));
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f161624h != 2) goto L5;
        return true;
    L5:
        RectF r101 = m(null);
        if (r101.isEmpty() == false) goto L8;
        return false;
    L8:
        if (r100 <= 0) goto L15;
        if (r101.right > getWidth()) goto L19;
        return false;
    L19:
        return true;
    L15:
        if (r101.left < 0.0f) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f161624h != 2) goto L5;
        return true;
    L5:
        RectF r101 = m(null);
        if (r101.isEmpty() == false) goto L8;
        return false;
    L8:
        if (r100 <= 0) goto L15;
        if (r101.bottom > getHeight()) goto L19;
        return false;
    L19:
        return true;
    L15:
        if (r101.top < 0.0f) goto L20;
        return false;
    L20:
        return true;
    }

    public final RectF m(RectF r100) {
        if (r100 != null) goto L4;
        r100 = new RectF();
    L6:
        if (o() == true) goto L8;
        return r100;
    L8:
        Matrix r101 = c.c();
        n(r101).postConcat(this.f161623g);
        r100.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        r101.mapRect(r100);
        c.b(r101);
        return r100;
    L4:
        r100.setEmpty();
        goto L6
    }

    public final Matrix n(Matrix r100) {
        if (r100 != null) goto L4;
        r100 = new Matrix();
    L6:
        if (o() == false) goto L8;
        RectF r101 = c.f(getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        RectF r102 = c.f(getWidth(), getHeight());
        r100.setRectToRect(r101, r102, Matrix.ScaleToFit.CENTER);
        c.e(r102);
        c.e(r101);
    L8:
        return r100;
    L4:
        r100.reset();
        goto L6
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        if (o() == true) goto L5;
    L12:
        super.onDraw(r100);
        return;
    L5:
        if (this.f161619c == true) goto L7;
    L11:
        Matrix r101 = c.c();
        Matrix r102 = n(r101);
        r102.postConcat(this.f161623g);
        setImageMatrix(r102);
        c.b(r101);
        goto L12
    L7:
        if (this.f161620d == true) goto L11;
        if (this.f161618b == null) goto L11;
        r();
        this.f161620d = true;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r210) {
        super.onTouchEvent(r210);
        int r100 = r210.getAction() & 255;
        if (r100 == 1) goto L44;
        if (r100 == 3) goto L44;
        if (r100 == 6) goto L10;
        if (r100 != 0) goto L26;
        h r101 = this.f161629m;
        if (r101 != null) goto L23;
    L24:
        j();
        this.f161624h = 1;
        this.f161626j.set(r210.getX(), r210.getY());
    L111:
        this.f161631o.onTouchEvent(r210);
        return true;
    L23:
        if (r101.isRunning() == true) goto L111;
    L26:
        if (r100 != 5) goto L28;
        j();
        this.f161624h = 2;
        q(r210.getX(0), r210.getY(0), r210.getX(1), r210.getY(1));
        goto L111
    L28:
        if (r100 != 2) goto L111;
        h r102 = this.f161629m;
        if (r102 != null) goto L32;
    L33:
        int r103 = this.f161624h;
        if (r103 != 1) goto L36;
        s(r210.getX() - this.f161626j.x, r210.getY() - this.f161626j.y);
        this.f161626j.set(r210.getX(), r210.getY());
        goto L111
    L36:
        if (r103 != 2) goto L111;
        if (r210.getPointerCount() <= 1) goto L111;
        float r104 = r210.getX(0);
        float r105 = r210.getY(0);
        float r106 = r210.getX(1);
        float r107 = r210.getY(1);
        d r108 = c.f161635a;
        float r109 = r104 - r106;
        float r110 = r105 - r107;
        float r111 = (float) Math.sqrt((r109 * r109) + (r110 * r110));
        float r112 = r210.getX(0);
        float r113 = r210.getY(0);
        float r114 = r210.getX(1);
        float r115 = (r113 + r210.getY(1)) / 2.0f;
        this.f161626j.set((r112 + r114) / 2.0f, r115);
        PointF r116 = this.f161627k;
        float r117 = this.f161628l;
        PointF r118 = this.f161626j;
        if (o() == false) goto L111;
        float r119 = r117 * r111;
        Matrix r120 = c.c();
        r120.postScale(r119, r119, r116.x, r116.y);
        r120.postTranslate(r118.x - r116.x, r118.y - r116.y);
        this.f161623g.set(r120);
        c.b(r120);
        l();
        invalidate();
        goto L111
    L32:
        if (r102.isRunning() == true) goto L111;
    L10:
        if (this.f161624h != 2) goto L111;
        if (r210.getPointerCount() <= 2) goto L111;
        if ((r210.getAction() >> 8) != 0) goto L17;
        q(r210.getX(1), r210.getY(1), r210.getX(2), r210.getY(2));
        goto L111
    L17:
        if ((r210.getAction() >> 8) != 1) goto L111;
        q(r210.getX(0), r210.getY(0), r210.getX(2), r210.getY(2));
    L44:
        if (this.f161624h == 2) goto L46;
    L110:
        this.f161624h = 0;
        goto L111
    L46:
        if (o() == false) goto L110;
        Matrix r121 = c.c();
        n(r121).postConcat(this.f161623g);
        float r122 = c.a(r121)[0];
        float r123 = c.a(this.f161623g)[0];
        boolean r124 = this.f161617a;
        if (r124 == false) goto L51;
        float r125 = this.f161618b.left;
    L52:
        if (r124 == false) goto L54;
        int r126 = this.f161618b.right;
    L55:
        float r127 = r126;
        boolean r128 = this.f161617a;
        if (r128 == false) goto L58;
        float r129 = this.f161618b.top;
    L59:
        if (r128 == false) goto L61;
        int r130 = this.f161618b.bottom;
    L62:
        float r131 = r130;
        if (this.f161617a == false) goto L65;
        int r132 = this.f161618b.width();
    L66:
        float r133 = r132;
        if (this.f161617a == false) goto L69;
        int r134 = this.f161618b.height();
    L70:
        float r135 = r134;
        float r136 = getMaxScale();
        if (r122 <= r136) goto L73;
        float r137 = r136 / r122;
    L74:
        float r138 = getMinScale();
        if ((r123 * r137) >= r138) goto L78;
        r137 = r138 / r123;
    L78:
        if (r137 == 1.0f) goto L80;
        boolean r139 = true;
    L81:
        Matrix r140 = c.d(r121);
        PointF r141 = this.f161626j;
        r140.postScale(r137, r137, r141.x, r141.y);
        RectF r142 = c.f(getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        r140.mapRect(r142);
        float r143 = r142.right;
        float r144 = r142.left;
        if ((r143 - r144) >= r133) goto L85;
        float r145 = ((r125 + r127) / 2.0f) - ((r143 + r144) / 2.0f);
    L91:
        float r146 = r142.bottom;
        float r147 = r142.top;
        if ((r146 - r147) >= r135) goto L96;
        float r148 = ((r129 + r131) / 2.0f) - ((r146 + r147) / 2.0f);
    L94:
        float r149 = 0.0f;
    L103:
        if (r145 == r149) goto L105;
    L106:
        r139 = true;
    L107:
        if (r139 == false) goto L109;
        Matrix r150 = c.d(this.f161623g);
        PointF r151 = this.f161626j;
        r150.postScale(r137, r137, r151.x, r151.y);
        r150.postTranslate(r145, r148);
        j();
        h r152 = new h(this, this.f161623g, r150);
        this.f161629m = r152;
        r152.start();
        c.b(r150);
    L109:
        c.e(r142);
        c.b(r140);
        c.b(r121);
        goto L110
    L105:
        if (r148 == r149) goto L107;
    L96:
        if (r147 <= r129) goto L99;
        r148 = r129 - r147;
        goto L94
    L99:
        if (r146 >= r131) goto L101;
        r148 = r131 - r146;
        goto L94
    L101:
        r149 = 0.0f;
        r148 = 0.0f;
        goto L103
    L85:
        if (r144 <= r125) goto L88;
        r145 = r125 - r144;
        goto L91
    L88:
        if (r143 >= r127) goto L90;
        r145 = r127 - r143;
        goto L91
    L90:
        r145 = 0.0f;
        goto L91
    L80:
        r139 = false;
        goto L81
    L73:
        r137 = 1.0f;
        goto L74
    L69:
        r134 = getHeight();
        goto L70
    L65:
        r132 = getWidth();
        goto L66
    L61:
        r130 = getHeight();
        goto L62
    L58:
        r129 = 0.0f;
        goto L59
    L54:
        r126 = getWidth();
        goto L55
    L51:
        r125 = 0.0f;
        goto L52
    }

    public void setDisplayWindowRect(Rect r100) {
        this.f161618b = r100;
        if (r100 == null) goto L6;
        this.f161617a = true;
        return;
    }

    public void setNeedScaleToMin(boolean r100) {
        this.f161619c = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.f161621e = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.f161622f = r100;
    }

    public PinchImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f161617a = false;
        this.f161618b = null;
        this.f161619c = false;
        this.f161620d = false;
        this.f161623g = new Matrix();
        this.f161624h = 0;
        this.f161626j = new PointF();
        this.f161627k = new PointF();
        this.f161628l = 0.0f;
        this.f161631o = new GestureDetector(getContext(), new a(this));
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final boolean s(float r110, float r111) {
        if (o() == true) goto L5;
        return false;
    L5:
        RectF r100 = c.f161636b.c();
        m(r100);
        boolean r101 = this.f161617a;
        if (r101 == false) goto L8;
        float r102 = this.f161618b.left;
    L9:
        if (r101 == false) goto L11;
        int r103 = this.f161618b.right;
    L12:
        float r104 = r103;
        boolean r105 = this.f161617a;
        if (r105 == false) goto L15;
        float r106 = this.f161618b.top;
    L16:
        if (r105 == false) goto L18;
        int r107 = this.f161618b.bottom;
    L19:
        float r108 = r107;
        if (this.f161617a == false) goto L22;
        int r109 = this.f161618b.width();
    L23:
        float r112 = r109;
        if (this.f161617a == false) goto L26;
        int r113 = this.f161618b.height();
    L27:
        float r114 = r113;
        float r115 = r100.right;
        float r116 = r100.left;
        if ((r115 - r116) >= r112) goto L31;
    L29:
        r110 = 0.0f;
    L40:
        float r117 = r100.bottom;
        float r118 = r100.top;
        if ((r117 - r118) >= r114) goto L44;
    L42:
        r111 = 0.0f;
    L53:
        c.e(r100);
        this.f161623g.postTranslate(r110, r111);
        l();
        invalidate();
        if (r110 == 0.0f) goto L56;
    L57:
        return true;
    L56:
        if (r111 != 0.0f) goto L57;
        return false;
    L44:
        if ((r118 + r111) <= r106) goto L49;
        if (r118 >= r106) goto L42;
        r111 = r106 - r118;
        goto L53
    L49:
        if ((r117 + r111) >= r108) goto L53;
        if (r117 <= r108) goto L42;
        r111 = r108 - r117;
        goto L53
    L31:
        if ((r116 + r110) <= r102) goto L36;
        if (r116 >= r102) goto L29;
        r110 = r102 - r116;
        goto L40
    L36:
        if ((r115 + r110) >= r104) goto L40;
        if (r115 <= r104) goto L29;
        r110 = r104 - r115;
        goto L40
    L26:
        r113 = getHeight();
        goto L27
    L22:
        r109 = getWidth();
        goto L23
    L18:
        r107 = getHeight();
        goto L19
    L15:
        r106 = 0.0f;
        goto L16
    L11:
        r103 = getWidth();
        goto L12
    L8:
        r102 = 0.0f;
        goto L9
    }

    public PinchImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f161617a = false;
        this.f161618b = null;
        this.f161619c = false;
        this.f161620d = false;
        this.f161623g = new Matrix();
        this.f161624h = 0;
        this.f161626j = new PointF();
        this.f161627k = new PointF();
        this.f161628l = 0.0f;
        this.f161631o = new GestureDetector(getContext(), new a(this));
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void q(float r100, float r101, float r102, float r103) {
        float r104 = r100 - r102;
        float r105 = r101 - r103;
        this.f161628l = c.a(this.f161623g)[0] / ((float) Math.sqrt((r104 * r104) + (r105 * r105)));
        float[] r106 = {(r100 + r102) / 2.0f, (r101 + r103) / 2.0f};
        Matrix r107 = this.f161623g;
        if (r107 == null) goto L5;
        float[] r108 = new float[2];
        Matrix r109 = c.c();
        r107.invert(r109);
        r109.mapPoints(r108, r106);
        c.b(r109);
    L6:
        this.f161627k.set(r108[0], r108[1]);
        return;
    L5:
        r108 = new float[2];
        goto L6
    }
}
