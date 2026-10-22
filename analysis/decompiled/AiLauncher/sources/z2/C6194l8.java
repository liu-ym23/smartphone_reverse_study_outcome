package z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzj;

/* renamed from: z2.l8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6194l8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        String strO = null;
        int iA = 0;
        int iA2 = 0;
        int iA3 = 0;
        int iA4 = 0;
        int iA5 = 0;
        int iA6 = 0;
        boolean zV = false;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 2:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 3:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 4:
                    iA3 = SafeParcelReader.A(parcel, iY);
                    break;
                case 5:
                    iA4 = SafeParcelReader.A(parcel, iY);
                    break;
                case 6:
                    iA5 = SafeParcelReader.A(parcel, iY);
                    break;
                case 7:
                    iA6 = SafeParcelReader.A(parcel, iY);
                    break;
                case 8:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 9:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                default:
                    SafeParcelReader.E(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzj(iA, iA2, iA3, iA4, iA5, iA6, zV, strO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzj[i10];
    }
}
