package com.android.server.location.countrydetector;

import android.content.Context;
import android.location.Address;
import android.location.Country;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.util.Slog;
import com.android.server.location.LocationLogsRecorder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

/* JADX INFO: loaded from: classes2.dex */
public class LocationBasedCountryDetector extends CountryDetectorBase {
    private static final long QUERY_LOCATION_TIMEOUT = 300000;
    private static final String TAG = "LocationBasedCountryDetector";
    private List<String> mEnabledProviders;
    protected List<LocationListener> mLocationListeners;
    private LocationManager mLocationManager;
    protected Thread mQueryThread;
    protected Timer mTimer;

    /* JADX INFO: renamed from: -$$Nest$mqueryCountryCode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5216$$Nest$mqueryCountryCode(LocationBasedCountryDetector r0, Location r1) {
        r0.queryCountryCode(r1);
    }

    public LocationBasedCountryDetector(Context ctx) {
        super(ctx);
        this.mLocationManager = (LocationManager) ctx.getSystemService(LocationLogsRecorder.KEY_FILE_LOCATION);
    }

    protected String getCountryFromLocation(Location location) {
        Geocoder geoCoder = new Geocoder(this.mContext);
        List<Address> addresses = geoCoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);     // Catch: IOException -> L9
        if (addresses != null) goto L6;
        return null;
    L6:
        if (addresses.size() <= 0) goto L17;
        String country = addresses.get(0).getCountryCode();     // Catch: IOException -> L9
        return country;
    L17:
        return null;
    L12:
        Slog.w(TAG, "Exception occurs when getting country from location");
        return null;
    }

    protected boolean isAcceptableProvider(String provider) {
        return "passive".equals(provider);
    }

    protected void registerListener(String provider, LocationListener listener) {
        long bid = Binder.clearCallingIdentity();
        this.mLocationManager.requestLocationUpdates(provider, 0, 0.0f, listener);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(bid);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        Binder.restoreCallingIdentity(bid);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    protected void unregisterListener(LocationListener listener) {
        long bid = Binder.clearCallingIdentity();
        this.mLocationManager.removeUpdates(listener);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(bid);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(bid);
        throw th;
    }

    protected Location getLastKnownLocation() {
        long bid = Binder.clearCallingIdentity();
        List<String> providers = this.mLocationManager.getAllProviders();     // Catch: Throwable -> L13
        Location bestLocation = null;
        Iterator<String> r4 = providers.iterator();     // Catch: Throwable -> L13
    L5:
        if (r4.hasNext() == false) goto L17;
        String provider = r4.next();     // Catch: Throwable -> L13
        Location lastKnownLocation = this.mLocationManager.getLastKnownLocation(provider);     // Catch: Throwable -> L13
        if (lastKnownLocation == null) goto L5;
        if (bestLocation == null) goto L15;
        if (bestLocation.getElapsedRealtimeNanos() >= lastKnownLocation.getElapsedRealtimeNanos()) goto L5;
    L15:
        bestLocation = lastKnownLocation;
        goto L5
    L17:
        Binder.restoreCallingIdentity(bid);
        return bestLocation;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(bid);
        throw th;
    }

    protected long getQueryLocationTimeout() {
        return 300000;
    }

    protected List<String> getEnabledProviders() {
        if (this.mEnabledProviders != null) goto L6;
        this.mEnabledProviders = this.mLocationManager.getProviders(true);
    L6:
        return this.mEnabledProviders;
    }

    @Override // com.android.server.location.countrydetector.CountryDetectorBase
    public synchronized Country detectCountry() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocationListeners != null) goto L21;
        List<String> enabledProviders = getEnabledProviders();     // Catch: Throwable -> L12
        int totalProviders = enabledProviders.size();     // Catch: Throwable -> L12
        if (totalProviders <= 0) goto L16;
        this.mLocationListeners = new ArrayList(totalProviders);     // Catch: Throwable -> L12
        int i = 0;
    L8:
        if (i >= totalProviders) goto L15;
        String provider = enabledProviders.get(i);     // Catch: Throwable -> L12
        if (isAcceptableProvider(provider) == false) goto L14;
        LocationListener listener = new AnonymousClass1(this);     // Catch: Throwable -> L12
        this.mLocationListeners.add(listener);     // Catch: Throwable -> L12
        registerListener(provider, listener);     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L8
    L15:
        this.mTimer = new Timer();     // Catch: Throwable -> L12
        this.mTimer.schedule(new AnonymousClass2(this), getQueryLocationTimeout());     // Catch: Throwable -> L12
    L17:
        Country r2 = this.mDetectedCountry;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r2;
    L16:
        queryCountryCode(getLastKnownLocation());     // Catch: Throwable -> L12
        goto L17
    L21:
        throw new IllegalStateException();     // Catch: Throwable -> L12
    }

    @Override // com.android.server.location.countrydetector.CountryDetectorBase
    public synchronized void stop() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocationListeners == null) goto L13;
        Iterator<LocationListener> r0 = this.mLocationListeners.iterator();     // Catch: Throwable -> L9
    L7:
        if (r0.hasNext() == false) goto L11;
        LocationListener listener = r0.next();     // Catch: Throwable -> L9
        unregisterListener(listener);     // Catch: Throwable -> L9
        goto L7
    L11:
        this.mLocationListeners = null;     // Catch: Throwable -> L9
    L13:
        if (this.mTimer == null) goto L15;
        this.mTimer.cancel();     // Catch: Throwable -> L9
        this.mTimer = null;     // Catch: Throwable -> L9
    L15:
        monitor-exit(this);
    }

    private synchronized void queryCountryCode(final Location location) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mQueryThread == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mQueryThread = new Thread(new AnonymousClass3(this, location));     // Catch: Throwable -> L10
        this.mQueryThread.start();     // Catch: Throwable -> L10
        monitor-exit(this);
    }
}
