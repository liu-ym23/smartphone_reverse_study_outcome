package com.obric.cae.libs.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IBleAlwaysOn extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.IBleAlwaysOn";

    public static class Default implements IBleAlwaysOn {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
        public void registerEventCallback(IBleAlwaysOnCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
        public void setCaeWakeLockState(boolean r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
        public void unregisterEventCallback(IBleAlwaysOnCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IBleAlwaysOn {
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_setCaeWakeLockState = 3;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements IBleAlwaysOn {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBleAlwaysOn.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
            public void registerEventCallback(IBleAlwaysOnCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBleAlwaysOn.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
            public void setCaeWakeLockState(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBleAlwaysOn.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.bluetooth.IBleAlwaysOn
            public void unregisterEventCallback(IBleAlwaysOnCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(IBleAlwaysOn.DESCRIPTOR);     // Catch: Throwable -> L6
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
            attachInterface(this, IBleAlwaysOn.DESCRIPTOR);
        }

        public static IBleAlwaysOn asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(IBleAlwaysOn.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IBleAlwaysOn) == false) goto L12;
            return (IBleAlwaysOn) r0;
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
            r5.enforceInterface(IBleAlwaysOn.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L24;
            if (r4 != 1) goto L11;
            registerEventCallback(IBleAlwaysOnCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
        L23:
            return true;
        L11:
            if (r4 != 2) goto L13;
            unregisterEventCallback(IBleAlwaysOnCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L23
        L13:
            if (r4 == 3) goto L17;
            return super.onTransact(r4, r5, r6, r7);
        L17:
            if (r5.readInt() == 0) goto L19;
            boolean r8 = true;
        L20:
            setCaeWakeLockState(r8);
            r6.writeNoException();
            goto L23
        L19:
            r8 = false;
            goto L20
        L24:
            r6.writeString(IBleAlwaysOn.DESCRIPTOR);
            return true;
        }
    }

    void registerEventCallback(IBleAlwaysOnCallback r1) throws RemoteException;

    void setCaeWakeLockState(boolean r1) throws RemoteException;

    void unregisterEventCallback(IBleAlwaysOnCallback r1) throws RemoteException;
}
