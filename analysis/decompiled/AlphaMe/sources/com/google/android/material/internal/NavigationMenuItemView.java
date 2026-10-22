package com.google.android.material.internal;

import K.S;
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
import androidx.appcompat.widget.C0237y0;
import androidx.appcompat.widget.h1;
import e.EnumC0546d;
import k.C0663q;
import k.InterfaceC0641B;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements InterfaceC0641B {

    /* renamed from: G, reason: collision with root package name */
    public static final int[] f10756G = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    public FrameLayout f10757A;

    /* renamed from: B, reason: collision with root package name */
    public C0663q f10758B;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f10759C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f10760D;

    /* renamed from: E, reason: collision with root package name */
    public Drawable f10761E;

    /* renamed from: F, reason: collision with root package name */
    public final r0.d f10762F;

    /* renamed from: v, reason: collision with root package name */
    public int f10763v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f10764w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10765x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f10766y;

    /* renamed from: z, reason: collision with root package name */
    public final CheckedTextView f10767z;

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10766y = true;
        r0.d dVar = new r0.d(3, this);
        this.f10762F = dVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.stepos.alphame.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.stepos.alphame.R.id.design_menu_item_text);
        this.f10767z = checkedTextView;
        S.h(checkedTextView, dVar);
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.f10757A == null) {
                this.f10757A = (FrameLayout) ((ViewStub) findViewById(com.stepos.alphame.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f10757A.removeAllViews();
            this.f10757A.addView(view);
        }
    }

    @Override // k.InterfaceC0641B
    public final void c(C0663q c0663q) {
        StateListDrawable stateListDrawable;
        this.f10758B = c0663q;
        int i4 = c0663q.f13269a;
        if (i4 > 0) {
            setId(i4);
        }
        setVisibility(c0663q.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(com.stepos.alphame.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f10756G, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(c0663q.isCheckable());
        setChecked(c0663q.isChecked());
        setEnabled(c0663q.isEnabled());
        setTitle(c0663q.f13273e);
        setIcon(c0663q.getIcon());
        setActionView(c0663q.getActionView());
        setContentDescription(c0663q.f13285q);
        h1.a(this, c0663q.f13286r);
        C0663q c0663q2 = this.f10758B;
        CharSequence charSequence = c0663q2.f13273e;
        CheckedTextView checkedTextView = this.f10767z;
        if (charSequence == null && c0663q2.getIcon() == null && this.f10758B.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.f10757A;
            if (frameLayout != null) {
                C0237y0 c0237y0 = (C0237y0) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) c0237y0).width = -1;
                this.f10757A.setLayoutParams(c0237y0);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.f10757A;
        if (frameLayout2 != null) {
            C0237y0 c0237y02 = (C0237y0) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) c0237y02).width = -2;
            this.f10757A.setLayoutParams(c0237y02);
        }
    }

    @Override // k.InterfaceC0641B
    public C0663q getItemData() {
        return this.f10758B;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        C0663q c0663q = this.f10758B;
        if (c0663q != null && c0663q.isCheckable() && this.f10758B.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f10756G);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z4) {
        refreshDrawableState();
        if (this.f10765x != z4) {
            this.f10765x = z4;
            this.f10762F.sendAccessibilityEvent(this.f10767z, 2048);
        }
    }

    public void setChecked(boolean z4) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.f10767z;
        checkedTextView.setChecked(z4);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z4 && this.f10766y) ? 1 : 0);
    }

    public void setHorizontalPadding(int i4) {
        setPadding(i4, getPaddingTop(), i4, getPaddingBottom());
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.f10760D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.f10759C);
            }
            int i4 = this.f10763v;
            drawable.setBounds(0, 0, i4, i4);
        } else if (this.f10764w) {
            if (this.f10761E == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = C.o.f272a;
                Drawable drawableA = C.j.a(resources, com.stepos.alphame.R.drawable.navigation_empty_icon, theme);
                this.f10761E = drawableA;
                if (drawableA != null) {
                    int i5 = this.f10763v;
                    drawableA.setBounds(0, 0, i5, i5);
                }
            }
            drawable = this.f10761E;
        }
        this.f10767z.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i4) {
        this.f10767z.setCompoundDrawablePadding(i4);
    }

    public void setIconSize(@Dimension int i4) {
        this.f10763v = i4;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f10759C = colorStateList;
        this.f10760D = colorStateList != null;
        C0663q c0663q = this.f10758B;
        if (c0663q != null) {
            setIcon(c0663q.getIcon());
        }
    }

    public void setMaxLines(int i4) {
        this.f10767z.setMaxLines(i4);
    }

    public void setNeedsEmptyIcon(boolean z4) {
        this.f10764w = z4;
    }

    public void setTextAppearance(int i4) {
        this.f10767z.setTextAppearance(i4);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f10767z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f10767z.setText(charSequence);
    }
}
