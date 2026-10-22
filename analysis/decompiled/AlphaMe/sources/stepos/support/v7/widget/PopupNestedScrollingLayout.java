package stepos.support.v7.widget;

import K.InterfaceC0087t;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;

/* loaded from: classes2.dex */
public class PopupNestedScrollingLayout extends ViewGroup implements InterfaceC0087t {

    /* renamed from: I, reason: collision with root package name */
    public static final Interpolator f14855I = M.a.b(0.2f, 0.03f, Property.DEFAULT_FLOAT_VALUE, 1.0f);

    /* renamed from: J, reason: collision with root package name */
    public static final float f14856J = 0.88f;

    /* renamed from: K, reason: collision with root package name */
    public static final float f14857K = 340.0f;

    /* renamed from: L, reason: collision with root package name */
    public static final float f14858L = 0.93f;

    /* renamed from: M, reason: collision with root package name */
    public static final float f14859M = 400.0f;

    /* renamed from: N, reason: collision with root package name */
    public static final float f14860N = 0.98f;

    /* renamed from: O, reason: collision with root package name */
    public static final float f14861O = 300.0f;

    /* renamed from: A, reason: collision with root package name */
    public boolean f14862A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f14863B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f14864C;

    /* renamed from: D, reason: collision with root package name */
    public float f14865D;

    /* renamed from: E, reason: collision with root package name */
    public float f14866E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f14867F;

    /* renamed from: G, reason: collision with root package name */
    public View f14868G;

    /* renamed from: H, reason: collision with root package name */
    public int f14869H;

    /* renamed from: a, reason: collision with root package name */
    public final float f14870a;

    /* renamed from: b, reason: collision with root package name */
    public final VelocityTracker f14871b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14872c;

    /* renamed from: d, reason: collision with root package name */
    public final Interpolator f14873d;

    /* renamed from: e, reason: collision with root package name */
    public final W.m f14874e;

    /* renamed from: f, reason: collision with root package name */
    public final float f14875f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14876g;

    /* renamed from: h, reason: collision with root package name */
    public final int f14877h;

    /* renamed from: i, reason: collision with root package name */
    public final int f14878i;

    /* renamed from: j, reason: collision with root package name */
    public final int f14879j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14880k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14881l;

    /* renamed from: m, reason: collision with root package name */
    public int f14882m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f14883n;

    /* renamed from: o, reason: collision with root package name */
    public int f14884o;

    /* renamed from: p, reason: collision with root package name */
    public int f14885p;

    /* renamed from: q, reason: collision with root package name */
    public int f14886q;

    /* renamed from: r, reason: collision with root package name */
    public int f14887r;

    /* renamed from: s, reason: collision with root package name */
    public int f14888s;

    /* renamed from: t, reason: collision with root package name */
    public int f14889t;

    /* renamed from: u, reason: collision with root package name */
    public stepos.support.v7.app.B f14890u;

    /* renamed from: v, reason: collision with root package name */
    public final J3.a f14891v;

    /* renamed from: w, reason: collision with root package name */
    public N f14892w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f14893x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f14894y;

    /* renamed from: z, reason: collision with root package name */
    public int f14895z;

