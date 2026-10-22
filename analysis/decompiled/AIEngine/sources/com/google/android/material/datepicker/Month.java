package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();
    final int daysInMonth;
    final int daysInWeek;
    private final Calendar firstOfMonth;
    private String longName;
    final int month;
    final long timeInMillis;
    final int year;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        public final Month createFromParcel(Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Month[] newArray(int i10) {
            return new Month[i10];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = s.c(calendar);
        this.firstOfMonth = calendarC;
        this.month = calendarC.get(2);
        this.year = calendarC.get(1);
        this.daysInWeek = calendarC.getMaximum(7);
        this.daysInMonth = calendarC.getActualMaximum(5);
        this.timeInMillis = calendarC.getTimeInMillis();
    }

    public static Month create(int i10, int i11) {
        Calendar calendarG = s.g(null);
        calendarG.set(1, i10);
        calendarG.set(2, i11);
        return new Month(calendarG);
    }

    public static Month current() {
        return new Month(s.f());
    }

    public int daysFromStartOfWeekToFirstOfMonth(int i10) {
        int i11 = this.firstOfMonth.get(7);
        if (i10 <= 0) {
            i10 = this.firstOfMonth.getFirstDayOfWeek();
        }
        int i12 = i11 - i10;
        return i12 < 0 ? i12 + this.daysInWeek : i12;
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

    public long getDay(int i10) {
        Calendar calendarC = s.c(this.firstOfMonth);
        calendarC.set(5, i10);
        return calendarC.getTimeInMillis();
    }

    public int getDayOfMonth(long j10) {
        Calendar calendarC = s.c(this.firstOfMonth);
        calendarC.setTimeInMillis(j10);
        return calendarC.get(5);
    }

    public String getLongName() {
        if (this.longName == null) {
            this.longName = s.b("yMMMM", Locale.getDefault()).format(new Date(this.firstOfMonth.getTimeInMillis()));
        }
        return this.longName;
    }

    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    public Month monthsLater(int i10) {
        Calendar calendarC = s.c(this.firstOfMonth);
        calendarC.add(2, i10);
        return new Month(calendarC);
    }

    public int monthsUntil(Month month) {
        if (!(this.firstOfMonth instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.month - this.month) + ((month.year - this.year) * 12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }

    @Override // java.lang.Comparable
    public int compareTo(Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    public static Month create(long j10) {
        Calendar calendarG = s.g(null);
        calendarG.setTimeInMillis(j10);
        return new Month(calendarG);
    }
}
