package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IErrorCodeCallback extends IInterface {

    public static class Default implements IErrorCodeCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.IErrorCodeCallback
        public void onResult(int r10, String r11) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.IErrorCodeCallback
        public void onResultBundled(Bundle r10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IErrorCodeCallback {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.IErrorCodeCallback";
        public static final int TRANSACTION_onResult = 1;
        public static final int TRANSACTION_onResultBundled = 2;

        public static class Proxy implements IErrorCodeCallback {
            public static IErrorCodeCallback sDefaultImpl;
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

            @Override // com.obric.capabilitykit.common.IErrorCodeCallback
            public void onResult(int r10, String r11) throws RemoteException {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r12.writeInt(r10);     // Catch: Throwable -> L10
                r12.writeString(r11);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r12, null, 1) == false) goto L6;
            L12:
                r12.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().onResult(r10, r11);     // Catch: Throwable -> L10
                r12.recycle();
                return;
            L10:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.IErrorCodeCallback
            public void onResultBundled(Bundle r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L10:
                if (this.mRemote.transact(2, r11, null, 1) == false) goto L12;
            L16:
                r11.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().onResultBundled(r10);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IErrorCodeCallback asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IErrorCodeCallback) == false) goto L12;
            return (IErrorCodeCallback) r11;
        L12:
            return new Proxy(r10);
        }

        public static IErrorCodeCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IErrorCodeCallback r10) {
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
            onResult(r11.readInt(), r11.readString());
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L15;
            Bundle r14 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L16:
            onResultBundled(r14);
            return true;
        L15:
            r14 = null;
            goto L16
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void onResult(int r10, String r11) throws RemoteException;

    void onResultBundled(Bundle r10) throws RemoteException;
}
