package com.stepos.alphame.location;

import android.content.Context;
import com.stepos.alphame.utils.AlphaMeLogger;

/* loaded from: classes.dex */
public class MapLocationClient {
    private static final String TAG = "MapLocationClient";
    private MapLocation lastKnownLocation;

    public MapLocationClient(Context context) {
    }

    public static void initPrivacyAndSdk(Context context) {
        AlphaMeLogger.dLog("MapLocationClient skip Baidu SDK init");
    }

    public MapLocation getLastKnownLocation() {
        return this.lastKnownLocation;
    }

    public void setBatterySavingMode() {
    }

    public void setHighAccuracyMode() {
    }

    public void setHttpTimeOut(long j4) {
    }

    public void setLocationCacheEnable(boolean z4) {
    }

    public void setLocationListener(MapLocationListener mapLocationListener) {
    }

    public void startLocation() {
    }

    public void stopLocation() {
    }

    public void unRegisterLocationListener(MapLocationListener mapLocationListener) {
    }
}
