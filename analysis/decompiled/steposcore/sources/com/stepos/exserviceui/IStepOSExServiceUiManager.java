package com.stepos.exserviceui;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.exserviceui.IExServiceUiCallback;

/* loaded from: classes.dex */
public interface IStepOSExServiceUiManager extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.exserviceui.IStepOSExServiceUiManager";

    boolean registerCallback(String str, IExServiceUiCallback iExServiceUiCallback) throws RemoteException;

    void reportUserAction(long j, int i) throws RemoteException;

    boolean unregisterCallback(String str, IExServiceUiCallback iExServiceUiCallback) throws RemoteException;

    public static class Default implements IStepOSExServiceUiManager {
        @Override // com.stepos.exserviceui.IStepOSExServiceUiManager
        public boolean registerCallback(String packageName, IExServiceUiCallback callback) throws RemoteException {
            return false;
        }

        @Override // com.stepos.exserviceui.IStepOSExServiceUiManager
        public boolean unregisterCallback(String packageName, IExServiceUiCallback callback) throws RemoteException {
            return false;
        }

        @Override // com.stepos.exserviceui.IStepOSExServiceUiManager
        public void reportUserAction(long eventId, int action) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSExServiceUiManager {
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_reportUserAction = 3;
        static final int TRANSACTION_unregisterCallback = 2;

        public Stub() {
            attachInterface(this, IStepOSExServiceUiManager.DESCRIPTOR);
        }

        public static IStepOSExServiceUiManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSExServiceUiManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSExServiceUiManager)) {
                return (IStepOSExServiceUiManager) iin;
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
                    return "reportUserAction";
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
                data.enforceInterface(IStepOSExServiceUiManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSExServiceUiManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    IExServiceUiCallback _arg1 = IExServiceUiCallback.Stub.asInterface(data.readStrongBinder());
                    boolean _result = registerCallback(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 2:
                    String _arg02 = data.readString();
                    IExServiceUiCallback _arg12 = IExServiceUiCallback.Stub.asInterface(data.readStrongBinder());
                    boolean _result2 = unregisterCallback(_arg02, _arg12);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 3:
                    long _arg03 = data.readLong();
                    int _arg13 = data.readInt();
                    reportUserAction(_arg03, _arg13);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSExServiceUiManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSExServiceUiManager.DESCRIPTOR;
            }

            @Override // com.stepos.exserviceui.IStepOSExServiceUiManager
            public boolean registerCallback(String packageName, IExServiceUiCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSExServiceUiManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.exserviceui.IStepOSExServiceUiManager
            public boolean unregisterCallback(String packageName, IExServiceUiCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSExServiceUiManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.exserviceui.IStepOSExServiceUiManager
            public void reportUserAction(long eventId, int action) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSExServiceUiManager.DESCRIPTOR);
                    _data.writeLong(eventId);
                    _data.writeInt(action);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 2;
        }
    }
}
