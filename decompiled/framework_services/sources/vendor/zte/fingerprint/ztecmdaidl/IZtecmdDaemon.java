package vendor.zte.fingerprint.ztecmdaidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IZtecmdDaemon extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "9d0889b7ecde4c347e888c7c37b8fcd0f6c7970d";
    public static final int VERSION = 1;

    public static class Default implements IZtecmdDaemon {
        public Default() {
        }

        @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdDaemon
        public void setNotify_zte(IZtecmdCallback clientCallback) throws RemoteException {
        }

        @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdDaemon
        public void zteCmd(int cmd, int param1, int param2, String containerName) throws RemoteException {
        }

        @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdDaemon
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdDaemon
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IZtecmdDaemon {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_setNotify_zte = 1;
        static final int TRANSACTION_zteCmd = 2;

        private static class Proxy implements IZtecmdDaemon {
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
                return IZtecmdDaemon.DESCRIPTOR;
            }

            @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdDaemon
            public void setNotify_zte(IZtecmdCallback clientCallback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IZtecmdDaemon.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(clientCallback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setNotify_zte is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdDaemon
            public void zteCmd(int cmd, int param1, int param2, String containerName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IZtecmdDaemon.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(cmd);     // Catch: Throwable -> L9
                _data.writeInt(param1);     // Catch: Throwable -> L9
                _data.writeInt(param2);     // Catch: Throwable -> L9
                _data.writeString(containerName);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method zteCmd is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdDaemon
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IZtecmdDaemon.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdDaemon
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IZtecmdDaemon.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IZtecmdDaemon.DESCRIPTOR);
        }

        public static IZtecmdDaemon asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IZtecmdDaemon.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IZtecmdDaemon) == false) goto L12;
            return (IZtecmdDaemon) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IZtecmdDaemon.DESCRIPTOR;
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
            int _arg0 = data.readInt();
            int _arg1 = data.readInt();
            int _arg2 = data.readInt();
            String _arg3 = data.readString();
            data.enforceNoDataAvail();
            zteCmd(_arg0, _arg1, _arg2, _arg3);
        L22:
            return true;
        L21:
            IZtecmdCallback _arg4 = IZtecmdCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setNotify_zte(_arg4);
            goto L22
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void setNotify_zte(IZtecmdCallback r1) throws RemoteException;

    void zteCmd(int r1, int r2, int r3, String r4) throws RemoteException;

    static {
        DESCRIPTOR = "vendor$zte$fingerprint$ztecmdaidl$IZtecmdDaemon".replace('$', '.');
    }
}
