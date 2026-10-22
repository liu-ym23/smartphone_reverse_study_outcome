package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Z;
import androidx.core.view.C1313a;
import androidx.core.view.N;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import u0.C5566a;

/* loaded from: classes2.dex */
public class NavigationMenuItemView extends h implements j.a {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f20967r = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    public int f20968g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f20969h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20970i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20971j;

    /* renamed from: k, reason: collision with root package name */
    public final CheckedTextView f20972k;

    /* renamed from: l, reason: collision with root package name */
    public FrameLayout f20973l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.appcompat.view.menu.g f20974m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f20975n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20976o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f20977p;

    /* renamed from: q, reason: collision with root package name */
    public final C1313a f20978q;

    public class a extends C1313a {
        public a() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.k0(NavigationMenuItemView.this.f20970i);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f20973l == null) {
                this.f20973l = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f20973l.removeAllViews();
            this.f20973l.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void e(androidx.appcompat.view.menu.g gVar, int i10) throws Resources.NotFoundException {
        this.f20974m = gVar;
        if (gVar.getItemId() > 0) {
            setId(gVar.getItemId());
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackground(h());
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        Z.a(this, gVar.getTooltipText());
        g();
    }

    public final void g() {
        if (k()) {
            this.f20972k.setVisibility(8);
            FrameLayout frameLayout = this.f20973l;
            if (frameLayout != null) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) aVar).width = -1;
                this.f20973l.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.f20972k.setVisibility(0);
        FrameLayout frameLayout2 = this.f20973l;
        if (frameLayout2 != null) {
            LinearLayoutCompat.a aVar2 = (LinearLayoutCompat.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) aVar2).width = -2;
            this.f20973l.setLayoutParams(aVar2);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public androidx.appcompat.view.menu.g getItemData() {
        return this.f20974m;
    }

    public final StateListDrawable h() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R$attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f20967r, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public void i(androidx.appcompat.view.menu.g gVar, boolean z10) throws Resources.NotFoundException {
        this.f20971j = z10;
        e(gVar, 0);
    }

    public void j() {
        FrameLayout frameLayout = this.f20973l;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f20972k.setCompoundDrawables(null, null, null, null);
    }

    public final boolean k() {
        return this.f20974m.getTitle() == null && this.f20974m.getIcon() == null && this.f20974m.getActionView() != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        androidx.appcompat.view.menu.g gVar = this.f20974m;
        if (gVar != null && gVar.isCheckable() && this.f20974m.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f20967r);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.f20970i != z10) {
            this.f20970i = z10;
            this.f20978q.sendAccessibilityEvent(this.f20972k, 2048);
        }
    }

    public void setChecked(boolean z10) {
        refreshDrawableState();
        this.f20972k.setChecked(z10);
        CheckedTextView checkedTextView = this.f20972k;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z10 && this.f20971j) ? 1 : 0);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) throws Resources.NotFoundException {
        if (drawable != null) {
            if (this.f20976o) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = C5566a.r(drawable).mutate();
                drawable.setTintList(this.f20975n);
            }
            int i10 = this.f20968g;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.f20969h) {
            if (this.f20977p == null) {
                Drawable drawableE = s0.h.e(getResources(), R$drawable.navigation_empty_icon, getContext().getTheme());
                this.f20977p = drawableE;
                if (drawableE != null) {
                    int i11 = this.f20968g;
                    drawableE.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.f20977p;
        }
        this.f20972k.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.f20972k.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(int i10) {
        this.f20968g = i10;
    }

    public void setIconTintList(ColorStateList colorStateList) throws Resources.NotFoundException {
        this.f20975n = colorStateList;
        this.f20976o = colorStateList != null;
        androidx.appcompat.view.menu.g gVar = this.f20974m;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.f20972k.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.f20969h = z10;
    }

    public void setTextAppearance(int i10) {
        androidx.core.widget.i.m(this.f20972k, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f20972k.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f20972k.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20971j = true;
        a aVar = new a();
        this.f20978q = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.f20972k = checkedTextView;
        N.i0(checkedTextView, aVar);
    }
}
