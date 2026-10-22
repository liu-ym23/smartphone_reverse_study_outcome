package android.hardware.security.secretkeeper;

import android.hardware.security.authgraph.IAuthGraphKeyExchange;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ISecretkeeper extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final int ERROR_INTERNAL_ERROR = 2;
    public static final int ERROR_REQUEST_MALFORMED = 3;
    public static final int ERROR_UNKNOWN_KEY_ID = 1;
    public static final String HASH = "347439bd6088bd24a72e789a616a1586863e43b8";
    public static final int VERSION = 1;

    public static class Default implements ISecretkeeper {
        public Default() {
        }

        @Override // android.hardware.security.secretkeeper.ISecretkeeper
        public IAuthGraphKeyExchange getAuthGraphKe() throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.secretkeeper.ISecretkeeper
        public byte[] processSecretManagementRequest(byte[] request) throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.secretkeeper.ISecretkeeper
        public void deleteIds(SecretId[] ids) throws RemoteException {
        }

        @Override // android.hardware.security.secretkeeper.ISecretkeeper
        public void deleteAll() throws RemoteException {
        }

        @Override // android.hardware.security.secretkeeper.ISecretkeeper
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.security.secretkeeper.ISecretkeeper
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISecretkeeper {
        static final int TRANSACTION_deleteAll = 4;
        static final int TRANSACTION_deleteIds = 3;
        static final int TRANSACTION_getAuthGraphKe = 1;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_processSecretManagementRequest = 2;

        private static class Proxy implements ISecretkeeper {
            private String mCachedHash;
            private int mCachedVersion;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mCachedVersion = -1;
                this.mCachedHash = "-1";
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISecretkeeper.DESCRIPTOR;
            }

            @Override // android.hardware.security.secretkeeper.ISecretkeeper
            public IAuthGraphKeyExchange getAuthGraphKe() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ISecretkeeper.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                IAuthGraphKeyExchange _result = IAuthGraphKeyExchange.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getAuthGraphKe is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.secretkeeper.ISecretkeeper
            public byte[] processSecretManagementRequest(byte[] request) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ISecretkeeper.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeByteArray(request);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                byte[] _result = _reply.createByteArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method processSecretManagementRequest is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.secretkeeper.ISecretkeeper
            public void deleteIds(SecretId[] ids) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ISecretkeeper.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedArray(ids, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method deleteIds is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.secretkeeper.ISecretkeeper
            public void deleteAll() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ISecretkeeper.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method deleteAll is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.secretkeeper.ISecretkeeper
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(ISecretkeeper.DESCRIPTOR);     // Catch: Throwable -> L7
                this.mRemote.transact(16777215, data, reply, 0);     // Catch: Throwable -> L7
                reply.readException();     // Catch: Throwable -> L7
                this.mCachedVersion = reply.readInt();     // Catch: Throwable -> L7
                reply.recycle();
                data.recycle();
            L7:
                th = move-exception;
                reply.recycle();
                data.recycle();
                throw th;
            L11:
                return this.mCachedVersion;
            }

            @Override // android.hardware.security.secretkeeper.ISecretkeeper
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(ISecretkeeper.DESCRIPTOR);     // Catch: Throwable -> L10
                this.mRemote.transact(Stub.TRANSACTION_getInterfaceHash, data, reply, 0);     // Catch: Throwable -> L10
                reply.readException();     // Catch: Throwable -> L10
                this.mCachedHash = reply.readString();     // Catch: Throwable -> L10
                reply.recycle();     // Catch: Throwable -> L8
                data.recycle();     // Catch: Throwable -> L8
                goto L13
            L10:
                th = move-exception;
                reply.recycle();     // Catch: Throwable -> L8
                data.recycle();     // Catch: Throwable -> L8
                throw th;     // Catch: Throwable -> L8
            L13:
                String r0 = this.mCachedHash;     // Catch: Throwable -> L8
                monitor-exit(this);
                return r0;
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, ISecretkeeper.DESCRIPTOR);
        }

        public static ISecretkeeper asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(ISecretkeeper.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof ISecretkeeper) == false) goto L12;
            return (ISecretkeeper) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L15;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L9;
                case 16777214: goto L7;
                case 16777215: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "getInterfaceVersion";
        L7:
            return "getInterfaceHash";
        L9:
            return "deleteAll";
        L11:
            return "deleteIds";
        L13:
            return "processSecretManagementRequest";
        L15:
            return "getAuthGraphKe";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = ISecretkeeper.DESCRIPTOR;
            if (code < 1) goto L7;
            if (code > 16777215) goto L7;
            data.enforceInterface(descriptor);
        L7:
            if (code != 1598968902) goto L10;
            reply.writeString(descriptor);
            return true;
        L10:
            if (code != 16777215) goto L14;
            reply.writeNoException();
            reply.writeInt(getInterfaceVersion());
            return true;
        L14:
            if (code != TRANSACTION_getInterfaceHash) goto L17;
            reply.writeNoException();
            reply.writeString(getInterfaceHash());
            return true;
        L17:
            switch(code) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                default: goto L19;
            };
        L20:
            deleteAll();
            reply.writeNoException();
        L24:
            return true;
        L21:
            SecretId[] _arg0 = (SecretId[]) data.createTypedArray(SecretId.CREATOR);
            data.enforceNoDataAvail();
            deleteIds(_arg0);
            reply.writeNoException();
            goto L24
        L22:
            byte[] _arg1 = data.createByteArray();
            data.enforceNoDataAvail();
            byte[] _result = processSecretManagementRequest(_arg1);
            reply.writeNoException();
            reply.writeByteArray(_result);
            goto L24
        L23:
            IAuthGraphKeyExchange _result2 = getAuthGraphKe();
            reply.writeNoException();
            reply.writeStrongInterface(_result2);
            goto L24
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    void deleteAll() throws RemoteException;

    void deleteIds(SecretId[] r1) throws RemoteException;

    IAuthGraphKeyExchange getAuthGraphKe() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    byte[] processSecretManagementRequest(byte[] r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$security$secretkeeper$ISecretkeeper".replace('$', '.');
    }
}
