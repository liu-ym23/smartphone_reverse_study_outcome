package com.google.android.gms.common.internal;

import a1.C0154a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "ConnectionInfoCreator")
/* loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new C0154a(11);

    /* renamed from: a, reason: collision with root package name */
    public Bundle f9872a;

    /* renamed from: b, reason: collision with root package name */
    public Feature[] f9873b;

    /* renamed from: c, reason: collision with root package name */
    public int f9874c;

    /* renamed from: d, reason: collision with root package name */
    public ConnectionTelemetryConfiguration f9875d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.P(parcel, 1, this.f9872a);
        J.V(parcel, 2, this.f9873b, i4);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9874c);
        J.T(parcel, 4, this.f9875d, i4);
        J.b0(parcel, iZ);
    }
}
