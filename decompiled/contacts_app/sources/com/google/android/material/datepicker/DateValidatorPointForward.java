package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = null;
    private final long point;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ DateValidatorPointForward(long r1, AnonymousClass1 r3) {
        this(r1);
    }

    private DateValidatorPointForward(long r1) {
        this.point = r1;
    }

    public static DateValidatorPointForward from(long r1) {
        return new DateValidatorPointForward(r1);
    }

    public static DateValidatorPointForward now() {
        return from(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long r3) {
        if (r3 < this.point) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.point);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof DateValidatorPointForward) == true) goto L9;
        return false;
    L9:
        if (this.point != ((DateValidatorPointForward) r6).point) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }
}
