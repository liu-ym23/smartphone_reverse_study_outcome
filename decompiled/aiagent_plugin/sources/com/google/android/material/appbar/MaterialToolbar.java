package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.l;
import com.google.android.material.internal.m;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.i;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {
    private static final int DEF_STYLE_RES = 0;
    private static final ImageView.ScaleType[] LOGO_SCALE_TYPE_ARRAY = null;
    private Boolean logoAdjustViewBounds;
    private ImageView.ScaleType logoScaleType;
    private Integer navigationIconTint;
    private boolean subtitleCentered;
    private boolean titleCentered;

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_Toolbar, "style", "Widget_MaterialComponents_Toolbar");
        LOGO_SCALE_TYPE_ARRAY = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public MaterialToolbar(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public MaterialToolbar(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.toolbarStyle, "attr", "toolbarStyle"));
    }

    public MaterialToolbar(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r12, r3, r11, r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r11);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        TypedArray r14 = l.a(r13, r3, R.styleable.MaterialToolbar, r11, r6, new int[0]);
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialToolbar_navigationIconTint, "styleable", "MaterialToolbar_navigationIconTint")) == false) goto L5;
        setNavigationIconTint(r14.getColor(ZeusTransformUtils.mapRes(R.styleable.MaterialToolbar_navigationIconTint, "styleable", "MaterialToolbar_navigationIconTint"), -1));
    L5:
        this.titleCentered = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialToolbar_titleCentered, "styleable", "MaterialToolbar_titleCentered"), false);
        this.subtitleCentered = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialToolbar_subtitleCentered, "styleable", "MaterialToolbar_subtitleCentered"), false);
        int r0 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.MaterialToolbar_logoScaleType, "styleable", "MaterialToolbar_logoScaleType"), -1);
        if (r0 < 0) goto L11;
        ImageView.ScaleType[] r2 = LOGO_SCALE_TYPE_ARRAY;
        if (r0 >= r2.length) goto L11;
        this.logoScaleType = r2[r0];
    L11:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialToolbar_logoAdjustViewBounds, "styleable", "MaterialToolbar_logoAdjustViewBounds")) == false) goto L13;
        this.logoAdjustViewBounds = Boolean.valueOf(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialToolbar_logoAdjustViewBounds, "styleable", "MaterialToolbar_logoAdjustViewBounds"), false));
    L13:
        r14.recycle();
        initBackground(r13);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        maybeCenterTitleViews();
        updateLogoImageView();
    }

    private void maybeCenterTitleViews() {
        if (this.titleCentered == false) goto L5;
    L7:
        TextView r0 = m.a(this);
        TextView r1 = m.b(this);
        if (r0 != null) goto L11;
        if (r1 != null) goto L11;
        return;
    L11:
        Pair<Integer, Integer> r2 = calculateTitleBoundLimits(r0, r1);
        if (this.titleCentered == false) goto L16;
        if (r0 == null) goto L16;
        layoutTitleCenteredHorizontally(r0, r2);
    L16:
        if (this.subtitleCentered == false) goto L20;
        if (r1 == null) goto L21;
        layoutTitleCenteredHorizontally(r1, r2);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (this.subtitleCentered == true) goto L7;
    }

    private Pair<Integer, Integer> calculateTitleBoundLimits(TextView r8, TextView r9) {
        int r0 = getMeasuredWidth();
        int r1 = r0 / 2;
        int r2 = getPaddingLeft();
        int r3 = r0 - getPaddingRight();
        int r4 = 0;
    L4:
        if (r4 >= getChildCount()) goto L21;
        View r5 = getChildAt(r4);
        if (r5.getVisibility() == 8) goto L19;
        if (r5 == r8) goto L19;
        if (r5 == r9) goto L19;
        if (r5.getRight() >= r1) goto L15;
        if (r5.getRight() <= r2) goto L15;
        r2 = r5.getRight();
    L15:
        if (r5.getLeft() <= r1) goto L19;
        if (r5.getLeft() >= r3) goto L19;
        r3 = r5.getLeft();
    L19:
        r4 = r4 + 1;
        goto L4
    L21:
        return new Pair(Integer.valueOf(r2), Integer.valueOf(r3));
    }

    private void layoutTitleCenteredHorizontally(View r6, Pair<Integer, Integer> r7) {
        int r5 = getMeasuredWidth();
        int r0 = r6.getMeasuredWidth();
        int r8 = (r5 / 2) - (r0 / 2);
        int r1 = r0 + r8;
        int r9 = Math.max(Math.max(((Integer) ZeusTransformUtils.preCheckCast(r7.first, Integer.class, "com.obric.aiagent.plugin")).intValue() - r8, 0), Math.max(r1 - ((Integer) ZeusTransformUtils.preCheckCast(r7.second, Integer.class, "com.obric.aiagent.plugin")).intValue(), 0));
        if (r9 <= 0) goto L5;
        r8 = r8 + r9;
        r1 = r1 - r9;
        r6.measure(View.MeasureSpec.makeMeasureSpec(r1 - r8, 1073741824), r6.getMeasuredHeightAndState());
    L5:
        r6.layout(r8, r6.getTop(), r1, r6.getBottom());
    }

    private void updateLogoImageView() {
        ImageView r0 = m.c(this);
        if (r0 == null) goto L11;
        Boolean r1 = this.logoAdjustViewBounds;
        if (r1 == null) goto L7;
        r0.setAdjustViewBounds(r1.booleanValue());
    L7:
        ImageView.ScaleType r2 = this.logoScaleType;
        if (r2 == null) goto L12;
        r0.setScaleType(r2);
        return;
    L12:
        return;
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.logoScaleType;
    }

    public void setLogoScaleType(ImageView.ScaleType r2) {
        if (this.logoScaleType == r2) goto L6;
        this.logoScaleType = r2;
        requestLayout();
        return;
    }

    public boolean isLogoAdjustViewBounds() {
        Boolean r0 = this.logoAdjustViewBounds;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.booleanValue() == false) goto L7;
        return true;
    }

    public void setLogoAdjustViewBounds(boolean r2) {
        Boolean r0 = this.logoAdjustViewBounds;
        if (r0 != null) goto L5;
    L6:
        this.logoAdjustViewBounds = Boolean.valueOf(r2);
        requestLayout();
        return;
    L5:
        if (r0.booleanValue() != r2) goto L6;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this);
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        i.a(this, r1);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable r1) {
        super.setNavigationIcon(maybeTintNavigationIcon(r1));
    }

    public void setNavigationIconTint(int r1) {
        this.navigationIconTint = Integer.valueOf(r1);
        Drawable r2 = getNavigationIcon();
        if (r2 == null) goto L6;
        setNavigationIcon(r2);
        return;
    }

    public Integer getNavigationIconTint() {
        return this.navigationIconTint;
    }

    public void setTitleCentered(boolean r2) {
        if (this.titleCentered == r2) goto L6;
        this.titleCentered = r2;
        requestLayout();
        return;
    }

    public boolean isTitleCentered() {
        return this.titleCentered;
    }

    public void setSubtitleCentered(boolean r2) {
        if (this.subtitleCentered == r2) goto L6;
        this.subtitleCentered = r2;
        requestLayout();
        return;
    }

    public boolean isSubtitleCentered() {
        return this.subtitleCentered;
    }

    private void initBackground(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        Drawable r0 = getBackground();
        if (r0 != null) goto L5;
    L7:
        MaterialShapeDrawable r2 = new MaterialShapeDrawable();
        if (r0 == null) goto L10;
        int r1 = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r0, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor();
    L11:
        r2.setFillColor(ColorStateList.valueOf(r1));
        r2.initializeElevationOverlay(r6);
        r2.setElevation(ViewCompat.q(this));
        ViewCompat.a(this, r2);
        return;
    L10:
        r1 = 0;
        goto L11
    L5:
        if (ZeusTransformUtils.instanceOf(r0, ColorDrawable.class) == true) goto L7;
    }

    private Drawable maybeTintNavigationIcon(Drawable r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (this.navigationIconTint == null) goto L8;
        Drawable r3 = androidx.core.graphics.drawable.a.g(r2.mutate());
        androidx.core.graphics.drawable.a.a(r3, this.navigationIconTint.intValue());
        return r3;
    L8:
        return r2;
    }
}
