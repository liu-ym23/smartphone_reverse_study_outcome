package com.stepos.launcher.preview;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ILauncherPreviewCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.launcher.preview.ILauncherPreviewCallback";

    public static class Default implements ILauncherPreviewCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.launcher.preview.ILauncherPreviewCallback
        public Bitmap getRenderPreview() throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ILauncherPreviewCallback {
        static final int TRANSACTION_getRenderPreview = 1;

        public static class Proxy implements ILauncherPreviewCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILauncherPreviewCallback.DESCRIPTOR;
            }

            @Override // com.stepos.launcher.preview.ILauncherPreviewCallback
            public Bitmap getRenderPreview() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherPreviewCallback.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bitmap) a.c(parcelObtain2, Bitmap.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ILauncherPreviewCallback.DESCRIPTOR);
        }

        public static ILauncherPreviewCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILauncherPreviewCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILauncherPreviewCallback)) ? new Proxy(iBinder) : (ILauncherPreviewCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ILauncherPreviewCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ILauncherPreviewCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            Bitmap renderPreview = getRenderPreview();
            parcel2.writeNoException();
            a.d(parcel2, renderPreview, 1);
            return true;
        }
    }

    public static class a {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    Bitmap getRenderPreview() throws RemoteException;
}
