package com.obric.cae.libs.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ISecondaryWifiCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ISecondaryWifiCallback";

    public static class Default implements ISecondaryWifiCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
        public void onAvailable(String r1, int r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
        public void onLost() throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
        public void onSignalStrength(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
        public void onUnavailable() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISecondaryWifiCallback {
        static final int TRANSACTION_onAvailable = 1;
        static final int TRANSACTION_onLost = 2;
        static final int TRANSACTION_onSignalStrength = 4;
        static final int TRANSACTION_onUnavailable = 3;

        public static class Proxy implements ISecondaryWifiCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISecondaryWifiCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
            public void onAvailable(String r4, int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISecondaryWifiCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
            public void onLost() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISecondaryWifiCallback.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
            public void onSignalStrength(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISecondaryWifiCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
            public void onUnavailable() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISecondaryWifiCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, ISecondaryWifiCallback.DESCRIPTOR);
        }

        public static ISecondaryWifiCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ISecondaryWifiCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ISecondaryWifiCallback) == false) goto L12;
            return (ISecondaryWifiCallback) r0;
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
            r5.enforceInterface(ISecondaryWifiCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            switch(r4) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                default: goto L11;
            };
        L12:
            onSignalStrength(r5.readInt());
            r6.writeNoException();
        L16:
            return true;
        L13:
            onUnavailable();
            r6.writeNoException();
            goto L16
        L14:
            onLost();
            r6.writeNoException();
            goto L16
        L15:
            onAvailable(r5.readString(), r5.readInt());
            r6.writeNoException();
            goto L16
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(ISecondaryWifiCallback.DESCRIPTOR);
            return true;
        }
    }

    void onAvailable(String r1, int r2) throws RemoteException;

    void onLost() throws RemoteException;

    void onSignalStrength(int r1) throws RemoteException;

    void onUnavailable() throws RemoteException;
}
