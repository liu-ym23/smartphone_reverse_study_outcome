package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

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

    static /* synthetic */ TextInputLayout access$000(DateFormatTextWatcher r0) {
        return r0.textInputLayout;
    }

    static /* synthetic */ DateFormat access$100(DateFormatTextWatcher r0) {
        return r0.dateFormat;
    }

    static /* synthetic */ String access$200(DateFormatTextWatcher r0) {
        return r0.outOfRange;
    }

    DateFormatTextWatcher(final String r2, DateFormat r3, TextInputLayout r4, CalendarConstraints r5) {
        this.dateFormat = r3;
        this.textInputLayout = r4;
        this.constraints = r5;
        this.outOfRange = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_out_of_range, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_out_of_range"));
        this.setErrorCallback = new AnonymousClass1(this, r2);
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError(null);
        onValidDate(null);
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return;
    L15:
        Date r6 = this.dateFormat.parse(r5.toString());     // Catch: ParseException -> L13
        this.textInputLayout.setError(null);     // Catch: ParseException -> L13
        long r7 = r6.getTime();     // Catch: ParseException -> L13
        if (this.constraints.getDateValidator().isValid(r7) == true) goto L8;
    L11:
        Runnable r8 = createRangeErrorCallback(r7);     // Catch: ParseException -> L13
        this.setRangeErrorCallback = r8;     // Catch: ParseException -> L13
        runValidation(this.textInputLayout, r8);     // Catch: ParseException -> L13
        return;
    L8:
        if (this.constraints.isWithinBounds(r7) == false) goto L11;
        onValidDate(Long.valueOf(r6.getTime()));     // Catch: ParseException -> L13
        return;
    L13:
        runValidation(this.textInputLayout, this.setErrorCallback);
    }

    private Runnable createRangeErrorCallback(final long r2) {
        return new AnonymousClass2(this, r2);
    }

    public void runValidation(View r3, Runnable r4) {
        r3.postDelayed((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin"), 1000);
    }
}
