package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class n implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        boolean zV = false;
        boolean zV2 = false;
        boolean zV3 = false;
        boolean zV4 = false;
        String strO = null;
        IBinder iBinderZ = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 2:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 3:
                    zV2 = SafeParcelReader.v(parcel, iY);
                    break;
                case 4:
                    iBinderZ = SafeParcelReader.z(parcel, iY);
                    break;
                case 5:
                    zV3 = SafeParcelReader.v(parcel, iY);
                    break;
                case 6:
                    zV4 = SafeParcelReader.v(parcel, iY);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzo(strO, zV, zV2, iBinderZ, zV3, zV4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzo[i10];
    }
}
