package vendor.bd.hardware.touchhal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ITouchHal extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "9a2bad54fb96c10235985b964d74a521e23d414d";
    public static final int VERSION = 1;

    public static class Default implements ITouchHal {
        public Default() {
        }

        @Override // vendor.bd.hardware.touchhal.ITouchHal
        public void setTsFeatureConfig(int feature, int config) throws RemoteException {
        }

        @Override // vendor.bd.hardware.touchhal.ITouchHal
        public void setTsClickEnableStatus(int status) throws RemoteException {
        }

        @Override // vendor.bd.hardware.touchhal.ITouchHal
        public void setTsOrientationStatus(int status) throws RemoteException {
        }

        @Override // vendor.bd.hardware.touchhal.ITouchHal
        public void setTsReportRateStatus(int status) throws RemoteException {
        }

        @Override // vendor.bd.hardware.touchhal.ITouchHal
        public void setTsAodMode(int status) throws RemoteException {
        }

        @Override // vendor.bd.hardware.touchhal.ITouchHal
        public void setTsPsensorStatus(int status) throws RemoteException {
        }

        @Override // vendor.bd.hardware.touchhal.ITouchHal
        public void setTsFpStatus(int status) throws RemoteException {
        }

        @Override // vendor.bd.hardware.touchhal.ITouchHal
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.bd.hardware.touchhal.ITouchHal
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITouchHal {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_setTsAodMode = 5;
        static final int TRANSACTION_setTsClickEnableStatus = 2;
        static final int TRANSACTION_setTsFeatureConfig = 1;
        static final int TRANSACTION_setTsFpStatus = 7;
        static final int TRANSACTION_setTsOrientationStatus = 3;
        static final int TRANSACTION_setTsPsensorStatus = 6;
        static final int TRANSACTION_setTsReportRateStatus = 4;

        private static class Proxy implements ITouchHal {
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
                return ITouchHal.DESCRIPTOR;
            }

            @Override // vendor.bd.hardware.touchhal.ITouchHal
            public void setTsFeatureConfig(int feature, int config) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ITouchHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(feature);     // Catch: Throwable -> L8
                _data.writeInt(config);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setTsFeatureConfig is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.touchhal.ITouchHal
            public void setTsClickEnableStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ITouchHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(status);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setTsClickEnableStatus is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.touchhal.ITouchHal
            public void setTsOrientationStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ITouchHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(status);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setTsOrientationStatus is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.touchhal.ITouchHal
            public void setTsReportRateStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ITouchHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(status);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setTsReportRateStatus is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.touchhal.ITouchHal
            public void setTsAodMode(int status) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ITouchHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(status);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setTsAodMode is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.touchhal.ITouchHal
            public void setTsPsensorStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ITouchHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(status);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setTsPsensorStatus is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.touchhal.ITouchHal
            public void setTsFpStatus(int status) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ITouchHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(status);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setTsFpStatus is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.touchhal.ITouchHal
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(ITouchHal.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // vendor.bd.hardware.touchhal.ITouchHal
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(ITouchHal.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, ITouchHal.DESCRIPTOR);
        }

        public static ITouchHal asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(ITouchHal.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof ITouchHal) == false) goto L12;
            return (ITouchHal) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = ITouchHal.DESCRIPTOR;
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
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                default: goto L19;
            };
        L20:
            int _arg0 = data.readInt();
            data.enforceNoDataAvail();
            setTsFpStatus(_arg0);
            reply.writeNoException();
        L27:
            return true;
        L21:
            int _arg1 = data.readInt();
            data.enforceNoDataAvail();
            setTsPsensorStatus(_arg1);
            reply.writeNoException();
            goto L27
        L22:
            int _arg2 = data.readInt();
            data.enforceNoDataAvail();
            setTsAodMode(_arg2);
            reply.writeNoException();
            goto L27
        L23:
            int _arg3 = data.readInt();
            data.enforceNoDataAvail();
            setTsReportRateStatus(_arg3);
            reply.writeNoException();
            goto L27
        L24:
            int _arg4 = data.readInt();
            data.enforceNoDataAvail();
            setTsOrientationStatus(_arg4);
            reply.writeNoException();
            goto L27
        L25:
            int _arg5 = data.readInt();
            data.enforceNoDataAvail();
            setTsClickEnableStatus(_arg5);
            reply.writeNoException();
            goto L27
        L26:
            int _arg6 = data.readInt();
            int _arg7 = data.readInt();
            data.enforceNoDataAvail();
            setTsFeatureConfig(_arg6, _arg7);
            reply.writeNoException();
            goto L27
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void setTsAodMode(int r1) throws RemoteException;

    void setTsClickEnableStatus(int r1) throws RemoteException;

    void setTsFeatureConfig(int r1, int r2) throws RemoteException;

    void setTsFpStatus(int r1) throws RemoteException;

    void setTsOrientationStatus(int r1) throws RemoteException;

    void setTsPsensorStatus(int r1) throws RemoteException;

    void setTsReportRateStatus(int r1) throws RemoteException;

    static {
        DESCRIPTOR = "vendor$bd$hardware$touchhal$ITouchHal".replace('$', '.');
    }
}
