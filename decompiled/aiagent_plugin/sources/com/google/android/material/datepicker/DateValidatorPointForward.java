package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        return from(i.b().getTimeInMillis());
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

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, DateValidatorPointForward.class) == true) goto L8;
        return false;
    L8:
        DateValidatorPointForward r8 = (DateValidatorPointForward) ZeusTransformUtils.preCheckCast(r7, DateValidatorPointForward.class, "com.obric.aiagent.plugin");
        if (this.point != r8.point) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }
}
