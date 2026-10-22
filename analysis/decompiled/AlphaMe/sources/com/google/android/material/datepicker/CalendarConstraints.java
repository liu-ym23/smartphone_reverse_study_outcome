package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new C0422a();

    /* renamed from: a, reason: collision with root package name */
    public final Month f10599a;

    /* renamed from: b, reason: collision with root package name */
    public final Month f10600b;

    /* renamed from: c, reason: collision with root package name */
    public final DateValidator f10601c;

    /* renamed from: d, reason: collision with root package name */
    public final Month f10602d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10603e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10604f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10605g;

    public interface DateValidator extends Parcelable {
        boolean l(long j4);
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i4) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f10599a = month;
        this.f10600b = month2;
        this.f10602d = month3;
        this.f10603e = i4;
        this.f10601c = dateValidator;
        if (month3 != null && month.f10657a.compareTo(month3.f10657a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.f10657a.compareTo(month2.f10657a) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i4 < 0 || i4 > J.g(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f10605g = month.h(month2) + 1;
        this.f10604f = (month2.f10659c - month.f10659c) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f10599a.equals(calendarConstraints.f10599a) && this.f10600b.equals(calendarConstraints.f10600b) && Objects.equals(this.f10602d, calendarConstraints.f10602d) && this.f10603e == calendarConstraints.f10603e && this.f10601c.equals(calendarConstraints.f10601c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10599a, this.f10600b, this.f10602d, Integer.valueOf(this.f10603e), this.f10601c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f10599a, 0);
        parcel.writeParcelable(this.f10600b, 0);
        parcel.writeParcelable(this.f10602d, 0);
        parcel.writeParcelable(this.f10601c, 0);
        parcel.writeInt(this.f10603e);
    }
}
