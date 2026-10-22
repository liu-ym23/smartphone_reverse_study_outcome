package com.google.android.gms.common.internal;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "SignInButtonConfigCreator")
/* loaded from: classes.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new C0154a(7);

    /* renamed from: a, reason: collision with root package name */
    public final int f9867a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9868b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9869c;

    /* renamed from: d, reason: collision with root package name */
    public final Scope[] f9870d;

    public zax(int i4, int i5, int i6, Scope[] scopeArr) {
        this.f9867a = i4;
        this.f9868b = i5;
        this.f9869c = i6;
        this.f9870d = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9867a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9868b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9869c);
        J.V(parcel, 4, this.f9870d, i4);
        J.b0(parcel, iZ);
    }
}
