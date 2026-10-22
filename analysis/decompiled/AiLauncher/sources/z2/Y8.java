package z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxx;

/* loaded from: classes2.dex */
public final class Y8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        zzxw zzxwVar = null;
        String strO = null;
        String strO2 = null;
        zzxx[] zzxxVarArr = null;
        zzxu[] zzxuVarArr = null;
        String[] strArrP = null;
        zzxp[] zzxpVarArr = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    zzxwVar = (zzxw) SafeParcelReader.n(parcel, iY, zzxw.CREATOR);
                    break;
                case 2:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 3:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 4:
                    zzxxVarArr = (zzxx[]) SafeParcelReader.r(parcel, iY, zzxx.CREATOR);
                    break;
                case 5:
                    zzxuVarArr = (zzxu[]) SafeParcelReader.r(parcel, iY, zzxu.CREATOR);
                    break;
                case 6:
                    strArrP = SafeParcelReader.p(parcel, iY);
                    break;
                case 7:
                    zzxpVarArr = (zzxp[]) SafeParcelReader.r(parcel, iY, zzxp.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzxs(zzxwVar, strO, strO2, zzxxVarArr, zzxuVarArr, strArrP, zzxpVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzxs[i10];
    }
}
