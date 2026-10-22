package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1761s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        zzat zzatVar = null;
        String strO = null;
        String strO2 = null;
        zzau[] zzauVarArr = null;
        zzar[] zzarVarArr = null;
        String[] strArrP = null;
        zzam[] zzamVarArr = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    zzatVar = (zzat) SafeParcelReader.n(parcel, iY, zzat.CREATOR);
                    break;
                case 2:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 3:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 4:
                    zzauVarArr = (zzau[]) SafeParcelReader.r(parcel, iY, zzau.CREATOR);
                    break;
                case 5:
                    zzarVarArr = (zzar[]) SafeParcelReader.r(parcel, iY, zzar.CREATOR);
                    break;
                case 6:
                    strArrP = SafeParcelReader.p(parcel, iY);
                    break;
                case 7:
                    zzamVarArr = (zzam[]) SafeParcelReader.r(parcel, iY, zzam.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzap(zzatVar, strO, strO2, zzauVarArr, zzarVarArr, strArrP, zzamVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzap[i10];
    }
}
