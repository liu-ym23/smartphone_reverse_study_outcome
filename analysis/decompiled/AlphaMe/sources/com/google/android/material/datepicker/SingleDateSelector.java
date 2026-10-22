package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import e.EnumC0546d;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.Locale;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new x(4);

    /* renamed from: a, reason: collision with root package name */
    public Long f10669a;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    @Override // com.google.android.material.datepicker.DateSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View C(android.view.LayoutInflater r10, android.view.ViewGroup r11, com.google.android.material.datepicker.CalendarConstraints r12, com.google.android.material.datepicker.v r13) throws android.content.res.Resources.NotFoundException {
        /*
            r9 = this;
            r0 = 2131493057(0x7f0c00c1, float:1.8609583E38)
            r1 = 0
            android.view.View r10 = r10.inflate(r0, r11, r1)
            r11 = 2131296804(0x7f090224, float:1.8211535E38)
            android.view.View r11 = r10.findViewById(r11)
            r7 = r11
            com.google.android.material.textfield.TextInputLayout r7 = (com.google.android.material.textfield.TextInputLayout) r7
            android.widget.EditText r11 = r7.getEditText()
            android.content.Context r0 = r10.getContext()
            r1 = 2130968943(0x7f04016f, float:1.7546554E38)
            java.lang.Integer r0 = f1.AbstractC0557a.y(r1, r0)
            if (r0 == 0) goto L2a
            int r0 = r0.intValue()
            r11.setHintTextColor(r0)
        L2a:
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = ""
            if (r0 == 0) goto L37
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r2 = r0.toLowerCase(r2)
            goto L38
        L37:
            r2 = r1
        L38:
            java.lang.String r3 = "lge"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L50
            if (r0 == 0) goto L48
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r0.toLowerCase(r1)
        L48:
            java.lang.String r0 = "samsung"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L55
        L50:
            r0 = 17
            r11.setInputType(r0)
        L55:
            java.text.SimpleDateFormat r3 = com.google.android.material.datepicker.J.d()
            android.content.res.Resources r0 = r10.getResources()
            java.lang.String r2 = com.google.android.material.datepicker.J.e(r0, r3)
            r7.setPlaceholderText(r2)
            java.lang.Long r0 = r9.f10669a
            if (r0 == 0) goto L6f
            java.lang.String r0 = r3.format(r0)
            r11.setText(r0)
        L6f:
            com.google.android.material.datepicker.F r8 = new com.google.android.material.datepicker.F
            r0 = r8
            r1 = r9
            r4 = r7
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r11.addTextChangedListener(r8)
            android.content.Context r9 = r10.getContext()
            java.lang.String r12 = "accessibility"
            java.lang.Object r9 = r9.getSystemService(r12)
            android.view.accessibility.AccessibilityManager r9 = (android.view.accessibility.AccessibilityManager) r9
            if (r9 == 0) goto L91
            boolean r9 = r9.isTouchExplorationEnabled()
            if (r9 == 0) goto L91
            goto L98
        L91:
            android.widget.EditText[] r9 = new android.widget.EditText[]{r11}
            com.google.android.material.datepicker.DateSelector.I(r9)
        L98:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.SingleDateSelector.C(android.view.LayoutInflater, android.view.ViewGroup, com.google.android.material.datepicker.CalendarConstraints, com.google.android.material.datepicker.v):android.view.View");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void D(long j4) {
        this.f10669a = Long.valueOf(j4);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String a(Context context) {
        Resources resources = context.getResources();
        Long l4 = this.f10669a;
        return resources.getString(R.string.mtrl_picker_announce_current_selection, l4 == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : B0.f.K(l4.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String b(Context context) {
        Resources resources = context.getResources();
        Long l4 = this.f10669a;
        return l4 == null ? resources.getString(R.string.mtrl_picker_date_header_unselected) : resources.getString(R.string.mtrl_picker_date_header_selected, B0.f.K(l4.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int d(Context context) {
        return AbstractC0557a.Y(context, MaterialDatePicker.class.getCanonicalName(), R.attr.materialCalendarTheme).data;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList e() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean m() {
        return this.f10669a != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList u() {
        ArrayList arrayList = new ArrayList();
        Long l4 = this.f10669a;
        if (l4 != null) {
            arrayList.add(l4);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Object w() {
        return this.f10669a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeValue(this.f10669a);
    }
}
