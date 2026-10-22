package com.stepos.pps;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPPSClientService extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.pps.IPPSClientService";

    public static class Default implements IPPSClientService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.pps.IPPSClientService
        public void onProcessLifecycle(int i, int i2, int i3, String str, long j, long j2) throws RemoteException {
        }
    }

    void onProcessLifecycle(int i, int i2, int i3, String str, long j, long j2) throws RemoteException;

    public static abstract class Stub extends Binder implements IPPSClientService {
        static final int TRANSACTION_onProcessLifecycle = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IPPSClientService.DESCRIPTOR);
        }

        public static IPPSClientService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPPSClientService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IPPSClientService)) {
                return (IPPSClientService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPPSClientService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IPPSClientService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                int i3 = parcel.readInt();
                int i4 = parcel.readInt();
                int i5 = parcel.readInt();
                String string = parcel.readString();
                long j = parcel.readLong();
                long j2 = parcel.readLong();
                parcel.enforceNoDataAvail();
                onProcessLifecycle(i3, i4, i5, string, j, j2);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IPPSClientService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPPSClientService.DESCRIPTOR;
            }

            @Override // com.stepos.pps.IPPSClientService
            public void onProcessLifecycle(int i, int i2, int i3, String str, long j, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain(asBinder());
                try {
                    parcelObtain.writeInterfaceToken(IPPSClientService.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
