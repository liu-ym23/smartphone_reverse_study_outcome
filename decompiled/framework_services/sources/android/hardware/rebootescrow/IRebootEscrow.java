package android.hardware.rebootescrow;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IRebootEscrow extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "ba450432e0dab8ee7bbc30013819ea8aef12054b";
    public static final int VERSION = 1;

    public static class Default implements IRebootEscrow {
        public Default() {
        }

        @Override // android.hardware.rebootescrow.IRebootEscrow
        public void storeKey(byte[] kek) throws RemoteException {
        }

        @Override // android.hardware.rebootescrow.IRebootEscrow
        public byte[] retrieveKey() throws RemoteException {
            return null;
        }

        @Override // android.hardware.rebootescrow.IRebootEscrow
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.rebootescrow.IRebootEscrow
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IRebootEscrow {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_retrieveKey = 2;
        static final int TRANSACTION_storeKey = 1;

        private static class Proxy implements IRebootEscrow {
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
                return IRebootEscrow.DESCRIPTOR;
            }

            @Override // android.hardware.rebootescrow.IRebootEscrow
            public void storeKey(byte[] kek) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IRebootEscrow.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeByteArray(kek);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method storeKey is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.rebootescrow.IRebootEscrow
            public byte[] retrieveKey() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IRebootEscrow.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                byte[] _result = _reply.createByteArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method retrieveKey is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.rebootescrow.IRebootEscrow
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IRebootEscrow.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.rebootescrow.IRebootEscrow
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IRebootEscrow.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IRebootEscrow.DESCRIPTOR);
        }

        public static IRebootEscrow asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IRebootEscrow.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IRebootEscrow) == false) goto L12;
            return (IRebootEscrow) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L11;
                case 2: goto L9;
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
            return "retrieveKey";
        L11:
            return "storeKey";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IRebootEscrow.DESCRIPTOR;
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
                case 1: goto L21;
                case 2: goto L20;
                default: goto L19;
            };
        L20:
            byte[] _result = retrieveKey();
            reply.writeNoException();
            reply.writeByteArray(_result);
        L22:
            return true;
        L21:
            byte[] _arg0 = data.createByteArray();
            data.enforceNoDataAvail();
            storeKey(_arg0);
            reply.writeNoException();
            goto L22
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    byte[] retrieveKey() throws RemoteException;

    void storeKey(byte[] r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$rebootescrow$IRebootEscrow".replace('$', '.');
    }
}
