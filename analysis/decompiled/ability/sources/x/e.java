package x;

import android.os.IBinder;
import android.os.Parcel;
import ca.ea.ca.a;

/* loaded from: classes2.dex */
public final class e implements o {
    @Override // x.o
    public final Object a(IBinder iBinder) {
        return a.AbstractBinderC0138a.a(iBinder);
    }

    @Override // x.o
    public final Object b(Object obj) {
        ca.ea.ca.a aVar = (ca.ea.ca.a) obj;
        if (aVar == null) {
            return null;
        }
        a.AbstractBinderC0138a.C0139a c0139a = (a.AbstractBinderC0138a.C0139a) aVar;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            c0139a.f2114a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
