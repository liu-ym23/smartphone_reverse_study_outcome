package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class v extends o {

    /* renamed from: e, reason: collision with root package name */
    public final int f11107e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f11108f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewOnClickListenerC0435a f11109g;

    public v(n nVar, int i4) {
        super(nVar);
        this.f11107e = R.drawable.design_password_eye;
        this.f11109g = new ViewOnClickListenerC0435a(2, this);
        if (i4 != 0) {
            this.f11107e = i4;
        }
    }

    @Override // com.google.android.material.textfield.o
    public final void b() {
        q();
    }

    @Override // com.google.android.material.textfield.o
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.o
    public final int d() {
        return this.f11107e;
    }

    @Override // com.google.android.material.textfield.o
    public final View.OnClickListener f() {
        return this.f11109g;
    }

    @Override // com.google.android.material.textfield.o
    public final boolean k() {
        return true;
    }

    @Override // com.google.android.material.textfield.o
    public final boolean l() {
        EditText editText = this.f11108f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // com.google.android.material.textfield.o
    public final void m(EditText editText) {
        this.f11108f = editText;
        q();
    }

    @Override // com.google.android.material.textfield.o
    public final void r() {
        EditText editText = this.f11108f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f11108f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.google.android.material.textfield.o
    public final void s() {
        EditText editText = this.f11108f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
