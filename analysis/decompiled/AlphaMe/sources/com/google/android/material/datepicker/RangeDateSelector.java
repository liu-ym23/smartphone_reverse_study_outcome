package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.RestrictTo;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.alphame.R;
import com.stepos.alphame.awareness.AwarenessDataItem;
import e.EnumC0546d;
import f1.AbstractC0557a;
import java.util.ArrayList;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class RangeDateSelector implements DateSelector<J.b> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new x(3);

    /* renamed from: a, reason: collision with root package name */
    public String f10664a;

    /* renamed from: b, reason: collision with root package name */
    public Long f10665b;

    /* renamed from: c, reason: collision with root package name */
    public Long f10666c;

    /* renamed from: d, reason: collision with root package name */
    public Long f10667d;

    /* renamed from: e, reason: collision with root package name */
    public Long f10668e;

    public static void c(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, C c4) {
        Long l4 = rangeDateSelector.f10667d;
        if (l4 == null || rangeDateSelector.f10668e == null) {
            if (textInputLayout.getError() != null && rangeDateSelector.f10664a.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError(null);
            }
            if (textInputLayout2.getError() != null && AwarenessDataItem.PERMISSION_SPLITTER.contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError(null);
            }
            c4.a();
        } else if (l4.longValue() <= rangeDateSelector.f10668e.longValue()) {
            Long l5 = rangeDateSelector.f10667d;
            rangeDateSelector.f10665b = l5;
            Long l6 = rangeDateSelector.f10668e;
            rangeDateSelector.f10666c = l6;
            c4.b(new J.b(l5, l6));
        } else {
            textInputLayout.setError(rangeDateSelector.f10664a);
            textInputLayout2.setError(AwarenessDataItem.PERMISSION_SPLITTER);
            c4.a();
        }
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            textInputLayout.getError();
        } else {
            if (TextUtils.isEmpty(textInputLayout2.getError())) {
                return;
            }
            textInputLayout2.getError();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    @Override // com.google.android.material.datepicker.DateSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View C(android.view.LayoutInflater r21, android.view.ViewGroup r22, com.google.android.material.datepicker.CalendarConstraints r23, com.google.android.material.datepicker.v r24) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.RangeDateSelector.C(android.view.LayoutInflater, android.view.ViewGroup, com.google.android.material.datepicker.CalendarConstraints, com.google.android.material.datepicker.v):android.view.View");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void D(long j4) {
        Long l4 = this.f10665b;
        if (l4 == null) {
            this.f10665b = Long.valueOf(j4);
        } else if (this.f10666c == null && l4.longValue() <= j4) {
            this.f10666c = Long.valueOf(j4);
        } else {
            this.f10666c = null;
            this.f10665b = Long.valueOf(j4);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String a(Context context) {
        Resources resources = context.getResources();
        J.b bVarB = B0.f.B(this.f10665b, this.f10666c);
        Object obj = bVarB.f848a;
        String string = obj == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) obj;
        Object obj2 = bVarB.f849b;
        return resources.getString(R.string.mtrl_picker_announce_current_range_selection, string, obj2 == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) obj2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String b(Context context) {
        Resources resources = context.getResources();
        Long l4 = this.f10665b;
        if (l4 == null && this.f10666c == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l5 = this.f10666c;
        if (l5 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, B0.f.C(l4.longValue()));
        }
        if (l4 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, B0.f.C(l5.longValue()));
        }
        J.b bVarB = B0.f.B(l4, l5);
        return resources.getString(R.string.mtrl_picker_range_header_selected, bVarB.f848a, bVarB.f849b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int d(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return AbstractC0557a.Y(context, MaterialDatePicker.class.getCanonicalName(), Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme).data;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new J.b(this.f10665b, this.f10666c));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean m() {
        Long l4 = this.f10665b;
        return (l4 == null || this.f10666c == null || l4.longValue() > this.f10666c.longValue()) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList u() {
        ArrayList arrayList = new ArrayList();
        Long l4 = this.f10665b;
        if (l4 != null) {
            arrayList.add(l4);
        }
        Long l5 = this.f10666c;
        if (l5 != null) {
            arrayList.add(l5);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Object w() {
        return new J.b(this.f10665b, this.f10666c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeValue(this.f10665b);
        parcel.writeValue(this.f10666c);
    }
}
