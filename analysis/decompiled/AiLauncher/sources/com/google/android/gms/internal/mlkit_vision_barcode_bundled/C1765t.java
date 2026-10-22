package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1765t implements Parcelable.Creator {
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
        String strO8 = null;
        String strO9 = null;
        String strO10 = null;
        String strO11 = null;
        String strO12 = null;
        String strO13 = null;
        String strO14 = null;
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
                case 8:
                    strO8 = SafeParcelReader.o(parcel, iY);
                    break;
                case 9:
                    strO9 = SafeParcelReader.o(parcel, iY);
                    break;
                case 10:
                    strO10 = SafeParcelReader.o(parcel, iY);
                    break;
                case 11:
                    strO11 = SafeParcelReader.o(parcel, iY);
                    break;
                case 12:
                    strO12 = SafeParcelReader.o(parcel, iY);
                    break;
                case 13:
                    strO13 = SafeParcelReader.o(parcel, iY);
                    break;
                case 14:
                    strO14 = SafeParcelReader.o(parcel, iY);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzaq(strO, strO2, strO3, strO4, strO5, strO6, strO7, strO8, strO9, strO10, strO11, strO12, strO13, strO14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzaq[i10];
    }
}
