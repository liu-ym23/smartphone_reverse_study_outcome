package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.core.content.a;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OCheckBoxLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OCheckBoxLayout extends FrameLayout implements Checkable {
    private final OStateGradientDrawable backgroundDrawable;
    private OCheckBox checkBox;
    private int layoutSizePx;

    public OCheckBoxLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCheckBoxLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    public /* synthetic */ OCheckBoxLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OCheckBoxLayout(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        OStateGradientDrawable r0 = new OStateGradientDrawable();
        this.backgroundDrawable = r0;
        refreshDimensionCache();
        if (r10 == null) goto L5;
        OCheckBox r4 = new OCheckBox(r9, r10, r8);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 17;
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.checkBox = r4;
        addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
    L6:
        this.checkBox.setEnableExpandTouchRect(false);
        r0.setCornerRadius(this.layoutSizePx);
        ColorStateList r12 = a.b(r9, ZeusTransformUtils.mapRes(R.color.o_checkbox_layout_bg_color, "color", "o_checkbox_layout_bg_color"));
        o.a(r12);
        o.c(r12, "getColorStateList(contex…eckbox_layout_bg_color)!!");
        r0.setSolidColors(r12);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.aiagent.plugin"));
        setClickable(true);
        return;
    L5:
        OCheckBox r13 = new OCheckBox(r9);
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 17;
        r13.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.checkBox = r13;
        addView((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.aiagent.plugin"));
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec(this.layoutSizePx, 1073741824);
        super.onMeasure(r3, r3);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
        this.backgroundDrawable.setCornerRadius(this.layoutSizePx);
    }

    private final void refreshDimensionCache() {
        this.layoutSizePx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 32);
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.checkBox.performClick();
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.checkBox.setEnabled(r1);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        this.checkBox.setChecked(r1);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.checkBox.toggle();
    }

    public final int getCheckedState() {
        return this.checkBox.getCheckedState();
    }

    public final void setCheckedState(int r1) {
        this.checkBox.setCheckedState(r1);
    }

    public final void setOnCheckedChangeListener(OCheckBox.b r3) {
        OCheckBox.b r4 = (OCheckBox.b) ZeusTransformUtils.wrapperContextForParams(r3, OCheckBox.b.class, "com.obric.aiagent.plugin");
        this.checkBox.setOnCheckedChangeListener(r4);
    }

    public final void setOnCheckedStateChangedListener(OCheckBox.c r3) {
        OCheckBox.c r4 = (OCheckBox.c) ZeusTransformUtils.wrapperContextForParams(r3, OCheckBox.c.class, "com.obric.aiagent.plugin");
        this.checkBox.setOnCheckedStateChangedListener(r4);
    }

    public final void setPrimaryColor(int r1) {
        this.checkBox.setPrimaryColor(r1);
    }

    public final void setAlwaysLight(boolean r1) {
        this.checkBox.setAlwaysLight(r1);
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }
}
