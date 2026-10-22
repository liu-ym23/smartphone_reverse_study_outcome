package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes3.dex */
public final class g implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final int f2714a;

    public g(int i) {
        this.f2714a = i;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i6, Spanned spanned, int i10, int i11) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i10, i11, charSequence.subSequence(i, i6).toString());
            if (Integer.parseInt(sb.toString()) <= this.f2714a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
