package com.google.android.material.theme;

import V2.a;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.m;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C1290c;
import androidx.appcompat.widget.C1304q;
import c3.C1494a;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.v;

/* loaded from: classes2.dex */
public class MaterialComponentsViewInflater extends m {
    @Override // androidx.appcompat.app.m
    public C1290c c(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    @Override // androidx.appcompat.app.m
    public AppCompatButton d(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.m
    public AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new MaterialCheckBox(context, attributeSet);
    }

    @Override // androidx.appcompat.app.m
    public C1304q k(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.m
    public AppCompatTextView o(Context context, AttributeSet attributeSet) {
        return new C1494a(context, attributeSet);
    }
}
