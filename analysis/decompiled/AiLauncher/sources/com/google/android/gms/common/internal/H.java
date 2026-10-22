package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class H implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        int iA = 0;
        boolean zV = false;
        boolean zV2 = false;
        int iA2 = 0;
        int iA3 = 0;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU == 3) {
                zV2 = SafeParcelReader.v(parcel, iY);
            } else if (iU == 4) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU != 5) {
                SafeParcelReader.E(parcel, iY);
            } else {
                iA3 = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new RootTelemetryConfiguration(iA, zV, zV2, iA2, iA3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new RootTelemetryConfiguration[i10];
    }
}
