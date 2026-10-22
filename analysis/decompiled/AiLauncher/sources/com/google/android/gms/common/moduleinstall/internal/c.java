package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        ArrayList arrayListS = null;
        String strO = null;
        boolean zV = false;
        String strO2 = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                arrayListS = SafeParcelReader.s(parcel, iY, Feature.CREATOR);
            } else if (iU == 2) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU == 3) {
                strO2 = SafeParcelReader.o(parcel, iY);
            } else if (iU != 4) {
                SafeParcelReader.E(parcel, iY);
            } else {
                strO = SafeParcelReader.o(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new ApiFeatureRequest(arrayListS, zV, strO2, strO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new ApiFeatureRequest[i10];
    }
}
