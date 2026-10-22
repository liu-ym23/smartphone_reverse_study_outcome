package com.google.android.material.theme;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.app.s;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.t;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.internal.i;
import com.google.android.material.textfield.q;
import com.stepos.aiengine.R;
import v4.a;
import w4.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends s {
    @Override // androidx.appcompat.app.s
    public final c a(Context context, AttributeSet attributeSet) {
        return new q(context, attributeSet);
    }

    @Override // androidx.appcompat.app.s
    public final e b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.s
    public final f c(Context context, AttributeSet attributeSet) {
        return new MaterialCheckBox(context, attributeSet);
    }

    @Override // androidx.appcompat.app.s
    public final t d(Context context, AttributeSet attributeSet) {
        a aVar = new a(b5.a.a(context, attributeSet, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet);
        Context context2 = aVar.getContext();
        TypedArray typedArrayD = i.d(context2, attributeSet, k4.a.f9915u, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (typedArrayD.hasValue(0)) {
            aVar.setButtonTintList(w4.c.a(context2, typedArrayD, 0));
        }
        aVar.h = typedArrayD.getBoolean(1, false);
        typedArrayD.recycle();
        return aVar;
    }

    @Override // androidx.appcompat.app.s
    public final AppCompatTextView e(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        a5.a aVar = new a5.a(b5.a.a(context, attributeSet, android.R.attr.textViewStyle, 0), attributeSet, android.R.attr.textViewStyle);
        Context context2 = aVar.getContext();
        if (b.b(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = k4.a.f9919y;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
            int iH = a5.a.h(context2, typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iH == -1) {
                TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
                typedArrayObtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, k4.a.f9918x);
                    int iH2 = a5.a.h(aVar.getContext(), typedArrayObtainStyledAttributes3, 2, 4);
                    typedArrayObtainStyledAttributes3.recycle();
                    if (iH2 >= 0) {
                        aVar.setLineHeight(iH2);
                    }
                }
            }
        }
        return aVar;
    }
}
