package com.stepos.common.picker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.aiengine.R;
import com.stepos.common.picker.WheelPicker;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TimePicker2 extends FrameLayout {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f6495p = 0;

    /* renamed from: a, reason: collision with root package name */
    public final WheelPicker f6496a;

    /* renamed from: b, reason: collision with root package name */
    public final WheelPicker f6497b;

    /* renamed from: c, reason: collision with root package name */
    public final WheelPicker f6498c;

    /* renamed from: d, reason: collision with root package name */
    public int f6499d;

    /* renamed from: e, reason: collision with root package name */
    public int f6500e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6501j;

    /* renamed from: k, reason: collision with root package name */
    public final String f6502k;

    /* renamed from: l, reason: collision with root package name */
    public final String[] f6503l;

    /* renamed from: m, reason: collision with root package name */
    public final String[] f6504m;

    /* renamed from: n, reason: collision with root package name */
    public final String[] f6505n;

    /* renamed from: o, reason: collision with root package name */
    public final String[] f6506o;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedStated extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedStated> CREATOR = new a();
        private final int hour;
        private final int minute;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedStated> {
            @Override // android.os.Parcelable.Creator
            public final SavedStated createFromParcel(Parcel parcel) {
                return new SavedStated(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedStated[] newArray(int i10) {
                return new SavedStated[i10];
            }
        }

        public /* synthetic */ SavedStated(Parcelable parcelable, int i10, int i11, k kVar) {
            this(parcelable, i10, i11);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.hour);
            parcel.writeInt(this.minute);
        }

        public SavedStated(Parcel parcel) {
            super(parcel);
            this.hour = parcel.readInt();
            this.minute = parcel.readInt();
        }

        private SavedStated(Parcelable parcelable, int i10, int i11) {
            super(parcelable);
            this.hour = i10;
            this.minute = i11;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePicker2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6501j = true;
        String[] strArr = new String[24];
        this.f6503l = strArr;
        String[] strArr2 = new String[12];
        this.f6504m = strArr2;
        this.f6505n = new String[60];
        String[] strArr3 = new String[4];
        this.f6506o = strArr3;
        Calendar calendar = Calendar.getInstance();
        this.f6499d = calendar.get(11);
        this.f6500e = calendar.get(12);
        boolean zIs24HourFormat = DateFormat.is24HourFormat(context);
        this.h = zIs24HourFormat;
        if (!zIs24HourFormat) {
            int i10 = this.f6499d;
            this.f6501j = i10 < 12;
            int i11 = i10 % 24;
            int i12 = (i11 < 0 ? i11 + 24 : i11) % 12;
            this.f6499d = i12 == 0 ? 12 : i12;
        }
        FrameLayout.inflate(getContext(), R.layout.stepos_time_picker2_column, this);
        WheelPicker wheelPicker = (WheelPicker) findViewById(R.id.am_pm_picker);
        this.f6496a = wheelPicker;
        WheelPicker wheelPicker2 = (WheelPicker) findViewById(R.id.hour_picker);
        this.f6497b = wheelPicker2;
        this.f6498c = (WheelPicker) findViewById(R.id.minute_picker);
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        wheelPicker.setItemCount(3);
        strArr3[3] = "";
        strArr3[0] = "";
        String str = amPmStrings[0];
        strArr3[1] = str;
        strArr3[2] = amPmStrings[1];
        this.f6502k = str;
        wheelPicker.a(new k(this));
        String str2 = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        int i13 = 0;
        for (int i14 = 24; i13 < i14; i14 = 24) {
            strArr[i13] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i13));
            if (i13 <= 9) {
                StringBuilder sbB = v1.d.b(str2);
                sbB.append(strArr[i13]);
                strArr[i13] = sbB.toString();
            }
            i13++;
        }
        int i15 = 1;
        for (int i16 = 12; i15 <= i16; i16 = 12) {
            int i17 = i15 - 1;
            strArr2[i17] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i15));
            if (i15 < 10) {
                StringBuilder sbB2 = v1.d.b(str2);
                sbB2.append(strArr2[i17]);
                strArr2[i17] = sbB2.toString();
            }
            i15++;
        }
        wheelPicker2.setDrawFlagEnable(true);
        wheelPicker2.setFlagText(getContext().getString(R.string.mc_date_time_hour));
        if (this.h) {
            wheelPicker2.f(this.f6499d, Arrays.asList(strArr), true);
            wheelPicker.setVisibility(8);
        } else {
            wheelPicker2.f(this.f6499d - 1, Arrays.asList(strArr2), true);
            wheelPicker.f(this.f6501j ? 1 : 2, Arrays.asList(this.f6506o), false);
        }
        wheelPicker2.a(new WheelPicker.e() { // from class: com.stepos.common.picker.j
            @Override // com.stepos.common.picker.WheelPicker.e
            public final void a(String str3) {
                TimePicker2 timePicker2 = this.f6553a;
                int i18 = TimePicker2.f6495p;
                try {
                    timePicker2.f6499d = Integer.parseInt(str3);
                } catch (NumberFormatException unused) {
                    a0.a.A("NumberFormat parse hour has an error, text:", str3, "TimePicker2");
                }
            }
        });
        WheelPicker wheelPicker3 = this.f6498c;
        String[] strArr4 = this.f6505n;
        String str3 = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i18 = 0; i18 < 60; i18++) {
            strArr4[i18] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i18));
            if (i18 <= 9) {
                StringBuilder sbB3 = v1.d.b(str3);
                sbB3.append(strArr4[i18]);
                strArr4[i18] = sbB3.toString();
            }
        }
        wheelPicker3.setDrawFlagEnable(true);
        wheelPicker3.setFlagText(getContext().getString(R.string.mc_date_time_min));
        wheelPicker3.f(this.f6500e, Arrays.asList(strArr4), true);
        wheelPicker3.a(new WheelPicker.e() { // from class: com.stepos.common.picker.i
            @Override // com.stepos.common.picker.WheelPicker.e
            public final void a(String str4) {
                TimePicker2 timePicker2 = this.f6552a;
                int i19 = TimePicker2.f6495p;
                try {
                    timePicker2.f6500e = Integer.parseInt(str4);
                } catch (NumberFormatException unused) {
                    a0.a.A("NumberFormat parse minute has an error, text:", str4, "TimePicker2");
                }
            }
        });
    }

    public final void a(int i10, int i11, boolean z) {
        boolean z3;
        boolean z10 = this.h != z;
        int i12 = i10 % 24;
        if (i12 < 0) {
            i12 += 24;
        }
        boolean z11 = getHour() != i12 || z10;
        if (z) {
            this.f6499d = i12;
            this.f6501j = i12 < 12;
        } else {
            this.f6501j = i12 < 12;
            int i13 = i12 % 24;
            if (i13 < 0) {
                i13 += 24;
            }
            int i14 = i13 % 12;
            this.f6499d = i14 != 0 ? i14 : 12;
        }
        if (this.f6500e != i11) {
            this.f6500e = i11;
            z3 = true;
        } else {
            z3 = false;
        }
        WheelPicker wheelPicker = this.f6497b;
        if (z10) {
            List listAsList = Arrays.asList(z ? this.f6503l : this.f6504m);
            int i15 = this.f6499d;
            if (!z) {
                i15--;
            }
            wheelPicker.f(i15, listAsList, true);
        }
        if (z11) {
            int i16 = this.f6499d;
            if (!z) {
                i16--;
            }
            wheelPicker.setCurrentItem(i16);
        }
        if (z3) {
            this.f6498c.setCurrentItem(this.f6500e);
        }
        this.h = z;
        WheelPicker wheelPicker2 = this.f6496a;
        if (z) {
            wheelPicker2.setVisibility(8);
            return;
        }
        wheelPicker2.f(this.f6501j ? 1 : 2, Arrays.asList(this.f6506o), false);
        wheelPicker2.setVisibility(0);
        wheelPicker2.setCurrentItem(this.f6501j ? 1 : 2);
    }

    public WheelPicker getAmPmPicker() {
        return this.f6496a;
    }

    public int getHour() {
        if (this.h) {
            return this.f6499d;
        }
        if (this.f6501j) {
            int i10 = this.f6499d;
            if (i10 == 12) {
                return 0;
            }
            return i10;
        }
        int i11 = this.f6499d;
        if (i11 == 12) {
            return 12;
        }
        return i11 + 12;
    }

    public WheelPicker getHourPicker() {
        return this.f6497b;
    }

    public int getMinute() {
        return this.f6500e;
    }

    public WheelPicker getMinutePicker() {
        return this.f6498c;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedStated savedStated = (SavedStated) parcelable;
        super.onRestoreInstanceState(savedStated.getSuperState());
        a(savedStated.hour, savedStated.minute, this.h);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedStated(super.onSaveInstanceState(), this.f6499d, this.f6500e, null);
    }

    public void set24HourFormat(boolean z) {
        a(getHour(), this.f6500e, z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6496a.setEnabled(z);
        this.f6497b.setEnabled(z);
        this.f6498c.setEnabled(z);
    }

    public void setHour(int i10) {
        if (i10 == getHour()) {
            return;
        }
        a(i10, this.f6500e, this.h);
    }

    public void setMinute(int i10) {
        if (i10 == getMinute()) {
            return;
        }
        a(getHour(), i10, this.h);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        WheelPicker wheelPicker = this.f6496a;
        if (wheelPicker != null) {
            wheelPicker.setVisibility(i10);
        }
        WheelPicker wheelPicker2 = this.f6497b;
        if (wheelPicker2 != null) {
            wheelPicker2.setVisibility(i10);
        }
        WheelPicker wheelPicker3 = this.f6498c;
        if (wheelPicker3 != null) {
            wheelPicker3.setVisibility(i10);
        }
    }

    @Deprecated
    public void setOnTimeChangedListener(a aVar) {
    }
}
