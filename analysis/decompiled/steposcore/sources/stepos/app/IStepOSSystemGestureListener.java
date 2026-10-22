package stepos.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public interface IStepOSSystemGestureListener extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IStepOSSystemGestureListener";
    public static final int GESTURE_AREA_SCREENSHOT = 8;
    public static final int GESTURE_BEHAVIOR_DETECT = 0;
    public static final int GESTURE_BEHAVIOR_IGNORE = -1;
    public static final int GESTURE_PRESS_ON_BOTTOM = 10;
    public static final int GESTURE_PRESS_ON_TOP = 9;
    public static final int GESTURE_SLIDE_FROM_LEFT = 3;
    public static final int GESTURE_SLIDE_FROM_RIGHT = 4;
    public static final int GESTURE_SLIDE_FROM_SIDE_BOTTOM = 1;
    public static final int GESTURE_THREEFINGER_SWIPE_UP = 11;
    public static final int GESTURE_WINDOW_MODE = 6;

    void onGestureCanceled(int i) throws RemoteException;

    void onGesturePreTrigger(int i, MotionEvent motionEvent) throws RemoteException;

    int onGesturePreTriggerBefore(int i, MotionEvent motionEvent) throws RemoteException;

    void onGestureTriggered(int i, MotionEvent motionEvent) throws RemoteException;

    void onKeyGestureTriggered(int i, MotionEvent motionEvent, KeyEvent keyEvent) throws RemoteException;

    public static class Default implements IStepOSSystemGestureListener {
        @Override // stepos.app.IStepOSSystemGestureListener
        public int onGesturePreTriggerBefore(int gesture, MotionEvent event) throws RemoteException {
            return 0;
        }

        @Override // stepos.app.IStepOSSystemGestureListener
        public void onGesturePreTrigger(int gesture, MotionEvent event) throws RemoteException {
        }

        @Override // stepos.app.IStepOSSystemGestureListener
        public void onGestureTriggered(int gesture, MotionEvent event) throws RemoteException {
        }

        @Override // stepos.app.IStepOSSystemGestureListener
        public void onGestureCanceled(int gesture) throws RemoteException {
        }

        @Override // stepos.app.IStepOSSystemGestureListener
        public void onKeyGestureTriggered(int gesture, MotionEvent motionEvent, KeyEvent keyEvent) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSSystemGestureListener {
        static final int TRANSACTION_onGestureCanceled = 4;
        static final int TRANSACTION_onGesturePreTrigger = 2;
        static final int TRANSACTION_onGesturePreTriggerBefore = 1;
        static final int TRANSACTION_onGestureTriggered = 3;
        static final int TRANSACTION_onKeyGestureTriggered = 5;

        public Stub() {
            attachInterface(this, IStepOSSystemGestureListener.DESCRIPTOR);
        }

        public static IStepOSSystemGestureListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSSystemGestureListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSSystemGestureListener)) {
                return (IStepOSSystemGestureListener) iin;
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
                    return "onGesturePreTriggerBefore";
                case 2:
                    return "onGesturePreTrigger";
                case 3:
                    return "onGestureTriggered";
                case 4:
                    return "onGestureCanceled";
                case 5:
                    return "onKeyGestureTriggered";
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
                data.enforceInterface(IStepOSSystemGestureListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSSystemGestureListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    MotionEvent _arg1 = (MotionEvent) data.readTypedObject(MotionEvent.CREATOR);
                    int _result = onGesturePreTriggerBefore(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    MotionEvent _arg12 = (MotionEvent) data.readTypedObject(MotionEvent.CREATOR);
                    onGesturePreTrigger(_arg02, _arg12);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    MotionEvent _arg13 = (MotionEvent) data.readTypedObject(MotionEvent.CREATOR);
                    onGestureTriggered(_arg03, _arg13);
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    onGestureCanceled(_arg04);
                    return true;
                case 5:
                    int _arg05 = data.readInt();
                    MotionEvent _arg14 = (MotionEvent) data.readTypedObject(MotionEvent.CREATOR);
                    KeyEvent _arg2 = (KeyEvent) data.readTypedObject(KeyEvent.CREATOR);
                    onKeyGestureTriggered(_arg05, _arg14, _arg2);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSSystemGestureListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSSystemGestureListener.DESCRIPTOR;
            }

            @Override // stepos.app.IStepOSSystemGestureListener
            public int onGesturePreTriggerBefore(int gesture, MotionEvent event) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSystemGestureListener.DESCRIPTOR);
                    _data.writeInt(gesture);
                    _data.writeTypedObject(event, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSSystemGestureListener
            public void onGesturePreTrigger(int gesture, MotionEvent event) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSystemGestureListener.DESCRIPTOR);
                    _data.writeInt(gesture);
                    _data.writeTypedObject(event, 0);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSSystemGestureListener
            public void onGestureTriggered(int gesture, MotionEvent event) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSystemGestureListener.DESCRIPTOR);
                    _data.writeInt(gesture);
                    _data.writeTypedObject(event, 0);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSSystemGestureListener
            public void onGestureCanceled(int gesture) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSystemGestureListener.DESCRIPTOR);
                    _data.writeInt(gesture);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSSystemGestureListener
            public void onKeyGestureTriggered(int gesture, MotionEvent motionEvent, KeyEvent keyEvent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSystemGestureListener.DESCRIPTOR);
                    _data.writeInt(gesture);
                    _data.writeTypedObject(motionEvent, 0);
                    _data.writeTypedObject(keyEvent, 0);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 4;
        }
    }
}
