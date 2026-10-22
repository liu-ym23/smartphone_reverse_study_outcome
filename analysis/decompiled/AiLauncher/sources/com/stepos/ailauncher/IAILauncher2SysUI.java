package com.stepos.ailauncher;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAILauncher2SysUI extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ailauncher.IAILauncher2SysUI";

    public static class Default implements IAILauncher2SysUI {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ailauncher.IAILauncher2SysUI
        public boolean isWhiteHomeBar() throws RemoteException {
            return false;
        }

        @Override // com.stepos.ailauncher.IAILauncher2SysUI
        public void onChatViewClosed(long j10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.IAILauncher2SysUI
        public void onHomeBarLighted() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.IAILauncher2SysUI
        public void showHomeBarCapsule(boolean z10, String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAILauncher2SysUI {
        static final int TRANSACTION_isWhiteHomeBar = 5;
        static final int TRANSACTION_onChatViewClosed = 4;
        static final int TRANSACTION_onHomeBarLighted = 3;
        static final int TRANSACTION_showHomeBarCapsule = 2;

        public static class Proxy implements IAILauncher2SysUI {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAILauncher2SysUI.DESCRIPTOR;
            }

            @Override // com.stepos.ailauncher.IAILauncher2SysUI
            public boolean isWhiteHomeBar() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAILauncher2SysUI.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.IAILauncher2SysUI
            public void onChatViewClosed(long j10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAILauncher2SysUI.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    this.mRemote.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.IAILauncher2SysUI
            public void onHomeBarLighted() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAILauncher2SysUI.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.IAILauncher2SysUI
            public void showHomeBarCapsule(boolean z10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAILauncher2SysUI.DESCRIPTOR);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAILauncher2SysUI.DESCRIPTOR);
        }

        public static IAILauncher2SysUI asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAILauncher2SysUI.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAILauncher2SysUI)) ? new Proxy(iBinder) : (IAILauncher2SysUI) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAILauncher2SysUI.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAILauncher2SysUI.DESCRIPTOR);
                return true;
            }
            if (i10 == 2) {
                showHomeBarCapsule(parcel.readInt() != 0, parcel.readString());
            } else if (i10 == 3) {
                onHomeBarLighted();
            } else if (i10 == 4) {
                onChatViewClosed(parcel.readLong());
            } else {
                if (i10 != 5) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                boolean zIsWhiteHomeBar = isWhiteHomeBar();
                parcel2.writeNoException();
                parcel2.writeInt(zIsWhiteHomeBar ? 1 : 0);
            }
            return true;
        }
    }

    boolean isWhiteHomeBar() throws RemoteException;

    void onChatViewClosed(long j10) throws RemoteException;

    void onHomeBarLighted() throws RemoteException;

    void showHomeBarCapsule(boolean z10, String str) throws RemoteException;
}
