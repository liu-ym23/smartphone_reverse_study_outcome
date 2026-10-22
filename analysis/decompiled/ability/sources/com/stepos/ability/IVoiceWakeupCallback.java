package com.stepos.ability;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IVoiceWakeupCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ability.IVoiceWakeupCallback";

    public static class Default implements IVoiceWakeupCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ability.IVoiceWakeupCallback
        public void onStateChanged(int i) throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupCallback
        public void onTrainingComplete() throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupCallback
        public void onWakeup() throws RemoteException {
        }

        @Override // com.stepos.ability.IVoiceWakeupCallback
        public void onWakeupById(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVoiceWakeupCallback {
        static final int TRANSACTION_onStateChanged = 3;
        static final int TRANSACTION_onTrainingComplete = 2;
        static final int TRANSACTION_onWakeup = 1;
        static final int TRANSACTION_onWakeupById = 4;

        public static class Proxy implements IVoiceWakeupCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoiceWakeupCallback.DESCRIPTOR;
            }

            @Override // com.stepos.ability.IVoiceWakeupCallback
            public void onStateChanged(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupCallback
            public void onTrainingComplete() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupCallback.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupCallback
            public void onWakeup() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupCallback.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ability.IVoiceWakeupCallback
            public void onWakeupById(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceWakeupCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IVoiceWakeupCallback.DESCRIPTOR);
        }

        public static IVoiceWakeupCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IVoiceWakeupCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IVoiceWakeupCallback)) ? new Proxy(iBinder) : (IVoiceWakeupCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IVoiceWakeupCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IVoiceWakeupCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onWakeup();
                parcel2.writeNoException();
            } else if (i == 2) {
                onTrainingComplete();
                parcel2.writeNoException();
            } else if (i == 3) {
                onStateChanged(parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i6);
                }
                onWakeupById(parcel.readString());
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onStateChanged(int i) throws RemoteException;

    void onTrainingComplete() throws RemoteException;

    void onWakeup() throws RemoteException;

    void onWakeupById(String str) throws RemoteException;
}
