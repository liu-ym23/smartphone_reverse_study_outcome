package android.hardware.tv.hdmi.cec;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IHdmiCec extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "cd956e3a0c2e6ade71693c85e9f0aeffa221ea26";
    public static final int VERSION = 1;

    public static class Default implements IHdmiCec {
        public Default() {
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public byte addLogicalAddress(byte addr) throws RemoteException {
            return 0;
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public void clearLogicalAddress() throws RemoteException {
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public void enableAudioReturnChannel(int portId, boolean enable) throws RemoteException {
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public int getCecVersion() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public int getPhysicalAddress() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public int getVendorId() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public byte sendMessage(CecMessage message) throws RemoteException {
            return 0;
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public void setCallback(IHdmiCecCallback callback) throws RemoteException {
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public void setLanguage(String language) throws RemoteException {
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public void enableWakeupByOtp(boolean value) throws RemoteException {
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public void enableCec(boolean value) throws RemoteException {
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public void enableSystemCecControl(boolean value) throws RemoteException {
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCec
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IHdmiCec {
        static final int TRANSACTION_addLogicalAddress = 1;
        static final int TRANSACTION_clearLogicalAddress = 2;
        static final int TRANSACTION_enableAudioReturnChannel = 3;
        static final int TRANSACTION_enableCec = 11;
        static final int TRANSACTION_enableSystemCecControl = 12;
        static final int TRANSACTION_enableWakeupByOtp = 10;
        static final int TRANSACTION_getCecVersion = 4;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getPhysicalAddress = 5;
        static final int TRANSACTION_getVendorId = 6;
        static final int TRANSACTION_sendMessage = 7;
        static final int TRANSACTION_setCallback = 8;
        static final int TRANSACTION_setLanguage = 9;

        private static class Proxy implements IHdmiCec {
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
                return IHdmiCec.DESCRIPTOR;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public byte addLogicalAddress(byte addr) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeByte(addr);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                byte _result = _reply.readByte();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method addLogicalAddress is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public void clearLogicalAddress() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method clearLogicalAddress is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public void enableAudioReturnChannel(int portId, boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(portId);     // Catch: Throwable -> L8
                _data.writeBoolean(enable);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method enableAudioReturnChannel is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public int getCecVersion() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getCecVersion is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public int getPhysicalAddress() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getPhysicalAddress is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public int getVendorId() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getVendorId is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public byte sendMessage(CecMessage message) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(message, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                byte _result = _reply.readByte();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method sendMessage is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public void setCallback(IHdmiCecCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setCallback is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public void setLanguage(String language) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(language);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setLanguage is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public void enableWakeupByOtp(boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(value);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method enableWakeupByOtp is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public void enableCec(boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(value);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method enableCec is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public void enableSystemCecControl(boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(value);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method enableSystemCecControl is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.tv.hdmi.cec.IHdmiCec
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IHdmiCec.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IHdmiCec.DESCRIPTOR);
        }

        public static IHdmiCec asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IHdmiCec.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IHdmiCec) == false) goto L12;
            return (IHdmiCec) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IHdmiCec.DESCRIPTOR;
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
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L21;
                case 12: goto L20;
                default: goto L19;
            };
        L20:
            boolean _arg0 = data.readBoolean();
            data.enforceNoDataAvail();
            enableSystemCecControl(_arg0);
            reply.writeNoException();
        L32:
            return true;
        L21:
            boolean _arg1 = data.readBoolean();
            data.enforceNoDataAvail();
            enableCec(_arg1);
            reply.writeNoException();
            goto L32
        L22:
            boolean _arg2 = data.readBoolean();
            data.enforceNoDataAvail();
            enableWakeupByOtp(_arg2);
            reply.writeNoException();
            goto L32
        L23:
            String _arg3 = data.readString();
            data.enforceNoDataAvail();
            setLanguage(_arg3);
            reply.writeNoException();
            goto L32
        L24:
            IHdmiCecCallback _arg4 = IHdmiCecCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setCallback(_arg4);
            reply.writeNoException();
            goto L32
        L25:
            CecMessage _arg5 = (CecMessage) data.readTypedObject(CecMessage.CREATOR);
            data.enforceNoDataAvail();
            byte _result = sendMessage(_arg5);
            reply.writeNoException();
            reply.writeByte(_result);
            goto L32
        L26:
            int _result2 = getVendorId();
            reply.writeNoException();
            reply.writeInt(_result2);
            goto L32
        L27:
            int _result3 = getPhysicalAddress();
            reply.writeNoException();
            reply.writeInt(_result3);
            goto L32
        L28:
            int _result4 = getCecVersion();
            reply.writeNoException();
            reply.writeInt(_result4);
            goto L32
        L29:
            int _arg6 = data.readInt();
            boolean _arg7 = data.readBoolean();
            data.enforceNoDataAvail();
            enableAudioReturnChannel(_arg6, _arg7);
            reply.writeNoException();
            goto L32
        L30:
            clearLogicalAddress();
            reply.writeNoException();
            goto L32
        L31:
            byte _arg8 = data.readByte();
            data.enforceNoDataAvail();
            byte _result5 = addLogicalAddress(_arg8);
            reply.writeNoException();
            reply.writeByte(_result5);
            goto L32
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    byte addLogicalAddress(byte r1) throws RemoteException;

    void clearLogicalAddress() throws RemoteException;

    void enableAudioReturnChannel(int r1, boolean r2) throws RemoteException;

    void enableCec(boolean r1) throws RemoteException;

    void enableSystemCecControl(boolean r1) throws RemoteException;

    void enableWakeupByOtp(boolean r1) throws RemoteException;

    int getCecVersion() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    int getPhysicalAddress() throws RemoteException;

    int getVendorId() throws RemoteException;

    byte sendMessage(CecMessage r1) throws RemoteException;

    void setCallback(IHdmiCecCallback r1) throws RemoteException;

    void setLanguage(String r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$tv$hdmi$cec$IHdmiCec".replace('$', '.');
    }
}
