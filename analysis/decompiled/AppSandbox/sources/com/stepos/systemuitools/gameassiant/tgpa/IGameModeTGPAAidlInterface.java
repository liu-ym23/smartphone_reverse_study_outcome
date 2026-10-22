package com.stepos.systemuitools.gameassiant.tgpa;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IGameModeTGPAAidlInterface extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.systemuitools.gameassiant.tgpa.IGameModeTGPAAidlInterface";

    public static class Default implements IGameModeTGPAAidlInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.systemuitools.gameassiant.tgpa.IGameModeTGPAAidlInterface
        public void isGameSupported(String str, boolean z) throws RemoteException {
        }

        @Override // com.stepos.systemuitools.gameassiant.tgpa.IGameModeTGPAAidlInterface
        public void setForeground(String str, boolean z) throws RemoteException {
        }

        @Override // com.stepos.systemuitools.gameassiant.tgpa.IGameModeTGPAAidlInterface
        public void updateGameInfo(String str, String str2) throws RemoteException {
        }
    }

    void isGameSupported(String str, boolean z) throws RemoteException;

    void setForeground(String str, boolean z) throws RemoteException;

    void updateGameInfo(String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements IGameModeTGPAAidlInterface {
        static final int TRANSACTION_isGameSupported = 3;
        static final int TRANSACTION_setForeground = 2;
        static final int TRANSACTION_updateGameInfo = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IGameModeTGPAAidlInterface.DESCRIPTOR);
        }

        public static IGameModeTGPAAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IGameModeTGPAAidlInterface.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IGameModeTGPAAidlInterface)) {
                return (IGameModeTGPAAidlInterface) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IGameModeTGPAAidlInterface.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IGameModeTGPAAidlInterface.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String string = parcel.readString();
                String string2 = parcel.readString();
                parcel.enforceNoDataAvail();
                updateGameInfo(string, string2);
            } else if (i == 2) {
                String string3 = parcel.readString();
                boolean z = parcel.readBoolean();
                parcel.enforceNoDataAvail();
                setForeground(string3, z);
            } else if (i == 3) {
                String string4 = parcel.readString();
                boolean z2 = parcel.readBoolean();
                parcel.enforceNoDataAvail();
                isGameSupported(string4, z2);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        private static class Proxy implements IGameModeTGPAAidlInterface {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IGameModeTGPAAidlInterface.DESCRIPTOR;
            }

            @Override // com.stepos.systemuitools.gameassiant.tgpa.IGameModeTGPAAidlInterface
            public void updateGameInfo(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                try {
                    parcelObtain.writeInterfaceToken(IGameModeTGPAAidlInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.systemuitools.gameassiant.tgpa.IGameModeTGPAAidlInterface
            public void setForeground(String str, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                try {
                    parcelObtain.writeInterfaceToken(IGameModeTGPAAidlInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeBoolean(z);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.systemuitools.gameassiant.tgpa.IGameModeTGPAAidlInterface
            public void isGameSupported(String str, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                try {
                    parcelObtain.writeInterfaceToken(IGameModeTGPAAidlInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeBoolean(z);
                    this.mRemote.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
