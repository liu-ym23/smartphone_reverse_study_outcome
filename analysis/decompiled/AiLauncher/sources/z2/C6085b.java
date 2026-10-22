package z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzo;

/* renamed from: z2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6085b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iF = SafeParcelReader.F(parcel);
        double dW = 0.0d;
        double dW2 = 0.0d;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 2) {
                dW = SafeParcelReader.w(parcel, iY);
            } else if (iU != 3) {
                SafeParcelReader.E(parcel, iY);
            } else {
                dW2 = SafeParcelReader.w(parcel, iY);
            }
        }
        SafeParcelReader.t(parcel, iF);
        return new zzo(dW, dW2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzo[i10];
    }
}
