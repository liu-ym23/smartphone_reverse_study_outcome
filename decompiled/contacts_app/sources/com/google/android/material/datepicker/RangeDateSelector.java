package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.android.contacts.util.HanziToPinyin;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = null;
    private CharSequence error;
    private final String invalidRangeEndError;
    private String invalidRangeStartError;
    private Long proposedTextEnd;
    private Long proposedTextStart;
    private Long selectedEndItem;
    private Long selectedStartItem;
    private SimpleDateFormat textInputFormat;

    private boolean isValidRange(long r1, long r3) {
        if (r1 > r3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ Pair<Long, Long> getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(Pair<Long, Long> r1) {
        setSelection2(r1);
    }

    public RangeDateSelector() {
        this.invalidRangeEndError = HanziToPinyin.Token.SEPARATOR;
        this.selectedStartItem = null;
        this.selectedEndItem = null;
        this.proposedTextStart = null;
        this.proposedTextEnd = null;
    }

    static /* synthetic */ Long access$002(RangeDateSelector r0, Long r1) {
        r0.proposedTextStart = r1;
        return r1;
    }

    static /* synthetic */ void access$100(RangeDateSelector r0, TextInputLayout r1, TextInputLayout r2, OnSelectionChangedListener r3) {
        r0.updateIfValidTextProposal(r1, r2, r3);
    }

    static /* synthetic */ Long access$202(RangeDateSelector r0, Long r1) {
        r0.proposedTextEnd = r1;
        return r1;
    }

    static /* synthetic */ Long access$302(RangeDateSelector r0, Long r1) {
        r0.selectedStartItem = r1;
        return r1;
    }

    static /* synthetic */ Long access$402(RangeDateSelector r0, Long r1) {
        r0.selectedEndItem = r1;
        return r1;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r3) {
        Long r0 = this.selectedStartItem;
        if (r0 != null) goto L6;
        this.selectedStartItem = Long.valueOf(r3);
        return;
    L6:
        if (this.selectedEndItem == null) goto L8;
    L10:
        this.selectedEndItem = null;
        this.selectedStartItem = Long.valueOf(r3);
        return;
    L8:
        if (isValidRange(r0.longValue(), r3) == false) goto L10;
        this.selectedEndItem = Long.valueOf(r3);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long r0 = this.selectedStartItem;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.selectedEndItem == null) goto L9;
        if (isValidRange(r0.longValue(), this.selectedEndItem.longValue()) == false) goto L9;
        return true;
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(Pair<Long, Long> r5) {
        if (r5.first != null) goto L5;
    L7:
        Long r1 = null;
        if (r5.first != null) goto L10;
        Long r0 = null;
    L11:
        this.selectedStartItem = r0;
        if (r5.second == null) goto L15;
        r1 = Long.valueOf(UtcDates.canonicalYearMonthDay(r5.second.longValue()));
    L15:
        this.selectedEndItem = r1;
        return;
    L10:
        r0 = Long.valueOf(UtcDates.canonicalYearMonthDay(r5.first.longValue()));
        goto L11
    L5:
        if (r5.second == null) goto L7;
        Preconditions.checkArgument(isValidRange(r5.first.longValue(), r5.second.longValue()));
        goto L7
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Pair<Long, Long> getSelection() {
        return new Pair(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        ArrayList r0 = new ArrayList();
        r0.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return r0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList r0 = new ArrayList();
        Long r1 = this.selectedStartItem;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        Long r2 = this.selectedEndItem;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        return r0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context r3) {
        Resources r2 = r3.getResources();
        DisplayMetrics r0 = r2.getDisplayMetrics();
        int r4 = r2.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis);
        if (Math.min(r0.widthPixels, r0.heightPixels) <= r4) goto L5;
        int r5 = R.attr.materialCalendarTheme;
    L7:
        return MaterialAttributes.resolveOrThrow(r3, r5, MaterialDatePicker.class.getCanonicalName());
    L5:
        r5 = R.attr.materialCalendarFullscreenTheme;
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context r6) {
        Resources r7 = r6.getResources();
        Long r0 = this.selectedStartItem;
        if (r0 == null) goto L5;
    L8:
        Long r1 = this.selectedEndItem;
        if (r1 == null) goto L11;
        if (r0 == null) goto L14;
        Pair<String, String> r5 = DateStrings.getDateRangeString(r0, r1);
        return r7.getString(R.string.mtrl_picker_range_header_selected, new Object[]{r5.first, r5.second});
    L14:
        return r7.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[]{DateStrings.getDateString(this.selectedEndItem.longValue())});
    L11:
        return r7.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[]{DateStrings.getDateString(this.selectedStartItem.longValue())});
    L5:
        if (this.selectedEndItem != null) goto L8;
        return r7.getString(R.string.mtrl_picker_range_header_unselected);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(Context r5) {
        Resources r6 = r5.getResources();
        Pair<String, String> r4 = DateStrings.getDateRangeString(this.selectedStartItem, this.selectedEndItem);
        if (r4.first != null) goto L5;
        String r0 = r6.getString(R.string.mtrl_picker_announce_current_selection_none);
    L7:
        if (r4.second != null) goto L9;
        String r7 = r6.getString(R.string.mtrl_picker_announce_current_selection_none);
    L11:
        return r6.getString(R.string.mtrl_picker_announce_current_range_selection, new Object[]{r0, r7});
    L9:
        r7 = r4.second;
        goto L11
    L5:
        r0 = r4.first;
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getError() {
        if (TextUtils.isEmpty(this.error) == false) goto L6;
        return null;
    L6:
        return this.error.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(SimpleDateFormat r1) {
        this.textInputFormat = r1;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater r20, ViewGroup r21, Bundle r22, final CalendarConstraints r23, final OnSelectionChangedListener<Pair<Long, Long>> r24) {
        View r11 = r20.inflate(R.layout.mtrl_picker_text_input_date_range, r21, false);
        final TextInputLayout r12 = (TextInputLayout) r11.findViewById(R.id.mtrl_picker_text_input_range_start);
        final TextInputLayout r13 = (TextInputLayout) r11.findViewById(R.id.mtrl_picker_text_input_range_end);
        r12.setErrorAccessibilityLiveRegion(0);
        r13.setErrorAccessibilityLiveRegion(0);
        EditText r14 = r12.getEditText();
        EditText r15 = r13.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters() == false) goto L5;
        r14.setInputType(17);
        r15.setInputType(17);
    L5:
        this.invalidRangeStartError = r11.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat r0 = this.textInputFormat;
        if (r0 == null) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r0 = UtcDates.getDefaultTextInputFormat();
    L12:
        final SimpleDateFormat r8 = r0;
        Long r2 = this.selectedStartItem;
        if (r2 == null) goto L15;
        r14.setText(r8.format(r2));
        this.proposedTextStart = this.selectedStartItem;
    L15:
        Long r3 = this.selectedEndItem;
        if (r3 == null) goto L18;
        r15.setText(r8.format(r3));
        this.proposedTextEnd = this.selectedEndItem;
    L18:
        if (r1 == false) goto L20;
        String r4 = r8.toPattern();
    L21:
        final String r7 = r4;
        r12.setPlaceholderText(r7);
        r13.setPlaceholderText(r7);
        r14.addTextChangedListener(new AnonymousClass1(this, r7, r8, r12, r23, r12, r13, r24));
        r15.addTextChangedListener(new AnonymousClass2(this, r7, r8, r13, r23, r12, r13, r24));
        DateSelector.showKeyboardWithAutoHideBehavior(new EditText[]{r14, r15});
        return r11;
    L20:
        r4 = UtcDates.getDefaultTextInputHint(r11.getResources(), r8);
        goto L21
    L8:
        r1 = false;
        goto L9
    }

    private void updateIfValidTextProposal(TextInputLayout r5, TextInputLayout r6, OnSelectionChangedListener<Pair<Long, Long>> r7) {
        Long r0 = this.proposedTextStart;
        if (r0 != null) goto L5;
    L11:
        clearInvalidRange(r5, r6);
        r7.onIncompleteSelectionChanged();
    L12:
        updateError(r5, r6);
        return;
    L5:
        if (this.proposedTextEnd == null) goto L11;
        if (isValidRange(r0.longValue(), this.proposedTextEnd.longValue()) == false) goto L10;
        this.selectedStartItem = this.proposedTextStart;
        this.selectedEndItem = this.proposedTextEnd;
        r7.onSelectionChanged(getSelection());
        goto L12
    L10:
        setInvalidRange(r5, r6);
        r7.onIncompleteSelectionChanged();
        goto L12
    }

    private void updateError(TextInputLayout r2, TextInputLayout r3) {
        if (TextUtils.isEmpty(r2.getError()) == true) goto L6;
        this.error = r2.getError();
        return;
    L6:
        if (TextUtils.isEmpty(r3.getError()) == true) goto L8;
        this.error = r3.getError();
        return;
    L8:
        this.error = null;
    }

    private void clearInvalidRange(TextInputLayout r3, TextInputLayout r4) {
        if (r3.getError() == null) goto L8;
        if (this.invalidRangeStartError.contentEquals(r3.getError()) == false) goto L8;
        r3.setError(null);
    L8:
        if (r4.getError() != null) goto L10;
        return;
    L10:
        if (HanziToPinyin.Token.SEPARATOR.contentEquals(r4.getError()) == false) goto L14;
        r4.setError(null);
        return;
    }

    private void setInvalidRange(TextInputLayout r1, TextInputLayout r2) {
        r1.setError(this.invalidRangeStartError);
        r2.setError(HanziToPinyin.Token.SEPARATOR);
    }

    static {
        CREATOR = new AnonymousClass3();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeValue(this.selectedStartItem);
        r1.writeValue(this.selectedEndItem);
    }
}
