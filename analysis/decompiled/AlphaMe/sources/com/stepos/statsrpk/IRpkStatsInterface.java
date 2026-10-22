package com.stepos.statsrpk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IRpkStatsInterface extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.statsrpk.IRpkStatsInterface";

    public static class Default implements IRpkStatsInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.statsrpk.IRpkStatsInterface
        public void track(RpkEvent rpkEvent, RpkInfo rpkInfo) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRpkStatsInterface {
        static final int TRANSACTION_track = 1;

        public static class Proxy implements IRpkStatsInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IRpkStatsInterface.DESCRIPTOR;
            }

            @Override // com.stepos.statsrpk.IRpkStatsInterface
            public void track(RpkEvent rpkEvent, RpkInfo rpkInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRpkStatsInterface.DESCRIPTOR);
                    if (rpkEvent != null) {
                        parcelObtain.writeInt(1);
                        rpkEvent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (rpkInfo != null) {
                        parcelObtain.writeInt(1);
                        rpkInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IRpkStatsInterface.DESCRIPTOR);
        }

        public static IRpkStatsInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRpkStatsInterface.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRpkStatsInterface)) ? new Proxy(iBinder) : (IRpkStatsInterface) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(IRpkStatsInterface.DESCRIPTOR);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(IRpkStatsInterface.DESCRIPTOR);
                return true;
            }
            if (i4 != 1) {
                return super.onTransact(i4, parcel, parcel2, i5);
            }
            track(parcel.readInt() != 0 ? RpkEvent.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? RpkInfo.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void track(RpkEvent rpkEvent, RpkInfo rpkInfo) throws RemoteException;
}
