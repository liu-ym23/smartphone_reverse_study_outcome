package com.zyql.screenperception.api;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IImageCaptureCallback extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.screenperception.api.IImageCaptureCallback";

    public static class Default implements IImageCaptureCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.screenperception.api.IImageCaptureCallback
        public void onError(int i, String str) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IImageCaptureCallback
        public void onSuccess(Uri uri) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IImageCaptureCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IImageCaptureCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImageCaptureCallback.DESCRIPTOR;
            }

            @Override // com.zyql.screenperception.api.IImageCaptureCallback
            public void onError(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageCaptureCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IImageCaptureCallback
            public void onSuccess(Uri uri) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageCaptureCallback.DESCRIPTOR);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IImageCaptureCallback.DESCRIPTOR);
        }

        public static IImageCaptureCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IImageCaptureCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IImageCaptureCallback)) ? new Proxy(iBinder) : (IImageCaptureCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IImageCaptureCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IImageCaptureCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess((Uri) (parcel.readInt() != 0 ? Uri.CREATOR.createFromParcel(parcel) : null));
                parcel2.writeNoException();
            } else {
                if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                onError(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onError(int i, String str) throws RemoteException;

    void onSuccess(Uri uri) throws RemoteException;
}
