package com.stepos.ailauncher.voice.support;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.stepos.ailauncher.voice.support.IVoiceAssistantCallback;
import java.util.List;

/* loaded from: classes3.dex */
public interface IVoiceServices extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.ailauncher.voice.support.IVoiceServices";

    public static class Default implements IVoiceServices {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void cancelRecognize() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void dismiss() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void dismissFloatView() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void display() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void displayFloatView(Intent intent) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void endRecognize() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public List<String> getSupportSounds() throws RemoteException {
            return null;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public boolean isDisplay() throws RemoteException {
            return false;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public boolean isFloatViewDisplayed() throws RemoteException {
            return false;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public boolean isPermissionAllowed() throws RemoteException {
            return false;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public boolean isSpeaking() throws RemoteException {
            return false;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public boolean isSupport(String str) throws RemoteException {
            return false;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void pauseSpeak() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void registerCallback(IVoiceAssistantCallback iVoiceAssistantCallback) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void resumeSpeak() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void setClientDeathListener(IBinder iBinder) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void setVoiceSpeed(float f10) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public boolean showCtaPermissionDiaglogIfNeed(String str) throws RemoteException {
            return false;
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void speak(String str, Intent intent) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void startRecognize(Intent intent) throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void stopSpeak() throws RemoteException {
        }

        @Override // com.stepos.ailauncher.voice.support.IVoiceServices
        public void unregisterCallBack() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVoiceServices {
        static final int TRANSACTION_cancelRecognize = 16;
        static final int TRANSACTION_dismiss = 2;
        static final int TRANSACTION_dismissFloatView = 15;
        static final int TRANSACTION_display = 1;
        static final int TRANSACTION_displayFloatView = 14;
        static final int TRANSACTION_endRecognize = 11;
        static final int TRANSACTION_getSupportSounds = 9;
        static final int TRANSACTION_isDisplay = 3;
        static final int TRANSACTION_isFloatViewDisplayed = 13;
        static final int TRANSACTION_isPermissionAllowed = 18;
        static final int TRANSACTION_isSpeaking = 8;
        static final int TRANSACTION_isSupport = 12;
        static final int TRANSACTION_pauseSpeak = 20;
        static final int TRANSACTION_registerCallback = 4;
        static final int TRANSACTION_resumeSpeak = 21;
        static final int TRANSACTION_setClientDeathListener = 22;
        static final int TRANSACTION_setVoiceSpeed = 19;
        static final int TRANSACTION_showCtaPermissionDiaglogIfNeed = 17;
        static final int TRANSACTION_speak = 6;
        static final int TRANSACTION_startRecognize = 10;
        static final int TRANSACTION_stopSpeak = 7;
        static final int TRANSACTION_unregisterCallBack = 5;

        public static class Proxy implements IVoiceServices {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void cancelRecognize() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void dismiss() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void dismissFloatView() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void display() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void displayFloatView(Intent intent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    a.d(parcelObtain, intent, 0);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void endRecognize() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IVoiceServices.DESCRIPTOR;
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public List<String> getSupportSounds() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public boolean isDisplay() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public boolean isFloatViewDisplayed() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public boolean isPermissionAllowed() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public boolean isSpeaking() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public boolean isSupport(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void pauseSpeak() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void registerCallback(IVoiceAssistantCallback iVoiceAssistantCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iVoiceAssistantCallback);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void resumeSpeak() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void setClientDeathListener(IBinder iBinder) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void setVoiceSpeed(float f10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    parcelObtain.writeFloat(f10);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public boolean showCtaPermissionDiaglogIfNeed(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void speak(String str, Intent intent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.d(parcelObtain, intent, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        intent.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void startRecognize(Intent intent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    a.d(parcelObtain, intent, 0);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        intent.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void stopSpeak() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.ailauncher.voice.support.IVoiceServices
            public void unregisterCallBack() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IVoiceServices.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IVoiceServices.DESCRIPTOR);
        }

        public static IVoiceServices asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IVoiceServices.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IVoiceServices)) ? new Proxy(iBinder) : (IVoiceServices) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IVoiceServices.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IVoiceServices.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    display();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    dismiss();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    boolean zIsDisplay = isDisplay();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsDisplay ? 1 : 0);
                    return true;
                case 4:
                    registerCallback(IVoiceAssistantCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    unregisterCallBack();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    String string = parcel.readString();
                    Intent intent = (Intent) a.c(parcel, Intent.CREATOR);
                    speak(string, intent);
                    parcel2.writeNoException();
                    a.d(parcel2, intent, 1);
                    return true;
                case 7:
                    stopSpeak();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    boolean zIsSpeaking = isSpeaking();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSpeaking ? 1 : 0);
                    return true;
                case 9:
                    List<String> supportSounds = getSupportSounds();
                    parcel2.writeNoException();
                    parcel2.writeStringList(supportSounds);
                    return true;
                case 10:
                    Intent intent2 = (Intent) a.c(parcel, Intent.CREATOR);
                    startRecognize(intent2);
                    parcel2.writeNoException();
                    a.d(parcel2, intent2, 1);
                    return true;
                case 11:
                    endRecognize();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    boolean zIsSupport = isSupport(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupport ? 1 : 0);
                    return true;
                case 13:
                    boolean zIsFloatViewDisplayed = isFloatViewDisplayed();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsFloatViewDisplayed ? 1 : 0);
                    return true;
                case 14:
                    displayFloatView((Intent) a.c(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    dismissFloatView();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    cancelRecognize();
                    parcel2.writeNoException();
                    return true;
                case 17:
                    boolean zShowCtaPermissionDiaglogIfNeed = showCtaPermissionDiaglogIfNeed(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zShowCtaPermissionDiaglogIfNeed ? 1 : 0);
                    return true;
                case 18:
                    boolean zIsPermissionAllowed = isPermissionAllowed();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsPermissionAllowed ? 1 : 0);
                    return true;
                case 19:
                    setVoiceSpeed(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    pauseSpeak();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    resumeSpeak();
                    parcel2.writeNoException();
                    return true;
                case 22:
                    setClientDeathListener(parcel.readStrongBinder());
                    parcel2.writeNoException();
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

    void cancelRecognize() throws RemoteException;

    void dismiss() throws RemoteException;

    void dismissFloatView() throws RemoteException;

    void display() throws RemoteException;

    void displayFloatView(Intent intent) throws RemoteException;

    void endRecognize() throws RemoteException;

    List<String> getSupportSounds() throws RemoteException;

    boolean isDisplay() throws RemoteException;

    boolean isFloatViewDisplayed() throws RemoteException;

    boolean isPermissionAllowed() throws RemoteException;

    boolean isSpeaking() throws RemoteException;

    boolean isSupport(String str) throws RemoteException;

    void pauseSpeak() throws RemoteException;

    void registerCallback(IVoiceAssistantCallback iVoiceAssistantCallback) throws RemoteException;

    void resumeSpeak() throws RemoteException;

    void setClientDeathListener(IBinder iBinder) throws RemoteException;

    void setVoiceSpeed(float f10) throws RemoteException;

    boolean showCtaPermissionDiaglogIfNeed(String str) throws RemoteException;

    void speak(String str, Intent intent) throws RemoteException;

    void startRecognize(Intent intent) throws RemoteException;

    void stopSpeak() throws RemoteException;

    void unregisterCallBack() throws RemoteException;
}
