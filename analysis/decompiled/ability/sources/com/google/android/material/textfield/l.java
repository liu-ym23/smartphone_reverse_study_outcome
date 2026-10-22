package com.google.android.material.textfield;

import android.widget.EditText;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f2674a;

    public l(m mVar) {
        this.f2674a = mVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        m mVar = this.f2674a;
        k kVar = mVar.f2681v;
        if (mVar.f2679s == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = mVar.f2679s;
        if (editText != null) {
            editText.removeTextChangedListener(kVar);
            if (mVar.f2679s.getOnFocusChangeListener() == mVar.b().e()) {
                mVar.f2679s.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        mVar.f2679s = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(kVar);
        }
        mVar.b().m(mVar.f2679s);
        mVar.j(mVar.b());
    }
}
