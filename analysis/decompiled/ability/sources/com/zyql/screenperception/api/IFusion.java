package com.zyql.screenperception.api;

import S0.b;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.zyql.screenperception.api.IFusionCallback;

/* loaded from: classes2.dex */
public interface IFusion extends IInterface {
    public static final String DESCRIPTOR = "com.zyql.screenperception.api.IFusion";

    public static class Default implements IFusion {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.zyql.screenperception.api.IFusion
        public Bitmap captureClickViewBitmap(int i, int i6) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IFusion
        public Bitmap captureClickViewBitmap2(int i, int i6) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IFusion
        public Bitmap captureLastClickedViewBitmap(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.zyql.screenperception.api.IFusion
        public void getFusionData(Bundle bundle, IFusionCallback iFusionCallback) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IFusion
        public void getScreenShot(Bundle bundle, IFusionCallback iFusionCallback) throws RemoteException {
        }

        @Override // com.zyql.screenperception.api.IFusion
        public Bitmap getViewBitmapAtCoordinates(int i, int i6, Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IFusion {
        static final int TRANSACTION_captureClickViewBitmap = 2;
        static final int TRANSACTION_captureClickViewBitmap2 = 3;
        static final int TRANSACTION_captureLastClickedViewBitmap = 1;
        static final int TRANSACTION_getFusionData = 4;
        static final int TRANSACTION_getScreenShot = 6;
        static final int TRANSACTION_getViewBitmapAtCoordinates = 5;

        public static class Proxy implements IFusion {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zyql.screenperception.api.IFusion
            public Bitmap captureClickViewBitmap(int i, int i6) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFusion.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i6);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bitmap) b.a(parcelObtain2, Bitmap.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IFusion
            public Bitmap captureClickViewBitmap2(int i, int i6) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFusion.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i6);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bitmap) b.a(parcelObtain2, Bitmap.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IFusion
            public Bitmap captureLastClickedViewBitmap(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFusion.DESCRIPTOR);
                    b.b(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bitmap) b.a(parcelObtain2, Bitmap.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IFusion
            public void getFusionData(Bundle bundle, IFusionCallback iFusionCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFusion.DESCRIPTOR);
                    b.b(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iFusionCallback);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IFusion.DESCRIPTOR;
            }

            @Override // com.zyql.screenperception.api.IFusion
            public void getScreenShot(Bundle bundle, IFusionCallback iFusionCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFusion.DESCRIPTOR);
                    b.b(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iFusionCallback);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.zyql.screenperception.api.IFusion
            public Bitmap getViewBitmapAtCoordinates(int i, int i6, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFusion.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i6);
                    b.b(parcelObtain, bundle, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bitmap) b.a(parcelObtain2, Bitmap.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IFusion.DESCRIPTOR);
        }

        public static IFusion asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IFusion.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IFusion)) ? new Proxy(iBinder) : (IFusion) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFusion.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IFusion.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    Bitmap bitmapCaptureLastClickedViewBitmap = captureLastClickedViewBitmap((Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    b.b(parcel2, bitmapCaptureLastClickedViewBitmap, 1);
                    return true;
                case 2:
                    Bitmap bitmapCaptureClickViewBitmap = captureClickViewBitmap(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    b.b(parcel2, bitmapCaptureClickViewBitmap, 1);
                    return true;
                case 3:
                    Bitmap bitmapCaptureClickViewBitmap2 = captureClickViewBitmap2(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    b.b(parcel2, bitmapCaptureClickViewBitmap2, 1);
                    return true;
                case 4:
                    getFusionData((Bundle) b.a(parcel, Bundle.CREATOR), IFusionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    Bitmap viewBitmapAtCoordinates = getViewBitmapAtCoordinates(parcel.readInt(), parcel.readInt(), (Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    b.b(parcel2, viewBitmapAtCoordinates, 1);
                    return true;
                case 6:
                    getScreenShot((Bundle) b.a(parcel, Bundle.CREATOR), IFusionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i6);
            }
        }
    }

    Bitmap captureClickViewBitmap(int i, int i6) throws RemoteException;

    Bitmap captureClickViewBitmap2(int i, int i6) throws RemoteException;

    Bitmap captureLastClickedViewBitmap(Bundle bundle) throws RemoteException;

    void getFusionData(Bundle bundle, IFusionCallback iFusionCallback) throws RemoteException;

    void getScreenShot(Bundle bundle, IFusionCallback iFusionCallback) throws RemoteException;

    Bitmap getViewBitmapAtCoordinates(int i, int i6, Bundle bundle) throws RemoteException;
}
