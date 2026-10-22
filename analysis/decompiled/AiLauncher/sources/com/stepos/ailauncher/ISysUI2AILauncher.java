package com.stepos.ailauncher;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISysUI2AILauncher extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ailauncher.ISysUI2AILauncher";

    public static class Default implements ISysUI2AILauncher {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ailauncher.ISysUI2AILauncher
        public int chatPanelShowType() throws RemoteException {
            return 0;
        }

        @Override // com.stepos.ailauncher.ISysUI2AILauncher
        public void onHomeBarCancel() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.ISysUI2AILauncher
        public void onHomeBarCapsuleClick() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.ISysUI2AILauncher
        public void onHomeBarPressed() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.ISysUI2AILauncher
        public void onInitialize(IBinder iBinder) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.ISysUI2AILauncher
        public void tryToShowChatView(long j10, boolean z10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.ISysUI2AILauncher
        public void tryToShowChatViewWithIntent(Intent intent, long j10, boolean z10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISysUI2AILauncher {
        static final int TRANSACTION_chatPanelShowType = 6;
        static final int TRANSACTION_onHomeBarCancel = 4;
        static final int TRANSACTION_onHomeBarCapsuleClick = 2;
        static final int TRANSACTION_onHomeBarPressed = 3;
        static final int TRANSACTION_onInitialize = 100;
        static final int TRANSACTION_tryToShowChatView = 5;
        static final int TRANSACTION_tryToShowChatViewWithIntent = 7;

        public static class Proxy implements ISysUI2AILauncher {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.ailauncher.ISysUI2AILauncher
            public int chatPanelShowType() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.ISysUI2AILauncher");
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.stepos.ailauncher.ISysUI2AILauncher";
            }

            @Override // com.stepos.ailauncher.ISysUI2AILauncher
            public void onHomeBarCancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.ISysUI2AILauncher");
                    this.mRemote.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.ISysUI2AILauncher
            public void onHomeBarCapsuleClick() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.ISysUI2AILauncher");
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.ISysUI2AILauncher
            public void onHomeBarPressed() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.ISysUI2AILauncher");
                    this.mRemote.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.ISysUI2AILauncher
            public void onInitialize(IBinder iBinder) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.ISysUI2AILauncher");
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(100, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.ISysUI2AILauncher
            public void tryToShowChatView(long j10, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.ISysUI2AILauncher");
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(5, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.ISysUI2AILauncher
            public void tryToShowChatViewWithIntent(Intent intent, long j10, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.ISysUI2AILauncher");
                    _Parcel.writeTypedObject(parcelObtain, intent, 0);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(7, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.stepos.ailauncher.ISysUI2AILauncher");
        }

        public static ISysUI2AILauncher asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.stepos.ailauncher.ISysUI2AILauncher");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISysUI2AILauncher)) ? new Proxy(iBinder) : (ISysUI2AILauncher) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.stepos.ailauncher.ISysUI2AILauncher");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.stepos.ailauncher.ISysUI2AILauncher");
                return true;
            }
            if (i10 != 100) {
                switch (i10) {
                    case 2:
                        onHomeBarCapsuleClick();
                        break;
                    case 3:
                        onHomeBarPressed();
                        break;
                    case 4:
                        onHomeBarCancel();
                        break;
                    case 5:
                        tryToShowChatView(parcel.readLong(), parcel.readInt() != 0);
                        break;
                    case 6:
                        int iChatPanelShowType = chatPanelShowType();
                        parcel2.writeNoException();
                        parcel2.writeInt(iChatPanelShowType);
                        break;
                    case 7:
                        tryToShowChatViewWithIntent((Intent) _Parcel.readTypedObject(parcel, Intent.CREATOR), parcel.readLong(), parcel.readInt() != 0);
                        break;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            } else {
                onInitialize(parcel.readStrongBinder());
            }
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    int chatPanelShowType() throws RemoteException;

    void onHomeBarCancel() throws RemoteException;

    void onHomeBarCapsuleClick() throws RemoteException;

    void onHomeBarPressed() throws RemoteException;

    void onInitialize(IBinder iBinder) throws RemoteException;

    void tryToShowChatView(long j10, boolean z10) throws RemoteException;

    void tryToShowChatViewWithIntent(Intent intent, long j10, boolean z10) throws RemoteException;
}
