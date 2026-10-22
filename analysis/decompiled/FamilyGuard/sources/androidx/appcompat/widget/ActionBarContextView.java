package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import g.C0728a;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0431a {

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f8016i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f8017j;

    /* renamed from: k, reason: collision with root package name */
    private View f8018k;

    /* renamed from: l, reason: collision with root package name */
    private View f8019l;

    /* renamed from: m, reason: collision with root package name */
    private View f8020m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f8021n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f8022o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f8023p;

    /* renamed from: q, reason: collision with root package name */
    private int f8024q;

    /* renamed from: r, reason: collision with root package name */
    private int f8025r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8026s;

    /* renamed from: t, reason: collision with root package name */
    private int f8027t;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f8028a;

        a(androidx.appcompat.view.b bVar) {
            this.f8028a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f8028a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.f8021n == null) {
            LayoutInflater.from(getContext()).inflate(g.g.f16945a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f8021n = linearLayout;
            this.f8022o = (TextView) linearLayout.findViewById(g.f.f16923e);
            this.f8023p = (TextView) this.f8021n.findViewById(g.f.f16922d);
            if (this.f8024q != 0) {
                this.f8022o.setTextAppearance(getContext(), this.f8024q);
            }
            if (this.f8025r != 0) {
                this.f8023p.setTextAppearance(getContext(), this.f8025r);
            }
        }
        this.f8022o.setText(this.f8016i);
        this.f8023p.setText(this.f8017j);
        boolean zIsEmpty = TextUtils.isEmpty(this.f8016i);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f8017j);
        this.f8023p.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f8021n.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f8021n.getParent() == null) {
            addView(this.f8021n);
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0431a
    public /* bridge */ /* synthetic */ androidx.core.view.S f(int i5, long j5) {
        return super.f(i5, j5);
    }

    public void g() {
        if (this.f8018k == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbstractC0431a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbstractC0431a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f8017j;
    }

    public CharSequence getTitle() {
        return this.f8016i;
    }

    public void h(androidx.appcompat.view.b bVar) {
        View view = this.f8018k;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f8027t, (ViewGroup) this, false);
            this.f8018k = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f8018k);
        }
        View viewFindViewById = this.f8018k.findViewById(g.f.f16927i);
        this.f8019l = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) bVar.e();
        C0433c c0433c = this.f8470d;
        if (c0433c != null) {
            c0433c.y();
        }
        C0433c c0433c2 = new C0433c(getContext());
        this.f8470d = c0433c2;
        c0433c2.J(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.c(this.f8470d, this.f8468b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f8470d.o(this);
        this.f8469c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f8469c, layoutParams);
    }

    public boolean j() {
        return this.f8026s;
    }

    public void k() {
        removeAllViews();
        this.f8020m = null;
        this.f8469c = null;
        this.f8470d = null;
        View view = this.f8019l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        C0433c c0433c = this.f8470d;
        if (c0433c != null) {
            return c0433c.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0433c c0433c = this.f8470d;
        if (c0433c != null) {
            c0433c.B();
            this.f8470d.C();
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0431a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        boolean zB = h0.b(this);
        int paddingRight = zB ? (i7 - i5) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
        View view = this.f8018k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8018k.getLayoutParams();
            int i9 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i10 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = AbstractC0431a.d(paddingRight, i9, zB);
            paddingRight = AbstractC0431a.d(iD + e(this.f8018k, iD, paddingTop, paddingTop2, zB), i10, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f8021n;
        if (linearLayout != null && this.f8020m == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f8021n, iE, paddingTop, paddingTop2, zB);
        }
        View view2 = this.f8020m;
        if (view2 != null) {
            e(view2, iE, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i7 - i5) - getPaddingRight();
        ActionMenuView actionMenuView = this.f8469c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        if (View.MeasureSpec.getMode(i5) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i6) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i5);
        int size2 = this.f8471e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i6);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f8018k;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8018k.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f8469c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f8469c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f8021n;
        if (linearLayout != null && this.f8020m == null) {
            if (this.f8026s) {
                this.f8021n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f8021n.getMeasuredWidth();
                boolean z5 = measuredWidth <= paddingLeft;
                if (z5) {
                    paddingLeft -= measuredWidth;
                }
                this.f8021n.setVisibility(z5 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f8020m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i7 = layoutParams.width;
            int i8 = i7 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i7 >= 0) {
                paddingLeft = Math.min(i7, paddingLeft);
            }
            int i9 = layoutParams.height;
            int i10 = i9 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i9 >= 0) {
                iMin = Math.min(i9, iMin);
            }
            this.f8020m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i8), View.MeasureSpec.makeMeasureSpec(iMin, i10));
        }
        if (this.f8471e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i11) {
                i11 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i11);
    }

    @Override // androidx.appcompat.widget.AbstractC0431a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC0431a
    public void setContentHeight(int i5) {
        this.f8471e = i5;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f8020m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f8020m = view;
        if (view != null && (linearLayout = this.f8021n) != null) {
            removeView(linearLayout);
            this.f8021n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f8017j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f8016i = charSequence;
        i();
        androidx.core.view.H.m0(this, charSequence);
    }

    public void setTitleOptional(boolean z5) {
        if (z5 != this.f8026s) {
            requestLayout();
        }
        this.f8026s = z5;
    }

    @Override // androidx.appcompat.widget.AbstractC0431a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i5) {
        super.setVisibility(i5);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16835l);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        a0 a0VarV = a0.v(context, attributeSet, g.j.f17214y, i5, 0);
        setBackground(a0VarV.g(g.j.f17219z));
        this.f8024q = a0VarV.n(g.j.f16997D, 0);
        this.f8025r = a0VarV.n(g.j.f16992C, 0);
        this.f8471e = a0VarV.m(g.j.f16987B, 0);
        this.f8027t = a0VarV.n(g.j.f16982A, g.g.f16948d);
        a0VarV.x();
    }
}
