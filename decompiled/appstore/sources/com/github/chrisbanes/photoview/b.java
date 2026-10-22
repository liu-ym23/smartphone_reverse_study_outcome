package com.github.chrisbanes.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f10275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f10276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f10278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f10279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f10280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f10281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OnGestureListener f10282j;

    public class a implements ScaleGestureDetector.OnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f10283a;

        public a(b r10) {
            this.f10283a = r10;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector r10) {
            float r11 = r10.getScaleFactor();
            if (Float.isNaN(r11) == false) goto L5;
            return false;
        L5:
            if (Float.isInfinite(r11) == false) goto L8;
            return false;
        L8:
            if (r11 < 0.0f) goto L14;
            b.a(this.f10283a).onScale(r11, r10.getFocusX(), r10.getFocusY());
            return true;
        L14:
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector r10) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector r10) {
        }
    }

    public b(Context r10, OnGestureListener r11) {
        this.f10273a = -1;
        this.f10274b = 0;
        ViewConfiguration r12 = ViewConfiguration.get(r10);
        this.f10281i = r12.getScaledMinimumFlingVelocity();
        this.f10280h = r12.getScaledTouchSlop();
        this.f10282j = r11;
        this.f10275c = new ScaleGestureDetector(r10, new a(this));
    }

    public static /* synthetic */ OnGestureListener a(b r10) {
        return r10.f10282j;
    }

    public final float b(MotionEvent r10) {
        return r10.getX(this.f10274b);
    L5:
        return r10.getX();
    }

    public final float c(MotionEvent r10) {
        return r10.getY(this.f10274b);
    L5:
        return r10.getY();
    }

    public boolean d() {
        return this.f10277e;
    }

    public boolean e() {
        return this.f10275c.isInProgress();
    }

    public boolean f(MotionEvent r10) {
        this.f10275c.onTouchEvent(r10);     // Catch: IllegalArgumentException -> L4
        return g(r10);
    L4:
        return true;
    }

    public final boolean g(MotionEvent r12) {
        int r10 = r12.getAction() & PrivateKeyType.INVALID;
        int r11 = 0;
        if (r10 != 0) goto L5;
        this.f10273a = r12.getPointerId(0);
        VelocityTracker r13 = VelocityTracker.obtain();
        this.f10276d = r13;
        if (r13 == null) goto L47;
        r13.addMovement(r12);
    L47:
        this.f10278f = b(r12);
        this.f10279g = c(r12);
        this.f10277e = false;
    L48:
        int r14 = this.f10273a;
        if (r14 == (-1)) goto L51;
        r11 = r14;
    L51:
        this.f10274b = r12.findPointerIndex(r11);
        return true;
    L5:
        if (r10 != 1) goto L7;
        this.f10273a = -1;
        if (this.f10277e == true) goto L37;
    L41:
        VelocityTracker r15 = this.f10276d;
        if (r15 == null) goto L48;
        r15.recycle();
        this.f10276d = null;
        goto L48
    L37:
        if (this.f10276d == null) goto L41;
        this.f10278f = b(r12);
        this.f10279g = c(r12);
        this.f10276d.addMovement(r12);
        this.f10276d.computeCurrentVelocity(1000);
        float r16 = this.f10276d.getXVelocity();
        float r17 = this.f10276d.getYVelocity();
        if (Math.max(Math.abs(r16), Math.abs(r17)) < this.f10281i) goto L41;
        this.f10282j.onFling(this.f10278f, this.f10279g, -r16, -r17);
        goto L41
    L7:
        if (r10 != 2) goto L9;
        float r18 = b(r12);
        float r19 = c(r12);
        float r20 = r18 - this.f10278f;
        float r21 = r19 - this.f10279g;
        if (this.f10277e == true) goto L30;
        if (Math.sqrt((r20 * r20) + (r21 * r21)) < this.f10280h) goto L27;
        boolean r22 = true;
    L28:
        this.f10277e = r22;
        goto L30
    L27:
        r22 = false;
    L30:
        if (this.f10277e == false) goto L48;
        this.f10282j.onDrag(r20, r21);
        this.f10278f = r18;
        this.f10279g = r19;
        VelocityTracker r23 = this.f10276d;
        if (r23 == null) goto L48;
        r23.addMovement(r12);
        goto L48
    L9:
        if (r10 != 3) goto L11;
        this.f10273a = -1;
        VelocityTracker r24 = this.f10276d;
        if (r24 == null) goto L48;
        r24.recycle();
        this.f10276d = null;
        goto L48
    L11:
        if (r10 != 6) goto L48;
        int r25 = d.b(r12.getAction());
        if (r12.getPointerId(r25) != this.f10273a) goto L48;
        if (r25 != 0) goto L17;
        int r26 = 1;
    L18:
        this.f10273a = r12.getPointerId(r26);
        this.f10278f = r12.getX(r26);
        this.f10279g = r12.getY(r26);
        goto L48
    L17:
        r26 = 0;
        goto L18
    }
}
