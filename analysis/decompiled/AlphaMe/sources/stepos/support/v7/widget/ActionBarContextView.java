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
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C0189a;
import androidx.appcompat.widget.ViewOnClickListenerC0193c;
import com.stepos.alphame.R;
import g.AbstractC0560a;
import j.C0622a;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
public class ActionBarContextView extends AbstractC0881a {

    /* renamed from: A, reason: collision with root package name */
    public static final Interpolator f14712A;

    /* renamed from: B, reason: collision with root package name */
    public static final Interpolator f14713B;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f14714l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f14715m;

    /* renamed from: n, reason: collision with root package name */
    public View f14716n;

    /* renamed from: o, reason: collision with root package name */
    public View f14717o;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f14718p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f14719q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f14720r;

    /* renamed from: s, reason: collision with root package name */
    public final int f14721s;

    /* renamed from: t, reason: collision with root package name */
    public final int f14722t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14723u;

    /* renamed from: v, reason: collision with root package name */
    public final int f14724v;

    /* renamed from: w, reason: collision with root package name */
    public int f14725w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f14726x;

    /* renamed from: y, reason: collision with root package name */
    public final C0189a f14727y;

    /* renamed from: z, reason: collision with root package name */
    public K.e0 f14728z;

    static {
        Interpolator interpolatorB = M.a.b(0.2f, 0.028f, 0.1f, 1.0f);
        f14712A = interpolatorB;
        f14713B = interpolatorB;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet);
        this.f14727y = new C0189a(this, 4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12591d, R.attr.steposActionModeStyleFullScreen, 0);
        setBackgroundDrawable((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : Z2.I.o(context, resourceId));
        this.f14721s = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f14722t = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f15059h = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f14724v = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void f(boolean z4) {
        (z4 ? e(0, 200L) : e(8, 100L)).g();
        if (this.f15057f || this.f14726x) {
            int i4 = z4 ? 0 : 8;
            K.e0 e0Var = this.f14728z;
            if (e0Var != null) {
                e0Var.b();
            }
            this.f14725w = i4 == 0 ? 1 : 2;
            View childAt = this.f15056e.getChildAt(0);
            if (childAt.getId() == R.id.stepos_nested_bottom_divider) {
                childAt = this.f15056e.getChildAt(1);
            }
            ViewGroup viewGroup = this.f15056e;
            ViewGroup viewGroup2 = viewGroup != null ? (ViewGroup) childAt : null;
            ViewGroup viewGroup3 = viewGroup == null ? this.f15054c : (viewGroup2 == null || viewGroup2 == this.f15054c || viewGroup2.getChildCount() <= 0) ? this.f15056e : this.f15054c;
            if (viewGroup3 == null) {
                this.f14725w = 0;
                return;
            }
            if (i4 == 0) {
                ViewTreeObserver viewTreeObserver = viewGroup3.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC0883c(this, viewGroup3, i4));
                    return;
                }
                return;
            }
            float height = viewGroup3.getHeight();
            K.e0 e0VarA = K.S.a(viewGroup3);
            e0VarA.h(height);
            e0VarA.c(260L);
            C0189a c0189a = this.f14727y;
            ((ActionBarContextView) c0189a.f3051d).f14728z = e0VarA;
            c0189a.f3050c = i4;
            e0VarA.e(c0189a);
            e0VarA.d(f14713B);
            e0VarA.g();
        }
    }

    public final void g(K3.c cVar) {
        View view = this.f14716n;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f14724v, (ViewGroup) this, false);
            this.f14716n = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f14716n);
        }
        this.f14716n.findViewById(R.id.action_mode_close_button).setOnClickListener(new ViewOnClickListenerC0193c(2, this, cVar));
        L3.k kVar = (L3.k) cVar.e();
        C0897q c0897q = this.f15055d;
        if (c0897q != null) {
            c0897q.j();
            C0891k c0891k = c0897q.f15111B;
            if (c0891k != null) {
                c0891k.b();
            }
        }
        C0897q c0897q2 = new C0897q(getContext());
        this.f15055d = c0897q2;
        c0897q2.f15128m = true;
        c0897q2.f15129n = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        boolean z4 = this.f15057f;
        Context context = this.f15053b;
        if (!z4) {
            kVar.b(this.f15055d, context);
            ActionMenuView actionMenuView = (ActionMenuView) this.f15055d.i(this);
            this.f15054c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f15054c, layoutParams);
            return;
        }
        this.f15055d.n(getContext().getResources().getDisplayMetrics().widthPixels - (C0622a.c(getContext()).f() * 2));
        this.f15055d.m();
        this.f15055d.l(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        kVar.b(this.f15055d, context);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f15055d.i(this);
        this.f15054c = actionMenuView2;
        actionMenuView2.setId(R.id.stepos_action_mode_menu_view);
        ViewGroup viewGroup = this.f15056e;
        if (viewGroup != null) {
            viewGroup.addView(this.f15054c, layoutParams);
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
        return this.f15060i != null ? this.f15052a.f3050c : getVisibility();
    }

    public int getContentHeight() {
        return this.f15059h;
    }

    public View getCustomView() {
        return this.f14717o;
    }

    public CharSequence getSubtitle() {
        return this.f14715m;
    }

    public CharSequence getTitle() {
        return this.f14714l;
    }

    public final void h(stepos.support.v7.app.L l4) {
        this.f14726x = true;
        L3.k kVar = l4.f14294f;
        C0897q c0897q = this.f15055d;
        if (c0897q != null) {
            c0897q.j();
            C0891k c0891k = c0897q.f15111B;
            if (c0891k != null) {
                c0891k.b();
            }
        }
        C0897q c0897q2 = new C0897q(getContext());
        this.f15055d = c0897q2;
        c0897q2.f15128m = true;
        c0897q2.f15129n = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        ViewGroup viewGroup = this.f15056e;
        Context context = this.f15053b;
        if (viewGroup == null) {
            kVar.b(this.f15055d, context);
            ActionMenuView actionMenuView = (ActionMenuView) this.f15055d.i(this);
            this.f15054c = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f15054c, layoutParams);
            return;
        }
        this.f15055d.n(getContext().getResources().getDisplayMetrics().widthPixels - (C0622a.c(getContext()).f() * 2));
        this.f15055d.m();
        this.f15055d.l(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        kVar.b(this.f15055d, context);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f15055d.i(this);
        this.f15054c = actionMenuView2;
        actionMenuView2.setId(R.id.stepos_action_mode_menu_view);
        this.f15056e.addView(this.f15054c, layoutParams);
    }

    public final void i() {
        if (this.f14718p == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.stepos_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f14718p = linearLayout;
            this.f14719q = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f14720r = (TextView) this.f14718p.findViewById(R.id.action_bar_subtitle);
            int i4 = this.f14721s;
            if (i4 != 0) {
                this.f14719q.setTextAppearance(getContext(), i4);
            }
            int i5 = this.f14722t;
            if (i5 != 0) {
                this.f14720r.setTextAppearance(getContext(), i5);
            }
        }
        this.f14719q.setText(this.f14714l);
        this.f14720r.setText(this.f14715m);
        boolean z4 = !TextUtils.isEmpty(this.f14714l);
        boolean z5 = !TextUtils.isEmpty(this.f14715m);
        this.f14720r.setVisibility(z5 ? 0 : 8);
        this.f14718p.setVisibility((z4 || z5) ? 0 : 8);
        if (this.f14718p.getParent() == null) {
            addView(this.f14718p);
        }
    }

    public final void j() {
        removeAllViews();
        ViewGroup viewGroup = this.f15056e;
        if (viewGroup != null) {
            viewGroup.removeView(this.f15054c);
        }
        this.f14717o = null;
        this.f15054c = null;
        this.f14726x = false;
        this.f15055d = null;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        if (this.f15058g) {
            setSplitToolbar(getContext().getResources().getBoolean(R.bool.stepos_split_action_bar_is_narrow));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0897q c0897q = this.f15055d;
        if (c0897q != null) {
            c0897q.j();
            C0891k c0891k = this.f15055d.f15111B;
            if (c0891k != null) {
                c0891k.b();
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
        accessibilityEvent.setContentDescription(this.f14714l);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        boolean zB = y0.b(this);
        int paddingRight = zB ? (i6 - i4) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
        View view = this.f14716n;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f14716n.getLayoutParams();
            int i8 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i9 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i10 = zB ? paddingRight - i8 : paddingRight + i8;
            int iD = AbstractC0881a.d(i10, paddingTop, paddingTop2, this.f14716n, zB) + i10;
            paddingRight = zB ? iD - i9 : iD + i9;
        }
        LinearLayout linearLayout = this.f14718p;
        if (linearLayout != null && this.f14717o == null && linearLayout.getVisibility() != 8) {
            paddingRight += AbstractC0881a.d(paddingRight, paddingTop, paddingTop2, this.f14718p, zB);
        }
        View view2 = this.f14717o;
        if (view2 != null) {
            AbstractC0881a.d(paddingRight, paddingTop, paddingTop2, view2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i6 - i4) - getPaddingRight();
        ActionMenuView actionMenuView = this.f15054c;
        if (actionMenuView == null || actionMenuView.getParent() != this) {
            return;
        }
        AbstractC0881a.d(paddingLeft, paddingTop, paddingTop2, this.f15054c, !zB);
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        if (View.MeasureSpec.getMode(i4) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i5) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i4);
        int size2 = this.f15059h;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i5);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f14716n;
        if (view != null) {
            int iC = AbstractC0881a.c(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f14716n.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f15054c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = AbstractC0881a.c(this.f15054c, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f14718p;
        if (linearLayout != null && this.f14717o == null) {
            if (this.f14723u) {
                this.f14718p.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f14718p.getMeasuredWidth();
                boolean z4 = measuredWidth <= paddingLeft;
                if (z4) {
                    paddingLeft -= measuredWidth;
                }
                this.f14718p.setVisibility(z4 ? 0 : 8);
            } else {
                paddingLeft = AbstractC0881a.c(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f14717o;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i6 = layoutParams.width;
            int i7 = i6 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i6 >= 0) {
                paddingLeft = Math.min(i6, paddingLeft);
            }
            int i8 = layoutParams.height;
            int i9 = i8 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i8 >= 0) {
                iMin = Math.min(i8, iMin);
            }
            this.f14717o.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i7), View.MeasureSpec.makeMeasureSpec(iMin, i9));
        }
        if (this.f15059h > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i10) {
                i10 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i10);
    }

    public void setContentHeight(int i4) {
        this.f15059h = i4;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f14717o;
        if (view2 != null) {
            removeView(view2);
        }
        this.f14717o = view;
        if (view != null && (linearLayout = this.f14718p) != null) {
            removeView(linearLayout);
            this.f14718p = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSplitToolbar(boolean z4) {
        if (this.f15057f != z4) {
            if (this.f15055d != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!z4) {
                    ActionMenuView actionMenuView = (ActionMenuView) this.f15055d.i(this);
                    this.f15054c = actionMenuView;
                    actionMenuView.setBackgroundDrawable(null);
                    ViewGroup viewGroup = (ViewGroup) this.f15054c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f15054c);
                    }
                    addView(this.f15054c, layoutParams);
                } else if (this.f15056e != null) {
                    this.f15055d.n(getContext().getResources().getDisplayMetrics().widthPixels);
                    this.f15055d.m();
                    layoutParams.width = -1;
                    layoutParams.height = this.f15059h;
                    ActionMenuView actionMenuView2 = (ActionMenuView) this.f15055d.i(this);
                    this.f15054c = actionMenuView2;
                    ViewGroup viewGroup2 = (ViewGroup) actionMenuView2.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.f15054c);
                    }
                    this.f15056e.addView(this.f15054c, layoutParams);
                }
            }
            this.f15057f = z4;
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f15056e = viewGroup;
    }

    public void setSplitWhenNarrow(boolean z4) {
        this.f15058g = z4;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f14715m = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f14714l = charSequence;
        i();
    }

    public void setTitleOptional(boolean z4) {
        if (z4 != this.f14723u) {
            requestLayout();
        }
        this.f14723u = z4;
    }

    @Override // stepos.support.v7.widget.AbstractC0881a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i4) {
        super.setVisibility(i4);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
