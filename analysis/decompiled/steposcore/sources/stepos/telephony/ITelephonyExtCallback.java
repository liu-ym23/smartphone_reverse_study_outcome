package stepos.telephony;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ITelephonyExtCallback extends IInterface {
    public static final String DESCRIPTOR = "stepos.telephony.ITelephonyExtCallback";

    String asString() throws RemoteException;

    String getId() throws RemoteException;

    String getRequest() throws RemoteException;

    void onNotify(String str, Bundle bundle) throws RemoteException;

    void setId(String str) throws RemoteException;

    public static class Default implements ITelephonyExtCallback {
        @Override // stepos.telephony.ITelephonyExtCallback
        public void onNotify(String request, Bundle params) throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExtCallback
        public String getId() throws RemoteException {
            return null;
        }

        @Override // stepos.telephony.ITelephonyExtCallback
        public void setId(String id) throws RemoteException {
        }

        @Override // stepos.telephony.ITelephonyExtCallback
        public String asString() throws RemoteException {
            return null;
        }

        @Override // stepos.telephony.ITelephonyExtCallback
        public String getRequest() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITelephonyExtCallback {
        static final int TRANSACTION_asString = 4;
        static final int TRANSACTION_getId = 2;
        static final int TRANSACTION_getRequest = 5;
        static final int TRANSACTION_onNotify = 1;
        static final int TRANSACTION_setId = 3;

        public Stub() {
            attachInterface(this, ITelephonyExtCallback.DESCRIPTOR);
        }

        public static ITelephonyExtCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ITelephonyExtCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof ITelephonyExtCallback)) {
                return (ITelephonyExtCallback) iin;
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
                    return "onNotify";
                case 2:
                    return "getId";
                case 3:
                    return "setId";
                case 4:
                    return "asString";
                case 5:
                    return "getRequest";
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
                data.enforceInterface(ITelephonyExtCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ITelephonyExtCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    Bundle _arg1 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                    onNotify(_arg0, _arg1);
                    return true;
                case 2:
                    String _result = getId();
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 3:
                    String _arg02 = data.readString();
                    setId(_arg02);
                    return true;
                case 4:
                    String _result2 = asString();
                    reply.writeNoException();
                    reply.writeString(_result2);
                    return true;
                case 5:
                    String _result3 = getRequest();
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ITelephonyExtCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITelephonyExtCallback.DESCRIPTOR;
            }

            @Override // stepos.telephony.ITelephonyExtCallback
            public void onNotify(String request, Bundle params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExtCallback.DESCRIPTOR);
                    _data.writeString(request);
                    _data.writeTypedObject(params, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExtCallback
            public String getId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExtCallback.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExtCallback
            public void setId(String id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExtCallback.DESCRIPTOR);
                    _data.writeString(id);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExtCallback
            public String asString() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExtCallback.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // stepos.telephony.ITelephonyExtCallback
            public String getRequest() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ITelephonyExtCallback.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
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
            return 4;
        }
    }
}
