package stepos.support.v4.view;

import P.e;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.view.C0456a;
import androidx.core.view.C0473s;
import androidx.core.view.E;
import androidx.core.view.H;
import androidx.core.view.L;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: G0, reason: collision with root package name */
    private static final boolean f20402G0 = "eng".equals(Build.TYPE);

    /* renamed from: H0, reason: collision with root package name */
    private static final int[] f20403H0 = {R.attr.layout_gravity};

    /* renamed from: I0, reason: collision with root package name */
    private static final Comparator<h> f20404I0 = new a();

    /* renamed from: J0, reason: collision with root package name */
    private static final Interpolator f20405J0 = new b();

    /* renamed from: K0, reason: collision with root package name */
    private static final o f20406K0 = new o();

    /* renamed from: L0, reason: collision with root package name */
    private static final p f20407L0 = new p();

    /* renamed from: M0, reason: collision with root package name */
    private static final float[] f20408M0 = {0.0f, 0.0f, 0.003365234f, 0.01357806f, 0.030720964f, 0.05475371f, 0.08548926f, 0.12255032f, 0.16538717f, 0.21324258f, 0.2652047f, 0.32024413f, 0.37725833f, 0.4351431f, 0.49284747f, 0.5494277f, 0.6040792f, 0.6561299f, 0.7050707f, 0.7505254f, 0.7922336f, 0.8300537f, 0.86390066f, 0.8937803f, 0.91972214f, 0.94181687f, 0.9601534f, 0.974861f, 0.98606336f, 0.99389625f, 0.99851006f, 1.0f};

    /* renamed from: N0, reason: collision with root package name */
    private static final Interpolator f20409N0 = new f();

    /* renamed from: O0, reason: collision with root package name */
    private static final Interpolator f20410O0 = androidx.core.view.animation.a.a(0.33f, 0.0f, 0.2f, 1.0f);

    /* renamed from: A, reason: collision with root package name */
    private int f20411A;

    /* renamed from: A0, reason: collision with root package name */
    private int f20412A0;

    /* renamed from: B, reason: collision with root package name */
    private float f20413B;

    /* renamed from: B0, reason: collision with root package name */
    private final e.r f20414B0;

    /* renamed from: C, reason: collision with root package name */
    private float f20415C;

    /* renamed from: C0, reason: collision with root package name */
    private final e.q f20416C0;

    /* renamed from: D, reason: collision with root package name */
    private int f20417D;

    /* renamed from: D0, reason: collision with root package name */
    private float f20418D0;

    /* renamed from: E, reason: collision with root package name */
    private int f20419E;

    /* renamed from: E0, reason: collision with root package name */
    private Interpolator f20420E0;

    /* renamed from: F, reason: collision with root package name */
    private boolean f20421F;

    /* renamed from: F0, reason: collision with root package name */
    private Interpolator f20422F0;

    /* renamed from: G, reason: collision with root package name */
    private boolean f20423G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f20424H;

    /* renamed from: I, reason: collision with root package name */
    private int f20425I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f20426J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f20427K;

    /* renamed from: L, reason: collision with root package name */
    private int f20428L;

    /* renamed from: M, reason: collision with root package name */
    private int f20429M;

    /* renamed from: Q, reason: collision with root package name */
    private int f20430Q;

    /* renamed from: R, reason: collision with root package name */
    private float f20431R;

    /* renamed from: S, reason: collision with root package name */
    private float f20432S;

    /* renamed from: T, reason: collision with root package name */
    private float f20433T;

    /* renamed from: U, reason: collision with root package name */
    private float f20434U;

    /* renamed from: V, reason: collision with root package name */
    private int f20435V;

    /* renamed from: W, reason: collision with root package name */
    private VelocityTracker f20436W;

    /* renamed from: a, reason: collision with root package name */
    private int f20437a;

    /* renamed from: a0, reason: collision with root package name */
    private int f20438a0;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<h> f20439b;

    /* renamed from: b0, reason: collision with root package name */
    private int f20440b0;

    /* renamed from: c, reason: collision with root package name */
    private final h f20441c;

    /* renamed from: c0, reason: collision with root package name */
    private int f20442c0;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f20443d;

    /* renamed from: d0, reason: collision with root package name */
    private int f20444d0;

    /* renamed from: e, reason: collision with root package name */
    private androidx.viewpager.widget.a f20445e;

    /* renamed from: e0, reason: collision with root package name */
    private Rect f20446e0;

    /* renamed from: f, reason: collision with root package name */
    private int f20447f;

    /* renamed from: f0, reason: collision with root package name */
    private int f20448f0;

    /* renamed from: g, reason: collision with root package name */
    private volatile g f20449g;

    /* renamed from: g0, reason: collision with root package name */
    private int f20450g0;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f20451h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f20452h0;

    /* renamed from: i, reason: collision with root package name */
    private int f20453i;

    /* renamed from: i0, reason: collision with root package name */
    private androidx.core.widget.d f20454i0;

    /* renamed from: j, reason: collision with root package name */
    private int f20455j;

    /* renamed from: j0, reason: collision with root package name */
    private androidx.core.widget.d f20456j0;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f20457k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f20458k0;

    /* renamed from: l, reason: collision with root package name */
    private int f20459l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f20460l0;

    /* renamed from: m, reason: collision with root package name */
    private int f20461m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f20462m0;

    /* renamed from: n, reason: collision with root package name */
    private int f20463n;

    /* renamed from: n0, reason: collision with root package name */
    private int f20464n0;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f20465o;

    /* renamed from: o0, reason: collision with root package name */
    private List<l> f20466o0;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f20467p;

    /* renamed from: p0, reason: collision with root package name */
    private l f20468p0;

    /* renamed from: q, reason: collision with root package name */
    private int f20469q;

    /* renamed from: q0, reason: collision with root package name */
    private l f20470q0;

    /* renamed from: r, reason: collision with root package name */
    private Context f20471r;

    /* renamed from: r0, reason: collision with root package name */
    private Method f20472r0;

    /* renamed from: s, reason: collision with root package name */
    private int f20473s;

    /* renamed from: s0, reason: collision with root package name */
    private float f20474s0;

    /* renamed from: t, reason: collision with root package name */
    private Parcelable f20475t;

    /* renamed from: t0, reason: collision with root package name */
    private float f20476t0;

    /* renamed from: u, reason: collision with root package name */
    private ClassLoader f20477u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f20478u0;

    /* renamed from: v, reason: collision with root package name */
    private Scroller f20479v;

    /* renamed from: v0, reason: collision with root package name */
    private P.i f20480v0;

    /* renamed from: w, reason: collision with root package name */
    private m f20481w;

    /* renamed from: w0, reason: collision with root package name */
    private P.j f20482w0;

    /* renamed from: x, reason: collision with root package name */
    private int f20483x;

    /* renamed from: x0, reason: collision with root package name */
    private int f20484x0;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f20485y;

    /* renamed from: y0, reason: collision with root package name */
    private LinkedList<View> f20486y0;

    /* renamed from: z, reason: collision with root package name */
    private int f20487z;

    /* renamed from: z0, reason: collision with root package name */
    private final Runnable f20488z0;

    class a implements Comparator<h> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            return hVar.f20496b - hVar2.f20496b;
        }
    }

    class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f5) {
            float f6 = f5 - 1.0f;
            return (f6 * f6 * f6 * f6 * f6) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            ViewPager.this.setScrollState(0);
            ViewPager.this.M();
        }
    }

    class d implements e.r {
        d() {
        }

        @Override // P.e.r
        public void a(P.e eVar, float f5, float f6) {
            ViewPager.this.J((int) f5);
        }
    }

    class e implements e.q {
        e() {
        }

        @Override // P.e.q
        public void a(P.e eVar, boolean z5, float f5, float f6) throws Resources.NotFoundException {
            ViewPager.this.setScrollState(0);
            ViewPager.this.M();
        }
    }

    class f implements Interpolator {
        f() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f5) {
            if (f5 <= 0.0f) {
                return ViewPager.f20408M0[0];
            }
            if (f5 >= 1.0f) {
                return ViewPager.f20408M0[ViewPager.f20408M0.length - 1];
            }
            float length = 1.0f / (ViewPager.f20408M0.length - 1);
            int i5 = (int) (f5 / length);
            return ViewPager.f20408M0[i5] + (((ViewPager.f20408M0[i5 + 1] - ViewPager.f20408M0[i5]) * (f5 - (i5 * length))) / length);
        }
    }

    public enum g {
        FLIP_MODE_DEFAULT,
        FLIP_MODE_OVERLAY
    }

    static class h {

        /* renamed from: a, reason: collision with root package name */
        Object f20495a;

        /* renamed from: b, reason: collision with root package name */
        int f20496b;

        /* renamed from: c, reason: collision with root package name */
        boolean f20497c;

        /* renamed from: d, reason: collision with root package name */
        float f20498d;

        /* renamed from: e, reason: collision with root package name */
        float f20499e;

        /* renamed from: f, reason: collision with root package name */
        View f20500f;

        /* renamed from: g, reason: collision with root package name */
        int f20501g;

        h() {
        }
    }

    class j extends C0456a {
        j() {
        }

        private boolean a() {
            return ViewPager.this.f20445e != null && ViewPager.this.f20445e.c() > 1;
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            E.e eVarA = E.e.a();
            eVarA.f(a());
            if (accessibilityEvent.getEventType() != 4096 || ViewPager.this.f20445e == null) {
                return;
            }
            eVarA.c(ViewPager.this.f20445e.c());
            eVarA.b(ViewPager.this.f20447f);
            eVarA.h(ViewPager.this.f20447f);
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.d0(ViewPager.class.getName());
            cVar.w0(a());
            if (ViewPager.this.canScrollHorizontally(1)) {
                cVar.a(RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        @Override // androidx.core.view.C0456a
        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) throws Resources.NotFoundException {
            if (super.performAccessibilityAction(view, i5, bundle)) {
                return true;
            }
            if (i5 == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f20447f + 1);
                return true;
            }
            if (i5 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f20447f - 1);
            return true;
        }
    }

    interface k {
    }

    public interface l {
        void a(int i5, float f5, int i6);

        void b(int i5);

        void c(int i5);
    }

    private class m extends DataSetObserver {
        private m() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            ViewPager.this.m();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.m();
        }

        /* synthetic */ m(ViewPager viewPager, a aVar) {
            this();
        }
    }

    public static class n extends View.BaseSavedState {
        public static final Parcelable.Creator<n> CREATOR = androidx.core.os.g.a(new a());

        /* renamed from: a, reason: collision with root package name */
        int f20510a;

        /* renamed from: b, reason: collision with root package name */
        Parcelable f20511b;

        /* renamed from: c, reason: collision with root package name */
        ClassLoader f20512c;

        class a implements androidx.core.os.h<n> {
            a() {
            }

            @Override // androidx.core.os.h
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new n(parcel, classLoader);
            }

            @Override // androidx.core.os.h
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public n[] newArray(int i5) {
                return new n[i5];
            }
        }

        public n(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f20510a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f20510a);
            parcel.writeParcelable(this.f20511b, i5);
        }

        n(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f20510a = parcel.readInt();
            this.f20511b = parcel.readParcelable(classLoader);
            this.f20512c = classLoader;
        }
    }

    static class o implements Comparator<View> {
        o() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            i iVar = (i) view.getLayoutParams();
            i iVar2 = (i) view2.getLayoutParams();
            boolean z5 = iVar.f20502a;
            return z5 != iVar2.f20502a ? z5 ? 1 : -1 : iVar.f20506e - iVar2.f20506e;
        }
    }

    static class p implements Comparator<View> {
        p() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            i iVar = (i) view.getLayoutParams();
            i iVar2 = (i) view2.getLayoutParams();
            boolean z5 = iVar.f20502a;
            return z5 != iVar2.f20502a ? z5 ? 1 : -1 : iVar2.f20506e - iVar.f20506e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        this.f20439b = new ArrayList<>();
        this.f20441c = new h();
        this.f20443d = new Rect();
        this.f20449g = g.FLIP_MODE_DEFAULT;
        this.f20473s = -1;
        this.f20475t = null;
        this.f20477u = null;
        this.f20413B = -3.4028235E38f;
        this.f20415C = Float.MAX_VALUE;
        this.f20425I = 1;
        this.f20435V = -1;
        this.f20450g0 = -1;
        this.f20458k0 = true;
        this.f20460l0 = false;
        this.f20474s0 = 290.0f;
        this.f20476t0 = 0.94f;
        this.f20478u0 = true;
        this.f20488z0 = new c();
        this.f20412A0 = 0;
        this.f20414B0 = new d();
        this.f20416C0 = new e();
        this.f20418D0 = 0.5f;
        this.f20471r = context;
        B();
    }

    private void A() {
        int clientWidth = getClientWidth();
        int paddingLeft = getPaddingLeft();
        int scrollX = getScrollX();
        for (int i5 = 0; i5 < this.f20439b.size(); i5++) {
            h hVar = this.f20439b.get(i5);
            hVar.f20501g = i5;
            if (((int) (clientWidth * hVar.f20499e)) + paddingLeft == scrollX) {
                this.f20453i = i5;
            }
            if (hVar.f20496b == this.f20447f) {
                this.f20455j = i5;
            }
        }
    }

    private boolean C(float f5, float f6) {
        if (f5 >= this.f20429M || f6 <= 0.0f) {
            return f5 > ((float) (getWidth() - this.f20429M)) && f6 < 0.0f;
        }
        return true;
    }

    private boolean D() {
        return X();
    }

    private boolean E() {
        P.j jVar = this.f20482w0;
        return jVar != null && Math.abs(jVar.b() - ((float) getScrollX())) > ((float) this.f20444d0);
    }

    private void G(MotionEvent motionEvent) {
        int iB = C0473s.b(motionEvent);
        if (C0473s.e(motionEvent, iB) == this.f20435V) {
            int i5 = iB == 0 ? 1 : 0;
            this.f20431R = C0473s.f(motionEvent, i5);
            this.f20435V = C0473s.e(motionEvent, i5);
            VelocityTracker velocityTracker = this.f20436W;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(int i5) {
        if (this.f20439b.size() == 0) {
            this.f20462m0 = false;
            F(0, 0.0f, 0);
            if (this.f20462m0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        h hVarY = y();
        int clientWidth = getClientWidth();
        int i6 = this.f20483x;
        int i7 = clientWidth + i6;
        float f5 = clientWidth;
        int i8 = hVarY.f20496b;
        float f6 = ((i5 / f5) - hVarY.f20499e) / (hVarY.f20498d + (i6 / f5));
        this.f20462m0 = false;
        F(i8, f6, (int) (i7 * f6));
        if (this.f20462m0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean K(float f5) {
        boolean z5;
        float f6 = this.f20431R - f5;
        this.f20431R = f5;
        float scrollX = getScrollX() + R(f6);
        float clientWidth = getClientWidth();
        float f7 = this.f20413B * clientWidth;
        float f8 = this.f20415C * clientWidth;
        h hVar = this.f20439b.get(0);
        ArrayList<h> arrayList = this.f20439b;
        boolean z6 = true;
        h hVar2 = arrayList.get(arrayList.size() - 1);
        if (hVar.f20496b != 0) {
            f7 = hVar.f20499e * clientWidth;
            z5 = false;
        } else {
            z5 = true;
        }
        if (hVar2.f20496b != this.f20445e.c() - 1) {
            f8 = hVar2.f20499e * clientWidth;
            z6 = false;
        }
        if (!this.f20478u0) {
            if (scrollX < f7) {
                zC = z5 ? this.f20454i0.c(Math.abs(f7 - scrollX) / clientWidth) : false;
                scrollX = f7;
            } else if (scrollX > f8) {
                zC = z6 ? this.f20456j0.c(Math.abs(scrollX - f8) / clientWidth) : false;
                scrollX = f8;
            }
        }
        int i5 = (int) scrollX;
        this.f20431R += scrollX - i5;
        if (g.FLIP_MODE_OVERLAY == this.f20449g) {
            S(i5);
        }
        scrollTo(i5, getScrollY());
        J(i5);
        return zC;
    }

    private boolean L(MotionEvent motionEvent, Rect rect) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (f20402G0) {
            Log.d("ViewPager", "pointInRect x = " + rawX + ", y = " + rawY + ", rect = " + rect);
        }
        return rect != null && this.f20447f == this.f20448f0 && rawX >= ((float) rect.left) && rawX <= ((float) rect.right) && rawY >= ((float) rect.top) && rawY <= ((float) rect.bottom);
    }

    private void O(int i5, int i6, int i7, int i8) {
        if (i6 <= 0 || this.f20439b.isEmpty()) {
            h hVarZ = z(this.f20447f);
            int iMin = (int) ((hVarZ != null ? Math.min(hVarZ.f20499e, this.f20415C) : 0.0f) * ((i5 - getPaddingLeft()) - getPaddingRight()));
            if (iMin != getScrollX()) {
                l(false);
                scrollTo(iMin, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = ((i5 - getPaddingLeft()) - getPaddingRight()) + i7;
        int scrollX = (int) ((getScrollX() / (((i6 - getPaddingLeft()) - getPaddingRight()) + i8)) * paddingLeft);
        scrollTo(scrollX, getScrollY());
        int duration = this.f20479v.getDuration() - this.f20479v.timePassed();
        h hVarZ2 = z(this.f20447f);
        if (hVarZ2 != null) {
            this.f20479v.startScroll(scrollX, 0, (int) ((hVarZ2.f20499e * i5) - scrollX), 0, duration);
        } else {
            this.f20479v.startScroll(scrollX, 0, -(scrollX % paddingLeft), 0, duration);
        }
    }

    private void P() {
        int i5 = 0;
        while (i5 < getChildCount()) {
            if (!((i) getChildAt(i5).getLayoutParams()).f20502a) {
                removeViewAt(i5);
                i5--;
            }
            i5++;
        }
    }

    private void Q(boolean z5) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z5);
        }
    }

    private void S(int i5) {
        int size;
        int i6;
        int i7;
        if (this.f20439b.size() == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int clientWidth = getClientWidth();
        if (this.f20453i >= this.f20439b.size()) {
            size = this.f20439b.size() - 1;
        } else {
            size = this.f20453i;
            if (size < 0) {
                size = 0;
            }
        }
        float f5 = clientWidth;
        int i8 = ((int) (this.f20439b.get(size).f20499e * f5)) + paddingLeft;
        View view = this.f20439b.get(size).f20500f;
        int i9 = size - 1;
        h hVar = i9 >= 0 ? this.f20439b.get(i9) : null;
        int i10 = size + 1;
        h hVar2 = i10 < this.f20439b.size() ? this.f20439b.get(i10) : null;
        View view2 = hVar != null ? hVar.f20500f : null;
        View view3 = hVar2 != null ? hVar2.f20500f : null;
        int i11 = i5 - i8;
        int i12 = this.f20483x;
        if (i11 >= clientWidth + (i12 / 2)) {
            size = i10;
        } else if (i11 <= (-((i12 / 2) + clientWidth))) {
            size = i9;
        }
        if (size < 0) {
            size = 0;
        } else if (size >= this.f20439b.size()) {
            size = this.f20439b.size() - 1;
        }
        if (this.f20453i != size) {
            this.f20453i = size;
            i8 = ((int) (this.f20439b.get(size).f20499e * f5)) + paddingLeft;
            view = this.f20439b.get(size).f20500f;
            if (view != null) {
                view.offsetLeftAndRight(i8 - view.getLeft());
            }
            if (size + 2 < this.f20439b.size() && view3 != null) {
                view3.offsetLeftAndRight((((int) (hVar2.f20499e * f5)) + paddingLeft) - view3.getLeft());
            }
            if (size - 2 >= 0 && view2 != null) {
                view2.offsetLeftAndRight((((int) (hVar.f20499e * f5)) + paddingLeft) - view2.getLeft());
            }
            int i13 = size - 1;
            hVar = i13 >= 0 ? this.f20439b.get(i13) : null;
            int i14 = size + 1;
            hVar2 = i14 < this.f20439b.size() ? this.f20439b.get(i14) : null;
            view2 = hVar != null ? hVar.f20500f : null;
            view3 = hVar2 != null ? hVar2.f20500f : null;
            i11 = i5 - i8;
        }
        if (view != null) {
            this.f20461m = view.getMeasuredHeight();
            this.f20463n = view.getTop();
            int i15 = this.f20455j;
            h hVar3 = (i15 < 0 || i15 >= this.f20439b.size()) ? null : this.f20439b.get(this.f20455j);
            int i16 = hVar3 != null ? ((int) (hVar3.f20499e * f5)) + paddingLeft : 0;
            if (hVar2 == null || view3 == null) {
                i6 = 0;
                i7 = 0;
            } else {
                i6 = paddingLeft + ((int) (hVar2.f20499e * f5));
                i7 = ((i6 - (clientWidth / 2)) - (this.f20483x / 2)) + (i11 / 2);
            }
            int i17 = (hVar == null || view2 == null) ? 0 : paddingLeft + ((int) (f5 * hVar.f20499e));
            if ((hVar3 != null && i5 == i16) || i5 == i8) {
                this.f20457k = false;
                if (view3 != null) {
                    view3.offsetLeftAndRight(i6 - view3.getLeft());
                }
                if (view2 != null) {
                    view2.offsetLeftAndRight(i17 - view2.getLeft());
                }
                view.offsetLeftAndRight(i8 - view.getLeft());
                return;
            }
            if (i11 >= 0 && view3 != null) {
                this.f20459l = view.getRight();
                this.f20469q = (int) (102.0d - (((i11 * 1.0d) / clientWidth) * 102.0d));
                this.f20457k = true;
                view3.offsetLeftAndRight(i7 - view3.getLeft());
                return;
            }
            if (i11 >= 0 || view2 == null) {
                return;
            }
            this.f20459l = view2.getRight();
            this.f20469q = (int) ((((-i11) * 1.0d) / clientWidth) * 102.0d);
            this.f20457k = true;
            view.offsetLeftAndRight((i8 + (i11 / 2)) - view.getLeft());
        }
    }

    private void T(int i5, boolean z5, int i6, boolean z6) throws Resources.NotFoundException {
        h hVarZ = z(i5);
        int clientWidth = hVarZ != null ? (int) (getClientWidth() * Math.max(this.f20413B, Math.min(hVarZ.f20499e, this.f20415C))) : 0;
        if (z5) {
            if (z6) {
                p(i5);
            }
            Y(clientWidth, 0, i6);
        } else {
            if (z6) {
                p(i5);
            }
            l(false);
            scrollTo(clientWidth, 0);
            J(clientWidth);
        }
    }

    private boolean X() {
        if (!this.f20451h) {
            return (this.f20465o == null || this.f20467p == null) ? false : true;
        }
        this.f20451h = false;
        Drawable drawable = this.f20465o;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f20461m);
        }
        Drawable drawable2 = this.f20467p;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getClientWidth(), this.f20461m);
        }
        return (this.f20465o == null || this.f20467p == null) ? false : true;
    }

    private void Z() {
        int i5 = 0;
        if (g.FLIP_MODE_OVERLAY == this.f20449g) {
            LinkedList<View> linkedList = this.f20486y0;
            if (linkedList == null) {
                this.f20486y0 = new LinkedList<>();
            } else {
                linkedList.clear();
            }
            int childCount = getChildCount();
            while (i5 < childCount) {
                this.f20486y0.add(getChildAt(i5));
                i5++;
            }
            Collections.sort(this.f20486y0, f20407L0);
            return;
        }
        if (this.f20484x0 != 0) {
            LinkedList<View> linkedList2 = this.f20486y0;
            if (linkedList2 == null) {
                this.f20486y0 = new LinkedList<>();
            } else {
                linkedList2.clear();
            }
            int childCount2 = getChildCount();
            while (i5 < childCount2) {
                this.f20486y0.add(getChildAt(i5));
                i5++;
            }
            Collections.sort(this.f20486y0, f20406K0);
        }
    }

    private void a0(float f5, float f6, int i5) {
        k();
        if (this.f20480v0 == null) {
            this.f20480v0 = new P.i(this, P.e.f4500z);
            this.f20482w0 = new P.j();
            this.f20480v0.c(this.f20414B0);
            this.f20480v0.b(this.f20416C0);
        }
        this.f20482w0.g(f6 + f5);
        this.f20482w0.f(this.f20476t0).h(this.f20474s0);
        this.f20480v0.m(f5);
        this.f20480v0.n(i5);
        this.f20480v0.x(this.f20482w0);
        this.f20480v0.p();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void i(h hVar, int i5, h hVar2) {
        int i6;
        int i7;
        h hVar3;
        h hVar4;
        int iC = this.f20445e.c();
        int clientWidth = getClientWidth();
        float f5 = clientWidth > 0 ? this.f20483x / clientWidth : 0.0f;
        if (hVar2 != null) {
            int i8 = hVar2.f20496b;
            int i9 = hVar.f20496b;
            if (i8 < i9) {
                float fE = hVar2.f20499e + hVar2.f20498d + f5;
                int i10 = i8 + 1;
                int i11 = 0;
                while (i10 <= hVar.f20496b && i11 < this.f20439b.size()) {
                    h hVar5 = this.f20439b.get(i11);
                    while (true) {
                        hVar4 = hVar5;
                        if (i10 <= hVar4.f20496b || i11 >= this.f20439b.size() - 1) {
                            break;
                        }
                        i11++;
                        hVar5 = this.f20439b.get(i11);
                    }
                    while (i10 < hVar4.f20496b) {
                        fE += this.f20445e.e(i10) + f5;
                        i10++;
                    }
                    hVar4.f20499e = fE;
                    fE += hVar4.f20498d + f5;
                    i10++;
                }
            } else if (i8 > i9) {
                int size = this.f20439b.size() - 1;
                float fE2 = hVar2.f20499e;
                while (true) {
                    i8--;
                    if (i8 < hVar.f20496b || size < 0) {
                        break;
                    }
                    h hVar6 = this.f20439b.get(size);
                    while (true) {
                        hVar3 = hVar6;
                        if (i8 >= hVar3.f20496b || size <= 0) {
                            break;
                        }
                        size--;
                        hVar6 = this.f20439b.get(size);
                    }
                    while (i8 > hVar3.f20496b) {
                        fE2 -= this.f20445e.e(i8) + f5;
                        i8--;
                    }
                    fE2 -= hVar3.f20498d + f5;
                    hVar3.f20499e = fE2;
                }
            }
        }
        int size2 = this.f20439b.size();
        float fE3 = hVar.f20499e;
        int i12 = hVar.f20496b;
        int i13 = i12 - 1;
        this.f20413B = i12 == 0 ? fE3 : -3.4028235E38f;
        int i14 = iC - 1;
        this.f20415C = i12 == i14 ? (hVar.f20498d + fE3) - 1.0f : Float.MAX_VALUE;
        int i15 = i5 - 1;
        while (i15 >= 0) {
            h hVar7 = this.f20439b.get(i15);
            while (true) {
                i7 = hVar7.f20496b;
                if (i13 <= i7) {
                    break;
                }
                fE3 -= this.f20445e.e(i13) + f5;
                i13--;
            }
            fE3 -= hVar7.f20498d + f5;
            hVar7.f20499e = fE3;
            if (i7 == 0) {
                this.f20413B = fE3;
            }
            i15--;
            i13--;
        }
        float fE4 = hVar.f20499e + hVar.f20498d + f5;
        int i16 = hVar.f20496b + 1;
        int i17 = i5 + 1;
        while (i17 < size2) {
            h hVar8 = this.f20439b.get(i17);
            while (true) {
                i6 = hVar8.f20496b;
                if (i16 >= i6) {
                    break;
                }
                fE4 += this.f20445e.e(i16) + f5;
                i16++;
            }
            if (i6 == i14) {
                this.f20415C = (hVar8.f20498d + fE4) - 1.0f;
            }
            hVar8.f20499e = fE4;
            fE4 += hVar8.f20498d + f5;
            i17++;
            i16++;
        }
        this.f20460l0 = false;
    }

    private void k() {
        P.i iVar = this.f20480v0;
        if (iVar == null || !iVar.i()) {
            return;
        }
        this.f20480v0.d();
    }

    private void l(boolean z5) {
        boolean z6 = this.f20412A0 == 2;
        if (z6) {
            setScrollingCacheEnabled(false);
            if (this.f20478u0) {
                k();
            } else {
                this.f20479v.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f20479v.getCurrX();
                int currY = this.f20479v.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        J(currX);
                    }
                }
            }
        }
        this.f20424H = false;
        for (int i5 = 0; i5 < this.f20439b.size(); i5++) {
            h hVar = this.f20439b.get(i5);
            if (hVar.f20497c) {
                hVar.f20497c = false;
                z6 = true;
            }
        }
        if (z6) {
            if (z5) {
                H.b0(this, this.f20488z0);
            } else {
                this.f20488z0.run();
            }
        }
    }

    private int n(int i5, float f5, int i6, int i7) {
        if (Math.abs(i7) <= this.f20442c0 || !b0() || Math.abs(i6) <= this.f20438a0 ? !(this.f20447f <= i5 ? f5 < this.f20418D0 : 1.0f - f5 >= this.f20418D0) : i6 <= 0) {
            i5++;
        }
        if (this.f20439b.size() <= 0) {
            return i5;
        }
        return Math.max(this.f20439b.get(0).f20496b, Math.min(i5, this.f20439b.get(r1.size() - 1).f20496b));
    }

    private void o(int i5, float f5, int i6) {
        l lVar = this.f20468p0;
        if (lVar != null) {
            lVar.a(i5, f5, i6);
        }
        List<l> list = this.f20466o0;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                l lVar2 = this.f20466o0.get(i7);
                if (lVar2 != null) {
                    lVar2.a(i5, f5, i6);
                }
            }
        }
        l lVar3 = this.f20470q0;
        if (lVar3 != null) {
            lVar3.a(i5, f5, i6);
        }
    }

    private void p(int i5) {
        l lVar = this.f20468p0;
        if (lVar != null) {
            lVar.c(i5);
        }
        List<l> list = this.f20466o0;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                l lVar2 = this.f20466o0.get(i6);
                if (lVar2 != null) {
                    lVar2.c(i5);
                }
            }
        }
        l lVar3 = this.f20470q0;
        if (lVar3 != null) {
            lVar3.c(i5);
        }
    }

    private void q(int i5) {
        l lVar = this.f20468p0;
        if (lVar != null) {
            lVar.b(i5);
        }
        List<l> list = this.f20466o0;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                l lVar2 = this.f20466o0.get(i6);
                if (lVar2 != null) {
                    lVar2.b(i5);
                }
            }
        }
        l lVar3 = this.f20470q0;
        if (lVar3 != null) {
            lVar3.b(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i5) {
        if (this.f20412A0 == i5) {
            return;
        }
        this.f20412A0 = i5;
        q(i5);
    }

    private void setScrollingCacheEnabled(boolean z5) {
        if (this.f20423G != z5) {
            this.f20423G = z5;
        }
    }

    private void t() {
        this.f20426J = false;
        this.f20427K = false;
        VelocityTracker velocityTracker = this.f20436W;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f20436W = null;
        }
    }

    private Rect v(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private h y() {
        int i5;
        int clientWidth = getClientWidth();
        float f5 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f6 = clientWidth > 0 ? this.f20483x / clientWidth : 0.0f;
        int i6 = 0;
        boolean z5 = true;
        h hVar = null;
        int i7 = -1;
        float f7 = 0.0f;
        while (i6 < this.f20439b.size()) {
            h hVar2 = this.f20439b.get(i6);
            if (!z5 && hVar2.f20496b != (i5 = i7 + 1)) {
                hVar2 = this.f20441c;
                hVar2.f20499e = f5 + f7 + f6;
                hVar2.f20496b = i5;
                hVar2.f20498d = this.f20445e.e(i5);
                i6--;
            }
            h hVar3 = hVar2;
            f5 = hVar3.f20499e;
            float f8 = hVar3.f20498d + f5 + f6;
            if (!z5 && scrollX < f5) {
                break;
            }
            if (scrollX < f8 || i6 == this.f20439b.size() - 1) {
                return hVar3;
            }
            int i8 = hVar3.f20496b;
            float f9 = hVar3.f20498d;
            i6++;
            i7 = i8;
            f7 = f9;
            hVar = hVar3;
            z5 = false;
        }
        return hVar;
    }

    void B() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        Interpolator interpolator = f20405J0;
        this.f20479v = new Scroller(context, interpolator);
        this.f20420E0 = interpolator;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.f20430Q = L.h(viewConfiguration);
        this.f20438a0 = (int) (400.0f * f5);
        this.f20440b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f20454i0 = new androidx.core.widget.d(context);
        this.f20456j0 = new androidx.core.widget.d(context);
        this.f20442c0 = (int) (25.0f * f5);
        this.f20444d0 = (int) (2.0f * f5);
        this.f20428L = (int) (f5 * 16.0f);
        H.k0(this, new j());
        if (H.v(this) == 0) {
            H.t0(this, 1);
        }
        if (g.FLIP_MODE_OVERLAY == this.f20449g) {
            setChildrenDrawingOrderEnabledCompat(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void F(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.f20464n0
            r1 = 1
            if (r0 <= 0) goto L6b
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L1a:
            if (r6 >= r5) goto L6b
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            stepos.support.v4.view.ViewPager$i r8 = (stepos.support.v4.view.ViewPager.i) r8
            boolean r9 = r8.f20502a
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.f20503b
            r8 = r8 & 7
            if (r8 == r1) goto L4f
            r9 = 3
            if (r8 == r9) goto L49
            r9 = 5
            if (r8 == r9) goto L39
            r8 = r2
            goto L5c
        L39:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L45:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5c
        L49:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5c
        L4f:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L45
        L5c:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L67
            r7.offsetLeftAndRight(r2)
        L67:
            r2 = r8
        L68:
            int r6 = r6 + 1
            goto L1a
        L6b:
            r11.o(r12, r13, r14)
            r11.r()
            r11.f20462m0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v4.view.ViewPager.F(int, float, int):void");
    }

    boolean H() throws Resources.NotFoundException {
        int i5 = this.f20447f;
        if (i5 <= 0) {
            return false;
        }
        U(i5 - 1, true);
        return true;
    }

    boolean I() throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.f20445e;
        if (aVar == null || this.f20447f >= aVar.c() - 1) {
            return false;
        }
        U(this.f20447f + 1, true);
        return true;
    }

    void M() throws Resources.NotFoundException {
        N(this.f20447f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ee A[PHI: r6 r8 r11
      0x00ee: PHI (r6v43 float) = (r6v41 float), (r6v42 float), (r6v10 float) binds: [B:75:0x0114, B:72:0x00fe, B:63:0x00e3] A[DONT_GENERATE, DONT_INLINE]
      0x00ee: PHI (r8v6 int) = (r8v5 int), (r8v4 int), (r8v9 int) binds: [B:75:0x0114, B:72:0x00fe, B:63:0x00e3] A[DONT_GENERATE, DONT_INLINE]
      0x00ee: PHI (r11v7 int) = (r11v1 int), (r11v6 int), (r11v10 int) binds: [B:75:0x0114, B:72:0x00fe, B:63:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void N(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v4.view.ViewPager.N(int):void");
    }

    protected float R(float f5) {
        return f5;
    }

    public void U(int i5, boolean z5) throws Resources.NotFoundException {
        this.f20424H = false;
        V(i5, z5, false);
    }

    void V(int i5, boolean z5, boolean z6) throws Resources.NotFoundException {
        W(i5, z5, z6, 0);
    }

    void W(int i5, boolean z5, boolean z6, int i6) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.f20445e;
        if (aVar == null || aVar.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z6 && this.f20447f == i5 && this.f20439b.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i5 < 0) {
            i5 = 0;
        } else if (i5 >= this.f20445e.c()) {
            i5 = this.f20445e.c() - 1;
        }
        int i7 = this.f20425I;
        int i8 = this.f20447f;
        if (i5 > i8 + i7 || i5 < i8 - i7) {
            for (int i9 = 0; i9 < this.f20439b.size(); i9++) {
                this.f20439b.get(i9).f20497c = true;
            }
        }
        boolean z7 = this.f20447f != i5;
        if (!this.f20458k0) {
            N(i5);
            T(i5, z5, i6, z7);
        } else {
            this.f20447f = i5;
            if (z7) {
                p(i5);
            }
            requestLayout();
        }
    }

    void Y(int i5, int i6, int i7) throws Resources.NotFoundException {
        int iRound;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i8 = i5 - scrollX;
        int i9 = i6 - scrollY;
        if (i8 == 0 && i9 == 0) {
            l(false);
            M();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        if (this.f20478u0) {
            a0(scrollX, i8, -i7);
            return;
        }
        int clientWidth = getClientWidth();
        int i10 = clientWidth / 2;
        float f5 = clientWidth;
        float f6 = i10;
        float fS = f6 + (s(Math.min(1.0f, (Math.abs(i8) * 1.0f) / f5)) * f6);
        int iAbs = Math.abs(i7);
        if (iAbs > 0) {
            iRound = Math.round(Math.abs(fS / iAbs) * 1000.0f) * 4;
        } else {
            float fAbs = Math.abs(i8) / ((f5 * this.f20445e.e(this.f20447f)) + this.f20483x);
            iRound = (int) (((g.FLIP_MODE_OVERLAY != this.f20449g || fAbs < 1.0f) ? fAbs + 1.0f : fAbs + 4.0f) * 100.0f);
        }
        this.f20479v.startScroll(scrollX, scrollY, i8, i9, Math.min(iRound, 600));
        H.a0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i5, int i6) {
        h hVarX;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() == 0 && (hVarX = x(childAt)) != null && hVarX.f20496b == this.f20447f) {
                    childAt.addFocusables(arrayList, i5, i6);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i6 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        h hVarX;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (hVarX = x(childAt)) != null && hVarX.f20496b == this.f20447f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        i iVar = (i) layoutParams;
        boolean z5 = iVar.f20502a;
        iVar.f20502a = z5;
        if (!this.f20421F) {
            super.addView(view, i5, layoutParams);
        } else {
            if (z5) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            iVar.f20505d = true;
            addViewInLayout(view, i5, layoutParams);
        }
    }

    protected boolean b0() {
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i5) {
        if (this.f20445e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i5 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f20413B)) : i5 > 0 && scrollX < ((int) (((float) clientWidth) * this.f20415C));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof i) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f20479v.isFinished() || !this.f20479v.computeScrollOffset()) {
            if (this.f20478u0) {
                return;
            }
            l(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f20479v.getCurrX();
        int currY = this.f20479v.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            if (g.FLIP_MODE_OVERLAY == this.f20449g) {
                S(currX);
            }
            scrollTo(currX, currY);
            if (!J(currX)) {
                this.f20479v.abortAnimation();
                scrollTo(0, currY);
            }
        }
        H.a0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (g.FLIP_MODE_OVERLAY == this.f20449g && this.f20457k && D()) {
            canvas.save();
            canvas.translate(this.f20459l, this.f20463n);
            this.f20465o.draw(canvas);
            this.f20467p.setAlpha(this.f20469q);
            this.f20467p.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || u(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        h hVarX;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (hVarX = x(childAt)) != null && hVarX.f20496b == this.f20447f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f20485y;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    h g(int i5, int i6) {
        h hVar = new h();
        hVar.f20496b = i5;
        hVar.f20495a = this.f20445e.f(this, i5);
        hVar.f20498d = this.f20445e.e(i5);
        if (i6 < 0 || i6 >= this.f20439b.size()) {
            hVar.f20501g = this.f20439b.size();
            this.f20439b.add(hVar);
            return hVar;
        }
        this.f20439b.add(i6, hVar);
        hVar.f20501g = i6;
        return hVar;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new i();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.f20445e;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i5, int i6) {
        if (this.f20484x0 == 2) {
            i6 = (i5 - 1) - i6;
        }
        if (this.f20486y0.size() == 0) {
            return i6;
        }
        if (i6 > 0 && i6 >= this.f20486y0.size()) {
            i6 = this.f20486y0.size() - 1;
        }
        return ((i) this.f20486y0.get(i6).getLayoutParams()).f20507f;
    }

    public int getCurrentItem() {
        return this.f20447f;
    }

    public g getFlipMode() {
        return this.f20449g;
    }

    public int getOffscreenPageLimit() {
        return this.f20425I;
    }

    public int getPageMargin() {
        return this.f20483x;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean h(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L63
        L9:
            if (r0 == 0) goto L63
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L63
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L63:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto Lb3
            if (r1 == r0) goto Lb3
            if (r5 != r3) goto L93
            android.graphics.Rect r2 = r4.f20443d
            android.graphics.Rect r2 = r4.v(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f20443d
            android.graphics.Rect r3 = r4.v(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8e
            if (r2 < r3) goto L8e
            boolean r0 = r4.H()
            goto Lca
        L8e:
            boolean r0 = r1.requestFocus()
            goto Lca
        L93:
            if (r5 != r2) goto Lbf
            android.graphics.Rect r2 = r4.f20443d
            android.graphics.Rect r2 = r4.v(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f20443d
            android.graphics.Rect r3 = r4.v(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto Lae
            if (r2 > r3) goto Lae
            boolean r0 = r4.I()
            goto Lca
        Lae:
            boolean r0 = r1.requestFocus()
            goto Lca
        Lb3:
            if (r5 == r3) goto Lc6
            r0 = 1
            if (r5 != r0) goto Lb9
            goto Lc6
        Lb9:
            if (r5 == r2) goto Lc1
            r0 = 2
            if (r5 != r0) goto Lbf
            goto Lc1
        Lbf:
            r0 = 0
            goto Lca
        Lc1:
            boolean r0 = r4.I()
            goto Lca
        Lc6:
            boolean r0 = r4.H()
        Lca:
            if (r0 == 0) goto Ld3
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v4.view.ViewPager.h(int):boolean");
    }

    protected boolean j(View view, boolean z5, int i5, int i6, int i7) {
        int i8;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i9 = i6 + scrollX;
                if (i9 >= childAt.getLeft() && i9 < childAt.getRight() && (i8 = i7 + scrollY) >= childAt.getTop() && i8 < childAt.getBottom() && j(childAt, true, i5, i9 - childAt.getLeft(), i8 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z5 && H.e(view, -i5);
    }

    void m() throws Resources.NotFoundException {
        int iC = this.f20445e.c();
        this.f20437a = iC;
        boolean z5 = this.f20439b.size() < (this.f20425I * 2) + 1 && this.f20439b.size() < iC;
        int iMax = this.f20447f;
        int i5 = 0;
        boolean z6 = false;
        while (i5 < this.f20439b.size()) {
            h hVar = this.f20439b.get(i5);
            int iD = this.f20445e.d(hVar.f20495a);
            if (iD != -1) {
                if (iD == -2) {
                    this.f20439b.remove(i5);
                    i5--;
                    if (!z6) {
                        this.f20445e.m(this);
                        z6 = true;
                    }
                    this.f20445e.a(this, hVar.f20496b, hVar.f20495a);
                    int i6 = this.f20447f;
                    if (i6 == hVar.f20496b) {
                        iMax = Math.max(0, Math.min(i6, iC - 1));
                    }
                } else {
                    int i7 = hVar.f20496b;
                    if (i7 != iD) {
                        if (i7 == this.f20447f) {
                            iMax = iD;
                        }
                        hVar.f20496b = iD;
                    }
                }
                z5 = true;
            }
            i5++;
        }
        if (z6) {
            this.f20445e.b(this);
        }
        Collections.sort(this.f20439b, f20404I0);
        if (g.FLIP_MODE_OVERLAY == this.f20449g) {
            A();
        }
        if (z5) {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                i iVar = (i) getChildAt(i8).getLayoutParams();
                if (!iVar.f20502a) {
                    iVar.f20504c = 0.0f;
                }
            }
            V(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i5, int i6) {
        if (H.x(this) == 1) {
            view.setRotationY(180.0f);
        }
        view.measure(i5, i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f20458k0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f20488z0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i5;
        float f5;
        int i6;
        super.onDraw(canvas);
        if (this.f20483x <= 0 || this.f20485y == null || this.f20439b.size() <= 0 || this.f20445e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f6 = this.f20483x / width;
        int i7 = 0;
        h hVar = this.f20439b.get(0);
        float f7 = hVar.f20499e;
        int size = this.f20439b.size();
        int i8 = hVar.f20496b;
        int i9 = this.f20439b.get(size - 1).f20496b;
        while (i8 < i9) {
            while (true) {
                i5 = hVar.f20496b;
                if (i8 <= i5 || i7 >= size) {
                    break;
                }
                i7++;
                hVar = this.f20439b.get(i7);
            }
            if (i8 == i5) {
                float f8 = hVar.f20499e;
                float f9 = hVar.f20498d;
                f5 = (f8 + f9) * width;
                f7 = f8 + f9 + f6;
            } else {
                float fE = this.f20445e.e(i8);
                f5 = (f7 + fE) * width;
                f7 += fE + f6;
            }
            int i10 = this.f20483x;
            if (i10 + f5 > scrollX) {
                i6 = scrollX;
                this.f20485y.setBounds((int) f5, this.f20487z, (int) (i10 + f5 + 0.5f), this.f20411A);
                this.f20485y.draw(canvas);
            } else {
                i6 = scrollX;
            }
            if (f5 > i6 + r2) {
                return;
            }
            i8++;
            scrollX = i6;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            if (action == 1 && this.f20426J) {
                VelocityTracker velocityTracker = this.f20436W;
                velocityTracker.computeCurrentVelocity(1000, this.f20440b0);
                int iF = (int) E.f(velocityTracker, this.f20435V);
                this.f20424H = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                h hVarY = y();
                int i5 = hVarY.f20496b;
                float f5 = ((scrollX / clientWidth) - hVarY.f20499e) / hVarY.f20498d;
                int iA = C0473s.a(motionEvent, this.f20435V);
                if (iA == -1) {
                    Log.e("ViewPager", "Invalid pointerId=" + this.f20435V + " in onTouchEvent ACTION_UP");
                } else {
                    W(n(i5, f5, iF, (int) (C0473s.f(motionEvent, iA) - this.f20433T)), true, true, iF);
                    this.f20435V = -1;
                    t();
                    if (this.f20454i0.e() | this.f20456j0.e()) {
                        H.a0(this);
                    }
                }
            }
            this.f20426J = false;
            this.f20427K = false;
            this.f20435V = -1;
            VelocityTracker velocityTracker2 = this.f20436W;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f20436W = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.f20426J) {
                return true;
            }
            if (this.f20427K) {
                return false;
            }
        }
        if (action == 0) {
            float x5 = motionEvent.getX();
            this.f20433T = x5;
            this.f20431R = x5;
            float y5 = motionEvent.getY();
            this.f20434U = y5;
            this.f20432S = y5;
            this.f20435V = C0473s.e(motionEvent, 0);
            this.f20427K = false;
            this.f20479v.computeScrollOffset();
            boolean zE = this.f20478u0 ? E() : Math.abs(this.f20479v.getFinalX() - this.f20479v.getCurrX()) > this.f20444d0;
            if (this.f20412A0 == 2 && zE) {
                this.f20479v.abortAnimation();
                this.f20424H = false;
                M();
                this.f20426J = true;
                Q(true);
                setScrollState(1);
            } else {
                l(false);
                this.f20426J = false;
            }
        } else if (action == 2) {
            int i6 = this.f20435V;
            if (i6 != -1) {
                int iA2 = C0473s.a(motionEvent, i6);
                if (iA2 == -1) {
                    Log.e("ViewPager", "Invalid pointerId=" + i6 + " in onInterceptTouchEvent ACTION_MOVE");
                } else {
                    float f6 = C0473s.f(motionEvent, iA2);
                    float f7 = f6 - this.f20431R;
                    float fAbs = Math.abs(f7);
                    float fG = C0473s.g(motionEvent, iA2);
                    float fAbs2 = Math.abs(fG - this.f20434U);
                    if (f7 != 0.0f && !C(this.f20431R, f7) && j(this, false, (int) f7, (int) f6, (int) fG)) {
                        this.f20431R = f6;
                        this.f20432S = fG;
                        this.f20427K = true;
                        return false;
                    }
                    int i7 = this.f20450g0;
                    if (fAbs < i7 && fAbs2 < i7 && L(motionEvent, this.f20446e0)) {
                        if (f20402G0) {
                            Log.d("ViewPager", "xDiff = " + fAbs + ", yDiff = " + fAbs2 + ", mTouchSlopAdj = " + this.f20450g0);
                        }
                        return false;
                    }
                    int i8 = this.f20430Q;
                    if (fAbs > i8 && fAbs > fAbs2) {
                        this.f20426J = true;
                        Q(true);
                        setScrollState(1);
                        this.f20431R = f7 > 0.0f ? this.f20433T + this.f20430Q : this.f20433T - this.f20430Q;
                        this.f20432S = fG;
                        setScrollingCacheEnabled(true);
                    } else if (fAbs2 > i8) {
                        this.f20427K = true;
                    }
                    if (this.f20426J && K(f6)) {
                        H.a0(this);
                    }
                }
            }
        } else if (action == 6) {
            G(motionEvent);
        }
        if (this.f20436W == null) {
            this.f20436W = VelocityTracker.obtain();
        }
        this.f20436W.addMovement(motionEvent);
        return this.f20426J;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v4.view.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) throws Resources.NotFoundException {
        i iVar;
        i iVar2;
        int i7;
        if (H.x(this) == 1) {
            setRotationY(180.0f);
        }
        boolean z5 = false;
        setMeasuredDimension(View.getDefaultSize(0, i5), View.getDefaultSize(0, i6));
        int measuredWidth = getMeasuredWidth();
        this.f20429M = Math.min(measuredWidth / 10, this.f20428L);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i8 = 0;
        while (true) {
            int i9 = 1073741824;
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8 && (iVar2 = (i) childAt.getLayoutParams()) != null && iVar2.f20502a) {
                int i10 = iVar2.f20503b;
                int i11 = i10 & 7;
                int i12 = i10 & 112;
                boolean z6 = (i12 == 48 || i12 == 80) ? true : z5;
                boolean z7 = (i11 == 3 || i11 == 5) ? true : z5;
                int i13 = Integer.MIN_VALUE;
                if (z6) {
                    i7 = Integer.MIN_VALUE;
                    i13 = 1073741824;
                } else {
                    i7 = z7 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i14 = ((ViewGroup.LayoutParams) iVar2).width;
                if (i14 != -2) {
                    if (i14 == -1) {
                        i14 = paddingLeft;
                    }
                    i13 = 1073741824;
                } else {
                    i14 = paddingLeft;
                }
                int i15 = ((ViewGroup.LayoutParams) iVar2).height;
                if (i15 == -2) {
                    i15 = measuredHeight;
                    i9 = i7;
                } else if (i15 == -1) {
                    i15 = measuredHeight;
                }
                measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i14, i13), View.MeasureSpec.makeMeasureSpec(i15, i9));
                if (z6) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z7) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i8++;
            z5 = false;
        }
        this.f20417D = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f20419E = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f20421F = true;
        M();
        this.f20421F = false;
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8 && ((iVar = (i) childAt2.getLayoutParams()) == null || !iVar.f20502a)) {
                measureChild(childAt2, View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * iVar.f20504c), 1073741824), this.f20419E);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i5, Rect rect) {
        int i6;
        int i7;
        int i8;
        h hVarX;
        int childCount = getChildCount();
        if ((i5 & 2) != 0) {
            i7 = childCount;
            i6 = 0;
            i8 = 1;
        } else {
            i6 = childCount - 1;
            i7 = -1;
            i8 = -1;
        }
        while (i6 != i7) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (hVarX = x(childAt)) != null && hVarX.f20496b == this.f20447f && childAt.requestFocus(i5, rect)) {
                return true;
            }
            i6 += i8;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof n)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        n nVar = (n) parcelable;
        super.onRestoreInstanceState(nVar.getSuperState());
        androidx.viewpager.widget.a aVar = this.f20445e;
        if (aVar != null) {
            aVar.i(nVar.f20511b, nVar.f20512c);
            V(nVar.f20510a, false, true);
        } else {
            this.f20473s = nVar.f20510a;
            this.f20475t = nVar.f20511b;
            this.f20477u = nVar.f20512c;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        n nVar = new n(super.onSaveInstanceState());
        nVar.f20510a = this.f20447f;
        androidx.viewpager.widget.a aVar = this.f20445e;
        if (aVar != null) {
            nVar.f20511b = aVar.j();
        }
        return nVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        if (i5 != i7) {
            int i9 = this.f20483x;
            O(i5, i7, i9, i9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0131  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r11) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v4.view.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void r() {
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f20421F) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    float s(float f5) {
        return (float) Math.sin((float) ((f5 - 0.5f) * 0.4712389167638204d));
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar2 = this.f20445e;
        if (aVar2 != null) {
            aVar2.n(this.f20481w);
            this.f20445e.m(this);
            for (int i5 = 0; i5 < this.f20439b.size(); i5++) {
                h hVar = this.f20439b.get(i5);
                this.f20445e.a(this, hVar.f20496b, hVar.f20495a);
            }
            this.f20445e.b(this);
            this.f20439b.clear();
            P();
            this.f20447f = 0;
            scrollTo(0, 0);
        }
        this.f20445e = aVar;
        this.f20437a = 0;
        if (aVar != null) {
            a aVar3 = null;
            if (this.f20481w == null) {
                this.f20481w = new m(this, aVar3);
            }
            this.f20445e.h(this.f20481w);
            this.f20424H = false;
            boolean z5 = this.f20458k0;
            this.f20458k0 = true;
            this.f20437a = this.f20445e.c();
            if (this.f20473s < 0) {
                if (z5) {
                    requestLayout();
                    return;
                } else {
                    M();
                    return;
                }
            }
            this.f20445e.i(this.f20475t, this.f20477u);
            V(this.f20473s, false, true);
            this.f20473s = -1;
            this.f20475t = null;
            this.f20477u = null;
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z5) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f20472r0 == null) {
            try {
                this.f20472r0 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e6) {
                Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e6);
            }
        }
        try {
            this.f20472r0.setAccessible(true);
            this.f20472r0.invoke(this, Boolean.valueOf(z5));
        } catch (Exception e7) {
            Log.e("ViewPager", "Error changing children drawing order", e7);
        }
    }

    public void setCurrentItem(int i5) throws Resources.NotFoundException {
        this.f20424H = false;
        V(i5, !this.f20458k0, false);
    }

    public void setDamping(float f5) {
        this.f20476t0 = f5;
    }

    public void setFlipMode(g gVar) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f20449g != gVar) {
            this.f20449g = gVar;
            if (g.FLIP_MODE_OVERLAY == this.f20449g) {
                this.f20483x = 0;
                A();
                setChildrenDrawingOrderEnabledCompat(true);
            } else {
                setChildrenDrawingOrderEnabledCompat(false);
            }
            Z();
            requestLayout();
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        Scroller scroller = this.f20479v;
        if (scroller != null && !scroller.isFinished()) {
            this.f20479v.forceFinished(true);
        }
        if (interpolator == null || this.f20420E0 == interpolator) {
            return;
        }
        this.f20420E0 = interpolator;
        this.f20479v = new Scroller(this.f20471r, interpolator);
    }

    public void setMinAutoFlingDistance(float f5) {
        this.f20418D0 = f5;
    }

    public void setOffscreenPageLimit(int i5) throws Resources.NotFoundException {
        if (i5 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i5 + " too small; defaulting to 1");
            i5 = 1;
        }
        if (i5 != this.f20425I) {
            this.f20425I = i5;
            M();
        }
    }

    void setOnAdapterChangeListener(k kVar) {
    }

    @Deprecated
    public void setOnPageChangeListener(l lVar) {
        this.f20468p0 = lVar;
    }

    public void setPageMargin(int i5) {
        if (g.FLIP_MODE_OVERLAY == this.f20449g) {
            return;
        }
        int i6 = this.f20483x;
        this.f20483x = i5;
        int width = getWidth();
        O(width, width, i5, i6);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f20485y = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setSpringAnimationEnable(boolean z5) {
        this.f20478u0 = z5;
    }

    public void setStiffness(float f5) {
        this.f20474s0 = f5;
    }

    public boolean u(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            return h(17);
        }
        if (keyCode == 22) {
            return h(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return h(2);
        }
        if (KeyEvent.metaStateHasModifiers(keyEvent.getMetaState(), 1)) {
            return h(1);
        }
        return false;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f20485y;
    }

    h w(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return x(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    h x(View view) {
        for (int i5 = 0; i5 < this.f20439b.size(); i5++) {
            h hVar = this.f20439b.get(i5);
            if (this.f20445e.g(view, hVar.f20495a)) {
                return hVar;
            }
        }
        return null;
    }

    h z(int i5) {
        for (int i6 = 0; i6 < this.f20439b.size(); i6++) {
            h hVar = this.f20439b.get(i6);
            if (hVar.f20496b == i5) {
                return hVar;
            }
        }
        return null;
    }

    public static class i extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20502a;

        /* renamed from: b, reason: collision with root package name */
        public int f20503b;

        /* renamed from: c, reason: collision with root package name */
        float f20504c;

        /* renamed from: d, reason: collision with root package name */
        boolean f20505d;

        /* renamed from: e, reason: collision with root package name */
        int f20506e;

        /* renamed from: f, reason: collision with root package name */
        int f20507f;

        public i() {
            super(-1, -1);
            this.f20504c = 0.0f;
        }

        public i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f20504c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f20403H0);
            this.f20503b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new i(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i5) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i5));
    }
}
