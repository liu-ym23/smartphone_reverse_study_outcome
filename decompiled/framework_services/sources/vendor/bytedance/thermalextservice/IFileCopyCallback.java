package vendor.bytedance.thermalextservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IFileCopyCallback extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "9fa87beb6e476c774f619c66a68b52aab48242b3";
    public static final int STATUS_ALREADY_EXISTS = 2;
    public static final int STATUS_DIGEST_MISMATCH = 6;
    public static final int STATUS_FSYNC_FAILED = 5;
    public static final int STATUS_INTERNAL_ERROR = 7;
    public static final int STATUS_INVALID_ARGUMENT = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_FAILED = 3;
    public static final int STATUS_WRITE_FAILED = 4;
    public static final int VERSION = 2;

    public static class Default implements IFileCopyCallback {
        public Default() {
        }

        @Override // vendor.bytedance.thermalextservice.IFileCopyCallback
        public void onCopyFinished(int status, String relativePath, long bytesWritten, String message) throws RemoteException {
        }

        @Override // vendor.bytedance.thermalextservice.IFileCopyCallback
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.bytedance.thermalextservice.IFileCopyCallback
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IFileCopyCallback {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onCopyFinished = 1;

        private static class Proxy implements IFileCopyCallback {
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
                return IFileCopyCallback.DESCRIPTOR;
            }

            @Override // vendor.bytedance.thermalextservice.IFileCopyCallback
            public void onCopyFinished(int status, String relativePath, long bytesWritten, String message) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IFileCopyCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(status);     // Catch: Throwable -> L9
                _data.writeString(relativePath);     // Catch: Throwable -> L9
                _data.writeLong(bytesWritten);     // Catch: Throwable -> L9
                _data.writeString(message);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onCopyFinished is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.IFileCopyCallback
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IFileCopyCallback.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // vendor.bytedance.thermalextservice.IFileCopyCallback
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IFileCopyCallback.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IFileCopyCallback.DESCRIPTOR);
        }

        public static IFileCopyCallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IFileCopyCallback.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IFileCopyCallback) == false) goto L12;
            return (IFileCopyCallback) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IFileCopyCallback.DESCRIPTOR;
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
                case 1: goto L20;
                default: goto L19;
            };
        L20:
            int _arg0 = data.readInt();
            String _arg1 = data.readString();
            long _arg2 = data.readLong();
            String _arg3 = data.readString();
            onCopyFinished(_arg0, _arg1, _arg2, _arg3);
            return true;
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void onCopyFinished(int r1, String r2, long r3, String r5) throws RemoteException;

    static {
        DESCRIPTOR = "vendor$bytedance$thermalextservice$IFileCopyCallback".replace('$', '.');
    }
}
