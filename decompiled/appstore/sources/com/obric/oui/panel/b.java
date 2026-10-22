package com.obric.oui.panel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Interpolator f15827o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f15828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.c f15829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f15830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f15831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f15832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f15833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15834g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15835h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15836i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15837j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f15838k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f15839l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15840m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Runnable f15841n;

    public class a implements Interpolator {
        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = r10 - 1.0f;
            return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.panel.b$b, reason: collision with other inner class name */
    public class RunnableC0203b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f15842a;

        public RunnableC0203b(b r10) {
            this.f15842a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b(this.f15842a).removeCallbacks(b.a(this.f15842a));
            b.c(this.f15842a, false);
        }
    }

    static {
        f15827o = new a();
    }

    public b(Context r10, ViewGroup r11, e.c r12) {
        this.f15840m = false;
        this.f15841n = new RunnableC0203b(this);
        this.f15828a = new OverScroller(r10, f15827o);
        this.f15833f = r11;
        this.f15829b = r12;
        ViewConfiguration r13 = ViewConfiguration.get(r10);
        this.f15832e = r13.getScaledTouchSlop();
        this.f15830c = r13.getScaledMaximumFlingVelocity();
        this.f15831d = r13.getScaledMinimumFlingVelocity();
    }

    public static /* synthetic */ Runnable a(b r10) {
        return r10.f15841n;
    }

    public static /* synthetic */ ViewGroup b(b r10) {
        return r10.f15833f;
    }

    public static /* synthetic */ boolean c(b r10, boolean r11) {
        r10.f15840m = r11;
        return r11;
    }

    public final float d(float r10, float r11, float r12) {
        float r13 = Math.abs(r10);
        if (r13 >= r11) goto L6;
        return 0.0f;
    L6:
        if (r13 > r12) goto L8;
        return r10;
    L8:
        if (r10 <= 0.0f) goto L11;
        return r12;
    L11:
        return -r12;
    }

    public final int e(int r10, int r11, int r12) {
        int r13 = Math.abs(r10);
        if (r13 >= r11) goto L6;
        return 0;
    L6:
        if (r13 <= r12) goto L11;
        if (r10 <= 0) goto L10;
        return r12;
    L10:
        return -r12;
    L11:
        return r10;
    }

    public final int f(int r10, int r11, int r12) {
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r13 = this.f15833f.getWidth();
        float r14 = r13 / 2;
        float r15 = r14 + (i(Math.min(1.0f, Math.abs(r10) / r13)) * r14);
        int r16 = Math.abs(r11);
        if (r16 <= 0) goto L8;
        int r17 = Math.round(Math.abs(r15 / r16) * 1000.0f) * 4;
    L10:
        return Math.min(r17, 600);
    L8:
        r17 = (int) (((Math.abs(r10) / r12) + 1.0f) * 256.0f);
        goto L10
    }

    public final int g(View r10, int r11, int r12, int r13, int r14) {
        int r15 = e(r13, (int) this.f15831d, (int) this.f15830c);
        int r16 = e(r14, (int) this.f15831d, (int) this.f15830c);
        int r17 = Math.abs(r11);
        int r18 = Math.abs(r12);
        int r19 = Math.abs(r15);
        int r20 = Math.abs(r16);
        int r21 = r19 + r20;
        int r22 = r17 + r18;
        if (r15 == 0) goto L6;
        float r23 = r19;
        float r24 = r21;
    L5:
        float r25 = r23 / r24;
        if (r16 == 0) goto L10;
        float r26 = r20;
        float r27 = r21;
    L9:
        float r28 = r26 / r27;
        return (int) ((f(r11, r15, this.f15829b.d(r10)) * r25) + (f(r12, r16, this.f15829b.e(r10)) * r28));
    L10:
        r26 = r18;
        r27 = r22;
        goto L9
    L6:
        r23 = r17;
        r24 = r22;
        goto L5
    }

    public boolean h(View r10, boolean r11) {
        if (this.f15840m == false) goto L24;
        boolean r12 = this.f15828a.computeScrollOffset();
        int r13 = this.f15828a.getCurrX();
        int r14 = this.f15828a.getCurrY();
        int r15 = r13 - r10.getLeft();
        int r16 = r14 - r10.getTop();
        if (r15 == 0) goto L7;
        ViewCompat.Z(r10, r15);
    L7:
        if (r16 == 0) goto L9;
        ViewCompat.a0(r10, r16);
    L9:
        if (r15 != 0) goto L11;
        if (r16 != 0) goto L11;
    L13:
        if (r12 == true) goto L15;
    L19:
        if (r12 == true) goto L24;
        if (r11 == false) goto L22;
        this.f15833f.post(this.f15841n);
        goto L24
    L22:
        this.f15840m = false;
        goto L24
    L15:
        if (r13 != this.f15828a.getFinalX()) goto L19;
        if (r14 != this.f15828a.getFinalY()) goto L19;
        this.f15828a.abortAnimation();
        r12 = false;
    L11:
        this.f15829b.k(r10, r13, r14, r15, r16);
    L24:
        return this.f15840m;
    }

    public final float i(float r10) {
        return (float) Math.sin((r10 - 0.5f) * 0.47123894f);
    }

    public void j(View r10, int r11, int r12, int r13, int r14) {
        int r15 = r10.getLeft();
        int r16 = r10.getTop();
        if (r13 == 0) goto L5;
        r11 = this.f15829b.a(r10, r11, r13);
        ViewCompat.Z(r10, r11 - r15);
    L5:
        int r17 = r11;
        if (r14 == 0) goto L8;
        r12 = this.f15829b.b(r10, r12, r14);
        ViewCompat.a0(r10, r12 - r16);
    L8:
        int r18 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        e.c r19 = this.f15829b;
        r19.k(r10, r17, r18, r17 - r15, r18 - r16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View k(View r10) {
        if (r10 != 0) goto L6;
        return null;
    L6:
        if (r10.canScrollHorizontally(-this.f15839l) == false) goto L8;
    L21:
        return r10;
    L8:
        if ((r10 instanceof IRLSlideView) == false) goto L13;
        if (((IRLSlideView) r10).canSlide(-this.f15839l) == true) goto L21;
    L13:
        if ((r10 instanceof ViewGroup) == false) goto L20;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L15:
        if (r13 >= r12) goto L20;
        View r14 = k(r11.getChildAt(r13));
        if (r14 != null) goto L18;
        r13 = r13 + 1;
        goto L15
    L18:
        return r14;
    L20:
        return null;
    }

    public final boolean l(View r10, int r11, int r12, int r13, int r14) {
        int r15 = r10.getLeft();
        int r16 = r10.getTop();
        int r17 = r11 - r15;
        int r18 = r12 - r16;
        if (r17 != 0) goto L7;
        if (r18 != 0) goto L7;
        this.f15828a.abortAnimation();
        return false;
    L7:
        int r19 = g(r10, r17, r18, r13, r14);
        this.f15828a.startScroll(r15, r16, r17, r18, r19);
        this.f15840m = true;
        return true;
    }

    public final float m(VelocityTracker r10) {
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        r10.computeCurrentVelocity(1000, this.f15830c);
        return r10.getXVelocity(this.f15837j);
    }

    public boolean n() {
        return this.f15838k;
    }

    public final boolean o(float r10, float r11) {
        if (Math.abs(r10) > this.f15832e) goto L5;
    L7:
        return false;
    L5:
        if ((Math.abs(r10) * 0.5f) <= Math.abs(r11)) goto L7;
        return true;
    }

    public void p(MotionEvent r10, View r11, int r12, VelocityTracker r13) {
        int r14 = r10.getActionMasked();
        if (r14 != 2) goto L6;
        int r15 = (int) r10.getX();
        int r16 = r15 - this.f15836i;
        this.f15836i = r15;
        int r17 = (int) ((r16 * (r11.getHeight() / r11.getWidth())) * 1.2f);
        j(r11, r11.getLeft(), r11.getTop() + r17, 0, r17);
    L6:
        if (r14 != 1) goto L10;
        if (r12 != 1) goto L10;
        q(r11, r13);
    L10:
        if (r14 != 3) goto L14;
        if (r12 != 1) goto L15;
        this.f15829b.l(r11, 0.0f, 0.0f);
        return;
    L15:
        return;
    }

    public void q(View r10, VelocityTracker r11) {
        r11.computeCurrentVelocity(1000, this.f15830c);
        float r12 = d(m(r11), this.f15831d, this.f15830c);
        this.f15829b.l(r10, 0.0f, r12);
    }

    public boolean r(View r10, int r11, int r12, int r13, int r14) {
        return l(r10, r11, r12, r13, r14);
    }

    public boolean s(View r10, MotionEvent r11) {
        this.f15836i = (int) r11.getX();
        boolean r12 = false;
        this.f15838k = false;
        int r13 = r11.getActionMasked();
        if (r13 != 0) goto L5;
        this.f15834g = (int) r11.getX();
        this.f15835h = (int) r11.getY();
    L5:
        int r14 = ((int) r11.getX()) - this.f15834g;
        int r15 = ((int) r11.getY()) - this.f15835h;
        if (r13 == 2) goto L8;
    L12:
        if (r12 == false) goto L17;
        if (r14 <= 0) goto L15;
        int r16 = 1;
    L16:
        this.f15839l = r16;
        this.f15829b.j(1);
        this.f15838k = true;
        goto L17
    L15:
        r16 = -1;
    L17:
        return r12;
    L8:
        if (o(r14, r15) == false) goto L12;
        if (k(r10) != null) goto L12;
        r12 = true;
        goto L12
    }
}
