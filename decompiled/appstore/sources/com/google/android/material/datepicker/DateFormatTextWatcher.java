package com.google.android.material.datepicker;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private static final int VALIDATION_DELAY = 1000;
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;

    @NonNull
    private final TextInputLayout textInputLayout;

    public DateFormatTextWatcher(final String r10, DateFormat r11, @NonNull TextInputLayout r12, CalendarConstraints r13) {
        this.dateFormat = r11;
        this.textInputLayout = r12;
        this.constraints = r13;
        this.outOfRange = r12.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.setErrorCallback = new AnonymousClass1(this, r10);
    }

    public static /* synthetic */ TextInputLayout access$000(DateFormatTextWatcher r10) {
        return r10.textInputLayout;
    }

    public static /* synthetic */ DateFormat access$100(DateFormatTextWatcher r10) {
        return r10.dateFormat;
    }

    public static /* synthetic */ String access$200(DateFormatTextWatcher r10) {
        return r10.outOfRange;
    }

    private Runnable createRangeErrorCallback(final long r10) {
        return new AnonymousClass2(this, r10);
    }

    public void onInvalidDate() {
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence r10, int r11, int r12, int r13) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError(null);
        onValidDate(null);
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return;
    L15:
        Date r14 = this.dateFormat.parse(r10.toString());     // Catch: ParseException -> L13
        this.textInputLayout.setError(null);     // Catch: ParseException -> L13
        long r15 = r14.getTime();     // Catch: ParseException -> L13
        if (this.constraints.getDateValidator().isValid(r15) == true) goto L8;
    L11:
        Runnable r16 = createRangeErrorCallback(r15);     // Catch: ParseException -> L13
        this.setRangeErrorCallback = r16;     // Catch: ParseException -> L13
        runValidation(this.textInputLayout, r16);     // Catch: ParseException -> L13
        return;
    L8:
        if (this.constraints.isWithinBounds(r15) == false) goto L11;
        onValidDate(Long.valueOf(r14.getTime()));     // Catch: ParseException -> L13
        return;
    L13:
        runValidation(this.textInputLayout, this.setErrorCallback);
    }

    public abstract void onValidDate(@Nullable Long r10);

    public void runValidation(View r10, Runnable r11) {
        r10.postDelayed(r11, 1000);
    }
}
