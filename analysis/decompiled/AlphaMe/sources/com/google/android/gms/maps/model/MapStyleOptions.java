package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "MapStyleOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class MapStyleOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new c(8);

    /* renamed from: a, reason: collision with root package name */
    public String f10171a;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.U(parcel, 2, this.f10171a);
        J.b0(parcel, iZ);
    }
}
