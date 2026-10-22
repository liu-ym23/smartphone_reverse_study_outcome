package com.google.android.gms.common.internal;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.alphame.awareness.AwarenessDataItem;
import t0.J;

@KeepForSdk
@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new C0154a(2);

    /* renamed from: a, reason: collision with root package name */
    public final int f9731a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9732b;

    public ClientIdentity(int i4, String str) {
        this.f9731a = i4;
        this.f9732b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f9731a == this.f9731a && com.airbnb.lottie.h.m(clientIdentity.f9732b, this.f9732b);
    }

    public final int hashCode() {
        return this.f9731a;
    }

    public final String toString() {
        return this.f9731a + AwarenessDataItem.USERID_SPLITTER + this.f9732b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9731a);
        J.U(parcel, 2, this.f9732b);
        J.b0(parcel, iZ);
    }
}
