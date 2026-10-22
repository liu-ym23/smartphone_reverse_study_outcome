package com.google.android.gms.common.server.converter;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "ConverterWrapperCreator")
/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new C0154a(19);

    /* renamed from: a, reason: collision with root package name */
    public final int f9900a;

    /* renamed from: b, reason: collision with root package name */
    public final StringToIntConverter f9901b;

    public zaa(int i4, StringToIntConverter stringToIntConverter) {
        this.f9900a = i4;
        this.f9901b = stringToIntConverter;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9900a);
        J.T(parcel, 2, this.f9901b, i4);
        J.b0(parcel, iZ);
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.f9900a = 1;
        this.f9901b = stringToIntConverter;
    }
}
