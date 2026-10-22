package x;

import android.os.IBinder;
import android.os.Parcel;
import ca.da.da.ca.c;

/* renamed from: x.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2111a implements o {
    @Override // x.o
    public final Object a(IBinder iBinder) {
        return c.a.a(iBinder);
    }

    @Override // x.o
    public final Object b(Object obj) {
        ca.da.da.ca.c cVar = (ca.da.da.ca.c) obj;
        if (cVar == null) {
            return null;
        }
        c.a.C0136a c0136a = (c.a.C0136a) cVar;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            c0136a.f2112a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
