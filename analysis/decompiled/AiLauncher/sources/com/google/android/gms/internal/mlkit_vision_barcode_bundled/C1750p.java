package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1750p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        zzbr zzbrVar = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            if (SafeParcelReader.u(iY) != 1) {
                SafeParcelReader.E(parcel, iY);
            } else {
                zzbrVar = (zzbr) SafeParcelReader.n(parcel, iY, zzbr.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzbe(zzbrVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzbe[i10];
    }
}
