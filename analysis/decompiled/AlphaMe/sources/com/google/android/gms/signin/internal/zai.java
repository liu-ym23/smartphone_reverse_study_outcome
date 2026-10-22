package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.maps.model.c;
import t0.J;

@SafeParcelable.Class(creator = "SignInRequestCreator")
/* loaded from: classes.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new c(27);

    /* renamed from: a, reason: collision with root package name */
    public final int f10254a;

    /* renamed from: b, reason: collision with root package name */
    public final zat f10255b;

    public zai(int i4, zat zatVar) {
        this.f10254a = i4;
        this.f10255b = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10254a);
        J.T(parcel, 2, this.f10255b, i4);
        J.b0(parcel, iZ);
    }
}
