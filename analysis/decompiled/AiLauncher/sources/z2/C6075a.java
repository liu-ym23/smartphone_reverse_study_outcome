package z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzn;

/* renamed from: z2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6075a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        String strO = null;
        String strO2 = null;
        int iA = 0;
        String strO3 = null;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 2) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 3) {
                strO = SafeParcelReader.o(parcel, iY);
            } else if (iU == 4) {
                strO3 = SafeParcelReader.o(parcel, iY);
            } else if (iU != 5) {
                SafeParcelReader.E(parcel, iY);
            } else {
                strO2 = SafeParcelReader.o(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzn(iA, strO, strO3, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzn[i10];
    }
}
