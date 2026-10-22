package vendor.bytedance.thermalextservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IThermalExtService extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "9fa87beb6e476c774f619c66a68b52aab48242b3";
    public static final int VERSION = 2;

    public static class Default implements IThermalExtService {
        public Default() {
        }

        @Override // vendor.bytedance.thermalextservice.IThermalExtService
        public int registerCallback(String name, IThermalExtServiceCallback callback) throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.thermalextservice.IThermalExtService
        public boolean unregisterCallback(int handle) throws RemoteException {
            return false;
        }

        @Override // vendor.bytedance.thermalextservice.IThermalExtService
        public ICdspMonitor getCdspMonitor() throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.thermalextservice.IThermalExtService
        public IThermalFileTransfer getFileTransfer() throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.thermalextservice.IThermalExtService
        public IThermalPackageApplier getThermalPackageApplier() throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.thermalextservice.IThermalExtService
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.bytedance.thermalextservice.IThermalExtService
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IThermalExtService {
        static final int TRANSACTION_getCdspMonitor = 3;
        static final int TRANSACTION_getFileTransfer = 4;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getThermalPackageApplier = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        private static class Proxy implements IThermalExtService {
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
                return IThermalExtService.DESCRIPTOR;
            }

            @Override // vendor.bytedance.thermalextservice.IThermalExtService
            public int registerCallback(String name, IThermalExtServiceCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IThermalExtService.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(name);     // Catch: Throwable -> L8
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method registerCallback is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.IThermalExtService
            public boolean unregisterCallback(int handle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IThermalExtService.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(handle);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method unregisterCallback is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.IThermalExtService
            public ICdspMonitor getCdspMonitor() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IThermalExtService.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                ICdspMonitor _result = ICdspMonitor.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getCdspMonitor is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.IThermalExtService
            public IThermalFileTransfer getFileTransfer() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IThermalExtService.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                IThermalFileTransfer _result = IThermalFileTransfer.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getFileTransfer is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.IThermalExtService
            public IThermalPackageApplier getThermalPackageApplier() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IThermalExtService.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                IThermalPackageApplier _result = IThermalPackageApplier.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getThermalPackageApplier is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.IThermalExtService
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IThermalExtService.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // vendor.bytedance.thermalextservice.IThermalExtService
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IThermalExtService.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IThermalExtService.DESCRIPTOR);
        }

        public static IThermalExtService asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IThermalExtService.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IThermalExtService) == false) goto L12;
            return (IThermalExtService) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IThermalExtService.DESCRIPTOR;
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
            IThermalPackageApplier _result = getThermalPackageApplier();
            reply.writeNoException();
            reply.writeStrongInterface(_result);
        L25:
            return true;
        L21:
            IThermalFileTransfer _result2 = getFileTransfer();
            reply.writeNoException();
            reply.writeStrongInterface(_result2);
            goto L25
        L22:
            ICdspMonitor _result3 = getCdspMonitor();
            reply.writeNoException();
            reply.writeStrongInterface(_result3);
            goto L25
        L23:
            int _arg0 = data.readInt();
            boolean _result4 = unregisterCallback(_arg0);
            reply.writeNoException();
            reply.writeBoolean(_result4);
            goto L25
        L24:
            String _arg1 = data.readString();
            IThermalExtServiceCallback _arg2 = IThermalExtServiceCallback.Stub.asInterface(data.readStrongBinder());
            int _result5 = registerCallback(_arg1, _arg2);
            reply.writeNoException();
            reply.writeInt(_result5);
            goto L25
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    ICdspMonitor getCdspMonitor() throws RemoteException;

    IThermalFileTransfer getFileTransfer() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    IThermalPackageApplier getThermalPackageApplier() throws RemoteException;

    int registerCallback(String r1, IThermalExtServiceCallback r2) throws RemoteException;

    boolean unregisterCallback(int r1) throws RemoteException;

    static {
        DESCRIPTOR = "vendor$bytedance$thermalextservice$IThermalExtService".replace('$', '.');
    }
}
