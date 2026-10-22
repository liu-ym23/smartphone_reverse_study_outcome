package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ITaskStateChangeCallback extends IInterface {

    public static class Default implements ITaskStateChangeCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ITaskStateChangeCallback
        public void onError(int r10, String r11) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ITaskStateChangeCallback
        public void onSuccess() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITaskStateChangeCallback {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ITaskStateChangeCallback";
        public static final int TRANSACTION_onError = 2;
        public static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements ITaskStateChangeCallback {
            public static ITaskStateChangeCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ITaskStateChangeCallback
            public void onError(int r10, String r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                r12.writeString(r11);     // Catch: Throwable -> L10
                if (this.mRemote.transact(2, r12, r13, 0) == false) goto L6;
            L12:
                r13.readException();     // Catch: Throwable -> L10
            L8:
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().onError(r10, r11);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ITaskStateChangeCallback
            public void onSuccess() throws RemoteException {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L6;
            L12:
                r11.readException();     // Catch: Throwable -> L10
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().onSuccess();     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITaskStateChangeCallback asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof ITaskStateChangeCallback) == false) goto L12;
            return (ITaskStateChangeCallback) r11;
        L12:
            return new Proxy(r10);
        }

        public static ITaskStateChangeCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITaskStateChangeCallback r10) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r10 == null) goto L9;
            Proxy.sDefaultImpl = r10;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
            if (r10 != 1) goto L5;
            r11.enforceInterface(DESCRIPTOR);
            onSuccess();
        L13:
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            onError(r11.readInt(), r11.readString());
            goto L13
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void onError(int r10, String r11) throws RemoteException;

    void onSuccess() throws RemoteException;
}
