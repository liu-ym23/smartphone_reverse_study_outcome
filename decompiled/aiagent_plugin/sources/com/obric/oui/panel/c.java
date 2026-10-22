package com.obric.oui.panel;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewDragHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f35906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f35907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f35908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f35909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f35910e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private OverScroller q;
    private final a r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private int v;
    private final Runnable x;

    /* JADX INFO: compiled from: ViewDragHelper.java */
    public static abstract class a {
        public int a(View r1) {
            return 0;
        }

        public int a(View r1, int r2, int r3) {
            return 0;
        }

        public void a(int r1) {
        }

        public void a(int r1, int r2) {
        }

        public void a(View r1, float r2, float r3) {
        }

        public void a(View r1, int r2, int r3, int r4, int r5) {
        }

        public abstract boolean a(View r1, int r2);

        public int b(View r1) {
            return 0;
        }

        public int b(View r1, int r2, int r3) {
            return 0;
        }

        public void b(int r1, int r2) {
        }

        public void b(View r1, int r2) {
        }

        public boolean b(int r1) {
            return false;
        }

        public int c(int r1) {
            return r1;
        }

        public a() {
        }
    }

    static {
        w = new ViewDragHelper$1();
    }

    public static c a(ViewGroup r4, a r5) {
        return new c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    private c(Context r3, ViewGroup r4, a r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f35908c = -1;
        this.v = 600;
        this.x = new AnonymousClass1(this);
        if (r4 == null) goto L10;
        if (r5 == null) goto L8;
        this.u = r4;
        this.r = r5;
        ViewConfiguration r7 = ViewConfiguration.get(r6);
        this.o = (int) ((ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f35907b = r7.getScaledTouchSlop();
        this.m = r7.getScaledMaximumFlingVelocity();
        this.n = r7.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(r6, w);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public void a(View r3, int r4) {
        if (r3.getParent() != this.u) goto L7;
        this.s = r3;
        this.f35908c = r4;
        this.r.b(r3, r4);
        b(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public int a() {
        return this.f35907b;
    }

    public void b() {
        this.f35908c = -1;
        d();
        VelocityTracker r0 = this.l;
        if (r0 == null) goto L6;
        r0.recycle();
        this.l = null;
        return;
    }

    public boolean a(View r1, int r2, int r3) {
        this.s = r1;
        this.f35908c = -1;
        boolean r4 = a(r2, r3, 0, 0);
        if (r4 == false) goto L5;
    L9:
        return r4;
    L5:
        if (this.f35906a != 0) goto L9;
        if (this.s == null) goto L9;
        this.s = null;
        goto L9
    }

    public boolean a(int r4, int r5) {
        if (this.t == false) goto L7;
        return a(r4, r5, (int) this.l.getXVelocity(this.f35908c), (int) this.l.getYVelocity(this.f35908c));
    L7:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean a(int r11, int r12, int r13, int r14) {
        int r2 = this.s.getLeft();
        int r3 = this.s.getTop();
        int r15 = r11 - r2;
        int r16 = r12 - r3;
        if (r15 != 0) goto L7;
        if (r16 != 0) goto L7;
        this.q.abortAnimation();
        b(0);
        return false;
    L7:
        int r6 = a(this.s, r15, r16, r13, r14);
        this.q.startScroll(r2, r3, r15, r16, r6);
        b(2);
        return true;
    }

    private int a(View r7, int r8, int r9, int r10, int r11) {
        int r12 = b(r10, (int) this.n, (int) this.m);
        int r13 = b(r11, (int) this.n, (int) this.m);
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
        return (int) ((a(r8, r12, this.r.b(r7)) * r15) + (a(r9, r13, this.r.a(r7)) * r18));
    L9:
        r16 = r1;
        r17 = r5;
        goto L10
    L5:
        r6 = r0;
        r14 = r5;
        goto L6
    }

    private int a(int r4, int r5, int r6) {
        if (r4 != 0) goto L5;
        return 0;
    L5:
        int r0 = this.u.getWidth();
        float r1 = r0 / 2;
        float r2 = r1 + (a(Math.min(1.0f, Math.abs(r4) / r0)) * r1);
        int r7 = Math.abs(r5);
        if (r7 <= 0) goto L8;
        int r8 = Math.round(Math.abs(r2 / r7) * 1000.0f) * 4;
    L10:
        return Math.min(r8, c());
    L8:
        r8 = (int) (((Math.abs(r4) / r6) + 1.0f) * 256.0f);
        goto L10
    }

    private int b(int r1, int r2, int r3) {
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

    private float a(float r1) {
        return (float) Math.sin((r1 - 0.5f) * 0.47123894f);
    }

    public boolean a(boolean r12) {
        if (this.f35906a != 2) goto L23;
        boolean r0 = this.q.computeScrollOffset();
        int r3 = this.q.getCurrX();
        int r10 = this.q.getCurrY();
        int r8 = r3 - this.s.getLeft();
        int r9 = r10 - this.s.getTop();
        if (r8 == 0) goto L7;
        ViewCompat.g(this.s, r8);
    L7:
        if (r9 == 0) goto L9;
        ViewCompat.f(this.s, r9);
    L9:
        if (r8 != 0) goto L11;
        if (r9 != 0) goto L11;
    L12:
        if (r0 == true) goto L14;
    L18:
        if (r0 == true) goto L23;
        if (r12 == false) goto L21;
        this.u.post(this.x);
        goto L23
    L21:
        b(0);
        goto L23
    L14:
        if (r3 != this.q.getFinalX()) goto L18;
        if (r10 != this.q.getFinalY()) goto L18;
        this.q.abortAnimation();
        r0 = false;
    L11:
        this.r.a(this.s, r3, r10, r8, r9);
    L23:
        if (this.f35906a != 2) goto L26;
        return true;
    L26:
        return false;
    }

    private void a(float r4, float r5) {
        this.t = true;
        this.r.a(this.s, r4, r5);
        this.t = false;
        if (this.f35906a != 1) goto L6;
        b(0);
        return;
    }

    private void d() {
        float[] r0 = this.f35909d;
        if (r0 != null) goto L5;
        return;
    L5:
        Arrays.fill(r0, 0.0f);
        Arrays.fill(this.f35910e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private void d(int r3) {
        if (this.f35909d != null) goto L5;
        return;
    L5:
        if (a(r3) == false) goto L10;
        this.f35909d[r3] = 0.0f;
        this.f35910e[r3] = 0.0f;
        this.f[r3] = 0.0f;
        this.g[r3] = 0.0f;
        this.h[r3] = 0;
        this.i[r3] = 0;
        this.j[r3] = 0;
        int r0 = this.k;
        this.k = (~(1 << r3)) & r0;
        return;
    }

    private void e(int r10) {
        float[] r0 = this.f35909d;
        if (r0 != null) goto L5;
    L6:
        int r11 = r10 + 1;
        float[] r1 = new float[r11];
        float[] r2 = new float[r11];
        float[] r3 = new float[r11];
        float[] r4 = new float[r11];
        int[] r5 = new int[r11];
        int[] r6 = new int[r11];
        int[] r12 = new int[r11];
        if (r0 == null) goto L9;
        System.arraycopy(r0, 0, r1, 0, r0.length);
        float[] r7 = this.f35910e;
        System.arraycopy(r7, 0, r2, 0, r7.length);
        float[] r8 = this.f;
        System.arraycopy(r8, 0, r3, 0, r8.length);
        float[] r9 = this.g;
        System.arraycopy(r9, 0, r4, 0, r9.length);
        int[] r13 = this.h;
        System.arraycopy(r13, 0, r5, 0, r13.length);
        int[] r14 = this.i;
        System.arraycopy(r14, 0, r6, 0, r14.length);
        int[] r15 = this.j;
        System.arraycopy(r15, 0, r12, 0, r15.length);
    L9:
        this.f35909d = r1;
        this.f35910e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r12;
        return;
    L5:
        if (r0.length <= r10) goto L6;
    }

    private void a(float r3, float r4, int r5) {
        e(r5);
        float[] r0 = this.f35909d;
        this.f[r5] = r3;
        r0[r5] = r3;
        float[] r1 = this.f35910e;
        this.g[r5] = r4;
        r1[r5] = r4;
        this.h[r5] = d((int) r3, (int) r4);
        this.k |= 1 << r5;
    }

    private void c(MotionEvent r7) {
        int r0 = r7.getPointerCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r7.getPointerId(r1);
        if (f(r2) == false) goto L8;
        float r3 = r7.getX(r1);
        float r4 = r7.getY(r1);
        this.f[r2] = r3;
        this.g[r2] = r4;
    L8:
        r1 = r1 + 1;
        goto L3
    }

    public boolean a(int r2) {
        if ((this.k & (1 << r2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    void b(int r3) {
        this.u.removeCallbacks(this.x);
        if (this.f35906a == r3) goto L8;
        this.f35906a = r3;
        this.r.a(r3);
        if (this.f35906a != 0) goto L9;
        this.s = null;
        return;
    L9:
        return;
    }

    boolean b(View r3, int r4) {
        if (r3 == this.s) goto L5;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (this.r.a(r3, r4) == false) goto L14;
        this.f35908c = r4;
        a(r3, r4);
        return true;
    L14:
        return false;
    L5:
        if (this.f35908c != r4) goto L7;
        return true;
    }

    public boolean a(MotionEvent r17) {
        int r2 = r17.getActionMasked();
        int r3 = r17.getActionIndex();
        if (r2 != 0) goto L6;
        b();
    L6:
        if (this.l != null) goto L8;
        this.l = VelocityTracker.obtain();
    L8:
        this.l.addMovement(r17);
        if (r2 == 0) goto L64;
        if (r2 == 1) goto L63;
        if (r2 == 2) goto L30;
        if (r2 == 3) goto L63;
        if (r2 != 5) goto L17;
        int r4 = r17.getPointerId(r3);
        float r7 = r17.getX(r3);
        float r1 = r17.getY(r3);
        a(r7, r1, r4);
        int r5 = this.f35906a;
        if (r5 != 0) goto L25;
        int r6 = this.h[r4];
        int r8 = this.p;
        if ((r6 & r8) != 0) goto L24;
    L18:
        boolean r9 = false;
    L73:
        if (this.f35906a == 1) goto L75;
        return r9;
    L75:
        return true;
    L24:
        this.r.a(r6 & r8, r4);
        goto L18
    L25:
        if (r5 != 2) goto L18;
        View r10 = c((int) r7, (int) r1);
        if (r10 != this.s) goto L18;
        b(r10, r4);
        goto L18
    L17:
        if (r2 != 6) goto L18;
        d(r17.getPointerId(r3));
        goto L18
    L30:
        if (this.f35909d == null) goto L18;
        if (this.f35910e == null) goto L18;
        int r11 = r17.getPointerCount();
        int r12 = 0;
    L35:
        if (r12 >= r11) goto L62;
        int r13 = r17.getPointerId(r12);
        if (f(r13) == false) goto L61;
        float r14 = r17.getX(r12);
        float r15 = r17.getY(r12);
        float r16 = r14 - this.f35909d[r13];
        float r18 = r15 - this.f35910e[r13];
        View r19 = c((int) r14, (int) r15);
        if (r19 != null) goto L42;
    L44:
        boolean r20 = false;
    L45:
        if (r20 == false) goto L54;
        int r110 = r19.getLeft();
        int r111 = (int) r16;
        int r112 = this.r.b(r19, r110 + r111, r111);
        int r113 = r19.getTop();
        int r114 = (int) r18;
        int r21 = this.r.a(r19, r113 + r114, r114);
        int r115 = this.r.b(r19);
        int r116 = this.r.a(r19);
        if (r115 == 0) goto L50;
        if (r115 <= 0) goto L54;
        if (r112 != r110) goto L54;
    L50:
        if (r116 == 0) goto L62;
        if (r116 <= 0) goto L54;
        if (r21 == r113) goto L62;
    L54:
        b(r16, r18, r13);
        if (this.f35906a == 1) goto L62;
        if (r20 == false) goto L61;
        if (b(r19, r13) == false) goto L61;
    L42:
        if (a(r19, r16, r18) == false) goto L44;
        r20 = true;
    L61:
        r12 = r12 + 1;
    L62:
        c(r17);
    L63:
        b();
        goto L18
    L64:
        float r22 = r17.getX();
        float r23 = r17.getY();
        r9 = false;
        int r24 = r17.getPointerId(0);
        a(r22, r23, r24);
        View r25 = c((int) r22, (int) r23);
        if (r25 == this.s) goto L67;
    L69:
        int r26 = this.h[r24];
        int r27 = this.p;
        if ((r26 & r27) == 0) goto L73;
        this.r.a(r26 & r27, r24);
        goto L73
    L67:
        if (this.f35906a != 2) goto L69;
        b(r25, r24);
        goto L69
    }

    public void b(MotionEvent r10) {
        int r0 = r10.getActionMasked();
        int r1 = r10.getActionIndex();
        if (r0 != 0) goto L6;
        b();
    L6:
        if (this.l != null) goto L8;
        this.l = VelocityTracker.obtain();
    L8:
        this.l.addMovement(r10);
        int r2 = 0;
        if (r0 != 0) goto L11;
        float r3 = r10.getX();
        float r4 = r10.getY();
        int r11 = r10.getPointerId(0);
        View r5 = c((int) r3, (int) r4);
        a(r3, r4, r11);
        b(r5, r11);
        int r6 = this.h[r11];
        int r7 = this.p;
        if ((r6 & r7) == 0) goto L102;
        this.r.a(r6 & r7, r11);
        return;
    L102:
        return;
    L11:
        if (r0 == 1) goto L75;
        if (r0 == 2) goto L54;
        if (r0 == 3) goto L50;
        if (r0 != 5) goto L19;
        int r8 = r10.getPointerId(r1);
        float r9 = r10.getX(r1);
        float r12 = r10.getY(r1);
        a(r9, r12, r8);
        if (this.f35906a != 0) goto L47;
        b(c((int) r9, (int) r12), r8);
        int r13 = this.h[r8];
        int r14 = this.p;
        if ((r13 & r14) == 0) goto L94;
        this.r.a(r13 & r14, r8);
        return;
    L94:
        return;
    L47:
        if (b((int) r9, (int) r12) == false) goto L96;
        b(this.s, r8);
        return;
    L96:
        return;
    L19:
        if (r0 != 6) goto L103;
        int r15 = r10.getPointerId(r1);
        if (this.f35906a == 1) goto L24;
    L40:
        d(r15);
        return;
    L24:
        if (r15 != this.f35908c) goto L40;
        int r16 = r10.getPointerCount();
    L27:
        if (r2 >= r16) goto L37;
        int r17 = r10.getPointerId(r2);
        if (r17 == this.f35908c) goto L36;
        View r18 = c((int) r10.getX(r2), (int) r10.getY(r2));
        View r19 = this.s;
        if (r18 != r19) goto L36;
        if (b(r19, r17) == false) goto L36;
        int r110 = this.f35908c;
    L38:
        if (r110 != (-1)) goto L40;
        e();
    L36:
        r2 = r2 + 1;
        goto L27
    L37:
        r110 = -1;
        goto L38
    L103:
        return;
    L50:
        if (this.f35906a != 1) goto L52;
        a(0.0f, 0.0f);
    L52:
        b();
        return;
    L54:
        if (this.f35906a == 1) goto L56;
        int r20 = r10.getPointerCount();
    L60:
        if (r2 >= r20) goto L73;
        int r21 = r10.getPointerId(r2);
        if (f(r21) == false) goto L72;
        float r22 = r10.getX(r2);
        float r23 = r10.getY(r2);
        float r24 = r22 - this.f35909d[r21];
        float r25 = r23 - this.f35910e[r21];
        b(r24, r25, r21);
        if (this.f35906a == 1) goto L73;
        View r26 = c((int) r22, (int) r23);
        if (a(r26, r24, r25) == false) goto L72;
        if (b(r26, r21) == true) goto L73;
    L72:
        r2 = r2 + 1;
    L73:
        c(r10);
        return;
    L56:
        if (f(this.f35908c) == false) goto L104;
        int r27 = r10.findPointerIndex(this.f35908c);
        float r28 = r10.getX(r27);
        float r29 = r10.getY(r27);
        float[] r30 = this.f;
        int r31 = this.f35908c;
        int r32 = (int) (r28 - r30[r31]);
        int r33 = (int) (r29 - this.g[r31]);
        b(this.s.getLeft() + r32, this.s.getTop() + r33, r32, r33);
        c(r10);
        return;
    L104:
        return;
    L75:
        if (this.f35906a != 1) goto L77;
        e();
    L77:
        b();
    }

    private void b(float r3, float r4, int r5) {
        int r0 = 1;
        if (a(r3, r4, r5, 1) == true) goto L7;
        r0 = 0;
    L7:
        if (a(r4, r3, r5, 4) == false) goto L10;
        r0 = r0 | 4;
    L10:
        if (a(r3, r4, r5, 2) == false) goto L13;
        r0 = r0 | 2;
    L13:
        if (a(r4, r3, r5, 8) == false) goto L15;
        r0 = r0 | 8;
    L15:
        if (r0 == 0) goto L18;
        int[] r6 = this.i;
        r6[r5] = r6[r5] | r0;
        this.r.b(r0, r5);
        return;
    }

    private boolean a(float r4, float r5, int r6, int r7) {
        float r8 = Math.abs(r4);
        float r9 = Math.abs(r5);
        if ((this.h[r6] & r7) == r7) goto L5;
        return false;
    L5:
        if ((this.p & r7) != 0) goto L7;
        return false;
    L7:
        if ((this.j[r6] & r7) != r7) goto L9;
        return false;
    L9:
        if ((this.i[r6] & r7) == r7) goto L30;
        int r0 = this.f35907b;
        if (r8 > r0) goto L16;
        if (r9 > r0) goto L16;
        return false;
    L16:
        if (r8 >= (r9 * 0.5f)) goto L22;
        if (this.r.b(r7) == false) goto L22;
        int[] r3 = this.j;
        r3[r6] = r3[r6] | r7;
        return false;
    L22:
        if ((this.i[r6] & r7) == 0) goto L24;
        return false;
    L24:
        if (r8 <= this.f35907b) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    }

    private boolean a(View r5, float r6, float r7) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.r.b(r5) <= 0) goto L8;
        boolean r1 = true;
    L10:
        if (this.r.a(r5) <= 0) goto L12;
        boolean r8 = true;
    L13:
        if (r1 == false) goto L19;
        if (r8 == false) goto L19;
        float r9 = (r6 * r6) + (r7 * r7);
        int r4 = this.f35907b;
        if (r9 > (r4 * r4)) goto L18;
        return false;
    L18:
        return true;
    L19:
        if (r1 == true) goto L21;
        if (r8 == true) goto L26;
        return false;
    L26:
        if (Math.abs(r7) > this.f35907b) goto L28;
        return false;
    L28:
        return true;
    L21:
        if (Math.abs(r6) > this.f35907b) goto L23;
        return false;
    L23:
        return true;
    L12:
        r8 = false;
        goto L13
    L8:
        r1 = false;
        goto L10
    }

    private void e() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(this.l.getXVelocity(this.f35908c), this.n, this.m), a(this.l.getYVelocity(this.f35908c), this.n, this.m));
    }

    private void b(int r11, int r12, int r13, int r14) {
        int r0 = this.s.getLeft();
        int r1 = this.s.getTop();
        if (r13 == 0) goto L5;
        r11 = this.r.b(this.s, r11, r13);
        ViewCompat.g(this.s, r11 - r0);
    L5:
        int r6 = r11;
        if (r14 == 0) goto L8;
        r12 = this.r.a(this.s, r12, r14);
        ViewCompat.f(this.s, r12 - r1);
    L8:
        int r7 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        a r4 = this.r;
        View r5 = this.s;
        r4.a(r5, r6, r7, r6 - r0, r7 - r1);
    }

    public boolean b(int r2, int r3) {
        return b(this.s, r2, r3);
    }

    public boolean b(View r2, int r3, int r4) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r3 >= r2.getLeft()) goto L8;
        return false;
    L8:
        if (r3 < r2.getRight()) goto L10;
        return false;
    L10:
        if (r4 >= r2.getTop()) goto L12;
        return false;
    L12:
        if (r4 >= r2.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    public View c(int r4, int r5) {
        int r0 = this.u.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L14;
        View r1 = this.u.getChildAt(this.r.c(r0));
        if (r4 < r1.getLeft()) goto L13;
        if (r4 >= r1.getRight()) goto L13;
        if (r5 < r1.getTop()) goto L13;
        if (r5 >= r1.getBottom()) goto L13;
        return r1;
    L13:
        r0 = r0 - 1;
        goto L3
    L14:
        return null;
    }

    private int d(int r4, int r5) {
        if (r4 >= (this.u.getLeft() + this.o)) goto L5;
        int r0 = 1;
    L7:
        if (r5 >= (this.u.getTop() + this.o)) goto L10;
        r0 = r0 | 4;
    L10:
        if (r4 <= (this.u.getRight() - this.o)) goto L13;
        r0 = r0 | 2;
    L13:
        if (r5 > (this.u.getBottom() - this.o)) goto L15;
        return r0;
    L15:
        return r0 | 8;
    L5:
        r0 = 0;
        goto L7
    }

    private boolean f(int r2) {
        if (a(r2) == true) goto L6;
        a(TAG, "Ignoring pointerId=" + r2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    L6:
        return true;
    }

    public int c() {
        return this.v;
    }

    public void c(int r1) {
        this.v = r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
