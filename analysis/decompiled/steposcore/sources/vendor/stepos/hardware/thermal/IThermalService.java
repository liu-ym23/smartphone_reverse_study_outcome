package vendor.stepos.hardware.thermal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.StepOSDateTimeUrlHelper;
import vendor.stepos.hardware.thermal.IThermalCallback;

/* loaded from: classes.dex */
public interface IThermalService extends IInterface {
    public static final String DESCRIPTOR = "vendor$stepos$hardware$thermal$IThermalService".replace('$', '.');
    public static final String HASH = "0c400c5f92d740b539cc820939fb9bb6fd9477e6";
    public static final int VERSION = 1;

    ThermalSample[] getAllTemperatures() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    int getMaxTemperature() throws RemoteException;

    int getTemperature(String str) throws RemoteException;

    void registerCallback(IThermalCallback iThermalCallback) throws RemoteException;

    void unregisterCallback(IThermalCallback iThermalCallback) throws RemoteException;

    public static class Default implements IThermalService {
        @Override // vendor.stepos.hardware.thermal.IThermalService
        public int getTemperature(String sensorName) throws RemoteException {
            return 0;
        }

        @Override // vendor.stepos.hardware.thermal.IThermalService
        public int getMaxTemperature() throws RemoteException {
            return 0;
        }

        @Override // vendor.stepos.hardware.thermal.IThermalService
        public ThermalSample[] getAllTemperatures() throws RemoteException {
            return null;
        }

        @Override // vendor.stepos.hardware.thermal.IThermalService
        public void registerCallback(IThermalCallback callback) throws RemoteException {
        }

        @Override // vendor.stepos.hardware.thermal.IThermalService
        public void unregisterCallback(IThermalCallback callback) throws RemoteException {
        }

        @Override // vendor.stepos.hardware.thermal.IThermalService
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // vendor.stepos.hardware.thermal.IThermalService
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IThermalService {
        static final int TRANSACTION_getAllTemperatures = 3;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getMaxTemperature = 2;
        static final int TRANSACTION_getTemperature = 1;
        static final int TRANSACTION_registerCallback = 4;
        static final int TRANSACTION_unregisterCallback = 5;

        public Stub() {
            markVintfStability();
            attachInterface(this, DESCRIPTOR);
        }

        public static IThermalService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IThermalService)) {
                return (IThermalService) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = DESCRIPTOR;
            if (code >= 1 && code <= TRANSACTION_getInterfaceVersion) {
                data.enforceInterface(descriptor);
            }
            if (code == 1598968902) {
                reply.writeString(descriptor);
                return true;
            }
            if (code == TRANSACTION_getInterfaceVersion) {
                reply.writeNoException();
                reply.writeInt(getInterfaceVersion());
                return true;
            }
            if (code == TRANSACTION_getInterfaceHash) {
                reply.writeNoException();
                reply.writeString(getInterfaceHash());
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    int _result = getTemperature(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    int _result2 = getMaxTemperature();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 3:
                    ThermalSample[] _result3 = getAllTemperatures();
                    reply.writeNoException();
                    reply.writeTypedArray(_result3, 1);
                    return true;
                case 4:
                    IThermalCallback _arg02 = IThermalCallback.Stub.asInterface(data.readStrongBinder());
                    registerCallback(_arg02);
                    reply.writeNoException();
                    return true;
                case 5:
                    IThermalCallback _arg03 = IThermalCallback.Stub.asInterface(data.readStrongBinder());
                    unregisterCallback(_arg03);
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IThermalService {
            private IBinder mRemote;
            private int mCachedVersion = -1;
            private String mCachedHash = StepOSDateTimeUrlHelper.UNKNOW_EVENT;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override // vendor.stepos.hardware.thermal.IThermalService
            public int getTemperature(String sensorName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(sensorName);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status) {
                        throw new RemoteException("Method getTemperature is unimplemented.");
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // vendor.stepos.hardware.thermal.IThermalService
            public int getMaxTemperature() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status) {
                        throw new RemoteException("Method getMaxTemperature is unimplemented.");
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // vendor.stepos.hardware.thermal.IThermalService
            public ThermalSample[] getAllTemperatures() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status) {
                        throw new RemoteException("Method getAllTemperatures is unimplemented.");
                    }
                    _reply.readException();
                    ThermalSample[] _result = (ThermalSample[]) _reply.createTypedArray(ThermalSample.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // vendor.stepos.hardware.thermal.IThermalService
            public void registerCallback(IThermalCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status) {
                        throw new RemoteException("Method registerCallback is unimplemented.");
                    }
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // vendor.stepos.hardware.thermal.IThermalService
            public void unregisterCallback(IThermalCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status) {
                        throw new RemoteException("Method unregisterCallback is unimplemented.");
                    }
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // vendor.stepos.hardware.thermal.IThermalService
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion == -1) {
                    Parcel data = Parcel.obtain();
                    Parcel reply = Parcel.obtain();
                    try {
                        data.writeInterfaceToken(DESCRIPTOR);
                        this.mRemote.transact(Stub.TRANSACTION_getInterfaceVersion, data, reply, 0);
                        reply.readException();
                        this.mCachedVersion = reply.readInt();
                    } finally {
                        reply.recycle();
                        data.recycle();
                    }
                }
                return this.mCachedVersion;
            }

            @Override // vendor.stepos.hardware.thermal.IThermalService
            public synchronized String getInterfaceHash() throws RemoteException {
                if (StepOSDateTimeUrlHelper.UNKNOW_EVENT.equals(this.mCachedHash)) {
                    Parcel data = Parcel.obtain();
                    Parcel reply = Parcel.obtain();
                    try {
                        data.writeInterfaceToken(DESCRIPTOR);
                        this.mRemote.transact(Stub.TRANSACTION_getInterfaceHash, data, reply, 0);
                        reply.readException();
                        this.mCachedHash = reply.readString();
                        reply.recycle();
                        data.recycle();
                    } catch (Throwable th) {
                        reply.recycle();
                        data.recycle();
                        throw th;
                    }
                }
                return this.mCachedHash;
            }
        }
    }
}
