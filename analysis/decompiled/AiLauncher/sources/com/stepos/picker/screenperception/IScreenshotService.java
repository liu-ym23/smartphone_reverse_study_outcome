package com.stepos.picker.screenperception;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.stepos.picker.screenperception.IScreenshotCallback;

/* loaded from: classes.dex */
public interface IScreenshotService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.picker.screenperception.IScreenshotService";

    public static class Default implements IScreenshotService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.picker.screenperception.IScreenshotService
        public int captureFullScreen(IScreenshotCallback iScreenshotCallback) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.picker.screenperception.IScreenshotService
        public int captureRegion(ScreenRegion screenRegion, IScreenshotCallback iScreenshotCallback) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IScreenshotService {
        static final int TRANSACTION_captureFullScreen = 1;
        static final int TRANSACTION_captureRegion = 2;

        public static class Proxy implements IScreenshotService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.picker.screenperception.IScreenshotService
            public int captureFullScreen(IScreenshotCallback iScreenshotCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenshotService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iScreenshotCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.picker.screenperception.IScreenshotService
            public int captureRegion(ScreenRegion screenRegion, IScreenshotCallback iScreenshotCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenshotService.DESCRIPTOR);
                    a.d(parcelObtain, screenRegion, 0);
                    parcelObtain.writeStrongInterface(iScreenshotCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IScreenshotService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IScreenshotService.DESCRIPTOR);
        }

        public static IScreenshotService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IScreenshotService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IScreenshotService)) ? new Proxy(iBinder) : (IScreenshotService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IScreenshotService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IScreenshotService.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                int iCaptureFullScreen = captureFullScreen(IScreenshotCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(iCaptureFullScreen);
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                int iCaptureRegion = captureRegion((ScreenRegion) a.c(parcel, ScreenRegion.INSTANCE), IScreenshotCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(iCaptureRegion);
            }
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

    int captureFullScreen(IScreenshotCallback iScreenshotCallback) throws RemoteException;

    int captureRegion(ScreenRegion screenRegion, IScreenshotCallback iScreenshotCallback) throws RemoteException;
}
