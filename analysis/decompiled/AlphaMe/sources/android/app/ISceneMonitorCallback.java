package android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISceneMonitorCallback extends IInterface {
    public static final String DESCRIPTOR = "android.app.ISceneMonitorCallback";

    public static class Default implements ISceneMonitorCallback {
        @Override // android.app.ISceneMonitorCallback
        public void addForegroundServiceRecord(int i4, int i5, String str, String str2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.ISceneMonitorCallback
        public void recordCellSignalStrengthBinChange(int i4) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void recordNetworkTraffic(int i4, long j4, long j5, long j6, long j7, long j8, long j9) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void recordScreenBrightness(int i4, int i5) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void recordWifiSignalStrengthBinChange(int i4) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void removeForegroundServiceRecord(int i4, int i5, String str) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void workingStateChange(int i4, int i5, String str, int i6, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISceneMonitorCallback {
        static final int TRANSACTION_addForegroundServiceRecord = 1;
        static final int TRANSACTION_recordCellSignalStrengthBinChange = 6;
        static final int TRANSACTION_recordNetworkTraffic = 4;
        static final int TRANSACTION_recordScreenBrightness = 5;
        static final int TRANSACTION_recordWifiSignalStrengthBinChange = 7;
        static final int TRANSACTION_removeForegroundServiceRecord = 2;
        static final int TRANSACTION_workingStateChange = 3;

        public static class Proxy implements ISceneMonitorCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.app.ISceneMonitorCallback
            public void addForegroundServiceRecord(int i4, int i5, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISceneMonitorCallback.DESCRIPTOR;
            }

            @Override // android.app.ISceneMonitorCallback
            public void recordCellSignalStrengthBinChange(int i4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i4);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void recordNetworkTraffic(int i4, long j4, long j5, long j6, long j7, long j8, long j9) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeLong(j4);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeLong(j7);
                    parcelObtain.writeLong(j8);
                    parcelObtain.writeLong(j9);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void recordScreenBrightness(int i4, int i5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void recordWifiSignalStrengthBinChange(int i4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i4);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void removeForegroundServiceRecord(int i4, int i5, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void workingStateChange(int i4, int i5, String str, int i6, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i6);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISceneMonitorCallback.DESCRIPTOR);
        }

        public static ISceneMonitorCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISceneMonitorCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISceneMonitorCallback)) ? new Proxy(iBinder) : (ISceneMonitorCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(ISceneMonitorCallback.DESCRIPTOR);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(ISceneMonitorCallback.DESCRIPTOR);
                return true;
            }
            switch (i4) {
                case 1:
                    addForegroundServiceRecord(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    removeForegroundServiceRecord(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    workingStateChange(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    recordNetworkTraffic(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    recordScreenBrightness(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    recordCellSignalStrengthBinChange(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    recordWifiSignalStrengthBinChange(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i4, parcel, parcel2, i5);
            }
        }
    }

    void addForegroundServiceRecord(int i4, int i5, String str, String str2) throws RemoteException;

    void recordCellSignalStrengthBinChange(int i4) throws RemoteException;

    void recordNetworkTraffic(int i4, long j4, long j5, long j6, long j7, long j8, long j9) throws RemoteException;

    void recordScreenBrightness(int i4, int i5) throws RemoteException;

    void recordWifiSignalStrengthBinChange(int i4) throws RemoteException;

    void removeForegroundServiceRecord(int i4, int i5, String str) throws RemoteException;

    void workingStateChange(int i4, int i5, String str, int i6, String str2) throws RemoteException;
}
