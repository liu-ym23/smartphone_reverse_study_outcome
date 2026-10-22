package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class e extends com.google.android.material.internal.q {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f20779a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20780b;

    /* renamed from: c, reason: collision with root package name */
    public final DateFormat f20781c;

    /* renamed from: d, reason: collision with root package name */
    public final CalendarConstraints f20782d;

    /* renamed from: e, reason: collision with root package name */
    public final String f20783e;

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f20784f;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f20785g;

    /* renamed from: h, reason: collision with root package name */
    public int f20786h = 0;

    public e(final String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f20780b = str;
        this.f20781c = dateFormat;
        this.f20779a = textInputLayout;
        this.f20782d = calendarConstraints;
        this.f20783e = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.f20784f = new Runnable() { // from class: com.google.android.material.datepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                e.b(this.f20775a, str);
            }
        };
    }

    public static /* synthetic */ void a(e eVar, long j10) {
        eVar.getClass();
        eVar.f20779a.setError(String.format(eVar.f20783e, eVar.g(h.c(j10))));
        eVar.d();
    }

    public static /* synthetic */ void b(e eVar, String str) {
        TextInputLayout textInputLayout = eVar.f20779a;
        DateFormat dateFormat = eVar.f20781c;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R$string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_use), eVar.g(str)) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_example), eVar.g(dateFormat.format(new Date(v.l().getTimeInMillis())))));
        eVar.d();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.f20780b.length() && editable.length() >= this.f20786h) {
            char cCharAt = this.f20780b.charAt(editable.length());
            if (Character.isLetterOrDigit(cCharAt)) {
                return;
            }
            editable.append(cCharAt);
        }
    }

    @Override // com.google.android.material.internal.q, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f20786h = charSequence.length();
    }

    public final Runnable c(final long j10) {
        return new Runnable() { // from class: com.google.android.material.datepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                e.a(this.f20777a, j10);
            }
        };
    }

    public abstract void d();

    public abstract void e(Long l10);

    public void f(View view, Runnable runnable) {
        view.post(runnable);
    }

    public final String g(String str) {
        return str.replace(' ', (char) 160);
    }

    @Override // com.google.android.material.internal.q, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) throws ParseException {
        this.f20779a.removeCallbacks(this.f20784f);
        this.f20779a.removeCallbacks(this.f20785g);
        this.f20779a.setError(null);
        e(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.f20780b.length()) {
            return;
        }
        try {
            Date date = this.f20781c.parse(charSequence.toString());
            this.f20779a.setError(null);
            long time = date.getTime();
            if (this.f20782d.getDateValidator().isValid(time) && this.f20782d.isWithinBounds(time)) {
                e(Long.valueOf(date.getTime()));
                return;
            }
            Runnable runnableC = c(time);
            this.f20785g = runnableC;
            f(this.f20779a, runnableC);
        } catch (ParseException unused) {
            f(this.f20779a, this.f20784f);
        }
    }
}
