package stepos.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public interface IStepOSGestureCallback extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IStepOSGestureCallback";

    void onGestureTrigger(KeyEvent keyEvent, MotionEvent motionEvent) throws RemoteException;

    public static class Default implements IStepOSGestureCallback {
        @Override // stepos.app.IStepOSGestureCallback
        public void onGestureTrigger(KeyEvent gesture, MotionEvent motionEvent) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSGestureCallback {
        static final int TRANSACTION_onGestureTrigger = 1;

        public Stub() {
            attachInterface(this, IStepOSGestureCallback.DESCRIPTOR);
        }

        public static IStepOSGestureCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSGestureCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSGestureCallback)) {
                return (IStepOSGestureCallback) iin;
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
                    return "onGestureTrigger";
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
                data.enforceInterface(IStepOSGestureCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSGestureCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    KeyEvent _arg0 = (KeyEvent) data.readTypedObject(KeyEvent.CREATOR);
                    MotionEvent _arg1 = (MotionEvent) data.readTypedObject(MotionEvent.CREATOR);
                    onGestureTrigger(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSGestureCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSGestureCallback.DESCRIPTOR;
            }

            @Override // stepos.app.IStepOSGestureCallback
            public void onGestureTrigger(KeyEvent gesture, MotionEvent motionEvent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSGestureCallback.DESCRIPTOR);
                    _data.writeTypedObject(gesture, 0);
                    _data.writeTypedObject(motionEvent, 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 0;
        }
    }
}
