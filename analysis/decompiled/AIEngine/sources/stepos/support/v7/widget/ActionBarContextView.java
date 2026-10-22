package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.aiengine.R;
import stepos.support.v7.widget.ActionMenuPresenter;
import v0.h0;
import v0.i0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class ActionBarContextView extends stepos.support.v7.widget.a {
    public static final PathInterpolator D;
    public static final PathInterpolator E;
    public boolean A;
    public final b B;
    public h0 C;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f12447o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f12448p;

    /* renamed from: q, reason: collision with root package name */
    public View f12449q;
    public View r;

    /* renamed from: s, reason: collision with root package name */
    public LinearLayout f12450s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f12451t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f12452u;

    /* renamed from: v, reason: collision with root package name */
    public final int f12453v;

    /* renamed from: w, reason: collision with root package name */
    public final int f12454w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12455x;

    /* renamed from: y, reason: collision with root package name */
    public final int f12456y;
    public int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fe.b f12457a;

        public a(fe.b bVar) {
            this.f12457a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f12457a.c();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements i0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12458a = false;

        public b() {
        }

        @Override // v0.i0
        public final void c() {
            this.f12458a = true;
        }

        @Override // v0.i0
        public final void d(View view) {
            if (this.f12458a) {
                return;
            }
            ActionBarContextView actionBarContextView = ActionBarContextView.this;
            if (actionBarContextView.z == 2) {
                actionBarContextView.j();
            }
            ViewGroup viewGroup = actionBarContextView.f12690e;
            if (viewGroup != null) {
                viewGroup.setTranslationY(0.0f);
            }
            actionBarContextView.z = 0;
            actionBarContextView.C = null;
        }

        @Override // v0.i0
        public final void e(View view) {
            ViewGroup viewGroup = ActionBarContextView.this.f12690e;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            this.f12458a = false;
        }
    }

    static {
        PathInterpolator pathInterpolator = new PathInterpolator(0.2f, 0.028f, 0.1f, 1.0f);
        D = pathInterpolator;
        E = pathInterpolator;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.attr.steposActionModeStyleFullScreen);
        this.B = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8924d, R.attr.steposActionModeStyleFullScreen, 0);
        setBackgroundDrawable((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : b1.L(resourceId, context));
        this.f12453v = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f12454w = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f12692k = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f12456y = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void f(boolean z) {
        (z ? e(0, 200L) : e(8, 100L)).g();
        if (this.h || this.A) {
            int i10 = z ? 0 : 8;
            h0 h0Var = this.C;
            if (h0Var != null) {
                h0Var.b();
            }
            this.z = i10 == 0 ? 1 : 2;
            View childAt = this.f12690e.getChildAt(0);
            if (childAt.getId() == R.id.stepos_nested_bottom_divider) {
                childAt = this.f12690e.getChildAt(1);
            }
            ViewGroup viewGroup = this.f12690e;
            ViewGroup viewGroup2 = viewGroup != null ? (ViewGroup) childAt : null;
            ViewGroup viewGroup3 = viewGroup == null ? this.f12688c : (viewGroup2 == null || viewGroup2 == this.f12688c || viewGroup2.getChildCount() <= 0) ? this.f12690e : this.f12688c;
            if (viewGroup3 == null) {
                this.z = 0;
                return;
            }
            if (i10 == 0) {
                ViewTreeObserver viewTreeObserver = viewGroup3.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnPreDrawListener(new stepos.support.v7.widget.b(this, viewGroup3, i10));
                    return;
                }
                return;
            }
            float height = viewGroup3.getHeight();
            h0 h0VarA = v0.e0.a(viewGroup3);
            h0VarA.h(height);
            h0VarA.c(260L);
            b bVar = this.B;
            ActionBarContextView.this.C = h0VarA;
            h0VarA.e(bVar);
            h0VarA.d(E);
            h0VarA.g();
        }
    }

    public final void g(fe.b bVar) {
        View view = this.f12449q;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f12456y, (ViewGroup) this, false);
            this.f12449q = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f12449q);
        }
        this.f12449q.findViewById(R.id.action_mode_close_button).setOnClickListener(new a(bVar));
        stepos.support.v7.view.menu.c cVarE = bVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f12689d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.j();
            ActionMenuPresenter.c cVar = actionMenuPresenter.E;
            if (cVar != null) {
                cVar.h();
            }
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f12689d = actionMenuPresenter2;
        actionMenuPresenter2.f12503p = true;
        actionMenuPresenter2.f12504q = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        boolean z = this.h;
        Context context = this.f12687b;
        if (!z) {
            cVarE.b(this.f12689d, context);
            ActionMenuView actionMenuView = (ActionMenuView) this.f12689d.i(this);
            this.f12688c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f12688c, layoutParams);
            return;
        }
        this.f12689d.n(getContext().getResources().getDisplayMetrics().widthPixels - (fe.a.a(getContext()).b() * 2));
        this.f12689d.m();
        this.f12689d.l(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        cVarE.b(this.f12689d, context);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f12689d.i(this);
        this.f12688c = actionMenuView2;
        actionMenuView2.setId(R.id.stepos_action_mode_menu_view);
        ViewGroup viewGroup = this.f12690e;
        if (viewGroup != null) {
            viewGroup.addView(this.f12688c, layoutParams);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
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
        return this.r;
    }

    public CharSequence getSubtitle() {
        return this.f12448p;
    }

    public CharSequence getTitle() {
        return this.f12447o;
    }

    public final void h(fe.b bVar) {
        this.A = true;
        stepos.support.v7.view.menu.c cVarE = bVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f12689d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.j();
            ActionMenuPresenter.c cVar = actionMenuPresenter.E;
            if (cVar != null) {
                cVar.h();
            }
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f12689d = actionMenuPresenter2;
        actionMenuPresenter2.f12503p = true;
        actionMenuPresenter2.f12504q = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        ViewGroup viewGroup = this.f12690e;
        Context context = this.f12687b;
        if (viewGroup == null) {
            cVarE.b(this.f12689d, context);
            ActionMenuView actionMenuView = (ActionMenuView) this.f12689d.i(this);
            this.f12688c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f12688c, layoutParams);
            return;
        }
        this.f12689d.n(getContext().getResources().getDisplayMetrics().widthPixels - (fe.a.a(getContext()).b() * 2));
        this.f12689d.m();
        this.f12689d.l(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        cVarE.b(this.f12689d, context);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f12689d.i(this);
        this.f12688c = actionMenuView2;
        actionMenuView2.setId(R.id.stepos_action_mode_menu_view);
        this.f12690e.addView(this.f12688c, layoutParams);
    }

    public final void i() {
        if (this.f12450s == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.stepos_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f12450s = linearLayout;
            this.f12451t = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f12452u = (TextView) this.f12450s.findViewById(R.id.action_bar_subtitle);
            int i10 = this.f12453v;
            if (i10 != 0) {
                this.f12451t.setTextAppearance(getContext(), i10);
            }
            int i11 = this.f12454w;
            if (i11 != 0) {
                this.f12452u.setTextAppearance(getContext(), i11);
            }
        }
        this.f12451t.setText(this.f12447o);
        this.f12452u.setText(this.f12448p);
        boolean zIsEmpty = TextUtils.isEmpty(this.f12447o);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f12448p);
        this.f12452u.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f12450s.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f12450s.getParent() == null) {
            addView(this.f12450s);
        }
    }

    public final void j() {
        removeAllViews();
        ViewGroup viewGroup = this.f12690e;
        if (viewGroup != null) {
            viewGroup.removeView(this.f12688c);
        }
        this.r = null;
        this.f12688c = null;
        this.A = false;
        this.f12689d = null;
    }

    @Override // stepos.support.v7.widget.a, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        if (this.f12691j) {
            setSplitToolbar(getContext().getResources().getBoolean(R.bool.stepos_split_action_bar_is_narrow));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f12689d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.j();
            ActionMenuPresenter.c cVar = this.f12689d.E;
            if (cVar != null) {
                cVar.h();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f12447o);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        boolean zB = g0.b(this);
        int paddingRight = zB ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f12449q;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12449q.getLayoutParams();
            int i14 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i16 = zB ? paddingRight - i14 : paddingRight + i14;
            int iD = stepos.support.v7.widget.a.d(i16, paddingTop, paddingTop2, this.f12449q, zB) + i16;
            paddingRight = zB ? iD - i15 : iD + i15;
        }
        LinearLayout linearLayout = this.f12450s;
        if (linearLayout != null && this.r == null && linearLayout.getVisibility() != 8) {
            paddingRight += stepos.support.v7.widget.a.d(paddingRight, paddingTop, paddingTop2, this.f12450s, zB);
        }
        View view2 = this.r;
        if (view2 != null) {
            stepos.support.v7.widget.a.d(paddingRight, paddingTop, paddingTop2, view2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f12688c;
        if (actionMenuView == null || actionMenuView.getParent() != this) {
            return;
        }
        stepos.support.v7.widget.a.d(paddingLeft, paddingTop, paddingTop2, this.f12688c, !zB);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = this.f12692k;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i11);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f12449q;
        if (view != null) {
            int iC = stepos.support.v7.widget.a.c(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12449q.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f12688c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = stepos.support.v7.widget.a.c(this.f12688c, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f12450s;
        if (linearLayout != null && this.r == null) {
            if (this.f12455x) {
                this.f12450s.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f12450s.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f12450s.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = stepos.support.v7.widget.a.c(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.r;
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
            this.r.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(iMin, i15));
        }
        if (this.f12692k > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            int measuredHeight = getChildAt(i17).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i16) {
                i16 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i16);
    }

    @Override // stepos.support.v7.widget.a
    public void setContentHeight(int i10) {
        this.f12692k = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.r;
        if (view2 != null) {
            removeView(view2);
        }
        this.r = view;
        if (view != null && (linearLayout = this.f12450s) != null) {
            removeView(linearLayout);
            this.f12450s = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    @Override // stepos.support.v7.widget.a
    public void setSplitToolbar(boolean z) {
        if (this.h != z) {
            if (this.f12689d != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!z) {
                    ActionMenuView actionMenuView = (ActionMenuView) this.f12689d.i(this);
                    this.f12688c = actionMenuView;
                    actionMenuView.setBackgroundDrawable(null);
                    ViewGroup viewGroup = (ViewGroup) this.f12688c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f12688c);
                    }
                    addView(this.f12688c, layoutParams);
                } else if (this.f12690e != null) {
                    this.f12689d.n(getContext().getResources().getDisplayMetrics().widthPixels);
                    this.f12689d.m();
                    layoutParams.width = -1;
                    layoutParams.height = this.f12692k;
                    ActionMenuView actionMenuView2 = (ActionMenuView) this.f12689d.i(this);
                    this.f12688c = actionMenuView2;
                    ViewGroup viewGroup2 = (ViewGroup) actionMenuView2.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.f12688c);
                    }
                    this.f12690e.addView(this.f12688c, layoutParams);
                }
            }
            super.setSplitToolbar(z);
        }
    }

    @Override // stepos.support.v7.widget.a
    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup viewGroup) {
        super.setSplitView(viewGroup);
    }

    @Override // stepos.support.v7.widget.a
    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f12448p = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f12447o = charSequence;
        i();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f12455x) {
            requestLayout();
        }
        this.f12455x = z;
    }

    @Override // stepos.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
