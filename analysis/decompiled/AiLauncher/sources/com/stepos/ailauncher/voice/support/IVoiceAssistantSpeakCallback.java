package com.stepos.ailauncher.voice.support;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IVoiceAssistantSpeakCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback";

    public static class Default implements IVoiceAssistantSpeakCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback
        public void onInit() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback
        public void onSpeakOver() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback
        public void onSpeaking() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVoiceAssistantSpeakCallback {
        static final int TRANSACTION_onInit = 1;
        static final int TRANSACTION_onSpeakOver = 2;
        static final int TRANSACTION_onSpeaking = 3;

        public static class Proxy implements IVoiceAssistantSpeakCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoiceAssistantSpeakCallback.DESCRIPTOR;
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback
            public void onInit() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantSpeakCallback.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback
            public void onSpeakOver() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantSpeakCallback.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback
            public void onSpeaking() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantSpeakCallback.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IVoiceAssistantSpeakCallback.DESCRIPTOR);
        }

        public static IVoiceAssistantSpeakCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IVoiceAssistantSpeakCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IVoiceAssistantSpeakCallback)) ? new Proxy(iBinder) : (IVoiceAssistantSpeakCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IVoiceAssistantSpeakCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IVoiceAssistantSpeakCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onInit();
                parcel2.writeNoException();
            } else if (i10 == 2) {
                onSpeakOver();
                parcel2.writeNoException();
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onSpeaking();
                parcel2.writeNoException();
            }
            return true;
        }
    }

    void onInit() throws RemoteException;

    void onSpeakOver() throws RemoteException;

    void onSpeaking() throws RemoteException;
}
