package com.zyql.screenperception.api;

import Z6.k;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.zyql.screenperception.api.IOCRResultCallback;

/* loaded from: classes2.dex */
public interface IScreenOCR extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.screenperception.api.IScreenOCR";

    public static class Default implements IScreenOCR {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.screenperception.api.IScreenOCR
        public String recognizeCurrentScreen(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IScreenOCR
        public void recognizeCurrentScreenAsync(Bundle bundle, IOCRResultCallback iOCRResultCallback) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IScreenOCR
        public String recognizeImage(Bitmap bitmap) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IScreenOCR
        public void recognizeImageAsync(Bitmap bitmap, IOCRResultCallback iOCRResultCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IScreenOCR {
        static final int TRANSACTION_recognizeCurrentScreen = 2;
        static final int TRANSACTION_recognizeCurrentScreenAsync = 4;
        static final int TRANSACTION_recognizeImage = 1;
        static final int TRANSACTION_recognizeImageAsync = 3;

        public static class Proxy implements IScreenOCR {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IScreenOCR.DESCRIPTOR;
            }

            @Override // com.zyql.screenperception.api.IScreenOCR
            public String recognizeCurrentScreen(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOCR.DESCRIPTOR);
                    k.a(parcelObtain, bundle);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IScreenOCR
            public void recognizeCurrentScreenAsync(Bundle bundle, IOCRResultCallback iOCRResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOCR.DESCRIPTOR);
                    k.a(parcelObtain, bundle);
                    parcelObtain.writeStrongInterface(iOCRResultCallback);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IScreenOCR
            public String recognizeImage(Bitmap bitmap) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOCR.DESCRIPTOR);
                    k.a(parcelObtain, bitmap);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IScreenOCR
            public void recognizeImageAsync(Bitmap bitmap, IOCRResultCallback iOCRResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenOCR.DESCRIPTOR);
                    k.a(parcelObtain, bitmap);
                    parcelObtain.writeStrongInterface(iOCRResultCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IScreenOCR.DESCRIPTOR);
        }

        public static IScreenOCR asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IScreenOCR.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IScreenOCR)) ? new Proxy(iBinder) : (IScreenOCR) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IScreenOCR.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IScreenOCR.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String strRecognizeImage = recognizeImage((Bitmap) (parcel.readInt() != 0 ? Bitmap.CREATOR.createFromParcel(parcel) : null));
                parcel2.writeNoException();
                parcel2.writeString(strRecognizeImage);
                return true;
            }
            if (i == 2) {
                String strRecognizeCurrentScreen = recognizeCurrentScreen((Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
                parcel2.writeNoException();
                parcel2.writeString(strRecognizeCurrentScreen);
                return true;
            }
            if (i == 3) {
                recognizeImageAsync((Bitmap) (parcel.readInt() != 0 ? Bitmap.CREATOR.createFromParcel(parcel) : null), IOCRResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 4) {
                return super.onTransact(i, parcel, parcel2, i6);
            }
            recognizeCurrentScreenAsync((Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null), IOCRResultCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    String recognizeCurrentScreen(Bundle bundle) throws RemoteException;

    void recognizeCurrentScreenAsync(Bundle bundle, IOCRResultCallback iOCRResultCallback) throws RemoteException;

    String recognizeImage(Bitmap bitmap) throws RemoteException;

    void recognizeImageAsync(Bitmap bitmap, IOCRResultCallback iOCRResultCallback) throws RemoteException;
}
