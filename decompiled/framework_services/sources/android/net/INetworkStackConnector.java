package android.net;

import android.net.dhcp.DhcpServingParamsParcel;
import android.net.dhcp.IDhcpServerCallbacks;
import android.net.ip.IIpClientCallbacks;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkStackConnector extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "ae4f960691890a07842408cdb9a73c9c833abea5";
    public static final int VERSION = 24;

    public static class Default implements INetworkStackConnector {
        public Default() {
        }

        @Override // android.net.INetworkStackConnector
        public void makeDhcpServer(String ifName, DhcpServingParamsParcel params, IDhcpServerCallbacks cb) throws RemoteException {
        }

        @Override // android.net.INetworkStackConnector
        public void makeNetworkMonitor(Network network, String name, INetworkMonitorCallbacks cb) throws RemoteException {
        }

        @Override // android.net.INetworkStackConnector
        public void makeIpClient(String ifName, IIpClientCallbacks callbacks) throws RemoteException {
        }

        @Override // android.net.INetworkStackConnector
        public void fetchIpMemoryStore(IIpMemoryStoreCallbacks cb) throws RemoteException {
        }

        @Override // android.net.INetworkStackConnector
        public void allowTestUid(int uid, INetworkStackStatusCallback cb) throws RemoteException {
        }

        @Override // android.net.INetworkStackConnector
        public void updateDnsEvent(String ifName, int returncode, long timestamp) throws RemoteException {
        }

        @Override // android.net.INetworkStackConnector
        public void updateDnsEvents(String[] hostnameList, int[] returncodeList, long[] timestampList) throws RemoteException {
        }

        @Override // android.net.INetworkStackConnector
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.INetworkStackConnector
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INetworkStackConnector {
        static final int TRANSACTION_allowTestUid = 5;
        static final int TRANSACTION_fetchIpMemoryStore = 4;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_makeDhcpServer = 1;
        static final int TRANSACTION_makeIpClient = 3;
        static final int TRANSACTION_makeNetworkMonitor = 2;
        static final int TRANSACTION_updateDnsEvent = 6;
        static final int TRANSACTION_updateDnsEvents = 7;

        private static class Proxy implements INetworkStackConnector {
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
                return INetworkStackConnector.DESCRIPTOR;
            }

            @Override // android.net.INetworkStackConnector
            public void makeDhcpServer(String ifName, DhcpServingParamsParcel params, IDhcpServerCallbacks cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkStackConnector.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                _data.writeTypedObject(params, 0);     // Catch: Throwable -> L9
                _data.writeStrongInterface(cb);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method makeDhcpServer is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkStackConnector
            public void makeNetworkMonitor(Network network, String name, INetworkMonitorCallbacks cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkStackConnector.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(network, 0);     // Catch: Throwable -> L9
                _data.writeString(name);     // Catch: Throwable -> L9
                _data.writeStrongInterface(cb);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method makeNetworkMonitor is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkStackConnector
            public void makeIpClient(String ifName, IIpClientCallbacks callbacks) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkStackConnector.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callbacks);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method makeIpClient is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkStackConnector
            public void fetchIpMemoryStore(IIpMemoryStoreCallbacks cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkStackConnector.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(cb);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method fetchIpMemoryStore is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkStackConnector
            public void allowTestUid(int uid, INetworkStackStatusCallback cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkStackConnector.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(uid);     // Catch: Throwable -> L9
                _data.writeStrongInterface(cb);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method allowTestUid is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkStackConnector
            public void updateDnsEvent(String ifName, int returncode, long timestamp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkStackConnector.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                _data.writeInt(returncode);     // Catch: Throwable -> L9
                _data.writeLong(timestamp);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method updateDnsEvent is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkStackConnector
            public void updateDnsEvents(String[] hostnameList, int[] returncodeList, long[] timestampList) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkStackConnector.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStringArray(hostnameList);     // Catch: Throwable -> L9
                _data.writeIntArray(returncodeList);     // Catch: Throwable -> L9
                _data.writeLongArray(timestampList);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method updateDnsEvents is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkStackConnector
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(INetworkStackConnector.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.INetworkStackConnector
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(INetworkStackConnector.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, INetworkStackConnector.DESCRIPTOR);
        }

        public static INetworkStackConnector asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(INetworkStackConnector.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof INetworkStackConnector) == false) goto L12;
            return (INetworkStackConnector) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = INetworkStackConnector.DESCRIPTOR;
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
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                default: goto L19;
            };
        L20:
            String[] _arg0 = data.createStringArray();
            int[] _arg1 = data.createIntArray();
            long[] _arg2 = data.createLongArray();
            updateDnsEvents(_arg0, _arg1, _arg2);
        L27:
            return true;
        L21:
            String _arg3 = data.readString();
            int _arg4 = data.readInt();
            long _arg5 = data.readLong();
            updateDnsEvent(_arg3, _arg4, _arg5);
            goto L27
        L22:
            int _arg6 = data.readInt();
            INetworkStackStatusCallback _arg7 = INetworkStackStatusCallback.Stub.asInterface(data.readStrongBinder());
            allowTestUid(_arg6, _arg7);
            goto L27
        L23:
            IIpMemoryStoreCallbacks _arg8 = IIpMemoryStoreCallbacks.Stub.asInterface(data.readStrongBinder());
            fetchIpMemoryStore(_arg8);
            goto L27
        L24:
            String _arg9 = data.readString();
            IIpClientCallbacks _arg10 = IIpClientCallbacks.Stub.asInterface(data.readStrongBinder());
            makeIpClient(_arg9, _arg10);
            goto L27
        L25:
            Network _arg11 = (Network) data.readTypedObject(Network.CREATOR);
            String _arg12 = data.readString();
            INetworkMonitorCallbacks _arg13 = INetworkMonitorCallbacks.Stub.asInterface(data.readStrongBinder());
            makeNetworkMonitor(_arg11, _arg12, _arg13);
            goto L27
        L26:
            String _arg14 = data.readString();
            DhcpServingParamsParcel _arg15 = (DhcpServingParamsParcel) data.readTypedObject(DhcpServingParamsParcel.CREATOR);
            IDhcpServerCallbacks _arg16 = IDhcpServerCallbacks.Stub.asInterface(data.readStrongBinder());
            makeDhcpServer(_arg14, _arg15, _arg16);
            goto L27
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void allowTestUid(int r1, INetworkStackStatusCallback r2) throws RemoteException;

    void fetchIpMemoryStore(IIpMemoryStoreCallbacks r1) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void makeDhcpServer(String r1, DhcpServingParamsParcel r2, IDhcpServerCallbacks r3) throws RemoteException;

    void makeIpClient(String r1, IIpClientCallbacks r2) throws RemoteException;

    void makeNetworkMonitor(Network r1, String r2, INetworkMonitorCallbacks r3) throws RemoteException;

    void updateDnsEvent(String r1, int r2, long r3) throws RemoteException;

    void updateDnsEvents(String[] r1, int[] r2, long[] r3) throws RemoteException;

    static {
        DESCRIPTOR = "android$net$INetworkStackConnector".replace('$', '.');
    }
}
