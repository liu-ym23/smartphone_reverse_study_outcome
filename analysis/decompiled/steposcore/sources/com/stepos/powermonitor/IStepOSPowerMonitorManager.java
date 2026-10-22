package com.stepos.powermonitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IStepOSPowerMonitorManager extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.powermonitor.IStepOSPowerMonitorManager";

    void clearDisplayMonitor(long j) throws RemoteException;

    List<StepOSAlarmInfo> getAlarmInfo() throws RemoteException;

    List<StepOSAppWakelockInfo> getAppWakelockInfo() throws RemoteException;

    List<StepOSAudioPlaybackInfo> getAudioPlaybackInfo() throws RemoteException;

    List<StepOSAudioRecorderInfo> getAudioRecorderInfo() throws RemoteException;

    StepOSDisplayMonitorInfo getDisplayMonitorInfo() throws RemoteException;

    List<StepOSGpsInfo> getGpsInfo() throws RemoteException;

    List<StepOSJobExecutionInfo> getJobExecutionInfo() throws RemoteException;

    List<StepOSKernelWakelockInfo> getKernelWakelockInfo() throws RemoteException;

    List<StepOSKernelWakeupInfo> getKernelWakeupReasonStats() throws RemoteException;

    List<StepOSRpmInfo> getRpmRadioInfo() throws RemoteException;

    List<StepOSTrafficInfo> getTrafficInfo() throws RemoteException;

    StepOSWifiInfo getWifiBatteryStats() throws RemoteException;

    void stopMonitor() throws RemoteException;

    public static class Default implements IStepOSPowerMonitorManager {
        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSAlarmInfo> getAlarmInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSAppWakelockInfo> getAppWakelockInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSGpsInfo> getGpsInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSRpmInfo> getRpmRadioInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSKernelWakelockInfo> getKernelWakelockInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSKernelWakeupInfo> getKernelWakeupReasonStats() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public StepOSWifiInfo getWifiBatteryStats() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSAudioPlaybackInfo> getAudioPlaybackInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSAudioRecorderInfo> getAudioRecorderInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSJobExecutionInfo> getJobExecutionInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public List<StepOSTrafficInfo> getTrafficInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public StepOSDisplayMonitorInfo getDisplayMonitorInfo() throws RemoteException {
            return null;
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public void clearDisplayMonitor(long consumedSnapshotWallMs) throws RemoteException {
        }

        @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
        public void stopMonitor() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IStepOSPowerMonitorManager {
        static final int TRANSACTION_clearDisplayMonitor = 13;
        static final int TRANSACTION_getAlarmInfo = 1;
        static final int TRANSACTION_getAppWakelockInfo = 2;
        static final int TRANSACTION_getAudioPlaybackInfo = 8;
        static final int TRANSACTION_getAudioRecorderInfo = 9;
        static final int TRANSACTION_getDisplayMonitorInfo = 12;
        static final int TRANSACTION_getGpsInfo = 3;
        static final int TRANSACTION_getJobExecutionInfo = 10;
        static final int TRANSACTION_getKernelWakelockInfo = 5;
        static final int TRANSACTION_getKernelWakeupReasonStats = 6;
        static final int TRANSACTION_getRpmRadioInfo = 4;
        static final int TRANSACTION_getTrafficInfo = 11;
        static final int TRANSACTION_getWifiBatteryStats = 7;
        static final int TRANSACTION_stopMonitor = 14;

        public Stub() {
            attachInterface(this, IStepOSPowerMonitorManager.DESCRIPTOR);
        }

        public static IStepOSPowerMonitorManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IStepOSPowerMonitorManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IStepOSPowerMonitorManager)) {
                return (IStepOSPowerMonitorManager) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "getAlarmInfo";
                case 2:
                    return "getAppWakelockInfo";
                case 3:
                    return "getGpsInfo";
                case 4:
                    return "getRpmRadioInfo";
                case 5:
                    return "getKernelWakelockInfo";
                case 6:
                    return "getKernelWakeupReasonStats";
                case 7:
                    return "getWifiBatteryStats";
                case 8:
                    return "getAudioPlaybackInfo";
                case 9:
                    return "getAudioRecorderInfo";
                case 10:
                    return "getJobExecutionInfo";
                case 11:
                    return "getTrafficInfo";
                case 12:
                    return "getDisplayMonitorInfo";
                case 13:
                    return "clearDisplayMonitor";
                case 14:
                    return "stopMonitor";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IStepOSPowerMonitorManager.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IStepOSPowerMonitorManager.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    List<StepOSAlarmInfo> _result = getAlarmInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result, 1);
                    return true;
                case 2:
                    List<StepOSAppWakelockInfo> _result2 = getAppWakelockInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result2, 1);
                    return true;
                case 3:
                    List<StepOSGpsInfo> _result3 = getGpsInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result3, 1);
                    return true;
                case 4:
                    List<StepOSRpmInfo> _result4 = getRpmRadioInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result4, 1);
                    return true;
                case 5:
                    List<StepOSKernelWakelockInfo> _result5 = getKernelWakelockInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result5, 1);
                    return true;
                case 6:
                    List<StepOSKernelWakeupInfo> _result6 = getKernelWakeupReasonStats();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result6, 1);
                    return true;
                case 7:
                    StepOSWifiInfo _result7 = getWifiBatteryStats();
                    reply.writeNoException();
                    reply.writeTypedObject(_result7, 1);
                    return true;
                case 8:
                    List<StepOSAudioPlaybackInfo> _result8 = getAudioPlaybackInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result8, 1);
                    return true;
                case 9:
                    List<StepOSAudioRecorderInfo> _result9 = getAudioRecorderInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result9, 1);
                    return true;
                case 10:
                    List<StepOSJobExecutionInfo> _result10 = getJobExecutionInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result10, 1);
                    return true;
                case 11:
                    List<StepOSTrafficInfo> _result11 = getTrafficInfo();
                    reply.writeNoException();
                    _Parcel.writeTypedList(reply, _result11, 1);
                    return true;
                case 12:
                    StepOSDisplayMonitorInfo _result12 = getDisplayMonitorInfo();
                    reply.writeNoException();
                    reply.writeTypedObject(_result12, 1);
                    return true;
                case 13:
                    long _arg0 = data.readLong();
                    clearDisplayMonitor(_arg0);
                    reply.writeNoException();
                    return true;
                case 14:
                    stopMonitor();
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IStepOSPowerMonitorManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSPowerMonitorManager.DESCRIPTOR;
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSAlarmInfo> getAlarmInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSAlarmInfo> _result = _reply.createTypedArrayList(StepOSAlarmInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSAppWakelockInfo> getAppWakelockInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSAppWakelockInfo> _result = _reply.createTypedArrayList(StepOSAppWakelockInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSGpsInfo> getGpsInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSGpsInfo> _result = _reply.createTypedArrayList(StepOSGpsInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSRpmInfo> getRpmRadioInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSRpmInfo> _result = _reply.createTypedArrayList(StepOSRpmInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSKernelWakelockInfo> getKernelWakelockInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSKernelWakelockInfo> _result = _reply.createTypedArrayList(StepOSKernelWakelockInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSKernelWakeupInfo> getKernelWakeupReasonStats() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSKernelWakeupInfo> _result = _reply.createTypedArrayList(StepOSKernelWakeupInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public StepOSWifiInfo getWifiBatteryStats() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    StepOSWifiInfo _result = (StepOSWifiInfo) _reply.readTypedObject(StepOSWifiInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSAudioPlaybackInfo> getAudioPlaybackInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSAudioPlaybackInfo> _result = _reply.createTypedArrayList(StepOSAudioPlaybackInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSAudioRecorderInfo> getAudioRecorderInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSAudioRecorderInfo> _result = _reply.createTypedArrayList(StepOSAudioRecorderInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSJobExecutionInfo> getJobExecutionInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSJobExecutionInfo> _result = _reply.createTypedArrayList(StepOSJobExecutionInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public List<StepOSTrafficInfo> getTrafficInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    List<StepOSTrafficInfo> _result = _reply.createTypedArrayList(StepOSTrafficInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public StepOSDisplayMonitorInfo getDisplayMonitorInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    StepOSDisplayMonitorInfo _result = (StepOSDisplayMonitorInfo) _reply.readTypedObject(StepOSDisplayMonitorInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public void clearDisplayMonitor(long consumedSnapshotWallMs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    _data.writeLong(consumedSnapshotWallMs);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.stepos.powermonitor.IStepOSPowerMonitorManager
            public void stopMonitor() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IStepOSPowerMonitorManager.DESCRIPTOR);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return 13;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> value, int parcelableFlags) {
            if (value == null) {
                parcel.writeInt(-1);
                return;
            }
            int N = value.size();
            parcel.writeInt(N);
            for (int i = 0; i < N; i++) {
                parcel.writeTypedObject(value.get(i), parcelableFlags);
            }
        }
    }
}
