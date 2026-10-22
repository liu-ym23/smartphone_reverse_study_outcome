package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private static final int VALIDATION_DELAY = 1000;
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;
    private final TextInputLayout textInputLayout;

    void onInvalidDate() {
    }

    abstract void onValidDate(Long r1);

    DateFormatTextWatcher(final String r1, DateFormat r2, TextInputLayout r3, CalendarConstraints r4) {
        this.dateFormat = r2;
        this.textInputLayout = r3;
        this.constraints = r4;
        this.outOfRange = r3.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.setErrorCallback = new DateFormatTextWatcher$$ExternalSyntheticLambda0(this, r1);
    }

    /* JADX INFO: renamed from: lambda$new$0$com-google-android-material-datepicker-DateFormatTextWatcher, reason: not valid java name */
    /* synthetic */ void m249x5657fb8e(String r11) {
        TextInputLayout r0 = this.textInputLayout;
        DateFormat r1 = this.dateFormat;
        Context r2 = r0.getContext();
        r0.setError(r2.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(r2.getString(R.string.mtrl_picker_invalid_format_use), new Object[]{sanitizeDateString(r11)}) + "\n" + String.format(r2.getString(R.string.mtrl_picker_invalid_format_example), new Object[]{sanitizeDateString(r1.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())))}));
        onInvalidDate();
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError(null);
        onValidDate(null);
        if (TextUtils.isEmpty(r1) == false) goto L15;
        return;
    L15:
        Date r5 = this.dateFormat.parse(r1.toString());     // Catch: ParseException -> L13
        this.textInputLayout.setError(null);     // Catch: ParseException -> L13
        long r6 = r5.getTime();     // Catch: ParseException -> L13
        if (this.constraints.getDateValidator().isValid(r6) == true) goto L8;
    L11:
        Runnable r7 = createRangeErrorCallback(r6);     // Catch: ParseException -> L13
        this.setRangeErrorCallback = r7;     // Catch: ParseException -> L13
        runValidation(this.textInputLayout, r7);     // Catch: ParseException -> L13
        return;
    L8:
        if (this.constraints.isWithinBounds(r6) == false) goto L11;
        onValidDate(Long.valueOf(r5.getTime()));     // Catch: ParseException -> L13
        return;
    L13:
        runValidation(this.textInputLayout, this.setErrorCallback);
    }

    private Runnable createRangeErrorCallback(final long r2) {
        return new DateFormatTextWatcher$$ExternalSyntheticLambda1(this, r2);
    }

    /* JADX INFO: renamed from: lambda$createRangeErrorCallback$1$com-google-android-material-datepicker-DateFormatTextWatcher, reason: not valid java name */
    /* synthetic */ void m248x14d77527(long r4) {
        String r5 = DateStrings.getDateString(r4);
        this.textInputLayout.setError(String.format(this.outOfRange, new Object[]{sanitizeDateString(r5)}));
        onInvalidDate();
    }

    private String sanitizeDateString(String r2) {
        return r2.replace(' ', Typography.nbsp);
    }

    public void runValidation(View r3, Runnable r4) {
        r3.postDelayed(r4, 1000);
    }
}
