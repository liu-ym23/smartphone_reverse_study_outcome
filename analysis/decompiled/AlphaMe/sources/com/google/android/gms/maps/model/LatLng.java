package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "LatLngCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class LatLng extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<LatLng> CREATOR = new c(7);

    /* renamed from: a, reason: collision with root package name */
    public final double f10167a;

    /* renamed from: b, reason: collision with root package name */
    public final double f10168b;

    public LatLng(double d4, double d5) {
        if (d5 < -180.0d || d5 >= 180.0d) {
            this.f10168b = ((((d5 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f10168b = d5;
        }
        this.f10167a = Math.max(-90.0d, Math.min(90.0d, d4));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f10167a) == Double.doubleToLongBits(latLng.f10167a) && Double.doubleToLongBits(this.f10168b) == Double.doubleToLongBits(latLng.f10168b);
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f10167a);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f10168b);
        return ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "lat/lng: (" + this.f10167a + "," + this.f10168b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 2, 8);
        parcel.writeDouble(this.f10167a);
        J.c0(parcel, 3, 8);
        parcel.writeDouble(this.f10168b);
        J.b0(parcel, iZ);
    }
}
