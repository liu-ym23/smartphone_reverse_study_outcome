package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "LocationSettingsRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
/* loaded from: classes.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new k(29);

    /* renamed from: a, reason: collision with root package name */
    public final List f10064a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10065b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10066c;

    public LocationSettingsRequest(ArrayList arrayList, boolean z4, boolean z5) {
        this.f10064a = arrayList;
        this.f10065b = z4;
        this.f10066c = z5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 1, Collections.unmodifiableList(this.f10064a));
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10065b ? 1 : 0);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10066c ? 1 : 0);
        J.b0(parcel, iZ);
    }
}
