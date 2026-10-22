package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        ArrayList arrayListS = null;
        int iA = 0;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU != 2) {
                SafeParcelReader.E(parcel, iY);
            } else {
                arrayListS = SafeParcelReader.s(parcel, iY, zac.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new StringToIntConverter(iA, arrayListS);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new StringToIntConverter[i10];
    }
}
