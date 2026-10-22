package android.hardware.broadcastradio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IBroadcastRadio extends IInterface {
    public static final int ANTENNA_STATE_CHANGE_TIMEOUT_MS = 100;
    public static final String DESCRIPTOR = null;
    public static final String HASH = "be432e9a5bdd211bdac48d6d03607fa71436f75c";
    public static final int INVALID_IMAGE = 0;
    public static final int LIST_COMPLETE_TIMEOUT_MS = 300000;
    public static final int TUNER_TIMEOUT_MS = 30000;
    public static final int VERSION = 3;

    public static class Default implements IBroadcastRadio {
        public Default() {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public Properties getProperties() throws RemoteException {
            return null;
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public AmFmRegionConfig getAmFmRegionConfig(boolean full) throws RemoteException {
            return null;
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public DabTableEntry[] getDabRegionConfig() throws RemoteException {
            return null;
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public void setTunerCallback(ITunerCallback callback) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public void unsetTunerCallback() throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public void tune(ProgramSelector program) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public void seek(boolean directionUp, boolean skipSubChannel) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public void step(boolean directionUp) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public void cancel() throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public void startProgramListUpdates(ProgramFilter filter) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public void stopProgramListUpdates() throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public boolean isConfigFlagSet(int flag) throws RemoteException {
            return false;
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public void setConfigFlag(int flag, boolean value) throws RemoteException {
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public VendorKeyValue[] setParameters(VendorKeyValue[] parameters) throws RemoteException {
            return null;
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public VendorKeyValue[] getParameters(String[] keys) throws RemoteException {
            return null;
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public byte[] getImage(int id) throws RemoteException {
            return null;
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public ICloseHandle registerAnnouncementListener(IAnnouncementListener listener, byte[] enabled) throws RemoteException {
            return null;
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.broadcastradio.IBroadcastRadio
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IBroadcastRadio {
        static final int TRANSACTION_cancel = 9;
        static final int TRANSACTION_getAmFmRegionConfig = 2;
        static final int TRANSACTION_getDabRegionConfig = 3;
        static final int TRANSACTION_getImage = 16;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getParameters = 15;
        static final int TRANSACTION_getProperties = 1;
        static final int TRANSACTION_isConfigFlagSet = 12;
        static final int TRANSACTION_registerAnnouncementListener = 17;
        static final int TRANSACTION_seek = 7;
        static final int TRANSACTION_setConfigFlag = 13;
        static final int TRANSACTION_setParameters = 14;
        static final int TRANSACTION_setTunerCallback = 4;
        static final int TRANSACTION_startProgramListUpdates = 10;
        static final int TRANSACTION_step = 8;
        static final int TRANSACTION_stopProgramListUpdates = 11;
        static final int TRANSACTION_tune = 6;
        static final int TRANSACTION_unsetTunerCallback = 5;

        private static class Proxy implements IBroadcastRadio {
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
                return IBroadcastRadio.DESCRIPTOR;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public Properties getProperties() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                Properties _result = (Properties) _reply.readTypedObject(Properties.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getProperties is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public AmFmRegionConfig getAmFmRegionConfig(boolean full) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(full);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                AmFmRegionConfig _result = (AmFmRegionConfig) _reply.readTypedObject(AmFmRegionConfig.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getAmFmRegionConfig is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public DabTableEntry[] getDabRegionConfig() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                DabTableEntry[] _result = (DabTableEntry[]) _reply.createTypedArray(DabTableEntry.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getDabRegionConfig is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public void setTunerCallback(ITunerCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setTunerCallback is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public void unsetTunerCallback() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method unsetTunerCallback is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public void tune(ProgramSelector program) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(program, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method tune is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public void seek(boolean directionUp, boolean skipSubChannel) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(directionUp);     // Catch: Throwable -> L8
                _data.writeBoolean(skipSubChannel);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method seek is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public void step(boolean directionUp) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeBoolean(directionUp);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method step is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public void cancel() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method cancel is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public void startProgramListUpdates(ProgramFilter filter) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedObject(filter, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method startProgramListUpdates is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public void stopProgramListUpdates() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method stopProgramListUpdates is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public boolean isConfigFlagSet(int flag) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(flag);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isConfigFlagSet is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public void setConfigFlag(int flag, boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(flag);     // Catch: Throwable -> L8
                _data.writeBoolean(value);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(13, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setConfigFlag is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public VendorKeyValue[] setParameters(VendorKeyValue[] parameters) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeTypedArray(parameters, 0);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(14, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                VendorKeyValue[] _result = (VendorKeyValue[]) _reply.createTypedArray(VendorKeyValue.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method setParameters is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public VendorKeyValue[] getParameters(String[] keys) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStringArray(keys);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(15, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                VendorKeyValue[] _result = (VendorKeyValue[]) _reply.createTypedArray(VendorKeyValue.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getParameters is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public byte[] getImage(int id) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(id);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(16, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                byte[] _result = _reply.createByteArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getImage is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public ICloseHandle registerAnnouncementListener(IAnnouncementListener listener, byte[] enabled) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(listener);     // Catch: Throwable -> L8
                _data.writeByteArray(enabled);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(17, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                ICloseHandle _result = ICloseHandle.Stub.asInterface(_reply.readStrongBinder());     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method registerAnnouncementListener is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.broadcastradio.IBroadcastRadio
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IBroadcastRadio.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IBroadcastRadio.DESCRIPTOR);
        }

        public static IBroadcastRadio asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IBroadcastRadio.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IBroadcastRadio) == false) goto L12;
            return (IBroadcastRadio) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IBroadcastRadio.DESCRIPTOR;
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
                case 1: goto L36;
                case 2: goto L35;
                case 3: goto L34;
                case 4: goto L33;
                case 5: goto L32;
                case 6: goto L31;
                case 7: goto L30;
                case 8: goto L29;
                case 9: goto L28;
                case 10: goto L27;
                case 11: goto L26;
                case 12: goto L25;
                case 13: goto L24;
                case 14: goto L23;
                case 15: goto L22;
                case 16: goto L21;
                case 17: goto L20;
                default: goto L19;
            };
        L20:
            IAnnouncementListener _arg0 = IAnnouncementListener.Stub.asInterface(data.readStrongBinder());
            byte[] _arg1 = data.createByteArray();
            data.enforceNoDataAvail();
            ICloseHandle _result = registerAnnouncementListener(_arg0, _arg1);
            reply.writeNoException();
            reply.writeStrongInterface(_result);
        L37:
            return true;
        L21:
            int _arg2 = data.readInt();
            data.enforceNoDataAvail();
            byte[] _result2 = getImage(_arg2);
            reply.writeNoException();
            reply.writeByteArray(_result2);
            goto L37
        L22:
            String[] _arg3 = data.createStringArray();
            data.enforceNoDataAvail();
            VendorKeyValue[] _result3 = getParameters(_arg3);
            reply.writeNoException();
            reply.writeTypedArray(_result3, 1);
            goto L37
        L23:
            VendorKeyValue[] _arg4 = (VendorKeyValue[]) data.createTypedArray(VendorKeyValue.CREATOR);
            data.enforceNoDataAvail();
            VendorKeyValue[] _result4 = setParameters(_arg4);
            reply.writeNoException();
            reply.writeTypedArray(_result4, 1);
            goto L37
        L24:
            int _arg5 = data.readInt();
            boolean _arg6 = data.readBoolean();
            data.enforceNoDataAvail();
            setConfigFlag(_arg5, _arg6);
            reply.writeNoException();
            goto L37
        L25:
            int _arg7 = data.readInt();
            data.enforceNoDataAvail();
            boolean _result5 = isConfigFlagSet(_arg7);
            reply.writeNoException();
            reply.writeBoolean(_result5);
            goto L37
        L26:
            stopProgramListUpdates();
            reply.writeNoException();
            goto L37
        L27:
            ProgramFilter _arg8 = (ProgramFilter) data.readTypedObject(ProgramFilter.CREATOR);
            data.enforceNoDataAvail();
            startProgramListUpdates(_arg8);
            reply.writeNoException();
            goto L37
        L28:
            cancel();
            reply.writeNoException();
            goto L37
        L29:
            boolean _arg9 = data.readBoolean();
            data.enforceNoDataAvail();
            step(_arg9);
            reply.writeNoException();
            goto L37
        L30:
            boolean _arg10 = data.readBoolean();
            boolean _arg11 = data.readBoolean();
            data.enforceNoDataAvail();
            seek(_arg10, _arg11);
            reply.writeNoException();
            goto L37
        L31:
            ProgramSelector _arg12 = (ProgramSelector) data.readTypedObject(ProgramSelector.CREATOR);
            data.enforceNoDataAvail();
            tune(_arg12);
            reply.writeNoException();
            goto L37
        L32:
            unsetTunerCallback();
            reply.writeNoException();
            goto L37
        L33:
            ITunerCallback _arg13 = ITunerCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            setTunerCallback(_arg13);
            reply.writeNoException();
            goto L37
        L34:
            DabTableEntry[] _result6 = getDabRegionConfig();
            reply.writeNoException();
            reply.writeTypedArray(_result6, 1);
            goto L37
        L35:
            boolean _arg14 = data.readBoolean();
            data.enforceNoDataAvail();
            AmFmRegionConfig _result7 = getAmFmRegionConfig(_arg14);
            reply.writeNoException();
            reply.writeTypedObject(_result7, 1);
            goto L37
        L36:
            Properties _result8 = getProperties();
            reply.writeNoException();
            reply.writeTypedObject(_result8, 1);
            goto L37
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void cancel() throws RemoteException;

    AmFmRegionConfig getAmFmRegionConfig(boolean r1) throws RemoteException;

    DabTableEntry[] getDabRegionConfig() throws RemoteException;

    byte[] getImage(int r1) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    VendorKeyValue[] getParameters(String[] r1) throws RemoteException;

    Properties getProperties() throws RemoteException;

    boolean isConfigFlagSet(int r1) throws RemoteException;

    ICloseHandle registerAnnouncementListener(IAnnouncementListener r1, byte[] r2) throws RemoteException;

    void seek(boolean r1, boolean r2) throws RemoteException;

    void setConfigFlag(int r1, boolean r2) throws RemoteException;

    VendorKeyValue[] setParameters(VendorKeyValue[] r1) throws RemoteException;

    void setTunerCallback(ITunerCallback r1) throws RemoteException;

    void startProgramListUpdates(ProgramFilter r1) throws RemoteException;

    void step(boolean r1) throws RemoteException;

    void stopProgramListUpdates() throws RemoteException;

    void tune(ProgramSelector r1) throws RemoteException;

    void unsetTunerCallback() throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$broadcastradio$IBroadcastRadio".replace('$', '.');
    }
}
