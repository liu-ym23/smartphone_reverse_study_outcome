package com.obric.cae.libs.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ISmartBluetoothEventCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback";

    public static class Default implements ISmartBluetoothEventCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback
        public void onEBikeAware(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback
        public void onEventReported(SmartBluetoothEvent r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISmartBluetoothEventCallback {
        static final int TRANSACTION_onEBikeAware = 2;
        static final int TRANSACTION_onEventReported = 1;

        public static class Proxy implements ISmartBluetoothEventCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISmartBluetoothEventCallback.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback
            public void onEBikeAware(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISmartBluetoothEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback
            public void onEventReported(SmartBluetoothEvent r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ISmartBluetoothEventCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ISmartBluetoothEventCallback.DESCRIPTOR);
        }

        public static ISmartBluetoothEventCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ISmartBluetoothEventCallback.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ISmartBluetoothEventCallback) == false) goto L12;
            return (ISmartBluetoothEventCallback) r0;
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
            r5.enforceInterface(ISmartBluetoothEventCallback.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L17;
            if (r4 != 1) goto L11;
            onEventReported((SmartBluetoothEvent) _Parcel.a(r5, SmartBluetoothEvent.CREATOR));
            r6.writeNoException();
        L16:
            return true;
        L11:
            if (r4 != 2) goto L13;
            onEBikeAware(r5.readInt());
            r6.writeNoException();
            goto L16
        L13:
            return super.onTransact(r4, r5, r6, r7);
        L17:
            r6.writeString(ISmartBluetoothEventCallback.DESCRIPTOR);
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

    void onEBikeAware(int r1) throws RemoteException;

    void onEventReported(SmartBluetoothEvent r1) throws RemoteException;
}
