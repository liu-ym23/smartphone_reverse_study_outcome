package android.hardware.usb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IUsb extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "7fe46e9531884739d925b8caeee9dba5c411e228";
    public static final int VERSION = 3;

    public static class Default implements IUsb {
        public Default() {
        }

        @Override // android.hardware.usb.IUsb
        public void enableContaminantPresenceDetection(String portName, boolean enable, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsb
        public void enableUsbData(String portName, boolean enable, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsb
        public void enableUsbDataWhileDocked(String portName, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsb
        public void queryPortStatus(long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsb
        public void setCallback(IUsbCallback callback) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsb
        public void switchRole(String portName, PortRole role, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsb
        public void limitPowerTransfer(String portName, boolean limit, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsb
        public void resetUsbPort(String portName, long transactionId) throws RemoteException {
        }

        @Override // android.hardware.usb.IUsb
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.usb.IUsb
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUsb {
        static final int TRANSACTION_enableContaminantPresenceDetection = 1;
        static final int TRANSACTION_enableUsbData = 2;
        static final int TRANSACTION_enableUsbDataWhileDocked = 3;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_limitPowerTransfer = 7;
        static final int TRANSACTION_queryPortStatus = 4;
        static final int TRANSACTION_resetUsbPort = 8;
        static final int TRANSACTION_setCallback = 5;
        static final int TRANSACTION_switchRole = 6;

        private static class Proxy implements IUsb {
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
                return IUsb.DESCRIPTOR;
            }

            @Override // android.hardware.usb.IUsb
            public void enableContaminantPresenceDetection(String portName, boolean enable, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeBoolean(enable);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method enableContaminantPresenceDetection is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsb
            public void enableUsbData(String portName, boolean enable, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeBoolean(enable);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method enableUsbData is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsb
            public void enableUsbDataWhileDocked(String portName, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method enableUsbDataWhileDocked is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsb
            public void queryPortStatus(long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method queryPortStatus is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsb
            public void setCallback(IUsbCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method setCallback is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsb
            public void switchRole(String portName, PortRole role, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeTypedObject(role, 0);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method switchRole is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsb
            public void limitPowerTransfer(String portName, boolean limit, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeBoolean(limit);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(7, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method limitPowerTransfer is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsb
            public void resetUsbPort(String portName, long transactionId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeString(portName);     // Catch: Throwable -> L9
                _data.writeLong(transactionId);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method resetUsbPort is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.usb.IUsb
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.usb.IUsb
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IUsb.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IUsb.DESCRIPTOR);
        }

        public static IUsb asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IUsb.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IUsb) == false) goto L12;
            return (IUsb) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IUsb.DESCRIPTOR;
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
            long _arg1 = data.readLong();
            data.enforceNoDataAvail();
            resetUsbPort(_arg0, _arg1);
        L28:
            return true;
        L21:
            String _arg2 = data.readString();
            boolean _arg3 = data.readBoolean();
            long _arg4 = data.readLong();
            data.enforceNoDataAvail();
            limitPowerTransfer(_arg2, _arg3, _arg4);
            goto L28
        L22:
            String _arg5 = data.readString();
            PortRole _arg6 = (PortRole) data.readTypedObject(PortRole.CREATOR);
            long _arg7 = data.readLong();
            data.enforceNoDataAvail();
            switchRole(_arg5, _arg6, _arg7);
            goto L28
        L23:
            IUsbCallback _arg8 = IUsbCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setCallback(_arg8);
            goto L28
        L24:
            long _arg9 = data.readLong();
            data.enforceNoDataAvail();
            queryPortStatus(_arg9);
            goto L28
        L25:
            String _arg10 = data.readString();
            long _arg11 = data.readLong();
            data.enforceNoDataAvail();
            enableUsbDataWhileDocked(_arg10, _arg11);
            goto L28
        L26:
            String _arg12 = data.readString();
            boolean _arg13 = data.readBoolean();
            long _arg14 = data.readLong();
            data.enforceNoDataAvail();
            enableUsbData(_arg12, _arg13, _arg14);
            goto L28
        L27:
            String _arg15 = data.readString();
            boolean _arg16 = data.readBoolean();
            long _arg17 = data.readLong();
            data.enforceNoDataAvail();
            enableContaminantPresenceDetection(_arg15, _arg16, _arg17);
            goto L28
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void enableContaminantPresenceDetection(String r1, boolean r2, long r3) throws RemoteException;

    void enableUsbData(String r1, boolean r2, long r3) throws RemoteException;

    void enableUsbDataWhileDocked(String r1, long r2) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void limitPowerTransfer(String r1, boolean r2, long r3) throws RemoteException;

    void queryPortStatus(long r1) throws RemoteException;

    void resetUsbPort(String r1, long r2) throws RemoteException;

    void setCallback(IUsbCallback r1) throws RemoteException;

    void switchRole(String r1, PortRole r2, long r3) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$usb$IUsb".replace('$', '.');
    }
}
