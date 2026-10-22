package com.obric.cae.libs.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeNetworkHandoverManager extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.network.ICaeNetworkHandoverManager";

    public static class Default implements ICaeNetworkHandoverManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
        public void registerNetworkHandoverListener(ICaeNetworkHandoverListener r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
        public void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNetworkHandoverManager {
        static final int TRANSACTION_registerNetworkHandoverListener = 1;
        static final int TRANSACTION_unregisterNetworkHandoverListener = 2;

        public static class Proxy implements ICaeNetworkHandoverManager {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICaeNetworkHandoverManager.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
            public void registerNetworkHandoverListener(ICaeNetworkHandoverListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNetworkHandoverManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
            public void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeNetworkHandoverManager.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeNetworkHandoverManager.DESCRIPTOR);
        }

        public static ICaeNetworkHandoverManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeNetworkHandoverManager.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeNetworkHandoverManager) == false) goto L12;
            return (ICaeNetworkHandoverManager) r0;
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
            r5.enforceInterface(ICaeNetworkHandoverManager.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            if (r4 != 1) goto L11;
            registerNetworkHandoverListener(ICaeNetworkHandoverListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
        L16:
            return true;
        L11:
            if (r4 != 2) goto L13;
            unregisterNetworkHandoverListener(ICaeNetworkHandoverListener.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(ICaeNetworkHandoverManager.DESCRIPTOR);
            return true;
        }
    }

    void registerNetworkHandoverListener(ICaeNetworkHandoverListener r1) throws RemoteException;

    void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r1) throws RemoteException;
}
