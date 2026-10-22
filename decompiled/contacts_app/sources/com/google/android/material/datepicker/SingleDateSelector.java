package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = null;
    private CharSequence error;
    private Long selectedItem;
    private SimpleDateFormat textInputFormat;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ Long getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(Long r1) {
        setSelection2(r1);
    }

    public SingleDateSelector() {
    }

    static /* synthetic */ void access$000(SingleDateSelector r0) {
        r0.clearSelection();
    }

    static /* synthetic */ CharSequence access$102(SingleDateSelector r0, CharSequence r1) {
        r0.error = r1;
        return r1;
    }

    static /* synthetic */ Long access$202(SingleDateSelector r0, Long r1) {
        r0.selectedItem = r1;
        return r1;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r1) {
        this.selectedItem = Long.valueOf(r1);
    }

    private void clearSelection() {
        this.selectedItem = null;
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(Long r3) {
        if (r3 != null) goto L4;
        Long r4 = null;
    L5:
        this.selectedItem = r4;
        return;
    L4:
        r4 = Long.valueOf(UtcDates.canonicalYearMonthDay(r3.longValue()));
        goto L5
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        if (this.selectedItem == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList r0 = new ArrayList();
        Long r1 = this.selectedItem;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        return r0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(SimpleDateFormat r1) {
        this.textInputFormat = r1;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater r11, ViewGroup r12, Bundle r13, final CalendarConstraints r14, final OnSelectionChangedListener<Long> r15) {
        View r16 = r11.inflate(R.layout.mtrl_picker_text_input_date, r12, false);
        final TextInputLayout r8 = (TextInputLayout) r16.findViewById(R.id.mtrl_picker_text_input_date);
        r8.setErrorAccessibilityLiveRegion(0);
        EditText r17 = r8.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters() == false) goto L5;
        r17.setInputType(17);
    L5:
        SimpleDateFormat r18 = this.textInputFormat;
        if (r18 == null) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r18 = UtcDates.getDefaultTextInputFormat();
    L12:
        final SimpleDateFormat r4 = r18;
        if (r1 == false) goto L15;
        String r19 = r4.toPattern();
    L16:
        final String r3 = r19;
        r8.setPlaceholderText(r3);
        Long r110 = this.selectedItem;
        if (r110 == null) goto L19;
        r17.setText(r4.format(r110));
    L19:
        r17.addTextChangedListener(new AnonymousClass1(this, r3, r4, r8, r14, r15, r8));
        DateSelector.showKeyboardWithAutoHideBehavior(new EditText[]{r17});
        return r16;
    L15:
        r19 = UtcDates.getDefaultTextInputHint(r16.getResources(), r4);
        goto L16
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context r2) {
        return MaterialAttributes.resolveOrThrow(r2, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context r4) {
        Resources r5 = r4.getResources();
        Long r3 = this.selectedItem;
        if (r3 == null) goto L5;
        String r6 = DateStrings.getYearMonthDay(r3.longValue());
        return r5.getString(R.string.mtrl_picker_date_header_selected, new Object[]{r6});
    L5:
        return r5.getString(R.string.mtrl_picker_date_header_unselected);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(Context r4) {
        Resources r5 = r4.getResources();
        Long r3 = this.selectedItem;
        if (r3 != null) goto L5;
        String r6 = r5.getString(R.string.mtrl_picker_announce_current_selection_none);
    L7:
        return r5.getString(R.string.mtrl_picker_announce_current_selection, new Object[]{r6});
    L5:
        r6 = DateStrings.getYearMonthDay(r3.longValue());
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
        return R.string.mtrl_picker_date_header_title;
    }

    static {
        CREATOR = new AnonymousClass2();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeValue(this.selectedItem);
    }
}
