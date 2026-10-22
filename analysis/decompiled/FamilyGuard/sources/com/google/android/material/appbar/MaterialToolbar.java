package com.google.android.material.appbar;

import a1.C0417j;
import a1.C0418k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.internal.o;
import com.google.android.material.internal.p;
import g.C0728a;
import t1.C1115h;
import t1.C1116i;
import x1.C1282a;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: e0, reason: collision with root package name */
    private static final int f12149e0 = C0417j.f6934y;

    /* renamed from: f0, reason: collision with root package name */
    private static final ImageView.ScaleType[] f12150f0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: W, reason: collision with root package name */
    private Integer f12151W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f12152a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f12153b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView.ScaleType f12154c0;

    /* renamed from: d0, reason: collision with root package name */
    private Boolean f12155d0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16823T);
    }

    private Pair<Integer, Integer> R(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i5 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i5 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i5 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void S(Context context) {
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : com.google.android.material.drawable.a.f(background);
        if (colorStateListValueOf != null) {
            C1115h c1115h = new C1115h();
            c1115h.g0(colorStateListValueOf);
            c1115h.U(context);
            c1115h.f0(getElevation());
            setBackground(c1115h);
        }
    }

    private void T(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i5 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i6 = measuredWidth2 + i5;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i5, 0), Math.max(i6 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i5 += iMax;
            i6 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i6 - i5, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i5, view.getTop(), i6, view.getBottom());
    }

    private void U() {
        if (this.f12152a0 || this.f12153b0) {
            TextView textViewG = p.g(this);
            TextView textViewE = p.e(this);
            if (textViewG == null && textViewE == null) {
                return;
            }
            Pair<Integer, Integer> pairR = R(textViewG, textViewE);
            if (this.f12152a0 && textViewG != null) {
                T(textViewG, pairR);
            }
            if (!this.f12153b0 || textViewE == null) {
                return;
            }
            T(textViewE, pairR);
        }
    }

    private Drawable V(Drawable drawable) {
        if (drawable == null || this.f12151W == null) {
            return drawable;
        }
        Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable.mutate());
        drawableR.setTint(this.f12151W.intValue());
        return drawableR;
    }

    private void W() {
        ImageView imageViewC = p.c(this);
        if (imageViewC != null) {
            Boolean bool = this.f12155d0;
            if (bool != null) {
                imageViewC.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f12154c0;
            if (scaleType != null) {
                imageViewC.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f12154c0;
    }

    public Integer getNavigationIconTint() {
        return this.f12151W;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C1116i.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        U();
        W();
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        C1116i.d(this, f5);
    }

    public void setLogoAdjustViewBounds(boolean z5) {
        Boolean bool = this.f12155d0;
        if (bool == null || bool.booleanValue() != z5) {
            this.f12155d0 = Boolean.valueOf(z5);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f12154c0 != scaleType) {
            this.f12154c0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(V(drawable));
    }

    public void setNavigationIconTint(int i5) {
        this.f12151W = Integer.valueOf(i5);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z5) {
        if (this.f12153b0 != z5) {
            this.f12153b0 = z5;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z5) {
        if (this.f12152a0 != z5) {
            this.f12152a0 = z5;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i5) {
        int i6 = f12149e0;
        super(C1282a.d(context, attributeSet, i5, i6), attributeSet, i5);
        Context context2 = getContext();
        TypedArray typedArrayI = o.i(context2, attributeSet, C0418k.f6969F3, i5, i6, new int[0]);
        int i7 = C0418k.f6987I3;
        if (typedArrayI.hasValue(i7)) {
            setNavigationIconTint(typedArrayI.getColor(i7, -1));
        }
        this.f12152a0 = typedArrayI.getBoolean(C0418k.f6999K3, false);
        this.f12153b0 = typedArrayI.getBoolean(C0418k.f6993J3, false);
        int i8 = typedArrayI.getInt(C0418k.f6981H3, -1);
        if (i8 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f12150f0;
            if (i8 < scaleTypeArr.length) {
                this.f12154c0 = scaleTypeArr[i8];
            }
        }
        int i9 = C0418k.f6975G3;
        if (typedArrayI.hasValue(i9)) {
            this.f12155d0 = Boolean.valueOf(typedArrayI.getBoolean(i9, false));
        }
        typedArrayI.recycle();
        S(context2);
    }
}
