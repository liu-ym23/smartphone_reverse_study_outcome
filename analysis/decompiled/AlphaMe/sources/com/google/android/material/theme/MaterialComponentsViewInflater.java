package com.google.android.material.theme;

import B0.f;
import C1.a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.app.I;
import androidx.appcompat.widget.C0200f0;
import androidx.appcompat.widget.C0226t;
import androidx.appcompat.widget.C0230v;
import androidx.appcompat.widget.C0232w;
import androidx.appcompat.widget.K;
import androidx.core.widget.b;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.c;
import com.google.android.material.internal.l;
import com.google.android.material.textfield.u;
import com.stepos.alphame.R;
import f1.AbstractC0557a;
import m1.AbstractC0769a;
import v1.C0953a;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends I {
    @Override // androidx.appcompat.app.I
    public final C0226t a(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    @Override // androidx.appcompat.app.I
    public final C0230v b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.I
    public final C0232w c(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.appcompat.app.I
    public final K d(Context context, AttributeSet attributeSet) {
        C0953a c0953a = new C0953a(a.b(context, attributeSet, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet);
        Context context2 = c0953a.getContext();
        TypedArray typedArrayE = l.e(context2, attributeSet, AbstractC0769a.f13555u, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (typedArrayE.hasValue(0)) {
            b.c(c0953a, f.y(context2, typedArrayE, 0));
        }
        c0953a.f15720f = typedArrayE.getBoolean(1, false);
        typedArrayE.recycle();
        return c0953a;
    }

    @Override // androidx.appcompat.app.I
    public final C0200f0 e(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        B1.a aVar = new B1.a(a.b(context, attributeSet, android.R.attr.textViewStyle, 0), attributeSet, android.R.attr.textViewStyle);
        Context context2 = aVar.getContext();
        if (AbstractC0557a.W(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = AbstractC0769a.f13559y;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
            int iS = B1.a.s(context2, typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iS == -1) {
                TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
                typedArrayObtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, AbstractC0769a.f13558x);
                    int iS2 = B1.a.s(aVar.getContext(), typedArrayObtainStyledAttributes3, 2, 4);
                    typedArrayObtainStyledAttributes3.recycle();
                    if (iS2 >= 0) {
                        aVar.setLineHeight(iS2);
                    }
                }
            }
        }
        return aVar;
    }
}
