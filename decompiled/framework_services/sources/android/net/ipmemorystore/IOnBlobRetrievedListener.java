package android.net.ipmemorystore;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IOnBlobRetrievedListener extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "b24ee617afb80799cb35b6241f5847d786c649f3";
    public static final int VERSION = 11;

    public static class Default implements IOnBlobRetrievedListener {
        public Default() {
        }

        @Override // android.net.ipmemorystore.IOnBlobRetrievedListener
        public void onBlobRetrieved(StatusParcelable status, String l2Key, String name, Blob data) throws RemoteException {
        }

        @Override // android.net.ipmemorystore.IOnBlobRetrievedListener
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.net.ipmemorystore.IOnBlobRetrievedListener
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOnBlobRetrievedListener {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onBlobRetrieved = 1;

        private static class Proxy implements IOnBlobRetrievedListener {
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
                return IOnBlobRetrievedListener.DESCRIPTOR;
            }

            @Override // android.net.ipmemorystore.IOnBlobRetrievedListener
            public void onBlobRetrieved(StatusParcelable status, String l2Key, String name, Blob data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(IOnBlobRetrievedListener.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(status, 0);     // Catch: Throwable -> L9
                _data.writeString(l2Key);     // Catch: Throwable -> L9
                _data.writeString(name);     // Catch: Throwable -> L9
                _data.writeTypedObject(data, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onBlobRetrieved is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.net.ipmemorystore.IOnBlobRetrievedListener
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IOnBlobRetrievedListener.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.net.ipmemorystore.IOnBlobRetrievedListener
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IOnBlobRetrievedListener.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IOnBlobRetrievedListener.DESCRIPTOR);
        }

        public static IOnBlobRetrievedListener asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IOnBlobRetrievedListener.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IOnBlobRetrievedListener) == false) goto L12;
            return (IOnBlobRetrievedListener) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IOnBlobRetrievedListener.DESCRIPTOR;
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
                case 1: goto L20;
                default: goto L19;
            };
        L20:
            StatusParcelable _arg0 = (StatusParcelable) data.readTypedObject(StatusParcelable.CREATOR);
            String _arg1 = data.readString();
            String _arg2 = data.readString();
            Blob _arg3 = (Blob) data.readTypedObject(Blob.CREATOR);
            onBlobRetrieved(_arg0, _arg1, _arg2, _arg3);
            return true;
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void onBlobRetrieved(StatusParcelable r1, String r2, String r3, Blob r4) throws RemoteException;

    static {
        DESCRIPTOR = "android$net$ipmemorystore$IOnBlobRetrievedListener".replace('$', '.');
    }
}
