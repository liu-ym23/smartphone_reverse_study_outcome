package com.stepos.secureservice.certification;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISafeRSASignCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.certification.ISafeRSASignCallback";

    public static class Default implements ISafeRSASignCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.certification.ISafeRSASignCallback
        public void onErrored(String str) throws RemoteException {
        }

        @Override // com.stepos.secureservice.certification.ISafeRSASignCallback
        public void onGet(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISafeRSASignCallback {
        static final int TRANSACTION_onErrored = 2;
        static final int TRANSACTION_onGet = 1;

        public static class Proxy implements ISafeRSASignCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISafeRSASignCallback.DESCRIPTOR;
            }

            @Override // com.stepos.secureservice.certification.ISafeRSASignCallback
            public void onErrored(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeRSASignCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.certification.ISafeRSASignCallback
            public void onGet(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeRSASignCallback.DESCRIPTOR);
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
            attachInterface(this, ISafeRSASignCallback.DESCRIPTOR);
        }

        public static ISafeRSASignCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISafeRSASignCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISafeRSASignCallback)) ? new Proxy(iBinder) : (ISafeRSASignCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(ISafeRSASignCallback.DESCRIPTOR);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(ISafeRSASignCallback.DESCRIPTOR);
                return true;
            }
            if (i4 == 1) {
                onGet(parcel.readString());
            } else {
                if (i4 != 2) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                onErrored(parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onErrored(String str) throws RemoteException;

    void onGet(String str) throws RemoteException;
}
