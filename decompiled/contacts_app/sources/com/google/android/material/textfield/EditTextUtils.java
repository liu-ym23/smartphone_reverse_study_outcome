package com.google.android.material.textfield;

import android.widget.EditText;

/* JADX INFO: loaded from: classes2.dex */
class EditTextUtils {
    private EditTextUtils() {
    }

    static boolean isEditable(EditText r0) {
        if (r0.getInputType() == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
