package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1746o implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        boolean zV = false;
        zzbt zzbtVar = null;
        zzbv zzbvVar = null;
        boolean zV2 = false;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                zzbtVar = (zzbt) SafeParcelReader.n(parcel, iY, zzbt.CREATOR);
            } else if (iU == 2) {
                zzbvVar = (zzbv) SafeParcelReader.n(parcel, iY, zzbv.CREATOR);
            } else if (iU == 3) {
                zV = SafeParcelReader.v(parcel, iY);
            } else if (iU != 4) {
                SafeParcelReader.E(parcel, iY);
            } else {
                zV2 = SafeParcelReader.v(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzbc(zzbtVar, zzbvVar, zV, zV2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzbc[i10];
    }
}
