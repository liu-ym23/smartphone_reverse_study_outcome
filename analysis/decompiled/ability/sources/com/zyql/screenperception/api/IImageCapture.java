package com.zyql.screenperception.api;

import U7.a;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.zyql.screenperception.api.IImageCaptureCallback;

/* loaded from: classes2.dex */
public interface IImageCapture extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.screenperception.api.IImageCapture";

    public static class Default implements IImageCapture {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.screenperception.api.IImageCapture
        public Bitmap captureRegion(int i, int i6, int i10, int i11) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IImageCapture
        public void captureRegionAsync(int i, int i6, int i10, int i11, IImageCaptureCallback iImageCaptureCallback) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IImageCapture
        public Uri captureRegionToFile(int i, int i6, int i10, int i11) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IImageCapture
        public Uri captureScreen(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IImageCapture
        public void captureScreenAsync(Bundle bundle, IImageCaptureCallback iImageCaptureCallback) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IImageCapture
        public Uri captureScreenToFile(Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImageCapture {
        static final int TRANSACTION_captureRegion = 2;
        static final int TRANSACTION_captureRegionAsync = 6;
        static final int TRANSACTION_captureRegionToFile = 4;
        static final int TRANSACTION_captureScreen = 1;
        static final int TRANSACTION_captureScreenAsync = 5;
        static final int TRANSACTION_captureScreenToFile = 3;

        public static class Proxy implements IImageCapture {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zyql.screenperception.api.IImageCapture
            public Bitmap captureRegion(int i, int i6, int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageCapture.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i6);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bitmap) a.a(parcelObtain2, Bitmap.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IImageCapture
            public void captureRegionAsync(int i, int i6, int i10, int i11, IImageCaptureCallback iImageCaptureCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageCapture.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i6);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeStrongInterface(iImageCaptureCallback);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IImageCapture
            public Uri captureRegionToFile(int i, int i6, int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageCapture.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i6);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Uri) a.a(parcelObtain2, Uri.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IImageCapture
            public Uri captureScreen(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageCapture.DESCRIPTOR);
                    a.b(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Uri) a.a(parcelObtain2, Uri.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IImageCapture
            public void captureScreenAsync(Bundle bundle, IImageCaptureCallback iImageCaptureCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageCapture.DESCRIPTOR);
                    a.b(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iImageCaptureCallback);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IImageCapture
            public Uri captureScreenToFile(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IImageCapture.DESCRIPTOR);
                    a.b(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Uri) a.a(parcelObtain2, Uri.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IImageCapture.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IImageCapture.DESCRIPTOR);
        }

        public static IImageCapture asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IImageCapture.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IImageCapture)) ? new Proxy(iBinder) : (IImageCapture) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IImageCapture.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IImageCapture.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    Uri uriCaptureScreen = captureScreen((Bundle) a.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    a.b(parcel2, uriCaptureScreen, 1);
                    return true;
                case 2:
                    Bitmap bitmapCaptureRegion = captureRegion(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    a.b(parcel2, bitmapCaptureRegion, 1);
                    return true;
                case 3:
                    Uri uriCaptureScreenToFile = captureScreenToFile((Bundle) a.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    a.b(parcel2, uriCaptureScreenToFile, 1);
                    return true;
                case 4:
                    Uri uriCaptureRegionToFile = captureRegionToFile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    a.b(parcel2, uriCaptureRegionToFile, 1);
                    return true;
                case 5:
                    captureScreenAsync((Bundle) a.a(parcel, Bundle.CREATOR), IImageCaptureCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    captureRegionAsync(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), IImageCaptureCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i6);
            }
        }
    }

    Bitmap captureRegion(int i, int i6, int i10, int i11) throws RemoteException;

    void captureRegionAsync(int i, int i6, int i10, int i11, IImageCaptureCallback iImageCaptureCallback) throws RemoteException;

    Uri captureRegionToFile(int i, int i6, int i10, int i11) throws RemoteException;

    Uri captureScreen(Bundle bundle) throws RemoteException;

    void captureScreenAsync(Bundle bundle, IImageCaptureCallback iImageCaptureCallback) throws RemoteException;

    Uri captureScreenToFile(Bundle bundle) throws RemoteException;
}
