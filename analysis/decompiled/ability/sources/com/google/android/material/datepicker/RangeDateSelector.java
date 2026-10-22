package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import c3.AbstractC0872b;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.ability.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new C(1);

    @Nullable
    private CharSequence error;
    private String invalidRangeStartError;

    @Nullable
    private SimpleDateFormat textInputFormat;
    private final String invalidRangeEndError = " ";

    @Nullable
    private Long selectedStartItem = null;

    @Nullable
    private Long selectedEndItem = null;

    @Nullable
    private Long proposedTextStart = null;

    @Nullable
    private Long proposedTextEnd = null;

    private void clearInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean isValidRange(long j5, long j6) {
        return j5 <= j6;
    }

    private void setInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    private void updateError(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.error = textInputLayout.getError();
        } else if (TextUtils.isEmpty(textInputLayout2.getError())) {
            this.error = null;
        } else {
            this.error = textInputLayout2.getError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIfValidTextProposal(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull H h) {
        Long l = this.proposedTextStart;
        if (l == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            h.a();
        } else if (isValidRange(l.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            h.b(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            h.a();
        }
        updateError(textInputLayout, textInputLayout2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return AbstractC0872b.d(context, A.class.getCanonicalName(), Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme).data;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public String getError() {
        if (TextUtils.isEmpty(this.error)) {
            return null;
        }
        return this.error.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedStartItem;
        if (l != null) {
            arrayList.add(l);
        }
        Long l5 = this.selectedEndItem;
        if (l5 != null) {
            arrayList.add(l5);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionContentDescription(@NonNull Context context) {
        Resources resources = context.getResources();
        Pair pairY = U7.a.y(this.selectedStartItem, this.selectedEndItem);
        F f = pairY.first;
        String string = f == 0 ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) f;
        S s5 = pairY.second;
        return resources.getString(R.string.mtrl_picker_announce_current_range_selection, string, s5 == 0 ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) s5);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l = this.selectedStartItem;
        if (l == null && this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l5 = this.selectedEndItem;
        if (l5 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, U7.a.z(l.longValue()));
        }
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, U7.a.z(l5.longValue()));
        }
        Pair pairY = U7.a.y(l, l5);
        return resources.getString(R.string.mtrl_picker_range_header_selected, pairY.first, pairY.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long l = this.selectedStartItem;
        return (l == null || this.selectedEndItem == null || !isValidRange(l.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    @Override // com.google.android.material.datepicker.DateSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateTextInputView(@androidx.annotation.NonNull android.view.LayoutInflater r13, @androidx.annotation.Nullable android.view.ViewGroup r14, @androidx.annotation.Nullable android.os.Bundle r15, com.google.android.material.datepicker.CalendarConstraints r16, @androidx.annotation.NonNull com.google.android.material.datepicker.H r17) {
        /*
            r12 = this;
            r0 = 2131558622(0x7f0d00de, float:1.8742565E38)
            r1 = 0
            android.view.View r13 = r13.inflate(r0, r14, r1)
            r14 = 2131362451(0x7f0a0293, float:1.8344683E38)
            android.view.View r14 = r13.findViewById(r14)
            r6 = r14
            com.google.android.material.textfield.TextInputLayout r6 = (com.google.android.material.textfield.TextInputLayout) r6
            r14 = 2131362450(0x7f0a0292, float:1.834468E38)
            android.view.View r14 = r13.findViewById(r14)
            r9 = r14
            com.google.android.material.textfield.TextInputLayout r9 = (com.google.android.material.textfield.TextInputLayout) r9
            android.widget.EditText r14 = r6.getEditText()
            android.widget.EditText r0 = r9.getEditText()
            android.content.Context r2 = r13.getContext()
            r3 = 2130968924(0x7f04015c, float:1.7546515E38)
            java.lang.Integer r2 = W2.a.b(r3, r2)
            if (r2 == 0) goto L3f
            int r3 = r2.intValue()
            r14.setHintTextColor(r3)
            int r2 = r2.intValue()
            r0.setHintTextColor(r2)
        L3f:
            java.lang.String r2 = android.os.Build.MANUFACTURER
            java.lang.String r3 = ""
            if (r2 == 0) goto L4c
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.String r4 = r2.toLowerCase(r4)
            goto L4d
        L4c:
            r4 = r3
        L4d:
            java.lang.String r5 = "lge"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L65
            if (r2 == 0) goto L5d
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r3 = r2.toLowerCase(r3)
        L5d:
            java.lang.String r2 = "samsung"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L6d
        L65:
            r2 = 17
            r14.setInputType(r2)
            r0.setInputType(r2)
        L6d:
            android.content.res.Resources r2 = r13.getResources()
            r3 = 2131952010(0x7f13018a, float:1.954045E38)
            java.lang.String r2 = r2.getString(r3)
            r12.invalidRangeStartError = r2
            java.text.SimpleDateFormat r2 = r12.textInputFormat
            if (r2 == 0) goto L7f
            r1 = 1
        L7f:
            if (r1 == 0) goto L83
        L81:
            r5 = r2
            goto L88
        L83:
            java.text.SimpleDateFormat r2 = com.google.android.material.datepicker.O.d()
            goto L81
        L88:
            java.lang.Long r2 = r12.selectedStartItem
            if (r2 == 0) goto L97
            java.lang.String r2 = r5.format(r2)
            r14.setText(r2)
            java.lang.Long r2 = r12.selectedStartItem
            r12.proposedTextStart = r2
        L97:
            java.lang.Long r2 = r12.selectedEndItem
            if (r2 == 0) goto La6
            java.lang.String r2 = r5.format(r2)
            r0.setText(r2)
            java.lang.Long r2 = r12.selectedEndItem
            r12.proposedTextEnd = r2
        La6:
            if (r1 == 0) goto Lae
            java.lang.String r1 = r5.toPattern()
        Lac:
            r4 = r1
            goto Lb7
        Lae:
            android.content.res.Resources r1 = r13.getResources()
            java.lang.String r1 = com.google.android.material.datepicker.O.e(r1, r5)
            goto Lac
        Lb7:
            r6.setPlaceholderText(r4)
            r9.setPlaceholderText(r4)
            com.google.android.material.datepicker.J r2 = new com.google.android.material.datepicker.J
            r11 = 0
            r8 = r6
            r3 = r12
            r7 = r16
            r10 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r14.addTextChangedListener(r2)
            com.google.android.material.datepicker.J r2 = new com.google.android.material.datepicker.J
            r11 = 1
            r6 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0.addTextChangedListener(r2)
            android.content.Context r12 = r13.getContext()
            boolean r12 = com.google.android.material.datepicker.DateSelector.isTouchExplorationEnabled(r12)
            if (r12 != 0) goto Le7
            android.widget.EditText[] r12 = new android.widget.EditText[]{r14, r0}
            com.google.android.material.datepicker.DateSelector.showKeyboardWithAutoHideBehavior(r12)
        Le7:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.RangeDateSelector.onCreateTextInputView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle, com.google.android.material.datepicker.CalendarConstraints, com.google.android.material.datepicker.H):android.view.View");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j5) {
        Long l = this.selectedStartItem;
        if (l == null) {
            this.selectedStartItem = Long.valueOf(j5);
        } else if (this.selectedEndItem == null && isValidRange(l.longValue(), j5)) {
            this.selectedEndItem = Long.valueOf(j5);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j5);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            AtomicReference atomicReference = O.f2420a;
            DateFormat dateFormat = (DateFormat) simpleDateFormat.clone();
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            simpleDateFormat = (SimpleDateFormat) dateFormat;
        }
        this.textInputFormat = simpleDateFormat;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@NonNull Pair<Long, Long> pair) {
        Long l = pair.first;
        if (l != null && pair.second != null) {
            Preconditions.checkArgument(isValidRange(l.longValue(), pair.second.longValue()));
        }
        Long l5 = pair.first;
        this.selectedStartItem = l5 == null ? null : Long.valueOf(O.a(l5.longValue()));
        Long l9 = pair.second;
        this.selectedEndItem = l9 != null ? Long.valueOf(O.a(l9.longValue())) : null;
    }
}
