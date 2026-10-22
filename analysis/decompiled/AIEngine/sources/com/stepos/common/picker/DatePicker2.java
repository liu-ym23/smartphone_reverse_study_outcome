package com.stepos.common.picker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.aiengine.R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DatePicker2 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final WheelPicker f6485a;

    /* renamed from: b, reason: collision with root package name */
    public final WheelPicker f6486b;

    /* renamed from: c, reason: collision with root package name */
    public final WheelPicker f6487c;

    /* renamed from: d, reason: collision with root package name */
    public int f6488d;

    /* renamed from: e, reason: collision with root package name */
    public int f6489e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f6490j;

    /* renamed from: k, reason: collision with root package name */
    public int f6491k;

    /* renamed from: l, reason: collision with root package name */
    public String[] f6492l;

    /* renamed from: m, reason: collision with root package name */
    public final String[] f6493m;

    /* renamed from: n, reason: collision with root package name */
    public String[] f6494n;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private final int day;
        private final int month;
        private final int year;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcelable parcelable, int i10, int i11, int i12, com.stepos.common.picker.a aVar) {
            this(parcelable, i10, i11, i12);
        }

        public int getDay() {
            return this.day;
        }

        public int getMonth() {
            return this.month;
        }

        public int getYear() {
            return this.year;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.year);
            parcel.writeInt(this.month);
            parcel.writeInt(this.day);
        }

        private SavedState(Parcelable parcelable, int i10, int i11, int i12) {
            super(parcelable);
            this.year = i10;
            this.month = i11;
            this.day = i12;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.year = parcel.readInt();
            this.month = parcel.readInt();
            this.day = parcel.readInt();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
    }

    public DatePicker2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6493m = new String[12];
        FrameLayout.inflate(context, R.layout.stepos_date_picker2_column, this);
        WheelPicker wheelPicker = (WheelPicker) findViewById(R.id.year_picker);
        this.f6485a = wheelPicker;
        WheelPicker wheelPicker2 = (WheelPicker) findViewById(R.id.month_picker);
        this.f6486b = wheelPicker2;
        this.f6487c = (WheelPicker) findViewById(R.id.day_picker);
        this.f6492l = new String[200];
        for (int i10 = 1900; i10 <= 2099; i10++) {
            this.f6492l[i10 - 1900] = String.valueOf(i10);
        }
        wheelPicker.setItemCount(5);
        wheelPicker.setDrawFlagEnable(true);
        wheelPicker.setFlagText(getContext().getString(R.string.mc_date_time_year));
        e(1900, 2099, Calendar.getInstance().get(1));
        wheelPicker.a(new com.stepos.common.picker.a(this));
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i11 = 1; i11 <= 12; i11++) {
            this.f6493m[i11 - 1] = String.valueOf(i11 < 10 ? str + i11 : Integer.valueOf(i11));
        }
        wheelPicker2.setDrawFlagEnable(true);
        wheelPicker2.setFlagText(getContext().getString(R.string.mc_date_time_month));
        int i12 = Calendar.getInstance().get(2);
        this.f6489e = i12 + 1;
        this.f6486b.f(i12, Arrays.asList(this.f6493m), true);
        wheelPicker2.a(new b(this));
        WheelPicker wheelPicker3 = this.f6487c;
        wheelPicker3.setDrawFlagEnable(true);
        wheelPicker3.setFlagText(getContext().getString(R.string.mc_date_time_day));
        d(this.f6488d, this.f6489e - 1, -1);
        wheelPicker3.a(new c(this));
    }

    public static int a(DatePicker2 datePicker2, String str, int i10) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            a0.a.A("parseInt has an error, text:", str, "DatePicker2");
            return i10;
        }
    }

    public static void b(DatePicker2 datePicker2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, datePicker2.f6488d);
        calendar.set(2, datePicker2.f6489e - 1);
        datePicker2.c(calendar);
        int actualMaximum = calendar.getActualMaximum(5);
        if (datePicker2.h > actualMaximum) {
            datePicker2.h = actualMaximum;
        }
        datePicker2.f6487c.f(datePicker2.h - 1, Arrays.asList(datePicker2.f6494n), true);
    }

    public final void c(Calendar calendar) {
        int actualMaximum = calendar.getActualMaximum(5);
        this.f6494n = new String[actualMaximum];
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i10 = 1; i10 <= actualMaximum; i10++) {
            this.f6494n[i10 - 1] = String.valueOf(i10 < 10 ? str + i10 : Integer.valueOf(i10));
        }
    }

    public final void d(int i10, int i11, int i12) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        if (i12 == -1) {
            this.h = calendar.get(5);
        } else {
            this.h = i12;
        }
        c(calendar);
        List listAsList = Arrays.asList(this.f6494n);
        this.f6487c.f(this.h - 1, listAsList, true);
    }

    public final void e(int i10, int i11, int i12) {
        if (i10 == this.f6490j && i11 == this.f6491k && i12 == this.f6488d) {
            return;
        }
        if (i10 <= i11) {
            this.f6492l = new String[(i11 - i10) + 1];
            for (int i13 = i10; i13 <= i11; i13++) {
                this.f6492l[i13 - i10] = String.valueOf(i13);
            }
        }
        this.f6490j = i10;
        this.f6491k = i11;
        this.f6488d = i12;
        WheelPicker wheelPicker = this.f6485a;
        if (i12 < i10 || i12 > i11) {
            wheelPicker.f(0, Arrays.asList(this.f6492l), true);
        } else {
            wheelPicker.f(this.f6488d - this.f6490j, Arrays.asList(this.f6492l), true);
        }
    }

    public Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.f6488d);
        calendar.set(2, this.f6489e - 1);
        calendar.set(5, this.h);
        return calendar.getTime();
    }

    public int getDay() {
        return this.h;
    }

    public WheelPicker getDayPicker() {
        return this.f6487c;
    }

    public int getMonth() {
        return this.f6489e;
    }

    public WheelPicker getMonthPicker() {
        return this.f6486b;
    }

    public int getYear() {
        return this.f6488d;
    }

    public WheelPicker getYearPicker() {
        return this.f6485a;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(parcelable);
        this.f6488d = savedState.getYear();
        this.f6489e = savedState.getMonth();
        this.h = savedState.getDay();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f6488d, this.f6489e, this.h, null);
    }

    public void setDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i10 = calendar.get(1);
        int i11 = calendar.get(2);
        int i12 = calendar.get(5);
        e(this.f6490j, this.f6491k, i10);
        this.f6489e = i11 + 1;
        this.f6486b.f(i11, Arrays.asList(this.f6493m), true);
        d(i10, i11, i12);
    }

    public void setOnDateChangedListener(a aVar) {
    }
}
