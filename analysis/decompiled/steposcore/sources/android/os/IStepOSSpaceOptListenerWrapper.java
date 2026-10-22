package android.os;

/* loaded from: classes.dex */
public interface IStepOSSpaceOptListenerWrapper extends IInterface {
    public static final String DESCRIPTOR = "android.os.IStepOSSpaceOptListenerWrapper";

    String getQuerySQL() throws RemoteException;

    void onFinished(long j) throws RemoteException;

    void onProgress(int i) throws RemoteException;

    void onQueryDb(String str, int i, String str2, String str3, int i2, int i3, String str4) throws RemoteException;

    public static class Default implements IStepOSSpaceOptListenerWrapper {
        @Override // android.os.IStepOSSpaceOptListenerWrapper
        public void onProgress(int progress) throws RemoteException {
        }

        @Override // android.os.IStepOSSpaceOptListenerWrapper
        public void onFinished(long totalSize) throws RemoteException {
        }

        @Override // android.os.IStepOSSpaceOptListenerWrapper
        public String getQuerySQL() throws RemoteException {
            return null;
        }

        @Override // android.os.IStepOSSpaceOptListenerWrapper
        public void onQueryDb(String id, int fileSize, String fileName, String packageName, int ts, int status, String filePath) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSSpaceOptListenerWrapper {
        static final int TRANSACTION_getQuerySQL = 3;
        static final int TRANSACTION_onFinished = 2;
        static final int TRANSACTION_onProgress = 1;
        static final int TRANSACTION_onQueryDb = 4;

        public Stub() {
            attachInterface(this, IStepOSSpaceOptListenerWrapper.DESCRIPTOR);
        }

        public static IStepOSSpaceOptListenerWrapper asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSSpaceOptListenerWrapper.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSSpaceOptListenerWrapper)) {
                return (IStepOSSpaceOptListenerWrapper) iin;
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
                    return "onProgress";
                case 2:
                    return "onFinished";
                case 3:
                    return "getQuerySQL";
                case 4:
                    return "onQueryDb";
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
                data.enforceInterface(IStepOSSpaceOptListenerWrapper.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSSpaceOptListenerWrapper.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    onProgress(_arg0);
                    return true;
                case 2:
                    long _arg02 = data.readLong();
                    onFinished(_arg02);
                    return true;
                case 3:
                    String _result = getQuerySQL();
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 4:
                    String _arg03 = data.readString();
                    int _arg1 = data.readInt();
                    String _arg2 = data.readString();
                    String _arg3 = data.readString();
                    int _arg4 = data.readInt();
                    int _arg5 = data.readInt();
                    String _arg6 = data.readString();
                    onQueryDb(_arg03, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSSpaceOptListenerWrapper {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSSpaceOptListenerWrapper.DESCRIPTOR;
            }

            @Override // android.os.IStepOSSpaceOptListenerWrapper
            public void onProgress(int progress) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSpaceOptListenerWrapper.DESCRIPTOR);
                    _data.writeInt(progress);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSSpaceOptListenerWrapper
            public void onFinished(long totalSize) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSpaceOptListenerWrapper.DESCRIPTOR);
                    _data.writeLong(totalSize);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSSpaceOptListenerWrapper
            public String getQuerySQL() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSpaceOptListenerWrapper.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.os.IStepOSSpaceOptListenerWrapper
            public void onQueryDb(String id, int fileSize, String fileName, String packageName, int ts, int status, String filePath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSSpaceOptListenerWrapper.DESCRIPTOR);
                    _data.writeString(id);
                    _data.writeInt(fileSize);
                    _data.writeString(fileName);
                    _data.writeString(packageName);
                    _data.writeInt(ts);
                    _data.writeInt(status);
                    _data.writeString(filePath);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 3;
        }
    }
}
