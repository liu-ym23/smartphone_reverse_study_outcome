package com.stepos.appui.bridge;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.SurfaceControlViewHost;
import com.stepos.appui.bridge.ISurfaceControlCallback;

/* loaded from: classes3.dex */
public interface ISurfaceControlViewHost extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.appui.bridge.ISurfaceControlViewHost";

    public static class Default implements ISurfaceControlViewHost {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
        public void doAction(String str, String str2) throws RemoteException {
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
        public String getPackageName() throws RemoteException {
            return null;
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
        public SurfaceControlViewHost.SurfacePackage getSurfacePackage(String str, IBinder iBinder, int i10, int i11) throws RemoteException {
            return null;
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
        public void onInitData(String str, String str2) throws RemoteException {
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
        public boolean onTouch(String str, MotionEvent motionEvent) throws RemoteException {
            return false;
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
        public void registerCallback(ISurfaceControlCallback iSurfaceControlCallback) throws RemoteException {
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
        public void release(String str) throws RemoteException {
        }

        @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
        public void unregisterCallback(ISurfaceControlCallback iSurfaceControlCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISurfaceControlViewHost {
        static final int TRANSACTION_doAction = 8;
        static final int TRANSACTION_getPackageName = 7;
        static final int TRANSACTION_getSurfacePackage = 3;
        static final int TRANSACTION_onInitData = 6;
        static final int TRANSACTION_onTouch = 4;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_release = 5;
        static final int TRANSACTION_unregisterCallback = 2;

        public static class Proxy implements ISurfaceControlViewHost {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
            public void doAction(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ISurfaceControlViewHost.DESCRIPTOR;
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
            public String getPackageName() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
            public SurfaceControlViewHost.SurfacePackage getSurfacePackage(String str, IBinder iBinder, int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (SurfaceControlViewHost.SurfacePackage) a.c(parcelObtain2, SurfaceControlViewHost.SurfacePackage.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
            public void onInitData(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
            public boolean onTouch(String str, MotionEvent motionEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.d(parcelObtain, motionEvent, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
            public void registerCallback(ISurfaceControlCallback iSurfaceControlCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSurfaceControlCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
            public void release(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlViewHost
            public void unregisterCallback(ISurfaceControlCallback iSurfaceControlCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISurfaceControlViewHost.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSurfaceControlCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISurfaceControlViewHost.DESCRIPTOR);
        }

        public static ISurfaceControlViewHost asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISurfaceControlViewHost.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISurfaceControlViewHost)) ? new Proxy(iBinder) : (ISurfaceControlViewHost) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ISurfaceControlViewHost.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ISurfaceControlViewHost.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    registerCallback(ISurfaceControlCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    unregisterCallback(ISurfaceControlCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    SurfaceControlViewHost.SurfacePackage surfacePackage = getSurfacePackage(parcel.readString(), parcel.readStrongBinder(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    a.d(parcel2, surfacePackage, 1);
                    return true;
                case 4:
                    boolean zOnTouch = onTouch(parcel.readString(), (MotionEvent) a.c(parcel, MotionEvent.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zOnTouch ? 1 : 0);
                    return true;
                case 5:
                    release(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    onInitData(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    String packageName = getPackageName();
                    parcel2.writeNoException();
                    parcel2.writeString(packageName);
                    return true;
                case 8:
                    doAction(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
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

    void doAction(String str, String str2) throws RemoteException;

    String getPackageName() throws RemoteException;

    SurfaceControlViewHost.SurfacePackage getSurfacePackage(String str, IBinder iBinder, int i10, int i11) throws RemoteException;

    void onInitData(String str, String str2) throws RemoteException;

    boolean onTouch(String str, MotionEvent motionEvent) throws RemoteException;

    void registerCallback(ISurfaceControlCallback iSurfaceControlCallback) throws RemoteException;

    void release(String str) throws RemoteException;

    void unregisterCallback(ISurfaceControlCallback iSurfaceControlCallback) throws RemoteException;
}
