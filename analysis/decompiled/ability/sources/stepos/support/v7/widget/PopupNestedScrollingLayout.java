package stepos.support.v7.widget;

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
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.datepicker.RunnableC0913p;
import com.stepos.ability.R;

/* loaded from: classes4.dex */
public class PopupNestedScrollingLayout extends ViewGroup implements NestedScrollingParent3 {

    /* renamed from: L, reason: collision with root package name */
    public static final Interpolator f6477L = PathInterpolatorCompat.create(0.2f, 0.03f, 0.0f, 1.0f);

    /* renamed from: M, reason: collision with root package name */
    public static final float f6478M = 0.88f;

    /* renamed from: N, reason: collision with root package name */
    public static final float f6479N = 340.0f;

    /* renamed from: O, reason: collision with root package name */
    public static final float f6480O = 0.93f;

    /* renamed from: P, reason: collision with root package name */
    public static final float f6481P = 400.0f;

    /* renamed from: Q, reason: collision with root package name */
    public static final float f6482Q = 0.98f;

    /* renamed from: R, reason: collision with root package name */
    public static final float f6483R = 300.0f;

    /* renamed from: A, reason: collision with root package name */
    public boolean f6484A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f6485B;

    /* renamed from: C, reason: collision with root package name */
    public float f6486C;

    /* renamed from: D, reason: collision with root package name */
    public float f6487D;
    public boolean E;

    /* renamed from: F, reason: collision with root package name */
    public View f6488F;

    /* renamed from: G, reason: collision with root package name */
    public int f6489G;

    /* renamed from: a, reason: collision with root package name */
    public final float f6490a;
    public final VelocityTracker b;
    public final int c;
    public final Interpolator d;
    public final SpringAnimation e;
    public final float f;
    public final int g;
    public final int h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final int f6491j;
    public boolean k;
    public boolean l;
    public int m;
    public final boolean n;
    public int o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f6492q;

    /* renamed from: r, reason: collision with root package name */
    public int f6493r;

    /* renamed from: s, reason: collision with root package name */
    public int f6494s;

    /* renamed from: t, reason: collision with root package name */
    public int f6495t;
    public stepos.support.v7.app.C u;

    /* renamed from: v, reason: collision with root package name */
    public final RunnableC1986e0 f6496v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6497w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6498x;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f6499z;

