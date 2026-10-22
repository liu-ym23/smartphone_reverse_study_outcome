package com.google.android.material.textfield;

import android.widget.EditText;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f11033a;

    public m(n nVar) {
        this.f11033a = nVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        n nVar = this.f11033a;
        if (nVar.f11053s == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = nVar.f11053s;
        l lVar = nVar.f11056v;
        if (editText != null) {
            editText.removeTextChangedListener(lVar);
            if (nVar.f11053s.getOnFocusChangeListener() == nVar.b().e()) {
                nVar.f11053s.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        nVar.f11053s = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(lVar);
        }
        nVar.b().m(nVar.f11053s);
        nVar.j(nVar.b());
    }
}
