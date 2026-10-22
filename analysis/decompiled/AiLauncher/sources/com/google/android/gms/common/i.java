package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        PendingIntent pendingIntent = null;
        int iA = 0;
        int iA2 = 0;
        String strO = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, iY, PendingIntent.CREATOR);
            } else if (iU != 4) {
                SafeParcelReader.E(parcel, iY);
            } else {
                strO = SafeParcelReader.o(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new ConnectionResult(iA, iA2, pendingIntent, strO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new ConnectionResult[i10];
    }
}
