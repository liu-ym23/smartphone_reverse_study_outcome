package com.obric.cae.libs.location;

import android.location.Address;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IStarLocationCityCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.location.IStarLocationCityCallback";

    public static class Default implements IStarLocationCityCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationCityCallback
        public void onCityChanged(Address r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarLocationCityCallback {
        static final int TRANSACTION_onCityChanged = 1;

        public static class Proxy implements IStarLocationCityCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStarLocationCityCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.IStarLocationCityCallback
            public void onCityChanged(Address r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(IStarLocationCityCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IStarLocationCityCallback.DESCRIPTOR);
        }

        public static IStarLocationCityCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IStarLocationCityCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IStarLocationCityCallback) == false) goto L12;
            return (IStarLocationCityCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 < 1) goto L8;
            if (r4 > 16777215) goto L8;
            r5.enforceInterface(IStarLocationCityCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L14;
            if (r4 != 1) goto L11;
            onCityChanged((Address) _Parcel.a(r5, Address.CREATOR));
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L14:
            r6.writeString(IStarLocationCityCallback.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static Object a(Parcel r1, Parcelable.Creator r2) {
            if (r1.readInt() != 0) goto L7;
            return null;
        L7:
            return r2.createFromParcel(r1);
        }
    }

    void onCityChanged(Address r1) throws RemoteException;
}
