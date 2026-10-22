package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.aiengine.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();
    private CharSequence error;
    private Long selectedItem;
    private SimpleDateFormat textInputFormat;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends d {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ p f4936l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f4937m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, p pVar, TextInputLayout textInputLayout2) {
            super(str, simpleDateFormat, textInputLayout, calendarConstraints);
            this.f4936l = pVar;
            this.f4937m = textInputLayout2;
        }

        @Override // com.google.android.material.datepicker.d
        public final void a() {
            SingleDateSelector.this.error = this.f4937m.getError();
            this.f4936l.a();
        }

        @Override // com.google.android.material.datepicker.d
        public final void b(Long l10) {
            SingleDateSelector singleDateSelector = SingleDateSelector.this;
            if (l10 == null) {
                singleDateSelector.clearSelection();
            } else {
                singleDateSelector.select(l10.longValue());
            }
            singleDateSelector.error = null;
            this.f4936l.b(singleDateSelector.getSelection());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Parcelable.Creator<SingleDateSelector> {
        @Override // android.os.Parcelable.Creator
        public final SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        public final SingleDateSelector[] newArray(int i10) {
            return new SingleDateSelector[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context context) {
        return w4.b.c(context, MaterialDatePicker.class.getCanonicalName(), R.attr.materialCalendarTheme).data;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
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
        Long l10 = this.selectedItem;
        if (l10 != null) {
            arrayList.add(l10);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<u0.b<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.selectedItem;
        return resources.getString(R.string.mtrl_picker_announce_current_selection, l10 == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : g.d(l10.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.selectedItem;
        return l10 == null ? resources.getString(R.string.mtrl_picker_date_header_unselected) : resources.getString(R.string.mtrl_picker_date_header_selected, g.d(l10.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    @Override // com.google.android.material.datepicker.DateSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateTextInputView(android.view.LayoutInflater r10, android.view.ViewGroup r11, android.os.Bundle r12, com.google.android.material.datepicker.CalendarConstraints r13, com.google.android.material.datepicker.p<java.lang.Long> r14) {
        /*
            r9 = this;
            r12 = 2131493056(0x7f0c00c0, float:1.8609581E38)
            r0 = 0
            android.view.View r10 = r10.inflate(r12, r11, r0)
            r11 = 2131296782(0x7f09020e, float:1.821149E38)
            android.view.View r11 = r10.findViewById(r11)
            r5 = r11
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5
            android.widget.EditText r11 = r5.getEditText()
            android.content.Context r12 = r10.getContext()
            r1 = 2130968924(0x7f04015c, float:1.7546515E38)
            java.lang.Integer r12 = jd.b.t(r1, r12)
            if (r12 == 0) goto L2a
            int r12 = r12.intValue()
            r11.setHintTextColor(r12)
        L2a:
            java.lang.String r12 = android.os.Build.MANUFACTURER
            java.lang.String r1 = ""
            if (r12 == 0) goto L37
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r2 = r12.toLowerCase(r2)
            goto L38
        L37:
            r2 = r1
        L38:
            java.lang.String r3 = "lge"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L50
            if (r12 == 0) goto L48
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r12.toLowerCase(r1)
        L48:
            java.lang.String r12 = "samsung"
            boolean r12 = r1.equals(r12)
            if (r12 == 0) goto L55
        L50:
            r12 = 17
            r11.setInputType(r12)
        L55:
            java.text.SimpleDateFormat r12 = r9.textInputFormat
            if (r12 == 0) goto L5a
            r0 = 1
        L5a:
            if (r0 == 0) goto L5e
        L5c:
            r4 = r12
            goto L63
        L5e:
            java.text.SimpleDateFormat r12 = com.google.android.material.datepicker.s.d()
            goto L5c
        L63:
            if (r0 == 0) goto L6b
            java.lang.String r12 = r4.toPattern()
        L69:
            r3 = r12
            goto L74
        L6b:
            android.content.res.Resources r12 = r10.getResources()
            java.lang.String r12 = com.google.android.material.datepicker.s.e(r12, r4)
            goto L69
        L74:
            r5.setPlaceholderText(r3)
            java.lang.Long r12 = r9.selectedItem
            if (r12 == 0) goto L82
            java.lang.String r12 = r4.format(r12)
            r11.setText(r12)
        L82:
            com.google.android.material.datepicker.SingleDateSelector$a r1 = new com.google.android.material.datepicker.SingleDateSelector$a
            r8 = r5
            r2 = r9
            r6 = r13
            r7 = r14
            r1.<init>(r3, r4, r5, r6, r7, r8)
            r11.addTextChangedListener(r1)
            android.content.Context r9 = r10.getContext()
            boolean r9 = com.google.android.material.datepicker.DateSelector.isTouchExplorationEnabled(r9)
            if (r9 != 0) goto L9f
            android.widget.EditText[] r9 = new android.widget.EditText[]{r11}
            com.google.android.material.datepicker.DateSelector.showKeyboardWithAutoHideBehavior(r9)
        L9f:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.SingleDateSelector.onCreateTextInputView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle, com.google.android.material.datepicker.CalendarConstraints, com.google.android.material.datepicker.p):android.view.View");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j10) {
        this.selectedItem = Long.valueOf(j10);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            AtomicReference<r> atomicReference = s.f4987a;
            DateFormat dateFormat = (DateFormat) simpleDateFormat.clone();
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            simpleDateFormat = (SimpleDateFormat) dateFormat;
        }
        this.textInputFormat = simpleDateFormat;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.selectedItem);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(Long l10) {
        this.selectedItem = l10 == null ? null : Long.valueOf(s.a(l10.longValue()));
    }
}
