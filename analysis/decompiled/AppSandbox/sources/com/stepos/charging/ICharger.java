package com.stepos.charging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICharger extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.charging.ICharger";

    public static class Default implements ICharger {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.charging.ICharger
        public int getBatterySOH() throws RemoteException {
            return 0;
        }

        @Override // com.stepos.charging.ICharger
        public String getWirelessTxModel() throws RemoteException {
            return null;
        }

        @Override // com.stepos.charging.ICharger
        public boolean setBatteryUPSModeEnable(boolean z) throws RemoteException {
            return false;
        }

        @Override // com.stepos.charging.ICharger
        public boolean setReverseWirelessChargingEnable(boolean z) throws RemoteException {
            return false;
        }

        @Override // com.stepos.charging.ICharger
        public boolean setWirelessTxFanQuiet(boolean z) throws RemoteException {
            return false;
        }

        @Override // com.stepos.charging.ICharger
        public void voteWiredChargingLevel(String str, int i) throws RemoteException {
        }

        @Override // com.stepos.charging.ICharger
        public void voteWirelessChargingLevel(String str, int i) throws RemoteException {
        }
    }

    int getBatterySOH() throws RemoteException;

    String getWirelessTxModel() throws RemoteException;

    boolean setBatteryUPSModeEnable(boolean z) throws RemoteException;

    boolean setReverseWirelessChargingEnable(boolean z) throws RemoteException;

    boolean setWirelessTxFanQuiet(boolean z) throws RemoteException;

    void voteWiredChargingLevel(String str, int i) throws RemoteException;

    void voteWirelessChargingLevel(String str, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ICharger {
        static final int TRANSACTION_getBatterySOH = 6;
        static final int TRANSACTION_getWirelessTxModel = 5;
        static final int TRANSACTION_setBatteryUPSModeEnable = 7;
        static final int TRANSACTION_setReverseWirelessChargingEnable = 4;
        static final int TRANSACTION_setWirelessTxFanQuiet = 3;
        static final int TRANSACTION_voteWiredChargingLevel = 1;
        static final int TRANSACTION_voteWirelessChargingLevel = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ICharger.DESCRIPTOR);
        }

        public static ICharger asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICharger.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ICharger)) {
                return (ICharger) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ICharger.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ICharger.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    String string = parcel.readString();
                    int i3 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    voteWiredChargingLevel(string, i3);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    String string2 = parcel.readString();
                    int i4 = parcel.readInt();
                    parcel.enforceNoDataAvail();
                    voteWirelessChargingLevel(string2, i4);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    boolean z = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    boolean wirelessTxFanQuiet = setWirelessTxFanQuiet(z);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(wirelessTxFanQuiet);
                    return true;
                case 4:
                    boolean z2 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    boolean reverseWirelessChargingEnable = setReverseWirelessChargingEnable(z2);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(reverseWirelessChargingEnable);
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
                    boolean z3 = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    boolean batteryUPSModeEnable = setBatteryUPSModeEnable(z3);
                    parcel2.writeNoException();
                    parcel2.writeBoolean(batteryUPSModeEnable);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICharger {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICharger.DESCRIPTOR;
            }

            @Override // com.stepos.charging.ICharger
            public void voteWiredChargingLevel(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICharger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.ICharger
            public void voteWirelessChargingLevel(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICharger.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.ICharger
            public boolean setWirelessTxFanQuiet(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICharger.DESCRIPTOR);
                    parcelObtain.writeBoolean(z);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.ICharger
            public boolean setReverseWirelessChargingEnable(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICharger.DESCRIPTOR);
                    parcelObtain.writeBoolean(z);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readBoolean();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.ICharger
            public String getWirelessTxModel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICharger.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.ICharger
            public int getBatterySOH() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICharger.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.charging.ICharger
            public boolean setBatteryUPSModeEnable(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICharger.DESCRIPTOR);
                    parcelObtain.writeBoolean(z);
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
