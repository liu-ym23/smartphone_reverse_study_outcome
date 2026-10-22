package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICldReportBluetooth extends IInterface {
    public static final int CLD_ERRCODE_BLUETOOTH_BOND = 0;
    public static final int CLD_ERRCODE_BLUETOOTH_LINK = 1;
    public static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportBluetooth";

    public static class Default implements ICldReportBluetooth {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICldReportBluetooth {

        public static class Proxy implements ICldReportBluetooth {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICldReportBluetooth.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, ICldReportBluetooth.DESCRIPTOR);
        }

        public static ICldReportBluetooth asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICldReportBluetooth.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICldReportBluetooth) == false) goto L12;
            return (ICldReportBluetooth) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r2, Parcel r3, Parcel r4, int r5) throws RemoteException {
            if (r2 != 1598968902) goto L5;
            r4.writeString(ICldReportBluetooth.DESCRIPTOR);
            return true;
        L5:
            return super.onTransact(r2, r3, r4, r5);
        }
    }
}
