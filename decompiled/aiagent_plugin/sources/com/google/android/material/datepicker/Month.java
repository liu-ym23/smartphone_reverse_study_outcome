package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes2.dex */
final class Month implements Parcelable, Comparable<Month> {
    public static final Parcelable.Creator<Month> CREATOR = null;
    final int daysInMonth;
    final int daysInWeek;
    private final Calendar firstOfMonth;
    private String longName;
    final int month;
    final long timeInMillis;
    final int year;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Month r3) {
        return compareTo2((Month) ZeusTransformUtils.preCheckCast(r3, Month.class, "com.obric.aiagent.plugin"));
    }

    private Month(Calendar r4) {
        r4.set(5, 1);
        Calendar r5 = i.b(r4);
        this.firstOfMonth = r5;
        this.month = r5.get(2);
        this.year = r5.get(1);
        this.daysInWeek = r5.getMaximum(7);
        this.daysInMonth = r5.getActualMaximum(5);
        this.timeInMillis = r5.getTimeInMillis();
    }

    static Month create(long r1) {
        Calendar r0 = i.c();
        r0.setTimeInMillis(r1);
        return new Month(r0);
    }

    static Month create(int r2, int r3) {
        Calendar r0 = i.c();
        r0.set(1, r2);
        r0.set(2, r3);
        return new Month(r0);
    }

    static Month current() {
        return new Month(i.b());
    }

    int daysFromStartOfWeekToFirstOfMonth() {
        int r0 = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        if (r0 < 0) goto L5;
        return r0;
    L5:
        return r0 + this.daysInWeek;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Month.class) == true) goto L8;
        return false;
    L8:
        Month r6 = (Month) ZeusTransformUtils.preCheckCast(r5, Month.class, "com.obric.aiagent.plugin");
        if (this.month != r6.month) goto L14;
        if (this.year != r6.year) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Month r1) {
        return this.firstOfMonth.compareTo(r1.firstOfMonth);
    }

    int monthsUntil(Month r3) {
        if (ZeusTransformUtils.instanceOf(this.firstOfMonth, GregorianCalendar.class) == false) goto L7;
        return ((r3.year - this.year) * 12) + (r3.month - this.month);
    L7:
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    long getDay(int r2) {
        Calendar r1 = i.b(this.firstOfMonth);
        r1.set(5, r2);
        return r1.getTimeInMillis();
    }

    int getDayOfMonth(long r1) {
        Calendar r0 = i.b(this.firstOfMonth);
        r0.setTimeInMillis(r1);
        return r0.get(5);
    }

    Month monthsLater(int r2) {
        Calendar r1 = i.b(this.firstOfMonth);
        r1.add(2, r2);
        return new Month(r1);
    }

    String getLongName() {
        if (this.longName != null) goto L6;
        this.longName = c.a(this.firstOfMonth.getTimeInMillis());
    L6:
        return this.longName;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.year);
        r1.writeInt(this.month);
    }
}
