package android.net;

import android.net.networkstack.aidl.NetworkMonitorParameters;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkMonitor extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "ae4f960691890a07842408cdb9a73c9c833abea5";
    public static final int NETWORK_TEST_RESULT_INVALID = 1;
    public static final int NETWORK_TEST_RESULT_PARTIAL_CONNECTIVITY = 2;
    public static final int NETWORK_TEST_RESULT_VALID = 0;
    public static final int NETWORK_VALIDATION_PROBE_DNS = 4;
    public static final int NETWORK_VALIDATION_PROBE_FALLBACK = 32;
    public static final int NETWORK_VALIDATION_PROBE_HTTP = 8;
    public static final int NETWORK_VALIDATION_PROBE_HTTPS = 16;
    public static final int NETWORK_VALIDATION_PROBE_PRIVDNS = 64;
    public static final int NETWORK_VALIDATION_RESULT_PARTIAL = 2;
    public static final int NETWORK_VALIDATION_RESULT_SKIPPED = 4;
    public static final int NETWORK_VALIDATION_RESULT_VALID = 1;
    public static final int VERSION = 24;

    public static class Default implements INetworkMonitor {
        public Default() {
        }

        @Override // android.net.INetworkMonitor
        public void start() throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void launchCaptivePortalApp() throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void notifyCaptivePortalAppFinished(int response) throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void setAcceptPartialConnectivity() throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void forceReevaluation(int uid) throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void notifyPrivateDnsChanged(PrivateDnsConfigParcel config) throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void notifyDnsResponse(int returnCode) throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void notifyNetworkConnected(LinkProperties lp, NetworkCapabilities nc) throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void notifyNetworkDisconnected() throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void notifyLinkPropertiesChanged(LinkProperties lp) throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void notifyNetworkCapabilitiesChanged(NetworkCapabilities nc) throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public void notifyNetworkConnectedParcel(NetworkMonitorParameters params) throws RemoteException {
        }

        @Override // android.net.INetworkMonitor
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.INetworkMonitor
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INetworkMonitor {
        static final int TRANSACTION_forceReevaluation = 5;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_launchCaptivePortalApp = 2;
        static final int TRANSACTION_notifyCaptivePortalAppFinished = 3;
        static final int TRANSACTION_notifyDnsResponse = 7;
        static final int TRANSACTION_notifyLinkPropertiesChanged = 10;
        static final int TRANSACTION_notifyNetworkCapabilitiesChanged = 11;
        static final int TRANSACTION_notifyNetworkConnected = 8;
        static final int TRANSACTION_notifyNetworkConnectedParcel = 12;
        static final int TRANSACTION_notifyNetworkDisconnected = 9;
        static final int TRANSACTION_notifyPrivateDnsChanged = 6;
        static final int TRANSACTION_setAcceptPartialConnectivity = 4;
        static final int TRANSACTION_start = 1;

        private static class Proxy implements INetworkMonitor {
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
                return INetworkMonitor.DESCRIPTOR;
            }

            @Override // android.net.INetworkMonitor
            public void start() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
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

            @Override // android.net.INetworkMonitor
            public void launchCaptivePortalApp() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method launchCaptivePortalApp is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void notifyCaptivePortalAppFinished(int response) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(response);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyCaptivePortalAppFinished is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void setAcceptPartialConnectivity() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setAcceptPartialConnectivity is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void forceReevaluation(int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(uid);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method forceReevaluation is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void notifyPrivateDnsChanged(PrivateDnsConfigParcel config) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(config, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyPrivateDnsChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void notifyDnsResponse(int returnCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(returnCode);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyDnsResponse is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void notifyNetworkConnected(LinkProperties lp, NetworkCapabilities nc) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(lp, 0);     // Catch: Throwable -> L9
                _data.writeTypedObject(nc, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyNetworkConnected is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void notifyNetworkDisconnected() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(9, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyNetworkDisconnected is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void notifyLinkPropertiesChanged(LinkProperties lp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(lp, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(10, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyLinkPropertiesChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void notifyNetworkCapabilitiesChanged(NetworkCapabilities nc) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(nc, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(11, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyNetworkCapabilitiesChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public void notifyNetworkConnectedParcel(NetworkMonitorParameters params) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(params, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(12, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyNetworkConnectedParcel is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetworkMonitor
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.INetworkMonitor
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(INetworkMonitor.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, INetworkMonitor.DESCRIPTOR);
        }

        public static INetworkMonitor asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(INetworkMonitor.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof INetworkMonitor) == false) goto L12;
            return (INetworkMonitor) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = INetworkMonitor.DESCRIPTOR;
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
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L21;
                case 12: goto L20;
                default: goto L19;
            };
        L20:
            NetworkMonitorParameters _arg0 = (NetworkMonitorParameters) data.readTypedObject(NetworkMonitorParameters.CREATOR);
            notifyNetworkConnectedParcel(_arg0);
        L32:
            return true;
        L21:
            NetworkCapabilities _arg1 = (NetworkCapabilities) data.readTypedObject(NetworkCapabilities.CREATOR);
            notifyNetworkCapabilitiesChanged(_arg1);
            goto L32
        L22:
            LinkProperties _arg2 = (LinkProperties) data.readTypedObject(LinkProperties.CREATOR);
            notifyLinkPropertiesChanged(_arg2);
            goto L32
        L23:
            notifyNetworkDisconnected();
            goto L32
        L24:
            LinkProperties _arg3 = (LinkProperties) data.readTypedObject(LinkProperties.CREATOR);
            NetworkCapabilities _arg4 = (NetworkCapabilities) data.readTypedObject(NetworkCapabilities.CREATOR);
            notifyNetworkConnected(_arg3, _arg4);
            goto L32
        L25:
            int _arg5 = data.readInt();
            notifyDnsResponse(_arg5);
            goto L32
        L26:
            PrivateDnsConfigParcel _arg6 = (PrivateDnsConfigParcel) data.readTypedObject(PrivateDnsConfigParcel.CREATOR);
            notifyPrivateDnsChanged(_arg6);
            goto L32
        L27:
            int _arg7 = data.readInt();
            forceReevaluation(_arg7);
            goto L32
        L28:
            setAcceptPartialConnectivity();
            goto L32
        L29:
            int _arg8 = data.readInt();
            notifyCaptivePortalAppFinished(_arg8);
            goto L32
        L30:
            launchCaptivePortalApp();
            goto L32
        L31:
            start();
            goto L32
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void forceReevaluation(int r1) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void launchCaptivePortalApp() throws RemoteException;

    void notifyCaptivePortalAppFinished(int r1) throws RemoteException;

    void notifyDnsResponse(int r1) throws RemoteException;

    void notifyLinkPropertiesChanged(LinkProperties r1) throws RemoteException;

    void notifyNetworkCapabilitiesChanged(NetworkCapabilities r1) throws RemoteException;

    void notifyNetworkConnected(LinkProperties r1, NetworkCapabilities r2) throws RemoteException;

    void notifyNetworkConnectedParcel(NetworkMonitorParameters r1) throws RemoteException;

    void notifyNetworkDisconnected() throws RemoteException;

    void notifyPrivateDnsChanged(PrivateDnsConfigParcel r1) throws RemoteException;

    void setAcceptPartialConnectivity() throws RemoteException;

    void start() throws RemoteException;

    static {
        DESCRIPTOR = "android$net$INetworkMonitor".replace('$', '.');
    }
}
