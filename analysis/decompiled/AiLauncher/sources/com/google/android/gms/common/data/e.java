package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        String[] strArrP = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleF = null;
        int iA = 0;
        int iA2 = 0;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                strArrP = SafeParcelReader.p(parcel, iY);
            } else if (iU == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.r(parcel, iY, CursorWindow.CREATOR);
            } else if (iU == 3) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 4) {
                bundleF = SafeParcelReader.f(parcel, iY);
            } else if (iU != 1000) {
                SafeParcelReader.E(parcel, iY);
            } else {
                iA = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        DataHolder dataHolder = new DataHolder(iA, strArrP, cursorWindowArr, iA2, bundleF);
        dataHolder.zad();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new DataHolder[i10];
    }
}
