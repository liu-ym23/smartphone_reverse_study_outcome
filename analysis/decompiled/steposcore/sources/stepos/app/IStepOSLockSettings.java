package stepos.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSLockSettings extends IInterface {
    public static final String DESCRIPTOR = "stepos.app.IStepOSLockSettings";

    boolean checkStepOSPassword(int i, String str, int i2) throws RemoteException;

    boolean clearStepOSPassword(int i, int i2) throws RemoteException;

    boolean hasStepOSPassword(int i, int i2) throws RemoteException;

    boolean setStepOSPassword(int i, String str, int i2) throws RemoteException;

    int stepOSProcessLeftTimes(boolean z) throws RemoteException;

    void writePasswordHash(byte[] bArr, int i, int i2) throws RemoteException;

    public static class Default implements IStepOSLockSettings {
        @Override // stepos.app.IStepOSLockSettings
        public boolean setStepOSPassword(int type, String password, int userId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSLockSettings
        public boolean checkStepOSPassword(int type, String password, int userId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSLockSettings
        public boolean hasStepOSPassword(int type, int userId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSLockSettings
        public boolean clearStepOSPassword(int type, int userId) throws RemoteException {
            return false;
        }

        @Override // stepos.app.IStepOSLockSettings
        public void writePasswordHash(byte[] hash, int type, int userId) throws RemoteException {
        }

        @Override // stepos.app.IStepOSLockSettings
        public int stepOSProcessLeftTimes(boolean reset) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSLockSettings {
        static final int TRANSACTION_checkStepOSPassword = 2;
        static final int TRANSACTION_clearStepOSPassword = 4;
        static final int TRANSACTION_hasStepOSPassword = 3;
        static final int TRANSACTION_setStepOSPassword = 1;
        static final int TRANSACTION_stepOSProcessLeftTimes = 6;
        static final int TRANSACTION_writePasswordHash = 5;

        public Stub() {
            attachInterface(this, IStepOSLockSettings.DESCRIPTOR);
        }

        public static IStepOSLockSettings asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSLockSettings.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSLockSettings)) {
                return (IStepOSLockSettings) iin;
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
                    return "setStepOSPassword";
                case 2:
                    return "checkStepOSPassword";
                case 3:
                    return "hasStepOSPassword";
                case 4:
                    return "clearStepOSPassword";
                case 5:
                    return "writePasswordHash";
                case 6:
                    return "stepOSProcessLeftTimes";
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
                data.enforceInterface(IStepOSLockSettings.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSLockSettings.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    String _arg1 = data.readString();
                    int _arg2 = data.readInt();
                    boolean _result = setStepOSPassword(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeBoolean(_result);
                    return true;
                case 2:
                    int _arg02 = data.readInt();
                    String _arg12 = data.readString();
                    int _arg22 = data.readInt();
                    boolean _result2 = checkStepOSPassword(_arg02, _arg12, _arg22);
                    reply.writeNoException();
                    reply.writeBoolean(_result2);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    int _arg13 = data.readInt();
                    boolean _result3 = hasStepOSPassword(_arg03, _arg13);
                    reply.writeNoException();
                    reply.writeBoolean(_result3);
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    int _arg14 = data.readInt();
                    boolean _result4 = clearStepOSPassword(_arg04, _arg14);
                    reply.writeNoException();
                    reply.writeBoolean(_result4);
                    return true;
                case 5:
                    byte[] _arg05 = data.createByteArray();
                    int _arg15 = data.readInt();
                    int _arg23 = data.readInt();
                    writePasswordHash(_arg05, _arg15, _arg23);
                    reply.writeNoException();
                    return true;
                case 6:
                    boolean _arg06 = data.readBoolean();
                    int _result5 = stepOSProcessLeftTimes(_arg06);
                    reply.writeNoException();
                    reply.writeInt(_result5);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSLockSettings {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSLockSettings.DESCRIPTOR;
            }

            @Override // stepos.app.IStepOSLockSettings
            public boolean setStepOSPassword(int type, String password, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSLockSettings.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(password);
                    _data.writeInt(userId);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSLockSettings
            public boolean checkStepOSPassword(int type, String password, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSLockSettings.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(password);
                    _data.writeInt(userId);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSLockSettings
            public boolean hasStepOSPassword(int type, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSLockSettings.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(userId);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSLockSettings
            public boolean clearStepOSPassword(int type, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSLockSettings.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(userId);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSLockSettings
            public void writePasswordHash(byte[] hash, int type, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSLockSettings.DESCRIPTOR);
                    _data.writeByteArray(hash);
                    _data.writeInt(type);
                    _data.writeInt(userId);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.app.IStepOSLockSettings
            public int stepOSProcessLeftTimes(boolean reset) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSLockSettings.DESCRIPTOR);
                    _data.writeBoolean(reset);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 5;
        }
    }
}
