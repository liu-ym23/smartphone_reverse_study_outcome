package android.hardware.usb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IUsbCallback extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "7fe46e9531884739d925b8caeee9dba5c411e228";
    public static final int VERSION = 3;

    public static class Default implements IUsbCallback {
        public Default() {
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyPortStatusChange(PortStatus[] currentPortStatus, int retval) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyRoleSwitchStatus(String portName, PortRole newRole, int retval, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyEnableUsbDataStatus(String portName, boolean enable, int retval, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyEnableUsbDataWhileDockedStatus(String portName, int retval, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyContaminantEnabledStatus(String portName, boolean enable, int retval, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyQueryPortStatus(String portName, int retval, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyLimitPowerTransferStatus(String portName, boolean limit, int retval, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyResetUsbPortStatus(String portName, int retval, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsbCallback
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.usb.IUsbCallback
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUsbCallback {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_notifyContaminantEnabledStatus = 5;
        static final int TRANSACTION_notifyEnableUsbDataStatus = 3;
        static final int TRANSACTION_notifyEnableUsbDataWhileDockedStatus = 4;
        static final int TRANSACTION_notifyLimitPowerTransferStatus = 7;
        static final int TRANSACTION_notifyPortStatusChange = 1;
        static final int TRANSACTION_notifyQueryPortStatus = 6;
        static final int TRANSACTION_notifyResetUsbPortStatus = 8;
        static final int TRANSACTION_notifyRoleSwitchStatus = 2;

        private static class Proxy implements IUsbCallback {
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
                return IUsbCallback.DESCRIPTOR;
            }

            @Override // android.hardware.usb.IUsbCallback
            public void notifyPortStatusChange(PortStatus[] currentPortStatus, int retval) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedArray(currentPortStatus, 0);     // Catch: Throwable -> L9
                _data.writeInt(retval);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyPortStatusChange is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsbCallback
            public void notifyRoleSwitchStatus(String portName, PortRole newRole, int retval, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeTypedObject(newRole, 0);     // Catch: Throwable -> L9
                _data.writeInt(retval);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyRoleSwitchStatus is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsbCallback
            public void notifyEnableUsbDataStatus(String portName, boolean enable, int retval, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeBoolean(enable);     // Catch: Throwable -> L9
                _data.writeInt(retval);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyEnableUsbDataStatus is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsbCallback
            public void notifyEnableUsbDataWhileDockedStatus(String portName, int retval, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeInt(retval);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyEnableUsbDataWhileDockedStatus is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsbCallback
            public void notifyContaminantEnabledStatus(String portName, boolean enable, int retval, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeBoolean(enable);     // Catch: Throwable -> L9
                _data.writeInt(retval);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyContaminantEnabledStatus is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsbCallback
            public void notifyQueryPortStatus(String portName, int retval, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeInt(retval);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyQueryPortStatus is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsbCallback
            public void notifyLimitPowerTransferStatus(String portName, boolean limit, int retval, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeBoolean(limit);     // Catch: Throwable -> L9
                _data.writeInt(retval);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyLimitPowerTransferStatus is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsbCallback
            public void notifyResetUsbPortStatus(String portName, int retval, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeInt(retval);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method notifyResetUsbPortStatus is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsbCallback
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.usb.IUsbCallback
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IUsbCallback.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IUsbCallback.DESCRIPTOR);
        }

        public static IUsbCallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IUsbCallback.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IUsbCallback) == false) goto L12;
            return (IUsbCallback) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IUsbCallback.DESCRIPTOR;
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
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                default: goto L19;
            };
        L20:
            String _arg0 = data.readString();
            int _arg1 = data.readInt();
            long _arg2 = data.readLong();
            data.enforceNoDataAvail();
            notifyResetUsbPortStatus(_arg0, _arg1, _arg2);
        L28:
            return true;
        L21:
            String _arg3 = data.readString();
            boolean _arg4 = data.readBoolean();
            int _arg5 = data.readInt();
            long _arg6 = data.readLong();
            data.enforceNoDataAvail();
            notifyLimitPowerTransferStatus(_arg3, _arg4, _arg5, _arg6);
            goto L28
        L22:
            String _arg7 = data.readString();
            int _arg8 = data.readInt();
            long _arg9 = data.readLong();
            data.enforceNoDataAvail();
            notifyQueryPortStatus(_arg7, _arg8, _arg9);
            goto L28
        L23:
            String _arg10 = data.readString();
            boolean _arg11 = data.readBoolean();
            int _arg12 = data.readInt();
            long _arg13 = data.readLong();
            data.enforceNoDataAvail();
            notifyContaminantEnabledStatus(_arg10, _arg11, _arg12, _arg13);
            goto L28
        L24:
            String _arg14 = data.readString();
            int _arg15 = data.readInt();
            long _arg16 = data.readLong();
            data.enforceNoDataAvail();
            notifyEnableUsbDataWhileDockedStatus(_arg14, _arg15, _arg16);
            goto L28
        L25:
            String _arg17 = data.readString();
            boolean _arg18 = data.readBoolean();
            int _arg19 = data.readInt();
            long _arg20 = data.readLong();
            data.enforceNoDataAvail();
            notifyEnableUsbDataStatus(_arg17, _arg18, _arg19, _arg20);
            goto L28
        L26:
            String _arg21 = data.readString();
            PortRole _arg22 = (PortRole) data.readTypedObject(PortRole.CREATOR);
            int _arg23 = data.readInt();
            long _arg24 = data.readLong();
            data.enforceNoDataAvail();
            notifyRoleSwitchStatus(_arg21, _arg22, _arg23, _arg24);
            goto L28
        L27:
            PortStatus[] _arg25 = (PortStatus[]) data.createTypedArray(PortStatus.CREATOR);
            int _arg26 = data.readInt();
            data.enforceNoDataAvail();
            notifyPortStatusChange(_arg25, _arg26);
            goto L28
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void notifyContaminantEnabledStatus(String r1, boolean r2, int r3, long r4) throws RemoteException;

    void notifyEnableUsbDataStatus(String r1, boolean r2, int r3, long r4) throws RemoteException;

    void notifyEnableUsbDataWhileDockedStatus(String r1, int r2, long r3) throws RemoteException;

    void notifyLimitPowerTransferStatus(String r1, boolean r2, int r3, long r4) throws RemoteException;

    void notifyPortStatusChange(PortStatus[] r1, int r2) throws RemoteException;

    void notifyQueryPortStatus(String r1, int r2, long r3) throws RemoteException;

    void notifyResetUsbPortStatus(String r1, int r2, long r3) throws RemoteException;

    void notifyRoleSwitchStatus(String r1, PortRole r2, int r3, long r4) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$usb$IUsbCallback".replace('$', '.');
    }
}
