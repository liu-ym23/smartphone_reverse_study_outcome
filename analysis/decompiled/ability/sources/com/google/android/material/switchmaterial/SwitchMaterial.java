package com.google.android.material.switchmaterial;

import Z2.a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.internal.k;

/* loaded from: classes3.dex */
public class SwitchMaterial extends SwitchCompat {
    public static final int[][] e = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: a, reason: collision with root package name */
    public final a f2599a;
    public ColorStateList b;
    public ColorStateList c;
    public boolean d;

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i = androidx.appcompat.R.attr.switchStyle;
        super(i3.a.a(context, attributeSet, i, com.stepos.ability.R.style.Widget_MaterialComponents_CompoundButton_Switch), attributeSet, i);
        Context context2 = getContext();
        this.f2599a = new a(context2);
        k.a(context2, attributeSet, i, com.stepos.ability.R.style.Widget_MaterialComponents_CompoundButton_Switch);
        int[] iArr = P2.a.f1069I;
        k.b(context2, attributeSet, iArr, i, com.stepos.ability.R.style.Widget_MaterialComponents_CompoundButton_Switch, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i, com.stepos.ability.R.style.Widget_MaterialComponents_CompoundButton_Switch);
        this.d = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() throws Resources.NotFoundException {
        if (this.b == null) {
            int iA = W2.a.a(com.stepos.ability.R.attr.colorSurface, this);
            int iA2 = W2.a.a(androidx.appcompat.R.attr.colorControlActivated, this);
            float dimension = getResources().getDimension(com.stepos.ability.R.dimen.mtrl_switch_thumb_elevation);
            a aVar = this.f2599a;
            if (aVar.f1583a) {
                float elevation = 0.0f;
                for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                    elevation += ((View) parent).getElevation();
                }
                dimension += elevation;
            }
            int iA3 = aVar.a(dimension, iA);
            this.b = new ColorStateList(e, new int[]{W2.a.c(1.0f, iA, iA2), iA3, W2.a.c(0.38f, iA, iA2), iA3});
        }
        return this.b;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.c == null) {
            int iA = W2.a.a(com.stepos.ability.R.attr.colorSurface, this);
            int iA2 = W2.a.a(androidx.appcompat.R.attr.colorControlActivated, this);
            int iA3 = W2.a.a(com.stepos.ability.R.attr.colorOnSurface, this);
            this.c = new ColorStateList(e, new int[]{W2.a.c(0.54f, iA, iA2), W2.a.c(0.32f, iA, iA3), W2.a.c(0.12f, iA, iA2), W2.a.c(0.12f, iA, iA3)});
        }
        return this.c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.d && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.d = z10;
        if (z10) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }
}
