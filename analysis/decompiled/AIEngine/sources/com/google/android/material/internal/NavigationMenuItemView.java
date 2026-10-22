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
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.c1;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NavigationMenuItemView extends e implements k.a {
    public static final int[] J = {R.attr.state_checked};
    public boolean A;
    public final boolean B;
    public final CheckedTextView C;
    public FrameLayout D;
    public androidx.appcompat.view.menu.h E;
    public ColorStateList F;
    public boolean G;
    public Drawable H;
    public final a I;

    /* renamed from: y, reason: collision with root package name */
    public int f5038y;
    public boolean z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends v0.a {
        public a() {
        }

        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.f13532a.setCheckable(NavigationMenuItemView.this.A);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.B = true;
        a aVar = new a();
        this.I = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.stepos.aiengine.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.stepos.aiengine.R.id.design_menu_item_text);
        this.C = checkedTextView;
        e0.j(checkedTextView, aVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.D == null) {
                this.D = (FrameLayout) ((ViewStub) findViewById(com.stepos.aiengine.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.D.removeAllViews();
            this.D.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void d(androidx.appcompat.view.menu.h hVar) throws Resources.NotFoundException {
        StateListDrawable stateListDrawable;
        this.E = hVar;
        int i10 = hVar.f501a;
        if (i10 > 0) {
            setId(i10);
        }
        setVisibility(hVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(com.stepos.aiengine.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(J, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setTitle(hVar.f505e);
        setIcon(hVar.getIcon());
        setActionView(hVar.getActionView());
        setContentDescription(hVar.f515t);
        c1.a(this, hVar.f516u);
        androidx.appcompat.view.menu.h hVar2 = this.E;
        CharSequence charSequence = hVar2.f505e;
        CheckedTextView checkedTextView = this.C;
        if (charSequence == null && hVar2.getIcon() == null && this.E.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.D;
            if (frameLayout != null) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) aVar).width = -1;
                this.D.setLayoutParams(aVar);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.D;
        if (frameLayout2 != null) {
            LinearLayoutCompat.a aVar2 = (LinearLayoutCompat.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) aVar2).width = -2;
            this.D.setLayoutParams(aVar2);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public androidx.appcompat.view.menu.h getItemData() {
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        androidx.appcompat.view.menu.h hVar = this.E;
        if (hVar != null && hVar.isCheckable() && this.E.isChecked()) {
            ViewGroup.mergeDrawableStates(iArrOnCreateDrawableState, J);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.A != z) {
            this.A = z;
            this.I.sendAccessibilityEvent(this.C, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.C;
        checkedTextView.setChecked(z);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z && this.B) ? 1 : 0);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) throws Resources.NotFoundException {
        if (drawable != null) {
            if (this.G) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.F);
            }
            int i10 = this.f5038y;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.z) {
            if (this.H == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal<TypedValue> threadLocal = m0.f.f10462a;
                Drawable drawable2 = resources.getDrawable(com.stepos.aiengine.R.drawable.navigation_empty_icon, theme);
                this.H = drawable2;
                if (drawable2 != null) {
                    int i11 = this.f5038y;
                    drawable2.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.H;
        }
        this.C.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.C.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(int i10) {
        this.f5038y = i10;
    }

    public void setIconTintList(ColorStateList colorStateList) throws Resources.NotFoundException {
        this.F = colorStateList;
        this.G = colorStateList != null;
        androidx.appcompat.view.menu.h hVar = this.E;
        if (hVar != null) {
            setIcon(hVar.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.C.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.z = z;
    }

    public void setTextAppearance(int i10) {
        this.C.setTextAppearance(i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.C.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.C.setText(charSequence);
    }
}
