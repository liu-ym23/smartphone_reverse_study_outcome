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
import e0.a0;
import f.k;
import f.q;
import g.f2;
import g.w0;
import j1.h;
import p1.d;
import w.j;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements q {
    public static final int[] H = {R.attr.state_checked};
    public final CheckedTextView A;
    public FrameLayout B;
    public k C;
    public ColorStateList D;
    public boolean E;
    public Drawable F;
    public final h G;

    /* renamed from: w, reason: collision with root package name */
    public int f1322w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1323x;
    public boolean y;
    public final boolean z;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = true;
        h hVar = new h(this, 2);
        this.G = hVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.stepos.stepclaw.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.stepos.stepclaw.R.id.design_menu_item_text);
        this.A = checkedTextView;
        a0.e(checkedTextView, hVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.B == null) {
                this.B = (FrameLayout) ((ViewStub) findViewById(com.stepos.stepclaw.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.B.removeAllViews();
            this.B.addView(view);
        }
    }

    @Override // f.q
    public final void b(k kVar) throws Resources.NotFoundException {
        StateListDrawable stateListDrawable;
        this.C = kVar;
        int i8 = kVar.f2473a;
        if (i8 > 0) {
            setId(i8);
        }
        setVisibility(kVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(com.stepos.stepclaw.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(H, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(kVar.isCheckable());
        setChecked(kVar.isChecked());
        setEnabled(kVar.isEnabled());
        setTitle(kVar.f2476e);
        setIcon(kVar.getIcon());
        View view = kVar.z;
        if (view == null) {
            view = null;
        }
        setActionView(view);
        setContentDescription(kVar.f2488q);
        f2.a(this, kVar.f2489r);
        k kVar2 = this.C;
        CharSequence charSequence = kVar2.f2476e;
        CheckedTextView checkedTextView = this.A;
        if (charSequence == null && kVar2.getIcon() == null) {
            View view2 = this.C.z;
            if ((view2 != null ? view2 : null) != null) {
                checkedTextView.setVisibility(8);
                FrameLayout frameLayout = this.B;
                if (frameLayout != null) {
                    w0 w0Var = (w0) frameLayout.getLayoutParams();
                    ((LinearLayout.LayoutParams) w0Var).width = -1;
                    this.B.setLayoutParams(w0Var);
                    return;
                }
                return;
            }
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.B;
        if (frameLayout2 != null) {
            w0 w0Var2 = (w0) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) w0Var2).width = -2;
            this.B.setLayoutParams(w0Var2);
        }
    }

    @Override // f.q
    public k getItemData() {
        return this.C;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i8) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i8 + 1);
        k kVar = this.C;
        if (kVar != null && kVar.isCheckable() && this.C.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.y != z) {
            this.y = z;
            this.G.h(this.A, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.A;
        checkedTextView.setChecked(z);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z && this.z) ? 1 : 0);
    }

    public void setHorizontalPadding(int i8) {
        setPadding(i8, getPaddingTop(), i8, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) throws Resources.NotFoundException {
        if (drawable != null) {
            if (this.E) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.D);
            }
            int i8 = this.f1322w;
            drawable.setBounds(0, 0, i8, i8);
        } else if (this.f1323x) {
            if (this.F == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = j.f6061a;
                Drawable drawable2 = resources.getDrawable(com.stepos.stepclaw.R.drawable.navigation_empty_icon, theme);
                this.F = drawable2;
                if (drawable2 != null) {
                    int i9 = this.f1322w;
                    drawable2.setBounds(0, 0, i9, i9);
                }
            }
            drawable = this.F;
        }
        this.A.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i8) {
        this.A.setCompoundDrawablePadding(i8);
    }

    public void setIconSize(int i8) {
        this.f1322w = i8;
    }

    public void setIconTintList(ColorStateList colorStateList) throws Resources.NotFoundException {
        this.D = colorStateList;
        this.E = colorStateList != null;
        k kVar = this.C;
        if (kVar != null) {
            setIcon(kVar.getIcon());
        }
    }

    public void setMaxLines(int i8) {
        this.A.setMaxLines(i8);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f1323x = z;
    }

    public void setTextAppearance(int i8) {
        this.A.setTextAppearance(i8);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.A.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.A.setText(charSequence);
    }
}
