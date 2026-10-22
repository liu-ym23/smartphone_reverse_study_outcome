package com.google.android.gms.common.server.converter;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "StringToIntConverterEntryCreator")
/* loaded from: classes.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new C0154a(21);

    /* renamed from: a, reason: collision with root package name */
    public final int f9902a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9903b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9904c;

    public zac(int i4, int i5, String str) {
        this.f9902a = i4;
        this.f9903b = str;
        this.f9904c = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9902a);
        J.U(parcel, 2, this.f9903b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9904c);
        J.b0(parcel, iZ);
    }

    public zac(String str, int i4) {
        this.f9902a = 1;
        this.f9903b = str;
        this.f9904c = i4;
    }
}
