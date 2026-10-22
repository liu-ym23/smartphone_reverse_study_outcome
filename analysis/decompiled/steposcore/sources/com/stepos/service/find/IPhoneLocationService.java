package com.stepos.service.find;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPhoneLocationService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.service.find.IPhoneLocationService";

    String getLocationMessage() throws RemoteException;

    FindPhoneData getUserName() throws RemoteException;

    void lockPhone() throws RemoteException;

    FindPhoneData unLockPhone(String str, String str2) throws RemoteException;

    public static class Default implements IPhoneLocationService {
        @Override // com.stepos.service.find.IPhoneLocationService
        public void lockPhone() throws RemoteException {
        }

        @Override // com.stepos.service.find.IPhoneLocationService
        public FindPhoneData unLockPhone(String username, String password) throws RemoteException {
            return null;
        }

        @Override // com.stepos.service.find.IPhoneLocationService
        public FindPhoneData getUserName() throws RemoteException {
            return null;
        }

        @Override // com.stepos.service.find.IPhoneLocationService
        public String getLocationMessage() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IPhoneLocationService {
        static final int TRANSACTION_getLocationMessage = 4;
        static final int TRANSACTION_getUserName = 3;
        static final int TRANSACTION_lockPhone = 1;
        static final int TRANSACTION_unLockPhone = 2;

        public Stub() {
            attachInterface(this, IPhoneLocationService.DESCRIPTOR);
        }

        public static IPhoneLocationService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IPhoneLocationService.DESCRIPTOR);
            if (iin != null && (iin instanceof IPhoneLocationService)) {
                return (IPhoneLocationService) iin;
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
                    return "lockPhone";
                case 2:
                    return "unLockPhone";
                case 3:
                    return "getUserName";
                case 4:
                    return "getLocationMessage";
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
                data.enforceInterface(IPhoneLocationService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IPhoneLocationService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    lockPhone();
                    reply.writeNoException();
                    return true;
                case 2:
                    String _arg0 = data.readString();
                    String _arg1 = data.readString();
                    FindPhoneData _result = unLockPhone(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeTypedObject(_result, 1);
                    return true;
                case 3:
                    FindPhoneData _result2 = getUserName();
                    reply.writeNoException();
                    reply.writeTypedObject(_result2, 1);
                    return true;
                case 4:
                    String _result3 = getLocationMessage();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IPhoneLocationService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPhoneLocationService.DESCRIPTOR;
            }

            @Override // com.stepos.service.find.IPhoneLocationService
            public void lockPhone() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IPhoneLocationService.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.service.find.IPhoneLocationService
            public FindPhoneData unLockPhone(String username, String password) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IPhoneLocationService.DESCRIPTOR);
                    _data.writeString(username);
                    _data.writeString(password);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    FindPhoneData _result = (FindPhoneData) _reply.readTypedObject(FindPhoneData.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.service.find.IPhoneLocationService
            public FindPhoneData getUserName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IPhoneLocationService.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    FindPhoneData _result = (FindPhoneData) _reply.readTypedObject(FindPhoneData.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.service.find.IPhoneLocationService
            public String getLocationMessage() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IPhoneLocationService.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
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
