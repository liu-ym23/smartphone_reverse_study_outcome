package com.bytedance.android.live.uikit.imageview.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes7.dex */
public class ImageViewTouch extends ImageViewTouchBase {
    public boolean A;
    public boolean B;
    public View.OnClickListener C;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ScaleGestureDetector f102210r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public GestureDetector f102211s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f102212t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f102213u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f102214v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public GestureDetector.OnGestureListener f102215w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ScaleGestureDetector.OnScaleGestureListener f102216x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f102217y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f102218z;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewTouch f102219a;

        public a(ImageViewTouch r100) {
            this.f102219a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            ImageViewTouch r101 = this.f102219a;
            if (r101.f102217y == false) goto L12;
            float r102 = r101.getScale();
            ImageViewTouch r103 = this.f102219a;
            float r104 = r103.getMaxZoom();
            if (r103.f102214v != 1) goto L10;
            float r105 = r103.f102213u;
            if (((2.0f * r105) + r102) > r104) goto L9;
            r104 = r102 + r105;
        L11:
            float r106 = Math.min(this.f102219a.getMaxZoom(), Math.max(r104, this.f102219a.getMinZoom()));
            ImageViewTouch r107 = this.f102219a;
            r107.f102212t = r106;
            r107.q(r106, r100.getX(), r100.getY(), 200.0f);
            this.f102219a.invalidate();
            goto L12
        L9:
            r103.f102214v = -1;
            goto L11
        L10:
            r103.f102214v = 1;
            r104 = 1.0f;
        L12:
            this.f102219a.getClass();
            return super.onDoubleTap(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            if (this.f102219a.isLongClickable() == true) goto L5;
            return;
        L5:
            if (this.f102219a.f102210r.isInProgress() == true) goto L9;
            this.f102219a.setPressed(true);
            this.f102219a.performLongClick();
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            ImageViewTouch r101 = this.f102219a;
            View.OnClickListener r102 = r101.C;
            if (r102 == null) goto L9;
            if (r101.B == false) goto L9;
            r102.onClick(r101);
            return true;
        L9:
            return super.onSingleTapConfirmed(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r110, MotionEvent r111, float r112, float r113) {
            ImageViewTouch r100 = this.f102219a;
            if (r100.A == true) goto L6;
        L21:
            return false;
        L6:
            if (Logger.debug() == false) goto L9;
            Logger.d("image", "onFling: " + r112 + ", " + r113);
        L9:
            if (r110.getPointerCount() > 1) goto L21;
            if (r111.getPointerCount() > 1) goto L21;
            if (r100.f102210r.isInProgress() == true) goto L21;
            float r101 = r111.getX() - r110.getX();
            float r114 = r111.getY() - r110.getY();
            if (Math.abs(r112) <= 800.0f) goto L19;
        L20:
            r100.f102224d.post(new vb1.a(r100, System.currentTimeMillis(), r101 / 2.0f, r114 / 2.0f));
            r100.invalidate();
            return true;
        L19:
            if (Math.abs(r113) <= 800.0f) goto L21;
            goto L20
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            ImageViewTouch r104 = this.f102219a;
            if (r104.A == false) goto L25;
            if (r100 == null) goto L25;
            if (r101 == null) goto L25;
            if (r100.getPointerCount() > 1) goto L25;
            if (r101.getPointerCount() > 1) goto L25;
            if (r104.f102210r.isInProgress() == true) goto L25;
            float r105 = r104.getScale();
            if (Logger.debug() == false) goto L20;
            Logger.d("image", "onScroll: " + r102 + ", " + r103 + " " + r105);
        L20:
            if (r105 == 1.0f) goto L22;
        L24:
            r104.m(-r102, -r103);
            r104.invalidate();
            return true;
        L22:
            if (r104.f102232l == true) goto L24;
        L25:
            return false;
        }
    }

    public interface b {
    }

    public class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewTouch f102220a;

        public c(ImageViewTouch r100) {
            this.f102220a = r100;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            r100.getCurrentSpan();
            r100.getPreviousSpan();
            float r101 = this.f102220a.f102212t * r100.getScaleFactor();
            ImageViewTouch r102 = this.f102220a;
            if (r102.f102218z == false) goto L6;
            float r103 = Math.min(r102.getMaxZoom(), Math.max(r101, this.f102220a.getMinZoom() - 0.1f));
            this.f102220a.p(r103, r100.getFocusX(), r100.getFocusY());
            ImageViewTouch r104 = this.f102220a;
            r104.f102212t = Math.min(r104.getMaxZoom(), Math.max(r103, this.f102220a.getMinZoom() - 1.0f));
            ImageViewTouch r105 = this.f102220a;
            r105.f102214v = 1;
            r105.invalidate();
            return true;
        L6:
            return false;
        }
    }

    public void setDoubleTapListener(b r100) {
    }

    public GestureDetector.OnGestureListener getGestureListener() {
        return new a(this);
    }

    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new c(this);
    }

    @Override // com.bytedance.android.live.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void j() {
        float[] r100 = new float[9];
        this.f102223c.getValues(r100);
        this.f102212t = r100[0];
    }

    @Override // com.bytedance.android.live.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void h() {
        super.h();
        ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f102215w = getGestureListener();
        this.f102216x = getScaleListener();
        this.f102210r = new ScaleGestureDetector(getContext().getApplicationContext(), this.f102216x);
        this.f102211s = new GestureDetector(getContext().getApplicationContext(), this.f102215w, null, true);
        this.f102212t = 1.0f;
        this.f102214v = 1;
    }

    public boolean getDoubleTapEnabled() {
        return this.f102217y;
    }

    @Override // com.bytedance.android.live.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void k(float r100) {
        if (this.f102210r.isInProgress() == true) goto L6;
        this.f102212t = r100;
        return;
    }

    @Override // com.bytedance.android.live.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void l(float r100) {
        if (this.f102210r.isInProgress() == true) goto L6;
        this.f102212t = r100;
    L6:
        if (r100 >= getMinZoom()) goto L9;
        q(getMinZoom(), getWidth() / 2.0f, getHeight() / 2.0f, 50.0f);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction() & 255;
        if (r101 != 0) goto L6;
        this.B = true;
    L6:
        if (r100.getPointerCount() <= 1) goto L8;
        this.B = false;
    L8:
        this.f102210r.onTouchEvent(r100);
        if (this.f102210r.isInProgress() == true) goto L11;
        this.f102211s.onTouchEvent(r100);
    L11:
        if (r101 == 0) goto L17;
        if (r101 == 1) goto L15;
    L18:
        return true;
    L15:
        if (getScale() >= getMinZoom()) goto L18;
        q(getMinZoom(), getWidth() / 2.0f, getHeight() / 2.0f, 50.0f);
        goto L18
    L17:
        this.f102237q = false;
        goto L18
    }

    public void setDoubleTapEnabled(boolean r100) {
        this.f102217y = r100;
    }

    public void setMyOnClickListener(View.OnClickListener r100) {
        this.C = r100;
    }

    public void setScaleEnabled(boolean r100) {
        this.f102218z = r100;
    }

    public void setScrollEnabled(boolean r100) {
        this.A = r100;
    }

    public ImageViewTouch(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f102217y = true;
        this.f102218z = true;
        this.A = true;
        this.B = true;
    }

    @Override // com.bytedance.android.live.uikit.imageview.imagezoom.ImageViewTouchBase
    public final void a(Drawable r100, boolean r101, Matrix r102, float r103) {
        super.a(r100, r101, r102, r103);
        this.f102213u = getMaxZoom() / 3.0f;
    }
}
