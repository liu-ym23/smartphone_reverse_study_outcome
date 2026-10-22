package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1738m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        String strO = null;
        String strO2 = null;
        byte[] bArrG = null;
        Point[] pointArr = null;
        zzar zzarVar = null;
        zzau zzauVar = null;
        zzav zzavVar = null;
        zzax zzaxVar = null;
        zzaw zzawVar = null;
        zzas zzasVar = null;
        zzao zzaoVar = null;
        zzap zzapVar = null;
        zzaq zzaqVar = null;
        int iA = 0;
        int iA2 = 0;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 3:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 4:
                    bArrG = SafeParcelReader.g(parcel, iY);
                    break;
                case 5:
                    pointArr = (Point[]) SafeParcelReader.r(parcel, iY, Point.CREATOR);
                    break;
                case 6:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 7:
                    zzarVar = (zzar) SafeParcelReader.n(parcel, iY, zzar.CREATOR);
                    break;
                case 8:
                    zzauVar = (zzau) SafeParcelReader.n(parcel, iY, zzau.CREATOR);
                    break;
                case 9:
                    zzavVar = (zzav) SafeParcelReader.n(parcel, iY, zzav.CREATOR);
                    break;
                case 10:
                    zzaxVar = (zzax) SafeParcelReader.n(parcel, iY, zzax.CREATOR);
                    break;
                case 11:
                    zzawVar = (zzaw) SafeParcelReader.n(parcel, iY, zzaw.CREATOR);
                    break;
                case 12:
                    zzasVar = (zzas) SafeParcelReader.n(parcel, iY, zzas.CREATOR);
                    break;
                case 13:
                    zzaoVar = (zzao) SafeParcelReader.n(parcel, iY, zzao.CREATOR);
                    break;
                case 14:
                    zzapVar = (zzap) SafeParcelReader.n(parcel, iY, zzap.CREATOR);
                    break;
                case 15:
                    zzaqVar = (zzaq) SafeParcelReader.n(parcel, iY, zzaq.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzay(iA, strO, strO2, bArrG, pointArr, iA2, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzay[i10];
    }
}
