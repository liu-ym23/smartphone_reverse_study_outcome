package vendor.bytedance.thermalextservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICdspMonitor extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "9fa87beb6e476c774f619c66a68b52aab48242b3";
    public static final int VERSION = 2;

    public static class Default implements ICdspMonitor {
        public Default() {
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public int openProfileHandle() throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public int closeProfileHandle() throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public int startProfile() throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public int stopProfile() throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public CdspUtilizations getUtilization() throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public float getCoreClock() throws RemoteException {
            return 0.0f;
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public float[] queryAvailableCoreClocks() throws RemoteException {
            return null;
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public void getDspInfoAsync(ICdspCallback callback) throws RemoteException {
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public void getDspInfoAsyncWithWindow(int sampleWindowMs, ICdspCallback callback) throws RemoteException {
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.bytedance.thermalextservice.ICdspMonitor
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICdspMonitor {
        static final int TRANSACTION_closeProfileHandle = 2;
        static final int TRANSACTION_getCoreClock = 6;
        static final int TRANSACTION_getDspInfoAsync = 8;
        static final int TRANSACTION_getDspInfoAsyncWithWindow = 9;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getUtilization = 5;
        static final int TRANSACTION_openProfileHandle = 1;
        static final int TRANSACTION_queryAvailableCoreClocks = 7;
        static final int TRANSACTION_startProfile = 3;
        static final int TRANSACTION_stopProfile = 4;

        private static class Proxy implements ICdspMonitor {
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
                return ICdspMonitor.DESCRIPTOR;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public int openProfileHandle() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method openProfileHandle is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public int closeProfileHandle() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method closeProfileHandle is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public int startProfile() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method startProfile is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public int stopProfile() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method stopProfile is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public CdspUtilizations getUtilization() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                CdspUtilizations _result = (CdspUtilizations) _reply.readTypedObject(CdspUtilizations.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getUtilization is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public float getCoreClock() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                float _result = _reply.readFloat();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getCoreClock is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public float[] queryAvailableCoreClocks() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                float[] _result = _reply.createFloatArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method queryAvailableCoreClocks is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public void getDspInfoAsync(ICdspCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(8, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method getDspInfoAsync is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public void getDspInfoAsyncWithWindow(int sampleWindowMs, ICdspCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                _data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(sampleWindowMs);     // Catch: Throwable -> L9
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(9, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method getDspInfoAsyncWithWindow is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // vendor.bytedance.thermalextservice.ICdspMonitor
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain();     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(ICdspMonitor.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, ICdspMonitor.DESCRIPTOR);
        }

        public static ICdspMonitor asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(ICdspMonitor.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof ICdspMonitor) == false) goto L12;
            return (ICdspMonitor) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = ICdspMonitor.DESCRIPTOR;
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
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                default: goto L19;
            };
        L20:
            int _arg0 = data.readInt();
            ICdspCallback _arg1 = ICdspCallback.Stub.asInterface(data.readStrongBinder());
            getDspInfoAsyncWithWindow(_arg0, _arg1);
        L29:
            return true;
        L21:
            ICdspCallback _arg2 = ICdspCallback.Stub.asInterface(data.readStrongBinder());
            getDspInfoAsync(_arg2);
            goto L29
        L22:
            float[] _result = queryAvailableCoreClocks();
            reply.writeNoException();
            reply.writeFloatArray(_result);
            goto L29
        L23:
            float _result2 = getCoreClock();
            reply.writeNoException();
            reply.writeFloat(_result2);
            goto L29
        L24:
            CdspUtilizations _result3 = getUtilization();
            reply.writeNoException();
            reply.writeTypedObject(_result3, 1);
            goto L29
        L25:
            int _result4 = stopProfile();
            reply.writeNoException();
            reply.writeInt(_result4);
            goto L29
        L26:
            int _result5 = startProfile();
            reply.writeNoException();
            reply.writeInt(_result5);
            goto L29
        L27:
            int _result6 = closeProfileHandle();
            reply.writeNoException();
            reply.writeInt(_result6);
            goto L29
        L28:
            int _result7 = openProfileHandle();
            reply.writeNoException();
            reply.writeInt(_result7);
            goto L29
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    int closeProfileHandle() throws RemoteException;

    float getCoreClock() throws RemoteException;

    void getDspInfoAsync(ICdspCallback r1) throws RemoteException;

    void getDspInfoAsyncWithWindow(int r1, ICdspCallback r2) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    CdspUtilizations getUtilization() throws RemoteException;

    int openProfileHandle() throws RemoteException;

    float[] queryAvailableCoreClocks() throws RemoteException;

    int startProfile() throws RemoteException;

    int stopProfile() throws RemoteException;

    static {
        DESCRIPTOR = "vendor$bytedance$thermalextservice$ICdspMonitor".replace('$', '.');
    }
}
