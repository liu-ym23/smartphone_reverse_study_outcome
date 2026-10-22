package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* loaded from: classes.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new x(0);

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f10657a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10658b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10659c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10660d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10661e;

    /* renamed from: f, reason: collision with root package name */
    public final long f10662f;

    /* renamed from: g, reason: collision with root package name */
    public String f10663g;

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = J.c(calendar);
        this.f10657a = calendarC;
        this.f10658b = calendarC.get(2);
        this.f10659c = calendarC.get(1);
        this.f10660d = calendarC.getMaximum(7);
        this.f10661e = calendarC.getActualMaximum(5);
        this.f10662f = calendarC.getTimeInMillis();
    }

    public static Month c(int i4, int i5) {
        Calendar calendarG = J.g(null);
        calendarG.set(1, i4);
        calendarG.set(2, i5);
        return new Month(calendarG);
    }

    public static Month f(long j4) {
        Calendar calendarG = J.g(null);
        calendarG.setTimeInMillis(j4);
        return new Month(calendarG);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Month month) {
        return this.f10657a.compareTo(month.f10657a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f10658b == month.f10658b && this.f10659c == month.f10659c;
    }

    public final String g() {
        if (this.f10663g == null) {
            this.f10663g = J.b("yMMMM", Locale.getDefault()).format(new Date(this.f10657a.getTimeInMillis()));
        }
        return this.f10663g;
    }

    public final int h(Month month) {
        if (!(this.f10657a instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.f10658b - this.f10658b) + ((month.f10659c - this.f10659c) * 12);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10658b), Integer.valueOf(this.f10659c)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f10659c);
        parcel.writeInt(this.f10658b);
    }
}
