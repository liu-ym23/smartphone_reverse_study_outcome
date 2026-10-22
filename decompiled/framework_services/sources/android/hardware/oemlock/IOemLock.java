package android.hardware.oemlock;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IOemLock extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "782d36d56fbdca1105672dd96b8e955b6a81dadf";
    public static final int VERSION = 1;

    public static class Default implements IOemLock {
        public Default() {
        }

        @Override // android.hardware.oemlock.IOemLock
        public String getName() throws RemoteException {
            return null;
        }

        @Override // android.hardware.oemlock.IOemLock
        public boolean isOemUnlockAllowedByCarrier() throws RemoteException {
            return false;
        }

        @Override // android.hardware.oemlock.IOemLock
        public boolean isOemUnlockAllowedByDevice() throws RemoteException {
            return false;
        }

        @Override // android.hardware.oemlock.IOemLock
        public int setOemUnlockAllowedByCarrier(boolean allowed, byte[] signature) throws RemoteException {
            return 0;
        }

        @Override // android.hardware.oemlock.IOemLock
        public void setOemUnlockAllowedByDevice(boolean allowed) throws RemoteException {
        }

        @Override // android.hardware.oemlock.IOemLock
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.oemlock.IOemLock
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOemLock {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getName = 1;
        static final int TRANSACTION_isOemUnlockAllowedByCarrier = 2;
        static final int TRANSACTION_isOemUnlockAllowedByDevice = 3;
        static final int TRANSACTION_setOemUnlockAllowedByCarrier = 4;
        static final int TRANSACTION_setOemUnlockAllowedByDevice = 5;

        private static class Proxy implements IOemLock {
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
                return IOemLock.DESCRIPTOR;
            }

            @Override // android.hardware.oemlock.IOemLock
            public String getName() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemLock.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                String _result = _reply.readString();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getName is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.oemlock.IOemLock
            public boolean isOemUnlockAllowedByCarrier() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemLock.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isOemUnlockAllowedByCarrier is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.oemlock.IOemLock
            public boolean isOemUnlockAllowedByDevice() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemLock.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isOemUnlockAllowedByDevice is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.oemlock.IOemLock
            public int setOemUnlockAllowedByCarrier(boolean allowed, byte[] signature) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemLock.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(allowed);     // Catch: Throwable -> L8
                _data.writeByteArray(signature);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method setOemUnlockAllowedByCarrier is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.oemlock.IOemLock
            public void setOemUnlockAllowedByDevice(boolean allowed) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IOemLock.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(allowed);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setOemUnlockAllowedByDevice is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.oemlock.IOemLock
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IOemLock.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.oemlock.IOemLock
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IOemLock.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IOemLock.DESCRIPTOR);
        }

        public static IOemLock asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IOemLock.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IOemLock) == false) goto L12;
            return (IOemLock) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
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
            return "setOemUnlockAllowedByDevice";
        L11:
            return "setOemUnlockAllowedByCarrier";
        L13:
            return "isOemUnlockAllowedByDevice";
        L15:
            return "isOemUnlockAllowedByCarrier";
        L17:
            return "getName";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IOemLock.DESCRIPTOR;
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
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                default: goto L19;
            };
        L20:
            boolean _arg0 = data.readBoolean();
            data.enforceNoDataAvail();
            setOemUnlockAllowedByDevice(_arg0);
            reply.writeNoException();
        L25:
            return true;
        L21:
            boolean _arg1 = data.readBoolean();
            byte[] _arg2 = data.createByteArray();
            data.enforceNoDataAvail();
            int _result = setOemUnlockAllowedByCarrier(_arg1, _arg2);
            reply.writeNoException();
            reply.writeInt(_result);
            goto L25
        L22:
            boolean _result2 = isOemUnlockAllowedByDevice();
            reply.writeNoException();
            reply.writeBoolean(_result2);
            goto L25
        L23:
            boolean _result3 = isOemUnlockAllowedByCarrier();
            reply.writeNoException();
            reply.writeBoolean(_result3);
            goto L25
        L24:
            String _result4 = getName();
            reply.writeNoException();
            reply.writeString(_result4);
            goto L25
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    String getName() throws RemoteException;

    boolean isOemUnlockAllowedByCarrier() throws RemoteException;

    boolean isOemUnlockAllowedByDevice() throws RemoteException;

    int setOemUnlockAllowedByCarrier(boolean r1, byte[] r2) throws RemoteException;

    void setOemUnlockAllowedByDevice(boolean r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$oemlock$IOemLock".replace('$', '.');
    }
}
