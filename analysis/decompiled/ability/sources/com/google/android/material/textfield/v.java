package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes3.dex */
public final class v implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public int f2701a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ TextInputLayout c;

    public v(TextInputLayout textInputLayout, EditText editText) {
        this.c = textInputLayout;
        this.b = editText;
        this.f2701a = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.c;
        textInputLayout.w(!textInputLayout.f2613F0, false);
        if (textInputLayout.l) {
            textInputLayout.p(editable);
        }
        if (textInputLayout.f2650t) {
            textInputLayout.x(editable);
        }
        EditText editText = this.b;
        int lineCount = editText.getLineCount();
        int i = this.f2701a;
        if (lineCount != i) {
            if (lineCount < i) {
                int minimumHeight = editText.getMinimumHeight();
                int i6 = textInputLayout.f2658y0;
                if (minimumHeight != i6) {
                    editText.setMinimumHeight(i6);
                }
            }
            this.f2701a = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i6, int i10) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i6, int i10) {
    }
}
