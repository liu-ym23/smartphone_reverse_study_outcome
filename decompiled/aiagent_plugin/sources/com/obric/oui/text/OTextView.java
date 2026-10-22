package com.obric.oui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.a;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.c;
import com.obric.oui.common.style.e;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: OTextView.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OTextView extends TextView implements a, b {
    private final /* synthetic */ a $$delegate_0;
    private final /* synthetic */ b $$delegate_1;
    private final /* synthetic */ i $$delegate_2;
    private boolean enableAutoAlignLeft;
    private c mAlphaHelper;
    private f mLayoutHelper;
    private e mOUIEffectHelper;
    private final int originalGravity;

    public OTextView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, null, 14, null);
    }

    public OTextView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, null, 12, null);
    }

    public OTextView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, null, 8, null);
    }

    @Override // com.obric.oui.common.style.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.$$delegate_1.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.a
    public void disablePressReleaseAnim(boolean r1) {
        this.$$delegate_0.disablePressReleaseAnim(r1);
    }

    public a getAlphaHelper() {
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

    @Override // android.widget.TextView, com.obric.oui.common.style.b
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

    @Override // com.obric.oui.common.style.b
    public void onPressAlphaChange(int r1) {
        this.$$delegate_1.onPressAlphaChange(r1);
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

    public /* synthetic */ OTextView(Context r2, AttributeSet r3, int r4, i r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = new i(r8, r9, r4, 0);
    L11:
        this(r8, r9, r4, r5);
    }

    public OTextView(Context r3, AttributeSet r4, int r5, i r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r6, "provider");
        super(r7, r8, r5);
        this.$$delegate_0 = r6.a();
        this.$$delegate_1 = r6.b();
        this.$$delegate_2 = r6;
        this.originalGravity = getGravity();
        r6.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        this.mLayoutHelper = (f) ZeusTransformUtils.preCheckCast(getLayoutHelper(), f.class, "com.obric.aiagent.plugin");
        this.mAlphaHelper = (c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), c.class, "com.obric.aiagent.plugin");
        this.mOUIEffectHelper = getEffectHelper();
        c r9 = this.mAlphaHelper;
        if (r9 == null) goto L6;
        r9.setChangeAlphaWhenPress(false);
    L6:
        c r10 = this.mAlphaHelper;
        if (r10 == null) goto L10;
        r10.setChangeAlphaWhenDisable(false);
    L10:
        setHighlightColor(r7.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_highlight_color, "color", "oui_text_highlight_color")));
        setIncludeFontPadding(false);
    }

    public final boolean getEnableAutoAlignLeft() {
        return this.enableAutoAlignLeft;
    }

    public final void setEnableAutoAlignLeft(boolean r2) {
        if (this.enableAutoAlignLeft == r2) goto L6;
        this.enableAutoAlignLeft = r2;
        requestLayout();
        return;
    }

    @Override // android.view.View
    public void setPressed(boolean r4) {
        e r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L6;
        r0.b(r4);
    L6:
        super.setPressed(r4);
        c r1 = this.mAlphaHelper;
        if (r1 == null) goto L11;
        r1.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
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

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.enableAutoAlignLeft == false) goto L6;
        updateGravityForText();
        return;
    }

    private final void updateGravityForText() {
        int r1 = 1;
        if (getLineCount() > 1) goto L5;
        boolean r0 = true;
    L6:
        int r2 = this.originalGravity & 112;
        if (r0 == true) goto L10;
        r1 = 3;
    L10:
        int r3 = r2 | r1;
        if (getGravity() == r3) goto L14;
        setGravity(r3);
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
