package com.stepos.alphame.bluetooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataSource;
import com.stepos.alphame.awareness.TimetableTracker;
import com.stepos.alphame.bluetooth.BluetoothDeviceFilter;
import com.stepos.alphame.location.FrequentLocation;
import com.stepos.alphame.location.FrequentLocationManager;
import com.stepos.alphame.location.LocationEngine;
import com.stepos.alphame.movingstate.MovingStateEngine;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.predict.PredictManager;
import com.stepos.alphame.scene.QuickAppHelper;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.wifi.WifiEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class VehicleBluetoothManager {
    public static final long FAIL_RETRY_TIMEOUT = 300000;
    public static final long FAIL_START_TIMEOUT = 1800000;
    public static final long HOUR = 3600000;
    public static final int MAX_BLUE_POINT = 80;
    public static final float MAX_CONNECT_SPEED = 50.0f;
    public static final int MAX_CONNECT_STEP = 100;
    public static final float MAX_CONNECT_STEP_RATE = 0.2f;
    public static final float MAX_PLAY_TIME = 0.3f;
    public static final long MINUTE = 60000;
    public static final int MIN_BLUE_POINT = -50;
    public static final long MIN_CONNECT_DISTANCE = 3000;
    public static final float MIN_CONNECT_SPEED = 5.5f;
    public static final long MIN_CONNECT_TIME = 600000;
    public static final long PARKING_LOCATION_TIMEOUT = 600000;
    public static final long SECOND = 1000;

    @SuppressLint({"StaticFieldLeak"})
    private static VehicleBluetoothManager sInstance;
    private final Context mContext;
    private long mLastLocationTime;
    private final WifiManager mWifiManager;
    List<BluetoothRecord> mVehicleBluetoothes = new ArrayList();
    private BluetoothRecord mTempRecord = null;
    private int VEHICLE_MIN_POSSIBLITY = 50;
    private HashMap<String, Boolean> mDeviceMatched = new HashMap<>();
    private String mCurrApp = null;
    private boolean mWifiScanEnabled = false;
    private BluetoothDeviceFilter.Filter mProfileFilter = BluetoothDeviceFilter.getFilter(1);

    private VehicleBluetoothManager(Context context) {
        this.mContext = context;
        this.mWifiManager = (WifiManager) context.getSystemService(AppSuggestStorable.COLUMN_WIFI);
    }

    private void checkFailed(BluetoothRecord bluetoothRecord) {
        if (bluetoothRecord.getParkingTime() == 0) {
            if (BlueToothEngine.getInstance(this.mContext).getConnectedDevices().contains(bluetoothRecord.getAddress())) {
                return;
            }
            bluetoothRecord.setFailed();
        } else if (System.currentTimeMillis() - bluetoothRecord.getParkingTime() > FAIL_RETRY_TIMEOUT) {
            bluetoothRecord.setFailed();
        }
    }

    public static VehicleBluetoothManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new VehicleBluetoothManager(context);
        }
        return sInstance;
    }

    private void minus(BluetoothRecord bluetoothRecord, String str) {
        int possibility = bluetoothRecord.getPossibility();
        if (possibility == 80 || possibility == -50) {
            bluetoothRecord.addUpdateRecord("minus canceled " + str + ", " + bluetoothRecord);
            return;
        }
        bluetoothRecord.setPossibility(Math.max(-50, possibility - 5));
        bluetoothRecord.addUpdateRecord("-5, " + str + ", " + bluetoothRecord);
    }

    private void plus(BluetoothRecord bluetoothRecord, String str) {
        int possibility = bluetoothRecord.getPossibility();
        if (possibility == 80 || possibility == -50) {
            bluetoothRecord.addUpdateRecord("plus canceled " + str + ", " + bluetoothRecord);
            return;
        }
        bluetoothRecord.setPossibility(Math.min(80, possibility + 5));
        bluetoothRecord.addUpdateRecord("+5, " + str + ", " + bluetoothRecord);
    }

    private void startLocation() {
        prepareWifiScan();
        LocationEngine.getInstance(this.mContext).startLocation(2);
    }

    private void updatePossibility(BluetoothRecord bluetoothRecord, long j4) {
        BluetoothRecord bluetoothRecord2 = get(bluetoothRecord.getName(), bluetoothRecord.getAddress());
        if (bluetoothRecord2 == null) {
            this.mVehicleBluetoothes.add(bluetoothRecord);
        } else {
            bluetoothRecord.addUpdateRecords(bluetoothRecord2);
            bluetoothRecord.setPossibility(bluetoothRecord2.getPossibility());
            this.mVehicleBluetoothes.remove(bluetoothRecord2);
            this.mVehicleBluetoothes.add(bluetoothRecord);
        }
        if (j4 - bluetoothRecord.getParkingTime() > 600000) {
            bluetoothRecord.setFailed();
            return;
        }
        if (bluetoothRecord.getParkingTime() - bluetoothRecord.getStartTime() < 600000) {
            return;
        }
        long parkingTime = (bluetoothRecord.getParkingTime() - bluetoothRecord.getStartTime()) / 1000;
        if (bluetoothRecord.getParkingLocation() == null || bluetoothRecord.getStartLocation() == null) {
            if (bluetoothRecord.getParkingLocation() == null) {
                bluetoothRecord.setFailed();
                return;
            }
            return;
        }
        long playTime = bluetoothRecord.getPlayTime() / 1000;
        float f4 = parkingTime;
        if (playTime / f4 > 0.3f) {
            StringBuilder sbE = AbstractC0831a.e("play too much ", playTime, "/");
            sbE.append(parkingTime);
            minus(bluetoothRecord, sbE.toString());
            return;
        }
        double dDistanceOfTwoPoints = FrequentLocationManager.distanceOfTwoPoints(bluetoothRecord.getStartLocation(), bluetoothRecord.getParkingLocation());
        if (dDistanceOfTwoPoints < 3000.0d) {
            minus(bluetoothRecord, "same location " + dDistanceOfTwoPoints);
        } else {
            plus(bluetoothRecord, "diff location  " + dDistanceOfTwoPoints);
        }
        float f5 = ((float) dDistanceOfTwoPoints) / f4;
        if (f5 <= 5.5f || f5 >= 50.0f) {
            minus(bluetoothRecord, "invalid speed " + f5);
        } else {
            plus(bluetoothRecord, "nice speed " + f5);
        }
        if (bluetoothRecord.getStartStepCount() < 0 || bluetoothRecord.getParkingStepCount() < 0) {
            return;
        }
        int parkingStepCount = bluetoothRecord.getParkingStepCount() - bluetoothRecord.getStartStepCount();
        float f6 = parkingStepCount / f4;
        if (parkingStepCount > 100) {
            minus(bluetoothRecord, AbstractC0351g.m("high step ", parkingStepCount));
        } else {
            plus(bluetoothRecord, AbstractC0351g.m("low step ", parkingStepCount));
        }
        if (f6 > 0.2f) {
            minus(bluetoothRecord, "high stepRate " + f6);
        } else {
            plus(bluetoothRecord, "low  stepRate " + f6);
        }
    }

    public void clear() {
        this.mVehicleBluetoothes.clear();
        this.mTempRecord = null;
    }

    public BluetoothRecord get(String str, String str2) {
        BluetoothRecord byAddress = getByAddress(str2);
        return byAddress == null ? getByName(str) : byAddress;
    }

    public List<String> getAll() {
        ArrayList arrayList = new ArrayList();
        Iterator<BluetoothRecord> it = this.mVehicleBluetoothes.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        return arrayList;
    }

    public List<String> getAllDetail() {
        ArrayList arrayList = new ArrayList();
        Iterator<BluetoothRecord> it = this.mVehicleBluetoothes.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toDetailString());
        }
        return arrayList;
    }

    @NonNull
    public List<BluetoothRecord> getAllVehicle() {
        ArrayList arrayList = new ArrayList();
        for (BluetoothRecord bluetoothRecord : this.mVehicleBluetoothes) {
            if (bluetoothRecord.getPossibility() >= this.VEHICLE_MIN_POSSIBLITY) {
                arrayList.add(bluetoothRecord);
            }
        }
        return arrayList;
    }

    public BluetoothRecord getByAddress(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (BluetoothRecord bluetoothRecord : this.mVehicleBluetoothes) {
            if (!TextUtils.isEmpty(bluetoothRecord.getAddress()) && bluetoothRecord.getAddress().equals(str)) {
                return bluetoothRecord;
            }
        }
        BluetoothRecord bluetoothRecord2 = this.mTempRecord;
        if (bluetoothRecord2 == null || !TextUtils.equals(bluetoothRecord2.getAddress(), str)) {
            return null;
        }
        return this.mTempRecord;
    }

    public BluetoothRecord getByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (BluetoothRecord bluetoothRecord : this.mVehicleBluetoothes) {
            if (!TextUtils.isEmpty(bluetoothRecord.getName()) && bluetoothRecord.getName().equals(str)) {
                return bluetoothRecord;
            }
        }
        return null;
    }

    public BluetoothRecord getLastChosenVehicle(String str) {
        BluetoothRecord bluetoothRecord;
        BluetoothRecord bluetoothRecord2 = this.mTempRecord;
        if (bluetoothRecord2 == null || !TextUtils.equals(str, bluetoothRecord2.getAddress())) {
            bluetoothRecord = null;
        } else {
            checkFailed(this.mTempRecord);
            bluetoothRecord = this.mTempRecord;
        }
        return bluetoothRecord == null ? getByAddress(str) : bluetoothRecord;
    }

    public BluetoothRecord getLastVehicle() {
        BluetoothRecord bluetoothRecord;
        BluetoothRecord bluetoothRecord2 = this.mTempRecord;
        if (bluetoothRecord2 == null || get(bluetoothRecord2.getName(), this.mTempRecord.getAddress()).getPossibility() < this.VEHICLE_MIN_POSSIBLITY) {
            bluetoothRecord = null;
        } else {
            checkFailed(this.mTempRecord);
            bluetoothRecord = this.mTempRecord;
        }
        if (bluetoothRecord == null) {
            for (BluetoothRecord bluetoothRecord3 : this.mVehicleBluetoothes) {
                if (bluetoothRecord3.getPossibility() >= this.VEHICLE_MIN_POSSIBLITY && (bluetoothRecord == null || bluetoothRecord3.getStartTime() > bluetoothRecord.getStartTime())) {
                    bluetoothRecord = bluetoothRecord3;
                }
            }
        }
        return bluetoothRecord;
    }

    public boolean isVehicle(BluetoothDevice bluetoothDevice) {
        BluetoothRecord bluetoothRecord = get(bluetoothDevice.getName(), bluetoothDevice.getAddress());
        if (bluetoothRecord == null) {
            return false;
        }
        Boolean boolValueOf = this.mDeviceMatched.get(bluetoothDevice.getAddress());
        if (boolValueOf == null) {
            if (bluetoothDevice.getUuids() == null && bluetoothDevice.getBluetoothClass() == null) {
                boolValueOf = Boolean.TRUE;
            } else {
                boolValueOf = Boolean.valueOf(this.mProfileFilter.matches(bluetoothDevice));
                this.mDeviceMatched.put(bluetoothDevice.getAddress(), boolValueOf);
            }
        }
        return boolValueOf.booleanValue() && bluetoothRecord.getPossibility() >= this.VEHICLE_MIN_POSSIBLITY;
    }

    public void locationFailed(boolean z4, long j4) {
        BluetoothRecord bluetoothRecord = this.mTempRecord;
        if (bluetoothRecord == null || bluetoothRecord.getParkingTime() == 0) {
            return;
        }
        if (j4 - this.mTempRecord.getParkingTime() <= FAIL_RETRY_TIMEOUT) {
            if (z4) {
                startLocation();
            }
        } else {
            if (z4) {
                onLocationEnd();
            }
            updatePossibility(this.mTempRecord, j4);
            this.mTempRecord = null;
        }
    }

    public void onLocationChanged(int i4, String str, String str2, long j4, boolean z4) {
        this.mLastLocationTime = j4;
        if (z4) {
            onLocationEnd();
        }
        BluetoothRecord bluetoothRecord = this.mTempRecord;
        if (bluetoothRecord == null || bluetoothRecord.getParkingTime() <= 0 || str == null) {
            return;
        }
        this.mTempRecord.setParkingAddress(str2);
        this.mTempRecord.setParkingLocation(str);
        updatePossibility(this.mTempRecord, j4);
        this.mTempRecord = null;
    }

    public void onLocationEnd() {
        restoreScanInterface();
    }

    public void onStepCountChange(int i4) {
        BluetoothRecord bluetoothRecord = this.mTempRecord;
        if (bluetoothRecord == null) {
            return;
        }
        if (bluetoothRecord.getParkingTime() > 0) {
            this.mTempRecord.setParkingStepCount(i4);
        } else {
            this.mTempRecord.setStartStepCount(i4);
        }
    }

    public void prepareWifiScan() {
        AlphaMeLogger.dLog("prepareWifiScan mWifiScanEnabled = " + this.mWifiScanEnabled);
        if (this.mWifiScanEnabled || WifiEngine.wifiChannelInUsed(this.mContext)) {
            return;
        }
        PerfBinderHelper.disableWifiScanInterface(false);
        this.mWifiScanEnabled = true;
    }

    public void restoreScanInterface() {
        AlphaMeLogger.dLog("restoreScanInterface mWifiScanEnabled = " + this.mWifiScanEnabled);
        if (!this.mWifiScanEnabled || WifiEngine.wifiChannelInUsed(this.mContext)) {
            return;
        }
        this.mWifiScanEnabled = false;
        if (System.currentTimeMillis() - TimetableTracker.getInstance().getScreenOffTime() < 180000) {
            PerfBinderHelper.disableWifiScanInterface(true);
        }
    }

    public void trackAppEvent(String str, long j4) {
        if (TextUtils.isEmpty(str) || QuickAppHelper.isQuickApp(str) || PredictManager.isPayment(str)) {
            return;
        }
        this.mCurrApp = str;
        BluetoothRecord bluetoothRecord = this.mTempRecord;
        if (bluetoothRecord != null) {
            bluetoothRecord.addAppRecord(str, j4);
        }
    }

    public void trackBluetoothEvent(int i4, String str, String str2, long j4, boolean z4) {
        if (str2 == null && str == null) {
            return;
        }
        if (i4 == 1) {
            BluetoothRecord bluetoothRecord = new BluetoothRecord();
            this.mTempRecord = bluetoothRecord;
            bluetoothRecord.setName(str);
            this.mTempRecord.setAddress(str2);
            this.mTempRecord.setStartTime(j4);
            FrequentLocation lastAvailableLocation = FrequentLocationManager.getInstance(this.mContext).getLastAvailableLocation();
            if (lastAvailableLocation != null && j4 - this.mLastLocationTime < FAIL_START_TIMEOUT) {
                this.mTempRecord.setStartLocation(lastAvailableLocation.getLongitude() + "," + lastAvailableLocation.getLatitude());
                this.mTempRecord.setStartAddress(lastAvailableLocation.getAddress());
            }
            this.mTempRecord.addAppRecord(this.mCurrApp, j4);
        } else {
            BluetoothRecord bluetoothRecord2 = this.mTempRecord;
            if (bluetoothRecord2 != null && bluetoothRecord2.getStartTime() > 0) {
                this.mTempRecord.setParkingTime(j4);
            }
        }
        if (z4) {
            if (i4 == 0) {
                startLocation();
            }
            int currStepCount = MovingStateEngine.getInstance(this.mContext).getCurrStepCount();
            AwarenessDataSource.getInstance().newStepRecord(currStepCount);
            onStepCountChange(currStepCount);
        }
    }
}
