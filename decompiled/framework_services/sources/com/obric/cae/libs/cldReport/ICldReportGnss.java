package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICldReportGnss extends IInterface {
    public static final int CLD_ERRCODE_GNSS_EVENT_NFW_POWER = 4;
    public static final int CLD_ERRCODE_GNSS_FEEDBACK = 1;
    public static final int CLD_ERRCODE_GNSS_MAGIC_NUMBER_BUGREPORT = 2;
    public static final int CLD_ERRCODE_GNSS_MAGIC_NUMBER_MODEM = 3;
    public static final int CLD_ERRCODE_LOCATION_AOI_BOARD_BREACH = 6;
    public static final int CLD_ERRCODE_SENSOR_FLIGHT_MODE = 5;
    public static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportGnss";

    public static class Default implements ICldReportGnss {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICldReportGnss {

        public static class Proxy implements ICldReportGnss {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICldReportGnss.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, ICldReportGnss.DESCRIPTOR);
        }

        public static ICldReportGnss asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICldReportGnss.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICldReportGnss) == false) goto L12;
            return (ICldReportGnss) r0;
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
            r4.writeString(ICldReportGnss.DESCRIPTOR);
            return true;
        L5:
            return super.onTransact(r2, r3, r4, r5);
        }
    }
}
