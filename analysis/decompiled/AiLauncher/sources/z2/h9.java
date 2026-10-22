package z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyu;

/* loaded from: classes2.dex */
public final class h9 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        long jB = 0;
        int iA = 0;
        int iA2 = 0;
        int iA3 = 0;
        int iA4 = 0;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 2) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 3) {
                iA3 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 4) {
                iA4 = SafeParcelReader.A(parcel, iY);
            } else if (iU != 5) {
                SafeParcelReader.E(parcel, iY);
            } else {
                jB = SafeParcelReader.B(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzyu(iA, iA2, iA3, iA4, jB);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzyu[i10];
    }
}
