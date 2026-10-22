package com.android.server;

import android.content.Context;
import android.content.Intent;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorAdditionalInfo;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Slog;
import com.android.server.location.LocationLogsRecorder;

/* JADX INFO: loaded from: classes.dex */
public class SensorNotificationService extends SystemService implements SensorEventListener, LocationListener {
    private static final String ATTRIBUTION_TAG = "SensorNotificationService";
    private static final boolean DBG = false;
    private static final long KM_IN_M = 1000;
    private static final long LOCATION_MIN_DISTANCE = 100000;
    private static final long LOCATION_MIN_TIME = 1800000;
    private static final long MILLIS_2010_1_1 = 1262358000000L;
    private static final long MINUTE_IN_MS = 60000;
    private static final String PROPERTY_USE_MOCKED_LOCATION = "sensor.notification.use_mocked";
    private static final String TAG = "SensorNotificationService";
    private Context mContext;
    private long mLocalGeomagneticFieldUpdateTime;
    private LocationManager mLocationManager;
    private Sensor mMetaSensor;
    private SensorManager mSensorManager;

    public SensorNotificationService(Context context) {
        super(context.createAttributionContext("SensorNotificationService"));
        this.mLocalGeomagneticFieldUpdateTime = -1800000;
        this.mContext = getContext();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        LocalServices.addService(SensorNotificationService.class, this);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 600) goto L9;
        this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mMetaSensor = this.mSensorManager.getDefaultSensor(32);
        if (this.mMetaSensor == null) goto L9;
        this.mSensorManager.registerListener(this, this.mMetaSensor, 0);
    L9:
        if (phase != 1000) goto L15;
        this.mLocationManager = (LocationManager) this.mContext.getSystemService(LocationLogsRecorder.KEY_FILE_LOCATION);
        if (this.mLocationManager == null) goto L16;
        this.mLocationManager.requestLocationUpdates("passive", 1800000, 100000.0f, this);
        return;
    L16:
        return;
    }

    private void broadcastDynamicSensorChanged() {
        Intent i = new Intent("android.intent.action.DYNAMIC_SENSOR_CHANGED");
        i.setFlags(1073741824);
        this.mContext.sendBroadcastAsUser(i, UserHandle.ALL);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor != this.mMetaSensor) goto L6;
        broadcastDynamicSensorChanged();
        return;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location.getLatitude() != 0.0d) goto L8;
        if (location.getLongitude() != 0.0d) goto L8;
        return;
    L8:
        if ((SystemClock.elapsedRealtime() - this.mLocalGeomagneticFieldUpdateTime) >= 600000) goto L10;
        return;
    L10:
        long time = System.currentTimeMillis();
        if (useMockedLocation() != location.isMock()) goto L13;
        return;
    L13:
        if (time < MILLIS_2010_1_1) goto L30;
        GeomagneticField field = new GeomagneticField((float) location.getLatitude(), (float) location.getLongitude(), (float) location.getAltitude(), time);
        SensorAdditionalInfo info = SensorAdditionalInfo.createLocalGeomagneticField(field.getFieldStrength() / 1000.0f, (float) ((((double) field.getDeclination()) * 3.141592653589793d) / 180.0d), (float) ((((double) field.getInclination()) * 3.141592653589793d) / 180.0d));     // Catch: IllegalArgumentException -> L20
        if (info == null) goto L28;
        this.mSensorManager.setOperationParameter(info);     // Catch: IllegalArgumentException -> L20
        this.mLocalGeomagneticFieldUpdateTime = SystemClock.elapsedRealtime();     // Catch: IllegalArgumentException -> L20
        return;
    L28:
        return;
    L23:
        Slog.e("SensorNotificationService", "Invalid local geomagnetic field, ignore.");
        return;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String provider) {
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String provider) {
    }

    private boolean useMockedLocation() {
        return "false".equals(System.getProperty(PROPERTY_USE_MOCKED_LOCATION, "false"));
    }
}
