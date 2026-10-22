package com.zyql.screenperception.api;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IFusionCallback extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.screenperception.api.IFusionCallback";

    public static class Default implements IFusionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.screenperception.api.IFusionCallback
        public void onError(int i, String str) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IFusionCallback
        public void onImageResult(Bitmap bitmap) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IFusionCallback
        public void onResult(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFusionCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onImageResult = 3;
        static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IFusionCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFusionCallback.DESCRIPTOR;
            }

            @Override // com.zyql.screenperception.api.IFusionCallback
            public void onError(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFusionCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IFusionCallback
            public void onImageResult(Bitmap bitmap) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFusionCallback.DESCRIPTOR);
                    if (bitmap != null) {
                        parcelObtain.writeInt(1);
                        bitmap.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IFusionCallback
            public void onResult(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFusionCallback.DESCRIPTOR);
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
            attachInterface(this, IFusionCallback.DESCRIPTOR);
        }

        public static IFusionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IFusionCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IFusionCallback)) ? new Proxy(iBinder) : (IFusionCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFusionCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IFusionCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onResult(parcel.readString());
                parcel2.writeNoException();
            } else if (i == 2) {
                onError(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                onImageResult((Bitmap) (parcel.readInt() != 0 ? Bitmap.CREATOR.createFromParcel(parcel) : null));
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onError(int i, String str) throws RemoteException;

    void onImageResult(Bitmap bitmap) throws RemoteException;

    void onResult(String str) throws RemoteException;
}
