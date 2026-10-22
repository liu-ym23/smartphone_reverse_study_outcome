package android.net.ip;

import android.net.DhcpResultsParcelable;
import android.net.Layer2InformationParcelable;
import android.net.NattKeepalivePacketDataParcelable;
import android.net.ProvisioningConfigurationParcelable;
import android.net.ProxyInfo;
import android.net.TcpKeepalivePacketDataParcelable;
import android.net.apf.ApfCapabilities;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IIpClient extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "ae4f960691890a07842408cdb9a73c9c833abea5";
    public static final int HOSTNAME_SETTING_DO_NOT_SEND = 2;
    public static final int HOSTNAME_SETTING_SEND = 1;
    public static final int HOSTNAME_SETTING_UNSET = 0;
    public static final int PROV_IPV4_DHCP = 2;
    public static final int PROV_IPV4_DISABLED = 0;
    public static final int PROV_IPV4_STATIC = 1;
    public static final int PROV_IPV6_DISABLED = 0;
    public static final int PROV_IPV6_LINKLOCAL = 2;
    public static final int PROV_IPV6_SLAAC = 1;
    public static final int VERSION = 24;

    public static class Default implements IIpClient {
        public Default() {
        }

        @Override // android.net.ip.IIpClient
        public void completedPreDhcpAction() throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void confirmConfiguration() throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void readPacketFilterComplete(byte[] data) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void shutdown() throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void startProvisioning(ProvisioningConfigurationParcelable req) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void stop() throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void setTcpBufferSizes(String tcpBufferSizes) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void setHttpProxy(ProxyInfo proxyInfo) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void setMulticastFilter(boolean enabled) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void addKeepalivePacketFilter(int slot, TcpKeepalivePacketDataParcelable pkt) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void removeKeepalivePacketFilter(int slot) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void setL2KeyAndGroupHint(String l2Key, String cluster) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void addNattKeepalivePacketFilter(int slot, NattKeepalivePacketDataParcelable pkt) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void notifyPreconnectionComplete(boolean success) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void updateLayer2Information(Layer2InformationParcelable info) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void updateApfCapabilities(ApfCapabilities apfCapabilities) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void restoreInitialDhcpLeaseSilently() throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public void applyDhcpOfferForSelfCure(DhcpResultsParcelable offer) throws RemoteException {
        }

        @Override // android.net.ip.IIpClient
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.ip.IIpClient
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IIpClient {
        static final int TRANSACTION_addKeepalivePacketFilter = 10;
        static final int TRANSACTION_addNattKeepalivePacketFilter = 13;
        static final int TRANSACTION_applyDhcpOfferForSelfCure = 18;
        static final int TRANSACTION_completedPreDhcpAction = 1;
        static final int TRANSACTION_confirmConfiguration = 2;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_notifyPreconnectionComplete = 14;
        static final int TRANSACTION_readPacketFilterComplete = 3;
        static final int TRANSACTION_removeKeepalivePacketFilter = 11;
        static final int TRANSACTION_restoreInitialDhcpLeaseSilently = 17;
        static final int TRANSACTION_setHttpProxy = 8;
        static final int TRANSACTION_setL2KeyAndGroupHint = 12;
        static final int TRANSACTION_setMulticastFilter = 9;
        static final int TRANSACTION_setTcpBufferSizes = 7;
        static final int TRANSACTION_shutdown = 4;
        static final int TRANSACTION_startProvisioning = 5;
        static final int TRANSACTION_stop = 6;
        static final int TRANSACTION_updateApfCapabilities = 16;
        static final int TRANSACTION_updateLayer2Information = 15;

        private static class Proxy implements IIpClient {
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
                return IIpClient.DESCRIPTOR;
            }

            @Override // android.net.ip.IIpClient
            public void completedPreDhcpAction() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method completedPreDhcpAction is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void confirmConfiguration() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method confirmConfiguration is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void readPacketFilterComplete(byte[] data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeByteArray(data);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method readPacketFilterComplete is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void shutdown() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method shutdown is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void startProvisioning(ProvisioningConfigurationParcelable req) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(req, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method startProvisioning is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void stop() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
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

            @Override // android.net.ip.IIpClient
            public void setTcpBufferSizes(String tcpBufferSizes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(tcpBufferSizes);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setTcpBufferSizes is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void setHttpProxy(ProxyInfo proxyInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(proxyInfo, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setHttpProxy is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void setMulticastFilter(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeBoolean(enabled);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(9, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setMulticastFilter is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void addKeepalivePacketFilter(int slot, TcpKeepalivePacketDataParcelable pkt) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(slot);     // Catch: Throwable -> L9
                _data.writeTypedObject(pkt, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(10, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method addKeepalivePacketFilter is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void removeKeepalivePacketFilter(int slot) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(slot);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(11, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method removeKeepalivePacketFilter is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void setL2KeyAndGroupHint(String l2Key, String cluster) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(l2Key);     // Catch: Throwable -> L9
                _data.writeString(cluster);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(12, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setL2KeyAndGroupHint is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void addNattKeepalivePacketFilter(int slot, NattKeepalivePacketDataParcelable pkt) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(slot);     // Catch: Throwable -> L9
                _data.writeTypedObject(pkt, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(13, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method addNattKeepalivePacketFilter is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void notifyPreconnectionComplete(boolean success) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeBoolean(success);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(14, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyPreconnectionComplete is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void updateLayer2Information(Layer2InformationParcelable info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(info, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(15, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method updateLayer2Information is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void updateApfCapabilities(ApfCapabilities apfCapabilities) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(apfCapabilities, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(16, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method updateApfCapabilities is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void restoreInitialDhcpLeaseSilently() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(17, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method restoreInitialDhcpLeaseSilently is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public void applyDhcpOfferForSelfCure(DhcpResultsParcelable offer) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(offer, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(18, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method applyDhcpOfferForSelfCure is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClient
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.ip.IIpClient
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IIpClient.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IIpClient.DESCRIPTOR);
        }

        public static IIpClient asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IIpClient.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IIpClient) == false) goto L12;
            return (IIpClient) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IIpClient.DESCRIPTOR;
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
                case 1: goto L37;
                case 2: goto L36;
                case 3: goto L35;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L32;
                case 7: goto L31;
                case 8: goto L30;
                case 9: goto L29;
                case 10: goto L28;
                case 11: goto L27;
                case 12: goto L26;
                case 13: goto L25;
                case 14: goto L24;
                case 15: goto L23;
                case 16: goto L22;
                case 17: goto L21;
                case 18: goto L20;
                default: goto L19;
            };
        L20:
            DhcpResultsParcelable _arg0 = (DhcpResultsParcelable) data.readTypedObject(DhcpResultsParcelable.CREATOR);
            applyDhcpOfferForSelfCure(_arg0);
        L38:
            return true;
        L21:
            restoreInitialDhcpLeaseSilently();
            goto L38
        L22:
            ApfCapabilities _arg1 = (ApfCapabilities) data.readTypedObject(ApfCapabilities.CREATOR);
            updateApfCapabilities(_arg1);
            goto L38
        L23:
            Layer2InformationParcelable _arg2 = (Layer2InformationParcelable) data.readTypedObject(Layer2InformationParcelable.CREATOR);
            updateLayer2Information(_arg2);
            goto L38
        L24:
            boolean _arg3 = data.readBoolean();
            notifyPreconnectionComplete(_arg3);
            goto L38
        L25:
            int _arg4 = data.readInt();
            NattKeepalivePacketDataParcelable _arg5 = (NattKeepalivePacketDataParcelable) data.readTypedObject(NattKeepalivePacketDataParcelable.CREATOR);
            addNattKeepalivePacketFilter(_arg4, _arg5);
            goto L38
        L26:
            String _arg6 = data.readString();
            String _arg7 = data.readString();
            setL2KeyAndGroupHint(_arg6, _arg7);
            goto L38
        L27:
            int _arg8 = data.readInt();
            removeKeepalivePacketFilter(_arg8);
            goto L38
        L28:
            int _arg9 = data.readInt();
            TcpKeepalivePacketDataParcelable _arg10 = (TcpKeepalivePacketDataParcelable) data.readTypedObject(TcpKeepalivePacketDataParcelable.CREATOR);
            addKeepalivePacketFilter(_arg9, _arg10);
            goto L38
        L29:
            boolean _arg11 = data.readBoolean();
            setMulticastFilter(_arg11);
            goto L38
        L30:
            ProxyInfo _arg12 = (ProxyInfo) data.readTypedObject(ProxyInfo.CREATOR);
            setHttpProxy(_arg12);
            goto L38
        L31:
            String _arg13 = data.readString();
            setTcpBufferSizes(_arg13);
            goto L38
        L32:
            stop();
            goto L38
        L33:
            ProvisioningConfigurationParcelable _arg14 = (ProvisioningConfigurationParcelable) data.readTypedObject(ProvisioningConfigurationParcelable.CREATOR);
            startProvisioning(_arg14);
            goto L38
        L34:
            shutdown();
            goto L38
        L35:
            byte[] _arg15 = data.createByteArray();
            readPacketFilterComplete(_arg15);
            goto L38
        L36:
            confirmConfiguration();
            goto L38
        L37:
            completedPreDhcpAction();
            goto L38
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void addKeepalivePacketFilter(int r1, TcpKeepalivePacketDataParcelable r2) throws RemoteException;

    void addNattKeepalivePacketFilter(int r1, NattKeepalivePacketDataParcelable r2) throws RemoteException;

    void applyDhcpOfferForSelfCure(DhcpResultsParcelable r1) throws RemoteException;

    void completedPreDhcpAction() throws RemoteException;

    void confirmConfiguration() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void notifyPreconnectionComplete(boolean r1) throws RemoteException;

    void readPacketFilterComplete(byte[] r1) throws RemoteException;

    void removeKeepalivePacketFilter(int r1) throws RemoteException;

    void restoreInitialDhcpLeaseSilently() throws RemoteException;

    void setHttpProxy(ProxyInfo r1) throws RemoteException;

    void setL2KeyAndGroupHint(String r1, String r2) throws RemoteException;

    void setMulticastFilter(boolean r1) throws RemoteException;

    void setTcpBufferSizes(String r1) throws RemoteException;

    void shutdown() throws RemoteException;

    void startProvisioning(ProvisioningConfigurationParcelable r1) throws RemoteException;

    void stop() throws RemoteException;

    void updateApfCapabilities(ApfCapabilities r1) throws RemoteException;

    void updateLayer2Information(Layer2InformationParcelable r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$net$ip$IIpClient".replace('$', '.');
    }
}
