package com.migu.music.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IMusicIpcInitCallback extends IInterface {

    public static class Default implements IMusicIpcInitCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.migu.music.ipc.IMusicIpcInitCallback
        public void onMusicIpcInitialized() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMusicIpcInitCallback {
        private static final String DESCRIPTOR = "com.migu.music.ipc.IMusicIpcInitCallback";
        static final int TRANSACTION_onMusicIpcInitialized = 1;

        public static class Proxy implements IMusicIpcInitCallback {
            public static IMusicIpcInitCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.migu.music.ipc.IMusicIpcInitCallback
            public void onMusicIpcInitialized() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onMusicIpcInitialized();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMusicIpcInitCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMusicIpcInitCallback)) ? new Proxy(iBinder) : (IMusicIpcInitCallback) iInterfaceQueryLocalInterface;
        }

        public static IMusicIpcInitCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMusicIpcInitCallback iMusicIpcInitCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMusicIpcInitCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMusicIpcInitCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onMusicIpcInitialized();
            parcel2.writeNoException();
            return true;
        }
    }

    void onMusicIpcInitialized() throws RemoteException;
}
