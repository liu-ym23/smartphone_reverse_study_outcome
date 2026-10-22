package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        int iA = 0;
        int iA2 = 0;
        Uri uri = null;
        int iA3 = 0;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                uri = (Uri) SafeParcelReader.n(parcel, iY, Uri.CREATOR);
            } else if (iU == 3) {
                iA3 = SafeParcelReader.A(parcel, iY);
            } else if (iU != 4) {
                SafeParcelReader.E(parcel, iY);
            } else {
                iA2 = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new WebImage(iA, uri, iA3, iA2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new WebImage[i10];
    }
}
