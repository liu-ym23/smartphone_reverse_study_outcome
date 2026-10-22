package z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;

/* loaded from: classes2.dex */
public final class T8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        zzp zzpVar = null;
        String strO = null;
        String strO2 = null;
        zzq[] zzqVarArr = null;
        zzn[] zznVarArr = null;
        String[] strArrP = null;
        zzi[] zziVarArr = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 2:
                    zzpVar = (zzp) SafeParcelReader.n(parcel, iY, zzp.CREATOR);
                    break;
                case 3:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 4:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 5:
                    zzqVarArr = (zzq[]) SafeParcelReader.r(parcel, iY, zzq.CREATOR);
                    break;
                case 6:
                    zznVarArr = (zzn[]) SafeParcelReader.r(parcel, iY, zzn.CREATOR);
                    break;
                case 7:
                    strArrP = SafeParcelReader.p(parcel, iY);
                    break;
                case 8:
                    zziVarArr = (zzi[]) SafeParcelReader.r(parcel, iY, zzi.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzl(zzpVar, strO, strO2, zzqVarArr, zznVarArr, strArrP, zziVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzl[i10];
    }
}
