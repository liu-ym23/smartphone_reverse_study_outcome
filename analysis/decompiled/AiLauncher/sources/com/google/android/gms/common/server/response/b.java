package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        String strO = null;
        int iA = 0;
        FastJsonResponse.Field field = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU != 3) {
                SafeParcelReader.E(parcel, iY);
            } else {
                field = (FastJsonResponse.Field) SafeParcelReader.n(parcel, iY, FastJsonResponse.Field.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zam(iA, strO, field);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zam[i10];
    }
}
