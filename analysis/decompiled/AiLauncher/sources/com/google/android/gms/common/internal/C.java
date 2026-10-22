package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class C implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        int iA = 0;
        boolean zV = false;
        boolean zV2 = false;
        IBinder iBinderZ = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                iBinderZ = SafeParcelReader.z(parcel, iY);
            } else if (iU == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.n(parcel, iY, ConnectionResult.CREATOR);
            } else if (iU == 4) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU != 5) {
                SafeParcelReader.E(parcel, iY);
            } else {
                zV2 = SafeParcelReader.v(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zav(iA, iBinderZ, connectionResult, zV, zV2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zav[i10];
    }
}
