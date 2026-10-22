package com.android.server.profcollect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IProviderStatusCallback extends IInterface {
    public static final String DESCRIPTOR = "com.android.server.profcollect.IProviderStatusCallback";

    public static class Default implements IProviderStatusCallback {
        public Default() {
        }

        @Override // com.android.server.profcollect.IProviderStatusCallback
        public void onProviderReady() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IProviderStatusCallback {
        static final int TRANSACTION_onProviderReady = 1;

        private static class Proxy implements IProviderStatusCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IProviderStatusCallback.DESCRIPTOR;
            }

            @Override // com.android.server.profcollect.IProviderStatusCallback
            public void onProviderReady() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IProviderStatusCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L6
                _data.recycle();
                return;
            L6:
                th = move-exception;
                _data.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IProviderStatusCallback.DESCRIPTOR);
        }

        public static IProviderStatusCallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IProviderStatusCallback.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IProviderStatusCallback) == false) goto L12;
            return (IProviderStatusCallback) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code < 1) goto L8;
            if (code > 16777215) goto L8;
            data.enforceInterface(IProviderStatusCallback.DESCRIPTOR);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(IProviderStatusCallback.DESCRIPTOR);
            return true;
        L11:
            switch(code) {
                case 1: goto L14;
                default: goto L13;
            };
        L14:
            onProviderReady();
            return true;
        L13:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void onProviderReady() throws RemoteException;
}
