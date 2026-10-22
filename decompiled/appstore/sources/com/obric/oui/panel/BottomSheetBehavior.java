package com.obric.oui.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int A;
    public int B;
    public boolean C;
    public Map D;
    public boolean E;
    public InterceptTouchEvent F;
    public boolean G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final com.obric.oui.panel.e.c f15741J;
    public final com.obric.oui.panel.e.c K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f15745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f15753l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15754m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f15755n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f15756o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15757p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.obric.oui.panel.e f15758q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.obric.oui.panel.b f15759r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f15760s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f15761t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15762u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f15763v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WeakReference f15764w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public WeakReference f15765x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f15766y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public VelocityTracker f15767z;

    public interface InterceptTouchEvent {
        boolean shouldInterceptTouchEvent(MotionEvent r10, int r11, int r12);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final int state;

        public class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r10) {
            this(r10, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.state);
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.state = r10.readInt();
        }

        public SavedState(Parcelable r10, int r11) {
            super(r10);
            this.state = r11;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f15768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f15770c;

        public a(BottomSheetBehavior r10, View r11, int r12) {
            this.f15770c = r10;
            this.f15768a = r11;
            this.f15769b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15770c.n(this.f15768a, this.f15769b);
        }
    }

    public class b extends com.obric.oui.panel.e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f15771a;

        public b(BottomSheetBehavior r10) {
            this.f15771a = r10;
        }

        @Override // com.obric.oui.panel.e.c
        public int a(View r10, int r11, int r12) {
            return r10.getLeft();
        }

        @Override // com.obric.oui.panel.e.c
        public int b(View r10, int r11, int r12) {
            int r13 = BottomSheetBehavior.c(this.f15771a);
            BottomSheetBehavior r14 = this.f15771a;
            if (r14.f15753l == false) goto L5;
            int r15 = r14.f15763v;
        L7:
            return p.a.b(r11, r13, r15);
        L5:
            r15 = r14.f15752k;
            goto L7
        }

        @Override // com.obric.oui.panel.e.c
        public int e(View r10) {
            BottomSheetBehavior r11 = this.f15771a;
            if (r11.f15753l == false) goto L7;
            return r11.f15763v;
        L7:
            return r11.f15752k;
        }

        @Override // com.obric.oui.panel.e.c
        public void j(int r10) {
            if (r10 == 1) goto L5;
            return;
        L5:
            if (BottomSheetBehavior.a(this.f15771a) == false) goto L9;
            this.f15771a.setStateInternal(1);
            return;
        }

        @Override // com.obric.oui.panel.e.c
        public void k(View r10, int r11, int r12, int r13, int r14) {
            this.f15771a.dispatchOnSlide(r12);
        }

        @Override // com.obric.oui.panel.e.c
        public void l(View r10, float r11, float r12) {
            int[] r13 = BottomSheetBehavior.b(this.f15771a, r10, r11, r12);
            int r14 = r13[0];
            int r15 = r13[1];
            BottomSheetBehavior r16 = this.f15771a;
            r16.f15757p = r15;
            if (r16.f15758q.E(r10.getLeft(), r14) == false) goto L5;
            this.f15771a.setStateInternal(2);
            ViewCompat.h0(r10, new f(this.f15771a, r10, r15));
            return;
        L5:
            this.f15771a.setStateInternal(r15);
        }

        @Override // com.obric.oui.panel.e.c
        public boolean m(View r10, int r11) {
            BottomSheetBehavior r12 = this.f15771a;
            int r13 = r12.f15756o;
            if (r13 != 1) goto L6;
            return false;
        L6:
            if (r12.C == false) goto L9;
            return false;
        L9:
            if (r13 == 3) goto L11;
        L17:
            WeakReference r14 = this.f15771a.f15764w;
            if (r14 != null) goto L20;
            return false;
        L20:
            if (r14.get() == r10) goto L22;
            return false;
        L22:
            return true;
        L11:
            if (r12.A != r11) goto L17;
            View r15 = (View) r12.f15765x.get();
            if (r15 == null) goto L17;
            if (r15.canScrollVertically(-1) == false) goto L17;
            return false;
        }
    }

    public class c extends com.obric.oui.panel.e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f15772a;

        public c(BottomSheetBehavior r10) {
            this.f15772a = r10;
        }

        @Override // com.obric.oui.panel.e.c
        public int a(View r10, int r11, int r12) {
            return BottomSheetBehavior.d(this.f15772a).a(r10, r11, r12);
        }

        @Override // com.obric.oui.panel.e.c
        public int b(View r10, int r11, int r12) {
            return BottomSheetBehavior.d(this.f15772a).b(r10, r11, r12);
        }

        @Override // com.obric.oui.panel.e.c
        public int e(View r10) {
            return BottomSheetBehavior.d(this.f15772a).e(r10);
        }

        @Override // com.obric.oui.panel.e.c
        public void j(int r10) {
            BottomSheetBehavior.d(this.f15772a).j(r10);
        }

        @Override // com.obric.oui.panel.e.c
        public void k(View r10, int r11, int r12, int r13, int r14) {
            BottomSheetBehavior.d(this.f15772a).k(r10, r11, r12, r13, r14);
        }

        @Override // com.obric.oui.panel.e.c
        public void l(View r10, float r11, float r12) {
            int[] r13 = BottomSheetBehavior.b(this.f15772a, r10, r11, r12);
            int r14 = r13[0];
            int r15 = r13[1];
            BottomSheetBehavior r16 = this.f15772a;
            r16.f15757p = r15;
            if (r16.f15759r.r(r10, r10.getLeft(), r14, (int) r11, (int) r12) == false) goto L5;
            this.f15772a.setStateInternal(2);
            ViewCompat.h0(r10, new e(this.f15772a, r10, r15));
            return;
        L5:
            this.f15772a.setStateInternal(r15);
        }

        @Override // com.obric.oui.panel.e.c
        public boolean m(View r10, int r11) {
            return BottomSheetBehavior.d(this.f15772a).m(r10, r11);
        }
    }

    public static abstract class d {
        public d() {
        }

        public void a(float r10) {
        }

        public void b(float r10) {
        }

        public abstract void c(View r10, float r11);

        public abstract void d(View r10, int r11);
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f15773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f15775c;

        public e(BottomSheetBehavior r10, View r11, int r12) {
            this.f15775c = r10;
            this.f15773a = r11;
            this.f15774b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.obric.oui.panel.b r10 = this.f15775c.f15759r;
            if (r10 != null) goto L5;
        L7:
            this.f15775c.setStateInternal(this.f15774b);
            return;
        L5:
            if (r10.h(this.f15773a, true) == false) goto L7;
            ViewCompat.h0(this.f15773a, this);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f15776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f15778c;

        public f(BottomSheetBehavior r10, View r11, int r12) {
            this.f15778c = r10;
            this.f15776a = r11;
            this.f15777b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.obric.oui.panel.e r10 = this.f15778c.f15758q;
            if (r10 != null) goto L5;
        L7:
            this.f15778c.setStateInternal(this.f15777b);
            return;
        L5:
            if (r10.k(true) == false) goto L7;
            ViewCompat.h0(this.f15776a, this);
        }
    }

    public BottomSheetBehavior() {
        this.f15742a = true;
        this.f15743b = false;
        this.f15744c = -1;
        this.f15754m = true;
        this.f15755n = false;
        this.f15756o = 4;
        this.f15757p = 4;
        this.f15766y = new ArrayList();
        this.E = true;
        this.G = false;
        this.H = true;
        this.I = 600;
        this.f15741J = new b(this);
        this.K = new c(this);
    }

    public static /* synthetic */ boolean a(BottomSheetBehavior r10) {
        return r10.f15754m;
    }

    public static /* synthetic */ int[] b(BottomSheetBehavior r10, View r11, float r12, float r13) {
        return r10.g(r11, r12, r13);
    }

    public static /* synthetic */ int c(BottomSheetBehavior r10) {
        return r10.getExpandedOffset();
    }

    public static /* synthetic */ com.obric.oui.panel.e.c d(BottomSheetBehavior r10) {
        return r10.f15741J;
    }

    public static BottomSheetBehavior f(View r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof CoordinatorLayout.c) == false) goto L11;
        CoordinatorLayout.Behavior r12 = ((CoordinatorLayout.c) r11).f();
        if ((r12 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r12;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getExpandedOffset() {
        if (this.f15742a == true) goto L7;
        return 0;
    L7:
        return this.f15750i;
    }

    public void calculateCollapsedOffset() {
        if (this.f15742a == false) goto L5;
        this.f15752k = Math.max(this.f15763v - this.f15749h, this.f15750i);
        return;
    L5:
        this.f15752k = this.f15763v - this.f15749h;
    }

    public void dispatchOnSlide(int r10) {
        View r11 = (View) this.f15764w.get();
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.f15766y.isEmpty() == true) goto L17;
        int r12 = 0;
        if (r10 <= this.f15752k) goto L12;
    L9:
        if (r12 >= this.f15766y.size()) goto L18;
        d r13 = (d) this.f15766y.get(r12);
        int r14 = this.f15752k;
        r13.c(r11, (r14 - r10) / (this.f15763v - r14));
        r12 = r12 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r12 >= this.f15766y.size()) goto L19;
        d r15 = (d) this.f15766y.get(r12);
        int r16 = this.f15752k;
        r15.c(r11, (r16 - r10) / (r16 - getExpandedOffset()));
        r12 = r12 + 1;
        goto L12
    L19:
        return;
    }

    public void e(d r10) {
        if (this.f15766y.contains(r10) == true) goto L6;
        this.f15766y.add(r10);
        return;
    }

    public View findScrollingChild(View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.U(r10) == false) goto L9;
        return r10;
    L9:
        if ((r10 instanceof ViewGroup) == false) goto L16;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L16;
        View r14 = findScrollingChild(r11.getChildAt(r13));
        if (r14 != null) goto L14;
        r13 = r13 + 1;
        goto L11
    L14:
        return r14;
    L16:
        return null;
    }

    public final int[] g(View r10, float r11, float r12) {
        int r13 = 0;
        int r14 = 6;
        int r15 = 3;
        if (r12 >= 0.0f) goto L15;
        if (Math.abs(r12) <= 1500.0f) goto L15;
        if (this.f15742a == false) goto L9;
        int r16 = this.f15750i;
    L47:
        return new int[]{r16, r15};
    L9:
        int r17 = r10.getTop();
        int r18 = this.f15751j;
        if (r17 <= r18) goto L12;
        r13 = r18;
    L13:
        r16 = r13;
        r15 = r14;
    L12:
        r14 = 3;
    L15:
        if (this.f15753l == false) goto L24;
        if (shouldHide(r10, r12) == false) goto L24;
        if (r10.getTop() <= this.f15752k) goto L21;
    L22:
        r16 = this.f15763v;
        r15 = 5;
        goto L47
    L21:
        if (Math.abs(r11) < Math.abs(r12)) goto L22;
    L24:
        if (r12 != 0.0f) goto L26;
    L29:
        int r19 = r10.getTop();
        if (this.f15742a == true) goto L32;
        int r20 = this.f15751j;
        if (r19 >= r20) goto L43;
        if (r19 < Math.abs(r19 - this.f15752k)) goto L12;
        r13 = this.f15751j;
        goto L13
    L43:
        if (Math.abs(r19 - r20) >= Math.abs(r19 - this.f15752k)) goto L45;
        r13 = this.f15751j;
        goto L13
    L45:
        r13 = this.f15752k;
    L35:
        r14 = 4;
        goto L13
    L32:
        if (Math.abs(r19 - this.f15750i) >= Math.abs(r19 - this.f15752k)) goto L34;
        r13 = this.f15750i;
        goto L12
    L34:
        r13 = this.f15752k;
        goto L35
    L26:
        if (Math.abs(r11) > Math.abs(r12)) goto L29;
        r16 = this.f15752k;
        r15 = 4;
        goto L47
    }

    public final int getState() {
        return this.f15756o;
    }

    public final float getYVelocity() {
        VelocityTracker r10 = this.f15767z;
        if (r10 != null) goto L6;
        return 0.0f;
    L6:
        r10.computeCurrentVelocity(1000, this.f15745d);
        return this.f15767z.getYVelocity(this.A);
    }

    public void h(d r10) {
        this.f15766y.remove(r10);
    }

    public void i(boolean r10) {
        this.G = r10;
    }

    public boolean isHideable() {
        return this.f15753l;
    }

    public void j(boolean r10) {
        this.H = r10;
    }

    public void k(d r10) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.f15766y.clear();
        if (r10 == null) goto L6;
        this.f15766y.add(r10);
        return;
    }

    public void l(boolean r10) {
        this.f15743b = r10;
    }

    public void m(int r10) {
        this.f15744c = r10;
    }

    public void n(View r10, int r11) {
        if (r11 != 4) goto L6;
        int r12 = this.f15752k;
    L20:
        if (this.f15758q.G(r10, r10.getLeft(), r12) == false) goto L22;
        setStateInternal(2);
        ViewCompat.h0(r10, new f(this, r10, r11));
        return;
    L22:
        setStateInternal(r11);
        return;
    L6:
        if (r11 != 6) goto L12;
        r12 = this.f15751j;
        if (this.f15742a == false) goto L20;
        int r13 = this.f15750i;
        if (r12 > r13) goto L20;
        r11 = 3;
        r12 = r13;
        goto L20
    L12:
        if (r11 != 3) goto L15;
        r12 = getExpandedOffset();
        goto L20
    L15:
        if (this.f15753l == false) goto L25;
        if (r11 != 5) goto L25;
        r12 = this.f15763v;
    L25:
        throw new IllegalArgumentException("Illegal state argument: " + r11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r10, View r11, MotionEvent r12) {
        if (r11.isShown() == true) goto L5;
    L76:
        this.f15760s = true;
        return false;
    L5:
        if (this.f15754m == false) goto L76;
        int r13 = r12.getActionMasked();
        if (r13 != 0) goto L11;
        reset();
    L11:
        if (this.f15767z != null) goto L13;
        this.f15767z = VelocityTracker.obtain();
    L13:
        this.f15767z.addMovement(r12);
        View r14 = null;
        if (r13 == 0) goto L23;
        if (r13 != 1) goto L17;
    L19:
        this.C = false;
        this.A = -1;
        if (this.f15760s == false) goto L39;
        this.f15760s = false;
        return false;
    L39:
        if (this.G == false) goto L48;
        if (this.f15760s == true) goto L48;
        com.obric.oui.panel.b r15 = this.f15759r;
        if (r15 == null) goto L48;
        if (r15.s(r11, r12) == false) goto L48;
        return true;
    L48:
        if (this.f15760s == true) goto L54;
        com.obric.oui.panel.e r16 = this.f15758q;
        if (r16 == null) goto L54;
        if (r16.F(r12) == false) goto L54;
        return true;
    L54:
        WeakReference r17 = this.f15765x;
        if (r17 == null) goto L58;
        r14 = (View) r17.get();
    L58:
        if (r13 != 2) goto L70;
        if (r14 == null) goto L70;
        if (this.f15760s == true) goto L70;
        if (this.f15756o == 1) goto L70;
        if (r10.isPointInChildBounds(r14, (int) r12.getX(), (int) r12.getY()) == true) goto L70;
        if (this.f15758q == null) goto L70;
        if (Math.abs(this.B - r12.getY()) <= this.f15758q.u()) goto L70;
    L75:
        return true;
    L70:
        InterceptTouchEvent r18 = this.F;
        if (r18 != null) goto L73;
        return false;
    L73:
        if (r18.shouldInterceptTouchEvent(r12, this.f15756o, this.f15757p) == true) goto L75;
        return false;
    L17:
        if (r13 == 3) goto L19;
    L23:
        int r19 = (int) r12.getX();
        this.B = (int) r12.getY();
        WeakReference r20 = this.f15765x;
        if (r20 == null) goto L26;
        View r21 = (View) r20.get();
    L27:
        if (r21 == null) goto L32;
        if (r10.isPointInChildBounds(r21, r19, this.B) == false) goto L32;
        this.A = r12.getPointerId(r12.getActionIndex());
        this.C = true;
    L32:
        if (this.A == (-1)) goto L34;
    L36:
        boolean r22 = false;
    L37:
        this.f15760s = r22;
        goto L39
    L34:
        if (r10.isPointInChildBounds(r11, r19, this.B) == true) goto L36;
        r22 = true;
        goto L37
    L26:
        r21 = null;
        goto L27
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
        if (this.E == true) goto L5;
    L9:
        int r13 = r11.getTop();
        r10.onLayoutChild(r11, r12);
        this.f15763v = r10.getHeight();
        if (this.f15747f == true) goto L12;
        this.f15749h = this.f15746e;
    L25:
        if (this.f15744c <= 0) goto L29;
        int r14 = r11.getHeight();
        int r15 = this.f15744c;
        if (r14 <= r15) goto L29;
        this.f15750i = Math.max(0, this.f15763v - r15);
    L30:
        this.f15751j = this.f15763v / 2;
        calculateCollapsedOffset();
        int r16 = this.f15756o;
        if (r16 != 3) goto L34;
        ViewCompat.a0(r11, getExpandedOffset());
    L48:
        if (this.f15758q != null) goto L51;
        com.obric.oui.panel.e r17 = com.obric.oui.panel.e.l(r10, this.f15741J);
        this.f15758q = r17;
        r17.D(this.I);
    L51:
        if (this.G == true) goto L53;
    L55:
        this.f15764w = new WeakReference(r11);
        this.f15765x = new WeakReference(findScrollingChild(r11));
        return true;
    L53:
        if (this.f15759r != null) goto L55;
        this.f15759r = new com.obric.oui.panel.b(r10.getContext(), r10, this.K);
        goto L55
    L34:
        if (r16 != 6) goto L37;
        ViewCompat.a0(r11, this.f15751j);
        goto L48
    L37:
        if (this.f15753l == false) goto L42;
        if (r16 != 5) goto L42;
        ViewCompat.a0(r11, this.f15763v);
    L42:
        if (r16 != 4) goto L44;
        ViewCompat.a0(r11, this.f15752k);
        goto L48
    L44:
        if (r16 == 1) goto L46;
        if (r16 != 2) goto L48;
    L46:
        ViewCompat.a0(r11, r13 - r11.getTop());
    L29:
        this.f15750i = Math.max(0, this.f15763v - r11.getHeight());
        goto L30
    L12:
        if (this.f15748g != 0) goto L14;
        this.f15748g = r10.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L14:
        float r18 = r10.getContext().getResources().getConfiguration().fontScale;
        tc.e.a("check fontScale:" + r18);
        if (this.H == false) goto L17;
        double r19 = 0.6d;
    L18:
        double r20 = this.f15748g;
        int r21 = this.f15744c;
        if (r21 <= 0) goto L21;
        double r22 = r21;
    L22:
        this.f15749h = (int) Math.max(r20, r22);
        goto L25
    L21:
        r22 = ((double) r18) * (((double) this.f15763v) * r19);
        goto L22
    L17:
        r19 = 1.0d;
        goto L18
    L5:
        if (ViewCompat.x(r10) == false) goto L9;
        if (ViewCompat.x(r11) == true) goto L9;
        r11.setFitsSystemWindows(true);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout r10, View r11, View r12, float r13, float r14) {
        if (r12 == this.f15765x.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.f15756o == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r10, r11, r12, r13, r14) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int[] r15, int r16) {
        if (r16 != 1) goto L6;
        return;
    L6:
        if (r12 == ((View) this.f15765x.get())) goto L8;
        return;
    L8:
        int r17 = r11.getTop();
        int r18 = r17 - r14;
        if (r14 > 0) goto L11;
        if (r14 < 0) goto L19;
    L30:
        dispatchOnSlide(r11.getTop());
        this.f15761t = r14;
        this.f15762u = true;
        return;
    L19:
        if (r12.canScrollVertically(-1) == true) goto L30;
        int r19 = this.f15752k;
        if (r18 <= r19) goto L27;
        if (this.f15753l == true) goto L27;
        int r20 = r17 - r19;
        r15[1] = r20;
        ViewCompat.a0(r11, -r20);
        setStateInternal(4);
    L27:
        if (this.f15754m == true) goto L29;
        return;
    L29:
        r15[1] = r14;
        ViewCompat.a0(r11, -r14);
        setStateInternal(1);
        goto L30
    L11:
        if (r18 >= getExpandedOffset()) goto L14;
        int r21 = r17 - getExpandedOffset();
        r15[1] = r21;
        ViewCompat.a0(r11, -r21);
        setStateInternal(3);
        goto L30
    L14:
        if (this.f15754m == true) goto L16;
        return;
    L16:
        r15[1] = r14;
        ViewCompat.a0(r11, -r14);
        setStateInternal(1);
        goto L30
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r10, View r11, Parcelable r12) {
        SavedState r13 = (SavedState) r12;
        super.onRestoreInstanceState(r10, r11, r13.getSuperState());
        int r14 = r13.state;
        if (r14 != 1) goto L5;
    L8:
        this.f15756o = 4;
        return;
    L5:
        if (r14 == 2) goto L8;
        this.f15756o = r14;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r10, View r11) {
        return new SavedState(super.onSaveInstanceState(r10, r11), this.f15756o);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r10, View r11, View r12, View r13, int r14, int r15) {
        this.f15761t = 0;
        this.f15762u = false;
        if ((r14 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout r10, View r11, View r12, int r13) {
        int r14 = 3;
        if (r11.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (r12 == this.f15765x.get()) goto L9;
        return;
    L9:
        if (this.f15762u == true) goto L12;
        return;
    L12:
        if (this.f15761t <= 0) goto L15;
        int r15 = getExpandedOffset();
    L40:
        this.f15757p = r14;
        if (this.f15758q.G(r11, r11.getLeft(), r15) == false) goto L43;
        setStateInternal(2);
        ViewCompat.h0(r11, new f(this, r11, r14));
    L44:
        this.f15762u = false;
        return;
    L43:
        setStateInternal(r14);
        goto L44
    L15:
        if (this.f15753l == false) goto L20;
        if (shouldHide(r11, getYVelocity()) == false) goto L20;
        r15 = this.f15763v;
        r14 = 5;
    L20:
        if (this.f15761t != 0) goto L38;
        int r16 = r11.getTop();
        if (this.f15742a == true) goto L24;
        int r17 = this.f15751j;
        if (r16 >= r17) goto L35;
        if (r16 >= Math.abs(r16 - this.f15752k)) goto L32;
        r15 = 0;
        goto L40
    L32:
        r15 = this.f15751j;
    L33:
        r14 = 6;
        goto L40
    L35:
        if (Math.abs(r16 - r17) >= Math.abs(r16 - this.f15752k)) goto L37;
        r15 = this.f15751j;
        goto L33
    L37:
        r15 = this.f15752k;
    L39:
        r14 = 4;
        goto L40
    L24:
        if (Math.abs(r16 - this.f15750i) >= Math.abs(r16 - this.f15752k)) goto L26;
        r15 = this.f15750i;
        goto L40
    L26:
        r15 = this.f15752k;
        goto L39
    L38:
        r15 = this.f15752k;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r10, View r11, MotionEvent r12) {
        if (r11.isShown() == true) goto L6;
        return false;
    L6:
        int r13 = r12.getActionMasked();
        if (this.f15756o != 1) goto L10;
        if (r13 != 0) goto L10;
        return true;
    L10:
        if (r13 != 0) goto L13;
        reset();
    L13:
        if (this.f15767z != null) goto L15;
        this.f15767z = VelocityTracker.obtain();
    L15:
        this.f15767z.addMovement(r12);
        if (this.G == false) goto L22;
        com.obric.oui.panel.b r14 = this.f15759r;
        if (r14 == null) goto L22;
        if (r14.n() == false) goto L22;
        this.f15759r.p(r12, r11, this.f15756o, this.f15767z);
    L26:
        if (this.G == false) goto L34;
        com.obric.oui.panel.b r15 = this.f15759r;
        if (r15 == null) goto L34;
        if (r15.n() == false) goto L34;
        return !this.f15760s;
    L34:
        if (r13 != 2) goto L41;
        if (this.f15760s == true) goto L41;
        if (Math.abs(this.B - r12.getY()) <= this.f15758q.u()) goto L41;
        this.f15758q.b(r11, r12.getPointerId(r12.getActionIndex()));
    L41:
        return !this.f15760s;
    L22:
        com.obric.oui.panel.e r16 = this.f15758q;
        if (r16 == null) goto L26;
        r16.processTouchEvent(r12);
        goto L26
    }

    public final void reset() {
        this.A = -1;
        VelocityTracker r10 = this.f15767z;
        if (r10 == null) goto L6;
        r10.recycle();
        this.f15767z = null;
        return;
    }

    public void setDraggable(boolean r10) {
        this.f15754m = r10;
    }

    public void setFitToContents(boolean r10) {
        if (this.f15742a != r10) goto L5;
        return;
    L5:
        this.f15742a = r10;
        if (this.f15764w == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.f15742a == true) goto L11;
    L13:
        int r11 = this.f15756o;
    L14:
        setStateInternal(r11);
        return;
    L11:
        if (this.f15756o != 6) goto L13;
        r11 = 3;
        goto L14
    }

    public void setHideable(boolean r10) {
        this.f15753l = r10;
    }

    public void setInterceptTouchEvent(InterceptTouchEvent r10) {
        this.F = r10;
    }

    public final void setPeekHeight(int r10) {
        if (r10 != (-1)) goto L8;
        if (this.f15747f == true) goto L20;
        this.f15747f = true;
    L13:
        if (this.f15756o != 4) goto L22;
        WeakReference r11 = this.f15764w;
        if (r11 == null) goto L23;
        View r12 = (View) r11.get();
        if (r12 == null) goto L24;
        r12.requestLayout();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L8:
        if (this.f15747f == false) goto L10;
    L11:
        this.f15747f = false;
        this.f15746e = Math.max(0, r10);
        this.f15752k = this.f15763v - r10;
        goto L13
    L10:
        if (this.f15746e != r10) goto L11;
    }

    public void setSkipCollapsed(boolean r10) {
        this.f15755n = r10;
    }

    public final void setState(int r10) {
        if (r10 != this.f15756o) goto L5;
        return;
    L5:
        WeakReference r11 = this.f15764w;
        if (r11 == null) goto L8;
        View r12 = (View) r11.get();
        if (r12 != null) goto L22;
        return;
    L22:
        ViewParent r13 = r12.getParent();
        if (r13 != null) goto L25;
    L29:
        n(r12, r10);
        return;
    L25:
        if (r13.isLayoutRequested() == false) goto L29;
        if (ViewCompat.S(r12) == false) goto L29;
        r12.post(new a(this, r12, r10));
        return;
    L8:
        if (r10 != 4) goto L10;
    L17:
        this.f15756o = r10;
        return;
    L10:
        if (r10 == 3) goto L17;
        if (r10 == 6) goto L17;
        if (this.f15753l == true) goto L16;
        return;
    L16:
        if (r10 == 5) goto L17;
    }

    public void setStateInternal(int r10) {
        if (this.f15756o != r10) goto L5;
        return;
    L5:
        this.f15756o = r10;
        int r11 = 0;
        if (r10 != 6) goto L8;
    L15:
        updateImportantForAccessibility(true);
    L16:
        View r12 = (View) this.f15764w.get();
    L18:
        if (r11 >= this.f15766y.size()) goto L20;
        ((d) this.f15766y.get(r11)).d(r12, r10);
        r11 = r11 + 1;
        goto L18
    L20:
        return;
    L8:
        if (r10 == 3) goto L15;
        if (r10 != 5) goto L13;
    L14:
        updateImportantForAccessibility(false);
        goto L16
    L13:
        if (r10 != 4) goto L16;
        goto L14
    }

    public boolean shouldHide(View r10, float r11) {
        if (this.f15755n == false) goto L6;
        return true;
    L6:
        if (r11 != 0.0f) goto L18;
        if (this.f15743b == false) goto L14;
        if (r10.getTop() <= (this.f15752k + (this.f15749h / 2))) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (r10.getTop() <= (((this.f15763v - getExpandedOffset()) / 2) + getExpandedOffset())) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.f15757p != 4) goto L27;
        if (this.f15746e <= (tc.f.m(r10.getContext()) / 2)) goto L27;
        if (r11 <= (this.f15745d * 0.08f)) goto L25;
        return true;
    L25:
        return false;
    L27:
        if ((Math.abs((r10.getTop() + (r11 * 0.1f)) - this.f15752k) / this.f15746e) <= 0.5f) goto L30;
        return true;
    L30:
        return false;
    }

    public final void updateImportantForAccessibility(boolean r10) {
        WeakReference r11 = this.f15764w;
        if (r11 != null) goto L5;
        return;
    L5:
        ViewParent r12 = ((View) r11.get()).getParent();
        if ((r12 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r13 = (CoordinatorLayout) r12;
        int r14 = r13.getChildCount();
        if (r10 == true) goto L11;
    L14:
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L27;
        View r16 = r13.getChildAt(r15);
        if (r16 == this.f15764w.get()) goto L26;
        if (r10 == true) goto L25;
        Map r17 = this.D;
        if (r17 == null) goto L26;
        if (r17.containsKey(r16) == false) goto L26;
        ViewCompat.A0(r16, ((Integer) this.D.get(r16)).intValue());
        goto L26
    L25:
        this.D.put(r16, Integer.valueOf(r16.getImportantForAccessibility()));
        ViewCompat.A0(r16, 4);
    L26:
        r15 = r15 + 1;
        goto L15
    L27:
        if (r10 == true) goto L36;
        this.D = null;
        return;
    L36:
        return;
    L11:
        if (this.D != null) goto L13;
        this.D = new HashMap(r14);
        goto L14
    }

    public BottomSheetBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f15742a = true;
        this.f15743b = false;
        this.f15744c = -1;
        this.f15754m = true;
        this.f15755n = false;
        this.f15756o = 4;
        this.f15757p = 4;
        this.f15766y = new ArrayList();
        this.E = true;
        this.G = false;
        this.H = true;
        this.I = 600;
        this.f15741J = new b(this);
        this.K = new c(this);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.BottomSheetBehavior_Layout);
        int r13 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue r14 = r12.peekValue(r13);
        if (r14 == null) goto L7;
        int r15 = r14.data;
        if (r15 != (-1)) goto L7;
        setPeekHeight(r15);
    L8:
        setHideable(r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r12.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        r12.recycle();
        this.f15745d = ViewConfiguration.get(r10).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r12.getDimensionPixelSize(r13, -1));
        goto L8
    }
}
