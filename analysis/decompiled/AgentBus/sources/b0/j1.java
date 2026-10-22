package b0;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class j1 implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1203a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1203a) {
            case 0:
                return new k1(parcel.readFloat());
            case 1:
                return new l1(parcel.readInt());
            default:
                return new m1(parcel.readLong());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        switch (this.f1203a) {
            case 0:
                return new k1[i2];
            case 1:
                return new l1[i2];
            default:
                return new m1[i2];
        }
    }
}
