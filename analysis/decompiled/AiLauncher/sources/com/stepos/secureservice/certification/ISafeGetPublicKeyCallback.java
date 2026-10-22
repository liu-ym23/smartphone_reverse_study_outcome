package com.stepos.secureservice.certification;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISafeGetPublicKeyCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.certification.ISafeGetPublicKeyCallback";

    public static class Default implements ISafeGetPublicKeyCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.certification.ISafeGetPublicKeyCallback
        public void onErrored(String str) throws RemoteException {
        }

        @Override // com.stepos.secureservice.certification.ISafeGetPublicKeyCallback
        public void onGet(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISafeGetPublicKeyCallback {
        static final int TRANSACTION_onErrored = 2;
        static final int TRANSACTION_onGet = 1;

        public static class Proxy implements ISafeGetPublicKeyCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISafeGetPublicKeyCallback.DESCRIPTOR;
            }

            @Override // com.stepos.secureservice.certification.ISafeGetPublicKeyCallback
            public void onErrored(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeGetPublicKeyCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.certification.ISafeGetPublicKeyCallback
            public void onGet(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISafeGetPublicKeyCallback.DESCRIPTOR);
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
            attachInterface(this, ISafeGetPublicKeyCallback.DESCRIPTOR);
        }

        public static ISafeGetPublicKeyCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISafeGetPublicKeyCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISafeGetPublicKeyCallback)) ? new Proxy(iBinder) : (ISafeGetPublicKeyCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ISafeGetPublicKeyCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ISafeGetPublicKeyCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onGet(parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onErrored(parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onErrored(String str) throws RemoteException;

    void onGet(String str) throws RemoteException;
}
