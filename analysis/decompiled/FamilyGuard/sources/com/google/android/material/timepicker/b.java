package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
class b implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    private int f13492a;

    public b(int i5) {
        this.f13492a = i5;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i5, int i6, Spanned spanned, int i7, int i8) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i7, i8, charSequence.subSequence(i5, i6).toString());
            if (Integer.parseInt(sb.toString()) <= this.f13492a) {
                return null;
            }
            return BuildConfig.FLAVOR;
        } catch (NumberFormatException unused) {
            return BuildConfig.FLAVOR;
        }
    }
}
