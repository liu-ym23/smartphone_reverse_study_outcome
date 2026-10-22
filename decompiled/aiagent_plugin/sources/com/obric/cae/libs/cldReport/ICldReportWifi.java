package com.obric.cae.libs.cldReport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public static class Default implements ICldReportWifi {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICldReportWifi {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportWifi";

        public static class Proxy implements ICldReportWifi {
            public static ICldReportWifi sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICldReportWifi asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICldReportWifi.class) == false) goto L13;
            return (ICldReportWifi) ZeusTransformUtils.preCheckCast(r0, ICldReportWifi.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICldReportWifi getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICldReportWifi r2) {
            ICldReportWifi r3 = (ICldReportWifi) ZeusTransformUtils.wrapperContextForParams(r2, ICldReportWifi.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r3 == null) goto L7;
            Proxy.sDefaultImpl = r3;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r2, Parcel r3, Parcel r4, int r5) {
            if (r2 != 1598968902) goto L5;
            r4.writeString(DESCRIPTOR);
            return true;
        L5:
            return super.onTransact(r2, r3, r4, r5);
        }
    }
}
