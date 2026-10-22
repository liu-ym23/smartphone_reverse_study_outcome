package stepos.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import stepos.app.IStepOSGestureCallback;

/* loaded from: classes.dex */
public interface IStepOSGestureManager extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IStepOSGestureManager";

    void registerCallback(IStepOSGestureCallback iStepOSGestureCallback, String str) throws RemoteException;

    void setPressureAreaEnabled(int i, boolean z) throws RemoteException;

    void triggerGesture(KeyEvent keyEvent, MotionEvent motionEvent) throws RemoteException;

    void unregisterCallback(IStepOSGestureCallback iStepOSGestureCallback) throws RemoteException;

    public static class Default implements IStepOSGestureManager {
        @Override // stepos.app.IStepOSGestureManager
        public void registerCallback(IStepOSGestureCallback callback, String tag) throws RemoteException {
        }

        @Override // stepos.app.IStepOSGestureManager
        public void unregisterCallback(IStepOSGestureCallback callback) throws RemoteException {
        }

        @Override // stepos.app.IStepOSGestureManager
        public void triggerGesture(KeyEvent gesture, MotionEvent motionEvent) throws RemoteException {
        }

        @Override // stepos.app.IStepOSGestureManager
        public void setPressureAreaEnabled(int areaCode, boolean enabled) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSGestureManager {
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_setPressureAreaEnabled = 4;
        static final int TRANSACTION_triggerGesture = 3;
        static final int TRANSACTION_unregisterCallback = 2;

        public Stub() {
            attachInterface(this, IStepOSGestureManager.DESCRIPTOR);
        }

        public static IStepOSGestureManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSGestureManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSGestureManager)) {
                return (IStepOSGestureManager) iin;
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
                    return "registerCallback";
                case 2:
                    return "unregisterCallback";
                case 3:
                    return "triggerGesture";
                case 4:
                    return "setPressureAreaEnabled";
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
                data.enforceInterface(IStepOSGestureManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSGestureManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    IStepOSGestureCallback _arg0 = IStepOSGestureCallback.Stub.asInterface(data.readStrongBinder());
                    String _arg1 = data.readString();
                    registerCallback(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 2:
                    IStepOSGestureCallback _arg02 = IStepOSGestureCallback.Stub.asInterface(data.readStrongBinder());
                    unregisterCallback(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    KeyEvent _arg03 = (KeyEvent) data.readTypedObject(KeyEvent.CREATOR);
                    MotionEvent _arg12 = (MotionEvent) data.readTypedObject(MotionEvent.CREATOR);
                    triggerGesture(_arg03, _arg12);
                    reply.writeNoException();
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    boolean _arg13 = data.readBoolean();
                    setPressureAreaEnabled(_arg04, _arg13);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSGestureManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSGestureManager.DESCRIPTOR;
            }

            @Override // stepos.app.IStepOSGestureManager
            public void registerCallback(IStepOSGestureCallback callback, String tag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSGestureManager.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    _data.writeString(tag);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSGestureManager
            public void unregisterCallback(IStepOSGestureCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSGestureManager.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSGestureManager
            public void triggerGesture(KeyEvent gesture, MotionEvent motionEvent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSGestureManager.DESCRIPTOR);
                    _data.writeTypedObject(gesture, 0);
                    _data.writeTypedObject(motionEvent, 0);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSGestureManager
            public void setPressureAreaEnabled(int areaCode, boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSGestureManager.DESCRIPTOR);
                    _data.writeInt(areaCode);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 3;
        }
    }
}
