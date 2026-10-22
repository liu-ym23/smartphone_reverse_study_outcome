package android.net;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface INetdUnsolicitedEventListener extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "a786da2fe41bda627a8c1e63b99264a415e769c8";
    public static final int VERSION = 17;

    public static class Default implements INetdUnsolicitedEventListener {
        public Default() {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceClassActivityChanged(boolean isActive, int timerLabel, long timestampNs, int uid) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onQuotaLimitReached(String alertName, String ifName) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceDnsServerInfo(String ifName, long lifetimeS, String[] servers) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceAddressUpdated(String addr, String ifName, int flags, int scope) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceAddressRemoved(String addr, String ifName, int flags, int scope) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceAdded(String ifName) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceRemoved(String ifName) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceChanged(String ifName, boolean up) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onInterfaceLinkStateChanged(String ifName, boolean up) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onRouteChanged(boolean updated, String route, String gateway, String ifName) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public void onStrictCleartextDetected(int uid, String hex) throws RemoteException {
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.INetdUnsolicitedEventListener
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INetdUnsolicitedEventListener {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onInterfaceAdded = 6;
        static final int TRANSACTION_onInterfaceAddressRemoved = 5;
        static final int TRANSACTION_onInterfaceAddressUpdated = 4;
        static final int TRANSACTION_onInterfaceChanged = 8;
        static final int TRANSACTION_onInterfaceClassActivityChanged = 1;
        static final int TRANSACTION_onInterfaceDnsServerInfo = 3;
        static final int TRANSACTION_onInterfaceLinkStateChanged = 9;
        static final int TRANSACTION_onInterfaceRemoved = 7;
        static final int TRANSACTION_onQuotaLimitReached = 2;
        static final int TRANSACTION_onRouteChanged = 10;
        static final int TRANSACTION_onStrictCleartextDetected = 11;

        private static class Proxy implements INetdUnsolicitedEventListener {
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
                return INetdUnsolicitedEventListener.DESCRIPTOR;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onInterfaceClassActivityChanged(boolean isActive, int timerLabel, long timestampNs, int uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeBoolean(isActive);     // Catch: Throwable -> L9
                _data.writeInt(timerLabel);     // Catch: Throwable -> L9
                _data.writeLong(timestampNs);     // Catch: Throwable -> L9
                _data.writeInt(uid);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onInterfaceClassActivityChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onQuotaLimitReached(String alertName, String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(alertName);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onQuotaLimitReached is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onInterfaceDnsServerInfo(String ifName, long lifetimeS, String[] servers) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                _data.writeLong(lifetimeS);     // Catch: Throwable -> L9
                _data.writeStringArray(servers);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onInterfaceDnsServerInfo is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onInterfaceAddressUpdated(String addr, String ifName, int flags, int scope) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(addr);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                _data.writeInt(flags);     // Catch: Throwable -> L9
                _data.writeInt(scope);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onInterfaceAddressUpdated is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onInterfaceAddressRemoved(String addr, String ifName, int flags, int scope) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(addr);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                _data.writeInt(flags);     // Catch: Throwable -> L9
                _data.writeInt(scope);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onInterfaceAddressRemoved is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onInterfaceAdded(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onInterfaceAdded is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onInterfaceRemoved(String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onInterfaceRemoved is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onInterfaceChanged(String ifName, boolean up) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                _data.writeBoolean(up);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onInterfaceChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onInterfaceLinkStateChanged(String ifName, boolean up) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                _data.writeBoolean(up);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(9, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onInterfaceLinkStateChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onRouteChanged(boolean updated, String route, String gateway, String ifName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeBoolean(updated);     // Catch: Throwable -> L9
                _data.writeString(route);     // Catch: Throwable -> L9
                _data.writeString(gateway);     // Catch: Throwable -> L9
                _data.writeString(ifName);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(10, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onRouteChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public void onStrictCleartextDetected(int uid, String hex) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(uid);     // Catch: Throwable -> L9
                _data.writeString(hex);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(11, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onStrictCleartextDetected is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.INetdUnsolicitedEventListener
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.INetdUnsolicitedEventListener
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(INetdUnsolicitedEventListener.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, INetdUnsolicitedEventListener.DESCRIPTOR);
        }

        public static INetdUnsolicitedEventListener asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(INetdUnsolicitedEventListener.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof INetdUnsolicitedEventListener) == false) goto L12;
            return (INetdUnsolicitedEventListener) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = INetdUnsolicitedEventListener.DESCRIPTOR;
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
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L28;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L25;
                case 7: goto L24;
                case 8: goto L23;
                case 9: goto L22;
                case 10: goto L21;
                case 11: goto L20;
                default: goto L19;
            };
        L20:
            int _arg0 = data.readInt();
            String _arg1 = data.readString();
            onStrictCleartextDetected(_arg0, _arg1);
        L31:
            return true;
        L21:
            boolean _arg2 = data.readBoolean();
            String _arg3 = data.readString();
            String _arg4 = data.readString();
            String _arg5 = data.readString();
            onRouteChanged(_arg2, _arg3, _arg4, _arg5);
            goto L31
        L22:
            String _arg6 = data.readString();
            boolean _arg7 = data.readBoolean();
            onInterfaceLinkStateChanged(_arg6, _arg7);
            goto L31
        L23:
            String _arg8 = data.readString();
            boolean _arg9 = data.readBoolean();
            onInterfaceChanged(_arg8, _arg9);
            goto L31
        L24:
            String _arg10 = data.readString();
            onInterfaceRemoved(_arg10);
            goto L31
        L25:
            String _arg11 = data.readString();
            onInterfaceAdded(_arg11);
            goto L31
        L26:
            String _arg12 = data.readString();
            String _arg13 = data.readString();
            int _arg14 = data.readInt();
            int _arg15 = data.readInt();
            onInterfaceAddressRemoved(_arg12, _arg13, _arg14, _arg15);
            goto L31
        L27:
            String _arg16 = data.readString();
            String _arg17 = data.readString();
            int _arg18 = data.readInt();
            int _arg19 = data.readInt();
            onInterfaceAddressUpdated(_arg16, _arg17, _arg18, _arg19);
            goto L31
        L28:
            String _arg20 = data.readString();
            long _arg21 = data.readLong();
            String[] _arg22 = data.createStringArray();
            onInterfaceDnsServerInfo(_arg20, _arg21, _arg22);
            goto L31
        L29:
            String _arg23 = data.readString();
            String _arg24 = data.readString();
            onQuotaLimitReached(_arg23, _arg24);
            goto L31
        L30:
            boolean _arg25 = data.readBoolean();
            int _arg26 = data.readInt();
            long _arg27 = data.readLong();
            int _arg28 = data.readInt();
            onInterfaceClassActivityChanged(_arg25, _arg26, _arg27, _arg28);
            goto L31
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void onInterfaceAdded(String r1) throws RemoteException;

    void onInterfaceAddressRemoved(String r1, String r2, int r3, int r4) throws RemoteException;

    void onInterfaceAddressUpdated(String r1, String r2, int r3, int r4) throws RemoteException;

    void onInterfaceChanged(String r1, boolean r2) throws RemoteException;

    void onInterfaceClassActivityChanged(boolean r1, int r2, long r3, int r5) throws RemoteException;

    void onInterfaceDnsServerInfo(String r1, long r2, String[] r4) throws RemoteException;

    void onInterfaceLinkStateChanged(String r1, boolean r2) throws RemoteException;

    void onInterfaceRemoved(String r1) throws RemoteException;

    void onQuotaLimitReached(String r1, String r2) throws RemoteException;

    void onRouteChanged(boolean r1, String r2, String r3, String r4) throws RemoteException;

    void onStrictCleartextDetected(int r1, String r2) throws RemoteException;

    static {
        DESCRIPTOR = "android$net$INetdUnsolicitedEventListener".replace('$', '.');
    }
}
