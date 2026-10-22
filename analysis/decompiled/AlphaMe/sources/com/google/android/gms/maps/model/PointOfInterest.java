package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "PointOfInterestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class PointOfInterest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new c(11);

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f10188a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10189b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10190c;

    public PointOfInterest(LatLng latLng, String str, String str2) {
        this.f10188a = latLng;
        this.f10189b = str;
        this.f10190c = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 2, this.f10188a, i4);
        J.U(parcel, 3, this.f10189b);
        J.U(parcel, 4, this.f10190c);
        J.b0(parcel, iZ);
    }
}
