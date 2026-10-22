package android.net.dhcp;

import android.net.INetworkStackStatusCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IDhcpServer extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "ae4f960691890a07842408cdb9a73c9c833abea5";
    public static final int STATUS_INVALID_ARGUMENT = 2;
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_UNKNOWN = 0;
    public static final int STATUS_UNKNOWN_ERROR = 3;
    public static final int VERSION = 24;

    public static class Default implements IDhcpServer {
        public Default() {
        }

        @Override // android.net.dhcp.IDhcpServer
        public void start(INetworkStackStatusCallback cb) throws RemoteException {
        }

        @Override // android.net.dhcp.IDhcpServer
        public void startWithCallbacks(INetworkStackStatusCallback statusCb, IDhcpEventCallbacks eventCb) throws RemoteException {
        }

        @Override // android.net.dhcp.IDhcpServer
        public void updateParams(DhcpServingParamsParcel params, INetworkStackStatusCallback cb) throws RemoteException {
        }

        @Override // android.net.dhcp.IDhcpServer
        public void stop(INetworkStackStatusCallback cb) throws RemoteException {
        }

        @Override // android.net.dhcp.IDhcpServer
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.dhcp.IDhcpServer
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDhcpServer {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_start = 1;
        static final int TRANSACTION_startWithCallbacks = 4;
        static final int TRANSACTION_stop = 3;
        static final int TRANSACTION_updateParams = 2;

        private static class Proxy implements IDhcpServer {
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
                return IDhcpServer.DESCRIPTOR;
            }

            @Override // android.net.dhcp.IDhcpServer
            public void start(INetworkStackStatusCallback cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IDhcpServer.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(cb);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method start is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.dhcp.IDhcpServer
            public void startWithCallbacks(INetworkStackStatusCallback statusCb, IDhcpEventCallbacks eventCb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IDhcpServer.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(statusCb);     // Catch: Throwable -> L9
                _data.writeStrongInterface(eventCb);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method startWithCallbacks is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.dhcp.IDhcpServer
            public void updateParams(DhcpServingParamsParcel params, INetworkStackStatusCallback cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IDhcpServer.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(params, 0);     // Catch: Throwable -> L9
                _data.writeStrongInterface(cb);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method updateParams is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.dhcp.IDhcpServer
            public void stop(INetworkStackStatusCallback cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IDhcpServer.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(cb);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method stop is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.dhcp.IDhcpServer
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IDhcpServer.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.dhcp.IDhcpServer
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IDhcpServer.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IDhcpServer.DESCRIPTOR);
        }

        public static IDhcpServer asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IDhcpServer.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IDhcpServer) == false) goto L12;
            return (IDhcpServer) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IDhcpServer.DESCRIPTOR;
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
            INetworkStackStatusCallback _arg0 = INetworkStackStatusCallback.Stub.asInterface(data.readStrongBinder());
            IDhcpEventCallbacks _arg1 = IDhcpEventCallbacks.Stub.asInterface(data.readStrongBinder());
            startWithCallbacks(_arg0, _arg1);
        L24:
            return true;
        L21:
            INetworkStackStatusCallback _arg2 = INetworkStackStatusCallback.Stub.asInterface(data.readStrongBinder());
            stop(_arg2);
            goto L24
        L22:
            DhcpServingParamsParcel _arg3 = (DhcpServingParamsParcel) data.readTypedObject(DhcpServingParamsParcel.CREATOR);
            INetworkStackStatusCallback _arg4 = INetworkStackStatusCallback.Stub.asInterface(data.readStrongBinder());
            updateParams(_arg3, _arg4);
            goto L24
        L23:
            INetworkStackStatusCallback _arg5 = INetworkStackStatusCallback.Stub.asInterface(data.readStrongBinder());
            start(_arg5);
            goto L24
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void start(INetworkStackStatusCallback r1) throws RemoteException;

    void startWithCallbacks(INetworkStackStatusCallback r1, IDhcpEventCallbacks r2) throws RemoteException;

    void stop(INetworkStackStatusCallback r1) throws RemoteException;

    void updateParams(DhcpServingParamsParcel r1, INetworkStackStatusCallback r2) throws RemoteException;

    static {
        DESCRIPTOR = "android$net$dhcp$IDhcpServer".replace('$', '.');
    }
}
