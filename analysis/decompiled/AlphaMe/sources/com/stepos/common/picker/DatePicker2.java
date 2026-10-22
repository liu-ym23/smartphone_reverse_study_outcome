package com.stepos.common.picker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class DatePicker2 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final WheelPicker f11312a;

    /* renamed from: b, reason: collision with root package name */
    public final WheelPicker f11313b;

    /* renamed from: c, reason: collision with root package name */
    public final WheelPicker f11314c;

    /* renamed from: d, reason: collision with root package name */
    public int f11315d;

    /* renamed from: e, reason: collision with root package name */
    public int f11316e;

    /* renamed from: f, reason: collision with root package name */
    public int f11317f;

    /* renamed from: g, reason: collision with root package name */
    public int f11318g;

    /* renamed from: h, reason: collision with root package name */
    public int f11319h;

    /* renamed from: i, reason: collision with root package name */
    public String[] f11320i;

    /* renamed from: j, reason: collision with root package name */
    public final String[] f11321j;

    /* renamed from: k, reason: collision with root package name */
    public String[] f11322k;

    public @interface DateType {
    }

    public DatePicker2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11321j = new String[12];
        View.inflate(context, R.layout.stepos_date_picker2_column, this);
        WheelPicker wheelPicker = (WheelPicker) findViewById(R.id.year_picker);
        this.f11312a = wheelPicker;
        this.f11313b = (WheelPicker) findViewById(R.id.month_picker);
        this.f11314c = (WheelPicker) findViewById(R.id.day_picker);
        d(1900, 2099);
        wheelPicker.setItemCount(5);
        wheelPicker.setDrawFlagEnable(true);
        wheelPicker.setFlagText(getContext().getString(R.string.mc_date_time_year));
        f(1900, 2099, Calendar.getInstance().get(1));
        wheelPicker.a(new a(this, 0));
        String str = String.format(Locale.getDefault(), "%d", 0);
        for (int i4 = 1; i4 <= 12; i4++) {
            this.f11321j[i4 - 1] = String.valueOf(i4 < 10 ? str + i4 : Integer.valueOf(i4));
        }
        WheelPicker wheelPicker2 = this.f11313b;
        wheelPicker2.setDrawFlagEnable(true);
        wheelPicker2.setFlagText(getContext().getString(R.string.mc_date_time_month));
        int i5 = Calendar.getInstance().get(2);
        this.f11316e = i5 + 1;
        this.f11313b.e(i5, Arrays.asList(this.f11321j), true);
        wheelPicker2.a(new a(this, 1));
        WheelPicker wheelPicker3 = this.f11314c;
        wheelPicker3.setDrawFlagEnable(true);
        wheelPicker3.setFlagText(getContext().getString(R.string.mc_date_time_day));
        e(this.f11315d, this.f11316e - 1, -1);
        wheelPicker3.a(new a(this, 2));
    }

    public static int a(DatePicker2 datePicker2, String str, int i4) {
        datePicker2.getClass();
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Log.w("DatePicker2", "parseInt has an error, text:" + str);
            return i4;
        }
    }

    public static void b(DatePicker2 datePicker2) {
        datePicker2.getClass();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, datePicker2.f11315d);
        calendar.set(2, datePicker2.f11316e - 1);
        datePicker2.c(calendar);
        int actualMaximum = calendar.getActualMaximum(5);
        if (datePicker2.f11317f > actualMaximum) {
            datePicker2.f11317f = actualMaximum;
        }
        List listAsList = Arrays.asList(datePicker2.f11322k);
        datePicker2.f11314c.e(datePicker2.f11317f - 1, listAsList, true);
    }

    public final void c(Calendar calendar) {
        int actualMaximum = calendar.getActualMaximum(5);
        this.f11322k = new String[actualMaximum];
        String str = String.format(Locale.getDefault(), "%d", 0);
        for (int i4 = 1; i4 <= actualMaximum; i4++) {
            this.f11322k[i4 - 1] = String.valueOf(i4 < 10 ? str + i4 : Integer.valueOf(i4));
        }
    }

    public final void d(int i4, int i5) {
        if (i4 > i5) {
            return;
        }
        this.f11320i = new String[(i5 - i4) + 1];
        for (int i6 = i4; i6 <= i5; i6++) {
            this.f11320i[i6 - i4] = String.valueOf(i6);
        }
    }

    public final void e(int i4, int i5, int i6) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i4);
        calendar.set(2, i5);
        if (i6 == -1) {
            this.f11317f = calendar.get(5);
        } else {
            this.f11317f = i6;
        }
        c(calendar);
        List listAsList = Arrays.asList(this.f11322k);
        this.f11314c.e(this.f11317f - 1, listAsList, true);
    }

    public final void f(int i4, int i5, int i6) {
        if (i4 == this.f11318g && i5 == this.f11319h && i6 == this.f11315d) {
            return;
        }
        d(i4, i5);
        this.f11318g = i4;
        this.f11319h = i5;
        this.f11315d = i6;
        WheelPicker wheelPicker = this.f11312a;
        if (i6 < i4 || i6 > i5) {
            wheelPicker.e(0, Arrays.asList(this.f11320i), true);
        } else {
            wheelPicker.e(this.f11315d - this.f11318g, Arrays.asList(this.f11320i), true);
        }
    }

    public Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.f11315d);
        calendar.set(2, this.f11316e - 1);
        calendar.set(5, this.f11317f);
        return calendar.getTime();
    }

    public int getDay() {
        return this.f11317f;
    }

    public WheelPicker getDayPicker() {
        return this.f11314c;
    }

    public int getMonth() {
        return this.f11316e;
    }

    public WheelPicker getMonthPicker() {
        return this.f11313b;
    }

    public int getYear() {
        return this.f11315d;
    }

    public WheelPicker getYearPicker() {
        return this.f11312a;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(parcelable);
        this.f11315d = savedState.f11323a;
        this.f11316e = savedState.f11324b;
        this.f11317f = savedState.f11325c;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f11315d, this.f11316e, this.f11317f);
    }

    public void setDate(@NonNull Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i4 = calendar.get(1);
        int i5 = calendar.get(2);
        int i6 = calendar.get(5);
        f(this.f11318g, this.f11319h, i4);
        this.f11316e = i5 + 1;
        this.f11313b.e(i5, Arrays.asList(this.f11321j), true);
        e(i4, i5, i6);
    }

    public void setOnDateChangedListener(b bVar) {
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new c();

        /* renamed from: a, reason: collision with root package name */
        public final int f11323a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11324b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11325c;

        public SavedState(Parcelable parcelable, int i4, int i5, int i6) {
            super(parcelable);
            this.f11323a = i4;
            this.f11324b = i5;
            this.f11325c = i6;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f11323a);
            parcel.writeInt(this.f11324b);
            parcel.writeInt(this.f11325c);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f11323a = parcel.readInt();
            this.f11324b = parcel.readInt();
            this.f11325c = parcel.readInt();
        }
    }
}
