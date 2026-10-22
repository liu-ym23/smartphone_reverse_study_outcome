package android.hardware.display;

import android.hardware.display.IBackScreenAnimationListener;
import android.hardware.display.IBackScreenCountdownListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSDisplayManager extends IInterface {
    public static final String DESCRIPTOR = "android.hardware.display.IStepOSDisplayManager";

    void cancelBackScreenCountdown() throws RemoteException;

    BackScreenAnimationInfo getBackScreenAnimationInfo() throws RemoteException;

    String getBackScreenBasicText() throws RemoteException;

    String getBackScreenBasicType() throws RemoteException;

    int getBackScreenBrightness() throws RemoteException;

    int getBackScreenBrightnessMode() throws RemoteException;

    int getBackScreenCustomEnd() throws RemoteException;

    int getBackScreenCustomStart() throws RemoteException;

    int getBackScreenDisplayMode() throws RemoteException;

    boolean isBackScreenAlwaysOnActive() throws RemoteException;

    boolean isBackScreenAutoRotateEnabled() throws RemoteException;

    boolean isBackScreenBasicTextInvert() throws RemoteException;

    boolean isBackScreenBasicTextMarquee() throws RemoteException;

    boolean isBackScreenCameraLinkEnabled() throws RemoteException;

    boolean isBackScreenEnabled() throws RemoteException;

    boolean isBackScreenRaiseFlipEnabled() throws RemoteException;

    void notifyBackScreenCameraCapture(Bundle bundle) throws RemoteException;

    void registerBackScreenAnimationListener(IBackScreenAnimationListener iBackScreenAnimationListener) throws RemoteException;

    void registerBackScreenAnimationListenerForType(IBackScreenAnimationListener iBackScreenAnimationListener, String str) throws RemoteException;

    void setBackScreenAgentFrame(int[] iArr, Bundle bundle) throws RemoteException;

    void setBackScreenAgentState(String str, Bundle bundle) throws RemoteException;

    void setBackScreenAutoRotateEnabled(boolean z) throws RemoteException;

    void setBackScreenBasicText(String str) throws RemoteException;

    void setBackScreenBasicTextInvert(boolean z) throws RemoteException;

    void setBackScreenBasicTextMarquee(boolean z) throws RemoteException;

    void setBackScreenBasicType(String str) throws RemoteException;

    void setBackScreenBrightness(int i) throws RemoteException;

    void setBackScreenBrightnessMode(int i) throws RemoteException;

    void setBackScreenCameraLinkEnabled(boolean z) throws RemoteException;

    void setBackScreenCustomEnd(int i) throws RemoteException;

    void setBackScreenCustomStart(int i) throws RemoteException;

    void setBackScreenDisplayMode(int i) throws RemoteException;

    void setBackScreenEnabled(boolean z) throws RemoteException;

    void setBackScreenRaiseFlipEnabled(boolean z) throws RemoteException;

    void setBlockColorMatrixEffectEnabled(boolean z) throws RemoteException;

    void setDisplayColorTemperature(int i, boolean z) throws RemoteException;

    void setNightDisplayActivatedImmediate(boolean z) throws RemoteException;

    void startBackScreenCountdown(int i, Bundle bundle, IBackScreenCountdownListener iBackScreenCountdownListener) throws RemoteException;

    void unregisterBackScreenAnimationListener(IBackScreenAnimationListener iBackScreenAnimationListener) throws RemoteException;

    boolean unregisterBackScreenAnimationListenerForType(IBackScreenAnimationListener iBackScreenAnimationListener, String str) throws RemoteException;

    public static class Default implements IStepOSDisplayManager {
        @Override // android.hardware.display.IStepOSDisplayManager
        public void setNightDisplayActivatedImmediate(boolean activate) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setDisplayColorTemperature(int temperature, boolean applyImmediate) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBlockColorMatrixEffectEnabled(boolean enabled) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenAgentState(String agentState, Bundle extra) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenAgentFrame(int[] frame, Bundle extra) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void registerBackScreenAnimationListener(IBackScreenAnimationListener listener) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void unregisterBackScreenAnimationListener(IBackScreenAnimationListener listener) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public BackScreenAnimationInfo getBackScreenAnimationInfo() throws RemoteException {
            return null;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void registerBackScreenAnimationListenerForType(IBackScreenAnimationListener listener, String type) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public boolean unregisterBackScreenAnimationListenerForType(IBackScreenAnimationListener listener, String type) throws RemoteException {
            return false;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void startBackScreenCountdown(int seconds, Bundle extra, IBackScreenCountdownListener listener) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void cancelBackScreenCountdown() throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenBrightnessMode(int mode) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public int getBackScreenBrightnessMode() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenBrightness(int brightness) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public int getBackScreenBrightness() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public boolean isBackScreenEnabled() throws RemoteException {
            return false;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenEnabled(boolean enabled) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public boolean isBackScreenAlwaysOnActive() throws RemoteException {
            return false;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public int getBackScreenDisplayMode() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenDisplayMode(int mode) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public int getBackScreenCustomStart() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenCustomStart(int minutesFromMidnight) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public int getBackScreenCustomEnd() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenCustomEnd(int minutesFromMidnight) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public String getBackScreenBasicType() throws RemoteException {
            return null;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenBasicType(String type) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public boolean isBackScreenRaiseFlipEnabled() throws RemoteException {
            return false;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenRaiseFlipEnabled(boolean enabled) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public boolean isBackScreenCameraLinkEnabled() throws RemoteException {
            return false;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenCameraLinkEnabled(boolean enabled) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public boolean isBackScreenAutoRotateEnabled() throws RemoteException {
            return false;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenAutoRotateEnabled(boolean enabled) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public String getBackScreenBasicText() throws RemoteException {
            return null;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenBasicText(String text) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public boolean isBackScreenBasicTextInvert() throws RemoteException {
            return false;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenBasicTextInvert(boolean invert) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public boolean isBackScreenBasicTextMarquee() throws RemoteException {
            return false;
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void setBackScreenBasicTextMarquee(boolean enabled) throws RemoteException {
        }

        @Override // android.hardware.display.IStepOSDisplayManager
        public void notifyBackScreenCameraCapture(Bundle extra) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSDisplayManager {
        static final int TRANSACTION_cancelBackScreenCountdown = 12;
        static final int TRANSACTION_getBackScreenAnimationInfo = 8;
        static final int TRANSACTION_getBackScreenBasicText = 34;
        static final int TRANSACTION_getBackScreenBasicType = 26;
        static final int TRANSACTION_getBackScreenBrightness = 16;
        static final int TRANSACTION_getBackScreenBrightnessMode = 14;
        static final int TRANSACTION_getBackScreenCustomEnd = 24;
        static final int TRANSACTION_getBackScreenCustomStart = 22;
        static final int TRANSACTION_getBackScreenDisplayMode = 20;
        static final int TRANSACTION_isBackScreenAlwaysOnActive = 19;
        static final int TRANSACTION_isBackScreenAutoRotateEnabled = 32;
        static final int TRANSACTION_isBackScreenBasicTextInvert = 36;
        static final int TRANSACTION_isBackScreenBasicTextMarquee = 38;
        static final int TRANSACTION_isBackScreenCameraLinkEnabled = 30;
        static final int TRANSACTION_isBackScreenEnabled = 17;
        static final int TRANSACTION_isBackScreenRaiseFlipEnabled = 28;
        static final int TRANSACTION_notifyBackScreenCameraCapture = 40;
        static final int TRANSACTION_registerBackScreenAnimationListener = 6;
        static final int TRANSACTION_registerBackScreenAnimationListenerForType = 9;
        static final int TRANSACTION_setBackScreenAgentFrame = 5;
        static final int TRANSACTION_setBackScreenAgentState = 4;
        static final int TRANSACTION_setBackScreenAutoRotateEnabled = 33;
        static final int TRANSACTION_setBackScreenBasicText = 35;
        static final int TRANSACTION_setBackScreenBasicTextInvert = 37;
        static final int TRANSACTION_setBackScreenBasicTextMarquee = 39;
        static final int TRANSACTION_setBackScreenBasicType = 27;
        static final int TRANSACTION_setBackScreenBrightness = 15;
        static final int TRANSACTION_setBackScreenBrightnessMode = 13;
        static final int TRANSACTION_setBackScreenCameraLinkEnabled = 31;
        static final int TRANSACTION_setBackScreenCustomEnd = 25;
        static final int TRANSACTION_setBackScreenCustomStart = 23;
        static final int TRANSACTION_setBackScreenDisplayMode = 21;
        static final int TRANSACTION_setBackScreenEnabled = 18;
        static final int TRANSACTION_setBackScreenRaiseFlipEnabled = 29;
        static final int TRANSACTION_setBlockColorMatrixEffectEnabled = 3;
        static final int TRANSACTION_setDisplayColorTemperature = 2;
        static final int TRANSACTION_setNightDisplayActivatedImmediate = 1;
        static final int TRANSACTION_startBackScreenCountdown = 11;
        static final int TRANSACTION_unregisterBackScreenAnimationListener = 7;
        static final int TRANSACTION_unregisterBackScreenAnimationListenerForType = 10;

        public Stub() {
            attachInterface(this, IStepOSDisplayManager.DESCRIPTOR);
        }

        public static IStepOSDisplayManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSDisplayManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSDisplayManager)) {
                return (IStepOSDisplayManager) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "setNightDisplayActivatedImmediate";
                case 2:
                    return "setDisplayColorTemperature";
                case 3:
                    return "setBlockColorMatrixEffectEnabled";
                case 4:
                    return "setBackScreenAgentState";
                case 5:
                    return "setBackScreenAgentFrame";
                case 6:
                    return "registerBackScreenAnimationListener";
                case 7:
                    return "unregisterBackScreenAnimationListener";
                case 8:
                    return "getBackScreenAnimationInfo";
                case 9:
                    return "registerBackScreenAnimationListenerForType";
                case 10:
                    return "unregisterBackScreenAnimationListenerForType";
                case 11:
                    return "startBackScreenCountdown";
                case 12:
                    return "cancelBackScreenCountdown";
                case 13:
                    return "setBackScreenBrightnessMode";
                case 14:
                    return "getBackScreenBrightnessMode";
                case 15:
                    return "setBackScreenBrightness";
                case 16:
                    return "getBackScreenBrightness";
                case 17:
                    return "isBackScreenEnabled";
                case 18:
                    return "setBackScreenEnabled";
                case 19:
                    return "isBackScreenAlwaysOnActive";
                case 20:
                    return "getBackScreenDisplayMode";
                case 21:
                    return "setBackScreenDisplayMode";
                case 22:
                    return "getBackScreenCustomStart";
                case 23:
                    return "setBackScreenCustomStart";
                case 24:
                    return "getBackScreenCustomEnd";
                case 25:
                    return "setBackScreenCustomEnd";
                case 26:
                    return "getBackScreenBasicType";
                case 27:
                    return "setBackScreenBasicType";
                case 28:
                    return "isBackScreenRaiseFlipEnabled";
                case 29:
                    return "setBackScreenRaiseFlipEnabled";
                case 30:
                    return "isBackScreenCameraLinkEnabled";
                case 31:
                    return "setBackScreenCameraLinkEnabled";
                case 32:
                    return "isBackScreenAutoRotateEnabled";
                case 33:
                    return "setBackScreenAutoRotateEnabled";
                case 34:
                    return "getBackScreenBasicText";
                case 35:
                    return "setBackScreenBasicText";
                case 36:
                    return "isBackScreenBasicTextInvert";
                case 37:
                    return "setBackScreenBasicTextInvert";
                case 38:
                    return "isBackScreenBasicTextMarquee";
                case 39:
                    return "setBackScreenBasicTextMarquee";
                case 40:
                    return "notifyBackScreenCameraCapture";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IStepOSDisplayManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSDisplayManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    boolean _arg0 = data.readBoolean();
                    setNightDisplayActivatedImmediate(_arg0);
                    reply.writeNoException();
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    boolean _arg1 = data.readBoolean();
                    setDisplayColorTemperature(_arg02, _arg1);
                    reply.writeNoException();
                    return true;
                case 3:
                    boolean _arg03 = data.readBoolean();
                    setBlockColorMatrixEffectEnabled(_arg03);
                    reply.writeNoException();
                    return true;
                case 4:
                    String _arg04 = data.readString();
                    Bundle _arg12 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    setBackScreenAgentState(_arg04, _arg12);
                    return true;
                case 5:
                    int[] _arg05 = data.createIntArray();
                    Bundle _arg13 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    setBackScreenAgentFrame(_arg05, _arg13);
                    return true;
                case 6:
                    IBackScreenAnimationListener _arg06 = IBackScreenAnimationListener.Stub.asInterface(data.readStrongBinder());
                    registerBackScreenAnimationListener(_arg06);
                    reply.writeNoException();
                    return true;
                case 7:
                    IBackScreenAnimationListener _arg07 = IBackScreenAnimationListener.Stub.asInterface(data.readStrongBinder());
                    unregisterBackScreenAnimationListener(_arg07);
                    reply.writeNoException();
                    return true;
                case 8:
                    BackScreenAnimationInfo _result = getBackScreenAnimationInfo();
                    reply.writeNoException();
                    reply.writeTypedObject(_result, 1);
                    return true;
                case 9:
                    IBackScreenAnimationListener _arg08 = IBackScreenAnimationListener.Stub.asInterface(data.readStrongBinder());
                    String _arg14 = data.readString();
                    registerBackScreenAnimationListenerForType(_arg08, _arg14);
                    reply.writeNoException();
                    return true;
                case 10:
                    IBackScreenAnimationListener _arg09 = IBackScreenAnimationListener.Stub.asInterface(data.readStrongBinder());
                    String _arg15 = data.readString();
                    boolean _result2 = unregisterBackScreenAnimationListenerForType(_arg09, _arg15);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 11:
                    int _arg010 = data.readInt();
                    Bundle _arg16 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    IBackScreenCountdownListener _arg2 = IBackScreenCountdownListener.Stub.asInterface(data.readStrongBinder());
                    startBackScreenCountdown(_arg010, _arg16, _arg2);
                    return true;
                case 12:
                    cancelBackScreenCountdown();
                    return true;
                case 13:
                    int _arg011 = data.readInt();
                    setBackScreenBrightnessMode(_arg011);
                    reply.writeNoException();
                    return true;
                case 14:
                    int _result3 = getBackScreenBrightnessMode();
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 15:
                    int _arg012 = data.readInt();
                    setBackScreenBrightness(_arg012);
                    reply.writeNoException();
                    return true;
                case 16:
                    int _result4 = getBackScreenBrightness();
                    reply.writeNoException();
                    reply.writeInt(_result4);
                    return true;
                case 17:
                    boolean _result5 = isBackScreenEnabled();
                    reply.writeNoException();
                    reply.writeBoolean(_result5);
                    return true;
                case 18:
                    boolean _arg013 = data.readBoolean();
                    setBackScreenEnabled(_arg013);
                    reply.writeNoException();
                    return true;
                case 19:
                    boolean _result6 = isBackScreenAlwaysOnActive();
                    reply.writeNoException();
                    reply.writeBoolean(_result6);
                    return true;
                case 20:
                    int _result7 = getBackScreenDisplayMode();
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 21:
                    int _arg014 = data.readInt();
                    setBackScreenDisplayMode(_arg014);
                    reply.writeNoException();
                    return true;
                case 22:
                    int _result8 = getBackScreenCustomStart();
                    reply.writeNoException();
                    reply.writeInt(_result8);
                    return true;
                case 23:
                    int _arg015 = data.readInt();
                    setBackScreenCustomStart(_arg015);
                    reply.writeNoException();
                    return true;
                case 24:
                    int _result9 = getBackScreenCustomEnd();
                    reply.writeNoException();
                    reply.writeInt(_result9);
                    return true;
                case 25:
                    int _arg016 = data.readInt();
                    setBackScreenCustomEnd(_arg016);
                    reply.writeNoException();
                    return true;
                case 26:
                    String _result10 = getBackScreenBasicType();
                    reply.writeNoException();
                    reply.writeString(_result10);
                    return true;
                case 27:
                    String _arg017 = data.readString();
                    setBackScreenBasicType(_arg017);
                    reply.writeNoException();
                    return true;
                case 28:
                    boolean _result11 = isBackScreenRaiseFlipEnabled();
                    reply.writeNoException();
                    reply.writeBoolean(_result11);
                    return true;
                case 29:
                    boolean _arg018 = data.readBoolean();
                    setBackScreenRaiseFlipEnabled(_arg018);
                    reply.writeNoException();
                    return true;
                case 30:
                    boolean _result12 = isBackScreenCameraLinkEnabled();
                    reply.writeNoException();
                    reply.writeBoolean(_result12);
                    return true;
                case 31:
                    boolean _arg019 = data.readBoolean();
                    setBackScreenCameraLinkEnabled(_arg019);
                    reply.writeNoException();
                    return true;
                case 32:
                    boolean _result13 = isBackScreenAutoRotateEnabled();
                    reply.writeNoException();
                    reply.writeBoolean(_result13);
                    return true;
                case 33:
                    boolean _arg020 = data.readBoolean();
                    setBackScreenAutoRotateEnabled(_arg020);
                    reply.writeNoException();
                    return true;
                case 34:
                    String _result14 = getBackScreenBasicText();
                    reply.writeNoException();
                    reply.writeString(_result14);
                    return true;
                case 35:
                    String _arg021 = data.readString();
                    setBackScreenBasicText(_arg021);
                    reply.writeNoException();
                    return true;
                case 36:
                    boolean _result15 = isBackScreenBasicTextInvert();
                    reply.writeNoException();
                    reply.writeBoolean(_result15);
                    return true;
                case 37:
                    boolean _arg022 = data.readBoolean();
                    setBackScreenBasicTextInvert(_arg022);
                    reply.writeNoException();
                    return true;
                case 38:
                    boolean _result16 = isBackScreenBasicTextMarquee();
                    reply.writeNoException();
                    reply.writeBoolean(_result16);
                    return true;
                case 39:
                    boolean _arg023 = data.readBoolean();
                    setBackScreenBasicTextMarquee(_arg023);
                    reply.writeNoException();
                    return true;
                case 40:
                    Bundle _arg024 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    notifyBackScreenCameraCapture(_arg024);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSDisplayManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSDisplayManager.DESCRIPTOR;
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setNightDisplayActivatedImmediate(boolean activate) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeBoolean(activate);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setDisplayColorTemperature(int temperature, boolean applyImmediate) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeInt(temperature);
                    _data.writeBoolean(applyImmediate);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBlockColorMatrixEffectEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenAgentState(String agentState, Bundle extra) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeString(agentState);
                    _data.writeTypedObject(extra, 0);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenAgentFrame(int[] frame, Bundle extra) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeIntArray(frame);
                    _data.writeTypedObject(extra, 0);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void registerBackScreenAnimationListener(IBackScreenAnimationListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void unregisterBackScreenAnimationListener(IBackScreenAnimationListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public BackScreenAnimationInfo getBackScreenAnimationInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    BackScreenAnimationInfo _result = (BackScreenAnimationInfo) _reply.readTypedObject(BackScreenAnimationInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void registerBackScreenAnimationListenerForType(IBackScreenAnimationListener listener, String type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    _data.writeString(type);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public boolean unregisterBackScreenAnimationListenerForType(IBackScreenAnimationListener listener, String type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    _data.writeString(type);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void startBackScreenCountdown(int seconds, Bundle extra, IBackScreenCountdownListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeInt(seconds);
                    _data.writeTypedObject(extra, 0);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(11, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void cancelBackScreenCountdown() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(12, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenBrightnessMode(int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeInt(mode);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public int getBackScreenBrightnessMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenBrightness(int brightness) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeInt(brightness);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public int getBackScreenBrightness() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public boolean isBackScreenEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public boolean isBackScreenAlwaysOnActive() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public int getBackScreenDisplayMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenDisplayMode(int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeInt(mode);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public int getBackScreenCustomStart() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenCustomStart(int minutesFromMidnight) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeInt(minutesFromMidnight);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public int getBackScreenCustomEnd() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenCustomEnd(int minutesFromMidnight) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeInt(minutesFromMidnight);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public String getBackScreenBasicType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenBasicType(String type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeString(type);
                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public boolean isBackScreenRaiseFlipEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenRaiseFlipEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(29, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public boolean isBackScreenCameraLinkEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(30, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenCameraLinkEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(31, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public boolean isBackScreenAutoRotateEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenAutoRotateEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public String getBackScreenBasicText() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(34, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenBasicText(String text) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeString(text);
                    this.mRemote.transact(35, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public boolean isBackScreenBasicTextInvert() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(36, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenBasicTextInvert(boolean invert) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeBoolean(invert);
                    this.mRemote.transact(37, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public boolean isBackScreenBasicTextMarquee() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    this.mRemote.transact(38, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void setBackScreenBasicTextMarquee(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(39, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IStepOSDisplayManager
            public void notifyBackScreenCameraCapture(Bundle extra) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSDisplayManager.DESCRIPTOR);
                    _data.writeTypedObject(extra, 0);
                    this.mRemote.transact(40, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 39;
        }
    }
}
