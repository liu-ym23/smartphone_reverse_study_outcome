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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BottomSheetRLDragHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final Interpolator m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OverScroller f35894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.a f35895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f35896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f35897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f35898e;
    private final ViewGroup f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private boolean n;
    private final Runnable o;

    static /* synthetic */ Runnable a(a r0) {
        return r0.o;
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ ViewGroup b(a r0) {
        return r0.f;
    }

    static {
        m = new BottomSheetRLDragHelper$1();
    }

    public a(Context r3, ViewGroup r4, c.a r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.n = false;
        this.o = new AnonymousClass1(this);
        this.f35894a = new OverScroller(r6, m);
        this.f = r4;
        this.f35895b = r5;
        ViewConfiguration r7 = ViewConfiguration.get(r6);
        this.f35898e = r7.getScaledTouchSlop();
        this.f35896c = r7.getScaledMaximumFlingVelocity();
        this.f35897d = r7.getScaledMinimumFlingVelocity();
    }

    public boolean a(View r6, MotionEvent r7) {
        this.i = (int) r7.getX();
        boolean r0 = false;
        this.k = false;
        int r1 = r7.getActionMasked();
        if (r1 != 0) goto L5;
        this.g = (int) r7.getX();
        this.h = (int) r7.getY();
    L5:
        int r2 = ((int) r7.getX()) - this.g;
        int r8 = ((int) r7.getY()) - this.h;
        if (r1 == 2) goto L8;
    L12:
        if (r0 == false) goto L17;
        if (r2 <= 0) goto L15;
        int r9 = 1;
    L16:
        this.l = r9;
        this.f35895b.a(1);
        this.k = true;
        goto L17
    L15:
        r9 = -1;
    L17:
        return r0;
    L8:
        if (a(r2, r8) == false) goto L12;
        if (a(r6) != null) goto L12;
        r0 = true;
        goto L12
    }

    public boolean a() {
        return this.k;
    }

    public void a(MotionEvent r9, View r10, int r11, VelocityTracker r12) {
        int r0 = r9.getActionMasked();
        if (r0 != 2) goto L6;
        int r13 = (int) r9.getX();
        int r1 = r13 - this.i;
        this.i = r13;
        int r7 = (int) ((r1 * (r10.getHeight() / r10.getWidth())) * 1.2f);
        a(r10, r10.getLeft(), r10.getTop() + r7, 0, r7);
    L6:
        if (r0 != 1) goto L10;
        if (r11 != 1) goto L10;
        a(r10, r12);
    L10:
        if (r0 != 3) goto L14;
        if (r11 != 1) goto L15;
        this.f35895b.a(r10, 0.0f, 0.0f);
        return;
    L15:
        return;
    }

    private boolean a(float r2, float r3) {
        if (Math.abs(r2) > this.f35898e) goto L5;
    L7:
        return false;
    L5:
        if ((Math.abs(r2) * 0.5f) <= Math.abs(r3)) goto L7;
        return true;
    }

    private View a(View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.canScrollHorizontally(-this.l) == false) goto L8;
    L21:
        return r5;
    L8:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L13;
        if (((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).a(-this.l) == true) goto L21;
    L13:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L20;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r2 = r6.getChildCount();
    L15:
        if (r1 >= r2) goto L20;
        View r3 = a(r6.getChildAt(r1));
        if (r3 != null) goto L18;
        r1 = r1 + 1;
        goto L15
    L18:
        return r3;
    L20:
        return null;
    }

    public void a(View r10, int r11, int r12, int r13, int r14) {
        int r0 = r10.getLeft();
        int r1 = r10.getTop();
        if (r13 == 0) goto L5;
        r11 = this.f35895b.b(r10, r11, r13);
        ViewCompat.g(r10, r11 - r0);
    L5:
        int r5 = r11;
        if (r14 == 0) goto L8;
        r12 = this.f35895b.a(r10, r12, r14);
        ViewCompat.f(r10, r12 - r1);
    L8:
        int r6 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        c.a r3 = this.f35895b;
        r3.a(r10, r5, r6, r5 - r0, r6 - r1);
    }

    public void a(View r3, VelocityTracker r4) {
        r4.computeCurrentVelocity(1000, this.f35896c);
        float r5 = a(a(r4), this.f35897d, this.f35896c);
        this.f35895b.a(r3, 0.0f, r5);
    }

    private float a(VelocityTracker r3) {
        if (r3 != null) goto L5;
        return 0.0f;
    L5:
        r3.computeCurrentVelocity(1000, this.f35896c);
        return r3.getXVelocity(this.j);
    }

    public boolean b(View r1, int r2, int r3, int r4, int r5) {
        return c(r1, r2, r3, r4, r5);
    }

    private boolean c(View r10, int r11, int r12, int r13, int r14) {
        int r1 = r10.getLeft();
        int r2 = r10.getTop();
        int r15 = r11 - r1;
        int r16 = r12 - r2;
        if (r15 != 0) goto L7;
        if (r16 != 0) goto L7;
        this.f35894a.abortAnimation();
        return false;
    L7:
        int r5 = d(r10, r15, r16, r13, r14);
        this.f35894a.startScroll(r1, r2, r15, r16, r5);
        this.n = true;
        return true;
    }

    private int d(View r7, int r8, int r9, int r10, int r11) {
        int r12 = a(r10, (int) this.f35897d, (int) this.f35896c);
        int r13 = a(r11, (int) this.f35897d, (int) this.f35896c);
        int r0 = Math.abs(r8);
        int r1 = Math.abs(r9);
        int r2 = Math.abs(r12);
        int r3 = Math.abs(r13);
        int r4 = r2 + r3;
        int r5 = r0 + r1;
        if (r12 == 0) goto L5;
        float r6 = r2;
        float r14 = r4;
    L6:
        float r15 = r6 / r14;
        if (r13 == 0) goto L9;
        float r16 = r3;
        float r17 = r4;
    L10:
        float r18 = r16 / r17;
        return (int) ((b(r8, r12, this.f35895b.b(r7)) * r15) + (b(r9, r13, this.f35895b.a(r7)) * r18));
    L9:
        r16 = r1;
        r17 = r5;
        goto L10
    L5:
        r6 = r0;
        r14 = r5;
        goto L6
    }

    private int a(int r1, int r2, int r3) {
        int r0 = Math.abs(r1);
        if (r0 >= r2) goto L6;
        return 0;
    L6:
        if (r0 <= r3) goto L11;
        if (r1 <= 0) goto L10;
        return r3;
    L10:
        return -r3;
    L11:
        return r1;
    }

    private float a(float r2, float r3, float r4) {
        float r1 = Math.abs(r2);
        if (r1 >= r3) goto L6;
        return 0.0f;
    L6:
        if (r1 > r4) goto L8;
        return r2;
    L8:
        if (r2 <= 0.0f) goto L11;
        return r4;
    L11:
        return -r4;
    }

    private int b(int r4, int r5, int r6) {
        if (r4 != 0) goto L5;
        return 0;
    L5:
        int r0 = this.f.getWidth();
        float r1 = r0 / 2;
        float r2 = r1 + (a(Math.min(1.0f, Math.abs(r4) / r0)) * r1);
        int r3 = Math.abs(r5);
        if (r3 <= 0) goto L8;
        int r7 = Math.round(Math.abs(r2 / r3) * 1000.0f) * 4;
    L10:
        return Math.min(r7, 600);
    L8:
        r7 = (int) (((Math.abs(r4) / r6) + 1.0f) * 256.0f);
        goto L10
    }

    private float a(float r1) {
        return (float) Math.sin((r1 - 0.5f) * 0.47123894f);
    }

    public boolean a(View r10, boolean r11) {
        if (this.n == false) goto L24;
        boolean r0 = this.f35894a.computeScrollOffset();
        int r1 = this.f35894a.getCurrX();
        int r8 = this.f35894a.getCurrY();
        int r6 = r1 - r10.getLeft();
        int r7 = r8 - r10.getTop();
        if (r6 == 0) goto L7;
        ViewCompat.g(r10, r6);
    L7:
        if (r7 == 0) goto L9;
        ViewCompat.f(r10, r7);
    L9:
        if (r6 != 0) goto L11;
        if (r7 != 0) goto L11;
    L13:
        if (r0 == true) goto L15;
    L19:
        if (r0 == true) goto L24;
        if (r11 == false) goto L22;
        this.f.post(this.o);
        goto L24
    L22:
        this.n = false;
        goto L24
    L15:
        if (r1 != this.f35894a.getFinalX()) goto L19;
        if (r8 != this.f35894a.getFinalY()) goto L19;
        this.f35894a.abortAnimation();
        r0 = false;
    L11:
        this.f35895b.a(r10, r1, r8, r6, r7);
    L24:
        return this.n;
    }
}
