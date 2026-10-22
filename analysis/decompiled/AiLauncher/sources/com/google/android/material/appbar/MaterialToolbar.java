package com.google.android.material.appbar;

import Z2.h;
import Z2.i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import com.google.android.material.internal.s;
import d3.C3953a;
import u0.C5566a;

/* loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: c0, reason: collision with root package name */
    public static final int f20246c0 = R$style.Widget_MaterialComponents_Toolbar;

    /* renamed from: d0, reason: collision with root package name */
    public static final ImageView.ScaleType[] f20247d0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: U, reason: collision with root package name */
    public Integer f20248U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f20249V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f20250W;

    /* renamed from: a0, reason: collision with root package name */
    public ImageView.ScaleType f20251a0;

    /* renamed from: b0, reason: collision with root package name */
    public Boolean f20252b0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    private Drawable W(Drawable drawable) {
        if (drawable == null || this.f20248U == null) {
            return drawable;
        }
        Drawable drawableR = C5566a.r(drawable.mutate());
        drawableR.setTint(this.f20248U.intValue());
        return drawableR;
    }

    public final Pair<Integer, Integer> S(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i10 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i10 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i10 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    public final void T(Context context) {
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : O2.a.f(background);
        if (colorStateListValueOf != null) {
            h hVar = new h();
            hVar.g0(colorStateListValueOf);
            hVar.U(context);
            hVar.f0(getElevation());
            setBackground(hVar);
        }
    }

    public final void U(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = measuredWidth2 + i10;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i10, 0), Math.max(i11 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i10 += iMax;
            i11 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 - i10, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i10, view.getTop(), i11, view.getBottom());
    }

    public final void V() {
        if (this.f20249V || this.f20250W) {
            TextView textViewG = s.g(this);
            TextView textViewE = s.e(this);
            if (textViewG == null && textViewE == null) {
                return;
            }
            Pair<Integer, Integer> pairS = S(textViewG, textViewE);
            if (this.f20249V && textViewG != null) {
                U(textViewG, pairS);
            }
            if (!this.f20250W || textViewE == null) {
                return;
            }
            U(textViewE, pairS);
        }
    }

    public final void X() {
        ImageView imageViewC = s.c(this);
        if (imageViewC != null) {
            Boolean bool = this.f20252b0;
            if (bool != null) {
                imageViewC.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f20251a0;
            if (scaleType != null) {
                imageViewC.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f20251a0;
    }

    public Integer getNavigationIconTint() {
        return this.f20248U;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        V();
        X();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        i.d(this, f10);
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.f20252b0;
        if (bool == null || bool.booleanValue() != z10) {
            this.f20252b0 = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f20251a0 != scaleType) {
            this.f20251a0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(W(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.f20248U = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.f20250W != z10) {
            this.f20250W = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.f20249V != z10) {
            this.f20249V = z10;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f20246c0;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayI = r.i(context2, attributeSet, R$styleable.MaterialToolbar, i10, i11, new int[0]);
        int i12 = R$styleable.MaterialToolbar_navigationIconTint;
        if (typedArrayI.hasValue(i12)) {
            setNavigationIconTint(typedArrayI.getColor(i12, -1));
        }
        this.f20249V = typedArrayI.getBoolean(R$styleable.MaterialToolbar_titleCentered, false);
        this.f20250W = typedArrayI.getBoolean(R$styleable.MaterialToolbar_subtitleCentered, false);
        int i13 = typedArrayI.getInt(R$styleable.MaterialToolbar_logoScaleType, -1);
        if (i13 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f20247d0;
            if (i13 < scaleTypeArr.length) {
                this.f20251a0 = scaleTypeArr[i13];
            }
        }
        int i14 = R$styleable.MaterialToolbar_logoAdjustViewBounds;
        if (typedArrayI.hasValue(i14)) {
            this.f20252b0 = Boolean.valueOf(typedArrayI.getBoolean(i14, false));
        }
        typedArrayI.recycle();
        T(context2);
    }
}
