package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes3.dex */
class MaxInputValidator implements InputFilter {
    private int max;

    public MaxInputValidator(int r10) {
        this.max = r10;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r10, int r11, int r12, Spanned r13, int r14, int r15) {
        StringBuilder r16 = new StringBuilder(r13);     // Catch: NumberFormatException -> L8
        r16.replace(r14, r15, r10.subSequence(r11, r12).toString());     // Catch: NumberFormatException -> L8
        if (Integer.parseInt(r16.toString()) > this.max) goto L6;
        return null;
    L6:
        return "";
    L11:
        return "";
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int r10) {
        this.max = r10;
    }
}
