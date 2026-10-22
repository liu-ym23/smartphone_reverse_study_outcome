package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuPresenter;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f561l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f562m;

    /* renamed from: n, reason: collision with root package name */
    public View f563n;

    /* renamed from: o, reason: collision with root package name */
    public View f564o;

    /* renamed from: p, reason: collision with root package name */
    public View f565p;

    /* renamed from: q, reason: collision with root package name */
    public LinearLayout f566q;
    public TextView r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f567s;

    /* renamed from: t, reason: collision with root package name */
    public final int f568t;

    /* renamed from: u, reason: collision with root package name */
    public final int f569u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f570v;

    /* renamed from: w, reason: collision with root package name */
    public final int f571w;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k.a f572a;

        public a(k.a aVar) {
            this.f572a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f572a.c();
        }
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.attr.actionModeStyle);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8924d, R.attr.actionModeStyle, 0);
        setBackground((!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : androidx.datastore.preferences.protobuf.b1.L(resourceId, context));
        this.f568t = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f569u = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f741e = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f571w = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void f(k.a aVar) {
        View view = this.f563n;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f571w, (ViewGroup) this, false);
            this.f563n = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f563n);
        }
        View viewFindViewById = this.f563n.findViewById(R.id.action_mode_close_button);
        this.f564o = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(aVar));
        androidx.appcompat.view.menu.f fVarE = aVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f740d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.j();
            ActionMenuPresenter.a aVar2 = actionMenuPresenter.f606w;
            if (aVar2 != null && aVar2.b()) {
                aVar2.f529i.dismiss();
            }
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f740d = actionMenuPresenter2;
        actionMenuPresenter2.f599o = true;
        actionMenuPresenter2.f600p = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        fVarE.b(this.f740d, this.f738b);
        ActionMenuPresenter actionMenuPresenter3 = this.f740d;
        androidx.appcompat.view.menu.k kVar = actionMenuPresenter3.f436k;
        if (kVar == null) {
            androidx.appcompat.view.menu.k kVar2 = (androidx.appcompat.view.menu.k) actionMenuPresenter3.f433d.inflate(actionMenuPresenter3.h, (ViewGroup) this, false);
            actionMenuPresenter3.f436k = kVar2;
            kVar2.c(actionMenuPresenter3.f432c);
            actionMenuPresenter3.b();
        }
        androidx.appcompat.view.menu.k kVar3 = actionMenuPresenter3.f436k;
        if (kVar != kVar3) {
            ((ActionMenuView) kVar3).setPresenter(actionMenuPresenter3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) kVar3;
        this.f739c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f739c, layoutParams);
    }

    public final void g() {
        if (this.f566q == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f566q = linearLayout;
            this.r = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f567s = (TextView) this.f566q.findViewById(R.id.action_bar_subtitle);
            int i10 = this.f568t;
            if (i10 != 0) {
                this.r.setTextAppearance(getContext(), i10);
            }
            int i11 = this.f569u;
            if (i11 != 0) {
                this.f567s.setTextAppearance(getContext(), i11);
            }
        }
        this.r.setText(this.f561l);
        this.f567s.setText(this.f562m);
        boolean zIsEmpty = TextUtils.isEmpty(this.f561l);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f562m);
        this.f567s.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f566q.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f566q.getParent() == null) {
            addView(this.f566q);
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

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f562m;
    }

    public CharSequence getTitle() {
        return this.f561l;
    }

    public final void h() {
        removeAllViews();
        this.f565p = null;
        this.f739c = null;
        this.f740d = null;
        View view = this.f564o;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f740d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.j();
            ActionMenuPresenter.a aVar = this.f740d.f606w;
            if (aVar == null || !aVar.b()) {
                return;
            }
            aVar.f529i.dismiss();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        boolean z3 = getLayoutDirection() == 1;
        int paddingRight = z3 ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f563n;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f563n.getLayoutParams();
            int i14 = z3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = z3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i16 = z3 ? paddingRight - i14 : paddingRight + i14;
            int iD = androidx.appcompat.widget.a.d(i16, paddingTop, paddingTop2, this.f563n, z3) + i16;
            paddingRight = z3 ? iD - i15 : iD + i15;
        }
        LinearLayout linearLayout = this.f566q;
        if (linearLayout != null && this.f565p == null && linearLayout.getVisibility() != 8) {
            paddingRight += androidx.appcompat.widget.a.d(paddingRight, paddingTop, paddingTop2, this.f566q, z3);
        }
        View view2 = this.f565p;
        if (view2 != null) {
            androidx.appcompat.widget.a.d(paddingRight, paddingTop, paddingTop2, view2, z3);
        }
        int paddingLeft = z3 ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f739c;
        if (actionMenuView != null) {
            androidx.appcompat.widget.a.d(paddingLeft, paddingTop, paddingTop2, actionMenuView, !z3);
        }
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
        int size2 = this.f741e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i11);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f563n;
        if (view != null) {
            int iC = androidx.appcompat.widget.a.c(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f563n.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f739c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = androidx.appcompat.widget.a.c(this.f739c, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f566q;
        if (linearLayout != null && this.f565p == null) {
            if (this.f570v) {
                this.f566q.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f566q.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f566q.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = androidx.appcompat.widget.a.c(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f565p;
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
            this.f565p.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(iMin, i15));
        }
        if (this.f741e > 0) {
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

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i10) {
        this.f741e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f565p;
        if (view2 != null) {
            removeView(view2);
        }
        this.f565p = view;
        if (view != null && (linearLayout = this.f566q) != null) {
            removeView(linearLayout);
            this.f566q = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f562m = charSequence;
        g();
    }

    public void setTitle(CharSequence charSequence) {
        this.f561l = charSequence;
        g();
        v0.e0.k(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f570v) {
            requestLayout();
        }
        this.f570v = z;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
