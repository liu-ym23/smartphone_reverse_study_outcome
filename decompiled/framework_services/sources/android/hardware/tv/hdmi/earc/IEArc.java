package android.hardware.tv.hdmi.earc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IEArc extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "101230f18c7b8438921e517e80eea4ccc7c1e463";
    public static final int VERSION = 1;

    public static class Default implements IEArc {
        public Default() {
        }

        @Override // android.hardware.tv.hdmi.earc.IEArc
        public void setEArcEnabled(boolean enabled) throws RemoteException {
        }

        @Override // android.hardware.tv.hdmi.earc.IEArc
        public boolean isEArcEnabled() throws RemoteException {
            return false;
        }

        @Override // android.hardware.tv.hdmi.earc.IEArc
        public void setCallback(IEArcCallback callback) throws RemoteException {
        }

        @Override // android.hardware.tv.hdmi.earc.IEArc
        public byte getState(int portId) throws RemoteException {
            return 0;
        }

        @Override // android.hardware.tv.hdmi.earc.IEArc
        public byte[] getLastReportedAudioCapabilities(int portId) throws RemoteException {
            return null;
        }

        @Override // android.hardware.tv.hdmi.earc.IEArc
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.tv.hdmi.earc.IEArc
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IEArc {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getLastReportedAudioCapabilities = 5;
        static final int TRANSACTION_getState = 4;
        static final int TRANSACTION_isEArcEnabled = 2;
        static final int TRANSACTION_setCallback = 3;
        static final int TRANSACTION_setEArcEnabled = 1;

        private static class Proxy implements IEArc {
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
                return IEArc.DESCRIPTOR;
            }

            @Override // android.hardware.tv.hdmi.earc.IEArc
            public void setEArcEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEArc.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(enabled);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setEArcEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.earc.IEArc
            public boolean isEArcEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEArc.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isEArcEnabled is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.earc.IEArc
            public void setCallback(IEArcCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEArc.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
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

            @Override // android.hardware.tv.hdmi.earc.IEArc
            public byte getState(int portId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEArc.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(portId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                byte _result = _reply.readByte();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getState is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.earc.IEArc
            public byte[] getLastReportedAudioCapabilities(int portId) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IEArc.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(portId);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                byte[] _result = _reply.createByteArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getLastReportedAudioCapabilities is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.tv.hdmi.earc.IEArc
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IEArc.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.tv.hdmi.earc.IEArc
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IEArc.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IEArc.DESCRIPTOR);
        }

        public static IEArc asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IEArc.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IEArc) == false) goto L12;
            return (IEArc) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IEArc.DESCRIPTOR;
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
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                default: goto L19;
            };
        L20:
            int _arg0 = data.readInt();
            data.enforceNoDataAvail();
            byte[] _result = getLastReportedAudioCapabilities(_arg0);
            reply.writeNoException();
            reply.writeByteArray(_result);
        L25:
            return true;
        L21:
            int _arg1 = data.readInt();
            data.enforceNoDataAvail();
            byte _result2 = getState(_arg1);
            reply.writeNoException();
            reply.writeByte(_result2);
            goto L25
        L22:
            IEArcCallback _arg2 = IEArcCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setCallback(_arg2);
            reply.writeNoException();
            goto L25
        L23:
            boolean _result3 = isEArcEnabled();
            reply.writeNoException();
            reply.writeBoolean(_result3);
            goto L25
        L24:
            boolean _arg3 = data.readBoolean();
            data.enforceNoDataAvail();
            setEArcEnabled(_arg3);
            reply.writeNoException();
            goto L25
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    byte[] getLastReportedAudioCapabilities(int r1) throws RemoteException;

    byte getState(int r1) throws RemoteException;

    boolean isEArcEnabled() throws RemoteException;

    void setCallback(IEArcCallback r1) throws RemoteException;

    void setEArcEnabled(boolean r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$tv$hdmi$earc$IEArc".replace('$', '.');
    }
}
