package com.stepos.launcher.client.libraries;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ILauncherWidgetDragCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback";

    public static class Default implements ILauncherWidgetDragCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback
        public Bundle onGetDragBundle(Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ILauncherWidgetDragCallback {
        static final int TRANSACTION_onGetDragBundle = 1;

        public static class Proxy implements ILauncherWidgetDragCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILauncherWidgetDragCallback.DESCRIPTOR;
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback
            public Bundle onGetDragBundle(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherWidgetDragCallback.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) a.c(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ILauncherWidgetDragCallback.DESCRIPTOR);
        }

        public static ILauncherWidgetDragCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILauncherWidgetDragCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILauncherWidgetDragCallback)) ? new Proxy(iBinder) : (ILauncherWidgetDragCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ILauncherWidgetDragCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ILauncherWidgetDragCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            Bundle bundleOnGetDragBundle = onGetDragBundle((Bundle) a.c(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            a.d(parcel2, bundleOnGetDragBundle, 1);
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

    Bundle onGetDragBundle(Bundle bundle) throws RemoteException;
}
