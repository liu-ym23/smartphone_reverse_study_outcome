package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HeaderBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a<V extends View> extends c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    OverScroller f13175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f13176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13179e;
    private int f;
    private VelocityTracker g;

    /* JADX INFO: renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeaderBehavior.java */
    private class RunnableC0275a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f13180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CoordinatorLayout f13181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final V f13182c;

        RunnableC0275a(a r1, CoordinatorLayout r2, V r3) {
            this.f13180a = r1;
            this.f13181b = r2;
            this.f13182c = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13182c != null) goto L5;
            return;
        L5:
            if (this.f13180a.f13175a != null) goto L7;
            return;
        L7:
            if (this.f13180a.f13175a.computeScrollOffset() == false) goto L9;
            a r0 = this.f13180a;
            r0.a_(this.f13181b, this.f13182c, r0.f13175a.getCurrY());
            ViewCompat.a(this.f13182c, this);
            return;
        L9:
            this.f13180a.e(this.f13181b, this.f13182c);
        }
    }

    boolean c(V r1) {
        return false;
    }

    void e(CoordinatorLayout r1, V r2) {
    }

    public a() {
        this.f13178d = -1;
        this.f = -1;
    }

    public a(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.f13178d = -1;
        this.f = -1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r7, V r8, MotionEvent r9) {
        if (this.f >= 0) goto L6;
        this.f = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getScaledTouchSlop();
    L6:
        if (r9.getActionMasked() != 2) goto L20;
        if (this.f13177c == false) goto L20;
        int r0 = this.f13178d;
        if (r0 != (-1)) goto L12;
        return false;
    L12:
        int r1 = r9.findPointerIndex(r0);
        if (r1 != (-1)) goto L15;
        return false;
    L15:
        int r2 = (int) r9.getY(r1);
        if (Math.abs(r2 - this.f13179e) <= this.f) goto L20;
        this.f13179e = r2;
        return true;
    L20:
        if (r9.getActionMasked() != 0) goto L35;
        this.f13178d = -1;
        int r3 = (int) r9.getX();
        int r4 = (int) r9.getY();
        if (c(r8) == true) goto L24;
    L26:
        boolean r10 = false;
    L27:
        this.f13177c = r10;
        if (r10 == false) goto L35;
        this.f13179e = r4;
        this.f13178d = r9.getPointerId(0);
        d();
        OverScroller r11 = this.f13175a;
        if (r11 == null) goto L35;
        if (r11.isFinished() == true) goto L35;
        this.f13175a.abortAnimation();
        return true;
    L24:
        if (r7.isPointInChildBounds(r8, r3, r4) == false) goto L26;
        r10 = true;
    L35:
        VelocityTracker r6 = this.g;
        if (r6 == null) goto L38;
        r6.addMovement(r9);
    L38:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout r12, V r13, MotionEvent r14) {
        int r0 = r14.getActionMasked();
        if (r0 != 1) goto L5;
        VelocityTracker r1 = this.g;
        if (r1 == null) goto L24;
        r1.addMovement(r14);
        this.g.computeCurrentVelocity(1000);
        a(r12, r13, -a(r13), 0, this.g.getYVelocity(this.f13178d));
        boolean r15 = true;
    L25:
        this.f13177c = false;
        this.f13178d = -1;
        VelocityTracker r16 = this.g;
        if (r16 == null) goto L28;
        r16.recycle();
        this.g = null;
    L28:
        VelocityTracker r17 = this.g;
        if (r17 == null) goto L32;
        r17.addMovement(r14);
    L32:
        if (this.f13177c == true) goto L37;
        if (r15 == false) goto L36;
        return true;
    L36:
        return false;
    L37:
        return true;
    L24:
        r15 = false;
        goto L25
    L5:
        if (r0 != 2) goto L7;
        int r2 = r14.findPointerIndex(this.f13178d);
        if (r2 != (-1)) goto L19;
        return false;
    L19:
        int r3 = (int) r14.getY(r2);
        int r7 = this.f13179e - r3;
        this.f13179e = r3;
        b(r12, r13, r7, b(r13), 0);
    L20:
        r15 = false;
        goto L28
    L7:
        if (r0 == 3) goto L24;
        if (r0 != 6) goto L20;
        if (r14.getActionIndex() != 0) goto L14;
        int r18 = 1;
    L15:
        this.f13178d = r14.getPointerId(r18);
        this.f13179e = (int) (r14.getY(r18) + 0.5f);
        goto L20
    L14:
        r18 = 0;
        goto L15
    }

    int a_(CoordinatorLayout r7, V r8, int r9) {
        return a(r7, r8, r9, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int a(CoordinatorLayout r1, V r2, int r3, int r4, int r5) {
        int r6 = c();
        if (r4 == 0) goto L9;
        if (r6 < r4) goto L9;
        if (r6 > r5) goto L9;
        int r7 = androidx.core.a.a.a(r3, r4, r5);
        if (r6 == r7) goto L9;
        a(r7);
        return r6 - r7;
    L9:
        return 0;
    }

    int b() {
        return c();
    }

    final int b(CoordinatorLayout r8, V r9, int r10, int r11, int r12) {
        return a(r8, r9, b() - r10, r11, r12);
    }

    final boolean a(CoordinatorLayout r14, V r15, int r16, int r17, float r18) {
        Runnable r2 = this.f13176b;
        if (r2 == null) goto L6;
        r15.removeCallbacks(r2);
        this.f13176b = null;
    L6:
        if (this.f13175a != null) goto L8;
        this.f13175a = new OverScroller((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L8:
        this.f13175a.fling(0, c(), 0, Math.round(r18), 0, 0, r16, r17);
        if (this.f13175a.computeScrollOffset() == false) goto L12;
        RunnableC0275a r3 = new RunnableC0275a(this, r14, r15);
        this.f13176b = r3;
        ViewCompat.a(r15, r3);
        return true;
    L12:
        e(r14, r15);
        return false;
    }

    int b(V r1) {
        return -r1.getHeight();
    }

    int a(V r1) {
        return r1.getHeight();
    }

    private void d() {
        if (this.g != null) goto L6;
        this.g = VelocityTracker.obtain();
        return;
    }
}
