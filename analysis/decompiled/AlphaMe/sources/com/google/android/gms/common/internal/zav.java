package com.google.android.gms.common.internal;

import a1.C0154a;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "ResolveAccountResponseCreator")
/* loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new C0154a(6);

    /* renamed from: a, reason: collision with root package name */
    public final int f9862a;

    /* renamed from: b, reason: collision with root package name */
    public final IBinder f9863b;

    /* renamed from: c, reason: collision with root package name */
    public final ConnectionResult f9864c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9865d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9866e;

    public zav(int i4, IBinder iBinder, ConnectionResult connectionResult, boolean z4, boolean z5) {
        this.f9862a = i4;
        this.f9863b = iBinder;
        this.f9864c = connectionResult;
        this.f9865d = z4;
        this.f9866e = z5;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        if (this.f9864c.equals(zavVar.f9864c)) {
            IBinder iBinder = this.f9863b;
            IAccountAccessor iAccountAccessorAsInterface = iBinder == null ? null : IAccountAccessor.Stub.asInterface(iBinder);
            IBinder iBinder2 = zavVar.f9863b;
            if (com.airbnb.lottie.h.m(iAccountAccessorAsInterface, iBinder2 != null ? IAccountAccessor.Stub.asInterface(iBinder2) : null)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9862a);
        J.R(parcel, 2, this.f9863b);
        J.T(parcel, 3, this.f9864c, i4);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f9865d ? 1 : 0);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f9866e ? 1 : 0);
        J.b0(parcel, iZ);
    }
}
