package z2;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: z2.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6255s {
    static {
        C6255s.class.getClassLoader();
    }

    public static void a(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void b(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
