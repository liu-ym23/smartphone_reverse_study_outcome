package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ActionBarContextView extends a {
    public static final PathInterpolator E;
    public static final PathInterpolator F;
    public int A;
    public boolean B;
    public final l3.d C;
    public n3.o0 D;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f12564p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f12565q;

    /* renamed from: r, reason: collision with root package name */
    public View f12566r;

    /* renamed from: s, reason: collision with root package name */
    public View f12567s;

    /* renamed from: t, reason: collision with root package name */
    public LinearLayout f12568t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f12569u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f12570v;

    /* renamed from: w, reason: collision with root package name */
    public final int f12571w;

    /* renamed from: x, reason: collision with root package name */
    public final int f12572x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12573y;

    /* renamed from: z, reason: collision with root package name */
    public final int f12574z;

    static {
        PathInterpolator pathInterpolator = new PathInterpolator(0.2f, 0.028f, 0.1f, 1.0f);
        E = pathInterpolator;
        F = pathInterpolator;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        super(context, attributeSet, i);
        m.a aVar = new m.a(1);
        aVar.f7866h = this;
        aVar.f7864f = false;
        VarHandle.storeStoreFence();
        this.f12708c = aVar;
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f12709f = context;
        } else {
            this.f12709f = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        l3.d dVar = new l3.d();
        dVar.f7721f = this;
        dVar.f7720c = false;
        VarHandle.storeStoreFence();
        this.C = dVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f4101d, i, 0);
        setBackgroundDrawable((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : id.k.v(resourceId, context));
        this.f12571w = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f12572x = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f12714l = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f12574z = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void f(boolean z10) {
        (z10 ? e(0, 200L) : e(8, 100L)).g();
        if (this.f12712j || this.B) {
            char c9 = z10 ? (char) 0 : '\b';
            n3.o0 o0Var = this.D;
            if (o0Var != null) {
                o0Var.b();
            }
            this.A = c9 == 0 ? 1 : 2;
            View childAt = this.i.getChildAt(0);
            if (childAt.getId() == R.id.stepos_nested_bottom_divider) {
                childAt = this.i.getChildAt(1);
            }
            ViewGroup viewGroup = this.i;
            ViewGroup viewGroup2 = viewGroup != null ? (ViewGroup) childAt : null;
            ViewGroup viewGroup3 = viewGroup == null ? this.f12710g : (viewGroup2 == null || viewGroup2 == this.f12710g || viewGroup2.getChildCount() <= 0) ? this.i : this.f12710g;
            if (viewGroup3 == null) {
                this.A = 0;
                return;
            }
            if (c9 == 0) {
                ViewTreeObserver viewTreeObserver = viewGroup3.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    c cVar = new c();
                    cVar.f12735f = this;
                    cVar.f12734c = viewGroup3;
                    VarHandle.storeStoreFence();
                    viewTreeObserver.addOnPreDrawListener(cVar);
                    return;
                }
                return;
            }
            float height = viewGroup3.getHeight();
            n3.o0 o0VarA = n3.k0.a(viewGroup3);
            o0VarA.h(height);
            o0VarA.c(260L);
            l3.d dVar = this.C;
            ((ActionBarContextView) dVar.f7721f).D = o0VarA;
            o0VarA.e(dVar);
            o0VarA.d(F);
            o0VarA.g();
        }
    }

    public final void g(se.b bVar) {
        Context context = this.f12709f;
        View view = this.f12566r;
        int i = 0;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f12574z, (ViewGroup) this, false);
            this.f12566r = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f12566r);
        }
        View viewFindViewById = this.f12566r.findViewById(R.id.action_mode_close_button);
        b bVar2 = new b(i);
        bVar2.f12726f = bVar;
        VarHandle.storeStoreFence();
        viewFindViewById.setOnClickListener(bVar2);
        te.l lVarE = bVar.e();
        q qVar = this.f12711h;
        if (qVar != null) {
            qVar.j();
            l lVar = qVar.F;
            if (lVar != null) {
                lVar.h();
            }
        }
        q qVar2 = new q(getContext());
        this.f12711h = qVar2;
        qVar2.f12812q = true;
        qVar2.f12813r = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (!this.f12712j) {
            lVarE.b(this.f12711h, context);
            ActionMenuView actionMenuView = (ActionMenuView) this.f12711h.i(this);
            this.f12710g = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f12710g, layoutParams);
            return;
        }
        this.f12711h.n(getContext().getResources().getDisplayMetrics().widthPixels - (a4.n.c(getContext()).d() * 2));
        this.f12711h.m();
        this.f12711h.l(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        lVarE.b(this.f12711h, context);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f12711h.i(this);
        this.f12710g = actionMenuView2;
        actionMenuView2.setId(R.id.stepos_action_mode_menu_view);
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.addView(this.f12710g, layoutParams);
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
        return this.f12715m != null ? this.f12708c.f7865g : getVisibility();
    }

    public int getContentHeight() {
        return this.f12714l;
    }

    public View getCustomView() {
        return this.f12567s;
    }

    public CharSequence getSubtitle() {
        return this.f12565q;
    }

    public CharSequence getTitle() {
        return this.f12564p;
    }

    public final void h(se.b bVar) {
        Context context = this.f12709f;
        this.B = true;
        te.l lVarE = bVar.e();
        q qVar = this.f12711h;
        if (qVar != null) {
            qVar.j();
            l lVar = qVar.F;
            if (lVar != null) {
                lVar.h();
            }
        }
        q qVar2 = new q(getContext());
        this.f12711h = qVar2;
        qVar2.f12812q = true;
        qVar2.f12813r = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (this.i == null) {
            lVarE.b(this.f12711h, context);
            ActionMenuView actionMenuView = (ActionMenuView) this.f12711h.i(this);
            this.f12710g = actionMenuView;
            actionMenuView.setBackgroundDrawable(null);
            addView(this.f12710g, layoutParams);
            return;
        }
        this.f12711h.n(getContext().getResources().getDisplayMetrics().widthPixels - (a4.n.c(getContext()).d() * 2));
        this.f12711h.m();
        this.f12711h.l(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        lVarE.b(this.f12711h, context);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.f12711h.i(this);
        this.f12710g = actionMenuView2;
        actionMenuView2.setId(R.id.stepos_action_mode_menu_view);
        this.i.addView(this.f12710g, layoutParams);
    }

    public final void i() {
        if (this.f12568t == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.stepos_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f12568t = linearLayout;
            this.f12569u = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f12570v = (TextView) this.f12568t.findViewById(R.id.action_bar_subtitle);
            int i = this.f12571w;
            if (i != 0) {
                this.f12569u.setTextAppearance(getContext(), i);
            }
            int i3 = this.f12572x;
            if (i3 != 0) {
                this.f12570v.setTextAppearance(getContext(), i3);
            }
        }
        this.f12569u.setText(this.f12564p);
        this.f12570v.setText(this.f12565q);
        boolean zIsEmpty = TextUtils.isEmpty(this.f12564p);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f12565q);
        this.f12570v.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f12568t.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f12568t.getParent() == null) {
            addView(this.f12568t);
        }
    }

    public final void j() {
        removeAllViews();
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.removeView(this.f12710g);
        }
        this.f12567s = null;
        this.f12710g = null;
        this.B = false;
        this.f12711h = null;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        if (this.f12713k) {
            setSplitToolbar(getContext().getResources().getBoolean(R.bool.stepos_split_action_bar_is_narrow));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q qVar = this.f12711h;
        if (qVar != null) {
            qVar.j();
            l lVar = this.f12711h.F;
            if (lVar != null) {
                lVar.h();
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
        accessibilityEvent.setContentDescription(this.f12564p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        boolean zB = x1.b(this);
        int paddingRight = zB ? (i10 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i11 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f12566r;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12566r.getLayoutParams();
            int i12 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i13 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i14 = zB ? paddingRight - i12 : paddingRight + i12;
            int iD = a.d(this.f12566r, i14, paddingTop, paddingTop2, zB) + i14;
            paddingRight = zB ? iD - i13 : iD + i13;
        }
        LinearLayout linearLayout = this.f12568t;
        if (linearLayout != null && this.f12567s == null && linearLayout.getVisibility() != 8) {
            paddingRight += a.d(this.f12568t, paddingRight, paddingTop, paddingTop2, zB);
        }
        View view2 = this.f12567s;
        if (view2 != null) {
            a.d(view2, paddingRight, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i10 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f12710g;
        if (actionMenuView == null || actionMenuView.getParent() != this) {
            return;
        }
        a.d(this.f12710g, paddingLeft, paddingTop, paddingTop2, !zB);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            od.f.e(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
            return;
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            od.f.e(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f12714l;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i3);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f12566r;
        if (view != null) {
            int iC = a.c(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12566r.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f12710g;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = a.c(this.f12710g, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f12568t;
        if (linearLayout != null && this.f12567s == null) {
            if (this.f12573y) {
                this.f12568t.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f12568t.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f12568t.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = a.c(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f12567s;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i10 = layoutParams.width;
            int i11 = i10 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i10 >= 0) {
                paddingLeft = Math.min(i10, paddingLeft);
            }
            int i12 = layoutParams.height;
            int i13 = i12 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i12 >= 0) {
                iMin = Math.min(i12, iMin);
            }
            this.f12567s.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i11), View.MeasureSpec.makeMeasureSpec(iMin, i13));
        }
        if (this.f12714l > 0) {
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
        this.f12714l = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f12567s;
        if (view2 != null) {
            removeView(view2);
        }
        this.f12567s = view;
        if (view != null && (linearLayout = this.f12568t) != null) {
            removeView(linearLayout);
            this.f12568t = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSplitToolbar(boolean z10) {
        if (this.f12712j != z10) {
            if (this.f12711h != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!z10) {
                    ActionMenuView actionMenuView = (ActionMenuView) this.f12711h.i(this);
                    this.f12710g = actionMenuView;
                    actionMenuView.setBackgroundDrawable(null);
                    ViewGroup viewGroup = (ViewGroup) this.f12710g.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f12710g);
                    }
                    addView(this.f12710g, layoutParams);
                } else if (this.i != null) {
                    this.f12711h.n(getContext().getResources().getDisplayMetrics().widthPixels);
                    this.f12711h.m();
                    layoutParams.width = -1;
                    layoutParams.height = this.f12714l;
                    ActionMenuView actionMenuView2 = (ActionMenuView) this.f12711h.i(this);
                    this.f12710g = actionMenuView2;
                    ViewGroup viewGroup2 = (ViewGroup) actionMenuView2.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.f12710g);
                    }
                    this.i.addView(this.f12710g, layoutParams);
                }
            }
            this.f12712j = z10;
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.i = viewGroup;
    }

    public void setSplitWhenNarrow(boolean z10) {
        this.f12713k = z10;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f12565q = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f12564p = charSequence;
        i();
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f12573y) {
            requestLayout();
        }
        this.f12573y = z10;
    }

    @Override // stepos.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.steposActionModeStyleFullScreen);
    }
}
