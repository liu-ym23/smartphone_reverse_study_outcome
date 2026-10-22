package f3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import c3.AbstractC0873c;
import com.google.android.material.internal.o;
import com.stepos.ability.R;
import e3.k;
import e3.p;

/* loaded from: classes3.dex */
public abstract class d extends FrameLayout {
    public static final c i = new c();

    /* renamed from: a, reason: collision with root package name */
    public final p f4435a;
    public int b;
    public final float c;
    public final float d;
    public final int e;
    public final int f;
    public ColorStateList g;
    public PorterDuff.Mode h;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        GradientDrawable gradientDrawable;
        Drawable drawableWrap;
        super(i3.a.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, P2.a.f1067G);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.b = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
            this.f4435a = p.b(context2, attributeSet, 0, 0).a();
        }
        this.c = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(AbstractC0873c.a(context2, typedArrayObtainStyledAttributes, 4));
        setBackgroundTintMode(o.b(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(i);
        setFocusable(true);
        if (getBackground() == null) {
            int iC = W2.a.c(getBackgroundOverlayColorAlpha(), W2.a.a(R.attr.colorSurface, this), W2.a.a(R.attr.colorOnSurface, this));
            p pVar = this.f4435a;
            if (pVar != null) {
                int i6 = e.f4436a;
                k kVar = new k(pVar);
                kVar.q(ColorStateList.valueOf(iC));
                gradientDrawable = kVar;
            } else {
                Resources resources = getResources();
                int i10 = e.f4436a;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(iC);
                gradientDrawable = gradientDrawable2;
            }
            if (this.g != null) {
                drawableWrap = DrawableCompat.wrap(gradientDrawable);
                drawableWrap.setTintList(this.g);
            } else {
                drawableWrap = DrawableCompat.wrap(gradientDrawable);
            }
            setBackground(drawableWrap);
        }
    }

    private void setBaseTransientBottomBar(e eVar) {
    }

    public float getActionTextColorAlpha() {
        return this.d;
    }

    public int getAnimationMode() {
        return this.b;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.c;
    }

    public int getMaxInlineActionWidth() {
        return this.f;
    }

    public int getMaxWidth() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i6, int i10, int i11, int i12) {
        super.onLayout(z10, i6, i10, i11, i12);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        int i11 = this.e;
        if (i11 <= 0 || getMeasuredWidth() <= i11) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY), i10);
    }

    public void setAnimationMode(int i6) {
        this.b = i6;
    }

    @Override // android.view.View
    public void setBackground(@Nullable Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        if (drawable != null && this.g != null) {
            drawable = DrawableCompat.wrap(drawable.mutate());
            drawable.setTintList(this.g);
            drawable.setTintMode(this.h);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.g = colorStateList;
        if (getBackground() != null) {
            Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
            drawableWrap.setTintList(colorStateList);
            drawableWrap.setTintMode(this.h);
            if (drawableWrap != getBackground()) {
                super.setBackgroundDrawable(drawableWrap);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.h = mode;
        if (getBackground() != null) {
            Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
            drawableWrap.setTintMode(mode);
            if (drawableWrap != getBackground()) {
                super.setBackgroundDrawable(drawableWrap);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : i);
        super.setOnClickListener(onClickListener);
    }
}
