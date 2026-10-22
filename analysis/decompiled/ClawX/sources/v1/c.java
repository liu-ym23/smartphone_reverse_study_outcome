package v1;

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
import com.stepos.stepclaw.R;
import k4.v;
import p1.k;
import t1.j;
import t1.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class c extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    public static final b f5948j = new b();

    /* renamed from: a, reason: collision with root package name */
    public final n f5949a;

    /* renamed from: b, reason: collision with root package name */
    public int f5950b;

    /* renamed from: c, reason: collision with root package name */
    public final float f5951c;
    public final float d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5952e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5953f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f5954g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f5955h;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        GradientDrawable gradientDrawable;
        super(x1.a.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, d1.a.f1779u);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.f5950b = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
            this.f5949a = n.b(context2, attributeSet, 0, 0).a();
        }
        this.f5951c = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(v.D(context2, typedArrayObtainStyledAttributes, 4));
        setBackgroundTintMode(k.f(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.f5952e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f5953f = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(f5948j);
        setFocusable(true);
        if (getBackground() == null) {
            int iA0 = v.a0(v.B(this, R.attr.colorSurface), v.B(this, R.attr.colorOnSurface), getBackgroundOverlayColorAlpha());
            n nVar = this.f5949a;
            if (nVar != null) {
                int i8 = d.f5956a;
                j jVar = new j(nVar);
                jVar.m(ColorStateList.valueOf(iA0));
                gradientDrawable = jVar;
            } else {
                Resources resources = getResources();
                int i9 = d.f5956a;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(iA0);
                gradientDrawable = gradientDrawable2;
            }
            ColorStateList colorStateList = this.f5954g;
            if (colorStateList != null) {
                gradientDrawable.setTintList(colorStateList);
            }
            setBackground(gradientDrawable);
        }
    }

    public float getActionTextColorAlpha() {
        return this.d;
    }

    public int getAnimationMode() {
        return this.f5950b;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f5951c;
    }

    public int getMaxInlineActionWidth() {
        return this.f5953f;
    }

    public int getMaxWidth() {
        return this.f5952e;
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
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        super.onLayout(z, i8, i9, i10, i11);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        int i10 = this.f5952e;
        if (i10 <= 0 || getMeasuredWidth() <= i10) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), i9);
    }

    public void setAnimationMode(int i8) {
        this.f5950b = i8;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f5954g != null) {
            drawable = drawable.mutate();
            drawable.setTintList(this.f5954g);
            drawable.setTintMode(this.f5955h);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f5954g = colorStateList;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            drawableMutate.setTintList(colorStateList);
            drawableMutate.setTintMode(this.f5955h);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f5955h = mode;
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
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f5948j);
        super.setOnClickListener(onClickListener);
    }

    private void setBaseTransientBottomBar(d dVar) {
    }
}
