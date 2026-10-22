package com.stepos.ailauncher.sprite.transport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface ISpriteStateCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ailauncher.sprite.transport.ISpriteStateCallback";

    public static class Default implements ISpriteStateCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteStateCallback
        public void onSpriteBubbleChange(String str) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteStateCallback
        public void onSpriteStateChange(SpriteStateResult spriteStateResult) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISpriteStateCallback {
        static final int TRANSACTION_onSpriteBubbleChange = 2;
        static final int TRANSACTION_onSpriteStateChange = 1;

        public static class Proxy implements ISpriteStateCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISpriteStateCallback.DESCRIPTOR;
            }

            @Override // com.stepos.ailauncher.sprite.transport.ISpriteStateCallback
            public void onSpriteBubbleChange(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISpriteStateCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.sprite.transport.ISpriteStateCallback
            public void onSpriteStateChange(SpriteStateResult spriteStateResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISpriteStateCallback.DESCRIPTOR);
                    a.d(parcelObtain, spriteStateResult, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISpriteStateCallback.DESCRIPTOR);
        }

        public static ISpriteStateCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISpriteStateCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISpriteStateCallback)) ? new Proxy(iBinder) : (ISpriteStateCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ISpriteStateCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ISpriteStateCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onSpriteStateChange((SpriteStateResult) a.c(parcel, SpriteStateResult.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onSpriteBubbleChange(parcel.readString());
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
}
