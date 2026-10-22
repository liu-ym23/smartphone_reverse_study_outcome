package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        String strO = null;
        ConnectionResult connectionResult = null;
        int iA = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, iY, PendingIntent.CREATOR);
            } else if (iU != 4) {
                SafeParcelReader.E(parcel, iY);
            } else {
                connectionResult = (ConnectionResult) SafeParcelReader.n(parcel, iY, ConnectionResult.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new Status(iA, strO, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new Status[i10];
    }
}
