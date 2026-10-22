package android.net;

import android.net.ipmemorystore.Blob;
import android.net.ipmemorystore.IOnBlobRetrievedListener;
import android.net.ipmemorystore.IOnL2KeyResponseListener;
import android.net.ipmemorystore.IOnNetworkAttributesRetrievedListener;
import android.net.ipmemorystore.IOnNetworkEventCountRetrievedListener;
import android.net.ipmemorystore.IOnSameL3NetworkResponseListener;
import android.net.ipmemorystore.IOnStatusAndCountListener;
import android.net.ipmemorystore.IOnStatusListener;
import android.net.ipmemorystore.NetworkAttributesParcelable;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IIpMemoryStore extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "b24ee617afb80799cb35b6241f5847d786c649f3";
    public static final int NETWORK_EVENT_NUD_FAILURE_CONFIRM = 1;
    public static final int NETWORK_EVENT_NUD_FAILURE_MAC_ADDRESS_CHANGED = 3;
    public static final int NETWORK_EVENT_NUD_FAILURE_ORGANIC = 2;
    public static final int NETWORK_EVENT_NUD_FAILURE_ROAM = 0;
    public static final int VERSION = 11;

    public static class Default implements IIpMemoryStore {
        public Default() {
        }

        @Override // android.net.IIpMemoryStore
        public void storeNetworkAttributes(String l2Key, NetworkAttributesParcelable attributes, IOnStatusListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void storeBlob(String l2Key, String clientId, String name, Blob data, IOnStatusListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void findL2Key(NetworkAttributesParcelable attributes, IOnL2KeyResponseListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void isSameNetwork(String l2Key1, String l2Key2, IOnSameL3NetworkResponseListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void retrieveNetworkAttributes(String l2Key, IOnNetworkAttributesRetrievedListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void retrieveBlob(String l2Key, String clientId, String name, IOnBlobRetrievedListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void factoryReset() throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void delete(String l2Key, boolean needWipe, IOnStatusAndCountListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void deleteCluster(String cluster, boolean needWipe, IOnStatusAndCountListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void storeNetworkEvent(String cluster, long timestamp, long expiry, int eventType, IOnStatusListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public void retrieveNetworkEventCount(String cluster, long[] sinceTimes, int[] eventTypes, IOnNetworkEventCountRetrievedListener listener) throws RemoteException {
        }

        @Override // android.net.IIpMemoryStore
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.IIpMemoryStore
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IIpMemoryStore {
        static final int TRANSACTION_delete = 8;
        static final int TRANSACTION_deleteCluster = 9;
        static final int TRANSACTION_factoryReset = 7;
        static final int TRANSACTION_findL2Key = 3;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_isSameNetwork = 4;
        static final int TRANSACTION_retrieveBlob = 6;
        static final int TRANSACTION_retrieveNetworkAttributes = 5;
        static final int TRANSACTION_retrieveNetworkEventCount = 11;
        static final int TRANSACTION_storeBlob = 2;
        static final int TRANSACTION_storeNetworkAttributes = 1;
        static final int TRANSACTION_storeNetworkEvent = 10;

        private static class Proxy implements IIpMemoryStore {
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
                return IIpMemoryStore.DESCRIPTOR;
            }

            @Override // android.net.IIpMemoryStore
            public void storeNetworkAttributes(String l2Key, NetworkAttributesParcelable attributes, IOnStatusListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(l2Key);     // Catch: Throwable -> L9
                _data.writeTypedObject(attributes, 0);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method storeNetworkAttributes is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void storeBlob(String l2Key, String clientId, String name, Blob data, IOnStatusListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(l2Key);     // Catch: Throwable -> L9
                _data.writeString(clientId);     // Catch: Throwable -> L9
                _data.writeString(name);     // Catch: Throwable -> L9
                _data.writeTypedObject(data, 0);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method storeBlob is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void findL2Key(NetworkAttributesParcelable attributes, IOnL2KeyResponseListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(attributes, 0);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method findL2Key is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void isSameNetwork(String l2Key1, String l2Key2, IOnSameL3NetworkResponseListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(l2Key1);     // Catch: Throwable -> L9
                _data.writeString(l2Key2);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method isSameNetwork is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void retrieveNetworkAttributes(String l2Key, IOnNetworkAttributesRetrievedListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(l2Key);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method retrieveNetworkAttributes is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void retrieveBlob(String l2Key, String clientId, String name, IOnBlobRetrievedListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(l2Key);     // Catch: Throwable -> L9
                _data.writeString(clientId);     // Catch: Throwable -> L9
                _data.writeString(name);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method retrieveBlob is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void factoryReset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method factoryReset is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void delete(String l2Key, boolean needWipe, IOnStatusAndCountListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(l2Key);     // Catch: Throwable -> L9
                _data.writeBoolean(needWipe);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method delete is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void deleteCluster(String cluster, boolean needWipe, IOnStatusAndCountListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(cluster);     // Catch: Throwable -> L9
                _data.writeBoolean(needWipe);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(9, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method deleteCluster is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void storeNetworkEvent(String cluster, long timestamp, long expiry, int eventType, IOnStatusListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(cluster);     // Catch: Throwable -> L9
                _data.writeLong(timestamp);     // Catch: Throwable -> L9
                _data.writeLong(expiry);     // Catch: Throwable -> L9
                _data.writeInt(eventType);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(10, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method storeNetworkEvent is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public void retrieveNetworkEventCount(String cluster, long[] sinceTimes, int[] eventTypes, IOnNetworkEventCountRetrievedListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(cluster);     // Catch: Throwable -> L9
                _data.writeLongArray(sinceTimes);     // Catch: Throwable -> L9
                _data.writeIntArray(eventTypes);     // Catch: Throwable -> L9
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(11, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method retrieveNetworkEventCount is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.IIpMemoryStore
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.IIpMemoryStore
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IIpMemoryStore.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IIpMemoryStore.DESCRIPTOR);
        }

        public static IIpMemoryStore asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IIpMemoryStore.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IIpMemoryStore) == false) goto L12;
            return (IIpMemoryStore) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IIpMemoryStore.DESCRIPTOR;
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
            String _arg0 = data.readString();
            long[] _arg1 = data.createLongArray();
            int[] _arg2 = data.createIntArray();
            IOnNetworkEventCountRetrievedListener _arg3 = IOnNetworkEventCountRetrievedListener.Stub.asInterface(data.readStrongBinder());
            retrieveNetworkEventCount(_arg0, _arg1, _arg2, _arg3);
        L31:
            return true;
        L21:
            String _arg4 = data.readString();
            long _arg5 = data.readLong();
            long _arg6 = data.readLong();
            int _arg7 = data.readInt();
            IOnStatusListener _arg8 = IOnStatusListener.Stub.asInterface(data.readStrongBinder());
            storeNetworkEvent(_arg4, _arg5, _arg6, _arg7, _arg8);
            goto L31
        L22:
            String _arg9 = data.readString();
            boolean _arg10 = data.readBoolean();
            IOnStatusAndCountListener _arg11 = IOnStatusAndCountListener.Stub.asInterface(data.readStrongBinder());
            deleteCluster(_arg9, _arg10, _arg11);
            goto L31
        L23:
            String _arg12 = data.readString();
            boolean _arg13 = data.readBoolean();
            IOnStatusAndCountListener _arg14 = IOnStatusAndCountListener.Stub.asInterface(data.readStrongBinder());
            delete(_arg12, _arg13, _arg14);
            goto L31
        L24:
            factoryReset();
            goto L31
        L25:
            String _arg15 = data.readString();
            String _arg16 = data.readString();
            String _arg17 = data.readString();
            IOnBlobRetrievedListener _arg18 = IOnBlobRetrievedListener.Stub.asInterface(data.readStrongBinder());
            retrieveBlob(_arg15, _arg16, _arg17, _arg18);
            goto L31
        L26:
            String _arg19 = data.readString();
            IOnNetworkAttributesRetrievedListener _arg20 = IOnNetworkAttributesRetrievedListener.Stub.asInterface(data.readStrongBinder());
            retrieveNetworkAttributes(_arg19, _arg20);
            goto L31
        L27:
            String _arg21 = data.readString();
            String _arg22 = data.readString();
            IOnSameL3NetworkResponseListener _arg23 = IOnSameL3NetworkResponseListener.Stub.asInterface(data.readStrongBinder());
            isSameNetwork(_arg21, _arg22, _arg23);
            goto L31
        L28:
            NetworkAttributesParcelable _arg24 = (NetworkAttributesParcelable) data.readTypedObject(NetworkAttributesParcelable.CREATOR);
            IOnL2KeyResponseListener _arg25 = IOnL2KeyResponseListener.Stub.asInterface(data.readStrongBinder());
            findL2Key(_arg24, _arg25);
            goto L31
        L29:
            String _arg26 = data.readString();
            String _arg27 = data.readString();
            String _arg28 = data.readString();
            Blob _arg29 = (Blob) data.readTypedObject(Blob.CREATOR);
            IOnStatusListener _arg30 = IOnStatusListener.Stub.asInterface(data.readStrongBinder());
            storeBlob(_arg26, _arg27, _arg28, _arg29, _arg30);
            goto L31
        L30:
            String _arg31 = data.readString();
            NetworkAttributesParcelable _arg32 = (NetworkAttributesParcelable) data.readTypedObject(NetworkAttributesParcelable.CREATOR);
            IOnStatusListener _arg33 = IOnStatusListener.Stub.asInterface(data.readStrongBinder());
            storeNetworkAttributes(_arg31, _arg32, _arg33);
            goto L31
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void delete(String r1, boolean r2, IOnStatusAndCountListener r3) throws RemoteException;

    void deleteCluster(String r1, boolean r2, IOnStatusAndCountListener r3) throws RemoteException;

    void factoryReset() throws RemoteException;

    void findL2Key(NetworkAttributesParcelable r1, IOnL2KeyResponseListener r2) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void isSameNetwork(String r1, String r2, IOnSameL3NetworkResponseListener r3) throws RemoteException;

    void retrieveBlob(String r1, String r2, String r3, IOnBlobRetrievedListener r4) throws RemoteException;

    void retrieveNetworkAttributes(String r1, IOnNetworkAttributesRetrievedListener r2) throws RemoteException;

    void retrieveNetworkEventCount(String r1, long[] r2, int[] r3, IOnNetworkEventCountRetrievedListener r4) throws RemoteException;

    void storeBlob(String r1, String r2, String r3, Blob r4, IOnStatusListener r5) throws RemoteException;

    void storeNetworkAttributes(String r1, NetworkAttributesParcelable r2, IOnStatusListener r3) throws RemoteException;

    void storeNetworkEvent(String r1, long r2, long r4, int r6, IOnStatusListener r7) throws RemoteException;

    static {
        DESCRIPTOR = "android$net$IIpMemoryStore".replace('$', '.');
    }
}
