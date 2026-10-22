package com.google.android.gms.maps.model;

import B0.e;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "LatLngBoundsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new c(6);

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f10169a;

    /* renamed from: b, reason: collision with root package name */
    public final LatLng f10170b;

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        com.stepos.statsrpk.c.m(latLng, "southwest must not be null.");
        com.stepos.statsrpk.c.m(latLng2, "northeast must not be null.");
        double d4 = latLng2.f10167a;
        double d5 = latLng.f10167a;
        if (d4 >= d5) {
            this.f10169a = latLng;
            this.f10170b = latLng2;
            return;
        }
        throw new IllegalArgumentException("southern latitude exceeds northern latitude (" + d5 + " > " + d4 + ")");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f10169a.equals(latLngBounds.f10169a) && this.f10170b.equals(latLngBounds.f10170b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10169a, this.f10170b});
    }

    public final String toString() {
        e eVar = new e(this);
        eVar.a(this.f10169a, "southwest");
        eVar.a(this.f10170b, "northeast");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 2, this.f10169a, i4);
        J.T(parcel, 3, this.f10170b, i4);
        J.b0(parcel, iZ);
    }
}
