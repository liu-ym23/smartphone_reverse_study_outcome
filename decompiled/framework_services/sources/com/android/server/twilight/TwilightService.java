package com.android.server.twilight;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.icu.util.Calendar;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.server.SystemService;
import com.android.server.am.HostingRecord;
import com.android.server.location.LocationLogsRecorder;
import com.ibm.icu.impl.CalendarAstronomer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class TwilightService extends SystemService implements AlarmManager.OnAlarmListener, Handler.Callback, LocationListener {
    private static final String ATTRIBUTION_TAG = "TwilightService";
    private static final boolean DEBUG = false;
    private static final int MSG_START_LISTENING = 1;
    private static final int MSG_STOP_LISTENING = 2;
    private static final String TAG = "TwilightService";
    protected AlarmManager mAlarmManager;
    private boolean mBootCompleted;
    private final Handler mHandler;
    private boolean mHasListeners;
    protected Location mLastLocation;
    protected TwilightState mLastTwilightState;
    private final ArrayMap<TwilightListener, Handler> mListeners;
    private LocationManager mLocationManager;
    private BroadcastReceiver mTimeChangedReceiver;

    public static /* synthetic */ void $r8$lambda$LGxa95zghnRqvHglJe8_uupAa40(TwilightListener r0, TwilightState r1) {
        lambda$updateTwilightState$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9033$$Nest$fgetmHandler(TwilightService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m9034$$Nest$fgetmListeners(TwilightService r0) {
        return r0.mListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTwilightState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9035$$Nest$mupdateTwilightState(TwilightService r0) {
        r0.updateTwilightState();
    }

    public TwilightService(Context context) {
        super(context.createAttributionContext("TwilightService"));
        this.mListeners = new ArrayMap();
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishLocalService(TwilightManager.class, new AnonymousClass1(this));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 1000) goto L8;
        Context c = getContext();
        this.mAlarmManager = (AlarmManager) c.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        this.mLocationManager = (LocationManager) c.getSystemService(LocationLogsRecorder.KEY_FILE_LOCATION);
        this.mBootCompleted = true;
        if (this.mHasListeners == false) goto L9;
        startListening();
        return;
    L9:
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L12;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        if (this.mHasListeners == false) goto L10;
        this.mHasListeners = false;
        if (this.mBootCompleted == false) goto L10;
        stopListening();
    L10:
        return true;
    L12:
        if (this.mHasListeners == true) goto L16;
        this.mHasListeners = true;
        if (this.mBootCompleted == false) goto L16;
        startListening();
    L16:
        return true;
    }

    private void startListening() {
        Slog.d("TwilightService", "startListening");
        this.mLocationManager.requestLocationUpdates("passive", 600000, 10.0f, this);
        if (this.mLocationManager.getLastLocation() != null) goto L11;
        if (this.mLocationManager.isProviderEnabled("network") == false) goto L8;
        this.mLocationManager.getCurrentLocation("network", null, getContext().getMainExecutor(), new TwilightService$$ExternalSyntheticLambda0(this));
        goto L11
    L8:
        if (this.mLocationManager.isProviderEnabled("gps") == false) goto L11;
        this.mLocationManager.getCurrentLocation("gps", null, getContext().getMainExecutor(), new TwilightService$$ExternalSyntheticLambda0(this));
    L11:
        if (this.mTimeChangedReceiver != null) goto L13;
        this.mTimeChangedReceiver = new AnonymousClass2(this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        getContext().registerReceiver(this.mTimeChangedReceiver, intentFilter);
    L13:
        updateTwilightState();
    }

    private void stopListening() {
        Slog.d("TwilightService", "stopListening");
        if (this.mTimeChangedReceiver == null) goto L6;
        getContext().unregisterReceiver(this.mTimeChangedReceiver);
        this.mTimeChangedReceiver = null;
    L6:
        if (this.mLastTwilightState == null) goto L8;
        this.mAlarmManager.cancel(this);
    L8:
        this.mLocationManager.removeUpdates(this);
        this.mLastLocation = null;
    }

    private void updateTwilightState() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mLastLocation == null) goto L5;
        Location r0 = this.mLastLocation;
    L6:
        Location location = r0;
        final TwilightState state = calculateTwilightState(location, currentTimeMillis);
        ArrayMap<TwilightListener, Handler> r5 = this.mListeners;
        monitor-enter(r5);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (Objects.equals(this.mLastTwilightState, state) == true) goto L15;
        this.mLastTwilightState = state;     // Catch: Throwable -> L13
        int i = this.mListeners.size() - 1;     // Catch: Throwable -> L13
    L11:
        if (i < 0) goto L15;
        final TwilightListener listener = this.mListeners.keyAt(i);     // Catch: Throwable -> L13
        Handler handler = this.mListeners.valueAt(i);     // Catch: Throwable -> L13
        handler.post(new TwilightService$$ExternalSyntheticLambda1(listener, state));     // Catch: Throwable -> L13
        i = i - 1;     // Catch: Throwable -> L13
    L15:
        monitor-exit(r5);     // Catch: Throwable -> L13
        if (state != null) goto L18;
        return;
    L18:
        if (state.isNight() == false) goto L20;
        long r6 = state.sunriseTimeMillis();
    L21:
        long triggerAtMillis = r6;
        this.mAlarmManager.setExact(1, triggerAtMillis, "TwilightService", this, this.mHandler);
        return;
    L20:
        r6 = state.sunsetTimeMillis();
        goto L21
    L5:
        r0 = this.mLocationManager.getLastLocation();
        goto L6
    }

    private static /* synthetic */ void lambda$updateTwilightState$0(TwilightListener listener, TwilightState state) {
        listener.onTwilightStateChanged(state);
    }

    @Override // android.app.AlarmManager.OnAlarmListener
    public void onAlarm() {
        Slog.d("TwilightService", "onAlarm");
        updateTwilightState();
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location == null) goto L5;
        Slog.d("TwilightService", "onLocationChanged: provider=" + location.getProvider() + " accuracy=" + location.getAccuracy() + " time=" + location.getTime());
        this.mLastLocation = location;
        updateTwilightState();
        return;
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

    private static TwilightState calculateTwilightState(Location location, long timeMillis) {
        if (location != null) goto L5;
        return null;
    L5:
        CalendarAstronomer ca = new CalendarAstronomer(location.getLongitude(), location.getLatitude());
        Calendar noon = Calendar.getInstance();
        noon.setTimeInMillis(timeMillis);
        noon.set(11, 12);
        noon.set(12, 0);
        noon.set(13, 0);
        noon.set(14, 0);
        ca.setTime(noon.getTimeInMillis());
        long sunriseTimeMillis = ca.getSunRiseSet(true);
        long sunsetTimeMillis = ca.getSunRiseSet(false);
        if (sunsetTimeMillis >= timeMillis) goto L9;
        noon.add(5, 1);
        ca.setTime(noon.getTimeInMillis());
        sunriseTimeMillis = ca.getSunRiseSet(true);
    L12:
        return new TwilightState(sunriseTimeMillis, sunsetTimeMillis);
    L9:
        if (sunriseTimeMillis <= timeMillis) goto L12;
        noon.add(5, -1);
        ca.setTime(noon.getTimeInMillis());
        sunsetTimeMillis = ca.getSunRiseSet(false);
        goto L12
    }
}
