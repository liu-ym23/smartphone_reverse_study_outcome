package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1777w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        boolean zV = false;
        boolean zV2 = false;
        boolean zV3 = false;
        float fX = 0.0f;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU == 2) {
                bArrG = SafeParcelReader.g(parcel, iY);
            } else if (iU == 3) {
                zV2 = SafeParcelReader.v(parcel, iY);
            } else if (iU == 4) {
                fX = SafeParcelReader.x(parcel, iY);
            } else if (iU != 5) {
                SafeParcelReader.E(parcel, iY);
            } else {
                zV3 = SafeParcelReader.v(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzbr(zV, bArrG, zV2, fX, zV3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzbr[i10];
    }
}
