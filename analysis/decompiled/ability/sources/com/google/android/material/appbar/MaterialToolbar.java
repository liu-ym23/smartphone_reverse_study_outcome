package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class MaterialToolbar extends Toolbar {
    public static final ImageView.ScaleType[] f = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a, reason: collision with root package name */
    public Integer f2284a;
    public boolean b;
    public boolean c;
    public ImageView.ScaleType d;
    public Boolean e;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i = R.attr.toolbarStyle;
        super(i3.a.a(context, attributeSet, i, com.stepos.ability.R.style.Widget_MaterialComponents_Toolbar), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayD = com.google.android.material.internal.k.d(context2, attributeSet, P2.a.f1062A, i, com.stepos.ability.R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (typedArrayD.hasValue(2)) {
            setNavigationIconTint(typedArrayD.getColor(2, -1));
        }
        this.b = typedArrayD.getBoolean(4, false);
        this.c = typedArrayD.getBoolean(3, false);
        int i6 = typedArrayD.getInt(1, -1);
        if (i6 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f;
            if (i6 < scaleTypeArr.length) {
                this.d = scaleTypeArr[i6];
            }
        }
        if (typedArrayD.hasValue(0)) {
            this.e = Boolean.valueOf(typedArrayD.getBoolean(0, false));
        }
        typedArrayD.recycle();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : Y2.b.a(background);
        if (colorStateListValueOf != null) {
            e3.k kVar = new e3.k();
            kVar.q(colorStateListValueOf);
            kVar.m(context2);
            kVar.p(getElevation());
            setBackground(kVar);
        }
    }

    public final void a(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i6 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i6 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i6 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i6 - i, BasicMeasure.EXACTLY), textView.getMeasuredHeightAndState());
        }
        textView.layout(i, textView.getTop(), i6, textView.getBottom());
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.d;
    }

    @Nullable
    @ColorInt
    public Integer getNavigationIconTint() {
        return this.f2284a;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof e3.k) {
            AbstractC1451a.T(this, (e3.k) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z10, i, i6, i10, i11);
        int i12 = 0;
        ImageView imageView2 = null;
        if (this.b || this.c) {
            ArrayList arrayListA = com.google.android.material.internal.l.a(this, getTitle());
            boolean zIsEmpty = arrayListA.isEmpty();
            M.d dVar = com.google.android.material.internal.l.f2503a;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListA, dVar);
            ArrayList arrayListA2 = com.google.android.material.internal.l.a(this, getSubtitle());
            TextView textView2 = arrayListA2.isEmpty() ? null : (TextView) Collections.max(arrayListA2, dVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i13 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i14 = 0; i14 < getChildCount(); i14++) {
                    View childAt = getChildAt(i14);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i13 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i13 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.b && textView != null) {
                    a(textView, pair);
                }
                if (this.c && textView2 != null) {
                    a(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i12 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i12);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i12++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.e;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.d;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f7) {
        super.setElevation(f7);
        Drawable background = getBackground();
        if (background instanceof e3.k) {
            ((e3.k) background).p(f7);
        }
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.e;
        if (bool == null || bool.booleanValue() != z10) {
            this.e = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.d != scaleType) {
            this.d = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null && this.f2284a != null) {
            drawable = DrawableCompat.wrap(drawable.mutate());
            drawable.setTint(this.f2284a.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(@ColorInt int i) {
        this.f2284a = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.c != z10) {
            this.c = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.b != z10) {
            this.b = z10;
            requestLayout();
        }
    }
}
