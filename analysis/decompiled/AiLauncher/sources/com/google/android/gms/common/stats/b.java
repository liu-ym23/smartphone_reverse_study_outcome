package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        int iA = 0;
        int iA2 = 0;
        int iA3 = 0;
        int iA4 = 0;
        boolean zV = false;
        String strO = null;
        ArrayList<String> arrayListQ = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        String strO5 = null;
        long jB = 0;
        long jB2 = 0;
        long jB3 = 0;
        float fX = 0.0f;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    jB = SafeParcelReader.B(parcel, iY);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
                case 4:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 5:
                    iA3 = SafeParcelReader.A(parcel, iY);
                    break;
                case 6:
                    arrayListQ = SafeParcelReader.q(parcel, iY);
                    break;
                case 8:
                    jB2 = SafeParcelReader.B(parcel, iY);
                    break;
                case 10:
                    strO3 = SafeParcelReader.o(parcel, iY);
                    break;
                case 11:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 12:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 13:
                    strO4 = SafeParcelReader.o(parcel, iY);
                    break;
                case 14:
                    iA4 = SafeParcelReader.A(parcel, iY);
                    break;
                case 15:
                    fX = SafeParcelReader.x(parcel, iY);
                    break;
                case 16:
                    jB3 = SafeParcelReader.B(parcel, iY);
                    break;
                case 17:
                    strO5 = SafeParcelReader.o(parcel, iY);
                    break;
                case 18:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new WakeLockEvent(iA, jB, iA2, strO, iA3, arrayListQ, strO2, jB2, iA4, strO3, strO4, fX, jB3, strO5, zV);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new WakeLockEvent[i10];
    }
}
