package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.animation.PathInterpolatorCompat;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes4.dex */
public class ActionBarContextView extends AbstractC1979b {

    /* renamed from: A, reason: collision with root package name */
    public static final Interpolator f6404A;

    /* renamed from: B, reason: collision with root package name */
    public static final Interpolator f6405B;
    public CharSequence l;
    public CharSequence m;
    public View n;
    public View o;
    public LinearLayout p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f6406q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f6407r;

    /* renamed from: s, reason: collision with root package name */
    public final int f6408s;

    /* renamed from: t, reason: collision with root package name */
    public final int f6409t;
    public boolean u;

    /* renamed from: v, reason: collision with root package name */
    public final int f6410v;

    /* renamed from: w, reason: collision with root package name */
    public int f6411w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6412x;
    public final C4.a y;

    /* renamed from: z, reason: collision with root package name */
    public ViewPropertyAnimatorCompat f6413z;

    static {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.2f, 0.028f, 0.1f, 1.0f);
        f6404A = interpolatorCreate;
        f6405B = interpolatorCreate;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new C4.a(this);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.ActionMode, com.stepos.ability.R.attr.steposActionModeStyleFullScreen, 0);
        setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionMode_background));
        this.f6408s = tintTypedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.f6409t = tintTypedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.h = tintTypedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.f6410v = tintTypedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    public final void f(boolean z10) {
        (z10 ? e(0, 200L) : e(8, 100L)).start();
        if (this.f || this.f6412x) {
            int i = z10 ? 0 : 8;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f6413z;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            this.f6411w = i == 0 ? 1 : 2;
            View childAt = this.e.getChildAt(0);
            if (childAt.getId() == com.stepos.ability.R.id.stepos_nested_bottom_divider) {
                childAt = this.e.getChildAt(1);
            }
            ViewGroup viewGroup = this.e;
            ViewGroup viewGroup2 = viewGroup != null ? (ViewGroup) childAt : null;
            ViewGroup viewGroup3 = viewGroup == null ? this.c : (viewGroup2 == null || viewGroup2 == this.c || viewGroup2.getChildCount() <= 0) ? this.e : this.c;
            if (viewGroup3 == null) {
                this.f6411w = 0;
                return;
            }
            if (i == 0) {
                ViewTreeObserver viewTreeObserver = viewGroup3.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1985e(this, viewGroup3, i));
                    return;
                }
                return;
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatTranslationY = ViewCompat.animate(viewGroup3).translationY(viewGroup3.getHeight());
            viewPropertyAnimatorCompatTranslationY.setDuration(260L);
            C4.a aVar = this.y;
            ((ActionBarContextView) aVar.c).f6413z = viewPropertyAnimatorCompatTranslationY;
            viewPropertyAnimatorCompatTranslationY.setListener(aVar);
            viewPropertyAnimatorCompatTranslationY.setInterpolator(f6405B);
            viewPropertyAnimatorCompatTranslationY.start();
        }
    }

    public final void g(Ua.c cVar) {
        View view = this.n;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f6410v, (ViewGroup) this, false);
            this.n = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.n);
        }
        this.n.findViewById(R.id.action_mode_close_button).setOnClickListener(new ViewOnClickListenerC1983d(cVar, 0));
        Va.n nVarC = cVar.c();
        C2005u c2005u = this.d;
        if (c2005u != null) {
            c2005u.h();
            C1999n c1999n = c2005u.f6632B;
            if (c1999n != null) {
                c1999n.e();
            }
        }
        C2005u c2005u2 = new C2005u(getContext());
        this.d = c2005u2;
        c2005u2.m = true;
        c2005u2.n = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        boolean z10 = this.f;
        Context context = this.b;
        if (!z10) {
            nVarC.b(this.d, context);
            ActionMenuView actionMenuView = (ActionMenuView) this.d.g(this);
            this.c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.c, layoutParams);
            return;
        }
        this.d.l(getContext().getResources().getDisplayMetrics().widthPixels - (Ua.a.a(getContext()).b() * 2), true);
        this.d.k(Integer.MAX_VALUE);
        this.d.j(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        nVarC.b(this.d, context);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.d.g(this);
        this.c = actionMenuView2;
        actionMenuView2.setId(com.stepos.ability.R.id.stepos_action_mode_menu_view);
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            viewGroup.addView(this.c, layoutParams);
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

    public int getAnimatedVisibility() {
        return this.i != null ? this.f6601a.c : getVisibility();
    }

    public int getContentHeight() {
        return this.h;
    }

    public View getCustomView() {
        return this.o;
    }

    public CharSequence getSubtitle() {
        return this.m;
    }

    public CharSequence getTitle() {
        return this.l;
    }

    public final void h(Ua.c cVar) {
        this.f6412x = true;
        Va.n nVarC = cVar.c();
        C2005u c2005u = this.d;
        if (c2005u != null) {
            c2005u.h();
            C1999n c1999n = c2005u.f6632B;
            if (c1999n != null) {
                c1999n.e();
            }
        }
        C2005u c2005u2 = new C2005u(getContext());
        this.d = c2005u2;
        c2005u2.m = true;
        c2005u2.n = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        ViewGroup viewGroup = this.e;
        Context context = this.b;
        if (viewGroup == null) {
            nVarC.b(this.d, context);
            ActionMenuView actionMenuView = (ActionMenuView) this.d.g(this);
            this.c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.c, layoutParams);
            return;
        }
        this.d.l(getContext().getResources().getDisplayMetrics().widthPixels - (Ua.a.a(getContext()).b() * 2), true);
        this.d.k(Integer.MAX_VALUE);
        this.d.j(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        nVarC.b(this.d, context);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.d.g(this);
        this.c = actionMenuView2;
        actionMenuView2.setId(com.stepos.ability.R.id.stepos_action_mode_menu_view);
        this.e.addView(this.c, layoutParams);
    }

    public final void i() {
        if (this.p == null) {
            LayoutInflater.from(getContext()).inflate(com.stepos.ability.R.layout.stepos_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.p = linearLayout;
            this.f6406q = (TextView) linearLayout.findViewById(com.stepos.ability.R.id.action_bar_title);
            this.f6407r = (TextView) this.p.findViewById(com.stepos.ability.R.id.action_bar_subtitle);
            int i = this.f6408s;
            if (i != 0) {
                this.f6406q.setTextAppearance(getContext(), i);
            }
            int i6 = this.f6409t;
            if (i6 != 0) {
                this.f6407r.setTextAppearance(getContext(), i6);
            }
        }
        this.f6406q.setText(this.l);
        this.f6407r.setText(this.m);
        boolean zIsEmpty = TextUtils.isEmpty(this.l);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.m);
        this.f6407r.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.p.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.p.getParent() == null) {
            addView(this.p);
        }
    }

    public final void j() {
        removeAllViews();
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            viewGroup.removeView(this.c);
        }
        this.o = null;
        this.c = null;
        this.f6412x = false;
        this.d = null;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        if (this.g) {
            setSplitToolbar(getContext().getResources().getBoolean(com.stepos.ability.R.bool.stepos_split_action_bar_is_narrow));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C2005u c2005u = this.d;
        if (c2005u != null) {
            c2005u.h();
            C1999n c1999n = this.d.f6632B;
            if (c1999n != null) {
                c1999n.e();
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
        accessibilityEvent.setContentDescription(this.l);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        boolean zB = I0.b(this);
        int paddingRight = zB ? (i10 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i11 - i6) - getPaddingTop()) - getPaddingBottom();
        View view = this.n;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
            int i12 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i13 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i14 = zB ? paddingRight - i12 : paddingRight + i12;
            int iD = AbstractC1979b.d(this.n, i14, paddingTop, paddingTop2, zB) + i14;
            paddingRight = zB ? iD - i13 : iD + i13;
        }
        LinearLayout linearLayout = this.p;
        if (linearLayout != null && this.o == null && linearLayout.getVisibility() != 8) {
            paddingRight += AbstractC1979b.d(this.p, paddingRight, paddingTop, paddingTop2, zB);
        }
        View view2 = this.o;
        if (view2 != null) {
            AbstractC1979b.d(view2, paddingRight, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i10 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView == null || actionMenuView.getParent() != this) {
            return;
        }
        AbstractC1979b.d(this.c, paddingLeft, paddingTop, paddingTop2, !zB);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int mode = View.MeasureSpec.getMode(i);
        int i10 = BasicMeasure.EXACTLY;
        if (mode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i6) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.h;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i6);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.n;
        if (view != null) {
            int iC = AbstractC1979b.c(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = AbstractC1979b.c(this.c, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.p;
        if (linearLayout != null && this.o == null) {
            if (this.u) {
                this.p.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.p.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.p.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = AbstractC1979b.c(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.o;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i11 = layoutParams.width;
            int i12 = i11 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i11 >= 0) {
                paddingLeft = Math.min(i11, paddingLeft);
            }
            int i13 = layoutParams.height;
            if (i13 == -2) {
                i10 = Integer.MIN_VALUE;
            }
            if (i13 >= 0) {
                iMin = Math.min(i13, iMin);
            }
            this.o.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i12), View.MeasureSpec.makeMeasureSpec(iMin, i10));
        }
        if (this.h > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            int measuredHeight = getChildAt(i15).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i14) {
                i14 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i14);
    }

    public void setContentHeight(int i) {
        this.h = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.o;
        if (view2 != null) {
            removeView(view2);
        }
        this.o = view;
        if (view != null && (linearLayout = this.p) != null) {
            removeView(linearLayout);
            this.p = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSplitToolbar(boolean z10) {
        if (this.f != z10) {
            if (this.d != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!z10) {
                    ActionMenuView actionMenuView = (ActionMenuView) this.d.g(this);
                    this.c = actionMenuView;
                    actionMenuView.setBackgroundDrawable(null);
                    ViewGroup viewGroup = (ViewGroup) this.c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.c);
                    }
                    addView(this.c, layoutParams);
                } else if (this.e != null) {
                    this.d.l(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.d.k(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.h;
                    ActionMenuView actionMenuView2 = (ActionMenuView) this.d.g(this);
                    this.c = actionMenuView2;
                    ViewGroup viewGroup2 = (ViewGroup) actionMenuView2.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.c);
                    }
                    this.e.addView(this.c, layoutParams);
                }
            }
            this.f = z10;
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.e = viewGroup;
    }

    public void setSplitWhenNarrow(boolean z10) {
        this.g = z10;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.m = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.l = charSequence;
        i();
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.u) {
            requestLayout();
        }
        this.u = z10;
    }

    @Override // stepos.support.v7.widget.AbstractC1979b, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
