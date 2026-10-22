package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.PathInterpolator;
import android.widget.OverScroller;
import com.stepos.aiengine.R;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PopupNestedScrollingLayout extends ViewGroup implements v0.p {
    public static final PathInterpolator N = new PathInterpolator(0.2f, 0.03f, 0.0f, 1.0f);
    public static final float O = 0.88f;
    public static final float P = 340.0f;
    public static final float Q = 0.93f;
    public static final float R = 400.0f;
    public static final float S = 0.98f;
    public static final float T = 300.0f;
    public static final float U = 0.88f;
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public float F;
    public float G;
    public float H;
    public boolean I;
    public boolean J;
    public boolean K;
    public View L;
    public int M;

    /* renamed from: a, reason: collision with root package name */
    public final float f12542a;

    /* renamed from: b, reason: collision with root package name */
    public final VelocityTracker f12543b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12544c;

    /* renamed from: d, reason: collision with root package name */
    public final PathInterpolator f12545d;

    /* renamed from: e, reason: collision with root package name */
    public final h1.f f12546e;
    public final float h;

    /* renamed from: j, reason: collision with root package name */
    public final int f12547j;

    /* renamed from: k, reason: collision with root package name */
    public final int f12548k;

    /* renamed from: l, reason: collision with root package name */
    public final int f12549l;

    /* renamed from: m, reason: collision with root package name */
    public final int f12550m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12551n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12552o;

    /* renamed from: p, reason: collision with root package name */
    public int f12553p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f12554q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f12555s;

    /* renamed from: t, reason: collision with root package name */
    public int f12556t;

    /* renamed from: u, reason: collision with root package name */
    public int f12557u;

    /* renamed from: v, reason: collision with root package name */
    public int f12558v;

    /* renamed from: w, reason: collision with root package name */
    public int f12559w;

    /* renamed from: x, reason: collision with root package name */
    public stepos.support.v7.app.q f12560x;

    /* renamed from: y, reason: collision with root package name */
    public final a f12561y;
    public boolean z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PathInterpolator pathInterpolator = PopupNestedScrollingLayout.N;
            PopupNestedScrollingLayout.this.f12551n = true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12563a;

        public b(int i10) {
            this.f12563a = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i10 = this.f12563a;
            PopupNestedScrollingLayout popupNestedScrollingLayout = PopupNestedScrollingLayout.this;
            popupNestedScrollingLayout.o(i10 - popupNestedScrollingLayout.f12555s);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12565a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12566b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f12567c;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface d {
    }

    public PopupNestedScrollingLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        this.f12545d = new PathInterpolator(0.12f, 0.0f, 0.33f, 1.0f);
        this.f12551n = false;
        this.f12554q = true;
        this.r = 1;
        this.f12555s = 0;
        this.f12561y = new a();
        this.z = true;
        this.B = 0;
        this.C = true;
        this.D = false;
        this.E = false;
        this.M = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ce.a.f3414c, 0, 0);
        this.f12559w = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f12544c = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_padding_top));
        typedArrayObtainStyledAttributes.recycle();
        new OverScroller(context, N);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f12542a = viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = getResources().getDimensionPixelSize(R.dimen.stepos_config_popup_nested_scroll_abandon_velocity);
        getResources().getDimensionPixelSize(R.dimen.stepos_config_popup_nested_fling_down_velocity);
        this.f12543b = VelocityTracker.obtain();
        setClipToPadding(false);
        this.f12548k = viewConfiguration.getScaledTouchSlop();
        this.f12549l = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_over_scroll_distance);
        this.f12550m = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_dismiss_triggered_distance);
        this.f12547j = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_scroll_down_threshold);
        this.f12556t = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_middle_state_height);
        h1.f fVar = new h1.f(new h1.e());
        this.f12546e = fVar;
        fVar.b(new q(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.view.View r9, int r10, int r11, int r12) {
        /*
            boolean r0 = r9 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L4b
            r0 = r9
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r9.getScrollX()
            int r3 = r9.getScrollY()
            int r4 = r0.getChildCount()
            int r4 = r4 - r1
        L15:
            if (r4 < 0) goto L4b
            android.view.View r5 = r0.getChildAt(r4)
            int r6 = r11 + r2
            int r7 = r5.getLeft()
            if (r6 < r7) goto L48
            int r7 = r5.getRight()
            if (r6 >= r7) goto L48
            int r7 = r12 + r3
            int r8 = r5.getTop()
            if (r7 < r8) goto L48
            int r8 = r5.getBottom()
            if (r7 >= r8) goto L48
            int r8 = r5.getLeft()
            int r6 = r6 - r8
            int r8 = r5.getTop()
            int r7 = r7 - r8
            boolean r5 = a(r5, r10, r6, r7)
            if (r5 == 0) goto L48
            goto L56
        L48:
            int r4 = r4 + (-1)
            goto L15
        L4b:
            if (r10 <= 0) goto L4f
            r10 = -1
            goto L50
        L4f:
            r10 = r1
        L50:
            boolean r9 = r9.canScrollVertically(r10)
            if (r9 == 0) goto L57
        L56:
            return r1
        L57:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.a(android.view.View, int, int, int):boolean");
    }

    public static View c(ViewGroup viewGroup, float f8, float f9) {
        View viewC;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (g(childAt, f8, f9)) {
                if ((childAt instanceof ViewGroup) && (viewC = c((ViewGroup) childAt, (f8 - childAt.getX()) + childAt.getScrollX(), (f9 - childAt.getY()) + childAt.getScrollY())) != null) {
                    return viewC;
                }
                WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
                if (e0.d.g(childAt)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public static View d(ViewGroup viewGroup, float f8, float f9) {
        View viewD;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (g(childAt, f8, f9)) {
                if (!(childAt instanceof SurfaceView) && !(childAt instanceof TextureView) && !Boolean.TRUE.equals(childAt.getTag(R.id.stepos_lite_popup_self_handled_touch))) {
                    String name = childAt.getClass().getName();
                    if (!name.endsWith(".GLRootView") && !name.endsWith(".GLSurfaceView")) {
                        if ((childAt instanceof ViewGroup) && (viewD = d((ViewGroup) childAt, (f8 - childAt.getX()) + childAt.getScrollX(), (f9 - childAt.getY()) + childAt.getScrollY())) != null) {
                            return viewD;
                        }
                    }
                }
                return childAt;
            }
        }
        return null;
    }

    public static boolean g(View view, float f8, float f9) {
        float x3 = view.getX();
        float y3 = view.getY();
        return f8 >= x3 && f9 >= y3 && f8 < ((float) view.getWidth()) + x3 && f9 < ((float) view.getHeight()) + y3;
    }

    private void setSpringForce(int i10) {
        int i11 = this.r;
        h1.f fVar = this.f12546e;
        if (i11 == i10) {
            h1.g gVar = new h1.g();
            gVar.a(S);
            gVar.b(T);
            fVar.f9241t = gVar;
            return;
        }
        if (i10 == 0 || i10 == 1) {
            h1.g gVar2 = new h1.g();
            gVar2.a(O);
            gVar2.b(P);
            fVar.f9241t = gVar2;
            return;
        }
        if (i10 != 2) {
            return;
        }
        h1.g gVar3 = new h1.g();
        gVar3.a(Q);
        gVar3.b(R);
        fVar.f9241t = gVar3;
    }

    public final void b() {
        if (this.f12560x == null || this.z || !m()) {
            return;
        }
        if (!this.E && post(this.f12561y)) {
            this.E = true;
        }
        if (this.E) {
            return;
        }
        this.f12551n = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(float r7, int r8) {
        /*
            r6 = this;
            boolean r0 = r6.z
            if (r0 != 0) goto L9
            int r1 = r6.B
            if (r1 == 0) goto L9
            goto Ld
        L9:
            boolean r1 = r6.f12552o
            if (r1 == 0) goto Le
        Ld:
            return r8
        Le:
            int r1 = r6.f12555s
            int r2 = r6.f12557u
            int r2 = -r2
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 < r2) goto L33
            if (r1 >= 0) goto L33
            int r1 = r6.B
            if (r1 != r5) goto L23
            int r6 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r6 <= 0) goto L44
            goto L3b
        L23:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 < 0) goto L29
            if (r0 != 0) goto L3b
        L29:
            float r6 = r6.h
            float r6 = -r6
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 >= 0) goto L44
            if (r8 != 0) goto L44
            goto L42
        L33:
            int r6 = r6.B
            if (r6 != r3) goto L3c
            int r6 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r6 <= 0) goto L42
        L3b:
            return r3
        L3c:
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L44
            if (r6 != 0) goto L44
        L42:
            r6 = 0
            return r6
        L44:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.e(float, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0064 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(int r7) {
        /*
            r6 = this;
            boolean r0 = r6.z
            if (r0 != 0) goto L9
            int r0 = r6.B
            if (r0 == 0) goto L9
            return r7
        L9:
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L10
            int r2 = r6.f12558v
            goto L17
        L10:
            if (r7 != r1) goto L14
            r2 = r0
            goto L17
        L14:
            int r2 = r6.f12557u
            int r2 = -r2
        L17:
            int r3 = r6.f12555s
            int r3 = r3 - r2
            int r2 = java.lang.Math.abs(r3)
            int r4 = r6.f12547j
            r5 = 2
            if (r3 <= 0) goto L37
            if (r7 != r5) goto L2e
            int r6 = r6.f12557u
            int r6 = r6 + r4
            if (r2 <= r6) goto L2b
            goto L55
        L2b:
            if (r2 <= r4) goto L64
            goto L63
        L2e:
            if (r7 != r1) goto L55
            if (r2 <= r4) goto L63
            int r6 = r6.B
            if (r6 != 0) goto L63
            goto L55
        L37:
            if (r7 != 0) goto L56
            int r7 = r6.B
            if (r7 != r5) goto L44
            if (r2 <= r4) goto L55
            boolean r6 = r6.z
            if (r6 == 0) goto L55
            goto L64
        L44:
            int r7 = r6.f12558v
            int r7 = r7 + r4
            if (r2 <= r7) goto L52
            boolean r7 = r6.z
            if (r7 == 0) goto L52
            boolean r6 = r6.f12552o
            if (r6 != 0) goto L52
            goto L64
        L52:
            if (r2 <= r4) goto L55
            goto L63
        L55:
            return r0
        L56:
            if (r7 != r1) goto L64
            if (r2 <= r4) goto L63
            boolean r7 = r6.z
            if (r7 == 0) goto L63
            boolean r6 = r6.f12552o
            if (r6 != 0) goto L63
            goto L64
        L63:
            return r1
        L64:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.f(int):int");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        c cVar = new c(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ce.a.f3415d);
        cVar.f12565a = typedArrayObtainStyledAttributes.getBoolean(0, false);
        cVar.f12566b = typedArrayObtainStyledAttributes.getBoolean(1, false);
        cVar.f12567c = typedArrayObtainStyledAttributes.getBoolean(2, false);
        typedArrayObtainStyledAttributes.recycle();
        return cVar;
    }

    public int getCurrentScrollY() {
        return this.f12555s;
    }

    public int getPositionState() {
        return this.r;
    }

    public int getUncollapsibleHeight() {
        return this.f12557u;
    }

    @Override // v0.o
    public final void h(int i10, View view) throws Settings.SettingNotFoundException {
        if (this.f12546e.f9232f) {
            return;
        }
        int iF = f(this.r);
        int i11 = this.f12553p;
        if (i11 != -1 && i11 != 2) {
            iF = i11;
        }
        q(iF);
        b();
    }

    @Override // v0.o
    public final void j(View view, int i10, int i11, int[] iArr, int i12) {
        boolean z = false;
        boolean z3 = i11 > 0 && (((!this.D ? this.f12555s < this.f12558v : this.f12555s <= this.f12558v) && this.B != 1) || (this.f12555s < 0 && this.B == 1));
        if (i11 < 0 && !view.canScrollVertically(-1)) {
            z = true;
        }
        if (z3 || (z && !this.f12552o)) {
            iArr[1] = n(i11, true);
        } else if (i11 != 0) {
            this.f12552o = true;
        }
    }

    @Override // v0.p
    public final void k(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i13 >= 0 || view.canScrollVertically(-1) || this.f12552o) {
            return;
        }
        iArr[1] = n(i13, true);
    }

    public final boolean m() {
        int i10 = this.B;
        int i11 = this.f12548k;
        int i12 = this.f12550m;
        if (i10 == 1 || this.r == 1) {
            if (this.f12555s > (-(i12 - i11)) || this.f12551n) {
                return false;
            }
        } else if (i10 != 2 || Math.abs(this.f12555s - this.f12558v) < i12 - i11 || this.f12551n) {
            return false;
        }
        return true;
    }

    public final int n(int i10, boolean z) {
        int i11 = this.f12555s;
        int i12 = i11 + i10;
        int i13 = this.f12558v;
        if (i12 > i13) {
            i10 = i13 - i11;
        }
        if (!this.z) {
            int i14 = this.B;
            if (i14 == 1 && (i10 < 0 || !z)) {
                i10 = s(i10, i11);
            } else if (i14 == 2 && (i10 < 0 || !z)) {
                i10 = s(i10, i11 - i13);
            } else if (this.r == 1 && i10 < 0) {
                i10 = s(i10, i11);
            }
        } else if (this.f12552o && i10 < 0 && i11 <= 0) {
            i10 = s(i10, i11);
        } else if (this.B == 1 && i10 > 0 && !z) {
            i10 = s(i10, i11);
        }
        this.f12546e.f();
        o(i10);
        return i10;
    }

    public final void o(int i10) {
        int i11 = -i10;
        int i12 = this.f12555s;
        int i13 = (-i11) + i12 >= 0 ? -this.M : (i12 <= 0 || i11 <= 0) ? i11 : i11 - i12;
        this.M += i13;
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (((c) childAt.getLayoutParams()).f12565a) {
                childAt.offsetTopAndBottom(i13);
            } else {
                childAt.offsetTopAndBottom(i11);
            }
        }
        int i15 = this.f12555s + i10;
        this.f12555s = i15;
        if (i15 >= 0 || this.f12560x == null) {
            return;
        }
        float fAbs = Math.abs(i15);
        float f8 = fAbs / this.f12557u;
        stepos.support.v7.app.s sVar = stepos.support.v7.app.s.this;
        int i16 = (int) ((1.0f - f8) * sVar.f12262b);
        sVar.f12261a.setAlpha(i16);
        sVar.f12265e = i16;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Configuration configuration = getResources().getConfiguration();
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        setPadding(getPaddingLeft(), configuration.orientation == 1 ? this.f12544c + systemWindowInsetTop : systemWindowInsetTop, getPaddingRight(), getPaddingBottom());
        return windowInsets.inset(0, systemWindowInsetTop, 0, 0);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        requestLayout();
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.stepos_lite_popup_padding_horizontal_f);
        setPadding(dimensionPixelOffset, getPaddingTop(), dimensionPixelOffset, getPaddingBottom());
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View childAt;
        View view;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.A = false;
            this.f12551n = false;
            this.E = false;
            this.f12552o = false;
            this.J = false;
            this.K = false;
            this.f12553p = -1;
            this.F = motionEvent.getX();
            this.G = motionEvent.getY();
            this.H = motionEvent.getY();
            float f8 = this.F;
            float f9 = this.G;
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    childAt = null;
                    break;
                }
                childAt = getChildAt(childCount);
                if (g(childAt, f8, f9)) {
                    break;
                }
                childCount--;
            }
            this.L = childAt;
            this.I = childAt != null;
            this.J = c(this, this.F, this.G) != null;
            this.K = d(this, this.F, this.G) != null;
        } else if (actionMasked == 2) {
            if (this.J || this.K) {
                this.H = motionEvent.getY();
                return false;
            }
            float y3 = motionEvent.getY() - this.G;
            float y5 = motionEvent.getY() - this.H;
            if (!this.A && (view = this.L) != null && !a(view, (int) y5, (int) (this.F - view.getLeft()), (int) (this.G - this.L.getTop())) && Math.abs(y3) > this.f12548k) {
                this.A = true;
            }
            this.H = motionEvent.getY();
        }
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        int width = getWidth();
        int measuredHeight = (getMeasuredHeight() - this.f12557u) - this.f12555s;
        int paddingLeft = getPaddingLeft();
        int paddingRight = width - getPaddingRight();
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            c cVar = (c) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !cVar.f12565a) {
                int i15 = measuredHeight + ((ViewGroup.MarginLayoutParams) cVar).topMargin;
                int measuredHeight2 = childAt.getMeasuredHeight() + i15;
                int measuredWidth = childAt.getMeasuredWidth();
                int i16 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft;
                childAt.layout(i16, i15, measuredWidth + i16, measuredHeight2);
                measuredHeight = measuredHeight2 + ((ViewGroup.MarginLayoutParams) cVar).bottomMargin;
            }
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            c cVar2 = (c) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && cVar2.f12565a) {
                int height = (((getHeight() - childAt2.getMeasuredHeight()) - (cVar2.f12566b ? 0 : getPaddingBottom())) - ((ViewGroup.MarginLayoutParams) cVar2).bottomMargin) + this.M;
                int measuredHeight3 = childAt2.getMeasuredHeight() + height;
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int i18 = (((paddingRight - paddingLeft) - measuredWidth2) / 2) + paddingLeft;
                childAt2.layout(i18, height, measuredWidth2 + i18, measuredHeight3);
            }
        }
        if (this.B == 2 && this.r != 2 && z) {
            this.r = 0;
            o(this.f12558v - this.f12555s);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int iRound;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (this.f12559w < size2) {
            this.f12559w = size2;
        }
        int iMin = Math.min(size2, this.f12559w);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int measuredHeight = paddingTop;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            c cVar = (c) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !cVar.f12567c) {
                measureChildWithMargins(childAt, iMakeMeasureSpec, 0, iMakeMeasureSpec2, measuredHeight);
                if (!cVar.f12566b) {
                    measuredHeight = childAt.getMeasuredHeight() + measuredHeight;
                }
            }
        }
        int i13 = iMin - measuredHeight;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            c cVar2 = (c) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && cVar2.f12567c) {
                if ((childAt2 instanceof LitePopupContentFrameLayout) && this.B == 1) {
                    LitePopupContentFrameLayout litePopupContentFrameLayout = (LitePopupContentFrameLayout) childAt2;
                    if (this.f12554q) {
                        litePopupContentFrameLayout.setLimitHeight(getPaddingTop() + (this.f12557u - measuredHeight));
                    }
                }
                childAt2.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin + ((ViewGroup.MarginLayoutParams) cVar2).rightMargin, ((ViewGroup.MarginLayoutParams) cVar2).width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) cVar2).topMargin + ((ViewGroup.MarginLayoutParams) cVar2).bottomMargin + measuredHeight, i13));
                measuredHeight = childAt2.getMeasuredHeight() + measuredHeight;
            }
        }
        int iMin2 = this.f12556t;
        if (getResources().getConfiguration().orientation == 2 && (iRound = Math.round(((iMin - getPaddingTop()) - getPaddingBottom()) * U)) > 0) {
            iMin2 = Math.min(iMin2, iRound);
        }
        this.f12557u = Math.min(iMin2, (measuredHeight - getPaddingTop()) - getPaddingBottom());
        this.f12558v = Math.max(0, ((measuredHeight - getPaddingBottom()) - getPaddingTop()) - this.f12557u);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f8, float f9) throws Settings.SettingNotFoundException {
        boolean z = this.f12555s <= this.f12558v || m();
        if (z) {
            boolean zCanScrollVertically = view.canScrollVertically(-1);
            if (f9 < 0.0f && zCanScrollVertically && this.r == 0) {
                return false;
            }
            if (Math.abs(f9) > this.f12542a) {
                int iE = e(-f9, this.r);
                this.f12553p = iE;
                if (this.r != iE) {
                    q(iE);
                } else {
                    z = !zCanScrollVertically;
                }
            }
            if (view instanceof StepOSRecyclerView) {
                ((StepOSRecyclerView) view).setOverScrollEnable(false);
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        j(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        return p(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) throws Settings.SettingNotFoundException {
        h(0, view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r1 != 3) goto L11;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) throws android.provider.Settings.SettingNotFoundException {
        /*
            r5 = this;
            android.view.VelocityTracker r0 = r5.f12543b
            r0.addMovement(r6)
            int r1 = r6.getAction()
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L14
            r6 = 3
            if (r1 == r6) goto L2b
            goto L2a
        L14:
            boolean r0 = r5.I
            if (r0 == 0) goto L2a
            float r0 = r6.getY()
            float r1 = r5.H
            float r0 = r0 - r1
            float r6 = r6.getY()
            r5.H = r6
            float r6 = -r0
            int r6 = (int) r6
            r5.n(r6, r2)
        L2a:
            return r4
        L2b:
            boolean r6 = r5.I
            if (r6 == 0) goto L56
            r6 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r6)
            float r6 = r0.getYVelocity()
            float r1 = java.lang.Math.abs(r6)
            float r2 = r5.f12542a
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L4c
            int r1 = r5.r
            int r6 = r5.e(r6, r1)
            r5.q(r6)
            goto L7a
        L4c:
            int r6 = r5.r
            int r6 = r5.f(r6)
            r5.q(r6)
            goto L7a
        L56:
            boolean r6 = r5.C
            if (r6 == 0) goto L6b
            android.content.res.Resources r6 = r5.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            if (r6 == r3) goto L6a
            int r6 = r5.r
            if (r6 != r4) goto L6b
        L6a:
            r2 = r4
        L6b:
            stepos.support.v7.app.q r6 = r5.f12560x
            if (r6 == 0) goto L7a
            if (r2 == 0) goto L7a
            stepos.support.v7.app.s$a r6 = (stepos.support.v7.app.s.a) r6
            stepos.support.v7.app.s r6 = stepos.support.v7.app.s.this
            stepos.support.v7.app.r r6 = r6.f12264d
            r6.finish()
        L7a:
            r5.b()
            r0.clear()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // v0.o
    public final boolean p(View view, View view2, int i10, int i11) {
        if (view2 instanceof StepOSRecyclerView) {
            ((StepOSRecyclerView) view2).setOverScrollEnable(true);
        }
        this.f12553p = -1;
        return (i10 & 2) != 0;
    }

    public final void q(int i10) throws Settings.SettingNotFoundException {
        setSpringForce(i10);
        this.r = i10;
        if (i10 == 0) {
            r(this.f12558v);
            return;
        }
        if (i10 == 1) {
            r(0);
            return;
        }
        if (i10 != 2) {
            return;
        }
        this.f12546e.f();
        stepos.support.v7.app.q qVar = this.f12560x;
        if (qVar != null) {
            stepos.support.v7.app.s.this.f12264d.finish();
        }
    }

    public final void r(int i10) throws Settings.SettingNotFoundException {
        float f8;
        if (this.f12555s == i10) {
            return;
        }
        h1.f fVar = this.f12546e;
        fVar.f();
        fVar.f9228b = this.f12555s;
        fVar.f9229c = true;
        fVar.f9241t.f9251i = i10;
        try {
            f8 = Settings.Global.getFloat(getContext().getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f8 = 1.0f;
        }
        if (f8 != 0.0f) {
            fVar.h();
        } else {
            post(new b(i10));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int s(int r6, int r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L43
            int r0 = r5.f12549l
            if (r0 == 0) goto L43
            int r1 = r5.r
            r2 = 1
            if (r1 != r2) goto Lf
            int r3 = r7 * r6
            if (r3 > 0) goto L15
        Lf:
            if (r1 != 0) goto L41
            int r1 = r7 * r6
            if (r1 <= 0) goto L41
        L15:
            int r1 = java.lang.Math.abs(r7)
            float r1 = (float) r1
            r3 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 * r3
            float r4 = (float) r0
            float r1 = r1 / r4
            android.view.animation.PathInterpolator r5 = r5.f12545d
            float r5 = r5.getInterpolation(r1)
            float r3 = r3 - r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L2c
            r3 = r5
        L2c:
            float r5 = (float) r6
            float r5 = r5 * r3
            int r5 = (int) r5
            if (r6 <= 0) goto L34
            if (r5 != 0) goto L37
            goto L38
        L34:
            if (r5 != 0) goto L37
            r5 = -1
        L37:
            r2 = r5
        L38:
            int r5 = java.lang.Math.abs(r7)
            if (r5 < r0) goto L40
            r5 = 0
            return r5
        L40:
            return r2
        L41:
            int r6 = r6 / 2
        L43:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.s(int, int):int");
    }

    public void setDismissedOnTouchOutside(boolean z) {
        this.C = z;
    }

    public void setMaxHeight(int i10) {
        this.f12559w = i10;
    }

    public void setOnDismissedListener(stepos.support.v7.app.q qVar) {
        this.f12560x = qVar;
    }

    public void setScrollPopupFirstOnTop(boolean z) {
        this.D = z;
    }

    public void setScrollToDismissEnabled(boolean z) {
        this.z = z;
    }

    public void setStyle(int i10) {
        this.B = i10;
    }

    public void setUncollapsibleHeight(int i10) {
        this.f12556t = i10;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof c) {
            c cVar = (c) layoutParams;
            c cVar2 = new c(cVar);
            cVar2.f12565a = cVar.f12565a;
            cVar2.f12566b = cVar.f12566b;
            cVar2.f12567c = cVar.f12567c;
            return cVar2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    public void setScrollListener(d dVar) {
    }

    @Override // v0.o
    public final void i(View view, View view2, int i10, int i11) {
    }

    @Override // v0.o
    public final void l(View view, int i10, int i11, int i12, int i13, int i14) {
    }
}
