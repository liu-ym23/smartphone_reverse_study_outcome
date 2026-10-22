package android.hardware.health;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IHealth extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "c8d014c7bb950af538396f3e5a409c69b7b9335c";
    public static final int STATUS_CALLBACK_DIED = 4;
    public static final int STATUS_UNKNOWN = 2;
    public static final int VERSION = 4;

    public static class Default implements IHealth {
        public Default() {
        }

        @Override // android.hardware.health.IHealth
        public void registerCallback(IHealthInfoCallback callback) throws RemoteException {
        }

        @Override // android.hardware.health.IHealth
        public void unregisterCallback(IHealthInfoCallback callback) throws RemoteException {
        }

        @Override // android.hardware.health.IHealth
        public void update() throws RemoteException {
        }

        @Override // android.hardware.health.IHealth
        public int getChargeCounterUah() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.health.IHealth
        public int getCurrentNowMicroamps() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.health.IHealth
        public int getCurrentAverageMicroamps() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.health.IHealth
        public int getCapacity() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.health.IHealth
        public long getEnergyCounterNwh() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.health.IHealth
        public int getChargeStatus() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.health.IHealth
        public StorageInfo[] getStorageInfo() throws RemoteException {
            return null;
        }

        @Override // android.hardware.health.IHealth
        public DiskStats[] getDiskStats() throws RemoteException {
            return null;
        }

        @Override // android.hardware.health.IHealth
        public HealthInfo getHealthInfo() throws RemoteException {
            return null;
        }

        @Override // android.hardware.health.IHealth
        public void setChargingPolicy(int in_value) throws RemoteException {
        }

        @Override // android.hardware.health.IHealth
        public int getChargingPolicy() throws RemoteException {
            return 0;
        }

        @Override // android.hardware.health.IHealth
        public BatteryHealthData getBatteryHealthData() throws RemoteException {
            return null;
        }

        @Override // android.hardware.health.IHealth
        public HingeInfo[] getHingeInfo() throws RemoteException {
            return null;
        }

        @Override // android.hardware.health.IHealth
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.health.IHealth
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IHealth {
        static final int TRANSACTION_getBatteryHealthData = 15;
        static final int TRANSACTION_getCapacity = 7;
        static final int TRANSACTION_getChargeCounterUah = 4;
        static final int TRANSACTION_getChargeStatus = 9;
        static final int TRANSACTION_getChargingPolicy = 14;
        static final int TRANSACTION_getCurrentAverageMicroamps = 6;
        static final int TRANSACTION_getCurrentNowMicroamps = 5;
        static final int TRANSACTION_getDiskStats = 11;
        static final int TRANSACTION_getEnergyCounterNwh = 8;
        static final int TRANSACTION_getHealthInfo = 12;
        static final int TRANSACTION_getHingeInfo = 16;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getStorageInfo = 10;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_setChargingPolicy = 13;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_update = 3;

        private static class Proxy implements IHealth {
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
                return IHealth.DESCRIPTOR;
            }

            @Override // android.hardware.health.IHealth
            public void registerCallback(IHealthInfoCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method registerCallback is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public void unregisterCallback(IHealthInfoCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeStrongInterface(callback);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method unregisterCallback is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public void update() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method update is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public int getChargeCounterUah() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getChargeCounterUah is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public int getCurrentNowMicroamps() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getCurrentNowMicroamps is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public int getCurrentAverageMicroamps() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getCurrentAverageMicroamps is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public int getCapacity() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(7, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getCapacity is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public long getEnergyCounterNwh() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(8, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                long _result = _reply.readLong();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getEnergyCounterNwh is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public int getChargeStatus() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(9, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getChargeStatus is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public StorageInfo[] getStorageInfo() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(10, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                StorageInfo[] _result = (StorageInfo[]) _reply.createTypedArray(StorageInfo.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getStorageInfo is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public DiskStats[] getDiskStats() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(11, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                DiskStats[] _result = (DiskStats[]) _reply.createTypedArray(DiskStats.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getDiskStats is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public HealthInfo getHealthInfo() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(12, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                HealthInfo _result = (HealthInfo) _reply.readTypedObject(HealthInfo.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getHealthInfo is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public void setChargingPolicy(int in_value) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeInt(in_value);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(13, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return;
            L11:
                throw new RemoteException("Method setChargingPolicy is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public int getChargingPolicy() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(14, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                int _result = _reply.readInt();     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getChargingPolicy is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public BatteryHealthData getBatteryHealthData() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(15, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                BatteryHealthData _result = (BatteryHealthData) _reply.readTypedObject(BatteryHealthData.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getBatteryHealthData is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public HingeInfo[] getHingeInfo() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(16, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                HingeInfo[] _result = (HingeInfo[]) _reply.createTypedArray(HingeInfo.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getHingeInfo is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.health.IHealth
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.health.IHealth
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IHealth.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IHealth.DESCRIPTOR);
        }

        public static IHealth asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IHealth.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IHealth) == false) goto L12;
            return (IHealth) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IHealth.DESCRIPTOR;
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
                case 1: goto L35;
                case 2: goto L34;
                case 3: goto L33;
                case 4: goto L32;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L28;
                case 9: goto L27;
                case 10: goto L26;
                case 11: goto L25;
                case 12: goto L24;
                case 13: goto L23;
                case 14: goto L22;
                case 15: goto L21;
                case 16: goto L20;
                default: goto L19;
            };
        L20:
            HingeInfo[] _result = getHingeInfo();
            reply.writeNoException();
            reply.writeTypedArray(_result, 1);
        L36:
            return true;
        L21:
            BatteryHealthData _result2 = getBatteryHealthData();
            reply.writeNoException();
            reply.writeTypedObject(_result2, 1);
            goto L36
        L22:
            int _result3 = getChargingPolicy();
            reply.writeNoException();
            reply.writeInt(_result3);
            goto L36
        L23:
            int _arg0 = data.readInt();
            data.enforceNoDataAvail();
            setChargingPolicy(_arg0);
            reply.writeNoException();
            goto L36
        L24:
            HealthInfo _result4 = getHealthInfo();
            reply.writeNoException();
            reply.writeTypedObject(_result4, 1);
            goto L36
        L25:
            DiskStats[] _result5 = getDiskStats();
            reply.writeNoException();
            reply.writeTypedArray(_result5, 1);
            goto L36
        L26:
            StorageInfo[] _result6 = getStorageInfo();
            reply.writeNoException();
            reply.writeTypedArray(_result6, 1);
            goto L36
        L27:
            int _result7 = getChargeStatus();
            reply.writeNoException();
            reply.writeInt(_result7);
            goto L36
        L28:
            long _result8 = getEnergyCounterNwh();
            reply.writeNoException();
            reply.writeLong(_result8);
            goto L36
        L29:
            int _result9 = getCapacity();
            reply.writeNoException();
            reply.writeInt(_result9);
            goto L36
        L30:
            int _result10 = getCurrentAverageMicroamps();
            reply.writeNoException();
            reply.writeInt(_result10);
            goto L36
        L31:
            int _result11 = getCurrentNowMicroamps();
            reply.writeNoException();
            reply.writeInt(_result11);
            goto L36
        L32:
            int _result12 = getChargeCounterUah();
            reply.writeNoException();
            reply.writeInt(_result12);
            goto L36
        L33:
            update();
            reply.writeNoException();
            goto L36
        L34:
            IHealthInfoCallback _arg1 = IHealthInfoCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            unregisterCallback(_arg1);
            reply.writeNoException();
            goto L36
        L35:
            IHealthInfoCallback _arg2 = IHealthInfoCallback.Stub.asInterface(data.readStrongBinder());
            data.enforceNoDataAvail();
            registerCallback(_arg2);
            reply.writeNoException();
            goto L36
        L19:
            return super.onTransact(code, data, reply, flags);
        }
    }

    BatteryHealthData getBatteryHealthData() throws RemoteException;

    int getCapacity() throws RemoteException;

    int getChargeCounterUah() throws RemoteException;

    int getChargeStatus() throws RemoteException;

    int getChargingPolicy() throws RemoteException;

    int getCurrentAverageMicroamps() throws RemoteException;

    int getCurrentNowMicroamps() throws RemoteException;

    DiskStats[] getDiskStats() throws RemoteException;

    long getEnergyCounterNwh() throws RemoteException;

    HealthInfo getHealthInfo() throws RemoteException;

    HingeInfo[] getHingeInfo() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    StorageInfo[] getStorageInfo() throws RemoteException;

    void registerCallback(IHealthInfoCallback r1) throws RemoteException;

    void setChargingPolicy(int r1) throws RemoteException;

    void unregisterCallback(IHealthInfoCallback r1) throws RemoteException;

    void update() throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$health$IHealth".replace('$', '.');
    }
}
