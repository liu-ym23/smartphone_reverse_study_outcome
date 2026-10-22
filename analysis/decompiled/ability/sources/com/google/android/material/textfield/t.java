package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class t extends n {
    public final int e;
    public EditText f;
    public final A6.b g;

    public t(m mVar, int i) {
        super(mVar);
        this.e = R.drawable.design_password_eye;
        this.g = new A6.b(this, 6);
        if (i != 0) {
            this.e = i;
        }
    }

    @Override // com.google.android.material.textfield.n
    public final void b() {
        q();
    }

    @Override // com.google.android.material.textfield.n
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.n
    public final int d() {
        return this.e;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnClickListener f() {
        return this.g;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean k() {
        return true;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean l() {
        EditText editText = this.f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // com.google.android.material.textfield.n
    public final void m(EditText editText) {
        this.f = editText;
        q();
    }

    @Override // com.google.android.material.textfield.n
    public final void r() {
        EditText editText = this.f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.google.android.material.textfield.n
    public final void s() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
