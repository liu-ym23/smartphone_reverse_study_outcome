package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import t0.J;

@SafeParcelable.Class(creator = "LocationSettingsStatesCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new k(10);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10069a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10070b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10071c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10072d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10073e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10074f;

    public LocationSettingsStates(boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.f10069a = z4;
        this.f10070b = z5;
        this.f10071c = z6;
        this.f10072d = z7;
        this.f10073e = z8;
        this.f10074f = z9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10069a ? 1 : 0);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10070b ? 1 : 0);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10071c ? 1 : 0);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f10072d ? 1 : 0);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f10073e ? 1 : 0);
        J.c0(parcel, 6, 4);
        parcel.writeInt(this.f10074f ? 1 : 0);
        J.b0(parcel, iZ);
    }
}
