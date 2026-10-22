package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
final class p implements Comparable<p>, Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Calendar f12767a;

    /* renamed from: b, reason: collision with root package name */
    final int f12768b;

    /* renamed from: c, reason: collision with root package name */
    final int f12769c;

    /* renamed from: d, reason: collision with root package name */
    final int f12770d;

    /* renamed from: e, reason: collision with root package name */
    final int f12771e;

    /* renamed from: f, reason: collision with root package name */
    final long f12772f;

    /* renamed from: g, reason: collision with root package name */
    private String f12773g;

    class a implements Parcelable.Creator<p> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p createFromParcel(Parcel parcel) {
            return p.G(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public p[] newArray(int i5) {
            return new p[i5];
        }
    }

    private p(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = w.c(calendar);
        this.f12767a = calendarC;
        this.f12768b = calendarC.get(2);
        this.f12769c = calendarC.get(1);
        this.f12770d = calendarC.getMaximum(7);
        this.f12771e = calendarC.getActualMaximum(5);
        this.f12772f = calendarC.getTimeInMillis();
    }

    static p G(int i5, int i6) {
        Calendar calendarI = w.i();
        calendarI.set(1, i5);
        calendarI.set(2, i6);
        return new p(calendarI);
    }

    static p H(long j5) {
        Calendar calendarI = w.i();
        calendarI.setTimeInMillis(j5);
        return new p(calendarI);
    }

    static p I() {
        return new p(w.g());
    }

    @Override // java.lang.Comparable
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public int compareTo(p pVar) {
        return this.f12767a.compareTo(pVar.f12767a);
    }

    int J(int i5) {
        int i6 = this.f12767a.get(7);
        if (i5 <= 0) {
            i5 = this.f12767a.getFirstDayOfWeek();
        }
        int i7 = i6 - i5;
        return i7 < 0 ? i7 + this.f12770d : i7;
    }

    long K(int i5) {
        Calendar calendarC = w.c(this.f12767a);
        calendarC.set(5, i5);
        return calendarC.getTimeInMillis();
    }

    int L(long j5) {
        Calendar calendarC = w.c(this.f12767a);
        calendarC.setTimeInMillis(j5);
        return calendarC.get(5);
    }

    String M() {
        if (this.f12773g == null) {
            this.f12773g = e.f(this.f12767a.getTimeInMillis());
        }
        return this.f12773g;
    }

    long N() {
        return this.f12767a.getTimeInMillis();
    }

    p O(int i5) {
        Calendar calendarC = w.c(this.f12767a);
        calendarC.add(2, i5);
        return new p(calendarC);
    }

    int P(p pVar) {
        if (this.f12767a instanceof GregorianCalendar) {
            return ((pVar.f12769c - this.f12769c) * 12) + (pVar.f12768b - this.f12768b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f12768b == pVar.f12768b && this.f12769c == pVar.f12769c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12768b), Integer.valueOf(this.f12769c)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f12769c);
        parcel.writeInt(this.f12768b);
    }
}
