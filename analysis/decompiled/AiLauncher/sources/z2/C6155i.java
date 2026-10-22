package z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzan;

/* renamed from: z2.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6155i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        int iA = 0;
        int iA2 = 0;
        int iA3 = 0;
        int iA4 = 0;
        long jB = 0;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 2) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU == 3) {
                iA2 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 4) {
                iA3 = SafeParcelReader.A(parcel, iY);
            } else if (iU == 5) {
                jB = SafeParcelReader.B(parcel, iY);
            } else if (iU != 6) {
                SafeParcelReader.E(parcel, iY);
            } else {
                iA4 = SafeParcelReader.A(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzan(iA, iA2, iA3, jB, iA4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzan[i10];
    }
}
