package android.hardware.broadcastradio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ITunerCallback extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "be432e9a5bdd211bdac48d6d03607fa71436f75c";
    public static final int VERSION = 3;

    public static class Default implements ITunerCallback {
        public Default() {
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onTuneFailed(int result, ProgramSelector selector) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onCurrentProgramInfoChanged(ProgramInfo info) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onProgramListUpdated(ProgramListChunk chunk) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onAntennaStateChange(boolean connected) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onConfigFlagUpdated(int flag, boolean value) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public void onParametersUpdated(VendorKeyValue[] parameters) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.broadcastradio.ITunerCallback
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITunerCallback {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onAntennaStateChange = 4;
        static final int TRANSACTION_onConfigFlagUpdated = 5;
        static final int TRANSACTION_onCurrentProgramInfoChanged = 2;
        static final int TRANSACTION_onParametersUpdated = 6;
        static final int TRANSACTION_onProgramListUpdated = 3;
        static final int TRANSACTION_onTuneFailed = 1;

        private static class Proxy implements ITunerCallback {
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
                return ITunerCallback.DESCRIPTOR;
            }

            @Override // android.hardware.broadcastradio.ITunerCallback
            public void onTuneFailed(int result, ProgramSelector selector) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITunerCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(result);     // Catch: Throwable -> L9
                _data.writeTypedObject(selector, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onTuneFailed is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.ITunerCallback
            public void onCurrentProgramInfoChanged(ProgramInfo info) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITunerCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(info, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onCurrentProgramInfoChanged is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.ITunerCallback
            public void onProgramListUpdated(ProgramListChunk chunk) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITunerCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(chunk, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(3, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onProgramListUpdated is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.ITunerCallback
            public void onAntennaStateChange(boolean connected) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITunerCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeBoolean(connected);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(4, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onAntennaStateChange is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.ITunerCallback
            public void onConfigFlagUpdated(int flag, boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITunerCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(flag);     // Catch: Throwable -> L9
                _data.writeBoolean(value);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(5, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onConfigFlagUpdated is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.ITunerCallback
            public void onParametersUpdated(VendorKeyValue[] parameters) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(ITunerCallback.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedArray(parameters, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(6, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method onParametersUpdated is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.ITunerCallback
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(ITunerCallback.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.broadcastradio.ITunerCallback
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(ITunerCallback.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, ITunerCallback.DESCRIPTOR);
        }

        public static ITunerCallback asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(ITunerCallback.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof ITunerCallback) == false) goto L12;
            return (ITunerCallback) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = ITunerCallback.DESCRIPTOR;
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
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                default: goto L19;
            };
        L20:
            VendorKeyValue[] _arg0 = (VendorKeyValue[]) data.createTypedArray(VendorKeyValue.CREATOR);
            data.enforceNoDataAvail();
            onParametersUpdated(_arg0);
        L26:
            return true;
        L21:
            int _arg1 = data.readInt();
            boolean _arg2 = data.readBoolean();
            data.enforceNoDataAvail();
            onConfigFlagUpdated(_arg1, _arg2);
            goto L26
        L22:
            boolean _arg3 = data.readBoolean();
            data.enforceNoDataAvail();
            onAntennaStateChange(_arg3);
            goto L26
        L23:
            ProgramListChunk _arg4 = (ProgramListChunk) data.readTypedObject(ProgramListChunk.CREATOR);
            data.enforceNoDataAvail();
            onProgramListUpdated(_arg4);
            goto L26
        L24:
            ProgramInfo _arg5 = (ProgramInfo) data.readTypedObject(ProgramInfo.CREATOR);
            data.enforceNoDataAvail();
            onCurrentProgramInfoChanged(_arg5);
            goto L26
        L25:
            int _arg6 = data.readInt();
            ProgramSelector _arg7 = (ProgramSelector) data.readTypedObject(ProgramSelector.CREATOR);
            data.enforceNoDataAvail();
            onTuneFailed(_arg6, _arg7);
            goto L26
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void onAntennaStateChange(boolean r1) throws RemoteException;

    void onConfigFlagUpdated(int r1, boolean r2) throws RemoteException;

    void onCurrentProgramInfoChanged(ProgramInfo r1) throws RemoteException;

    void onParametersUpdated(VendorKeyValue[] r1) throws RemoteException;

    void onProgramListUpdated(ProgramListChunk r1) throws RemoteException;

    void onTuneFailed(int r1, ProgramSelector r2) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$broadcastradio$ITunerCallback".replace('$', '.');
    }
}
