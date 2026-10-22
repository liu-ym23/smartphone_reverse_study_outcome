package com.bytedance.ai.view.popup.anim;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final InterpolatorC0718a f37871v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f37872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f37873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f37874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f37875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f37876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f37877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f37878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f37879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f37880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f37881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f37883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f37884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f37885n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f37886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OverScroller f37887p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f37888q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f37889r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f37890s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ViewGroup f37891t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f37892u;

    /* JADX INFO: renamed from: com.bytedance.ai.view.popup.anim.a$a, reason: collision with other inner class name */
    public class InterpolatorC0718a implements Interpolator {
        public InterpolatorC0718a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f37893a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f37893a.p(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100) {
            this.f37893a = r100;
        }
    }

    public static abstract class c {
        public c() {
        }
    }

    public final void b() {
        this.f37874c = -1;
        float[] r100 = this.f37875d;
        if (r100 == null) goto L6;
        Arrays.fill(r100, 0.0f);
        Arrays.fill(this.f37876e, 0.0f);
        Arrays.fill(this.f37877f, 0.0f);
        Arrays.fill(this.f37878g, 0.0f);
        Arrays.fill(this.f37879h, 0);
        Arrays.fill(this.f37880i, 0);
        Arrays.fill(this.f37881j, 0);
        this.f37882k = 0;
    L6:
        VelocityTracker r101 = this.f37883l;
        if (r101 == null) goto L10;
        r101.recycle();
        this.f37883l = null;
        return;
    }

    static {
        f37871v = new InterpolatorC0718a();
    }

    public final void l() {
        this.f37883l.computeCurrentVelocity(1000, this.f37884m);
        float r100 = this.f37883l.getXVelocity(this.f37874c);
        float r101 = this.f37885n;
        float r102 = this.f37884m;
        float r103 = Math.abs(r100);
        float r104 = 0.0f;
        if (r103 >= r101) goto L6;
        r100 = 0.0f;
    L11:
        float r105 = this.f37883l.getYVelocity(this.f37874c);
        float r106 = this.f37885n;
        float r107 = this.f37884m;
        float r108 = Math.abs(r105);
        if (r108 >= r106) goto L15;
    L21:
        h(r100, r104);
        return;
    L15:
        if (r108 > r107) goto L17;
    L20:
        r104 = r105;
        goto L21
    L17:
        if (r105 <= 0.0f) goto L19;
        r104 = r107;
        goto L21
    L19:
        r105 = -r107;
        goto L20
    L6:
        if (r103 <= r102) goto L11;
        if (r100 <= 0.0f) goto L10;
        r100 = r102;
        goto L11
    L10:
        r100 = -r102;
        goto L11
    }

    public final void f(int r100) {
        float[] r101 = this.f37875d;
        if (r101 == null) goto L12;
        int r102 = this.f37882k;
        boolean r103 = true;
        int r104 = 1 << r100;
        if ((r104 & r102) != 0) goto L8;
        r103 = false;
    L8:
        if (r103 == false) goto L13;
        r101[r100] = 0.0f;
        this.f37876e[r100] = 0.0f;
        this.f37877f[r100] = 0.0f;
        this.f37878g[r100] = 0.0f;
        this.f37879h[r100] = 0;
        this.f37880i[r100] = 0;
        this.f37881j[r100] = 0;
        this.f37882k = (~r104) & r102;
        return;
    L13:
        return;
    }

    public final void o(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        int r103 = r100.getPointerId(r102);
        boolean r104 = true;
        if ((this.f37882k & (1 << r103)) == 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L10;
        r104 = false;
    L10:
        if (r104 == false) goto L13;
        float r106 = r100.getX(r102);
        float r107 = r100.getY(r102);
        this.f37877f[r103] = r106;
        this.f37878g[r103] = r107;
    L13:
        r102 = r102 + 1;
        goto L3
    L7:
        r105 = false;
        goto L8
    }

    public final void p(int r100) {
        this.f37891t.removeCallbacks(this.f37892u);
        if (this.f37872a == r100) goto L14;
        this.f37872a = r100;
        BottomSheetBehavior.a r101 = (BottomSheetBehavior.a) this.f37888q;
        if (r100 != 1) goto L9;
        BottomSheetBehavior r102 = r101.f37866a;
        if (r102.f37852s == false) goto L11;
        r102.setStateInternal(1);
    L11:
        if (this.f37872a != 0) goto L15;
        this.f37889r = null;
        return;
    L15:
        return;
    L9:
        r101.getClass();
        goto L11
    }

    public final void c(View r100, int r101) {
        if (r100.getParent() != this.f37891t) goto L7;
        this.f37889r = r100;
        this.f37874c = r101;
        this.f37888q.getClass();
        p(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f37891t + ")");
    }

    public final boolean e(View r100, float r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.f37888q.getClass();
        BottomSheetBehavior r102 = ((BottomSheetBehavior.a) this.f37888q).f37866a;
        if (r102.f37850q == false) goto L8;
        int r103 = r102.f37833J;
    L10:
        if (r103 <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L15;
        return false;
    L15:
        if (Math.abs(r101) <= this.f37873b) goto L19;
        return true;
    L19:
        return false;
    L12:
        r104 = false;
        goto L13
    L8:
        r103 = r102.f37849p;
        goto L10
    }

    public final void h(float r110, float r111) {
        this.f37890s = true;
        c r100 = this.f37888q;
        View r101 = this.f37889r;
        BottomSheetBehavior.a r102 = (BottomSheetBehavior.a) r100;
        r102.getClass();
        int r103 = r101.getTop();
        int r104 = 3;
        if (r111 >= 0.0f) goto L23;
        BottomSheetBehavior r112 = r102.f37866a;
        if (r112.f37835b == false) goto L14;
        int r113 = r112.f37849p;
        if (r103 > r113) goto L9;
    L13:
        int r114 = r112.f37846m;
    L22:
        r113 = r114;
    L106:
        r102.f37866a.startSettlingAnimation(r101, r104, r113, true);
        this.f37890s = false;
        if (this.f37872a != 1) goto L110;
        p(0);
        return;
    L110:
        return;
    L9:
        if (r112.f37851r == true) goto L11;
    L20:
        r104 = 4;
        goto L106
    L11:
        if (r112.B != 4) goto L13;
    L14:
        r113 = r112.f37849p;
        if (r103 > r113) goto L17;
    L21:
        r114 = r112.f37843j;
        goto L22
    L17:
        if (r112.f37851r == false) goto L20;
        if (r112.B != 4) goto L21;
    L23:
        BottomSheetBehavior r105 = r102.f37866a;
        if (r105.f37850q == false) goto L68;
        if (r105.shouldHide(r101, r111) == false) goto L68;
        if (Math.abs(r110) >= Math.abs(r111)) goto L32;
        if (r111 <= 500.0f) goto L32;
    L42:
        r113 = r102.f37866a.f37833J;
        r104 = 5;
    L32:
        if (r102.f37866a.B != 3) goto L36;
        int r115 = r101.getTop();
        BottomSheetBehavior r116 = r102.f37866a;
        if ((r115 - r116.f37843j) < r116.A) goto L36;
    L39:
        boolean r117 = true;
    L41:
        if (r117 == true) goto L42;
        BottomSheetBehavior r118 = r102.f37866a;
        if (r118.f37835b == false) goto L57;
        if (r118.B == 3) goto L48;
        r113 = r118.f37849p;
        if ((r113 - r103) < r118.f37857x) goto L20;
        r114 = r118.f37846m;
        goto L22
    L48:
        if (r118.f37851r == true) goto L52;
        int r119 = Math.abs(r103 - r118.f37846m);
        BottomSheetBehavior r120 = r102.f37866a;
        if (r119 < r120.f37858y) goto L52;
        r113 = r120.f37849p;
    L52:
        r114 = r102.f37866a.f37846m;
        goto L22
    L57:
        if (r118.B == 3) goto L59;
        r113 = r118.f37849p;
        if ((r113 - r103) < r118.f37857x) goto L20;
        r114 = r118.f37843j;
        goto L22
    L59:
        if (r118.f37851r == true) goto L63;
        int r121 = Math.abs(r103 - r118.f37843j);
        BottomSheetBehavior r122 = r102.f37866a;
        if (r121 < r122.f37858y) goto L63;
        r113 = r122.f37849p;
    L63:
        r114 = r102.f37866a.f37843j;
    L36:
        if (r102.f37866a.B != 4) goto L40;
        int r123 = r101.getTop();
        BottomSheetBehavior r124 = r102.f37866a;
        if ((r123 - r124.f37849p) >= r124.f37859z) goto L39;
    L40:
        r117 = false;
    L68:
        if (r111 != 0.0f) goto L70;
    L82:
        BottomSheetBehavior r125 = r102.f37866a;
        if (r125.f37835b == false) goto L96;
        if (r125.B == 3) goto L87;
        r113 = r125.f37849p;
        if ((r113 - r103) < r125.f37857x) goto L20;
        r114 = r125.f37846m;
        goto L22
    L87:
        if (r125.f37851r == true) goto L91;
        int r126 = Math.abs(r103 - r125.f37846m);
        BottomSheetBehavior r127 = r102.f37866a;
        if (r126 < r127.f37858y) goto L91;
        r113 = r127.f37849p;
    L91:
        r114 = r102.f37866a.f37846m;
        goto L22
    L96:
        if (r125.B == 3) goto L98;
        r113 = r125.f37849p;
        if ((r113 - r103) < r125.f37857x) goto L20;
        r114 = r125.f37843j;
        goto L22
    L98:
        if (r125.f37851r == true) goto L102;
        int r128 = Math.abs(r103 - r125.f37843j);
        BottomSheetBehavior r129 = r102.f37866a;
        if (r128 < r129.f37858y) goto L102;
        r113 = r129.f37849p;
    L102:
        r114 = r102.f37866a.f37843j;
        goto L22
    L70:
        if (Math.abs(r110) > Math.abs(r111)) goto L82;
        BottomSheetBehavior r130 = r102.f37866a;
        if (r130.f37835b == false) goto L79;
        if (r130.f37851r == false) goto L77;
        r114 = r130.f37846m;
        goto L22
    L77:
        r113 = r130.f37849p;
        goto L20
    L79:
        if (r130.f37851r == false) goto L81;
        r114 = r130.f37843j;
        goto L22
    L81:
        r113 = r130.f37849p;
        goto L20
    }

    public final View j(int r100, int r101) {
        int r102 = this.f37891t.getChildCount() - 1;
    L3:
        if (r102 < 0) goto L14;
        ViewGroup r103 = this.f37891t;
        this.f37888q.getClass();
        View r104 = r103.getChildAt(r102);
        if (r100 < r104.getLeft()) goto L13;
        if (r100 >= r104.getRight()) goto L13;
        if (r101 < r104.getTop()) goto L13;
        if (r101 >= r104.getBottom()) goto L13;
        return r104;
    L13:
        r102 = r102 - 1;
        goto L3
    L14:
        return null;
    }

    public final boolean q(View r100, int r101) {
        if (r100 != this.f37889r) goto L8;
        if (this.f37874c != r101) goto L8;
        return true;
    L8:
        if (r100 == null) goto L36;
        BottomSheetBehavior.a r102 = (BottomSheetBehavior.a) this.f37888q;
        BottomSheetBehavior r103 = r102.f37866a;
        int r104 = r103.D;
        if (r104 != 1) goto L13;
    L32:
        boolean r105 = false;
    L33:
        if (r105 == false) goto L36;
        this.f37874c = r101;
        c(r100, r101);
        return true;
    L13:
        if (r103.R == true) goto L32;
        if (r104 == 3) goto L18;
    L27:
        WeakReference<V> r106 = r102.f37866a.K;
        if (r106 == 0) goto L32;
        if (r106.get() != r100) goto L32;
        r105 = true;
        goto L33
    L18:
        if (r103.O != r101) goto L27;
        WeakReference<View> r107 = r103.L;
        if (r107 == null) goto L22;
        View r108 = r107.get();
    L23:
        if (r108 == null) goto L27;
        if (r108.canScrollVertically(-1) == false) goto L27;
    L22:
        r108 = null;
    L36:
        return false;
    }

    public a(Context r100, ViewGroup r101, c r102) {
        this.f37874c = -1;
        this.f37892u = new b(this);
        if (r101 == null) goto L10;
        if (r102 == null) goto L8;
        this.f37891t = r101;
        this.f37888q = r102;
        ViewConfiguration r103 = ViewConfiguration.get(r100);
        Resources r104 = r100.getResources();
        this.f37886o = (int) ((WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 20.0f) + 0.5f);
        this.f37873b = r103.getScaledTouchSlop();
        this.f37884m = r103.getScaledMaximumFlingVelocity();
        this.f37885n = r103.getScaledMinimumFlingVelocity();
        this.f37887p = new OverScroller(r100, f37871v);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final int g(int r100, int r101, int r102) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        int r103 = this.f37891t.getWidth();
        float r104 = r103 / 2;
        float r105 = r104 + (((float) Math.sin((Math.min(1.0f, Math.abs(r100) / r103) - 0.5f) * 0.47123894f)) * r104);
        int r106 = Math.abs(r101);
        if (r106 <= 0) goto L8;
        int r107 = Math.round(Math.abs(r105 / r106) * 1000.0f) * 4;
    L10:
        return Math.min(r107, 600);
    L8:
        r107 = (int) (((Math.abs(r100) / r102) + 1.0f) * 256.0f);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final void m(float r100, float r101, int r102) {
        boolean r103 = d(r100, r101, r102, 1);
        ?? r104 = r103;
        if (d(r101, r100, r102, 4) == false) goto L5;
        r104 = (r103 ? 1 : 0) | 4;
    L5:
        ?? r105 = r104;
        if (d(r100, r101, r102, 2) == false) goto L8;
        r105 = (r104 == true ? 1 : 0) | 2;
    L8:
        ?? r106 = r105;
        if (d(r101, r100, r102, 8) == false) goto L11;
        r106 = (r105 == true ? 1 : 0) | 8;
    L11:
        if (r106 == 0) goto L14;
        int[] r107 = this.f37880i;
        r107[r102] = (r107[r102] | r106) == true ? 1 : 0;
        this.f37888q.getClass();
        return;
    }

    public final void n(float r110, float r111, int r112) {
        float[] r100 = this.f37875d;
        int r101 = 0;
        if (r100 != null) goto L5;
    L6:
        int r102 = r112 + 1;
        float[] r103 = new float[r102];
        float[] r104 = new float[r102];
        float[] r105 = new float[r102];
        float[] r106 = new float[r102];
        int[] r107 = new int[r102];
        int[] r108 = new int[r102];
        int[] r109 = new int[r102];
        if (r100 == null) goto L9;
        System.arraycopy(r100, 0, r103, 0, r100.length);
        float[] r113 = this.f37876e;
        System.arraycopy(r113, 0, r104, 0, r113.length);
        float[] r114 = this.f37877f;
        System.arraycopy(r114, 0, r105, 0, r114.length);
        float[] r115 = this.f37878g;
        System.arraycopy(r115, 0, r106, 0, r115.length);
        int[] r116 = this.f37879h;
        System.arraycopy(r116, 0, r107, 0, r116.length);
        int[] r117 = this.f37880i;
        System.arraycopy(r117, 0, r108, 0, r117.length);
        int[] r118 = this.f37881j;
        System.arraycopy(r118, 0, r109, 0, r118.length);
    L9:
        this.f37875d = r103;
        this.f37876e = r104;
        this.f37877f = r105;
        this.f37878g = r106;
        this.f37879h = r107;
        this.f37880i = r108;
        this.f37881j = r109;
    L10:
        float[] r119 = this.f37875d;
        this.f37877f[r112] = r110;
        r119[r112] = r110;
        float[] r120 = this.f37876e;
        this.f37878g[r112] = r111;
        r120[r112] = r111;
        int[] r121 = this.f37879h;
        int r122 = (int) r110;
        int r123 = (int) r111;
        if (r122 >= (this.f37891t.getLeft() + this.f37886o)) goto L14;
        r101 = 1;
    L14:
        if (r123 >= (this.f37891t.getTop() + this.f37886o)) goto L17;
        r101 = r101 | 4;
    L17:
        if (r122 <= (this.f37891t.getRight() - this.f37886o)) goto L20;
        r101 = r101 | 2;
    L20:
        if (r123 <= (this.f37891t.getBottom() - this.f37886o)) goto L22;
        r101 = r101 | 8;
    L22:
        r121[r112] = r101;
        this.f37882k |= 1 << r112;
        return;
    L5:
        if (r100.length > r112) goto L10;
        goto L6
    }

    public static boolean a(View r100, int r110, int r111, int r112) {
        if ((r100 instanceof ViewGroup) == false) goto L18;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r100.getScrollX();
        int r103 = r100.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L18;
        View r105 = r101.getChildAt(r104);
        int r106 = r111 + r102;
        if (r106 < r105.getLeft()) goto L17;
        if (r106 >= r105.getRight()) goto L17;
        int r107 = r112 + r103;
        if (r107 < r105.getTop()) goto L17;
        if (r107 >= r105.getBottom()) goto L17;
        if (a(r105, r110, r106 - r105.getLeft(), r107 - r105.getTop()) == false) goto L17;
        return true;
    L17:
        r104 = r104 - 1;
    L18:
        if (r110 == 0) goto L22;
        if (r100.canScrollHorizontally(-r110) == false) goto L22;
        return true;
    L22:
        if (r100.canScrollVertically(-1) == true) goto L34;
        return false;
    L34:
        return true;
    }

    public final boolean d(float r100, float r101, int r102, int r103) {
        float r104 = Math.abs(r100);
        float r105 = Math.abs(r101);
        if ((this.f37879h[r102] & r103) == r103) goto L5;
        return false;
    L5:
        if ((0 & r103) != 0) goto L7;
        return false;
    L7:
        if ((this.f37881j[r102] & r103) != r103) goto L9;
        return false;
    L9:
        if ((this.f37880i[r102] & r103) == r103) goto L27;
        int r106 = this.f37873b;
        if (r104 > r106) goto L16;
        if (r105 > r106) goto L16;
        return false;
    L16:
        if (r104 >= (r105 * 0.5f)) goto L19;
        this.f37888q.getClass();
    L19:
        if ((this.f37880i[r102] & r103) == 0) goto L21;
        return false;
    L21:
        if (r104 <= this.f37873b) goto L29;
        return true;
    L29:
        return false;
    L27:
        return false;
    }

    public final void i(int r100, int r101, int r102, int r103) {
        int r104 = this.f37889r.getLeft();
        int r105 = this.f37889r.getTop();
        if (r102 == 0) goto L5;
        c r106 = this.f37888q;
        View r107 = this.f37889r;
        ((BottomSheetBehavior.a) r106).getClass();
        int r108 = r107.getLeft();
        ViewCompat.offsetLeftAndRight(this.f37889r, r108 - r104);
    L5:
        if (r103 == 0) goto L11;
        BottomSheetBehavior.a r109 = (BottomSheetBehavior.a) this.f37888q;
        int r110 = r109.f37866a.getExpandedOffset();
        BottomSheetBehavior r111 = r109.f37866a;
        if (r111.f37850q == false) goto L9;
        int r112 = r111.f37833J;
    L10:
        r101 = MathUtils.clamp(r101, r110, r112);
        ViewCompat.offsetTopAndBottom(this.f37889r, r101 - r105);
        goto L11
    L9:
        r112 = r111.f37849p;
    L11:
        if (r102 != 0) goto L13;
        if (r103 != 0) goto L13;
        return;
    L13:
        ((BottomSheetBehavior.a) this.f37888q).f37866a.dispatchOnSlide(r101);
    }

    public final boolean k(int r110, int r111, int r112, int r113) {
        int r100 = this.f37889r.getLeft();
        int r101 = this.f37889r.getTop();
        int r102 = r110 - r100;
        int r103 = r111 - r101;
        if (r102 != 0) goto L7;
        if (r103 != 0) goto L7;
        this.f37887p.abortAnimation();
        p(0);
        return false;
    L7:
        int r114 = (int) this.f37885n;
        int r104 = (int) this.f37884m;
        int r105 = Math.abs(r112);
        if (r105 >= r114) goto L10;
        r112 = 0;
    L14:
        int r115 = (int) this.f37885n;
        int r106 = (int) this.f37884m;
        int r107 = Math.abs(r113);
        if (r107 >= r115) goto L17;
        r113 = 0;
    L21:
        int r116 = Math.abs(r102);
        int r108 = Math.abs(r103);
        int r109 = Math.abs(r112);
        int r117 = Math.abs(r113);
        int r118 = r109 + r117;
        int r119 = r116 + r108;
        if (r112 == 0) goto L24;
        float r120 = r109;
        float r121 = r118;
    L25:
        float r122 = r120 / r121;
        if (r113 == 0) goto L28;
        float r123 = r117;
        float r124 = r118;
    L29:
        float r125 = r123 / r124;
        this.f37888q.getClass();
        int r126 = g(r102, r112, 0);
        BottomSheetBehavior r127 = ((BottomSheetBehavior.a) this.f37888q).f37866a;
        if (r127.f37850q == false) goto L32;
        int r128 = r127.f37833J;
    L33:
        this.f37887p.startScroll(r100, r101, r102, r103, (int) ((r126 * r122) + (g(r103, r113, r128) * r125)));
        p(2);
        return true;
    L32:
        r128 = r127.f37849p;
        goto L33
    L28:
        r123 = r108;
        r124 = r119;
        goto L29
    L24:
        r120 = r116;
        r121 = r119;
        goto L25
    L17:
        if (r107 <= r106) goto L21;
        if (r113 <= 0) goto L20;
        r113 = r106;
        goto L21
    L20:
        r113 = -r106;
        goto L21
    L10:
        if (r105 <= r104) goto L14;
        if (r112 <= 0) goto L13;
        r112 = r104;
        goto L14
    L13:
        r112 = -r104;
        goto L14
    }
}
