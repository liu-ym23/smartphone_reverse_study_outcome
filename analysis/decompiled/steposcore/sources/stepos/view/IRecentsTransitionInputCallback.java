package stepos.view;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;

/* loaded from: classes.dex */
public interface IRecentsTransitionInputCallback extends IInterface {
    public static final String DESCRIPTOR = "stepos.view.IRecentsTransitionInputCallback";

    void notifyKeyEvent(KeyEvent keyEvent) throws RemoteException;

    public static class Default implements IRecentsTransitionInputCallback {
        @Override // stepos.view.IRecentsTransitionInputCallback
        public void notifyKeyEvent(KeyEvent keyEvent) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRecentsTransitionInputCallback {
        static final int TRANSACTION_notifyKeyEvent = 1;

        public Stub() {
            attachInterface(this, IRecentsTransitionInputCallback.DESCRIPTOR);
        }

        public static IRecentsTransitionInputCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IRecentsTransitionInputCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IRecentsTransitionInputCallback)) {
                return (IRecentsTransitionInputCallback) iin;
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
                    return "notifyKeyEvent";
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
                data.enforceInterface(IRecentsTransitionInputCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IRecentsTransitionInputCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    KeyEvent _arg0 = (KeyEvent) data.readTypedObject(KeyEvent.CREATOR);
                    notifyKeyEvent(_arg0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IRecentsTransitionInputCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IRecentsTransitionInputCallback.DESCRIPTOR;
            }

            @Override // stepos.view.IRecentsTransitionInputCallback
            public void notifyKeyEvent(KeyEvent keyEvent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IRecentsTransitionInputCallback.DESCRIPTOR);
                    _data.writeTypedObject(keyEvent, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 0;
        }
    }
}
