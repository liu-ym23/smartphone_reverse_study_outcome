package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.bdturing.localstorage.DbHelper;
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

/* JADX INFO: compiled from: OButton.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OButton extends Button implements com.obric.oui.common.style.a, b {
    private static final float ALPHA_ON_PRESS = 0.3f;
    public static final a Companion = null;
    private static final String TAG = "OButton";
    private final /* synthetic */ com.obric.oui.common.style.a $$delegate_0;
    private final /* synthetic */ b $$delegate_1;
    private final /* synthetic */ i $$delegate_2;
    private boolean changeAlphaWhenPressed;
    private int customPaddingOffset;
    private float disabledAlpha;
    private boolean internalPressState;
    private boolean isInternalTextColorChange;
    private c mAlphaHelper;
    private Drawable mIcon;
    private int mImageSourceId;
    private int mImageTintColorId;
    private f mLayoutHelper;
    private e mOUIEffectHelper;
    private int originIconAlpha;
    private int originTextColor;

    /* JADX INFO: compiled from: OButton.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final OButton a(Context r4, ViewGroup r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            o.e(r5, "root");
            return a(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_button_neutral, "layout", "o_widget_titlebar_button_neutral"));
        }

        public final OButton b(Context r4, ViewGroup r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            o.e(r5, "root");
            return a(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_primary_button, "layout", "o_widget_titlebar_primary_button"));
        }

        public final OButton c(Context r4, ViewGroup r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            o.e(r5, "root");
            return a(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_primarylight_button, "layout", "o_widget_titlebar_primarylight_button"));
        }

        public final OButton d(Context r4, ViewGroup r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            o.e(r5, "root");
            return a(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_trans_button, "layout", "o_widget_titlebar_trans_button"));
        }

        public final OButton e(Context r4, ViewGroup r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            o.e(r5, "root");
            return a(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_understated_button, "layout", "o_widget_titlebar_understated_button"));
        }

        public final OButton a(Context r5, ViewGroup r6, int r7) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            o.e(r6, "root");
            if (((OButton) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.btn_titlebar, DbHelper.COL_ID, "btn_titlebar")), OButton.class, "com.obric.aiagent.plugin")) != null) goto L5;
            View r8 = Button.inflate(r4, r7, r6).findViewById(ZeusTransformUtils.mapRes(R.id.btn_titlebar, DbHelper.COL_ID, "btn_titlebar"));
            o.a(r8);
            return (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.aiagent.plugin");
        L5:
            View r9 = ZeusTransformUtils.inflate(LayoutInflater.from(r4), r7, r6, false, "com.obric.aiagent.plugin");
            Objects.requireNonNull(r9, "null cannot be cast to non-null type com.obric.oui.button.OButton");
            OButton r10 = (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.aiagent.plugin");
            r10.setId(-1);
            r6.addView((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
            return r10;
        }
    }

    static {
        Companion = new a(null);
    }

    public OButton(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, null, 28, null);
    }

    public OButton(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r13, 0, null, 24, null);
    }

    public OButton(Context r11, AttributeSet r12, int r13, int r14) {
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

    public /* synthetic */ OButton(Context r4, AttributeSet r5, int r6, int r7, i r8, int r9, h r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if ((r9 & 4) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r9 & 8) != 0) goto L11;
        r0 = r7;
    L11:
        if ((r9 & 16) == 0) goto L13;
        r8 = new i(r11, r12, r1, r0);
    L13:
        this(r11, r12, r1, r0, r8);
        return;
    L5:
        r1 = r6;
        goto L7
    }

    public OButton(Context r2, AttributeSet r3, int r4, int r5, i r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r6, "provider");
        super(r7, r8, r4);
        this.$$delegate_0 = r6.a();
        this.$$delegate_1 = r6.b();
        this.$$delegate_2 = r6;
        this.disabledAlpha = 1.0f;
        ((f) ZeusTransformUtils.preCheckCast(r6.b(), f.class, "com.obric.aiagent.plugin")).a(true);
        r6.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        this.mLayoutHelper = (f) ZeusTransformUtils.preCheckCast(getLayoutHelper(), f.class, "com.obric.aiagent.plugin");
        this.mAlphaHelper = (c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), c.class, "com.obric.aiagent.plugin");
        this.mOUIEffectHelper = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        initView(r7, r8);
    }

    public final Drawable getMIcon() {
        return this.mIcon;
    }

    public final void setMIcon(Drawable r1) {
        this.mIcon = r1;
        requestLayout();
        invalidate();
    }

    public final int getMImageTintColorId() {
        return this.mImageTintColorId;
    }

    public final void setMImageTintColorId(int r1) {
        this.mImageTintColorId = r1;
        invalidate();
    }

    private final void initView(Context r7, AttributeSet r8) {
        TypedArray r9 = ((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.OButton);
        o.c(r9, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.mImageSourceId = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OButton_icon, "styleable", "OButton_icon"), 0);
        setMImageTintColorId(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OButton_iconTint, "styleable", "OButton_iconTint"), 0));
        int r10 = this.mImageSourceId;
        if (r10 == 0) goto L5;
        setButtonSourceBitmap(r10);
    L5:
        setTextAppearance(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_buttonTextStyle, "styleable", "OButton_oui_buttonTextStyle"), ZeusTransformUtils.mapRes(R.style.Title_Title_M_Thick, "style", "Title_Title_M_Thick")));
        this.changeAlphaWhenPressed = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_buttonChangeAlphaWhenPressed, "styleable", "OButton_oui_buttonChangeAlphaWhenPressed"), false);
        int r11 = getCurrentTextColor();
        this.originTextColor = r11;
        ColorStateList r12 = ColorStateList.valueOf(r11);
        o.c(r12, "valueOf(textColor)");
        setCompoundDrawableTintList(r12);
        this.customPaddingOffset = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_widgetPaddingOffset, "styleable", "OButton_oui_widgetPaddingOffset"), 0);
        Drawable[] r13 = getCompoundDrawables();
        o.c(r13, "getCompoundDrawables()");
        if (((Drawable) ZeusTransformUtils.preCheckCast(d.a.i.b((Object[]) ZeusTransformUtils.preCheckCast(r13, Object[].class, "com.obric.aiagent.plugin"), 0), Drawable.class, "com.obric.aiagent.plugin")) == null) goto L8;
        adjustPaddingLeft(true);
    L8:
        this.disabledAlpha = r9.getFloat(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_widgetDisableAlpha, "styleable", "OButton_oui_widgetDisableAlpha"), 1.0f);
        r9.recycle();
        updateContentColorForState(isEnabled());
    }

    public final void setButtonSourceBitmap(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        setMIcon(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
        Drawable r5 = this.mIcon;
        if (r5 != null) goto L7;
        int r6 = 0;
    L8:
        this.originIconAlpha = r6;
        invalidate();
        return;
    L7:
        r6 = r5.getAlpha();
        goto L8
    }

    public final void setButtonSourceBitmap(int r4, int r5) {
        if (r4 != 0) goto L4;
        return;
    L4:
        Drawable r6 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        if (r6 != null) goto L7;
        Drawable r7 = null;
    L8:
        setMIcon(r7);
        Drawable r8 = this.mIcon;
        if (r8 == null) goto L12;
        r8.setTint(r5);
    L12:
        Drawable r9 = this.mIcon;
        if (r9 != null) goto L15;
        int r10 = 0;
    L16:
        this.originIconAlpha = r10;
        invalidate();
        return;
    L15:
        r10 = r9.getAlpha();
        goto L16
    L7:
        r7 = r6.mutate();
        goto L8
    }

    private final Bitmap getBitmapFromVectorDrawable(VectorDrawable r5) {
        Bitmap r4 = Bitmap.createBitmap(r5.getIntrinsicWidth(), r5.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r4);
        r5.setBounds(0, 0, r0.getWidth(), r0.getHeight());
        r5.draw(r0);
        o.c(r4, "bitmap");
        return r4;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r2) {
        o.e(r2, "canvas");
        super.onDraw(r2);
        drawIcon(r2);
    }

    public final void drawIcon(Canvas r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Drawable r0 = this.mIcon;
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = (getWidth() - r0.getIntrinsicWidth()) / 2;
        int r2 = (getHeight() - r0.getIntrinsicHeight()) / 2;
        r0.setBounds(r1, r2, r0.getIntrinsicWidth() + r1, r0.getIntrinsicHeight() + r2);
        if (this.mImageTintColorId == 0) goto L10;
        r0.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new PorterDuffColorFilter(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(this.mImageTintColorId), PorterDuff.Mode.SRC_IN), ColorFilter.class, "com.obric.aiagent.plugin"));
    L10:
        r0.draw(r6);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = getMeasuredWidth();
        int r7 = getMeasuredHeight();
        Drawable r0 = this.mIcon;
        if (r0 == null) goto L6;
        r6 = Math.max(r6, (r0.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight());
        r7 = Math.max(r7, (r0.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom());
    L6:
        setMeasuredDimension(r6, r7);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        c r0 = this.mAlphaHelper;
        if (r0 == null) goto L7;
        r0.onSelectedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        c r0 = this.mAlphaHelper;
        if (r0 == null) goto L6;
        r0.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
    L6:
        updateContentColorForState(r4);
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
        if (this.internalPressState != r4) goto L6;
        com.obric.oui.d.a.b.d(TAG, o.a("setPressState, already set, skip! pressed: ", Boolean.valueOf(r4)));
        return;
    L6:
        this.internalPressState = r4;
        e r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L10;
        r0.b(r4);
    L10:
        c r1 = this.mAlphaHelper;
        if (r1 == null) goto L15;
        r1.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void onPressAlphaChange(int r3) {
        if (this.changeAlphaWhenPressed == true) goto L5;
        return;
    L5:
        float r4 = n.a(r3 / 255.0f, 0.0f, 1.0f);
        updateTextColorOnPress(r4);
        updateIconAlphaOnPress(r4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        adjustPaddingLeft(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        adjustPaddingLeft(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void setDisabledTextAlpha(float r1) {
        this.disabledAlpha = r1;
        if (isEnabled() == true) goto L6;
        updateContentColorForState(false);
        return;
    }

    @Override // android.widget.TextView
    public void setTextColor(int r2) {
        if (this.isInternalTextColorChange == true) goto L5;
        this.originTextColor = r2;
    L5:
        super.setTextColor(r2);
    }

    private final void updateContentColorForState(boolean r8) {
        int r0 = this.originTextColor;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r4 = 0;
        if (r8 == true) goto L14;
        int r9 = com.obric.oui.d.h.a(r0, this.disabledAlpha);
        this.isInternalTextColorChange = true;
        super.setTextColor(r9);
        this.isInternalTextColorChange = false;
        Drawable[] r10 = getCompoundDrawables();
        o.c(r10, "compoundDrawables");
        Object[] r11 = (Object[]) ZeusTransformUtils.preCheckCast(r10, Object[].class, "com.obric.aiagent.plugin");
        int r1 = r11.length;
    L8:
        if (r4 >= r1) goto L21;
        Drawable r2 = (Drawable) ZeusTransformUtils.preCheckCast(r11[r4], Drawable.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L13;
        r2.setAlpha((int) (this.disabledAlpha * 255));
    L13:
        r4 = r4 + 1;
    L21:
        invalidate();
        return;
    L14:
        this.isInternalTextColorChange = true;
        super.setTextColor(r0);
        this.isInternalTextColorChange = false;
        Drawable[] r12 = getCompoundDrawables();
        o.c(r12, "compoundDrawables");
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        int r3 = r13.length;
    L15:
        if (r4 >= r3) goto L21;
        Drawable r5 = (Drawable) ZeusTransformUtils.preCheckCast(r13[r4], Drawable.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L20;
        r5.setAlpha(255);
    L20:
        r4 = r4 + 1;
        goto L15
    }

    private final void adjustPaddingLeft(boolean r5) {
        int r0 = getPaddingTop();
        int r1 = getPaddingRight();
        int r2 = getPaddingBottom();
        if (r5 == false) goto L5;
        int r6 = getPaddingRight() - this.customPaddingOffset;
    L7:
        if (r6 == getPaddingLeft()) goto L10;
        setPadding(r6, r0, r1, r2);
        return;
    L10:
        return;
    L5:
        r6 = getPaddingRight();
        goto L7
    }

    private final void updateTextColorOnPress(float r8) {
        int r0 = this.originTextColor;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = (r0 >> 24) & 255;
        int r2 = n.a((int) (r1 * getAnimatedPressAlpha(r8)), 0, 255);
        int r3 = ((r0 >> 16) & 255) << 16;
        setTextColor((r0 & 255) | ((r3 | (r2 << 24)) | (((r0 >> 8) & 255) << 8)));
        com.obric.oui.d.a.b.b(TAG, "updateTextColorOnPress, fraction: " + r8 + ", newTextAlpha: " + r2 + ", originTextAlpha: " + r1);
    }

    private final void updateIconAlphaOnPress(float r4) {
        int r0 = this.originIconAlpha;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = n.a((int) (r0 * getAnimatedPressAlpha(r4)), 0, 255);
        Drawable r2 = this.mIcon;
        if (r2 == null) goto L9;
        r2.setAlpha(r1);
    L9:
        com.obric.oui.d.a.b.b(TAG, "updateIconAlphaOnPress, fraction: " + r4 + ", alpha: " + r1 + ", originIconAlpha: " + this.originIconAlpha);
    }
}
