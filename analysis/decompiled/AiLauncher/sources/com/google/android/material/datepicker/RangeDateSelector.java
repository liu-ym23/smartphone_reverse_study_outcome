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
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
public class RangeDateSelector implements DateSelector<B0.d<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();
    private CharSequence error;
    private String invalidRangeStartError;
    private SimpleDateFormat textInputFormat;
    private final String invalidRangeEndError = " ";
    private Long selectedStartItem = null;
    private Long selectedEndItem = null;
    private Long proposedTextStart = null;
    private Long proposedTextEnd = null;

    public class a extends e {

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f20750i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f20751j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ r f20752k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, r rVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f20750i = textInputLayout2;
            this.f20751j = textInputLayout3;
            this.f20752k = rVar;
        }

        @Override // com.google.android.material.datepicker.e
        public void d() {
            RangeDateSelector.this.proposedTextStart = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f20750i, this.f20751j, this.f20752k);
        }

        @Override // com.google.android.material.datepicker.e
        public void e(Long l10) {
            RangeDateSelector.this.proposedTextStart = l10;
            RangeDateSelector.this.updateIfValidTextProposal(this.f20750i, this.f20751j, this.f20752k);
        }
    }

    public class b extends e {

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f20754i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f20755j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ r f20756k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, r rVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f20754i = textInputLayout2;
            this.f20755j = textInputLayout3;
            this.f20756k = rVar;
        }

        @Override // com.google.android.material.datepicker.e
        public void d() {
            RangeDateSelector.this.proposedTextEnd = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f20754i, this.f20755j, this.f20756k);
        }

        @Override // com.google.android.material.datepicker.e
        public void e(Long l10) {
            RangeDateSelector.this.proposedTextEnd = l10;
            RangeDateSelector.this.updateIfValidTextProposal(this.f20754i, this.f20755j, this.f20756k);
        }
    }

    public class c implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i10) {
            return new RangeDateSelector[i10];
        }
    }

    private void clearInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean isValidRange(long j10, long j11) {
        return j10 <= j11;
    }

    private void setInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    private void updateError(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.error = textInputLayout.getError();
        } else if (TextUtils.isEmpty(textInputLayout2.getError())) {
            this.error = null;
        } else {
            this.error = textInputLayout2.getError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIfValidTextProposal(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, r<B0.d<Long, Long>> rVar) {
        Long l10 = this.proposedTextStart;
        if (l10 == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            rVar.a();
        } else if (isValidRange(l10.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            rVar.b(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            rVar.a();
        }
        updateError(textInputLayout, textInputLayout2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return W2.b.f(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R$dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R$attr.materialCalendarTheme : R$attr.materialCalendarFullscreenTheme, m.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R$string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getError() {
        if (TextUtils.isEmpty(this.error)) {
            return null;
        }
        return this.error.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.selectedStartItem;
        if (l10 != null) {
            arrayList.add(l10);
        }
        Long l11 = this.selectedEndItem;
        if (l11 != null) {
            arrayList.add(l11);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<B0.d<Long, Long>> getSelectedRanges() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new B0.d(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(Context context) {
        Resources resources = context.getResources();
        B0.d<String, String> dVarA = h.a(this.selectedStartItem, this.selectedEndItem);
        String str = dVarA.f1411a;
        String string = str == null ? resources.getString(R$string.mtrl_picker_announce_current_selection_none) : str;
        String str2 = dVarA.f1412b;
        return resources.getString(R$string.mtrl_picker_announce_current_range_selection, string, str2 == null ? resources.getString(R$string.mtrl_picker_announce_current_selection_none) : str2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.selectedStartItem;
        if (l10 == null && this.selectedEndItem == null) {
            return resources.getString(R$string.mtrl_picker_range_header_unselected);
        }
        Long l11 = this.selectedEndItem;
        if (l11 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_start_selected, h.c(l10.longValue()));
        }
        if (l10 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_end_selected, h.c(l11.longValue()));
        }
        B0.d<String, String> dVarA = h.a(l10, l11);
        return resources.getString(R$string.mtrl_picker_range_header_selected, dVarA.f1411a, dVarA.f1412b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long l10 = this.selectedStartItem;
        return (l10 == null || this.selectedEndItem == null || !isValidRange(l10.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, r<B0.d<Long, Long>> rVar) {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        Integer numF = M2.a.f(viewInflate.getContext(), R$attr.colorOnSurfaceVariant);
        if (numF != null) {
            editText.setHintTextColor(numF.intValue());
            editText2.setHintTextColor(numF.intValue());
        }
        if (com.google.android.material.internal.i.b()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = viewInflate.getResources().getString(R$string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatF = this.textInputFormat;
        boolean z10 = simpleDateFormatF != null;
        if (!z10) {
            simpleDateFormatF = v.f();
        }
        SimpleDateFormat simpleDateFormat = simpleDateFormatF;
        Long l10 = this.selectedStartItem;
        if (l10 != null) {
            editText.setText(simpleDateFormat.format(l10));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l11 = this.selectedEndItem;
        if (l11 != null) {
            editText2.setText(simpleDateFormat.format(l11));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String pattern = z10 ? simpleDateFormat.toPattern() : v.g(viewInflate.getResources(), simpleDateFormat);
        textInputLayout.setPlaceholderText(pattern);
        textInputLayout2.setPlaceholderText(pattern);
        editText.addTextChangedListener(new a(pattern, simpleDateFormat, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, rVar));
        editText2.addTextChangedListener(new b(pattern, simpleDateFormat, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, rVar));
        if (!DateSelector.isTouchExplorationEnabled(viewInflate.getContext())) {
            DateSelector.showKeyboardWithAutoHideBehavior(editText, editText2);
        }
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j10) {
        Long l10 = this.selectedStartItem;
        if (l10 == null) {
            this.selectedStartItem = Long.valueOf(j10);
        } else if (this.selectedEndItem == null && isValidRange(l10.longValue(), j10)) {
            this.selectedEndItem = Long.valueOf(j10);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j10);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) v.i(simpleDateFormat);
        }
        this.textInputFormat = simpleDateFormat;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public B0.d<Long, Long> getSelection() {
        return new B0.d<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(B0.d<Long, Long> dVar) {
        Long l10 = dVar.f1411a;
        if (l10 != null && dVar.f1412b != null) {
            B0.h.a(isValidRange(l10.longValue(), dVar.f1412b.longValue()));
        }
        Long l11 = dVar.f1411a;
        this.selectedStartItem = l11 == null ? null : Long.valueOf(v.a(l11.longValue()));
        Long l12 = dVar.f1412b;
        this.selectedEndItem = l12 != null ? Long.valueOf(v.a(l12.longValue())) : null;
    }
}
