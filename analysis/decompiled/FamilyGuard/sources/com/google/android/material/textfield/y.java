package com.google.android.material.textfield;

import a1.C0412e;
import a1.C0416i;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes.dex */
class y extends s {

    /* renamed from: e, reason: collision with root package name */
    private int f13424e;

    /* renamed from: f, reason: collision with root package name */
    private EditText f13425f;

    /* renamed from: g, reason: collision with root package name */
    private final View.OnClickListener f13426g;

    y(r rVar, int i5) {
        super(rVar);
        this.f13424e = C0412e.f6807a;
        this.f13426g = new View.OnClickListener() { // from class: com.google.android.material.textfield.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y.v(this.f13423a, view);
            }
        };
        if (i5 != 0) {
            this.f13424e = i5;
        }
    }

    public static /* synthetic */ void v(y yVar, View view) {
        EditText editText = yVar.f13425f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (yVar.w()) {
            yVar.f13425f.setTransformationMethod(null);
        } else {
            yVar.f13425f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            yVar.f13425f.setSelection(selectionEnd);
        }
        yVar.r();
    }

    private boolean w() {
        EditText editText = this.f13425f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean x(EditText editText) {
        if (editText != null) {
            return editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.s
    void b(CharSequence charSequence, int i5, int i6, int i7) {
        r();
    }

    @Override // com.google.android.material.textfield.s
    int c() {
        return C0416i.f6908x;
    }

    @Override // com.google.android.material.textfield.s
    int d() {
        return this.f13424e;
    }

    @Override // com.google.android.material.textfield.s
    View.OnClickListener f() {
        return this.f13426g;
    }

    @Override // com.google.android.material.textfield.s
    boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    boolean m() {
        return !w();
    }

    @Override // com.google.android.material.textfield.s
    void n(EditText editText) {
        this.f13425f = editText;
        r();
    }

    @Override // com.google.android.material.textfield.s
    void s() {
        if (x(this.f13425f)) {
            this.f13425f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.s
    void u() {
        EditText editText = this.f13425f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
