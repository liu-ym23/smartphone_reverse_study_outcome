package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.c;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;

    @Nullable
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
        ENABLED_CHECKED_STATES = new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public MaterialCheckBox(Context r10) {
        this(r10, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList != null) goto L6;
        int[][] r10 = ENABLED_CHECKED_STATES;
        int[] r11 = new int[r10.length];
        int r12 = MaterialColors.getColor(this, R.attr.colorControlActivated);
        int r13 = MaterialColors.getColor(this, R.attr.colorSurface);
        int r14 = MaterialColors.getColor(this, R.attr.colorOnSurface);
        r11[0] = MaterialColors.layer(r13, r12, 1.0f);
        r11[1] = MaterialColors.layer(r13, r14, 0.54f);
        r11[2] = MaterialColors.layer(r13, r14, 0.38f);
        r11[3] = MaterialColors.layer(r13, r14, 0.38f);
        this.materialThemeColorsTintList = new ColorStateList(r10, r11);
    L6:
        return this.materialThemeColorsTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors == true) goto L5;
        return;
    L5:
        if (c.b(this) != null) goto L9;
        setUseMaterialThemeColors(true);
        return;
    }

    public void setUseMaterialThemeColors(boolean r10) {
        this.useMaterialThemeColors = r10;
        if (r10 == false) goto L5;
        c.c(this, getMaterialThemeColorsTintList());
        return;
    L5:
        c.c(this, null);
    }

    public MaterialCheckBox(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.checkboxStyle);
    }

    public MaterialCheckBox(Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        Context r14 = getContext();
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r14, r11, R.styleable.MaterialCheckBox, r12, r13, new int[0]);
        int r16 = R.styleable.MaterialCheckBox_buttonTint;
        if (r15.hasValue(r16) == false) goto L5;
        c.c(this, MaterialResources.getColorStateList(r14, r15, r16));
    L5:
        this.useMaterialThemeColors = r15.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        r15.recycle();
    }
}
