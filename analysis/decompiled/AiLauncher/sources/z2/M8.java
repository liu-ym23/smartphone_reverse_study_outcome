package z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzk;

/* loaded from: classes2.dex */
public final class M8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        String strO = null;
        String strO2 = null;
        String strO3 = null;
        String strO4 = null;
        String strO5 = null;
        zzj zzjVar = null;
        zzj zzjVar2 = null;
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
                    zzjVar = (zzj) SafeParcelReader.n(parcel, iY, zzj.CREATOR);
                    break;
                case 8:
                    zzjVar2 = (zzj) SafeParcelReader.n(parcel, iY, zzj.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzk(strO, strO2, strO3, strO4, strO5, zzjVar, zzjVar2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzk[i10];
    }
}
