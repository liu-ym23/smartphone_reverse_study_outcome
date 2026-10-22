package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* loaded from: classes2.dex */
public class y extends s {

    /* renamed from: e, reason: collision with root package name */
    public int f21691e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f21692f;

    /* renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f21693g;

    public y(r rVar, int i10) {
        super(rVar);
        this.f21691e = R$drawable.design_password_eye;
        this.f21693g = new View.OnClickListener() { // from class: com.google.android.material.textfield.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y.v(this.f21690a, view);
            }
        };
        if (i10 != 0) {
            this.f21691e = i10;
        }
    }

    public static /* synthetic */ void v(y yVar, View view) {
        EditText editText = yVar.f21692f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (yVar.w()) {
            yVar.f21692f.setTransformationMethod(null);
        } else {
            yVar.f21692f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            yVar.f21692f.setSelection(selectionEnd);
        }
        yVar.r();
    }

    public static boolean x(EditText editText) {
        if (editText != null) {
            return editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.s
    public void b(CharSequence charSequence, int i10, int i11, int i12) {
        r();
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return R$string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return this.f21691e;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f21693g;
    }

    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return !w();
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f21692f = editText;
        r();
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        if (x(this.f21692f)) {
            this.f21692f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f21692f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final boolean w() {
        EditText editText = this.f21692f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
