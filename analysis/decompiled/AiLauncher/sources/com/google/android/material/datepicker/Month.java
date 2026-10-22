package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes2.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();
    final int daysInMonth;
    final int daysInWeek;
    private final Calendar firstOfMonth;
    private String longName;
    final int month;
    final long timeInMillis;
    final int year;

    public class a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i10) {
            return new Month[i10];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarE = v.e(calendar);
        this.firstOfMonth = calendarE;
        this.month = calendarE.get(2);
        this.year = calendarE.get(1);
        this.daysInWeek = calendarE.getMaximum(7);
        this.daysInMonth = calendarE.getActualMaximum(5);
        this.timeInMillis = calendarE.getTimeInMillis();
    }

    public static Month create(long j10) {
        Calendar calendarN = v.n();
        calendarN.setTimeInMillis(j10);
        return new Month(calendarN);
    }

    public static Month current() {
        return new Month(v.l());
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
        Calendar calendarE = v.e(this.firstOfMonth);
        calendarE.set(5, i10);
        return calendarE.getTimeInMillis();
    }

    public int getDayOfMonth(long j10) {
        Calendar calendarE = v.e(this.firstOfMonth);
        calendarE.setTimeInMillis(j10);
        return calendarE.get(5);
    }

    public String getLongName() {
        if (this.longName == null) {
            this.longName = h.l(this.firstOfMonth.getTimeInMillis());
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
        Calendar calendarE = v.e(this.firstOfMonth);
        calendarE.add(2, i10);
        return new Month(calendarE);
    }

    public int monthsUntil(Month month) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month.year - this.year) * 12) + (month.month - this.month);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
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

    public static Month create(int i10, int i11) {
        Calendar calendarN = v.n();
        calendarN.set(1, i10);
        calendarN.set(2, i11);
        return new Month(calendarN);
    }
}
