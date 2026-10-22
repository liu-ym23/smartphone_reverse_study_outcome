package com.byted.mgl.merge.service.api.privacy.location;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;

/* JADX INFO: loaded from: classes43.dex */
public interface IPrivacyLocation {
    void requestLocationUpdates(LocationManager r100, String r101, long r102, float r103, LocationListener r104, Looper r105, String r106) throws IllegalAccessException;
}
