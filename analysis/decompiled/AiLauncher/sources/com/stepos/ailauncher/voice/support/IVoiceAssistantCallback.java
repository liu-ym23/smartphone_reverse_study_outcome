package com.stepos.ailauncher.voice.support;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IVoiceAssistantCallback extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ailauncher.voice.support.IVoiceAssistantCallback";

    public static class Default implements IVoiceAssistantCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onCancel() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onFailure(Intent intent) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onFloatViewStartBtnClick() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onPermisionDialogClick(boolean z10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onRecordData(byte[] bArr) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onRecordStart() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onSpeakBegan(String str) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onSpeakCompleted(int i10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onSpeakInterrupted() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onSpeakPause() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onSuccess(Intent intent) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onTTSBufferWriterReady(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, int i12) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
        public void onVoiceMsgProc(Intent intent) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVoiceAssistantCallback {
        static final int TRANSACTION_onCancel = 4;
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onFloatViewStartBtnClick = 10;
        static final int TRANSACTION_onPermisionDialogClick = 11;
        static final int TRANSACTION_onRecordData = 13;
        static final int TRANSACTION_onRecordStart = 3;
        static final int TRANSACTION_onSpeakBegan = 8;
        static final int TRANSACTION_onSpeakCompleted = 5;
        static final int TRANSACTION_onSpeakInterrupted = 6;
        static final int TRANSACTION_onSpeakPause = 7;
        static final int TRANSACTION_onSuccess = 1;
        static final int TRANSACTION_onTTSBufferWriterReady = 12;
        static final int TRANSACTION_onVoiceMsgProc = 9;

        public static class Proxy implements IVoiceAssistantCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoiceAssistantCallback.DESCRIPTOR;
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onCancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onFailure(Intent intent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    a.d(parcelObtain, intent, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onFloatViewStartBtnClick() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onPermisionDialogClick(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onRecordData(byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    this.mRemote.transact(13, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onRecordStart() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onSpeakBegan(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onSpeakCompleted(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onSpeakInterrupted() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onSpeakPause() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onSuccess(Intent intent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    a.d(parcelObtain, intent, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onTTSBufferWriterReady(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, int i12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    a.d(parcelObtain, parcelFileDescriptor, 0);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    this.mRemote.transact(12, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantCallback
            public void onVoiceMsgProc(Intent intent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceAssistantCallback.DESCRIPTOR);
                    a.d(parcelObtain, intent, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        intent.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IVoiceAssistantCallback.DESCRIPTOR);
        }

        public static IVoiceAssistantCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IVoiceAssistantCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IVoiceAssistantCallback)) ? new Proxy(iBinder) : (IVoiceAssistantCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IVoiceAssistantCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IVoiceAssistantCallback.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    onSuccess((Intent) a.c(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    onFailure((Intent) a.c(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    onRecordStart();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    onCancel();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    onSpeakCompleted(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    onSpeakInterrupted();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    onSpeakPause();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    onSpeakBegan(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    Intent intent = (Intent) a.c(parcel, Intent.CREATOR);
                    onVoiceMsgProc(intent);
                    parcel2.writeNoException();
                    a.d(parcel2, intent, 1);
                    return true;
                case 10:
                    onFloatViewStartBtnClick();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    onPermisionDialogClick(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    onTTSBufferWriterReady((ParcelFileDescriptor) a.c(parcel, ParcelFileDescriptor.CREATOR), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 13:
                    onRecordData(parcel.createByteArray());
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

    void onCancel() throws RemoteException;

    void onFailure(Intent intent) throws RemoteException;

    void onFloatViewStartBtnClick() throws RemoteException;

    void onPermisionDialogClick(boolean z10) throws RemoteException;

    void onRecordData(byte[] bArr) throws RemoteException;

    void onRecordStart() throws RemoteException;

    void onSpeakBegan(String str) throws RemoteException;

    void onSpeakCompleted(int i10) throws RemoteException;

    void onSpeakInterrupted() throws RemoteException;

    void onSpeakPause() throws RemoteException;

    void onSuccess(Intent intent) throws RemoteException;

    void onTTSBufferWriterReady(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, int i12) throws RemoteException;

    void onVoiceMsgProc(Intent intent) throws RemoteException;
}
