package com.bytedance.android.ui.ec.widget.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.ui.base.widget.button.CornersButton;
import com.bytedance.android.ui.base.widget.drawable.RotatingDrawable;
import com.bytedance.android.ui.base.widget.icon.IconExtKt;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020!H\u0014J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020\u0014J\b\u0010'\u001a\u00020!H\u0016J\u0018\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J(\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020!H\u0002J\u0012\u00103\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u00105\u001a\u00020!H\u0007J\u0010\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0012H\u0014J\u0010\u00108\u001a\u0002092\u0006\u00104\u001a\u00020\u0012H\u0002R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/button/ECButton;", "Lcom/bytedance/android/ui/base/widget/button/CornersButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disabledAlpha", "", "Ljava/lang/Float;", "enabledAlpha", "foregroundColor", "Landroid/content/res/ColorStateList;", "foregroundColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "foregroundDrawable", "Landroid/graphics/drawable/Drawable;", "hasAdjust", "", "getHasAdjust", "()Z", "setHasAdjust", "(Z)V", "iconLoadingColorStateList", "iconLoadingSize", "tempDrawableEnd", "tempDrawablePadding", "tempDrawableStart", "tempText", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawableStateChanged", "endLoading", "isLoadingAnimating", "jumpDrawablesToCurrentState", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setEnabled", "enabled", "setForegroundColor", "setForegroundDrawable", "drawable", "startLoading", "verifyDrawable", "who", "wrapDrawableWithInset", "Landroid/graphics/drawable/InsetDrawable;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECButton extends CornersButton {
    private Float disabledAlpha;
    private Float enabledAlpha;
    private ColorStateList foregroundColor;
    private GradientDrawable foregroundColorDrawable;
    private Drawable foregroundDrawable;
    private boolean hasAdjust;
    private ColorStateList iconLoadingColorStateList;
    private int iconLoadingSize;
    private Drawable tempDrawableEnd;
    private int tempDrawablePadding;
    private Drawable tempDrawableStart;
    private CharSequence tempText;

    public ECButton(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    public final void endLoading() {
        setClickable(true);
        Drawable r100 = getCompoundDrawables()[0];
        if (isLoadingAnimating() == false) goto L9;
        setCompoundDrawables(this.tempDrawableStart, null, this.tempDrawableEnd, null);
        if ((r100 instanceof RotatingDrawable) == false) goto L7;
        ((RotatingDrawable) r100).stop();
    L7:
        setText(this.tempText);
        this.tempText = "";
        setCompoundDrawablePadding(this.tempDrawablePadding);
        this.tempDrawableEnd = null;
        this.tempDrawableStart = null;
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        return;
    }

    private final void setForegroundColor() {
        if (this.foregroundColor == null) goto L12;
        GradientDrawable r100 = new GradientDrawable();
        Drawable r101 = getBackground();
        if ((r101 instanceof BackgroundDrawable) == true) goto L7;
        r101 = null;
    L7:
        BackgroundDrawable r102 = (BackgroundDrawable) r101;
        if (r102 == null) goto L10;
        r100.setCornerRadius(r102.getCornerRadius());
    L10:
        DrawableCompat.setTintList(r100, this.foregroundColor);
        setForegroundDrawable(wrapDrawableWithInset(r100));
        Unit r103 = Unit.INSTANCE;
        this.foregroundColorDrawable = r100;
        return;
    }

    @Override // com.bytedance.android.ui.base.widget.icon.IconTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.foregroundDrawable;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() != true) goto L11;
        Drawable r101 = this.foregroundDrawable;
        if (r101 == null) goto L12;
        r101.setState(getDrawableState());
        return;
    L12:
        return;
    }

    public final boolean isLoadingAnimating() {
        Drawable r100 = getCompoundDrawables()[0];
        if ((r100 instanceof RotatingDrawable) == true) goto L5;
        return false;
    L5:
        return ((RotatingDrawable) r100).isRunning();
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.foregroundDrawable;
        if (r100 == null) goto L6;
        r100.jumpToCurrentState();
        return;
    }

    public final void startLoading() {
        if (isLoadingAnimating() == false) goto L5;
        return;
    L5:
        setClickable(false);
        Drawable[] r100 = getCompoundDrawables();
        Drawable r101 = r100[0];
        Drawable r102 = r100[2];
        this.tempDrawableStart = r101;
        this.tempDrawableEnd = r102;
        RotatingDrawable r103 = new RotatingDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ec_dux_ic_s_s_circlegap_outlined_20));
        ColorStateList r104 = this.iconLoadingColorStateList;
        if (r104 == null) goto L8;
        r103.setColorFilter(new PorterDuffColorFilter(r104.getColorForState(getDrawableState(), -16777216), PorterDuff.Mode.SRC_IN));
    L8:
        IconExtKt.setDrawableSize(r103, this.iconLoadingSize);
        r103.start();
        this.tempText = getText();
        this.tempDrawablePadding = getCompoundDrawablePadding();
        setCompoundDrawablePadding(0);
        setText("");
        setCompoundDrawables(r103, null, null, null);
    }

    public final boolean getHasAdjust() {
        return this.hasAdjust;
    }

    private final void setForegroundDrawable(Drawable r100) {
        if (Intrinsics.areEqual(this.foregroundDrawable, r100) == false) goto L5;
        return;
    L5:
        Drawable r101 = this.foregroundDrawable;
        if (r101 == null) goto L8;
        r101.setCallback(null);
        unscheduleDrawable(r101);
    L8:
        this.foregroundDrawable = r100;
        if (r100 == null) goto L13;
        r100.setCallback(this);
        if (r100.isStateful() == false) goto L13;
        r100.setState(getDrawableState());
    L13:
        requestLayout();
        invalidate();
    }

    private final InsetDrawable wrapDrawableWithInset(Drawable r100) {
        return new InsetDrawable(r100, 0, 0, 0, 0);
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Drawable[] r101 = getCompoundDrawables();
        Drawable r102 = r101[0];
        Drawable r103 = r101[2];
        if (r102 == null) goto L10;
        if (r103 != null) goto L10;
        float r104 = (getWidth() - ((getPaint().measureText(getText().toString()) + getCompoundDrawablePadding()) + r102.getBounds().width())) / 2;
        this.hasAdjust = true;
        int r105 = (int) r104;
        if (getPaddingLeft() == r105) goto L8;
    L9:
        setPadding(r105, getPaddingTop(), r105, getPaddingBottom());
    L24:
        super.draw(r100);
        Drawable r106 = this.foregroundDrawable;
        if (r106 == null) goto L28;
        r106.draw(r100);
        return;
    L28:
        return;
    L8:
        if (getPaddingRight() == r105) goto L24;
    L10:
        if (r102 != null) goto L17;
        if (r103 == null) goto L17;
        float r107 = (getWidth() - ((getPaint().measureText(getText().toString()) + getCompoundDrawablePadding()) + r103.getBounds().width())) / 2;
        this.hasAdjust = true;
        int r108 = (int) r107;
        if (getPaddingLeft() == r108) goto L15;
    L16:
        setPadding(r108, getPaddingTop(), r108, getPaddingBottom());
        goto L24
    L15:
        if (getPaddingRight() == r108) goto L24;
    L17:
        if (r102 == null) goto L24;
        if (r103 == null) goto L24;
        float r109 = getPaint().measureText(getText().toString());
        int r110 = getCompoundDrawablePadding();
        float r111 = (getMeasuredWidth() - (((r109 + (r110 * 2)) + r102.getBounds().width()) + r103.getBounds().width())) / 2;
        this.hasAdjust = true;
        int r112 = (int) r111;
        if (getPaddingLeft() == r112) goto L22;
    L23:
        setPadding(r112, getPaddingTop(), r112, getPaddingBottom());
        goto L24
    L22:
        if (getPaddingRight() == r112) goto L24;
        goto L23
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L7;
        Float r101 = this.enabledAlpha;
        if (r101 == null) goto L11;
        setAlpha(r101.floatValue());
        return;
    L11:
        return;
    L7:
        Float r102 = this.disabledAlpha;
        if (r102 == null) goto L13;
        setAlpha(r102.floatValue());
        return;
    }

    public final void setHasAdjust(boolean r100) {
        this.hasAdjust = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, this.foregroundDrawable) == true) goto L8;
        return false;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Drawable r102 = this.foregroundDrawable;
        if (r102 == null) goto L6;
        r102.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        invalidate();
        return;
    }

    public ECButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.tempText = "";
        if (r101 == null) goto L14;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.enabled, android.R.attr.foreground, R.attr.foreground_tint, R.attr.icon_loading_color, R.attr.icon_loading_size, R.attr.state_disabled_alpha, R.attr.state_enabled_alpha});
        this.foregroundColor = r103.getColorStateList(2);
        Drawable r104 = r103.getDrawable(1);
        if (r103.hasValue(6) == false) goto L8;
        this.enabledAlpha = Float.valueOf(r103.getFloat(6, 1.0f));
    L8:
        if (r103.hasValue(5) == false) goto L10;
        this.disabledAlpha = Float.valueOf(r103.getFloat(5, 0.34f));
    L10:
        this.iconLoadingSize = r103.getDimensionPixelSize(4, 0);
        this.iconLoadingColorStateList = r103.getColorStateList(3);
        setEnabled(r103.getBoolean(0, true));
        r103.recycle();
        if (r104 != null) goto L15;
        setForegroundColor();
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Drawable r104 = this.foregroundDrawable;
        if (r104 == null) goto L6;
        r104.setBounds(0, 0, r100, r101);
        invalidate();
        return;
    }

    public /* synthetic */ ECButton(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
