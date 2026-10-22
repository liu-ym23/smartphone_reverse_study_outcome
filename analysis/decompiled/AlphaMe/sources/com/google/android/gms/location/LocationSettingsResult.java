package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import t0.J;

@SafeParcelable.Class(creator = "LocationSettingsResultCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class LocationSettingsResult extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new k(9);

    /* renamed from: a, reason: collision with root package name */
    public final Status f10067a;

    /* renamed from: b, reason: collision with root package name */
    public final LocationSettingsStates f10068b;

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f10067a = status;
        this.f10068b = locationSettingsStates;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 1, this.f10067a, i4);
        J.T(parcel, 2, this.f10068b, i4);
        J.b0(parcel, iZ);
    }
}
