package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ICaeUserAware extends IInterface {
    public static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAware";
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
        public void addBssidsToAvoidRomingScan(List<String> r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addHomeWifiBssids(List<String> r1) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void clearHomeWifiBssids() throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public HarMonitorParams getHarMonitorParams() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyGeofenceChanged(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyHarEvent(HarEventData r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyLearningSuccess(boolean r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyRoomChangedPredicted(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerCallback(ICaeUserAwareCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarMonitorParams(HarMonitorParams r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarState(int r1, long r2, int r4) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setLevel2DataCollection(List<HarLevel2DataReq> r1, int r2, HarLevel2DataResp r3) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setWifiRssiTriggerThresholds(int r1, int r2, int r3, int r4, int r5) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterCallback(ICaeUserAwareCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAware {
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
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addBssidsToAvoidRomingScan(List<String> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStringList(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addHomeWifiBssids(List<String> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStringList(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
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
            public void clearHomeWifiBssids() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public HarMonitorParams getHarMonitorParams() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                Parcelable.Creator<HarMonitorParams> r2 = HarMonitorParams.CREATOR;     // Catch: Throwable -> L6
                if (r1.readInt() == 0) goto L8;
                HarMonitorParams r3 = r2.createFromParcel(r1);     // Catch: Throwable -> L6
            L9:
                HarMonitorParams r4 = r3;     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                r3 = null;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return ICaeUserAware.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyGeofenceChanged(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyHarEvent(HarEventData r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(14, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyLearningSuccess(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(16, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyRoomChangedPredicted(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerCallback(ICaeUserAwareCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarMonitorParams(HarMonitorParams r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.a(r0, r5, 0);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarState(int r4, long r5, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeLong(r5);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setLevel2DataCollection(List<HarLevel2DataReq> r4, int r5, HarLevel2DataResp r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeTypedList(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r6);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setWifiRssiTriggerThresholds(int r4, int r5, int r6, int r7, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeInt(r6);     // Catch: Throwable -> L6
                r0.writeInt(r7);     // Catch: Throwable -> L6
                r0.writeInt(r8);     // Catch: Throwable -> L6
                this.mRemote.transact(15, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterCallback(ICaeUserAwareCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(ICaeUserAware.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeStrongInterface(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, ICaeUserAware.DESCRIPTOR);
        }

        public static ICaeUserAware asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(ICaeUserAware.DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeUserAware) == false) goto L12;
            return (ICaeUserAware) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 < 1) goto L8;
            if (r9 > 16777215) goto L8;
            r10.enforceInterface(ICaeUserAware.DESCRIPTOR);
        L8:
            if (r9 == 1598968902) goto L33;
            switch(r9) {
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L21;
                case 12: goto L20;
                case 13: goto L19;
                case 14: goto L18;
                case 15: goto L17;
                case 16: goto L13;
                default: goto L11;
            };
        L17:
            setWifiRssiTriggerThresholds(r10.readInt(), r10.readInt(), r10.readInt(), r10.readInt(), r10.readInt());
            r11.writeNoException();
        L32:
            return true;
        L18:
            notifyHarEvent((HarEventData) _Parcel.a(r10, HarEventData.CREATOR));
            r11.writeNoException();
            goto L32
        L19:
            HarMonitorParams r13 = getHarMonitorParams();
            r11.writeNoException();
            _Parcel.a(r11, r13, 1);
            goto L32
        L20:
            setHarMonitorParams((HarMonitorParams) _Parcel.a(r10, HarMonitorParams.CREATOR));
            r11.writeNoException();
            goto L32
        L21:
            unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L32
        L22:
            registerSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L32
        L23:
            setLevel2DataCollection(r10.createTypedArrayList(HarLevel2DataReq.CREATOR), r10.readInt(), HarLevel2DataResp.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L32
        L24:
            setHarState(r10.readInt(), r10.readLong(), r10.readInt());
            r11.writeNoException();
            goto L32
        L25:
            addBssidsToAvoidRomingScan(r10.createStringArrayList());
            r11.writeNoException();
            goto L32
        L26:
            notifyGeofenceChanged(r10.readInt());
            r11.writeNoException();
            goto L32
        L27:
            notifyRoomChangedPredicted(r10.readInt());
            r11.writeNoException();
            goto L32
        L28:
            clearHomeWifiBssids();
            r11.writeNoException();
            goto L32
        L29:
            addHomeWifiBssids(r10.createStringArrayList());
            r11.writeNoException();
            goto L32
        L30:
            unregisterCallback(ICaeUserAwareCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L32
        L31:
            registerCallback(ICaeUserAwareCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            goto L32
        L11:
            return super.onTransact(r9, r10, r11, r12);
        L13:
            if (r10.readInt() == 0) goto L15;
            boolean r14 = true;
        L16:
            notifyLearningSuccess(r14);
            r11.writeNoException();
            goto L32
        L15:
            r14 = false;
            goto L16
        L33:
            r11.writeString(ICaeUserAware.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public _Parcel() {
        }

        public static Object a(Parcel r1, Parcelable.Creator r2) {
            if (r1.readInt() != 0) goto L7;
            return null;
        L7:
            return r2.createFromParcel(r1);
        }

        public static void a(Parcel r1, Parcelable r2, int r3) {
            if (r2 == null) goto L4;
            r1.writeInt(1);
            r2.writeToParcel(r1, r3);
            return;
        L4:
            r1.writeInt(0);
        }
    }

    void addBssidsToAvoidRomingScan(List<String> r1) throws RemoteException;

    void addHomeWifiBssids(List<String> r1) throws RemoteException;

    void clearHomeWifiBssids() throws RemoteException;

    HarMonitorParams getHarMonitorParams() throws RemoteException;

    void notifyGeofenceChanged(int r1) throws RemoteException;

    void notifyHarEvent(HarEventData r1) throws RemoteException;

    void notifyLearningSuccess(boolean r1) throws RemoteException;

    void notifyRoomChangedPredicted(int r1) throws RemoteException;

    void registerCallback(ICaeUserAwareCallback r1) throws RemoteException;

    void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r1) throws RemoteException;

    void setHarMonitorParams(HarMonitorParams r1) throws RemoteException;

    void setHarState(int r1, long r2, int r4) throws RemoteException;

    void setLevel2DataCollection(List<HarLevel2DataReq> r1, int r2, HarLevel2DataResp r3) throws RemoteException;

    void setWifiRssiTriggerThresholds(int r1, int r2, int r3, int r4, int r5) throws RemoteException;

    void unregisterCallback(ICaeUserAwareCallback r1) throws RemoteException;

    void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r1) throws RemoteException;
}
