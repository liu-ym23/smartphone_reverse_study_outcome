package ca.da.da;

import android.os.IBinder;
import android.os.Parcel;
import android.util.Pair;
import ca.da.da.s;
import x.o;

/* loaded from: classes2.dex */
public final class a implements o {
    @Override // x.o
    public final Object a(IBinder iBinder) {
        return s.a.a(iBinder);
    }

    @Override // x.o
    public final Object b(Object obj) {
        s sVar = (s) obj;
        if (sVar == null) {
            return null;
        }
        s.a.C0137a c0137a = (s.a.C0137a) sVar;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            c0137a.f2113a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            parcelObtain = Parcel.obtain();
            parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                c0137a.f2113a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                boolean z10 = parcelObtain2.readInt() != 0;
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return new Pair(string, Boolean.valueOf(z10));
            } finally {
            }
        } finally {
        }
    }
}
