package android.hardware.power.stats;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IPowerStats extends IInterface {
    public static final String DESCRIPTOR = null;
    public static final String HASH = "c3e113101b731c666717eb579492efa287a8f529";
    public static final int VERSION = 2;

    public static class Default implements IPowerStats {
        public Default() {
        }

        @Override // android.hardware.power.stats.IPowerStats
        public PowerEntity[] getPowerEntityInfo() throws RemoteException {
            return null;
        }

        @Override // android.hardware.power.stats.IPowerStats
        public StateResidencyResult[] getStateResidency(int[] powerEntityIds) throws RemoteException {
            return null;
        }

        @Override // android.hardware.power.stats.IPowerStats
        public EnergyConsumer[] getEnergyConsumerInfo() throws RemoteException {
            return null;
        }

        @Override // android.hardware.power.stats.IPowerStats
        public EnergyConsumerResult[] getEnergyConsumed(int[] energyConsumerIds) throws RemoteException {
            return null;
        }

        @Override // android.hardware.power.stats.IPowerStats
        public Channel[] getEnergyMeterInfo() throws RemoteException {
            return null;
        }

        @Override // android.hardware.power.stats.IPowerStats
        public EnergyMeasurement[] readEnergyMeter(int[] channelIds) throws RemoteException {
            return null;
        }

        @Override // android.hardware.power.stats.IPowerStats
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.hardware.power.stats.IPowerStats
        public String getInterfaceHash() {
            return "";
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IPowerStats {
        static final int TRANSACTION_getEnergyConsumed = 4;
        static final int TRANSACTION_getEnergyConsumerInfo = 3;
        static final int TRANSACTION_getEnergyMeterInfo = 5;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getPowerEntityInfo = 1;
        static final int TRANSACTION_getStateResidency = 2;
        static final int TRANSACTION_readEnergyMeter = 6;

        private static class Proxy implements IPowerStats {
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
                return IPowerStats.DESCRIPTOR;
            }

            @Override // android.hardware.power.stats.IPowerStats
            public PowerEntity[] getPowerEntityInfo() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IPowerStats.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(1, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                PowerEntity[] _result = (PowerEntity[]) _reply.createTypedArray(PowerEntity.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getPowerEntityInfo is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.power.stats.IPowerStats
            public StateResidencyResult[] getStateResidency(int[] powerEntityIds) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IPowerStats.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeIntArray(powerEntityIds);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(2, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                StateResidencyResult[] _result = (StateResidencyResult[]) _reply.createTypedArray(StateResidencyResult.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getStateResidency is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.power.stats.IPowerStats
            public EnergyConsumer[] getEnergyConsumerInfo() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IPowerStats.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(3, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                EnergyConsumer[] _result = (EnergyConsumer[]) _reply.createTypedArray(EnergyConsumer.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getEnergyConsumerInfo is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.power.stats.IPowerStats
            public EnergyConsumerResult[] getEnergyConsumed(int[] energyConsumerIds) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IPowerStats.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeIntArray(energyConsumerIds);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(4, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                EnergyConsumerResult[] _result = (EnergyConsumerResult[]) _reply.createTypedArray(EnergyConsumerResult.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getEnergyConsumed is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.power.stats.IPowerStats
            public Channel[] getEnergyMeterInfo() throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IPowerStats.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(5, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                Channel[] _result = (Channel[]) _reply.createTypedArray(Channel.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method getEnergyMeterInfo is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.power.stats.IPowerStats
            public EnergyMeasurement[] readEnergyMeter(int[] channelIds) throws RemoteException {
                Parcel _data = Parcel.obtain(asBinder());
                Parcel _reply = Parcel.obtain();
                _data.writeInterfaceToken(IPowerStats.DESCRIPTOR);     // Catch: Throwable -> L8
                _data.writeIntArray(channelIds);     // Catch: Throwable -> L8
                boolean _status = this.mRemote.transact(6, _data, _reply, 0);     // Catch: Throwable -> L8
                if (_status == false) goto L11;
                _reply.readException();     // Catch: Throwable -> L8
                EnergyMeasurement[] _result = (EnergyMeasurement[]) _reply.createTypedArray(EnergyMeasurement.CREATOR);     // Catch: Throwable -> L8
                _reply.recycle();
                _data.recycle();
                return _result;
            L11:
                throw new RemoteException("Method readEnergyMeter is unimplemented.");     // Catch: Throwable -> L8
            L8:
                th = move-exception;
                _reply.recycle();
                _data.recycle();
                throw th;
            }

            @Override // android.hardware.power.stats.IPowerStats
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion != (-1)) goto L11;
                Parcel data = Parcel.obtain(asBinder());
                Parcel reply = Parcel.obtain();
                data.writeInterfaceToken(IPowerStats.DESCRIPTOR);     // Catch: Throwable -> L7
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

            @Override // android.hardware.power.stats.IPowerStats
            public synchronized String getInterfaceHash() throws RemoteException {
                monitor-enter(this);
            L8:
                th = move-exception;
                throw th;
            L4:
                if ("-1".equals(this.mCachedHash) == false) goto L13;
                Parcel data = Parcel.obtain(asBinder());     // Catch: Throwable -> L8
                Parcel reply = Parcel.obtain();     // Catch: Throwable -> L8
                data.writeInterfaceToken(IPowerStats.DESCRIPTOR);     // Catch: Throwable -> L10
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
            attachInterface(this, IPowerStats.DESCRIPTOR);
        }

        public static IPowerStats asInterface(IBinder obj) {
            if (obj != null) goto L5;
            return null;
        L5:
            IInterface iin = obj.queryLocalInterface(IPowerStats.DESCRIPTOR);
            if (iin == null) goto L12;
            if ((iin instanceof IPowerStats) == false) goto L12;
            return (IPowerStats) iin;
        L12:
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch(transactionCode) {
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 16777214: goto L7;
                case 16777215: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "getInterfaceVersion";
        L7:
            return "getInterfaceHash";
        L9:
            return "readEnergyMeter";
        L11:
            return "getEnergyMeterInfo";
        L13:
            return "getEnergyConsumed";
        L15:
            return "getEnergyConsumerInfo";
        L17:
            return "getStateResidency";
        L19:
            return "getPowerEntityInfo";
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = IPowerStats.DESCRIPTOR;
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
            int[] _arg0 = data.createIntArray();
            data.enforceNoDataAvail();
            EnergyMeasurement[] _result = readEnergyMeter(_arg0);
            reply.writeNoException();
            reply.writeTypedArray(_result, 1);
        L26:
            return true;
        L21:
            Channel[] _result2 = getEnergyMeterInfo();
            reply.writeNoException();
            reply.writeTypedArray(_result2, 1);
            goto L26
        L22:
            int[] _arg1 = data.createIntArray();
            data.enforceNoDataAvail();
            EnergyConsumerResult[] _result3 = getEnergyConsumed(_arg1);
            reply.writeNoException();
            reply.writeTypedArray(_result3, 1);
            goto L26
        L23:
            EnergyConsumer[] _result4 = getEnergyConsumerInfo();
            reply.writeNoException();
            reply.writeTypedArray(_result4, 1);
            goto L26
        L24:
            int[] _arg2 = data.createIntArray();
            data.enforceNoDataAvail();
            StateResidencyResult[] _result5 = getStateResidency(_arg2);
            reply.writeNoException();
            reply.writeTypedArray(_result5, 1);
            goto L26
        L25:
            PowerEntity[] _result6 = getPowerEntityInfo();
            reply.writeNoException();
            reply.writeTypedArray(_result6, 1);
            goto L26
        L19:
            return super.onTransact(code, data, reply, flags);
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getInterfaceHash;
        }
    }

    EnergyConsumerResult[] getEnergyConsumed(int[] r1) throws RemoteException;

    EnergyConsumer[] getEnergyConsumerInfo() throws RemoteException;

    Channel[] getEnergyMeterInfo() throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    PowerEntity[] getPowerEntityInfo() throws RemoteException;

    StateResidencyResult[] getStateResidency(int[] r1) throws RemoteException;

    EnergyMeasurement[] readEnergyMeter(int[] r1) throws RemoteException;

    static {
        DESCRIPTOR = "android$hardware$power$stats$IPowerStats".replace('$', '.');
    }
}
