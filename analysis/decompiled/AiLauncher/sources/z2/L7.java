package z2;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;

/* loaded from: classes2.dex */
public final class L7 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        double dW = 0.0d;
        int iA = 0;
        int iA2 = 0;
        boolean zV = false;
        String strO = null;
        String strO2 = null;
        Point[] pointArr = null;
        zzn zznVar = null;
        zzq zzqVar = null;
        zzr zzrVar = null;
        zzt zztVar = null;
        zzs zzsVar = null;
        zzo zzoVar = null;
        zzk zzkVar = null;
        zzl zzlVar = null;
        zzm zzmVar = null;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 2:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 3:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 4:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
                case 5:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 6:
                    pointArr = (Point[]) SafeParcelReader.r(parcel, iY, Point.CREATOR);
                    break;
                case 7:
                    zznVar = (zzn) SafeParcelReader.n(parcel, iY, zzn.CREATOR);
                    break;
                case 8:
                    zzqVar = (zzq) SafeParcelReader.n(parcel, iY, zzq.CREATOR);
                    break;
                case 9:
                    zzrVar = (zzr) SafeParcelReader.n(parcel, iY, zzr.CREATOR);
                    break;
                case 10:
                    zztVar = (zzt) SafeParcelReader.n(parcel, iY, zzt.CREATOR);
                    break;
                case 11:
                    zzsVar = (zzs) SafeParcelReader.n(parcel, iY, zzs.CREATOR);
                    break;
                case 12:
                    zzoVar = (zzo) SafeParcelReader.n(parcel, iY, zzo.CREATOR);
                    break;
                case 13:
                    zzkVar = (zzk) SafeParcelReader.n(parcel, iY, zzk.CREATOR);
                    break;
                case 14:
                    zzlVar = (zzl) SafeParcelReader.n(parcel, iY, zzl.CREATOR);
                    break;
                case 15:
                    zzmVar = (zzm) SafeParcelReader.n(parcel, iY, zzm.CREATOR);
                    break;
                case 16:
                    bArrG = SafeParcelReader.g(parcel, iY);
                    break;
                case 17:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 18:
                    dW = SafeParcelReader.w(parcel, iY);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzu(iA, strO, strO2, iA2, pointArr, zznVar, zzqVar, zzrVar, zztVar, zzsVar, zzoVar, zzkVar, zzlVar, zzmVar, bArrG, zV, dW);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzu[i10];
    }
}
