package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1781x implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        int iA = 0;
        float[] fArrI = null;
        boolean zV = false;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                fArrI = SafeParcelReader.i(parcel, iY);
            } else if (iU == 2) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU != 3) {
                SafeParcelReader.E(parcel, iY);
            } else {
                zV = SafeParcelReader.v(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzbt(fArrI, iA, zV);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzbt[i10];
    }
}
