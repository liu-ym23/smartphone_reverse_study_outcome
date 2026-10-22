package com.google.android.material.internal;

import a1.C0411d;
import a1.C0412e;
import a1.C0413f;
import a1.C0415h;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
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
import androidx.appcompat.widget.f0;
import androidx.core.view.C0456a;
import androidx.core.view.H;
import androidx.recyclerview.widget.RecyclerView;
import g.C0728a;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends h implements k.a {

    /* renamed from: G, reason: collision with root package name */
    private static final int[] f12911G = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    private FrameLayout f12912A;

    /* renamed from: B, reason: collision with root package name */
    private androidx.appcompat.view.menu.g f12913B;

    /* renamed from: C, reason: collision with root package name */
    private ColorStateList f12914C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f12915D;

    /* renamed from: E, reason: collision with root package name */
    private Drawable f12916E;

    /* renamed from: F, reason: collision with root package name */
    private final C0456a f12917F;

    /* renamed from: v, reason: collision with root package name */
    private int f12918v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f12919w;

    /* renamed from: x, reason: collision with root package name */
    boolean f12920x;

    /* renamed from: y, reason: collision with root package name */
    boolean f12921y;

    /* renamed from: z, reason: collision with root package name */
    private final CheckedTextView f12922z;

    class a extends C0456a {
        a() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.b0(NavigationMenuItemView.this.f12920x);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        if (D()) {
            this.f12922z.setVisibility(8);
            FrameLayout frameLayout = this.f12912A;
            if (frameLayout != null) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) aVar).width = -1;
                this.f12912A.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.f12922z.setVisibility(0);
        FrameLayout frameLayout2 = this.f12912A;
        if (frameLayout2 != null) {
            LinearLayoutCompat.a aVar2 = (LinearLayoutCompat.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) aVar2).width = -2;
            this.f12912A.setLayoutParams(aVar2);
        }
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0728a.f16848y, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f12911G, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean D() {
        return this.f12913B.getTitle() == null && this.f12913B.getIcon() == null && this.f12913B.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f12912A == null) {
                this.f12912A = (FrameLayout) ((ViewStub) findViewById(C0413f.f6842e)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f12912A.removeAllViews();
            this.f12912A.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void f(androidx.appcompat.view.menu.g gVar, int i5) {
        this.f12913B = gVar;
        if (gVar.getItemId() > 0) {
            setId(gVar.getItemId());
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackground(C());
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        f0.a(this, gVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public androidx.appcompat.view.menu.g getItemData() {
        return this.f12913B;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        androidx.appcompat.view.menu.g gVar = this.f12913B;
        if (gVar != null && gVar.isCheckable() && this.f12913B.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12911G);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z5) {
        refreshDrawableState();
        if (this.f12920x != z5) {
            this.f12920x = z5;
            this.f12917F.sendAccessibilityEvent(this.f12922z, RecyclerView.ItemAnimator.FLAG_MOVED);
        }
    }

    public void setChecked(boolean z5) {
        refreshDrawableState();
        this.f12922z.setChecked(z5);
        CheckedTextView checkedTextView = this.f12922z;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z5 && this.f12921y) ? 1 : 0);
    }

    public void setHorizontalPadding(int i5) {
        setPadding(i5, getPaddingTop(), i5, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f12915D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
                drawable.setTintList(this.f12914C);
            }
            int i5 = this.f12918v;
            drawable.setBounds(0, 0, i5, i5);
        } else if (this.f12919w) {
            if (this.f12916E == null) {
                Drawable drawableF = androidx.core.content.res.h.f(getResources(), C0412e.f6817k, getContext().getTheme());
                this.f12916E = drawableF;
                if (drawableF != null) {
                    int i6 = this.f12918v;
                    drawableF.setBounds(0, 0, i6, i6);
                }
            }
            drawable = this.f12916E;
        }
        this.f12922z.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i5) {
        this.f12922z.setCompoundDrawablePadding(i5);
    }

    public void setIconSize(int i5) {
        this.f12918v = i5;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f12914C = colorStateList;
        this.f12915D = colorStateList != null;
        androidx.appcompat.view.menu.g gVar = this.f12913B;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i5) {
        this.f12922z.setMaxLines(i5);
    }

    public void setNeedsEmptyIcon(boolean z5) {
        this.f12919w = z5;
    }

    public void setTextAppearance(int i5) {
        androidx.core.widget.i.m(this.f12922z, i5);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f12922z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f12922z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f12921y = true;
        a aVar = new a();
        this.f12917F = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0415h.f6867a, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(C0411d.f6780e));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(C0413f.f6843f);
        this.f12922z = checkedTextView;
        H.k0(checkedTextView, aVar);
    }
}
