package android.net;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IIpMemoryStoreCallbacks extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "b24ee617afb80799cb35b6241f5847d786c649f3";
    public static final int VERSION = 11;

    public static class Default implements IIpMemoryStoreCallbacks {
        public Default() {
        }

        @Override // android.net.IIpMemoryStoreCallbacks
        public void onIpMemoryStoreFetched(IIpMemoryStore ipMemoryStore) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStoreCallbacks
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.IIpMemoryStoreCallbacks
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IIpMemoryStoreCallbacks {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onIpMemoryStoreFetched = 1;

        private static class Proxy implements IIpMemoryStoreCallbacks {
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
                return IIpMemoryStoreCallbacks.DESCRIPTOR;
            }

            @Override // android.net.IIpMemoryStoreCallbacks
            public void onIpMemoryStoreFetched(IIpMemoryStore ipMemoryStore) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStoreCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(ipMemoryStore);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onIpMemoryStoreFetched is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStoreCallbacks
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IIpMemoryStoreCallbacks.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.IIpMemoryStoreCallbacks
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IIpMemoryStoreCallbacks.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IIpMemoryStoreCallbacks.DESCRIPTOR);
        }

        public static IIpMemoryStoreCallbacks asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IIpMemoryStoreCallbacks.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IIpMemoryStoreCallbacks) == false) goto L12;
            return (IIpMemoryStoreCallbacks) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IIpMemoryStoreCallbacks.DESCRIPTOR;
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
            IIpMemoryStore _arg0 = IIpMemoryStore.Stub.asInterface(data.readStrongBinder());
            onIpMemoryStoreFetched(_arg0);
            return true;
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void onIpMemoryStoreFetched(IIpMemoryStore r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$net$IIpMemoryStoreCallbacks".replace('$', '.');
    }
}
