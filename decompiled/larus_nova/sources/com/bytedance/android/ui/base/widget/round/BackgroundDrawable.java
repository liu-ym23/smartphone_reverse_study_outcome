package com.bytedance.android.ui.base.widget.round;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020\u0007H\u0002J\u0006\u0010&\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0019J\u0006\u0010(\u001a\u00020\u0019J\u0006\u0010)\u001a\u00020\u0019J\u0006\u0010*\u001a\u00020\u0019J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0007H\u0002J\"\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u00100\u001a\u00020/J\b\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u00020/H\u0002J\b\u00104\u001a\u00020/H\u0002J\b\u00105\u001a\u00020/H\u0002J\u0010\u00106\u001a\u00020\u00002\b\b\u0001\u00107\u001a\u00020\u000eJ\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u000e\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u000e\u0010;\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u000e\u0010<\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u0010\u0010>\u001a\u00020\u00002\b\b\u0001\u00107\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/bytedance/android/ui/base/widget/round/BackgroundDrawable;", "Landroid/graphics/drawable/StateListDrawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "immediately", "", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "background", "Landroid/graphics/drawable/GradientDrawable;", "backgroundChecked", "backgroundPressed", "bgCheckedColor", "", "bgCheckedEndColor", "bgCheckedStartColor", "bgColor", "bgEndColor", "bgPressColor", "bgPressEndColor", "bgPressStartColor", "bgStartColor", "colorOrientation", "cornerRadius", "", "cornerRadiusBL", "cornerRadiusBR", "cornerRadiusTL", "cornerRadiusTR", "isBackgroundAdded", "isCheckedBackgroundAdded", "isPressedBackgroundAdded", "strokeCheckedColor", "strokeColor", "strokePressColor", "strokeWidth", "allRadiusIsEqual", "getCornerRadius", "getCornerRadiusBL", "getCornerRadiusBR", "getCornerRadiusTL", "getCornerRadiusTR", "getOrientationEnum", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "hasRadius", "initAttributes", "", "invalidate", "isBgColorValid", "makeBackgroundDrawable", "makeCheckedBackgroundDrawable", "makeDrawable", "makePressedBackgroundDrawable", "setBgColor", "color", "setCornerRadius", "radius", "setCornerRadiusBL", "setCornerRadiusBR", "setCornerRadiusTL", "setCornerRadiusTR", "setStrokeColor", "setStrokeWidth", "width", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackgroundDrawable extends StateListDrawable {
    private final GradientDrawable background;
    private final GradientDrawable backgroundChecked;
    private final GradientDrawable backgroundPressed;
    private int bgCheckedColor;
    private int bgCheckedEndColor;
    private int bgCheckedStartColor;
    private int bgColor;
    private int bgEndColor;
    private int bgPressColor;
    private int bgPressEndColor;
    private int bgPressStartColor;
    private int bgStartColor;
    private int colorOrientation;
    private float cornerRadius;
    private float cornerRadiusBL;
    private float cornerRadiusBR;
    private float cornerRadiusTL;
    private float cornerRadiusTR;
    private boolean isBackgroundAdded;
    private boolean isCheckedBackgroundAdded;
    private boolean isPressedBackgroundAdded;
    private int strokeCheckedColor;
    private int strokeColor;
    private int strokePressColor;
    private int strokeWidth;

    private final boolean allRadiusIsEqual() {
        float r100 = this.cornerRadiusTL;
        if (r100 == this.cornerRadiusTR) goto L5;
    L9:
        return false;
    L5:
        if (r100 != this.cornerRadiusBR) goto L9;
        if (r100 != this.cornerRadiusBL) goto L9;
        return true;
    }

    private final GradientDrawable.Orientation getOrientationEnum() {
        int r100 = this.colorOrientation;
        if (r100 == 1) goto L18;
        if (r100 == 3) goto L23;
        if (r100 == 4) goto L22;
        if (r100 == 5) goto L21;
        if (r100 == 6) goto L20;
        return GradientDrawable.Orientation.TOP_BOTTOM;
    L20:
        return GradientDrawable.Orientation.BL_TR;
    L21:
        return GradientDrawable.Orientation.TR_BL;
    L22:
        return GradientDrawable.Orientation.BR_TL;
    L23:
        return GradientDrawable.Orientation.TL_BR;
    L18:
        return GradientDrawable.Orientation.LEFT_RIGHT;
    }

    private final boolean hasRadius() {
        float r100 = 0;
        if (this.cornerRadiusTL <= r100) goto L5;
    L10:
        return true;
    L5:
        if (this.cornerRadiusTR > r100) goto L10;
        if (this.cornerRadiusBR > r100) goto L10;
        if (this.cornerRadiusBL > r100) goto L10;
        return false;
    }

    private final boolean isBgColorValid() {
        if (this.bgStartColor != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.bgEndColor == 0) goto L7;
        return true;
    }

    private final void makeBackgroundDrawable() {
        if (isBgColorValid() == false) goto L19;
        this.background.setColors(new int[]{this.bgStartColor, this.bgEndColor});
        this.background.setOrientation(getOrientationEnum());
        if (hasRadius() == true) goto L7;
    L10:
        int r100 = this.strokeWidth;
        if (r100 < 0) goto L16;
        int r101 = this.strokeColor;
        if (r101 == 0) goto L16;
        this.background.setStroke(r100, r101);
    L16:
        if (this.isBackgroundAdded == true) goto L20;
        this.isBackgroundAdded = true;
        addState(new int[]{-16842919, -16842912}, this.background);
        return;
    L20:
        return;
    L7:
        if (allRadiusIsEqual() == false) goto L9;
        this.background.setCornerRadius(this.cornerRadiusTL);
        goto L10
    L9:
        GradientDrawable r102 = this.background;
        float r103 = this.cornerRadiusTL;
        float r104 = this.cornerRadiusTR;
        float r105 = this.cornerRadiusBR;
        float r106 = this.cornerRadiusBL;
        r102.setCornerRadii(new float[]{r103, r103, r104, r104, r105, r105, r106, r106});
        goto L10
    }

    private final void makeCheckedBackgroundDrawable() {
        if (isBgColorValid() == true) goto L5;
        return;
    L5:
        int r100 = this.bgCheckedStartColor;
        if (r100 == 0) goto L10;
        if (this.bgCheckedEndColor == 0) goto L10;
    L11:
        GradientDrawable r101 = this.backgroundChecked;
        int[] r102 = new int[2];
        if (r100 != 0) goto L14;
        r100 = this.bgStartColor;
    L14:
        r102[0] = r100;
        int r103 = this.bgCheckedEndColor;
        if (r103 != 0) goto L17;
        r103 = this.bgEndColor;
    L17:
        r102[1] = r103;
        r101.setColors(r102);
        this.backgroundChecked.setOrientation(getOrientationEnum());
        if (hasRadius() == true) goto L20;
    L23:
        int r104 = this.strokeCheckedColor;
        if (r104 != 0) goto L26;
        r104 = this.strokeColor;
    L26:
        int r105 = this.strokeWidth;
        if (r105 < 0) goto L31;
        if (r104 == 0) goto L31;
        this.backgroundChecked.setStroke(r105, r104);
    L31:
        if (this.isCheckedBackgroundAdded == true) goto L35;
        this.isCheckedBackgroundAdded = true;
        addState(new int[]{R.attr.state_checked}, this.backgroundChecked);
        return;
    L35:
        return;
    L20:
        if (allRadiusIsEqual() == false) goto L22;
        this.backgroundChecked.setCornerRadius(this.cornerRadiusTL);
        goto L23
    L22:
        GradientDrawable r106 = this.backgroundChecked;
        float r107 = this.cornerRadiusTL;
        float r108 = this.cornerRadiusTR;
        float r109 = this.cornerRadiusBR;
        float r110 = this.cornerRadiusBL;
        r106.setCornerRadii(new float[]{r107, r107, r108, r108, r109, r109, r110, r110});
    L10:
        if (this.strokeCheckedColor != 0) goto L11;
    }

    private final void makeDrawable() {
        makeBackgroundDrawable();
        makePressedBackgroundDrawable();
        makeCheckedBackgroundDrawable();
    }

    private final void makePressedBackgroundDrawable() {
        if (isBgColorValid() == true) goto L5;
        return;
    L5:
        int r100 = this.bgPressStartColor;
        if (r100 == 0) goto L10;
        if (this.bgPressEndColor == 0) goto L10;
    L11:
        GradientDrawable r101 = this.backgroundPressed;
        int[] r102 = new int[2];
        if (r100 != 0) goto L14;
        r100 = this.bgStartColor;
    L14:
        r102[0] = r100;
        int r103 = this.bgPressEndColor;
        if (r103 != 0) goto L17;
        r103 = this.bgEndColor;
    L17:
        r102[1] = r103;
        r101.setColors(r102);
        this.backgroundPressed.setOrientation(getOrientationEnum());
        if (hasRadius() == true) goto L20;
    L23:
        int r104 = this.strokePressColor;
        if (r104 != 0) goto L26;
        r104 = this.strokeColor;
    L26:
        int r105 = this.strokeWidth;
        if (r105 < 0) goto L31;
        if (r104 == 0) goto L31;
        this.backgroundPressed.setStroke(r105, r104);
    L31:
        if (this.isPressedBackgroundAdded == true) goto L35;
        this.isPressedBackgroundAdded = true;
        addState(new int[]{R.attr.state_pressed}, this.backgroundPressed);
        return;
    L35:
        return;
    L20:
        if (allRadiusIsEqual() == false) goto L22;
        this.backgroundPressed.setCornerRadius(this.cornerRadiusTL);
        goto L23
    L22:
        GradientDrawable r106 = this.backgroundPressed;
        float r107 = this.cornerRadiusTL;
        float r108 = this.cornerRadiusTR;
        float r109 = this.cornerRadiusBR;
        float r110 = this.cornerRadiusBL;
        r106.setCornerRadii(new float[]{r107, r107, r108, r108, r109, r109, r110, r110});
    L10:
        if (this.strokePressColor != 0) goto L11;
    }

    public final void invalidate() {
        makeDrawable();
        invalidateSelf();
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCornerRadiusBL() {
        return this.cornerRadiusBL;
    }

    public final float getCornerRadiusBR() {
        return this.cornerRadiusBR;
    }

    public final float getCornerRadiusTL() {
        return this.cornerRadiusTL;
    }

    public final float getCornerRadiusTR() {
        return this.cornerRadiusTR;
    }

    public final BackgroundDrawable setBgColor(int r100) {
        this.bgColor = r100;
        this.bgStartColor = r100;
        this.bgEndColor = r100;
        return this;
    }

    public final BackgroundDrawable setCornerRadius(float r100) {
        this.cornerRadius = r100;
        this.cornerRadiusTL = r100;
        this.cornerRadiusTR = r100;
        this.cornerRadiusBL = r100;
        this.cornerRadiusBR = r100;
        return this;
    }

    public final BackgroundDrawable setCornerRadiusBL(float r100) {
        this.cornerRadiusBL = r100;
        return this;
    }

    public final BackgroundDrawable setCornerRadiusBR(float r100) {
        this.cornerRadiusBR = r100;
        return this;
    }

    public final BackgroundDrawable setCornerRadiusTL(float r100) {
        this.cornerRadiusTL = r100;
        return this;
    }

    public final BackgroundDrawable setCornerRadiusTR(float r100) {
        this.cornerRadiusTR = r100;
        return this;
    }

    public final BackgroundDrawable setStrokeColor(int r100) {
        this.strokeColor = r100;
        return this;
    }

    public final BackgroundDrawable setStrokeWidth(int r100) {
        this.strokeWidth = r100;
        return this;
    }

    public BackgroundDrawable(Context r100, AttributeSet r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.background = new GradientDrawable();
        this.backgroundPressed = new GradientDrawable();
        this.backgroundChecked = new GradientDrawable();
        this.colorOrientation = 2;
        float r103 = this.cornerRadius;
        this.cornerRadiusTL = r103;
        this.cornerRadiusTR = r103;
        this.cornerRadiusBL = r103;
        this.cornerRadiusBR = r103;
        this.strokeWidth = -1;
        initAttributes(r100, r101, r102);
    }

    private final void initAttributes(Context r100, AttributeSet r101, boolean r102) {
        if (r101 == null) goto L7;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.bg_checkedColor, com.larus.nova.R.attr.bg_checkedEndColor, com.larus.nova.R.attr.bg_checkedStartColor, com.larus.nova.R.attr.bg_color, com.larus.nova.R.attr.bg_colorOrientation, com.larus.nova.R.attr.bg_cornerRadius, com.larus.nova.R.attr.bg_cornerRadius_BL, com.larus.nova.R.attr.bg_cornerRadius_BR, com.larus.nova.R.attr.bg_cornerRadius_TL, com.larus.nova.R.attr.bg_cornerRadius_TR, com.larus.nova.R.attr.bg_endColor, com.larus.nova.R.attr.bg_pressColor, com.larus.nova.R.attr.bg_pressEndColor, com.larus.nova.R.attr.bg_pressStartColor, com.larus.nova.R.attr.bg_startColor, com.larus.nova.R.attr.bg_strokeCheckedColor, com.larus.nova.R.attr.bg_strokeColor, com.larus.nova.R.attr.bg_strokePressColor, com.larus.nova.R.attr.bg_strokeWidth});
        int r104 = r103.getColor(3, this.bgColor);
        this.bgColor = r104;
        this.bgStartColor = r103.getColor(14, r104);
        this.bgEndColor = r103.getColor(10, this.bgColor);
        int r105 = r103.getColor(11, this.bgPressColor);
        this.bgPressColor = r105;
        this.bgPressStartColor = r103.getColor(13, r105);
        this.bgPressEndColor = r103.getColor(12, this.bgPressColor);
        int r106 = r103.getColor(0, this.bgCheckedColor);
        this.bgCheckedColor = r106;
        this.bgCheckedStartColor = r103.getColor(2, r106);
        this.bgCheckedEndColor = r103.getColor(1, this.bgCheckedColor);
        this.strokeColor = r103.getColor(16, this.strokeColor);
        this.strokePressColor = r103.getColor(17, this.strokePressColor);
        this.strokeCheckedColor = r103.getColor(15, this.strokeCheckedColor);
        this.colorOrientation = r103.getInt(4, this.colorOrientation);
        this.strokeWidth = r103.getDimensionPixelSize(18, this.strokeWidth);
        float r107 = r103.getDimension(5, this.cornerRadius);
        this.cornerRadius = r107;
        this.cornerRadiusTL = r103.getDimension(8, r107);
        this.cornerRadiusTR = r103.getDimension(9, this.cornerRadius);
        this.cornerRadiusBL = r103.getDimension(6, this.cornerRadius);
        this.cornerRadiusBR = r103.getDimension(7, this.cornerRadius);
        r103.recycle();
        if (r102 == false) goto L8;
        makeDrawable();
        return;
    L8:
        return;
    }

    public /* synthetic */ BackgroundDrawable(Context r100, AttributeSet r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = true;
    L5:
        this(r100, r101, r102);
    }
}
