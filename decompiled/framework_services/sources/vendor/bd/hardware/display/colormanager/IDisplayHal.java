package vendor.bd.hardware.display.colormanager;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IDisplayHal extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "4f70030b3cf9b949560f2602a600eb3eb6a2853c";
    public static final int VERSION = 1;

    public static class Default implements IDisplayHal {
        public Default() {
        }

        @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
        public void SetPccDimmingConfig(int temperature, int type, boolean isSwitching) throws RemoteException {
        }

        @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
        public void SetPccConfig(byte[] pccConfig) throws RemoteException {
        }

        @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
        public void SetAutoTemperatureConfig(int temperatureParam, int type) throws RemoteException {
        }

        @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
        public void SetPowerMode(int powermode) throws RemoteException {
        }

        @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
        public void SetFocusAppMode(int FocusAppMode) throws RemoteException {
        }

        @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
        public void SetLoadLut3dConfig(String load_file_path) throws RemoteException {
        }

        @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
        public void Transact(byte[] req, byte[] rsp) throws RemoteException {
        }

        @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDisplayHal {
        static final int TRANSACTION_SetAutoTemperatureConfig = 3;
        static final int TRANSACTION_SetFocusAppMode = 5;
        static final int TRANSACTION_SetLoadLut3dConfig = 6;
        static final int TRANSACTION_SetPccConfig = 2;
        static final int TRANSACTION_SetPccDimmingConfig = 1;
        static final int TRANSACTION_SetPowerMode = 4;
        static final int TRANSACTION_Transact = 7;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;

        private static class Proxy implements IDisplayHal {
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
                return IDisplayHal.DESCRIPTOR;
            }

            @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
            public void SetPccDimmingConfig(int temperature, int type, boolean isSwitching) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDisplayHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(temperature);     // Catch: Throwable -> L8
                _data.writeInt(type);     // Catch: Throwable -> L8
                _data.writeBoolean(isSwitching);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method SetPccDimmingConfig is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
            public void SetPccConfig(byte[] pccConfig) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDisplayHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeByteArray(pccConfig);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method SetPccConfig is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
            public void SetAutoTemperatureConfig(int temperatureParam, int type) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDisplayHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(temperatureParam);     // Catch: Throwable -> L8
                _data.writeInt(type);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method SetAutoTemperatureConfig is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
            public void SetPowerMode(int powermode) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDisplayHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(powermode);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method SetPowerMode is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
            public void SetFocusAppMode(int FocusAppMode) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDisplayHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(FocusAppMode);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method SetFocusAppMode is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
            public void SetLoadLut3dConfig(String load_file_path) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDisplayHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(load_file_path);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method SetLoadLut3dConfig is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
            public void Transact(byte[] req, byte[] rsp) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IDisplayHal.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeByteArray(req);     // Catch: Throwable -> L8
                _data.writeInt(rsp.length);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.readByteArray(rsp);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method Transact is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IDisplayHal.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // vendor.bd.hardware.display.colormanager.IDisplayHal
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IDisplayHal.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IDisplayHal.DESCRIPTOR);
        }

        public static IDisplayHal asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IDisplayHal.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IDisplayHal) == false) goto L12;
            return (IDisplayHal) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IDisplayHal.DESCRIPTOR;
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
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L20;
                default: goto L19;
            };
        L20:
            byte[] _arg0 = data.createByteArray();
            int _arg1_length = data.readInt();
            if (_arg1_length > 1000000) goto L27;
            if (_arg1_length >= 0) goto L24;
            byte[] _arg1 = null;
        L25:
            data.enforceNoDataAvail();
            Transact(_arg0, _arg1);
            reply.writeNoException();
            reply.writeByteArray(_arg1);
        L34:
            return true;
        L24:
            _arg1 = new byte[_arg1_length];
            goto L25
        L27:
            throw new BadParcelableException("Array too large: " + _arg1_length);
        L28:
            String _arg2 = data.readString();
            data.enforceNoDataAvail();
            SetLoadLut3dConfig(_arg2);
            reply.writeNoException();
            goto L34
        L29:
            int _arg3 = data.readInt();
            data.enforceNoDataAvail();
            SetFocusAppMode(_arg3);
            reply.writeNoException();
            goto L34
        L30:
            int _arg4 = data.readInt();
            data.enforceNoDataAvail();
            SetPowerMode(_arg4);
            reply.writeNoException();
            goto L34
        L31:
            int _arg5 = data.readInt();
            int _arg6 = data.readInt();
            data.enforceNoDataAvail();
            SetAutoTemperatureConfig(_arg5, _arg6);
            reply.writeNoException();
            goto L34
        L32:
            byte[] _arg7 = data.createByteArray();
            data.enforceNoDataAvail();
            SetPccConfig(_arg7);
            reply.writeNoException();
            goto L34
        L33:
            int _arg8 = data.readInt();
            int _arg9 = data.readInt();
            boolean _arg10 = data.readBoolean();
            data.enforceNoDataAvail();
            SetPccDimmingConfig(_arg8, _arg9, _arg10);
            reply.writeNoException();
            goto L34
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void SetAutoTemperatureConfig(int r1, int r2) throws RemoteException;

    void SetFocusAppMode(int r1) throws RemoteException;

    void SetLoadLut3dConfig(String r1) throws RemoteException;

    void SetPccConfig(byte[] r1) throws RemoteException;

    void SetPccDimmingConfig(int r1, int r2, boolean r3) throws RemoteException;

    void SetPowerMode(int r1) throws RemoteException;

    void Transact(byte[] r1, byte[] r2) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    static {
        DESCRIPTOR = "vendor$bd$hardware$display$colormanager$IDisplayHal".replace('$', '.');
    }
}
