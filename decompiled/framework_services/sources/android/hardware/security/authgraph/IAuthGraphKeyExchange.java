package android.hardware.security.authgraph;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IAuthGraphKeyExchange extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "3758824e7b75acdb1ca66620fb8a8aec0ec6dfcc";
    public static final int VERSION = 1;

    public static class Default implements IAuthGraphKeyExchange {
        public Default() {
        }

        @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
        public SessionInitiationInfo create() throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
        public KeInitResult init(PubKey peerPubKey, Identity peerId, byte[] peerNonce, int peerVersion) throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
        public SessionInfo finish(PubKey peerPubKey, Identity peerId, SessionIdSignature peerSignature, byte[] peerNonce, int peerVersion, Key ownKey) throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
        public Arc[] authenticationComplete(SessionIdSignature peerSignature, Arc[] sharedKeys) throws RemoteException {
            return null;
        }

        @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAuthGraphKeyExchange {
        static final int TRANSACTION_authenticationComplete = 4;
        static final int TRANSACTION_create = 1;
        static final int TRANSACTION_finish = 3;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_init = 2;

        private static class Proxy implements IAuthGraphKeyExchange {
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
                return IAuthGraphKeyExchange.DESCRIPTOR;
            }

            @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
            public SessionInitiationInfo create() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IAuthGraphKeyExchange.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                SessionInitiationInfo _result = (SessionInitiationInfo) _reply.readTypedObject(SessionInitiationInfo.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method create is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
            public KeInitResult init(PubKey peerPubKey, Identity peerId, byte[] peerNonce, int peerVersion) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IAuthGraphKeyExchange.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(peerPubKey, 0);     // Catch: Throwable -> L8
                _data.writeTypedObject(peerId, 0);     // Catch: Throwable -> L8
                _data.writeByteArray(peerNonce);     // Catch: Throwable -> L8
                _data.writeInt(peerVersion);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                KeInitResult _result = (KeInitResult) _reply.readTypedObject(KeInitResult.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method init is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
            public SessionInfo finish(PubKey peerPubKey, Identity peerId, SessionIdSignature peerSignature, byte[] peerNonce, int peerVersion, Key ownKey) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IAuthGraphKeyExchange.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(peerPubKey, 0);     // Catch: Throwable -> L8
                _data.writeTypedObject(peerId, 0);     // Catch: Throwable -> L8
                _data.writeTypedObject(peerSignature, 0);     // Catch: Throwable -> L8
                _data.writeByteArray(peerNonce);     // Catch: Throwable -> L8
                _data.writeInt(peerVersion);     // Catch: Throwable -> L8
                _data.writeTypedObject(ownKey, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                SessionInfo _result = (SessionInfo) _reply.readTypedObject(SessionInfo.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method finish is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
            public Arc[] authenticationComplete(SessionIdSignature peerSignature, Arc[] sharedKeys) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IAuthGraphKeyExchange.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(peerSignature, 0);     // Catch: Throwable -> L8
                _data.writeFixedArray(sharedKeys, 0, new int[]{2});     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                Arc[] _result = (Arc[]) _reply.createFixedArray(Arc[].class, Arc.CREATOR, new int[]{2});     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method authenticationComplete is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IAuthGraphKeyExchange.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.security.authgraph.IAuthGraphKeyExchange
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IAuthGraphKeyExchange.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IAuthGraphKeyExchange.DESCRIPTOR);
        }

        public static IAuthGraphKeyExchange asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IAuthGraphKeyExchange.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IAuthGraphKeyExchange) == false) goto L12;
            return (IAuthGraphKeyExchange) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L15;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L9;
                case 16777214: goto L7;
                case 16777215: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "getInterfaceVersion";
        L7:
            return "getInterfaceHash";
        L9:
            return "authenticationComplete";
        L11:
            return "finish";
        L13:
            return "init";
        L15:
            return "create";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IAuthGraphKeyExchange.DESCRIPTOR;
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
            SessionIdSignature _arg0 = (SessionIdSignature) data.readTypedObject(SessionIdSignature.CREATOR);
            Arc[] _arg1 = (Arc[]) data.createFixedArray(Arc[].class, Arc.CREATOR, new int[]{2});
            data.enforceNoDataAvail();
            Arc[] _result = authenticationComplete(_arg0, _arg1);
            reply.writeNoException();
            reply.writeFixedArray(_result, 1, new int[]{2});
        L24:
            return true;
        L21:
            PubKey _arg2 = (PubKey) data.readTypedObject(PubKey.CREATOR);
            Identity _arg3 = (Identity) data.readTypedObject(Identity.CREATOR);
            SessionIdSignature _arg4 = (SessionIdSignature) data.readTypedObject(SessionIdSignature.CREATOR);
            byte[] _arg5 = data.createByteArray();
            int _arg6 = data.readInt();
            Key _arg7 = (Key) data.readTypedObject(Key.CREATOR);
            data.enforceNoDataAvail();
            SessionInfo _result2 = finish(_arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
            reply.writeNoException();
            reply.writeTypedObject(_result2, 1);
            goto L24
        L22:
            PubKey _arg8 = (PubKey) data.readTypedObject(PubKey.CREATOR);
            Identity _arg9 = (Identity) data.readTypedObject(Identity.CREATOR);
            byte[] _arg10 = data.createByteArray();
            int _arg11 = data.readInt();
            data.enforceNoDataAvail();
            KeInitResult _result3 = init(_arg8, _arg9, _arg10, _arg11);
            reply.writeNoException();
            reply.writeTypedObject(_result3, 1);
            goto L24
        L23:
            SessionInitiationInfo _result4 = create();
            reply.writeNoException();
            reply.writeTypedObject(_result4, 1);
            goto L24
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    Arc[] authenticationComplete(SessionIdSignature r1, Arc[] r2) throws RemoteException;

    SessionInitiationInfo create() throws RemoteException;

    SessionInfo finish(PubKey r1, Identity r2, SessionIdSignature r3, byte[] r4, int r5, Key r6) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    KeInitResult init(PubKey r1, Identity r2, byte[] r3, int r4) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$security$authgraph$IAuthGraphKeyExchange".replace('$', '.');
    }
}
