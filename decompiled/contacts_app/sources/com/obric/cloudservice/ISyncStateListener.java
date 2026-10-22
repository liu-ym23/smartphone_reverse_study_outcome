package com.obric.cloudservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ISyncStateListener extends IInterface {

    public static class Default implements ISyncStateListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cloudservice.ISyncStateListener
        public void onCloudServiceIdle() throws RemoteException {
        }

        public Default() {
        }
    }

    public static abstract class Stub extends Binder implements ISyncStateListener {
        private static final String DESCRIPTOR = "com.obric.cloudservice.ISyncStateListener";
        static final int TRANSACTION_onCloudServiceIdle = 1;

        private static class Proxy implements ISyncStateListener {
            public static ISyncStateListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cloudservice.ISyncStateListener
            public void onCloudServiceIdle() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onCloudServiceIdle();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISyncStateListener asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface r0 = obj.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ISyncStateListener) == false) goto L12;
            return (ISyncStateListener) r0;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) goto L5;
            data.enforceInterface(DESCRIPTOR);
            onCloudServiceIdle();
            reply.writeNoException();
            return true;
        L5:
            if (code != 1598968902) goto L7;
            reply.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(code, data, reply, flags);
        }

        public static boolean setDefaultImpl(ISyncStateListener impl) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (impl == null) goto L7;
            Proxy.sDefaultImpl = impl;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ISyncStateListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    void onCloudServiceIdle() throws RemoteException;
}
