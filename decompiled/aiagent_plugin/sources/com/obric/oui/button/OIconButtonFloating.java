package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: OIconButtonFloating.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OIconButtonFloating extends OShadowFrame {
    private AppCompatImageView iconView;

    public OIconButtonFloating(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OIconButtonFloating(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OIconButtonFloating(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public /* synthetic */ OIconButtonFloating(Context r2, AttributeSet r3, int r4, int r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r8, r9, r4, r5);
    }

    public OIconButtonFloating(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r5, r6);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void initContent(Context r7, FrameLayout r8, AttributeSet r9, TypedArray r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        o.e(r8, "contentView");
        if (r10 != null) goto L5;
        return;
    L5:
        ColorStateList r13 = r10.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetTintColor, "styleable", "OShadowFrame_oui_widgetTintColor"));
        Drawable r0 = r10.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetIcon, "styleable", "OShadowFrame_oui_widgetIcon"));
        AppCompatImageView r2 = new AppCompatImageView(r11);
        this.iconView = r2;
        AppCompatImageView r3 = null;
        if (r2 != null) goto L8;
        o.c("iconView");
        r2 = null;
    L8:
        r2.setDuplicateParentStateEnabled(true);
        if (r0 == null) goto L19;
        AppCompatImageView r4 = this.iconView;
        if (r4 != null) goto L13;
        o.c("iconView");
        r4 = null;
    L13:
        r4.setImageDrawable(r0);
        if (r13 == null) goto L19;
        AppCompatImageView r1 = this.iconView;
        if (r1 != null) goto L18;
        o.c("iconView");
        r1 = null;
    L18:
        r1.setImageTintList(r13);
    L19:
        AppCompatImageView r14 = this.iconView;
        if (r14 != null) goto L22;
        o.c("iconView");
    L23:
        View r15 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, -1);
        r5.gravity = 17;
        x r6 = x.f38692a;
        r8.addView(r15, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        if (getEnableMaterial() == false) goto L27;
        initMaterials(r11, r10);
        return;
    L27:
        return;
    L22:
        r3 = r14;
        goto L23
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void applyDynamicTheme(int r1) {
        super.applyDynamicTheme(r1);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void updateUIOnEnableChanged(boolean r3) {
        super.updateUIOnEnableChanged(r3);
        AppCompatImageView r0 = null;
        if (r3 == false) goto L9;
        AppCompatImageView r2 = this.iconView;
        if (r2 != null) goto L7;
        o.c("iconView");
    L8:
        r0.setAlpha(1.0f);
        return;
    L7:
        r0 = r2;
        goto L8
    L9:
        AppCompatImageView r4 = this.iconView;
        if (r4 != null) goto L12;
        o.c("iconView");
    L13:
        r0.setAlpha(0.3f);
        return;
    L12:
        r0 = r4;
        goto L13
    }

    public final void setIcon(int r1) {
        AppCompatImageView r0 = this.iconView;
        if (r0 != null) goto L5;
        o.c("iconView");
        r0 = null;
    L5:
        r0.setImageResource(r1);
    }

    public final void setIcon(Drawable r2) {
        o.e(r2, "drawable");
        AppCompatImageView r1 = this.iconView;
        if (r1 != null) goto L5;
        o.c("iconView");
        r1 = null;
    L5:
        r1.setImageDrawable(r2);
    }

    public final void setIconTintColor(int r1) {
        AppCompatImageView r0 = this.iconView;
        if (r0 != null) goto L5;
        o.c("iconView");
        r0 = null;
    L5:
        r0.setColorFilter(r1);
    }

    public final void setIconTintColor(ColorStateList r2) {
        o.e(r2, "color");
        AppCompatImageView r1 = this.iconView;
        if (r1 != null) goto L5;
        o.c("iconView");
        r1 = null;
    L5:
        r1.setImageTintList(r2);
    }

    public final void setIconBgColor(int r1) {
        setBgColor(r1);
    }
}
