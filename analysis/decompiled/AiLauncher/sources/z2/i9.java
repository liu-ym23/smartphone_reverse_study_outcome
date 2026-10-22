package z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzm;

/* loaded from: classes2.dex */
public final class i9 implements Parcelable.Creator {
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
                case 2:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 3:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 4:
                    strO3 = SafeParcelReader.o(parcel, iY);
                    break;
                case 5:
                    strO4 = SafeParcelReader.o(parcel, iY);
                    break;
                case 6:
                    strO5 = SafeParcelReader.o(parcel, iY);
                    break;
                case 7:
                    strO6 = SafeParcelReader.o(parcel, iY);
                    break;
                case 8:
                    strO7 = SafeParcelReader.o(parcel, iY);
                    break;
                case 9:
                    strO8 = SafeParcelReader.o(parcel, iY);
                    break;
                case 10:
                    strO9 = SafeParcelReader.o(parcel, iY);
                    break;
                case 11:
                    strO10 = SafeParcelReader.o(parcel, iY);
                    break;
                case 12:
                    strO11 = SafeParcelReader.o(parcel, iY);
                    break;
                case 13:
                    strO12 = SafeParcelReader.o(parcel, iY);
                    break;
                case 14:
                    strO13 = SafeParcelReader.o(parcel, iY);
                    break;
                case 15:
                    strO14 = SafeParcelReader.o(parcel, iY);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzm(strO, strO2, strO3, strO4, strO5, strO6, strO7, strO8, strO9, strO10, strO11, strO12, strO13, strO14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzm[i10];
    }
}
