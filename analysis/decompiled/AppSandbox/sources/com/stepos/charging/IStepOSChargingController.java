package com.stepos.charging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStepOSChargingController extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.charging.IStepOSChargingController";

    public static class Default implements IStepOSChargingController {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.charging.IStepOSChargingController
        public int getBatterySOH() throws RemoteException {
            return 0;
        }

        @Override // com.stepos.charging.IStepOSChargingController
        public String getWirelessTxModel() throws RemoteException {
            return null;
        }

        @Override // com.stepos.charging.IStepOSChargingController
        public boolean setBatteryUPSMode(int i) throws RemoteException {
            return false;
        }

        @Override // com.stepos.charging.IStepOSChargingController
        public boolean setReverseWirelessChargingMode(int i) throws RemoteException {
            return false;
        }

        @Override // com.stepos.charging.IStepOSChargingController
        public boolean setWiredChargingLevel(int i) throws RemoteException {
            return false;
        }

        @Override // com.stepos.charging.IStepOSChargingController
        public boolean setWirelessChargingLevel(int i) throws RemoteException {
            return false;
        }

        @Override // com.stepos.charging.IStepOSChargingController
        public boolean setWirelessTxFanMode(int i) throws RemoteException {
            return false;
        }
    }

    int getBatterySOH() throws RemoteException;

    String getWirelessTxModel() throws RemoteException;

    boolean setBatteryUPSMode(int i) throws RemoteException;

    boolean setReverseWirelessChargingMode(int i) throws RemoteException;

    boolean setWiredChargingLevel(int i) throws RemoteException;

    boolean setWirelessChargingLevel(int i) throws RemoteException;

    boolean setWirelessTxFanMode(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IStepOSChargingController {
        static final int TRANSACTION_getBatterySOH = 6;
        static final int TRANSACTION_getWirelessTxModel = 5;
        static final int TRANSACTION_setBatteryUPSMode = 7;
        static final int TRANSACTION_setReverseWirelessChargingMode = 4;
        static final int TRANSACTION_setWiredChargingLevel = 1;
        static final int TRANSACTION_setWirelessChargingLevel = 2;
        static final int TRANSACTION_setWirelessTxFanMode = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IStepOSChargingController.DESCRIPTOR);
        }

        public static IStepOSChargingController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IStepOSChargingController.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IStepOSChargingController)) {
                return (IStepOSChargingController) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IStepOSChargingController.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IStepOSChargingController.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    int i3 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    boolean wiredChargingLevel = setWiredChargingLevel(i3);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(wiredChargingLevel);
                    return true;
                case 2:
                    int i4 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    boolean wirelessChargingLevel = setWirelessChargingLevel(i4);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(wirelessChargingLevel);
                    return true;
                case 3:
                    int i5 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    boolean wirelessTxFanMode = setWirelessTxFanMode(i5);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(wirelessTxFanMode);
                    return true;
                case 4:
                    int i6 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    boolean reverseWirelessChargingMode = setReverseWirelessChargingMode(i6);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(reverseWirelessChargingMode);
                    return true;
                case 5:
                    String wirelessTxModel = getWirelessTxModel();
                    parcel2.writeNoException();
                    parcel2.writeString(wirelessTxModel);
                    return true;
                case 6:
                    int batterySOH = getBatterySOH();
                    parcel2.writeNoException();
                    parcel2.writeInt(batterySOH);
                    return true;
                case 7:
                    int i7 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    boolean batteryUPSMode = setBatteryUPSMode(i7);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(batteryUPSMode);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IStepOSChargingController {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IStepOSChargingController.DESCRIPTOR;
            }

            @Override // com.stepos.charging.IStepOSChargingController
            public boolean setWiredChargingLevel(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IStepOSChargingController.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.IStepOSChargingController
            public boolean setWirelessChargingLevel(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IStepOSChargingController.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.IStepOSChargingController
            public boolean setWirelessTxFanMode(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IStepOSChargingController.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.IStepOSChargingController
            public boolean setReverseWirelessChargingMode(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IStepOSChargingController.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.IStepOSChargingController
            public String getWirelessTxModel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IStepOSChargingController.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.IStepOSChargingController
            public int getBatterySOH() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IStepOSChargingController.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.IStepOSChargingController
            public boolean setBatteryUPSMode(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IStepOSChargingController.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
