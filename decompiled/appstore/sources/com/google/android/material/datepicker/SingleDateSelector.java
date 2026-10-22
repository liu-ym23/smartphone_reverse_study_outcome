package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.c;
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
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = null;

    @Nullable
    private Long selectedItem;

    static {
        CREATOR = new AnonymousClass2();
    }

    public SingleDateSelector() {
    }

    public static /* synthetic */ void access$000(SingleDateSelector r10) {
        r10.clearSelection();
    }

    public static /* synthetic */ Long access$102(SingleDateSelector r10, Long r11) {
        r10.selectedItem = r11;
        return r11;
    }

    private void clearSelection() {
        this.selectedItem = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context r10) {
        return MaterialAttributes.resolveOrThrow(r10, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList r10 = new ArrayList();
        Long r11 = this.selectedItem;
        if (r11 == null) goto L5;
        r10.add(r11);
    L5:
        return r10;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<c> getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public /* bridge */ /* synthetic */ Long getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        Long r12 = this.selectedItem;
        if (r12 == null) goto L5;
        String r13 = DateStrings.getYearMonthDay(r12.longValue());
        return r11.getString(R.string.mtrl_picker_date_header_selected, new Object[]{r13});
    L5:
        return r11.getString(R.string.mtrl_picker_date_header_unselected);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        if (this.selectedItem == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12, final CalendarConstraints r13, @NonNull final OnSelectionChangedListener<Long> r14) {
        View r15 = r10.inflate(R.layout.mtrl_picker_text_input_date, r11, false);
        final TextInputLayout r16 = (TextInputLayout) r15.findViewById(R.id.mtrl_picker_text_input_date);
        EditText r17 = r16.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters() == false) goto L5;
        r17.setInputType(17);
    L5:
        final SimpleDateFormat r18 = UtcDates.getTextInputFormat();
        final String r19 = UtcDates.getTextInputHint(r15.getResources(), r18);
        r16.setPlaceholderText(r19);
        Long r110 = this.selectedItem;
        if (r110 == null) goto L8;
        r17.setText(r18.format(r110));
    L8:
        r17.addTextChangedListener(new AnonymousClass1(this, r19, r18, r16, r13, r14));
        ViewUtils.requestFocusAndShowKeyboard(r17);
        return r15;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r10) {
        this.selectedItem = Long.valueOf(r10);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(@Nullable Long r10) {
        setSelection2(r10);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeValue(this.selectedItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public Long getSelection() {
        return this.selectedItem;
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(@Nullable Long r10) {
        if (r10 != null) goto L4;
        Long r11 = null;
    L5:
        this.selectedItem = r11;
        return;
    L4:
        r11 = Long.valueOf(UtcDates.canonicalYearMonthDay(r10.longValue()));
        goto L5
    }
}
