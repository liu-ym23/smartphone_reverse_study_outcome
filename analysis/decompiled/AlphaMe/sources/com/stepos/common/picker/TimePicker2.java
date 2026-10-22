package com.stepos.common.picker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class TimePicker2 extends FrameLayout {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f11326n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final WheelPicker f11327a;

    /* renamed from: b, reason: collision with root package name */
    public final WheelPicker f11328b;

    /* renamed from: c, reason: collision with root package name */
    public final WheelPicker f11329c;

    /* renamed from: d, reason: collision with root package name */
    public int f11330d;

    /* renamed from: e, reason: collision with root package name */
    public int f11331e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11332f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11333g;

    /* renamed from: h, reason: collision with root package name */
    public final String f11334h;

    /* renamed from: i, reason: collision with root package name */
    public final String[] f11335i;

    /* renamed from: j, reason: collision with root package name */
    public final String[] f11336j;

    /* renamed from: k, reason: collision with root package name */
    public final String[] f11337k;

    /* renamed from: l, reason: collision with root package name */
    public final String[] f11338l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f11339m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePicker2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        String[] strArr;
        String[] strArr2;
        int i4;
        super(context, attributeSet, 0);
        final int i5 = 0;
        final int i6 = 1;
        this.f11333g = true;
        this.f11335i = new String[24];
        this.f11336j = new String[12];
        this.f11337k = new String[60];
        String[] strArr3 = new String[4];
        this.f11338l = strArr3;
        Calendar calendar = Calendar.getInstance();
        this.f11330d = calendar.get(11);
        this.f11331e = calendar.get(12);
        boolean zIs24HourFormat = DateFormat.is24HourFormat(context);
        this.f11332f = zIs24HourFormat;
        if (!zIs24HourFormat && (i4 = this.f11330d) >= 12) {
            this.f11330d = i4 - 12;
            this.f11333g = false;
        }
        View.inflate(getContext(), R.layout.stepos_time_picker2_column, this);
        WheelPicker wheelPicker = (WheelPicker) findViewById(R.id.am_pm_picker);
        this.f11327a = wheelPicker;
        this.f11328b = (WheelPicker) findViewById(R.id.hour_picker);
        this.f11329c = (WheelPicker) findViewById(R.id.minute_picker);
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        wheelPicker.setItemCount(3);
        strArr3[3] = "";
        strArr3[0] = "";
        String str = amPmStrings[0];
        strArr3[1] = str;
        strArr3[2] = amPmStrings[1];
        this.f11334h = str;
        wheelPicker.a(new a(this, 3));
        String str2 = String.format(Locale.getDefault(), "%d", 0);
        int i7 = 0;
        while (true) {
            strArr = this.f11335i;
            if (i7 >= 24) {
                break;
            }
            strArr[i7] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i7));
            if (i7 <= 9) {
                StringBuilder sbS = B0.g.s(str2);
                sbS.append(strArr[i7]);
                strArr[i7] = sbS.toString();
            }
            i7++;
        }
        int i8 = 1;
        while (true) {
            strArr2 = this.f11336j;
            if (i8 > 12) {
                break;
            }
            int i9 = i8 - 1;
            strArr2[i9] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i8));
            if (i8 < 10) {
                StringBuilder sbS2 = B0.g.s(str2);
                sbS2.append(strArr2[i9]);
                strArr2[i9] = sbS2.toString();
            }
            i8++;
        }
        WheelPicker wheelPicker2 = this.f11328b;
        wheelPicker2.setDrawFlagEnable(true);
        wheelPicker2.setFlagText(getContext().getString(R.string.mc_date_time_hour));
        boolean z4 = this.f11332f;
        WheelPicker wheelPicker3 = this.f11327a;
        if (z4) {
            wheelPicker2.e(this.f11330d, Arrays.asList(strArr), true);
            wheelPicker3.setVisibility(8);
        } else {
            wheelPicker2.e(this.f11330d - 1, Arrays.asList(strArr2), true);
            wheelPicker3.e(0, Arrays.asList(this.f11338l), false);
        }
        wheelPicker2.a(new s(this) { // from class: com.stepos.common.picker.l

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TimePicker2 f11389b;

            {
                this.f11389b = this;
            }

            @Override // com.stepos.common.picker.s
            public final void a(String str3) {
                int i10 = i6;
                TimePicker2 timePicker2 = this.f11389b;
                switch (i10) {
                    case 0:
                        int i11 = TimePicker2.f11326n;
                        timePicker2.getClass();
                        try {
                            timePicker2.f11331e = Integer.parseInt(str3);
                        } catch (NumberFormatException unused) {
                            Log.w("TimePicker2", "NumberFormat parse minute has an error, text:" + str3);
                        }
                        timePicker2.a(timePicker2, timePicker2.f11330d, timePicker2.f11331e);
                        break;
                    default:
                        int i12 = TimePicker2.f11326n;
                        timePicker2.getClass();
                        try {
                            timePicker2.f11330d = Integer.parseInt(str3);
                        } catch (NumberFormatException unused2) {
                            Log.w("TimePicker2", "NumberFormat parse hour has an error, text:" + str3);
                        }
                        timePicker2.a(timePicker2, timePicker2.f11330d, timePicker2.f11331e);
                        break;
                }
            }
        });
        String str3 = String.format(Locale.getDefault(), "%d", 0);
        int i10 = 0;
        while (true) {
            String[] strArr4 = this.f11337k;
            if (i10 >= 60) {
                WheelPicker wheelPicker4 = this.f11329c;
                wheelPicker4.setDrawFlagEnable(true);
                wheelPicker4.setFlagText(getContext().getString(R.string.mc_date_time_min));
                wheelPicker4.e(this.f11331e, Arrays.asList(strArr4), true);
                wheelPicker4.a(new s(this) { // from class: com.stepos.common.picker.l

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ TimePicker2 f11389b;

                    {
                        this.f11389b = this;
                    }

                    @Override // com.stepos.common.picker.s
                    public final void a(String str32) {
                        int i102 = i5;
                        TimePicker2 timePicker2 = this.f11389b;
                        switch (i102) {
                            case 0:
                                int i11 = TimePicker2.f11326n;
                                timePicker2.getClass();
                                try {
                                    timePicker2.f11331e = Integer.parseInt(str32);
                                } catch (NumberFormatException unused) {
                                    Log.w("TimePicker2", "NumberFormat parse minute has an error, text:" + str32);
                                }
                                timePicker2.a(timePicker2, timePicker2.f11330d, timePicker2.f11331e);
                                break;
                            default:
                                int i12 = TimePicker2.f11326n;
                                timePicker2.getClass();
                                try {
                                    timePicker2.f11330d = Integer.parseInt(str32);
                                } catch (NumberFormatException unused2) {
                                    Log.w("TimePicker2", "NumberFormat parse hour has an error, text:" + str32);
                                }
                                timePicker2.a(timePicker2, timePicker2.f11330d, timePicker2.f11331e);
                                break;
                        }
                    }
                });
                return;
            }
            strArr4[i10] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i10));
            if (i10 <= 9) {
                StringBuilder sbS3 = B0.g.s(str3);
                sbS3.append(strArr4[i10]);
                strArr4[i10] = sbS3.toString();
            }
            i10++;
        }
    }

    public final void a(TimePicker2 timePicker2, int i4, int i5) {
        ArrayList arrayList = this.f11339m;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((m) it.next()).onTimeChanged(timePicker2, this.f11333g, i4, i5);
            }
        }
    }

    public final void b(int i4, int i5, boolean z4) {
        boolean z5;
        boolean z6;
        int i6;
        boolean z7 = this.f11332f != z4;
        if (this.f11330d != i4) {
            this.f11330d = i4;
            z5 = true;
        } else {
            z5 = false;
        }
        this.f11333g = true;
        if (!z4 && (i6 = this.f11330d) > 12) {
            this.f11330d = i6 - 12;
            this.f11333g = false;
            z5 = true;
        }
        if (this.f11331e != i5) {
            this.f11331e = i5;
            z6 = true;
        } else {
            z6 = false;
        }
        WheelPicker wheelPicker = this.f11328b;
        if (z7) {
            List listAsList = Arrays.asList(z4 ? this.f11335i : this.f11336j);
            int i7 = this.f11330d;
            if (!z4) {
                i7--;
            }
            wheelPicker.e(i7, listAsList, true);
        }
        if (z5) {
            int i8 = this.f11330d;
            if (!z4) {
                i8--;
            }
            wheelPicker.setCurrentItem(i8);
        }
        if (z6) {
            this.f11329c.setCurrentItem(this.f11331e);
        }
        this.f11332f = z4;
        WheelPicker wheelPicker2 = this.f11327a;
        if (z4) {
            wheelPicker2.setVisibility(8);
            return;
        }
        wheelPicker2.e(0, Arrays.asList(this.f11338l), false);
        wheelPicker2.setVisibility(0);
        wheelPicker2.setCurrentItem(this.f11333g ? 1 : 2);
    }

    public WheelPicker getAmPmPicker() {
        return this.f11327a;
    }

    public int getHour() {
        if (!this.f11332f && !this.f11333g) {
            return this.f11330d + 12;
        }
        return this.f11330d;
    }

    public WheelPicker getHourPicker() {
        return this.f11328b;
    }

    public int getMinute() {
        return this.f11331e;
    }

    public WheelPicker getMinutePicker() {
        return this.f11329c;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedStated savedStated = (SavedStated) parcelable;
        super.onRestoreInstanceState(savedStated.getSuperState());
        b(savedStated.f11340a, savedStated.f11341b, this.f11332f);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedStated(super.onSaveInstanceState(), this.f11330d, this.f11331e);
    }

    public void set24HourFormat(boolean z4) {
        b(this.f11330d, this.f11331e, z4);
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        this.f11327a.setEnabled(z4);
        this.f11328b.setEnabled(z4);
        this.f11329c.setEnabled(z4);
    }

    public void setHour(int i4) {
        if (i4 == getHour()) {
            return;
        }
        b(i4, this.f11331e, this.f11332f);
    }

    public void setMinute(int i4) {
        if (i4 == getMinute()) {
            return;
        }
        b(this.f11330d, i4, this.f11332f);
    }

    @Deprecated
    public void setOnTimeChangedListener(n nVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        WheelPicker wheelPicker = this.f11327a;
        if (wheelPicker != null) {
            wheelPicker.setVisibility(i4);
        }
        WheelPicker wheelPicker2 = this.f11328b;
        if (wheelPicker2 != null) {
            wheelPicker2.setVisibility(i4);
        }
        WheelPicker wheelPicker3 = this.f11329c;
        if (wheelPicker3 != null) {
            wheelPicker3.setVisibility(i4);
        }
    }

    public static class SavedStated extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedStated> CREATOR = new o();

        /* renamed from: a, reason: collision with root package name */
        public final int f11340a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11341b;

        public SavedStated(Parcel parcel) {
            super(parcel);
            this.f11340a = parcel.readInt();
            this.f11341b = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f11340a);
            parcel.writeInt(this.f11341b);
        }

        public SavedStated(Parcelable parcelable, int i4, int i5) {
            super(parcelable);
            this.f11340a = i4;
            this.f11341b = i5;
        }
    }
}
