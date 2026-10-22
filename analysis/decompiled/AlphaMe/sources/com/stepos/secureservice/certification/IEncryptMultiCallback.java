package com.stepos.secureservice.certification;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IEncryptMultiCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.secureservice.certification.IEncryptMultiCallback";

    public static class Default implements IEncryptMultiCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
        public void onErrored(String str) throws RemoteException {
        }

        @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
        public void onGet(List<String> list, String str, int i4, int i5, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IEncryptMultiCallback {
        static final int TRANSACTION_onErrored = 2;
        static final int TRANSACTION_onGet = 1;

        public static class Proxy implements IEncryptMultiCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IEncryptMultiCallback.DESCRIPTOR;
            }

            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
            public void onErrored(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IEncryptMultiCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.secureservice.certification.IEncryptMultiCallback
            public void onGet(List<String> list, String str, int i4, int i5, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IEncryptMultiCallback.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IEncryptMultiCallback.DESCRIPTOR);
        }

        public static IEncryptMultiCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IEncryptMultiCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IEncryptMultiCallback)) ? new Proxy(iBinder) : (IEncryptMultiCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(IEncryptMultiCallback.DESCRIPTOR);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(IEncryptMultiCallback.DESCRIPTOR);
                return true;
            }
            if (i4 == 1) {
                onGet(parcel.createStringArrayList(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
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

    void onGet(List<String> list, String str, int i4, int i5, String str2) throws RemoteException;
}
