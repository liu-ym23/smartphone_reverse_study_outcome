package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class S implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrJ = null;
        int[] iArrJ2 = null;
        boolean zV = false;
        boolean zV2 = false;
        int iA = 0;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.n(parcel, iY, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 3:
                    zV2 = SafeParcelReader.v(parcel, iY);
                    break;
                case 4:
                    iArrJ = SafeParcelReader.j(parcel, iY);
                    break;
                case 5:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 6:
                    iArrJ2 = SafeParcelReader.j(parcel, iY);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zV, zV2, iArrJ, iA, iArrJ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new ConnectionTelemetryConfiguration[i10];
    }
}
