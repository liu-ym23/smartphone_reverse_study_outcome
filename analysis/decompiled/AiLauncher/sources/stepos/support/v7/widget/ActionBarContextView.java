package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.N;
import androidx.core.view.U;
import androidx.core.view.V;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$bool;
import stepos.support.v7.appcompat.R$layout;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class ActionBarContextView extends stepos.support.v7.widget.a {

    /* renamed from: B, reason: collision with root package name */
    public static final Interpolator f41042B;

    /* renamed from: C, reason: collision with root package name */
    public static final Interpolator f41043C;

    /* renamed from: A, reason: collision with root package name */
    public U f41044A;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f41045m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f41046n;

    /* renamed from: o, reason: collision with root package name */
    public View f41047o;

    /* renamed from: p, reason: collision with root package name */
    public View f41048p;

    /* renamed from: q, reason: collision with root package name */
    public LinearLayout f41049q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f41050r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f41051s;

    /* renamed from: t, reason: collision with root package name */
    public int f41052t;

    /* renamed from: u, reason: collision with root package name */
    public int f41053u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f41054v;

    /* renamed from: w, reason: collision with root package name */
    public int f41055w;

    /* renamed from: x, reason: collision with root package name */
    public int f41056x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f41057y;

    /* renamed from: z, reason: collision with root package name */
    public final c f41058z;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ic.b f41059a;

        public a(Ic.b bVar) {
            this.f41059a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f41059a.c();
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41061a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f41062b;

        public b(View view, int i10) {
            this.f41061a = view;
            this.f41062b = i10;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f41061a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ActionBarContextView.this.f41056x == 2) {
                ActionBarContextView.this.f41058z.d(this.f41061a);
                return false;
            }
            N.C0(this.f41061a, this.f41061a.getHeight());
            U uM = N.d(this.f41061a).m(0.0f);
            uM.f(260L);
            uM.g(ActionBarContextView.f41042B);
            uM.h(ActionBarContextView.this.f41058z.a(uM, this.f41062b));
            uM.l();
            return false;
        }
    }

    public class c implements V {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41064a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f41065b;

        public c() {
        }

        public c a(U u10, int i10) {
            ActionBarContextView.this.f41044A = u10;
            this.f41065b = i10;
            return this;
        }

        @Override // androidx.core.view.V
        public void c(View view) {
            this.f41064a = true;
        }

        @Override // androidx.core.view.V
        public void d(View view) {
            if (this.f41064a) {
                return;
            }
            if (ActionBarContextView.this.f41056x == 2) {
                ActionBarContextView.this.s();
            }
            ViewGroup viewGroup = ActionBarContextView.this.f41521e;
            if (viewGroup != null) {
                viewGroup.setTranslationY(0.0f);
            }
            ActionBarContextView.this.f41056x = 0;
            ActionBarContextView.this.f41044A = null;
        }

        @Override // androidx.core.view.V
        public void e(View view) {
            ViewGroup viewGroup = ActionBarContextView.this.f41521e;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            this.f41064a = false;
        }
    }

    static {
        Interpolator interpolatorA = D0.a.a(0.2f, 0.028f, 0.1f, 1.0f);
        f41042B = interpolatorA;
        f41043C = interpolatorA;
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    @Override // stepos.support.v7.widget.a
    public /* bridge */ /* synthetic */ U f(int i10, long j10) {
        return super.f(i10, j10);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // stepos.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // stepos.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public View getCustomView() {
        return this.f41048p;
    }

    public CharSequence getSubtitle() {
        return this.f41046n;
    }

    public CharSequence getTitle() {
        return this.f41045m;
    }

    public void k(boolean z10, Ic.b bVar) {
        U u10;
        (z10 ? f(0, 200L) : f(8, 100L)).l();
        if (this.f41522f || this.f41057y) {
            if (bVar != null ? bVar.m() : true) {
                l(z10);
            } else if (this.f41056x == 2 && (u10 = this.f41044A) != null && z10) {
                u10.c();
            }
        }
    }

    public final void l(boolean z10) {
        t(z10 ? 0 : 8);
    }

    public void m() {
        if (this.f41047o != null || this.f41057y) {
            return;
        }
        s();
    }

    public void n(Ic.b bVar) {
        View view = this.f41047o;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f41055w, (ViewGroup) this, false);
            this.f41047o = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f41047o);
        }
        this.f41047o.findViewById(R$id.action_mode_close_button).setOnClickListener(new a(bVar));
        stepos.support.v7.view.menu.c cVar = (stepos.support.v7.view.menu.c) bVar.f();
        ActionMenuPresenter actionMenuPresenter = this.f41520d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.I();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f41520d = actionMenuPresenter2;
        actionMenuPresenter2.Y(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (!this.f41522f) {
            cVar.c(this.f41520d, this.f41518b);
            ActionMenuView actionMenuView = (ActionMenuView) this.f41520d.n(this);
            this.f41519c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f41519c, layoutParams);
            return;
        }
        this.f41520d.Z(getContext().getResources().getDisplayMetrics().widthPixels - (Ic.a.b(getContext()).f() * 2), true);
        this.f41520d.U(Integer.MAX_VALUE);
        this.f41520d.T(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        cVar.c(this.f41520d, this.f41518b);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f41520d.n(this);
        this.f41519c = actionMenuView2;
        actionMenuView2.setId(stepos.support.v7.appcompat.R$id.stepos_action_mode_menu_view);
        ViewGroup viewGroup = this.f41521e;
        if (viewGroup != null) {
            viewGroup.addView(this.f41519c, layoutParams);
        }
    }

    public void o(Ic.b bVar) {
        this.f41057y = true;
        stepos.support.v7.view.menu.c cVar = (stepos.support.v7.view.menu.c) bVar.f();
        ActionMenuPresenter actionMenuPresenter = this.f41520d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.I();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f41520d = actionMenuPresenter2;
        actionMenuPresenter2.Y(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (this.f41521e == null) {
            cVar.c(this.f41520d, this.f41518b);
            ActionMenuView actionMenuView = (ActionMenuView) this.f41520d.n(this);
            this.f41519c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f41519c, layoutParams);
            return;
        }
        this.f41520d.Z(getContext().getResources().getDisplayMetrics().widthPixels - (Ic.a.b(getContext()).f() * 2), true);
        this.f41520d.U(Integer.MAX_VALUE);
        this.f41520d.T(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        cVar.c(this.f41520d, this.f41518b);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f41520d.n(this);
        this.f41519c = actionMenuView2;
        actionMenuView2.setId(stepos.support.v7.appcompat.R$id.stepos_action_mode_menu_view);
        this.f41521e.addView(this.f41519c, layoutParams);
    }

    @Override // stepos.support.v7.widget.a, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f41523g) {
            setSplitToolbar(getContext().getResources().getBoolean(R$bool.stepos_split_action_bar_is_narrow));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f41520d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.M();
            this.f41520d.N();
        }
    }

    @Override // stepos.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f41045m);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean zM = y.m(this);
        int paddingRight = zM ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f41047o;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f41047o.getLayoutParams();
            int i14 = zM ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = zM ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = stepos.support.v7.widget.a.d(paddingRight, i14, zM);
            paddingRight = stepos.support.v7.widget.a.d(iD + e(this.f41047o, iD, paddingTop, paddingTop2, zM), i15, zM);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f41049q;
        if (linearLayout != null && this.f41048p == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f41049q, iE, paddingTop, paddingTop2, zM);
        }
        View view2 = this.f41048p;
        if (view2 != null) {
            e(view2, iE, paddingTop, paddingTop2, zM);
        }
        int paddingLeft = zM ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f41519c;
        if (actionMenuView == null || actionMenuView.getParent() != this) {
            return;
        }
        e(this.f41519c, paddingLeft, paddingTop, paddingTop2, !zM);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = this.f41524h;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i11);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f41047o;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f41047o.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f41519c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f41519c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f41049q;
        if (linearLayout != null && this.f41048p == null) {
            if (this.f41054v) {
                this.f41049q.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f41049q.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f41049q.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f41048p;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i12 = layoutParams.width;
            int i13 = i12 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i12 >= 0) {
                paddingLeft = Math.min(i12, paddingLeft);
            }
            int i14 = layoutParams.height;
            int i15 = i14 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i14 >= 0) {
                iMin = Math.min(i14, iMin);
            }
            this.f41048p.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(iMin, i15));
        }
        if (this.f41524h > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            int measuredHeight = getChildAt(i17).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i16) {
                i16 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i16);
    }

    @Override // stepos.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        if (this.f41049q == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.stepos_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f41049q = linearLayout;
            this.f41050r = (TextView) linearLayout.findViewById(stepos.support.v7.appcompat.R$id.action_bar_title);
            this.f41051s = (TextView) this.f41049q.findViewById(stepos.support.v7.appcompat.R$id.action_bar_subtitle);
            if (this.f41052t != 0) {
                this.f41050r.setTextAppearance(getContext(), this.f41052t);
            }
            if (this.f41053u != 0) {
                this.f41051s.setTextAppearance(getContext(), this.f41053u);
            }
        }
        this.f41050r.setText(this.f41045m);
        this.f41051s.setText(this.f41046n);
        boolean zIsEmpty = TextUtils.isEmpty(this.f41045m);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f41046n);
        this.f41051s.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f41049q.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f41049q.getParent() == null) {
            addView(this.f41049q);
        }
    }

    public boolean q() {
        return this.f41057y;
    }

    public boolean r() {
        return this.f41054v;
    }

    public void s() {
        removeAllViews();
        ViewGroup viewGroup = this.f41521e;
        if (viewGroup != null) {
            viewGroup.removeView(this.f41519c);
        }
        this.f41048p = null;
        this.f41519c = null;
        this.f41057y = false;
        this.f41520d = null;
    }

    @Override // stepos.support.v7.widget.a
    public void setContentHeight(int i10) {
        this.f41524h = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f41048p;
        if (view2 != null) {
            removeView(view2);
        }
        this.f41048p = view;
        if (view != null && (linearLayout = this.f41049q) != null) {
            removeView(linearLayout);
            this.f41049q = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    @Override // stepos.support.v7.widget.a
    public void setSplitToolbar(boolean z10) {
        if (this.f41522f != z10) {
            if (this.f41520d != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!z10) {
                    ActionMenuView actionMenuView = (ActionMenuView) this.f41520d.n(this);
                    this.f41519c = actionMenuView;
                    actionMenuView.setBackgroundDrawable(null);
                    ViewGroup viewGroup = (ViewGroup) this.f41519c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f41519c);
                    }
                    addView(this.f41519c, layoutParams);
                } else if (this.f41521e != null) {
                    this.f41520d.Z(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.f41520d.U(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.f41524h;
                    ActionMenuView actionMenuView2 = (ActionMenuView) this.f41520d.n(this);
                    this.f41519c = actionMenuView2;
                    ViewGroup viewGroup2 = (ViewGroup) actionMenuView2.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.f41519c);
                    }
                    this.f41521e.addView(this.f41519c, layoutParams);
                }
            }
            super.setSplitToolbar(z10);
        }
    }

    @Override // stepos.support.v7.widget.a
    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup viewGroup) {
        super.setSplitView(viewGroup);
    }

    @Override // stepos.support.v7.widget.a
    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z10) {
        super.setSplitWhenNarrow(z10);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f41046n = charSequence;
        p();
    }

    public void setTitle(CharSequence charSequence) {
        this.f41045m = charSequence;
        p();
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f41054v) {
            requestLayout();
        }
        this.f41054v = z10;
    }

    @Override // stepos.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(int i10) {
        U u10 = this.f41044A;
        if (u10 != null) {
            u10.c();
        }
        this.f41056x = i10 == 0 ? 1 : 2;
        View childAt = this.f41521e.getChildAt(0);
        if (childAt.getId() == stepos.support.v7.appcompat.R$id.stepos_nested_bottom_divider) {
            childAt = this.f41521e.getChildAt(1);
        }
        ViewGroup viewGroup = this.f41521e;
        ViewGroup viewGroup2 = viewGroup != null ? (ViewGroup) childAt : null;
        View view = viewGroup == null ? this.f41519c : (viewGroup2 == null || viewGroup2 == this.f41519c || viewGroup2.getChildCount() <= 0) ? this.f41521e : this.f41519c;
        if (view == null) {
            this.f41056x = 0;
            return;
        }
        if (i10 == 0) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnPreDrawListener(new b(view, i10));
                return;
            }
            return;
        }
        U uM = N.d(view).m(view.getHeight());
        uM.f(260L);
        uM.h(this.f41058z.a(uM, i10));
        uM.g(f41043C);
        uM.l();
    }

    public boolean u() {
        ActionMenuPresenter actionMenuPresenter = this.f41520d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.a0();
        }
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, O6.c.c() ? R$attr.steposActionModeStyleFullScreen : androidx.appcompat.R$attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41058z = new c();
        androidx.appcompat.widget.U uV = androidx.appcompat.widget.U.v(context, attributeSet, R$styleable.ActionMode, i10, 0);
        setBackgroundDrawable(uV.g(R$styleable.ActionMode_background));
        this.f41052t = uV.n(R$styleable.ActionMode_titleTextStyle, 0);
        this.f41053u = uV.n(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f41524h = uV.m(R$styleable.ActionMode_height, 0);
        this.f41055w = uV.n(R$styleable.ActionMode_closeItemLayout, androidx.appcompat.R$layout.abc_action_mode_close_item_material);
        uV.x();
    }
}
