package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.c;
import t0.J;

@SafeParcelable.Class(creator = "AuthAccountResultCreator")
/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new c(25);

    /* renamed from: a, reason: collision with root package name */
    public final int f10249a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10250b;

    /* renamed from: c, reason: collision with root package name */
    public final Intent f10251c;

    public zaa(int i4, int i5, Intent intent) {
        this.f10249a = i4;
        this.f10250b = i5;
        this.f10251c = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10249a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10250b);
        J.T(parcel, 3, this.f10251c, i4);
        J.b0(parcel, iZ);
    }
}
