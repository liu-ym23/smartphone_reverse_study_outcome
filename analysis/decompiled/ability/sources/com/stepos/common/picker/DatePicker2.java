package com.stepos.common.picker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.ability.R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DatePicker2 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final WheelPicker f3572a;
    public final WheelPicker b;
    public final WheelPicker c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public String[] i;

    /* renamed from: j, reason: collision with root package name */
    public final String[] f3573j;
    public String[] k;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new d();
        private final int day;
        private final int month;
        private final int year;

        public /* synthetic */ SavedState(Parcelable parcelable, int i, int i6, int i10, a aVar) {
            this(parcelable, i, i6, i10);
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
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.year);
            parcel.writeInt(this.month);
            parcel.writeInt(this.day);
        }

        private SavedState(Parcelable parcelable, int i, int i6, int i10) {
            super(parcelable);
            this.year = i;
            this.month = i6;
            this.day = i10;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.year = parcel.readInt();
            this.month = parcel.readInt();
            this.day = parcel.readInt();
        }
    }

    public DatePicker2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3573j = new String[12];
        View.inflate(context, R.layout.stepos_date_picker2_column, this);
        WheelPicker wheelPicker = (WheelPicker) findViewById(R.id.year_picker);
        this.f3572a = wheelPicker;
        WheelPicker wheelPicker2 = (WheelPicker) findViewById(R.id.month_picker);
        this.b = wheelPicker2;
        this.c = (WheelPicker) findViewById(R.id.day_picker);
        this.i = new String[200];
        for (int i = 1900; i <= 2099; i++) {
            this.i[i - 1900] = String.valueOf(i);
        }
        wheelPicker.setItemCount(5);
        wheelPicker.setDrawFlagEnable(true);
        wheelPicker.setFlagText(getContext().getString(R.string.mc_date_time_year));
        e(1900, 2099, Calendar.getInstance().get(1));
        wheelPicker.a(new a(this));
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i6 = 1; i6 <= 12; i6++) {
            this.f3573j[i6 - 1] = String.valueOf(i6 < 10 ? str + i6 : Integer.valueOf(i6));
        }
        wheelPicker2.setDrawFlagEnable(true);
        wheelPicker2.setFlagText(getContext().getString(R.string.mc_date_time_month));
        int i10 = Calendar.getInstance().get(2);
        this.e = i10 + 1;
        this.b.e(Arrays.asList(this.f3573j), i10, true);
        wheelPicker2.a(new b(this, 0));
        WheelPicker wheelPicker3 = this.c;
        wheelPicker3.setDrawFlagEnable(true);
        wheelPicker3.setFlagText(getContext().getString(R.string.mc_date_time_day));
        d(this.d, this.e - 1, -1);
        wheelPicker3.a(new b(this, 1));
    }

    public static int a(DatePicker2 datePicker2, String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            androidx.constraintlayout.core.dsl.a.w("parseInt has an error, text:", str, "DatePicker2");
            return i;
        }
    }

    public static void b(DatePicker2 datePicker2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, datePicker2.d);
        calendar.set(2, datePicker2.e - 1);
        datePicker2.c(calendar);
        int actualMaximum = calendar.getActualMaximum(5);
        if (datePicker2.f > actualMaximum) {
            datePicker2.f = actualMaximum;
        }
        datePicker2.c.e(Arrays.asList(datePicker2.k), datePicker2.f - 1, true);
    }

    public final void c(Calendar calendar) {
        int actualMaximum = calendar.getActualMaximum(5);
        this.k = new String[actualMaximum];
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i = 1; i <= actualMaximum; i++) {
            this.k[i - 1] = String.valueOf(i < 10 ? str + i : Integer.valueOf(i));
        }
    }

    public final void d(int i, int i6, int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i6);
        if (i10 == -1) {
            this.f = calendar.get(5);
        } else {
            this.f = i10;
        }
        c(calendar);
        this.c.e(Arrays.asList(this.k), this.f - 1, true);
    }

    public final void e(int i, int i6, int i10) {
        if (i == this.g && i6 == this.h && i10 == this.d) {
            return;
        }
        if (i <= i6) {
            this.i = new String[(i6 - i) + 1];
            for (int i11 = i; i11 <= i6; i11++) {
                this.i[i11 - i] = String.valueOf(i11);
            }
        }
        this.g = i;
        this.h = i6;
        this.d = i10;
        WheelPicker wheelPicker = this.f3572a;
        if (i10 < i || i10 > i6) {
            wheelPicker.e(Arrays.asList(this.i), 0, true);
        } else {
            wheelPicker.e(Arrays.asList(this.i), this.d - this.g, true);
        }
    }

    public Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.d);
        calendar.set(2, this.e - 1);
        calendar.set(5, this.f);
        return calendar.getTime();
    }

    public int getDay() {
        return this.f;
    }

    public WheelPicker getDayPicker() {
        return this.c;
    }

    public int getMonth() {
        return this.e;
    }

    public WheelPicker getMonthPicker() {
        return this.b;
    }

    public int getYear() {
        return this.d;
    }

    public WheelPicker getYearPicker() {
        return this.f3572a;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(parcelable);
        this.d = savedState.getYear();
        this.e = savedState.getMonth();
        this.f = savedState.getDay();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.d, this.e, this.f, null);
    }

    public void setDate(@NonNull Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(1);
        int i6 = calendar.get(2);
        int i10 = calendar.get(5);
        e(this.g, this.h, i);
        this.e = i6 + 1;
        this.b.e(Arrays.asList(this.f3573j), i6, true);
        d(i, i6, i10);
    }

    public void setOnDateChangedListener(c cVar) {
    }
}
