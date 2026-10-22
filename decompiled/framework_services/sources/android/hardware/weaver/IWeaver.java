package android.hardware.weaver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IWeaver extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "0d60d74c2704ad281e219244514516db8482ef3d";
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_INCORRECT_KEY = 2;
    public static final int STATUS_THROTTLE = 3;
    public static final int VERSION = 2;

    public static class Default implements IWeaver {
        public Default() {
        }

        @Override // android.hardware.weaver.IWeaver
        public WeaverConfig getConfig() throws RemoteException {
            return null;
        }

        @Override // android.hardware.weaver.IWeaver
        public WeaverReadResponse read(int slotId, byte[] key) throws RemoteException {
            return null;
        }

        @Override // android.hardware.weaver.IWeaver
        public void write(int slotId, byte[] key, byte[] value) throws RemoteException {
        }

        @Override // android.hardware.weaver.IWeaver
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.weaver.IWeaver
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IWeaver {
        static final int TRANSACTION_getConfig = 1;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_read = 2;
        static final int TRANSACTION_write = 3;

        private static class Proxy implements IWeaver {
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
                return IWeaver.DESCRIPTOR;
            }

            @Override // android.hardware.weaver.IWeaver
            public WeaverConfig getConfig() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IWeaver.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                WeaverConfig _result = (WeaverConfig) _reply.readTypedObject(WeaverConfig.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getConfig is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.weaver.IWeaver
            public WeaverReadResponse read(int slotId, byte[] key) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IWeaver.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(slotId);     // Catch: Throwable -> L8
                _data.writeByteArray(key);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                WeaverReadResponse _result = (WeaverReadResponse) _reply.readTypedObject(WeaverReadResponse.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method read is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.weaver.IWeaver
            public void write(int slotId, byte[] key, byte[] value) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IWeaver.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(slotId);     // Catch: Throwable -> L8
                _data.writeByteArray(key);     // Catch: Throwable -> L8
                _data.writeByteArray(value);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method write is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.weaver.IWeaver
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IWeaver.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.weaver.IWeaver
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IWeaver.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IWeaver.DESCRIPTOR);
        }

        public static IWeaver asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IWeaver.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IWeaver) == false) goto L12;
            return (IWeaver) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L13;
                case 2: goto L11;
                case 3: goto L9;
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
            return "write";
        L11:
            return "read";
        L13:
            return "getConfig";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IWeaver.DESCRIPTOR;
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
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                default: goto L19;
            };
        L20:
            int _arg0 = data.readInt();
            byte[] _arg1 = data.createByteArray();
            byte[] _arg2 = data.createByteArray();
            data.enforceNoDataAvail();
            write(_arg0, _arg1, _arg2);
            reply.writeNoException();
        L23:
            return true;
        L21:
            int _arg3 = data.readInt();
            byte[] _arg4 = data.createByteArray();
            data.enforceNoDataAvail();
            WeaverReadResponse _result = read(_arg3, _arg4);
            reply.writeNoException();
            reply.writeTypedObject(_result, 1);
            goto L23
        L22:
            WeaverConfig _result2 = getConfig();
            reply.writeNoException();
            reply.writeTypedObject(_result2, 1);
            goto L23
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    WeaverConfig getConfig() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    WeaverReadResponse read(int r1, byte[] r2) throws RemoteException;

    void write(int r1, byte[] r2, byte[] r3) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$weaver$IWeaver".replace('$', '.');
    }
}
