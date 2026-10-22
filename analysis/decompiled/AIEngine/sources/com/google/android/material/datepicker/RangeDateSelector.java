package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.aiengine.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RangeDateSelector implements DateSelector<u0.b<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();
    private CharSequence error;
    private String invalidRangeStartError;
    private SimpleDateFormat textInputFormat;
    private final String invalidRangeEndError = " ";
    private Long selectedStartItem = null;
    private Long selectedEndItem = null;
    private Long proposedTextStart = null;
    private Long proposedTextEnd = null;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends d {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f4928l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f4929m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ p f4930n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, p pVar) {
            super(str, simpleDateFormat, textInputLayout, calendarConstraints);
            this.f4928l = textInputLayout2;
            this.f4929m = textInputLayout3;
            this.f4930n = pVar;
        }

        @Override // com.google.android.material.datepicker.d
        public final void a() throws Resources.NotFoundException {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.proposedTextStart = null;
            rangeDateSelector.updateIfValidTextProposal(this.f4928l, this.f4929m, this.f4930n);
        }

        @Override // com.google.android.material.datepicker.d
        public final void b(Long l10) throws Resources.NotFoundException {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.proposedTextStart = l10;
            rangeDateSelector.updateIfValidTextProposal(this.f4928l, this.f4929m, this.f4930n);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends d {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f4932l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f4933m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ p f4934n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, p pVar) {
            super(str, simpleDateFormat, textInputLayout, calendarConstraints);
            this.f4932l = textInputLayout2;
            this.f4933m = textInputLayout3;
            this.f4934n = pVar;
        }

        @Override // com.google.android.material.datepicker.d
        public final void a() throws Resources.NotFoundException {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.proposedTextEnd = null;
            rangeDateSelector.updateIfValidTextProposal(this.f4932l, this.f4933m, this.f4934n);
        }

        @Override // com.google.android.material.datepicker.d
        public final void b(Long l10) throws Resources.NotFoundException {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.proposedTextEnd = l10;
            rangeDateSelector.updateIfValidTextProposal(this.f4932l, this.f4933m, this.f4934n);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        public final RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        public final RangeDateSelector[] newArray(int i10) {
            return new RangeDateSelector[i10];
        }
    }

    private void clearInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) throws Resources.NotFoundException {
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

    private void setInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) throws Resources.NotFoundException {
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
    public void updateIfValidTextProposal(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, p<u0.b<Long, Long>> pVar) throws Resources.NotFoundException {
        Long l10 = this.proposedTextStart;
        if (l10 == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            pVar.a();
        } else if (isValidRange(l10.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            pVar.b(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            pVar.a();
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
        return w4.b.c(context, MaterialDatePicker.class.getCanonicalName(), Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme).data;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
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
    public Collection<u0.b<Long, Long>> getSelectedRanges() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new u0.b(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(Context context) {
        Resources resources = context.getResources();
        u0.b<String, String> bVarA = g.a(this.selectedStartItem, this.selectedEndItem);
        String str = bVarA.f13138a;
        String string = str == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : str;
        String str2 = bVarA.f13139b;
        return resources.getString(R.string.mtrl_picker_announce_current_range_selection, string, str2 == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : str2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.selectedStartItem;
        if (l10 == null && this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l11 = this.selectedEndItem;
        if (l11 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, g.b(l10.longValue()));
        }
        if (l10 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, g.b(l11.longValue()));
        }
        u0.b<String, String> bVarA = g.a(l10, l11);
        return resources.getString(R.string.mtrl_picker_range_header_selected, bVarA.f13138a, bVarA.f13139b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long l10 = this.selectedStartItem;
        return (l10 == null || this.selectedEndItem == null || !isValidRange(l10.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    @Override // com.google.android.material.datepicker.DateSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateTextInputView(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13, com.google.android.material.datepicker.CalendarConstraints r14, com.google.android.material.datepicker.p<u0.b<java.lang.Long, java.lang.Long>> r15) {
        /*
            r10 = this;
            r13 = 2131493057(0x7f0c00c1, float:1.8609583E38)
            r0 = 0
            android.view.View r11 = r11.inflate(r13, r12, r0)
            r12 = 2131296784(0x7f090210, float:1.8211494E38)
            android.view.View r12 = r11.findViewById(r12)
            r5 = r12
            com.google.android.material.textfield.TextInputLayout r5 = (com.google.android.material.textfield.TextInputLayout) r5
            r12 = 2131296783(0x7f09020f, float:1.8211492E38)
            android.view.View r12 = r11.findViewById(r12)
            r8 = r12
            com.google.android.material.textfield.TextInputLayout r8 = (com.google.android.material.textfield.TextInputLayout) r8
            android.widget.EditText r12 = r5.getEditText()
            android.widget.EditText r13 = r8.getEditText()
            android.content.Context r1 = r11.getContext()
            r2 = 2130968924(0x7f04015c, float:1.7546515E38)
            java.lang.Integer r1 = jd.b.t(r2, r1)
            if (r1 == 0) goto L3f
            int r2 = r1.intValue()
            r12.setHintTextColor(r2)
            int r1 = r1.intValue()
            r13.setHintTextColor(r1)
        L3f:
            java.lang.String r1 = android.os.Build.MANUFACTURER
            java.lang.String r2 = ""
            if (r1 == 0) goto L4c
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r3 = r1.toLowerCase(r3)
            goto L4d
        L4c:
            r3 = r2
        L4d:
            java.lang.String r4 = "lge"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L65
            if (r1 == 0) goto L5d
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r2 = r1.toLowerCase(r2)
        L5d:
            java.lang.String r1 = "samsung"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L6d
        L65:
            r1 = 17
            r12.setInputType(r1)
            r13.setInputType(r1)
        L6d:
            android.content.res.Resources r1 = r11.getResources()
            r2 = 2131886560(0x7f1201e0, float:1.9407702E38)
            java.lang.String r1 = r1.getString(r2)
            r10.invalidRangeStartError = r1
            java.text.SimpleDateFormat r1 = r10.textInputFormat
            if (r1 == 0) goto L7f
            r0 = 1
        L7f:
            if (r0 == 0) goto L83
        L81:
            r4 = r1
            goto L88
        L83:
            java.text.SimpleDateFormat r1 = com.google.android.material.datepicker.s.d()
            goto L81
        L88:
            java.lang.Long r1 = r10.selectedStartItem
            if (r1 == 0) goto L97
            java.lang.String r1 = r4.format(r1)
            r12.setText(r1)
            java.lang.Long r1 = r10.selectedStartItem
            r10.proposedTextStart = r1
        L97:
            java.lang.Long r1 = r10.selectedEndItem
            if (r1 == 0) goto La6
            java.lang.String r1 = r4.format(r1)
            r13.setText(r1)
            java.lang.Long r1 = r10.selectedEndItem
            r10.proposedTextEnd = r1
        La6:
            if (r0 == 0) goto Lae
            java.lang.String r0 = r4.toPattern()
        Lac:
            r3 = r0
            goto Lb7
        Lae:
            android.content.res.Resources r0 = r11.getResources()
            java.lang.String r0 = com.google.android.material.datepicker.s.e(r0, r4)
            goto Lac
        Lb7:
            r5.setPlaceholderText(r3)
            r8.setPlaceholderText(r3)
            com.google.android.material.datepicker.RangeDateSelector$a r1 = new com.google.android.material.datepicker.RangeDateSelector$a
            r7 = r5
            r2 = r10
            r6 = r14
            r9 = r15
            r1.<init>(r3, r4, r5, r6, r7, r8, r9)
            r12.addTextChangedListener(r1)
            com.google.android.material.datepicker.RangeDateSelector$b r1 = new com.google.android.material.datepicker.RangeDateSelector$b
            r5 = r8
            r1.<init>(r3, r4, r5, r6, r7, r8, r9)
            r13.addTextChangedListener(r1)
            android.content.Context r10 = r11.getContext()
            boolean r10 = com.google.android.material.datepicker.DateSelector.isTouchExplorationEnabled(r10)
            if (r10 != 0) goto Le3
            android.widget.EditText[] r10 = new android.widget.EditText[]{r12, r13}
            com.google.android.material.datepicker.DateSelector.showKeyboardWithAutoHideBehavior(r10)
        Le3:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.RangeDateSelector.onCreateTextInputView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle, com.google.android.material.datepicker.CalendarConstraints, com.google.android.material.datepicker.p):android.view.View");
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
            AtomicReference<r> atomicReference = s.f4987a;
            DateFormat dateFormat = (DateFormat) simpleDateFormat.clone();
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            simpleDateFormat = (SimpleDateFormat) dateFormat;
        }
        this.textInputFormat = simpleDateFormat;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public u0.b<Long, Long> getSelection() {
        return new u0.b<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(u0.b<Long, Long> bVar) {
        Long l10 = bVar.f13138a;
        Long l11 = bVar.f13139b;
        if (l10 != null && l11 != null && !isValidRange(l10.longValue(), l11.longValue())) {
            throw new IllegalArgumentException();
        }
        Long l12 = bVar.f13138a;
        this.selectedStartItem = l12 == null ? null : Long.valueOf(s.a(l12.longValue()));
        this.selectedEndItem = l11 != null ? Long.valueOf(s.a(l11.longValue())) : null;
    }
}
