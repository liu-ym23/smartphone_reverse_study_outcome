package com.stepos.picker.screenperception;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IScreenshotCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.picker.screenperception.IScreenshotCallback";

    public static class Default implements IScreenshotCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.picker.screenperception.IScreenshotCallback
        public void onCaptured(Uri uri) throws RemoteException {
        }

        @Override // com.stepos.picker.screenperception.IScreenshotCallback
        public void onFailed(int i10, String str) throws RemoteException {
        }

        @Override // com.stepos.picker.screenperception.IScreenshotCallback
        public void onTrackEvent(String str, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IScreenshotCallback {
        static final int TRANSACTION_onCaptured = 1;
        static final int TRANSACTION_onFailed = 2;
        static final int TRANSACTION_onTrackEvent = 3;

        public static class Proxy implements IScreenshotCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IScreenshotCallback.DESCRIPTOR;
            }

            @Override // com.stepos.picker.screenperception.IScreenshotCallback
            public void onCaptured(Uri uri) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenshotCallback.DESCRIPTOR);
                    a.d(parcelObtain, uri, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.picker.screenperception.IScreenshotCallback
            public void onFailed(int i10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenshotCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.picker.screenperception.IScreenshotCallback
            public void onTrackEvent(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IScreenshotCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IScreenshotCallback.DESCRIPTOR);
        }

        public static IScreenshotCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IScreenshotCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IScreenshotCallback)) ? new Proxy(iBinder) : (IScreenshotCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IScreenshotCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IScreenshotCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onCaptured((Uri) a.c(parcel, Uri.CREATOR));
            } else if (i10 == 2) {
                onFailed(parcel.readInt(), parcel.readString());
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onTrackEvent(parcel.readString(), parcel.readString());
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

    void onCaptured(Uri uri) throws RemoteException;

    void onFailed(int i10, String str) throws RemoteException;

    void onTrackEvent(String str, String str2) throws RemoteException;
}
