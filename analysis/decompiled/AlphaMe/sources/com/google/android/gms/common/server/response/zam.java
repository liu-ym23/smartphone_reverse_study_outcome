package com.google.android.gms.common.server.response;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMapPairCreator")
/* loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new C0154a(22);

    /* renamed from: a, reason: collision with root package name */
    public final int f9926a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9927b;

    /* renamed from: c, reason: collision with root package name */
    public final FastJsonResponse$Field f9928c;

    public zam(int i4, String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f9926a = i4;
        this.f9927b = str;
        this.f9928c = fastJsonResponse$Field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9926a);
        J.U(parcel, 2, this.f9927b);
        J.T(parcel, 3, this.f9928c, i4);
        J.b0(parcel, iZ);
    }

    public zam(String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f9926a = 1;
        this.f9927b = str;
        this.f9928c = fastJsonResponse$Field;
    }
}
