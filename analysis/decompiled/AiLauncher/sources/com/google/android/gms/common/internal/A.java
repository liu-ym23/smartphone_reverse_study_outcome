package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class A implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        int iA = -1;
        int iA2 = 0;
        int iA3 = 0;
        int iA4 = 0;
        int iA5 = 0;
        String strO = null;
        String strO2 = null;
        long jB = 0;
        long jB2 = 0;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    iA3 = SafeParcelReader.A(parcel, iY);
                    break;
                case 3:
                    iA4 = SafeParcelReader.A(parcel, iY);
                    break;
                case 4:
                    jB = SafeParcelReader.B(parcel, iY);
                    break;
                case 5:
                    jB2 = SafeParcelReader.B(parcel, iY);
                    break;
                case 6:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 7:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 8:
                    iA5 = SafeParcelReader.A(parcel, iY);
                    break;
                case 9:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new MethodInvocation(iA2, iA3, iA4, jB, jB2, strO, strO2, iA5, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new MethodInvocation[i10];
    }
}
