package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.c;
import com.obric.oui.common.style.e;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OIconButton.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OIconButton extends AppCompatImageView implements com.obric.oui.common.style.a, b {
    private static final float ALPHA_ON_PRESS = 0.3f;
    public static final a Companion = null;
    private final /* synthetic */ com.obric.oui.common.style.a $$delegate_0;
    private final /* synthetic */ b $$delegate_1;
    private final /* synthetic */ i $$delegate_2;
    private float alignmentProgress;
    private Integer backgroundColor;
    private boolean changeAlphaWhenPressed;
    private float disabledAlpha;
    private boolean internalPressState;
    private c mAlphaHelper;
    private f mLayoutHelper;
    private e mOUIEffectHelper;
    private int originIconAlpha;
    private int targetLeftPadding;

    /* JADX INFO: compiled from: OIconButton.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OIconButton(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, null, 30, null);
    }

    public OIconButton(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, null, 28, null);
    }

    public OIconButton(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r13, 0, null, 24, null);
    }

    public OIconButton(Context r11, AttributeSet r12, int r13, int r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r13, r14, null, 16, null);
    }

    private final float getAnimatedPressAlpha(float r2) {
        return 1 - (r2 * 0.7f);
    }

    @Override // com.obric.oui.common.style.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.$$delegate_1.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.a
    public void disablePressReleaseAnim(boolean r1) {
        this.$$delegate_0.disablePressReleaseAnim(r1);
    }

    public com.obric.oui.common.style.a getAlphaHelper() {
        return this.$$delegate_2.a();
    }

    @Override // com.obric.oui.common.style.b
    public List<j> getCurrentShadows() {
        return this.$$delegate_1.getCurrentShadows();
    }

    public e getEffectHelper() {
        return this.$$delegate_2.c();
    }

    public b getLayoutHelper() {
        return this.$$delegate_2.b();
    }

    @Override // com.obric.oui.common.style.b
    public int getRadius() {
        return this.$$delegate_1.getRadius();
    }

    @Override // com.obric.oui.common.style.b
    public float getShadowAlpha() {
        return this.$$delegate_1.getShadowAlpha();
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowColor() {
        return this.$$delegate_1.getShadowColor();
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowElevation() {
        return this.$$delegate_1.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.a
    public void handleTouchEvent(MotionEvent r1) {
        this.$$delegate_0.handleTouchEvent(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBorder() {
        return this.$$delegate_1.hasBorder();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBottomSeparator() {
        return this.$$delegate_1.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasLeftSeparator() {
        return this.$$delegate_1.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasRightSeparator() {
        return this.$$delegate_1.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasTopSeparator() {
        return this.$$delegate_1.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isEnableShadowWidthRadius() {
        return this.$$delegate_1.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isShadowVisible() {
        return this.$$delegate_1.isShadowVisible();
    }

    @Override // com.obric.oui.common.style.a
    public void onPressedChanged(View r1, boolean r2) {
        this.$$delegate_0.onPressedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.a
    public void onSelectedChanged(View r1, boolean r2) {
        this.$$delegate_0.onSelectedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowBottomDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowLeftDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowRightDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowTopDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void refreshColors(String r1) {
        this.$$delegate_0.refreshColors(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void resetAlphaAnim() {
        this.$$delegate_0.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderColor(int r1) {
        this.$$delegate_1.setBorderColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderWidth(int r1) {
        this.$$delegate_1.setBorderWidth(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBottomDividerAlpha(int r1) {
        this.$$delegate_1.setBottomDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenPress(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenSelected(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setEnableShadowWidthRadius(boolean r1) {
        this.$$delegate_1.setEnableShadowWidthRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean setHeightLimit(int r1) {
        return this.$$delegate_1.setHeightLimit(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r1) {
        this.$$delegate_0.setKeepPressAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setLeftDividerAlpha(int r1) {
        this.$$delegate_1.setLeftDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOuterNormalColor(int r1) {
        this.$$delegate_1.setOuterNormalColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineExcludePadding(boolean r1) {
        this.$$delegate_1.setOutlineExcludePadding(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineInset(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.setOutlineInset(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r1) {
        this.$$delegate_0.setOverridePressColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1) {
        this.$$delegate_1.setRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.setRadius(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, float r3) {
        this.$$delegate_1.setRadiusAndShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, int r3, float r4) {
        this.$$delegate_1.setRadiusAndShadow(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRightDividerAlpha(int r1) {
        this.$$delegate_1.setRightDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadow(j r1, j r2, boolean r3) {
        this.$$delegate_1.setShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowAlpha(float r1) {
        this.$$delegate_1.setShadowAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowColor(int r1) {
        this.$$delegate_1.setShadowColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r1) {
        this.$$delegate_1.setShadowCornerRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowElevation(int r1) {
        this.$$delegate_1.setShadowElevation(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowInsets(int r1, int r2) {
        this.$$delegate_1.setShadowInsets(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowStyle(int r1) {
        this.$$delegate_1.setShadowStyle(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowVisible(boolean r1, boolean r2) {
        this.$$delegate_1.setShadowVisible(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.$$delegate_1.setShowBorderOnlyBeforeL(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setTopDividerAlpha(int r1) {
        this.$$delegate_1.setTopDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setUseThemeGeneralShadowElevation() {
        this.$$delegate_1.setUseThemeGeneralShadowElevation();
    }

    @Override // com.obric.oui.common.style.b
    public boolean setWidthLimit(int r1) {
        return this.$$delegate_1.setWidthLimit(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r1) {
        this.$$delegate_1.setWidthMin(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return this.$$delegate_1.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomSeparatorColor(int r1) {
        this.$$delegate_1.updateBottomSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateDividerColorStrength(float r1) {
        this.$$delegate_1.updateDividerColorStrength(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftSeparatorColor(int r1) {
        this.$$delegate_1.updateLeftSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightSeparatorColor(int r1) {
        this.$$delegate_1.updateRightSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateShadows(List<j> r3) {
        List<j> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.$$delegate_1.updateShadows(r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopSeparatorColor(int r1) {
        this.$$delegate_1.updateTopSeparatorColor(r1);
    }

    public /* synthetic */ OIconButton(Context r4, AttributeSet r5, int r6, int r7, i r8, int r9, h r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r9 & 2) == 0) goto L5;
        r12 = null;
    L5:
        AttributeSet r13 = r12;
        int r0 = 0;
        if ((r9 & 4) == 0) goto L8;
        int r1 = 0;
    L10:
        if ((r9 & 8) != 0) goto L14;
        r0 = r7;
    L14:
        if ((r9 & 16) == 0) goto L16;
        r8 = new i(r11, r13, r1, r0);
    L16:
        this(r11, r13, r1, r0, r8);
        return;
    L8:
        r1 = r6;
        goto L10
    }

    public OIconButton(Context r4, AttributeSet r5, int r6, int r7, i r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        o.e(r8, "provider");
        super(r9, r10, r6);
        this.$$delegate_0 = r8.a();
        this.$$delegate_1 = r8.b();
        this.$$delegate_2 = r8;
        this.disabledAlpha = 1.0f;
        r8.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        setEnableShadowWidthRadius(true);
        this.mLayoutHelper = (f) ZeusTransformUtils.preCheckCast(getLayoutHelper(), f.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), c.class, "com.obric.aiagent.plugin");
        this.mAlphaHelper = r11;
        if (r11 == null) goto L6;
        r11.a(getRadius());
    L6:
        this.mOUIEffectHelper = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r12 = r9.obtainStyledAttributes(r10, R.styleable.OButton);
        o.c(r12, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.changeAlphaWhenPressed = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_buttonChangeAlphaWhenPressed, "styleable", "OButton_oui_buttonChangeAlphaWhenPressed"), false);
        this.disabledAlpha = r12.getFloat(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_widgetDisableAlpha, "styleable", "OButton_oui_widgetDisableAlpha"), 1.0f);
        r12.recycle();
        updateUIOnEnableChanged(isEnabled());
        this.targetLeftPadding = d.i.a.a(16 * ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getDisplayMetrics().density);
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L10;
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(0);
        r13.setCornerRadius(getRadius());
        Drawable r14 = getBackground();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        r13.setColor(((ColorDrawable) ZeusTransformUtils.preCheckCast(r14, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor());
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r13, Drawable.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void setAlignmentProgress(float r2) {
        if (this.alignmentProgress != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.alignmentProgress = r2;
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setTargetLeftPadding(int r1) {
        this.targetLeftPadding = r1;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r5) {
        o.e(r5, "canvas");
        if (this.alignmentProgress != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        super.onDraw(r5);
        return;
    L9:
        Drawable r1 = getDrawable();
        if (r1 != null) goto L13;
        OIconButton r2 = (OIconButton) ZeusTransformUtils.preCheckCast(this, OIconButton.class, "com.obric.aiagent.plugin");
        super.onDraw(r5);
        return;
    L13:
        int r3 = r1.getIntrinsicWidth();
        if (r3 > 0) goto L17;
        super.onDraw(r5);
        return;
    L17:
        float r4 = (this.targetLeftPadding - (getPaddingLeft() + ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - r3) / 2.0f))) * this.alignmentProgress;
        int r6 = r5.save();
        r5.translate(r4, 0.0f);
        super.onDraw(r5);
        r5.restoreToCount(r6);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.View
    public void setBackgroundColor(int r3) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(getRadius());
        r0.setColor(r3);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.View
    public void setPressed(boolean r4) {
        super.setPressed(r4);
        e r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L6;
        r0.b(r4);
    L6:
        c r1 = this.mAlphaHelper;
        if (r1 == null) goto L11;
        r1.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
        return;
    }

    private final void setPressState(boolean r4) {
        if (this.internalPressState != r4) goto L5;
        return;
    L5:
        this.internalPressState = r4;
        e r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L9;
        r0.b(r4);
    L9:
        c r1 = this.mAlphaHelper;
        if (r1 == null) goto L14;
        r1.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        c r0 = this.mAlphaHelper;
        if (r0 == null) goto L6;
        r0.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
    L6:
        updateUIOnEnableChanged(r4);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        c r0 = this.mAlphaHelper;
        if (r0 == null) goto L7;
        r0.onSelectedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        o.e(r2, "canvas");
        f r0 = this.mLayoutHelper;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        super.draw(r2);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r4) {
        o.e(r4, "canvas");
        super.dispatchDraw(r4);
        f r0 = this.mLayoutHelper;
        if (r0 == null) goto L6;
        r0.a(r4, getWidth(), getHeight());
    L6:
        f r3 = this.mLayoutHelper;
        if (r3 == null) goto L11;
        r3.b(r4);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void onPressAlphaChange(int r3) {
        if (this.changeAlphaWhenPressed == true) goto L5;
        return;
    L5:
        updateIconAlphaOnPress(n.a(r3 / 255.0f, 0.0f, 1.0f));
    }

    public final void setDisabledAlpha(float r1) {
        this.disabledAlpha = r1;
        if (isEnabled() == true) goto L6;
        updateUIOnEnableChanged(false);
        return;
    }

    private final void updateUIOnEnableChanged(boolean r2) {
        if (r2 == true) goto L8;
        Drawable r3 = getDrawable();
        if (r3 == null) goto L14;
        r3.setAlpha((int) (this.disabledAlpha * 255));
        return;
    L14:
        return;
    L8:
        Drawable r1 = getDrawable();
        if (r1 == null) goto L15;
        r1.setAlpha(255);
        return;
    }

    private final void updateIconAlphaOnPress(float r3) {
        if (this.originIconAlpha != 0) goto L5;
        this.originIconAlpha = getImageAlpha();
    L5:
        int r0 = this.originIconAlpha;
        if (r0 != 0) goto L8;
        return;
    L8:
        setImageAlpha(n.a((int) (r0 * getAnimatedPressAlpha(r3)), 0, 255));
    }
}