    public PopupNestedScrollingLayout(Context context, @Nullable AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        this.f14873d = M.a.b(0.12f, Property.DEFAULT_FLOAT_VALUE, 0.33f, 1.0f);
        this.f14880k = false;
        this.f14883n = true;
        this.f14884o = 1;
        this.f14885p = 0;
        this.f14891v = new J3.a(2, this);
        this.f14893x = true;
        this.f14895z = 0;
        this.f14862A = true;
        this.f14863B = false;
        this.f14864C = false;
        this.f14869H = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I3.a.f843c, 0, 0);
        this.f14889t = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f14872c = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_padding_top));
        typedArrayObtainStyledAttributes.recycle();
        new OverScroller(context, f14855I);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f14870a = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f14875f = getResources().getDimensionPixelSize(R.dimen.stepos_config_popup_nested_scroll_abandon_velocity);
        getResources().getDimensionPixelSize(R.dimen.stepos_config_popup_nested_fling_down_velocity);
        this.f14871b = VelocityTracker.obtain();
        setClipToPadding(false);
        this.f14877h = viewConfiguration.getScaledTouchSlop();
        this.f14878i = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_over_scroll_distance);
        this.f14879j = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_dismiss_triggered_distance);
        this.f14876g = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_scroll_down_threshold);
        this.f14886q = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_middle_state_height);
        W.m mVar = new W.m(new W.l());
        this.f14874e = mVar;
        mVar.b(new com.stepos.common.animator.f(2, this));
    }

    public static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            view.getScrollX();
            view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (a(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
        }
        return view.canScrollVertically(-1) || view.canScrollVertically(1);
    }

    private void setSpringForce(int i4) {
        int i5 = this.f14884o;
        W.m mVar = this.f14874e;
        if (i5 == i4) {
            W.n nVar = new W.n();
            nVar.a(f14860N);
            nVar.b(f14861O);
            mVar.f1974m = nVar;
            return;
        }
        if (i4 == 0 || i4 == 1) {
            W.n nVar2 = new W.n();
            nVar2.a(f14856J);
            nVar2.b(f14857K);
            mVar.f1974m = nVar2;
            return;
        }
        if (i4 != 2) {
            return;
        }
        W.n nVar3 = new W.n();
        nVar3.a(f14858L);
        nVar3.b(f14859M);
        mVar.f1974m = nVar3;
    }

    public final void b() {
        if (this.f14890u == null || this.f14893x || !f()) {
            return;
        }
        if (!this.f14864C && post(this.f14891v)) {
            this.f14864C = true;
        }
        if (this.f14864C) {
            return;
        }
        stepos.support.v7.app.B b4 = this.f14890u;
        if (b4 != null) {
            ((stepos.support.v7.app.E) b4).f14266a.f14273d.performDragTriggered();
        }
        this.f14880k = true;
    }

    public final int c(float f4, int i4) {
        boolean z4 = this.f14893x;
        if ((!z4 && this.f14895z != 0) || this.f14881l) {
            return i4;
        }
        int i5 = this.f14885p;
        if (i5 < (-this.f14887r) || i5 >= 0) {
            int i6 = this.f14895z;
            return i6 == 2 ? f4 > Property.DEFAULT_FLOAT_VALUE ? 2 : 0 : (f4 >= Property.DEFAULT_FLOAT_VALUE || i6 != 0) ? 1 : 0;
        }
        if (this.f14895z == 1) {
            return f4 > Property.DEFAULT_FLOAT_VALUE ? 2 : 1;
        }
        if (f4 < Property.DEFAULT_FLOAT_VALUE || !z4) {
            return (f4 >= (-this.f14875f) || i4 != 0) ? 1 : 0;
        }
        return 2;
    }

    @Override // K.InterfaceC0086s
    public final void d(View view, View view2, int i4, int i5) {
    }

    public final int e(int i4) {
        if (!this.f14893x && this.f14895z != 0) {
            return i4;
        }
        int i5 = this.f14885p - (i4 == 0 ? this.f14888s : i4 == 1 ? 0 : -this.f14887r);
        int iAbs = Math.abs(i5);
        int i6 = this.f14876g;
        if (i5 > 0) {
            if (i4 == 2) {
                if (iAbs > this.f14887r + i6) {
                    return 0;
                }
                return iAbs > i6 ? 1 : 2;
            }
            if (i4 == 1) {
                return (iAbs <= i6 || this.f14895z != 0) ? 1 : 0;
            }
            return 0;
        }
        if (i4 != 0) {
            if (i4 == 1) {
                return (iAbs <= i6 || !this.f14893x || this.f14881l) ? 1 : 2;
            }
            return 2;
        }
        if (this.f14895z == 2) {
            return (iAbs <= i6 || !this.f14893x) ? 0 : 2;
        }
        if (iAbs <= this.f14888s + i6 || !this.f14893x || this.f14881l) {
            return iAbs > i6 ? 1 : 0;
        }
        return 2;
    }

    public final boolean f() {
        int i4 = this.f14895z;
        int i5 = this.f14877h;
        int i6 = this.f14879j;
        return (i4 == 1 || this.f14884o == 1) ? this.f14885p <= (-(i6 - i5)) && !this.f14880k : i4 == 2 && Math.abs(this.f14885p - this.f14888s) >= i6 - i5 && !this.f14880k;
    }

    public final int g(int i4, boolean z4) {
        int i5 = this.f14885p;
        int i6 = i5 + i4;
        int i7 = this.f14888s;
        if (i6 > i7) {
            i4 = i7 - i5;
        }
        if (!this.f14893x) {
            int i8 = this.f14895z;
            if (i8 == 1 && (i4 < 0 || !z4)) {
                i4 = l(i4, i5);
            } else if (i8 == 2 && (i4 < 0 || !z4)) {
                i4 = l(i4, i5 - i7);
            } else if (this.f14884o == 1 && i4 < 0) {
                i4 = l(i4, i5);
            }
        } else if (this.f14881l && i4 < 0 && i5 <= 0) {
            i4 = l(i4, i5);
        } else if (this.f14895z == 1 && i4 > 0 && !z4) {
            i4 = l(i4, i5);
        }
        this.f14874e.c();
        h(i4);
        return i4;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new M(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        M m4 = new M(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I3.a.f844d);
        m4.f14835a = typedArrayObtainStyledAttributes.getBoolean(0, false);
        m4.f14836b = typedArrayObtainStyledAttributes.getBoolean(1, false);
        m4.f14837c = typedArrayObtainStyledAttributes.getBoolean(2, false);
        typedArrayObtainStyledAttributes.recycle();
        return m4;
    }

    public int getCurrentScrollY() {
        return this.f14885p;
    }

    public int getPositionState() {
        return this.f14884o;
    }

    public int getUncollapsibleHeight() {
        return this.f14887r;
    }

    public final void h(int i4) {
        int i5 = -i4;
        int i6 = this.f14885p;
        int i7 = (-i5) + i6 >= 0 ? -this.f14869H : (i6 <= 0 || i5 <= 0) ? i5 : i5 - i6;
        this.f14869H += i7;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (((M) childAt.getLayoutParams()).f14835a) {
                childAt.offsetTopAndBottom(i7);
            } else {
                childAt.offsetTopAndBottom(i5);
            }
        }
        this.f14885p += i4;
        N n4 = this.f14892w;
        if (n4 != null) {
            ((stepos.support.v7.app.E) n4).f14266a.getClass();
        }
        int i9 = this.f14885p;
        if (i9 >= 0 || this.f14890u == null) {
            return;
        }
        float fAbs = Math.abs(i9);
        float f4 = fAbs / this.f14887r;
        stepos.support.v7.app.G g4 = ((stepos.support.v7.app.E) this.f14890u).f14266a;
        int i10 = (int) ((1.0f - f4) * g4.f14271b);
        g4.f14270a.setAlpha(i10);
        g4.f14276g = i10;
        g4.f14273d.performDismissProgress(f4);
    }

    @Override // K.InterfaceC0086s
    public final void i(View view, int i4, int i5, int[] iArr, int i6) {
        boolean z4 = false;
        boolean z5 = i5 > 0 && (((!this.f14863B ? this.f14885p < this.f14888s : this.f14885p <= this.f14888s) && this.f14895z != 1) || (this.f14885p < 0 && this.f14895z == 1));
        if (i5 < 0 && !view.canScrollVertically(-1)) {
            z4 = true;
        }
        if (z5 || (z4 && !this.f14881l)) {
            iArr[1] = g(i5, true);
        } else if (i5 != 0) {
            this.f14881l = true;
        }
    }

    public final void j(int i4) throws Settings.SettingNotFoundException {
        setSpringForce(i4);
        this.f14884o = i4;
        if (i4 == 0) {
            k(this.f14888s);
            return;
        }
        if (i4 == 1) {
            k(0);
            return;
        }
        if (i4 != 2) {
            return;
        }
        this.f14874e.c();
        stepos.support.v7.app.B b4 = this.f14890u;
        if (b4 != null) {
            stepos.support.v7.app.G g4 = ((stepos.support.v7.app.E) b4).f14266a;
            g4.f14273d.performDismissed();
            g4.f14273d.finish(false);
        }
    }

    public final void k(int i4) throws Settings.SettingNotFoundException {
        float f4;
        if (this.f14885p == i4) {
            return;
        }
        W.m mVar = this.f14874e;
        mVar.c();
        mVar.g(this.f14885p);
        mVar.f1974m.f1985i = i4;
        try {
            f4 = Settings.Global.getFloat(getContext().getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f4 = 1.0f;
        }
        if (f4 != Property.DEFAULT_FLOAT_VALUE) {
            mVar.i();
        } else {
            post(new A0.e(i4, 2, this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(int r6, int r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L45
            int r0 = r5.f14878i
            if (r0 == 0) goto L45
            int r1 = r5.f14884o
            r2 = 1
            if (r1 != r2) goto Lf
            int r3 = r7 * r6
            if (r3 > 0) goto L15
        Lf:
            if (r1 != 0) goto L43
            int r1 = r7 * r6
            if (r1 <= 0) goto L43
        L15:
            int r1 = java.lang.Math.abs(r7)
            float r1 = (float) r1
            r3 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 * r3
            float r4 = (float) r0
            float r1 = r1 / r4
            android.view.animation.Interpolator r5 = r5.f14873d
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
            if (r5 < r0) goto L41
            r5 = 0
            r6 = r5
            goto L45
        L41:
            r6 = r2
            goto L45
        L43:
            int r6 = r6 / 2
        L45:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.l(int, int):int");
    }

    @Override // K.InterfaceC0086s
    public final void n(int i4, View view) throws Settings.SettingNotFoundException {
        if (this.f14874e.f1967f) {
            return;
        }
        int iE = e(this.f14884o);
        int i5 = this.f14882m;
        if (i5 != -1 && i5 != 2) {
            iE = i5;
        }
        j(iE);
        b();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Configuration configuration = getResources().getConfiguration();
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        setPadding(getPaddingLeft(), configuration.orientation == 1 ? this.f14872c + systemWindowInsetTop : systemWindowInsetTop, getPaddingRight(), getPaddingBottom());
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
            this.f14894y = false;
            this.f14880k = false;
            this.f14864C = false;
            this.f14881l = false;
            this.f14882m = -1;
            this.f14865D = motionEvent.getY();
            this.f14866E = motionEvent.getY();
            float x4 = motionEvent.getX();
            float f4 = this.f14865D;
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    childAt = null;
                    break;
                }
                childAt = getChildAt(childCount);
                float x5 = childAt.getX();
                float y4 = childAt.getY();
                float width = childAt.getWidth() + x5;
                float height = childAt.getHeight() + y4;
                if (x4 >= x5 && f4 >= y4 && x4 < width && f4 < height) {
                    break;
                }
                childCount--;
            }
            this.f14868G = childAt;
            this.f14867F = childAt != null;
        } else if (actionMasked == 2) {
            float y5 = motionEvent.getY() - this.f14865D;
            if (!this.f14894y && (view = this.f14868G) != null && !a(view) && Math.abs(y5) > this.f14877h) {
                this.f14894y = true;
            }
            this.f14866E = motionEvent.getY();
        }
        return this.f14894y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int width = getWidth();
        int measuredHeight = (getMeasuredHeight() - this.f14887r) - this.f14885p;
        int paddingLeft = getPaddingLeft();
        int paddingRight = width - getPaddingRight();
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            M m4 = (M) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !m4.f14835a) {
                int i9 = measuredHeight + ((ViewGroup.MarginLayoutParams) m4).topMargin;
                int measuredHeight2 = childAt.getMeasuredHeight() + i9;
                int measuredWidth = childAt.getMeasuredWidth();
                int i10 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft;
                childAt.layout(i10, i9, measuredWidth + i10, measuredHeight2);
                measuredHeight = measuredHeight2 + ((ViewGroup.MarginLayoutParams) m4).bottomMargin;
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            M m5 = (M) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && m5.f14835a) {
                int height = (((getHeight() - childAt2.getMeasuredHeight()) - (m5.f14836b ? 0 : getPaddingBottom())) - ((ViewGroup.MarginLayoutParams) m5).bottomMargin) + this.f14869H;
                int measuredHeight3 = childAt2.getMeasuredHeight() + height;
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int i12 = (((paddingRight - paddingLeft) - measuredWidth2) / 2) + paddingLeft;
                childAt2.layout(i12, height, measuredWidth2 + i12, measuredHeight3);
            }
        }
        if (this.f14895z == 2 && this.f14884o != 2 && z4) {
            this.f14884o = 0;
            h(this.f14888s - this.f14885p);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        if (this.f14889t < size2) {
            this.f14889t = size2;
        }
        int iMin = Math.min(size2, this.f14889t);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int measuredHeight = paddingTop;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            M m4 = (M) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !m4.f14837c) {
                measureChildWithMargins(childAt, iMakeMeasureSpec, 0, iMakeMeasureSpec2, measuredHeight);
                if (!m4.f14836b) {
                    measuredHeight = childAt.getMeasuredHeight() + measuredHeight;
                }
            }
        }
        int i7 = iMin - measuredHeight;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt2 = getChildAt(i8);
            M m5 = (M) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && m5.f14837c) {
                if ((childAt2 instanceof LitePopupContentFrameLayout) && this.f14895z == 1) {
                    LitePopupContentFrameLayout litePopupContentFrameLayout = (LitePopupContentFrameLayout) childAt2;
                    if (this.f14883n) {
                        litePopupContentFrameLayout.setLimitHeight(getPaddingTop() + (this.f14887r - measuredHeight));
                    }
                }
                childAt2.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) m5).leftMargin + ((ViewGroup.MarginLayoutParams) m5).rightMargin, ((ViewGroup.MarginLayoutParams) m5).width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) m5).topMargin + ((ViewGroup.MarginLayoutParams) m5).bottomMargin + measuredHeight, i7));
                measuredHeight = childAt2.getMeasuredHeight() + measuredHeight;
            }
        }
        this.f14887r = Math.min(this.f14886q, (measuredHeight - getPaddingTop()) - getPaddingBottom());
        this.f14888s = Math.max(0, ((measuredHeight - getPaddingBottom()) - getPaddingTop()) - this.f14887r);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) throws Settings.SettingNotFoundException {
        boolean z4 = this.f14885p <= this.f14888s || f();
        if (z4) {
            boolean zCanScrollVertically = view.canScrollVertically(-1);
            if (f5 < Property.DEFAULT_FLOAT_VALUE && zCanScrollVertically && this.f14884o == 0) {
                return false;
            }
            if (Math.abs(f5) > this.f14870a) {
                int iC = c(-f5, this.f14884o);
                this.f14882m = iC;
                if (this.f14884o != iC) {
                    j(iC);
                } else {
                    z4 = !zCanScrollVertically;
                }
            }
            if (view instanceof StepOSRecyclerView) {
                ((StepOSRecyclerView) view).setOverScrollEnable(false);
            }
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        i(view, i4, i5, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        return r(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) throws Settings.SettingNotFoundException {
        n(0, view);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) throws android.provider.Settings.SettingNotFoundException {
        /*
            r5 = this;
            android.view.VelocityTracker r0 = r5.f14871b
            r0.addMovement(r6)
            int r1 = r6.getAction()
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L2c
            if (r1 == r3) goto L15
            r6 = 3
            if (r1 == r6) goto L2c
            goto L86
        L15:
            boolean r0 = r5.f14867F
            if (r0 == 0) goto L86
            float r0 = r6.getY()
            float r1 = r5.f14866E
            float r0 = r0 - r1
            float r6 = r6.getY()
            r5.f14866E = r6
            float r6 = -r0
            int r6 = (int) r6
            r5.g(r6, r2)
            goto L86
        L2c:
            boolean r6 = r5.f14867F
            if (r6 == 0) goto L57
            r6 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r6)
            float r6 = r0.getYVelocity()
            float r1 = java.lang.Math.abs(r6)
            float r2 = r5.f14870a
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L4d
            int r1 = r5.f14884o
            int r6 = r5.c(r6, r1)
            r5.j(r6)
            goto L80
        L4d:
            int r6 = r5.f14884o
            int r6 = r5.e(r6)
            r5.j(r6)
            goto L80
        L57:
            boolean r6 = r5.f14862A
            if (r6 == 0) goto L6c
            android.content.res.Resources r6 = r5.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            if (r6 == r3) goto L6b
            int r6 = r5.f14884o
            if (r6 != r4) goto L6c
        L6b:
            r2 = r4
        L6c:
            stepos.support.v7.app.B r6 = r5.f14890u
            if (r6 == 0) goto L80
            if (r2 == 0) goto L80
            stepos.support.v7.app.E r6 = (stepos.support.v7.app.E) r6
            stepos.support.v7.app.G r6 = r6.f14266a
            stepos.support.v7.app.D r1 = r6.f14273d
            r1.performDismissed()
            stepos.support.v7.app.D r6 = r6.f14273d
            r6.finish(r4)
        L80:
            r5.b()
            r0.clear()
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // K.InterfaceC0087t
    public final void p(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        if (i7 >= 0 || view.canScrollVertically(-1) || this.f14881l) {
            return;
        }
        iArr[1] = g(i7, true);
    }

    @Override // K.InterfaceC0086s
    public final void q(View view, int i4, int i5, int i6, int i7, int i8) {
    }

    @Override // K.InterfaceC0086s
    public final boolean r(View view, View view2, int i4, int i5) {
        if (view2 instanceof StepOSRecyclerView) {
            ((StepOSRecyclerView) view2).setOverScrollEnable(true);
        }
        this.f14882m = -1;
        return (i4 & 2) != 0;
    }

    public void setDismissedOnTouchOutside(boolean z4) {
        this.f14862A = z4;
    }

    public void setMaxHeight(int i4) {
        this.f14889t = i4;
    }

    public void setOnDismissedListener(stepos.support.v7.app.B b4) {
        this.f14890u = b4;
    }

    public void setScrollListener(N n4) {
        this.f14892w = n4;
    }

    public void setScrollPopupFirstOnTop(boolean z4) {
        this.f14863B = z4;
    }

    public void setScrollToDismissEnabled(boolean z4) {
        this.f14893x = z4;
    }

    public void setStyle(int i4) {
        this.f14895z = i4;
    }

    public void setUncollapsibleHeight(int i4) {
        this.f14886q = i4;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof M) {
            M m4 = (M) layoutParams;
            M m5 = new M(m4);
            m5.f14835a = m4.f14835a;
            m5.f14836b = m4.f14836b;
            m5.f14837c = m4.f14837c;
            return m5;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new M((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new M(layoutParams);
    }
}
