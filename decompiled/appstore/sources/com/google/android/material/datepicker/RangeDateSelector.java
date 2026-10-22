package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.c;
import androidx.core.util.e;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<c> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = null;
    private final String invalidRangeEndError;
    private String invalidRangeStartError;

    @Nullable
    private Long proposedTextEnd;

    @Nullable
    private Long proposedTextStart;

    @Nullable
    private Long selectedEndItem;

    @Nullable
    private Long selectedStartItem;

    static {
        CREATOR = new AnonymousClass3();
    }

    public RangeDateSelector() {
        this.invalidRangeEndError = " ";
        this.selectedStartItem = null;
        this.selectedEndItem = null;
        this.proposedTextStart = null;
        this.proposedTextEnd = null;
    }

    public static /* synthetic */ Long access$002(RangeDateSelector r10, Long r11) {
        r10.proposedTextStart = r11;
        return r11;
    }

    public static /* synthetic */ void access$100(RangeDateSelector r10, TextInputLayout r11, TextInputLayout r12, OnSelectionChangedListener r13) {
        r10.updateIfValidTextProposal(r11, r12, r13);
    }

    public static /* synthetic */ Long access$202(RangeDateSelector r10, Long r11) {
        r10.proposedTextEnd = r11;
        return r11;
    }

    public static /* synthetic */ Long access$302(RangeDateSelector r10, Long r11) {
        r10.selectedStartItem = r11;
        return r11;
    }

    public static /* synthetic */ Long access$402(RangeDateSelector r10, Long r11) {
        r10.selectedEndItem = r11;
        return r11;
    }

    private void clearInvalidRange(@NonNull TextInputLayout r10, @NonNull TextInputLayout r11) {
        if (r10.getError() == null) goto L8;
        if (this.invalidRangeStartError.contentEquals(r10.getError()) == false) goto L8;
        r10.setError(null);
    L8:
        if (r11.getError() != null) goto L10;
        return;
    L10:
        if (" ".contentEquals(r11.getError()) == false) goto L14;
        r11.setError(null);
        return;
    }

    private boolean isValidRange(long r10, long r11) {
        if (r10 > r11) goto L5;
        return true;
    L5:
        return false;
    }

    private void setInvalidRange(@NonNull TextInputLayout r10, @NonNull TextInputLayout r11) {
        r10.setError(this.invalidRangeStartError);
        r11.setError(" ");
    }

    private void updateIfValidTextProposal(@NonNull TextInputLayout r10, @NonNull TextInputLayout r11, @NonNull OnSelectionChangedListener<c> r12) {
        Long r13 = this.proposedTextStart;
        if (r13 != null) goto L5;
    L12:
        clearInvalidRange(r10, r11);
        r12.onIncompleteSelectionChanged();
        return;
    L5:
        if (this.proposedTextEnd == null) goto L12;
        if (isValidRange(r13.longValue(), this.proposedTextEnd.longValue()) == false) goto L10;
        this.selectedStartItem = this.proposedTextStart;
        this.selectedEndItem = this.proposedTextEnd;
        r12.onSelectionChanged(getSelection());
        return;
    L10:
        setInvalidRange(r10, r11);
        r12.onIncompleteSelectionChanged();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        DisplayMetrics r12 = r11.getDisplayMetrics();
        int r13 = r11.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis);
        if (Math.min(r12.widthPixels, r12.heightPixels) <= r13) goto L5;
        int r14 = R.attr.materialCalendarTheme;
    L7:
        return MaterialAttributes.resolveOrThrow(r10, r14, MaterialDatePicker.class.getCanonicalName());
    L5:
        r14 = R.attr.materialCalendarFullscreenTheme;
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList r10 = new ArrayList();
        Long r11 = this.selectedStartItem;
        if (r11 == null) goto L5;
        r10.add(r11);
    L5:
        Long r12 = this.selectedEndItem;
        if (r12 == null) goto L8;
        r10.add(r12);
    L8:
        return r10;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<c> getSelectedRanges() {
        if (this.selectedStartItem == null) goto L10;
        if (this.selectedEndItem == null) goto L10;
        ArrayList r10 = new ArrayList();
        r10.add(new c(this.selectedStartItem, this.selectedEndItem));
        return r10;
    L10:
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public /* bridge */ /* synthetic */ c getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        Long r12 = this.selectedStartItem;
        if (r12 == null) goto L5;
    L8:
        Long r13 = this.selectedEndItem;
        if (r13 == null) goto L11;
        if (r12 == null) goto L14;
        c r14 = DateStrings.getDateRangeString(r12, r13);
        return r11.getString(R.string.mtrl_picker_range_header_selected, new Object[]{r14.f2646a, r14.f2647b});
    L14:
        return r11.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[]{DateStrings.getDateString(r13.longValue())});
    L11:
        return r11.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[]{DateStrings.getDateString(r12.longValue())});
    L5:
        if (this.selectedEndItem != null) goto L8;
        return r11.getString(R.string.mtrl_picker_range_header_unselected);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long r10 = this.selectedStartItem;
        if (r10 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.selectedEndItem == null) goto L9;
        if (isValidRange(r10.longValue(), this.selectedEndItem.longValue()) == false) goto L9;
        return true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater r18, @Nullable ViewGroup r19, @Nullable Bundle r20, final CalendarConstraints r21, @NonNull final OnSelectionChangedListener<c> r22) {
        View r10 = r18.inflate(R.layout.mtrl_picker_text_input_date_range, r19, false);
        final TextInputLayout r11 = (TextInputLayout) r10.findViewById(R.id.mtrl_picker_text_input_range_start);
        final TextInputLayout r12 = (TextInputLayout) r10.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText r13 = r11.getEditText();
        EditText r14 = r12.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters() == false) goto L5;
        r13.setInputType(17);
        r14.setInputType(17);
    L5:
        this.invalidRangeStartError = r10.getResources().getString(R.string.mtrl_picker_invalid_range);
        final SimpleDateFormat r15 = UtcDates.getTextInputFormat();
        Long r16 = this.selectedStartItem;
        if (r16 == null) goto L8;
        r13.setText(r15.format(r16));
        this.proposedTextStart = this.selectedStartItem;
    L8:
        Long r17 = this.selectedEndItem;
        if (r17 == null) goto L11;
        r14.setText(r15.format(r17));
        this.proposedTextEnd = this.selectedEndItem;
    L11:
        final String r23 = UtcDates.getTextInputHint(r10.getResources(), r15);
        r11.setPlaceholderText(r23);
        r12.setPlaceholderText(r23);
        r13.addTextChangedListener(new AnonymousClass1(this, r23, r15, r11, r21, r11, r12, r22));
        r14.addTextChangedListener(new AnonymousClass2(this, r23, r15, r12, r21, r11, r12, r22));
        ViewUtils.requestFocusAndShowKeyboard(r13);
        return r10;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r10) {
        Long r11 = this.selectedStartItem;
        if (r11 != null) goto L6;
        this.selectedStartItem = Long.valueOf(r10);
        return;
    L6:
        if (this.selectedEndItem == null) goto L8;
    L10:
        this.selectedEndItem = null;
        this.selectedStartItem = Long.valueOf(r10);
        return;
    L8:
        if (isValidRange(r11.longValue(), r10) == false) goto L10;
        this.selectedEndItem = Long.valueOf(r10);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(@NonNull c r10) {
        setSelection2(r10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeValue(this.selectedStartItem);
        r10.writeValue(this.selectedEndItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public c getSelection() {
        return new c(this.selectedStartItem, this.selectedEndItem);
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(@NonNull c r10) {
        Object r11 = r10.f2646a;
        if (r11 != null) goto L5;
    L7:
        Object r12 = r10.f2646a;
        Long r13 = null;
        if (r12 != null) goto L10;
        Long r14 = null;
    L11:
        this.selectedStartItem = r14;
        Object r15 = r10.f2647b;
        if (r15 == null) goto L15;
        r13 = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) r15).longValue()));
    L15:
        this.selectedEndItem = r13;
        return;
    L10:
        r14 = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) r12).longValue()));
        goto L11
    L5:
        if (r10.f2647b == null) goto L7;
        e.a(isValidRange(((Long) r11).longValue(), ((Long) r10.f2647b).longValue()));
        goto L7
    }
}
