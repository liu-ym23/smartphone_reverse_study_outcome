package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.ability.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.google.android.material.datepicker.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0906i extends com.google.android.material.internal.j {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f2427a;
    public final String b;
    public final DateFormat c;
    public final CalendarConstraints d;
    public final String e;
    public final I4.l f;
    public RunnableC0905h g;
    public int h = 0;

    public AbstractC0906i(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.b = str;
        this.c = dateFormat;
        this.f2427a = textInputLayout;
        this.d = calendarConstraints;
        this.e = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f = new I4.l(9, this, str);
    }

    public abstract void a();

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) || editable.length() == 0) {
            return;
        }
        int length = editable.length();
        String str = this.b;
        if (length >= str.length() || editable.length() < this.h) {
            return;
        }
        char cCharAt = str.charAt(editable.length());
        if (Character.isLetterOrDigit(cCharAt)) {
            return;
        }
        editable.append(cCharAt);
    }

    public abstract void b(Long l);

    @Override // com.google.android.material.internal.j, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        this.h = charSequence.length();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.google.android.material.datepicker.h, java.lang.Runnable] */
    @Override // com.google.android.material.internal.j, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i6, int i10) throws ParseException {
        CalendarConstraints calendarConstraints = this.d;
        TextInputLayout textInputLayout = this.f2427a;
        I4.l lVar = this.f;
        textInputLayout.removeCallbacks(lVar);
        textInputLayout.removeCallbacks(this.g);
        textInputLayout.setError(null);
        b(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.b.length()) {
            return;
        }
        try {
            Date date = this.c.parse(charSequence.toString());
            textInputLayout.setError(null);
            final long time = date.getTime();
            if (calendarConstraints.getDateValidator().isValid(time) && calendarConstraints.isWithinBounds(time)) {
                b(Long.valueOf(date.getTime()));
                return;
            }
            ?? r42 = new Runnable() { // from class: com.google.android.material.datepicker.h
                @Override // java.lang.Runnable
                public final void run() {
                    String strZ = U7.a.z(time);
                    AbstractC0906i abstractC0906i = this.f2426a;
                    abstractC0906i.f2427a.setError(String.format(abstractC0906i.e, strZ.replace(' ', (char) 160)));
                    abstractC0906i.a();
                }
            };
            this.g = r42;
            textInputLayout.post(r42);
        } catch (ParseException unused) {
            textInputLayout.post(lVar);
        }
    }
}
