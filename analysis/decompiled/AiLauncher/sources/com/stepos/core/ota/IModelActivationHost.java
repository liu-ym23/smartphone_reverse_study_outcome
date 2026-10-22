package com.stepos.core.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IModelActivationHost extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.core.ota.IModelActivationHost";

    public static class Default implements IModelActivationHost {
        @Override // com.stepos.core.ota.IModelActivationHost
        public boolean activate(String str, int i10, String str2, String str3) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.core.ota.IModelActivationHost
        public boolean deactivate(String str) throws RemoteException {
            return false;
        }

        @Override // com.stepos.core.ota.IModelActivationHost
        public int getCurrentVersion(String str) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IModelActivationHost {
        static final int TRANSACTION_activate = 1;
        static final int TRANSACTION_deactivate = 3;
        static final int TRANSACTION_getCurrentVersion = 2;

        public static class Proxy implements IModelActivationHost {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.stepos.core.ota.IModelActivationHost
            public boolean activate(String str, int i10, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IModelActivationHost.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.core.ota.IModelActivationHost
            public boolean deactivate(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IModelActivationHost.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.core.ota.IModelActivationHost
            public int getCurrentVersion(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IModelActivationHost.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IModelActivationHost.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IModelActivationHost.DESCRIPTOR);
        }

        public static IModelActivationHost asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IModelActivationHost.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IModelActivationHost)) ? new Proxy(iBinder) : (IModelActivationHost) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IModelActivationHost.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IModelActivationHost.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                boolean zActivate = activate(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zActivate ? 1 : 0);
            } else if (i10 == 2) {
                int currentVersion = getCurrentVersion(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(currentVersion);
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                boolean zDeactivate = deactivate(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zDeactivate ? 1 : 0);
            }
            return true;
        }
    }

    boolean activate(String str, int i10, String str2, String str3) throws RemoteException;

    boolean deactivate(String str) throws RemoteException;

    int getCurrentVersion(String str) throws RemoteException;
}
