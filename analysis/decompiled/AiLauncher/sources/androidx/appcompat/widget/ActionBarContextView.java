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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import i.AbstractC4156b;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC1288a {

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f8726i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f8727j;

    /* renamed from: k, reason: collision with root package name */
    public View f8728k;

    /* renamed from: l, reason: collision with root package name */
    public View f8729l;

    /* renamed from: m, reason: collision with root package name */
    public View f8730m;

    /* renamed from: n, reason: collision with root package name */
    public LinearLayout f8731n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f8732o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f8733p;

    /* renamed from: q, reason: collision with root package name */
    public int f8734q;

    /* renamed from: r, reason: collision with root package name */
    public int f8735r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8736s;

    /* renamed from: t, reason: collision with root package name */
    public int f8737t;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC4156b f8738a;

        public a(AbstractC4156b abstractC4156b) {
            this.f8738a = abstractC4156b;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f8738a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AbstractC1288a
    public /* bridge */ /* synthetic */ androidx.core.view.U f(int i10, long j10) {
        return super.f(i10, j10);
    }

    public void g() {
        if (this.f8728k == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbstractC1288a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbstractC1288a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f8727j;
    }

    public CharSequence getTitle() {
        return this.f8726i;
    }

    public void h(AbstractC4156b abstractC4156b) {
        View view = this.f8728k;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f8737t, (ViewGroup) this, false);
            this.f8728k = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f8728k);
        }
        View viewFindViewById = this.f8728k.findViewById(R$id.action_mode_close_button);
        this.f8729l = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(abstractC4156b));
        androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) abstractC4156b.e();
        ActionMenuPresenter actionMenuPresenter = this.f9168d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f9168d = actionMenuPresenter2;
        actionMenuPresenter2.L(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.c(this.f9168d, this.f9166b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f9168d.q(this);
        this.f9167c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f9167c, layoutParams);
    }

    public final void i() {
        if (this.f8731n == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f8731n = linearLayout;
            this.f8732o = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f8733p = (TextView) this.f8731n.findViewById(R$id.action_bar_subtitle);
            if (this.f8734q != 0) {
                this.f8732o.setTextAppearance(getContext(), this.f8734q);
            }
            if (this.f8735r != 0) {
                this.f8733p.setTextAppearance(getContext(), this.f8735r);
            }
        }
        this.f8732o.setText(this.f8726i);
        this.f8733p.setText(this.f8727j);
        boolean zIsEmpty = TextUtils.isEmpty(this.f8726i);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f8727j);
        this.f8733p.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f8731n.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f8731n.getParent() == null) {
            addView(this.f8731n);
        }
    }

    public boolean j() {
        return this.f8736s;
    }

    public void k() {
        removeAllViews();
        this.f8730m = null;
        this.f9167c = null;
        this.f9168d = null;
        View view = this.f8729l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f9168d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.M();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f9168d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.D();
            this.f9168d.E();
        }
    }

    @Override // androidx.appcompat.widget.AbstractC1288a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean zB = b0.b(this);
        int paddingRight = zB ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f8728k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8728k.getLayoutParams();
            int i14 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = AbstractC1288a.d(paddingRight, i14, zB);
            paddingRight = AbstractC1288a.d(iD + e(this.f8728k, iD, paddingTop, paddingTop2, zB), i15, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f8731n;
        if (linearLayout != null && this.f8730m == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f8731n, iE, paddingTop, paddingTop2, zB);
        }
        View view2 = this.f8730m;
        if (view2 != null) {
            e(view2, iE, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f9167c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
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
        int size2 = this.f9169e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i11);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f8728k;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8728k.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f9167c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f9167c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f8731n;
        if (linearLayout != null && this.f8730m == null) {
            if (this.f8736s) {
                this.f8731n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f8731n.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f8731n.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f8730m;
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
            this.f8730m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(iMin, i15));
        }
        if (this.f9169e > 0) {
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

    @Override // androidx.appcompat.widget.AbstractC1288a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC1288a
    public void setContentHeight(int i10) {
        this.f9169e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f8730m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f8730m = view;
        if (view != null && (linearLayout = this.f8731n) != null) {
            removeView(linearLayout);
            this.f8731n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f8727j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f8726i = charSequence;
        i();
        androidx.core.view.N.k0(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f8736s) {
            requestLayout();
        }
        this.f8736s = z10;
    }

    @Override // androidx.appcompat.widget.AbstractC1288a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        U uV = U.v(context, attributeSet, R$styleable.ActionMode, i10, 0);
        setBackground(uV.g(R$styleable.ActionMode_background));
        this.f8734q = uV.n(R$styleable.ActionMode_titleTextStyle, 0);
        this.f8735r = uV.n(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f9169e = uV.m(R$styleable.ActionMode_height, 0);
        this.f8737t = uV.n(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        uV.x();
    }
}
