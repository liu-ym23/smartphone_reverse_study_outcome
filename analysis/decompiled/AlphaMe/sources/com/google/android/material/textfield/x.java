package com.google.android.material.textfield;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class x implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public int f11120a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f11121b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f11122c;

    public x(TextInputLayout textInputLayout, EditText editText) {
        this.f11122c = textInputLayout;
        this.f11121b = editText;
        this.f11120a = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) throws Resources.NotFoundException {
        TextInputLayout textInputLayout = this.f11122c;
        textInputLayout.w(!textInputLayout.f10940L0, false);
        if (textInputLayout.f10964l) {
            textInputLayout.p(editable);
        }
        if (textInputLayout.f10980t) {
            textInputLayout.x(editable);
        }
        EditText editText = this.f11121b;
        int lineCount = editText.getLineCount();
        int i4 = this.f11120a;
        if (lineCount != i4) {
            if (lineCount < i4) {
                int minimumHeight = editText.getMinimumHeight();
                int i5 = textInputLayout.f10926E0;
                if (minimumHeight != i5) {
                    editText.setMinimumHeight(i5);
                }
            }
            this.f11120a = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }
}
