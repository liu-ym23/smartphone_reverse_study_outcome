package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s extends l {

    /* renamed from: e, reason: collision with root package name */
    public final int f5330e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f5331f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.material.datepicker.k f5332g;

    public s(k kVar, int i10) {
        super(kVar);
        this.f5330e = R.drawable.design_password_eye;
        this.f5332g = new com.google.android.material.datepicker.k(this, 3);
        if (i10 != 0) {
            this.f5330e = i10;
        }
    }

    @Override // com.google.android.material.textfield.l
    public final void b() {
        p();
    }

    @Override // com.google.android.material.textfield.l
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.l
    public final int d() {
        return this.f5330e;
    }

    @Override // com.google.android.material.textfield.l
    public final View.OnClickListener f() {
        return this.f5332g;
    }

    @Override // com.google.android.material.textfield.l
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.l
    public final boolean k() {
        EditText editText = this.f5331f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // com.google.android.material.textfield.l
    public final void l(EditText editText) {
        this.f5331f = editText;
        p();
    }

    @Override // com.google.android.material.textfield.l
    public final void q() {
        EditText editText = this.f5331f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f5331f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.google.android.material.textfield.l
    public final void r() {
        EditText editText = this.f5331f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
