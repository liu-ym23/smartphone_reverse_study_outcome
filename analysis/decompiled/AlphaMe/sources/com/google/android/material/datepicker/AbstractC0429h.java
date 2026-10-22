package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.alphame.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.google.android.material.datepicker.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0429h extends com.google.android.material.internal.k {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f10676a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10677b;

    /* renamed from: c, reason: collision with root package name */
    public final DateFormat f10678c;

    /* renamed from: d, reason: collision with root package name */
    public final CalendarConstraints f10679d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10680e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.appcompat.app.o f10681f;

    /* renamed from: g, reason: collision with root package name */
    public RunnableC0428g f10682g;

    /* renamed from: h, reason: collision with root package name */
    public int f10683h = 0;

    public AbstractC0429h(String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f10677b = str;
        this.f10678c = simpleDateFormat;
        this.f10676a = textInputLayout;
        this.f10679d = calendarConstraints;
        this.f10680e = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f10681f = new androidx.appcompat.app.o(12, this, str);
    }

    public abstract void a();

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) || editable.length() == 0) {
            return;
        }
        int length = editable.length();
        String str = this.f10677b;
        if (length >= str.length() || editable.length() < this.f10683h) {
            return;
        }
        char cCharAt = str.charAt(editable.length());
        if (Character.isLetterOrDigit(cCharAt)) {
            return;
        }
        editable.append(cCharAt);
    }

    public abstract void b(Long l4);

    @Override // com.google.android.material.internal.k, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        this.f10683h = charSequence.length();
    }

    @Override // com.google.android.material.internal.k, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) throws ParseException {
        CalendarConstraints calendarConstraints = this.f10679d;
        TextInputLayout textInputLayout = this.f10676a;
        androidx.appcompat.app.o oVar = this.f10681f;
        textInputLayout.removeCallbacks(oVar);
        textInputLayout.removeCallbacks(this.f10682g);
        textInputLayout.setError(null);
        b(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.f10677b.length()) {
            return;
        }
        try {
            Date date = this.f10678c.parse(charSequence.toString());
            textInputLayout.setError(null);
            long time = date.getTime();
            if (calendarConstraints.f10601c.l(time)) {
                Calendar calendarC = J.c(calendarConstraints.f10599a.f10657a);
                calendarC.set(5, 1);
                if (calendarC.getTimeInMillis() <= time) {
                    Month month = calendarConstraints.f10600b;
                    int i7 = month.f10661e;
                    Calendar calendarC2 = J.c(month.f10657a);
                    calendarC2.set(5, i7);
                    if (time <= calendarC2.getTimeInMillis()) {
                        b(Long.valueOf(date.getTime()));
                        return;
                    }
                }
            }
            RunnableC0428g runnableC0428g = new RunnableC0428g(0, time, this);
            this.f10682g = runnableC0428g;
            textInputLayout.post(runnableC0428g);
        } catch (ParseException unused) {
            textInputLayout.post(oVar);
        }
    }
}
