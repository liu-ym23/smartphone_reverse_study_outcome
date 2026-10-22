package com.obric.cae.libs.cloud;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICloud extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.cloud.ICloud";

    public static class Default implements ICloud {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void postToCloud(String r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallback(ICloudEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallbackWithType(int r1, ICloudEventCallback r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void unregisterCallback(ICloudEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void updateUserConfigData(int r1, String r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICloud {
        static final int TRANSACTION_postToCloud = 4;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerCallbackWithType = 2;
        static final int TRANSACTION_unregisterCallback = 3;
        static final int TRANSACTION_updateUserConfigData = 5;

        public static class Proxy implements ICloud {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICloud.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.cloud.ICloud
            public void postToCloud(String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICloud.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void registerCallback(ICloudEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICloud.DESCRIPTOR);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void registerCallbackWithType(int r4, ICloudEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICloud.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void unregisterCallback(ICloudEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICloud.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void updateUserConfigData(int r4, String r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICloud.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeString(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
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
            attachInterface(this, ICloud.DESCRIPTOR);
        }

        public static ICloud asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICloud.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICloud) == false) goto L12;
            return (ICloud) r0;
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
            r5.enforceInterface(ICloud.DESCRIPTOR);
        L8:
            if (r4 == 1598968902) goto L18;
            switch(r4) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                default: goto L11;
            };
        L12:
            updateUserConfigData(r5.readInt(), r5.readString());
            r6.writeNoException();
        L17:
            return true;
        L13:
            postToCloud(r5.readString());
            r6.writeNoException();
            goto L17
        L14:
            unregisterCallback(ICloudEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L17
        L15:
            registerCallbackWithType(r5.readInt(), ICloudEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L17
        L16:
            registerCallback(ICloudEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            goto L17
        L11:
            return super.onTransact(r4, r5, r6, r7);
        L18:
            r6.writeString(ICloud.DESCRIPTOR);
            return true;
        }
    }

    void postToCloud(String r1) throws RemoteException;

    void registerCallback(ICloudEventCallback r1) throws RemoteException;

    void registerCallbackWithType(int r1, ICloudEventCallback r2) throws RemoteException;

    void unregisterCallback(ICloudEventCallback r1) throws RemoteException;

    void updateUserConfigData(int r1, String r2) throws RemoteException;
}
