package com.stepos.launcher.client.widget;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ILauncherWidgetCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.launcher.client.widget.ILauncherWidgetCallback";

    public static class Default implements ILauncherWidgetCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.launcher.client.widget.ILauncherWidgetCallback
        public void onWidgetStackAction(String str, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ILauncherWidgetCallback {
        static final int TRANSACTION_onWidgetStackAction = 1;

        public static class Proxy implements ILauncherWidgetCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILauncherWidgetCallback.DESCRIPTOR;
            }

            @Override // com.stepos.launcher.client.widget.ILauncherWidgetCallback
            public void onWidgetStackAction(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherWidgetCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.d(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ILauncherWidgetCallback.DESCRIPTOR);
        }

        public static ILauncherWidgetCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILauncherWidgetCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILauncherWidgetCallback)) ? new Proxy(iBinder) : (ILauncherWidgetCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ILauncherWidgetCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ILauncherWidgetCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onWidgetStackAction(parcel.readString(), (Bundle) a.c(parcel, Bundle.CREATOR));
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

    void onWidgetStackAction(String str, Bundle bundle) throws RemoteException;
}
