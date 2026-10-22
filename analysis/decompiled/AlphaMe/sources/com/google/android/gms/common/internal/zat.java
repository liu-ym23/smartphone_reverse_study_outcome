package com.google.android.gms.common.internal;

import a1.C0154a;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "ResolveAccountRequestCreator")
/* loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new C0154a(5);

    /* renamed from: a, reason: collision with root package name */
    public final int f9858a;

    /* renamed from: b, reason: collision with root package name */
    public final Account f9859b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9860c;

    /* renamed from: d, reason: collision with root package name */
    public final GoogleSignInAccount f9861d;

    public zat(int i4, Account account, int i5, GoogleSignInAccount googleSignInAccount) {
        this.f9858a = i4;
        this.f9859b = account;
        this.f9860c = i5;
        this.f9861d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9858a);
        J.T(parcel, 2, this.f9859b, i4);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9860c);
        J.T(parcel, 4, this.f9861d, i4);
        J.b0(parcel, iZ);
    }
}
