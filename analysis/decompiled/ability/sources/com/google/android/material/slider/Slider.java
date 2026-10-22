package com.google.android.material.slider;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.content.res.AppCompatResources;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import e3.C1412a;
import e3.C1417f;
import e3.k;
import e3.o;
import e3.p;
import g1.AbstractC1451a;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class Slider extends f {
    public Slider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.value});
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            setValue(typedArrayObtainStyledAttributes.getFloat(0, 0.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public int getActiveThumbIndex() {
        return this.f2583q0;
    }

    public int getFocusedThumbIndex() {
        return this.f2585r0;
    }

    @Px
    public int getHaloRadius() {
        return this.f2540L;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.f2526A0;
    }

    public int getLabelBehavior() {
        return this.f2529C;
    }

    public float getStepSize() {
        return this.s0;
    }

    public float getThumbElevation() {
        return this.f2547O0.b.n;
    }

    @Px
    public int getThumbHeight() {
        return this.f2536G;
    }

    @Override // com.google.android.material.slider.f
    @Px
    public int getThumbRadius() {
        return this.f2534F / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f2547O0.b.e;
    }

    public float getThumbStrokeWidth() {
        return this.f2547O0.b.k;
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.f2547O0.b.d;
    }

    public int getThumbTrackGapSize() {
        return this.f2542M;
    }

    @Px
    public int getThumbWidth() {
        return this.f2534F;
    }

    @Px
    public int getTickActiveRadius() {
        return this.f2590v0;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.f2528B0;
    }

    @Px
    public int getTickInactiveRadius() {
        return this.f2592w0;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.f2530C0;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.f2530C0.equals(this.f2528B0)) {
            return this.f2528B0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public int getTickVisibilityMode() {
        return this.f2588u0;
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.f2532D0;
    }

    @Override // com.google.android.material.slider.f
    @Px
    public int getTrackCornerSize() {
        int i = this.f2550Q;
        return i == -1 ? this.f2531D / 2 : i;
    }

    @Px
    public int getTrackHeight() {
        return this.f2531D;
    }

    @Nullable
    public ColorStateList getTrackIconActiveColor() {
        return this.f2566a0;
    }

    @Nullable
    public Drawable getTrackIconActiveEnd() {
        return this.f2560V;
    }

    @Nullable
    public Drawable getTrackIconActiveStart() {
        return this.f2556T;
    }

    @Nullable
    public ColorStateList getTrackIconInactiveColor() {
        return this.f2570f0;
    }

    @Nullable
    public Drawable getTrackIconInactiveEnd() {
        return this.f2568d0;
    }

    @Nullable
    public Drawable getTrackIconInactiveStart() {
        return this.b0;
    }

    public int getTrackIconSize() {
        return this.f2571g0;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.f2533E0;
    }

    public int getTrackInsideCornerSize() {
        return this.f2552R;
    }

    @Px
    public int getTrackSidePadding() {
        return this.E;
    }

    public int getTrackStopIndicatorSize() {
        return this.f2548P;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.f2533E0.equals(this.f2532D0)) {
            return this.f2532D0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Px
    public int getTrackWidth() {
        return this.f2594x0;
    }

    public float getValue() {
        return getValues().get(0).floatValue();
    }

    public float getValueFrom() {
        return this.f2579n0;
    }

    public float getValueTo() {
        return this.f2580o0;
    }

    @Override // com.google.android.material.slider.f
    public void setCentered(boolean z10) {
        if (this.f2554S == z10) {
            return;
        }
        this.f2554S = z10;
        if (z10) {
            setValues(Float.valueOf((this.f2579n0 + this.f2580o0) / 2.0f));
        } else {
            setValues(Float.valueOf(this.f2579n0));
        }
        L(true);
    }

    public void setCustomThumbDrawable(@DrawableRes int i) {
        setCustomThumbDrawable(getResources().getDrawable(i));
    }

    @Override // com.google.android.material.slider.f, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z10) {
        super.setEnabled(z10);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.f2581p0.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.f2585r0 = i;
        this.h.requestKeyboardFocusForVirtualView(i);
        postInvalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setHaloRadius(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) @Px int i) {
        if (i == this.f2540L) {
            return;
        }
        this.f2540L = i;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setRadius(this.f2540L);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(@DimenRes int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    @Override // com.google.android.material.slider.f
    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f2526A0)) {
            return;
        }
        this.f2526A0 = colorStateList;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        int iM = m(colorStateList);
        Paint paint = this.d;
        paint.setColor(iM);
        paint.setAlpha(63);
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setLabelBehavior(int i) {
        if (this.f2529C != i) {
            this.f2529C = i;
            L(true);
        }
    }

    public /* bridge */ /* synthetic */ void setLabelFormatter(@Nullable g gVar) {
    }

    @Override // com.google.android.material.slider.f
    public void setOrientation(int i) {
        if (this.f2596z == i) {
            return;
        }
        this.f2596z = i;
        L(true);
    }

    public void setStepSize(float f) {
        if (f >= 0.0f) {
            if (this.s0 != f) {
                this.s0 = f;
                this.f2597z0 = true;
                postInvalidate();
                return;
            }
            return;
        }
        float f7 = this.f2579n0;
        float f9 = this.f2580o0;
        StringBuilder sb = new StringBuilder("The stepSize(");
        sb.append(f);
        sb.append(") must be 0, or a factor of the valueFrom(");
        sb.append(f7);
        sb.append(")-valueTo(");
        throw new IllegalArgumentException(androidx.compose.foundation.b.u(sb, ") range", f9));
    }

    @Override // com.google.android.material.slider.f
    public void setThumbElevation(float f) {
        this.f2547O0.p(f);
    }

    public void setThumbElevationResource(@DimenRes int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    @Override // com.google.android.material.slider.f
    public void setThumbHeight(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) @Px int i) {
        if (i == this.f2536G) {
            return;
        }
        this.f2536G = i;
        this.f2547O0.setBounds(0, 0, this.f2534F, i);
        Drawable drawable = this.f2549P0;
        if (drawable != null) {
            a(drawable);
        }
        Iterator it = this.f2551Q0.iterator();
        while (it.hasNext()) {
            a((Drawable) it.next());
        }
        L(false);
    }

    public void setThumbHeightResource(@DimenRes int i) {
        setThumbHeight(getResources().getDimensionPixelSize(i));
    }

    public void setThumbRadius(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) @Px int i) {
        int i6 = i * 2;
        setThumbWidth(i6);
        setThumbHeight(i6);
    }

    public void setThumbRadiusResource(@DimenRes int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    @Override // com.google.android.material.slider.f
    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f2547O0.v(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i) {
        if (i != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    @Override // com.google.android.material.slider.f
    public void setThumbStrokeWidth(float f) {
        k kVar = this.f2547O0;
        kVar.b.k = f;
        kVar.invalidateSelf();
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        k kVar = this.f2547O0;
        if (colorStateList.equals(kVar.b.d)) {
            return;
        }
        kVar.q(colorStateList);
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setThumbTrackGapSize(@Px int i) {
        if (this.f2542M == i) {
            return;
        }
        this.f2542M = i;
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setThumbWidth(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) @Px int i) {
        if (i == this.f2534F) {
            return;
        }
        this.f2534F = i;
        C1417f c1417f = new C1417f(0);
        C1417f c1417f2 = new C1417f(0);
        C1417f c1417f3 = new C1417f(0);
        C1417f c1417f4 = new C1417f(0);
        float f = this.f2534F / 2.0f;
        com.stepos.statsrpk.d dVarX = AbstractC1451a.x(0);
        o.b(dVarX);
        o.b(dVarX);
        o.b(dVarX);
        o.b(dVarX);
        C1412a c1412a = new C1412a(f);
        C1412a c1412a2 = new C1412a(f);
        C1412a c1412a3 = new C1412a(f);
        C1412a c1412a4 = new C1412a(f);
        p pVar = new p();
        pVar.f4369a = dVarX;
        pVar.b = dVarX;
        pVar.c = dVarX;
        pVar.d = dVarX;
        pVar.e = c1412a;
        pVar.f = c1412a2;
        pVar.g = c1412a3;
        pVar.h = c1412a4;
        pVar.i = c1417f;
        pVar.f4370j = c1417f2;
        pVar.k = c1417f3;
        pVar.l = c1417f4;
        k kVar = this.f2547O0;
        kVar.setShapeAppearanceModel(pVar);
        kVar.setBounds(0, 0, this.f2534F, this.f2536G);
        Drawable drawable = this.f2549P0;
        if (drawable != null) {
            a(drawable);
        }
        Iterator it = this.f2551Q0.iterator();
        while (it.hasNext()) {
            a((Drawable) it.next());
        }
        L(false);
    }

    public void setThumbWidthResource(@DimenRes int i) {
        setThumbWidth(getResources().getDimensionPixelSize(i));
    }

    @Override // com.google.android.material.slider.f
    public void setTickActiveRadius(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) @Px int i) {
        if (this.f2590v0 != i) {
            this.f2590v0 = i;
            this.f.setStrokeWidth(i * 2);
            L(false);
        }
    }

    @Override // com.google.android.material.slider.f
    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f2528B0)) {
            return;
        }
        this.f2528B0 = colorStateList;
        this.f.setColor(m(colorStateList));
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTickInactiveRadius(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) @Px int i) {
        if (this.f2592w0 != i) {
            this.f2592w0 = i;
            this.e.setStrokeWidth(i * 2);
            L(false);
        }
    }

    @Override // com.google.android.material.slider.f
    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f2530C0)) {
            return;
        }
        this.f2530C0 = colorStateList;
        this.e.setColor(m(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisibilityMode(int i) {
        if (this.f2588u0 != i) {
            this.f2588u0 = i;
            postInvalidate();
        }
    }

    @Deprecated
    public void setTickVisible(boolean z10) {
        setTickVisibilityMode(z10 ? 0 : 2);
    }

    @Override // com.google.android.material.slider.f
    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f2532D0)) {
            return;
        }
        this.f2532D0 = colorStateList;
        this.b.setColor(m(colorStateList));
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackCornerSize(@Px int i) {
        if (this.f2550Q == i) {
            return;
        }
        this.f2550Q = i;
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackHeight(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) @Px int i) {
        if (this.f2531D != i) {
            this.f2531D = i;
            this.f2565a.setStrokeWidth(i);
            this.b.setStrokeWidth(this.f2531D);
            L(false);
        }
    }

    @Override // com.google.android.material.slider.f
    public void setTrackIconActiveColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == this.f2566a0) {
            return;
        }
        this.f2566a0 = colorStateList;
        I();
        H();
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackIconActiveEnd(@Nullable Drawable drawable) {
        if (drawable == this.f2560V) {
            return;
        }
        this.f2560V = drawable;
        this.f2562W = false;
        H();
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackIconActiveStart(@Nullable Drawable drawable) {
        if (drawable == this.f2556T) {
            return;
        }
        this.f2556T = drawable;
        this.f2558U = false;
        I();
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackIconInactiveColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == this.f2570f0) {
            return;
        }
        this.f2570f0 = colorStateList;
        K();
        J();
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackIconInactiveEnd(@Nullable Drawable drawable) {
        if (drawable == this.f2568d0) {
            return;
        }
        this.f2568d0 = drawable;
        this.f2569e0 = false;
        J();
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackIconInactiveStart(@Nullable Drawable drawable) {
        if (drawable == this.b0) {
            return;
        }
        this.b0 = drawable;
        this.f2567c0 = false;
        K();
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackIconSize(@Px int i) {
        if (this.f2571g0 == i) {
            return;
        }
        this.f2571g0 = i;
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f2533E0)) {
            return;
        }
        this.f2533E0 = colorStateList;
        this.f2565a.setColor(m(colorStateList));
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackInsideCornerSize(@Px int i) {
        if (this.f2552R == i) {
            return;
        }
        this.f2552R = i;
        invalidate();
    }

    @Override // com.google.android.material.slider.f
    public void setTrackStopIndicatorSize(@Px int i) {
        if (this.f2548P == i) {
            return;
        }
        this.f2548P = i;
        this.g.setStrokeWidth(i);
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValue(float f) {
        setValues(Float.valueOf(f));
    }

    public void setValueFrom(float f) {
        this.f2579n0 = f;
        this.f2597z0 = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.f2580o0 = f;
        this.f2597z0 = true;
        postInvalidate();
    }

    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        a(drawableNewDrawable);
        this.f2549P0 = drawableNewDrawable;
        this.f2551Q0.clear();
        postInvalidate();
    }

    public void setTrackIconActiveEnd(@DrawableRes int i) {
        setTrackIconActiveEnd(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconActiveStart(@DrawableRes int i) {
        setTrackIconActiveStart(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconInactiveEnd(@DrawableRes int i) {
        setTrackIconInactiveEnd(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconInactiveStart(@DrawableRes int i) {
        setTrackIconInactiveStart(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }
}
