package com.android.server.location;

import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.obric.cae.libs.location.IStarLocationService;

/* JADX INFO: loaded from: classes2.dex */
public class CaeLocationManager {
    private static final String EXTRA_ZPP_CONFIDENCE = "zpp_confidence";
    private static final int GET_SERVER_INTERVAL_MS = 1000;
    private static final int GET_SERVER_MAX_RETRY = 500;
    private static final String PACKAGE_NAME_AUTONAVI_MINIMAP = "com.autonavi.minimap";
    private static final String SERVICE_NAME_STAR_LOCATION = "cae_star_location";
    private static final String TAG = null;
    private static final String ZPP_CONFIDENCE_HIGH = "high";
    private static final String ZPP_CONFIDENCE_MEDIUM = "medium";
    private static CaeLocationManager sInstance;
    private IStarLocationService mStarLocationService;

    /* JADX INFO: renamed from: -$$Nest$fgetmStarLocationService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IStarLocationService m5112$$Nest$fgetmStarLocationService(CaeLocationManager r0) {
        return r0.mStarLocationService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStarLocationService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5113$$Nest$fputmStarLocationService(CaeLocationManager r0, IStarLocationService r1) {
        r0.mStarLocationService = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mretryGetServiceThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5114$$Nest$mretryGetServiceThread(CaeLocationManager r0) {
        r0.retryGetServiceThread();
    }

    /* JADX INFO: renamed from: -$$Nest$msetBinderDeath, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5115$$Nest$msetBinderDeath(CaeLocationManager r0) {
        r0.setBinderDeath();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5116$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = CaeLocationManager.class.getSimpleName();
    }

    public static synchronized CaeLocationManager getInstance() {
        monitor-enter(CaeLocationManager.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new CaeLocationManager();     // Catch: Throwable -> L7
    L9:
        CaeLocationManager r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(CaeLocationManager.class);
        return r1;
    }

    private CaeLocationManager() {
    }

    public void init() {
        retryGetServiceThread();
    }

    public boolean isServiceConnected() {
        if (this.mStarLocationService == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean checkPackageEnabled(String pkgName) {
        return !PACKAGE_NAME_AUTONAVI_MINIMAP.equals(pkgName);
    }

    private void retryGetServiceThread() {
        new AnonymousClass1(this).start();
    }

    private void setBinderDeath() {
        this.mStarLocationService.asBinder().linkToDeath(new AnonymousClass2(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        StarLocation.getInstance().loge(TAG, "mStarLocationService linkToDeath! :" + e);
    }

    public Location getLastKnownLocationFromZpp(int userId, String provider) {
        if (provider != null) goto L5;
    L22:
        return null;
    L5:
        if (provider.isEmpty() == true) goto L22;
        if (this.mStarLocationService == null) goto L22;
        Location location = this.mStarLocationService.getLastKnownLocationFromZpp(userId, provider);     // Catch: Exception -> L16
        if (location == null) goto L18;
        if (location.isComplete() == false) goto L18;
        return processZppConfidence(location);
    L18:
        StarLocation.getInstance().logd(TAG, "getLastKnownLocationFromZpp invalid location: " + location);     // Catch: Exception -> L16
        return null;
    L16:
        e = move-exception;
        StarLocation.getInstance().loge(TAG, "getLastKnownLocationFromZpp error: " + e);
        return null;
    }

    private Location processZppConfidence(Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) goto L6;
        StarLocation.getInstance().logd(TAG, "getLastKnownLocationFromZpp missing extras");
        return null;
    L6:
        String confidence = extras.getString(EXTRA_ZPP_CONFIDENCE);
        if (ZPP_CONFIDENCE_HIGH.equalsIgnoreCase(confidence) == false) goto L9;
    L13:
        StarLocation.getInstance().logd(TAG, "getLastKnownLocationFromZpp accepted confidence: " + confidence);
        return new Location(location);
    L9:
        if (ZPP_CONFIDENCE_MEDIUM.equalsIgnoreCase(confidence) == true) goto L13;
        StarLocation.getInstance().logd(TAG, "getLastKnownLocationFromZpp rejected confidence: " + confidence);
        return null;
    }
}
