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
        public void addForegroundServiceRecord(int i, int i2, String str, String str2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.app.ISceneMonitorCallback
        public void recordCellSignalStrengthBinChange(int i) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void recordNetworkTraffic(int i, long j, long j2, long j3, long j4, long j5, long j6) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void recordScreenBrightness(int i, int i2) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void recordWifiSignalStrengthBinChange(int i) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void removeForegroundServiceRecord(int i, int i2, String str) throws RemoteException {
        }

        @Override // android.app.ISceneMonitorCallback
        public void workingStateChange(int i, int i2, String str, int i3, String str2) throws RemoteException {
        }
    }

    void addForegroundServiceRecord(int i, int i2, String str, String str2) throws RemoteException;

    void recordCellSignalStrengthBinChange(int i) throws RemoteException;

    void recordNetworkTraffic(int i, long j, long j2, long j3, long j4, long j5, long j6) throws RemoteException;

    void recordScreenBrightness(int i, int i2) throws RemoteException;

    void recordWifiSignalStrengthBinChange(int i) throws RemoteException;

    void removeForegroundServiceRecord(int i, int i2, String str) throws RemoteException;

    void workingStateChange(int i, int i2, String str, int i3, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements ISceneMonitorCallback {
        static final int TRANSACTION_addForegroundServiceRecord = 1;
        static final int TRANSACTION_recordCellSignalStrengthBinChange = 6;
        static final int TRANSACTION_recordNetworkTraffic = 4;
        static final int TRANSACTION_recordScreenBrightness = 5;
        static final int TRANSACTION_recordWifiSignalStrengthBinChange = 7;
        static final int TRANSACTION_removeForegroundServiceRecord = 2;
        static final int TRANSACTION_workingStateChange = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISceneMonitorCallback.DESCRIPTOR);
        }

        public static ISceneMonitorCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISceneMonitorCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISceneMonitorCallback)) {
                return (ISceneMonitorCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Parcel parcel3;
            if (i < 1 || i > 16777215) {
                parcel3 = parcel;
            } else {
                parcel3 = parcel;
                parcel3.enforceInterface(ISceneMonitorCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISceneMonitorCallback.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    int i3 = parcel.readInt();
                    int i4 = parcel.readInt();
                    String string = parcel.readString();
                    String string2 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    addForegroundServiceRecord(i3, i4, string, string2);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    int i5 = parcel.readInt();
                    int i6 = parcel.readInt();
                    String string3 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    removeForegroundServiceRecord(i5, i6, string3);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int i7 = parcel.readInt();
                    int i8 = parcel.readInt();
                    String string4 = parcel.readString();
                    int i9 = parcel.readInt();
                    String string5 = parcel.readString();
                    parcel.enforceNoDataAvail();
                    workingStateChange(i7, i8, string4, i9, string5);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int i10 = parcel3.readInt();
                    long j = parcel.readLong();
                    long j2 = parcel.readLong();
                    long j3 = parcel.readLong();
                    long j4 = parcel.readLong();
                    long j5 = parcel.readLong();
                    long j6 = parcel.readLong();
                    parcel.enforceNoDataAvail();
                    recordNetworkTraffic(i10, j, j2, j3, j4, j5, j6);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    int i11 = parcel3.readInt();
                    int i12 = parcel3.readInt();
                    parcel3.enforceNoDataAvail();
                    recordScreenBrightness(i11, i12);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    int i13 = parcel3.readInt();
                    parcel3.enforceNoDataAvail();
                    recordCellSignalStrengthBinChange(i13);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    int i14 = parcel3.readInt();
                    parcel3.enforceNoDataAvail();
                    recordWifiSignalStrengthBinChange(i14);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ISceneMonitorCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISceneMonitorCallback.DESCRIPTOR;
            }

            @Override // android.app.ISceneMonitorCallback
            public void addForegroundServiceRecord(int i, int i2, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void removeForegroundServiceRecord(int i, int i2, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void workingStateChange(int i, int i2, String str, int i3, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void recordNetworkTraffic(int i, long j, long j2, long j3, long j4, long j5, long j6) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeLong(j4);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void recordScreenBrightness(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void recordCellSignalStrengthBinChange(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.app.ISceneMonitorCallback
            public void recordWifiSignalStrengthBinChange(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISceneMonitorCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
