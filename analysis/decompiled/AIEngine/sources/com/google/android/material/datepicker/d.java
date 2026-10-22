package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.aiengine.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class d extends com.google.android.material.internal.h {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f4954a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4955b;

    /* renamed from: c, reason: collision with root package name */
    public final DateFormat f4956c;

    /* renamed from: d, reason: collision with root package name */
    public final CalendarConstraints f4957d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4958e;
    public final androidx.room.o h;

    /* renamed from: j, reason: collision with root package name */
    public c f4959j;

    /* renamed from: k, reason: collision with root package name */
    public int f4960k = 0;

    public d(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f4955b = str;
        this.f4956c = dateFormat;
        this.f4954a = textInputLayout;
        this.f4957d = calendarConstraints;
        this.f4958e = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.h = new androidx.room.o(5, this, str);
    }

    public abstract void a();

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) || editable.length() == 0) {
            return;
        }
        int length = editable.length();
        String str = this.f4955b;
        if (length >= str.length() || editable.length() < this.f4960k) {
            return;
        }
        char cCharAt = str.charAt(editable.length());
        if (Character.isLetterOrDigit(cCharAt)) {
            return;
        }
        editable.append(cCharAt);
    }

    public abstract void b(Long l10);

    @Override // com.google.android.material.internal.h, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f4960k = charSequence.length();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.google.android.material.datepicker.c, java.lang.Runnable] */
    @Override // com.google.android.material.internal.h, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) throws Resources.NotFoundException, ParseException {
        CalendarConstraints calendarConstraints = this.f4957d;
        TextInputLayout textInputLayout = this.f4954a;
        androidx.room.o oVar = this.h;
        textInputLayout.removeCallbacks(oVar);
        textInputLayout.removeCallbacks(this.f4959j);
        textInputLayout.setError(null);
        b(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.f4955b.length()) {
            return;
        }
        try {
            Date date = this.f4956c.parse(charSequence.toString());
            textInputLayout.setError(null);
            final long time = date.getTime();
            if (calendarConstraints.getDateValidator().isValid(time) && calendarConstraints.isWithinBounds(time)) {
                b(Long.valueOf(date.getTime()));
                return;
            }
            ?? r42 = new Runnable() { // from class: com.google.android.material.datepicker.c
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    String strB = g.b(time);
                    d dVar = this.f4952a;
                    dVar.f4954a.setError(String.format(dVar.f4958e, strB.replace(' ', (char) 160)));
                    dVar.a();
                }
            };
            this.f4959j = r42;
            textInputLayout.post(r42);
        } catch (ParseException unused) {
            textInputLayout.post(oVar);
        }
    }
}
