package com.stepos.widget.tabbar;

import android.content.res.ColorStateList;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0001\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\f\u001a\u00020\b\u0012\b\b\u0001\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0014\u0010\f\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\r\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0010\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabItemStyle;", "", "cornerRadius", "", "blurRadius", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "alphaSelected", "fillColor", "", "labelTextColor", "Landroid/content/res/ColorStateList;", "iconTint", "labelTextAppearance", "paddingHorizontal", "isGlassEnabled", "", "isPressLightEnabled", "<init>", "(FFFFILandroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;IIZZ)V", "getCornerRadius$StepOSWidget_release", "()F", "getBlurRadius$StepOSWidget_release", "getAlpha$StepOSWidget_release", "getAlphaSelected$StepOSWidget_release", "getFillColor$StepOSWidget_release", "()I", "getLabelTextColor$StepOSWidget_release", "()Landroid/content/res/ColorStateList;", "getIconTint$StepOSWidget_release", "getLabelTextAppearance$StepOSWidget_release", "getPaddingHorizontal$StepOSWidget_release", "isGlassEnabled$StepOSWidget_release", "()Z", "isPressLightEnabled$StepOSWidget_release", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSTabItemStyle {
    private final float alpha;
    private final float alphaSelected;
    private final float blurRadius;
    private final float cornerRadius;
    private final int fillColor;
    private final ColorStateList iconTint;
    private final boolean isGlassEnabled;
    private final boolean isPressLightEnabled;
    private final int labelTextAppearance;
    private final ColorStateList labelTextColor;
    private final int paddingHorizontal;

    public StepOSTabItemStyle(float f10, float f11, float f12, float f13, int i10, ColorStateList colorStateList, ColorStateList colorStateList2, int i11, int i12, boolean z10, boolean z11) {
        this.cornerRadius = f10;
        this.blurRadius = f11;
        this.alpha = f12;
        this.alphaSelected = f13;
        this.fillColor = i10;
        this.labelTextColor = colorStateList;
        this.iconTint = colorStateList2;
        this.labelTextAppearance = i11;
        this.paddingHorizontal = i12;
        this.isGlassEnabled = z10;
        this.isPressLightEnabled = z11;
    }

    /* renamed from: getAlpha$StepOSWidget_release, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: getAlphaSelected$StepOSWidget_release, reason: from getter */
    public final float getAlphaSelected() {
        return this.alphaSelected;
    }

    /* renamed from: getBlurRadius$StepOSWidget_release, reason: from getter */
    public final float getBlurRadius() {
        return this.blurRadius;
    }

    /* renamed from: getCornerRadius$StepOSWidget_release, reason: from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* renamed from: getFillColor$StepOSWidget_release, reason: from getter */
    public final int getFillColor() {
        return this.fillColor;
    }

    /* renamed from: getIconTint$StepOSWidget_release, reason: from getter */
    public final ColorStateList getIconTint() {
        return this.iconTint;
    }

    /* renamed from: getLabelTextAppearance$StepOSWidget_release, reason: from getter */
    public final int getLabelTextAppearance() {
        return this.labelTextAppearance;
    }

    /* renamed from: getLabelTextColor$StepOSWidget_release, reason: from getter */
    public final ColorStateList getLabelTextColor() {
        return this.labelTextColor;
    }

    /* renamed from: getPaddingHorizontal$StepOSWidget_release, reason: from getter */
    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    /* renamed from: isGlassEnabled$StepOSWidget_release, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    /* renamed from: isPressLightEnabled$StepOSWidget_release, reason: from getter */
    public final boolean getIsPressLightEnabled() {
        return this.isPressLightEnabled;
    }
}
