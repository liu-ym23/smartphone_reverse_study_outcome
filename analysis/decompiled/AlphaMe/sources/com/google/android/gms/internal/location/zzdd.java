package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import t0.J;

@SafeParcelable.Class(creator = "LocationRequestInternalCreator")
@SafeParcelable.Reserved({2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 1000})
@Deprecated
/* loaded from: classes.dex */
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new com.google.android.gms.common.k(4);

    /* renamed from: a, reason: collision with root package name */
    public LocationRequest f9987a;

    public final boolean equals(Object obj) {
        if (obj instanceof zzdd) {
            return com.airbnb.lottie.h.m(this.f9987a, ((zzdd) obj).f9987a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9987a.hashCode();
    }

    public final String toString() {
        return this.f9987a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 1, this.f9987a, i4);
        J.b0(parcel, iZ);
    }
}
