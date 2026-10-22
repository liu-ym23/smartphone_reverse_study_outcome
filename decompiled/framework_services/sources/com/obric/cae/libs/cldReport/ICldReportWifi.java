package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface ICldReportWifi extends IInterface {
    public static final int CLD_ERRCODE_WIFI_CONNECT_FAIL = 3;
    public static final int CLD_ERRCODE_WIFI_CONNECT_SLOW = 4;
    public static final int CLD_ERRCODE_WIFI_DISCONNECT = 5;
    public static final int CLD_ERRCODE_WIFI_FEEDBACK = 0;
    public static final int CLD_ERRCODE_WIFI_NOT_AUTO_CONNECT = 8;
    public static final int CLD_ERRCODE_WIFI_OPEN_FAIL = 1;
    public static final int CLD_ERRCODE_WIFI_OPEN_SLOW = 2;
    public static final int CLD_ERRCODE_WIFI_ROAM_FAIL = 7;
    public static final int CLD_ERRCODE_WIFI_WLAN_CRASH = 6;
    public static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportWifi";

    public static class Default implements ICldReportWifi {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICldReportWifi {

        public static class Proxy implements ICldReportWifi {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICldReportWifi.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, ICldReportWifi.DESCRIPTOR);
        }

        public static ICldReportWifi asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICldReportWifi.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICldReportWifi) == false) goto L12;
            return (ICldReportWifi) r0;
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
            r4.writeString(ICldReportWifi.DESCRIPTOR);
            return true;
        L5:
            return super.onTransact(r2, r3, r4, r5);
        }
    }
}
