package android.net.ip;

import android.net.DhcpResultsParcelable;
import android.net.Layer2PacketParcelable;
import android.net.LinkProperties;
import android.net.networkstack.aidl.ip.ReachabilityLossInfoParcelable;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IIpClientCallbacks extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final int DTIM_MULTIPLIER_RESET = 0;
    public static final String HASH = "ae4f960691890a07842408cdb9a73c9c833abea5";
    public static final int VERSION = 24;

    public static class Default implements IIpClientCallbacks {
        public Default() {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onIpClientCreated(IIpClient ipClient) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onPreDhcpAction() throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onPostDhcpAction() throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onNewDhcpResults(DhcpResultsParcelable dhcpResults) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onProvisioningSuccess(LinkProperties newLp) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onProvisioningFailure(LinkProperties newLp) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onLinkPropertiesChange(LinkProperties newLp) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onReachabilityLost(String logMsg) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onQuit() throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void installPacketFilter(byte[] filter) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void startReadPacketFilter() throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void setFallbackMulticastFilter(boolean enabled) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void setNeighborDiscoveryOffload(boolean enable) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onPreconnectionStart(List<Layer2PacketParcelable> packets) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onReachabilityFailure(ReachabilityLossInfoParcelable lossInfo) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void setMaxDtimMultiplier(int multiplier) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onDhcpOfferReceived(int offerId, DhcpResultsParcelable offer) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public void onDhcpOfferApplyFailed(int offerId) throws RemoteException {
        }

        @Override // android.net.ip.IIpClientCallbacks
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.ip.IIpClientCallbacks
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IIpClientCallbacks {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_installPacketFilter = 10;
        static final int TRANSACTION_onDhcpOfferApplyFailed = 18;
        static final int TRANSACTION_onDhcpOfferReceived = 17;
        static final int TRANSACTION_onIpClientCreated = 1;
        static final int TRANSACTION_onLinkPropertiesChange = 7;
        static final int TRANSACTION_onNewDhcpResults = 4;
        static final int TRANSACTION_onPostDhcpAction = 3;
        static final int TRANSACTION_onPreDhcpAction = 2;
        static final int TRANSACTION_onPreconnectionStart = 14;
        static final int TRANSACTION_onProvisioningFailure = 6;
        static final int TRANSACTION_onProvisioningSuccess = 5;
        static final int TRANSACTION_onQuit = 9;
        static final int TRANSACTION_onReachabilityFailure = 15;
        static final int TRANSACTION_onReachabilityLost = 8;
        static final int TRANSACTION_setFallbackMulticastFilter = 12;
        static final int TRANSACTION_setMaxDtimMultiplier = 16;
        static final int TRANSACTION_setNeighborDiscoveryOffload = 13;
        static final int TRANSACTION_startReadPacketFilter = 11;

        private static class Proxy implements IIpClientCallbacks {
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
                return IIpClientCallbacks.DESCRIPTOR;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onIpClientCreated(IIpClient ipClient) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(ipClient);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onIpClientCreated is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onPreDhcpAction() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onPreDhcpAction is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onPostDhcpAction() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onPostDhcpAction is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onNewDhcpResults(DhcpResultsParcelable dhcpResults) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(dhcpResults, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onNewDhcpResults is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onProvisioningSuccess(LinkProperties newLp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(newLp, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onProvisioningSuccess is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onProvisioningFailure(LinkProperties newLp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(newLp, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onProvisioningFailure is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onLinkPropertiesChange(LinkProperties newLp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(newLp, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onLinkPropertiesChange is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onReachabilityLost(String logMsg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(logMsg);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onReachabilityLost is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onQuit() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(9, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onQuit is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void installPacketFilter(byte[] filter) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeByteArray(filter);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(10, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method installPacketFilter is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void startReadPacketFilter() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(11, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method startReadPacketFilter is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void setFallbackMulticastFilter(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeBoolean(enabled);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(12, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setFallbackMulticastFilter is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void setNeighborDiscoveryOffload(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeBoolean(enable);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(13, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setNeighborDiscoveryOffload is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onPreconnectionStart(List<Layer2PacketParcelable> packets) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _Parcel.m33$$Nest$smwriteTypedList(_data, packets, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(14, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onPreconnectionStart is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onReachabilityFailure(ReachabilityLossInfoParcelable lossInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(lossInfo, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(15, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onReachabilityFailure is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void setMaxDtimMultiplier(int multiplier) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(multiplier);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(16, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setMaxDtimMultiplier is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onDhcpOfferReceived(int offerId, DhcpResultsParcelable offer) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(offerId);     // Catch: Throwable -> L9
                _data.writeTypedObject(offer, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(17, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onDhcpOfferReceived is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public void onDhcpOfferApplyFailed(int offerId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(offerId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(18, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onDhcpOfferApplyFailed is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ip.IIpClientCallbacks
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.ip.IIpClientCallbacks
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IIpClientCallbacks.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IIpClientCallbacks.DESCRIPTOR);
        }

        public static IIpClientCallbacks asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IIpClientCallbacks.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IIpClientCallbacks) == false) goto L12;
            return (IIpClientCallbacks) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IIpClientCallbacks.DESCRIPTOR;
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
            int _arg0 = data.readInt();
            onDhcpOfferApplyFailed(_arg0);
        L38:
            return true;
        L21:
            int _arg1 = data.readInt();
            DhcpResultsParcelable _arg2 = (DhcpResultsParcelable) data.readTypedObject(DhcpResultsParcelable.CREATOR);
            onDhcpOfferReceived(_arg1, _arg2);
            goto L38
        L22:
            int _arg3 = data.readInt();
            setMaxDtimMultiplier(_arg3);
            goto L38
        L23:
            ReachabilityLossInfoParcelable _arg4 = (ReachabilityLossInfoParcelable) data.readTypedObject(ReachabilityLossInfoParcelable.CREATOR);
            onReachabilityFailure(_arg4);
            goto L38
        L24:
            List<Layer2PacketParcelable> _arg5 = data.createTypedArrayList(Layer2PacketParcelable.CREATOR);
            onPreconnectionStart(_arg5);
            goto L38
        L25:
            boolean _arg6 = data.readBoolean();
            setNeighborDiscoveryOffload(_arg6);
            goto L38
        L26:
            boolean _arg7 = data.readBoolean();
            setFallbackMulticastFilter(_arg7);
            goto L38
        L27:
            startReadPacketFilter();
            goto L38
        L28:
            byte[] _arg8 = data.createByteArray();
            installPacketFilter(_arg8);
            goto L38
        L29:
            onQuit();
            goto L38
        L30:
            String _arg9 = data.readString();
            onReachabilityLost(_arg9);
            goto L38
        L31:
            LinkProperties _arg10 = (LinkProperties) data.readTypedObject(LinkProperties.CREATOR);
            onLinkPropertiesChange(_arg10);
            goto L38
        L32:
            LinkProperties _arg11 = (LinkProperties) data.readTypedObject(LinkProperties.CREATOR);
            onProvisioningFailure(_arg11);
            goto L38
        L33:
            LinkProperties _arg12 = (LinkProperties) data.readTypedObject(LinkProperties.CREATOR);
            onProvisioningSuccess(_arg12);
            goto L38
        L34:
            DhcpResultsParcelable _arg13 = (DhcpResultsParcelable) data.readTypedObject(DhcpResultsParcelable.CREATOR);
            onNewDhcpResults(_arg13);
            goto L38
        L35:
            onPostDhcpAction();
            goto L38
        L36:
            onPreDhcpAction();
            goto L38
        L37:
            IIpClient _arg14 = IIpClient.Stub.asInterface(data.readStrongBinder());
            onIpClientCreated(_arg14);
            goto L38
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    public static class _Parcel {
        /* JADX INFO: renamed from: -$$Nest$smwriteTypedList, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m33$$Nest$smwriteTypedList(Parcel r0, List r1, int r2) {
            writeTypedList(r0, r1, r2);
        }

        public _Parcel() {
        }

        private static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> value, int parcelableFlags) {
            if (value != null) goto L4;
            parcel.writeInt(-1);
            return;
        L4:
            int N = value.size();
            int i = 0;
            parcel.writeInt(N);
        L5:
            if (i >= N) goto L9;
            parcel.writeTypedObject(value.get(i), parcelableFlags);
            i = i + 1;
            goto L5
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void installPacketFilter(byte[] r1) throws RemoteException;

    void onDhcpOfferApplyFailed(int r1) throws RemoteException;

    void onDhcpOfferReceived(int r1, DhcpResultsParcelable r2) throws RemoteException;

    void onIpClientCreated(IIpClient r1) throws RemoteException;

    void onLinkPropertiesChange(LinkProperties r1) throws RemoteException;

    void onNewDhcpResults(DhcpResultsParcelable r1) throws RemoteException;

    void onPostDhcpAction() throws RemoteException;

    void onPreDhcpAction() throws RemoteException;

    void onPreconnectionStart(List<Layer2PacketParcelable> r1) throws RemoteException;

    void onProvisioningFailure(LinkProperties r1) throws RemoteException;

    void onProvisioningSuccess(LinkProperties r1) throws RemoteException;

    void onQuit() throws RemoteException;

    void onReachabilityFailure(ReachabilityLossInfoParcelable r1) throws RemoteException;

    void onReachabilityLost(String r1) throws RemoteException;

    void setFallbackMulticastFilter(boolean r1) throws RemoteException;

    void setMaxDtimMultiplier(int r1) throws RemoteException;

    void setNeighborDiscoveryOffload(boolean r1) throws RemoteException;

    void startReadPacketFilter() throws RemoteException;

    static {
        DESCRIPTOR = "android$net$ip$IIpClientCallbacks".replace('$', '.');
    }
}
