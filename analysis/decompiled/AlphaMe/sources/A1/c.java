package A1;

import B0.f;
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
import com.stepos.alphame.R;
import f1.AbstractC0557a;
import m1.AbstractC0769a;
import t0.J;
import y1.j;
import y1.n;

/* loaded from: classes.dex */
public abstract class c extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    public static final b f45i = new b();

    /* renamed from: a, reason: collision with root package name */
    public final n f46a;

    /* renamed from: b, reason: collision with root package name */
    public int f47b;

    /* renamed from: c, reason: collision with root package name */
    public final float f48c;

    /* renamed from: d, reason: collision with root package name */
    public final float f49d;

    /* renamed from: e, reason: collision with root package name */
    public final int f50e;

    /* renamed from: f, reason: collision with root package name */
    public final int f51f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f52g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f53h;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        GradientDrawable gradientDrawable;
        super(C1.a.b(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, AbstractC0769a.f13530E);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.f47b = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
            this.f46a = n.b(context2, attributeSet, 0, 0).a();
        }
        this.f48c = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(f.y(context2, typedArrayObtainStyledAttributes, 4));
        setBackgroundTintMode(J.D(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f49d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.f50e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f51f = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(f45i);
        setFocusable(true);
        if (getBackground() == null) {
            int iL = AbstractC0557a.L(getBackgroundOverlayColorAlpha(), AbstractC0557a.x(R.attr.colorSurface, this), AbstractC0557a.x(R.attr.colorOnSurface, this));
            n nVar = this.f46a;
            if (nVar != null) {
                int i4 = d.f54a;
                j jVar = new j(nVar);
                jVar.o(ColorStateList.valueOf(iL));
                gradientDrawable = jVar;
            } else {
                Resources resources = getResources();
                int i5 = d.f54a;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(iL);
                gradientDrawable = gradientDrawable2;
            }
            ColorStateList colorStateList = this.f52g;
            if (colorStateList != null) {
                gradientDrawable.setTintList(colorStateList);
            }
            setBackground(gradientDrawable);
        }
    }

    private void setBaseTransientBottomBar(d dVar) {
    }

    public float getActionTextColorAlpha() {
        return this.f49d;
    }

    public int getAnimationMode() {
        return this.f47b;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f48c;
    }

    public int getMaxInlineActionWidth() {
        return this.f51f;
    }

    public int getMaxWidth() {
        return this.f50e;
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
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int i6 = this.f50e;
        if (i6 <= 0 || getMeasuredWidth() <= i6) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i5);
    }

    public void setAnimationMode(int i4) {
        this.f47b = i4;
    }

    @Override // android.view.View
    public void setBackground(@Nullable Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        if (drawable != null && this.f52g != null) {
            drawable = drawable.mutate();
            drawable.setTintList(this.f52g);
            drawable.setTintMode(this.f53h);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.f52g = colorStateList;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            drawableMutate.setTintList(colorStateList);
            drawableMutate.setTintMode(this.f53h);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.f53h = mode;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            drawableMutate.setTintMode(mode);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
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
        setOnTouchListener(onClickListener != null ? null : f45i);
        super.setOnClickListener(onClickListener);
    }
}
