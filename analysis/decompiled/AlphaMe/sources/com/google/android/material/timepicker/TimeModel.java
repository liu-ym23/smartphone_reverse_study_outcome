package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new i();

    /* renamed from: a, reason: collision with root package name */
    public final int f11155a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11156b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11157c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11158d;

    public TimeModel(Parcel parcel) {
        int i4 = parcel.readInt();
        int i5 = parcel.readInt();
        int i6 = parcel.readInt();
        int i7 = parcel.readInt();
        this.f11156b = i4;
        this.f11157c = i5;
        this.f11158d = i6;
        this.f11155a = i7;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f11156b == timeModel.f11156b && this.f11157c == timeModel.f11157c && this.f11155a == timeModel.f11155a && this.f11158d == timeModel.f11158d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11155a), Integer.valueOf(this.f11156b), Integer.valueOf(this.f11157c), Integer.valueOf(this.f11158d)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f11156b);
        parcel.writeInt(this.f11157c);
        parcel.writeInt(this.f11158d);
        parcel.writeInt(this.f11155a);
    }
}
