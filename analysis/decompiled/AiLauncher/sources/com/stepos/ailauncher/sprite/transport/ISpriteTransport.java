package com.stepos.ailauncher.sprite.transport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.stepos.ailauncher.sprite.transport.ISpriteStateCallback;

/* loaded from: classes3.dex */
public interface ISpriteTransport extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ailauncher.sprite.transport.ISpriteTransport";

    public static class Default implements ISpriteTransport {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void onSpriteBubbleChange(String str) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void onSpriteStateChange(SpriteStateResult spriteStateResult) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void onUserEvent(int i10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void registerCallback(ISpriteStateCallback iSpriteStateCallback) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void unregisterCallback(ISpriteStateCallback iSpriteStateCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISpriteTransport {
        static final int TRANSACTION_onSpriteBubbleChange = 4;
        static final int TRANSACTION_onSpriteStateChange = 3;
        static final int TRANSACTION_onUserEvent = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        public static class Proxy implements ISpriteTransport {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISpriteTransport.DESCRIPTOR;
            }

            @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
            public void onSpriteBubbleChange(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISpriteTransport.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
            public void onSpriteStateChange(SpriteStateResult spriteStateResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISpriteTransport.DESCRIPTOR);
                    a.d(parcelObtain, spriteStateResult, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
            public void onUserEvent(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISpriteTransport.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
            public void registerCallback(ISpriteStateCallback iSpriteStateCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISpriteTransport.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSpriteStateCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
            public void unregisterCallback(ISpriteStateCallback iSpriteStateCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISpriteTransport.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSpriteStateCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISpriteTransport.DESCRIPTOR);
        }

        public static ISpriteTransport asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISpriteTransport.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISpriteTransport)) ? new Proxy(iBinder) : (ISpriteTransport) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ISpriteTransport.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ISpriteTransport.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                registerCallback(ISpriteStateCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i10 == 2) {
                unregisterCallback(ISpriteStateCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            } else if (i10 == 3) {
                onSpriteStateChange((SpriteStateResult) a.c(parcel, SpriteStateResult.CREATOR));
                parcel2.writeNoException();
            } else if (i10 == 4) {
                onSpriteBubbleChange(parcel.readString());
                parcel2.writeNoException();
            } else {
                if (i10 != 5) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onUserEvent(parcel.readInt());
                parcel2.writeNoException();
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

    void onSpriteBubbleChange(String str) throws RemoteException;

    void onSpriteStateChange(SpriteStateResult spriteStateResult) throws RemoteException;

    void onUserEvent(int i10) throws RemoteException;

    void registerCallback(ISpriteStateCallback iSpriteStateCallback) throws RemoteException;

    void unregisterCallback(ISpriteStateCallback iSpriteStateCallback) throws RemoteException;
}
