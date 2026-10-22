package com.stepos.core.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface ISessionCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.callback.ISessionCallback";

    public static class Default implements ISessionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.callback.ISessionCallback
        public void onSessionClosed(String str) throws RemoteException {
        }

        @Override // com.stepos.core.callback.ISessionCallback
        public void onSessionCreated(String str) throws RemoteException {
        }

        @Override // com.stepos.core.callback.ISessionCallback
        public void onSessionError(String str, int i10, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISessionCallback {
        static final int TRANSACTION_onSessionClosed = 2;
        static final int TRANSACTION_onSessionCreated = 1;
        static final int TRANSACTION_onSessionError = 3;

        public static class Proxy implements ISessionCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISessionCallback.DESCRIPTOR;
            }

            @Override // com.stepos.core.callback.ISessionCallback
            public void onSessionClosed(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISessionCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.callback.ISessionCallback
            public void onSessionCreated(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISessionCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.callback.ISessionCallback
            public void onSessionError(String str, int i10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISessionCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISessionCallback.DESCRIPTOR);
        }

        public static ISessionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISessionCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISessionCallback)) ? new Proxy(iBinder) : (ISessionCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ISessionCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ISessionCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onSessionCreated(parcel.readString());
                parcel2.writeNoException();
            } else if (i10 == 2) {
                onSessionClosed(parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onSessionError(parcel.readString(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onSessionClosed(String str) throws RemoteException;

    void onSessionCreated(String str) throws RemoteException;

    void onSessionError(String str, int i10, String str2) throws RemoteException;
}
