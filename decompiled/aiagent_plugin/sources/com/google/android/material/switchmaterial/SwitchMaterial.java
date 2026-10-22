package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.c.a;
import com.google.android.material.color.b;
import com.google.android.material.internal.l;
import com.google.android.material.internal.r;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchMaterial extends SwitchCompat {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;
    private final a elevationOverlayProvider;
    private ColorStateList materialThemeColorsThumbTintList;
    private ColorStateList materialThemeColorsTrackTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_CompoundButton_Switch, "style", "Widget_MaterialComponents_CompoundButton_Switch");
        ENABLED_CHECKED_STATES = new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public SwitchMaterial(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public SwitchMaterial(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.switchStyle, "attr", "switchStyle"));
    }

    public SwitchMaterial(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r12, r3, r11, r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r11);
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.elevationOverlayProvider = new a(r2);
        TypedArray r13 = l.a(r2, r3, R.styleable.SwitchMaterial, r11, r6, new int[0]);
        this.useMaterialThemeColors = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SwitchMaterial_useMaterialThemeColors, "styleable", "SwitchMaterial_useMaterialThemeColors"), false);
        r13.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors == false) goto L8;
        if (getThumbTintList() != null) goto L8;
        setThumbTintList(getMaterialThemeColorsThumbTintList());
    L8:
        if (this.useMaterialThemeColors == true) goto L10;
        return;
    L10:
        if (getTrackTintList() != null) goto L14;
        setTrackTintList(getMaterialThemeColorsTrackTintList());
        return;
    }

    public void setUseMaterialThemeColors(boolean r1) {
        this.useMaterialThemeColors = r1;
        if (r1 == false) goto L5;
        setThumbTintList(getMaterialThemeColorsThumbTintList());
        setTrackTintList(getMaterialThemeColorsTrackTintList());
        return;
    L5:
        setThumbTintList(null);
        setTrackTintList(null);
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.materialThemeColorsThumbTintList != null) goto L9;
        int r0 = b.a(this, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"));
        int r1 = b.a(this, ZeusTransformUtils.mapRes(R.attr.colorControlActivated, "attr", "colorControlActivated"));
        float r2 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.mtrl_switch_thumb_elevation, "dimen", "mtrl_switch_thumb_elevation"));
        if (this.elevationOverlayProvider.a() == false) goto L7;
        r2 = r2 + r.d(this);
    L7:
        int r3 = this.elevationOverlayProvider.a(r0, r2);
        int[][] r4 = ENABLED_CHECKED_STATES;
        int[] r5 = new int[r4.length];
        r5[0] = b.a(r0, r1, 1.0f);
        r5[1] = r3;
        r5[2] = b.a(r0, r1, 0.38f);
        r5[3] = r3;
        this.materialThemeColorsThumbTintList = new ColorStateList(r4, r5);
    L9:
        return this.materialThemeColorsThumbTintList;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.materialThemeColorsTrackTintList != null) goto L6;
        int[][] r0 = ENABLED_CHECKED_STATES;
        int[] r1 = new int[r0.length];
        int r2 = b.a(this, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"));
        int r4 = b.a(this, ZeusTransformUtils.mapRes(R.attr.colorControlActivated, "attr", "colorControlActivated"));
        int r3 = b.a(this, ZeusTransformUtils.mapRes(R.attr.colorOnSurface, "attr", "colorOnSurface"));
        r1[0] = b.a(r2, r4, 0.54f);
        r1[1] = b.a(r2, r3, 0.32f);
        r1[2] = b.a(r2, r4, 0.12f);
        r1[3] = b.a(r2, r3, 0.12f);
        this.materialThemeColorsTrackTintList = new ColorStateList(r0, r1);
    L6:
        return this.materialThemeColorsTrackTintList;
    }
}
