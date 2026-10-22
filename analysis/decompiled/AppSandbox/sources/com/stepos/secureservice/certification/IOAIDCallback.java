package com.stepos.secureservice.certification;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOAIDCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.certification.IOAIDCallback";

    public static class Default implements IOAIDCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.certification.IOAIDCallback
        public void onErrored(String str) throws RemoteException {
        }

        @Override // com.stepos.secureservice.certification.IOAIDCallback
        public void onGet(String str, String str2, int i, int i2, String str3) throws RemoteException {
        }
    }

    void onErrored(String str) throws RemoteException;

    void onGet(String str, String str2, int i, int i2, String str3) throws RemoteException;

    public static abstract class Stub extends Binder implements IOAIDCallback {
        static final int TRANSACTION_onErrored = 2;
        static final int TRANSACTION_onGet = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IOAIDCallback.DESCRIPTOR);
        }

        public static IOAIDCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IOAIDCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IOAIDCallback)) {
                return (IOAIDCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOAIDCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOAIDCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String string = parcel.readString();
                String string2 = parcel.readString();
                int i3 = parcel.readInt();
                int i4 = parcel.readInt();
                String string3 = parcel.readString();
                parcel.enforceNoDataAvail();
                onGet(string, string2, i3, i4, string3);
                parcel2.writeNoException();
            } else if (i == 2) {
                String string4 = parcel.readString();
                parcel.enforceNoDataAvail();
                onErrored(string4);
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        private static class Proxy implements IOAIDCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOAIDCallback.DESCRIPTOR;
            }

            @Override // com.stepos.secureservice.certification.IOAIDCallback
            public void onGet(String str, String str2, int i, int i2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOAIDCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.certification.IOAIDCallback
            public void onErrored(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOAIDCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
