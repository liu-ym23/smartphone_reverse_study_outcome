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
import androidx.appcompat.widget.Toolbar;
import com.stepos.alphame.R;
import java.util.ArrayList;
import java.util.Collections;
import m1.AbstractC0769a;
import t0.J;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: W, reason: collision with root package name */
    public static final ImageView.ScaleType[] f10269W = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: R, reason: collision with root package name */
    public Integer f10270R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f10271S;
    public boolean T;

    /* renamed from: U, reason: collision with root package name */
    public ImageView.ScaleType f10272U;

    /* renamed from: V, reason: collision with root package name */
    public Boolean f10273V;

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(C1.a.b(context, attributeSet, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar), attributeSet, 0);
        Context context2 = getContext();
        TypedArray typedArrayE = com.google.android.material.internal.l.e(context2, attributeSet, AbstractC0769a.f13560z, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (typedArrayE.hasValue(2)) {
            setNavigationIconTint(typedArrayE.getColor(2, -1));
        }
        this.f10271S = typedArrayE.getBoolean(4, false);
        this.T = typedArrayE.getBoolean(3, false);
        int i4 = typedArrayE.getInt(1, -1);
        if (i4 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f10269W;
            if (i4 < scaleTypeArr.length) {
                this.f10272U = scaleTypeArr[i4];
            }
        }
        if (typedArrayE.hasValue(0)) {
            this.f10273V = Boolean.valueOf(typedArrayE.getBoolean(0, false));
        }
        typedArrayE.recycle();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : J.w(background);
        if (colorStateListValueOf != null) {
            y1.j jVar = new y1.j();
            jVar.o(colorStateListValueOf);
            jVar.l(context2);
            jVar.n(getElevation());
            setBackground(jVar);
        }
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.f10272U;
    }

    @Nullable
    @ColorInt
    public Integer getNavigationIconTint() {
        return this.f10270R;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof y1.j) {
            B0.f.x0(this, (y1.j) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z4, i4, i5, i6, i7);
        int i8 = 0;
        ImageView imageView2 = null;
        if (this.f10271S || this.T) {
            ArrayList arrayListD = com.google.android.material.internal.l.d(this, getTitle());
            boolean zIsEmpty = arrayListD.isEmpty();
            A.f fVar = com.google.android.material.internal.l.f10861c;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListD, fVar);
            ArrayList arrayListD2 = com.google.android.material.internal.l.d(this, getSubtitle());
            TextView textView2 = arrayListD2.isEmpty() ? null : (TextView) Collections.max(arrayListD2, fVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i9 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i10 = 0; i10 < getChildCount(); i10++) {
                    View childAt = getChildAt(i10);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i9 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i9 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f10271S && textView != null) {
                    t(textView, pair);
                }
                if (this.T && textView2 != null) {
                    t(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i8 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i8);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i8++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f10273V;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f10272U;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        Drawable background = getBackground();
        if (background instanceof y1.j) {
            ((y1.j) background).n(f4);
        }
    }

    public void setLogoAdjustViewBounds(boolean z4) {
        Boolean bool = this.f10273V;
        if (bool == null || bool.booleanValue() != z4) {
            this.f10273V = Boolean.valueOf(z4);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.f10272U != scaleType) {
            this.f10272U = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null && this.f10270R != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.f10270R.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(@ColorInt int i4) {
        this.f10270R = Integer.valueOf(i4);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z4) {
        if (this.T != z4) {
            this.T = z4;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z4) {
        if (this.f10271S != z4) {
            this.f10271S = z4;
            requestLayout();
        }
    }

    public final void t(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i4 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i5 = measuredWidth2 + i4;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i4, 0), Math.max(i5 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i4 += iMax;
            i5 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i5 - i4, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i4, textView.getTop(), i5, textView.getBottom());
    }
}
