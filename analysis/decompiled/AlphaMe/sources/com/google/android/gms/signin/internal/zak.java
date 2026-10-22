package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.maps.model.c;
import t0.J;

@SafeParcelable.Class(creator = "SignInResponseCreator")
/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new c(28);

    /* renamed from: a, reason: collision with root package name */
    public final int f10256a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectionResult f10257b;

    /* renamed from: c, reason: collision with root package name */
    public final zav f10258c;

    public zak(int i4, ConnectionResult connectionResult, zav zavVar) {
        this.f10256a = i4;
        this.f10257b = connectionResult;
        this.f10258c = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10256a);
        J.T(parcel, 2, this.f10257b, i4);
        J.T(parcel, 3, this.f10258c, i4);
        J.b0(parcel, iZ);
    }
}
