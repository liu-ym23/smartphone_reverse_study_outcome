package com.stepos.launcher.client.libraries;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.SurfaceControl;

/* loaded from: classes.dex */
public interface ILauncherOverlayCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.launcher.client.libraries.ILauncherOverlayCallback";

    public static class Default implements ILauncherOverlayCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
        public void onOverlaySurfaceChanged(SurfaceControl surfaceControl) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
        public int onQuickstepInteraction(Bundle bundle) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
        public void overlayScrollChanged(float f10) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
        public void overlayStateChanged(int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ILauncherOverlayCallback {
        static final int TRANSACTION_onOverlaySurfaceChanged = 4;
        static final int TRANSACTION_onQuickstepInteraction = 3;
        static final int TRANSACTION_overlayScrollChanged = 1;
        static final int TRANSACTION_overlayStateChanged = 2;

        public static class Proxy implements ILauncherOverlayCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILauncherOverlayCallback.DESCRIPTOR;
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
            public void onOverlaySurfaceChanged(SurfaceControl surfaceControl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlayCallback.DESCRIPTOR);
                    a.d(parcelObtain, surfaceControl, 0);
                    this.mRemote.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
            public int onQuickstepInteraction(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlayCallback.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
            public void overlayScrollChanged(float f10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlayCallback.DESCRIPTOR);
                    parcelObtain.writeFloat(f10);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
            public void overlayStateChanged(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlayCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ILauncherOverlayCallback.DESCRIPTOR);
        }

        public static ILauncherOverlayCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILauncherOverlayCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILauncherOverlayCallback)) ? new Proxy(iBinder) : (ILauncherOverlayCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ILauncherOverlayCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ILauncherOverlayCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                overlayScrollChanged(parcel.readFloat());
            } else if (i10 == 2) {
                overlayStateChanged(parcel.readInt());
            } else if (i10 == 3) {
                int iOnQuickstepInteraction = onQuickstepInteraction((Bundle) a.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(iOnQuickstepInteraction);
            } else {
                if (i10 != 4) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onOverlaySurfaceChanged((SurfaceControl) a.c(parcel, SurfaceControl.CREATOR));
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

    void onOverlaySurfaceChanged(SurfaceControl surfaceControl) throws RemoteException;

    int onQuickstepInteraction(Bundle bundle) throws RemoteException;

    void overlayScrollChanged(float f10) throws RemoteException;

    void overlayStateChanged(int i10) throws RemoteException;
}
