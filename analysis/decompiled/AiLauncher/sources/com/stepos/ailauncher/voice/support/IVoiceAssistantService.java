package com.stepos.ailauncher.voice.support;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.ailauncher.voice.support.IVoiceAssistantCallback;
import com.stepos.ailauncher.voice.support.IVoiceAssistantSpeakCallback;

/* loaded from: classes3.dex */
public interface IVoiceAssistantService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ailauncher.voice.support.IVoiceAssistantService";

    public static class Default implements IVoiceAssistantService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void displayPopWindow(String str, IBinder iBinder) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void hidePopWindow(IBinder iBinder) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public boolean isPopWindowShowing() throws RemoteException {
            return false;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public boolean isSpeaking() throws RemoteException {
            return false;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void overridePopWindowNightMode(boolean z10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void registerCallback(String str, IVoiceAssistantCallback iVoiceAssistantCallback) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void registerOnSpeakCallback(String str, IVoiceAssistantSpeakCallback iVoiceAssistantSpeakCallback) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void runStartSpeak(String str, String str2) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void runStopRecognize() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void runStopSpeak() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void runTextRecognize(String str, String str2) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void runVoiceRecognize(String str, String[] strArr) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void runWakeRecognize(String str, long j10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void setBackgroundColor(int i10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void setFocuses(String str, int i10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void setHintText(String str, String str2) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void unregisterCallback(String str) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
        public void unregisterOnSpeakCallback(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVoiceAssistantService {
        static final int TRANSACTION_displayPopWindow = 4;
        static final int TRANSACTION_hidePopWindow = 5;
        static final int TRANSACTION_isPopWindowShowing = 6;
        static final int TRANSACTION_isSpeaking = 14;
        static final int TRANSACTION_overridePopWindowNightMode = 18;
        static final int TRANSACTION_registerCallback = 2;
        static final int TRANSACTION_registerOnSpeakCallback = 11;
        static final int TRANSACTION_runStartSpeak = 13;
        static final int TRANSACTION_runStopRecognize = 10;
        static final int TRANSACTION_runStopSpeak = 15;
        static final int TRANSACTION_runTextRecognize = 8;
        static final int TRANSACTION_runVoiceRecognize = 7;
        static final int TRANSACTION_runWakeRecognize = 9;
        static final int TRANSACTION_setBackgroundColor = 17;
        static final int TRANSACTION_setFocuses = 1;
        static final int TRANSACTION_setHintText = 16;
        static final int TRANSACTION_unregisterCallback = 3;
        static final int TRANSACTION_unregisterOnSpeakCallback = 12;

        public static class Proxy implements IVoiceAssistantService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void displayPopWindow(String str, IBinder iBinder) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.stepos.ailauncher.voice.support.IVoiceAssistantService";
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void hidePopWindow(IBinder iBinder) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public boolean isPopWindowShowing() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public boolean isSpeaking() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void overridePopWindowNightMode(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void registerCallback(String str, IVoiceAssistantCallback iVoiceAssistantCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iVoiceAssistantCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void registerOnSpeakCallback(String str, IVoiceAssistantSpeakCallback iVoiceAssistantSpeakCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iVoiceAssistantSpeakCallback);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void runStartSpeak(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void runStopRecognize() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void runStopSpeak() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void runTextRecognize(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void runVoiceRecognize(String str, String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void runWakeRecognize(String str, long j10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j10);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void setBackgroundColor(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void setFocuses(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void setHintText(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void unregisterCallback(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceAssistantService
            public void unregisterOnSpeakCallback(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                    parcelObtain.writeString(str);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.stepos.ailauncher.voice.support.IVoiceAssistantService");
        }

        public static IVoiceAssistantService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IVoiceAssistantService)) ? new Proxy(iBinder) : (IVoiceAssistantService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.stepos.ailauncher.voice.support.IVoiceAssistantService");
                return true;
            }
            switch (i10) {
                case 1:
                    setFocuses(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    registerCallback(parcel.readString(), IVoiceAssistantCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    unregisterCallback(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    displayPopWindow(parcel.readString(), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    hidePopWindow(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    boolean zIsPopWindowShowing = isPopWindowShowing();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsPopWindowShowing ? 1 : 0);
                    return true;
                case 7:
                    runVoiceRecognize(parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    runTextRecognize(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    runWakeRecognize(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    runStopRecognize();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    registerOnSpeakCallback(parcel.readString(), IVoiceAssistantSpeakCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    unregisterOnSpeakCallback(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    runStartSpeak(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    boolean zIsSpeaking = isSpeaking();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSpeaking ? 1 : 0);
                    return true;
                case 15:
                    runStopSpeak();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    setHintText(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    setBackgroundColor(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    overridePopWindowNightMode(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void displayPopWindow(String str, IBinder iBinder) throws RemoteException;

    void hidePopWindow(IBinder iBinder) throws RemoteException;

    boolean isPopWindowShowing() throws RemoteException;

    boolean isSpeaking() throws RemoteException;

    void overridePopWindowNightMode(boolean z10) throws RemoteException;

    void registerCallback(String str, IVoiceAssistantCallback iVoiceAssistantCallback) throws RemoteException;

    void registerOnSpeakCallback(String str, IVoiceAssistantSpeakCallback iVoiceAssistantSpeakCallback) throws RemoteException;

    void runStartSpeak(String str, String str2) throws RemoteException;

    void runStopRecognize() throws RemoteException;

    void runStopSpeak() throws RemoteException;

    void runTextRecognize(String str, String str2) throws RemoteException;

    void runVoiceRecognize(String str, String[] strArr) throws RemoteException;

    void runWakeRecognize(String str, long j10) throws RemoteException;

    void setBackgroundColor(int i10) throws RemoteException;

    void setFocuses(String str, int i10) throws RemoteException;

    void setHintText(String str, String str2) throws RemoteException;

    void unregisterCallback(String str) throws RemoteException;

    void unregisterOnSpeakCallback(String str) throws RemoteException;
}
