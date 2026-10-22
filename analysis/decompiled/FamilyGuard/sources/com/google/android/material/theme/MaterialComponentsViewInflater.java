package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.m;
import androidx.appcompat.widget.C0434d;
import androidx.appcompat.widget.C0436f;
import androidx.appcompat.widget.C0437g;
import androidx.appcompat.widget.C0451v;
import androidx.appcompat.widget.D;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.v;
import f1.C0695a;
import p1.C0921a;
import w1.C1202a;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends m {
    @Override // androidx.appcompat.app.m
    protected C0434d c(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    @Override // androidx.appcompat.app.m
    protected C0436f d(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.m
    protected C0437g e(Context context, AttributeSet attributeSet) {
        return new C0695a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.m
    protected C0451v k(Context context, AttributeSet attributeSet) {
        return new C0921a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.m
    protected D o(Context context, AttributeSet attributeSet) {
        return new C1202a(context, attributeSet);
    }
}
