package android.net.metrics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INetdEventListener extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final int DNS_REPORTED_IP_ADDRESSES_LIMIT = 10;
    public static final int EVENT_GETADDRINFO = 1;
    public static final int EVENT_GETHOSTBYADDR = 3;
    public static final int EVENT_GETHOSTBYNAME = 2;
    public static final int EVENT_RES_NSEND = 4;
    public static final String HASH = "8e27594d285ca7c567d87e8cf74766c27647e02b";
    public static final int REPORTING_LEVEL_FULL = 2;
    public static final int REPORTING_LEVEL_METRICS = 1;
    public static final int REPORTING_LEVEL_NONE = 0;
    public static final int VERSION = 1;

    public static class Default implements INetdEventListener {
        public Default() {
        }

        @Override // android.net.metrics.INetdEventListener
        public void onDnsEvent(int netId, int eventType, int returnCode, int latencyMs, String hostname, String[] ipAddresses, int ipAddressesCount, int uid) throws RemoteException {
        }

        @Override // android.net.metrics.INetdEventListener
        public void onPrivateDnsValidationEvent(int netId, String ipAddress, String hostname, boolean validated) throws RemoteException {
        }

        @Override // android.net.metrics.INetdEventListener
        public void onConnectEvent(int netId, int error, int latencyMs, String ipAddr, int port, int uid) throws RemoteException {
        }

        @Override // android.net.metrics.INetdEventListener
        public void onWakeupEvent(String prefix, int uid, int ethertype, int ipNextHeader, byte[] dstHw, String srcIp, String dstIp, int srcPort, int dstPort, long timestampNs) throws RemoteException {
        }

        @Override // android.net.metrics.INetdEventListener
        public void onTcpSocketStatsEvent(int[] networkIds, int[] sentPackets, int[] lostPackets, int[] rttUs, int[] sentAckDiffMs) throws RemoteException {
        }

        @Override // android.net.metrics.INetdEventListener
        public void onNat64PrefixEvent(int netId, boolean added, String prefixString, int prefixLength) throws RemoteException {
        }

        @Override // android.net.metrics.INetdEventListener
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.metrics.INetdEventListener
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INetdEventListener {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onConnectEvent = 3;
        static final int TRANSACTION_onDnsEvent = 1;
        static final int TRANSACTION_onNat64PrefixEvent = 6;
        static final int TRANSACTION_onPrivateDnsValidationEvent = 2;
        static final int TRANSACTION_onTcpSocketStatsEvent = 5;
        static final int TRANSACTION_onWakeupEvent = 4;

        private static class Proxy implements INetdEventListener {
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
                return INetdEventListener.DESCRIPTOR;
            }

            @Override // android.net.metrics.INetdEventListener
            public void onDnsEvent(int netId, int eventType, int returnCode, int latencyMs, String hostname, String[] ipAddresses, int ipAddressesCount, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(netId);     // Catch: Throwable -> L9
                _data.writeInt(eventType);     // Catch: Throwable -> L9
                _data.writeInt(returnCode);     // Catch: Throwable -> L9
                _data.writeInt(latencyMs);     // Catch: Throwable -> L9
                _data.writeString(hostname);     // Catch: Throwable -> L9
                _data.writeStringArray(ipAddresses);     // Catch: Throwable -> L9
                _data.writeInt(ipAddressesCount);     // Catch: Throwable -> L9
                _data.writeInt(uid);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onDnsEvent is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.metrics.INetdEventListener
            public void onPrivateDnsValidationEvent(int netId, String ipAddress, String hostname, boolean validated) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(netId);     // Catch: Throwable -> L9
                _data.writeString(ipAddress);     // Catch: Throwable -> L9
                _data.writeString(hostname);     // Catch: Throwable -> L9
                _data.writeBoolean(validated);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onPrivateDnsValidationEvent is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.metrics.INetdEventListener
            public void onConnectEvent(int netId, int error, int latencyMs, String ipAddr, int port, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(netId);     // Catch: Throwable -> L9
                _data.writeInt(error);     // Catch: Throwable -> L9
                _data.writeInt(latencyMs);     // Catch: Throwable -> L9
                _data.writeString(ipAddr);     // Catch: Throwable -> L9
                _data.writeInt(port);     // Catch: Throwable -> L9
                _data.writeInt(uid);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onConnectEvent is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.metrics.INetdEventListener
            public void onWakeupEvent(String prefix, int uid, int ethertype, int ipNextHeader, byte[] dstHw, String srcIp, String dstIp, int srcPort, int dstPort, long timestampNs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdEventListener.DESCRIPTOR);     // Catch: Throwable -> L57
                _data.writeString(prefix);     // Catch: Throwable -> L57
                _data.writeInt(uid);     // Catch: Throwable -> L54
                _data.writeInt(ethertype);     // Catch: Throwable -> L51
                _data.writeInt(ipNextHeader);     // Catch: Throwable -> L48
                _data.writeByteArray(dstHw);     // Catch: Throwable -> L45
                _data.writeString(srcIp);     // Catch: Throwable -> L42
                _data.writeString(dstIp);     // Catch: Throwable -> L39
                _data.writeInt(srcPort);     // Catch: Throwable -> L36
                _data.writeInt(dstPort);     // Catch: Throwable -> L33
                _data.writeLong(timestampNs);     // Catch: Throwable -> L31
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L29
                if (_status == false) goto L28;
                _data.recycle();
                return;
            L28:
                throw new RemoteException("Method onWakeupEvent is unimplemented.");     // Catch: Throwable -> L29
            L29:
                th = th;
            L59:
                _data.recycle();
                throw th;
            L31:
                th = th;
            L33:
                th = th;
            L36:
                th = th;
            L39:
                th = th;
            L42:
                th = th;
            L45:
                th = th;
            L48:
                th = th;
            L51:
                th = th;
            L54:
                th = th;
            L57:
                th = th;
                goto L59
            }

            @Override // android.net.metrics.INetdEventListener
            public void onTcpSocketStatsEvent(int[] networkIds, int[] sentPackets, int[] lostPackets, int[] rttUs, int[] sentAckDiffMs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeIntArray(networkIds);     // Catch: Throwable -> L9
                _data.writeIntArray(sentPackets);     // Catch: Throwable -> L9
                _data.writeIntArray(lostPackets);     // Catch: Throwable -> L9
                _data.writeIntArray(rttUs);     // Catch: Throwable -> L9
                _data.writeIntArray(sentAckDiffMs);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onTcpSocketStatsEvent is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.metrics.INetdEventListener
            public void onNat64PrefixEvent(int netId, boolean added, String prefixString, int prefixLength) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(netId);     // Catch: Throwable -> L9
                _data.writeBoolean(added);     // Catch: Throwable -> L9
                _data.writeString(prefixString);     // Catch: Throwable -> L9
                _data.writeInt(prefixLength);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onNat64PrefixEvent is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.metrics.INetdEventListener
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(INetdEventListener.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.metrics.INetdEventListener
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(INetdEventListener.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, INetdEventListener.DESCRIPTOR);
        }

        public static INetdEventListener asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(INetdEventListener.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof INetdEventListener) == false) goto L12;
            return (INetdEventListener) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = INetdEventListener.DESCRIPTOR;
            if (code < 1) goto L6;
            if (code > 16777215) goto L6;
            Parcel r6 = data;
            r6.enforceInterface(descriptor);
        L8:
            if (code != 1598968902) goto L11;
            reply.writeString(descriptor);
            return true;
        L11:
            if (code != 16777215) goto L15;
            reply.writeNoException();
            reply.writeInt(getInterfaceVersion());
            return true;
        L15:
            if (code != TRANSACTION_getInterfaceHash) goto L18;
            reply.writeNoException();
            reply.writeString(getInterfaceHash());
            return true;
        L18:
            switch(code) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                default: goto L20;
            };
        L21:
            int _arg0 = r6.readInt();
            boolean _arg1 = r6.readBoolean();
            String _arg2 = r6.readString();
            int _arg3 = r6.readInt();
            onNat64PrefixEvent(_arg0, _arg1, _arg2, _arg3);
        L27:
            return true;
        L22:
            int[] _arg4 = r6.createIntArray();
            int[] _arg5 = r6.createIntArray();
            int[] _arg6 = r6.createIntArray();
            int[] _arg7 = r6.createIntArray();
            int[] _arg8 = r6.createIntArray();
            onTcpSocketStatsEvent(_arg4, _arg5, _arg6, _arg7, _arg8);
            goto L27
        L23:
            String _arg9 = r6.readString();
            int _arg10 = r6.readInt();
            int _arg11 = r6.readInt();
            int _arg12 = r6.readInt();
            byte[] _arg13 = r6.createByteArray();
            String _arg14 = data.readString();
            String _arg15 = data.readString();
            int _arg16 = data.readInt();
            int _arg17 = data.readInt();
            long _arg18 = data.readLong();
            onWakeupEvent(_arg9, _arg10, _arg11, _arg12, _arg13, _arg14, _arg15, _arg16, _arg17, _arg18);
            goto L27
        L24:
            int _arg19 = data.readInt();
            int _arg20 = data.readInt();
            int _arg21 = data.readInt();
            String _arg22 = data.readString();
            int _arg23 = data.readInt();
            int _arg24 = data.readInt();
            onConnectEvent(_arg19, _arg20, _arg21, _arg22, _arg23, _arg24);
            goto L27
        L25:
            int _arg25 = data.readInt();
            String _arg26 = data.readString();
            String _arg27 = data.readString();
            boolean _arg28 = data.readBoolean();
            onPrivateDnsValidationEvent(_arg25, _arg26, _arg27, _arg28);
            goto L27
        L26:
            int _arg29 = data.readInt();
            int _arg30 = data.readInt();
            int _arg31 = data.readInt();
            int _arg32 = data.readInt();
            String _arg33 = data.readString();
            String[] _arg34 = data.createStringArray();
            int _arg35 = data.readInt();
            int _arg36 = data.readInt();
            onDnsEvent(_arg29, _arg30, _arg31, _arg32, _arg33, _arg34, _arg35, _arg36);
            goto L27
        L20:
            return super.onTransact(code, data, reply, flags);
        L6:
            r6 = data;
            goto L8
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void onConnectEvent(int r1, int r2, int r3, String r4, int r5, int r6) throws RemoteException;

    void onDnsEvent(int r1, int r2, int r3, int r4, String r5, String[] r6, int r7, int r8) throws RemoteException;

    void onNat64PrefixEvent(int r1, boolean r2, String r3, int r4) throws RemoteException;

    void onPrivateDnsValidationEvent(int r1, String r2, String r3, boolean r4) throws RemoteException;

    void onTcpSocketStatsEvent(int[] r1, int[] r2, int[] r3, int[] r4, int[] r5) throws RemoteException;

    void onWakeupEvent(String r1, int r2, int r3, int r4, byte[] r5, String r6, String r7, int r8, int r9, long r10) throws RemoteException;

    static {
        DESCRIPTOR = "android$net$metrics$INetdEventListener".replace('$', '.');
    }
}
