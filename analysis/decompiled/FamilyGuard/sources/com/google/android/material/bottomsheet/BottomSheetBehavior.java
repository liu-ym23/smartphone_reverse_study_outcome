package com.google.android.material.bottomsheet;

import E.c;
import E.f;
import J.c;
import a1.C0409b;
import a1.C0411d;
import a1.C0416i;
import a1.C0417j;
import a1.C0418k;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.H;
import com.google.android.material.internal.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import o1.C0899b;
import q1.C0981c;
import t1.C1115h;
import t1.l;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: l0, reason: collision with root package name */
    private static final int f12300l0 = C0417j.f6913d;

    /* renamed from: A, reason: collision with root package name */
    private boolean f12301A;

    /* renamed from: B, reason: collision with root package name */
    private final BottomSheetBehavior<V>.h f12302B;

    /* renamed from: C, reason: collision with root package name */
    private ValueAnimator f12303C;

    /* renamed from: D, reason: collision with root package name */
    int f12304D;

    /* renamed from: E, reason: collision with root package name */
    int f12305E;

    /* renamed from: F, reason: collision with root package name */
    int f12306F;

    /* renamed from: G, reason: collision with root package name */
    float f12307G;

    /* renamed from: H, reason: collision with root package name */
    int f12308H;

    /* renamed from: I, reason: collision with root package name */
    float f12309I;

    /* renamed from: J, reason: collision with root package name */
    boolean f12310J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f12311K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f12312L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f12313M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f12314N;

    /* renamed from: O, reason: collision with root package name */
    int f12315O;

    /* renamed from: P, reason: collision with root package name */
    int f12316P;

    /* renamed from: Q, reason: collision with root package name */
    J.c f12317Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f12318R;

    /* renamed from: S, reason: collision with root package name */
    private int f12319S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f12320T;

    /* renamed from: U, reason: collision with root package name */
    private float f12321U;

    /* renamed from: V, reason: collision with root package name */
    private int f12322V;

    /* renamed from: W, reason: collision with root package name */
    int f12323W;

    /* renamed from: X, reason: collision with root package name */
    int f12324X;

    /* renamed from: Y, reason: collision with root package name */
    WeakReference<V> f12325Y;

    /* renamed from: Z, reason: collision with root package name */
    WeakReference<View> f12326Z;

    /* renamed from: a, reason: collision with root package name */
    private int f12327a;

    /* renamed from: a0, reason: collision with root package name */
    WeakReference<View> f12328a0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f12329b;

    /* renamed from: b0, reason: collision with root package name */
    WeakReference<View> f12330b0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12331c;

    /* renamed from: c0, reason: collision with root package name */
    private final ArrayList<f> f12332c0;

    /* renamed from: d, reason: collision with root package name */
    private float f12333d;

    /* renamed from: d0, reason: collision with root package name */
    private VelocityTracker f12334d0;

    /* renamed from: e, reason: collision with root package name */
    private int f12335e;

    /* renamed from: e0, reason: collision with root package name */
    C0899b f12336e0;

    /* renamed from: f, reason: collision with root package name */
    private int f12337f;

    /* renamed from: f0, reason: collision with root package name */
    int f12338f0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12339g;

    /* renamed from: g0, reason: collision with root package name */
    private int f12340g0;

    /* renamed from: h, reason: collision with root package name */
    private int f12341h;

    /* renamed from: h0, reason: collision with root package name */
    boolean f12342h0;

    /* renamed from: i, reason: collision with root package name */
    private int f12343i;

    /* renamed from: i0, reason: collision with root package name */
    private Map<View, Integer> f12344i0;

    /* renamed from: j, reason: collision with root package name */
    private C1115h f12345j;

    /* renamed from: j0, reason: collision with root package name */
    final SparseIntArray f12346j0;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f12347k;

    /* renamed from: k0, reason: collision with root package name */
    private final c.AbstractC0042c f12348k0;

    /* renamed from: l, reason: collision with root package name */
    private int f12349l;

    /* renamed from: m, reason: collision with root package name */
    private int f12350m;

    /* renamed from: n, reason: collision with root package name */
    private int f12351n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f12352o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f12353p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12354q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f12355r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f12356s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f12357t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f12358u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f12359v;

    /* renamed from: w, reason: collision with root package name */
    private int f12360w;

    /* renamed from: x, reason: collision with root package name */
    private int f12361x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f12362y;

    /* renamed from: z, reason: collision with root package name */
    private l f12363z;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f12364a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f12365b;

        a(View view, int i5) {
            this.f12364a = view;
            this.f12365b = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.w0(this.f12364a, this.f12365b, false);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f12345j != null) {
                BottomSheetBehavior.this.f12345j.h0(fFloatValue);
            }
        }
    }

    class c implements r.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f12368a;

        c(boolean z5) {
            this.f12368a = z5;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
        @Override // com.google.android.material.internal.r.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.core.view.Y a(android.view.View r11, androidx.core.view.Y r12, com.google.android.material.internal.r.d r13) {
            /*
                r10 = this;
                int r0 = androidx.core.view.Y.l.f()
                androidx.core.graphics.b r0 = r12.f(r0)
                int r1 = androidx.core.view.Y.l.c()
                androidx.core.graphics.b r1 = r12.f(r1)
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r0.f9643b
                com.google.android.material.bottomsheet.BottomSheetBehavior.n(r2, r3)
                boolean r2 = com.google.android.material.internal.r.g(r11)
                int r3 = r11.getPaddingBottom()
                int r4 = r11.getPaddingLeft()
                int r5 = r11.getPaddingRight()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.o(r6)
                if (r6 == 0) goto L41
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r12.h()
                com.google.android.material.bottomsheet.BottomSheetBehavior.q(r3, r6)
                int r3 = r13.f13050d
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.p(r6)
                int r3 = r3 + r6
            L41:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.r(r6)
                if (r6 == 0) goto L53
                if (r2 == 0) goto L4e
                int r4 = r13.f13049c
                goto L50
            L4e:
                int r4 = r13.f13047a
            L50:
                int r6 = r0.f9642a
                int r4 = r4 + r6
            L53:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.s(r6)
                if (r6 == 0) goto L66
                if (r2 == 0) goto L60
                int r13 = r13.f13047a
                goto L62
            L60:
                int r13 = r13.f13049c
            L62:
                int r2 = r0.f9644c
                int r5 = r13 + r2
            L66:
                android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.t(r2)
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L80
                int r2 = r13.leftMargin
                int r8 = r0.f9642a
                if (r2 == r8) goto L80
                r13.leftMargin = r8
                r2 = r7
                goto L81
            L80:
                r2 = r6
            L81:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.u(r8)
                if (r8 == 0) goto L92
                int r8 = r13.rightMargin
                int r9 = r0.f9644c
                if (r8 == r9) goto L92
                r13.rightMargin = r9
                r2 = r7
            L92:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.d(r8)
                if (r8 == 0) goto La3
                int r8 = r13.topMargin
                int r0 = r0.f9643b
                if (r8 == r0) goto La3
                r13.topMargin = r0
                goto La4
            La3:
                r7 = r2
            La4:
                if (r7 == 0) goto La9
                r11.setLayoutParams(r13)
            La9:
                int r13 = r11.getPaddingTop()
                r11.setPadding(r4, r13, r5, r3)
                boolean r11 = r10.f12368a
                if (r11 == 0) goto Lbb
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r13 = r1.f9645d
                com.google.android.material.bottomsheet.BottomSheetBehavior.e(r11, r13)
            Lbb:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.o(r11)
                if (r11 != 0) goto Lc9
                boolean r11 = r10.f12368a
                if (r11 == 0) goto Lc8
                goto Lc9
            Lc8:
                return r12
            Lc9:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                com.google.android.material.bottomsheet.BottomSheetBehavior.f(r10, r6)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.a(android.view.View, androidx.core.view.Y, com.google.android.material.internal.r$d):androidx.core.view.Y");
        }
    }

    class d extends c.AbstractC0042c {

        /* renamed from: a, reason: collision with root package name */
        private long f12370a;

        d() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.f12324X + bottomSheetBehavior.K()) / 2;
        }

        @Override // J.c.AbstractC0042c
        public int a(View view, int i5, int i6) {
            return view.getLeft();
        }

        @Override // J.c.AbstractC0042c
        public int b(View view, int i5, int i6) {
            return B.a.b(i5, BottomSheetBehavior.this.K(), e(view));
        }

        @Override // J.c.AbstractC0042c
        public int e(View view) {
            return BottomSheetBehavior.this.C() ? BottomSheetBehavior.this.f12324X : BottomSheetBehavior.this.f12308H;
        }

        @Override // J.c.AbstractC0042c
        public void j(int i5) {
            if (i5 == 1 && BottomSheetBehavior.this.f12312L) {
                BottomSheetBehavior.this.p0(1);
            }
        }

        @Override // J.c.AbstractC0042c
        public void k(View view, int i5, int i6, int i7, int i8) {
            BottomSheetBehavior.this.H(i6);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
        @Override // J.c.AbstractC0042c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.l(android.view.View, float, float):void");
        }

        @Override // J.c.AbstractC0042c
        public boolean m(View view, int i5) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i6 = bottomSheetBehavior.f12315O;
            if (i6 == 1 || bottomSheetBehavior.f12342h0) {
                return false;
            }
            if (i6 == 3 && bottomSheetBehavior.f12338f0 == i5) {
                WeakReference<View> weakReference = bottomSheetBehavior.f12330b0;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f12370a = SystemClock.uptimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.f12325Y;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class e implements E.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12372a;

        e(int i5) {
            this.f12372a = i5;
        }

        @Override // E.f
        public boolean a(View view, f.a aVar) {
            BottomSheetBehavior.this.o0(this.f12372a);
            return true;
        }
    }

    public static abstract class f {
        void a(View view) {
        }

        public abstract void b(View view, float f5);

        public abstract void c(View view, int i5);
    }

    public BottomSheetBehavior() {
        this.f12327a = 0;
        this.f12329b = true;
        this.f12331c = false;
        this.f12349l = -1;
        this.f12350m = -1;
        this.f12302B = new h(this, null);
        this.f12307G = 0.5f;
        this.f12309I = -1.0f;
        this.f12312L = true;
        this.f12313M = true;
        this.f12315O = 4;
        this.f12316P = 4;
        this.f12321U = 0.1f;
        this.f12332c0 = new ArrayList<>();
        this.f12340g0 = -1;
        this.f12346j0 = new SparseIntArray();
        this.f12348k0 = new d();
    }

    private int A() {
        int iMin;
        int i5;
        int i6;
        if (this.f12339g) {
            iMin = Math.min(Math.max(this.f12341h, this.f12324X - ((this.f12323W * 9) / 16)), this.f12322V);
            i5 = this.f12360w;
        } else {
            if (!this.f12352o && !this.f12353p && (i6 = this.f12351n) > 0) {
                return Math.max(this.f12337f, i6 + this.f12343i);
            }
            iMin = this.f12337f;
            i5 = this.f12360w;
        }
        return iMin + i5;
    }

    private void A0(boolean z5) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.f12325Y;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z5) {
                if (this.f12344i0 != null) {
                    return;
                } else {
                    this.f12344i0 = new HashMap(childCount);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = coordinatorLayout.getChildAt(i5);
                if (childAt != this.f12325Y.get()) {
                    if (z5) {
                        this.f12344i0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f12331c) {
                            childAt.setImportantForAccessibility(4);
                        }
                    } else if (this.f12331c && (map = this.f12344i0) != null && map.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(this.f12344i0.get(childAt).intValue());
                    }
                }
            }
            if (!z5) {
                this.f12344i0 = null;
            } else if (this.f12331c) {
                this.f12325Y.get().sendAccessibilityEvent(8);
            }
        }
    }

    private float B(int i5) {
        float f5;
        float fK;
        int i6 = this.f12308H;
        if (i5 > i6 || i6 == K()) {
            int i7 = this.f12308H;
            f5 = i7 - i5;
            fK = this.f12324X - i7;
        } else {
            int i8 = this.f12308H;
            f5 = i8 - i5;
            fK = i8 - K();
        }
        return f5 / fK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(boolean z5) {
        V v5;
        if (this.f12325Y != null) {
            w();
            if (this.f12315O != 4 || (v5 = this.f12325Y.get()) == null) {
                return;
            }
            if (z5) {
                o0(4);
            } else {
                v5.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        return Q() && R();
    }

    private void D(View view, int i5) {
        if (view == null) {
            return;
        }
        H.d0(view, 524288);
        H.d0(view, 262144);
        H.d0(view, 1048576);
        int i6 = this.f12346j0.get(i5, -1);
        if (i6 != -1) {
            H.d0(view, i6);
            this.f12346j0.delete(i5);
        }
    }

    private E.f E(int i5) {
        return new e(i5);
    }

    private void F(Context context) {
        if (this.f12363z == null) {
            return;
        }
        C1115h c1115h = new C1115h(this.f12363z);
        this.f12345j = c1115h;
        c1115h.U(context);
        ColorStateList colorStateList = this.f12347k;
        if (colorStateList != null) {
            this.f12345j.g0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f12345j.setTint(typedValue.data);
    }

    private void G() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(z(), 1.0f);
        this.f12303C = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f12303C.addUpdateListener(new b());
    }

    private int J(int i5, int i6, int i7, int i8) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, i6, i8);
        if (i7 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i7), 1073741824);
        }
        if (size != 0) {
            i7 = Math.min(size, i7);
        }
        return View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
    }

    private int L(int i5) {
        if (i5 == 3) {
            return K();
        }
        if (i5 == 4) {
            return this.f12308H;
        }
        if (i5 == 5) {
            return this.f12324X;
        }
        if (i5 == 6) {
            return this.f12306F;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i5);
    }

    private float M() {
        VelocityTracker velocityTracker = this.f12334d0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f12333d);
        return this.f12334d0.getYVelocity(this.f12338f0);
    }

    private boolean N() {
        WeakReference<V> weakReference = this.f12325Y;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            this.f12325Y.get().getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean O() {
        if (this.f12315O == 3) {
            return this.f12362y || N();
        }
        return false;
    }

    private boolean S(V v5) {
        ViewParent parent = v5.getParent();
        return parent != null && parent.isLayoutRequested() && v5.isAttachedToWindow();
    }

    private boolean U(CoordinatorLayout coordinatorLayout, int i5, int i6) {
        WeakReference<View> weakReference = this.f12328a0;
        View view = weakReference != null ? weakReference.get() : null;
        return view != null && coordinatorLayout.O(view, i5, i6);
    }

    private boolean V(CoordinatorLayout coordinatorLayout, int i5, int i6) {
        WeakReference<View> weakReference = this.f12330b0;
        View view = weakReference != null ? weakReference.get() : null;
        return view != null && coordinatorLayout.O(view, i5, i6);
    }

    private void W(View view, c.a aVar, int i5) {
        H.f0(view, aVar, null, E(i5));
    }

    private void X() {
        this.f12338f0 = -1;
        this.f12340g0 = -1;
        VelocityTracker velocityTracker = this.f12334d0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f12334d0 = null;
        }
    }

    private void Y(g gVar) {
        int i5 = this.f12327a;
        if (i5 == 0) {
            return;
        }
        if (i5 == -1 || (i5 & 1) == 1) {
            this.f12337f = gVar.f12375b;
        }
        if (i5 == -1 || (i5 & 2) == 2) {
            this.f12329b = gVar.f12376c;
        }
        if (i5 == -1 || (i5 & 4) == 4) {
            this.f12310J = gVar.f12377d;
        }
        if (i5 == -1 || (i5 & 8) == 8) {
            this.f12311K = gVar.f12378e;
        }
    }

    private void Z(V v5, Runnable runnable) {
        if (S(v5)) {
            v5.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void q0(View view) {
        boolean z5 = (P() || this.f12339g) ? false : true;
        if (this.f12353p || this.f12354q || this.f12355r || this.f12357t || this.f12358u || this.f12359v || z5) {
            r.b(view, new c(z5));
        }
    }

    private boolean s0() {
        if (this.f12317Q != null) {
            return this.f12312L || this.f12315O == 1;
        }
        return false;
    }

    private int v(View view, int i5, int i6) {
        return H.b(view, view.getResources().getString(i5), E(i6));
    }

    private void w() {
        int iA = A();
        if (this.f12329b) {
            this.f12308H = Math.max(this.f12324X - iA, this.f12305E);
        } else {
            this.f12308H = this.f12324X - iA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(View view, int i5, boolean z5) {
        int iL = L(i5);
        J.c cVar = this.f12317Q;
        if (cVar == null || (!z5 ? cVar.H(view, view.getLeft(), iL) : cVar.F(view.getLeft(), iL))) {
            p0(i5);
            return;
        }
        p0(2);
        z0(i5, true);
        this.f12302B.c(i5);
    }

    private float x(float f5, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f5 > 0.0f) {
                return radius / f5;
            }
        }
        return 0.0f;
    }

    private void x0() {
        WeakReference<V> weakReference = this.f12325Y;
        if (weakReference != null) {
            y0(weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.f12326Z;
        if (weakReference2 != null) {
            y0(weakReference2.get(), 1);
        }
    }

    private void y() {
        this.f12306F = (int) (this.f12324X * (1.0f - this.f12307G));
    }

    private void y0(View view, int i5) {
        if (view == null) {
            return;
        }
        D(view, i5);
        if (!this.f12329b && this.f12315O != 6) {
            this.f12346j0.put(i5, v(view, C0416i.f6885a, 6));
        }
        if (this.f12310J && R() && this.f12315O != 5) {
            W(view, c.a.f1266y, 5);
        }
        int i6 = this.f12315O;
        if (i6 == 3) {
            W(view, c.a.f1265x, this.f12329b ? 4 : 6);
            return;
        }
        if (i6 == 4) {
            W(view, c.a.f1264w, this.f12329b ? 3 : 6);
        } else {
            if (i6 != 6) {
                return;
            }
            W(view, c.a.f1265x, 4);
            W(view, c.a.f1264w, 3);
        }
    }

    private float z() {
        WeakReference<V> weakReference;
        WindowInsets rootWindowInsets;
        if (this.f12345j == null || (weakReference = this.f12325Y) == null || weakReference.get() == null) {
            return 0.0f;
        }
        V v5 = this.f12325Y.get();
        if (!N() || (rootWindowInsets = v5.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(x(this.f12345j.N(), rootWindowInsets.getRoundedCorner(0)), x(this.f12345j.O(), rootWindowInsets.getRoundedCorner(1)));
    }

    private void z0(int i5, boolean z5) {
        boolean zO;
        ValueAnimator valueAnimator;
        if (i5 == 2 || this.f12301A == (zO = O()) || this.f12345j == null) {
            return;
        }
        this.f12301A = zO;
        if (!z5 || (valueAnimator = this.f12303C) == null) {
            ValueAnimator valueAnimator2 = this.f12303C;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f12303C.cancel();
            }
            this.f12345j.h0(this.f12301A ? z() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.f12303C.reverse();
        } else {
            this.f12303C.setFloatValues(this.f12345j.C(), zO ? z() : 1.0f);
            this.f12303C.start();
        }
    }

    void H(int i5) {
        V v5 = this.f12325Y.get();
        if (v5 == null || this.f12332c0.isEmpty()) {
            return;
        }
        float fB = B(i5);
        for (int i6 = 0; i6 < this.f12332c0.size(); i6++) {
            this.f12332c0.get(i6).b(v5, fB);
        }
    }

    View I(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View viewI = I(viewGroup.getChildAt(i5));
                if (viewI != null) {
                    return viewI;
                }
            }
        }
        return null;
    }

    public int K() {
        if (this.f12329b) {
            return this.f12305E;
        }
        return Math.max(this.f12304D, this.f12356s ? 0 : this.f12361x);
    }

    public boolean P() {
        return this.f12352o;
    }

    public boolean Q() {
        return this.f12310J;
    }

    public boolean R() {
        return true;
    }

    public boolean T() {
        return true;
    }

    public void a0(boolean z5) {
        this.f12312L = z5;
    }

    public void b0(boolean z5) {
        this.f12313M = z5;
    }

    public void c0(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f12304D = i5;
        z0(this.f12315O, true);
    }

    public void d0(boolean z5) {
        if (this.f12329b == z5) {
            return;
        }
        this.f12329b = z5;
        if (this.f12325Y != null) {
            w();
        }
        p0((this.f12329b && this.f12315O == 6) ? 3 : this.f12315O);
        z0(this.f12315O, true);
        x0();
    }

    public void e0(boolean z5) {
        this.f12352o = z5;
    }

    public void f0(float f5) {
        if (f5 <= 0.0f || f5 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.f12307G = f5;
        if (this.f12325Y != null) {
            y();
        }
    }

    public void g0(boolean z5) {
        if (this.f12310J != z5) {
            this.f12310J = z5;
            if (!z5 && this.f12315O == 5) {
                o0(4);
            }
            x0();
        }
    }

    public void h0(int i5) {
        this.f12350m = i5;
    }

    public void i0(int i5) {
        this.f12349l = i5;
    }

    public void j0(int i5) {
        k0(i5, false);
    }

    public final void k0(int i5, boolean z5) {
        if (i5 == -1) {
            if (this.f12339g) {
                return;
            } else {
                this.f12339g = true;
            }
        } else {
            if (!this.f12339g && this.f12337f == i5) {
                return;
            }
            this.f12339g = false;
            this.f12337f = Math.max(0, i5);
        }
        B0(z5);
    }

    public void l0(int i5) {
        this.f12327a = i5;
    }

    public void m0(int i5) {
        this.f12335e = i5;
    }

    public void n0(boolean z5) {
        this.f12311K = z5;
    }

    public void o0(int i5) {
        if (i5 == 1 || i5 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i5 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.f12310J && i5 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i5);
            return;
        }
        int i6 = (i5 == 6 && this.f12329b && L(i5) <= this.f12305E) ? 3 : i5;
        WeakReference<V> weakReference = this.f12325Y;
        if (weakReference == null || weakReference.get() == null) {
            p0(i5);
        } else {
            V v5 = this.f12325Y.get();
            Z(v5, new a(v5, i6));
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.f12325Y = null;
        this.f12317Q = null;
        this.f12336e0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f12325Y = null;
        this.f12317Q = null;
        this.f12336e0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        int i5;
        J.c cVar;
        if (!v5.isShown() || !this.f12312L) {
            this.f12318R = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            X();
        }
        if (this.f12334d0 == null) {
            this.f12334d0 = VelocityTracker.obtain();
        }
        this.f12334d0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x5 = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            this.f12340g0 = y5;
            if (this.f12315O != 2 && V(coordinatorLayout, x5, y5)) {
                this.f12338f0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                if (!U(coordinatorLayout, x5, this.f12340g0)) {
                    this.f12342h0 = true;
                }
            }
            this.f12318R = this.f12338f0 == -1 && !coordinatorLayout.O(v5, x5, this.f12340g0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f12342h0 = false;
            this.f12338f0 = -1;
            if (this.f12318R) {
                this.f12318R = false;
                return false;
            }
        }
        if (!this.f12318R && (cVar = this.f12317Q) != null && cVar.G(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference = this.f12330b0;
        View view = weakReference != null ? weakReference.get() : null;
        return (actionMasked != 2 || view == null || this.f12318R || this.f12315O == 1 || coordinatorLayout.O(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f12317Q == null || (i5 = this.f12340g0) == -1 || Math.abs(((float) i5) - motionEvent.getY()) <= ((float) this.f12317Q.u())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v5, int i5) {
        if (coordinatorLayout.getFitsSystemWindows() && !v5.getFitsSystemWindows()) {
            v5.setFitsSystemWindows(true);
        }
        if (this.f12325Y == null) {
            this.f12341h = coordinatorLayout.getResources().getDimensionPixelSize(C0411d.f6774b);
            q0(v5);
            H.H0(v5, new com.google.android.material.bottomsheet.a(v5));
            this.f12325Y = new WeakReference<>(v5);
            this.f12336e0 = new C0899b(v5);
            C1115h c1115h = this.f12345j;
            if (c1115h != null) {
                v5.setBackground(c1115h);
                C1115h c1115h2 = this.f12345j;
                float elevation = this.f12309I;
                if (elevation == -1.0f) {
                    elevation = v5.getElevation();
                }
                c1115h2.f0(elevation);
            } else {
                ColorStateList colorStateList = this.f12347k;
                if (colorStateList != null) {
                    H.p0(v5, colorStateList);
                }
            }
            x0();
            if (v5.getImportantForAccessibility() == 0) {
                v5.setImportantForAccessibility(1);
            }
        }
        if (this.f12317Q == null) {
            this.f12317Q = J.c.m(coordinatorLayout, this.f12348k0);
        }
        int top = v5.getTop();
        coordinatorLayout.W(v5, i5);
        this.f12323W = coordinatorLayout.getWidth();
        this.f12324X = coordinatorLayout.getHeight();
        int height = v5.getHeight();
        this.f12322V = height;
        int iMin = this.f12324X;
        int i6 = iMin - height;
        int i7 = this.f12361x;
        if (i6 < i7) {
            if (this.f12356s) {
                int i8 = this.f12350m;
                if (i8 != -1) {
                    iMin = Math.min(iMin, i8);
                }
                this.f12322V = iMin;
            } else {
                int iMin2 = iMin - i7;
                int i9 = this.f12350m;
                if (i9 != -1) {
                    iMin2 = Math.min(iMin2, i9);
                }
                this.f12322V = iMin2;
            }
        }
        this.f12305E = Math.max(0, this.f12324X - this.f12322V);
        y();
        w();
        int i10 = this.f12315O;
        if (i10 == 3) {
            H.V(v5, K());
        } else if (i10 == 6) {
            H.V(v5, this.f12306F);
        } else if (this.f12310J && i10 == 5) {
            H.V(v5, this.f12324X);
        } else if (i10 == 4) {
            H.V(v5, this.f12308H);
        } else if (i10 == 1 || i10 == 2) {
            H.V(v5, top - v5.getTop());
        }
        z0(this.f12315O, false);
        this.f12330b0 = new WeakReference<>(I(v5));
        for (int i11 = 0; i11 < this.f12332c0.size(); i11++) {
            this.f12332c0.get(i11).a(v5);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v5, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v5.getLayoutParams();
        v5.measure(J(i5, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, this.f12349l, marginLayoutParams.width), J(i7, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, this.f12350m, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v5, View view, float f5, float f6) {
        WeakReference<View> weakReference;
        return T() && (weakReference = this.f12330b0) != null && view == weakReference.get() && (!(this.f12315O == 3 || this.f12314N) || super.onNestedPreFling(coordinatorLayout, v5, view, f5, f6));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5, int i6, int[] iArr, int i7) {
        if (i7 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.f12330b0;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (!T() || view == view2) {
            int top = v5.getTop();
            int i8 = top - i6;
            if (i6 > 0) {
                if (!this.f12320T && !this.f12313M && view == view2 && view.canScrollVertically(1)) {
                    this.f12314N = true;
                    return;
                }
                if (i8 < K()) {
                    int iK = top - K();
                    iArr[1] = iK;
                    H.V(v5, -iK);
                    p0(3);
                } else {
                    if (!this.f12312L) {
                        return;
                    }
                    iArr[1] = i6;
                    H.V(v5, -i6);
                    p0(1);
                }
            } else if (i6 < 0) {
                boolean zCanScrollVertically = view.canScrollVertically(-1);
                if (!this.f12320T && !this.f12313M && view == view2 && zCanScrollVertically) {
                    this.f12314N = true;
                    return;
                }
                if (!zCanScrollVertically) {
                    if (i8 > this.f12308H && !C()) {
                        int i9 = top - this.f12308H;
                        iArr[1] = i9;
                        H.V(v5, -i9);
                        p0(4);
                    } else {
                        if (!this.f12312L) {
                            return;
                        }
                        iArr[1] = i6;
                        H.V(v5, -i6);
                        p0(1);
                    }
                }
            }
            H(v5.getTop());
            this.f12319S = i6;
            this.f12320T = true;
            this.f12314N = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v5, Parcelable parcelable) {
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v5, gVar.getSuperState());
        Y(gVar);
        int i5 = gVar.f12374a;
        if (i5 == 1 || i5 == 2) {
            this.f12315O = 4;
            this.f12316P = 4;
        } else {
            this.f12315O = i5;
            this.f12316P = i5;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v5) {
        return new g(super.onSaveInstanceState(coordinatorLayout, v5), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i5, int i6) {
        this.f12319S = 0;
        this.f12320T = false;
        return (i5 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.K()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.p0(r0)
            return
        Lf:
            boolean r3 = r2.T()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference<android.view.View> r3 = r2.f12330b0
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.f12320T
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.f12319S
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.f12329b
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.f12306F
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.f12310J
            if (r3 == 0) goto L49
            float r3 = r2.M()
            boolean r3 = r2.t0(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.f12319S
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.f12329b
            if (r1 == 0) goto L68
            int r5 = r2.f12305E
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f12308H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.f12306F
            if (r3 >= r1) goto L7e
            int r1 = r2.f12308H
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.u0()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f12308H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.f12329b
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.f12306F
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f12308H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.w0(r4, r0, r3)
            r2.f12320T = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
        if (!v5.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f12315O == 1 && actionMasked == 0) {
            return true;
        }
        if (s0()) {
            this.f12317Q.z(motionEvent);
        }
        if (actionMasked == 0) {
            X();
        }
        if (this.f12334d0 == null) {
            this.f12334d0 = VelocityTracker.obtain();
        }
        this.f12334d0.addMovement(motionEvent);
        if (s0() && actionMasked == 2 && !this.f12318R && Math.abs(this.f12340g0 - motionEvent.getY()) > this.f12317Q.u()) {
            this.f12317Q.b(v5, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f12318R;
    }

    void p0(int i5) {
        V v5;
        if (this.f12315O == i5) {
            return;
        }
        this.f12315O = i5;
        if (i5 == 4 || i5 == 3 || i5 == 6 || (this.f12310J && i5 == 5)) {
            this.f12316P = i5;
        }
        WeakReference<V> weakReference = this.f12325Y;
        if (weakReference == null || (v5 = weakReference.get()) == null) {
            return;
        }
        if (i5 == 3) {
            A0(true);
        } else if (i5 == 6 || i5 == 5 || i5 == 4) {
            A0(false);
        }
        z0(i5, true);
        for (int i6 = 0; i6 < this.f12332c0.size(); i6++) {
            this.f12332c0.get(i6).c(v5, i5);
        }
        x0();
    }

    public boolean r0(long j5, float f5) {
        return false;
    }

    boolean t0(View view, float f5) {
        if (this.f12311K) {
            return true;
        }
        if (R() && view.getTop() >= this.f12308H) {
            return Math.abs((((float) view.getTop()) + (f5 * this.f12321U)) - ((float) this.f12308H)) / ((float) A()) > 0.5f;
        }
        return false;
    }

    public boolean u0() {
        return false;
    }

    public boolean v0() {
        return true;
    }

    private class h {

        /* renamed from: a, reason: collision with root package name */
        private int f12379a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f12380b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f12381c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f12380b = false;
                J.c cVar = BottomSheetBehavior.this.f12317Q;
                if (cVar != null && cVar.k(true)) {
                    h hVar = h.this;
                    hVar.c(hVar.f12379a);
                    return;
                }
                h hVar2 = h.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f12315O == 2) {
                    bottomSheetBehavior.p0(hVar2.f12379a);
                }
            }
        }

        private h() {
            this.f12381c = new a();
        }

        void c(int i5) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.f12325Y;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f12379a = i5;
            if (this.f12380b) {
                return;
            }
            BottomSheetBehavior.this.f12325Y.get().postOnAnimation(this.f12381c);
            this.f12380b = true;
        }

        /* synthetic */ h(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    protected static class g extends androidx.customview.view.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        final int f12374a;

        /* renamed from: b, reason: collision with root package name */
        int f12375b;

        /* renamed from: c, reason: collision with root package name */
        boolean f12376c;

        /* renamed from: d, reason: collision with root package name */
        boolean f12377d;

        /* renamed from: e, reason: collision with root package name */
        boolean f12378e;

        class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i5) {
                return new g[i5];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f12374a = parcel.readInt();
            this.f12375b = parcel.readInt();
            this.f12376c = parcel.readInt() == 1;
            this.f12377d = parcel.readInt() == 1;
            this.f12378e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f12374a);
            parcel.writeInt(this.f12375b);
            parcel.writeInt(this.f12376c ? 1 : 0);
            parcel.writeInt(this.f12377d ? 1 : 0);
            parcel.writeInt(this.f12378e ? 1 : 0);
        }

        public g(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f12374a = bottomSheetBehavior.f12315O;
            this.f12375b = ((BottomSheetBehavior) bottomSheetBehavior).f12337f;
            this.f12376c = ((BottomSheetBehavior) bottomSheetBehavior).f12329b;
            this.f12377d = bottomSheetBehavior.f12310J;
            this.f12378e = ((BottomSheetBehavior) bottomSheetBehavior).f12311K;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i5;
        super(context, attributeSet);
        this.f12327a = 0;
        this.f12329b = true;
        this.f12331c = false;
        this.f12349l = -1;
        this.f12350m = -1;
        this.f12302B = new h(this, null);
        this.f12307G = 0.5f;
        this.f12309I = -1.0f;
        this.f12312L = true;
        this.f12313M = true;
        this.f12315O = 4;
        this.f12316P = 4;
        this.f12321U = 0.1f;
        this.f12332c0 = new ArrayList<>();
        this.f12340g0 = -1;
        this.f12346j0 = new SparseIntArray();
        this.f12348k0 = new d();
        this.f12343i = context.getResources().getDimensionPixelSize(C0411d.f6777c0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7210t);
        int i6 = C0418k.f7234x;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            this.f12347k = C0981c.a(context, typedArrayObtainStyledAttributes, i6);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C0418k.f7031Q)) {
            this.f12363z = l.e(context, attributeSet, C0409b.f6715b, f12300l0).m();
        }
        F(context);
        G();
        this.f12309I = typedArrayObtainStyledAttributes.getDimension(C0418k.f7228w, -1.0f);
        int i7 = C0418k.f7216u;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            i0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i7, -1));
        }
        int i8 = C0418k.f7222v;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            h0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i8, -1));
        }
        int i9 = C0418k.f6959E;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i9);
        if (typedValuePeekValue != null && (i5 = typedValuePeekValue.data) == -1) {
            j0(i5);
        } else {
            j0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i9, -1));
        }
        g0(typedArrayObtainStyledAttributes.getBoolean(C0418k.f6953D, false));
        e0(typedArrayObtainStyledAttributes.getBoolean(C0418k.f6983I, false));
        d0(typedArrayObtainStyledAttributes.getBoolean(C0418k.f6941B, true));
        n0(typedArrayObtainStyledAttributes.getBoolean(C0418k.f6977H, false));
        a0(typedArrayObtainStyledAttributes.getBoolean(C0418k.f7240y, true));
        b0(typedArrayObtainStyledAttributes.getBoolean(C0418k.f7246z, true));
        l0(typedArrayObtainStyledAttributes.getInt(C0418k.f6965F, 0));
        f0(typedArrayObtainStyledAttributes.getFloat(C0418k.f6947C, 0.5f));
        int i10 = C0418k.f6935A;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i10);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            c0(typedValuePeekValue2.data);
        } else {
            c0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i10, 0));
        }
        m0(typedArrayObtainStyledAttributes.getInt(C0418k.f6971G, 500));
        this.f12353p = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7007M, false);
        this.f12354q = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7013N, false);
        this.f12355r = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7019O, false);
        this.f12356s = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7025P, true);
        this.f12357t = typedArrayObtainStyledAttributes.getBoolean(C0418k.f6989J, false);
        this.f12358u = typedArrayObtainStyledAttributes.getBoolean(C0418k.f6995K, false);
        this.f12359v = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7001L, false);
        this.f12362y = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7037R, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f12333d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
