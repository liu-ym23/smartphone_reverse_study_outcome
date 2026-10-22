package stepos.support.v7.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.C0478x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class OverScrollLayout extends FrameLayout {

    /* renamed from: y, reason: collision with root package name */
    static final Interpolator f21571y = new b();

    /* renamed from: a, reason: collision with root package name */
    private StepOSRecyclerView f21572a;

    /* renamed from: b, reason: collision with root package name */
    int f21573b;

    /* renamed from: c, reason: collision with root package name */
    int f21574c;

    /* renamed from: d, reason: collision with root package name */
    int f21575d;

    /* renamed from: e, reason: collision with root package name */
    e f21576e;

    /* renamed from: f, reason: collision with root package name */
    c f21577f;

    /* renamed from: g, reason: collision with root package name */
    private int f21578g;

    /* renamed from: h, reason: collision with root package name */
    private int f21579h;

    /* renamed from: i, reason: collision with root package name */
    private int f21580i;

    /* renamed from: j, reason: collision with root package name */
    private int f21581j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f21582k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f21583l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f21584m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f21585n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f21586o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f21587p;

    /* renamed from: q, reason: collision with root package name */
    private float f21588q;

    /* renamed from: r, reason: collision with root package name */
    private VelocityTracker f21589r;

    /* renamed from: s, reason: collision with root package name */
    private int f21590s;

    /* renamed from: t, reason: collision with root package name */
    private TimeInterpolator f21591t;

    /* renamed from: u, reason: collision with root package name */
    private C0478x f21592u;

    /* renamed from: v, reason: collision with root package name */
    private OverScroller f21593v;

    /* renamed from: w, reason: collision with root package name */
    private d f21594w;

    /* renamed from: x, reason: collision with root package name */
    private RecyclerView.OnScrollListener f21595x;

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i5) throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (i5 != 0) {
                if (i5 == 1) {
                    OverScrollLayout.this.f21572a.removeOnScrollListener(OverScrollLayout.this.f21595x);
                    return;
                }
                return;
            }
            OverScrollLayout.this.f21572a.removeOnScrollListener(OverScrollLayout.this.f21595x);
            OverScrollLayout.this.f21593v.computeScrollOffset();
            if (OverScrollLayout.this.s()) {
                if (OverScrollLayout.this.f21594w == null) {
                    OverScrollLayout overScrollLayout = OverScrollLayout.this;
                    overScrollLayout.f21594w = overScrollLayout.new d();
                }
                int currVelocity = (int) OverScrollLayout.this.f21593v.getCurrVelocity();
                if (OverScrollLayout.this.f21590s == 0 || OverScrollLayout.this.f21590s == 0 ? currVelocity <= 0 : currVelocity > 0) {
                    currVelocity = -currVelocity;
                }
                OverScrollLayout overScrollLayout2 = OverScrollLayout.this;
                overScrollLayout2.f21573b = overScrollLayout2.getNewOverflingDistance();
                if (OverScrollLayout.this.f21578g == 1) {
                    OverScrollLayout.this.f21594w.b(0, currVelocity);
                } else if (OverScrollLayout.this.f21578g == 0) {
                    OverScrollLayout.this.f21594w.b(currVelocity, 0);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
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

    private class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final a5.d f21597a;

        c() {
            this.f21597a = new a5.d(OverScrollLayout.this.getContext());
        }

        void a() throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            OverScrollLayout.this.removeCallbacks(this);
            this.f21597a.b();
        }

        void b() {
            if (this.f21597a.h(OverScrollLayout.this.getScrollX(), 0, 0, 0, 0, 0)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            a5.d dVar = this.f21597a;
            if (!dVar.c()) {
                a();
                return;
            }
            int scrollX = OverScrollLayout.this.getScrollX();
            int iE = dVar.e();
            OverScrollLayout overScrollLayout = OverScrollLayout.this;
            if (!overScrollLayout.overScrollBy(iE - scrollX, 0, scrollX, 0, 0, 0, overScrollLayout.f21573b, 0, false)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            } else if ((scrollX > 0 || iE <= 0) && (scrollX < 0 || iE >= 0)) {
                b();
            } else {
                dVar.b();
            }
        }
    }

    private class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final a5.d f21599a;

        /* renamed from: b, reason: collision with root package name */
        private int f21600b;

        /* renamed from: c, reason: collision with root package name */
        private int f21601c;

        d() {
            this.f21599a = new a5.d(OverScrollLayout.this.getContext(), OverScrollLayout.f21571y);
        }

        void a() throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            OverScrollLayout.this.removeCallbacks(this);
            this.f21599a.b();
        }

        void b(int i5, int i6) throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            this.f21601c = i6;
            a5.d dVar = this.f21599a;
            int i7 = OverScrollLayout.this.f21573b;
            dVar.d(0, 0, i5, i6, 0, 0, 0, 0, i7, i7);
            this.f21600b = 0;
            OverScrollLayout.this.postOnAnimation(this);
        }

        void c() {
            if (this.f21599a.h(0, OverScrollLayout.this.getScrollY(), 0, 0, 0, 0)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            a5.d dVar = this.f21599a;
            if (!dVar.c()) {
                a();
                OverScrollLayout.this.t();
                return;
            }
            if (OverScrollLayout.this.f21578g == 1) {
                int scrollY = OverScrollLayout.this.getScrollY();
                int iF = dVar.f();
                int i5 = iF - this.f21600b;
                OverScrollLayout overScrollLayout = OverScrollLayout.this;
                if (!overScrollLayout.overScrollBy(0, i5, 0, overScrollLayout.getScrollY(), 0, 0, 0, OverScrollLayout.this.f21573b, false)) {
                    OverScrollLayout.this.invalidate();
                    OverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollY > 0 || iF <= 0) && (scrollY < 0 || iF >= 0)) {
                    c();
                } else {
                    dVar.b();
                }
                this.f21600b = iF;
                return;
            }
            int scrollX = OverScrollLayout.this.getScrollX();
            int iE = dVar.e();
            int i6 = iE - this.f21600b;
            OverScrollLayout overScrollLayout2 = OverScrollLayout.this;
            if (!overScrollLayout2.overScrollBy(i6, 0, overScrollLayout2.getScrollX(), 0, 0, 0, OverScrollLayout.this.f21573b, 0, false)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            } else if ((scrollX > 0 || iE <= 0) && (scrollX < 0 || iE >= 0)) {
                c();
            } else {
                dVar.b();
            }
            this.f21600b = iE;
        }
    }

    private class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final a5.d f21603a;

        e() {
            this.f21603a = new a5.d(OverScrollLayout.this.getContext());
        }

        void a() throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            OverScrollLayout.this.removeCallbacks(this);
            this.f21603a.b();
        }

        void b() {
            if (this.f21603a.h(0, OverScrollLayout.this.getScrollY(), 0, 0, 0, 0)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            a5.d dVar = this.f21603a;
            if (!dVar.c()) {
                a();
                return;
            }
            int scrollY = OverScrollLayout.this.getScrollY();
            int iF = dVar.f();
            OverScrollLayout overScrollLayout = OverScrollLayout.this;
            if (!overScrollLayout.overScrollBy(0, iF - scrollY, 0, scrollY, 0, 0, 0, overScrollLayout.f21573b, false)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            } else if ((scrollY > 0 || iF <= 0) && (scrollY < 0 || iF >= 0)) {
                b();
            } else {
                dVar.b();
            }
        }
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNewOverflingDistance() {
        return (int) (getHeight() * 0.5f);
    }

    private boolean o(int i5) {
        int iComputeHorizontalScrollOffset = this.f21572a.computeHorizontalScrollOffset();
        int iComputeHorizontalScrollRange = this.f21572a.computeHorizontalScrollRange() - this.f21572a.computeHorizontalScrollExtent();
        if (iComputeHorizontalScrollRange == 0) {
            return false;
        }
        return i5 < 0 ? iComputeHorizontalScrollOffset > 50 : iComputeHorizontalScrollOffset < iComputeHorizontalScrollRange - 50;
    }

    private boolean p(int i5) {
        int iComputeVerticalScrollOffset = this.f21572a.computeVerticalScrollOffset();
        int iComputeVerticalScrollRange = this.f21572a.computeVerticalScrollRange() - this.f21572a.computeVerticalScrollExtent();
        if (iComputeVerticalScrollRange == 0) {
            return false;
        }
        return i5 < 0 ? iComputeVerticalScrollOffset > 50 : iComputeVerticalScrollOffset < iComputeVerticalScrollRange - 50;
    }

    private boolean q(View view) {
        if (view instanceof RecyclerView) {
            this.f21572a = (StepOSRecyclerView) view;
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                if (q(viewGroup.getChildAt(i5))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        if (this.f21593v.isFinished()) {
            return false;
        }
        if (this.f21578g != 0 || ((this.f21590s != 0 || this.f21572a.canScrollHorizontally(1)) && (this.f21590s != 1 || this.f21572a.canScrollHorizontally(-1)))) {
            if (this.f21578g != 1) {
                return false;
            }
            if ((this.f21590s != 0 || this.f21572a.canScrollVertically(1)) && (this.f21590s != 1 || this.f21572a.canScrollVertically(-1))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (getScrollY() != 0) {
            if (this.f21576e == null) {
                this.f21576e = new e();
            }
            this.f21576e.b();
        } else if (getScrollX() != 0) {
            if (this.f21577f == null) {
                this.f21577f = new c();
            }
            this.f21577f.b();
        }
    }

    private int u(int i5, int i6) {
        int i7 = this.f21573b;
        if (i6 == 0 || i7 == 0) {
            return i5;
        }
        if (i6 * i5 >= 0) {
            return i5 / 2;
        }
        float interpolation = 1.0f - this.f21591t.getInterpolation((Math.abs(i6) * 1.0f) / i7);
        if (interpolation < 0.0f) {
            interpolation = 0.0f;
        }
        int i8 = (int) (i5 * interpolation);
        if (i5 > 0) {
            if (i8 == 0) {
                i8 = 1;
            }
        } else if (i8 == 0) {
            i8 = -1;
        }
        if (Math.abs(i6) >= i7) {
            return 0;
        }
        return i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0160  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r16) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 841
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.OverScrollLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) {
            throw new IllegalStateException("OverScrollLayout only can host 1 elements");
        }
        if (!q(getChildAt(0))) {
            throw new IllegalStateException("OverScrollLayout only contain recyclerview");
        }
        this.f21588q = 1.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f5, float f6) {
        int i5 = this.f21590s;
        if ((i5 == 1 && f6 < 0.0f) || ((i5 == 0 && f6 > 0.0f) || ((i5 == 1 && f5 < 0.0f) || (i5 == 0 && f5 > 0.0f)))) {
            this.f21572a.addOnScrollListener(this.f21595x);
            OverScroller overScroller = new OverScroller(view.getContext(), f21571y);
            this.f21593v = overScroller;
            overScroller.fling(0, 0, (int) f5, (int) f6, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i5) {
        this.f21592u.b(view, view2, i5);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i5, int i6, boolean z5, boolean z6) {
        int i7 = this.f21578g;
        if (i7 == 1) {
            if (getScrollY() != i6) {
                onScrollChanged(i5, i6, getScrollX(), getScrollY());
                setScrollY(i6);
                r();
                awakenScrollBars();
                return;
            }
            return;
        }
        if (i7 != 0 || getScrollX() == i5) {
            return;
        }
        onScrollChanged(i5, i6, getScrollX(), getScrollY());
        setScrollX(i5);
        r();
        awakenScrollBars();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        if (this.f21572a.getLayoutManager() instanceof LinearLayoutManager) {
            this.f21578g = ((LinearLayoutManager) this.f21572a.getLayoutManager()).getOrientation();
        }
        int i9 = this.f21578g;
        if (i9 == 1) {
            this.f21573b = (int) (i6 * 0.5f);
        } else if (i9 == 0) {
            this.f21573b = (int) (i5 * 0.5f);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i5) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f21592u.d(view);
    }

    protected void r() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public void setAntiShakeValue(int i5) {
        this.f21579h = i5;
    }

    public void setConfictRatio(float f5) {
        this.f21588q = f5;
    }

    public void setOverScrollEnable(boolean z5) {
        this.f21587p = z5;
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21578g = -1;
        this.f21579h = 0;
        this.f21580i = 0;
        this.f21581j = 0;
        this.f21583l = true;
        this.f21584m = true;
        this.f21585n = true;
        this.f21586o = true;
        this.f21587p = true;
        this.f21588q = 0.0f;
        this.f21590s = 0;
        this.f21591t = androidx.core.view.animation.a.a(0.12f, 0.0f, 0.33f, 1.0f);
        this.f21595x = new a();
        setOverScrollMode(0);
        this.f21582k = true;
        this.f21592u = new C0478x(this);
    }
}
