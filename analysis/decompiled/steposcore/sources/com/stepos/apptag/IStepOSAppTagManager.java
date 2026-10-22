package com.stepos.apptag;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSAppTagManager extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.apptag.IStepOSAppTagManager";

    int getAppTagByPackage(String str) throws RemoteException;

    int getAppTagByPid(int i) throws RemoteException;

    int getAppTagByUid(int i) throws RemoteException;

    boolean isUidWakingState(int i) throws RemoteException;

    public static class Default implements IStepOSAppTagManager {
        @Override // com.stepos.apptag.IStepOSAppTagManager
        public int getAppTagByUid(int uid) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.apptag.IStepOSAppTagManager
        public int getAppTagByPackage(String packageName) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.apptag.IStepOSAppTagManager
        public int getAppTagByPid(int pid) throws RemoteException {
            return 0;
        }

        @Override // com.stepos.apptag.IStepOSAppTagManager
        public boolean isUidWakingState(int uid) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSAppTagManager {
        static final int TRANSACTION_getAppTagByPackage = 2;
        static final int TRANSACTION_getAppTagByPid = 3;
        static final int TRANSACTION_getAppTagByUid = 1;
        static final int TRANSACTION_isUidWakingState = 4;

        public Stub() {
            attachInterface(this, IStepOSAppTagManager.DESCRIPTOR);
        }

        public static IStepOSAppTagManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSAppTagManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSAppTagManager)) {
                return (IStepOSAppTagManager) iin;
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
                    return "getAppTagByUid";
                case 2:
                    return "getAppTagByPackage";
                case 3:
                    return "getAppTagByPid";
                case 4:
                    return "isUidWakingState";
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
                data.enforceInterface(IStepOSAppTagManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSAppTagManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _arg0 = data.readInt();
                    int _result = getAppTagByUid(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    String _arg02 = data.readString();
                    int _result2 = getAppTagByPackage(_arg02);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 3:
                    int _arg03 = data.readInt();
                    int _result3 = getAppTagByPid(_arg03);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 4:
                    int _arg04 = data.readInt();
                    boolean _result4 = isUidWakingState(_arg04);
                    reply.writeNoException();
                    reply.writeBoolean(_result4);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSAppTagManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSAppTagManager.DESCRIPTOR;
            }

            @Override // com.stepos.apptag.IStepOSAppTagManager
            public int getAppTagByUid(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAppTagManager.DESCRIPTOR);
                    _data.writeInt(uid);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.apptag.IStepOSAppTagManager
            public int getAppTagByPackage(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAppTagManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.apptag.IStepOSAppTagManager
            public int getAppTagByPid(int pid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAppTagManager.DESCRIPTOR);
                    _data.writeInt(pid);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.apptag.IStepOSAppTagManager
            public boolean isUidWakingState(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAppTagManager.DESCRIPTOR);
                    _data.writeInt(uid);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
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
