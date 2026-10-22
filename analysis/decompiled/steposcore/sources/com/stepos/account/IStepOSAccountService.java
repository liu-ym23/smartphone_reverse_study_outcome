package com.stepos.account;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSAccountService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.account.IStepOSAccountService";

    String getUserData(String str) throws RemoteException;

    void setUserData(String str, String str2) throws RemoteException;

    public static class Default implements IStepOSAccountService {
        @Override // com.stepos.account.IStepOSAccountService
        public String getUserData(String key) throws RemoteException {
            return null;
        }

        @Override // com.stepos.account.IStepOSAccountService
        public void setUserData(String key, String value) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSAccountService {
        static final int TRANSACTION_getUserData = 1;
        static final int TRANSACTION_setUserData = 2;

        public Stub() {
            attachInterface(this, IStepOSAccountService.DESCRIPTOR);
        }

        public static IStepOSAccountService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSAccountService.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSAccountService)) {
                return (IStepOSAccountService) iin;
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
                    return "getUserData";
                case 2:
                    return "setUserData";
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
                data.enforceInterface(IStepOSAccountService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSAccountService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    String _result = getUserData(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 2:
                    String _arg02 = data.readString();
                    String _arg1 = data.readString();
                    setUserData(_arg02, _arg1);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSAccountService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSAccountService.DESCRIPTOR;
            }

            @Override // com.stepos.account.IStepOSAccountService
            public String getUserData(String key) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccountService.DESCRIPTOR);
                    _data.writeString(key);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.account.IStepOSAccountService
            public void setUserData(String key, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccountService.DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeString(value);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 1;
        }
    }
}
