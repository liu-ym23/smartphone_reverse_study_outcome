package android.accounts;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSAccountManager extends IInterface {
    public static final String DESCRIPTOR = "android.accounts.IStepOSAccountManager";

    String getStepOSUserData(Account account, String str) throws RemoteException;

    public static class Default implements IStepOSAccountManager {
        @Override // android.accounts.IStepOSAccountManager
        public String getStepOSUserData(Account account, String key) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSAccountManager {
        static final int TRANSACTION_getStepOSUserData = 1;

        public Stub() {
            attachInterface(this, IStepOSAccountManager.DESCRIPTOR);
        }

        public static IStepOSAccountManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSAccountManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSAccountManager)) {
                return (IStepOSAccountManager) iin;
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
                    return "getStepOSUserData";
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
                data.enforceInterface(IStepOSAccountManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSAccountManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    Account _arg0 = (Account) data.readTypedObject(Account.CREATOR);
                    String _arg1 = data.readString();
                    String _result = getStepOSUserData(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSAccountManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSAccountManager.DESCRIPTOR;
            }

            @Override // android.accounts.IStepOSAccountManager
            public String getStepOSUserData(Account account, String key) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSAccountManager.DESCRIPTOR);
                    _data.writeTypedObject(account, 0);
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
        }

        public int getMaxTransactionId() {
            return 0;
        }
    }
}
