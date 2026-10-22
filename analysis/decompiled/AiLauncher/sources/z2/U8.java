package z2;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxy;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzya;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyb;

/* loaded from: classes2.dex */
public final class U8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        String strO = null;
        String strO2 = null;
        byte[] bArrG = null;
        Point[] pointArr = null;
        zzxu zzxuVar = null;
        zzxx zzxxVar = null;
        zzxy zzxyVar = null;
        zzya zzyaVar = null;
        zzxz zzxzVar = null;
        zzxv zzxvVar = null;
        zzxr zzxrVar = null;
        zzxs zzxsVar = null;
        zzxt zzxtVar = null;
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
                    zzxuVar = (zzxu) SafeParcelReader.n(parcel, iY, zzxu.CREATOR);
                    break;
                case 8:
                    zzxxVar = (zzxx) SafeParcelReader.n(parcel, iY, zzxx.CREATOR);
                    break;
                case 9:
                    zzxyVar = (zzxy) SafeParcelReader.n(parcel, iY, zzxy.CREATOR);
                    break;
                case 10:
                    zzyaVar = (zzya) SafeParcelReader.n(parcel, iY, zzya.CREATOR);
                    break;
                case 11:
                    zzxzVar = (zzxz) SafeParcelReader.n(parcel, iY, zzxz.CREATOR);
                    break;
                case 12:
                    zzxvVar = (zzxv) SafeParcelReader.n(parcel, iY, zzxv.CREATOR);
                    break;
                case 13:
                    zzxrVar = (zzxr) SafeParcelReader.n(parcel, iY, zzxr.CREATOR);
                    break;
                case 14:
                    zzxsVar = (zzxs) SafeParcelReader.n(parcel, iY, zzxs.CREATOR);
                    break;
                case 15:
                    zzxtVar = (zzxt) SafeParcelReader.n(parcel, iY, zzxt.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzyb(iA, strO, strO2, bArrG, pointArr, iA2, zzxuVar, zzxxVar, zzxyVar, zzyaVar, zzxzVar, zzxvVar, zzxrVar, zzxsVar, zzxtVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzyb[i10];
    }
}
