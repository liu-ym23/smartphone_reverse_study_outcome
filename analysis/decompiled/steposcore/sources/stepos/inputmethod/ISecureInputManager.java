package stepos.inputmethod;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import stepos.inputmethod.ISecureInputModeListener;

/* loaded from: classes.dex */
public interface ISecureInputManager extends IInterface {
    public static final String DESCRIPTOR = "stepos.inputmethod.ISecureInputManager";

    void exitSecureMode() throws RemoteException;

    boolean isSecureModeActive() throws RemoteException;

    void registerSecureModeListener(ISecureInputModeListener iSecureInputModeListener) throws RemoteException;

    void unregisterSecureModeListener(ISecureInputModeListener iSecureInputModeListener) throws RemoteException;

    public static class Default implements ISecureInputManager {
        @Override // stepos.inputmethod.ISecureInputManager
        public void exitSecureMode() throws RemoteException {
        }

        @Override // stepos.inputmethod.ISecureInputManager
        public boolean isSecureModeActive() throws RemoteException {
            return false;
        }

        @Override // stepos.inputmethod.ISecureInputManager
        public void registerSecureModeListener(ISecureInputModeListener listener) throws RemoteException {
        }

        @Override // stepos.inputmethod.ISecureInputManager
        public void unregisterSecureModeListener(ISecureInputModeListener listener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISecureInputManager {
        static final int TRANSACTION_exitSecureMode = 1;
        static final int TRANSACTION_isSecureModeActive = 2;
        static final int TRANSACTION_registerSecureModeListener = 3;
        static final int TRANSACTION_unregisterSecureModeListener = 4;

        public Stub() {
            attachInterface(this, ISecureInputManager.DESCRIPTOR);
        }

        public static ISecureInputManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISecureInputManager.DESCRIPTOR);
            if (iin != null && (iin instanceof ISecureInputManager)) {
                return (ISecureInputManager) iin;
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
                    return "exitSecureMode";
                case 2:
                    return "isSecureModeActive";
                case 3:
                    return "registerSecureModeListener";
                case 4:
                    return "unregisterSecureModeListener";
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
                data.enforceInterface(ISecureInputManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ISecureInputManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    exitSecureMode();
                    reply.writeNoException();
                    return true;
                case 2:
                    boolean _result = isSecureModeActive();
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 3:
                    ISecureInputModeListener _arg0 = ISecureInputModeListener.Stub.asInterface(data.readStrongBinder());
                    registerSecureModeListener(_arg0);
                    reply.writeNoException();
                    return true;
                case 4:
                    ISecureInputModeListener _arg02 = ISecureInputModeListener.Stub.asInterface(data.readStrongBinder());
                    unregisterSecureModeListener(_arg02);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ISecureInputManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISecureInputManager.DESCRIPTOR;
            }

            @Override // stepos.inputmethod.ISecureInputManager
            public void exitSecureMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISecureInputManager.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.ISecureInputManager
            public boolean isSecureModeActive() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISecureInputManager.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.ISecureInputManager
            public void registerSecureModeListener(ISecureInputModeListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISecureInputManager.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.inputmethod.ISecureInputManager
            public void unregisterSecureModeListener(ISecureInputModeListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISecureInputManager.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
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
