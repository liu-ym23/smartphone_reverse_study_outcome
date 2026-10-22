package com.stepos.common.picker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.ability.R;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TimePicker2 extends FrameLayout {
    public static final /* synthetic */ int m = 0;

    /* renamed from: a, reason: collision with root package name */
    public final WheelPicker f3574a;
    public final WheelPicker b;
    public final WheelPicker c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public final String h;
    public final String[] i;

    /* renamed from: j, reason: collision with root package name */
    public final String[] f3575j;
    public final String[] k;
    public final String[] l;

    public static class SavedStated extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedStated> CREATOR = new o();
        private final int hour;
        private final int minute;

        public /* synthetic */ SavedStated(Parcelable parcelable, int i, int i6, m mVar) {
            this(parcelable, i, i6);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hour);
            parcel.writeInt(this.minute);
        }

        public SavedStated(Parcel parcel) {
            super(parcel);
            this.hour = parcel.readInt();
            this.minute = parcel.readInt();
        }

        private SavedStated(Parcelable parcelable, int i, int i6) {
            super(parcelable);
            this.hour = i;
            this.minute = i6;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePicker2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i;
        super(context, attributeSet, 0);
        this.g = true;
        String[] strArr = new String[24];
        this.i = strArr;
        String[] strArr2 = new String[12];
        this.f3575j = strArr2;
        this.k = new String[60];
        String[] strArr3 = new String[4];
        this.l = strArr3;
        Calendar calendar = Calendar.getInstance();
        this.d = calendar.get(11);
        this.e = calendar.get(12);
        boolean zIs24HourFormat = DateFormat.is24HourFormat(context);
        this.f = zIs24HourFormat;
        if (!zIs24HourFormat && (i = this.d) >= 12) {
            this.d = i - 12;
            this.g = false;
        }
        View.inflate(getContext(), R.layout.stepos_time_picker2_column, this);
        WheelPicker wheelPicker = (WheelPicker) findViewById(R.id.am_pm_picker);
        this.f3574a = wheelPicker;
        WheelPicker wheelPicker2 = (WheelPicker) findViewById(R.id.hour_picker);
        this.b = wheelPicker2;
        this.c = (WheelPicker) findViewById(R.id.minute_picker);
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        wheelPicker.setItemCount(3);
        strArr3[3] = "";
        strArr3[0] = "";
        String str = amPmStrings[0];
        strArr3[1] = str;
        strArr3[2] = amPmStrings[1];
        this.h = str;
        wheelPicker.a(new m(this));
        String str2 = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        int i6 = 0;
        for (int i10 = 24; i6 < i10; i10 = 24) {
            strArr[i6] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i6));
            if (i6 <= 9) {
                StringBuilder sbV = androidx.compose.foundation.b.v(str2);
                sbV.append(strArr[i6]);
                strArr[i6] = sbV.toString();
            }
            i6++;
        }
        int i11 = 1;
        for (int i12 = 12; i11 <= i12; i12 = 12) {
            int i13 = i11 - 1;
            strArr2[i13] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i11));
            if (i11 < 10) {
                StringBuilder sbV2 = androidx.compose.foundation.b.v(str2);
                sbV2.append(strArr2[i13]);
                strArr2[i13] = sbV2.toString();
            }
            i11++;
        }
        wheelPicker2.setDrawFlagEnable(true);
        wheelPicker2.setFlagText(getContext().getString(R.string.mc_date_time_hour));
        if (this.f) {
            wheelPicker2.e(Arrays.asList(strArr), this.d, true);
            wheelPicker.setVisibility(8);
        } else {
            wheelPicker2.e(Arrays.asList(strArr2), this.d - 1, true);
            wheelPicker.e(Arrays.asList(this.l), 0, false);
        }
        final int i14 = 1;
        wheelPicker2.a(new s(this) { // from class: com.stepos.common.picker.l
            public final /* synthetic */ TimePicker2 b;

            {
                this.b = this;
            }

            @Override // com.stepos.common.picker.s
            public final void a(String str3) {
                int i15 = i14;
                TimePicker2 timePicker2 = this.b;
                switch (i15) {
                    case 0:
                        int i16 = TimePicker2.m;
                        try {
                            timePicker2.e = Integer.parseInt(str3);
                            break;
                        } catch (NumberFormatException unused) {
                            androidx.constraintlayout.core.dsl.a.w("NumberFormat parse minute has an error, text:", str3, "TimePicker2");
                            return;
                        }
                    default:
                        int i17 = TimePicker2.m;
                        try {
                            timePicker2.d = Integer.parseInt(str3);
                            break;
                        } catch (NumberFormatException unused2) {
                            androidx.constraintlayout.core.dsl.a.w("NumberFormat parse hour has an error, text:", str3, "TimePicker2");
                        }
                }
            }
        });
        WheelPicker wheelPicker3 = this.c;
        String[] strArr4 = this.k;
        String str3 = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i15 = 0; i15 < 60; i15++) {
            strArr4[i15] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i15));
            if (i15 <= 9) {
                StringBuilder sbV3 = androidx.compose.foundation.b.v(str3);
                sbV3.append(strArr4[i15]);
                strArr4[i15] = sbV3.toString();
            }
        }
        wheelPicker3.setDrawFlagEnable(true);
        wheelPicker3.setFlagText(getContext().getString(R.string.mc_date_time_min));
        wheelPicker3.e(Arrays.asList(strArr4), this.e, true);
        final int i16 = 0;
        wheelPicker3.a(new s(this) { // from class: com.stepos.common.picker.l
            public final /* synthetic */ TimePicker2 b;

            {
                this.b = this;
            }

            @Override // com.stepos.common.picker.s
            public final void a(String str32) {
                int i152 = i16;
                TimePicker2 timePicker2 = this.b;
                switch (i152) {
                    case 0:
                        int i162 = TimePicker2.m;
                        try {
                            timePicker2.e = Integer.parseInt(str32);
                            break;
                        } catch (NumberFormatException unused) {
                            androidx.constraintlayout.core.dsl.a.w("NumberFormat parse minute has an error, text:", str32, "TimePicker2");
                            return;
                        }
                    default:
                        int i17 = TimePicker2.m;
                        try {
                            timePicker2.d = Integer.parseInt(str32);
                            break;
                        } catch (NumberFormatException unused2) {
                            androidx.constraintlayout.core.dsl.a.w("NumberFormat parse hour has an error, text:", str32, "TimePicker2");
                        }
                }
            }
        });
    }

    public final void a(int i, int i6, boolean z10) {
        boolean z11;
        boolean z12;
        int i10;
        boolean z13 = this.f != z10;
        if (this.d != i) {
            this.d = i;
            z11 = true;
        } else {
            z11 = false;
        }
        this.g = true;
        if (!z10 && (i10 = this.d) > 12) {
            this.d = i10 - 12;
            this.g = false;
            z11 = true;
        }
        if (this.e != i6) {
            this.e = i6;
            z12 = true;
        } else {
            z12 = false;
        }
        WheelPicker wheelPicker = this.b;
        if (z13) {
            List listAsList = Arrays.asList(z10 ? this.i : this.f3575j);
            int i11 = this.d;
            if (!z10) {
                i11--;
            }
            wheelPicker.e(listAsList, i11, true);
        }
        if (z11) {
            int i12 = this.d;
            if (!z10) {
                i12--;
            }
            wheelPicker.setCurrentItem(i12);
        }
        if (z12) {
            this.c.setCurrentItem(this.e);
        }
        this.f = z10;
        WheelPicker wheelPicker2 = this.f3574a;
        if (z10) {
            wheelPicker2.setVisibility(8);
            return;
        }
        wheelPicker2.e(Arrays.asList(this.l), 0, false);
        wheelPicker2.setVisibility(0);
        wheelPicker2.setCurrentItem(this.g ? 1 : 2);
    }

    public WheelPicker getAmPmPicker() {
        return this.f3574a;
    }

    public int getHour() {
        if (!this.f && !this.g) {
            return this.d + 12;
        }
        return this.d;
    }

    public WheelPicker getHourPicker() {
        return this.b;
    }

    public int getMinute() {
        return this.e;
    }

    public WheelPicker getMinutePicker() {
        return this.c;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedStated savedStated = (SavedStated) parcelable;
        super.onRestoreInstanceState(savedStated.getSuperState());
        a(savedStated.hour, savedStated.minute, this.f);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedStated(super.onSaveInstanceState(), this.d, this.e, null);
    }

    public void set24HourFormat(boolean z10) {
        a(this.d, this.e, z10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f3574a.setEnabled(z10);
        this.b.setEnabled(z10);
        this.c.setEnabled(z10);
    }

    public void setHour(int i) {
        if (i == getHour()) {
            return;
        }
        a(i, this.e, this.f);
    }

    public void setMinute(int i) {
        if (i == getMinute()) {
            return;
        }
        a(this.d, i, this.f);
    }

    @Deprecated
    public void setOnTimeChangedListener(n nVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        WheelPicker wheelPicker = this.f3574a;
        if (wheelPicker != null) {
            wheelPicker.setVisibility(i);
        }
        WheelPicker wheelPicker2 = this.b;
        if (wheelPicker2 != null) {
            wheelPicker2.setVisibility(i);
        }
        WheelPicker wheelPicker3 = this.c;
        if (wheelPicker3 != null) {
            wheelPicker3.setVisibility(i);
        }
    }
}
