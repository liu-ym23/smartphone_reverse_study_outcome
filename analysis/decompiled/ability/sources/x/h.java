package x;

import android.os.IBinder;
import android.os.Parcel;
import ca.da.da.ca.b;

/* loaded from: classes2.dex */
public final class h implements o {
    @Override // x.o
    public final Object a(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    @Override // x.o
    public final Object b(Object obj) {
        ca.da.da.ca.b bVar = (ca.da.da.ca.b) obj;
        if (bVar == null) {
            return null;
        }
        b.a.C0135a c0135a = (b.a.C0135a) bVar;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
            c0135a.f2111a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
