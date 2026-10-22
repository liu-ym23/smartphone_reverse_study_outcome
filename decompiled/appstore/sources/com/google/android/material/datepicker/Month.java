package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes3.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = null;
    final int daysInMonth;
    final int daysInWeek;

    @NonNull
    private final Calendar firstOfMonth;

    @Nullable
    private String longName;
    final int month;
    final long timeInMillis;
    final int year;

    static {
        CREATOR = new AnonymousClass1();
    }

    private Month(@NonNull Calendar r10) {
        r10.set(5, 1);
        Calendar r11 = UtcDates.getDayCopy(r10);
        this.firstOfMonth = r11;
        this.month = r11.get(2);
        this.year = r11.get(1);
        this.daysInWeek = r11.getMaximum(7);
        this.daysInMonth = r11.getActualMaximum(5);
        this.timeInMillis = r11.getTimeInMillis();
    }

    @NonNull
    public static Month create(long r10) {
        Calendar r11 = UtcDates.getUtcCalendar();
        r11.setTimeInMillis(r10);
        return new Month(r11);
    }

    @NonNull
    public static Month current() {
        return new Month(UtcDates.getTodayCalendar());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull Month r10) {
        return compareTo2(r10);
    }

    public int daysFromStartOfWeekToFirstOfMonth() {
        int r10 = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        if (r10 < 0) goto L5;
        return r10;
    L5:
        return r10 + this.daysInWeek;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Month) == true) goto L8;
        return false;
    L8:
        Month r11 = (Month) r10;
        if (this.month != r11.month) goto L14;
        if (this.year != r11.year) goto L14;
        return true;
    L14:
        return false;
    }

    public long getDay(int r10) {
        Calendar r11 = UtcDates.getDayCopy(this.firstOfMonth);
        r11.set(5, r10);
        return r11.getTimeInMillis();
    }

    public int getDayOfMonth(long r10) {
        Calendar r11 = UtcDates.getDayCopy(this.firstOfMonth);
        r11.setTimeInMillis(r10);
        return r11.get(5);
    }

    @NonNull
    public String getLongName(Context r10) {
        if (this.longName != null) goto L6;
        this.longName = DateStrings.getYearMonth(r10, this.firstOfMonth.getTimeInMillis());
    L6:
        return this.longName;
    }

    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @NonNull
    public Month monthsLater(int r10) {
        Calendar r11 = UtcDates.getDayCopy(this.firstOfMonth);
        r11.add(2, r10);
        return new Month(r11);
    }

    public int monthsUntil(@NonNull Month r10) {
        if ((this.firstOfMonth instanceof GregorianCalendar) == false) goto L7;
        return ((r10.year - this.year) * 12) + (r10.month - this.month);
    L7:
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeInt(this.year);
        r10.writeInt(this.month);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull Month r10) {
        return this.firstOfMonth.compareTo(r10.firstOfMonth);
    }

    @NonNull
    public static Month create(int r10, int r11) {
        Calendar r12 = UtcDates.getUtcCalendar();
        r12.set(1, r10);
        r12.set(2, r11);
        return new Month(r12);
    }
}
