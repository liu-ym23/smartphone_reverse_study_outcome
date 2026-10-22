package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1789z implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        String strO5 = null;
        String strO6 = null;
        String strO7 = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 2:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 3:
                    strO3 = SafeParcelReader.o(parcel, iY);
                    break;
                case 4:
                    strO4 = SafeParcelReader.o(parcel, iY);
                    break;
                case 5:
                    strO5 = SafeParcelReader.o(parcel, iY);
                    break;
                case 6:
                    strO6 = SafeParcelReader.o(parcel, iY);
                    break;
                case 7:
                    strO7 = SafeParcelReader.o(parcel, iY);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzat(strO, strO2, strO3, strO4, strO5, strO6, strO7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzat[i10];
    }
}
