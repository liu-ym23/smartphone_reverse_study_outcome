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
import android.view.animation.PathInterpolator;
import android.widget.OverScroller;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class PopupNestedScrollingLayout extends ViewGroup implements n3.r {
    public static final PathInterpolator L = new PathInterpolator(0.2f, 0.03f, 0.0f, 1.0f);
    public static final float M = 0.88f;
    public static final float N = 340.0f;
    public static final float O = 0.93f;
    public static final float P = 400.0f;
    public static final float Q = 0.98f;
    public static final float R = 300.0f;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public float G;
    public float H;
    public boolean I;
    public View J;
    public int K;

    /* renamed from: c, reason: collision with root package name */
    public final float f12613c;

    /* renamed from: f, reason: collision with root package name */
    public final VelocityTracker f12614f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12615g;

    /* renamed from: h, reason: collision with root package name */
    public final PathInterpolator f12616h;
    public final z3.g i;

    /* renamed from: j, reason: collision with root package name */
    public final float f12617j;

    /* renamed from: k, reason: collision with root package name */
    public final int f12618k;

    /* renamed from: l, reason: collision with root package name */
    public final int f12619l;

    /* renamed from: m, reason: collision with root package name */
    public final int f12620m;

    /* renamed from: n, reason: collision with root package name */
    public final int f12621n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12622o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12623p;

    /* renamed from: q, reason: collision with root package name */
    public int f12624q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f12625r;

    /* renamed from: s, reason: collision with root package name */
    public int f12626s;

    /* renamed from: t, reason: collision with root package name */
    public int f12627t;

    /* renamed from: u, reason: collision with root package name */
    public int f12628u;

    /* renamed from: v, reason: collision with root package name */
    public int f12629v;

    /* renamed from: w, reason: collision with root package name */
    public int f12630w;

    /* renamed from: x, reason: collision with root package name */
    public int f12631x;

    /* renamed from: y, reason: collision with root package name */
    public stepos.support.v7.app.t f12632y;

    /* renamed from: z, reason: collision with root package name */
    public final w0 f12633z;

    public PopupNestedScrollingLayout(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.f12616h = new PathInterpolator(0.12f, 0.0f, 0.33f, 1.0f);
        this.f12622o = false;
        this.f12625r = true;
        this.f12626s = 1;
        this.f12627t = 0;
        w0 w0Var = new w0(1);
        w0Var.f12894f = this;
        VarHandle.storeStoreFence();
        this.f12633z = w0Var;
        this.A = true;
        this.C = 0;
        this.D = true;
        this.E = false;
        this.F = false;
        this.K = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, oe.a.f9501c, i, 0);
        this.f12631x = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f12615g = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_padding_top));
        typedArrayObtainStyledAttributes.recycle();
        new OverScroller(context, L);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f12613c = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f12617j = getResources().getDimensionPixelSize(R.dimen.stepos_config_popup_nested_scroll_abandon_velocity);
        getResources().getDimensionPixelSize(R.dimen.stepos_config_popup_nested_fling_down_velocity);
        this.f12614f = VelocityTracker.obtain();
        setClipToPadding(false);
        this.f12619l = viewConfiguration.getScaledTouchSlop();
        this.f12620m = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_over_scroll_distance);
        this.f12621n = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_dismiss_triggered_distance);
        this.f12618k = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_scroll_down_threshold);
        this.f12628u = context.getResources().getDimensionPixelSize(R.dimen.stepos_lite_popup_middle_state_height);
        z3.g gVar = new z3.g(new w.d());
        this.i = gVar;
        l0 l0Var = new l0();
        l0Var.f12773a = this;
        VarHandle.storeStoreFence();
        gVar.a(l0Var);
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
        int i3 = this.f12626s;
        z3.g gVar = this.i;
        if (i3 == i) {
            z3.h hVar = new z3.h();
            hVar.a(Q);
            hVar.b(R);
            gVar.f16369k = hVar;
            return;
        }
        if (i == 0 || i == 1) {
            z3.h hVar2 = new z3.h();
            hVar2.a(M);
            hVar2.b(N);
            gVar.f16369k = hVar2;
            return;
        }
        if (i != 2) {
            return;
        }
        z3.h hVar3 = new z3.h();
        hVar3.a(O);
        hVar3.b(P);
        gVar.f16369k = hVar3;
    }

    public final void b() {
        if (this.f12632y == null || this.A || !e()) {
            return;
        }
        if (!this.F && post(this.f12633z)) {
            this.F = true;
        }
        if (this.F) {
            return;
        }
        stepos.support.v7.app.t tVar = this.f12632y;
        if (tVar != null) {
            ((stepos.support.v7.app.w) ((stepos.support.v7.app.f) tVar).f12315f).f12513d.getClass();
        }
        this.f12622o = true;
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
            boolean r0 = r6.A
            if (r0 != 0) goto L9
            int r1 = r6.C
            if (r1 == 0) goto L9
            goto Ld
        L9:
            boolean r1 = r6.f12623p
            if (r1 == 0) goto Le
        Ld:
            return r8
        Le:
            int r1 = r6.f12627t
            int r2 = r6.f12629v
            int r2 = -r2
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 < r2) goto L33
            if (r1 >= 0) goto L33
            int r1 = r6.C
            if (r1 != r5) goto L23
            int r6 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r6 <= 0) goto L44
            goto L3b
        L23:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 < 0) goto L29
            if (r0 != 0) goto L3b
        L29:
            float r6 = r6.f12617j
            float r6 = -r6
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 >= 0) goto L44
            if (r8 != 0) goto L44
            goto L42
        L33:
            int r6 = r6.C
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
            boolean r0 = r6.A
            if (r0 != 0) goto L9
            int r0 = r6.C
            if (r0 == 0) goto L9
            return r7
        L9:
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L10
            int r2 = r6.f12630w
            goto L17
        L10:
            if (r7 != r1) goto L14
            r2 = r0
            goto L17
        L14:
            int r2 = r6.f12629v
            int r2 = -r2
        L17:
            int r3 = r6.f12627t
            int r3 = r3 - r2
            int r2 = java.lang.Math.abs(r3)
            int r4 = r6.f12618k
            r5 = 2
            if (r3 <= 0) goto L37
            if (r7 != r5) goto L2e
            int r6 = r6.f12629v
            int r6 = r6 + r4
            if (r2 <= r6) goto L2b
            goto L55
        L2b:
            if (r2 <= r4) goto L64
            goto L63
        L2e:
            if (r7 != r1) goto L55
            if (r2 <= r4) goto L63
            int r6 = r6.C
            if (r6 != 0) goto L63
            goto L55
        L37:
            if (r7 != 0) goto L56
            int r7 = r6.C
            if (r7 != r5) goto L44
            if (r2 <= r4) goto L55
            boolean r6 = r6.A
            if (r6 == 0) goto L55
            goto L64
        L44:
            int r7 = r6.f12630w
            int r7 = r7 + r4
            if (r2 <= r7) goto L52
            boolean r7 = r6.A
            if (r7 == 0) goto L52
            boolean r6 = r6.f12623p
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
            boolean r7 = r6.A
            if (r7 == 0) goto L63
            boolean r6 = r6.f12623p
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
        int i = this.C;
        int i3 = this.f12619l;
        int i10 = this.f12621n;
        if (i == 1 || this.f12626s == 1) {
            if (this.f12627t > (-(i10 - i3)) || this.f12622o) {
                return false;
            }
        } else if (i != 2 || Math.abs(this.f12627t - this.f12630w) < i10 - i3 || this.f12622o) {
            return false;
        }
        return true;
    }

    public final int f(int i, boolean z10) {
        int i3 = this.f12627t;
        int i10 = i3 + i;
        int i11 = this.f12630w;
        if (i10 > i11) {
            i = i11 - i3;
        }
        if (!this.A) {
            int i12 = this.C;
            if (i12 == 1 && (i < 0 || !z10)) {
                i = o(i, i3);
            } else if (i12 == 2 && (i < 0 || !z10)) {
                i = o(i, i3 - i11);
            } else if (this.f12626s == 1 && i < 0) {
                i = o(i, i3);
            }
        } else if (this.f12623p && i < 0 && i3 <= 0) {
            i = o(i, i3);
        } else if (this.C == 1 && i > 0 && !z10) {
            i = o(i, i3);
        }
        this.i.b();
        g(i);
        return i;
    }

    public final void g(int i) {
        int i3 = -i;
        int i10 = this.f12627t;
        int i11 = (-i3) + i10 >= 0 ? -this.K : (i10 <= 0 || i3 <= 0) ? i3 : i3 - i10;
        this.K += i11;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((m0) childAt.getLayoutParams()).f12778a) {
                childAt.offsetTopAndBottom(i11);
            } else {
                childAt.offsetTopAndBottom(i3);
            }
        }
        int i13 = this.f12627t + i;
        this.f12627t = i13;
        if (i13 >= 0 || this.f12632y == null) {
            return;
        }
        float fAbs = Math.abs(i13);
        float f5 = fAbs / this.f12629v;
        stepos.support.v7.app.w wVar = (stepos.support.v7.app.w) ((stepos.support.v7.app.f) this.f12632y).f12315f;
        int i14 = (int) ((1.0f - f5) * wVar.f12511b);
        wVar.f12510a.setAlpha(i14);
        wVar.f12514e = i14;
        wVar.f12513d.getClass();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new m0(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof m0)) {
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new m0((ViewGroup.MarginLayoutParams) layoutParams) : new m0(layoutParams);
        }
        m0 m0Var = (m0) layoutParams;
        m0 m0Var2 = new m0(m0Var);
        m0Var2.f12778a = m0Var.f12778a;
        m0Var2.f12779b = m0Var.f12779b;
        m0Var2.f12780c = m0Var.f12780c;
        return m0Var2;
    }

    public int getCurrentScrollY() {
        return this.f12627t;
    }

    public int getPositionState() {
        return this.f12626s;
    }

    public int getUncollapsibleHeight() {
        return this.f12629v;
    }

    public final void h(int i) throws Settings.SettingNotFoundException {
        setSpringForce(i);
        this.f12626s = i;
        if (i == 0) {
            i(this.f12630w);
            return;
        }
        if (i == 1) {
            i(0);
            return;
        }
        if (i != 2) {
            return;
        }
        this.i.b();
        stepos.support.v7.app.t tVar = this.f12632y;
        if (tVar != null) {
            stepos.support.v7.app.u uVar = ((stepos.support.v7.app.w) ((stepos.support.v7.app.f) tVar).f12315f).f12513d;
            uVar.getClass();
            uVar.finish();
        }
    }

    public final void i(int i) throws Settings.SettingNotFoundException {
        float f5;
        if (this.f12627t == i) {
            return;
        }
        z3.g gVar = this.i;
        gVar.b();
        gVar.f16361b = this.f12627t;
        gVar.f16362c = true;
        gVar.f16369k.i = i;
        try {
            f5 = Settings.Global.getFloat(getContext().getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f5 = 1.0f;
        }
        if (f5 != 0.0f) {
            gVar.g();
            return;
        }
        a4.h hVar = new a4.h();
        hVar.f172g = this;
        hVar.f171f = i;
        VarHandle.storeStoreFence();
        post(hVar);
    }

    @Override // n3.q
    public final void j(int i, View view) throws Settings.SettingNotFoundException {
        if (this.i.f16365f) {
            return;
        }
        int iD = d(this.f12626s);
        int i3 = this.f12624q;
        if (i3 != -1 && i3 != 2) {
            iD = i3;
        }
        h(iD);
        b();
    }

    @Override // n3.r
    public final void k(View view, int i, int i3, int i10, int i11, int i12, int[] iArr) {
        if (i11 >= 0 || view.canScrollVertically(-1) || this.f12623p) {
            return;
        }
        iArr[1] = f(i11, true);
    }

    @Override // n3.q
    public final boolean m(View view, View view2, int i, int i3) {
        if (view2 instanceof StepOSRecyclerView) {
            ((StepOSRecyclerView) view2).setOverScrollEnable(true);
        }
        this.f12624q = -1;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int o(int r6, int r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L43
            int r0 = r5.f12620m
            if (r0 == 0) goto L43
            int r1 = r5.f12626s
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
            android.view.animation.PathInterpolator r5 = r5.f12616h
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.o(int, int):int");
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Configuration configuration = getResources().getConfiguration();
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        setPadding(getPaddingLeft(), configuration.orientation == 1 ? this.f12615g + systemWindowInsetTop : systemWindowInsetTop, getPaddingRight(), getPaddingBottom());
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
            this.B = false;
            this.f12622o = false;
            this.F = false;
            this.f12623p = false;
            this.f12624q = -1;
            this.G = motionEvent.getY();
            this.H = motionEvent.getY();
            float x6 = motionEvent.getX();
            float f5 = this.G;
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    childAt = null;
                    break;
                }
                childAt = getChildAt(childCount);
                float x10 = childAt.getX();
                float y10 = childAt.getY();
                float width = childAt.getWidth() + x10;
                float height = childAt.getHeight() + y10;
                if (x6 >= x10 && f5 >= y10 && x6 < width && f5 < height) {
                    break;
                }
                childCount--;
            }
            this.J = childAt;
            this.I = childAt != null;
        } else if (actionMasked == 2) {
            float y11 = motionEvent.getY() - this.G;
            if (!this.B && (view = this.J) != null && !a(view) && Math.abs(y11) > this.f12619l) {
                this.B = true;
            }
            this.H = motionEvent.getY();
        }
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        int width = getWidth();
        int measuredHeight = (getMeasuredHeight() - this.f12629v) - this.f12627t;
        int paddingLeft = getPaddingLeft();
        int paddingRight = width - getPaddingRight();
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            m0 m0Var = (m0) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !m0Var.f12778a) {
                int i13 = measuredHeight + ((ViewGroup.MarginLayoutParams) m0Var).topMargin;
                int measuredHeight2 = childAt.getMeasuredHeight() + i13;
                int measuredWidth = childAt.getMeasuredWidth();
                int i14 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft;
                childAt.layout(i14, i13, measuredWidth + i14, measuredHeight2);
                measuredHeight = measuredHeight2 + ((ViewGroup.MarginLayoutParams) m0Var).bottomMargin;
            }
        }
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            m0 m0Var2 = (m0) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && m0Var2.f12778a) {
                int height = (((getHeight() - childAt2.getMeasuredHeight()) - (m0Var2.f12779b ? 0 : getPaddingBottom())) - ((ViewGroup.MarginLayoutParams) m0Var2).bottomMargin) + this.K;
                int measuredHeight3 = childAt2.getMeasuredHeight() + height;
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int i16 = (((paddingRight - paddingLeft) - measuredWidth2) / 2) + paddingLeft;
                childAt2.layout(i16, height, measuredWidth2 + i16, measuredHeight3);
            }
        }
        if (this.C == 2 && this.f12626s != 2 && z10) {
            this.f12626s = 0;
            g(this.f12630w - this.f12627t);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i3);
        if (this.f12631x < size2) {
            this.f12631x = size2;
        }
        int iMin = Math.min(size2, this.f12631x);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int measuredHeight = paddingTop;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            m0 m0Var = (m0) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !m0Var.f12780c) {
                measureChildWithMargins(childAt, iMakeMeasureSpec, 0, iMakeMeasureSpec2, measuredHeight);
                if (!m0Var.f12779b) {
                    measuredHeight = childAt.getMeasuredHeight() + measuredHeight;
                }
            }
        }
        int i11 = iMin - measuredHeight;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            m0 m0Var2 = (m0) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && m0Var2.f12780c) {
                if ((childAt2 instanceof LitePopupContentFrameLayout) && this.C == 1) {
                    LitePopupContentFrameLayout litePopupContentFrameLayout = (LitePopupContentFrameLayout) childAt2;
                    if (this.f12625r) {
                        litePopupContentFrameLayout.setLimitHeight(getPaddingTop() + (this.f12629v - measuredHeight));
                    }
                }
                childAt2.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) m0Var2).leftMargin + ((ViewGroup.MarginLayoutParams) m0Var2).rightMargin, ((ViewGroup.MarginLayoutParams) m0Var2).width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) m0Var2).topMargin + ((ViewGroup.MarginLayoutParams) m0Var2).bottomMargin + measuredHeight, i11));
                measuredHeight = childAt2.getMeasuredHeight() + measuredHeight;
            }
        }
        this.f12629v = Math.min(this.f12628u, (measuredHeight - getPaddingTop()) - getPaddingBottom());
        this.f12630w = Math.max(0, ((measuredHeight - getPaddingBottom()) - getPaddingTop()) - this.f12629v);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f10) throws Settings.SettingNotFoundException {
        boolean z10 = this.f12627t <= this.f12630w || e();
        if (z10) {
            boolean zCanScrollVertically = view.canScrollVertically(-1);
            if (f10 < 0.0f && zCanScrollVertically && this.f12626s == 0) {
                return false;
            }
            if (Math.abs(f10) > this.f12613c) {
                int iC = c(-f10, this.f12626s);
                this.f12624q = iC;
                if (this.f12626s != iC) {
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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i3, int[] iArr) {
        q(view, i, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return m(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) throws Settings.SettingNotFoundException {
        j(0, view);
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
            android.view.VelocityTracker r0 = r5.f12614f
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
            r5.f(r6, r2)
        L2a:
            return r4
        L2b:
            boolean r6 = r5.I
            if (r6 == 0) goto L57
            r6 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r6)
            float r6 = r0.getYVelocity()
            float r1 = java.lang.Math.abs(r6)
            float r3 = r5.f12613c
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L43
            r2 = r4
        L43:
            int r1 = r5.f12626s
            if (r2 == 0) goto L4f
            int r6 = r5.c(r6, r1)
            r5.h(r6)
            goto L80
        L4f:
            int r6 = r5.d(r1)
            r5.h(r6)
            goto L80
        L57:
            boolean r6 = r5.D
            if (r6 == 0) goto L6c
            android.content.res.Resources r6 = r5.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            if (r6 == r3) goto L6b
            int r6 = r5.f12626s
            if (r6 != r4) goto L6c
        L6b:
            r2 = r4
        L6c:
            stepos.support.v7.app.t r6 = r5.f12632y
            if (r6 == 0) goto L80
            if (r2 == 0) goto L80
            stepos.support.v7.app.f r6 = (stepos.support.v7.app.f) r6
            java.lang.Object r6 = r6.f12315f
            stepos.support.v7.app.w r6 = (stepos.support.v7.app.w) r6
            stepos.support.v7.app.u r6 = r6.f12513d
            r6.getClass()
            r6.finish()
        L80:
            r5.b()
            r0.clear()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // n3.q
    public final void q(View view, int i, int i3, int[] iArr, int i10) {
        boolean z10 = this.E;
        int i11 = this.f12627t;
        int i12 = this.f12630w;
        boolean z11 = false;
        boolean z12 = i3 > 0 && (((!z10 ? i11 < i12 : i11 <= i12) && this.C != 1) || (i11 < 0 && this.C == 1));
        if (i3 < 0 && !view.canScrollVertically(-1)) {
            z11 = true;
        }
        if (z12 || (z11 && !this.f12623p)) {
            iArr[1] = f(i3, true);
        } else if (i3 != 0) {
            this.f12623p = true;
        }
    }

    public void setDismissedOnTouchOutside(boolean z10) {
        this.D = z10;
    }

    public void setMaxHeight(int i) {
        this.f12631x = i;
    }

    public void setOnDismissedListener(stepos.support.v7.app.t tVar) {
        this.f12632y = tVar;
    }

    public void setScrollPopupFirstOnTop(boolean z10) {
        this.E = z10;
    }

    public void setScrollToDismissEnabled(boolean z10) {
        this.A = z10;
    }

    public void setStyle(int i) {
        this.C = i;
    }

    public void setUncollapsibleHeight(int i) {
        this.f12628u = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        m0 m0Var = new m0(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, oe.a.f9502d);
        m0Var.f12778a = typedArrayObtainStyledAttributes.getBoolean(0, false);
        m0Var.f12779b = typedArrayObtainStyledAttributes.getBoolean(1, false);
        m0Var.f12780c = typedArrayObtainStyledAttributes.getBoolean(2, false);
        typedArrayObtainStyledAttributes.recycle();
        return m0Var;
    }

    public void setScrollListener(n0 n0Var) {
    }

    @Override // n3.q
    public final void n(View view, View view2, int i, int i3) {
    }

    public PopupNestedScrollingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopupNestedScrollingLayout(Context context) {
        this(context, null);
    }

    @Override // n3.q
    public final void l(View view, int i, int i3, int i10, int i11, int i12) {
    }
}
