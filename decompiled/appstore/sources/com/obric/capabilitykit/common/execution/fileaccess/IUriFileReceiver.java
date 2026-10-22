package com.obric.capabilitykit.common.execution.fileaccess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IUriFileReceiver extends IInterface {

    public static class Default implements IUriFileReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver
        public void onSessionReady(UriFileAccessSession r10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUriFileReceiver {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver";
        public static final int TRANSACTION_onSessionReady = 1;

        public static class Proxy implements IUriFileReceiver {
            public static IUriFileReceiver sDefaultImpl;
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

            @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver
            public void onSessionReady(UriFileAccessSession r10) throws RemoteException {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r10 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L10:
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L12;
            L16:
                r12.readException();     // Catch: Throwable -> L6
            L14:
                r12.recycle();
                r11.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().onSessionReady(r10);     // Catch: Throwable -> L6
                goto L14
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUriFileReceiver asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IUriFileReceiver) == false) goto L12;
            return (IUriFileReceiver) r11;
        L12:
            return new Proxy(r10);
        }

        public static IUriFileReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IUriFileReceiver r10) {
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
            if (r11.readInt() == 0) goto L13;
            UriFileAccessSession r14 = UriFileAccessSession.CREATOR.createFromParcel(r11);
        L14:
            onSessionReady(r14);
            r12.writeNoException();
            return true;
        L13:
            r14 = null;
            goto L14
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void onSessionReady(UriFileAccessSession r10) throws RemoteException;
}
