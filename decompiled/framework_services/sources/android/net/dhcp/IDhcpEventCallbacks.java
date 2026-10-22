package android.net.dhcp;

import android.net.IpPrefix;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IDhcpEventCallbacks extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "ae4f960691890a07842408cdb9a73c9c833abea5";
    public static final int VERSION = 24;

    public static class Default implements IDhcpEventCallbacks {
        public Default() {
        }

        @Override // android.net.dhcp.IDhcpEventCallbacks
        public void onLeasesChanged(List<DhcpLeaseParcelable> newLeases) throws RemoteException {
        }

        @Override // android.net.dhcp.IDhcpEventCallbacks
        public void onNewPrefixRequest(IpPrefix currentPrefix) throws RemoteException {
        }

        @Override // android.net.dhcp.IDhcpEventCallbacks
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.dhcp.IDhcpEventCallbacks
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDhcpEventCallbacks {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onLeasesChanged = 1;
        static final int TRANSACTION_onNewPrefixRequest = 2;

        private static class Proxy implements IDhcpEventCallbacks {
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
                return IDhcpEventCallbacks.DESCRIPTOR;
            }

            @Override // android.net.dhcp.IDhcpEventCallbacks
            public void onLeasesChanged(List<DhcpLeaseParcelable> newLeases) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IDhcpEventCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _Parcel.m32$$Nest$smwriteTypedList(_data, newLeases, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onLeasesChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.dhcp.IDhcpEventCallbacks
            public void onNewPrefixRequest(IpPrefix currentPrefix) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IDhcpEventCallbacks.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(currentPrefix, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onNewPrefixRequest is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.dhcp.IDhcpEventCallbacks
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IDhcpEventCallbacks.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.dhcp.IDhcpEventCallbacks
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IDhcpEventCallbacks.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IDhcpEventCallbacks.DESCRIPTOR);
        }

        public static IDhcpEventCallbacks asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IDhcpEventCallbacks.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IDhcpEventCallbacks) == false) goto L12;
            return (IDhcpEventCallbacks) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IDhcpEventCallbacks.DESCRIPTOR;
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
                case 1: goto L21;
                case 2: goto L20;
                default: goto L19;
            };
        L20:
            IpPrefix _arg0 = (IpPrefix) data.readTypedObject(IpPrefix.CREATOR);
            onNewPrefixRequest(_arg0);
        L22:
            return true;
        L21:
            List<DhcpLeaseParcelable> _arg1 = data.createTypedArrayList(DhcpLeaseParcelable.CREATOR);
            onLeasesChanged(_arg1);
            goto L22
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    public static class _Parcel {
        /* JADX INFO: renamed from: -$$Nest$smwriteTypedList, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m32$$Nest$smwriteTypedList(Parcel r0, List r1, int r2) {
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

    void onLeasesChanged(List<DhcpLeaseParcelable> r1) throws RemoteException;

    void onNewPrefixRequest(IpPrefix r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$net$dhcp$IDhcpEventCallbacks".replace('$', '.');
    }
}
