package vendor.qti.hardware.servicetrackeraidl;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IServicetracker extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "fd4771abe6e1c694687c871ee5d888b6e9cbf7b0";
    public static final int VERSION = 1;

    public static class Default implements IServicetracker {
        public Default() {
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public void bindService(ServiceData serviceData, ClientData clientData) throws RemoteException {
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public void destroyService(ServiceData serviceData) throws RemoteException {
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public ClientConnection[] getClientConnections(String clientName) throws RemoteException {
            return null;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public int getPid(String processName) throws RemoteException {
            return 0;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public int[] getPids(String[] serviceList) throws RemoteException {
            return null;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public int[] getRunningServicePid() throws RemoteException {
            return null;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public int getServiceBCount(ServiceRecord[] bServiceList) throws RemoteException {
            return 0;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public ServiceConnection[] getServiceConnections(String serviceName) throws RemoteException {
            return null;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public ClientRecord getclientInfo(String clientName) throws RemoteException {
            return null;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public ServiceRecord getserviceInfo(String serviceName) throws RemoteException {
            return null;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public boolean isServiceB(String serviceName) throws RemoteException {
            return false;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public void killProcess(int pid) throws RemoteException {
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public void startService(ServiceData serviceData) throws RemoteException {
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public void unbindService(ServiceData serviceData, ClientData clientData) throws RemoteException {
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IServicetracker {
        static final int TRANSACTION_bindService = 1;
        static final int TRANSACTION_destroyService = 2;
        static final int TRANSACTION_getClientConnections = 3;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getPid = 4;
        static final int TRANSACTION_getPids = 5;
        static final int TRANSACTION_getRunningServicePid = 6;
        static final int TRANSACTION_getServiceBCount = 7;
        static final int TRANSACTION_getServiceConnections = 8;
        static final int TRANSACTION_getclientInfo = 9;
        static final int TRANSACTION_getserviceInfo = 10;
        static final int TRANSACTION_isServiceB = 11;
        static final int TRANSACTION_killProcess = 12;
        static final int TRANSACTION_startService = 13;
        static final int TRANSACTION_unbindService = 14;

        private static class Proxy implements IServicetracker {
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
                return IServicetracker.DESCRIPTOR;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public void bindService(ServiceData serviceData, ClientData clientData) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(serviceData, 0);     // Catch: Throwable -> L9
                _data.writeTypedObject(clientData, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(1, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method bindService is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public void destroyService(ServiceData serviceData) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(serviceData, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(2, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method destroyService is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public ClientConnection[] getClientConnections(String clientName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(clientName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                ClientConnection[] _result = (ClientConnection[]) _reply.createTypedArray(ClientConnection.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getClientConnections is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public int getPid(String processName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(processName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getPid is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public int[] getPids(String[] serviceList) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStringArray(serviceList);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int[] _result = _reply.createIntArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getPids is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public int[] getRunningServicePid() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int[] _result = _reply.createIntArray();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getRunningServicePid is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public int getServiceBCount(ServiceRecord[] bServiceList) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(bServiceList.length);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.readTypedArray(bServiceList, ServiceRecord.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getServiceBCount is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public ServiceConnection[] getServiceConnections(String serviceName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(serviceName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                ServiceConnection[] _result = (ServiceConnection[]) _reply.createTypedArray(ServiceConnection.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getServiceConnections is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public ClientRecord getclientInfo(String clientName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(clientName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                ClientRecord _result = (ClientRecord) _reply.readTypedObject(ClientRecord.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getclientInfo is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public ServiceRecord getserviceInfo(String serviceName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(serviceName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                ServiceRecord _result = (ServiceRecord) _reply.readTypedObject(ServiceRecord.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getserviceInfo is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public boolean isServiceB(String serviceName) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeString(serviceName);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                boolean _result = _reply.readBoolean();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method isServiceB is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public void killProcess(int pid) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeInt(pid);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(12, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method killProcess is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public void startService(ServiceData serviceData) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(serviceData, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(13, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method startService is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public void unbindService(ServiceData serviceData, ClientData clientData) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                _data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L9
                _data.writeTypedObject(serviceData, 0);     // Catch: Throwable -> L9
                _data.writeTypedObject(clientData, 0);     // Catch: Throwable -> L9
                boolean _status = this.mRemote.transact(14, _data, null, 1);     // Catch: Throwable -> L9
                if (_status == false) goto L8;
                _data.recycle();
                return;
            L8:
                throw new RemoteException("Method unbindService is unimplemented.");     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                _data.recycle();
                throw th;
            }

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // vendor.qti.hardware.servicetrackeraidl.IServicetracker
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IServicetracker.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IServicetracker.DESCRIPTOR);
        }

        public static IServicetracker asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IServicetracker.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IServicetracker) == false) goto L12;
            return (IServicetracker) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IServicetracker.DESCRIPTOR;
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
                case 1: goto L40;
                case 2: goto L39;
                case 3: goto L38;
                case 4: goto L37;
                case 5: goto L36;
                case 6: goto L35;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 12: goto L22;
                case 13: goto L21;
                case 14: goto L20;
                default: goto L19;
            };
        L20:
            ServiceData _arg0 = (ServiceData) data.readTypedObject(ServiceData.CREATOR);
            ClientData _arg1 = (ClientData) data.readTypedObject(ClientData.CREATOR);
            data.enforceNoDataAvail();
            unbindService(_arg0, _arg1);
        L41:
            return true;
        L21:
            ServiceData _arg2 = (ServiceData) data.readTypedObject(ServiceData.CREATOR);
            data.enforceNoDataAvail();
            startService(_arg2);
            goto L41
        L22:
            int _arg3 = data.readInt();
            data.enforceNoDataAvail();
            killProcess(_arg3);
            goto L41
        L23:
            String _arg4 = data.readString();
            data.enforceNoDataAvail();
            boolean _result = isServiceB(_arg4);
            reply.writeNoException();
            reply.writeBoolean(_result);
            goto L41
        L24:
            String _arg5 = data.readString();
            data.enforceNoDataAvail();
            ServiceRecord _result2 = getserviceInfo(_arg5);
            reply.writeNoException();
            reply.writeTypedObject(_result2, 1);
            goto L41
        L25:
            String _arg6 = data.readString();
            data.enforceNoDataAvail();
            ClientRecord _result3 = getclientInfo(_arg6);
            reply.writeNoException();
            reply.writeTypedObject(_result3, 1);
            goto L41
        L26:
            String _arg7 = data.readString();
            data.enforceNoDataAvail();
            ServiceConnection[] _result4 = getServiceConnections(_arg7);
            reply.writeNoException();
            reply.writeTypedArray(_result4, 1);
            goto L41
        L27:
            int _arg0_length = data.readInt();
            if (_arg0_length > 1000000) goto L34;
            if (_arg0_length >= 0) goto L31;
            ServiceRecord[] _arg8 = null;
        L32:
            data.enforceNoDataAvail();
            int _result5 = getServiceBCount(_arg8);
            reply.writeNoException();
            reply.writeInt(_result5);
            reply.writeTypedArray(_arg8, 1);
            goto L41
        L31:
            _arg8 = new ServiceRecord[_arg0_length];
            goto L32
        L34:
            throw new BadParcelableException("Array too large: " + _arg0_length);
        L35:
            int[] _result6 = getRunningServicePid();
            reply.writeNoException();
            reply.writeIntArray(_result6);
            goto L41
        L36:
            String[] _arg9 = data.createStringArray();
            data.enforceNoDataAvail();
            int[] _result7 = getPids(_arg9);
            reply.writeNoException();
            reply.writeIntArray(_result7);
            goto L41
        L37:
            String _arg10 = data.readString();
            data.enforceNoDataAvail();
            int _result8 = getPid(_arg10);
            reply.writeNoException();
            reply.writeInt(_result8);
            goto L41
        L38:
            String _arg11 = data.readString();
            data.enforceNoDataAvail();
            ClientConnection[] _result9 = getClientConnections(_arg11);
            reply.writeNoException();
            reply.writeTypedArray(_result9, 1);
            goto L41
        L39:
            ServiceData _arg12 = (ServiceData) data.readTypedObject(ServiceData.CREATOR);
            data.enforceNoDataAvail();
            destroyService(_arg12);
            goto L41
        L40:
            ServiceData _arg13 = (ServiceData) data.readTypedObject(ServiceData.CREATOR);
            ClientData _arg14 = (ClientData) data.readTypedObject(ClientData.CREATOR);
            data.enforceNoDataAvail();
            bindService(_arg13, _arg14);
            goto L41
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    void bindService(ServiceData r1, ClientData r2) throws RemoteException;

    void destroyService(ServiceData r1) throws RemoteException;

    ClientConnection[] getClientConnections(String r1) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    int getPid(String r1) throws RemoteException;

    int[] getPids(String[] r1) throws RemoteException;

    int[] getRunningServicePid() throws RemoteException;

    int getServiceBCount(ServiceRecord[] r1) throws RemoteException;

    ServiceConnection[] getServiceConnections(String r1) throws RemoteException;

    ClientRecord getclientInfo(String r1) throws RemoteException;

    ServiceRecord getserviceInfo(String r1) throws RemoteException;

    boolean isServiceB(String r1) throws RemoteException;

    void killProcess(int r1) throws RemoteException;

    void startService(ServiceData r1) throws RemoteException;

    void unbindService(ServiceData r1, ClientData r2) throws RemoteException;

    static {
        DESCRIPTOR = "vendor$qti$hardware$servicetrackeraidl$IServicetracker".replace('$', '.');
    }
}
