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
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class NavigationMenuItemView extends e implements MenuView.ItemView {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f2447r = {R.attr.state_checked};
    public int g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2448j;
    public final CheckedTextView k;
    public FrameLayout l;
    public MenuItemImpl m;
    public ColorStateList n;
    public boolean o;
    public Drawable p;

    /* renamed from: q, reason: collision with root package name */
    public final a f2449q;

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2448j = true;
        a aVar = new a(1, this);
        this.f2449q = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.stepos.ability.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.stepos.ability.R.id.design_menu_item_text);
        this.k = checkedTextView;
        ViewCompat.setAccessibilityDelegate(checkedTextView, aVar);
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.l == null) {
                this.l = (FrameLayout) ((ViewStub) findViewById(com.stepos.ability.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.l.removeAllViews();
            this.l.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.m;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void initialize(MenuItemImpl menuItemImpl, int i) throws Resources.NotFoundException {
        StateListDrawable stateListDrawable;
        this.m = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f2447r, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        CharSequence title = this.m.getTitle();
        CheckedTextView checkedTextView = this.k;
        if (title == null && this.m.getIcon() == null && this.m.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.l;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.l.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.l;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.l.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.m;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.m.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2447r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.i != z10) {
            this.i = z10;
            this.f2449q.sendAccessibilityEvent(this.k, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z10) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.k;
        checkedTextView.setChecked(z10);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z10 && this.f2448j) ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) throws Resources.NotFoundException {
        if (drawable != null) {
            if (this.o) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                drawable.setTintList(this.n);
            }
            int i = this.g;
            drawable.setBounds(0, 0, i, i);
        } else if (this.h) {
            if (this.p == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), com.stepos.ability.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.p = drawable2;
                if (drawable2 != null) {
                    int i6 = this.g;
                    drawable2.setBounds(0, 0, i6, i6);
                }
            }
            drawable = this.p;
        }
        this.k.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.k.setCompoundDrawablePadding(i);
    }

    public void setIconSize(@Dimension int i) {
        this.g = i;
    }

    public void setIconTintList(ColorStateList colorStateList) throws Resources.NotFoundException {
        this.n = colorStateList;
        this.o = colorStateList != null;
        MenuItemImpl menuItemImpl = this.m;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.k.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.h = z10;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void setShortcut(boolean z10, char c) {
    }

    public void setTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.k, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.k.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.k.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final boolean showsIcon() {
        return true;
    }
}
