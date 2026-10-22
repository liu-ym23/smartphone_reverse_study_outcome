package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.material3.DatePickerDefaults;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* loaded from: classes3.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new C(0);
    final int daysInMonth;
    final int daysInWeek;

    @NonNull
    private final Calendar firstOfMonth;

    @Nullable
    private String longName;
    final int month;
    final long timeInMillis;
    final int year;

    private Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = O.c(calendar);
        this.firstOfMonth = calendarC;
        this.month = calendarC.get(2);
        this.year = calendarC.get(1);
        this.daysInWeek = calendarC.getMaximum(7);
        this.daysInMonth = calendarC.getActualMaximum(5);
        this.timeInMillis = calendarC.getTimeInMillis();
    }

    @NonNull
    public static Month create(int i, int i6) {
        Calendar calendarG = O.g(null);
        calendarG.set(1, i);
        calendarG.set(2, i6);
        return new Month(calendarG);
    }

    @NonNull
    public static Month current() {
        return new Month(O.f());
    }

    public int daysFromStartOfWeekToFirstOfMonth(int i) {
        int i6 = this.firstOfMonth.get(7);
        if (i <= 0) {
            i = this.firstOfMonth.getFirstDayOfWeek();
        }
        int i10 = i6 - i;
        return i10 < 0 ? i10 + this.daysInWeek : i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.month == month.month && this.year == month.year;
    }

    public long getDay(int i) {
        Calendar calendarC = O.c(this.firstOfMonth);
        calendarC.set(5, i);
        return calendarC.getTimeInMillis();
    }

    public int getDayOfMonth(long j5) {
        Calendar calendarC = O.c(this.firstOfMonth);
        calendarC.setTimeInMillis(j5);
        return calendarC.get(5);
    }

    @NonNull
    public String getLongName() {
        if (this.longName == null) {
            this.longName = O.b(DatePickerDefaults.YearMonthSkeleton, Locale.getDefault()).format(new Date(this.firstOfMonth.getTimeInMillis()));
        }
        return this.longName;
    }

    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @NonNull
    public Month monthsLater(int i) {
        Calendar calendarC = O.c(this.firstOfMonth);
        calendarC.add(2, i);
        return new Month(calendarC);
    }

    public int monthsUntil(@NonNull Month month) {
        if (!(this.firstOfMonth instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.month - this.month) + ((month.year - this.year) * 12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    @NonNull
    public static Month create(long j5) {
        Calendar calendarG = O.g(null);
        calendarG.setTimeInMillis(j5);
        return new Month(calendarG);
    }
}
