package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Interpolator f2854x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f2858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f2859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f2860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f2861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f2862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f2863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f2864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f2866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f2867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f2868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f2870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2871q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OverScroller f2872r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f2873s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f2874t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2875u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f2876v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f2877w;

    public class a implements Interpolator {
        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = r10 - 1.0f;
            return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
        }
    }

    /* JADX INFO: renamed from: androidx.customview.widget.b$b, reason: collision with other inner class name */
    public class RunnableC0025b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f2878a;

        public RunnableC0025b(b r10) {
            this.f2878a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2878a.K(0);
        }
    }

    public static abstract class c {
        public c() {
        }

        public abstract int clampViewPositionHorizontal(View r10, int r11, int r12);

        public int clampViewPositionVertical(View r10, int r11, int r12) {
            return 0;
        }

        public int getOrderedChildIndex(int r10) {
            return r10;
        }

        public int getViewHorizontalDragRange(@NonNull View r10) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View r10) {
            return 0;
        }

        public void onEdgeDragStarted(int r10, int r11) {
        }

        public boolean onEdgeLock(int r10) {
            return false;
        }

        public void onEdgeTouched(int r10, int r11) {
        }

        public void onViewCaptured(@NonNull View r10, int r11) {
        }

        public void onViewDragStateChanged(int r10) {
        }

        public void onViewPositionChanged(View r10, int r11, int r12, int r13, int r14) {
        }

        public void onViewReleased(View r10, float r11, float r12) {
        }

        public abstract boolean tryCaptureView(View r10, int r11);
    }

    static {
        f2854x = new a();
    }

    public b(Context r10, ViewGroup r11, c r12) {
        this.f2857c = -1;
        this.f2877w = new RunnableC0025b(this);
        if (r11 == null) goto L10;
        if (r12 == null) goto L8;
        this.f2876v = r11;
        this.f2873s = r12;
        ViewConfiguration r13 = ViewConfiguration.get(r10);
        int r14 = (int) ((r10.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f2870p = r14;
        this.f2869o = r14;
        this.f2856b = r13.getScaledTouchSlop();
        this.f2867m = r13.getScaledMaximumFlingVelocity();
        this.f2868n = r13.getScaledMinimumFlingVelocity();
        this.f2872r = new OverScroller(r10, f2854x);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public static b o(ViewGroup r10, float r11, c r12) {
        b r13 = p(r10, r12);
        r13.f2856b = (int) (r13.f2856b * (1.0f / r11));
        return r13;
    }

    public static b p(ViewGroup r10, c r11) {
        return new b(r10.getContext(), r10, r11);
    }

    private void saveLastMotion(MotionEvent r10) {
        int r11 = r10.getPointerCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        int r13 = r10.getPointerId(r12);
        if (F(r13) == false) goto L8;
        float r14 = r10.getX(r12);
        float r15 = r10.getY(r12);
        this.f2860f[r13] = r14;
        this.f2861g[r13] = r15;
    L8:
        r12 = r12 + 1;
        goto L3
    }

    public float A() {
        return this.f2868n;
    }

    public int B() {
        return this.f2856b;
    }

    public int C() {
        return this.f2855a;
    }

    public boolean D(int r10, int r11) {
        return G(this.f2874t, r10, r11);
    }

    public boolean E(int r10) {
        if ((this.f2865k & (1 << r10)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean F(int r10) {
        if (E(r10) == true) goto L6;
        Log.e("ViewDragHelper", "Ignoring pointerId=" + r10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    L6:
        return true;
    }

    public boolean G(View r10, int r11, int r12) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r11 >= r10.getLeft()) goto L8;
        return false;
    L8:
        if (r11 < r10.getRight()) goto L10;
        return false;
    L10:
        if (r12 >= r10.getTop()) goto L12;
        return false;
    L12:
        if (r12 >= r10.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    public final void H() {
        this.f2866l.computeCurrentVelocity(1000, this.f2867m);
        q(h(this.f2866l.getXVelocity(this.f2857c), this.f2868n, this.f2867m), h(this.f2866l.getYVelocity(this.f2857c), this.f2868n, this.f2867m));
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
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.customview.widget.b$c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void I(float r10, float r11, int r12) {
        boolean r13 = d(r10, r11, r12, 1);
        ?? r14 = r13;
        if (d(r11, r10, r12, 4) == false) goto L5;
        r14 = (r13 ? 1 : 0) | 4;
    L5:
        ?? r15 = r14;
        if (d(r10, r11, r12, 2) == false) goto L8;
        r15 = (r14 == true ? 1 : 0) | 2;
    L8:
        ?? r16 = r15;
        if (d(r11, r10, r12, 8) == false) goto L11;
        r16 = (r15 == true ? 1 : 0) | 8;
    L11:
        if (r16 == 0) goto L14;
        int[] r17 = this.f2863i;
        r17[r12] = (r17[r12] | r16) == true ? 1 : 0;
        this.f2873s.onEdgeDragStarted(r16, r12);
        return;
    }

    public final void J(float r10, float r11, int r12) {
        t(r12);
        float[] r13 = this.f2858d;
        this.f2860f[r12] = r10;
        r13[r12] = r10;
        float[] r14 = this.f2859e;
        this.f2861g[r12] = r11;
        r14[r12] = r11;
        this.f2862h[r12] = z((int) r10, (int) r11);
        this.f2865k |= 1 << r12;
    }

    public void K(int r10) {
        this.f2876v.removeCallbacks(this.f2877w);
        if (this.f2855a == r10) goto L8;
        this.f2855a = r10;
        this.f2873s.onViewDragStateChanged(r10);
        if (this.f2855a != 0) goto L9;
        this.f2874t = null;
        return;
    L9:
        return;
    }

    public void L(int r10) {
        this.f2869o = r10;
    }

    public void M(int r10) {
        this.f2871q = r10;
    }

    public void N(float r10) {
        this.f2868n = r10;
    }

    public boolean O(int r10, int r11) {
        if (this.f2875u == false) goto L7;
        return v(r10, r11, (int) this.f2866l.getXVelocity(this.f2857c), (int) this.f2866l.getYVelocity(this.f2857c));
    L7:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean P(MotionEvent r17) {
        int r10 = r17.getActionMasked();
        int r11 = r17.getActionIndex();
        if (r10 != 0) goto L6;
        b();
    L6:
        if (this.f2866l != null) goto L8;
        this.f2866l = VelocityTracker.obtain();
    L8:
        this.f2866l.addMovement(r17);
        if (r10 == 0) goto L64;
        if (r10 == 1) goto L63;
        if (r10 == 2) goto L30;
        if (r10 == 3) goto L63;
        if (r10 != 5) goto L17;
        int r12 = r17.getPointerId(r11);
        float r13 = r17.getX(r11);
        float r14 = r17.getY(r11);
        J(r13, r14, r12);
        int r15 = this.f2855a;
        if (r15 != 0) goto L25;
        int r16 = this.f2862h[r12];
        int r18 = this.f2871q;
        if ((r16 & r18) != 0) goto L24;
    L18:
        boolean r19 = false;
    L73:
        if (this.f2855a == 1) goto L75;
        return r19;
    L75:
        return true;
    L24:
        this.f2873s.onEdgeTouched(r16 & r18, r12);
        goto L18
    L25:
        if (r15 != 2) goto L18;
        View r20 = u((int) r13, (int) r14);
        if (r20 != this.f2874t) goto L18;
        R(r20, r12);
        goto L18
    L17:
        if (r10 != 6) goto L18;
        k(r17.getPointerId(r11));
        goto L18
    L30:
        if (this.f2858d == null) goto L18;
        if (this.f2859e == null) goto L18;
        int r21 = r17.getPointerCount();
        int r22 = 0;
    L35:
        if (r22 >= r21) goto L62;
        int r23 = r17.getPointerId(r22);
        if (F(r23) == false) goto L61;
        float r24 = r17.getX(r22);
        float r25 = r17.getY(r22);
        float r26 = r24 - this.f2858d[r23];
        float r110 = r25 - this.f2859e[r23];
        View r27 = u((int) r24, (int) r25);
        if (r27 != null) goto L42;
    L44:
        boolean r28 = false;
    L45:
        if (r28 == false) goto L54;
        int r111 = r27.getLeft();
        int r112 = (int) r26;
        int r113 = this.f2873s.clampViewPositionHorizontal(r27, r111 + r112, r112);
        int r114 = r27.getTop();
        int r115 = (int) r110;
        int r29 = this.f2873s.clampViewPositionVertical(r27, r114 + r115, r115);
        int r116 = this.f2873s.getViewHorizontalDragRange(r27);
        int r117 = this.f2873s.getViewVerticalDragRange(r27);
        if (r116 == 0) goto L50;
        if (r116 <= 0) goto L54;
        if (r113 != r111) goto L54;
    L50:
        if (r117 == 0) goto L62;
        if (r117 <= 0) goto L54;
        if (r29 == r114) goto L62;
    L54:
        I(r26, r110, r23);
        if (this.f2855a == 1) goto L62;
        if (r28 == false) goto L61;
        if (R(r27, r23) == false) goto L61;
    L42:
        if (g(r27, r26, r110) == false) goto L44;
        r28 = true;
    L61:
        r22 = r22 + 1;
    L62:
        saveLastMotion(r17);
    L63:
        b();
        goto L18
    L64:
        float r30 = r17.getX();
        float r31 = r17.getY();
        r19 = false;
        int r32 = r17.getPointerId(0);
        J(r30, r31, r32);
        View r33 = u((int) r30, (int) r31);
        if (r33 == this.f2874t) goto L67;
    L69:
        int r34 = this.f2862h[r32];
        int r35 = this.f2871q;
        if ((r34 & r35) == 0) goto L73;
        this.f2873s.onEdgeTouched(r34 & r35, r32);
        goto L73
    L67:
        if (this.f2855a != 2) goto L69;
        R(r33, r32);
        goto L69
    }

    public boolean Q(View r10, int r11, int r12) {
        this.f2874t = r10;
        this.f2857c = -1;
        boolean r13 = v(r11, r12, 0, 0);
        if (r13 == false) goto L5;
    L9:
        return r13;
    L5:
        if (this.f2855a != 0) goto L9;
        if (this.f2874t == null) goto L9;
        this.f2874t = null;
        goto L9
    }

    public boolean R(View r10, int r11) {
        if (r10 == this.f2874t) goto L5;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (this.f2873s.tryCaptureView(r10, r11) == false) goto L14;
        this.f2857c = r11;
        c(r10, r11);
        return true;
    L14:
        return false;
    L5:
        if (this.f2857c != r11) goto L7;
        return true;
    }

    public void a() {
        b();
        if (this.f2855a != 2) goto L5;
        int r10 = this.f2872r.getCurrX();
        int r11 = this.f2872r.getCurrY();
        this.f2872r.abortAnimation();
        int r12 = this.f2872r.getCurrX();
        int r13 = this.f2872r.getCurrY();
        this.f2873s.onViewPositionChanged(this.f2874t, r12, r13, r12 - r10, r13 - r11);
    L5:
        K(0);
    }

    public void b() {
        this.f2857c = -1;
        j();
        VelocityTracker r10 = this.f2866l;
        if (r10 == null) goto L6;
        r10.recycle();
        this.f2866l = null;
        return;
    }

    public void c(View r10, int r11) {
        if (r10.getParent() != this.f2876v) goto L7;
        this.f2874t = r10;
        this.f2857c = r11;
        this.f2873s.onViewCaptured(r10, r11);
        K(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f2876v + ")");
    }

    public final boolean d(float r10, float r11, int r12, int r13) {
        float r14 = Math.abs(r10);
        float r15 = Math.abs(r11);
        if ((this.f2862h[r12] & r13) == r13) goto L5;
        return false;
    L5:
        if ((this.f2871q & r13) != 0) goto L7;
        return false;
    L7:
        if ((this.f2864j[r12] & r13) != r13) goto L9;
        return false;
    L9:
        if ((this.f2863i[r12] & r13) == r13) goto L30;
        int r16 = this.f2856b;
        if (r14 > r16) goto L16;
        if (r15 > r16) goto L16;
        return false;
    L16:
        if (r14 >= (r15 * 0.5f)) goto L22;
        if (this.f2873s.onEdgeLock(r13) == false) goto L22;
        int[] r17 = this.f2864j;
        r17[r12] = r17[r12] | r13;
        return false;
    L22:
        if ((this.f2863i[r12] & r13) == 0) goto L24;
        return false;
    L24:
        if (r14 <= this.f2856b) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    }

    public boolean e(int r10) {
        int r11 = this.f2858d.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (f(r10, r12) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean f(int r10, int r11) {
        if (E(r11) == true) goto L6;
        return false;
    L6:
        if ((r10 & 1) != 1) goto L8;
        boolean r12 = true;
    L10:
        if ((r10 & 2) != 2) goto L12;
        boolean r13 = true;
    L13:
        float r14 = this.f2860f[r11] - this.f2858d[r11];
        float r15 = this.f2861g[r11] - this.f2859e[r11];
        if (r12 == false) goto L20;
        if (r13 == false) goto L20;
        float r16 = (r14 * r14) + (r15 * r15);
        int r17 = this.f2856b;
        if (r16 > (r17 * r17)) goto L19;
        return false;
    L19:
        return true;
    L20:
        if (r12 == true) goto L22;
        if (r13 == true) goto L27;
        return false;
    L27:
        if (Math.abs(r15) > this.f2856b) goto L29;
        return false;
    L29:
        return true;
    L22:
        if (Math.abs(r14) > this.f2856b) goto L24;
        return false;
    L24:
        return true;
    L12:
        r13 = false;
        goto L13
    L8:
        r12 = false;
        goto L10
    }

    public final boolean g(View r10, float r11, float r12) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (this.f2873s.getViewHorizontalDragRange(r10) <= 0) goto L8;
        boolean r13 = true;
    L10:
        if (this.f2873s.getViewVerticalDragRange(r10) <= 0) goto L12;
        boolean r14 = true;
    L13:
        if (r13 == false) goto L19;
        if (r14 == false) goto L19;
        float r15 = (r11 * r11) + (r12 * r12);
        int r16 = this.f2856b;
        if (r15 > (r16 * r16)) goto L18;
        return false;
    L18:
        return true;
    L19:
        if (r13 == true) goto L21;
        if (r14 == true) goto L26;
        return false;
    L26:
        if (Math.abs(r12) > this.f2856b) goto L28;
        return false;
    L28:
        return true;
    L21:
        if (Math.abs(r11) > this.f2856b) goto L23;
        return false;
    L23:
        return true;
    L12:
        r14 = false;
        goto L13
    L8:
        r13 = false;
        goto L10
    }

    public final float h(float r10, float r11, float r12) {
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

    public final int i(int r10, int r11, int r12) {
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

    public final void j() {
        float[] r10 = this.f2858d;
        if (r10 != null) goto L5;
        return;
    L5:
        Arrays.fill(r10, 0.0f);
        Arrays.fill(this.f2859e, 0.0f);
        Arrays.fill(this.f2860f, 0.0f);
        Arrays.fill(this.f2861g, 0.0f);
        Arrays.fill(this.f2862h, 0);
        Arrays.fill(this.f2863i, 0);
        Arrays.fill(this.f2864j, 0);
        this.f2865k = 0;
    }

    public final void k(int r10) {
        if (this.f2858d != null) goto L5;
        return;
    L5:
        if (E(r10) == false) goto L10;
        this.f2858d[r10] = 0.0f;
        this.f2859e[r10] = 0.0f;
        this.f2860f[r10] = 0.0f;
        this.f2861g[r10] = 0.0f;
        this.f2862h[r10] = 0;
        this.f2863i[r10] = 0;
        this.f2864j[r10] = 0;
        int r11 = this.f2865k;
        this.f2865k = (~(1 << r10)) & r11;
        return;
    }

    public final int l(int r10, int r11, int r12) {
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r13 = this.f2876v.getWidth();
        float r14 = r13 / 2;
        float r15 = r14 + (r(Math.min(1.0f, Math.abs(r10) / r13)) * r14);
        int r16 = Math.abs(r11);
        if (r16 <= 0) goto L8;
        int r17 = Math.round(Math.abs(r15 / r16) * 1000.0f) * 4;
    L10:
        return Math.min(r17, 600);
    L8:
        r17 = (int) (((Math.abs(r10) / r12) + 1.0f) * 256.0f);
        goto L10
    }

    public final int m(View r10, int r11, int r12, int r13, int r14) {
        int r15 = i(r13, (int) this.f2868n, (int) this.f2867m);
        int r16 = i(r14, (int) this.f2868n, (int) this.f2867m);
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
        return (int) ((l(r11, r15, this.f2873s.getViewHorizontalDragRange(r10)) * r25) + (l(r12, r16, this.f2873s.getViewVerticalDragRange(r10)) * r28));
    L10:
        r26 = r18;
        r27 = r22;
        goto L9
    L6:
        r23 = r17;
        r24 = r22;
        goto L5
    }

    public boolean n(boolean r12) {
        if (this.f2855a != 2) goto L23;
        boolean r10 = this.f2872r.computeScrollOffset();
        int r11 = this.f2872r.getCurrX();
        int r13 = this.f2872r.getCurrY();
        int r14 = r11 - this.f2874t.getLeft();
        int r15 = r13 - this.f2874t.getTop();
        if (r14 == 0) goto L7;
        ViewCompat.Z(this.f2874t, r14);
    L7:
        if (r15 == 0) goto L9;
        ViewCompat.a0(this.f2874t, r15);
    L9:
        if (r14 != 0) goto L11;
        if (r15 != 0) goto L11;
    L12:
        if (r10 == true) goto L14;
    L18:
        if (r10 == true) goto L23;
        if (r12 == false) goto L21;
        this.f2876v.post(this.f2877w);
        goto L23
    L21:
        K(0);
        goto L23
    L14:
        if (r11 != this.f2872r.getFinalX()) goto L18;
        if (r13 != this.f2872r.getFinalY()) goto L18;
        this.f2872r.abortAnimation();
        r10 = false;
    L11:
        this.f2873s.onViewPositionChanged(this.f2874t, r11, r13, r14, r15);
    L23:
        if (this.f2855a != 2) goto L26;
        return true;
    L26:
        return false;
    }

    public void processTouchEvent(@NonNull MotionEvent r10) {
        int r11 = r10.getActionMasked();
        int r12 = r10.getActionIndex();
        if (r11 != 0) goto L6;
        b();
    L6:
        if (this.f2866l != null) goto L8;
        this.f2866l = VelocityTracker.obtain();
    L8:
        this.f2866l.addMovement(r10);
        int r13 = 0;
        if (r11 != 0) goto L11;
        float r14 = r10.getX();
        float r15 = r10.getY();
        int r16 = r10.getPointerId(0);
        View r17 = u((int) r14, (int) r15);
        J(r14, r15, r16);
        R(r17, r16);
        int r18 = this.f2862h[r16];
        int r19 = this.f2871q;
        if ((r18 & r19) == 0) goto L102;
        this.f2873s.onEdgeTouched(r18 & r19, r16);
        return;
    L102:
        return;
    L11:
        if (r11 == 1) goto L75;
        if (r11 == 2) goto L54;
        if (r11 == 3) goto L50;
        if (r11 != 5) goto L19;
        int r20 = r10.getPointerId(r12);
        float r21 = r10.getX(r12);
        float r110 = r10.getY(r12);
        J(r21, r110, r20);
        if (this.f2855a != 0) goto L47;
        R(u((int) r21, (int) r110), r20);
        int r111 = this.f2862h[r20];
        int r22 = this.f2871q;
        if ((r111 & r22) == 0) goto L94;
        this.f2873s.onEdgeTouched(r111 & r22, r20);
        return;
    L94:
        return;
    L47:
        if (D((int) r21, (int) r110) == false) goto L96;
        R(this.f2874t, r20);
        return;
    L96:
        return;
    L19:
        if (r11 != 6) goto L103;
        int r23 = r10.getPointerId(r12);
        if (this.f2855a == 1) goto L24;
    L40:
        k(r23);
        return;
    L24:
        if (r23 != this.f2857c) goto L40;
        int r24 = r10.getPointerCount();
    L27:
        if (r13 >= r24) goto L37;
        int r25 = r10.getPointerId(r13);
        if (r25 == this.f2857c) goto L36;
        View r26 = u((int) r10.getX(r13), (int) r10.getY(r13));
        View r27 = this.f2874t;
        if (r26 != r27) goto L36;
        if (R(r27, r25) == false) goto L36;
        int r112 = this.f2857c;
    L38:
        if (r112 != (-1)) goto L40;
        H();
    L36:
        r13 = r13 + 1;
        goto L27
    L37:
        r112 = -1;
        goto L38
    L103:
        return;
    L50:
        if (this.f2855a != 1) goto L52;
        q(0.0f, 0.0f);
    L52:
        b();
        return;
    L54:
        if (this.f2855a == 1) goto L56;
        int r28 = r10.getPointerCount();
    L60:
        if (r13 >= r28) goto L73;
        int r29 = r10.getPointerId(r13);
        if (F(r29) == false) goto L72;
        float r30 = r10.getX(r13);
        float r31 = r10.getY(r13);
        float r32 = r30 - this.f2858d[r29];
        float r33 = r31 - this.f2859e[r29];
        I(r32, r33, r29);
        if (this.f2855a == 1) goto L73;
        View r34 = u((int) r30, (int) r31);
        if (g(r34, r32, r33) == false) goto L72;
        if (R(r34, r29) == true) goto L73;
    L72:
        r13 = r13 + 1;
    L73:
        saveLastMotion(r10);
        return;
    L56:
        if (F(this.f2857c) == false) goto L104;
        int r35 = r10.findPointerIndex(this.f2857c);
        float r36 = r10.getX(r35);
        float r37 = r10.getY(r35);
        float[] r38 = this.f2860f;
        int r39 = this.f2857c;
        int r40 = (int) (r36 - r38[r39]);
        int r41 = (int) (r37 - this.f2861g[r39]);
        s(this.f2874t.getLeft() + r40, this.f2874t.getTop() + r41, r40, r41);
        saveLastMotion(r10);
        return;
    L104:
        return;
    L75:
        if (this.f2855a != 1) goto L77;
        H();
    L77:
        b();
    }

    public final void q(float r10, float r11) {
        this.f2875u = true;
        this.f2873s.onViewReleased(this.f2874t, r10, r11);
        this.f2875u = false;
        if (this.f2855a != 1) goto L6;
        K(0);
        return;
    }

    public final float r(float r10) {
        return (float) Math.sin((r10 - 0.5f) * 0.47123894f);
    }

    public final void s(int r11, int r12, int r13, int r14) {
        int r10 = this.f2874t.getLeft();
        int r15 = this.f2874t.getTop();
        if (r13 == 0) goto L5;
        r11 = this.f2873s.clampViewPositionHorizontal(this.f2874t, r11, r13);
        ViewCompat.Z(this.f2874t, r11 - r10);
    L5:
        int r16 = r11;
        if (r14 == 0) goto L8;
        r12 = this.f2873s.clampViewPositionVertical(this.f2874t, r12, r14);
        ViewCompat.a0(this.f2874t, r12 - r15);
    L8:
        int r17 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        c r18 = this.f2873s;
        View r19 = this.f2874t;
        r18.onViewPositionChanged(r19, r16, r17, r16 - r10, r17 - r15);
    }

    public final void t(int r10) {
        float[] r11 = this.f2858d;
        if (r11 != null) goto L5;
    L6:
        int r12 = r10 + 1;
        float[] r13 = new float[r12];
        float[] r14 = new float[r12];
        float[] r15 = new float[r12];
        float[] r16 = new float[r12];
        int[] r17 = new int[r12];
        int[] r18 = new int[r12];
        int[] r19 = new int[r12];
        if (r11 == null) goto L9;
        System.arraycopy(r11, 0, r13, 0, r11.length);
        float[] r20 = this.f2859e;
        System.arraycopy(r20, 0, r14, 0, r20.length);
        float[] r21 = this.f2860f;
        System.arraycopy(r21, 0, r15, 0, r21.length);
        float[] r22 = this.f2861g;
        System.arraycopy(r22, 0, r16, 0, r22.length);
        int[] r23 = this.f2862h;
        System.arraycopy(r23, 0, r17, 0, r23.length);
        int[] r24 = this.f2863i;
        System.arraycopy(r24, 0, r18, 0, r24.length);
        int[] r25 = this.f2864j;
        System.arraycopy(r25, 0, r19, 0, r25.length);
    L9:
        this.f2858d = r13;
        this.f2859e = r14;
        this.f2860f = r15;
        this.f2861g = r16;
        this.f2862h = r17;
        this.f2863i = r18;
        this.f2864j = r19;
        return;
    L5:
        if (r11.length <= r10) goto L6;
    }

    public View u(int r10, int r11) {
        int r12 = this.f2876v.getChildCount() - 1;
    L3:
        if (r12 < 0) goto L14;
        View r13 = this.f2876v.getChildAt(this.f2873s.getOrderedChildIndex(r12));
        if (r10 < r13.getLeft()) goto L13;
        if (r10 >= r13.getRight()) goto L13;
        if (r11 < r13.getTop()) goto L13;
        if (r11 >= r13.getBottom()) goto L13;
        return r13;
    L13:
        r12 = r12 - 1;
        goto L3
    L14:
        return null;
    }

    public final boolean v(int r11, int r12, int r13, int r14) {
        int r10 = this.f2874t.getLeft();
        int r15 = this.f2874t.getTop();
        int r16 = r11 - r10;
        int r17 = r12 - r15;
        if (r16 != 0) goto L7;
        if (r17 != 0) goto L7;
        this.f2872r.abortAnimation();
        K(0);
        return false;
    L7:
        int r18 = m(this.f2874t, r16, r17, r13, r14);
        this.f2872r.startScroll(r10, r15, r16, r17, r18);
        K(2);
        return true;
    }

    public View w() {
        return this.f2874t;
    }

    public int x() {
        return this.f2870p;
    }

    public int y() {
        return this.f2869o;
    }

    public final int z(int r10, int r11) {
        if (r10 >= (this.f2876v.getLeft() + this.f2869o)) goto L5;
        int r12 = 1;
    L7:
        if (r11 >= (this.f2876v.getTop() + this.f2869o)) goto L10;
        r12 = r12 | 4;
    L10:
        if (r10 <= (this.f2876v.getRight() - this.f2869o)) goto L13;
        r12 = r12 | 2;
    L13:
        if (r11 > (this.f2876v.getBottom() - this.f2869o)) goto L15;
        return r12;
    L15:
        return r12 | 8;
    L5:
        r12 = 0;
        goto L7
    }
}
