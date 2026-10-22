package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IGetRunningTaskCallback extends IInterface {

    public static class Default implements IGetRunningTaskCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.IGetRunningTaskCallback
        public void onResult(String r10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGetRunningTaskCallback {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.IGetRunningTaskCallback";
        public static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IGetRunningTaskCallback {
            public static IGetRunningTaskCallback sDefaultImpl;
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

            @Override // com.obric.capabilitykit.common.IGetRunningTaskCallback
            public void onResult(String r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r11.writeString(r10);     // Catch: Throwable -> L10
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L6;
            L12:
                r12.readException();     // Catch: Throwable -> L10
            L8:
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L12;
                Stub.getDefaultImpl().onResult(r10);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGetRunningTaskCallback asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IGetRunningTaskCallback) == false) goto L12;
            return (IGetRunningTaskCallback) r11;
        L12:
            return new Proxy(r10);
        }

        public static IGetRunningTaskCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IGetRunningTaskCallback r10) {
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
            onResult(r11.readString());
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void onResult(String r10) throws RemoteException;
}
