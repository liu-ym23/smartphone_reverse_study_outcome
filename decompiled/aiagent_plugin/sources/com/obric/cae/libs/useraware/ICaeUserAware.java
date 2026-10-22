package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeUserAware extends IInterface {
    public static final int ENTER_COMPANY_GEOFENCE_EVENT = 3;
    public static final int ENTER_HOME_GEOFENCE_EVENT = 1;
    public static final int EXIT_COMPANY_GEOFENCE_EVENT = 4;
    public static final int EXIT_HOEM_GEOFENCE_EVENT = 2;
    public static final int LEVEL1_MODEL_RESULT = 1;
    public static final int LEVEL2_MODEL_RESULT = 2;
    public static final int MASK_SCAN_AUDIO = 16;
    public static final int MASK_SCAN_BT = 2;
    public static final int MASK_SCAN_CELL = 4;
    public static final int MASK_SCAN_LOCATION = 8;
    public static final int MASK_SCAN_WIFI = 1;
    public static final int MASK_SENSOR_ACCELEROMETER = 32;
    public static final int MASK_SENSOR_GYROSCOPE = 128;
    public static final int MASK_SENSOR_LIGHT = 1024;
    public static final int MASK_SENSOR_LINEAR_ACCELERATION = 64;
    public static final int MASK_SENSOR_MAGNETIC_FIELD = 256;
    public static final int MASK_SENSOR_ORIENTATION = 8192;
    public static final int MASK_SENSOR_OUT_ELEVATOR = 4096;
    public static final int MASK_SENSOR_PRESSURE = 2048;
    public static final int MASK_SENSOR_PROXIMITY = 16384;
    public static final int MASK_SENSOR_ROTATION_MATRIX = 32768;
    public static final int MASK_SENSOR_STEP_COUNTER = 512;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;
    public static final String USER_AWARE_REPORT_HAR_FEEDBACK_INFO = "useraware_HAR_feedback_info";
    public static final String USER_AWARE_REPORT_HAR_STATE_INFO = "useraware_HAR_state_info";
    public static final String USER_AWARE_REPORT_NEAR_ELEVATOR_INFO = "useraware_near_elevator_info";
    public static final String USER_AWARE_REPORT_STAR_GEOFENCE_INFO = "useraware_star_geofence_info";
    public static final String USER_AWARE_REPORT_STAR_ZPP_INFO = "useraware_star_zpp_info";
    public static final String USER_AWARE_REPORT_USER_FEEDBACK_INFO = "useraware_user_feedback_info";
    public static final String USER_AWARE_REPORT_WIFI_CONNECT_INFO = "useraware_wifi_conn_info";
    public static final String USER_AWARE_REPORT_WIFI_PNO_STATS = "useraware_wifi_pno_stats";
    public static final String USER_AWARE_REPORT_WIFI_SCAN_COUNT = "useraware_wifi_scan_count";
    public static final String USER_AWARE_REPORT_WIFI_SCAN_INFO = "useraware_wifi_scan_info";

    public static class Default implements ICaeUserAware {
        public Default() {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addBssidsToAvoidRomingScan(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addHomeWifiBssids(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void clearHomeWifiBssids() {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public HarMonitorParams getHarMonitorParams() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyGeofenceChanged(int r1) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyHarEvent(HarEventData r1) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyLearningSuccess(boolean r1) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyRoomChangedPredicted(int r1) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerCallback(ICaeUserAwareCallback r2) {
            ICaeUserAwareCallback r1 = (ICaeUserAwareCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICaeUserAwareCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r2) {
            ISmartBluetoothEventCallback r1 = (ISmartBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r2, ISmartBluetoothEventCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarMonitorParams(HarMonitorParams r1) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarState(int r1, long r2, int r4) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setLevel2DataCollection(List<HarLevel2DataReq> r1, int r2, HarLevel2DataResp r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.aiagent.plugin");
            HarLevel2DataResp r4 = (HarLevel2DataResp) ZeusTransformUtils.wrapperContextForParams(r3, HarLevel2DataResp.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setWifiRssiTriggerThresholds(int r1, int r2, int r3, int r4, int r5) {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterCallback(ICaeUserAwareCallback r2) {
            ICaeUserAwareCallback r1 = (ICaeUserAwareCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICaeUserAwareCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r2) {
            ISmartBluetoothEventCallback r1 = (ISmartBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r2, ISmartBluetoothEventCallback.class, "com.obric.aiagent.plugin");
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAware {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAware";
        static final int TRANSACTION_addBssidsToAvoidRomingScan = 7;
        static final int TRANSACTION_addHomeWifiBssids = 3;
        static final int TRANSACTION_clearHomeWifiBssids = 4;
        static final int TRANSACTION_getHarMonitorParams = 13;
        static final int TRANSACTION_notifyGeofenceChanged = 6;
        static final int TRANSACTION_notifyHarEvent = 14;
        static final int TRANSACTION_notifyLearningSuccess = 16;
        static final int TRANSACTION_notifyRoomChangedPredicted = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerSmartBluetoothEvent = 10;
        static final int TRANSACTION_setHarMonitorParams = 12;
        static final int TRANSACTION_setHarState = 8;
        static final int TRANSACTION_setLevel2DataCollection = 9;
        static final int TRANSACTION_setWifiRssiTriggerThresholds = 15;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_unregisterSmartBluetoothEvent = 11;

        public static class Proxy implements ICaeUserAware {
            public static ICaeUserAware sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addBssidsToAvoidRomingScan(List<String> r5) {
                List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addBssidsToAvoidRomingScan(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addHomeWifiBssids(List<String> r5) {
                List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStringList(r6);     // Catch: Throwable -> L13
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addHomeWifiBssids(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void clearHomeWifiBssids() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearHomeWifiBssids();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public HarMonitorParams getHarMonitorParams() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                HarMonitorParams r4 = (HarMonitorParams) ZeusTransformUtils.preCheckCast(HarMonitorParams.CREATOR.createFromParcel(r1), HarMonitorParams.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                HarMonitorParams r5 = Stub.getDefaultImpl().getHarMonitorParams();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r5;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyGeofenceChanged(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyGeofenceChanged(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyHarEvent(HarEventData r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(14, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyHarEvent(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyLearningSuccess(boolean r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L13
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyLearningSuccess(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyRoomChangedPredicted(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyRoomChangedPredicted(r5);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerCallback(ICaeUserAwareCallback r5) {
                ICaeUserAwareCallback r6 = (ICaeUserAwareCallback) ZeusTransformUtils.wrapperContextForParams(r5, ICaeUserAwareCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r5) {
                ISmartBluetoothEventCallback r6 = (ISmartBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r5, ISmartBluetoothEventCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSmartBluetoothEvent(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarMonitorParams(HarMonitorParams r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setHarMonitorParams(r5);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarState(int r5, long r6, int r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r5);     // Catch: Throwable -> L13
                r0.writeLong(r6);     // Catch: Throwable -> L13
                r0.writeInt(r8);     // Catch: Throwable -> L13
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHarState(r5, r6, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setLevel2DataCollection(List<HarLevel2DataReq> r5, int r6, HarLevel2DataResp r7) {
                List<HarLevel2DataReq> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                HarLevel2DataResp r9 = (HarLevel2DataResp) ZeusTransformUtils.wrapperContextForParams(r7, HarLevel2DataResp.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeTypedList(r8);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r9 == null) goto L6;
                IBinder r2 = r9.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setLevel2DataCollection(r8, r6, r9);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setWifiRssiTriggerThresholds(int r9, int r10, int r11, int r12, int r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r9);     // Catch: Throwable -> L13
                r0.writeInt(r10);     // Catch: Throwable -> L13
                r0.writeInt(r11);     // Catch: Throwable -> L13
                r0.writeInt(r12);     // Catch: Throwable -> L13
                r0.writeInt(r13);     // Catch: Throwable -> L13
                if (this.mRemote.transact(15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setWifiRssiTriggerThresholds(r9, r10, r11, r12, r13);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterCallback(ICaeUserAwareCallback r5) {
                ICaeUserAwareCallback r6 = (ICaeUserAwareCallback) ZeusTransformUtils.wrapperContextForParams(r5, ICaeUserAwareCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r5) {
                ISmartBluetoothEventCallback r6 = (ISmartBluetoothEventCallback) ZeusTransformUtils.wrapperContextForParams(r5, ISmartBluetoothEventCallback.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterSmartBluetoothEvent(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeUserAware asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ICaeUserAware.class) == false) goto L13;
            return (ICaeUserAware) ZeusTransformUtils.preCheckCast(r0, ICaeUserAware.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ICaeUserAware getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeUserAware r2) {
            ICaeUserAware r3 = (ICaeUserAware) ZeusTransformUtils.wrapperContextForParams(r2, ICaeUserAware.class, "com.obric.aiagent.plugin");
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
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L52;
            boolean r2 = false;
            HarMonitorParams r4 = null;
            HarEventData r5 = null;
            switch(r10) {
                case 1: goto L50;
                case 2: goto L48;
                case 3: goto L46;
                case 4: goto L44;
                case 5: goto L42;
                case 6: goto L40;
                case 7: goto L38;
                case 8: goto L36;
                case 9: goto L34;
                case 10: goto L32;
                case 11: goto L30;
                case 12: goto L25;
                case 13: goto L20;
                case 14: goto L15;
                case 15: goto L13;
                case 16: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L11;
            r2 = true;
        L11:
            notifyLearningSuccess(r2);
            r12.writeNoException();
            return true;
        L13:
            r11.enforceInterface(DESCRIPTOR);
            setWifiRssiTriggerThresholds(r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt(), r11.readInt());
            r12.writeNoException();
            return true;
        L15:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L18;
            r5 = (HarEventData) ZeusTransformUtils.preCheckCast(HarEventData.CREATOR.createFromParcel(r11), HarEventData.class, "com.obric.aiagent.plugin");
        L18:
            notifyHarEvent(r5);
            r12.writeNoException();
            return true;
        L20:
            r11.enforceInterface(DESCRIPTOR);
            HarMonitorParams r9 = getHarMonitorParams();
            r12.writeNoException();
            if (r9 == null) goto L23;
            r12.writeInt(1);
            r9.writeToParcel(r12, 1);
        L24:
            return true;
        L23:
            r12.writeInt(0);
            goto L24
        L25:
            r11.enforceInterface(DESCRIPTOR);
            if (r11.readInt() == 0) goto L28;
            r4 = (HarMonitorParams) ZeusTransformUtils.preCheckCast(HarMonitorParams.CREATOR.createFromParcel(r11), HarMonitorParams.class, "com.obric.aiagent.plugin");
        L28:
            setHarMonitorParams(r4);
            r12.writeNoException();
            return true;
        L30:
            r11.enforceInterface(DESCRIPTOR);
            unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L32:
            r11.enforceInterface(DESCRIPTOR);
            registerSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L34:
            r11.enforceInterface(DESCRIPTOR);
            setLevel2DataCollection(r11.createTypedArrayList(HarLevel2DataReq.CREATOR), r11.readInt(), HarLevel2DataResp.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L36:
            r11.enforceInterface(DESCRIPTOR);
            setHarState(r11.readInt(), r11.readLong(), r11.readInt());
            r12.writeNoException();
            return true;
        L38:
            r11.enforceInterface(DESCRIPTOR);
            addBssidsToAvoidRomingScan(r11.createStringArrayList());
            r12.writeNoException();
            return true;
        L40:
            r11.enforceInterface(DESCRIPTOR);
            notifyGeofenceChanged(r11.readInt());
            r12.writeNoException();
            return true;
        L42:
            r11.enforceInterface(DESCRIPTOR);
            notifyRoomChangedPredicted(r11.readInt());
            r12.writeNoException();
            return true;
        L44:
            r11.enforceInterface(DESCRIPTOR);
            clearHomeWifiBssids();
            r12.writeNoException();
            return true;
        L46:
            r11.enforceInterface(DESCRIPTOR);
            addHomeWifiBssids(r11.createStringArrayList());
            r12.writeNoException();
            return true;
        L48:
            r11.enforceInterface(DESCRIPTOR);
            unregisterCallback(ICaeUserAwareCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L50:
            r11.enforceInterface(DESCRIPTOR);
            registerCallback(ICaeUserAwareCallback.Stub.asInterface(r11.readStrongBinder()));
            r12.writeNoException();
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L52:
            r12.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addBssidsToAvoidRomingScan(List<String> r1);

    void addHomeWifiBssids(List<String> r1);

    void clearHomeWifiBssids();

    HarMonitorParams getHarMonitorParams();

    void notifyGeofenceChanged(int r1);

    void notifyHarEvent(HarEventData r1);

    void notifyLearningSuccess(boolean r1);

    void notifyRoomChangedPredicted(int r1);

    void registerCallback(ICaeUserAwareCallback r1);

    void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r1);

    void setHarMonitorParams(HarMonitorParams r1);

    void setHarState(int r1, long r2, int r4);

    void setLevel2DataCollection(List<HarLevel2DataReq> r1, int r2, HarLevel2DataResp r3);

    void setWifiRssiTriggerThresholds(int r1, int r2, int r3, int r4, int r5);

    void unregisterCallback(ICaeUserAwareCallback r1);

    void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r1);
}
