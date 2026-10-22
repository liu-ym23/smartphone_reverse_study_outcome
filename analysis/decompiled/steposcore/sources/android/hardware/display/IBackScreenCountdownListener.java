package android.hardware.display;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IBackScreenCountdownListener extends IInterface {
    public static final String DESCRIPTOR = "android.hardware.display.IBackScreenCountdownListener";

    void onCancel() throws RemoteException;

    void onEnd() throws RemoteException;

    void onError(String str) throws RemoteException;

    void onStart(int i) throws RemoteException;

    void onUpdate(int i) throws RemoteException;

    public static class Default implements IBackScreenCountdownListener {
        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onStart(int seconds) throws RemoteException {
        }

        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onEnd() throws RemoteException {
        }

        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onCancel() throws RemoteException {
        }

        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onError(String reason) throws RemoteException {
        }

        @Override // android.hardware.display.IBackScreenCountdownListener
        public void onUpdate(int remainingSeconds) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IBackScreenCountdownListener {
        static final int TRANSACTION_onCancel = 3;
        static final int TRANSACTION_onEnd = 2;
        static final int TRANSACTION_onError = 4;
        static final int TRANSACTION_onStart = 1;
        static final int TRANSACTION_onUpdate = 5;

        public Stub() {
            attachInterface(this, IBackScreenCountdownListener.DESCRIPTOR);
        }

        public static IBackScreenCountdownListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IBackScreenCountdownListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IBackScreenCountdownListener)) {
                return (IBackScreenCountdownListener) iin;
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
                    return "onStart";
                case 2:
                    return "onEnd";
                case 3:
                    return "onCancel";
                case 4:
                    return "onError";
                case 5:
                    return "onUpdate";
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
                data.enforceInterface(IBackScreenCountdownListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IBackScreenCountdownListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    onStart(_arg0);
                    return true;
                case 2:
                    onEnd();
                    return true;
                case 3:
                    onCancel();
                    return true;
                case 4:
                    String _arg02 = data.readString();
                    onError(_arg02);
                    return true;
                case 5:
                    int _arg03 = data.readInt();
                    onUpdate(_arg03);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IBackScreenCountdownListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBackScreenCountdownListener.DESCRIPTOR;
            }

            @Override // android.hardware.display.IBackScreenCountdownListener
            public void onStart(int seconds) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IBackScreenCountdownListener.DESCRIPTOR);
                    _data.writeInt(seconds);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IBackScreenCountdownListener
            public void onEnd() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IBackScreenCountdownListener.DESCRIPTOR);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IBackScreenCountdownListener
            public void onCancel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IBackScreenCountdownListener.DESCRIPTOR);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IBackScreenCountdownListener
            public void onError(String reason) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IBackScreenCountdownListener.DESCRIPTOR);
                    _data.writeString(reason);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.hardware.display.IBackScreenCountdownListener
            public void onUpdate(int remainingSeconds) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IBackScreenCountdownListener.DESCRIPTOR);
                    _data.writeInt(remainingSeconds);
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
