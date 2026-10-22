package com.stepos.statsrpk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes2.dex */
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
                    a.d(parcelObtain, rpkEvent, 0);
                    a.d(parcelObtain, rpkInfo, 0);
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
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IRpkStatsInterface.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IRpkStatsInterface.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            track((RpkEvent) a.c(parcel, RpkEvent.CREATOR), (RpkInfo) a.c(parcel, RpkInfo.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    public static class a {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void track(RpkEvent rpkEvent, RpkInfo rpkInfo) throws RemoteException;
}
