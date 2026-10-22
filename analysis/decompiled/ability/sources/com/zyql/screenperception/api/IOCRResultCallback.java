package com.zyql.screenperception.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IOCRResultCallback extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.screenperception.api.IOCRResultCallback";

    public static class Default implements IOCRResultCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.screenperception.api.IOCRResultCallback
        public void onError(int i, String str) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IOCRResultCallback
        public void onProgress(int i, String str) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IOCRResultCallback
        public void onSuccess(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOCRResultCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onProgress = 3;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IOCRResultCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOCRResultCallback.DESCRIPTOR;
            }

            @Override // com.zyql.screenperception.api.IOCRResultCallback
            public void onError(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRResultCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IOCRResultCallback
            public void onProgress(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRResultCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IOCRResultCallback
            public void onSuccess(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOCRResultCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IOCRResultCallback.DESCRIPTOR);
        }

        public static IOCRResultCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IOCRResultCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOCRResultCallback)) ? new Proxy(iBinder) : (IOCRResultCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOCRResultCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOCRResultCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess(parcel.readString());
                parcel2.writeNoException();
            } else if (i == 2) {
                onError(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                onProgress(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onError(int i, String str) throws RemoteException;

    void onProgress(int i, String str) throws RemoteException;

    void onSuccess(String str) throws RemoteException;
}