    public PopupNestedScrollingLayout(Context context, @Nullable AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        this.d = PathInterpolatorCompat.create(0.12f, 0.0f, 0.33f, 1.0f);
        this.k = false;
        this.n = true;
        this.o = 1;
        this.p = 0;
        this.f6496v = new RunnableC1986e0(this, 1);
        this.f6497w = true;
        this.y = 0;
        this.f6499z = true;
        this.f6484A = false;
        this.f6485B = false;
        this.f6489G = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Ra.a.c, 0, 0);
        this.f6495t = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_padding_top));
        typedArrayObtainStyledAttributes.recycle();
        new OverScroller(context, f6477L);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6490a = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f = getResources().getDimensionPixelSize(R.dimen.stepos_config_popup_nested_scroll_abandon_velocity);
        getResources().getDimensionPixelSize(R.dimen.stepos_config_popup_nested_fling_down_velocity);
        this.b = VelocityTracker.obtain();
        setClipToPadding(false);
        this.h = viewConfiguration.getScaledTouchSlop();
        this.i = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_over_scroll_distance);
        this.f6491j = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_dismiss_triggered_distance);
        this.g = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_scroll_down_threshold);
        this.f6492q = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_middle_state_height);
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        this.e = springAnimation;
        springAnimation.addUpdateListener(new S(this));
    }

    public static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            view.getScrollX();
            view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (a(viewGroup.getChildAt(childCount))) {
                    break;
                }
            }
            if (!view.canScrollVertically(-1) || view.canScrollVertically(1)) {
                break;
            }
            return false;
        }
        if (view.canScrollVertically(-1)) {
        }
        return true;
    }

    private void setSpringForce(int i) {
        int i6 = this.o;
        SpringAnimation springAnimation = this.e;
        if (i6 == i) {
            springAnimation.setSpring(new SpringForce().setDampingRatio(f6482Q).setStiffness(f6483R));
            return;
        }
        if (i == 0 || i == 1) {
            springAnimation.setSpring(new SpringForce().setDampingRatio(f6478M).setStiffness(f6479N));
        } else {
            if (i != 2) {
                return;
            }
            springAnimation.setSpring(new SpringForce().setDampingRatio(f6480O).setStiffness(f6481P));
        }
    }

    public final void b() {
        if (this.u == null || this.f6497w || !e()) {
            return;
        }
        if (!this.f6485B && post(this.f6496v)) {
            this.f6485B = true;
        }
        if (this.f6485B) {
            return;
        }
        this.k = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(float r7, int r8) {
        /*
            r6 = this;
            boolean r0 = r6.f6497w
            if (r0 != 0) goto L9
            int r1 = r6.y
            if (r1 == 0) goto L9
            goto Ld
        L9:
            boolean r1 = r6.l
            if (r1 == 0) goto Le
        Ld:
            return r8
        Le:
            int r1 = r6.p
            int r2 = r6.f6493r
            int r2 = -r2
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 < r2) goto L33
            if (r1 >= 0) goto L33
            int r1 = r6.y
            if (r1 != r5) goto L23
            int r6 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r6 <= 0) goto L44
            goto L3b
        L23:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 < 0) goto L29
            if (r0 != 0) goto L3b
        L29:
            float r6 = r6.f
            float r6 = -r6
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 >= 0) goto L44
            if (r8 != 0) goto L44
            goto L42
        L33:
            int r6 = r6.y
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.c(float, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0064 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(int r7) {
        /*
            r6 = this;
            boolean r0 = r6.f6497w
            if (r0 != 0) goto L9
            int r0 = r6.y
            if (r0 == 0) goto L9
            return r7
        L9:
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L10
            int r2 = r6.f6494s
            goto L17
        L10:
            if (r7 != r1) goto L14
            r2 = r0
            goto L17
        L14:
            int r2 = r6.f6493r
            int r2 = -r2
        L17:
            int r3 = r6.p
            int r3 = r3 - r2
            int r2 = java.lang.Math.abs(r3)
            int r4 = r6.g
            r5 = 2
            if (r3 <= 0) goto L37
            if (r7 != r5) goto L2e
            int r6 = r6.f6493r
            int r6 = r6 + r4
            if (r2 <= r6) goto L2b
            goto L55
        L2b:
            if (r2 <= r4) goto L64
            goto L63
        L2e:
            if (r7 != r1) goto L55
            if (r2 <= r4) goto L63
            int r6 = r6.y
            if (r6 != 0) goto L63
            goto L55
        L37:
            if (r7 != 0) goto L56
            int r7 = r6.y
            if (r7 != r5) goto L44
            if (r2 <= r4) goto L55
            boolean r6 = r6.f6497w
            if (r6 == 0) goto L55
            goto L64
        L44:
            int r7 = r6.f6494s
            int r7 = r7 + r4
            if (r2 <= r7) goto L52
            boolean r7 = r6.f6497w
            if (r7 == 0) goto L52
            boolean r6 = r6.l
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
            boolean r7 = r6.f6497w
            if (r7 == 0) goto L63
            boolean r6 = r6.l
            if (r6 != 0) goto L63
            goto L64
        L63:
            return r1
        L64:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.d(int):int");
    }

    public final boolean e() {
        int i = this.y;
        int i6 = this.h;
        int i10 = this.f6491j;
        if (i == 1 || this.o == 1) {
            if (this.p > (-(i10 - i6)) || this.k) {
                return false;
            }
        } else if (i != 2 || Math.abs(this.p - this.f6494s) < i10 - i6 || this.k) {
            return false;
        }
        return true;
    }

    public final int f(int i, boolean z10) {
        int i6 = this.p;
        int i10 = i6 + i;
        int i11 = this.f6494s;
        if (i10 > i11) {
            i = i11 - i6;
        }
        if (!this.f6497w) {
            int i12 = this.y;
            if (i12 == 1 && (i < 0 || !z10)) {
                i = j(i, i6);
            } else if (i12 == 2 && (i < 0 || !z10)) {
                i = j(i, i6 - i11);
            } else if (this.o == 1 && i < 0) {
                i = j(i, i6);
            }
        } else if (this.l && i < 0 && i6 <= 0) {
            i = j(i, i6);
        } else if (this.y == 1 && i > 0 && !z10) {
            i = j(i, i6);
        }
        this.e.cancel();
        g(i);
        return i;
    }

    public final void g(int i) {
        int i6 = -i;
        int i10 = this.p;
        int i11 = (-i6) + i10 >= 0 ? -this.f6489G : (i10 <= 0 || i6 <= 0) ? i6 : i6 - i10;
        this.f6489G += i11;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((T) childAt.getLayoutParams()).f6559a) {
                childAt.offsetTopAndBottom(i11);
            } else {
                childAt.offsetTopAndBottom(i6);
            }
        }
        int i13 = this.p + i;
        this.p = i13;
        if (i13 >= 0 || this.u == null) {
            return;
        }
        float fAbs = Math.abs(i13);
        float f = fAbs / this.f6493r;
        stepos.support.v7.app.F f7 = (stepos.support.v7.app.F) ((Q.a) this.u).b;
        int i14 = (int) ((1.0f - f) * f7.b);
        f7.f6216a.setAlpha(i14);
        f7.e = i14;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new T(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        T t9 = new T(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Ra.a.d);
        t9.f6559a = typedArrayObtainStyledAttributes.getBoolean(0, false);
        t9.b = typedArrayObtainStyledAttributes.getBoolean(1, false);
        t9.c = typedArrayObtainStyledAttributes.getBoolean(2, false);
        typedArrayObtainStyledAttributes.recycle();
        return t9;
    }

    public int getCurrentScrollY() {
        return this.p;
    }

    public int getPositionState() {
        return this.o;
    }

    public int getUncollapsibleHeight() {
        return this.f6493r;
    }

    public final void h(int i) throws Settings.SettingNotFoundException {
        setSpringForce(i);
        this.o = i;
        if (i == 0) {
            i(this.f6494s);
            return;
        }
        if (i == 1) {
            i(0);
            return;
        }
        if (i != 2) {
            return;
        }
        this.e.cancel();
        stepos.support.v7.app.C c = this.u;
        if (c != null) {
            ((stepos.support.v7.app.F) ((Q.a) c).b).d.finish();
        }
    }

    public final void i(int i) throws Settings.SettingNotFoundException {
        float f;
        if (this.p == i) {
            return;
        }
        SpringAnimation springAnimation = this.e;
        springAnimation.cancel();
        springAnimation.setStartValue(this.p);
        springAnimation.getSpring().setFinalPosition(i);
        try {
            f = Settings.Global.getFloat(getContext().getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f = 1.0f;
        }
        if (f != 0.0f) {
            springAnimation.start();
        } else {
            post(new RunnableC0913p(this, i, 2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(int r6, int r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L43
            int r0 = r5.i
            if (r0 == 0) goto L43
            int r1 = r5.o
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
            android.view.animation.Interpolator r5 = r5.d
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.j(int, int):int");
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Configuration configuration = getResources().getConfiguration();
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        setPadding(getPaddingLeft(), configuration.orientation == 1 ? this.c + systemWindowInsetTop : systemWindowInsetTop, getPaddingRight(), getPaddingBottom());
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
            this.f6498x = false;
            this.k = false;
            this.f6485B = false;
            this.l = false;
            this.m = -1;
            this.f6486C = motionEvent.getY();
            this.f6487D = motionEvent.getY();
            float x10 = motionEvent.getX();
            float f = this.f6486C;
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    childAt = null;
                    break;
                }
                childAt = getChildAt(childCount);
                float x11 = childAt.getX();
                float y = childAt.getY();
                float width = childAt.getWidth() + x11;
                float height = childAt.getHeight() + y;
                if (x10 >= x11 && f >= y && x10 < width && f < height) {
                    break;
                }
                childCount--;
            }
            this.f6488F = childAt;
            this.E = childAt != null;
        } else if (actionMasked == 2) {
            float y9 = motionEvent.getY() - this.f6486C;
            if (!this.f6498x && (view = this.f6488F) != null && !a(view) && Math.abs(y9) > this.h) {
                this.f6498x = true;
            }
            this.f6487D = motionEvent.getY();
        }
        return this.f6498x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        int width = getWidth();
        int measuredHeight = (getMeasuredHeight() - this.f6493r) - this.p;
        int paddingLeft = getPaddingLeft();
        int paddingRight = width - getPaddingRight();
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            T t9 = (T) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !t9.f6559a) {
                int i13 = measuredHeight + ((ViewGroup.MarginLayoutParams) t9).topMargin;
                int measuredHeight2 = childAt.getMeasuredHeight() + i13;
                int measuredWidth = childAt.getMeasuredWidth();
                int i14 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft;
                childAt.layout(i14, i13, measuredWidth + i14, measuredHeight2);
                measuredHeight = measuredHeight2 + ((ViewGroup.MarginLayoutParams) t9).bottomMargin;
            }
        }
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            T t10 = (T) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && t10.f6559a) {
                int height = (((getHeight() - childAt2.getMeasuredHeight()) - (t10.b ? 0 : getPaddingBottom())) - ((ViewGroup.MarginLayoutParams) t10).bottomMargin) + this.f6489G;
                int measuredHeight3 = childAt2.getMeasuredHeight() + height;
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int i16 = (((paddingRight - paddingLeft) - measuredWidth2) / 2) + paddingLeft;
                childAt2.layout(i16, height, measuredWidth2 + i16, measuredHeight3);
            }
        }
        if (this.y == 2 && this.o != 2 && z10) {
            this.o = 0;
            g(this.f6494s - this.p);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i6);
        if (this.f6495t < size2) {
            this.f6495t = size2;
        }
        int iMin = Math.min(size2, this.f6495t);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int measuredHeight = paddingTop;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            T t9 = (T) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !t9.c) {
                measureChildWithMargins(childAt, iMakeMeasureSpec, 0, iMakeMeasureSpec2, measuredHeight);
                if (!t9.b) {
                    measuredHeight = childAt.getMeasuredHeight() + measuredHeight;
                }
            }
        }
        int i11 = iMin - measuredHeight;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            T t10 = (T) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && t10.c) {
                if ((childAt2 instanceof LitePopupContentFrameLayout) && this.y == 1) {
                    LitePopupContentFrameLayout litePopupContentFrameLayout = (LitePopupContentFrameLayout) childAt2;
                    if (this.n) {
                        litePopupContentFrameLayout.setLimitHeight(getPaddingTop() + (this.f6493r - measuredHeight));
                    }
                }
                childAt2.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) t10).leftMargin + ((ViewGroup.MarginLayoutParams) t10).rightMargin, ((ViewGroup.MarginLayoutParams) t10).width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) t10).topMargin + ((ViewGroup.MarginLayoutParams) t10).bottomMargin + measuredHeight, i11));
                measuredHeight = childAt2.getMeasuredHeight() + measuredHeight;
            }
        }
        this.f6493r = Math.min(this.f6492q, (measuredHeight - getPaddingTop()) - getPaddingBottom());
        this.f6494s = Math.max(0, ((measuredHeight - getPaddingBottom()) - getPaddingTop()) - this.f6493r);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View view, float f, float f7) throws Settings.SettingNotFoundException {
        boolean z10 = this.p <= this.f6494s || e();
        if (z10) {
            boolean zCanScrollVertically = view.canScrollVertically(-1);
            if (f7 < 0.0f && zCanScrollVertically && this.o == 0) {
                return false;
            }
            if (Math.abs(f7) > this.f6490a) {
                int iC = c(-f7, this.o);
                this.m = iC;
                if (this.o != iC) {
                    h(iC);
                } else {
                    z10 = !zCanScrollVertically;
                }
            }
            if (view instanceof StepOSRecyclerView) {
                ((StepOSRecyclerView) view).setOverScrollEnable(false);
            }
        }
        return z10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View view, int i, int i6, int[] iArr) {
        onNestedPreScroll(view, i, i6, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View view, int i, int i6, int i10, int i11, int i12) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View view, View view2, int i, int i6) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View view) throws Settings.SettingNotFoundException {
        onStopNestedScroll(view, 0);
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
            android.view.VelocityTracker r0 = r5.b
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
            boolean r0 = r5.E
            if (r0 == 0) goto L2a
            float r0 = r6.getY()
            float r1 = r5.f6487D
            float r0 = r0 - r1
            float r6 = r6.getY()
            r5.f6487D = r6
            float r6 = -r0
            int r6 = (int) r6
            r5.f(r6, r2)
        L2a:
            return r4
        L2b:
            boolean r6 = r5.E
            if (r6 == 0) goto L56
            r6 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r6)
            float r6 = r0.getYVelocity()
            float r1 = java.lang.Math.abs(r6)
            float r2 = r5.f6490a
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L4c
            int r1 = r5.o
            int r6 = r5.c(r6, r1)
            r5.h(r6)
            goto L7c
        L4c:
            int r6 = r5.o
            int r6 = r5.d(r6)
            r5.h(r6)
            goto L7c
        L56:
            boolean r6 = r5.f6499z
            if (r6 == 0) goto L6b
            android.content.res.Resources r6 = r5.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            if (r6 == r3) goto L6a
            int r6 = r5.o
            if (r6 != r4) goto L6b
        L6a:
            r2 = r4
        L6b:
            stepos.support.v7.app.C r6 = r5.u
            if (r6 == 0) goto L7c
            if (r2 == 0) goto L7c
            Q.a r6 = (Q.a) r6
            java.lang.Object r6 = r6.b
            stepos.support.v7.app.F r6 = (stepos.support.v7.app.F) r6
            stepos.support.v7.app.D r6 = r6.d
            r6.finish()
        L7c:
            r5.b()
            r0.clear()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDismissedOnTouchOutside(boolean z10) {
        this.f6499z = z10;
    }

    public void setMaxHeight(int i) {
        this.f6495t = i;
    }

    public void setOnDismissedListener(stepos.support.v7.app.C c) {
        this.u = c;
    }

    public void setScrollListener(U u) {
    }

    public void setScrollPopupFirstOnTop(boolean z10) {
        this.f6484A = z10;
    }

    public void setScrollToDismissEnabled(boolean z10) {
        this.f6497w = z10;
    }

    public void setStyle(int i) {
        this.y = i;
    }

    public void setUncollapsibleHeight(int i) {
        this.f6492q = i;
        requestLayout();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View view, int i, int i6, int[] iArr, int i10) {
        boolean z10 = false;
        boolean z11 = i6 > 0 && (((!this.f6484A ? this.p < this.f6494s : this.p <= this.f6494s) && this.y != 1) || (this.p < 0 && this.y == 1));
        if (i6 < 0 && !view.canScrollVertically(-1)) {
            z10 = true;
        }
        if (z11 || (z10 && !this.l)) {
            iArr[1] = f(i6, true);
        } else if (i6 != 0) {
            this.l = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View view, int i, int i6, int i10, int i11, int i12, int[] iArr) {
        if (i11 >= 0 || view.canScrollVertically(-1) || this.l) {
            return;
        }
        iArr[1] = f(i11, true);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View view, View view2, int i, int i6) {
        if (view2 instanceof StepOSRecyclerView) {
            ((StepOSRecyclerView) view2).setOverScrollEnable(true);
        }
        this.m = -1;
        return (i & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View view, int i) throws Settings.SettingNotFoundException {
        if (this.e.isRunning()) {
            return;
        }
        int iD = d(this.o);
        int i6 = this.m;
        if (i6 != -1 && i6 != 2) {
            iD = i6;
        }
        h(iD);
        b();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof T) {
            T t9 = (T) layoutParams;
            T t10 = new T(t9);
            t10.f6559a = t9.f6559a;
            t10.b = t9.b;
            t10.c = t9.c;
            return t10;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new T((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new T(layoutParams);
    }
}
