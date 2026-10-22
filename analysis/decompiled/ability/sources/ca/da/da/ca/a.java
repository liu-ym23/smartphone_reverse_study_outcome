package ca.da.da.ca;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: ca.da.da.ca.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0133a extends Binder implements a {

        /* renamed from: ca.da.da.ca.a$a$a, reason: collision with other inner class name */
        public static class C0134a implements a {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f2110a;

            public C0134a(IBinder iBinder) {
                this.f2110a = iBinder;
            }

            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.f2110a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2110a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0134a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
