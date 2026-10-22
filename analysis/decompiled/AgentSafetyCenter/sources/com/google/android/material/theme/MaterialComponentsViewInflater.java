package com.google.android.material.theme;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import com.stepos.agentsafetycenter.R;
import h.h0;
import i7.c;
import java.lang.invoke.VarHandle;
import k7.a;
import m.b0;
import m.o;
import m.p;
import m.q;
import m.v0;
import m.w1;
import p5.f;
import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends h0 {
    @Override // h.h0
    public final o a(Context context, AttributeSet attributeSet) {
        c cVar = new c(a.a(context, attributeSet, R.attr.autoCompleteTextViewStyle, 0, new int[0]), attributeSet, R.attr.autoCompleteTextViewStyle);
        new Rect();
        Context context2 = cVar.getContext();
        a7.a.a(context2, attributeSet, R.attr.autoCompleteTextViewStyle, R.style.Widget_AppCompat_AutoCompleteTextView);
        int[] iArr = p6.a.i;
        a7.a.b(context2, attributeSet, iArr, R.attr.autoCompleteTextViewStyle, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.autoCompleteTextViewStyle, R.style.Widget_AppCompat_AutoCompleteTextView);
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getInt(0, 0) == 0) {
            cVar.setKeyListener(null);
        }
        cVar.f5820k = typedArrayObtainStyledAttributes.getResourceId(3, R.layout.mtrl_auto_complete_simple_item);
        cVar.f5821l = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            cVar.f5822m = ColorStateList.valueOf(typedArrayObtainStyledAttributes.getColor(2, 0));
        }
        cVar.f5823n = typedArrayObtainStyledAttributes.getColor(4, 0);
        cVar.f5824o = h.s(context2, typedArrayObtainStyledAttributes, 5);
        cVar.f5819j = (AccessibilityManager) context2.getSystemService("accessibility");
        w1 w1Var = new w1(context2, null, R.attr.listPopupWindowStyle, 0);
        cVar.i = w1Var;
        w1Var.C = true;
        w1Var.D.setFocusable(true);
        w1Var.f8127s = cVar;
        w1Var.D.setInputMethodMode(2);
        w1Var.p(cVar.getAdapter());
        i7.a aVar = new i7.a(0);
        aVar.f5815f = cVar;
        VarHandle.storeStoreFence();
        w1Var.f8128t = aVar;
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            cVar.setSimpleItems(typedArrayObtainStyledAttributes.getResourceId(6, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        VarHandle.storeStoreFence();
        return cVar;
    }

    @Override // h.h0
    public final p b(Context context, AttributeSet attributeSet) {
        return new u6.c(context, attributeSet);
    }

    @Override // h.h0
    public final q c(Context context, AttributeSet attributeSet) {
        return new w6.c(context, attributeSet);
    }

    @Override // h.h0
    public final b0 d(Context context, AttributeSet attributeSet) {
        c7.a aVar = new c7.a(a.a(context, attributeSet, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]), attributeSet);
        Context context2 = aVar.getContext();
        a7.a.a(context2, attributeSet, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton);
        int[] iArr = p6.a.f9819l;
        a7.a.b(context2, attributeSet, iArr, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            aVar.setButtonTintList(h.s(context2, typedArrayObtainStyledAttributes, 0));
        }
        aVar.f2222j = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    @Override // h.h0
    public final v0 e(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        j7.a aVar = new j7.a(a.a(context, attributeSet, android.R.attr.textViewStyle, 0, new int[0]), attributeSet, android.R.attr.textViewStyle);
        Context context2 = aVar.getContext();
        if (f.F(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = p6.a.f9823p;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
            int iF = j7.a.f(context2, typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iF == -1) {
                TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
                typedArrayObtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, p6.a.f9822o);
                    int iF2 = j7.a.f(aVar.getContext(), typedArrayObtainStyledAttributes3, 2, 4);
                    typedArrayObtainStyledAttributes3.recycle();
                    if (iF2 >= 0) {
                        aVar.setLineHeight(iF2);
                    }
                }
            }
        }
        return aVar;
    }
}
