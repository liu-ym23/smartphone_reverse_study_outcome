package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
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
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.C0456a;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: j0, reason: collision with root package name */
    static final int[] f11613j0 = {R.attr.layout_gravity};

    /* renamed from: k0, reason: collision with root package name */
    private static final Comparator<f> f11614k0 = new a();

    /* renamed from: l0, reason: collision with root package name */
    private static final Interpolator f11615l0 = new b();

    /* renamed from: m0, reason: collision with root package name */
    private static final m f11616m0 = new m();

    /* renamed from: A, reason: collision with root package name */
    private int f11617A;

    /* renamed from: B, reason: collision with root package name */
    private int f11618B;

    /* renamed from: C, reason: collision with root package name */
    private int f11619C;

    /* renamed from: D, reason: collision with root package name */
    private float f11620D;

    /* renamed from: E, reason: collision with root package name */
    private float f11621E;

    /* renamed from: F, reason: collision with root package name */
    private float f11622F;

    /* renamed from: G, reason: collision with root package name */
    private float f11623G;

    /* renamed from: H, reason: collision with root package name */
    private int f11624H;

    /* renamed from: I, reason: collision with root package name */
    private VelocityTracker f11625I;

    /* renamed from: J, reason: collision with root package name */
    private int f11626J;

    /* renamed from: K, reason: collision with root package name */
    private int f11627K;

    /* renamed from: L, reason: collision with root package name */
    private int f11628L;

    /* renamed from: M, reason: collision with root package name */
    private int f11629M;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f11630Q;

    /* renamed from: R, reason: collision with root package name */
    private long f11631R;

    /* renamed from: S, reason: collision with root package name */
    private EdgeEffect f11632S;

    /* renamed from: T, reason: collision with root package name */
    private EdgeEffect f11633T;

    /* renamed from: U, reason: collision with root package name */
    private boolean f11634U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f11635V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f11636W;

    /* renamed from: a, reason: collision with root package name */
    private int f11637a;

    /* renamed from: a0, reason: collision with root package name */
    private int f11638a0;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<f> f11639b;

    /* renamed from: b0, reason: collision with root package name */
    private List<j> f11640b0;

    /* renamed from: c, reason: collision with root package name */
    private final f f11641c;

    /* renamed from: c0, reason: collision with root package name */
    private j f11642c0;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f11643d;

    /* renamed from: d0, reason: collision with root package name */
    private j f11644d0;

    /* renamed from: e, reason: collision with root package name */
    androidx.viewpager.widget.a f11645e;

    /* renamed from: e0, reason: collision with root package name */
    private List<i> f11646e0;

    /* renamed from: f, reason: collision with root package name */
    int f11647f;

    /* renamed from: f0, reason: collision with root package name */
    private int f11648f0;

    /* renamed from: g, reason: collision with root package name */
    private int f11649g;

    /* renamed from: g0, reason: collision with root package name */
    private ArrayList<View> f11650g0;

    /* renamed from: h, reason: collision with root package name */
    private Parcelable f11651h;

    /* renamed from: h0, reason: collision with root package name */
    private final Runnable f11652h0;

    /* renamed from: i, reason: collision with root package name */
    private ClassLoader f11653i;

    /* renamed from: i0, reason: collision with root package name */
    private int f11654i0;

    /* renamed from: j, reason: collision with root package name */
    private Scroller f11655j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11656k;

    /* renamed from: l, reason: collision with root package name */
    private k f11657l;

    /* renamed from: m, reason: collision with root package name */
    private int f11658m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f11659n;

    /* renamed from: o, reason: collision with root package name */
    private int f11660o;

    /* renamed from: p, reason: collision with root package name */
    private int f11661p;

    /* renamed from: q, reason: collision with root package name */
    private float f11662q;

    /* renamed from: r, reason: collision with root package name */
    private float f11663r;

    /* renamed from: s, reason: collision with root package name */
    private int f11664s;

    /* renamed from: t, reason: collision with root package name */
    private int f11665t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f11666u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f11667v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f11668w;

    /* renamed from: x, reason: collision with root package name */
    private int f11669x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f11670y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f11671z;

    static class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.f11676b - fVar2.f11676b;
        }
    }

    static class b implements Interpolator {
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
            ViewPager.this.F();
        }
    }

    class d implements InterfaceC0479y {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f11673a = new Rect();

        d() {
        }

        @Override // androidx.core.view.InterfaceC0479y
        public Y a(View view, Y y5) {
            Y yW = H.W(view, y5);
            if (yW.n()) {
                return yW;
            }
            Rect rect = this.f11673a;
            rect.left = yW.i();
            rect.top = yW.k();
            rect.right = yW.j();
            rect.bottom = yW.h();
            int childCount = ViewPager.this.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                Y yG = H.g(ViewPager.this.getChildAt(i5), yW);
                rect.left = Math.min(yG.i(), rect.left);
                rect.top = Math.min(yG.k(), rect.top);
                rect.right = Math.min(yG.j(), rect.right);
                rect.bottom = Math.min(yG.h(), rect.bottom);
            }
            return yW.o(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    static class f {

        /* renamed from: a, reason: collision with root package name */
        Object f11675a;

        /* renamed from: b, reason: collision with root package name */
        int f11676b;

        /* renamed from: c, reason: collision with root package name */
        boolean f11677c;

        /* renamed from: d, reason: collision with root package name */
        float f11678d;

        /* renamed from: e, reason: collision with root package name */
        float f11679e;

        f() {
        }
    }

    class h extends C0456a {
        h() {
        }

        private boolean a() {
            androidx.viewpager.widget.a aVar = ViewPager.this.f11645e;
            return aVar != null && aVar.c() > 1;
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(a());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.f11645e) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.c());
            accessibilityEvent.setFromIndex(ViewPager.this.f11647f);
            accessibilityEvent.setToIndex(ViewPager.this.f11647f);
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
                viewPager.setCurrentItem(viewPager.f11647f + 1);
                return true;
            }
            if (i5 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f11647f - 1);
            return true;
        }
    }

    public interface i {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    public interface j {
        void a(int i5, float f5, int i6);

        void b(int i5);

        void c(int i5);
    }

    private class k extends DataSetObserver {
        k() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            ViewPager.this.g();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.g();
        }
    }

    public static class l extends androidx.customview.view.a {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f11688a;

        /* renamed from: b, reason: collision with root package name */
        Parcelable f11689b;

        /* renamed from: c, reason: collision with root package name */
        ClassLoader f11690c;

        static class a implements Parcelable.ClassLoaderCreator<l> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new l(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public l[] newArray(int i5) {
                return new l[i5];
            }
        }

        public l(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f11688a + "}";
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f11688a);
            parcel.writeParcelable(this.f11689b, i5);
        }

        l(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f11688a = parcel.readInt();
            this.f11689b = parcel.readParcelable(classLoader);
            this.f11690c = classLoader;
        }
    }

    static class m implements Comparator<View> {
        m() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z5 = gVar.f11680a;
            return z5 != gVar2.f11680a ? z5 ? 1 : -1 : gVar.f11684e - gVar2.f11684e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11639b = new ArrayList<>();
        this.f11641c = new f();
        this.f11643d = new Rect();
        this.f11649g = -1;
        this.f11651h = null;
        this.f11653i = null;
        this.f11662q = -3.4028235E38f;
        this.f11663r = Float.MAX_VALUE;
        this.f11669x = 1;
        this.f11624H = -1;
        this.f11634U = true;
        this.f11635V = false;
        this.f11652h0 = new c();
        this.f11654i0 = 0;
        v();
    }

    private void A(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f11624H) {
            int i5 = actionIndex == 0 ? 1 : 0;
            this.f11620D = motionEvent.getX(i5);
            this.f11624H = motionEvent.getPointerId(i5);
            VelocityTracker velocityTracker = this.f11625I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean D(int i5) {
        if (this.f11639b.size() == 0) {
            if (this.f11634U) {
                return false;
            }
            this.f11636W = false;
            z(0, 0.0f, 0);
            if (this.f11636W) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f fVarT = t();
        int clientWidth = getClientWidth();
        int i6 = this.f11658m;
        int i7 = clientWidth + i6;
        float f5 = clientWidth;
        int i8 = fVarT.f11676b;
        float f6 = ((i5 / f5) - fVarT.f11679e) / (fVarT.f11678d + (i6 / f5));
        this.f11636W = false;
        z(i8, f6, (int) (i7 * f6));
        if (this.f11636W) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean E(float f5) {
        boolean z5;
        boolean z6;
        float f6 = this.f11620D - f5;
        this.f11620D = f5;
        float scrollX = getScrollX() + f6;
        float clientWidth = getClientWidth();
        float f7 = this.f11662q * clientWidth;
        float f8 = this.f11663r * clientWidth;
        boolean z7 = false;
        f fVar = this.f11639b.get(0);
        ArrayList<f> arrayList = this.f11639b;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f11676b != 0) {
            f7 = fVar.f11679e * clientWidth;
            z5 = false;
        } else {
            z5 = true;
        }
        if (fVar2.f11676b != this.f11645e.c() - 1) {
            f8 = fVar2.f11679e * clientWidth;
            z6 = false;
        } else {
            z6 = true;
        }
        if (scrollX < f7) {
            if (z5) {
                this.f11632S.onPull(Math.abs(f7 - scrollX) / clientWidth);
                z7 = true;
            }
            scrollX = f7;
        } else if (scrollX > f8) {
            if (z6) {
                this.f11633T.onPull(Math.abs(scrollX - f8) / clientWidth);
                z7 = true;
            }
            scrollX = f8;
        }
        int i5 = (int) scrollX;
        this.f11620D += scrollX - i5;
        scrollTo(i5, getScrollY());
        D(i5);
        return z7;
    }

    private void H(int i5, int i6, int i7, int i8) {
        if (i6 > 0 && !this.f11639b.isEmpty()) {
            if (!this.f11655j.isFinished()) {
                this.f11655j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i6 - getPaddingLeft()) - getPaddingRight()) + i8)) * (((i5 - getPaddingLeft()) - getPaddingRight()) + i7)), getScrollY());
                return;
            }
        }
        f fVarU = u(this.f11647f);
        int iMin = (int) ((fVarU != null ? Math.min(fVarU.f11679e, this.f11663r) : 0.0f) * ((i5 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            f(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void I() {
        int i5 = 0;
        while (i5 < getChildCount()) {
            if (!((g) getChildAt(i5).getLayoutParams()).f11680a) {
                removeViewAt(i5);
                i5--;
            }
            i5++;
        }
    }

    private void J(boolean z5) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z5);
        }
    }

    private boolean K() {
        this.f11624H = -1;
        m();
        this.f11632S.onRelease();
        this.f11633T.onRelease();
        return this.f11632S.isFinished() || this.f11633T.isFinished();
    }

    private void L(int i5, boolean z5, int i6, boolean z6) throws Resources.NotFoundException {
        f fVarU = u(i5);
        int clientWidth = fVarU != null ? (int) (getClientWidth() * Math.max(this.f11662q, Math.min(fVarU.f11679e, this.f11663r))) : 0;
        if (z5) {
            P(clientWidth, 0, i6);
            if (z6) {
                j(i5);
                return;
            }
            return;
        }
        if (z6) {
            j(i5);
        }
        f(false);
        scrollTo(clientWidth, 0);
        D(clientWidth);
    }

    private void Q() {
        if (this.f11648f0 != 0) {
            ArrayList<View> arrayList = this.f11650g0;
            if (arrayList == null) {
                this.f11650g0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                this.f11650g0.add(getChildAt(i5));
            }
            Collections.sort(this.f11650g0, f11616m0);
        }
    }

    private void d(f fVar, int i5, f fVar2) {
        int i6;
        int i7;
        f fVar3;
        f fVar4;
        int iC = this.f11645e.c();
        int clientWidth = getClientWidth();
        float f5 = clientWidth > 0 ? this.f11658m / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i8 = fVar2.f11676b;
            int i9 = fVar.f11676b;
            if (i8 < i9) {
                float fE = fVar2.f11679e + fVar2.f11678d + f5;
                int i10 = i8 + 1;
                int i11 = 0;
                while (i10 <= fVar.f11676b && i11 < this.f11639b.size()) {
                    f fVar5 = this.f11639b.get(i11);
                    while (true) {
                        fVar4 = fVar5;
                        if (i10 <= fVar4.f11676b || i11 >= this.f11639b.size() - 1) {
                            break;
                        }
                        i11++;
                        fVar5 = this.f11639b.get(i11);
                    }
                    while (i10 < fVar4.f11676b) {
                        fE += this.f11645e.e(i10) + f5;
                        i10++;
                    }
                    fVar4.f11679e = fE;
                    fE += fVar4.f11678d + f5;
                    i10++;
                }
            } else if (i8 > i9) {
                int size = this.f11639b.size() - 1;
                float fE2 = fVar2.f11679e;
                while (true) {
                    i8--;
                    if (i8 < fVar.f11676b || size < 0) {
                        break;
                    }
                    f fVar6 = this.f11639b.get(size);
                    while (true) {
                        fVar3 = fVar6;
                        if (i8 >= fVar3.f11676b || size <= 0) {
                            break;
                        }
                        size--;
                        fVar6 = this.f11639b.get(size);
                    }
                    while (i8 > fVar3.f11676b) {
                        fE2 -= this.f11645e.e(i8) + f5;
                        i8--;
                    }
                    fE2 -= fVar3.f11678d + f5;
                    fVar3.f11679e = fE2;
                }
            }
        }
        int size2 = this.f11639b.size();
        float fE3 = fVar.f11679e;
        int i12 = fVar.f11676b;
        int i13 = i12 - 1;
        this.f11662q = i12 == 0 ? fE3 : -3.4028235E38f;
        int i14 = iC - 1;
        this.f11663r = i12 == i14 ? (fVar.f11678d + fE3) - 1.0f : Float.MAX_VALUE;
        int i15 = i5 - 1;
        while (i15 >= 0) {
            f fVar7 = this.f11639b.get(i15);
            while (true) {
                i7 = fVar7.f11676b;
                if (i13 <= i7) {
                    break;
                }
                fE3 -= this.f11645e.e(i13) + f5;
                i13--;
            }
            fE3 -= fVar7.f11678d + f5;
            fVar7.f11679e = fE3;
            if (i7 == 0) {
                this.f11662q = fE3;
            }
            i15--;
            i13--;
        }
        float fE4 = fVar.f11679e + fVar.f11678d + f5;
        int i16 = fVar.f11676b + 1;
        int i17 = i5 + 1;
        while (i17 < size2) {
            f fVar8 = this.f11639b.get(i17);
            while (true) {
                i6 = fVar8.f11676b;
                if (i16 >= i6) {
                    break;
                }
                fE4 += this.f11645e.e(i16) + f5;
                i16++;
            }
            if (i6 == i14) {
                this.f11663r = (fVar8.f11678d + fE4) - 1.0f;
            }
            fVar8.f11679e = fE4;
            fE4 += fVar8.f11678d + f5;
            i17++;
            i16++;
        }
        this.f11635V = false;
    }

    private void f(boolean z5) {
        boolean z6 = this.f11654i0 == 2;
        if (z6) {
            setScrollingCacheEnabled(false);
            if (!this.f11655j.isFinished()) {
                this.f11655j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f11655j.getCurrX();
                int currY = this.f11655j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        D(currX);
                    }
                }
            }
        }
        this.f11668w = false;
        for (int i5 = 0; i5 < this.f11639b.size(); i5++) {
            f fVar = this.f11639b.get(i5);
            if (fVar.f11677c) {
                fVar.f11677c = false;
                z6 = true;
            }
        }
        if (z6) {
            if (z5) {
                H.b0(this, this.f11652h0);
            } else {
                this.f11652h0.run();
            }
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int h(int i5, float f5, int i6, int i7) {
        if (Math.abs(i7) <= this.f11628L || Math.abs(i6) <= this.f11626J) {
            i5 += (int) (f5 + (i5 >= this.f11647f ? 0.4f : 0.6f));
        } else if (i6 <= 0) {
            i5++;
        }
        if (this.f11639b.size() <= 0) {
            return i5;
        }
        return Math.max(this.f11639b.get(0).f11676b, Math.min(i5, this.f11639b.get(r1.size() - 1).f11676b));
    }

    private void i(int i5, float f5, int i6) {
        j jVar = this.f11642c0;
        if (jVar != null) {
            jVar.a(i5, f5, i6);
        }
        List<j> list = this.f11640b0;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                j jVar2 = this.f11640b0.get(i7);
                if (jVar2 != null) {
                    jVar2.a(i5, f5, i6);
                }
            }
        }
        j jVar3 = this.f11644d0;
        if (jVar3 != null) {
            jVar3.a(i5, f5, i6);
        }
    }

    private void j(int i5) {
        j jVar = this.f11642c0;
        if (jVar != null) {
            jVar.c(i5);
        }
        List<j> list = this.f11640b0;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                j jVar2 = this.f11640b0.get(i6);
                if (jVar2 != null) {
                    jVar2.c(i5);
                }
            }
        }
        j jVar3 = this.f11644d0;
        if (jVar3 != null) {
            jVar3.c(i5);
        }
    }

    private void k(int i5) {
        j jVar = this.f11642c0;
        if (jVar != null) {
            jVar.b(i5);
        }
        List<j> list = this.f11640b0;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                j jVar2 = this.f11640b0.get(i6);
                if (jVar2 != null) {
                    jVar2.b(i5);
                }
            }
        }
        j jVar3 = this.f11644d0;
        if (jVar3 != null) {
            jVar3.b(i5);
        }
    }

    private void m() {
        this.f11670y = false;
        this.f11671z = false;
        VelocityTracker velocityTracker = this.f11625I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f11625I = null;
        }
    }

    private Rect q(Rect rect, View view) {
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

    private void setScrollingCacheEnabled(boolean z5) {
        if (this.f11667v != z5) {
            this.f11667v = z5;
        }
    }

    private f t() {
        int i5;
        int clientWidth = getClientWidth();
        float f5 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f6 = clientWidth > 0 ? this.f11658m / clientWidth : 0.0f;
        int i6 = 0;
        boolean z5 = true;
        f fVar = null;
        int i7 = -1;
        float f7 = 0.0f;
        while (i6 < this.f11639b.size()) {
            f fVar2 = this.f11639b.get(i6);
            if (!z5 && fVar2.f11676b != (i5 = i7 + 1)) {
                fVar2 = this.f11641c;
                fVar2.f11679e = f5 + f7 + f6;
                fVar2.f11676b = i5;
                fVar2.f11678d = this.f11645e.e(i5);
                i6--;
            }
            f fVar3 = fVar2;
            f5 = fVar3.f11679e;
            float f8 = fVar3.f11678d + f5 + f6;
            if (!z5 && scrollX < f5) {
                break;
            }
            if (scrollX < f8 || i6 == this.f11639b.size() - 1) {
                return fVar3;
            }
            int i8 = fVar3.f11676b;
            float f9 = fVar3.f11678d;
            i6++;
            i7 = i8;
            f7 = f9;
            fVar = fVar3;
            z5 = false;
        }
        return fVar;
    }

    private static boolean w(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean y(float f5, float f6) {
        if (f5 >= this.f11618B || f6 <= 0.0f) {
            return f5 > ((float) (getWidth() - this.f11618B)) && f6 < 0.0f;
        }
        return true;
    }

    boolean B() throws Resources.NotFoundException {
        int i5 = this.f11647f;
        if (i5 <= 0) {
            return false;
        }
        M(i5 - 1, true);
        return true;
    }

    boolean C() throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.f11645e;
        if (aVar == null || this.f11647f >= aVar.c() - 1) {
            return false;
        }
        M(this.f11647f + 1, true);
        return true;
    }

    void F() throws Resources.NotFoundException {
        G(this.f11647f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cc A[PHI: r7 r10 r15
      0x00cc: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:64:0x00f0, B:61:0x00da, B:53:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:64:0x00f0, B:61:0x00da, B:53:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:64:0x00f0, B:61:0x00da, B:53:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void G(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.G(int):void");
    }

    public void M(int i5, boolean z5) throws Resources.NotFoundException {
        this.f11668w = false;
        N(i5, z5, false);
    }

    void N(int i5, boolean z5, boolean z6) throws Resources.NotFoundException {
        O(i5, z5, z6, 0);
    }

    void O(int i5, boolean z5, boolean z6, int i6) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.f11645e;
        if (aVar == null || aVar.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z6 && this.f11647f == i5 && this.f11639b.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i5 < 0) {
            i5 = 0;
        } else if (i5 >= this.f11645e.c()) {
            i5 = this.f11645e.c() - 1;
        }
        int i7 = this.f11669x;
        int i8 = this.f11647f;
        if (i5 > i8 + i7 || i5 < i8 - i7) {
            for (int i9 = 0; i9 < this.f11639b.size(); i9++) {
                this.f11639b.get(i9).f11677c = true;
            }
        }
        boolean z7 = this.f11647f != i5;
        if (!this.f11634U) {
            G(i5);
            L(i5, z5, i6, z7);
        } else {
            this.f11647f = i5;
            if (z7) {
                j(i5);
            }
            requestLayout();
        }
    }

    void P(int i5, int i6, int i7) throws Resources.NotFoundException {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f11655j;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.f11656k ? this.f11655j.getCurrX() : this.f11655j.getStartX();
            this.f11655j.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i8 = scrollX;
        int scrollY = getScrollY();
        int i9 = i5 - i8;
        int i10 = i6 - scrollY;
        if (i9 == 0 && i10 == 0) {
            f(false);
            F();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i11 = clientWidth / 2;
        float f5 = clientWidth;
        float f6 = i11;
        float fL = f6 + (l(Math.min(1.0f, (Math.abs(i9) * 1.0f) / f5)) * f6);
        int iAbs = Math.abs(i7);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fL / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i9) / ((f5 * this.f11645e.e(this.f11647f)) + this.f11658m)) + 1.0f) * 100.0f), 600);
        this.f11656k = false;
        this.f11655j.startScroll(i8, scrollY, i9, i10, iMin);
        H.a0(this);
    }

    f a(int i5, int i6) {
        f fVar = new f();
        fVar.f11676b = i5;
        fVar.f11675a = this.f11645e.f(this, i5);
        fVar.f11678d = this.f11645e.e(i5);
        if (i6 < 0 || i6 >= this.f11639b.size()) {
            this.f11639b.add(fVar);
            return fVar;
        }
        this.f11639b.add(i6, fVar);
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i5, int i6) {
        f fVarS;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.f11676b == this.f11647f) {
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
        f fVarS;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.f11676b == this.f11647f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean zW = gVar.f11680a | w(view);
        gVar.f11680a = zW;
        if (!this.f11666u) {
            super.addView(view, i5, layoutParams);
        } else {
            if (zW) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.f11683d = true;
            addViewInLayout(view, i5, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(int r5) {
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
            android.graphics.Rect r2 = r4.f11643d
            android.graphics.Rect r2 = r4.q(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f11643d
            android.graphics.Rect r3 = r4.q(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8e
            if (r2 < r3) goto L8e
            boolean r0 = r4.B()
            goto Lca
        L8e:
            boolean r0 = r1.requestFocus()
            goto Lca
        L93:
            if (r5 != r2) goto Lbf
            android.graphics.Rect r2 = r4.f11643d
            android.graphics.Rect r2 = r4.q(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f11643d
            android.graphics.Rect r3 = r4.q(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto Lae
            if (r2 > r3) goto Lae
            boolean r0 = r4.C()
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
            boolean r0 = r4.C()
            goto Lca
        Lc6:
            boolean r0 = r4.B()
        Lca:
            if (r0 == 0) goto Ld3
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.b(int):boolean");
    }

    public boolean c() {
        if (this.f11670y) {
            return false;
        }
        this.f11630Q = true;
        setScrollState(1);
        this.f11620D = 0.0f;
        this.f11622F = 0.0f;
        VelocityTracker velocityTracker = this.f11625I;
        if (velocityTracker == null) {
            this.f11625I = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.f11625I.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.f11631R = jUptimeMillis;
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i5) {
        if (this.f11645e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i5 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f11662q)) : i5 > 0 && scrollX < ((int) (((float) clientWidth) * this.f11663r));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f11656k = true;
        if (this.f11655j.isFinished() || !this.f11655j.computeScrollOffset()) {
            f(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f11655j.getCurrX();
        int currY = this.f11655j.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!D(currX)) {
                this.f11655j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        H.a0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || o(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarS;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.f11676b == this.f11647f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f11645e) != null && aVar.c() > 1)) {
            if (!this.f11632S.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f11662q * width);
                this.f11632S.setSize(height, width);
                zDraw = this.f11632S.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f11633T.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f11663r + 1.0f)) * width2);
                this.f11633T.setSize(height2, width2);
                zDraw |= this.f11633T.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.f11632S.finish();
            this.f11633T.finish();
        }
        if (zDraw) {
            H.a0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f11659n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    protected boolean e(View view, boolean z5, int i5, int i6, int i7) {
        int i8;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i9 = i6 + scrollX;
                if (i9 >= childAt.getLeft() && i9 < childAt.getRight() && (i8 = i7 + scrollY) >= childAt.getTop() && i8 < childAt.getBottom() && e(childAt, true, i5, i9 - childAt.getLeft(), i8 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z5 && view.canScrollHorizontally(-i5);
    }

    void g() throws Resources.NotFoundException {
        int iC = this.f11645e.c();
        this.f11637a = iC;
        boolean z5 = this.f11639b.size() < (this.f11669x * 2) + 1 && this.f11639b.size() < iC;
        int iMax = this.f11647f;
        int i5 = 0;
        boolean z6 = false;
        while (i5 < this.f11639b.size()) {
            f fVar = this.f11639b.get(i5);
            int iD = this.f11645e.d(fVar.f11675a);
            if (iD != -1) {
                if (iD == -2) {
                    this.f11639b.remove(i5);
                    i5--;
                    if (!z6) {
                        this.f11645e.m(this);
                        z6 = true;
                    }
                    this.f11645e.a(this, fVar.f11676b, fVar.f11675a);
                    int i6 = this.f11647f;
                    if (i6 == fVar.f11676b) {
                        iMax = Math.max(0, Math.min(i6, iC - 1));
                    }
                } else {
                    int i7 = fVar.f11676b;
                    if (i7 != iD) {
                        if (i7 == this.f11647f) {
                            iMax = iD;
                        }
                        fVar.f11676b = iD;
                    }
                }
                z5 = true;
            }
            i5++;
        }
        if (z6) {
            this.f11645e.b(this);
        }
        Collections.sort(this.f11639b, f11614k0);
        if (z5) {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                g gVar = (g) getChildAt(i8).getLayoutParams();
                if (!gVar.f11680a) {
                    gVar.f11682c = 0.0f;
                }
            }
            N(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.f11645e;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i5, int i6) {
        if (this.f11648f0 == 2) {
            i6 = (i5 - 1) - i6;
        }
        return ((g) this.f11650g0.get(i6).getLayoutParams()).f11685f;
    }

    public int getCurrentItem() {
        return this.f11647f;
    }

    public int getOffscreenPageLimit() {
        return this.f11669x;
    }

    public int getPageMargin() {
        return this.f11658m;
    }

    float l(float f5) {
        return (float) Math.sin((f5 - 0.5f) * 0.47123894f);
    }

    public void n() throws Resources.NotFoundException {
        if (!this.f11630Q) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.f11645e != null) {
            VelocityTracker velocityTracker = this.f11625I;
            velocityTracker.computeCurrentVelocity(1000, this.f11627K);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f11624H);
            this.f11668w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f fVarT = t();
            O(h(fVarT.f11676b, ((scrollX / clientWidth) - fVarT.f11679e) / fVarT.f11678d, xVelocity, (int) (this.f11620D - this.f11622F)), true, true, xVelocity);
        }
        m();
        this.f11630Q = false;
    }

    public boolean o(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            return keyEvent.hasModifiers(2) ? B() : b(17);
        }
        if (keyCode == 22) {
            return keyEvent.hasModifiers(2) ? C() : b(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (keyEvent.hasNoModifiers()) {
            return b(2);
        }
        if (keyEvent.hasModifiers(1)) {
            return b(1);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11634U = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f11652h0);
        Scroller scroller = this.f11655j;
        if (scroller != null && !scroller.isFinished()) {
            this.f11655j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i5;
        float f5;
        int i6;
        super.onDraw(canvas);
        if (this.f11658m <= 0 || this.f11659n == null || this.f11639b.size() <= 0 || this.f11645e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f6 = this.f11658m / width;
        int i7 = 0;
        f fVar = this.f11639b.get(0);
        float f7 = fVar.f11679e;
        int size = this.f11639b.size();
        int i8 = fVar.f11676b;
        int i9 = this.f11639b.get(size - 1).f11676b;
        while (i8 < i9) {
            while (true) {
                i5 = fVar.f11676b;
                if (i8 <= i5 || i7 >= size) {
                    break;
                }
                i7++;
                fVar = this.f11639b.get(i7);
            }
            if (i8 == i5) {
                float f8 = fVar.f11679e;
                float f9 = fVar.f11678d;
                f5 = (f8 + f9) * width;
                f7 = f8 + f9 + f6;
            } else {
                float fE = this.f11645e.e(i8);
                f5 = (f7 + fE) * width;
                f7 += fE + f6;
            }
            if (this.f11658m + f5 > scrollX) {
                i6 = scrollX;
                this.f11659n.setBounds(Math.round(f5), this.f11660o, Math.round(this.f11658m + f5), this.f11661p);
                this.f11659n.draw(canvas);
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
            K();
            return false;
        }
        if (action != 0) {
            if (this.f11670y) {
                return true;
            }
            if (this.f11671z) {
                return false;
            }
        }
        if (action == 0) {
            float x5 = motionEvent.getX();
            this.f11622F = x5;
            this.f11620D = x5;
            float y5 = motionEvent.getY();
            this.f11623G = y5;
            this.f11621E = y5;
            this.f11624H = motionEvent.getPointerId(0);
            this.f11671z = false;
            this.f11656k = true;
            this.f11655j.computeScrollOffset();
            if (this.f11654i0 != 2 || Math.abs(this.f11655j.getFinalX() - this.f11655j.getCurrX()) <= this.f11629M) {
                f(false);
                this.f11670y = false;
            } else {
                this.f11655j.abortAnimation();
                this.f11668w = false;
                F();
                this.f11670y = true;
                J(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i5 = this.f11624H;
            if (i5 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i5);
                float x6 = motionEvent.getX(iFindPointerIndex);
                float f5 = x6 - this.f11620D;
                float fAbs = Math.abs(f5);
                float y6 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y6 - this.f11623G);
                if (f5 != 0.0f && !y(this.f11620D, f5) && e(this, false, (int) f5, (int) x6, (int) y6)) {
                    this.f11620D = x6;
                    this.f11621E = y6;
                    this.f11671z = true;
                    return false;
                }
                int i6 = this.f11619C;
                if (fAbs > i6 && fAbs * 0.5f > fAbs2) {
                    this.f11670y = true;
                    J(true);
                    setScrollState(1);
                    float f6 = this.f11622F;
                    float f7 = this.f11619C;
                    this.f11620D = f5 > 0.0f ? f6 + f7 : f6 - f7;
                    this.f11621E = y6;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i6) {
                    this.f11671z = true;
                }
                if (this.f11670y && E(x6)) {
                    H.a0(this);
                }
            }
        } else if (action == 6) {
            A(motionEvent);
        }
        if (this.f11625I == null) {
            this.f11625I = VelocityTracker.obtain();
        }
        this.f11625I.addMovement(motionEvent);
        return this.f11670y;
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
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) throws Resources.NotFoundException {
        g gVar;
        g gVar2;
        int i7;
        setMeasuredDimension(View.getDefaultSize(0, i5), View.getDefaultSize(0, i6));
        int measuredWidth = getMeasuredWidth();
        this.f11618B = Math.min(measuredWidth / 10, this.f11617A);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i8 = 0;
        while (true) {
            boolean z5 = true;
            int i9 = 1073741824;
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8 && (gVar2 = (g) childAt.getLayoutParams()) != null && gVar2.f11680a) {
                int i10 = gVar2.f11681b;
                int i11 = i10 & 7;
                int i12 = i10 & 112;
                boolean z6 = i12 == 48 || i12 == 80;
                if (i11 != 3 && i11 != 5) {
                    z5 = false;
                }
                int i13 = Integer.MIN_VALUE;
                if (z6) {
                    i7 = Integer.MIN_VALUE;
                    i13 = 1073741824;
                } else {
                    i7 = z5 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i14 = ((ViewGroup.LayoutParams) gVar2).width;
                if (i14 != -2) {
                    if (i14 == -1) {
                        i14 = paddingLeft;
                    }
                    i13 = 1073741824;
                } else {
                    i14 = paddingLeft;
                }
                int i15 = ((ViewGroup.LayoutParams) gVar2).height;
                if (i15 == -2) {
                    i15 = measuredHeight;
                    i9 = i7;
                } else if (i15 == -1) {
                    i15 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14, i13), View.MeasureSpec.makeMeasureSpec(i15, i9));
                if (z6) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z5) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i8++;
        }
        this.f11664s = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f11665t = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f11666u = true;
        F();
        this.f11666u = false;
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8 && ((gVar = (g) childAt2.getLayoutParams()) == null || !gVar.f11680a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * gVar.f11682c), 1073741824), this.f11665t);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i5, Rect rect) {
        int i6;
        int i7;
        int i8;
        f fVarS;
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
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.f11676b == this.f11647f && childAt.requestFocus(i5, rect)) {
                return true;
            }
            i6 += i8;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof l)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        l lVar = (l) parcelable;
        super.onRestoreInstanceState(lVar.getSuperState());
        androidx.viewpager.widget.a aVar = this.f11645e;
        if (aVar != null) {
            aVar.i(lVar.f11689b, lVar.f11690c);
            N(lVar.f11688a, false, true);
        } else {
            this.f11649g = lVar.f11688a;
            this.f11651h = lVar.f11689b;
            this.f11653i = lVar.f11690c;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        l lVar = new l(super.onSaveInstanceState());
        lVar.f11688a = this.f11647f;
        androidx.viewpager.widget.a aVar = this.f11645e;
        if (aVar != null) {
            lVar.f11689b = aVar.j();
        }
        return lVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        if (i5 != i7) {
            int i9 = this.f11658m;
            H(i5, i7, i9, i9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(float f5) {
        if (!this.f11630Q) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.f11645e == null) {
            return;
        }
        this.f11620D += f5;
        float scrollX = getScrollX() - f5;
        float clientWidth = getClientWidth();
        float f6 = this.f11662q * clientWidth;
        float f7 = this.f11663r * clientWidth;
        f fVar = this.f11639b.get(0);
        f fVar2 = this.f11639b.get(r4.size() - 1);
        if (fVar.f11676b != 0) {
            f6 = fVar.f11679e * clientWidth;
        }
        if (fVar2.f11676b != this.f11645e.c() - 1) {
            f7 = fVar2.f11679e * clientWidth;
        }
        if (scrollX < f6) {
            scrollX = f6;
        } else if (scrollX > f7) {
            scrollX = f7;
        }
        int i5 = (int) scrollX;
        this.f11620D += scrollX - i5;
        scrollTo(i5, getScrollY());
        D(i5);
        MotionEvent motionEventObtain = MotionEvent.obtain(this.f11631R, SystemClock.uptimeMillis(), 2, this.f11620D, 0.0f, 0);
        this.f11625I.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    f r(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return s(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f11666u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    f s(View view) {
        for (int i5 = 0; i5 < this.f11639b.size(); i5++) {
            f fVar = this.f11639b.get(i5);
            if (this.f11645e.g(view, fVar.f11675a)) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar2 = this.f11645e;
        if (aVar2 != null) {
            aVar2.l(null);
            this.f11645e.m(this);
            for (int i5 = 0; i5 < this.f11639b.size(); i5++) {
                f fVar = this.f11639b.get(i5);
                this.f11645e.a(this, fVar.f11676b, fVar.f11675a);
            }
            this.f11645e.b(this);
            this.f11639b.clear();
            I();
            this.f11647f = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.f11645e;
        this.f11645e = aVar;
        this.f11637a = 0;
        if (aVar != null) {
            if (this.f11657l == null) {
                this.f11657l = new k();
            }
            this.f11645e.l(this.f11657l);
            this.f11668w = false;
            boolean z5 = this.f11634U;
            this.f11634U = true;
            this.f11637a = this.f11645e.c();
            if (this.f11649g >= 0) {
                this.f11645e.i(this.f11651h, this.f11653i);
                N(this.f11649g, false, true);
                this.f11649g = -1;
                this.f11651h = null;
                this.f11653i = null;
            } else if (z5) {
                requestLayout();
            } else {
                F();
            }
        }
        List<i> list = this.f11646e0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f11646e0.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f11646e0.get(i6).a(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i5) throws Resources.NotFoundException {
        this.f11668w = false;
        N(i5, !this.f11634U, false);
    }

    public void setOffscreenPageLimit(int i5) throws Resources.NotFoundException {
        if (i5 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i5 + " too small; defaulting to 1");
            i5 = 1;
        }
        if (i5 != this.f11669x) {
            this.f11669x = i5;
            F();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.f11642c0 = jVar;
    }

    public void setPageMargin(int i5) {
        int i6 = this.f11658m;
        this.f11658m = i5;
        int width = getWidth();
        H(width, width, i5, i6);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f11659n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i5) {
        if (this.f11654i0 == i5) {
            return;
        }
        this.f11654i0 = i5;
        k(i5);
    }

    f u(int i5) {
        for (int i6 = 0; i6 < this.f11639b.size(); i6++) {
            f fVar = this.f11639b.get(i6);
            if (fVar.f11676b == i5) {
                return fVar;
            }
        }
        return null;
    }

    void v() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f11655j = new Scroller(context, f11615l0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.f11619C = viewConfiguration.getScaledPagingTouchSlop();
        this.f11626J = (int) (400.0f * f5);
        this.f11627K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f11632S = new EdgeEffect(context);
        this.f11633T = new EdgeEffect(context);
        this.f11628L = (int) (25.0f * f5);
        this.f11629M = (int) (2.0f * f5);
        this.f11617A = (int) (f5 * 16.0f);
        H.k0(this, new h());
        if (H.v(this) == 0) {
            H.t0(this, 1);
        }
        H.w0(this, new d());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f11659n;
    }

    public boolean x() {
        return this.f11630Q;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void z(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.f11638a0
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
            androidx.viewpager.widget.ViewPager$g r8 = (androidx.viewpager.widget.ViewPager.g) r8
            boolean r9 = r8.f11680a
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.f11681b
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
            r11.i(r12, r13, r14)
            r11.f11636W = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.z(int, float, int):void");
    }

    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11680a;

        /* renamed from: b, reason: collision with root package name */
        public int f11681b;

        /* renamed from: c, reason: collision with root package name */
        float f11682c;

        /* renamed from: d, reason: collision with root package name */
        boolean f11683d;

        /* renamed from: e, reason: collision with root package name */
        int f11684e;

        /* renamed from: f, reason: collision with root package name */
        int f11685f;

        public g() {
            super(-1, -1);
            this.f11682c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f11682c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f11613j0);
            this.f11681b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i5) {
        setPageMarginDrawable(androidx.core.content.a.e(getContext(), i5));
    }
}
