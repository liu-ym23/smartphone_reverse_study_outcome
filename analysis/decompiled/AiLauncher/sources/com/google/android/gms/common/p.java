package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        boolean zV = false;
        String strO = null;
        IBinder iBinderZ = null;
        boolean zV2 = false;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU == 2) {
                iBinderZ = SafeParcelReader.z(parcel, iY);
            } else if (iU == 3) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU != 4) {
                SafeParcelReader.E(parcel, iY);
            } else {
                zV2 = SafeParcelReader.v(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzs(strO, iBinderZ, zV, zV2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzs[i10];
    }
}
